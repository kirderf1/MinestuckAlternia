package com.apocfarce.minestuck_alternia.world.gen.feature;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.world.gen.feature.IFeatureConfig;

import java.util.function.Supplier;

public class LakesFeatureConfig implements IFeatureConfig {
	
	public static final Codec<LakesFeatureConfig> CODEC = RecordCodecBuilder.create(builder ->
			builder.group(BlockState.CODEC.fieldOf("lake").forGetter(LakesFeatureConfig::getLakeState),
					BlockState.CODEC.optionalFieldOf("edge", Blocks.AIR.getDefaultState()).forGetter(LakesFeatureConfig::getEdgeState))
					.apply(builder, LakesFeatureConfig::new));
	
	private final Supplier<BlockState> lakeState, edgeState;
	
	public LakesFeatureConfig(BlockState lakeState) {
		this(lakeState, Blocks.AIR.getDefaultState());
	}
	
	public LakesFeatureConfig(Supplier<BlockState> lakeState) {
		this(lakeState, Blocks.AIR::getDefaultState);
	}
	
	public LakesFeatureConfig(BlockState lakeState, BlockState edgeState) {
		this(() -> lakeState, () -> edgeState);
	}
	
	public LakesFeatureConfig(Supplier<BlockState> lakeState, Supplier<BlockState> edgeState) {
		this.lakeState = lakeState;
		this.edgeState = edgeState;
	}
	
	public BlockState getLakeState() {
		return lakeState.get();
	}
	
	public BlockState getEdgeState() {
		return edgeState.get();
	}
	
	public boolean hasEdgeState() {
		return getEdgeState().getBlock() != Blocks.AIR;
	}
}