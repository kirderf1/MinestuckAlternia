package com.apocfarce.minestuck_alternia.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.RotatedPillarBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

import javax.annotation.Nullable;
import java.util.function.Supplier;

public class AxeModifiableBlock extends RotatedPillarBlock {
	private final Supplier<Block> stripped;
	
	public AxeModifiableBlock(Supplier<Block> strippedLog, Properties properties) {
		super(properties);
		this.stripped = strippedLog;
	}
	
	@Nullable
	@Override
	public BlockState getToolModifiedState(BlockState state, World world, BlockPos pos, PlayerEntity player, ItemStack stack, ToolType toolType) {
		return stripped.get().getDefaultState().with(AXIS, state.get(AXIS));
	}
}