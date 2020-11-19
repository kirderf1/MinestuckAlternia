package com.apocfarce.minestuck_alternia.world.biome;

import com.apocfarce.minestuck_alternia.Minestuck_alternia;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class AlterniaBiomes {
	
	public static final DeferredRegister<Biome> REGISTER = DeferredRegister.create(ForgeRegistries.BIOMES, Minestuck_alternia.MOD_ID);
	
	public static final RegistryObject<AlterniaPlains> ALTERNIA_PLAINS = REGISTER.register("alternia_plains", AlterniaPlains::new);
	
	public static final RegistryObject<MirrageWoodsBiome> MIRRAGE_FOREST = REGISTER.register("mirrage_forest", MirrageWoodsBiome::new);
	public static final RegistryObject<PyralWoodsBiome> PYRAL_FOREST = REGISTER.register("pyral_forest", PyralWoodsBiome::new);
	public static final RegistryObject<MixedWoodsBiome> MIXED_FOREST = REGISTER.register("mixed_forest", MixedWoodsBiome::new);
	
	public static final RegistryObject<RainbowDesertBiome> COLORED_DESERT = REGISTER.register("colored_desert", RainbowDesertBiome::new);
	
	public static void initBiomeFeatures() {
		ALTERNIA_PLAINS.get().addFeatures();
		MIRRAGE_FOREST.get().addFeatures();
		PYRAL_FOREST.get().addFeatures();
		MIXED_FOREST.get().addFeatures();
		COLORED_DESERT.get().addFeatures();
	}
}