package com.apocfarce.minestuck_alternia.data.loot;

import com.apocfarce.minestuck_alternia.Minestuck_alternia;
import com.apocfarce.minestuck_alternia.block.AlterniaBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.data.loot.BlockLootTables;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.stream.Collectors;

public class AlterniaBlockLootTables extends BlockLootTables {
	
	private static final float[] DEFAULT_SAPLING_DROP_RATES = new float[]{1/20F, 1/16F, 1/12F, 1/10F};
	
	@Override
	protected void addTables() {
		registerLootTable(AlterniaBlocks.darkStone, block -> droppingWithSilkTouch(block, AlterniaBlocks.darkCobble));
		registerDropSelfLootTable(AlterniaBlocks.darkCobble);
		registerLootTable(AlterniaBlocks.redRock, block -> droppingWithSilkTouch(block, AlterniaBlocks.redCobble));
		registerDropSelfLootTable(AlterniaBlocks.redCobble);
		registerDropSelfLootTable(AlterniaBlocks.portalCenter);
		registerDropSelfLootTable(AlterniaBlocks.portalBase);
		registerDropSelfLootTable(AlterniaBlocks.portalCrown);
		registerDropSelfLootTable(AlterniaBlocks.redSnake);
		registerDropSelfLootTable(AlterniaBlocks.greenSnake);
		
		registerDropSelfLootTable(AlterniaBlocks.pyralSapling);
		registerLootTable(AlterniaBlocks.pyralLeaves, block -> droppingWithChancesAndSticks(block, AlterniaBlocks.pyralSapling, DEFAULT_SAPLING_DROP_RATES));
		registerDropSelfLootTable(AlterniaBlocks.pyralLog);
		registerDropSelfLootTable(AlterniaBlocks.strippedPyralLog);
		registerDropSelfLootTable(AlterniaBlocks.pyralWood);
		registerDropSelfLootTable(AlterniaBlocks.strippedPyralWood);
		registerDropSelfLootTable(AlterniaBlocks.pyralSapling);
		registerDropSelfLootTable(AlterniaBlocks.pyralSapling);
		registerDropSelfLootTable(AlterniaBlocks.pyralPlanks);
		registerDropSelfLootTable(AlterniaBlocks.pyralStairs);
		registerDropSelfLootTable(AlterniaBlocks.pyralSlab);
		registerDropSelfLootTable(AlterniaBlocks.pyralFence);
		registerDropSelfLootTable(AlterniaBlocks.pyralFenceGate);
		
		registerDropSelfLootTable(AlterniaBlocks.mirrageSapling);
		registerLootTable(AlterniaBlocks.mirrageLeaves, block -> droppingWithChancesAndSticks(block, AlterniaBlocks.mirrageSapling, DEFAULT_SAPLING_DROP_RATES));
		registerDropSelfLootTable(AlterniaBlocks.mirrageLog);
		registerDropSelfLootTable(AlterniaBlocks.strippedmirrageLog);
		registerDropSelfLootTable(AlterniaBlocks.mirrageWood);
		registerDropSelfLootTable(AlterniaBlocks.strippedmirrageWood);
		registerDropSelfLootTable(AlterniaBlocks.mirragePlanks);
		registerDropSelfLootTable(AlterniaBlocks.mirrageStairs);
		registerDropSelfLootTable(AlterniaBlocks.mirrageSlab);
		registerDropSelfLootTable(AlterniaBlocks.mirrageFence);
		registerDropSelfLootTable(AlterniaBlocks.mirrageFenceGate);
		
		registerLootTable(AlterniaBlocks.pyralGrass, BlockLootTables::droppingSeeds);
		
		for(Block glass : AlterniaBlocks.hiveGlass) {
			if(glass != null)
				registerSilkTouch(glass);
		}
	}
	
	@Override
	protected Iterable<Block> getKnownBlocks() {
		return ForgeRegistries.BLOCKS.getValues().stream().filter(block -> block.getRegistryName().getNamespace().equals(Minestuck_alternia.MOD_ID)).collect(Collectors.toList());
	}
}
