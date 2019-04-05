package main.java.com.apocfarce.minestuck_alternia.Item;

import java.awt.Event;

import main.java.com.apocfarce.minestuck_alternia.block.AlterniaBlocks;
import net.minecraft.block.Block;

import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.IRegistry;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

public class AlterniaItems
{
	//the tab for future reference
	//public static CreativeTabs modTab = TabAlternia.instance;
	public static ItemGroup modGroup=ItemGroupAlternia.instance;
	//items
	public static Item ExampleItem;
	public static Item OblongMeatProduct;
	//multi colored items
	public static Item[] bloodPotions;
	
	
	
	public static void registerItems(RegistryEvent.Register<Item> event)
	{
		//get the registry
		IForgeRegistry<Item> registry = event.getRegistry();
		/**-----------------------------------
		 * items
		 *-------------------------------------*/
		//items
		registry.register(new ExampleItem(new Item.Properties().group(modGroup)));
		//food
		registry.register(new ItemFood(6, 3, true, new Item.Properties().group(modGroup)));
		//blood colored items
		bloodPotions=new Item[ENUM_BLOOD_COLOR.values().length];
		for(int i=0;i<bloodPotions.length;i++) {
			if(i!=ENUM_BLOOD_COLOR.GREY.ordinal()) {
				registry.register(new BloodBottle(new Item.Properties().group(modGroup).maxStackSize(1),ENUM_BLOOD_COLOR.values()[i]));
			}
		}
		
		/**-----------------------------------
		 *blocks
		 -------------------------------------*/
		registerBlock(registry ,new ItemBlock(AlterniaBlocks.darkCobble,new Item.Properties().group(modGroup)));
		registerBlock(registry ,new ItemBlock(AlterniaBlocks.darkStone,new Item.Properties().group(modGroup)));
		registerBlock(registry ,new ItemBlock(AlterniaBlocks.redCobble,new Item.Properties().group(modGroup)));
		registerBlock(registry ,new ItemBlock(AlterniaBlocks.redRock,new Item.Properties().group(modGroup)));
		registerBlock(registry ,new ItemBlock(AlterniaBlocks.block,new Item.Properties().group(modGroup)));
		//multi colored blocks
		for(int i=0;i<AlterniaBlocks.hiveGlass.length;i++) {
			if(i!= ENUM_BLOOD_COLOR.MUTANT.ordinal()) {
				registerBlock(registry ,new ItemBlock(AlterniaBlocks.hiveGlass[i],new Item.Properties().group(modGroup)));
			}
		}
	}

	

	

	   /*------------------------------------------
	    * coppied from net.minecraft.item.Item
	    --------------------------------------------*/
	private static Item registerBlock(IForgeRegistry<Item> registry, ItemBlock item)
	{
		System.out.println("++++++++++++++++++++++++++++++++"+item+"+++++++++++++++++++++++++++");
		registry.register(item.setRegistryName(item.getBlock().getRegistryName()));
		return item;
	}
}
