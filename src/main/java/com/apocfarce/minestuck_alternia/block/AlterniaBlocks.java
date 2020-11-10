package com.apocfarce.minestuck_alternia.block;

import com.apocfarce.minestuck_alternia.Item.ENUM_BLOOD_COLOR;
import com.apocfarce.minestuck_alternia.block.tree.MirrageTree;
import com.apocfarce.minestuck_alternia.block.tree.PyralTree;

import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
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
	//wood stuff
	public static BushBlock pyralSapling;
	public static Block pyralLeaves;
	public static LogBlock pyralLog;
	public static LogBlock strippedPyralLog;
	public static Block pyralWood;
	public static Block strippedPyralWood;
	public static Block pyralPlanks;
	public static StairsBlock pyralStairs;
	public static SlabBlock pyralSlab;
	public static FenceBlock pyralFence;
	public static FenceGateBlock pyralFenceGate;
	public static Block pyralDoor;
	public static Block pyralTrapDoor;
	public static Block pyralSign;
	public static Block pyralButton;
	public static Block pyralPressurePlate;
	
	
	public static BushBlock mirrageSapling;
	public static Block mirrageLeaves;
	public static LogBlock mirrageLog;
	public static LogBlock strippedmirrageLog;
	public static Block mirrageWood;
	public static Block strippedmirrageWood;
	public static Block mirragePlanks;
	public static StairsBlock mirrageStairs;
	public static SlabBlock mirrageSlab;
	public static FenceBlock mirrageFence;
	public static FenceGateBlock mirrageFenceGate;
	public static Block mirrageDoor;
	public static Block mirrageTrapDoor;
	public static Block mirrageSign;
	public static Block mirrageButton;
	public static Block mirragePressurePlate;
	
	public static Block pyralGrass;
	
	//BloodColoredBlocks
	public static PaneBlock hiveGlass[];
	
	
	public static void registerBlocks(RegistryEvent.Register<Block> event)
	{
		IForgeRegistry<Block> registry = event.getRegistry();
		//blood colored blocks
		hiveGlass=new PaneBlock[ENUM_BLOOD_COLOR.values().length];
		for(int i=0;i<hiveGlass.length;i++) {
			if(i!=ENUM_BLOOD_COLOR.MUTANT.ordinal()) {
				hiveGlass[i] = (PaneBlock) register(registry,"minestuck_alternia:hiveglass_"+ENUM_BLOOD_COLOR.values()[i].name().toLowerCase(), new HiveGlass(Block.Properties.create(Material.GLASS).sound(SoundType.GLASS).notSolid(), ENUM_BLOOD_COLOR.values()[i]));
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
		
		//wood
		pyralSapling = (BushBlock) register(registry,"minestuck_alternia:pyral_sapling", new AlterniaSapling(new PyralTree(), Block.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().sound(SoundType.PLANT).notSolid()));
		pyralLeaves =  register(registry,"minestuck_alternia:pyral_leaves",  new LeavesBlock(Block.Properties.create(Material.LEAVES).sound(SoundType.PLANT).hardnessAndResistance(0.2F).tickRandomly().notSolid()));
		strippedPyralLog = (LogBlock) register(registry,"minestuck_alternia:stripped_pyral_log",  new LogBlock(MaterialColor.BLUE,Block.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(2.0F)));
		strippedPyralWood =  register(registry,"minestuck_alternia:stripped_pyral_wood",  new RotatedPillarBlock(Block.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(2.0F)));
		pyralLog = (LogBlock) register(registry,"minestuck_alternia:pyral_log",  new AlterniaLogBlock(MaterialColor.BLUE,strippedPyralLog,Block.Properties.create(Material.WOOD,MaterialColor.BLUE).sound(SoundType.WOOD).hardnessAndResistance(2.0F)));
		pyralWood =  register(registry,"minestuck_alternia:pyral_wood",  new RotatedPillarBlock(Block.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(2.0F)));
		pyralPlanks =  register(registry,"minestuck_alternia:pyral_planks",  new Block(Block.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(2.0F,3.0F)));
		pyralStairs = (StairsBlock) register(registry,"minestuck_alternia:pyral_stairs", new AlterniaStairs(pyralPlanks.getDefaultState(), Block.Properties.from(pyralPlanks)));
		pyralSlab = (SlabBlock) register(registry,"minestuck_alternia:pyral_slab", new SlabBlock(Block.Properties.from(pyralPlanks)));
		pyralFence = (FenceBlock) register(registry,"minestuck_alternia:pyral_fence", new FenceBlock(Block.Properties.from(pyralPlanks)));
		pyralFenceGate = (FenceGateBlock) register(registry,"minestuck_alternia:pyral_fence_gate", new FenceGateBlock(Block.Properties.from(pyralPlanks)));
/*		pyralDoor = register(registry,"minestuck_alternia:pyral_door", new)
		pyralTrapDoor = register(registry,"minestuck_alternia:pyral_trap_door", new)
		pyralSign = register(registry,"minestuck_alternia:pyral_sign", new)
		pyralButton = register(registry,"minestuck_alternia:pyral_button", new)
		pyralPressurePlate = register(registry,"minestuck_alternia:pyral_pressure_plate", new)*/
		
		
		
		mirrageSapling = (BushBlock) register(registry,"minestuck_alternia:mirrage_sapling", new AlterniaSapling(new MirrageTree(), Block.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().sound(SoundType.PLANT).notSolid()));
		mirrageLeaves =  register(registry,"minestuck_alternia:mirrage_leaves",  new LeavesBlock(Block.Properties.create(Material.LEAVES).sound(SoundType.PLANT).hardnessAndResistance(0.2F).tickRandomly().notSolid()));
		strippedmirrageLog = (LogBlock) register(registry,"minestuck_alternia:stripped_mirrage_log",  new LogBlock(MaterialColor.BLACK,Block.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(2.0F)));
		strippedmirrageWood =  register(registry,"minestuck_alternia:stripped_mirrage_wood",  new RotatedPillarBlock(Block.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(2.0F)));
		mirrageLog = (LogBlock) register(registry,"minestuck_alternia:mirrage_log",  new AlterniaLogBlock(MaterialColor.GRAY,strippedmirrageLog,Block.Properties.create(Material.WOOD,MaterialColor.BLUE).sound(SoundType.WOOD).hardnessAndResistance(2.0F)));
		mirrageWood =  register(registry,"minestuck_alternia:mirrage_wood",  new RotatedPillarBlock(Block.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(2.0F)));
		mirragePlanks =  register(registry,"minestuck_alternia:mirrage_planks",  new Block(Block.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(2.0F,3.0F)));
		mirrageStairs = (StairsBlock) register(registry,"minestuck_alternia:mirrage_stairs", new AlterniaStairs(mirragePlanks.getDefaultState(), Block.Properties.from(mirragePlanks)));
		mirrageSlab = (SlabBlock) register(registry,"minestuck_alternia:mirrage_slab", new SlabBlock(Block.Properties.from(mirragePlanks)));
		mirrageFence = (FenceBlock) register(registry,"minestuck_alternia:mirrage_fence", new FenceBlock(Block.Properties.from(mirragePlanks)));
		mirrageFenceGate = (FenceGateBlock) register(registry,"minestuck_alternia:mirrage_fence_gate", new FenceGateBlock(Block.Properties.from(mirragePlanks)));

		
		pyralGrass = register(registry,"minestuck_alternia:pyral_grass",new AlterniaTallGrass(Block.Properties.create(Material.TALL_PLANTS).sound(SoundType.PLANT).doesNotBlockMovement().hardnessAndResistance(0).notSolid()));
		
		
	}
	

	
	private static Block register(IForgeRegistry<Block> registry,ResourceLocation key, Block blockIn){
		registry.register(blockIn.setRegistryName(key));
		return(blockIn);
	}	
	private static Block register(IForgeRegistry<Block> registry,String key, Block blockIn){
		return register(registry,new ResourceLocation(key), blockIn);
	}
}