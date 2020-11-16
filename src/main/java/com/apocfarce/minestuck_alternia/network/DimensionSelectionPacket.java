package com.apocfarce.minestuck_alternia.network;

import com.apocfarce.minestuck_alternia.util.PlayerDataHelper;
import com.apocfarce.minestuck_alternia.util.PortalUtil;
import com.apocfarce.minestuck_alternia.world.AlterniaDimensions;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.DimensionManager;

public class DimensionSelectionPacket extends PlayToServerPacket {
	
	public final boolean choseAlternia;
	
	public DimensionSelectionPacket(boolean choseAlternia) {
		this.choseAlternia = choseAlternia;
	}
	
	@Override
	protected void execute(ServerPlayerEntity player) {
		//TODO track choices in progress so that people can't cheat by sending this packet to at any time teleport to alternia spawn
		PlayerDataHelper.setSelectedDimension(player, choseAlternia);
		if(choseAlternia) {
			ServerWorld alternia = DimensionManager.getWorld(player.server, AlterniaDimensions.getDimensionType(), true, true);
			//TODO randomize spawn point slightly like regular spawn, perhaps?
			//Other idea: spawn the player into an existing hive
			BlockPos spawnPos = alternia.getSpawnPoint();
			PortalUtil.teleportEntity(player, alternia, spawnPos.getX() + 0.5, spawnPos.getY(), spawnPos.getZ() + 0.5, 0, 0);
		}
	}
	
	@Override
	public void encode(PacketBuffer buffer) {
		buffer.writeBoolean(choseAlternia);
	}
	
	public static DimensionSelectionPacket decode(PacketBuffer buffer) {
		return new DimensionSelectionPacket(buffer.readBoolean());
	}
}