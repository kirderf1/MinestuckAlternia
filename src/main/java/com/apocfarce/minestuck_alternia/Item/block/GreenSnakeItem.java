package com.apocfarce.minestuck_alternia.Item.block;

import com.apocfarce.minestuck_alternia.block.GreenSnake;
import com.apocfarce.minestuck_alternia.block.GreenSnake.EnumParts;
import com.apocfarce.minestuck_alternia.block.Portal;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.EnumProperty;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class GreenSnakeItem extends MultiBlockItem
{
	public GreenSnakeItem(Block block,Properties properties)
	{
		super(block, properties);
		
	}
	
	@Override
	public boolean canPlaceAt(BlockItemUseContext context, Direction facing,BlockState stateOn)
	{
		if (stateOn.getBlock() instanceof Portal) {
			Portal portal = (Portal)stateOn.getBlock();		
			if(portal.hasPart(Portal.PortalPart.GREEN_SNAKE, context.getWorld(), portal.getMainCorner(context.getWorld(), context.getPos().offset(context.getFace().getOpposite()),facing)))
				return false;
			return true;
		}
		return false;
	}
	@Override
	public boolean placeBlock(BlockItemUseContext context, BlockState state)	
	{
		World worldIn = context.getWorld();
		BlockPos posOn = context.getPos().offset(context.getFace().getOpposite());
		Portal portal =(Portal)worldIn.getBlockState(posOn).getBlock();
		Direction facing = portal.getOrientation(worldIn, posOn);
		if(facing == null) {
			facing=context.getPlayer().getHorizontalFacing();
		}
		BlockPos pos = portal.getMainCorner(worldIn, posOn,facing);
		EnumProperty<EnumParts> PART = GreenSnake.PART;
		EnumProperty<Direction> HORIZONTAL_FACING = HorizontalBlock.HORIZONTAL_FACING;
		if(!worldIn.isRemote)
		{

			
			//green snake
			worldIn.setBlockState(pos.offset(facing.rotateY(),0).offset(facing,2).up(1),state.with(PART, EnumParts.SNAKE_BODY).with(HORIZONTAL_FACING,facing.rotateYCCW()));
			worldIn.setBlockState(pos.offset(facing.rotateY(),0).offset(facing,2).up(2),state.with(PART, EnumParts.SNAKE_BODY).with(HORIZONTAL_FACING,facing.rotateYCCW()));
			worldIn.setBlockState(pos.offset(facing.rotateY(),0).offset(facing,2).up(3),state.with(PART, EnumParts.SNAKE_BODY).with(HORIZONTAL_FACING,facing.rotateYCCW()));
			worldIn.setBlockState(pos.offset(facing.rotateY(),0).offset(facing,2).up(4),state.with(PART, EnumParts.SNAKE_NECK).with(HORIZONTAL_FACING,facing.rotateYCCW()));
			worldIn.setBlockState(pos.offset(facing.rotateY(),-1).offset(facing,2).up(4),state.with(PART, EnumParts.GREEN_HEAD).with(HORIZONTAL_FACING,facing.rotateYCCW()));

			
	
			if(context.getPlayer() instanceof ServerPlayerEntity)
				CriteriaTriggers.PLACED_BLOCK.trigger((ServerPlayerEntity) context.getPlayer(), pos, context.getItem());
		}
		return true;
	}
}


