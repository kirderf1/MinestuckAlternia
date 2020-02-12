package com.apocfarce.minestuck_alternia.world.biome;

import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.BlockBlobConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.placement.ChanceRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;

public class AlterniaTestBiome extends Biome {

	protected AlterniaTestBiome() {
		super(new Biome.Builder()
				.surfaceBuilder(SurfaceBuilder.SWAMP,SurfaceBuilder.GRASS_DIRT_SAND_CONFIG)
				.precipitation(Biome.RainType.RAIN)
				.category(Biome.Category.SWAMP)
				.temperature(0.5F)
				.depth(2.0F)
				.scale(0.0F)
				.temperature(0.5F)
				.downfall(1.0F)
				.waterColor(0xFF6600)
				.waterFogColor(0x993300)
				.parent((String)null)
				);
		//structures
		addStructure(Feature.SWAMP_HUT, IFeatureConfig.NO_FEATURE_CONFIG);
		//defaults
		DefaultBiomeFeatures.addForestTrees(this);
		//non default Fetures
		addFeature(GenerationStage.Decoration.SURFACE_STRUCTURES, createDecoratedFeature(Feature.DESERT_WELL, IFeatureConfig.NO_FEATURE_CONFIG , Placement.CHANCE_RANGE, new ChanceRangeConfig(8, 2, 64, 255)));
		addFeature(GenerationStage.Decoration.SURFACE_STRUCTURES, createDecoratedFeature(Feature.FOREST_ROCK, new BlockBlobConfig(Blocks.GRASS_BLOCK.getDefaultState(), 3)  , Placement.CHANCE_RANGE, new ChanceRangeConfig(8, 5, 64, 255)));
		//spawns
	    this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.EVOKER, 10, 2, 10));
		
		
	}

}
