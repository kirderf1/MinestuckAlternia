package com.apocfarce.minestuck_alternia.world.gen.feature.structure;

import com.apocfarce.minestuck_alternia.util.BloodColor;
import net.minecraft.util.math.BlockPos;

import javax.annotation.Nullable;

public interface LiveableHive {
	/**
	 * Checks if the given blood color can occupy this hive, and if true,
	 * sets any flags that this is occupied and returns the spawn position.
	 * Otherwise, returns null.
	 */
	@Nullable
	BlockPos tryOccupy(BloodColor color);
}