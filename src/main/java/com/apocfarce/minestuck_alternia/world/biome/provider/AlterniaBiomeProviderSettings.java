package com.apocfarce.minestuck_alternia.world.biome.provider;

import net.minecraft.world.WorldType;
import net.minecraft.world.biome.provider.IBiomeProviderSettings;
import net.minecraft.world.gen.OverworldGenSettings;
import net.minecraft.world.storage.WorldInfo;

public class AlterniaBiomeProviderSettings implements IBiomeProviderSettings {
   private final long seed;
   private final WorldType worldType;
   private OverworldGenSettings generatorSettings;
   
   public AlterniaBiomeProviderSettings(WorldInfo info) {
      this.seed = info.getSeed();
      this.worldType = info.getGenerator();
   }
   
   public AlterniaBiomeProviderSettings setGeneratorSettings(OverworldGenSettings settings) {
      this.generatorSettings = settings;
      return this;
   }
   
   public long getSeed() {
      return seed;
   }
   
   public WorldType getWorldType() {
      return worldType;
   }
   
   public OverworldGenSettings getGeneratorSettings() {
      return this.generatorSettings;
   }
}