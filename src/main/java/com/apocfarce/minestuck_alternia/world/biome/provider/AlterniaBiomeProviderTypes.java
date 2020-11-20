package com.apocfarce.minestuck_alternia.world.biome.provider;

import com.apocfarce.minestuck_alternia.MinestuckAlternia;
import net.minecraft.world.biome.provider.BiomeProviderType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;


public class AlterniaBiomeProviderTypes {
	public static final DeferredRegister<BiomeProviderType<?, ?>> REGISTER = DeferredRegister.create(ForgeRegistries.BIOME_PROVIDER_TYPES, MinestuckAlternia.MOD_ID);
	
	public static RegistryObject<BiomeProviderType<AlterniaBiomeProviderSettings,AlterniaBiomeProvider>> ALTERNIA
			= REGISTER.register("alternia", () -> new BiomeProviderType<>(AlterniaBiomeProvider::new, AlterniaBiomeProviderSettings::new));
	
}