package com.apocfarce.minestuck_alternia.world.gen.carver;

import com.apocfarce.minestuck_alternia.block.AlterniaBlocks;
import com.google.common.collect.ImmutableSet;
import com.mojang.serialization.Codec;
import net.minecraft.block.Blocks;
import net.minecraft.fluid.Fluids;
import net.minecraft.world.gen.carver.CanyonWorldCarver;
import net.minecraft.world.gen.feature.ProbabilityConfig;

public class AlterniaCanyonCarver extends CanyonWorldCarver {

	public AlterniaCanyonCarver(Codec<ProbabilityConfig> codec) {
		super(codec);
		this.carvableBlocks = ImmutableSet.of(AlterniaBlocks.DARK_STONE,AlterniaBlocks.RED_ROCK,//underground blocks
				Blocks.GRASS_BLOCK,Blocks.DIRT,//most biomes surface
				Blocks.SAND,Blocks.SANDSTONE,//desert
				Blocks.RED_CONCRETE_POWDER,Blocks.RED_CONCRETE,Blocks.PINK_CONCRETE_POWDER,Blocks.PINK_CONCRETE,Blocks.CYAN_CONCRETE_POWDER,Blocks.CYAN_CONCRETE,Blocks.LIGHT_BLUE_CONCRETE_POWDER,Blocks.LIGHT_BLUE_CONCRETE//colored deserts
				);
		this.carvableFluids = ImmutableSet.of(Fluids.LAVA, Fluids.WATER);
	   
	}

}
