package com.apocfarce.minestuck_alternia.world.biome;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;

public class MixedWoodsBiome extends Biome {

	protected MixedWoodsBiome() {
		super(new Biome.Builder()
				.surfaceBuilder(SurfaceBuilder.DEFAULT,SurfaceBuilder.GRASS_DIRT_SAND_CONFIG)
				.precipitation(Biome.RainType.RAIN)
				.category(Biome.Category.FOREST)
				.temperature(0.5F)
				.depth(0.2F)
				.scale(0.2F)
				.temperature(0.25F)
				.downfall(0.8F)
				.waterColor(0x113355)
				.waterFogColor(0x115588)
				.parent(null)
				);
	}
	
	public void addFeatures() {
		AlterniaBiomeFeatures.addStructures(this);
		
		AlterniaBiomeFeatures.addMidhighbloodHives2(this);
		
		DefaultBiomeFeatures.addCarvers(this);
		DefaultBiomeFeatures.addStructures(this);
		DefaultBiomeFeatures.addLakes(this);
		DefaultBiomeFeatures.addMonsterRooms(this);
		DefaultBiomeFeatures.addStoneVariants(this);
		DefaultBiomeFeatures.addOres(this);
		DefaultBiomeFeatures.addSedimentDisks(this);
		
		
		AlterniaBiomeFeatures.addPyralTrees(this);
		AlterniaBiomeFeatures.addMirrageTrees(this);
		
		AlterniaBiomeFeatures.addPyralGrass(this);
		
		DefaultBiomeFeatures.addExtraDefaultFlowers(this);
		DefaultBiomeFeatures.addJungleGrass(this);
		DefaultBiomeFeatures.addMushrooms(this);
		DefaultBiomeFeatures.addSprings(this);
		DefaultBiomeFeatures.addFreezeTopLayer(this);
	}
	
	@Override
	public int getFoliageColor() {
		return(0xAA55EE);
	}
	@Override
	public int getGrassColor(double posX, double posZ) {
		return(0x004455);
	}
	
}