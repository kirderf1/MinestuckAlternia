package com.apocfarce.minestuck_alternia.world.biome.layer;

import com.apocfarce.minestuck_alternia.world.biome.provider.AlterniaBiomeProvider;
import net.minecraft.util.WeightedRandom;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.INoiseRandom;
import net.minecraft.world.gen.layer.traits.IC0Transformer;
import net.minecraftforge.common.BiomeManager.BiomeEntry;
import net.minecraftforge.common.BiomeManager.BiomeType;

import java.util.List;

/**
 * Biome layer that converts biome types to biome ids based on the map in AlterniaBiomeProvider
 */
public enum AlterniaBiomeLayer implements IC0Transformer {
	INSTANCE;
	
	public int apply(INoiseRandom context, int value) {
		switch (value) {
			case 0:
				return 0; // ocean biome id
			case 1:
				return getWeightedBiomeEntry(BiomeType.DESERT, context);
			case 2:
				return getWeightedBiomeEntry(BiomeType.WARM, context);
			case 3:
				return getWeightedBiomeEntry(BiomeType.COOL, context);
			/*case 4:
				return getWeightedBiomeEntry(BiomeType.ICY, context);*/
		}
		throw new IllegalStateException("Got unexpected biome layer value: " + value);
	}
	
	protected int getWeightedBiomeEntry(BiomeType type, INoiseRandom context) {
		List<BiomeEntry> biomeList = AlterniaBiomeProvider.getBiomes(type);
		int totalWeight = WeightedRandom.getTotalWeight(biomeList);
		int weight = context.random(totalWeight);
		BiomeEntry entry = WeightedRandom.getRandomItem(biomeList, weight);
		return WorldGenRegistries.BIOME.getId(WorldGenRegistries.BIOME.getValueForKey(entry.getKey()));
	}
}