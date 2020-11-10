package com.apocfarce.minestuck_alternia.world.biome.provider;

import java.util.*;

import javax.annotation.Nullable;

import com.apocfarce.minestuck_alternia.world.gen.AlterniaGenSettings;
import com.apocfarce.minestuck_alternia.world.gen.layer.AlterniaLayerUtil;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;

import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.biome.provider.BiomeProvider;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.layer.Layer;
import net.minecraft.world.storage.WorldInfo;
import net.minecraftforge.common.BiomeManager.BiomeEntry;
import net.minecraftforge.common.BiomeManager.BiomeType;

public class AlterniaBiomeProvider extends BiomeProvider {
	private final Layer genBiomes;
	private static final List<BiomeEntry>[] biomes = SetupBiomesList();
   	private static final Set<Biome> biomeSet = new HashSet<>();
   
	public AlterniaBiomeProvider(AlterniaBiomeProviderSettings settings) {
		super(Collections.unmodifiableSet(biomeSet));
		AlterniaGenSettings alterniagensettings = settings.getGeneratorSettings();
		this.genBiomes = AlterniaLayerUtil.buildAlterniaProcedure(settings.getSeed(), settings.getWorldType(), alterniagensettings);
	}	
	public static List<BiomeEntry>[] SetupBiomesList() {
		List<BiomeEntry>[] tbiomes= new ArrayList[BiomeType.values().length];
		for(int i = 0; i<tbiomes.length;i++) {
			tbiomes[i]=new ArrayList<BiomeEntry>();
		}
		return tbiomes;
	}
   
	public static void AddVanillaBiomes(){
//		AddBiome(Biomes.BAMBOO_JUNGLE, BiomeType.WARM, 10);
//		AddBiome(Biomes.SWAMP, BiomeType.COOL, 10);
		AddBiome(Biomes.ICE_SPIKES, BiomeType.ICY, 10);
		AddBiome(Biomes.BADLANDS, BiomeType.DESERT, 10);
	}	
	public static void AddBiome(Biome biome,BiomeType type, int weight) {
		biomes[type.ordinal()].add(new BiomeEntry(biome,weight));
		biomeSet.add(biome);
	}
	
	public static ImmutableList<BiomeEntry> getBiomes(BiomeType biomeType){
		
		int idx = biomeType.ordinal();
		List<BiomeEntry> list = idx >= biomes.length ? null : biomes[idx];

		return list != null ? ImmutableList.copyOf(list) : null;
	}
	
	@Override
	public Biome getNoiseBiome(int x, int y, int z) {
		return genBiomes.func_215738_a(x, z);
	}
}