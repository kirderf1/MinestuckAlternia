package com.apocfarce.minestuck_alternia;

import com.apocfarce.minestuck_alternia.Item.AlterniaItems;
import com.apocfarce.minestuck_alternia.block.AlterniaBlocks;
import com.apocfarce.minestuck_alternia.client.ClientProxy;
import com.apocfarce.minestuck_alternia.command.OccupyHiveCommand;
import com.apocfarce.minestuck_alternia.data.AlterniaData;
import com.apocfarce.minestuck_alternia.network.AlterniaPacketHandler;
import com.apocfarce.minestuck_alternia.util.EventListener;
import com.apocfarce.minestuck_alternia.world.AlterniaDimensions;
import com.apocfarce.minestuck_alternia.world.biome.AlterniaBiomes;
import com.apocfarce.minestuck_alternia.world.biome.provider.AlterniaBiomeProvider;
import com.apocfarce.minestuck_alternia.world.biome.provider.AlterniaBiomeProviderTypes;
import com.apocfarce.minestuck_alternia.world.gen.AlterniaChunkGenTypes;
import com.apocfarce.minestuck_alternia.world.gen.feature.AlterniaFeatures;
import com.apocfarce.minestuck_alternia.world.gen.feature.structure.PieceTypes;
import com.apocfarce.minestuck_alternia.world.gen.surfacebuilder.AlterniaSurfaceBuilders;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.world.RegisterDimensionsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(MinestuckAlternia.MOD_ID)
public class MinestuckAlternia {
	public static final String MOD_ID = "minestuck_alternia";

    public MinestuckAlternia() {
        IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();
        modBus.addListener(this::setup);
        modBus.addListener(this::doClientStuff);
        modBus.addListener(AlterniaData::gatherData);
        MinecraftForge.EVENT_BUS.register(this);
        MinecraftForge.EVENT_BUS.register(EventListener.class);
        
        AlterniaDimensions.REGISTER.register(modBus);
        AlterniaSurfaceBuilders.REGISTER.register(modBus);
        AlterniaChunkGenTypes.REGISTER.register(modBus);
        AlterniaBiomeProviderTypes.REGISTER.register(modBus);
        AlterniaBiomes.REGISTER.register(modBus);
        AlterniaFeatures.REGISTER.register(modBus);
    }
    
    @SuppressWarnings("deprecation")    //The deferred work queue does not have a replacement yet. It'll come in 1.16
    private void setup(final FMLCommonSetupEvent event) {
        AlterniaBiomes.initBiomeFeatures();
        DeferredWorkQueue.runLater(PieceTypes::register);
        DeferredWorkQueue.runLater(AlterniaBiomeProvider::initBiomeList);
        AlterniaPacketHandler.registerPackets();
    }
    
    private void doClientStuff(final FMLClientSetupEvent event) {
        ClientProxy.setup();
    }
    
    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {
        OccupyHiveCommand.register(event.getCommandDispatcher());
    }
    
    @Mod.EventBusSubscriber(modid = "minestuck_alternia", bus=Mod.EventBusSubscriber.Bus.FORGE)
	public static class ForgeRegistryEvents {
        @SubscribeEvent
    	public static void registerDimensionTypes(final RegisterDimensionsEvent event) {
        	AlterniaDimensions.registerDimensionTypes();
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
    }

}
