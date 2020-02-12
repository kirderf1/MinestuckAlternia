package com.apocfarce.minestuck_alternia.block;

import com.apocfarce.minestuck_alternia.Item.ENUM_BLOOD_COLOR;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.registries.IForgeRegistry;

public class AlterniaBlocks
{
	
	//Blocks
	public static Block darkStone;
	public static Block darkCobble;
	public static Block redRock;
	public static Block redCobble;
	public static Block portalCenter;
	public static Block portalBase;
	public static Block portalCrown;
	public static Block redSnake;
	public static Block greenSnake;
	
	//BloodColoredBlocks
	public static Block hiveGlass[];
	
	
	public static void registerBlocks(RegistryEvent.Register<Block> event)
	{
		IForgeRegistry<Block> registry = event.getRegistry();
		//blood colored blocks
		hiveGlass=new Block[ENUM_BLOOD_COLOR.values().length];
		for(int i=0;i<hiveGlass.length;i++) {
			if(i!=ENUM_BLOOD_COLOR.MUTANT.ordinal()) {
				hiveGlass[i]=register(registry,"minestuck_alternia:hiveglass_"+ENUM_BLOOD_COLOR.values()[i].name().toLowerCase(), new HiveGlass(Block.Properties.create(Material.GLASS).sound(SoundType.GLASS), ENUM_BLOOD_COLOR.values()[i]));
			}
		}


		darkStone=register(registry,"minestuck_alternia:dark_stone",new Block(Block.Properties.create(Material.ROCK).sound(SoundType.STONE).hardnessAndResistance(1.5F, 6.0F)));
		darkCobble=register(registry,"minestuck_alternia:dark_cobble",new Block(Block.Properties.create(Material.ROCK).sound(SoundType.STONE).hardnessAndResistance(2.0F, 10.0F)));
		redRock=register(registry,"minestuck_alternia:red_rock",new Block(Block.Properties.create(Material.ROCK).sound(SoundType.STONE).hardnessAndResistance(1.5F, 6.0F)));
		redCobble=register(registry,"minestuck_alternia:red_cobble",new Block(Block.Properties.create(Material.ROCK).sound(SoundType.STONE).hardnessAndResistance(2.0F, 10.0F)));

		portalCenter =register(registry,"minestuck_alternia:portal_center",new PortalCenter(Block.Properties.create(Material.IRON).sound(SoundType.STONE).hardnessAndResistance(5.0F, 6.0F)));
		portalCrown = register(registry,"minestuck_alternia:portal_crown", new PortalCrown(Block.Properties.create(Material.IRON).sound(SoundType.STONE).hardnessAndResistance(5.0F, 6.0F)));
		portalBase =  register(registry,"minestuck_alternia:portal_base",  new PortalBase(Block.Properties.create(Material.IRON).sound(SoundType.STONE).hardnessAndResistance(5.0F, 6.0F)));
		redSnake =    register(registry,"minestuck_alternia:red_snake",    new RedSnake(Block.Properties.create(Material.IRON).sound(SoundType.STONE).hardnessAndResistance(5.0F, 6.0F)));
		greenSnake =  register(registry,"minestuck_alternia:green_snake",  new GreenSnake(Block.Properties.create(Material.IRON).sound(SoundType.STONE).hardnessAndResistance(5.0F, 6.0F)));
	}
	
	private static Block register(IForgeRegistry<Block> registry,ResourceLocation key, Block blockIn){
		registry.register(blockIn.setRegistryName(key));
		return(blockIn);
	}	
	private static Block register(IForgeRegistry<Block> registry,String key, Block blockIn){
		return register(registry,new ResourceLocation(key), blockIn);
	}
}