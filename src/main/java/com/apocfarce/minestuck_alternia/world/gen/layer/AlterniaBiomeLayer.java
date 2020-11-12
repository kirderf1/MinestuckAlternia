package com.apocfarce.minestuck_alternia.world.gen.layer;

import com.apocfarce.minestuck_alternia.world.biome.provider.AlterniaBiomeProvider;
import com.google.common.collect.ImmutableList;

import net.minecraft.util.WeightedRandom;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.INoiseRandom;
import net.minecraft.world.gen.OverworldGenSettings;
import net.minecraft.world.gen.layer.traits.IC0Transformer;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeManager.BiomeEntry;
import net.minecraftforge.common.BiomeManager.BiomeType;

import java.util.ArrayList;
import java.util.List;

/**
 * Biome layer that converts biome types to biome ids based on the map in AlterniaBiomeProvider
 */
public enum AlterniaBiomeLayer implements IC0Transformer {
	INSTANCE;
	
	public int apply(INoiseRandom context, int value) {
		switch (value) {
			case 1:
				return Registry.BIOME.getId(getWeightedBiomeEntry(BiomeType.DESERT, context).biome);
			case 2:
				return Registry.BIOME.getId(getWeightedBiomeEntry(BiomeType.WARM, context).biome);
			case 3:
				return Registry.BIOME.getId(getWeightedBiomeEntry(BiomeType.COOL, context).biome);
			case 4:
				return Registry.BIOME.getId(getWeightedBiomeEntry(BiomeType.ICY, context).biome);
		}
		throw new IllegalStateException("Got unexpected biome layer value: " + value);
	}
	
	protected BiomeEntry getWeightedBiomeEntry(BiomeType type, INoiseRandom context) {
		List<BiomeEntry> biomeList = AlterniaBiomeProvider.getBiomes(type);
		int totalWeight = WeightedRandom.getTotalWeight(biomeList);
		int weight = context.random(totalWeight);
		return WeightedRandom.getRandomItem(biomeList, weight);
	}
}