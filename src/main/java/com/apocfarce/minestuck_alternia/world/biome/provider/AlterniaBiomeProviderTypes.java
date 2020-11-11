package com.apocfarce.minestuck_alternia.world.biome.provider;

import com.apocfarce.minestuck_alternia.Minestuck_alternia;
import net.minecraft.world.biome.provider.BiomeProviderType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;


public class AlterniaBiomeProviderTypes {
	public static final DeferredRegister<BiomeProviderType<?, ?>> REGISTER = DeferredRegister.create(ForgeRegistries.BIOME_PROVIDER_TYPES, Minestuck_alternia.MOD_ID);
	
	public static RegistryObject<BiomeProviderType<AlterniaBiomeProviderSettings,AlterniaBiomeProvider>> ALTERNIA
			= REGISTER.register("alternia", () -> new BiomeProviderType<>(AlterniaBiomeProvider::new, AlterniaBiomeProviderSettings::new));
	
}