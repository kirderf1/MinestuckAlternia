package com.apocfarce.minestuck_alternia.util;

import com.apocfarce.minestuck_alternia.network.AlterniaPacketHandler;
import com.apocfarce.minestuck_alternia.network.ShouldDoSelectionPacket;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.network.PacketDistributor;

public class EventListener {
	
	@SubscribeEvent
	public static void onPlayerLogin(PlayerEvent.PlayerLoggedInEvent event) {
		ServerPlayerEntity player = (ServerPlayerEntity) event.getPlayer();
		if(PlayerDataHelper.hasNotSelectedDimension(player)) {
			if(mightBeFirstTimeLogin(player))
				AlterniaPacketHandler.INSTANCE.send(PacketDistributor.PLAYER.with(() -> player), new ShouldDoSelectionPacket());
			else PlayerDataHelper.setSelectedDimension(player, false);
		}
	}
	
	private static boolean mightBeFirstTimeLogin(ServerPlayerEntity player) {
		//Used to attempt to tell the difference between a player who logged in to the world for the first time,
		// and a player who had logged in to the world before, but before adding this mod/before this update
		// It's not a surefire way, but it should catch all important situations, by assuming that if a player haven't gotten any
		// advancements, then they have joined for the first time.
		return player.server.getAdvancementManager().getAllAdvancements().stream().noneMatch(advancement ->
				player.getAdvancements().getProgress(advancement).isDone());
	}
}
