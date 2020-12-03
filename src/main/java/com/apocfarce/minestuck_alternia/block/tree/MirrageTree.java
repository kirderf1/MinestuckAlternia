package com.apocfarce.minestuck_alternia.block.tree;

import com.apocfarce.minestuck_alternia.world.gen.feature.AlterniaFeatures;
import net.minecraft.block.trees.Tree;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;

import java.util.Random;

public class MirrageTree extends Tree {
	@Override
	protected ConfiguredFeature<BaseTreeFeatureConfig, ?> getTreeFeature(Random random, boolean hasFlowers) {
		return random.nextInt(10) == 0 ? AlterniaFeatures.LARGE_MIRRAGE : AlterniaFeatures.MIRRAGE;
	}
}