package com.apocfarce.minestuck_alternia;

import com.apocfarce.minestuck_alternia.block.AlterniaBlocks;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;

/**
 * Handles any client-side registering, such as setting render layers
 * @author kirderf1
 */
public class ClientProxy {
	
	/**
	 * Sets render layers for alternia blocks, which informs minecraft of blocks that has cutout or tansparent textures
	 */
	static void setupBlockRenderLayers() {
		
		RenderTypeLookup.setRenderLayer(AlterniaBlocks.PYRAL_LEAVES, RenderType.getCutoutMipped());
		RenderTypeLookup.setRenderLayer(AlterniaBlocks.MIRRAGE_LEAVES, RenderType.getCutoutMipped());
		RenderTypeLookup.setRenderLayer(AlterniaBlocks.PYRAL_SAPLING, RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(AlterniaBlocks.MIRRAGE_SAPLING, RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(AlterniaBlocks.PYRAL_GRASS, RenderType.getCutout());
		
		RenderTypeLookup.setRenderLayer(AlterniaBlocks.BURGUNDY_HIVE_GLASS, RenderType.getTranslucent());
		RenderTypeLookup.setRenderLayer(AlterniaBlocks.BRONZE_HIVE_GLASS, RenderType.getTranslucent());
		RenderTypeLookup.setRenderLayer(AlterniaBlocks.GOLD_HIVE_GLASS, RenderType.getTranslucent());
		RenderTypeLookup.setRenderLayer(AlterniaBlocks.OLIVE_HIVE_GLASS, RenderType.getTranslucent());
		RenderTypeLookup.setRenderLayer(AlterniaBlocks.JADE_HIVE_GLASS, RenderType.getTranslucent());
		RenderTypeLookup.setRenderLayer(AlterniaBlocks.TEAL_HIVE_GLASS, RenderType.getTranslucent());
		RenderTypeLookup.setRenderLayer(AlterniaBlocks.CERULEAN_HIVE_GLASS, RenderType.getTranslucent());
		RenderTypeLookup.setRenderLayer(AlterniaBlocks.INDIGO_HIVE_GLASS, RenderType.getTranslucent());
		RenderTypeLookup.setRenderLayer(AlterniaBlocks.PURPLE_HIVE_GLASS, RenderType.getTranslucent());
		RenderTypeLookup.setRenderLayer(AlterniaBlocks.VIOLET_HIVE_GLASS, RenderType.getTranslucent());
		RenderTypeLookup.setRenderLayer(AlterniaBlocks.FUCHSIA_HIVE_GLASS, RenderType.getTranslucent());
		RenderTypeLookup.setRenderLayer(AlterniaBlocks.LIME_HIVE_GLASS, RenderType.getTranslucent());
		RenderTypeLookup.setRenderLayer(AlterniaBlocks.GREY_HIVE_GLASS, RenderType.getTranslucent());
	}
}