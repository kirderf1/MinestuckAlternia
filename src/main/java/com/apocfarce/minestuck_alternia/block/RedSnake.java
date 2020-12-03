package com.apocfarce.minestuck_alternia.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Direction;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

public class RedSnake extends Portal{
	public static final EnumProperty<EnumParts> PART = EnumProperty.create("part", EnumParts.class);

	public RedSnake(Properties properties) {
		super(properties);
	}
	

	@Override
	protected MutableBoundingBox getBaseBox(IWorld worldIn, BlockPos pos) {
		BlockState state = worldIn.getBlockState(pos);
		Direction stateFacing = state.get(HORIZONTAL_FACING);
		switch(state.get(PART)) {
		case RED_HEAD:
			BlockPos mainPos1 = pos.offset(stateFacing.getOpposite(),4).down(4).offset(stateFacing.rotateY(),2);
			BlockPos oppositePos1 = mainPos1.offset(stateFacing,3).offset(stateFacing.rotateYCCW());
			return new MutableBoundingBox(mainPos1, oppositePos1);
		case SNAKE_NECK:
			BlockPos mainPos2 = pos.offset(stateFacing.getOpposite(),3).down(4).offset(stateFacing.rotateY(),2);
			BlockPos oppositePos2 = mainPos2.offset(stateFacing,3).offset(stateFacing.rotateYCCW());
			return new MutableBoundingBox(mainPos2, oppositePos2);
		case SNAKE_BODY:
			for(int i =1;i<=3;i++) {
				if(worldIn.getBlockState(pos.down(i)).has(PortalBase.PART)) {
					BlockPos mainPos3 = pos.offset(stateFacing.getOpposite(),3).down(i).offset(stateFacing.rotateY(),2);
					BlockPos oppositePos3 = mainPos3.offset(stateFacing,3).offset(stateFacing.rotateYCCW());
					return new MutableBoundingBox(mainPos3, oppositePos3);
				}
			}
		default:
			return null;
		}
	}


	@Override
	public BlockPos getMainCorner(IWorld worldIn, BlockPos pos,Direction Playerfacing) {
		BlockState state = worldIn.getBlockState(pos);
		Direction stateFacing = state.get(HORIZONTAL_FACING);
		switch(state.get(PART)) {
		case RED_HEAD: return pos.offset(stateFacing.getOpposite(),4).down(4).offset(stateFacing.rotateY(),2);
		case SNAKE_NECK:return pos.offset(stateFacing.getOpposite(),3).down(4).offset(stateFacing.rotateY(),2);
		case SNAKE_BODY:
			for(int i =1;i<=3;i++) {
				if(worldIn.getBlockState(pos.down(i)).has(PortalBase.PART)) {
					return pos.offset(stateFacing.getOpposite(),3).down(i).offset(stateFacing.rotateY(),2);
				}
			}
		default:
			return null;
		}
	}

	@Override
	public void destroyPart(World worldIn, BlockPos mainCorner, Direction facing, boolean isCreative) {
        if (!worldIn.isRemote&&!isCreative) {
    		spawnDrops(this.getDefaultState(), worldIn, mainCorner.offset(facing,2).up(1).offset(facing.rotateY()));
        }
		worldIn.destroyBlock(mainCorner.offset(facing,2).up(1).offset(facing.rotateY(),3),false);
		worldIn.destroyBlock(mainCorner.offset(facing,2).up(2).offset(facing.rotateY(),3),false);
		worldIn.destroyBlock(mainCorner.offset(facing,2).up(3).offset(facing.rotateY(),3),false);
		worldIn.destroyBlock(mainCorner.offset(facing,2).up(4).offset(facing.rotateY(),3),false);
		worldIn.destroyBlock(mainCorner.offset(facing,2).up(4).offset(facing.rotateY(),4),false);
		destroyPart(Portal.PortalPart.CENTER,worldIn,mainCorner,facing,isCreative);
		destroyPart(Portal.PortalPart.CROWN,worldIn,mainCorner,facing,isCreative);
	}
		
		
		
		
		
		
		
		
		
		
		protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
			builder.add(HORIZONTAL_FACING,PART);
		}
		public BlockState getStateForPlacement(BlockItemUseContext context) {
			return this.getDefaultState().with(HORIZONTAL_FACING, context.getPlacementHorizontalFacing().getOpposite()).with(PART,EnumParts.SNAKE_BODY);
		}
		
		public enum EnumParts implements IStringSerializable{
			//will be 3x3x3 for a total of 27 blocks, i will need 2 inter linked classes

			RED_HEAD,
			SNAKE_NECK,
			SNAKE_BODY;
			

			@Override
			public String getName() {
				return name().toLowerCase();
			}

		}
	
	

}
