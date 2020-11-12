package com.apocfarce.minestuck_alternia.world.gen;

import com.apocfarce.minestuck_alternia.Minestuck_alternia;
import net.minecraft.world.gen.ChunkGeneratorType;
import net.minecraft.world.gen.OverworldGenSettings;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class AlterniaChunkGenTypes
{
	public static final DeferredRegister<ChunkGeneratorType<?, ?>> REGISTER = DeferredRegister.create(ForgeRegistries.CHUNK_GENERATOR_TYPES, Minestuck_alternia.MOD_ID);
	
	
}