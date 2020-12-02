package com.apocfarce.minestuck_alternia.world.biome;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.structure.MineshaftConfig;
import net.minecraft.world.gen.feature.structure.MineshaftStructure;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;

public final class ShrublandBiome extends Biome {
	protected ShrublandBiome() {
		super((new Biome.Builder())
				.surfaceBuilder(SurfaceBuilder.DEFAULT, SurfaceBuilder.CORASE_DIRT_DIRT_GRAVEL_CONFIG)
				.precipitation(Biome.RainType.RAIN)
				.category(Biome.Category.PLAINS)
				.depth(0.125F)
				.scale(0.05F)
				.temperature(0.8F)
				.downfall(0.4F)
				.waterColor(0x113355)
				.waterFogColor(0x115588)
				.parent(null));
	}
	
	public void addFeatures() {
		this.addStructure(Feature.MINESHAFT.withConfiguration(new MineshaftConfig(0.004D, MineshaftStructure.Type.NORMAL)));
		this.addStructure(Feature.STRONGHOLD.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
		
		AlterniaBiomeFeatures.addStructures(this);
		
		AlterniaBiomeFeatures.addLowbloodHives(this);
		
		AlterniaBiomeFeatures.addCarvers(this);
		DefaultBiomeFeatures.addStructures(this);
		DefaultBiomeFeatures.addLakes(this);
		DefaultBiomeFeatures.addMonsterRooms(this);
		AlterniaBiomeFeatures.addStoneVariants(this);
		AlterniaBiomeFeatures.addOres(this);
		
		
		DefaultBiomeFeatures.addDeadBushes(this);
		DefaultBiomeFeatures.addDesertLakes(this);
		DefaultBiomeFeatures.addGrass(this);
		
		DefaultBiomeFeatures.addFreezeTopLayer(this);
	}
	
	@Override
	public int getFoliageColor() {
		return(0x889933);
	}
	@Override
	public int getGrassColor(double posX, double posZ) {
		return(0x889944);
	}
}