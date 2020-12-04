package com.apocfarce.minestuck_alternia.world.biome.provider;

import com.apocfarce.minestuck_alternia.world.biome.AlterniaBiomes;
import com.apocfarce.minestuck_alternia.world.biome.layer.AlterniaLayerUtil;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryLookupCodec;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.provider.BiomeProvider;
import net.minecraft.world.gen.layer.Layer;
import net.minecraftforge.common.BiomeManager.BiomeEntry;
import net.minecraftforge.common.BiomeManager.BiomeType;

import java.util.*;

public class AlterniaBiomeProvider extends BiomeProvider {
	public static final Codec<AlterniaBiomeProvider> CODEC = RecordCodecBuilder.create(builder ->
			builder.group(Codec.LONG.fieldOf("seed").stable().forGetter(provider -> provider.seed),
			RegistryLookupCodec.getLookUpCodec(Registry.BIOME_KEY).forGetter(provider -> provider.lookupRegistry))
			.apply(builder, builder.stable(AlterniaBiomeProvider::new)));
	
	private static final Map<BiomeType, List<BiomeEntry>> biomes = new EnumMap<>(BiomeType.class);
	private static final Map<BiomeType, List<BiomeEntry>> unmodifiableBiomes = new EnumMap<>(BiomeType.class);
   	private static final List<Biome> biomeSet = new ArrayList<>();
   	private final long seed;
	private final Layer genBiomes;
	private final Registry<Biome> lookupRegistry;
   
	public AlterniaBiomeProvider(long seed, Registry<Biome> lookupRegistry) {
		super(Collections.unmodifiableList(biomeSet));
		this.seed = seed;
		this.lookupRegistry = lookupRegistry;
		this.genBiomes = AlterniaLayerUtil.buildAlterniaProcedure(seed);
	}
	
	@Override
	protected Codec<? extends BiomeProvider> getBiomeProviderCodec() {
		return CODEC;
	}
	
	@Override
	public BiomeProvider getBiomeProvider(long seed) {
		return new AlterniaBiomeProvider(seed, lookupRegistry);
	}
	
	public static void initBiomeList() {
		//addVanilla(Biomes.BADLANDS, BiomeType.DESERT, 10);
		//addVanilla(Biomes.DESERT,BiomeType.DESERT, 20);
		
		addBiome(AlterniaBiomes.MIRRAGE_FOREST.get(), BiomeType.COOL, 10);
		addBiome(AlterniaBiomes.PYRAL_FOREST.get(), BiomeType.COOL, 10);
		addBiome(AlterniaBiomes.MIXED_FOREST.get(), BiomeType.COOL, 10);
		addBiome(AlterniaBiomes.ALTERNIA_PLAINS.get(), BiomeType.WARM, 30);
		addBiome(AlterniaBiomes.VOLCANIC_FIELD.get(), BiomeType.WARM,10);
		addBiome(AlterniaBiomes.SHRUBLAND.get(), BiomeType.WARM,10);
		addBiome(AlterniaBiomes.COLORED_DESERT.get(), BiomeType.DESERT, 30);
	}
	/* We can no longer modify vanilla biomes directly
	private static void addVanilla(Biome biome, BiomeType type, int weight) {
		//This is needed so that alternia structures are generated correctly. (alternia biomes also has this, but elsewhere)
		// This will not have an effect on the biomes in the overworld
		AlterniaBiomeFeatures.withCarvers(biome);
		AlterniaBiomeFeatures.withOres(biome);
		addBiome(biome, type, weight);
	}
	*/
	private static void addBiome(Biome biome, BiomeType type, int weight) {
		biomes.computeIfAbsent(type, AlterniaBiomeProvider::makeList).add(new BiomeEntry(WorldGenRegistries.BIOME.getOptionalKey(biome).get(),weight));
		biomeSet.add(biome);
	}
	
	private static List<BiomeEntry> makeList(BiomeType type) {
		List<BiomeEntry> list = new ArrayList<>();
		unmodifiableBiomes.put(type, Collections.unmodifiableList(list));
		return list;
	}
	
	public static List<BiomeEntry> getBiomes(BiomeType biomeType) {
		
		return unmodifiableBiomes.get(biomeType);
	}
	
	@Override
	public Biome getNoiseBiome(int x, int y, int z) {
		return genBiomes.func_242936_a(lookupRegistry, x, z);
	}
}