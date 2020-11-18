package com.apocfarce.minestuck_alternia.world.gen.feature.structure;

import com.apocfarce.minestuck_alternia.Item.BloodColor;
import com.mojang.datafixers.Dynamic;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.feature.structure.ScatteredStructure;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.feature.structure.StructurePiece;
import net.minecraft.world.gen.feature.structure.StructureStart;
import net.minecraft.world.gen.feature.template.TemplateManager;

import java.util.function.Function;

public class HiveStructure extends ScatteredStructure<HiveStructureConfig> {
	
	public HiveStructure(Function<Dynamic<?>, ? extends HiveStructureConfig> configFactoryIn) {
		super(configFactoryIn);
	}
	
	@Override
	protected int getSeedModifier() {
		return 555768014;
	}
	
	@Override
	public IStartFactory getStartFactory() {
		return Start::new;
	}
	
	@Override
	public String getStructureName() {
		return "alternia_hive";
	}
	
	@Override
	public int getSize() {
		return 3;
	}
	
	private static class Start extends StructureStart {
		
		public Start(Structure<?> structure, int chunkX, int chunkZ, MutableBoundingBox boundingBox, int references, long seed) {
			super(structure, chunkX, chunkZ, boundingBox, references, seed);
		}
		
		@Override
		public void init(ChunkGenerator<?> generator, TemplateManager templateManager, int chunkX, int chunkZ, Biome biome) {
			
			HiveStructureConfig config = (HiveStructureConfig) generator.getStructureConfig(biome, getStructure());
			if(config == null) {
				return;
			}
			
			HiveType type = config.pickType(rand);
			
			int x = chunkX * 16 + rand.nextInt(16);
			int z = chunkZ * 16 + rand.nextInt(16);
			int y = generator.getNoiseHeightMinusOne(x, z, Heightmap.Type.WORLD_SURFACE_WG);
			BlockPos position = new BlockPos(x, y, z);
			
			Rotation rotation = Rotation.randomRotation(rand);
			
			StructurePiece piece = type.createPiece(templateManager, position, rotation);
			components.add(piece);
			piece.buildComponent(piece, components, rand);
			
			recalculateStructureSize();
		}
		
		public BlockPos tryOccupy(BloodColor color) {
			StructurePiece piece = components.get(0);
			return piece instanceof LiveableHive ? ((LiveableHive) piece).tryOccupy(color) : null;
		}
	}
}
