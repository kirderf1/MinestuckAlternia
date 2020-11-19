package com.apocfarce.minestuck_alternia.world.biome;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;

public class MirrageWoodsBiome extends Biome {

	protected MirrageWoodsBiome() {
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
		
		AlterniaBiomeFeatures.addMidlowbloodHives(this);
		
		DefaultBiomeFeatures.addCarvers(this);
		DefaultBiomeFeatures.addStructures(this);
		DefaultBiomeFeatures.addLakes(this);
		DefaultBiomeFeatures.addMonsterRooms(this);
		DefaultBiomeFeatures.addStoneVariants(this);
		DefaultBiomeFeatures.addOres(this);
		DefaultBiomeFeatures.addSedimentDisks(this);
		
		AlterniaBiomeFeatures.addMirrageTrees(this);
//	      addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(createGrassClusterConfig(AlterniaBlocks.mirrageGrass.getDefaultState())).withPlacement(Placement.COUNT_HEIGHTMAP.configure(new FrequencyConfig(1))));
		
		
		DefaultBiomeFeatures.addExtraDefaultFlowers(this);
		DefaultBiomeFeatures.addJungleGrass(this);
		DefaultBiomeFeatures.addMushrooms(this);
		DefaultBiomeFeatures.addSprings(this);
		DefaultBiomeFeatures.addFreezeTopLayer(this);
	}
	
	@Override
	public int getFoliageColor() {
		return(0x666666);
	}
	@Override
	public int getGrassColor(double posX, double posZ) {
		return(0x666666);
	}
}
