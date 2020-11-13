package com.apocfarce.minestuck_alternia.world.biome;

import com.apocfarce.minestuck_alternia.block.AlterniaBlocks;
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
import net.minecraft.world.gen.placement.FrequencyConfig;
import net.minecraft.world.gen.placement.Placement;

import java.util.ArrayList;
import java.util.List;

/**
 * A helper class for configuring alternia-specific world features
 * @author kirderf1
 */
public class AlterniaBiomeFeatures {
	
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
		biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(createGrassClusterConfig(AlterniaBlocks.PYRAL_GRASS.getDefaultState())).withPlacement(Placement.COUNT_HEIGHTMAP.configure(new FrequencyConfig(1))));
	}
	
	//While vanilla is creating their configs statically, it's not appropriate for us to do the same since mod blocks (or any registry objects)
	// aren't designed to be available for static initialization. That is why we instead use these functions.
	
	public static BlockClusterFeatureConfig createGrassClusterConfig(BlockState grass) {
		return new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(grass), new SimpleBlockPlacer()).tries(32).build();
	}
	
	public static TreeFeatureConfig createPyralTreeConfig() {
		return new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(AlterniaBlocks.PYRAL_LOG.getDefaultState()), new SimpleBlockStateProvider(AlterniaBlocks.PYRAL_LEAVES.getDefaultState()), new SpruceFoliagePlacer(2, 1)).baseHeight(6).heightRandA(3).trunkHeight(1).trunkHeightRandom(1).trunkTopOffsetRandom(2).ignoreVines().setSapling(AlterniaBlocks.PYRAL_SAPLING).build();
	}
	
	public static TreeFeatureConfig createLargePyralTreeConfig() {
		return new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(AlterniaBlocks.PYRAL_LOG.getDefaultState()), new SimpleBlockStateProvider(AlterniaBlocks.PYRAL_LEAVES.getDefaultState()), new BlobFoliagePlacer(0, 0)).setSapling(AlterniaBlocks.PYRAL_SAPLING).build();
	}
	
	public static TreeFeatureConfig createMirrageTreeConfig() {
		return new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(AlterniaBlocks.MIRRAGE_LOG.getDefaultState()), new SimpleBlockStateProvider(AlterniaBlocks.MIRRAGE_LEAVES.getDefaultState()), new BlobFoliagePlacer(2, 0)).baseHeight(5).heightRandA(2).foliageHeight(3).ignoreVines().setSapling(AlterniaBlocks.MIRRAGE_SAPLING).build();
	}
	
	public static TreeFeatureConfig createLargeMirrageTreeConfig() {
		return new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(AlterniaBlocks.MIRRAGE_LOG.getDefaultState()), new SimpleBlockStateProvider(AlterniaBlocks.MIRRAGE_LEAVES.getDefaultState()), new BlobFoliagePlacer(0, 0)).setSapling(AlterniaBlocks.MIRRAGE_SAPLING).build();
	}
}