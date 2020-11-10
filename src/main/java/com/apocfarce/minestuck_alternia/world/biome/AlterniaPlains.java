package com.apocfarce.minestuck_alternia.world.biome;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.apocfarce.minestuck_alternia.Utils.MultipleFeatureChanceHelper;
import com.apocfarce.minestuck_alternia.world.gen.feature.AlterniaFeatureHandeler;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.ConfiguredRandomFeatureList;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.MultipleRandomFeatureConfig;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.structure.MineshaftConfig;
import net.minecraft.world.gen.feature.structure.MineshaftStructure;
import net.minecraft.world.gen.placement.ChanceConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;

public final class AlterniaPlains extends Biome {
	protected AlterniaPlains() {
		super((new Biome.Builder())
				.surfaceBuilder(SurfaceBuilder.DEFAULT, SurfaceBuilder.GRASS_DIRT_GRAVEL_CONFIG)
				.precipitation(Biome.RainType.RAIN)
				.category(Biome.Category.PLAINS)
				.depth(0.125F)
				.scale(0.05F)
				.temperature(0.8F)
				.downfall(0.4F)
				.waterColor(0x113355)
				.waterFogColor(0x115588)
				.parent((String)null));

      

		this.addStructure(Feature.MINESHAFT.withConfiguration(new MineshaftConfig(0.004D, MineshaftStructure.Type.NORMAL)));
		this.addStructure(Feature.STRONGHOLD.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));

		List<ConfiguredRandomFeatureList<?>> biomeHives = new ArrayList<ConfiguredRandomFeatureList<?>>();
		
		biomeHives.add(AlterniaFeatureHandeler.burgundyHiveFeature1.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withChance(0.1F));
		biomeHives.add(AlterniaFeatureHandeler.burgundyHiveFeature2.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withChance(0.1F));
		biomeHives.add(AlterniaFeatureHandeler.burgundyHiveFeature3.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withChance(0.1F));
		
		biomeHives.add(AlterniaFeatureHandeler.bronzeHiveFeature1.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withChance(0.3F));
		biomeHives.add(AlterniaFeatureHandeler.bronzeHiveFeature2.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withChance(0.3F));
		biomeHives.add(AlterniaFeatureHandeler.bronzeHiveFeature3.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withChance(0.3F));

		biomeHives.add(AlterniaFeatureHandeler.goldHiveFeature1.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withChance(0.1F));
		biomeHives.add(AlterniaFeatureHandeler.goldHiveFeature2.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withChance(0.1F));
		biomeHives.add(AlterniaFeatureHandeler.goldHiveFeature3.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withChance(0.1F));
		
		ConfiguredFeature<?, ?> defaultHive = AlterniaFeatureHandeler.burgundyHiveFeature3.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG);
		this.addFeature(GenerationStage.Decoration.SURFACE_STRUCTURES, Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(biomeHives, defaultHive)).withPlacement(Placement.CHANCE_HEIGHTMAP.configure(new ChanceConfig(50))));

		DefaultBiomeFeatures.addCarvers(this);
		DefaultBiomeFeatures.addStructures(this);
		DefaultBiomeFeatures.addLakes(this);
		DefaultBiomeFeatures.addMonsterRooms(this);
		DefaultBiomeFeatures.addPlainsTallGrass(this);
		DefaultBiomeFeatures.addStoneVariants(this);
		DefaultBiomeFeatures.addOres(this);
		DefaultBiomeFeatures.addSedimentDisks(this);
		DefaultBiomeFeatures.addOakTreesFlowersGrass(this);
		DefaultBiomeFeatures.addMushrooms(this);
		DefaultBiomeFeatures.addReedsAndPumpkins(this);
		DefaultBiomeFeatures.addSprings(this);
		DefaultBiomeFeatures.addFreezeTopLayer(this);
		

	}
	@Override
	public int getFoliageColor() {
		return(0x9955DD);
	}
	@Override
	public int getGrassColor(double posX, double posZ) {
		return(0x004411);
	}
}