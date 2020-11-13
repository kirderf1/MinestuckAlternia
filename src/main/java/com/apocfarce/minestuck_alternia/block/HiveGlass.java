package com.apocfarce.minestuck_alternia.block;


import com.apocfarce.minestuck_alternia.Item.EnumBloodColor;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.PaneBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;

public class HiveGlass  extends PaneBlock {
	
	public EnumBloodColor color;
	
	public HiveGlass(Block.Properties properties, EnumBloodColor bloodColor) {
		super(properties);
		color=bloodColor;
	}
	public EnumBloodColor GetBloodColor() {
		return color;
	}
	@Override
	public int getOpacity(BlockState state, IBlockReader worldIn, BlockPos pos) {
		return(Blocks.GLASS_PANE.getDefaultState().getOpacity(worldIn, pos));
	}
}
