package com.apocfarce.minestuck_alternia.world.gen;

import net.minecraft.world.gen.ChunkGeneratorType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class GenTypesHandeler
{
	public static ChunkGeneratorType<AlterniaGenSettings, AlterniaChunkGenerator> ALTERNIA;
	
	@SubscribeEvent
	public static void registerChunkGenerators(RegistryEvent.Register<ChunkGeneratorType<?, ?>> event)
	{
		ALTERNIA = (ChunkGeneratorType<AlterniaGenSettings, AlterniaChunkGenerator>) new ChunkGeneratorType<AlterniaGenSettings, AlterniaChunkGenerator>(AlterniaChunkGenerator::new, false, AlterniaGenSettings::new).setRegistryName("minestuck_alternia:alternia");
		event.getRegistry().register(ALTERNIA);
	}
}
