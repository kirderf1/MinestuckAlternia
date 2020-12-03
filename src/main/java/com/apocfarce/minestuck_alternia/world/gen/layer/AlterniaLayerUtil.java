package com.apocfarce.minestuck_alternia.world.gen.layer;

import net.minecraft.world.gen.IExtendedNoiseRandom;
import net.minecraft.world.gen.LazyAreaLayerContext;
import net.minecraft.world.gen.area.IArea;
import net.minecraft.world.gen.area.IAreaFactory;
import net.minecraft.world.gen.area.LazyArea;
import net.minecraft.world.gen.layer.EdgeLayer;
import net.minecraft.world.gen.layer.Layer;
import net.minecraft.world.gen.layer.LayerUtil;
import net.minecraft.world.gen.layer.ZoomLayer;

import java.util.function.LongFunction;

public class AlterniaLayerUtil extends LayerUtil {

	public static <T extends IArea, C extends IExtendedNoiseRandom<T>> IAreaFactory<T> buildAlterniaProcedure(LongFunction<C> contextFactory) {
		//During these layers, the value represents a biome type (0:ocean1: desert, 2: warm, 3: cool, 4: icy)
		IAreaFactory<T> layerStack = AlterniaHeatMapLayer.INSTANCE.apply(contextFactory.apply(1L));
		//layer that turns desert into warm if near cool or icy
		layerStack = EdgeLayer.CoolWarm.INSTANCE.apply(contextFactory.apply(2L), layerStack);
		//layer that turns icy into cool if near warm or desert
		layerStack = EdgeLayer.HeatIce.INSTANCE.apply(contextFactory.apply(2L), layerStack);
		
		//Replaces biome types with biomes in the respective categories
		layerStack = AlterniaBiomeLayer.INSTANCE.apply(contextFactory.apply(200L), layerStack);
		
		//i'll eventually want to do something with Oceans to spawn violet, and fucia hives in
		//layerStack = AlterniaOceanLayer.INSTANCE.apply(contextFactory.apply(200L),layerStack);
				
		layerStack = ZoomLayer.NORMAL.apply(contextFactory.apply(2002L), layerStack);
		layerStack = ZoomLayer.NORMAL.apply(contextFactory.apply(2003L), layerStack);
		
		//replicate biome size
		int biomeSize = 4;
		
		//add zoom layers to expand the size of the biomes
		for(int zoomIndex = 0; zoomIndex < biomeSize; ++zoomIndex)
			layerStack = ZoomLayer.NORMAL.apply(contextFactory.apply(1000 + zoomIndex), layerStack);

		return layerStack;
	}

	public static Layer buildAlterniaProcedure(long seed) {
	
		IAreaFactory<LazyArea> areaFactory = buildAlterniaProcedure(seedModifier -> new LazyAreaLayerContext(25, seed, seedModifier));
		return new Layer(areaFactory);
	}
}