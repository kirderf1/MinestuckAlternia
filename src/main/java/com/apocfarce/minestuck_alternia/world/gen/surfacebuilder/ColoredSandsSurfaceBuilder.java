package com.apocfarce.minestuck_alternia.world.gen.surfacebuilder;

import java.util.Arrays;
import java.util.Random;
import java.util.function.Function;

import com.mojang.datafixers.Dynamic;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.SharedSeedRandom;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.PerlinNoiseGenerator;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

public class ColoredSandsSurfaceBuilder extends SurfaceBuilder<SurfaceBuilderConfig> {
	private static final BlockState red_concrete_powder = Blocks.RED_CONCRETE_POWDER.getDefaultState();
	private static final BlockState pink_concrete_powder = Blocks.PINK_CONCRETE_POWDER.getDefaultState();
	private static final BlockState cyan_concrete_powder = Blocks.CYAN_CONCRETE_POWDER.getDefaultState();
	private static final BlockState light_Blue_concrete_powder = Blocks.LIGHT_BLUE_CONCRETE_POWDER.getDefaultState();
	
	
	private static final BlockState red_concrete = Blocks.RED_CONCRETE.getDefaultState();
	private static final BlockState pink_concrete = Blocks.PINK_CONCRETE.getDefaultState();
	private static final BlockState cyan_concrete = Blocks.CYAN_CONCRETE.getDefaultState();
	private static final BlockState light_Blue_concrete = Blocks.LIGHT_BLUE_CONCRETE.getDefaultState();

	protected BlockState[] field_215432_a;
	protected long field_215433_b;
	protected PerlinNoiseGenerator octive1;
	protected PerlinNoiseGenerator octive2;
	protected PerlinNoiseGenerator octive3;
	
	public ColoredSandsSurfaceBuilder(Function<Dynamic<?>, ? extends SurfaceBuilderConfig> p_i51317_1_) {
		super(p_i51317_1_);
	}
	
	public void buildSurface(Random random, IChunk chunkIn, Biome biomeIn, int x, int z, int startHeight, double noise, BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed, SurfaceBuilderConfig config) {
		int xInChunk = x & 15;
		int zInChunk = z & 15;
		int color = (int)(noise / 3.0D + 3.0D + random.nextDouble() * 0.25D);
		
		BlockPos.Mutable blockpos$mutableblockpos = new BlockPos.Mutable();
		BlockState surfaceBlock;
		int depth = 0;

		for(int y = startHeight; y >= 0; --y) {
			if (depth<8) {
				blockpos$mutableblockpos.setPos(xInChunk, y, zInChunk);
				if (depth<3) {
					switch(color) {
						case 0:surfaceBlock=light_Blue_concrete_powder;
						break;
						case 1:surfaceBlock=cyan_concrete_powder;
						break;
						case 2:surfaceBlock=red_concrete_powder;
						break;
						case 3:surfaceBlock=pink_concrete_powder;
						break;
						case 4:surfaceBlock=cyan_concrete_powder;
						break;
						case 5:surfaceBlock=light_Blue_concrete_powder;
						break;
						default:surfaceBlock=light_Blue_concrete_powder;
					}
				}else {
					switch(color) {
						case 0:surfaceBlock=light_Blue_concrete;
						break;
						case 1:surfaceBlock=cyan_concrete;
						break;
						case 2:surfaceBlock=red_concrete;
						break;
						case 3:surfaceBlock=pink_concrete;
						break;
						case 4:surfaceBlock=cyan_concrete;
						break;
						case 5:surfaceBlock=light_Blue_concrete;
						break;
						default:surfaceBlock=light_Blue_concrete;
					}
				}
				chunkIn.setBlockState(blockpos$mutableblockpos, surfaceBlock, false);
				depth++;
			}
			
			
		}
      
/*      BlockState blockstate = WHITE_TERRACOTTA;
      BlockState blockstate1 = biomeIn.getSurfaceBuilderConfig().getUnder();
      boolean flag = Math.cos(noise / 3.0D * Math.PI) > 0.0D;
      int l = -1;
      boolean flag1 = false;
      int depth = 0;
      BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();

      for(int y = startHeight; y >= 0; --y) {
         if (depth < 15) {
            blockpos$mutableblockpos.setPos(xInChunk, y, zInChunk);
            BlockState blockstate2 = chunkIn.getBlockState(blockpos$mutableblockpos);
            if (blockstate2.isAir()) {
               l = -1;
            } else if (blockstate2.getBlock() == defaultBlock.getBlock()) {
               if (l == -1) {
                  flag1 = false;
                  if (key <= 0) {
                     blockstate = Blocks.AIR.getDefaultState();
                     blockstate1 = defaultBlock;
                  } else if (y >= seaLevel - 4 && y <= seaLevel + 1) {
                     blockstate = WHITE_TERRACOTTA;
                     blockstate1 = biomeIn.getSurfaceBuilderConfig().getUnder();
                  }

                  if (y < seaLevel && (blockstate == null || blockstate.isAir())) {
                     blockstate = defaultFluid;
                  }

                  l = key + Math.max(0, y - seaLevel);
                  if (y >= seaLevel - 1) {
                     if (y > seaLevel + 3 + key) {
                        BlockState blockstate3;
                        if (y >= 64 && y <= 127) {
                           if (flag) {
                              blockstate3 = TERRACOTTA;
                           } else {
                              blockstate3 = this.func_215431_a(x, y, z);
                           }
                        } else {
                           blockstate3 = ORANGE_TERRACOTTA;
                        }

                        chunkIn.setBlockState(blockpos$mutableblockpos, blockstate3, false);
                     } else {
                        chunkIn.setBlockState(blockpos$mutableblockpos, biomeIn.getSurfaceBuilderConfig().getTop(), false);
                        flag1 = true;
                     }
                  } else {
                     chunkIn.setBlockState(blockpos$mutableblockpos, blockstate1, false);
                     Block block = blockstate1.getBlock();
                     if (block == Blocks.WHITE_TERRACOTTA || block == Blocks.ORANGE_TERRACOTTA || block == Blocks.MAGENTA_TERRACOTTA || block == Blocks.LIGHT_BLUE_TERRACOTTA || block == Blocks.YELLOW_TERRACOTTA || block == Blocks.LIME_TERRACOTTA || block == Blocks.PINK_TERRACOTTA || block == Blocks.GRAY_TERRACOTTA || block == Blocks.LIGHT_GRAY_TERRACOTTA || block == Blocks.CYAN_TERRACOTTA || block == Blocks.PURPLE_TERRACOTTA || block == Blocks.BLUE_TERRACOTTA || block == Blocks.BROWN_TERRACOTTA || block == Blocks.GREEN_TERRACOTTA || block == Blocks.RED_TERRACOTTA || block == Blocks.BLACK_TERRACOTTA) {
                        chunkIn.setBlockState(blockpos$mutableblockpos, ORANGE_TERRACOTTA, false);
                     }
                  }
               } else if (l > 0) {
                  --l;
                  if (flag1) {
                     chunkIn.setBlockState(blockpos$mutableblockpos, ORANGE_TERRACOTTA, false);
                  } else {
                     chunkIn.setBlockState(blockpos$mutableblockpos, this.func_215431_a(x, y, z), false);
                  }
               }

               ++depth;
            }
         }
      }*/

	}
	@Override
	public void setSeed(long seed) {
		if (this.field_215433_b != seed || this.field_215432_a == null) {
			this.func_215430_b(seed);
		}

		if (this.field_215433_b != seed || this.octive1 == null || this.octive2 == null) {
			SharedSeedRandom random = new SharedSeedRandom(seed);
			this.octive1 = new PerlinNoiseGenerator(random, 3, 0);
			this.octive2 = new PerlinNoiseGenerator(random, 0, 0);
		}
		
		this.field_215433_b = seed;
	}
	
