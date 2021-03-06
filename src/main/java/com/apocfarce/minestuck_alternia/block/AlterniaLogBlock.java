package com.apocfarce.minestuck_alternia.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.LogBlock;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.AxeItem;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

import java.util.function.Supplier;

public class AlterniaLogBlock extends LogBlock {
	private final Supplier<Block> stripped;
	public AlterniaLogBlock(MaterialColor color, Supplier<Block> strippedLog, Properties properties) {
		super(color, properties);
		this.stripped = strippedLog;
	}

	@Override
	@SuppressWarnings("deprecation")
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
		if (player.getHeldItem(handIn).getItem() instanceof AxeItem) {
			worldIn.setBlockState(pos, stripped.get().getDefaultState().with(AXIS, state.get(AXIS)));
		}
		return super.onBlockActivated(state, worldIn, pos, player, handIn, hit);
	}
}