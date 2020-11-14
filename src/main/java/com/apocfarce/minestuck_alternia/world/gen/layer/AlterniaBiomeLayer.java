package com.apocfarce.minestuck_alternia.world.gen.layer;

import com.apocfarce.minestuck_alternia.world.biome.provider.AlterniaBiomeProvider;
import com.google.common.collect.ImmutableList;

import net.minecraft.util.registry.Registry;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.INoiseRandom;
import net.minecraft.world.gen.OverworldGenSettings;
import net.minecraft.world.gen.layer.traits.IC0Transformer;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeManager.BiomeEntry;
import net.minecraftforge.common.BiomeManager.BiomeType;

public class AlterniaBiomeLayer implements IC0Transformer {
   private static final int BIRCH_FOREST = Registry.BIOME.getId(Biomes.BIRCH_FOREST);
   private static final int DESERT = Registry.BIOME.getId(Biomes.DESERT);
   private static final int MOUNTAINS = Registry.BIOME.getId(Biomes.MOUNTAINS);
   private static final int FOREST = Registry.BIOME.getId(Biomes.FOREST);
   private static final int SNOWY_TUNDRA = Registry.BIOME.getId(Biomes.SNOWY_TUNDRA);
   private static final int JUNGLE = Registry.BIOME.getId(Biomes.JUNGLE);
   private static final int BADLANDS_PLATEAU = Registry.BIOME.getId(Biomes.BADLANDS_PLATEAU);
   private static final int WOODED_BADLANDS_PLATEAU = Registry.BIOME.getId(Biomes.WOODED_BADLANDS_PLATEAU);
   private static final int MUSHROOM_FIELDS = Registry.BIOME.getId(Biomes.MUSHROOM_FIELDS);
   private static final int PLAINS = Registry.BIOME.getId(Biomes.PLAINS);
   private static final int GIANT_TREE_TAIGA = Registry.BIOME.getId(Biomes.GIANT_TREE_TAIGA);
   private static final int DARK_FOREST = Registry.BIOME.getId(Biomes.DARK_FOREST);
   private static final int SAVANNA = Registry.BIOME.getId(Biomes.SAVANNA);
   private static final int SWAMP = Registry.BIOME.getId(Biomes.SWAMP);
   private static final int TAIGA = Registry.BIOME.getId(Biomes.TAIGA);
   private static final int SNOWY_TAIGA = Registry.BIOME.getId(Biomes.SNOWY_TAIGA);
   @SuppressWarnings("unchecked")
   private java.util.List<BiomeEntry>[] biomes = new java.util.ArrayList[BiomeType.values().length];
   private final OverworldGenSettings settings;

   public AlterniaBiomeLayer(WorldType p_i48641_1_, OverworldGenSettings p_i48641_2_) {
      for (BiomeType type : BiomeType.values()) {
         ImmutableList<BiomeEntry> biomesToAdd = AlterniaBiomeProvider.getBiomes(type);
         int idx = type.ordinal();

         if (biomes[idx] == null) biomes[idx] = new java.util.ArrayList<BiomeEntry>();
         if (biomesToAdd != null) biomes[idx].addAll(biomesToAdd);
      }

      int desertIdx = BiomeType.DESERT.ordinal();



      this.settings = p_i48641_2_;

   }

   public int apply(INoiseRandom context, int value) {
      if (this.settings != null && this.settings.getBiomeId() >= 0) {
         return this.settings.getBiomeId();
      } else {
         int i = (value & 3840) >> 8;
         value = value & -3841;
         if (!AlterniaLayerUtil.isOcean(value) && value != MUSHROOM_FIELDS) {
            switch(value) {
            case 1:
               if (i > 0) {
                  return context.random(3) == 0 ? BADLANDS_PLATEAU : WOODED_BADLANDS_PLATEAU;
               }

               return Registry.BIOME.getId(getWeightedBiomeEntry(BiomeType.DESERT, context).biome);
            case 2:
               if (i > 0) {
                  return JUNGLE;
               }

               return Registry.BIOME.getId(getWeightedBiomeEntry(BiomeType.WARM, context).biome);
            case 3:
               if (i > 0) {
                  return GIANT_TREE_TAIGA;
               }

               return Registry.BIOME.getId(getWeightedBiomeEntry(BiomeType.COOL, context).biome);
            case 4:
               return Registry.BIOME.getId(getWeightedBiomeEntry(BiomeType.ICY, context).biome);
            default:
               return MUSHROOM_FIELDS;
            }
         } else {
            return value;
         }
      }
   }

   protected BiomeEntry getWeightedBiomeEntry(BiomeType type, INoiseRandom context) {
      java.util.List<BiomeEntry> biomeList = biomes[type.ordinal()];
      int totalWeight = net.minecraft.util.WeightedRandom.getTotalWeight(biomeList);
      int weight = BiomeManager.isTypeListModded(type)?context.random(totalWeight):context.random(totalWeight / 10) * 10;
      return (BiomeEntry)net.minecraft.util.WeightedRandom.getRandomItem(biomeList, weight);
   }
}