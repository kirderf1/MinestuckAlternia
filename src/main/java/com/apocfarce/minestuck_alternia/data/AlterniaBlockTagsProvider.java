package com.apocfarce.minestuck_alternia.data;

import com.apocfarce.minestuck_alternia.Utils.AlterniaTags;
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
		
		getBuilder(AlterniaTags.Blocks.PYRAL_LOGS).add(AlterniaBlocks.pyralLog, AlterniaBlocks.pyralWood, AlterniaBlocks.strippedPyralLog, AlterniaBlocks.strippedPyralWood);
		getBuilder(AlterniaTags.Blocks.MIRRAGE_LOGS).add(AlterniaBlocks.mirrageLog, AlterniaBlocks.mirrageWood, AlterniaBlocks.strippedmirrageLog, AlterniaBlocks.strippedmirrageWood);
		getBuilder(AlterniaTags.Blocks.LEAVES).add(AlterniaBlocks.pyralLeaves, AlterniaBlocks.mirrageLeaves);
		getBuilder(AlterniaTags.Blocks.FENCES).add(AlterniaBlocks.pyralFence, AlterniaBlocks.mirrageFence);
	}
	
	@Override
	public String getName() {
		return "Alternia block tags provider";
	}
}