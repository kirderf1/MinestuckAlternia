package com.apocfarce.minestuck_alternia;

import com.apocfarce.minestuck_alternia.block.AlterniaBlocks;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;


public class ClientProxy {
	
	static void setupBlockRenderLayers() {
		for(Block glass : AlterniaBlocks.hiveGlass) {
			if(glass != null)	//Apparently the array has a free spot for mutant-color, which isn't used.
				RenderTypeLookup.setRenderLayer(glass, RenderType.getTranslucent());
		}
	}
}