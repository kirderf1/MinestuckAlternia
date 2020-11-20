package com.apocfarce.minestuck_alternia.world.gen.feature.structure;

import com.apocfarce.minestuck_alternia.Item.BloodColor;
import com.apocfarce.minestuck_alternia.Minestuck_alternia;
import com.mojang.datafixers.Dynamic;
import com.mojang.datafixers.types.DynamicOps;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.feature.structure.StructurePiece;
import net.minecraft.world.gen.feature.template.TemplateManager;

import java.util.HashMap;
import java.util.Map;

public final class HiveType {
	public final ResourceLocation name;
	public final Heightmap.Type heightmap;
	public final PieceConstructor constructor;
	
	private HiveType(ResourceLocation name, Heightmap.Type heightmap, PieceConstructor constructor) {
		this.name = name;
		this.heightmap = heightmap;
		this.constructor = constructor;
	}
	
	public StructurePiece createPiece(TemplateManager templates, BlockPos pos, Rotation rotation) {
		return constructor.create(templates, name, pos, rotation);
	}
	
	public interface PieceConstructor {
		StructurePiece create(TemplateManager templates, ResourceLocation name, BlockPos pos, Rotation rotation);
	}
	
	public <T> Dynamic<T> serialize(DynamicOps<T> ops) {
		return new Dynamic<>(ops, ops.createString(name.toString()));
	}
	
	public static <T> HiveType deserialize(Dynamic<T> dynamic) {
		return hiveTypes.get(new ResourceLocation(dynamic.asString(DEFAULT_VALUE.toString())));
	}
	
	private static final ResourceLocation DEFAULT_VALUE = new ResourceLocation(Minestuck_alternia.MOD_ID, "burgundy_small");
	private static final Map<ResourceLocation, HiveType> hiveTypes = new HashMap<>();
	
	public static final HiveType BURGUNDY_AWNING_SMALL = standardHive("burgundy_awning_small", BloodColor.BURGUNDY, new BlockPos(5, 1, 6), new BlockPos(15, 1, 12));
	public static final HiveType BURGUNDY_SMALL = standardHive("burgundy_small", BloodColor.BURGUNDY, new BlockPos(3, 1, 5), new BlockPos(10, 1, 10));
	public static final HiveType BURGUNDY_MANSION = standardHive("burgundy_mansion", BloodColor.BURGUNDY, new BlockPos(15, 1, 0), new BlockPos(15, 9, 10));
	
	public static final HiveType BRONZE_WOODEN = standardHive("bronze_wooden", BloodColor.BRONZE, new BlockPos(8, 5, 1), new BlockPos(5, 1, 10));
	public static final HiveType BRONZE_FARM = standardHive("bronze_farm", BloodColor.BRONZE, new BlockPos(8, 4, 0), new BlockPos(8, 1, 5));
	public static final HiveType BRONZE_WINDMILL = standardHive("bronze_windmill", BloodColor.BRONZE, new BlockPos(1, 1, 6), new BlockPos(4, 1, 6));
	
	public static final HiveType GOLD_SYMMETRIC = standardHive("gold_symmetric", BloodColor.GOLD, new BlockPos(15, 0, 0), new BlockPos(15, 1, 5));
	public static final HiveType GOLD_BEACON = standardHive("gold_beacon", BloodColor.GOLD, new BlockPos(7, 1, 9), new BlockPos(13, 17, 14));
	public static final HiveType GOLD_TOWER = standardHive("gold_tower", BloodColor.GOLD, new BlockPos(0, 1, 11), new BlockPos(11, 27, 12));
	
	public static final HiveType MUTANT_PLUS = standardHive("mutant_plus", BloodColor.MUTANT, new BlockPos(1, 4, 8), new BlockPos(10, 1, 8));
	public static final HiveType MUTANT_LARGE = standardHive("mutant_large", BloodColor.MUTANT, new BlockPos(14, 0, 0), new BlockPos(11, 1, 11));
	public static final HiveType MUTANT_AWNING_LARGE = standardHive("mutant_awning_large", BloodColor.MUTANT, new BlockPos(0, 0, 6), new BlockPos(16, 5, 5));
	
	public static final HiveType LIME_DIAGONAL = standardHive("lime_diagonal", BloodColor.LIME, new BlockPos(9, 1, 0), new BlockPos(4, 2, 11));
	public static final HiveType LIME_ROUND_TOWER = standardHive("lime_round_tower", BloodColor.LIME, new BlockPos(0, 1, 14), new BlockPos(24, 1, 14));
	public static final HiveType LIME_FARM = standardHive("lime_farm", BloodColor.LIME, new BlockPos(0, 0, 15), new BlockPos(17, 1, 15));
	
