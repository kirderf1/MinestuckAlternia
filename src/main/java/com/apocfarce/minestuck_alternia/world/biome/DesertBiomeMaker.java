package com.apocfarce.minestuck_alternia.world.biome;

import com.apocfarce.minestuck_alternia.world.gen.feature.structure.AlterniaStructures;
import com.apocfarce.minestuck_alternia.world.gen.surfacebuilder.AlterniaSurfaceBuilders;
import net.minecraft.world.biome.*;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;

public class DesertBiomeMaker {
	
	public static Biome makeRainbowDesert() {
		MobSpawnInfo.Builder mobSpawns = new MobSpawnInfo.Builder();
		
		BiomeGenerationSettings.Builder genSettings = new BiomeGenerationSettings.Builder()
				.withSurfaceBuilder(AlterniaSurfaceBuilders.COLORED_SANDS.get().func_242929_a(SurfaceBuilder.SAND_CONFIG));
		
		genSettings.withStructure(AlterniaStructures.HIGHBLOOD_HIVE);
		
		AlterniaBiomeFeatures.withCarvers(genSettings);
		DefaultBiomeFeatures.withMonsterRoom(genSettings);
		AlterniaBiomeFeatures.withStoneVariants(genSettings);
		AlterniaBiomeFeatures.withOres(genSettings);
		DefaultBiomeFeatures.withDisks(genSettings);
		
		DefaultBiomeFeatures.withDefaultFlowers(genSettings);
		DefaultBiomeFeatures.withJungleGrass(genSettings);
		DefaultBiomeFeatures.withNormalMushroomGeneration(genSettings);
		DefaultBiomeFeatures.withLavaAndWaterSprings(genSettings);
		DefaultBiomeFeatures.withFrozenTopLayer(genSettings);
		
		BiomeAmbience.Builder ambience = new BiomeAmbience.Builder();
		ambience.setWaterColor(0x113355).setWaterFogColor(0x115588);
		ambience.withFoliageColor(0x666666).withGrassColor(0x666666);
		ambience.withSkyColor(0x6DB1FF).setMoodSound(MoodSoundAmbience.DEFAULT_CAVE);
		
		return new Biome.Builder().precipitation(Biome.RainType.NONE).category(Biome.Category.DESERT).depth(0.125F).scale(0.05F)
				.temperature(2.0F).downfall(0.0F).setEffects(ambience.build()).withMobSpawnSettings(mobSpawns.copy()).withGenerationSettings(genSettings.build()).build();
	}
}