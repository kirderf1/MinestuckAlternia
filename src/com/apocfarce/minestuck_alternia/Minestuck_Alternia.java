package com.apocfarce.minestuck_alternia;
import com.apocfarce.minestuck_alternia.proxy.ClientProxy;
import com.apocfarce.minestuck_alternia.proxy.CommonProxy;

import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Minestuck_Alternia.modId, name = Minestuck_Alternia.name, version = Minestuck_Alternia.version, acceptedMinecraftVersions = "[1.12.2]")
public class Minestuck_Alternia {

	public static final String modId = "minestuck_alternia";
	public static final String name = "Minestuck Alternia";
	public static final String version = "1.12.2";

	@Mod.Instance(modId)
	public static Minestuck_Alternia instance;

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		proxy.preInit();
	}

	@Mod.EventHandler
	public void init(FMLInitializationEvent event) {
		proxy.init();
		if(event.getSide().isClient())
		{
			ClientProxy.registerRenderers();
		}
	}
	

	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		if(Loader.isModLoaded("minestuck")) {
			System.out.println("minestuck detected");
//			minestuck support(event);
		}
			
		proxy.postInit();
	}
	@SidedProxy(serverSide = "com.apocfarce.minestuck_alternia.proxy.ServerProxy", clientSide = "com.apocfarce.minestuck_alternia.proxy.ClientProxy")
	public static CommonProxy proxy;

}