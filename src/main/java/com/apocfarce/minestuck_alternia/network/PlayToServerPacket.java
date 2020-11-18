package com.apocfarce.minestuck_alternia.network;

import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraftforge.fml.network.NetworkDirection;
import net.minecraftforge.fml.network.NetworkEvent;

import java.util.function.Supplier;

public abstract class PlayToServerPacket implements BasicPacket {
	@Override
	public final void consume(Supplier<NetworkEvent.Context> context) {
		if(context.get().getDirection() == NetworkDirection.PLAY_TO_SERVER)
			context.get().enqueueWork(() -> execute(context.get().getSender()));
		context.get().setPacketHandled(true);
	}
	
	protected abstract void execute(ServerPlayerEntity player);
}