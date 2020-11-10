package com.apocfarce.minestuck_alternia.world.biome;

import java.util.ArrayList;
import java.util.List;

import com.apocfarce.minestuck_alternia.world.gen.feature.AlterniaFeatureHandeler;
import com.apocfarce.minestuck_alternia.world.gen.surfacebuilder.AlterniaSurfaceBuilders;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.ConfiguredRandomFeatureList;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.MultipleRandomFeatureConfig;
import net.minecraft.world.gen.placement.ChanceConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;

public class RainbowDesertBiome extends Biome {
	protected RainbowDesertBiome() {
		super(new Biome.Builder()
				.surfaceBuilder(AlterniaSurfaceBuilders.COLORED_SANDS.get(), SurfaceBuilder.SAND_CONFIG)
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
		
		List<ConfiguredRandomFeatureList<?>> biomeHives = new ArrayList<ConfiguredRandomFeatureList<?>>();
		
		biomeHives.add(AlterniaFeatureHandeler.indigoHiveFeature1.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withChance(0.1F));
		biomeHives.add(AlterniaFeatureHandeler.indigoHiveFeature2.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withChance(0.1F));
		biomeHives.add(AlterniaFeatureHandeler.indigoHiveFeature3.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withChance(0.1F));

		biomeHives.add(AlterniaFeatureHandeler.purpleHiveFeature1.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withChance(1F));
		biomeHives.add(AlterniaFeatureHandeler.purpleHiveFeature2.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withChance(0.1F));
		biomeHives.add(AlterniaFeatureHandeler.purpleHiveFeature3.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withChance(0.1F));
		
		ConfiguredFeature<?, ?> defaultHive = AlterniaFeatureHandeler.indigoHiveFeature1.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG);
		this.addFeature(GenerationStage.Decoration.SURFACE_STRUCTURES, Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(biomeHives, defaultHive)).withPlacement(Placement.CHANCE_HEIGHTMAP.configure(new ChanceConfig(50))));
		
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
	public int getFoliageColor() {
		return(0x666666);
	}
	@Override
	public int getGrassColor(double posX, double posZ) {
		return(0x666666);
	}


}
