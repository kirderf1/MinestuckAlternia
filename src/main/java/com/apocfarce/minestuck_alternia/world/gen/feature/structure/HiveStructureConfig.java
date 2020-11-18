package com.apocfarce.minestuck_alternia.world.gen.feature.structure;

import com.mojang.datafixers.Dynamic;
import com.mojang.datafixers.types.DynamicOps;
import net.minecraft.world.gen.feature.IFeatureConfig;

import java.util.Random;

public class HiveStructureConfig implements IFeatureConfig {
	//TODO this is where we would specify any differences between biomes, such as which hive types that will appear
	@Override
	public <T> Dynamic<T> serialize(DynamicOps<T> ops) {
		return null;
	}
	
	public static <T> HiveStructureConfig deserialize(Dynamic<T> dynamic) {
		return new HiveStructureConfig();
	}
	
	public HiveType pickType(Random random) {
		return null;
	}
}