package com.apocfarce.minestuck_alternia.world.gen.feature.structure;

import com.apocfarce.minestuck_alternia.util.BloodColor;
import com.mojang.serialization.Codec;
import net.minecraft.util.Rotation;
import net.minecraft.util.SharedSeedRandom;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.util.registry.DynamicRegistries;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.ChunkStatus;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.feature.structure.StructurePiece;
import net.minecraft.world.gen.feature.structure.StructureStart;
import net.minecraft.world.gen.feature.template.TemplateManager;
import net.minecraft.world.gen.settings.StructureSeparationSettings;
import net.minecraft.world.server.ServerWorld;

public class HiveStructure extends Structure<HiveStructureConfig> {
	
	public HiveStructure(Codec<HiveStructureConfig> codec) {
		super(codec);
	}
	
	@Override
	public IStartFactory<HiveStructureConfig> getStartFactory() {
		return Start::new;
	}
	
	@Override
	public String getStructureName() {
		return String.valueOf(getRegistryName());
	}
	/*
	TODO these are now stored based on the dimension. Figure out where once you start updating the dimension itself
	@Override
	protected int getBiomeFeatureDistance(ChunkGenerator<?> chunkGenerator) {
		return 12;
	}
	
	@Override
	protected int getBiomeFeatureSeparation(ChunkGenerator<?> chunkGenerator) {
		return 3;
	}
	*/
	public BlockPos tryFindHiveToOccupy(ServerWorld world, BloodColor color) {
		
		final int maxRadius = 10;
		BlockPos spawn = world.getSpawnPoint();
		int chunkX = spawn.getX() >> 4;
		int chunkZ = spawn.getZ() >> 4;
		SharedSeedRandom random = new SharedSeedRandom();
		ChunkGenerator generator = world.getChunkProvider().getChunkGenerator();
		long seed = world.getSeed();
		
		StructureSeparationSettings settings = generator.func_235957_b_().func_236197_a_(this);
		
		if(settings == null)
			return null;
		
		for(int radius = 0; radius <= maxRadius; radius++) {
			for(int spacingX = -radius; spacingX <= radius; spacingX++) {
				boolean borderX = spacingX == -radius || spacingX == radius;
				for(int spacingZ = -radius; spacingZ <= radius; spacingZ++) {
					boolean borderZ = spacingZ == -radius || spacingZ == radius;
					
					if(borderX || borderZ) {	//Don't search spaces that we've already visited for lower values of radius
						int x = chunkX + settings.func_236668_a_()*spacingX;
						int z = chunkZ + settings.func_236668_a_()*spacingZ;
						ChunkPos structurePos = getChunkPosForStructure(settings, seed, random, x, z);
						StructureStart<?> start = world.getChunk(structurePos.x, structurePos.z, ChunkStatus.STRUCTURE_STARTS).func_230342_a_(this);
						
						if(start != null && start.isValid()) {
							BlockPos hivePos = tryOccupy(start, color);
							if(hivePos != null)
								return hivePos;
						}
					}
				}
			}
		}
		
		return null;
	}
	
	private static class Start extends StructureStart<HiveStructureConfig> {
		
		public Start(Structure<HiveStructureConfig> structure, int chunkX, int chunkZ, MutableBoundingBox boundingBox, int references, long seed) {
			super(structure, chunkX, chunkZ, boundingBox, references, seed);
		}
		
		@Override
		public void func_230364_a_(DynamicRegistries registries, ChunkGenerator generator, TemplateManager templateManager, int chunkX, int chunkZ, Biome biome, HiveStructureConfig config) {
			
			HiveType type = config.pickType(rand);
			
			int x = chunkX * 16 + rand.nextInt(16);
			int z = chunkZ * 16 + rand.nextInt(16);
			int y = generator.getNoiseHeight(x, z, Heightmap.Type.WORLD_SURFACE_WG);
			BlockPos position = new BlockPos(x, y, z);
			
			Rotation rotation = Rotation.randomRotation(rand);
			
			StructurePiece piece = type.createPiece(templateManager, position, rotation);
			components.add(piece);
			piece.buildComponent(piece, components, rand);
			
			recalculateStructureSize();
		}
	}
	
	private static BlockPos tryOccupy(StructureStart<?> start, BloodColor color) {
		StructurePiece piece = start.getComponents().get(0);
		return piece instanceof LiveableHive ? ((LiveableHive) piece).tryOccupy(color) : null;
	}
}
