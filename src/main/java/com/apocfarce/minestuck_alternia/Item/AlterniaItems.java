package com.apocfarce.minestuck_alternia.Item;

import com.apocfarce.minestuck_alternia.Item.block.*;
import com.apocfarce.minestuck_alternia.MinestuckAlternia;
import com.apocfarce.minestuck_alternia.block.AlterniaBlocks;
import com.apocfarce.minestuck_alternia.util.BloodColor;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.ObjectHolder;

import javax.annotation.Nonnull;
import java.util.Objects;

@ObjectHolder(MinestuckAlternia.MOD_ID)
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
		for(BloodColor color : BloodColor.values()) {
			register(registry, color.getBloodName() + "_blood_bottle", new BloodBottle(new Item.Properties().group(ItemGroupAlternia.instance).maxStackSize(1), color));
		}
		
		register(registry, AlterniaBlocks.DARK_COBBLE, ItemGroupAlternia.instance);
		register(registry, AlterniaBlocks.DARK_STONE, ItemGroupAlternia.instance);
		register(registry, AlterniaBlocks.RED_COBBLE, ItemGroupAlternia.instance);
		register(registry, AlterniaBlocks.RED_ROCK, ItemGroupAlternia.instance);
		
		register(registry, AlterniaBlocks.DARK_STONE_COAL_ORE, ItemGroupAlternia.instance);
		register(registry, AlterniaBlocks.DARK_STONE_IRON_ORE, ItemGroupAlternia.instance);
		register(registry, AlterniaBlocks.DARK_STONE_GOLD_ORE, ItemGroupAlternia.instance);
		register(registry, AlterniaBlocks.DARK_STONE_REDSTONE_ORE, ItemGroupAlternia.instance);
		register(registry, AlterniaBlocks.DARK_STONE_DIAMOND_ORE, ItemGroupAlternia.instance);
		register(registry, AlterniaBlocks.DARK_STONE_LAPIS_ORE, ItemGroupAlternia.instance);
		
		register(registry, AlterniaBlocks.PYRAL_SAPLING, ItemGroupAlternia.instance);
		register(registry, AlterniaBlocks.PYRAL_LEAVES, ItemGroupAlternia.instance);
		register(registry, AlterniaBlocks.PYRAL_LOG, ItemGroupAlternia.instance);
		register(registry, AlterniaBlocks.PYRAL_WOOD, ItemGroupAlternia.instance);
		register(registry, AlterniaBlocks.STRIPPED_PYRAL_LOG, ItemGroupAlternia.instance);
		register(registry, AlterniaBlocks.STRIPPED_PYRAL_WOOD, ItemGroupAlternia.instance);
		register(registry, AlterniaBlocks.PYRAL_PLANKS, ItemGroupAlternia.instance);
		register(registry, AlterniaBlocks.PYRAL_STAIRS, ItemGroupAlternia.instance);
		register(registry, AlterniaBlocks.PYRAL_SLAB, ItemGroupAlternia.instance);
		register(registry, AlterniaBlocks.PYRAL_FENCE, ItemGroupAlternia.instance);
		register(registry, AlterniaBlocks.PYRAL_FENCE_GATE, ItemGroupAlternia.instance);
		
		register(registry, AlterniaBlocks.MIRRAGE_SAPLING, ItemGroupAlternia.instance);
		register(registry, AlterniaBlocks.MIRRAGE_LEAVES, ItemGroupAlternia.instance);
		register(registry, AlterniaBlocks.MIRRAGE_LOG, ItemGroupAlternia.instance);
		register(registry, AlterniaBlocks.MIRRAGE_WOOD, ItemGroupAlternia.instance);
		register(registry, AlterniaBlocks.STRIPPED_MIRRAGE_LOG, ItemGroupAlternia.instance);
		register(registry, AlterniaBlocks.STRIPPED_MIRRAGE_WOOD, ItemGroupAlternia.instance);
		register(registry, AlterniaBlocks.MIRRAGE_PLANKS, ItemGroupAlternia.instance);
		register(registry, AlterniaBlocks.MIRRAGE_STAIRS, ItemGroupAlternia.instance);
		register(registry, AlterniaBlocks.MIRRAGE_SLAB, ItemGroupAlternia.instance);
		register(registry, AlterniaBlocks.MIRRAGE_FENCE, ItemGroupAlternia.instance);
		register(registry, AlterniaBlocks.MIRRAGE_FENCE_GATE, ItemGroupAlternia.instance);
		
		register(registry, AlterniaBlocks.PYRAL_GRASS, ItemGroupAlternia.instance);
		
		register(registry, new PortalCenterItem(AlterniaBlocks.PORTAL_CENTER, new Item.Properties().group(ItemGroupAlternia.instance)));
		register(registry, new PortalCrownItem(AlterniaBlocks.PORTAL_CROWN, new Item.Properties().group(ItemGroupAlternia.instance)));
		register(registry, new PortalBaseItem(AlterniaBlocks.PORTAL_BASE, new Item.Properties().group(ItemGroupAlternia.instance)));
		register(registry, new RedSnakeItem(AlterniaBlocks.RED_SNAKE, new Item.Properties().group(ItemGroupAlternia.instance)));
		register(registry, new GreenSnakeItem(AlterniaBlocks.GREEN_SNAKE, new Item.Properties().group(ItemGroupAlternia.instance)));
		
		register(registry, AlterniaBlocks.BURGUNDY_HIVE_GLASS, ItemGroupAlternia.instance);
		register(registry, AlterniaBlocks.BRONZE_HIVE_GLASS, ItemGroupAlternia.instance);
		register(registry, AlterniaBlocks.GOLD_HIVE_GLASS, ItemGroupAlternia.instance);
		register(registry, AlterniaBlocks.OLIVE_HIVE_GLASS, ItemGroupAlternia.instance);
		register(registry, AlterniaBlocks.JADE_HIVE_GLASS, ItemGroupAlternia.instance);
		register(registry, AlterniaBlocks.TEAL_HIVE_GLASS, ItemGroupAlternia.instance);
		register(registry, AlterniaBlocks.CERULEAN_HIVE_GLASS, ItemGroupAlternia.instance);
		register(registry, AlterniaBlocks.INDIGO_HIVE_GLASS, ItemGroupAlternia.instance);
		register(registry, AlterniaBlocks.PURPLE_HIVE_GLASS, ItemGroupAlternia.instance);
		register(registry, AlterniaBlocks.VIOLET_HIVE_GLASS, ItemGroupAlternia.instance);
		register(registry, AlterniaBlocks.FUCHSIA_HIVE_GLASS, ItemGroupAlternia.instance);
		register(registry, AlterniaBlocks.LIME_HIVE_GLASS, ItemGroupAlternia.instance);
		register(registry, AlterniaBlocks.GREY_HIVE_GLASS, ItemGroupAlternia.instance);
	}
	
	private static void register(IForgeRegistry<Item> registry, Block block, ItemGroup group) {
		register(registry, new BlockItem(block, new Item.Properties().group(group)));
	}
	
	private static void register(IForgeRegistry<Item> registry, BlockItem item) {
		registry.register(item.setRegistryName(Objects.requireNonNull(item.getBlock().getRegistryName())));
	}
	
	private static void register(IForgeRegistry<Item> registry, String name, Item item) {
		registry.register(item.setRegistryName(name));
	}
}
