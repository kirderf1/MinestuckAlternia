package com.apocfarce.minestuck_alternia.world.gen.feature.structure;

import com.apocfarce.minestuck_alternia.Item.BloodColor;
import com.apocfarce.minestuck_alternia.Minestuck_alternia;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.feature.structure.StructurePiece;
import net.minecraft.world.gen.feature.template.TemplateManager;

public final class HiveType {
	public final ResourceLocation name;
	public final Heightmap.Type heightmap;
	public final BloodColor color;
	public final PieceConstructor constructor;
	
	private HiveType(ResourceLocation name, BloodColor color, Heightmap.Type heightmap, PieceConstructor constructor) {
		this.name = name;
		this.heightmap = heightmap;
		this.color = color;
		this.constructor = constructor;
	}
	
	public StructurePiece createPiece(TemplateManager templates, BlockPos pos, Rotation rotation) {
		return constructor.create(templates, name, pos, rotation);
	}
	
	public interface PieceConstructor {
		StructurePiece create(TemplateManager templates, ResourceLocation name, BlockPos pos, Rotation rotation);
	}
	
	private static HiveType makeStandardHive(String name, BloodColor color, BlockPos spawn, BlockPos floor) {
		return new HiveType(new ResourceLocation(Minestuck_alternia.MOD_ID, name), color, Heightmap.Type.WORLD_SURFACE_WG, SimpleHiveStructurePiece.with(color, floor, spawn));
	}
}