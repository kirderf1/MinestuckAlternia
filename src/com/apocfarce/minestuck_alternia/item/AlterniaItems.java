package com.apocfarce.minestuck_alternia.item;

import com.apocfarce.minestuck_alternia.Minestuck_Alternia;
import com.apocfarce.minestuck_alternia.block.AlterniaBlocks;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemFood;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

public class AlterniaItems
{
	public static CreativeTabs tabAlternia = TabAlternia.instance;
	//items
	public static Item item= new ExampleItem();
	//food
	public static Item oblongMeatPoduct=new ItemFood(6, true);
	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event)
	{
		//get the registry
		IForgeRegistry<Item> registry = event.getRegistry();
		/**-----------------------------------
		 * items
		 *-------------------------------------*/		
		//items
		registerItem(registry,item,"item");
		//food
		registerItem(registry,oblongMeatPoduct,"oblong_meat_product");
		/**-----------------------------------
		 *blocks
		 -------------------------------------*/
		registerItemBlock(registry,new ItemBlock(AlterniaBlocks.block));
	}
	private static Item registerItem(IForgeRegistry<Item> registry,Item item, String name) {
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
