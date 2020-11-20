package com.apocfarce.minestuck_alternia.world.gen.feature.structure;

import com.mojang.datafixers.Dynamic;
import com.mojang.datafixers.types.DynamicOps;
import net.minecraft.util.WeightedList;
import net.minecraft.world.gen.feature.IFeatureConfig;

import java.util.Random;

public class HiveStructureConfig implements IFeatureConfig {
	
	private final WeightedList<HiveType> types;
	
	public HiveStructureConfig(WeightedList<HiveType> list) {
		types = list;
	}
	
	@Override
	public <T> Dynamic<T> serialize(DynamicOps<T> ops) {
		return new Dynamic<>(ops, types.func_226310_a_(ops, hiveType -> hiveType.serialize(ops)));
	}
	
	public static <T> HiveStructureConfig deserialize(Dynamic<T> dynamic) {
		return new HiveStructureConfig(new WeightedList<>(dynamic, HiveType::deserialize));
	}
	
	public HiveType pickType(Random random) {
		return types.func_226318_b_(random);
	}
}