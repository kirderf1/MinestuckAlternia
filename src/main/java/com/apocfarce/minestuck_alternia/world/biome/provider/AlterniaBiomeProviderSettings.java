package com.apocfarce.minestuck_alternia.world.biome.provider;

import com.apocfarce.minestuck_alternia.world.gen.AlterniaGenSettings;

import net.minecraft.world.WorldType;
import net.minecraft.world.biome.provider.IBiomeProviderSettings;
import net.minecraft.world.storage.WorldInfo;

public class AlterniaBiomeProviderSettings implements IBiomeProviderSettings {
   private final long seed;
   private final WorldType worldType;
   private AlterniaGenSettings generatorSettings;
   
   public AlterniaBiomeProviderSettings(WorldInfo info) {
      this.seed = info.getSeed();
      this.worldType = info.getGenerator();
   }
   
   public AlterniaBiomeProviderSettings setGeneratorSettings(AlterniaGenSettings p_205441_1_) {
      this.generatorSettings = p_205441_1_;
      return this;
   }
   
   public long getSeed() {
      return seed;
   }
   
   public WorldType getWorldType() {
      return worldType;
   }
   
   public AlterniaGenSettings getGeneratorSettings() {
      return this.generatorSettings;
   }
}