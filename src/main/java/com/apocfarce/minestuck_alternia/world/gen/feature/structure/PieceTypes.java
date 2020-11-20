package com.apocfarce.minestuck_alternia.world.gen.feature.structure;

import com.apocfarce.minestuck_alternia.Minestuck_alternia;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.structure.IStructurePieceType;

public class PieceTypes {
	public static IStructurePieceType HIVE;
	
	public static void register() {
		HIVE = register("hive", SimpleHiveStructurePiece::new);
	}
	
	private static IStructurePieceType register(String name, IStructurePieceType type) {
		return Registry.register(Registry.STRUCTURE_PIECE, new ResourceLocation(Minestuck_alternia.MOD_ID, name), type);
	}
}