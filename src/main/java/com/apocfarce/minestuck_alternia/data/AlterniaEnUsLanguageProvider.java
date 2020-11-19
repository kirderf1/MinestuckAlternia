package com.apocfarce.minestuck_alternia.data;

import com.apocfarce.minestuck_alternia.Item.AlterniaItems;
import com.apocfarce.minestuck_alternia.Item.ItemGroupAlternia;
import com.apocfarce.minestuck_alternia.Item.block.PortalBaseItem;
import com.apocfarce.minestuck_alternia.Item.block.PortalCenterItem;
import com.apocfarce.minestuck_alternia.Item.block.PortalCrownItem;
import com.apocfarce.minestuck_alternia.Minestuck_alternia;
import com.apocfarce.minestuck_alternia.block.AlterniaBlocks;
import com.apocfarce.minestuck_alternia.client.BloodSelectionScreen;
import com.apocfarce.minestuck_alternia.client.StartDimensionSelectionScreen;
import com.apocfarce.minestuck_alternia.util.BloodColor;
import com.apocfarce.minestuck_alternia.util.CustomDamageSources;
import com.apocfarce.minestuck_alternia.world.biome.AlterniaBiomes;
import net.minecraft.data.DataGenerator;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.DamageSource;
import net.minecraftforge.common.data.LanguageProvider;

public class AlterniaEnUsLanguageProvider extends LanguageProvider {
	
	public AlterniaEnUsLanguageProvider(DataGenerator gen) {
		super(gen, Minestuck_alternia.MOD_ID, "en_us");
	}
	
