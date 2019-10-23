package com.apocfarce.minestuck_alternia.world.biome;

import com.apocfarce.minestuck_alternia.world.biome.provider.AlterniaBiomeProvider;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.EndMidlandsBiome;
import net.minecraftforge.common.BiomeManager.BiomeType;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.registries.IForgeRegistry;

public class AlterniaBiomeHandeler {
	public static Biome AlterniaTestBiome;
	
	public static void RegisterBiomes(Register<Biome> event) {
		IForgeRegistry<Biome> registry = event.getRegistry();
		AlterniaTestBiome =register(registry,new ResourceLocation("alternia_test"), new EndMidlandsBiome(),BiomeType.WARM,10);
		
	}
	public static Biome register(IForgeRegistry<Biome> registry,ResourceLocation name,Biome biome,BiomeType type,int weight) {
		biome.setRegistryName(name);
		registry.register(biome);
		AlterniaBiomeProvider.AddBiome(biome, type, weight);
		return biome;
	}
	

}
