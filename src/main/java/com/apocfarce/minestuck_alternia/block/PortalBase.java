package com.apocfarce.minestuck_alternia.block;

import com.apocfarce.minestuck_alternia.Item.AlterniaItems;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

public class PortalBase extends Portal{
	public static final EnumProperty<EnumParts> PART = EnumProperty.create("part", EnumParts.class);

	
	
	public PortalBase(Properties properties) {
		super(properties);
	}
	
//FACING STUFF	
	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(HORIZONTAL_FACING,PART);
	}
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		return this.getDefaultState().with(HORIZONTAL_FACING, context.getPlacementHorizontalFacing().getOpposite()).with(PART,EnumParts.BASE_CORNER);
	}


	
	
	
	public enum EnumParts implements IStringSerializable{
		BASE_EDGE,
		BASE_CORNER,
		BASE_CENTER;
		
		@Override
		public String getName() {
			return name().toLowerCase();
		}

	}





	@Override
	protected MutableBoundingBox getBaseBox(IWorld worldIn, BlockPos pos) {
		BlockState state = worldIn.getBlockState(pos);
		switch(state.get(PART)) {
		case BASE_CENTER:
			switch(state.get(HORIZONTAL_FACING)) {
			case EAST:return new MutableBoundingBox(pos.getX()-2, pos.getY(), pos.getZ()-2, pos.getX()+1, pos.getY(), pos.getZ()+1);
			case NORTH:return new MutableBoundingBox(pos.getX()-2, pos.getY(), pos.getZ()-1, pos.getX()+1, pos.getY(), pos.getZ()+2);
			case WEST:return new MutableBoundingBox(pos.getX()-1, pos.getY(), pos.getZ()-1, pos.getX()+2, pos.getY(), pos.getZ()+2);
			case SOUTH:return new MutableBoundingBox(pos.getX()-1, pos.getY(), pos.getZ()-2, pos.getX()+2, pos.getY(), pos.getZ()+1);
			default:break;
			}
			break;
		case BASE_CORNER:
			switch(state.get(HORIZONTAL_FACING)) {
			case EAST:return new MutableBoundingBox(pos.getX()-3, pos.getY(), pos.getZ()-3, pos.getX(), pos.getY(), pos.getZ());
			case NORTH:return new MutableBoundingBox(pos.getX()-3, pos.getY(), pos.getZ(), pos.getX(), pos.getY(), pos.getZ()+3);
			case WEST:return new MutableBoundingBox(pos.getX(), pos.getY(), pos.getZ(), pos.getX()+3, pos.getY(), pos.getZ()+3);
			case SOUTH:return new MutableBoundingBox(pos.getX(), pos.getY(), pos.getZ()-3, pos.getX()+3, pos.getY(), pos.getZ());
			default:break;
			}
			break;			
		case BASE_EDGE:
			return(getBaseBox(worldIn, pos.offset(state.get(HORIZONTAL_FACING).getOpposite())));
		default:
			break;
		}
		return null;
	}


	@Override
	public BlockPos getMainCorner(IWorld worldIn, BlockPos pos,Direction playerFacing) {
		MutableBoundingBox box = getBaseBox(worldIn,pos);
		Direction facing = getOrientation(worldIn, box);
		if(facing == null) {
			facing = playerFacing;
		}
		
		return getMainCorner(facing, box);
	}


	@Override
	public void DestroyPart(World worldIn, BlockPos mainCorner, Direction facing, boolean isCreative) {

        if (!worldIn.isRemote&&!isCreative) {
        	spawnDrops(this.getDefaultState(), worldIn, mainCorner.up());
        }
		DestroyPart(Portal.PortalPart.GREEN_SNAKE,worldIn,mainCorner,facing,isCreative);
		DestroyPart(Portal.PortalPart.RED_SNAKE,worldIn,mainCorner,facing,isCreative);
		DestroyPart(Portal.PortalPart.CROWN,worldIn,mainCorner,facing,isCreative);
		DestroyPart(Portal.PortalPart.CENTER,worldIn,mainCorner,facing,isCreative);
		for (int x=0;x<4;x++) {
			for(int z=0;z<4;z++) {
				worldIn.destroyBlock(mainCorner.offset(facing, x).offset(facing.rotateY(),z),false);
			}
		}

	}
}
