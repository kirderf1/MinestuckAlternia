package com.apocfarce.minestuck_alternia.world.gen.feature;

import com.apocfarce.minestuck_alternia.world.gen.feature.structure.AlterniaStructures;
import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.SectionPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.LightType;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.surfacebuilders.ISurfaceBuilderConfig;
import net.minecraftforge.common.util.Constants;

import java.util.Random;

public class ModifiedLakesFeature extends Feature<LakesFeatureConfig> {
	
	public ModifiedLakesFeature(Codec<LakesFeatureConfig> codec) {
		super(codec);
	}
	
	@Override
	public boolean generate(ISeedReader reader, ChunkGenerator generator, Random rand, BlockPos pos, LakesFeatureConfig config) {
		pos = getFirstSolidBlock(reader, pos);
		
		if (pos.getY() > AIR_HEIGHT && !reader.func_241827_a(SectionPos.from(pos), AlterniaStructures.HIVE).findAny().isPresent()) {
			pos = pos.down(AIR_HEIGHT);
			
			boolean[] isLakeBlock = generateLakeShape(rand);
			
			//Checks if this lake is fine to generate with the surrounding blocks
			if (!isValidLake(isLakeBlock, reader, pos, config.getLakeState()))
				return false;
			
			//Places the core lake blocks
			for (int x = 0; x < 16; x++) {
				for (int z = 0; z < 16; z++) {
					for (int y = 0; y < 8; y++) {
						if (isLakeBlock[index(x, y, z)]) {
							reader.setBlockState(pos.add(x, y, z), isLiquidHeight(y) ? config.getLakeState() : Blocks.AIR.getDefaultState(), Constants.BlockFlags.BLOCK_UPDATE);
						}
					}
				}
			}
			
			grassifyExposedDirt(isLakeBlock, reader, pos);
			
			if (config.hasEdgeState())
				rockifyEdge(isLakeBlock, reader, pos, rand, config.getEdgeState());
			
			if (config.getLakeState().getMaterial() == Material.WATER)
				freezeSurface(reader, pos);
			
			return true;
		}
		return false;
	}
	
	private boolean[] generateLakeShape(Random rand) {
		boolean[] isLakeBlock = new boolean[2048];
		int ellipsoids = rand.nextInt(4) + 4;
		
		//Randomizes a set of ellipsoids, which determine which blocks that the lake will consist of
		for (int count = 0; count < ellipsoids; count++) {
			double xSize = rand.nextDouble() * 6.0D + 3.0D;
			double ySize = rand.nextDouble() * 4.0D + 2.0D;
			double zSize = rand.nextDouble() * 6.0D + 3.0D;
			double xPos = rand.nextDouble() * (16.0D - xSize - 2.0D) + 1.0D + xSize / 2.0D;
			double yPos = rand.nextDouble() * (8.0D - ySize - 4.0D) + 2.0D + ySize / 2.0D;
			double zPos = rand.nextDouble() * (16.0D - zSize - 2.0D) + 1.0D + zSize / 2.0D;
			
			for (int x = 1; x < 15; x++) {
				for (int z = 1; z < 15; z++) {
					for (int y = 1; y < 7; y++) {
						double xDist = (x - xPos) / (xSize / 2.0D);
						double yDist = (y - yPos) / (ySize / 2.0D);
						double zDist = (z - zPos) / (zSize / 2.0D);
						double dist = xDist * xDist + yDist * yDist + zDist * zDist;
						if (dist < 1.0D)
							isLakeBlock[index(x, y, z)] = true;
					}
				}
			}
		}
		return isLakeBlock;
	}
	
