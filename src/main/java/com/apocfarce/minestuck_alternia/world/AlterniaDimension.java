package com.apocfarce.minestuck_alternia.world;

import com.apocfarce.minestuck_alternia.block.AlterniaBlocks;
import com.apocfarce.minestuck_alternia.util.CustomDamageSources;
import com.apocfarce.minestuck_alternia.util.PlayerDataHelper;
import com.apocfarce.minestuck_alternia.world.biome.provider.AlterniaBiomeProvider;
import com.apocfarce.minestuck_alternia.world.biome.provider.AlterniaBiomeProviderSettings;
import com.apocfarce.minestuck_alternia.world.biome.provider.AlterniaBiomeProviderTypes;
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
	
	public AlterniaDimension(World worldIn, DimensionType typeIn) {
		super(worldIn, typeIn, 0.1F);
	}
	
	@Override
	public ChunkGenerator<?> createChunkGenerator() {
		
		BiomeProviderType<AlterniaBiomeProviderSettings, AlterniaBiomeProvider> biomeProviderType = AlterniaBiomeProviderTypes.ALTERNIA.get();
		
		
		OverworldGenSettings genSettings = ChunkGeneratorType.SURFACE.createSettings();
	
		genSettings.setDefaultBlock(AlterniaBlocks.DARK_STONE.getDefaultState());
		
		AlterniaBiomeProviderSettings alterniabiomeprovidersettings = biomeProviderType.createSettings(world.getWorldInfo()).setGeneratorSettings(genSettings);
		return ChunkGeneratorType.SURFACE.create(this.world, biomeProviderType.create(alterniabiomeprovidersettings), genSettings);
	}
	
	@Nullable
	@Override
	public BlockPos findSpawn(ChunkPos chunkPos, boolean checkValid) {
		for (int x = chunkPos.getXStart(); x <= chunkPos.getXEnd(); x++) {
			for (int z = chunkPos.getZStart(); z <= chunkPos.getZEnd(); z++) {
				BlockPos blockpos = this.findSpawn(x, z, checkValid);
				if (blockpos != null) {
					return blockpos;
				}
			}
		}
		
		return null;
	}
	
	@Nullable
	@Override
	public BlockPos findSpawn(int x, int z, boolean checkValid) {
		BlockPos.Mutable mutablePos = new BlockPos.Mutable(x, 0, z);
		Biome biome = this.world.getBiome(mutablePos);
		BlockState surfaceBlockState = biome.getSurfaceBuilderConfig().getTop();
		if (checkValid && !surfaceBlockState.getBlock().isIn(BlockTags.VALID_SPAWN)) {
			return null;
		} else {
			Chunk chunk = this.world.getChunk(x >> 4, z >> 4);
			int topY = chunk.getTopBlockY(Heightmap.Type.MOTION_BLOCKING, x & 15, z & 15);
			if (topY < 0)
				return null;
			else if (chunk.getTopBlockY(Heightmap.Type.WORLD_SURFACE, x & 15, z & 15) > chunk.getTopBlockY(Heightmap.Type.OCEAN_FLOOR, x & 15, z & 15))
				return null;
			else {
				for (int y = topY + 1; y >= 0; y--) {
					mutablePos.setPos(x, y, z);
					BlockState state = this.world.getBlockState(mutablePos);
					if (!state.getFluidState().isEmpty())
						break;
					
					if (state.equals(surfaceBlockState))
						return mutablePos.up().toImmutable();
				}
				
				return null;
			}
		}
	}
	
	/**
	 * Calculates the angle of sun and moon in the sky relative to a specified time (usually worldTime)
	 */
	@Override
	public float calculateCelestialAngle(long worldTime, float partialTicks) {
		// A term representing the day-night angle. 0: noon, 0.5: midnight, 1: noon on the following day
		double angleFraction = MathHelper.frac((double) worldTime / 24000.0 + 0.25);
		// A term which represents the day-night angle, but modified to have longer nights (in the same manner as vanilla has longer days)
		double longNightModifier = Math.acos(1 - 2*angleFraction) / Math.PI;
		// The two angle terms are weighted together to lessen the impact of the "longer nights" term
		return (float) (2*angleFraction + longNightModifier) / 3;
	}
	
	@Override
	public void tick() {
		if(!world.isRemote) {
			for(PlayerEntity player : world.getPlayers()) {
				if(((ServerPlayerEntity) player).interactionManager.survivalOrAdventure())
					updateSunburn((ServerPlayerEntity) player);
			}
		}
	}
	
	private static final int MAX_SUNBURN_FACTOR = 4, SUNBURN_TIMER = 100, NEUTRAL_SUBTRACTED_SKYLIGHT = 4;
	
	private void updateSunburn(ServerPlayerEntity player) {
		int sunburnTimer = PlayerDataHelper.getPlayerDataForReading(player).getInt("sunburn");
		int factor = getSunburnFactor(player);
		int newTimer = Math.max(0, sunburnTimer + factor);
		if(newTimer >= SUNBURN_TIMER) {
			//Apply sunburn damage and reset timer
			player.attackEntityFrom(CustomDamageSources.SUNBURN, 1);
			newTimer = 0;
		}
		if(sunburnTimer != newTimer)
			PlayerDataHelper.getPlayerDataForWriting(player).putInt("sunburn", newTimer);
	}
	
	private int getSunburnFactor(ServerPlayerEntity player) {
		int skylightSubtracted = world.getSkylightSubtracted();
		if(skylightSubtracted > NEUTRAL_SUBTRACTED_SKYLIGHT || !world.canSeeSky(player.getPosition()))
			return -1;
		else return Math.round(MAX_SUNBURN_FACTOR * (1 - skylightSubtracted / (float) NEUTRAL_SUBTRACTED_SKYLIGHT));
	}
	
	/**
	 * Returns 'true' if in the "main surface world", but 'false' if in the Nether or End dimensions.
	 */
	@Override
	public boolean isSurfaceWorld() {
		return true;
	}
	
	/**
	 * Return Vec3D with biome specific fog color
	 */
	@Override
	public Vec3d getFogColor(float CelestialAngle, float partialTicks) {
		float dayRed = 1.0F;
		float dayGreen = 0.5F;
		float dayBlue = 0.2F;
		float nightRed = 0.2F;
		float nightGreen = 0.3F;
		float nightBlue = 0.3F;
		
		float time = MathHelper.cos(CelestialAngle * ((float) Math.PI * 2F)) * 2.0F + 0.5F;
		time = MathHelper.clamp(time, 0.0F, 1.0F);
		float RRange = dayRed - nightRed;
		float GRange = dayGreen - nightGreen;
		float BRange = dayBlue - nightBlue;
		
		float red = time * RRange + nightRed;
		float green = time * GRange + nightGreen;
		float blue = time * BRange + nightBlue;
		
		return new Vec3d(red, green, blue);
	}
	
	/**
	 * True if the player can respawn in this dimension (true = overworld, false = nether).
	 */
	@Override
	public boolean canRespawnHere() {
		return true;
	}
	
	/**
	 * Returns true if the given X,Z coordinate should show environmental fog.
	 */
	@Override
	public boolean doesXZShowFog(int x, int z) {
		return false;
	}
	
	public static class Type extends ModDimension {
		@Override
		public BiFunction<World, DimensionType, ? extends Dimension> getFactory() {
			return AlterniaDimension::new;
		}
	}
}
