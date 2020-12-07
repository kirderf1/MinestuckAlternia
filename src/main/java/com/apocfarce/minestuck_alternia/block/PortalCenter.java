package com.apocfarce.minestuck_alternia.block;

import com.apocfarce.minestuck_alternia.Item.AlterniaItems;
import com.apocfarce.minestuck_alternia.world.AlterniaDimensions;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.server.TicketType;

public class PortalCenter extends Portal{
	public static final BooleanProperty IsOpen = BooleanProperty.create("is_open");
	
	public PortalCenter(Properties properties) {
		super(properties);
	}
	
	@Override
	protected MutableBoundingBox getBaseBox(IWorld worldIn, BlockPos pos) {
		Portal blockDown = (Portal)worldIn.getBlockState(pos.down()).getBlock();
		return blockDown.getBaseBox(worldIn, pos.down());
	}


	@Override
	public BlockPos getMainCorner(IWorld worldIn, BlockPos pos,Direction playerFacing) {
		Portal blockDown = (Portal)worldIn.getBlockState(pos.down()).getBlock();
		return blockDown.getMainCorner(worldIn, pos.down(),playerFacing);
	}


	@Override
	public void destroyPart(World worldIn, BlockPos mainCorner, Direction facing, boolean isCreative) {
		if (!worldIn.isRemote&&!isCreative) {
			spawnDrops(this.getDefaultState(), worldIn, mainCorner.offset(facing,2).up(1).offset(facing.rotateY(),1));
		}
		worldIn.destroyBlock(mainCorner.offset(facing,2).up(1).offset(facing.rotateY(),1),false);
		worldIn.destroyBlock(mainCorner.offset(facing,2).up(1).offset(facing.rotateY(),2),false);
		worldIn.destroyBlock(mainCorner.offset(facing,2).up(2).offset(facing.rotateY(),2),false);
		worldIn.destroyBlock(mainCorner.offset(facing,2).up(2).offset(facing.rotateY(),1),false);
		
	}
	
	private BlockPos[] getPortalBlocks(BlockPos pos, IWorld worldIn) {
	
		boolean up =(worldIn.getBlockState(pos.up()).hasProperty(IsOpen));
		boolean north =(worldIn.getBlockState(pos.north()).hasProperty(IsOpen));
		boolean east =(worldIn.getBlockState(pos.east()).hasProperty(IsOpen));
		boolean west =(worldIn.getBlockState(pos.west()).hasProperty(IsOpen));
		
		if(east||west) {
			if(up) {
				if(east) {
					return new BlockPos[]{pos,pos.east(),pos.up(),pos.east().up()};
				}else {
					return new BlockPos[]{pos,pos.west(),pos.up(),pos.west().up()};
				}
			}else {
				if(east) {
					return new BlockPos[]{pos,pos.east(),pos.down(),pos.east().down()};
				}else {
					return new BlockPos[]{pos,pos.west(),pos.down(),pos.west().down()};
				}
			}
		}else {
			if(up) {
				if(north) {
					return new BlockPos[]{pos,pos.north(),pos.up(),pos.north().up()};
				}else {
					return new BlockPos[]{pos,pos.south(),pos.up(),pos.south().up()};
				}
			}else {
				if(north) {
					return new BlockPos[]{pos,pos.north(),pos.down(),pos.north().down()};
				}else {
					return new BlockPos[]{pos,pos.south(),pos.down(),pos.south().down()};
				}
			}
		}
	}
	
	public void closePortal(BlockPos pos, World worldIn) {
		BlockPos[] blocks = getPortalBlocks(pos,worldIn);
		for (BlockPos block : blocks) {
			worldIn.setBlockState(block, worldIn.getBlockState(block).with(IsOpen, false));
		}
	}
	
	public void openPortal(BlockPos pos, World worldIn) {
		BlockPos[] blocks = getPortalBlocks(pos,worldIn);
		for (BlockPos block : blocks) {
			worldIn.setBlockState(block, worldIn.getBlockState(block).with(IsOpen, true));
		}
	}
	
	@Override
	@SuppressWarnings("deprecation")
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
		if(isComplete(worldIn,pos) && !state.get(IsOpen) && player.getHeldItem(handIn).getItem() == AlterniaItems.CHERUB_KEY) {
			openPortal(pos,worldIn);
			return ActionResultType.SUCCESS;
		}
		return super.onBlockActivated(state, worldIn, pos, player, handIn, hit);
	}
	@Override
	@SuppressWarnings("deprecation")
	public void onEntityCollision(BlockState state, World worldIn, BlockPos pos, Entity entityIn) {
		if(entityIn instanceof ServerPlayerEntity&&worldIn instanceof ServerWorld){
			if(state.get(IsOpen)) {
				ServerPlayerEntity player = (ServerPlayerEntity) entityIn;
				ServerWorld from = (ServerWorld) worldIn;
				ServerWorld to;
				
				if (from.getDimensionKey() == World.OVERWORLD) {
					to = from.getServer().getWorld(AlterniaDimensions.ALTERNIA_KEY);
				} else {
					to = from.getServer().func_241755_D_();
				}
				
				if(to != null) {
					teleport(from, to, entityIn.getPosition(), player);
					closePortal(pos, from);
				} else LOGGER.error("Destination world for cherub portal not found");
			}
		}
	}
	public static void teleport(ServerWorld from, ServerWorld to, BlockPos spawnPos, ServerPlayerEntity player) {
		from.getChunkProvider().registerTicket(TicketType.POST_TELEPORT, new ChunkPos(spawnPos), 1, player.getEntityId());
		while (to.isAirBlock(spawnPos)) {
			spawnPos = spawnPos.down();
		}
		while (!to.canBlockSeeSky(spawnPos)) {
			spawnPos = spawnPos.up();
		}
		spawnPos = spawnPos.up();
		
		if (player.isSleeping()) {
			player.stopSleepInBed(true, true);
		}
		player.stopRiding();
		
		player.teleport(to, spawnPos.getX(), spawnPos.getY(), spawnPos.getZ(), player.rotationYaw, player.rotationPitch);
	}
	
	@Override
	@SuppressWarnings("deprecation")
	public VoxelShape getCollisionShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		return Block.makeCuboidShape(1.0D, 0.0D, 1.0D, 15.0D, 15.0D, 15.0D);
	}
	
	@Override
	@SuppressWarnings("deprecation")
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		return Block.makeCuboidShape(1.0D, 0.0D, 1.0D, 15.0D, 15.0D, 15.0D);	
	}
	
	
	
	
	
	
	
//FACING STUFF	
	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(HORIZONTAL_FACING,IsOpen);
	}
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		return this.getDefaultState().with(HORIZONTAL_FACING, context.getPlacementHorizontalFacing().getOpposite()).with(IsOpen,false);
	}




	
	

}
