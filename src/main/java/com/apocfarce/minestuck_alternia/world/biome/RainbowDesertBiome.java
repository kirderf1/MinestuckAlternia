package com.apocfarce.minestuck_alternia.world.biome;

import com.apocfarce.minestuck_alternia.world.gen.surfacebuilder.AlterniaSurfaceBuilders;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;

public class RainbowDesertBiome extends CustomSurfaceBiome {
	protected RainbowDesertBiome() {
		super(AlterniaSurfaceBuilders.COLORED_SANDS, () -> SurfaceBuilder.SAND_CONFIG, new Biome.Builder()
				.precipitation(Biome.RainType.NONE)
				.category(Biome.Category.DESERT)
				.temperature(0.5F)
				.depth(0.125F)
				.scale(0.05F)
				.temperature(2.0F)
				.downfall(0.0F)
				.waterColor(0x113355)
				.waterFogColor(0x115588)
				.parent(null)
				);
	}
	
	public void addFeatures() {
		AlterniaBiomeFeatures.addStructures(this);
		
		AlterniaBiomeFeatures.addHighbloodHives(this);

		AlterniaBiomeFeatures.addCarvers(this);
		DefaultBiomeFeatures.addStructures(this);
		DefaultBiomeFeatures.addMonsterRooms(this);
		AlterniaBiomeFeatures.addStoneVariants(this);
		AlterniaBiomeFeatures.addOres(this);
		DefaultBiomeFeatures.addSedimentDisks(this);
		
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
