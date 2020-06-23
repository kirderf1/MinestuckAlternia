package com.apocfarce.minestuck_alternia.block.tree;

import java.util.Random;

import com.apocfarce.minestuck_alternia.world.gen.feature.MirrageTreeFeature;
import com.apocfarce.minestuck_alternia.world.gen.feature.MirrageTreeLargeFeature;

import net.minecraft.block.trees.Tree;
import net.minecraft.world.gen.feature.AbstractTreeFeature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

public class MirrageTree extends Tree {
	   protected AbstractTreeFeature<NoFeatureConfig> getTreeFeature(Random random) {
		      return (AbstractTreeFeature<NoFeatureConfig>)(random.nextInt(10) == 0 ? new MirrageTreeLargeFeature(NoFeatureConfig::deserialize, true) : new MirrageTreeFeature(NoFeatureConfig::deserialize,false));
		   }
}
