package com.apocfarce.minestuck_alternia.network;

import com.apocfarce.minestuck_alternia.Minestuck_alternia;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.network.NetworkDirection;
import net.minecraftforge.fml.network.NetworkRegistry;
import net.minecraftforge.fml.network.simple.SimpleChannel;

import java.util.Optional;
import java.util.function.Function;

public class AlterniaPacketHandler {
	private static final String PROTOCOL_VERSION = "1";
	public static final SimpleChannel INSTANCE = NetworkRegistry.newSimpleChannel(
			new ResourceLocation(Minestuck_alternia.MOD_ID, "main"),
			() -> PROTOCOL_VERSION,
			PROTOCOL_VERSION::equals,
			PROTOCOL_VERSION::equals
	);
	
	private static int id = 0;
	
	public static void registerPackets() {
		if(id != 0)
			throw new IllegalStateException("Packets already registered!");
		
		registerToClient(ShouldDoSelectionPacket.class, ShouldDoSelectionPacket::decode);
		registerToServer(DimensionSelectionPacket.class, DimensionSelectionPacket::decode);
	}
	
	private static <T extends PlayToClientPacket> void registerToClient(Class<T> c, Function<PacketBuffer, T> decoder) {
		INSTANCE.registerMessage(id++, c, BasicPacket::encode, decoder, BasicPacket::consume, Optional.of(NetworkDirection.PLAY_TO_CLIENT));
	}
	private static <T extends PlayToServerPacket> void registerToServer(Class<T> c, Function<PacketBuffer, T> decoder) {
		INSTANCE.registerMessage(id++, c, BasicPacket::encode, decoder, BasicPacket::consume, Optional.of(NetworkDirection.PLAY_TO_SERVER));
	}
}