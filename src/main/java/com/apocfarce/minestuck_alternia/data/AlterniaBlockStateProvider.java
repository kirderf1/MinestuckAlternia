package com.apocfarce.minestuck_alternia.data;

import com.apocfarce.minestuck_alternia.Minestuck_alternia;
import com.apocfarce.minestuck_alternia.block.AlterniaBlocks;
import net.minecraft.block.*;
import net.minecraft.data.DataGenerator;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ExistingFileHelper;
import net.minecraftforge.client.model.generators.ModelProvider;

@SuppressWarnings("ConstantConditions")
public class AlterniaBlockStateProvider extends BlockStateProvider {
	
	public AlterniaBlockStateProvider(DataGenerator gen, ExistingFileHelper exFileHelper) {
		super(gen, Minestuck_alternia.MOD_ID, exFileHelper);
	}
	
	@Override
	protected void registerStatesAndModels() {
		simpleBlock(AlterniaBlocks.DARK_STONE);
		simpleBlockItem(AlterniaBlocks.DARK_STONE);
		simpleBlock(AlterniaBlocks.DARK_COBBLE);
		simpleBlockItem(AlterniaBlocks.DARK_COBBLE);
		simpleBlock(AlterniaBlocks.RED_ROCK);
		simpleBlockItem(AlterniaBlocks.RED_ROCK);
		simpleBlock(AlterniaBlocks.RED_COBBLE);
		simpleBlockItem(AlterniaBlocks.RED_COBBLE);
		
		cross(AlterniaBlocks.PYRAL_SAPLING);
		simpleFlatBlockItem(AlterniaBlocks.PYRAL_SAPLING);
		leaves(AlterniaBlocks.PYRAL_LEAVES);
		simpleBlockItem(AlterniaBlocks.PYRAL_LEAVES);
		logBlock(AlterniaBlocks.PYRAL_LOG);
		simpleBlockItem(AlterniaBlocks.PYRAL_LOG);
		strippedLogBlock(AlterniaBlocks.STRIPPED_PYRAL_LOG, AlterniaBlocks.PYRAL_LOG);
		simpleBlockItem(AlterniaBlocks.STRIPPED_PYRAL_LOG);
		simpleBlock(AlterniaBlocks.PYRAL_WOOD, blockTexture(AlterniaBlocks.PYRAL_LOG));
		simpleBlockItem(AlterniaBlocks.PYRAL_WOOD);
		simpleBlock(AlterniaBlocks.STRIPPED_PYRAL_WOOD, blockTexture(AlterniaBlocks.STRIPPED_PYRAL_LOG));
		simpleBlockItem(AlterniaBlocks.STRIPPED_PYRAL_WOOD);
		simpleBlock(AlterniaBlocks.PYRAL_PLANKS);
		simpleBlockItem(AlterniaBlocks.PYRAL_PLANKS);
		stairsBlock(AlterniaBlocks.PYRAL_STAIRS, blockTexture(AlterniaBlocks.PYRAL_PLANKS));
		simpleBlockItem(AlterniaBlocks.PYRAL_STAIRS);
		slabBlock(AlterniaBlocks.PYRAL_SLAB, blockTexture(AlterniaBlocks.PYRAL_PLANKS), blockTexture(AlterniaBlocks.PYRAL_PLANKS));
		simpleBlockItem(AlterniaBlocks.PYRAL_SLAB);
		fenceBlock(AlterniaBlocks.PYRAL_FENCE, blockTexture(AlterniaBlocks.PYRAL_PLANKS));
		inventoryFenceItem(AlterniaBlocks.PYRAL_FENCE, blockTexture(AlterniaBlocks.PYRAL_PLANKS));
		fenceGateBlock(AlterniaBlocks.PYRAL_FENCE_GATE, blockTexture(AlterniaBlocks.PYRAL_PLANKS));
		simpleBlockItem(AlterniaBlocks.PYRAL_FENCE_GATE);
		
		cross(AlterniaBlocks.MIRRAGE_SAPLING);
		simpleFlatBlockItem(AlterniaBlocks.MIRRAGE_SAPLING);
		leaves(AlterniaBlocks.MIRRAGE_LEAVES, blockTexture(Blocks.ACACIA_LEAVES));
		simpleBlockItem(AlterniaBlocks.MIRRAGE_LEAVES);
		logBlock(AlterniaBlocks.MIRRAGE_LOG);
		simpleBlockItem(AlterniaBlocks.MIRRAGE_LOG);
		strippedLogBlock(AlterniaBlocks.STRIPPED_MIRRAGE_LOG, AlterniaBlocks.MIRRAGE_LOG);
		simpleBlockItem(AlterniaBlocks.STRIPPED_MIRRAGE_LOG);
		simpleBlock(AlterniaBlocks.MIRRAGE_WOOD, blockTexture(AlterniaBlocks.MIRRAGE_LOG));
		simpleBlockItem(AlterniaBlocks.MIRRAGE_WOOD);
		simpleBlock(AlterniaBlocks.STRIPPED_MIRRAGE_WOOD, blockTexture(AlterniaBlocks.STRIPPED_MIRRAGE_LOG));
		simpleBlockItem(AlterniaBlocks.STRIPPED_MIRRAGE_WOOD);
		simpleBlock(AlterniaBlocks.MIRRAGE_PLANKS);
		simpleBlockItem(AlterniaBlocks.MIRRAGE_PLANKS);
	stairsBlock(AlterniaBlocks.MIRRAGE_STAIRS, blockTexture(AlterniaBlocks.MIRRAGE_PLANKS));
		simpleBlockItem(AlterniaBlocks.MIRRAGE_STAIRS);
		slabBlock(AlterniaBlocks.MIRRAGE_SLAB, blockTexture(AlterniaBlocks.MIRRAGE_PLANKS), blockTexture(AlterniaBlocks.MIRRAGE_PLANKS));
		simpleBlockItem(AlterniaBlocks.MIRRAGE_SLAB);
		fenceBlock(AlterniaBlocks.MIRRAGE_FENCE, blockTexture(AlterniaBlocks.MIRRAGE_PLANKS));
		inventoryFenceItem(AlterniaBlocks.MIRRAGE_FENCE, blockTexture(AlterniaBlocks.MIRRAGE_PLANKS));
		fenceGateBlock(AlterniaBlocks.MIRRAGE_FENCE_GATE, blockTexture(AlterniaBlocks.MIRRAGE_PLANKS));
		simpleBlockItem(AlterniaBlocks.MIRRAGE_FENCE_GATE);
		
		tintedCross(AlterniaBlocks.PYRAL_GRASS);
		simpleFlatBlockItem(AlterniaBlocks.PYRAL_GRASS);
		
		paneBlock(AlterniaBlocks.BURGUNDY_HIVE_GLASS);
		simpleFlatBlockItem(AlterniaBlocks.BURGUNDY_HIVE_GLASS);
		paneBlock(AlterniaBlocks.BRONZE_HIVE_GLASS);
		simpleFlatBlockItem(AlterniaBlocks.BRONZE_HIVE_GLASS);
		paneBlock(AlterniaBlocks.GOLD_HIVE_GLASS);
		simpleFlatBlockItem(AlterniaBlocks.GOLD_HIVE_GLASS);
		paneBlock(AlterniaBlocks.OLIVE_HIVE_GLASS);
		simpleFlatBlockItem(AlterniaBlocks.OLIVE_HIVE_GLASS);
		paneBlock(AlterniaBlocks.JADE_HIVE_GLASS);
		simpleFlatBlockItem(AlterniaBlocks.JADE_HIVE_GLASS);
		paneBlock(AlterniaBlocks.TEAL_HIVE_GLASS);
		simpleFlatBlockItem(AlterniaBlocks.TEAL_HIVE_GLASS);
		paneBlock(AlterniaBlocks.CERULEAN_HIVE_GLASS);
		simpleFlatBlockItem(AlterniaBlocks.CERULEAN_HIVE_GLASS);
		paneBlock(AlterniaBlocks.INDIGO_HIVE_GLASS);
		simpleFlatBlockItem(AlterniaBlocks.INDIGO_HIVE_GLASS);
		paneBlock(AlterniaBlocks.PURPLE_HIVE_GLASS);
		simpleFlatBlockItem(AlterniaBlocks.PURPLE_HIVE_GLASS);
		paneBlock(AlterniaBlocks.VIOLET_HIVE_GLASS);
		simpleFlatBlockItem(AlterniaBlocks.VIOLET_HIVE_GLASS);
		paneBlock(AlterniaBlocks.FUCHSIA_HIVE_GLASS);
		simpleFlatBlockItem(AlterniaBlocks.FUCHSIA_HIVE_GLASS);
		paneBlock(AlterniaBlocks.LIME_HIVE_GLASS);
		simpleFlatBlockItem(AlterniaBlocks.LIME_HIVE_GLASS);
		paneBlock(AlterniaBlocks.GREY_HIVE_GLASS);
		simpleFlatBlockItem(AlterniaBlocks.GREY_HIVE_GLASS);
	}
	
