package com.apocfarce.minestuck_alternia.world.biome;

import com.apocfarce.minestuck_alternia.block.AlterniaBlocks;
import com.apocfarce.minestuck_alternia.world.gen.carver.AlterniaCarvers;
import com.apocfarce.minestuck_alternia.world.gen.feature.AlterniaFeatures;
import com.apocfarce.minestuck_alternia.world.gen.feature.AlterniaFillerBlockTypes;
import com.apocfarce.minestuck_alternia.world.gen.feature.structure.HiveStructureConfig;
import com.apocfarce.minestuck_alternia.world.gen.feature.structure.HiveType;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.WeightedList;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.blockplacer.SimpleBlockPlacer;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.carver.WorldCarver;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;
import net.minecraft.world.gen.foliageplacer.SpruceFoliagePlacer;
import net.minecraft.world.gen.placement.AtSurfaceWithExtraConfig;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.DepthAverageConfig;
import net.minecraft.world.gen.placement.FrequencyConfig;
import net.minecraft.world.gen.placement.IPlacementConfig;
import net.minecraft.world.gen.placement.Placement;

import java.util.ArrayList;
import java.util.List;

/**
 * A helper class for configuring alternia-specific world features
 * @author kirderf1
 */
public class AlterniaBiomeFeatures {
	
	
	
	
	
	public static void addCarvers(Biome biome) {
		biome.addCarver(GenerationStage.Carving.AIR, Biome.createCarver(AlterniaCarvers.ALTERNIA_CAVES.get(), new ProbabilityConfig(0.14285715F)));
		biome.addCarver(GenerationStage.Carving.AIR, Biome.createCarver(AlterniaCarvers.ALTERNIA_CANYONS.get(), new ProbabilityConfig(0.02F)));  
	}
	
