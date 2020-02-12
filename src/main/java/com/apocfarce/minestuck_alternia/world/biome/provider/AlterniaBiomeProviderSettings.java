package com.apocfarce.minestuck_alternia.world.biome.provider;

import com.apocfarce.minestuck_alternia.world.gen.AlterniaGenSettings;

import net.minecraft.world.biome.provider.IBiomeProviderSettings;
import net.minecraft.world.storage.WorldInfo;

public class AlterniaBiomeProviderSettings implements IBiomeProviderSettings {
   private WorldInfo worldInfo;
   private AlterniaGenSettings generatorSettings;

   public AlterniaBiomeProviderSettings setWorldInfo(WorldInfo info) {
      this.worldInfo = info;
      return this;
   }

   public AlterniaBiomeProviderSettings setGeneratorSettings(AlterniaGenSettings p_205441_1_) {
      this.generatorSettings = p_205441_1_;
      return this;
   }

   public WorldInfo getWorldInfo() {
      return this.worldInfo;
   }

   public AlterniaGenSettings getGeneratorSettings() {
      return this.generatorSettings;
   }
}