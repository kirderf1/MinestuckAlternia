package com.apocfarce.minestuck_alternia.world.biome.provider;

import java.util.function.Function;
import java.util.function.Supplier;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.provider.BiomeProvider;
import net.minecraft.world.biome.provider.BiomeProviderType;
import net.minecraft.world.biome.provider.IBiomeProviderSettings;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.registries.IForgeRegistry;



public class AlterniaBioimeProviderHandeler{
	public static BiomeProviderType<AlterniaBiomeProviderSettings,AlterniaBiomeProvider> ALTERNIA;
	
	public static void RegisterBiomeProviderTypes(RegistryEvent.Register<BiomeProviderType<?, ?>> event) {
		IForgeRegistry<BiomeProviderType<?, ?>> registery = event.getRegistry();
		AlterniaBiomeProvider.AddVanillaBiomes();
		ALTERNIA = register(registery,new ResourceLocation("alternia"),AlterniaBiomeProvider::new,AlterniaBiomeProviderSettings::new);	
	}
	
	private static <C extends IBiomeProviderSettings, T extends BiomeProvider> BiomeProviderType<C,T> register(IForgeRegistry<BiomeProviderType<?, ?>> registry,ResourceLocation key, Function<C,T> provider, Supplier<C> settings){
		BiomeProviderType<C,T> type = new BiomeProviderType<C,T>(provider,settings);
		type.setRegistryName(key);
		registry.register(type);
		return(type);
	}	
	
	
	
		
}