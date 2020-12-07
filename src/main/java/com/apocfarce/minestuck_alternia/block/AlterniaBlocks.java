package com.apocfarce.minestuck_alternia.block;

import com.apocfarce.minestuck_alternia.MinestuckAlternia;
import com.apocfarce.minestuck_alternia.block.tree.MirrageTree;
import com.apocfarce.minestuck_alternia.block.tree.PyralTree;
import com.apocfarce.minestuck_alternia.util.BloodColor;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.util.Direction;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.ObjectHolder;

import javax.annotation.Nonnull;
import java.util.function.Function;

@ObjectHolder(MinestuckAlternia.MOD_ID)
public class AlterniaBlocks
{
	
	//Blocks
	public static final Block DARK_STONE = getNull();
	public static final Block DARK_COBBLE = getNull();
	public static final Block RED_ROCK = getNull();
	public static final Block RED_COBBLE = getNull();
	public static final Block PORTAL_CENTER = getNull();
	public static final Block PORTAL_BASE = getNull();
	public static final Block PORTAL_CROWN = getNull();
	public static final Block RED_SNAKE = getNull();
	public static final Block GREEN_SNAKE = getNull();
	//wood stuff
	public static final BushBlock PYRAL_SAPLING = getNull();
	public static final Block PYRAL_LEAVES = getNull();
	public static final RotatedPillarBlock PYRAL_LOG = getNull();
	public static final RotatedPillarBlock STRIPPED_PYRAL_LOG = getNull();
	public static final Block PYRAL_WOOD = getNull();
	public static final Block STRIPPED_PYRAL_WOOD = getNull();
	public static final Block PYRAL_PLANKS = getNull();
	public static final StairsBlock PYRAL_STAIRS = getNull();
	public static final SlabBlock PYRAL_SLAB = getNull();
	public static final FenceBlock PYRAL_FENCE = getNull();
	public static final FenceGateBlock PYRAL_FENCE_GATE = getNull();
	
	public static final BushBlock MIRRAGE_SAPLING = getNull();
	public static final Block MIRRAGE_LEAVES = getNull();
	public static final RotatedPillarBlock MIRRAGE_LOG = getNull();
	public static final RotatedPillarBlock STRIPPED_MIRRAGE_LOG = getNull();
	public static final Block MIRRAGE_WOOD = getNull();
	public static final Block STRIPPED_MIRRAGE_WOOD = getNull();
	public static final Block MIRRAGE_PLANKS = getNull();
	public static final StairsBlock MIRRAGE_STAIRS = getNull();
	public static final SlabBlock MIRRAGE_SLAB = getNull();
	public static final FenceBlock MIRRAGE_FENCE = getNull();
	public static final FenceGateBlock MIRRAGE_FENCE_GATE = getNull();
	
	public static final Block PYRAL_GRASS = getNull();
	
	//BloodColoredBlocks
	public static final PaneBlock BURGUNDY_HIVE_GLASS = getNull();
	public static final PaneBlock BRONZE_HIVE_GLASS = getNull();
	public static final PaneBlock GOLD_HIVE_GLASS = getNull();
	public static final PaneBlock OLIVE_HIVE_GLASS = getNull();
	public static final PaneBlock JADE_HIVE_GLASS = getNull();
	public static final PaneBlock TEAL_HIVE_GLASS = getNull();
	public static final PaneBlock CERULEAN_HIVE_GLASS = getNull();
	public static final PaneBlock INDIGO_HIVE_GLASS = getNull();
	public static final PaneBlock PURPLE_HIVE_GLASS = getNull();
	public static final PaneBlock VIOLET_HIVE_GLASS = getNull();
	public static final PaneBlock FUCHSIA_HIVE_GLASS = getNull();
	public static final PaneBlock LIME_HIVE_GLASS = getNull();
	public static final PaneBlock GREY_HIVE_GLASS = getNull();
	
	@Nonnull
	@SuppressWarnings("ConstantConditions")
	private static <T> T getNull() {
		return null;
	}
	
