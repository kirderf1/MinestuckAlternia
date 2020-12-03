package com.apocfarce.minestuck_alternia.world.biome.provider;

import com.apocfarce.minestuck_alternia.MinestuckAlternia;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;


public class AlterniaBiomeProviders {
	
	public static void init() {
		Registry.register(Registry.BIOME_PROVIDER_CODEC, new ResourceLocation(MinestuckAlternia.MOD_ID, "alternia"), AlterniaBiomeProvider.CODEC);
	}
}