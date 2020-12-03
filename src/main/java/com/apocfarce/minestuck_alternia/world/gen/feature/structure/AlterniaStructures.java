package com.apocfarce.minestuck_alternia.world.gen.feature.structure;


import com.apocfarce.minestuck_alternia.MinestuckAlternia;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.WeightedList;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.StructureFeature;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class AlterniaStructures {
	
	public static final DeferredRegister<Structure<?>> REGISTER = DeferredRegister.create(ForgeRegistries.STRUCTURE_FEATURES, MinestuckAlternia.MOD_ID);
	
	public static final RegistryObject<HiveStructure> HIVE = REGISTER.register("hive", () -> new HiveStructure(HiveStructureConfig.CODEC));
	
	public static StructureFeature<HiveStructureConfig, ? extends Structure<HiveStructureConfig>> LOWBLOOD_HIVE;
	public static StructureFeature<HiveStructureConfig, ? extends Structure<HiveStructureConfig>> MID_LOWBLOOD_HIVE;
	public static StructureFeature<HiveStructureConfig, ? extends Structure<HiveStructureConfig>> PYRAL_MID_HIGHBLOOD_HIVE;
	public static StructureFeature<HiveStructureConfig, ? extends Structure<HiveStructureConfig>> MIXED_MID_HIGHBLOOD_HIVE;
	public static StructureFeature<HiveStructureConfig, ? extends Structure<HiveStructureConfig>> HIGHBLOOD_HIVE;
	
	public static void initFeatures() {
		LOWBLOOD_HIVE = register("lowblood_hive", HIVE.get().withConfiguration(lowbloodConfig()));
		MID_LOWBLOOD_HIVE = register("mid_lowblood_hive", HIVE.get().withConfiguration(midLowbloodConfig()));
		PYRAL_MID_HIGHBLOOD_HIVE = register("pyral_mid_highblood_hive", HIVE.get().withConfiguration(pyralMidHighbloodConfig()));
		MIXED_MID_HIGHBLOOD_HIVE = register("mixed_mid_highblood_hive", HIVE.get().withConfiguration(mixedMidHighbloodConfig()));
		HIGHBLOOD_HIVE = register("highblood_hive", HIVE.get().withConfiguration(highbloodConfig()));
	}
	
	private static HiveStructureConfig lowbloodConfig() {
		WeightedList<HiveType> hives = new WeightedList<>();
		
		hives.func_226313_a_(HiveType.BURGUNDY_AWNING_SMALL, 2);
		hives.func_226313_a_(HiveType.BURGUNDY_SMALL, 3);
		hives.func_226313_a_(HiveType.BURGUNDY_MANSION, 1);
		
		hives.func_226313_a_(HiveType.BRONZE_WOODEN, 3);
		hives.func_226313_a_(HiveType.BRONZE_FARM, 2);
		hives.func_226313_a_(HiveType.BRONZE_WINDMILL, 1);
		
		hives.func_226313_a_(HiveType.GOLD_SYMMETRIC, 3);
		hives.func_226313_a_(HiveType.GOLD_BEACON, 1);
		hives.func_226313_a_(HiveType.GOLD_TOWER, 2);
		
		return new HiveStructureConfig(hives);
	}
	
	private static HiveStructureConfig midLowbloodConfig() {
		WeightedList<HiveType> hives = new WeightedList<>();
		
		hives.func_226313_a_(HiveType.MUTANT_PLUS, 1);
		hives.func_226313_a_(HiveType.MUTANT_LARGE, 3);
		hives.func_226313_a_(HiveType.MUTANT_AWNING_LARGE, 2);
		
		hives.func_226313_a_(HiveType.LIME_DIAGONAL, 3);
		hives.func_226313_a_(HiveType.LIME_ROUND_TOWER, 2);
		hives.func_226313_a_(HiveType.LIME_FARM, 1);
		
		hives.func_226313_a_(HiveType.OLIVE_CAVE, 3);
		hives.func_226313_a_(HiveType.OLIVE_TREE, 2);
		hives.func_226313_a_(HiveType.OLIVE_BASEMENT, 1);
		
		return new HiveStructureConfig(hives);
	}
	
	private static HiveStructureConfig pyralMidHighbloodConfig() {
		WeightedList<HiveType> hives = new WeightedList<>();
		
		hives.func_226313_a_(HiveType.JADE_TOWER, 3);
		hives.func_226313_a_(HiveType.JADE_FOUNTAIN, 2);
		hives.func_226313_a_(HiveType.JADE_TREE, 3);
		
		hives.func_226313_a_(HiveType.TEAL_BALCONY_MANSION, 2);
		hives.func_226313_a_(HiveType.TEAL_TREE_MANSION, 3);
		hives.func_226313_a_(HiveType.TEAL_TOWER, 1);
		
		hives.func_226313_a_(HiveType.CERULEAN_L, 2);
		hives.func_226313_a_(HiveType.CERULEAN_BASEMENT, 1);
		hives.func_226313_a_(HiveType.CERULEAN_CAVE, 1);
		
		return new HiveStructureConfig(hives);
	}
	
	private static HiveStructureConfig mixedMidHighbloodConfig() {
		WeightedList<HiveType> hives = new WeightedList<>();
		
		hives.func_226313_a_(HiveType.JADE_TOWER, 2);
		hives.func_226313_a_(HiveType.JADE_FOUNTAIN, 1);
		hives.func_226313_a_(HiveType.JADE_TREE, 1);
		
		hives.func_226313_a_(HiveType.TEAL_BALCONY_MANSION, 2);
		hives.func_226313_a_(HiveType.TEAL_TREE_MANSION, 1);
		hives.func_226313_a_(HiveType.TEAL_TOWER, 3);
		
		hives.func_226313_a_(HiveType.CERULEAN_L, 2);
		hives.func_226313_a_(HiveType.CERULEAN_BASEMENT, 3);
		hives.func_226313_a_(HiveType.CERULEAN_CAVE, 3);
		
		return new HiveStructureConfig(hives);
	}
	
	private static HiveStructureConfig highbloodConfig() {
		WeightedList<HiveType> hives = new WeightedList<>();
		
		hives.func_226313_a_(HiveType.INDIGO_TOWER_PLUS, 3);
		hives.func_226313_a_(HiveType.INDIGO_TELESCOPE, 1);
		hives.func_226313_a_(HiveType.INDIGO_LARGE_CHIMNEYS, 2);
		
		hives.func_226313_a_(HiveType.PURPLE_BASEMENT, 2);
		hives.func_226313_a_(HiveType.PURPLE_BALCONY, 2);
		hives.func_226313_a_(HiveType.PURPLE_CHURCH, 1);
		hives.func_226313_a_(HiveType.PURPLE_TENT, 1);
		
		return new HiveStructureConfig(hives);
	}
	
	private static <FC extends IFeatureConfig, F extends Structure<FC>> StructureFeature<FC, F> register(String name, StructureFeature<FC, F> structure) {
		return WorldGenRegistries.register(WorldGenRegistries.CONFIGURED_STRUCTURE_FEATURE, new ResourceLocation(MinestuckAlternia.MOD_ID, name), structure);
	}
}