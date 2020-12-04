package com.apocfarce.minestuck_alternia.world.gen.carver;

import com.apocfarce.minestuck_alternia.MinestuckAlternia;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.carver.ConfiguredCarver;
import net.minecraft.world.gen.carver.ICarverConfig;
import net.minecraft.world.gen.carver.WorldCarver;
import net.minecraft.world.gen.feature.ProbabilityConfig;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, modid = MinestuckAlternia.MOD_ID)
public class AlterniaCarvers {
	
	public static ConfiguredCarver<ProbabilityConfig> CONFIGURED_CAVE;
	public static ConfiguredCarver<ProbabilityConfig> CONFIGURED_CANYON;
	
	@SubscribeEvent
	public static void registerCarvers(RegistryEvent.Register<WorldCarver<?>> event) {
		WorldCarver<ProbabilityConfig> cave = register(event.getRegistry(), "cave", new AlterniaCaveCarver(ProbabilityConfig.CODEC, 256));
		WorldCarver<ProbabilityConfig> canyon = register(event.getRegistry(), "canyon", new AlterniaCanyonCarver(ProbabilityConfig.CODEC));
		CONFIGURED_CAVE = register("cave", cave.func_242761_a(new ProbabilityConfig(1/7F)));
		CONFIGURED_CANYON = register("canyon", canyon.func_242761_a(new ProbabilityConfig(1/50F)));
	}
	
	private static <C extends WorldCarver<?>> C register(IForgeRegistry<WorldCarver<?>> registry, String name, C carver) {
		registry.register(carver.setRegistryName(name));
		return carver;
	}
	
	private static <C extends ICarverConfig> ConfiguredCarver<C> register(String name, ConfiguredCarver<C> carver) {
		return WorldGenRegistries.register(WorldGenRegistries.CONFIGURED_CARVER, new ResourceLocation(MinestuckAlternia.MOD_ID, name), carver);
	}
}