package com.apocfarce.minestuck_alternia.data;

import com.apocfarce.minestuck_alternia.Item.AlterniaItems;
import com.apocfarce.minestuck_alternia.Minestuck_alternia;
import com.apocfarce.minestuck_alternia.block.AlterniaBlocks;
import net.minecraft.block.Block;
import net.minecraft.data.DataGenerator;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.generators.ExistingFileHelper;
import net.minecraftforge.client.model.generators.ItemModelProvider;

@SuppressWarnings("ConstantConditions")
public class AlterniaItemModelProvider extends ItemModelProvider {
	
	public AlterniaItemModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
		super(generator, Minestuck_alternia.MOD_ID, existingFileHelper);
	}
	
	@Override
	protected void registerModels() {
		simpleTexture(AlterniaBlocks.portalCenter.asItem());
		simpleTexture(AlterniaBlocks.portalBase.asItem());
		simpleTexture(AlterniaBlocks.portalCrown.asItem());
		simpleTexture(AlterniaBlocks.redSnake.asItem());
		simpleTexture(AlterniaBlocks.greenSnake.asItem());
		
		simpleTexture(AlterniaItems.cherubKey);
		
		for(Item potion : AlterniaItems.bloodPotions) {
			if(potion != null)
				simpleTexture(potion);
		}
		
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