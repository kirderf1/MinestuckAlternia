package com.apocfarce.minestuck_alternia.world.gen.surfacebuilder;

import com.apocfarce.minestuck_alternia.block.AlterniaBlocks;
import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

import java.util.Random;

public class DarkStoneSurfaceBuilder extends SurfaceBuilder<SurfaceBuilderConfig> {
	
	public DarkStoneSurfaceBuilder(Codec<SurfaceBuilderConfig> configCodec) {
		super(configCodec);
	}
	
	public void buildSurface(Random random, IChunk chunkIn, Biome biomeIn, int x, int z, int startHeight, double noise, BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed, SurfaceBuilderConfig config) {
		int xInChunk = x & 15;
		int zInChunk = z & 15;
		int color = (int) (noise / 3.0D + 3.0D + random.nextDouble() * 0.25D);
		
		BlockPos.Mutable mutablePos = new BlockPos.Mutable();
		BlockState surfaceBlock;
		int depth = 0;
		
		for (int y = startHeight; y >= 0; --y) {
			mutablePos.setPos(xInChunk, y, zInChunk);
			BlockState worldBlock = chunkIn.getBlockState(mutablePos);
			if (worldBlock.isAir(chunkIn, mutablePos))
				depth = 0;
			else if (worldBlock.getBlock() == defaultBlock.getBlock()) {
				
				if (depth < 3) {
					surfaceBlock = AlterniaBlocks.DARK_STONE.getDefaultState();
					
					chunkIn.setBlockState(mutablePos, surfaceBlock, false);
					depth++;
				}
			}
		}
	}
	

}