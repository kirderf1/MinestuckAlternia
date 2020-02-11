package com.apocfarce.minestuck_alternia.Item.block;

import com.apocfarce.minestuck_alternia.block.GreenSnake;
import com.apocfarce.minestuck_alternia.block.Portal;
import com.apocfarce.minestuck_alternia.block.RedSnake;
import com.apocfarce.minestuck_alternia.block.RedSnake.EnumParts;

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

public class RedSnakeItem extends MultiBlockItem
{
	public RedSnakeItem(Block block,Properties properties)
	{
		super(block, properties);
		
	}
	
	@Override
	public boolean canPlaceAt(BlockItemUseContext context, Direction facing,BlockState stateOn)
	{
		if (stateOn.getBlock() instanceof Portal) {
			Portal portal = (Portal)stateOn.getBlock();		
			if(portal.hasPart(Portal.PortalPart.RED_SNAKE, context.getWorld(), portal.getMainCorner(context.getWorld(), context.getPos().offset(context.getFace().getOpposite()),facing)))
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
		EnumProperty<EnumParts> PART = RedSnake.PART;
		EnumProperty<Direction> HORIZONTAL_FACING = HorizontalBlock.HORIZONTAL_FACING;
		if(!worldIn.isRemote)
		{
			worldIn.setBlockState(pos.offset(facing.rotateY(),3).offset(facing,2).up(1),state.with(PART, EnumParts.SNAKE_BODY).with(HORIZONTAL_FACING,facing.rotateY()));
			worldIn.setBlockState(pos.offset(facing.rotateY(),3).offset(facing,2).up(2),state.with(PART, EnumParts.SNAKE_BODY).with(HORIZONTAL_FACING,facing.rotateY()));
			worldIn.setBlockState(pos.offset(facing.rotateY(),3).offset(facing,2).up(3),state.with(PART, EnumParts.SNAKE_BODY).with(HORIZONTAL_FACING,facing.rotateY()));
			worldIn.setBlockState(pos.offset(facing.rotateY(),3).offset(facing,2).up(4),state.with(PART, EnumParts.SNAKE_NECK).with(HORIZONTAL_FACING,facing.rotateY()));
			worldIn.setBlockState(pos.offset(facing.rotateY(),4).offset(facing,2).up(4),state.with(PART, EnumParts.RED_HEAD).with(HORIZONTAL_FACING,facing.rotateY()));

			
	
			if(context.getPlayer() instanceof ServerPlayerEntity)
				CriteriaTriggers.PLACED_BLOCK.trigger((ServerPlayerEntity) context.getPlayer(), pos, context.getItem());
		}
		return true;
	}
}


