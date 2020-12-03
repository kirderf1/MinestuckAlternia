package com.apocfarce.minestuck_alternia.world.gen.feature.structure;


import com.apocfarce.minestuck_alternia.MinestuckAlternia;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class AlterniaStructures {
	
	public static final DeferredRegister<Structure<?>> REGISTER = DeferredRegister.create(ForgeRegistries.STRUCTURE_FEATURES, MinestuckAlternia.MOD_ID);
	
	public static RegistryObject<HiveStructure> HIVE = REGISTER.register("hive", () -> new HiveStructure(HiveStructureConfig.CODEC));
	
}