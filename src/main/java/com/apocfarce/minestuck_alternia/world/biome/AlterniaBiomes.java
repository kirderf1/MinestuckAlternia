package com.apocfarce.minestuck_alternia.world.biome;

import com.apocfarce.minestuck_alternia.MinestuckAlternia;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class AlterniaBiomes {
	
	public static final DeferredRegister<Biome> REGISTER = DeferredRegister.create(ForgeRegistries.BIOMES, MinestuckAlternia.MOD_ID);
	
	public static final RegistryObject<Biome> ALTERNIA_PLAINS = REGISTER.register("plains", WarmBiomeMaker::makePlains);
	public static final RegistryObject<Biome> VOLCANIC_FIELD = REGISTER.register("volcanic_fields", WarmBiomeMaker::makeVolcanicFields);
	public static final RegistryObject<Biome> SHRUBLAND = REGISTER.register("shrub_land", WarmBiomeMaker::makeShrublands);
	
	public static final RegistryObject<Biome> MIRRAGE_FOREST = REGISTER.register("mirrage_forest", CoolBiomeMaker::makeMirrageWoods);
	public static final RegistryObject<Biome> PYRAL_FOREST = REGISTER.register("pyral_forest", CoolBiomeMaker::makePyralWoods);
	public static final RegistryObject<Biome> MIXED_FOREST = REGISTER.register("mixed_forest", CoolBiomeMaker::makeMixedWoods);
	
	public static final RegistryObject<Biome> COLORED_DESERT = REGISTER.register("colored_desert", DesertBiomeMaker::makeRainbowDesert);

}