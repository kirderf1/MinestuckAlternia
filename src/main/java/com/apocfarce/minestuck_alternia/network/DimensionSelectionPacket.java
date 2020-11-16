package com.apocfarce.minestuck_alternia.network;

import com.apocfarce.minestuck_alternia.util.EventListener;
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
		EventListener.handleDimensionSelection(player, choseAlternia);
	}
	
	@Override
	public void encode(PacketBuffer buffer) {
		buffer.writeBoolean(choseAlternia);
	}
	
	public static DimensionSelectionPacket decode(PacketBuffer buffer) {
		return new DimensionSelectionPacket(buffer.readBoolean());
	}
}