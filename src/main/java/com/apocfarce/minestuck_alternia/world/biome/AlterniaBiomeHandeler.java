package com.apocfarce.minestuck_alternia.world.biome;

import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.ImmutableList;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraftforge.common.BiomeManager.BiomeEntry;
import net.minecraftforge.common.BiomeManager.BiomeType;

public class AlterniaBiomeHandeler {
	
	public static ImmutableList<BiomeEntry> getBiomes(BiomeType biomeType){
		switch(biomeType) {
		case COOL:
				return ImmutableList.copyOf(new BiomeEntry[]{
						new BiomeEntry(Biomes.SNOWY_TUNDRA,10)
				});
		case DESERT:
			return ImmutableList.copyOf(new BiomeEntry[]{
						new BiomeEntry(Biomes.DESERT,10)
					});
		case ICY:
			return ImmutableList.copyOf(new BiomeEntry[]{
						new BiomeEntry(Biomes.ICE_SPIKES,10)
					});
		case WARM:
			return ImmutableList.copyOf(new BiomeEntry[]{
						new BiomeEntry(Biomes.PLAINS,10),
						new BiomeEntry(Biomes.END_MIDLANDS,10)
					});
		default:
			return ImmutableList.copyOf(new BiomeEntry[]{});
		}
	}

}