	@Override
	protected void addTranslations() {
		add(AlterniaBlocks.DARK_STONE, "Dark Stone");
		add(AlterniaBlocks.DARK_COBBLE, "Dark Cobblestone");
		add(AlterniaBlocks.RED_ROCK, "Red Stone");
		add(AlterniaBlocks.RED_COBBLE, "Red Cobblestone");
		
		add(AlterniaBlocks.PORTAL_BASE, "Cherub Portal Base");
		add(AlterniaBlocks.PORTAL_CENTER, "Cherub Portal Center");
		add(AlterniaBlocks.PORTAL_CROWN, "Cherub Portal Crown");
		add(AlterniaBlocks.RED_SNAKE, "Cherub Portal Red Snake");
		add(AlterniaBlocks.GREEN_SNAKE, "Cherub Portal Green Snake");
		
		add(AlterniaBlocks.PYRAL_SAPLING, "Pyral Sapling");
		add(AlterniaBlocks.PYRAL_LEAVES, "Pyral Leaves");
		add(AlterniaBlocks.PYRAL_LOG, "Pyral Log");
		add(AlterniaBlocks.STRIPPED_PYRAL_LOG, "Stripped Pyral Log");
		add(AlterniaBlocks.PYRAL_WOOD, "Pyral Wood");
		add(AlterniaBlocks.STRIPPED_PYRAL_WOOD, "Stripped Pyral Wood");
		add(AlterniaBlocks.PYRAL_PLANKS, "Pyral Planks");
		add(AlterniaBlocks.PYRAL_STAIRS, "Pyral Stairs");
		add(AlterniaBlocks.PYRAL_SLAB, "Pyral Slab");
		add(AlterniaBlocks.PYRAL_FENCE, "Pyral Fence");
		add(AlterniaBlocks.PYRAL_FENCE_GATE, "Pyral Fence Gate");
		
		add(AlterniaBlocks.MIRRAGE_SAPLING, "Mirrage Sapling");
		add(AlterniaBlocks.MIRRAGE_LEAVES, "Mirrage Leaves");
		add(AlterniaBlocks.MIRRAGE_LOG, "Mirrage Log");
		add(AlterniaBlocks.STRIPPED_MIRRAGE_LOG, "Stripped Mirrage Log");
		add(AlterniaBlocks.MIRRAGE_WOOD, "Mirrage Wood");
		add(AlterniaBlocks.STRIPPED_MIRRAGE_WOOD, "Stripped Mirrage Wood");
		add(AlterniaBlocks.MIRRAGE_PLANKS, "Mirrage Planks");
		add(AlterniaBlocks.MIRRAGE_STAIRS, "Mirrage Stairs");
		add(AlterniaBlocks.MIRRAGE_SLAB, "Mirrage Slab");
		add(AlterniaBlocks.MIRRAGE_FENCE, "Mirrage Fence");
		add(AlterniaBlocks.MIRRAGE_FENCE_GATE, "Mirrage Fence Gate");
		
		add(AlterniaBlocks.PYRAL_GRASS, "Pyral Grass");
		
		add(AlterniaBlocks.BURGUNDY_HIVE_GLASS, "Burgundy Hive Glass");
		add(AlterniaBlocks.BRONZE_HIVE_GLASS, "Bronze Hive Glass");
		add(AlterniaBlocks.GOLD_HIVE_GLASS, "Gold Hive Glass");
		add(AlterniaBlocks.OLIVE_HIVE_GLASS, "Olive Hive Glass");
		add(AlterniaBlocks.JADE_HIVE_GLASS, "Jade Hive Glass");
		add(AlterniaBlocks.TEAL_HIVE_GLASS, "Teal Hive Glass");
		add(AlterniaBlocks.CERULEAN_HIVE_GLASS, "Cerulean Hive Glass");
		add(AlterniaBlocks.INDIGO_HIVE_GLASS, "Indigo Hive Glass");
		add(AlterniaBlocks.PURPLE_HIVE_GLASS, "Purple Hive Glass");
		add(AlterniaBlocks.VIOLET_HIVE_GLASS, "Violet Hive Glass");
		add(AlterniaBlocks.FUCHSIA_HIVE_GLASS, "Fuchsia Hive Glass");
		add(AlterniaBlocks.LIME_HIVE_GLASS, "Lime Hive Glass");
		add(AlterniaBlocks.GREY_HIVE_GLASS, "Grey Hive Glass");
		
		add(AlterniaItems.OBLONG_MEAT_PRODUCT, "Oblong Meat Product");
		
		add(AlterniaItems.BURGUNDY_BLOOD_BOTTLE, "Burgundy Blood Bottle");
		add(AlterniaItems.BRONZE_BLOOD_BOTTLE, "Bronze Blood Bottle");
		add(AlterniaItems.GOLD_BLOOD_BOTTLE, "Gold Blood Bottle");
		add(AlterniaItems.OLIVE_BLOOD_BOTTLE, "Olive Blood Bottle");
		add(AlterniaItems.JADE_BLOOD_BOTTLE, "Jade Blood Bottle");
		add(AlterniaItems.TEAL_BLOOD_BOTTLE, "Teal Blood Bottle");
		add(AlterniaItems.CERULEAN_BLOOD_BOTTLE, "Cerulean Blood Bottle");
		add(AlterniaItems.INDIGO_BLOOD_BOTTLE, "Indigo Blood Bottle");
		add(AlterniaItems.PURPLE_BLOOD_BOTTLE, "Purple Blood Bottle");
		add(AlterniaItems.VIOLET_BLOOD_BOTTLE, "Violet Blood Bottle");
		add(AlterniaItems.FUCHSIA_BLOOD_BOTTLE, "Fuchsia Blood Bottle");
		add(AlterniaItems.LIME_BLOOD_BOTTLE, "Lime Blood Bottle");
		add(AlterniaItems.MUTANT_BLOOD_BOTTLE, "Mutant Blood Bottle");
		
		add(AlterniaItems.CHERUB_KEY, "Cherub Key");
		
		add(ItemGroupAlternia.instance, "Minestuck Alternia");
		
		add(CustomDamageSources.SUNBURN, "%1$s burned to death in the sun", "%1$s burned to death in the sun whilst fighting %2$s");
		
		addBiome(AlterniaBiomes.ALTERNIA_PLAINS, "Alternia Plains");
		addBiome(AlterniaBiomes.MIRRAGE_FOREST, "Mirrage Forest");
		addBiome(AlterniaBiomes.PYRAL_FOREST, "Pyral Forest");
		addBiome(AlterniaBiomes.MIXED_FOREST, "Mixed Forest");
		addBiome(AlterniaBiomes.COLORED_DESERT, "Colored Desert");
		
		add(PortalCenterItem.CANT_PLACE, "You must place the crown before placing the center");
		add(PortalCrownItem.CANT_PLACE, "You must place both of the snakes before placing the crown");
		add(PortalBaseItem.CANT_PLACE, "Not enough room to place this (needs a 4x4 space)");
		
		add(StartDimensionSelectionScreen.TITLE, "Start-dimension selection");
		add(StartDimensionSelectionScreen.PROMPT, "Select a home dimension");
		add(StartDimensionSelectionScreen.OVERWORLD, "Overworld");
		add(StartDimensionSelectionScreen.ALTERNIA, "Alternia");
		
		add(BloodSelectionScreen.TITLE, "Blood color selection");
		add(BloodSelectionScreen.PROMPT, "Select a blood color");
		
		add(BloodColor.BURGUNDY, "Burgundy");
		add(BloodColor.BRONZE, "Bronze");
		add(BloodColor.GOLD, "Gold");
		add(BloodColor.OLIVE, "Olive");
		add(BloodColor.JADE, "Jade");
		add(BloodColor.TEAL, "Teal");
		add(BloodColor.CERULEAN, "Cerulean");
		add(BloodColor.INDIGO, "Indigo");
		add(BloodColor.PURPLE, "Purple");
		add(BloodColor.VIOLET, "Violet");
		add(BloodColor.FUCHSIA, "Fuchsia");
		add(BloodColor.MUTANT, "Mutant");
		add(BloodColor.LIME, "Lime");
	}
	
	protected void add(ItemGroup key, String value)
	{
		add(key.getTranslationKey(), value);
	}
	
	protected void add(DamageSource source, String normalMessage, String fightingMessage) {
		add("death.attack." + source.getDamageType(), normalMessage);
		add("death.attack." + source.getDamageType() + ".player", fightingMessage);
	}
	
	protected void add(BloodColor color, String name) {
		add(color.getTranslationKey(), name);
	}
}