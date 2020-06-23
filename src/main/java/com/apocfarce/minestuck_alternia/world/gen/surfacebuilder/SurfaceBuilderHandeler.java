package com.apocfarce.minestuck_alternia.world.gen.surfacebuilder;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.registries.IForgeRegistry;

public class SurfaceBuilderHandeler {
	public static SurfaceBuilder<SurfaceBuilderConfig> ColoredSands= new ColoredSandsSurfaceBuilder(SurfaceBuilderConfig::deserialize);
	public static void registerSurfaceBuilders(RegistryEvent.Register<SurfaceBuilder<?>> event)
	{
		IForgeRegistry<SurfaceBuilder<?>> registry = event.getRegistry();
		ColoredSands=register(registry,"colored_desert",ColoredSands);
		
	}
	
	
	
	private static SurfaceBuilder<SurfaceBuilderConfig> register(IForgeRegistry<SurfaceBuilder<?>> registry,String key, SurfaceBuilder<SurfaceBuilderConfig> surfaceBuilderIn){
		return(register(registry,new ResourceLocation("minestuck_alternia:"+key),surfaceBuilderIn));
	}
	
	private static SurfaceBuilder<SurfaceBuilderConfig> register(IForgeRegistry<SurfaceBuilder<?>> registry,ResourceLocation key, SurfaceBuilder<SurfaceBuilderConfig> surfaceBuilderIn){
		registry.register(surfaceBuilderIn.setRegistryName(key));
		return(surfaceBuilderIn);
	}
	
}
