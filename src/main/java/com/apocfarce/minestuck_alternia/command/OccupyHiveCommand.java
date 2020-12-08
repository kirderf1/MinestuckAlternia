package com.apocfarce.minestuck_alternia.command;

import com.apocfarce.minestuck_alternia.util.BloodColor;
import com.apocfarce.minestuck_alternia.util.PortalUtil;
import com.apocfarce.minestuck_alternia.world.AlterniaDimensions;
import com.apocfarce.minestuck_alternia.world.gen.feature.structure.AlterniaStructures;
import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;
import net.minecraft.command.arguments.EntityArgument;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.server.command.EnumArgument;

public class OccupyHiveCommand {
	
	public static void register(CommandDispatcher<CommandSource> dispatcher) {
		dispatcher.register(Commands.literal("occupy_hive").requires(source -> source.hasPermissionLevel(2))
				.then(Commands.argument("player", EntityArgument.player())
				.then(Commands.argument("blood", EnumArgument.enumArgument(BloodColor.class))
				.executes(context -> perform(context.getSource(), EntityArgument.getPlayer(context, "player"), context.getArgument("blood", BloodColor.class))))));
	}
	
	private static int perform(CommandSource source, ServerPlayerEntity player, BloodColor color) {
		ServerWorld alterniaWorld = player.server.getWorld(AlterniaDimensions.ALTERNIA_WORLD_KEY);
		if(alterniaWorld != null) {
			BlockPos spawnPos = AlterniaStructures.HIVE.tryFindHiveToOccupy(alterniaWorld, color);
			if(spawnPos != null) {
				boolean success = PortalUtil.teleportEntity(player, alterniaWorld, spawnPos.getX() + 0.5, spawnPos.getY(), spawnPos.getZ() + 0.5, 0, 0) != null;
				if(success)
					return 1;
			}
		}
		return 0;
	}
}