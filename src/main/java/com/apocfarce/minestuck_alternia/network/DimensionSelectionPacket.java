package com.apocfarce.minestuck_alternia.network;

import com.apocfarce.minestuck_alternia.util.BloodColor;
import com.apocfarce.minestuck_alternia.util.EventListener;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.network.PacketBuffer;

public class DimensionSelectionPacket extends PlayToServerPacket {
	
	public final boolean choseAlternia;
	public final BloodColor color;
	
	private DimensionSelectionPacket(boolean choseAlternia, BloodColor color) {
		this.choseAlternia = choseAlternia;
		this.color = color;
	}
	
	public static DimensionSelectionPacket overworld() {
		return new DimensionSelectionPacket(false, null);
	}
	
	public static DimensionSelectionPacket alternia(BloodColor color) {
		return new DimensionSelectionPacket(true, color);
	}
	
	@Override
	protected void execute(ServerPlayerEntity player) {
		EventListener.handleDimensionSelection(player, choseAlternia, color);
	}
	
	@Override
	public void encode(PacketBuffer buffer) {
		buffer.writeBoolean(choseAlternia);
		if(choseAlternia)
			color.toBuffer(buffer);
	}
	
	public static DimensionSelectionPacket decode(PacketBuffer buffer) {
		boolean choseAlternia = buffer.readBoolean();
		if(choseAlternia)
			return DimensionSelectionPacket.alternia(BloodColor.fromBuffer(buffer));
		else return DimensionSelectionPacket.overworld();
	}
}