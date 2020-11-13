package com.apocfarce.minestuck_alternia.Item;

import com.apocfarce.minestuck_alternia.Minestuck_alternia;
import com.apocfarce.minestuck_alternia.Item.block.GreenSnakeItem;
import com.apocfarce.minestuck_alternia.Item.block.PortalBaseItem;
import com.apocfarce.minestuck_alternia.Item.block.PortalCenterItem;
import com.apocfarce.minestuck_alternia.Item.block.PortalCrownItem;
import com.apocfarce.minestuck_alternia.Item.block.RedSnakeItem;
import com.apocfarce.minestuck_alternia.block.AlterniaBlocks;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.ObjectHolder;

import javax.annotation.Nonnull;

@ObjectHolder(Minestuck_alternia.MOD_ID)
public class AlterniaItems {
	//items
	public static final Item CHERUB_KEY = getNull();
	
	//food
	public static final Item OBLONG_MEAT_PRODUCT = getNull();
	
	//blood
	public static final Item BURGUNDY_BLOOD_BOTTLE = getNull();
	public static final Item BRONZE_BLOOD_BOTTLE = getNull();
	public static final Item GOLD_BLOOD_BOTTLE = getNull();
	public static final Item OLIVE_BLOOD_BOTTLE = getNull();
	public static final Item JADE_BLOOD_BOTTLE = getNull();
	public static final Item TEAL_BLOOD_BOTTLE = getNull();
	public static final Item CERULEAN_BLOOD_BOTTLE = getNull();
	public static final Item INDIGO_BLOOD_BOTTLE = getNull();
	public static final Item PURPLE_BLOOD_BOTTLE = getNull();
	public static final Item VIOLET_BLOOD_BOTTLE = getNull();
	public static final Item FUCHSIA_BLOOD_BOTTLE = getNull();
	public static final Item LIME_BLOOD_BOTTLE = getNull();
	public static final Item MUTANT_BLOOD_BOTTLE = getNull();
	
	//items used only in crafting
	public static final Item RED_SNAKE = getNull();
	public static final Item GREEN_SNAKE = getNull();
	public static final Item PORTAL_CROWN = getNull();
	public static final Item PORTAL_CENTER = getNull();
	public static final Item PORTAL_BASE = getNull();
	@Nonnull
	@SuppressWarnings("ConstantConditions")
	private static <T> T getNull() {
		return null;
	}
	
	public static void registerItems(Register<Item> event) {
		//get the registry
		IForgeRegistry<Item> registry = event.getRegistry();
		
		/*-----------------------------------
		 * items
		 *-------------------------------------*/
		//items
		register(registry, "cherub_key", new Item(new Item.Properties().group(ItemGroupAlternia.instance)));
		
		//food
		register(registry, "oblong_meat_product", new Item(new Item.Properties().group(ItemGroupAlternia.instance).food(new Food.Builder().hunger(6).saturation(3).build())));
		
		//blood
		for(EnumBloodColor color : EnumBloodColor.values()) {
			if (color != EnumBloodColor.GREY) {
				register(registry, color.name().toLowerCase() + "_blood_bottle", new BloodBottle(new Item.Properties().group(ItemGroupAlternia.instance).maxStackSize(1), color));
			}
		}
		
		register(registry, AlterniaBlocks.darkCobble, ItemGroupAlternia.instance);
		register(registry, AlterniaBlocks.darkStone, ItemGroupAlternia.instance);
		register(registry, AlterniaBlocks.redCobble, ItemGroupAlternia.instance);
		register(registry, AlterniaBlocks.redRock, ItemGroupAlternia.instance);
		
		register(registry, AlterniaBlocks.pyralSapling, ItemGroupAlternia.instance);
		register(registry, AlterniaBlocks.pyralLeaves, ItemGroupAlternia.instance);
		register(registry, AlterniaBlocks.pyralLog, ItemGroupAlternia.instance);
		register(registry, AlterniaBlocks.pyralWood, ItemGroupAlternia.instance);
		register(registry, AlterniaBlocks.strippedPyralLog, ItemGroupAlternia.instance);
		register(registry, AlterniaBlocks.strippedPyralWood, ItemGroupAlternia.instance);
		register(registry, AlterniaBlocks.pyralPlanks, ItemGroupAlternia.instance);
		register(registry, AlterniaBlocks.pyralStairs, ItemGroupAlternia.instance);
		register(registry, AlterniaBlocks.pyralSlab, ItemGroupAlternia.instance);
		register(registry, AlterniaBlocks.pyralFence, ItemGroupAlternia.instance);
		register(registry, AlterniaBlocks.pyralFenceGate, ItemGroupAlternia.instance);
		
		register(registry, AlterniaBlocks.mirrageSapling, ItemGroupAlternia.instance);
		register(registry, AlterniaBlocks.mirrageLeaves, ItemGroupAlternia.instance);
		register(registry, AlterniaBlocks.mirrageLog, ItemGroupAlternia.instance);
		register(registry, AlterniaBlocks.mirrageWood, ItemGroupAlternia.instance);
		register(registry, AlterniaBlocks.strippedmirrageLog, ItemGroupAlternia.instance);
		register(registry, AlterniaBlocks.strippedmirrageWood, ItemGroupAlternia.instance);
		register(registry, AlterniaBlocks.mirragePlanks, ItemGroupAlternia.instance);
		register(registry, AlterniaBlocks.mirrageStairs, ItemGroupAlternia.instance);
		register(registry, AlterniaBlocks.mirrageSlab, ItemGroupAlternia.instance);
		register(registry, AlterniaBlocks.mirrageFence, ItemGroupAlternia.instance);
		register(registry, AlterniaBlocks.mirrageFenceGate, ItemGroupAlternia.instance);
		
		register(registry, AlterniaBlocks.pyralGrass, ItemGroupAlternia.instance);
		
		register(registry, new PortalCenterItem(AlterniaBlocks.portalCenter, new Item.Properties().group(ItemGroupAlternia.instance)));
		register(registry, new PortalCrownItem(AlterniaBlocks.portalCrown, new Item.Properties().group(ItemGroupAlternia.instance)));
		register(registry, new PortalBaseItem(AlterniaBlocks.portalBase, new Item.Properties().group(ItemGroupAlternia.instance)));
		register(registry, new RedSnakeItem(AlterniaBlocks.redSnake, new Item.Properties().group(ItemGroupAlternia.instance)));
		register(registry, new GreenSnakeItem(AlterniaBlocks.greenSnake, new Item.Properties().group(ItemGroupAlternia.instance)));
		
		for (int i = 0; i < AlterniaBlocks.hiveGlass.length; i++) {
			if (i != EnumBloodColor.MUTANT.ordinal()) {
				register(registry, AlterniaBlocks.hiveGlass[i], ItemGroupAlternia.instance);
			}
		}
	}
	
	private static Item register(IForgeRegistry<Item> registry, Block blockIn, ItemGroup group) {
		return register(registry, new BlockItem(blockIn, new Item.Properties().group(group)));
	}
	
	private static Item register(IForgeRegistry<Item> registry, BlockItem itemBlockIn) {
		return register(registry, itemBlockIn.getBlock().getRegistryName().getPath(), itemBlockIn);
	}
	
	private static Item register(IForgeRegistry<Item> registry, String id, Item item) {
		registry.register(item.setRegistryName(id));
		return item;
	}
}
