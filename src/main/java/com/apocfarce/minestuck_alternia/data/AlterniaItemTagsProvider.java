package com.apocfarce.minestuck_alternia.data;

import com.apocfarce.minestuck_alternia.Item.AlterniaItems;
import com.apocfarce.minestuck_alternia.MinestuckAlternia;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraftforge.common.data.ExistingFileHelper;

import javax.annotation.Nullable;

public class AlterniaItemTagsProvider extends ItemTagsProvider {
	
	public AlterniaItemTagsProvider(DataGenerator dataGenerator, BlockTagsProvider blockTagProvider, @Nullable ExistingFileHelper existingFileHelper) {
		super(dataGenerator, blockTagProvider, MinestuckAlternia.MOD_ID, existingFileHelper);
	}
	
	@Override
	protected void registerTags() {
		getOrCreateBuilder(ItemTags.STONE_TOOL_MATERIALS).add(AlterniaItems.DARK_COBBLE, AlterniaItems.RED_COBBLE);
		getOrCreateBuilder(ItemTags.STONE_CRAFTING_MATERIALS).add(AlterniaItems.DARK_COBBLE, AlterniaItems.RED_COBBLE);
	}
}