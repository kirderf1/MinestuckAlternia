package com.apocfarce.minestuck_alternia.world.biome;

import com.apocfarce.minestuck_alternia.world.gen.carver.AlterniaCarvers;
import com.apocfarce.minestuck_alternia.world.gen.feature.AlterniaFeatures;
import net.minecraft.world.biome.BiomeGenerationSettings;
import net.minecraft.world.gen.GenerationStage;

/**
 * A helper class for configuring alternia-specific world features
 * @author kirderf1
 */
public class AlterniaBiomeFeatures {
	
	public static void withCarvers(BiomeGenerationSettings.Builder builder) {
		builder.withCarver(GenerationStage.Carving.AIR, AlterniaCarvers.CONFIGURED_CAVE);
		builder.withCarver(GenerationStage.Carving.AIR, AlterniaCarvers.CONFIGURED_CANYON);
	}
	
	public static void withOres(BiomeGenerationSettings.Builder builder) {
		builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, AlterniaFeatures.COAL_ORE);
		builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, AlterniaFeatures.IRON_ORE);
		builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, AlterniaFeatures.GOLD_ORE);
		builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, AlterniaFeatures.REDSTONE_ORE);
		builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, AlterniaFeatures.DIAMOND_ORE);
		builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, AlterniaFeatures.LAPIS_ORE);
	}
	
	public static void withStoneVariants(BiomeGenerationSettings.Builder builder) {
		builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, AlterniaFeatures.RED_ROCK_ORE);
	}
	
	public static void withPyralTrees(BiomeGenerationSettings.Builder builder) {
		builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, AlterniaFeatures.PYRAL_TREES);
	}
	
	public static void withMirrageTrees(BiomeGenerationSettings.Builder builder) {
		builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, AlterniaFeatures.MIRRAGE_TREES);
	}
	
	public static void withPyralGrass(BiomeGenerationSettings.Builder builder) {
		builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, AlterniaFeatures.PYRAL_GRASS);
	}
}