	protected ResourceLocation extend(ResourceLocation rl, String suffix) {
		return new ResourceLocation(rl.getNamespace(), rl.getPath() + suffix);
	}
	
	protected void simpleBlock(Block block, ResourceLocation texture) {
		simpleBlock(block, models().cubeAll(block.getRegistryName().getPath(), texture));
	}
	
	protected void simpleBlockItem(Block block) {
		simpleBlockItem(block, blockTexture(block));
	}
	
	protected void simpleBlockItem(Block block, ResourceLocation parent) {
		simpleBlockItem(block, models().getExistingFile(parent));
	}
	
	protected void simpleFlatBlockItem(Block block) {
		itemModels().singleTexture(block.getRegistryName().getPath(), mcLoc("item/generated"), "layer0", blockTexture(block));
	}
	
	protected void cross(Block block) {
		simpleBlock(block, models().cross(block.getRegistryName().getPath(), blockTexture(block)));
	}
	
	protected void tintedCross(Block block) {
		simpleBlock(block, models().singleTexture(block.getRegistryName().getPath(), mcLoc(ModelProvider.BLOCK_FOLDER + "/tinted_cross"), "cross", blockTexture(block)));
	}
	
	protected void leaves(Block leaves) {
		leaves(leaves, blockTexture(leaves));
	}
	
	protected void leaves(Block leaves, ResourceLocation texture) {
		simpleBlock(leaves, models().singleTexture(leaves.getRegistryName().getPath(), mcLoc(ModelProvider.BLOCK_FOLDER + "/leaves"), "all", texture));
	}
	
	protected void strippedLogBlock(LogBlock block, LogBlock regularLog) {
		axisBlock(block, blockTexture(block), extend(blockTexture(regularLog), "_top"));
	}
	
	protected void inventoryFenceItem(FenceBlock block, ResourceLocation texture) {
		String baseName = block.getRegistryName().toString();
		simpleBlockItem(block, models().fenceInventory(baseName + "_inventory", texture));
	}
	
	protected void paneBlock(PaneBlock block) {
		paneBlock(block, blockTexture(block), blockTexture(block));
	}
}