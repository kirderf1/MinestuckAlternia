package com.apocfarce.minestuck_alternia.util;

import com.apocfarce.minestuck_alternia.Minestuck_alternia;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraftforge.common.util.Constants;

public class PlayerDataHelper {
	
	public static boolean hasNotSelectedDimension(ServerPlayerEntity player) {
		return !getPersistedDataForReading(player).contains("chose_alternia", Constants.NBT.TAG_BYTE);
	}
	
	public static void setSelectedDimension(ServerPlayerEntity player, boolean choseAlternia) {
		if(!player.getPersistentData().contains(PlayerEntity.PERSISTED_NBT_TAG, Constants.NBT.TAG_COMPOUND))
			player.getPersistentData().put(PlayerEntity.PERSISTED_NBT_TAG, new CompoundNBT());
		
		CompoundNBT data = getPersistedDataForWriting(player);
		data.putBoolean("chose_alternia", choseAlternia);
	}
	
	/**
	 * Returns a data tag for reading persisted player data.
	 */
	public static CompoundNBT getPersistedDataForReading(ServerPlayerEntity player) {
		return player.getPersistentData().getCompound(PlayerEntity.PERSISTED_NBT_TAG).getCompound(Minestuck_alternia.MOD_ID);
	}
	
	/**
	 * Gets (and if not present, creates) a data tag for writing persisted player data.
	 * This data is saved in the player entity, and is copied over in special circumstances such as death.
	 * Appropriate for basically any player data that should be carried over on death.
	 */
	public static CompoundNBT getPersistedDataForWriting(ServerPlayerEntity player) {
		return getOrCreate(getOrCreate(player.getPersistentData(), PlayerEntity.PERSISTED_NBT_TAG), Minestuck_alternia.MOD_ID);
	}
	
	/**
	 * Returns a data tag for reading non-persisted player data.
	 */
	public static CompoundNBT getPlayerDataForReading(ServerPlayerEntity player) {
		return player.getPersistentData().getCompound(Minestuck_alternia.MOD_ID);
	}
	
	/**
	 * Gets (and if not present, creates) a data tag for writing non-persisted player data.
	 * This data is saved in the player entity, but is lost in special circumstances such as death.
	 * Appropriate for any temporary data, such as effect timers.
	 */
	public static CompoundNBT getPlayerDataForWriting(ServerPlayerEntity player) {
		return getOrCreate(player.getPersistentData(), Minestuck_alternia.MOD_ID);
	}
	
	private static CompoundNBT getOrCreate(CompoundNBT nbt, String name) {
		if(!nbt.contains(name, Constants.NBT.TAG_COMPOUND)) {
			nbt.put(name, new CompoundNBT());
		}
		return nbt.getCompound(name);
	}
}