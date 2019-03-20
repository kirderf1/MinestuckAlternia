package main.java.com.apocfarce.minestuck_alternia.Item;

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
	
	//items
	public static Item ExampleItem;
	//multi colored items
	public static Item[] bloodPotions;
	
	//food
	//public static Item oblongMeatProduct=new ItemFood(6,true);
	
	
	
	public static void registerItems()
	{
		//get the registry
		/**-----------------------------------
		 * items
		 *-------------------------------------*/
		//items
		ExampleItem=register("minestuck_alternia:example_item",new ExampleItem(new Item.Properties().group(ItemGroupAlternia.instance)));
		//food
		register("minestuck_alternia:oblong_meat_product",new ItemFood(6, 3, true, new Item.Properties().group(ItemGroupAlternia.instance)));
		//blood colored items
		bloodPotions=new Item[ENUM_BLOOD_COLOR.values().length];
		for(int i=0;i<bloodPotions.length;i++) {
			if(i!=ENUM_BLOOD_COLOR.GREY.ordinal()) {
				bloodPotions[i]=register("minestuck_alternia:blood_bottle_"+ENUM_BLOOD_COLOR.values()[i].name().toLowerCase(),new BloodBottle(new Item.Properties().group(ItemGroupAlternia.instance).maxStackSize(1),ENUM_BLOOD_COLOR.values()[i]));
			}
		}
		
		/**-----------------------------------
		 *blocks
		 -------------------------------------*/
		register(AlterniaBlocks.darkCobble,ItemGroupAlternia.instance);
		register(AlterniaBlocks.darkStone,ItemGroupAlternia.instance);
		register(AlterniaBlocks.redCobble,ItemGroupAlternia.instance);
		register(AlterniaBlocks.redRock,ItemGroupAlternia.instance);
		register(AlterniaBlocks.block,ItemGroupAlternia.instance);
		for(int i=0;i<AlterniaBlocks.hiveGlass.length;i++) {
			if(i!= ENUM_BLOOD_COLOR.MUTANT.ordinal()) {
				register(AlterniaBlocks.hiveGlass[i],ItemGroupAlternia.instance);
			}
		}
	}

	

	

	   /*------------------------------------------
	    * coppied from net.minecraft.item.Item
	    --------------------------------------------*/
	   private static Item register(Block blockIn) {
	      return register(new ItemBlock(blockIn, new Item.Properties()));
	   }

	   private static Item register(Block blockIn, ItemGroup group) {
	      return register(new ItemBlock(blockIn, (new Item.Properties()).group(group)));
	   }

	   private static Item register(ItemBlock itemBlockIn) {
	      return register(itemBlockIn.getBlock(), itemBlockIn);
	   }

	   protected static Item register(Block blockIn, Item itemIn) {
	      return register(IRegistry.field_212618_g.getKey(blockIn), itemIn);
	   }

	   private static Item register(String id, Item itemIn) {
	      return register(new ResourceLocation(id), itemIn);
	   }

	   private static Item register(ResourceLocation resourceLocationIn, Item itemIn) {
	      if (itemIn instanceof ItemBlock) {
	         ((ItemBlock)itemIn).addToBlockToItemMap( net.minecraftforge.registries.GameData.getBlockItemMap(), itemIn);
	      }
	      IRegistry.field_212630_s.put(resourceLocationIn, itemIn);
	      return(itemIn);
	   }
}
