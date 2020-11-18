package com.apocfarce.minestuck_alternia.data;

import com.apocfarce.minestuck_alternia.util.AlterniaTags;
import com.apocfarce.minestuck_alternia.block.AlterniaBlocks;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.tags.BlockTags;

public class AlterniaBlockTagsProvider extends BlockTagsProvider {
	
	public AlterniaBlockTagsProvider(DataGenerator generatorIn) {
		super(generatorIn);
	}
	
	@Override
	protected void registerTags() {
		getBuilder(BlockTags.LOGS).add(AlterniaTags.Blocks.PYRAL_LOGS, AlterniaTags.Blocks.MIRRAGE_LOGS);
		getBuilder(BlockTags.LEAVES).add(AlterniaTags.Blocks.LEAVES);
		getBuilder(BlockTags.FENCES).add(AlterniaTags.Blocks.FENCES);
		
		getBuilder(AlterniaTags.Blocks.PYRAL_LOGS).add(AlterniaBlocks.PYRAL_LOG, AlterniaBlocks.PYRAL_WOOD, AlterniaBlocks.STRIPPED_PYRAL_LOG, AlterniaBlocks.STRIPPED_PYRAL_WOOD);
		getBuilder(AlterniaTags.Blocks.MIRRAGE_LOGS).add(AlterniaBlocks.MIRRAGE_LOG, AlterniaBlocks.MIRRAGE_WOOD, AlterniaBlocks.STRIPPED_MIRRAGE_LOG, AlterniaBlocks.STRIPPED_MIRRAGE_WOOD);
		getBuilder(AlterniaTags.Blocks.LEAVES).add(AlterniaBlocks.PYRAL_LEAVES, AlterniaBlocks.MIRRAGE_LEAVES);
		getBuilder(AlterniaTags.Blocks.FENCES).add(AlterniaBlocks.PYRAL_FENCE, AlterniaBlocks.MIRRAGE_FENCE);
	}
	
	@Override
	public String getName() {
		return "Alternia block tags provider";
	}
}