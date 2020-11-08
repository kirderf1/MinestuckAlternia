package com.apocfarce.minestuck_alternia.data;

import com.apocfarce.minestuck_alternia.data.loot.AlterniaLootTableProvider;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;

public class AlterniaData {
	
	public static void gatherData(GatherDataEvent event) {
		DataGenerator generator = event.getGenerator();
		
		if(event.includeServer()) {
			generator.addProvider(new AlterniaBlockTagsProvider(generator));
			generator.addProvider(new AlterniaRecipeProvider(generator));
			generator.addProvider(new AlterniaLootTableProvider(generator));
		}
	}
}
