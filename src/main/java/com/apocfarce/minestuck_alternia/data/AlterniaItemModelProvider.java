package com.apocfarce.minestuck_alternia.data;

import com.apocfarce.minestuck_alternia.Item.AlterniaItems;
import com.apocfarce.minestuck_alternia.MinestuckAlternia;
import net.minecraft.data.DataGenerator;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

@SuppressWarnings("ConstantConditions")
public class AlterniaItemModelProvider extends ItemModelProvider {
	
	public AlterniaItemModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
		super(generator, MinestuckAlternia.MOD_ID, existingFileHelper);
	}
	
	@Override
	protected void registerModels() {
		simpleTexture(AlterniaItems.PORTAL_CENTER);
		simpleTexture(AlterniaItems.PORTAL_BASE);
		simpleTexture(AlterniaItems.PORTAL_CROWN);
		simpleTexture(AlterniaItems.RED_SNAKE);
		simpleTexture(AlterniaItems.GREEN_SNAKE);
		
		simpleTexture(AlterniaItems.CHERUB_KEY);
		
		simpleTexture(AlterniaItems.BURGUNDY_BLOOD_BOTTLE);
		simpleTexture(AlterniaItems.BRONZE_BLOOD_BOTTLE);
		simpleTexture(AlterniaItems.GOLD_BLOOD_BOTTLE);
		simpleTexture(AlterniaItems.OLIVE_BLOOD_BOTTLE);
		simpleTexture(AlterniaItems.JADE_BLOOD_BOTTLE);
		simpleTexture(AlterniaItems.TEAL_BLOOD_BOTTLE);
		simpleTexture(AlterniaItems.CERULEAN_BLOOD_BOTTLE);
		simpleTexture(AlterniaItems.INDIGO_BLOOD_BOTTLE);
		simpleTexture(AlterniaItems.PURPLE_BLOOD_BOTTLE);
		simpleTexture(AlterniaItems.VIOLET_BLOOD_BOTTLE);
		simpleTexture(AlterniaItems.FUCHSIA_BLOOD_BOTTLE);
		simpleTexture(AlterniaItems.LIME_BLOOD_BOTTLE);
		simpleTexture(AlterniaItems.MUTANT_BLOOD_BOTTLE);
	}
	
	protected ResourceLocation itemTexture(Item item) {
		ResourceLocation name = item.getRegistryName();
		return new ResourceLocation(name.getNamespace(), ITEM_FOLDER + "/" + name.getPath());
	}
	
	protected void simpleTexture(Item item) {
		singleTexture(item.getRegistryName().getPath(), mcLoc("item/generated"), "layer0", itemTexture(item));
	}
	
	protected void simpleHandheld(Item item) {
		singleTexture(item.getRegistryName().getPath(), mcLoc("item/handheld"), "layer0", itemTexture(item));
	}
}