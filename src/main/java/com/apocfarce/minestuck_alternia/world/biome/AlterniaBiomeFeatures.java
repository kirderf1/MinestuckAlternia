package com.apocfarce.minestuck_alternia.world.biome;

import com.apocfarce.minestuck_alternia.world.gen.carver.AlterniaCarvers;
import com.apocfarce.minestuck_alternia.world.gen.feature.AlterniaFeatures;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeGenerationSettings;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.ProbabilityConfig;

/**
 * A helper class for configuring alternia-specific world features
 * @author kirderf1
 */
public class AlterniaBiomeFeatures {
	
	public static void addCarvers(Biome biome) {
		biome.addCarver(GenerationStage.Carving.AIR, Biome.createCarver(AlterniaCarvers.ALTERNIA_CAVES.get(), new ProbabilityConfig(1/7F)));
		biome.addCarver(GenerationStage.Carving.AIR, Biome.createCarver(AlterniaCarvers.ALTERNIA_CANYONS.get(), new ProbabilityConfig(1/50F)));
	}
	
	public static void addOres(BiomeGenerationSettings.Builder builder) {
		builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, AlterniaFeatures.COAL_ORE);
		builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, AlterniaFeatures.IRON_ORE);
		builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, AlterniaFeatures.GOLD_ORE);
		builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, AlterniaFeatures.REDSTONE_ORE);
		builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, AlterniaFeatures.DIAMOND_ORE);
		builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, AlterniaFeatures.LAPIS_ORE);
	}
	
	public static void addStoneVariants(BiomeGenerationSettings.Builder builder) {
		builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, AlterniaFeatures.RED_ROCK_ORE);
	}
	
	public static void addPyralTrees(BiomeGenerationSettings.Builder builder) {
		builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, AlterniaFeatures.PYRAL_TREES);
	}
	
	public static void addMirrageTrees(BiomeGenerationSettings.Builder builder) {
		builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, AlterniaFeatures.MIRRAGE_TREES);
	}
	
	public static void addPyralGrass(BiomeGenerationSettings.Builder builder) {
		builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, AlterniaFeatures.PYRAL_GRASS);
	}
}