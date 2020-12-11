package com.apocfarce.minestuck_alternia.world.biome;

import com.apocfarce.minestuck_alternia.MinestuckAlternia;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, modid = MinestuckAlternia.MOD_ID)
public class AlterniaBiomes {
	
	public static final BiomeDictionary.Type ALTERNIA = Type.getType("ALTERNIA");
	
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
	
	@SubscribeEvent
	public static void registerBiomes(RegistryEvent.Register<Biome> event) {
		IForgeRegistry<Biome> registry = event.getRegistry();
		register(registry, PLAINS, WarmBiomeMaker.makePlains());
		register(registry, VOLCANIC_FIELD, WarmBiomeMaker.makeVolcanicFields());
		register(registry, SHRUB_LAND, WarmBiomeMaker.makeShrublands());
		register(registry, MIRRAGE_FOREST, CoolBiomeMaker.makeMirrageWoods());
		register(registry, PYRAL_FOREST, CoolBiomeMaker.makePyralWoods());
		register(registry, MIXED_FOREST, CoolBiomeMaker.makeMixedWoods());
		register(registry, COLORED_DESERT, DesertBiomeMaker.makeRainbowDesert());
	}
	
	private static void register(IForgeRegistry<Biome> registry, RegistryKey<Biome> key, Biome biome) {
		registry.register(biome.setRegistryName(key.getLocation()));
	}
	
	public static void initBiomeTypes() {
		BiomeDictionary.addTypes(PLAINS, ALTERNIA, Type.PLAINS);
		BiomeDictionary.addTypes(VOLCANIC_FIELD, ALTERNIA, Type.WASTELAND);
		BiomeDictionary.addTypes(SHRUB_LAND, ALTERNIA, Type.SPARSE, Type.WASTELAND);
		BiomeDictionary.addTypes(MIRRAGE_FOREST, ALTERNIA, Type.FOREST);
		BiomeDictionary.addTypes(PYRAL_FOREST, ALTERNIA, Type.FOREST);
		BiomeDictionary.addTypes(MIXED_FOREST, ALTERNIA, Type.FOREST);
		BiomeDictionary.addTypes(COLORED_DESERT, ALTERNIA, Type.HOT, Type.DRY, Type.SANDY);
	}
}