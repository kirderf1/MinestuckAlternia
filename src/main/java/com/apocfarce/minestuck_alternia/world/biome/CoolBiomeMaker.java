package com.apocfarce.minestuck_alternia.world.biome;

import com.apocfarce.minestuck_alternia.world.gen.feature.structure.AlterniaStructures;
import net.minecraft.world.biome.*;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;

public class CoolBiomeMaker {
	
	public static Biome makePyralWoods() {
		MobSpawnInfo.Builder mobSpawns = new MobSpawnInfo.Builder();
		
		BiomeGenBuilder genSettings = new BiomeGenBuilder();
		genSettings.withSurfaceBuilder(SurfaceBuilder.DEFAULT.func_242929_a(SurfaceBuilder.GRASS_DIRT_SAND_CONFIG));
		
		genSettings.withStructure(() -> AlterniaStructures.PYRAL_MID_HIGHBLOOD_HIVE);
		
		AlterniaBiomeFeatures.withCarvers(genSettings);
		DefaultBiomeFeatures.withLavaAndWaterLakes(genSettings);
		DefaultBiomeFeatures.withMonsterRoom(genSettings);
		AlterniaBiomeFeatures.withStoneVariants(genSettings);
		AlterniaBiomeFeatures.withOres(genSettings);
		DefaultBiomeFeatures.withDisks(genSettings);
		
		AlterniaBiomeFeatures.withPyralTrees(genSettings);
		AlterniaBiomeFeatures.withPyralGrass(genSettings);
		
		DefaultBiomeFeatures.withDefaultFlowers(genSettings);
		DefaultBiomeFeatures.withJungleGrass(genSettings);
		DefaultBiomeFeatures.withNormalMushroomGeneration(genSettings);
		DefaultBiomeFeatures.withLavaAndWaterSprings(genSettings);
		DefaultBiomeFeatures.withFrozenTopLayer(genSettings);
		
		BiomeAmbience.Builder ambience = new BiomeAmbience.Builder();
		ambience.setWaterColor(0x113355).setWaterFogColor(0x115588);
		ambience.withFoliageColor(0xAA55EE).withGrassColor(0x004455);
		ambience.withSkyColor(0x7CA3FF).setFogColor(0xC0D8FF).setMoodSound(MoodSoundAmbience.DEFAULT_CAVE);
		
		return new Biome.Builder().precipitation(Biome.RainType.RAIN).category(Biome.Category.FOREST).depth(0.2F).scale(0.2F)
				.temperature(0.25F).downfall(0.8F).setEffects(ambience.build()).withMobSpawnSettings(mobSpawns.copy()).withGenerationSettings(genSettings.build()).build();
	}
	
	public static Biome makeMixedWoods() {
		MobSpawnInfo.Builder mobSpawns = new MobSpawnInfo.Builder();
		
		BiomeGenBuilder genSettings = new BiomeGenBuilder();
		genSettings.withSurfaceBuilder(SurfaceBuilder.DEFAULT.func_242929_a(SurfaceBuilder.GRASS_DIRT_SAND_CONFIG));
		
		genSettings.withStructure(() -> AlterniaStructures.MIXED_MID_HIGHBLOOD_HIVE);
		
		AlterniaBiomeFeatures.withCarvers(genSettings);
		DefaultBiomeFeatures.withLavaAndWaterLakes(genSettings);
		DefaultBiomeFeatures.withMonsterRoom(genSettings);
		AlterniaBiomeFeatures.withStoneVariants(genSettings);
		AlterniaBiomeFeatures.withOres(genSettings);
		DefaultBiomeFeatures.withDisks(genSettings);
		
		AlterniaBiomeFeatures.withPyralTrees(genSettings);
		AlterniaBiomeFeatures.withMirrageTrees(genSettings);
		AlterniaBiomeFeatures.withPyralGrass(genSettings);
		
		DefaultBiomeFeatures.withDefaultFlowers(genSettings);
		DefaultBiomeFeatures.withJungleGrass(genSettings);
		DefaultBiomeFeatures.withNormalMushroomGeneration(genSettings);
		DefaultBiomeFeatures.withLavaAndWaterSprings(genSettings);
		DefaultBiomeFeatures.withFrozenTopLayer(genSettings);
		
		BiomeAmbience.Builder ambience = new BiomeAmbience.Builder();
		ambience.setWaterColor(0x113355).setWaterFogColor(0x115588);
		ambience.withFoliageColor(0xAA55EE).withGrassColor(0x004455);
		ambience.withSkyColor(0x7CA3FF).setFogColor(0xC0D8FF).setMoodSound(MoodSoundAmbience.DEFAULT_CAVE);
		
		return new Biome.Builder().precipitation(Biome.RainType.RAIN).category(Biome.Category.FOREST).depth(0.2F).scale(0.2F)
				.temperature(0.25F).downfall(0.8F).setEffects(ambience.build()).withMobSpawnSettings(mobSpawns.copy()).withGenerationSettings(genSettings.build()).build();
	}
	
	public static Biome makeMirrageWoods() {
		MobSpawnInfo.Builder mobSpawns = new MobSpawnInfo.Builder();
		
		BiomeGenBuilder genSettings = new BiomeGenBuilder();
		genSettings.withSurfaceBuilder(SurfaceBuilder.DEFAULT.func_242929_a(SurfaceBuilder.GRASS_DIRT_SAND_CONFIG));
		
		genSettings.withStructure(() -> AlterniaStructures.MID_LOWBLOOD_HIVE);
		
		AlterniaBiomeFeatures.withCarvers(genSettings);
		DefaultBiomeFeatures.withLavaAndWaterLakes(genSettings);
		DefaultBiomeFeatures.withMonsterRoom(genSettings);
		AlterniaBiomeFeatures.withStoneVariants(genSettings);
		AlterniaBiomeFeatures.withOres(genSettings);
		DefaultBiomeFeatures.withDisks(genSettings);
		
		AlterniaBiomeFeatures.withMirrageTrees(genSettings);
		
		DefaultBiomeFeatures.withDefaultFlowers(genSettings);
		DefaultBiomeFeatures.withJungleGrass(genSettings);
		DefaultBiomeFeatures.withNormalMushroomGeneration(genSettings);
		DefaultBiomeFeatures.withLavaAndWaterSprings(genSettings);
		DefaultBiomeFeatures.withFrozenTopLayer(genSettings);
		
		BiomeAmbience.Builder ambience = new BiomeAmbience.Builder();
		ambience.setWaterColor(0x113355).setWaterFogColor(0x115588);
		ambience.withFoliageColor(0x666666).withGrassColor(0x666666);
		ambience.withSkyColor(0x7CA3FF).setFogColor(0xC0D8FF).setMoodSound(MoodSoundAmbience.DEFAULT_CAVE);
		
		return new Biome.Builder().precipitation(Biome.RainType.RAIN).category(Biome.Category.FOREST).depth(0.2F).scale(0.2F)
				.temperature(0.25F).downfall(0.8F).setEffects(ambience.build()).withMobSpawnSettings(mobSpawns.copy()).withGenerationSettings(genSettings.build()).build();
	}
}