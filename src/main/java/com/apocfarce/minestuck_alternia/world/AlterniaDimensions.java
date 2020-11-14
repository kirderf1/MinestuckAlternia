package com.apocfarce.minestuck_alternia.world;

import com.apocfarce.minestuck_alternia.Minestuck_alternia;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.dimension.DimensionType;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.ModDimension;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class AlterniaDimensions {
	public static final DeferredRegister<ModDimension> REGISTER = DeferredRegister.create(ForgeRegistries.MOD_DIMENSIONS, Minestuck_alternia.MOD_ID);
	
	public static final RegistryObject<ModDimension> ALTERNIA = REGISTER.register("alternia", AlterniaDimension.Type::new);
	
	private static DimensionType alterniaType;
	private static final ResourceLocation dimensionID = new ResourceLocation(Minestuck_alternia.MOD_ID,"alternia");
	
	public static void registerDimensionTypes() {
		alterniaType = DimensionManager.registerOrGetDimension(dimensionID, ALTERNIA.get(), null, true);
	}
	
	public static DimensionType getDimensionType() {
		return alterniaType;
	}
}
