package com.apocfarce.minestuck_alternia.world.gen.layer;

import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.INoiseRandom;
import net.minecraft.world.gen.layer.LayerUtil;
import net.minecraft.world.gen.layer.traits.ICastleTransformer;

public enum AlterniaEdgeBiomeLayer implements ICastleTransformer {
	INSTANCE;

	private static final int DESERT = Registry.BIOME.getId(Biomes.DESERT);
	private static final int MOUNTAINS = Registry.BIOME.getId(Biomes.MOUNTAINS);
	private static final int WOODED_MOUNTAINS = Registry.BIOME.getId(Biomes.WOODED_MOUNTAINS);
	private static final int SNOWY_TUNDRA = Registry.BIOME.getId(Biomes.SNOWY_TUNDRA);
	private static final int JUNGLE = Registry.BIOME.getId(Biomes.JUNGLE);
	private static final int BAMBOO_JUNGLE = Registry.BIOME.getId(Biomes.BAMBOO_JUNGLE);
	private static final int JUNGLE_EDGE = Registry.BIOME.getId(Biomes.JUNGLE_EDGE);
	private static final int BADLANDS = Registry.BIOME.getId(Biomes.BADLANDS);
	private static final int BADLANDS_PLATEAU = Registry.BIOME.getId(Biomes.BADLANDS_PLATEAU);
	private static final int WOODED_BADLANDS_PLATEAU = Registry.BIOME.getId(Biomes.WOODED_BADLANDS_PLATEAU);
	private static final int PLAINS = Registry.BIOME.getId(Biomes.PLAINS);
	private static final int GIANT_TREE_TAIGA = Registry.BIOME.getId(Biomes.GIANT_TREE_TAIGA);
	private static final int MOUNTAIN_EDGE = Registry.BIOME.getId(Biomes.MOUNTAIN_EDGE);
	private static final int SWAMP = Registry.BIOME.getId(Biomes.SWAMP);
	private static final int TAIGA = Registry.BIOME.getId(Biomes.TAIGA);
	private static final int SNOWY_TAIGA = Registry.BIOME.getId(Biomes.SNOWY_TAIGA);

	public int apply(INoiseRandom context, int north, int west, int south, int east, int center) {
		int[] aint = new int[1];
//		if(this.replaceBiomeEdge(aint, north, west, south, east, center, AlterniaBiomeHandeler.AlterniaDeepForest, AlterniaBiomeHandeler.AlterniaWoods)) {
//			return aint[0];
//		}
		
		
		return center;
		
		
		
/*		int[] aint = new int[1];
		if (	!this.func_202751_a(aint, north, west, south, east, center, MOUNTAINS, MOUNTAIN_EDGE)//if center is not a type of mountian
			&&	!this.replaceBiomeEdge(aint, north, west, south, east, center, WOODED_BADLANDS_PLATEAU, BADLANDS)//
			&&	!this.replaceBiomeEdge(aint, north, west, south, east, center, BADLANDS_PLATEAU, BADLANDS)
			&&	!this.replaceBiomeEdge(aint, north, west, south, east, center, GIANT_TREE_TAIGA, TAIGA)) {
			if (center == DESERT) {
				if(north == SNOWY_TUNDRA || west == SNOWY_TUNDRA || east == SNOWY_TUNDRA || south == SNOWY_TUNDRA){
					return WOODED_MOUNTAINS;
				}
			}
			if (center == SWAMP) {
				if (north == DESERT || west == DESERT || east == DESERT || south == DESERT || north == SNOWY_TAIGA || west == SNOWY_TAIGA || east == SNOWY_TAIGA || south == SNOWY_TAIGA || north == SNOWY_TUNDRA || west == SNOWY_TUNDRA || east == SNOWY_TUNDRA || south == SNOWY_TUNDRA) {
					return PLAINS;
				}
				
				if (north == JUNGLE || south == JUNGLE || west == JUNGLE || east == JUNGLE || north == BAMBOO_JUNGLE || south == BAMBOO_JUNGLE || west == BAMBOO_JUNGLE || east == BAMBOO_JUNGLE) {
					return JUNGLE_EDGE;
				}	
			}

				return center;

		} else {
			return aint[0];
		}*/
	}		
	/**
	 * Creates a border around similar neighboring biome types.
	 */
	private boolean func_202751_a(int[] aint, int north, int west, int south, int east, int center, int midID, int edgeID) {
		if (!LayerUtil.areBiomesSimilar(center, midID)) {
			return false;
		} else {
			if (this.canBiomesBeNeighbors(north, midID) && this.canBiomesBeNeighbors(west, midID) && this.canBiomesBeNeighbors(east, midID) && this.canBiomesBeNeighbors(south, midID)) {
				aint[0] = center;
			} else {
				aint[0] = edgeID;
			}
			
			return true;
		}
	}
	
   /**
    * Creates a border around a biome.
    */
   private boolean replaceBiomeEdge(int[] aint, int north, int west, int south, int east, int center, Biome midBiome, Biome edgeBiome) {
	  int midBiomeID = Registry.BIOME.getId(midBiome);
      if (center != midBiomeID) {
         return false;
      } else {
         if (LayerUtil.areBiomesSimilar(north, midBiomeID) && LayerUtil.areBiomesSimilar(west, midBiomeID) && LayerUtil.areBiomesSimilar(east, midBiomeID) && LayerUtil.areBiomesSimilar(south, midBiomeID)) {
        	 aint[0] = center;
         } else {
        	 aint[0] = Registry.BIOME.getId(edgeBiome);
         }

         return true;
      }
   }

   /**
    * Returns if two biomes can logically be neighbors. If one is hot and the other cold, for example, it returns false.
    */
   private boolean canBiomesBeNeighbors(int biomeID1, int biomeID2) {
      if (LayerUtil.areBiomesSimilar(biomeID1, biomeID2)) {
         return true;
      } else {
         Biome biome1 = Registry.BIOME.getByValue(biomeID1);
         Biome biome2 = Registry.BIOME.getByValue(biomeID2);
         if (biome1 != null && biome2 != null) {
            Biome.TempCategory biome$tempcategory = biome1.getTempCategory();
            Biome.TempCategory biome$tempcategory1 = biome2.getTempCategory();
            return biome$tempcategory == biome$tempcategory1 || biome$tempcategory == Biome.TempCategory.MEDIUM || biome$tempcategory1 == Biome.TempCategory.MEDIUM;
         } else {
            return false;
         }
      }
   }
}