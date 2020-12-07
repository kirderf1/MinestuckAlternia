package com.apocfarce.minestuck_alternia.world.biome.layer;

import com.apocfarce.minestuck_alternia.world.biome.provider.AlterniaBiomeProvider;
import net.minecraft.util.WeightedRandom;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.INoiseRandom;
import net.minecraft.world.gen.layer.traits.IC0Transformer;
import net.minecraftforge.common.BiomeManager.BiomeEntry;
import net.minecraftforge.common.BiomeManager.BiomeType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

/**
 * Biome layer that converts biome types to biome ids based on the map in AlterniaBiomeProvider
 */
public class AlterniaBiomeLayer implements IC0Transformer {
	
	private static final Logger LOGGER = LogManager.getLogger();
	
	private final Registry<Biome> lookupRegistry;
	
	public AlterniaBiomeLayer(Registry<Biome> lookupRegistry) {
		this.lookupRegistry = lookupRegistry;
	}
	
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
		int id = lookupRegistry.getId(lookupRegistry.getValueForKey(entry.getKey()));
		if(id == -1) {
			LOGGER.error("Unable to find biome {}", entry.getKey());
			return 0;
		} else return id;
	}
}