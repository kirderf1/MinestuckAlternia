package com.apocfarce.minestuck_alternia.world.gen.feature.structure;

import com.mojang.datafixers.Dynamic;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.structure.ScatteredStructure;
import net.minecraft.world.gen.feature.structure.Structure;
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
		return HiveStructureStart::new;
	}
	
	@Override
	public String getStructureName() {
		return "alternia_hive";
	}
	
	@Override
	public int getSize() {
		return 3;
	}
	
	private static class HiveStructureStart extends StructureStart {
		
		public HiveStructureStart(Structure<?> structure, int chunkX, int chunkZ, MutableBoundingBox boundingBox, int references, long seed) {
			super(structure, chunkX, chunkZ, boundingBox, references, seed);
		}
		
		@Override
		public void init(ChunkGenerator<?> generator, TemplateManager templateManager, int chunkX, int chunkZ, Biome biome) {
			HiveStructureConfig config = (HiveStructureConfig) generator.getStructureConfig(biome, getStructure());
			
		}
	}
}
