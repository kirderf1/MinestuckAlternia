package com.apocfarce.minestuck_alternia.network;

import com.apocfarce.minestuck_alternia.client.StartDimensionSelectionScreen;
import net.minecraft.client.Minecraft;
import net.minecraft.network.PacketBuffer;

public class ShouldDoSelectionPacket extends PlayToClientPacket {
	
	@Override
	protected void execute() {
		Minecraft.getInstance().displayGuiScreen(new StartDimensionSelectionScreen());	//TODO set a flag instead, so that we could wait until there is no screen if some other mod set the screen first
	}
	
	@Override
	public void encode(PacketBuffer buffer) {
	
	}
	
	@SuppressWarnings("unused")
	public static ShouldDoSelectionPacket decode(PacketBuffer buffer) {
		return new ShouldDoSelectionPacket();
	}
}