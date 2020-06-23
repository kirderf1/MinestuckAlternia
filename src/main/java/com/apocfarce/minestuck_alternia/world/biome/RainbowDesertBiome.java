package com.apocfarce.minestuck_alternia.world.biome;

import com.apocfarce.minestuck_alternia.block.AlterniaBlocks;
import com.apocfarce.minestuck_alternia.world.gen.feature.AlterniaFeatureHandeler;
import com.apocfarce.minestuck_alternia.world.gen.surfacebuilder.SurfaceBuilderHandeler;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.GrassFeatureConfig;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.MultipleRandomFeatureConfig;
import net.minecraft.world.gen.placement.AtSurfaceWithExtraConfig;
import net.minecraft.world.gen.placement.FrequencyConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;

public class RainbowDesertBiome extends Biome {

	protected RainbowDesertBiome() {
		super(new Biome.Builder()
				.surfaceBuilder(SurfaceBuilderHandeler.ColoredSands,SurfaceBuilder.SAND_CONFIG)
				.precipitation(Biome.RainType.NONE)
				.category(Biome.Category.DESERT)
				.temperature(0.5F)
				.depth(0.125F)
				.scale(0.05F)
				.temperature(2.0F)
				.downfall(0.0F)
				.waterColor(0x113355)
				.waterFogColor(0x115588)
				.parent((String)null)
				);
	      DefaultBiomeFeatures.addCarvers(this);
	      DefaultBiomeFeatures.addStructures(this);
	      DefaultBiomeFeatures.addMonsterRooms(this);
	      DefaultBiomeFeatures.addStoneVariants(this);
	      DefaultBiomeFeatures.addOres(this);
	      DefaultBiomeFeatures.addSedimentDisks(this);
	      
	      

	      DefaultBiomeFeatures.addExtraDefaultFlowers(this);
	      DefaultBiomeFeatures.addJungleGrass(this);
	      DefaultBiomeFeatures.addMushrooms(this);
	      DefaultBiomeFeatures.addSprings(this);
	      DefaultBiomeFeatures.addFreezeTopLayer(this);
		

		
	}
	@Override
	public int getFoliageColor(BlockPos pos) {
		return(0x666666);
	}
	@Override
	public int getGrassColor(BlockPos pos) {
		return(0x666666);
	}


}
