package com.apocfarce.minestuck_alternia.Utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import net.minecraft.world.gen.feature.ConfiguredRandomFeatureList;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

public class MultipleFeatureChanceHelper {
	
	public MultipleFeatureChanceHelper() {
		
		
		
		
		
		
	}
	
	public static List<ConfiguredRandomFeatureList<?>> normalizeChances(List<ConfiguredRandomFeatureList<?>> listTmp){
		
		List<ConfiguredRandomFeatureList<?>> normalizedList = new ArrayList<ConfiguredRandomFeatureList<?>>();
		
		
		Iterator<ConfiguredRandomFeatureList<?>> iter = listTmp.iterator();
		float ChanceSum = 0;
		while(iter.hasNext())
			ChanceSum += iter.next().chance;
		iter = listTmp.iterator();
		while (iter.hasNext()) {
			ConfiguredRandomFeatureList<?> hive = iter.next();
			normalizedList.add(new ConfiguredRandomFeatureList<>(hive.feature, hive.chance/ChanceSum));
		}
		
		return normalizedList;
	}
}
