package com.apocfarce.minestuck_alternia.network;

import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.network.NetworkEvent;

import java.util.function.Supplier;

public interface BasicPacket {
	void encode(PacketBuffer buffer);
	
	void consume(Supplier<NetworkEvent.Context> context);
}