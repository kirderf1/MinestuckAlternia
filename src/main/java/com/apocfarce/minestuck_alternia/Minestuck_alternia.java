package com.apocfarce.minestuck_alternia;


import com.apocfarce.minestuck_alternia.Item.AlterniaItems;
import com.apocfarce.minestuck_alternia.block.AlterniaBlocks;
import com.apocfarce.minestuck_alternia.data.AlterniaData;
import com.apocfarce.minestuck_alternia.world.DimensionsHandeler;
import com.apocfarce.minestuck_alternia.world.biome.AlterniaBiomes;
import com.apocfarce.minestuck_alternia.world.biome.provider.AlterniaBiomeProvider;
import com.apocfarce.minestuck_alternia.world.biome.provider.AlterniaBiomeProviderTypes;
import com.apocfarce.minestuck_alternia.world.gen.AlterniaChunkGenTypes;
import com.apocfarce.minestuck_alternia.world.gen.feature.AlterniaFeatureHandeler;
import com.apocfarce.minestuck_alternia.world.gen.surfacebuilder.AlterniaSurfaceBuilders;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.Feature;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.ModDimension;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.world.RegisterDimensionsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("minestuck_alternia")
public class Minestuck_alternia {
	public static String MOD_ID = "minestuck_alternia";

    public Minestuck_alternia() {
        IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();
        modBus.addListener(this::setup);
        modBus.addListener(this::SendInterModCom);
        modBus.addListener(this::ReciveInterModCom);
        modBus.addListener(this::doClientStuff);
        modBus.addListener(AlterniaData::gatherData);
        MinecraftForge.EVENT_BUS.register(this);
        
        AlterniaSurfaceBuilders.REGISTER.register(modBus);
        AlterniaChunkGenTypes.REGISTER.register(modBus);
        AlterniaBiomeProviderTypes.REGISTER.register(modBus);
        AlterniaBiomes.REGISTER.register(modBus);
    }
    private void setup(final FMLCommonSetupEvent event) {
        AlterniaBiomeProvider.initBiomeList();
    }
    
    private void doClientStuff(final FMLClientSetupEvent event) {
        ClientProxy.setupBlockRenderLayers();
    }
    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {
    }
    private void SendInterModCom(final InterModEnqueueEvent event){
    }
    private void ReciveInterModCom(final InterModProcessEvent event){

    }
    
    @Mod.EventBusSubscriber(modid = "minestuck_alternia", bus=Mod.EventBusSubscriber.Bus.FORGE)
	public static class ForgeRegistryEvents{
        @SubscribeEvent
    	public static void registerDimensionTypes(final RegisterDimensionsEvent event) {
        	DimensionsHandeler.registerDimensionTypes();
        } 
 
	}


    @Mod.EventBusSubscriber(modid = "minestuck_alternia",bus=Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent) {
            AlterniaBlocks.registerBlocks(blockRegistryEvent);
        } 
        @SubscribeEvent
        public static void onItemRegistry(final RegistryEvent.Register<Item> ItemRegistryEvent) {
            AlterniaItems.registerItems(ItemRegistryEvent); 
        }
        @SubscribeEvent
        public static void onFeatureRegistry(final RegistryEvent.Register<Feature<?>> featureRegistryEvent) {
        	AlterniaFeatureHandeler.registerFeatures(featureRegistryEvent);
        }
        @SubscribeEvent
        public static void onDimensionRegistry(final RegistryEvent.Register<ModDimension> DimensionRegistryEvent) {
            DimensionsHandeler.registerDimensions(DimensionRegistryEvent); 
        }
    }

}
