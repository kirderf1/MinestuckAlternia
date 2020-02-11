package com.apocfarce.minestuck_alternia.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

public class PortalCrown extends Portal {

	public PortalCrown(Properties properties) {
		super(properties);
	}

	
	@Override
	protected MutableBoundingBox getBaseBox(IWorld worldIn, BlockPos pos) {
		BlockState state = worldIn.getBlockState(pos);
		Direction facing = state.get(HORIZONTAL_FACING);
		BlockPos pos1,pos2;
		if(worldIn.getBlockState(pos.offset(facing.getOpposite())).has(GreenSnake.PART)) {
			pos1 = pos.offset(facing.getOpposite()).down(3).offset(facing.rotateY(),2);
			pos2=pos.offset(facing,2).down(3).offset(facing.rotateYCCW());
		}else {
			pos1 = pos.offset(facing,2).down(3).offset(facing.rotateYCCW(),2);
			pos2 = pos.offset(facing,2).down(3).offset(facing.rotateYCCW());
		}
		return new MutableBoundingBox(pos1,pos2);
	}
	@Override
	public BlockPos getMainCorner(IWorld worldIn, BlockPos pos,Direction playerFacing) {
		BlockState state = worldIn.getBlockState(pos);
		Direction facing = state.get(HORIZONTAL_FACING);
		
		if(worldIn.getBlockState(pos.offset(facing.getOpposite())).has(GreenSnake.PART)) {
			return pos.offset(facing.getOpposite()).down(3).offset(facing.rotateY(),2);
		}else {
			return pos.offset(facing,2).down(3).offset(facing.rotateYCCW(),2);
		}
		
		
	}
	@Override
	public void DestroyPart(World worldIn, BlockPos mainCorner, Direction facing,boolean isCreative) {
        if (!worldIn.isRemote&&!isCreative) {
    		spawnDrops(this.getDefaultState(), worldIn, mainCorner.offset(facing,2).up(3).offset(facing.rotateY(),1));
        }
		worldIn.destroyBlock(mainCorner.offset(facing,2).up(3).offset(facing.rotateY(),1),false);
		worldIn.destroyBlock(mainCorner.offset(facing,2).up(3).offset(facing.rotateY(),2),false);
		DestroyPart(Portal.PortalPart.CENTER,worldIn,mainCorner,facing,isCreative);

	}
	
	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(HORIZONTAL_FACING);
	}
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		return this.getDefaultState().with(HORIZONTAL_FACING, context.getPlacementHorizontalFacing().getOpposite());
	}



}
