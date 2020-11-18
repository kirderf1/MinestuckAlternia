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
	
	private static final ResourceLocation DEFAULT_VALUE = new ResourceLocation(Minestuck_alternia.MOD_ID, "");
	private static final Map<ResourceLocation, HiveType> hiveTypes = new HashMap<>();
	
	public static final HiveType BURGUNDY_1 = standardHive("burgundy_1", BloodColor.BURGUNDY, new BlockPos(5, 1, 6), new BlockPos(0, 0, 0));
	public static final HiveType BURGUNDY_2 = standardHive("burgundy_2", BloodColor.BURGUNDY, new BlockPos(3, 1, 5), new BlockPos(0, 0, 0));
	public static final HiveType BURGUNDY_3 = standardHive("burgundy_3", BloodColor.BURGUNDY, new BlockPos(15, 1, 0), new BlockPos(0, 0, 0));
	
	public static final HiveType BRONZE_1 = standardHive("bronze_1", BloodColor.BRONZE, new BlockPos(8, 5, 1), new BlockPos(0, 0, 0));
	public static final HiveType BRONZE_2 = standardHive("bronze_2", BloodColor.BRONZE, new BlockPos(8, 4, 0), new BlockPos(0, 0, 0));
	public static final HiveType BRONZE_3 = standardHive("bronze_3", BloodColor.BRONZE, new BlockPos(1, 1, 6), new BlockPos(0, 0, 0));
	
	public static final HiveType GOLD_1 = standardHive("gold_1", BloodColor.GOLD, new BlockPos(15, 0, 0), new BlockPos(0, 0, 0));
	public static final HiveType GOLD_2 = standardHive("gold_2", BloodColor.GOLD, new BlockPos(7, 1, 9), new BlockPos(0, 0, 0));
	public static final HiveType GOLD_3 = standardHive("gold_3", BloodColor.GOLD, new BlockPos(0, 1, 11), new BlockPos(0, 0, 0));
	
	public static final HiveType MUTANT_1 = standardHive("mutant_1", BloodColor.MUTANT, new BlockPos(1, 4, 8), new BlockPos(0, 0, 0));
	public static final HiveType MUTANT_2 = standardHive("mutant_2", BloodColor.MUTANT, new BlockPos(14, 0, 0), new BlockPos(0, 0, 0));
	public static final HiveType MUTANT_3 = standardHive("mutant_3", BloodColor.MUTANT, new BlockPos(0, 0, 6), new BlockPos(0, 0, 0));
	
	public static final HiveType LIME_1 = standardHive("lime_1", BloodColor.LIME, new BlockPos(9, 1, 0), new BlockPos(0, 0, 0));
	public static final HiveType LIME_2 = standardHive("lime_2", BloodColor.LIME, new BlockPos(0, 1, 15), new BlockPos(0, 0, 0));
	public static final HiveType LIME_3 = standardHive("lime_3", BloodColor.LIME, new BlockPos(0, 0, 15), new BlockPos(0, 0, 0));
	
	public static final HiveType OLIVE_1 = standardHive("olive_1", BloodColor.OLIVE, new BlockPos(4, 1, 13), new BlockPos(0, 0, 0));
	public static final HiveType OLIVE_2 = standardHive("olive_2", BloodColor.OLIVE, new BlockPos(13, 1, 6), new BlockPos(0, 0, 0));
	public static final HiveType OLIVE_3 = standardHive("olive_3", BloodColor.OLIVE, new BlockPos(11, 19, 5), new BlockPos(0, 0, 0));
	
	public static final HiveType JADE_1 = standardHive("jade_1", BloodColor.JADE, new BlockPos(10, 1, 31), new BlockPos(0, 0, 0));
	public static final HiveType JADE_2 = standardHive("jade_2", BloodColor.JADE, new BlockPos(14, 1, 0), new BlockPos(0, 0, 0));
	public static final HiveType JADE_3 = standardHive("jade_3", BloodColor.JADE, new BlockPos(3, 1, 5), new BlockPos(0, 0, 0));
	
	public static final HiveType TEAL_1 = standardHive("teal_1", BloodColor.TEAL, new BlockPos(0, 1, 15), new BlockPos(0, 0, 0));
	public static final HiveType TEAL_2 = standardHive("teal_2", BloodColor.TEAL, new BlockPos(1, 1, 15), new BlockPos(0, 0, 0));
	public static final HiveType TEAL_3 = standardHive("teal_3", BloodColor.TEAL, new BlockPos(15, 1, 0), new BlockPos(0, 0, 0));
	
	public static final HiveType CERULEAN_1 = standardHive("cerulean_1", BloodColor.CERULEAN, new BlockPos(4, 0, 10), new BlockPos(0, 0, 0));
	public static final HiveType CERULEAN_2 = standardHive("cerulean_2", BloodColor.CERULEAN, new BlockPos(21, 10, 15), new BlockPos(0, 0, 0));
	public static final HiveType CERULEAN_3 = standardHive("cerulean_3", BloodColor.CERULEAN, new BlockPos(20, 21, 15), new BlockPos(0, 0, 0));
	
	public static final HiveType INDIGO_1 = standardHive("indigo_1", BloodColor.INDIGO, new BlockPos(3, 1, 0), new BlockPos(0, 0, 0));
	public static final HiveType INDIGO_2 = standardHive("indigo_2", BloodColor.INDIGO, new BlockPos(1, 1, 15), new BlockPos(0, 0, 0));
	public static final HiveType INDIGO_3 = standardHive("indigo_3", BloodColor.INDIGO, new BlockPos(0, 1, 15), new BlockPos(0, 0, 0));
	
	public static final HiveType PURPLE_1 = standardHive("purple_1", BloodColor.PURPLE, new BlockPos(15, 11, 13), new BlockPos(0, 0, 0));
	public static final HiveType PURPLE_2 = standardHive("purple_2", BloodColor.PURPLE, new BlockPos(1, 0, 1), new BlockPos(0, 0, 0));
	public static final HiveType PURPLE_3 = standardHive("purple_3", BloodColor.PURPLE, new BlockPos(15, 0, 0), new BlockPos(0, 0, 0));
	public static final HiveType PURPLE_4 = standardHive("purple_4", BloodColor.PURPLE, new BlockPos(0, 1, 15), new BlockPos(0, 0, 0));
	
	private static HiveType register(ResourceLocation name, Heightmap.Type heightmap, PieceConstructor constructor) {
		HiveType type = new HiveType(name, heightmap, constructor);
		hiveTypes.put(name, type);
		return type;
	}
	
	private static HiveType standardHive(String name, BloodColor color, BlockPos floor, BlockPos spawn) {
		return register(new ResourceLocation(Minestuck_alternia.MOD_ID, name), Heightmap.Type.WORLD_SURFACE_WG, SimpleHiveStructurePiece.with(color, floor, spawn));
	}
}