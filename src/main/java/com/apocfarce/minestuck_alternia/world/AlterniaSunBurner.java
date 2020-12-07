package com.apocfarce.minestuck_alternia.world;

import com.apocfarce.minestuck_alternia.util.CustomDamageSources;
import com.apocfarce.minestuck_alternia.util.PlayerDataHelper;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class AlterniaSunBurner {
	@SubscribeEvent
	public static void onTick(TickEvent.PlayerTickEvent event) {
		if(event.side.isServer() && event.phase == TickEvent.Phase.END) {
			ServerPlayerEntity player = (ServerPlayerEntity) event.player;
			if (player.world.getDimensionKey() == AlterniaDimensions.ALTERNIA_KEY
					&& player.interactionManager.survivalOrAdventure())
				updateSunburn(player);
		}
	}
	
	private static final int MAX_SUNBURN_FACTOR = 4, SUNBURN_TIMER = 100, NEUTRAL_SUBTRACTED_SKYLIGHT = 4;
	
	private static void updateSunburn(ServerPlayerEntity player) {
		int sunburnTimer = PlayerDataHelper.getPlayerDataForReading(player).getInt("sunburn");
		int factor = getSunburnFactor(player);
		int newTimer = Math.max(0, sunburnTimer + factor);
		if(newTimer >= SUNBURN_TIMER) {
			//Apply sunburn damage and reset timer
			player.attackEntityFrom(CustomDamageSources.SUNBURN, 1);
			newTimer = 0;
		}
		if(sunburnTimer != newTimer)
			PlayerDataHelper.getPlayerDataForWriting(player).putInt("sunburn", newTimer);
	}
	
	private static int getSunburnFactor(ServerPlayerEntity player) {
		int skylightSubtracted = player.world.getSkylightSubtracted();
		if(skylightSubtracted > NEUTRAL_SUBTRACTED_SKYLIGHT || !player.world.canSeeSky(player.getPosition()))
			return -1;
		else return Math.round(MAX_SUNBURN_FACTOR * (1 - skylightSubtracted / (float) NEUTRAL_SUBTRACTED_SKYLIGHT));
	}
}