	public static void registerBlocks(RegistryEvent.Register<Block> event) {
		IForgeRegistry<Block> registry = event.getRegistry();
		//blood colored blocks
		for (BloodColor color : BloodColor.values()) {
			register(registry, color.getBlockName() + "_hive_glass", new HiveGlass(Block.Properties.create(Material.GLASS).sound(SoundType.GLASS).hardnessAndResistance(0.3F).notSolid(), color));
		}
		
		
		register(registry, "dark_stone", new Block(Block.Properties.create(Material.ROCK).sound(SoundType.STONE).hardnessAndResistance(1.5F, 6.0F)));
		register(registry, "dark_cobble", new Block(Block.Properties.create(Material.ROCK).sound(SoundType.STONE).hardnessAndResistance(2.0F, 10.0F)));
		register(registry, "red_rock", new Block(Block.Properties.create(Material.ROCK).sound(SoundType.STONE).hardnessAndResistance(1.5F, 6.0F)));
		register(registry, "red_cobble", new Block(Block.Properties.create(Material.ROCK).sound(SoundType.STONE).hardnessAndResistance(2.0F, 10.0F)));
		
		register(registry, "portal_center", new PortalCenter(Block.Properties.create(Material.IRON).sound(SoundType.STONE).hardnessAndResistance(5.0F, 6.0F)));
		register(registry, "portal_crown", new PortalCrown(Block.Properties.create(Material.IRON).sound(SoundType.STONE).hardnessAndResistance(5.0F, 6.0F)));
		register(registry, "portal_base", new PortalBase(Block.Properties.create(Material.IRON).sound(SoundType.STONE).hardnessAndResistance(5.0F, 6.0F)));
		register(registry, "red_snake", new RedSnake(Block.Properties.create(Material.IRON).sound(SoundType.STONE).hardnessAndResistance(5.0F, 6.0F)));
		register(registry, "green_snake", new GreenSnake(Block.Properties.create(Material.IRON).sound(SoundType.STONE).hardnessAndResistance(5.0F, 6.0F)));
		
		//wood
		register(registry, "pyral_sapling", new AlterniaSapling(new PyralTree(), Block.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().sound(SoundType.PLANT).notSolid()));
		register(registry, "pyral_leaves", new LeavesBlock(Block.Properties.create(Material.LEAVES).sound(SoundType.PLANT).hardnessAndResistance(0.2F).tickRandomly().notSolid()));
		register(registry, "stripped_pyral_log", new RotatedPillarBlock(Block.Properties.create(Material.WOOD, yAxisColor(MaterialColor.BLUE, MaterialColor.WOOD)).sound(SoundType.WOOD).hardnessAndResistance(2.0F)));
		register(registry, "stripped_pyral_wood", new RotatedPillarBlock(Block.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(2.0F)));
		register(registry, "pyral_log", new AxeModifiableBlock(() -> AlterniaBlocks.STRIPPED_MIRRAGE_LOG, Block.Properties.create(Material.WOOD, MaterialColor.BLUE).sound(SoundType.WOOD).hardnessAndResistance(2.0F)));
		register(registry, "pyral_wood", new RotatedPillarBlock(Block.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(2.0F)));
		Block.Properties pyralPlankProperties = Block.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(2.0F, 3.0F);
		register(registry, "pyral_planks", new Block(pyralPlankProperties));
		register(registry, "pyral_stairs", new StairsBlock(() -> AlterniaBlocks.PYRAL_PLANKS.getDefaultState(), pyralPlankProperties));
		register(registry, "pyral_slab", new SlabBlock(pyralPlankProperties));
		register(registry, "pyral_fence", new FenceBlock(pyralPlankProperties));
		register(registry, "pyral_fence_gate", new FenceGateBlock(pyralPlankProperties));
		
		register(registry, "mirrage_sapling", new AlterniaSapling(new MirrageTree(), Block.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().sound(SoundType.PLANT).notSolid()));
		register(registry, "mirrage_leaves", new LeavesBlock(Block.Properties.create(Material.LEAVES).sound(SoundType.PLANT).hardnessAndResistance(0.2F).tickRandomly().notSolid()));
		register(registry, "stripped_mirrage_log", new RotatedPillarBlock(Block.Properties.create(Material.WOOD, yAxisColor(MaterialColor.BLACK, MaterialColor.WOOD)).sound(SoundType.WOOD).hardnessAndResistance(2.0F)));
		register(registry, "stripped_mirrage_wood", new RotatedPillarBlock(Block.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(2.0F)));
		register(registry, "mirrage_log", new AxeModifiableBlock(() -> AlterniaBlocks.STRIPPED_MIRRAGE_LOG, Block.Properties.create(Material.WOOD, yAxisColor(MaterialColor.GRAY, MaterialColor.BLUE)).sound(SoundType.WOOD).hardnessAndResistance(2.0F)));
		register(registry, "mirrage_wood", new RotatedPillarBlock(Block.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(2.0F)));
		Block.Properties mirragePlankProperties = Block.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(2.0F, 3.0F);
		register(registry, "mirrage_planks", new Block(mirragePlankProperties));
		register(registry, "mirrage_stairs", new StairsBlock(() -> AlterniaBlocks.MIRRAGE_PLANKS.getDefaultState(), mirragePlankProperties));
		register(registry, "mirrage_slab", new SlabBlock(mirragePlankProperties));
		register(registry, "mirrage_fence", new FenceBlock(mirragePlankProperties));
		register(registry, "mirrage_fence_gate", new FenceGateBlock(mirragePlankProperties));
		
		register(registry, "pyral_grass", new TallGrassBlock(Block.Properties.create(Material.TALL_PLANTS).sound(SoundType.PLANT).doesNotBlockMovement().hardnessAndResistance(0).notSolid()));
	}
	
	private static void register(IForgeRegistry<Block> registry, String name, Block block) {
		registry.register(block.setRegistryName(name));
	}
	
	private static Function<BlockState, MaterialColor> yAxisColor(MaterialColor topColor, MaterialColor sideColor) {
		return state -> state.get(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? topColor : sideColor;
	}
}