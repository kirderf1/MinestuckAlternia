package com.apocfarce.minestuck_alternia.world.biome;

import com.google.common.collect.Lists;
import net.minecraft.world.biome.BiomeGenerationSettings;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.carver.ConfiguredCarver;
import net.minecraft.world.gen.feature.StructureFeature;

import java.util.function.Supplier;

public class BiomeGenBuilder extends BiomeGenerationSettings.Builder {
	
	public BiomeGenBuilder withCarver(GenerationStage.Carving carvingStage, Supplier<ConfiguredCarver<?>> carver) {
		carvers.computeIfAbsent(carvingStage, carving -> Lists.newArrayList()).add(carver);
		return this;
	}
	
	public BiomeGenBuilder withStructure(Supplier<StructureFeature<?, ?>> structure) {
		structures.add(structure);
		return this;
	}
}