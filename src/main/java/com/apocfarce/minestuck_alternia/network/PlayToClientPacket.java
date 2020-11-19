package com.apocfarce.minestuck_alternia.network;

import net.minecraftforge.fml.network.NetworkDirection;
import net.minecraftforge.fml.network.NetworkEvent;

import java.util.function.Supplier;

public abstract class PlayToClientPacket implements BasicPacket {
	@Override
	public final void consume(Supplier<NetworkEvent.Context> context) {
		if(context.get().getDirection() == NetworkDirection.PLAY_TO_CLIENT)
			context.get().enqueueWork(this::execute);
		context.get().setPacketHandled(true);
	}
	
	protected abstract void execute();
}