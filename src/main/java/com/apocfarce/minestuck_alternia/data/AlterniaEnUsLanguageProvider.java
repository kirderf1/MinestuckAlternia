package com.apocfarce.minestuck_alternia.data;

import com.apocfarce.minestuck_alternia.Item.AlterniaItems;
import com.apocfarce.minestuck_alternia.Item.ENUM_BLOOD_COLOR;
import com.apocfarce.minestuck_alternia.Item.ItemGroupAlternia;
import com.apocfarce.minestuck_alternia.block.AlterniaBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.data.LanguageProvider;

public class AlterniaEnUsLanguageProvider extends LanguageProvider {
	
	public AlterniaEnUsLanguageProvider(DataGenerator gen, String modid, String locale) {
		super(gen, modid, locale);
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
		
		add(AlterniaBlocks.hiveGlass[ENUM_BLOOD_COLOR.BURGUNDY.ordinal()], "Burgundy Hive Glass");
		add(AlterniaBlocks.hiveGlass[ENUM_BLOOD_COLOR.BRONZE.ordinal()], "Bronze Hive Glass");
		add(AlterniaBlocks.hiveGlass[ENUM_BLOOD_COLOR.GOLD.ordinal()], "Gold Hive Glass");
		add(AlterniaBlocks.hiveGlass[ENUM_BLOOD_COLOR.OLIVE.ordinal()], "Olive Hive Glass");
		add(AlterniaBlocks.hiveGlass[ENUM_BLOOD_COLOR.JADE.ordinal()], "Jade Hive Glass");
		add(AlterniaBlocks.hiveGlass[ENUM_BLOOD_COLOR.TEAL.ordinal()], "Teal Hive Glass");
		add(AlterniaBlocks.hiveGlass[ENUM_BLOOD_COLOR.CERULEAN.ordinal()], "Cerulean Hive Glass");
		add(AlterniaBlocks.hiveGlass[ENUM_BLOOD_COLOR.INDIGO.ordinal()], "Indigo Hive Glass");
		add(AlterniaBlocks.hiveGlass[ENUM_BLOOD_COLOR.PURPLE.ordinal()], "Purple Hive Glass");
		add(AlterniaBlocks.hiveGlass[ENUM_BLOOD_COLOR.VIOLET.ordinal()], "Violet Hive Glass");
		add(AlterniaBlocks.hiveGlass[ENUM_BLOOD_COLOR.FUCHSIA.ordinal()], "Fucshia Hive Glass");
		add(AlterniaBlocks.hiveGlass[ENUM_BLOOD_COLOR.LIME.ordinal()], "Lime Hive Glass");
		add(AlterniaBlocks.hiveGlass[ENUM_BLOOD_COLOR.GREY.ordinal()], "Grey Hive Glass");
		
		add(AlterniaItems.oblongMeatProduct, "Oblong Meat Product");
		
		add(AlterniaItems.bloodPotions[ENUM_BLOOD_COLOR.BURGUNDY.ordinal()], "Burgundy Blood Bottle");
		add(AlterniaItems.bloodPotions[ENUM_BLOOD_COLOR.BRONZE.ordinal()], "Bronze Blood Bottle");
		add(AlterniaItems.bloodPotions[ENUM_BLOOD_COLOR.GOLD.ordinal()], "Gold Blood Bottle");
		add(AlterniaItems.bloodPotions[ENUM_BLOOD_COLOR.OLIVE.ordinal()], "Olive Blood Bottle");
		add(AlterniaItems.bloodPotions[ENUM_BLOOD_COLOR.JADE.ordinal()], "Jade Blood Bottle");
		add(AlterniaItems.bloodPotions[ENUM_BLOOD_COLOR.TEAL.ordinal()], "Teal Blood Bottle");
		add(AlterniaItems.bloodPotions[ENUM_BLOOD_COLOR.CERULEAN.ordinal()], "Cerulian Blood Bottle");
		add(AlterniaItems.bloodPotions[ENUM_BLOOD_COLOR.INDIGO.ordinal()], "Indigo Blood Bottle");
		add(AlterniaItems.bloodPotions[ENUM_BLOOD_COLOR.PURPLE.ordinal()], "Purple Blood Bottle");
		add(AlterniaItems.bloodPotions[ENUM_BLOOD_COLOR.VIOLET.ordinal()], "Violet Blood Bottle");
		add(AlterniaItems.bloodPotions[ENUM_BLOOD_COLOR.FUCHSIA.ordinal()], "Fucshia Blood Bottle");
		add(AlterniaItems.bloodPotions[ENUM_BLOOD_COLOR.LIME.ordinal()], "Lime Blood Bottle");
		add(AlterniaItems.bloodPotions[ENUM_BLOOD_COLOR.MUTANT.ordinal()], "Mutant Blood Bottle");
		
		add(AlterniaItems.cherubKey, "Cherub Key");
		
		add(ItemGroupAlternia.instance, "Minestuck Alternia");
		
		add("message.cant_place.portal_center", "You must place the crown before placing the center");
		add("message.cant_place.portal_crown", "You must place both of the snakes before placing the crown");
		add("message.cant_place.portal_base", "not enough room to place this(needs a 4x4 space)");
	}
	
	protected void add(ItemGroup key, String value)
	{
		add(key.getTranslationKey(), value);
	}
}