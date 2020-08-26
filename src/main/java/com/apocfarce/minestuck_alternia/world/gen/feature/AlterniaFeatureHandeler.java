package com.apocfarce.minestuck_alternia.world.gen.feature;


import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
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

	public static Feature<NoFeatureConfig> burgundyHiveFeature1 = new AlterniaTemplateFeature(NoFeatureConfig::deserialize,new BlockPos(5,1,6));
	public static Feature<NoFeatureConfig> burgundyHiveFeature2 = new AlterniaTemplateFeature(NoFeatureConfig::deserialize,new BlockPos(3,1,5));
	public static Feature<NoFeatureConfig> burgundyHiveFeature3 = new AlterniaTemplateFeature(NoFeatureConfig::deserialize,new BlockPos(15,1,0));
	
	
	public static Feature<NoFeatureConfig> bronzeHiveFeature = new AlterniaTemplateFeature(NoFeatureConfig::deserialize,new BlockPos(8,5,1));
	public static Feature<NoFeatureConfig> bronzeGreenHouseFeature = new AlterniaTemplateFeature(NoFeatureConfig::deserialize, new BlockPos(8,4,0));
	public static Feature<NoFeatureConfig> bronzeWindmillFeature = new AlterniaTemplateFeature(NoFeatureConfig::deserialize, new BlockPos(1,1,6));
	

	public static void registerFeatures(RegistryEvent.Register<Feature<?>> event)
	{
		IForgeRegistry<Feature<?>> registry = event.getRegistry();
		
		pyralTreeFeature = register(registry,"minestuck_alternia:pyral_tree",pyralTreeFeature);
		pyralTreeLargeFeature = register(registry,"minestuck_alternia:pyral_tree_large",pyralTreeLargeFeature);
		mirrageTreeFeature = register(registry,"minestuck_alternia:mirrage_tree",mirrageTreeFeature);
		mirrageTreeLargeFeature = register(registry,"minestuck_alternia:mirrage_tree_large",mirrageTreeLargeFeature);
		
		
		bronzeHiveFeature = register(registry,"minestuck_alternia:bronze_hive",bronzeHiveFeature);
		bronzeGreenHouseFeature = register(registry,"minestuck_alternia:bronze_green_house",bronzeGreenHouseFeature);
		bronzeWindmillFeature = register(registry,"minestuck_alternia:bronze_windmill",bronzeWindmillFeature);
		
		burgundyHiveFeature1 = register(registry,"minestuck_alternia:burgundy_hive1",burgundyHiveFeature1);
		burgundyHiveFeature2 = register(registry,"minestuck_alternia:burgundy_hive2",burgundyHiveFeature2);
		burgundyHiveFeature3 = register(registry,"minestuck_alternia:burgundy_hive3",burgundyHiveFeature3);
		
	}
	


	

	private static<FC extends IFeatureConfig> Feature<FC> register(IForgeRegistry<Feature<?>> registry,ResourceLocation key, Feature<FC> featureIn){
		registry.register(featureIn.setRegistryName(key));
		return(featureIn);
	}
	private static<FC extends IFeatureConfig> Feature<FC> register(IForgeRegistry<Feature<?>> registry,String key, Feature<FC> featureIn){
		return register(registry,new ResourceLocation(key), featureIn);
	}
}
