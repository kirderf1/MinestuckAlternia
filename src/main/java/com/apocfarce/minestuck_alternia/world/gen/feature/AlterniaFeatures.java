package com.apocfarce.minestuck_alternia.world.gen.feature;

import com.apocfarce.minestuck_alternia.MinestuckAlternia;
import com.apocfarce.minestuck_alternia.block.AlterniaBlocks;
import com.google.common.collect.ImmutableList;
import net.minecraft.block.Blocks;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.blockplacer.SimpleBlockPlacer;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;
import net.minecraft.world.gen.foliageplacer.FancyFoliagePlacer;
import net.minecraft.world.gen.foliageplacer.SpruceFoliagePlacer;
import net.minecraft.world.gen.placement.AtSurfaceWithExtraConfig;
import net.minecraft.world.gen.placement.ChanceConfig;
import net.minecraft.world.gen.placement.DepthAverageConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.trunkplacer.FancyTrunkPlacer;
import net.minecraft.world.gen.trunkplacer.StraightTrunkPlacer;

import java.util.OptionalInt;

public class AlterniaFeatures {
	//Normally not recommended, but these need to be available when biomes are created
	public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> PYRAL = register("pyral", Feature.TREE.withConfiguration(new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(AlterniaBlocks.PYRAL_LOG.getDefaultState()), new SimpleBlockStateProvider(AlterniaBlocks.PYRAL_LEAVES.getDefaultState()), new SpruceFoliagePlacer(FeatureSpread.func_242253_a(2, 1), FeatureSpread.func_242253_a(0, 2), FeatureSpread.func_242253_a(1, 1)), new StraightTrunkPlacer(5, 2, 1), new TwoLayerFeature(2, 0, 2)).setIgnoreVines().build()));
	public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> LARGE_PYRAL = register("large_pyral", Feature.TREE.withConfiguration(new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(AlterniaBlocks.PYRAL_LOG.getDefaultState()), new SimpleBlockStateProvider(AlterniaBlocks.PYRAL_LEAVES.getDefaultState()), new FancyFoliagePlacer(FeatureSpread.func_242252_a(2), FeatureSpread.func_242252_a(4), 4), new FancyTrunkPlacer(3, 11, 0), new TwoLayerFeature(0, 0, 0, OptionalInt.of(4))).setIgnoreVines().func_236702_a_(Heightmap.Type.MOTION_BLOCKING).build()));
	public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> MIRRAGE = register("mirrage", Feature.TREE.withConfiguration(new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(AlterniaBlocks.MIRRAGE_LOG.getDefaultState()), new SimpleBlockStateProvider(AlterniaBlocks.MIRRAGE_LEAVES.getDefaultState()), new BlobFoliagePlacer(FeatureSpread.func_242252_a(2), FeatureSpread.func_242252_a(0), 3), new StraightTrunkPlacer(4, 2, 0), new TwoLayerFeature(1, 0, 1)).setIgnoreVines().build()));
	public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> LARGE_MIRRAGE = register("large_mirrage", Feature.TREE.withConfiguration(new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(AlterniaBlocks.MIRRAGE_LOG.getDefaultState()), new SimpleBlockStateProvider(AlterniaBlocks.MIRRAGE_LEAVES.getDefaultState()), new FancyFoliagePlacer(FeatureSpread.func_242252_a(2), FeatureSpread.func_242252_a(4), 4), new FancyTrunkPlacer(3, 11, 0), new TwoLayerFeature(0, 0, 0, OptionalInt.of(4))).setIgnoreVines().func_236702_a_(Heightmap.Type.MOTION_BLOCKING).build()));
	
	public static final ConfiguredFeature<?, ?> PYRAL_TREES = register("pyral_trees", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(Features.FANCY_OAK.withChance(1/20F), LARGE_PYRAL.withChance(1/5F)), PYRAL)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(10, 0.1F, 1))));
	public static final ConfiguredFeature<?, ?> MIRRAGE_TREES = register("mirrage_trees", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(Features.FANCY_OAK.withChance(1/20F), LARGE_MIRRAGE.withChance(1/5F)), MIRRAGE)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(10, 0.1F, 1))));
	
	public static final ConfiguredFeature<?, ?> PYRAL_GRASS = register("pyral_grass", Feature.RANDOM_PATCH.withConfiguration(new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(AlterniaBlocks.PYRAL_GRASS.getDefaultState()), new SimpleBlockPlacer()).tries(32).build()).withPlacement(Features.Placements.PATCH_PLACEMENT));
	
	public static final ConfiguredFeature<?, ?> RED_ROCK_ORE = register("red_rock_ore", Feature.ORE.withConfiguration(new OreFeatureConfig(AlterniaFillerBlockTypes.darkStone(), AlterniaBlocks.RED_ROCK.getDefaultState(), 33)).range(256).square().func_242731_b(10));
	public static final ConfiguredFeature<?, ?> COAL_ORE = register("coal_ore", Feature.ORE.withConfiguration(new OreFeatureConfig(AlterniaFillerBlockTypes.darkStone(), Blocks.COAL_ORE.getDefaultState(), 17)).range(128).square().func_242731_b(20));
	public static final ConfiguredFeature<?, ?> IRON_ORE = register("iron_ore", Feature.ORE.withConfiguration(new OreFeatureConfig(AlterniaFillerBlockTypes.darkStone(), Blocks.IRON_ORE.getDefaultState(), 9)).range(64).square().func_242731_b(20));
	public static final ConfiguredFeature<?, ?> GOLD_ORE = register("gold_ore", Feature.ORE.withConfiguration(new OreFeatureConfig(AlterniaFillerBlockTypes.darkStone(), Blocks.GOLD_ORE.getDefaultState(), 9)).range(32).square().func_242731_b(2));
	public static final ConfiguredFeature<?, ?> REDSTONE_ORE = register("redstone_ore", Feature.ORE.withConfiguration(new OreFeatureConfig(AlterniaFillerBlockTypes.darkStone(), Blocks.REDSTONE_ORE.getDefaultState(), 8)).range(16).square().func_242731_b(8));
	public static final ConfiguredFeature<?, ?> DIAMOND_ORE = register("diamond_ore", Feature.ORE.withConfiguration(new OreFeatureConfig(AlterniaFillerBlockTypes.darkStone(), Blocks.DIAMOND_ORE.getDefaultState(), 8)).range(16).square());
	public static final ConfiguredFeature<?, ?> LAPIS_ORE = register("lapis_ore", Feature.ORE.withConfiguration(new OreFeatureConfig(AlterniaFillerBlockTypes.darkStone(), Blocks.LAPIS_ORE.getDefaultState(), 7)).withPlacement(Placement.DEPTH_AVERAGE.configure(new DepthAverageConfig(16, 16))).square());
	
	public static final ConfiguredFeature<?, ?> COMMON_LAVA_LAKE = register("common_lava_lake", Feature.LAKE.withConfiguration(new BlockStateFeatureConfig(Blocks.LAVA.getDefaultState())).withPlacement(Placement.LAVA_LAKE.configure(new ChanceConfig(10))));
	
	private static <FC extends IFeatureConfig> ConfiguredFeature<FC, ?> register(String name, ConfiguredFeature<FC, ?> configuredFeature) {
		return Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, new ResourceLocation(MinestuckAlternia.MOD_ID, name), configuredFeature);
	}
}