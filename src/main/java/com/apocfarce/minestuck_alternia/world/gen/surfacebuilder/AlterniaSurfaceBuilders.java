package com.apocfarce.minestuck_alternia.world.gen.surfacebuilder;

import com.apocfarce.minestuck_alternia.Minestuck_alternia;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;

public class AlterniaSurfaceBuilders {
	
	public static final DeferredRegister<SurfaceBuilder<?>> REGISTER = DeferredRegister.create(ForgeRegistries.SURFACE_BUILDERS, Minestuck_alternia.MOD_ID);
	
	public static final RegistryObject<SurfaceBuilder<SurfaceBuilderConfig>> COLORED_SANDS = REGISTER.register("colored_sands", () -> new ColoredSandsSurfaceBuilder(SurfaceBuilderConfig::deserialize));
	
}