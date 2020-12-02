package com.apocfarce.minestuck_alternia.world.gen.layer;

import net.minecraft.world.gen.INoiseRandom;
import net.minecraft.world.gen.layer.traits.IC1Transformer;

public enum HeatWorldLayer implements IC1Transformer {
   INSTANCE;


   public int apply(INoiseRandom context, int value) {
	   if(context.random(3) == 0) {
		   return 1;
	   }
      return value;
   }
}
