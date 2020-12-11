package com.apocfarce.minestuck_alternia.data;

import com.apocfarce.minestuck_alternia.MinestuckAlternia;
import com.apocfarce.minestuck_alternia.block.AlterniaBlocks;
import com.apocfarce.minestuck_alternia.util.AlterniaTags;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;

public class AlterniaBlockTagsProvider extends BlockTagsProvider {
	
	public AlterniaBlockTagsProvider(DataGenerator generatorIn, ExistingFileHelper exFileHelper) {
		super(generatorIn, MinestuckAlternia.MOD_ID, exFileHelper);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	protected void registerTags() {
		getOrCreateBuilder(BlockTags.LOGS_THAT_BURN).addTags(AlterniaTags.Blocks.PYRAL_LOGS, AlterniaTags.Blocks.MIRRAGE_LOGS);
		getOrCreateBuilder(BlockTags.PLANKS).addTags(AlterniaTags.Blocks.PLANKS);
		getOrCreateBuilder(BlockTags.WOODEN_STAIRS).addTags(AlterniaTags.Blocks.WOODEN_STAIRS);
		getOrCreateBuilder(BlockTags.WOODEN_SLABS).addTags(AlterniaTags.Blocks.WOODEN_SLABS);
		getOrCreateBuilder(BlockTags.WOODEN_FENCES).addTags(AlterniaTags.Blocks.WOODEN_FENCES);
		getOrCreateBuilder(BlockTags.SAPLINGS).addTags(AlterniaTags.Blocks.SAPLINGS);
		getOrCreateBuilder(BlockTags.LEAVES).addTags(AlterniaTags.Blocks.LEAVES);
		getOrCreateBuilder(BlockTags.FENCE_GATES).add(AlterniaBlocks.PYRAL_FENCE_GATE, AlterniaBlocks.MIRRAGE_FENCE_GATE);
		
		getOrCreateBuilder(Tags.Blocks.STONE).add(AlterniaBlocks.DARK_STONE, AlterniaBlocks.RED_ROCK);
		getOrCreateBuilder(Tags.Blocks.COBBLESTONE).add(AlterniaBlocks.DARK_COBBLE, AlterniaBlocks.RED_COBBLE);
		getOrCreateBuilder(BlockTags.GOLD_ORES).add(AlterniaBlocks.DARK_STONE_GOLD_ORE);
		getOrCreateBuilder(Tags.Blocks.ORES_COAL).add(AlterniaBlocks.DARK_STONE_COAL_ORE);
		getOrCreateBuilder(Tags.Blocks.ORES_IRON).add(AlterniaBlocks.DARK_STONE_IRON_ORE);
		getOrCreateBuilder(Tags.Blocks.ORES_REDSTONE).add(AlterniaBlocks.DARK_STONE_REDSTONE_ORE);
		getOrCreateBuilder(Tags.Blocks.ORES_DIAMOND).add(AlterniaBlocks.DARK_STONE_DIAMOND_ORE);
		getOrCreateBuilder(Tags.Blocks.ORES_LAPIS).add(AlterniaBlocks.DARK_STONE_LAPIS_ORE);
		
		getOrCreateBuilder(AlterniaTags.Blocks.PYRAL_LOGS).add(AlterniaBlocks.PYRAL_LOG, AlterniaBlocks.PYRAL_WOOD, AlterniaBlocks.STRIPPED_PYRAL_LOG, AlterniaBlocks.STRIPPED_PYRAL_WOOD);
		getOrCreateBuilder(AlterniaTags.Blocks.MIRRAGE_LOGS).add(AlterniaBlocks.MIRRAGE_LOG, AlterniaBlocks.MIRRAGE_WOOD, AlterniaBlocks.STRIPPED_MIRRAGE_LOG, AlterniaBlocks.STRIPPED_MIRRAGE_WOOD);
		getOrCreateBuilder(AlterniaTags.Blocks.PLANKS).add(AlterniaBlocks.PYRAL_PLANKS, AlterniaBlocks.MIRRAGE_PLANKS);
		getOrCreateBuilder(AlterniaTags.Blocks.WOODEN_STAIRS).add(AlterniaBlocks.PYRAL_STAIRS, AlterniaBlocks.MIRRAGE_STAIRS);
		getOrCreateBuilder(AlterniaTags.Blocks.WOODEN_SLABS).add(AlterniaBlocks.PYRAL_SLAB, AlterniaBlocks.MIRRAGE_SLAB);
		getOrCreateBuilder(AlterniaTags.Blocks.WOODEN_FENCES).add(AlterniaBlocks.PYRAL_FENCE, AlterniaBlocks.MIRRAGE_FENCE);
		getOrCreateBuilder(AlterniaTags.Blocks.SAPLINGS).add(AlterniaBlocks.PYRAL_SAPLING, AlterniaBlocks.MIRRAGE_SAPLING);
		getOrCreateBuilder(AlterniaTags.Blocks.LEAVES).add(AlterniaBlocks.PYRAL_LEAVES, AlterniaBlocks.MIRRAGE_LEAVES);
		
		getOrCreateBuilder(AlterniaTags.Blocks.ALTERNIA_STONE).add(AlterniaBlocks.DARK_STONE, AlterniaBlocks.RED_ROCK);
	}
	
	@Override
	public String getName() {
		return "Alternia block tags provider";
	}
}