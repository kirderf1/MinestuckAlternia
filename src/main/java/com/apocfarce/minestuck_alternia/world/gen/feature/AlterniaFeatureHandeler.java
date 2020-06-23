package com.apocfarce.minestuck_alternia.world.gen.feature;


import net.minecraft.util.ResourceLocation;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.registries.IForgeRegistry;

public class AlterniaFeatureHandeler {
	public static Feature<NoFeatureConfig> pyralTreeFeature=new PyralTreeFeature(NoFeatureConfig::deserialize,false);
	public static Feature<NoFeatureConfig> pyralTreeLargeFeature=new PyralTreeLargeFeature(NoFeatureConfig::deserialize, false);
	public static Feature<NoFeatureConfig> mirrageTreeFeature=new MirrageTreeFeature(NoFeatureConfig::deserialize,false);
	public static Feature<NoFeatureConfig> mirrageTreeLargeFeature=new MirrageTreeLargeFeature(NoFeatureConfig::deserialize, false);


	public static void registerFeatures(RegistryEvent.Register<Feature<?>> event)
	{
		IForgeRegistry<Feature<?>> registry = event.getRegistry();
		
		pyralTreeFeature = register(registry,"minestuck_alternia:pyral_tree",pyralTreeFeature);
		pyralTreeLargeFeature = register(registry,"minestuck_alternia:pyral_tree_large",pyralTreeLargeFeature);
		mirrageTreeFeature = register(registry,"minestuck_alternia:mirrage_tree",mirrageTreeFeature);
		mirrageTreeLargeFeature = register(registry,"minestuck_alternia:mirrage_tree_large",mirrageTreeLargeFeature);
		
	}

	
	
	private static<FC extends IFeatureConfig> Feature<FC> register(IForgeRegistry<Feature<?>> registry,ResourceLocation key, Feature<FC> featureIn){
		registry.register(featureIn.setRegistryName(key));
		return(featureIn);
	}	
	private static<FC extends IFeatureConfig> Feature<FC> register(IForgeRegistry<Feature<?>> registry,String key, Feature<FC> featureIn){
		return register(registry,new ResourceLocation(key), featureIn);
	}
}
