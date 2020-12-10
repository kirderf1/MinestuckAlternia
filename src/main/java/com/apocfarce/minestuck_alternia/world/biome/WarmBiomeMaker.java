package com.apocfarce.minestuck_alternia.world.biome;

import com.apocfarce.minestuck_alternia.world.gen.feature.structure.AlterniaStructures;
import com.apocfarce.minestuck_alternia.world.gen.surfacebuilder.AlterniaSurfaceBuilders;
import net.minecraft.world.biome.*;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;

public class WarmBiomeMaker {
	
	public static Biome makePlains() {
		MobSpawnInfo.Builder mobSpawns = new MobSpawnInfo.Builder();
		
		BiomeGenBuilder genSettings = new BiomeGenBuilder();
		genSettings.withSurfaceBuilder(SurfaceBuilder.DEFAULT.func_242929_a(SurfaceBuilder.GRASS_DIRT_SAND_CONFIG));
		
		DefaultBiomeFeatures.withStrongholdAndMineshaft(genSettings);
		
		genSettings.withStructure(() -> AlterniaStructures.LOWBLOOD_HIVE);
		
		AlterniaBiomeFeatures.withCarvers(genSettings);
		AlterniaBiomeFeatures.withLavaAndWaterLakes(genSettings);
		DefaultBiomeFeatures.withMonsterRoom(genSettings);
		DefaultBiomeFeatures.withNoiseTallGrass(genSettings);
		AlterniaBiomeFeatures.withStoneVariants(genSettings);
		AlterniaBiomeFeatures.withOres(genSettings);
		DefaultBiomeFeatures.withDisks(genSettings);
		
		DefaultBiomeFeatures.withPlainGrassVegetation(genSettings);
		DefaultBiomeFeatures.withNormalMushroomGeneration(genSettings);
		DefaultBiomeFeatures.withSugarCaneAndPumpkins(genSettings);
		DefaultBiomeFeatures.withLavaAndWaterSprings(genSettings);
		DefaultBiomeFeatures.withFrozenTopLayer(genSettings);
		
		BiomeAmbience.Builder ambience = new BiomeAmbience.Builder();
		ambience.setWaterColor(0x113355).setWaterFogColor(0x115588);
		ambience.withFoliageColor(0x9955DD).withGrassColor(0x004411);
		ambience.withSkyColor(0x77A7FF).setFogColor(0xC0D8FF).setMoodSound(MoodSoundAmbience.DEFAULT_CAVE);
		
		return new Biome.Builder().precipitation(Biome.RainType.RAIN).category(Biome.Category.PLAINS).depth(0.125F).scale(0.05F)
				.temperature(0.8F).downfall(0.4F).setEffects(ambience.build()).withMobSpawnSettings(mobSpawns.copy()).withGenerationSettings(genSettings.build()).build();
	}
	
	public static Biome makeVolcanicFields() {
		MobSpawnInfo.Builder mobSpawns = new MobSpawnInfo.Builder();
		
		BiomeGenBuilder genSettings = new BiomeGenBuilder();
		genSettings.withSurfaceBuilder(() -> AlterniaSurfaceBuilders.DARK_STONE.get().func_242929_a(SurfaceBuilder.CORASE_DIRT_DIRT_GRAVEL_CONFIG));
		
		DefaultBiomeFeatures.withStrongholdAndMineshaft(genSettings);
		
		genSettings.withStructure(() -> AlterniaStructures.HIGHBLOOD_HIVE);
		
		AlterniaBiomeFeatures.withCarvers(genSettings);
		DefaultBiomeFeatures.withMonsterRoom(genSettings);
		
		AlterniaBiomeFeatures.withExtraLavaLakes(genSettings);
		DefaultBiomeFeatures.withFrozenTopLayer(genSettings);
		
		BiomeAmbience.Builder ambience = new BiomeAmbience.Builder();
		ambience.setWaterColor(0x113355).setWaterFogColor(0x115588);
		ambience.withFoliageColor(0x9955DD).withGrassColor(0x004411);
		ambience.withSkyColor(0x77A7FF).setFogColor(0xC0D8FF).setMoodSound(MoodSoundAmbience.DEFAULT_CAVE);
		
		return new Biome.Builder().precipitation(Biome.RainType.RAIN).category(Biome.Category.MESA).depth(0.8F).scale(0.25F)
				.temperature(0.8F).downfall(0.4F).setEffects(ambience.build()).withMobSpawnSettings(mobSpawns.copy()).withGenerationSettings(genSettings.build()).build();
	}
	
	public static Biome makeShrublands() {
		MobSpawnInfo.Builder mobSpawns = new MobSpawnInfo.Builder();
		
		BiomeGenBuilder genSettings = new BiomeGenBuilder();
		genSettings.withSurfaceBuilder(SurfaceBuilder.DEFAULT.func_242929_a(SurfaceBuilder.CORASE_DIRT_DIRT_GRAVEL_CONFIG));
		
		DefaultBiomeFeatures.withStrongholdAndMineshaft(genSettings);
		
		genSettings.withStructure(() -> AlterniaStructures.LOWBLOOD_HIVE);
		
		AlterniaBiomeFeatures.withCarvers(genSettings);
		DefaultBiomeFeatures.withMonsterRoom(genSettings);
		AlterniaBiomeFeatures.withStoneVariants(genSettings);
		AlterniaBiomeFeatures.withOres(genSettings);
		
		DefaultBiomeFeatures.withDesertDeadBushes(genSettings);
		AlterniaBiomeFeatures.withLavaLakes(genSettings);
		DefaultBiomeFeatures.withBadlandsGrass(genSettings);
		
		DefaultBiomeFeatures.withFrozenTopLayer(genSettings);
		
		BiomeAmbience.Builder ambience = new BiomeAmbience.Builder();
		ambience.setWaterColor(0x113355).setWaterFogColor(0x115588);
		ambience.withFoliageColor(0x889933).withGrassColor(0x889944);
		ambience.withSkyColor(0x77A7FF).setFogColor(0xC0D8FF).setMoodSound(MoodSoundAmbience.DEFAULT_CAVE);
		
		return new Biome.Builder().precipitation(Biome.RainType.RAIN).category(Biome.Category.PLAINS).depth(0.125F).scale(0.05F)
				.temperature(0.8F).downfall(0.4F).setEffects(ambience.build()).withMobSpawnSettings(mobSpawns.copy()).withGenerationSettings(genSettings.build()).build();
	}
}