package com.apocfarce.minestuck_alternia.world.gen.layer;

import net.minecraft.world.gen.INoiseRandom;
import net.minecraft.world.gen.layer.LayerUtil;
import net.minecraft.world.gen.layer.traits.IAreaTransformer0;
import net.minecraft.world.gen.layer.traits.IC1Transformer;

public enum AlterniaHeatMapLayer implements IAreaTransformer0 {
	INSTANCE;
	private int OCEAN_CHANCE = 0;
	private int DESERT_CHANCE = 45;
	private int WARM_CHANCE = 30;
	private int COOL_CHANCE = 25;
	private int FROZEN_CHANCE = 0;
	
	public int apply(INoiseRandom context, int x,int z) {
		int RN = context.random(100);
		
		if((RN-=OCEAN_CHANCE) < 0)
			return 0;
		else if((RN -= DESERT_CHANCE) < 0)
			return 1;
		else if((RN -= WARM_CHANCE) < 0)
			return 2;
		else if((RN -= COOL_CHANCE) < 0)
			return 3;
		else if((RN -= FROZEN_CHANCE) < 0)
			return 4;
		//default to ocean
		else return 0;
		
	}
}
