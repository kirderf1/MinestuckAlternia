package com.apocfarce.minestuck_alternia.world.biome;

import net.minecraft.block.BlockState;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.ISurfaceBuilderConfig;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;

import java.util.Random;
import java.util.function.Supplier;

/**
 * A biome class designed for use with surface builders provided through suppliers.
 */
public abstract class CustomSurfaceBiome extends Biome {
	private final Supplier<ConfiguredSurfaceBuilder<?>> surfaceBuilderSupplier;
	private ConfiguredSurfaceBuilder<?> surfaceBuilder = null;
	
	protected <T extends ISurfaceBuilderConfig> CustomSurfaceBiome(Supplier<SurfaceBuilder<T>> surfaceBuilder, Supplier<T> surfaceConfig, Builder biomeBuilder) {
		super(biomeBuilder.surfaceBuilder(SurfaceBuilder.NOPE, SurfaceBuilder.STONE_STONE_GRAVEL_CONFIG));
		surfaceBuilderSupplier = () -> new ConfiguredSurfaceBuilder<>(surfaceBuilder.get(), surfaceConfig.get());
	}
	
	@Override
	public void buildSurface(Random random, IChunk chunkIn, int x, int z, int startHeight, double noise, BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed) {
		getSurfaceBuilder().setSeed(seed);
		getSurfaceBuilder().buildSurface(random, chunkIn, this, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed);
	}
	
	@Override
	public ConfiguredSurfaceBuilder<?> getSurfaceBuilder() {
		if(surfaceBuilder == null)
			surfaceBuilder = surfaceBuilderSupplier.get();
		return surfaceBuilder;
	}
	
	@Override
	public ISurfaceBuilderConfig getSurfaceBuilderConfig() {
		return getSurfaceBuilder().getConfig();
	}
}