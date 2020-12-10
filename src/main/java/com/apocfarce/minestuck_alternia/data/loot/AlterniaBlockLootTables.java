package com.apocfarce.minestuck_alternia.data.loot;

import com.apocfarce.minestuck_alternia.MinestuckAlternia;
import com.apocfarce.minestuck_alternia.block.AlterniaBlocks;
import net.minecraft.block.Block;
import net.minecraft.data.loot.BlockLootTables;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Items;
import net.minecraft.loot.ItemLootEntry;
import net.minecraft.loot.RandomValueRange;
import net.minecraft.loot.functions.ApplyBonus;
import net.minecraft.loot.functions.SetCount;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.stream.Collectors;

public class AlterniaBlockLootTables extends BlockLootTables {
	
	private static final float[] DEFAULT_SAPLING_DROP_RATES = new float[]{1/20F, 1/16F, 1/12F, 1/10F};
	
	@Override
	protected void addTables() {
		registerLootTable(AlterniaBlocks.DARK_STONE, block -> droppingWithSilkTouch(block, AlterniaBlocks.DARK_COBBLE));
		registerDropSelfLootTable(AlterniaBlocks.DARK_COBBLE);
		registerLootTable(AlterniaBlocks.RED_ROCK, block -> droppingWithSilkTouch(block, AlterniaBlocks.RED_COBBLE));
		
		registerLootTable(AlterniaBlocks.DARK_STONE_COAL_ORE, ore -> droppingItemWithFortune(ore, Items.COAL));
		registerDropSelfLootTable(AlterniaBlocks.DARK_STONE_IRON_ORE);
		registerDropSelfLootTable(AlterniaBlocks.DARK_STONE_GOLD_ORE);
		registerLootTable(AlterniaBlocks.DARK_STONE_REDSTONE_ORE, ore -> droppingWithSilkTouch(ore, withExplosionDecay(ore,
				ItemLootEntry.builder(Items.REDSTONE).acceptFunction(SetCount.builder(RandomValueRange.of(4, 5)))
						.acceptFunction(ApplyBonus.uniformBonusCount(Enchantments.FORTUNE)))));
		registerLootTable(AlterniaBlocks.DARK_STONE_DIAMOND_ORE, ore -> droppingItemWithFortune(ore, Items.DIAMOND));
		registerLootTable(AlterniaBlocks.DARK_STONE_LAPIS_ORE, ore -> droppingWithSilkTouch(ore, withExplosionDecay(ore,
				ItemLootEntry.builder(Items.LAPIS_LAZULI).acceptFunction(SetCount.builder(RandomValueRange.of(4, 9)))
				.acceptFunction(ApplyBonus.oreDrops(Enchantments.FORTUNE)))));
		
		registerDropSelfLootTable(AlterniaBlocks.RED_COBBLE);
		registerDropSelfLootTable(AlterniaBlocks.PORTAL_CENTER);
		registerDropSelfLootTable(AlterniaBlocks.PORTAL_BASE);
		registerDropSelfLootTable(AlterniaBlocks.PORTAL_CROWN);
		registerDropSelfLootTable(AlterniaBlocks.RED_SNAKE);
		registerDropSelfLootTable(AlterniaBlocks.GREEN_SNAKE);
		
		registerDropSelfLootTable(AlterniaBlocks.PYRAL_SAPLING);
		registerLootTable(AlterniaBlocks.PYRAL_LEAVES, block -> droppingWithChancesAndSticks(block, AlterniaBlocks.PYRAL_SAPLING, DEFAULT_SAPLING_DROP_RATES));
		registerDropSelfLootTable(AlterniaBlocks.PYRAL_LOG);
		registerDropSelfLootTable(AlterniaBlocks.STRIPPED_PYRAL_LOG);
		registerDropSelfLootTable(AlterniaBlocks.PYRAL_WOOD);
		registerDropSelfLootTable(AlterniaBlocks.STRIPPED_PYRAL_WOOD);
		registerDropSelfLootTable(AlterniaBlocks.PYRAL_PLANKS);
		registerDropSelfLootTable(AlterniaBlocks.PYRAL_STAIRS);
		registerDropSelfLootTable(AlterniaBlocks.PYRAL_SLAB);
		registerDropSelfLootTable(AlterniaBlocks.PYRAL_FENCE);
		registerDropSelfLootTable(AlterniaBlocks.PYRAL_FENCE_GATE);
		
		registerDropSelfLootTable(AlterniaBlocks.MIRRAGE_SAPLING);
		registerLootTable(AlterniaBlocks.MIRRAGE_LEAVES, block -> droppingWithChancesAndSticks(block, AlterniaBlocks.MIRRAGE_SAPLING, DEFAULT_SAPLING_DROP_RATES));
		registerDropSelfLootTable(AlterniaBlocks.MIRRAGE_LOG);
		registerDropSelfLootTable(AlterniaBlocks.STRIPPED_MIRRAGE_LOG);
		registerDropSelfLootTable(AlterniaBlocks.MIRRAGE_WOOD);
		registerDropSelfLootTable(AlterniaBlocks.STRIPPED_MIRRAGE_WOOD);
		registerDropSelfLootTable(AlterniaBlocks.MIRRAGE_PLANKS);
		registerDropSelfLootTable(AlterniaBlocks.MIRRAGE_STAIRS);
		registerDropSelfLootTable(AlterniaBlocks.MIRRAGE_SLAB);
		registerDropSelfLootTable(AlterniaBlocks.MIRRAGE_FENCE);
		registerDropSelfLootTable(AlterniaBlocks.MIRRAGE_FENCE_GATE);
		
		registerLootTable(AlterniaBlocks.PYRAL_GRASS, BlockLootTables::droppingSeeds);
		
		registerSilkTouch(AlterniaBlocks.BURGUNDY_HIVE_GLASS);
		registerSilkTouch(AlterniaBlocks.BRONZE_HIVE_GLASS);
		registerSilkTouch(AlterniaBlocks.GOLD_HIVE_GLASS);
		registerSilkTouch(AlterniaBlocks.OLIVE_HIVE_GLASS);
		registerSilkTouch(AlterniaBlocks.JADE_HIVE_GLASS);
		registerSilkTouch(AlterniaBlocks.TEAL_HIVE_GLASS);
		registerSilkTouch(AlterniaBlocks.CERULEAN_HIVE_GLASS);
		registerSilkTouch(AlterniaBlocks.INDIGO_HIVE_GLASS);
		registerSilkTouch(AlterniaBlocks.PURPLE_HIVE_GLASS);
		registerSilkTouch(AlterniaBlocks.VIOLET_HIVE_GLASS);
		registerSilkTouch(AlterniaBlocks.FUCHSIA_HIVE_GLASS);
		registerSilkTouch(AlterniaBlocks.LIME_HIVE_GLASS);
		registerSilkTouch(AlterniaBlocks.GREY_HIVE_GLASS);
	}
	
	@Override
	protected Iterable<Block> getKnownBlocks() {
		return ForgeRegistries.BLOCKS.getValues().stream().filter(block -> block.getRegistryName().getNamespace().equals(MinestuckAlternia.MOD_ID)).collect(Collectors.toList());
	}
}
