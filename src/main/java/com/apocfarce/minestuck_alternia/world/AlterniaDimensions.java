package com.apocfarce.minestuck_alternia.world;

import com.apocfarce.minestuck_alternia.MinestuckAlternia;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;

public class AlterniaDimensions {
	public static final RegistryKey<World> ALTERNIA_KEY = RegistryKey.getOrCreateKey(Registry.WORLD_KEY, new ResourceLocation(MinestuckAlternia.MOD_ID,"alternia"));
	
}
