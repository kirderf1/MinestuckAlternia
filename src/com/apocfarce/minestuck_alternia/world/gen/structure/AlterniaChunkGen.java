package com.apocfarce.minestuck_alternia.world.gen.structure;

import java.util.Random;

import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

public class AlterniaChunkGen implements IWorldGenerator {
	
	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator,IChunkProvider chunkProvider) {
		switch (world.provider.getDimension()){
		case -1:
			generateNetherChunk(random, chunkX, chunkZ, world, chunkGenerator, chunkProvider);
			break;
		case 0:
			generateOverworldChunk(random, chunkX, chunkZ, world, chunkGenerator, chunkProvider);
			break;
		case 1:
			generateEndChunk(random, chunkX, chunkZ, world, chunkGenerator, chunkProvider);
			break;
		}
		
	}

	private void generateEndChunk(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator,IChunkProvider chunkProvider) {
		//System.out.println("generating end chunk "+ chunkX+","+chunkZ);

	}

	private void generateOverworldChunk(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator,IChunkProvider chunkProvider) {
		AlterniaVillageGen villageGenerator=new AlterniaVillageGen();
		villageGenerator.generate(world, chunkX, chunkZ,new ChunkPrimer());
		villageGenerator.generateStructure(world, random, new ChunkPos(chunkX,chunkZ));
	}

	private void generateNetherChunk(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator,IChunkProvider chunkProvider) {
		//System.out.println("generating Nether chunk "+ chunkX+","+chunkZ);
	}

}
