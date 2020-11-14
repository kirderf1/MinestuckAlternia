package com.apocfarce.minestuck_alternia.block.tree;

import java.util.Random;

import com.apocfarce.minestuck_alternia.world.biome.AlterniaBiomeFeatures;

import net.minecraft.block.trees.Tree;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;

public class PyralTree extends Tree {
	@Override
	   protected ConfiguredFeature<TreeFeatureConfig, ?> getTreeFeature(Random random, boolean hasFlowers) {
		      return random.nextInt(10) == 0 ? Feature.FANCY_TREE.withConfiguration(AlterniaBiomeFeatures.createLargePyralTreeConfig())
					  : Feature.NORMAL_TREE.withConfiguration(AlterniaBiomeFeatures.createPyralTreeConfig());
		   }
}