	public static final HiveType OLIVE_CAVE = standardHive("olive_cave", BloodColor.OLIVE, new BlockPos(4, 1, 13), new BlockPos(15, 1, 11));
	public static final HiveType OLIVE_TREE = standardHive("olive_tree", BloodColor.OLIVE, new BlockPos(13, 1, 6), new BlockPos(17, 1, 16));
	public static final HiveType OLIVE_BASEMENT = standardHive("olive_basement", BloodColor.OLIVE, new BlockPos(11, 19, 5), new BlockPos(6, 1, 25));
	
	public static final HiveType JADE_TOWER = standardHive("jade_tower", BloodColor.JADE, new BlockPos(10, 1, 31), new BlockPos(10, 5, 6));
	public static final HiveType JADE_FOUNTAIN = standardHive("jade_fountain", BloodColor.JADE, new BlockPos(14, 1, 0), new BlockPos(4, 1, 4));
	public static final HiveType JADE_TREE = standardHive("jade_tree", BloodColor.JADE, new BlockPos(3, 1, 5), new BlockPos(14, 9, 5));
	
	public static final HiveType TEAL_BALCONY_MANSION = standardHive("teal_balcony_mansion", BloodColor.TEAL, new BlockPos(0, 1, 15), new BlockPos(20, 7, 15));
	public static final HiveType TEAL_TREE_MANSION = standardHive("teal_tree_mansion", BloodColor.TEAL, new BlockPos(1, 1, 15), new BlockPos(5, 7, 15));
	public static final HiveType TEAL_TOWER = standardHive("teal_tower", BloodColor.TEAL, new BlockPos(15, 1, 0), new BlockPos(15, 20, 12));
	
	public static final HiveType CERULEAN_L = standardHive("cerulean_l", BloodColor.CERULEAN, new BlockPos(4, 0, 10), new BlockPos(12, 1, 4));
	public static final HiveType CERULEAN_BASEMENT = standardHive("cerulean_basement", BloodColor.CERULEAN, new BlockPos(21, 10, 15), new BlockPos(23, 1, 15));
	public static final HiveType CERULEAN_CAVE = standardHive("cerulean_cave", BloodColor.CERULEAN, new BlockPos(20, 21, 15), new BlockPos(20, 1, 15));
	
	public static final HiveType INDIGO_TOWER_PLUS = standardHive("indigo_tower_plus", BloodColor.INDIGO, new BlockPos(3, 1, 0), new BlockPos(19, 1, 11));
	public static final HiveType INDIGO_TELESCOPE = standardHive("indigo_telescope", BloodColor.INDIGO, new BlockPos(1, 1, 15), new BlockPos(23, 4, 15));
	public static final HiveType INDIGO_LARGE_CHIMNEYS = standardHive("indigo_large_chimneys", BloodColor.INDIGO, new BlockPos(0, 1, 15), new BlockPos(10, 9, 10));
	
	public static final HiveType PURPLE_BASEMENT = standardHive("purple_basement", BloodColor.PURPLE, new BlockPos(15, 11, 13), new BlockPos(20, 1, 20));
	public static final HiveType PURPLE_BALCONY = standardHive("purple_balcony", BloodColor.PURPLE, new BlockPos(1, 0, 1), new BlockPos(14, 1, 17));
	public static final HiveType PURPLE_CHURCH = standardHive("purple_church", BloodColor.PURPLE, new BlockPos(15, 0, 0), new BlockPos(15, 2, 25));
	public static final HiveType PURPLE_TENT = standardHive("purple_tent", BloodColor.PURPLE, new BlockPos(0, 1, 15), new BlockPos(10, 1, 10));
	
	private static HiveType register(ResourceLocation name, Heightmap.Type heightmap, PieceConstructor constructor) {
		HiveType type = new HiveType(name, heightmap, constructor);
		hiveTypes.put(name, type);
		return type;
	}
	
	private static HiveType standardHive(String name, BloodColor color, BlockPos floor, BlockPos spawn) {
		return register(new ResourceLocation(Minestuck_alternia.MOD_ID, name), Heightmap.Type.WORLD_SURFACE_WG, SimpleHiveStructurePiece.with(color, floor, spawn));
	}
	
	@Override
	public String toString() {
		return name.toString();
	}
}