package com.apocfarce.minestuck_alternia.world.gen.layer;

import net.minecraft.world.gen.INoiseRandom;
import net.minecraft.world.gen.layer.traits.IAreaTransformer0;

public enum AlterniaSeedLayer implements IAreaTransformer0 {
   INSTANCE;

   public int apply(INoiseRandom context, int x, int z) {
	   return 1;
   }
}