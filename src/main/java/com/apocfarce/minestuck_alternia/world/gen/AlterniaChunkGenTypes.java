package com.apocfarce.minestuck_alternia.world.gen;

import com.apocfarce.minestuck_alternia.MinestuckAlternia;
import net.minecraft.world.gen.ChunkGeneratorType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class AlterniaChunkGenTypes
{
	public static final DeferredRegister<ChunkGeneratorType<?, ?>> REGISTER = DeferredRegister.create(ForgeRegistries.CHUNK_GENERATOR_TYPES, MinestuckAlternia.MOD_ID);
	
	
}