package com.apocfarce.minestuck_alternia.world.gen.carver;

import com.apocfarce.minestuck_alternia.MinestuckAlternia;

import net.minecraft.world.gen.carver.WorldCarver;
import net.minecraft.world.gen.feature.ProbabilityConfig;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class AlterniaCarvers {

	public static final DeferredRegister<WorldCarver<?>> REGISTER = DeferredRegister.create(ForgeRegistries.WORLD_CARVERS, MinestuckAlternia.MOD_ID);
	
	public static final RegistryObject<WorldCarver<ProbabilityConfig>> ALTERNIA_CAVES = REGISTER.register("alternia_caves", () -> new AlterniaCaveCarver(ProbabilityConfig::deserialize, 256));
	public static final RegistryObject<WorldCarver<ProbabilityConfig>> ALTERNIA_CANYONS = REGISTER.register("alternia_canyons", () -> new AlterniaCanyonCarver(ProbabilityConfig::deserialize));
	
}
