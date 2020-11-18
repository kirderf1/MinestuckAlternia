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
	
	private static HiveType register(ResourceLocation name, Heightmap.Type heightmap, PieceConstructor constructor) {
		HiveType type = new HiveType(name, heightmap, constructor);
		hiveTypes.put(name, type);
		return type;
	}
	
	private static HiveType makeStandardHive(String name, BloodColor color, BlockPos spawn, BlockPos floor) {
		return register(new ResourceLocation(Minestuck_alternia.MOD_ID, name), Heightmap.Type.WORLD_SURFACE_WG, SimpleHiveStructurePiece.with(color, floor, spawn));
	}
}