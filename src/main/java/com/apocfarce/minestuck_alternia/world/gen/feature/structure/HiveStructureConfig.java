package com.apocfarce.minestuck_alternia.world.gen.feature.structure;

import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import net.minecraft.util.WeightedList;
import net.minecraft.world.gen.feature.IFeatureConfig;

import java.util.Random;

public class HiveStructureConfig implements IFeatureConfig {
	
	public static final Codec<HiveStructureConfig> CODEC = WeightedList.func_234002_a_(HiveType.CODEC)
			.comapFlatMap(HiveStructureConfig::encode, config -> config.types).fieldOf("hives").codec();
	
	private final WeightedList<HiveType> types;
	
	private static DataResult<HiveStructureConfig> encode(WeightedList<HiveType> hiveTypes) {
		return hiveTypes.func_234005_b_() ? DataResult.error("HiveStructureConfig with no hive types") : DataResult.success(new HiveStructureConfig(hiveTypes));
	}
	
	public HiveStructureConfig(WeightedList<HiveType> list) {
		types = list;
	}
	
	public HiveType pickType(Random random) {
		return types.func_226318_b_(random);
	}
}