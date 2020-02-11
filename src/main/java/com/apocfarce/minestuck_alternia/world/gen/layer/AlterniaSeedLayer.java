package com.apocfarce.minestuck_alternia.world.gen.layer;

import net.minecraft.world.gen.INoiseRandom;
import net.minecraft.world.gen.layer.traits.IAreaTransformer0;

public enum AlterniaSeedLayer implements IAreaTransformer0 {
   INSTANCE;

   public int apply(INoiseRandom p_215735_1_, int p_215735_2_, int p_215735_3_) {
	   return 1;
   }
}