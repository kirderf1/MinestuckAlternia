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
		getOrCreateBuilder(BlockTags.LOGS).addTags(AlterniaTags.Blocks.PYRAL_LOGS, AlterniaTags.Blocks.MIRRAGE_LOGS);
		getOrCreateBuilder(BlockTags.LEAVES).addTags(AlterniaTags.Blocks.LEAVES);
		getOrCreateBuilder(BlockTags.FENCES).addTags(AlterniaTags.Blocks.FENCES);
		getOrCreateBuilder(BlockTags.GOLD_ORES).add(AlterniaBlocks.DARK_STONE_GOLD_ORE);
		getOrCreateBuilder(Tags.Blocks.ORES_COAL).add(AlterniaBlocks.DARK_STONE_COAL_ORE);
		getOrCreateBuilder(Tags.Blocks.ORES_IRON).add(AlterniaBlocks.DARK_STONE_IRON_ORE);
		getOrCreateBuilder(Tags.Blocks.ORES_REDSTONE).add(AlterniaBlocks.DARK_STONE_REDSTONE_ORE);
		getOrCreateBuilder(Tags.Blocks.ORES_DIAMOND).add(AlterniaBlocks.DARK_STONE_DIAMOND_ORE);
		getOrCreateBuilder(Tags.Blocks.ORES_LAPIS).add(AlterniaBlocks.DARK_STONE_LAPIS_ORE);
		
		getOrCreateBuilder(AlterniaTags.Blocks.PYRAL_LOGS).add(AlterniaBlocks.PYRAL_LOG, AlterniaBlocks.PYRAL_WOOD, AlterniaBlocks.STRIPPED_PYRAL_LOG, AlterniaBlocks.STRIPPED_PYRAL_WOOD);
		getOrCreateBuilder(AlterniaTags.Blocks.MIRRAGE_LOGS).add(AlterniaBlocks.MIRRAGE_LOG, AlterniaBlocks.MIRRAGE_WOOD, AlterniaBlocks.STRIPPED_MIRRAGE_LOG, AlterniaBlocks.STRIPPED_MIRRAGE_WOOD);
		getOrCreateBuilder(AlterniaTags.Blocks.LEAVES).add(AlterniaBlocks.PYRAL_LEAVES, AlterniaBlocks.MIRRAGE_LEAVES);
		getOrCreateBuilder(AlterniaTags.Blocks.FENCES).add(AlterniaBlocks.PYRAL_FENCE, AlterniaBlocks.MIRRAGE_FENCE);
	}
	
	@Override
	public String getName() {
		return "Alternia block tags provider";
	}
}