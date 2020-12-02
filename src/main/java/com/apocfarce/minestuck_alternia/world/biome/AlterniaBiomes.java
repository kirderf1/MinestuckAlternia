package com.apocfarce.minestuck_alternia.world.biome;

import com.apocfarce.minestuck_alternia.MinestuckAlternia;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class AlterniaBiomes {
	
	public static final DeferredRegister<Biome> REGISTER = DeferredRegister.create(ForgeRegistries.BIOMES, MinestuckAlternia.MOD_ID);
	
	public static final RegistryObject<AlterniaPlains> ALTERNIA_PLAINS = REGISTER.register("alternia_plains", AlterniaPlains::new);
	public static final RegistryObject<VolcanicFieldsBiome> VOLCANIC_FIELD = REGISTER.register("volcanic_fields", VolcanicFieldsBiome::new);
	public static final RegistryObject<ShrublandBiome> SHRUBLAND = REGISTER.register("shrub_land", ShrublandBiome::new);
	
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
		VOLCANIC_FIELD.get().addFeatures();
		SHRUBLAND.get().addFeatures();
	}
}