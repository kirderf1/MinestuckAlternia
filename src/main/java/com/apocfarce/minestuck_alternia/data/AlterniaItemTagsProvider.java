package com.apocfarce.minestuck_alternia.data;

import com.apocfarce.minestuck_alternia.Item.AlterniaItems;
import com.apocfarce.minestuck_alternia.MinestuckAlternia;
import com.apocfarce.minestuck_alternia.util.AlterniaTags;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.ItemTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;

import javax.annotation.Nullable;

public class AlterniaItemTagsProvider extends ItemTagsProvider {
	
	public AlterniaItemTagsProvider(DataGenerator dataGenerator, BlockTagsProvider blockTagProvider, @Nullable ExistingFileHelper existingFileHelper) {
		super(dataGenerator, blockTagProvider, MinestuckAlternia.MOD_ID, existingFileHelper);
	}
	
	@Override
	protected void registerTags() {
		copy(BlockTags.LOGS_THAT_BURN, ItemTags.LOGS_THAT_BURN);
		copy(BlockTags.PLANKS, ItemTags.PLANKS);
		copy(BlockTags.WOODEN_STAIRS, ItemTags.WOODEN_STAIRS);
		copy(BlockTags.WOODEN_SLABS, ItemTags.WOODEN_SLABS);
		copy(BlockTags.WOODEN_FENCES, ItemTags.WOODEN_FENCES);
		copy(BlockTags.SAPLINGS, ItemTags.SAPLINGS);
		copy(BlockTags.LEAVES, ItemTags.LEAVES);
		
		copy(Tags.Blocks.STONE, Tags.Items.STONE);
		copy(Tags.Blocks.COBBLESTONE, Tags.Items.COBBLESTONE);
		copy(BlockTags.GOLD_ORES, ItemTags.GOLD_ORES);
		copy(Tags.Blocks.ORES_COAL, Tags.Items.ORES_COAL);
		copy(Tags.Blocks.ORES_IRON, Tags.Items.ORES_IRON);
		copy(Tags.Blocks.ORES_REDSTONE, Tags.Items.ORES_REDSTONE);
		copy(Tags.Blocks.ORES_DIAMOND, Tags.Items.ORES_DIAMOND);
		copy(Tags.Blocks.ORES_LAPIS, Tags.Items.ORES_LAPIS);
		
		copy(AlterniaTags.Blocks.PYRAL_LOGS, AlterniaTags.Items.PYRAL_LOGS);
		copy(AlterniaTags.Blocks.MIRRAGE_LOGS, AlterniaTags.Items.MIRRAGE_LOGS);
		copy(AlterniaTags.Blocks.PLANKS, AlterniaTags.Items.PLANKS);
		copy(AlterniaTags.Blocks.WOODEN_STAIRS, AlterniaTags.Items.WOODEN_STAIRS);
		copy(AlterniaTags.Blocks.WOODEN_SLABS, AlterniaTags.Items.WOODEN_SLABS);
		copy(AlterniaTags.Blocks.WOODEN_FENCES, AlterniaTags.Items.WOODEN_FENCES);
		copy(AlterniaTags.Blocks.SAPLINGS, AlterniaTags.Items.SAPLINGS);
		copy(AlterniaTags.Blocks.LEAVES, AlterniaTags.Items.LEAVES);
		
		getOrCreateBuilder(ItemTags.STONE_TOOL_MATERIALS).add(AlterniaItems.DARK_COBBLE, AlterniaItems.RED_COBBLE);
		getOrCreateBuilder(ItemTags.STONE_CRAFTING_MATERIALS).add(AlterniaItems.DARK_COBBLE, AlterniaItems.RED_COBBLE);
	}
}