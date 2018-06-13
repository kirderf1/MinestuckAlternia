package com.apocfarce.minestuck_alternia.item;

import com.apocfarce.minestuck_alternia.block.AlterniaBlocks;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

public class AlterniaItems
{
	public static CreativeTabs tabAlternia = TabAlternia.instance;
	//items
	public static Item item= new ExampleItem();
	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event)
	{
		//get the registry
		IForgeRegistry<Item> registry = event.getRegistry();
		//items
		RegisterItem(registry,item,"item");
		//blocks
		registerItemBlock(registry,new ItemBlock(AlterniaBlocks.block));
	}
	private static Item RegisterItem(IForgeRegistry<Item> registry,Item item, String name) {
		item.setCreativeTab(tabAlternia);
		item.setUnlocalizedName(name);
		item.setRegistryName(name);
		registry.register(item);
		return item;
	}
	
	
	private static Item registerItemBlock(IForgeRegistry<Item> registry, ItemBlock item)
	{
		registry.register(item.setRegistryName(item.getBlock().getRegistryName()));
		return item;
	}
}
