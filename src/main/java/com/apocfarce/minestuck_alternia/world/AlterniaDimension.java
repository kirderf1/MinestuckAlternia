package com.apocfarce.minestuck_alternia.world;
/*
import com.apocfarce.minestuck_alternia.block.AlterniaBlocks;
import com.apocfarce.minestuck_alternia.util.CustomDamageSources;
import com.apocfarce.minestuck_alternia.util.PlayerDataHelper;
import com.apocfarce.minestuck_alternia.world.biome.provider.AlterniaBiomeProvider;
import com.apocfarce.minestuck_alternia.world.biome.provider.AlterniaBiomeProviders;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.provider.BiomeProviderType;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.dimension.Dimension;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.ChunkGeneratorType;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.OverworldGenSettings;
import net.minecraftforge.common.ModDimension;

import javax.annotation.Nullable;
import java.util.function.BiFunction;

public class AlterniaDimension extends Dimension {
	
	/**
	 * Calculates the angle of sun and moon in the sky relative to a specified time (usually worldTime)
	 * /
	@Override
	public float calculateCelestialAngle(long worldTime, float partialTicks) {
		// A term representing the day-night angle. 0: noon, 0.5: midnight, 1: noon on the following day
		double angleFraction = MathHelper.frac((double) worldTime / 24000.0 + 0.25);
		// A term which represents the day-night angle, but modified to have longer nights (in the same manner as vanilla has longer days)
		double longNightModifier = Math.acos(1 - 2*angleFraction) / Math.PI;
		// The two angle terms are weighted together to lessen the impact of the "longer nights" term
		return (float) (2*angleFraction + longNightModifier) / 3;
	}
	
}
*/