	private boolean isValidLake(boolean[] isLakeBlock, ISeedReader reader, BlockPos pos, BlockState lakeState) {
		for(int x = 0; x < 16; x++) {
			for(int z = 0; z < 16; z++) {
				for(int y = 0; y < 8; y++) {
					if (isEdge(isLakeBlock, x, y, z)) {
						Material material = reader.getBlockState(pos.add(x, y, z)).getMaterial();
						//Disallow lake generation if a liquid is bordering the lake at air height
						if (!isLiquidHeight(y) && material.isLiquid()) {
							return false;
						}
						
						//Disallow lake generation if a non-solid is bordering the lake at liquid height,
						// unless that non-solid is what this lake is made of
						if (isLiquidHeight(y) && !material.isSolid() && reader.getBlockState(pos.add(x, y, z)) != lakeState) {
							return false;
						}
					}
				}
			}
		}
		return true;
	}
	
	private void grassifyExposedDirt(boolean[] isLakeBlock, ISeedReader reader, BlockPos pos) {
		for(int x = 0; x < 16; x++) {
			for(int z = 0; z < 16; z++) {
				for(int y = AIR_HEIGHT; y < 8; y++) {
					if (isLakeBlock[index(x, y, z)]) {
						BlockPos dirtPos = pos.add(x, y - 1, z);
						//The vanilla version would replace dirt with grass (or mycelium),
						// which didn't seem appropriate for our shrub-lands biome
						ISurfaceBuilderConfig surfaceConfig = reader.getBiome(dirtPos).getGenerationSettings().getSurfaceBuilderConfig();
						if (reader.getBlockState(dirtPos).getBlock() == surfaceConfig.getUnder().getBlock() && reader.getLightFor(LightType.SKY, pos.add(x, y, z)) > 0) {
							reader.setBlockState(dirtPos, surfaceConfig.getTop(), Constants.BlockFlags.BLOCK_UPDATE);
						}
					}
				}
			}
		}
	}
	
	private void rockifyEdge(boolean[] isLakeBlock, ISeedReader reader, BlockPos pos, Random rand, BlockState stone) {
		for(int x = 0; x < 16; x++) {
			for(int z = 0; z < 16; z++) {
				for(int y = 0; y < 8; y++) {
					if (isEdge(isLakeBlock, x, y, z) && (isLiquidHeight(y) || rand.nextInt(2) != 0)
							&& reader.getBlockState(pos.add(x, y, z)).getMaterial().isSolid()) {
						reader.setBlockState(pos.add(x, y, z), stone, Constants.BlockFlags.BLOCK_UPDATE);
					}
				}
			}
		}
	}
	
	private void freezeSurface(ISeedReader reader, BlockPos pos) {
		for(int x = 0; x < 16; x++) {
			for(int z = 0; z < 16; z++) {
				BlockPos icePos = pos.add(x, AIR_HEIGHT, z);
				if (reader.getBiome(icePos).doesWaterFreeze(reader, icePos, false)) {
					reader.setBlockState(icePos, Blocks.ICE.getDefaultState(), Constants.BlockFlags.BLOCK_UPDATE);
				}
			}
		}
	}
	
	private static BlockPos getFirstSolidBlock(ISeedReader reader, BlockPos pos) {
		while(pos.getY() > AIR_HEIGHT + 1 && reader.isAirBlock(pos)) {
			pos = pos.down();
		}
		return pos;
	}
	
	private static int index(int x, int y, int z) {
		return (x * 16 + z) * 8 + y;
	}
	
	private static final int AIR_HEIGHT = 4;
	
	private static boolean isLiquidHeight(int y) {
		return y < AIR_HEIGHT;
	}
	
	private static boolean isEdge(boolean[] isLakeBlock, int x, int y, int z) {
		return !isLakeBlock[index(x, y, z)] &&
				(x < 15 && isLakeBlock[index(x + 1, y, z)] || x > 0 && isLakeBlock[index(x - 1, y, z)]
						|| z < 15 && isLakeBlock[index(x, y, z + 1)] || z > 0 && isLakeBlock[index(x, y, z - 1)]
						|| y < 7 && isLakeBlock[index(x, y + 1, z)] || y > 0 && isLakeBlock[index(x, y - 1, z)]);
	}
}