	public static void addOres(Biome biomeIn) {
		biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(AlterniaFillerBlockTypes.AlterniaNaturalStone, Blocks.COAL_ORE.getDefaultState(), 17)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(20, 0, 0, 128))));
		biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(AlterniaFillerBlockTypes.AlterniaNaturalStone, Blocks.IRON_ORE.getDefaultState(), 9)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(20, 0, 0, 64))));
		biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(AlterniaFillerBlockTypes.AlterniaNaturalStone, Blocks.GOLD_ORE.getDefaultState(), 9)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(2, 0, 0, 32))));
		biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(AlterniaFillerBlockTypes.AlterniaNaturalStone, Blocks.REDSTONE_ORE.getDefaultState(), 8)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(8, 0, 0, 16))));
		biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(AlterniaFillerBlockTypes.AlterniaNaturalStone, Blocks.DIAMOND_ORE.getDefaultState(), 8)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(1, 0, 0, 16))));
		biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(AlterniaFillerBlockTypes.AlterniaNaturalStone, Blocks.LAPIS_ORE.getDefaultState(), 7)).withPlacement(Placement.COUNT_DEPTH_AVERAGE.configure(new DepthAverageConfig(1, 16, 16))));
	}
	
	public static void addStoneVariants(Biome biome){
		biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(AlterniaFillerBlockTypes.AlterniaNaturalStone, AlterniaBlocks.RED_ROCK.getDefaultState(), 33)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(10, 0, 0, 256))));	
	}
	/**
	 * This function need to be applied to all biomes in alternia for
	 */
	public static void addStructures(Biome biome) {
		biome.addFeature(GenerationStage.Decoration.SURFACE_STRUCTURES, AlterniaFeatures.HIVE.get().withConfiguration(new HiveStructureConfig(new WeightedList<>()))
				.withPlacement(Placement.NOPE.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));
	}
	
	public static void addLowbloodHives(Biome biome) {
		WeightedList<HiveType> hives = new WeightedList<>();
		
		hives.func_226313_a_(HiveType.BURGUNDY_AWNING_SMALL, 2);
		hives.func_226313_a_(HiveType.BURGUNDY_SMALL, 3);
		hives.func_226313_a_(HiveType.BURGUNDY_MANSION, 1);
		
		hives.func_226313_a_(HiveType.BRONZE_WOODEN, 3);
		hives.func_226313_a_(HiveType.BRONZE_FARM, 2);
		hives.func_226313_a_(HiveType.BRONZE_WINDMILL, 1);
		
		hives.func_226313_a_(HiveType.GOLD_SYMMETRIC, 3);
		hives.func_226313_a_(HiveType.GOLD_BEACON, 1);
		hives.func_226313_a_(HiveType.GOLD_TOWER, 2);
		
		biome.addStructure(AlterniaFeatures.HIVE.get().withConfiguration(new HiveStructureConfig(hives)));
	}
	
	public static void addMidlowbloodHives(Biome biome) {
		WeightedList<HiveType> hives = new WeightedList<>();
		
		hives.func_226313_a_(HiveType.MUTANT_PLUS, 1);
		hives.func_226313_a_(HiveType.MUTANT_LARGE, 3);
		hives.func_226313_a_(HiveType.MUTANT_AWNING_LARGE, 2);
		
		hives.func_226313_a_(HiveType.LIME_DIAGONAL, 3);
		hives.func_226313_a_(HiveType.LIME_ROUND_TOWER, 2);
		hives.func_226313_a_(HiveType.LIME_FARM, 1);
		
		hives.func_226313_a_(HiveType.OLIVE_CAVE, 3);
		hives.func_226313_a_(HiveType.OLIVE_TREE, 2);
		hives.func_226313_a_(HiveType.OLIVE_BASEMENT, 1);
		
		biome.addStructure(AlterniaFeatures.HIVE.get().withConfiguration(new HiveStructureConfig(hives)));
	}
	
	public static void addMidhighbloodHives(Biome biome) {
		WeightedList<HiveType> hives = new WeightedList<>();
		
		hives.func_226313_a_(HiveType.JADE_TOWER, 3);
		hives.func_226313_a_(HiveType.JADE_FOUNTAIN, 2);
		hives.func_226313_a_(HiveType.JADE_TREE, 3);
		
		hives.func_226313_a_(HiveType.TEAL_BALCONY_MANSION, 2);
		hives.func_226313_a_(HiveType.TEAL_TREE_MANSION, 3);
		hives.func_226313_a_(HiveType.TEAL_TOWER, 1);
		
		hives.func_226313_a_(HiveType.CERULEAN_L, 2);
		hives.func_226313_a_(HiveType.CERULEAN_BASEMENT, 1);
		hives.func_226313_a_(HiveType.CERULEAN_CAVE, 1);
		
		biome.addStructure(AlterniaFeatures.HIVE.get().withConfiguration(new HiveStructureConfig(hives)));
	}
	
	public static void addMidhighbloodHives2(Biome biome) {
		WeightedList<HiveType> hives = new WeightedList<>();
		
		hives.func_226313_a_(HiveType.JADE_TOWER, 2);
		hives.func_226313_a_(HiveType.JADE_FOUNTAIN, 1);
		hives.func_226313_a_(HiveType.JADE_TREE, 1);
		
		hives.func_226313_a_(HiveType.TEAL_BALCONY_MANSION, 2);
		hives.func_226313_a_(HiveType.TEAL_TREE_MANSION, 1);
		hives.func_226313_a_(HiveType.TEAL_TOWER, 3);
		
		hives.func_226313_a_(HiveType.CERULEAN_L, 2);
		hives.func_226313_a_(HiveType.CERULEAN_BASEMENT, 3);
		hives.func_226313_a_(HiveType.CERULEAN_CAVE, 3);
		
		biome.addStructure(AlterniaFeatures.HIVE.get().withConfiguration(new HiveStructureConfig(hives)));
	}
	
	public static void addHighbloodHives(Biome biome) {
		WeightedList<HiveType> hives = new WeightedList<>();
		
		hives.func_226313_a_(HiveType.INDIGO_TOWER_PLUS, 3);
		hives.func_226313_a_(HiveType.INDIGO_TELESCOPE, 1);
		hives.func_226313_a_(HiveType.INDIGO_LARGE_CHIMNEYS, 2);
		
		hives.func_226313_a_(HiveType.PURPLE_BASEMENT, 2);
		hives.func_226313_a_(HiveType.PURPLE_BALCONY, 2);
		hives.func_226313_a_(HiveType.PURPLE_CHURCH, 1);
		hives.func_226313_a_(HiveType.PURPLE_TENT, 1);
		
		biome.addStructure(AlterniaFeatures.HIVE.get().withConfiguration(new HiveStructureConfig(hives)));
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