package com.apocfarce.minestuck_alternia.world;

import com.apocfarce.minestuck_alternia.MinestuckAlternia;
import com.apocfarce.minestuck_alternia.world.biome.provider.AlterniaBiomeProvider;
import com.mojang.serialization.Lifecycle;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.SimpleRegistry;
import net.minecraft.world.Dimension;
import net.minecraft.world.DimensionType;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.DimensionSettings;
import net.minecraft.world.gen.NoiseChunkGenerator;
import net.minecraft.world.gen.settings.DimensionGeneratorSettings;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.server.FMLServerAboutToStartEvent;

@Mod.EventBusSubscriber
public class AlterniaDimensions {
	public static final RegistryKey<World> ALTERNIA_WORLD_KEY = RegistryKey.getOrCreateKey(Registry.WORLD_KEY, new ResourceLocation(MinestuckAlternia.MOD_ID,"alternia"));
	public static final RegistryKey<Dimension> ALTERNIA_DIM_KEY = RegistryKey.getOrCreateKey(Registry.DIMENSION_KEY, new ResourceLocation(MinestuckAlternia.MOD_ID,"alternia"));
	public static final RegistryKey<DimensionType> ALTERNIA_DIM_TYPE_KEY = RegistryKey.getOrCreateKey(Registry.DIMENSION_TYPE_KEY, new ResourceLocation(MinestuckAlternia.MOD_ID,"alternia"));
	public static final RegistryKey<DimensionSettings> ALTERNIA_GEN_SETTINGS_KEY = RegistryKey.getOrCreateKey(Registry.NOISE_SETTINGS_KEY, new ResourceLocation(MinestuckAlternia.MOD_ID,"alternia"));
	
	@SubscribeEvent
	public static void onServerAboutToStart(FMLServerAboutToStartEvent event) {
		DimensionGeneratorSettings settings = event.getServer().getServerConfiguration().getDimensionGeneratorSettings();
		long seed = settings.getSeed();
		SimpleRegistry<Dimension> registry = settings.func_236224_e_();
		Registry<DimensionType> dimensionTypeLookup = event.getServer().func_244267_aX().func_230520_a_();
		Registry<Biome> biomeLookup = event.getServer().func_244267_aX().getRegistry(Registry.BIOME_KEY);
		Registry<DimensionSettings> settingsLookup = event.getServer().func_244267_aX().getRegistry(Registry.NOISE_SETTINGS_KEY);
		
		if(!registry.getOptionalValue(ALTERNIA_DIM_KEY).isPresent())
			registry.register(ALTERNIA_DIM_KEY, new Dimension(() -> dimensionTypeLookup.getOrThrow(ALTERNIA_DIM_TYPE_KEY),
					getAlterniaChunkGenerator(biomeLookup, settingsLookup, seed)), Lifecycle.stable());
	}
	
	private static ChunkGenerator getAlterniaChunkGenerator(Registry<Biome> biomeLookup, Registry<DimensionSettings> settingsLookup, long seed) {
		return new NoiseChunkGenerator(new AlterniaBiomeProvider(seed, biomeLookup), seed, () -> settingsLookup.getOrThrow(ALTERNIA_GEN_SETTINGS_KEY));
	}
}