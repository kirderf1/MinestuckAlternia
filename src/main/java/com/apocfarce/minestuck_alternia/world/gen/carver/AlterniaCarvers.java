package com.apocfarce.minestuck_alternia.world.gen.carver;

import com.apocfarce.minestuck_alternia.MinestuckAlternia;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.carver.ConfiguredCarver;
import net.minecraft.world.gen.carver.ICarverConfig;
import net.minecraft.world.gen.carver.WorldCarver;
import net.minecraft.world.gen.feature.ProbabilityConfig;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class AlterniaCarvers {

	public static final DeferredRegister<WorldCarver<?>> REGISTER = DeferredRegister.create(ForgeRegistries.WORLD_CARVERS, MinestuckAlternia.MOD_ID);
	
	public static final RegistryObject<WorldCarver<ProbabilityConfig>> CAVE = REGISTER.register("cave", () -> new AlterniaCaveCarver(ProbabilityConfig.CODEC, 256));
	public static final RegistryObject<WorldCarver<ProbabilityConfig>> CANYON = REGISTER.register("canyon", () -> new AlterniaCanyonCarver(ProbabilityConfig.CODEC));
	
	public static ConfiguredCarver<ProbabilityConfig> CONFIGURED_CAVE;
	public static ConfiguredCarver<ProbabilityConfig> CONFIGURED_CANYON;
	
	public static void initCarvers() {
		CONFIGURED_CAVE = register("cave", CAVE.get().func_242761_a(new ProbabilityConfig(1/7F)));
		CONFIGURED_CANYON = register("canyon", CANYON.get().func_242761_a(new ProbabilityConfig(1/50F)));
	}
	
	private static <C extends ICarverConfig> ConfiguredCarver<C> register(String name, ConfiguredCarver<C> carver) {
		return WorldGenRegistries.register(WorldGenRegistries.CONFIGURED_CARVER, new ResourceLocation(MinestuckAlternia.MOD_ID, name), carver);
	}
}