package com.apocfarce.minestuck_alternia.world.biome;

import com.apocfarce.minestuck_alternia.MinestuckAlternia;
import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;

import java.util.List;

public class AlterniaBiomes {
	
	public static final RegistryKey<Biome> PLAINS = makeKey("plains");
	public static final RegistryKey<Biome> VOLCANIC_FIELD = makeKey("volcanic_fields");
	public static final RegistryKey<Biome> SHRUB_LAND = makeKey("shrub_land");
	
	public static final RegistryKey<Biome> MIRRAGE_FOREST = makeKey("mirrage_forest");
	public static final RegistryKey<Biome> PYRAL_FOREST = makeKey("pyral_forest");
	public static final RegistryKey<Biome> MIXED_FOREST = makeKey("mixed_forest");
	
	public static final RegistryKey<Biome> COLORED_DESERT = makeKey("colored_desert");
	
	private static RegistryKey<Biome> makeKey(String name) {
		return RegistryKey.getOrCreateKey(Registry.BIOME_KEY, new ResourceLocation(MinestuckAlternia.MOD_ID, name));
	}
	
	public static List<Pair<RegistryKey<Biome>, Biome>> makeBiomesForDataGen() {
		return ImmutableList.of(Pair.of(PLAINS, WarmBiomeMaker.makePlains()), Pair.of(VOLCANIC_FIELD, WarmBiomeMaker.makeVolcanicFields()),
				Pair.of(SHRUB_LAND, WarmBiomeMaker.makeShrublands()),
				Pair.of(MIRRAGE_FOREST, CoolBiomeMaker.makeMirrageWoods()), Pair.of(PYRAL_FOREST, CoolBiomeMaker.makePyralWoods()),
				Pair.of(MIXED_FOREST, CoolBiomeMaker.makeMixedWoods()),
				Pair.of(COLORED_DESERT, DesertBiomeMaker.makeRainbowDesert()));
	}
}