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
		
		RenderTypeLookup.setRenderLayer(AlterniaBlocks.pyralLeaves, RenderType.getCutoutMipped());
		RenderTypeLookup.setRenderLayer(AlterniaBlocks.mirrageLeaves, RenderType.getCutoutMipped());
		RenderTypeLookup.setRenderLayer(AlterniaBlocks.pyralSapling, RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(AlterniaBlocks.mirrageSapling, RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(AlterniaBlocks.pyralGrass, RenderType.getCutout());
		
		for(Block glass : AlterniaBlocks.hiveGlass) {
			if(glass != null)	//Apparently the array has a free spot for mutant-color, which isn't used.
				RenderTypeLookup.setRenderLayer(glass, RenderType.getTranslucent());
		}
	}
}