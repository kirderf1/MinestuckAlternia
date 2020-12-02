package com.apocfarce.minestuck_alternia.world.biome;

import com.apocfarce.minestuck_alternia.world.gen.surfacebuilder.AlterniaSurfaceBuilders;

import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.BlockStateFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.structure.MineshaftConfig;
import net.minecraft.world.gen.feature.structure.MineshaftStructure;
import net.minecraft.world.gen.placement.ChanceConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;

public final class VolcanicFieldsBiome extends CustomSurfaceBiome {
	protected VolcanicFieldsBiome() {
		super(AlterniaSurfaceBuilders.DARK_STONE,()-> SurfaceBuilder.CORASE_DIRT_DIRT_GRAVEL_CONFIG,new Biome.Builder()
				.precipitation(Biome.RainType.RAIN)
				.category(Biome.Category.MESA)
				.depth(0.8F)
				.scale(0.25F)
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
		
		AlterniaBiomeFeatures.addHighbloodHives(this);
		
		AlterniaBiomeFeatures.addCarvers(this);
		DefaultBiomeFeatures.addStructures(this);
		DefaultBiomeFeatures.addMonsterRooms(this);
	//	AlterniaBiomeFeatures.addStoneVariants(this);
	//	AlterniaBiomeFeatures.addOres(this);
	//	DefaultBiomeFeatures.addSedimentDisks(this);   
		addFeature(GenerationStage.Decoration.LOCAL_MODIFICATIONS, Feature.LAKE.withConfiguration(new BlockStateFeatureConfig(Blocks.LAVA.getDefaultState())).withPlacement(Placement.LAVA_LAKE.configure(new ChanceConfig(10))));

	}
	
	@Override
	public int getFoliageColor() {
		return(0x9955DD);
	}
	@Override
	public int getGrassColor(double posX, double posZ) {
		return(0x004411);
	}
}