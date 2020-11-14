package com.apocfarce.minestuck_alternia.world.biome;

import com.apocfarce.minestuck_alternia.block.AlterniaBlocks;
import com.apocfarce.minestuck_alternia.world.gen.feature.AlterniaFeatureHandeler;
import net.minecraft.block.BlockState;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.blockplacer.SimpleBlockPlacer;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;
import net.minecraft.world.gen.foliageplacer.SpruceFoliagePlacer;
import net.minecraft.world.gen.placement.AtSurfaceWithExtraConfig;
import net.minecraft.world.gen.placement.ChanceConfig;
import net.minecraft.world.gen.placement.FrequencyConfig;
import net.minecraft.world.gen.placement.Placement;

import java.util.ArrayList;
import java.util.List;

/**
 * A helper class for configuring alternia-specific world features
 * @author kirderf1
 */
public class AlterniaBiomeFeatures {
	
	public static void addHivesBurgundy(Biome biome) {
		
		List<ConfiguredRandomFeatureList<?>> biomeHives = new ArrayList<>();
		
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
		biome.addFeature(GenerationStage.Decoration.SURFACE_STRUCTURES, Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(biomeHives, defaultHive))
				.withPlacement(Placement.CHANCE_HEIGHTMAP.configure(new ChanceConfig(50))));
	}
	
	public static void addHivesMutant(Biome biome) {
		
		List<ConfiguredRandomFeatureList<?>> biomeHives = new ArrayList<>();
		
		biomeHives.add(AlterniaFeatureHandeler.mutantHiveFeature1.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withChance(0.1F));
		biomeHives.add(AlterniaFeatureHandeler.mutantHiveFeature2.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withChance(0.3F));
		biomeHives.add(AlterniaFeatureHandeler.mutantHiveFeature3.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withChance(0.1F));
		
		biomeHives.add(AlterniaFeatureHandeler.limeHiveFeature1.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withChance(0.1F));
		biomeHives.add(AlterniaFeatureHandeler.limeHiveFeature2.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withChance(0.1F));
		biomeHives.add(AlterniaFeatureHandeler.limeHiveFeature3.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withChance(0.1F));
		
		biomeHives.add(AlterniaFeatureHandeler.oliveHiveFeature1.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withChance(0.1F));
		biomeHives.add(AlterniaFeatureHandeler.oliveHiveFeature2.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withChance(1F));
		biomeHives.add(AlterniaFeatureHandeler.oliveHiveFeature3.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withChance(0.3F));
		
		ConfiguredFeature<?, ?> defaultHive = AlterniaFeatureHandeler.mutantHiveFeature1.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG);
		biome.addFeature(GenerationStage.Decoration.SURFACE_STRUCTURES, Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(biomeHives, defaultHive))
				.withPlacement(Placement.CHANCE_HEIGHTMAP.configure(new ChanceConfig(50))));
	}
	
	public static void addHivesJade(Biome biome) {
		List<ConfiguredRandomFeatureList<?>> biomeHives = new ArrayList<>();
		
		biomeHives.add(AlterniaFeatureHandeler.jadeHiveFeature1.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withChance(0.1F));
		biomeHives.add(AlterniaFeatureHandeler.jadeHiveFeature2.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withChance(0.1F));
		biomeHives.add(AlterniaFeatureHandeler.jadeHiveFeature3.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withChance(0.1F));
		
		biomeHives.add(AlterniaFeatureHandeler.tealHiveFeature1.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withChance(0.1F));
		biomeHives.add(AlterniaFeatureHandeler.tealHiveFeature2.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withChance(0.1F));
		biomeHives.add(AlterniaFeatureHandeler.tealHiveFeature3.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withChance(0.1F));
		
		biomeHives.add(AlterniaFeatureHandeler.ceruleanHiveFeature1.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withChance(0.1F));
		biomeHives.add(AlterniaFeatureHandeler.ceruleanHiveFeature2.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withChance(0.1F));
		biomeHives.add(AlterniaFeatureHandeler.ceruleanHiveFeature3.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withChance(0.1F));
		
		ConfiguredFeature<?, ?> defaultHive = AlterniaFeatureHandeler.jadeHiveFeature1.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG);
		biome.addFeature(GenerationStage.Decoration.SURFACE_STRUCTURES, Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(biomeHives, defaultHive))
				.withPlacement(Placement.CHANCE_HEIGHTMAP.configure(new ChanceConfig(100))));
	}
	
	public static void addHivesTeal(Biome biome) {
		List<ConfiguredRandomFeatureList<?>> biomeHives = new ArrayList<>();
		
		biomeHives.add(AlterniaFeatureHandeler.jadeHiveFeature1.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withChance(0.1F));
		biomeHives.add(AlterniaFeatureHandeler.jadeHiveFeature2.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withChance(0.1F));
		biomeHives.add(AlterniaFeatureHandeler.jadeHiveFeature3.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withChance(0.1F));
		
		biomeHives.add(AlterniaFeatureHandeler.tealHiveFeature1.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withChance(0.1F));
		biomeHives.add(AlterniaFeatureHandeler.tealHiveFeature2.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withChance(0.3F));
		biomeHives.add(AlterniaFeatureHandeler.tealHiveFeature3.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withChance(0.1F));
		
		biomeHives.add(AlterniaFeatureHandeler.ceruleanHiveFeature1.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withChance(0.3F));
		biomeHives.add(AlterniaFeatureHandeler.ceruleanHiveFeature2.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withChance(0.3F));
		biomeHives.add(AlterniaFeatureHandeler.ceruleanHiveFeature3.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withChance(0.1F));
		
		ConfiguredFeature<?, ?> defaultHive = AlterniaFeatureHandeler.tealHiveFeature1.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG);
		biome.addFeature(GenerationStage.Decoration.SURFACE_STRUCTURES, Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(biomeHives, defaultHive))
				.withPlacement(Placement.CHANCE_HEIGHTMAP.configure(new ChanceConfig(100))));
	}
	
	public static void addHivesIndigo(Biome biome) {
		List<ConfiguredRandomFeatureList<?>> biomeHives = new ArrayList<>();
		
		biomeHives.add(AlterniaFeatureHandeler.indigoHiveFeature1.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withChance(0.1F));
		biomeHives.add(AlterniaFeatureHandeler.indigoHiveFeature2.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withChance(0.1F));
		biomeHives.add(AlterniaFeatureHandeler.indigoHiveFeature3.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withChance(0.1F));
		
		biomeHives.add(AlterniaFeatureHandeler.purpleHiveFeature1.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withChance(1F));
		biomeHives.add(AlterniaFeatureHandeler.purpleHiveFeature2.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withChance(0.1F));
		biomeHives.add(AlterniaFeatureHandeler.purpleHiveFeature3.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withChance(0.1F));
		
		ConfiguredFeature<?, ?> defaultHive = AlterniaFeatureHandeler.indigoHiveFeature1.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG);
		biome.addFeature(GenerationStage.Decoration.SURFACE_STRUCTURES, Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(biomeHives, defaultHive))
				.withPlacement(Placement.CHANCE_HEIGHTMAP.configure(new ChanceConfig(50))));
	}
	
	public static void addPyralTrees(Biome biome) {
		List<ConfiguredRandomFeatureList<?>> biomeTrees = new ArrayList<>();
		biomeTrees.add(Feature.FANCY_TREE.withConfiguration(DefaultBiomeFeatures.FANCY_TREE_CONFIG).withChance(0.05F));
		biomeTrees.add(Feature.NORMAL_TREE.withConfiguration(createPyralTreeConfig()).withChance(0.34F));
		biomeTrees.add(Feature.FANCY_TREE.withConfiguration(createLargePyralTreeConfig()).withChance(0.34F));
		
		ConfiguredFeature<?, ?> defaultTree = Feature.NORMAL_TREE.withConfiguration(createPyralTreeConfig());
		biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(biomeTrees, defaultTree)).withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(10, 0.1F, 1))));
	}
	
	public static void addMirrageTrees(Biome biome) {
		List<ConfiguredRandomFeatureList<?>> biomeTrees = new ArrayList<>();
		biomeTrees.add(Feature.FANCY_TREE.withConfiguration(DefaultBiomeFeatures.FANCY_TREE_CONFIG).withChance(0.05F));
		biomeTrees.add(Feature.NORMAL_TREE.withConfiguration(createMirrageTreeConfig()).withChance(0.34F));
		biomeTrees.add(Feature.FANCY_TREE.withConfiguration(createLargeMirrageTreeConfig()).withChance(0.34F));
		
		ConfiguredFeature<?, ?> defaultTree = Feature.NORMAL_TREE.withConfiguration(createMirrageTreeConfig());
		biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(biomeTrees, defaultTree)).withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(10, 0.1F, 1))));
	}
	
	public static void addPyralGrass(Biome biome) {
		biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(createGrassClusterConfig(AlterniaBlocks.pyralGrass.getDefaultState())).withPlacement(Placement.COUNT_HEIGHTMAP.configure(new FrequencyConfig(1))));
	}
	
	//While vanilla is creating their configs statically, it's not appropriate for us to do the same since mod blocks (or any registry objects)
	// aren't designed to be available for static initialization. That is why we instead use these functions.
	
	public static BlockClusterFeatureConfig createGrassClusterConfig(BlockState grass) {
		return new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(grass), new SimpleBlockPlacer()).tries(32).build();
	}
	
	public static TreeFeatureConfig createPyralTreeConfig() {
		return new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(AlterniaBlocks.pyralLog.getDefaultState()), new SimpleBlockStateProvider(AlterniaBlocks.pyralLeaves.getDefaultState()), new SpruceFoliagePlacer(2, 1)).baseHeight(6).heightRandA(3).trunkHeight(1).trunkHeightRandom(1).trunkTopOffsetRandom(2).ignoreVines().setSapling(AlterniaBlocks.pyralSapling).build();
	}
	
	public static TreeFeatureConfig createLargePyralTreeConfig() {
		return new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(AlterniaBlocks.pyralLog.getDefaultState()), new SimpleBlockStateProvider(AlterniaBlocks.pyralLeaves.getDefaultState()), new BlobFoliagePlacer(0, 0)).setSapling(AlterniaBlocks.pyralSapling).build();
	}
	
	public static TreeFeatureConfig createMirrageTreeConfig() {
		return new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(AlterniaBlocks.mirrageLog.getDefaultState()), new SimpleBlockStateProvider(AlterniaBlocks.mirrageLeaves.getDefaultState()), new BlobFoliagePlacer(2, 0)).baseHeight(5).heightRandA(2).foliageHeight(3).ignoreVines().setSapling(AlterniaBlocks.mirrageSapling).build();
	}
	
	public static TreeFeatureConfig createLargeMirrageTreeConfig() {
		return new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(AlterniaBlocks.mirrageLog.getDefaultState()), new SimpleBlockStateProvider(AlterniaBlocks.mirrageLeaves.getDefaultState()), new BlobFoliagePlacer(0, 0)).setSapling(AlterniaBlocks.mirrageSapling).build();
	}
}