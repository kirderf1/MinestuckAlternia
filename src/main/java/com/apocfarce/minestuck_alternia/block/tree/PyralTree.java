package com.apocfarce.minestuck_alternia.block.tree;

import java.util.Random;

import com.apocfarce.minestuck_alternia.world.gen.feature.PyralTreeFeature;
import com.apocfarce.minestuck_alternia.world.gen.feature.PyralTreeLargeFeature;

import net.minecraft.block.trees.Tree;
import net.minecraft.world.gen.feature.AbstractTreeFeature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

public class PyralTree extends Tree {
	   protected AbstractTreeFeature<NoFeatureConfig> getTreeFeature(Random random) {
		      return (AbstractTreeFeature<NoFeatureConfig>)(random.nextInt(10) == 0 ? new PyralTreeLargeFeature(NoFeatureConfig::deserialize, true) : new PyralTreeFeature(NoFeatureConfig::deserialize,false));
		   }
}