   protected void func_215430_b(long p_215430_1_) {
      this.field_215432_a = new BlockState[64];
      Arrays.fill(this.field_215432_a, red_concrete_powder);
      SharedSeedRandom random = new SharedSeedRandom(p_215430_1_);
      this.octive3 = new PerlinNoiseGenerator(random, 0, 0);

      for(int l1 = 0; l1 < 64; ++l1) {
         l1 += random.nextInt(5) + 1;
         if (l1 < 64) {
            this.field_215432_a[l1] = pink_concrete_powder;
         }
      }

      int i2 = random.nextInt(4) + 2;

      for(int i = 0; i < i2; ++i) {
         int j = random.nextInt(3) + 1;
         int k = random.nextInt(64);

         for(int l = 0; k + l < 64 && l < j; ++l) {
            this.field_215432_a[k + l] = cyan_concrete_powder;
         }
      }

      int j2 = random.nextInt(4) + 2;

      for(int k2 = 0; k2 < j2; ++k2) {
         int i3 = random.nextInt(3) + 2;
         int l3 = random.nextInt(64);

         for(int i1 = 0; l3 + i1 < 64 && i1 < i3; ++i1) {
            this.field_215432_a[l3 + i1] = light_Blue_concrete_powder;
         }
      }

      int l2 = random.nextInt(4) + 2;

      for(int j3 = 0; j3 < l2; ++j3) {
         int i4 = random.nextInt(3) + 1;
         int k4 = random.nextInt(64);

         for(int j1 = 0; k4 + j1 < 64 && j1 < i4; ++j1) {
            this.field_215432_a[k4 + j1] = red_concrete_powder;
         }
      }

      int k3 = random.nextInt(3) + 3;
      int j4 = 0;

      for(int l4 = 0; l4 < k3; ++l4) {
         int i5 = 1;
         j4 += random.nextInt(16) + 4;

         for(int k1 = 0; j4 + k1 < 64 && k1 < 1; ++k1) {
            this.field_215432_a[j4 + k1] = WHITE_TERRACOTTA;
            if (j4 + k1 > 1 && random.nextBoolean()) {
               this.field_215432_a[j4 + k1 - 1] = light_Blue_concrete_powder;
            }

            if (j4 + k1 < 63 && random.nextBoolean()) {
               this.field_215432_a[j4 + k1 + 1] = light_Blue_concrete_powder;
            }
         }
      }

   }

}