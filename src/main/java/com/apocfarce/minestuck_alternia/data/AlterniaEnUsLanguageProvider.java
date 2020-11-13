package com.apocfarce.minestuck_alternia.data;

import com.apocfarce.minestuck_alternia.Item.AlterniaItems;
import com.apocfarce.minestuck_alternia.Item.EnumBloodColor;
import com.apocfarce.minestuck_alternia.Item.ItemGroupAlternia;
import com.apocfarce.minestuck_alternia.Item.block.PortalBaseItem;
import com.apocfarce.minestuck_alternia.Item.block.PortalCenterItem;
import com.apocfarce.minestuck_alternia.Item.block.PortalCrownItem;
import com.apocfarce.minestuck_alternia.Minestuck_alternia;
import com.apocfarce.minestuck_alternia.block.AlterniaBlocks;
import com.apocfarce.minestuck_alternia.world.biome.AlterniaBiomeHandeler;
import net.minecraft.data.DataGenerator;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.data.LanguageProvider;

public class AlterniaEnUsLanguageProvider extends LanguageProvider {
	
	public AlterniaEnUsLanguageProvider(DataGenerator gen) {
		super(gen, Minestuck_alternia.MOD_ID, "en_us");
	}
	
	@Override
	protected void addTranslations() {
		add(AlterniaBlocks.darkStone, "Dark Stone");
		add(AlterniaBlocks.darkCobble, "Dark Cobblestone");
		add(AlterniaBlocks.redRock, "Red Stone");
		add(AlterniaBlocks.redCobble, "Red Cobblestone");
		
		add(AlterniaBlocks.portalBase, "Cherub Portal Base");
		add(AlterniaBlocks.portalCenter, "Cherub Portal Center");
		add(AlterniaBlocks.portalCrown, "Cherub Portal Crown");
		add(AlterniaBlocks.redSnake, "Cherub Portal Red Snake");
		add(AlterniaBlocks.greenSnake, "Cherub Portal Green Snake");
		
		add(AlterniaBlocks.pyralSapling, "Pyral Sapling");
		add(AlterniaBlocks.pyralLeaves, "Pyral Leaves");
		add(AlterniaBlocks.pyralLog, "Pyral Log");
		add(AlterniaBlocks.strippedPyralLog, "Stripped Pyral Log");
		add(AlterniaBlocks.pyralWood, "Pyral Wood");
		add(AlterniaBlocks.strippedPyralWood, "Stripped Pyral Wood");
		add(AlterniaBlocks.pyralPlanks, "Pyral Planks");
		add(AlterniaBlocks.pyralStairs, "Pyral Stairs");
		add(AlterniaBlocks.pyralSlab, "Pyral Slab");
		add(AlterniaBlocks.pyralFence, "Pyral Fence");
		add(AlterniaBlocks.pyralFenceGate, "Pyral Fence Gate");
		
		add(AlterniaBlocks.mirrageSapling, "Mirrage Sapling");
		add(AlterniaBlocks.mirrageLeaves, "Mirrage Leaves");
		add(AlterniaBlocks.mirrageLog, "Mirrage Log");
		add(AlterniaBlocks.strippedmirrageLog, "Stripped Mirrage Log");
		add(AlterniaBlocks.mirrageWood, "Mirrage Wood");
		add(AlterniaBlocks.strippedmirrageWood, "Stripped Mirrage Wood");
		add(AlterniaBlocks.mirragePlanks, "Mirrage Planks");
		add(AlterniaBlocks.mirrageStairs, "Mirrage Stairs");
		add(AlterniaBlocks.mirrageSlab, "Mirrage Slab");
		add(AlterniaBlocks.mirrageFence, "Mirrage Fence");
		add(AlterniaBlocks.mirrageFenceGate, "Mirrage Fence Gate");
		
		add(AlterniaBlocks.pyralGrass, "Pyral Grass");
		
		add(AlterniaBlocks.hiveGlass[EnumBloodColor.BURGUNDY.ordinal()], "Burgundy Hive Glass");
		add(AlterniaBlocks.hiveGlass[EnumBloodColor.BRONZE.ordinal()], "Bronze Hive Glass");
		add(AlterniaBlocks.hiveGlass[EnumBloodColor.GOLD.ordinal()], "Gold Hive Glass");
		add(AlterniaBlocks.hiveGlass[EnumBloodColor.OLIVE.ordinal()], "Olive Hive Glass");
		add(AlterniaBlocks.hiveGlass[EnumBloodColor.JADE.ordinal()], "Jade Hive Glass");
		add(AlterniaBlocks.hiveGlass[EnumBloodColor.TEAL.ordinal()], "Teal Hive Glass");
		add(AlterniaBlocks.hiveGlass[EnumBloodColor.CERULEAN.ordinal()], "Cerulean Hive Glass");
		add(AlterniaBlocks.hiveGlass[EnumBloodColor.INDIGO.ordinal()], "Indigo Hive Glass");
		add(AlterniaBlocks.hiveGlass[EnumBloodColor.PURPLE.ordinal()], "Purple Hive Glass");
		add(AlterniaBlocks.hiveGlass[EnumBloodColor.VIOLET.ordinal()], "Violet Hive Glass");
		add(AlterniaBlocks.hiveGlass[EnumBloodColor.FUCHSIA.ordinal()], "Fuchsia Hive Glass");
		add(AlterniaBlocks.hiveGlass[EnumBloodColor.LIME.ordinal()], "Lime Hive Glass");
		add(AlterniaBlocks.hiveGlass[EnumBloodColor.GREY.ordinal()], "Grey Hive Glass");
		
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
		
		add(AlterniaBiomeHandeler.AlterniaPlains, "Alternia Plains");
		add(AlterniaBiomeHandeler.mirrageForest, "Mirrage Forest");
		add(AlterniaBiomeHandeler.pyralForest, "Pyral Forest");
		add(AlterniaBiomeHandeler.mixedForest, "Mixed Forest");
		add(AlterniaBiomeHandeler.ColoredDesert, "Colored Desert");
		
		add(PortalCenterItem.CANT_PLACE, "You must place the crown before placing the center");
		add(PortalCrownItem.CANT_PLACE, "You must place both of the snakes before placing the crown");
		add(PortalBaseItem.CANT_PLACE, "Not enough room to place this (needs a 4x4 space)");
	}
	
	protected void add(ItemGroup key, String value)
	{
		add(key.getTranslationKey(), value);
	}
}