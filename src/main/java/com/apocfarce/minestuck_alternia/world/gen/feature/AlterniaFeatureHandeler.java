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
	
	public static Feature<NoFeatureConfig> bronzeHiveFeature1 = new AlterniaTemplateFeature(NoFeatureConfig::deserialize,new BlockPos(8,5,1));
	public static Feature<NoFeatureConfig> bronzeHiveFeature2 = new AlterniaTemplateFeature(NoFeatureConfig::deserialize, new BlockPos(8,4,0));
	public static Feature<NoFeatureConfig> bronzeHiveFeature3 = new AlterniaTemplateFeature(NoFeatureConfig::deserialize, new BlockPos(1,1,6));
	
	public static Feature<NoFeatureConfig> goldHiveFeature1 = new AlterniaTemplateFeature(NoFeatureConfig::deserialize,new BlockPos(15,0,0));
	public static Feature<NoFeatureConfig> goldHiveFeature2 = new AlterniaTemplateFeature(NoFeatureConfig::deserialize, new BlockPos(7,1,9));
	public static Feature<NoFeatureConfig> goldHiveFeature3 = new AlterniaTemplateFeature(NoFeatureConfig::deserialize, new BlockPos(0,1,11));

	public static Feature<NoFeatureConfig> mutantHiveFeature1 = new AlterniaTemplateFeature(NoFeatureConfig::deserialize,new BlockPos(1,4,8));
	public static Feature<NoFeatureConfig> mutantHiveFeature2 = new AlterniaTemplateFeature(NoFeatureConfig::deserialize, new BlockPos(14,0,0));
	public static Feature<NoFeatureConfig> mutantHiveFeature3 = new AlterniaTemplateFeature(NoFeatureConfig::deserialize, new BlockPos(0,0,6));

	public static Feature<NoFeatureConfig> limeHiveFeature1 = new AlterniaTemplateFeature(NoFeatureConfig::deserialize,new BlockPos(9,1,0));
	public static Feature<NoFeatureConfig> limeHiveFeature2 = new AlterniaTemplateFeature(NoFeatureConfig::deserialize, new BlockPos(0,1,15));
	public static Feature<NoFeatureConfig> limeHiveFeature3 = new AlterniaTemplateFeature(NoFeatureConfig::deserialize, new BlockPos(0,0,15));

	public static Feature<NoFeatureConfig> oliveHiveFeature1 = new AlterniaTemplateFeature(NoFeatureConfig::deserialize,new BlockPos(4,1,13));
	public static Feature<NoFeatureConfig> oliveHiveFeature2 = new AlterniaTemplateFeature(NoFeatureConfig::deserialize, new BlockPos(13,1,6));
	public static Feature<NoFeatureConfig> oliveHiveFeature3 = new AlterniaTemplateFeature(NoFeatureConfig::deserialize, new BlockPos(11,19,5));

	public static Feature<NoFeatureConfig> jadeHiveFeature1 = new AlterniaTemplateFeature(NoFeatureConfig::deserialize,new BlockPos(10,1,31));
	public static Feature<NoFeatureConfig> jadeHiveFeature2 = new AlterniaTemplateFeature(NoFeatureConfig::deserialize, new BlockPos(14,1,0));
	public static Feature<NoFeatureConfig> jadeHiveFeature3 = new AlterniaTemplateFeature(NoFeatureConfig::deserialize, new BlockPos(3,1,5));

	public static Feature<NoFeatureConfig> tealHiveFeature1 = new AlterniaTemplateFeature(NoFeatureConfig::deserialize,new BlockPos(0,1,15));
	public static Feature<NoFeatureConfig> tealHiveFeature2 = new AlterniaTemplateFeature(NoFeatureConfig::deserialize, new BlockPos(1,1,15));
	public static Feature<NoFeatureConfig> tealHiveFeature3 = new AlterniaTemplateFeature(NoFeatureConfig::deserialize, new BlockPos(15,1,0));

	public static Feature<NoFeatureConfig> ceruleanHiveFeature1 = new AlterniaTemplateFeature(NoFeatureConfig::deserialize,new BlockPos(4,0,10));
	public static Feature<NoFeatureConfig> ceruleanHiveFeature2 = new AlterniaTemplateFeature(NoFeatureConfig::deserialize, new BlockPos(21,10,15));
	public static Feature<NoFeatureConfig> ceruleanHiveFeature3 = new AlterniaTemplateFeature(NoFeatureConfig::deserialize, new BlockPos(20,21,15));

	public static Feature<NoFeatureConfig> indigoHiveFeature1 = new AlterniaTemplateFeature(NoFeatureConfig::deserialize,new BlockPos(3,1,0));
	public static Feature<NoFeatureConfig> indigoHiveFeature2 = new AlterniaTemplateFeature(NoFeatureConfig::deserialize, new BlockPos(1,1,15));
	public static Feature<NoFeatureConfig> indigoHiveFeature3 = new AlterniaTemplateFeature(NoFeatureConfig::deserialize, new BlockPos(0,1,15));
	
	public static Feature<NoFeatureConfig> purpleHiveFeature1 = new AlterniaTemplateFeature(NoFeatureConfig::deserialize,new BlockPos(15,11,13));
	public static Feature<NoFeatureConfig> purpleHiveFeature2 = new AlterniaTemplateFeature(NoFeatureConfig::deserialize, new BlockPos(1,0,1));
	public static Feature<NoFeatureConfig> purpleHiveFeature3 = new AlterniaTemplateFeature(NoFeatureConfig::deserialize, new BlockPos(15,0,0));
	
	
	public static void registerFeatures(RegistryEvent.Register<Feature<?>> event)
	{
		IForgeRegistry<Feature<?>> registry = event.getRegistry();
		
		pyralTreeFeature = register(registry,"minestuck_alternia:pyral_tree",pyralTreeFeature);
		pyralTreeLargeFeature = register(registry,"minestuck_alternia:pyral_tree_large",pyralTreeLargeFeature);
		mirrageTreeFeature = register(registry,"minestuck_alternia:mirrage_tree",mirrageTreeFeature);
		mirrageTreeLargeFeature = register(registry,"minestuck_alternia:mirrage_tree_large",mirrageTreeLargeFeature);
		
		
		
		burgundyHiveFeature1 = register(registry,"minestuck_alternia:burgundy_hive1",burgundyHiveFeature1);
		burgundyHiveFeature2 = register(registry,"minestuck_alternia:burgundy_hive2",burgundyHiveFeature2);
		burgundyHiveFeature3 = register(registry,"minestuck_alternia:burgundy_hive3",burgundyHiveFeature3);

		bronzeHiveFeature1 = register(registry,"minestuck_alternia:bronze_hive1",bronzeHiveFeature1);
		bronzeHiveFeature2 = register(registry,"minestuck_alternia:bronze_hive2",bronzeHiveFeature2);
		bronzeHiveFeature3 = register(registry,"minestuck_alternia:bronze_hive3",bronzeHiveFeature3);
		
		goldHiveFeature1 = register(registry,"minestuck_alternia:gold_hive1",goldHiveFeature1);
		goldHiveFeature2 = register(registry,"minestuck_alternia:gold_hive2",goldHiveFeature2);
		goldHiveFeature3 = register(registry,"minestuck_alternia:gold_hive3",goldHiveFeature3);

		
		
		mutantHiveFeature1 = register(registry,"minestuck_alternia:mutant_hive1",mutantHiveFeature1);
		mutantHiveFeature2 = register(registry,"minestuck_alternia:mutant_hive2",mutantHiveFeature2);
		mutantHiveFeature3 = register(registry,"minestuck_alternia:mutant_hive3",mutantHiveFeature3);

		limeHiveFeature1 = register(registry,"minestuck_alternia:lime_hive1",limeHiveFeature1);
		limeHiveFeature2 = register(registry,"minestuck_alternia:lime_hive2",limeHiveFeature2);
		limeHiveFeature3 = register(registry,"minestuck_alternia:lime_hive3",limeHiveFeature3);

		oliveHiveFeature1 = register(registry,"minestuck_alternia:olive_hive1",oliveHiveFeature1);
		oliveHiveFeature2 = register(registry,"minestuck_alternia:olive_hive2",oliveHiveFeature2);
		oliveHiveFeature3 = register(registry,"minestuck_alternia:olive_hive3",oliveHiveFeature3);

		jadeHiveFeature1 = register(registry,"minestuck_alternia:jade_hive1",jadeHiveFeature1);
		jadeHiveFeature2 = register(registry,"minestuck_alternia:jade_hive2",jadeHiveFeature2);
		jadeHiveFeature3 = register(registry,"minestuck_alternia:jade_hive3",jadeHiveFeature3);

		tealHiveFeature1 = register(registry,"minestuck_alternia:teal_hive1",tealHiveFeature1);
		tealHiveFeature2 = register(registry,"minestuck_alternia:teal_hive2",tealHiveFeature2);
		tealHiveFeature3 = register(registry,"minestuck_alternia:teal_hive3",tealHiveFeature3);

		ceruleanHiveFeature1 = register(registry,"minestuck_alternia:cerulean_hive1",ceruleanHiveFeature1);
		ceruleanHiveFeature2 = register(registry,"minestuck_alternia:cerulean_hive2",ceruleanHiveFeature2);
		ceruleanHiveFeature3 = register(registry,"minestuck_alternia:cerulean_hive3",ceruleanHiveFeature3);

		indigoHiveFeature1 = register(registry,"minestuck_alternia:indigo_hive1",indigoHiveFeature1);
		indigoHiveFeature2 = register(registry,"minestuck_alternia:indigo_hive2",indigoHiveFeature2);
		indigoHiveFeature3 = register(registry,"minestuck_alternia:indigo_hive3",indigoHiveFeature3);

		purpleHiveFeature1 = register(registry,"minestuck_alternia:purple_hive1",purpleHiveFeature1);
		purpleHiveFeature2 = register(registry,"minestuck_alternia:purple_hive2",purpleHiveFeature2);
		purpleHiveFeature3 = register(registry,"minestuck_alternia:purple_hive3",purpleHiveFeature3);


	}
	


	

	private static<FC extends IFeatureConfig> Feature<FC> register(IForgeRegistry<Feature<?>> registry,ResourceLocation key, Feature<FC> featureIn){
		registry.register(featureIn.setRegistryName(key));
		return(featureIn);
	}
	private static<FC extends IFeatureConfig> Feature<FC> register(IForgeRegistry<Feature<?>> registry,String key, Feature<FC> featureIn){
		return register(registry,new ResourceLocation(key), featureIn);
	}
}
