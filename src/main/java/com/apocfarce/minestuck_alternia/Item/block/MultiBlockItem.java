package com.apocfarce.minestuck_alternia.Item.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;

public abstract class MultiBlockItem extends BlockItem
{
	public MultiBlockItem(Block block,Properties properties)
	{
		super(block, properties);
		
	}
	@Override
	public ActionResultType tryPlace(BlockItemUseContext context)
	{
		BlockPos pos = context.getPos();
		if (context.getWorld().isRemote()){
			return ActionResultType.SUCCESS;
		} else
		{
			
			BlockState stateIn = context.getWorld().getBlockState(context.getPos());
			BlockState stateOn = context.getWorld().getBlockState(context.getPos().offset(context.getFace().getOpposite()));
			
			boolean flag = stateIn.isReplaceable(context);
			if (!flag)
			{
				pos = pos.up();
			}
			
			Direction placedFacing = context.getPlayer().getHorizontalFacing().getOpposite();
			ItemStack itemstack = context.getPlayer().getHeldItem(context.getHand());
			
			pos = pos.offset(placedFacing.rotateY());
			
			if(placedFacing == Direction.WEST && context.getHitVec().z >= 0.5F || placedFacing == Direction.EAST && context.getHitVec().z < 0.5F
					|| placedFacing == Direction.NORTH && context.getHitVec().x < 0.5F || placedFacing == Direction.SOUTH && context.getHitVec().x >= 0.5F)
				pos = pos.offset(placedFacing.rotateYCCW());
			
			if (!itemstack.isEmpty())
			{
				if(!canPlaceAt(context,placedFacing,stateOn))
					return ActionResultType.FAIL;
	               if (!context.getPlayer().abilities.isCreativeMode) {
	                   itemstack.shrink(1);
	                }
				BlockState placingState = this.getBlock().getDefaultState().with(HorizontalBlock.HORIZONTAL_FACING,placedFacing);
				this.placeBlock(context, placingState);
				return ActionResultType.SUCCESS;
			}
			return ActionResultType.FAIL;
		
		}
	}
	

	public abstract boolean canPlaceAt(BlockItemUseContext context, Direction facing,BlockState stateIn);
}


