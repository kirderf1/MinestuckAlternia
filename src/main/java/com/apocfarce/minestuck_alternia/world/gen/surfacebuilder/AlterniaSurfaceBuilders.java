package com.apocfarce.minestuck_alternia.world.gen.surfacebuilder;

import com.apocfarce.minestuck_alternia.MinestuckAlternia;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class AlterniaSurfaceBuilders {
	
	public static final DeferredRegister<SurfaceBuilder<?>> REGISTER = DeferredRegister.create(ForgeRegistries.SURFACE_BUILDERS, MinestuckAlternia.MOD_ID);
	
	public static final RegistryObject<SurfaceBuilder<SurfaceBuilderConfig>> COLORED_SANDS = REGISTER.register("colored_sands", () -> new ColoredSandsSurfaceBuilder(SurfaceBuilderConfig::deserialize));
	public static final RegistryObject<SurfaceBuilder<SurfaceBuilderConfig>> DARK_STONE = REGISTER.register("dark_stone", () -> new DarkStoneSurfaceBuilder(SurfaceBuilderConfig::deserialize));
}