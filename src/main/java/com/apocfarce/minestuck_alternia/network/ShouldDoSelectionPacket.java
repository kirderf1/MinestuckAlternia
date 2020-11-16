package com.apocfarce.minestuck_alternia.network;

import com.apocfarce.minestuck_alternia.client.StartDimensionSelectionScreen;
import net.minecraft.client.Minecraft;
import net.minecraft.network.PacketBuffer;

public class ShouldDoSelectionPacket extends PlayToClientPacket {
	
	@Override
	protected void execute() {
		StartDimensionSelectionScreen.setShouldShowScreen();
	}
	
	@Override
	public void encode(PacketBuffer buffer) {
	
	}
	
	@SuppressWarnings("unused")
	public static ShouldDoSelectionPacket decode(PacketBuffer buffer) {
		return new ShouldDoSelectionPacket();
	}
}