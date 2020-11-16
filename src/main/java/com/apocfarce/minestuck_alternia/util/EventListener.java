package com.apocfarce.minestuck_alternia.util;

import com.apocfarce.minestuck_alternia.network.AlterniaPacketHandler;
import com.apocfarce.minestuck_alternia.network.ShouldDoSelectionPacket;
import com.apocfarce.minestuck_alternia.world.AlterniaDimensions;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.event.server.FMLServerStoppingEvent;
import net.minecraftforge.fml.network.PacketDistributor;

import java.util.HashSet;
import java.util.Set;

public class EventListener {
	
	private static final Set<ServerPlayerEntity> playerInSelection = new HashSet<>();
	
	@SubscribeEvent
	public static void onPlayerLogin(PlayerEvent.PlayerLoggedInEvent event) {
		ServerPlayerEntity player = (ServerPlayerEntity) event.getPlayer();
		if(PlayerDataHelper.hasNotSelectedDimension(player)) {
			if(mightBeFirstTimeLogin(player)) {
				playerInSelection.add(player);
				AlterniaPacketHandler.INSTANCE.send(PacketDistributor.PLAYER.with(() -> player), new ShouldDoSelectionPacket());
			} else PlayerDataHelper.setSelectedDimension(player, false);
		}
	}
	
	@SubscribeEvent
	public static void onServerStopped(FMLServerStoppingEvent event) {
		playerInSelection.clear();
	}
	
	public static void handleDimensionSelection(ServerPlayerEntity player, boolean choseAlternia) {
		if(playerInSelection.contains(player)) {
			playerInSelection.remove(player);
			PlayerDataHelper.setSelectedDimension(player, choseAlternia);
			if(choseAlternia) {
				ServerWorld alternia = DimensionManager.getWorld(player.server, AlterniaDimensions.getDimensionType(), true, true);
				//Idea: randomize spawn point slightly like regular spawn, perhaps?
				//Other idea: spawn the player into an existing hive
				BlockPos spawnPos = alternia.getHeight(Heightmap.Type.MOTION_BLOCKING, alternia.getSpawnPoint());
				PortalUtil.teleportEntity(player, alternia, spawnPos.getX() + 0.5, spawnPos.getY(), spawnPos.getZ() + 0.5, 0, 0);
			}
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
