package com.apocfarce.minestuck_alternia;

import com.apocfarce.minestuck_alternia.Item.AlterniaItems;
import com.apocfarce.minestuck_alternia.block.AlterniaBlocks;
import com.apocfarce.minestuck_alternia.client.ClientProxy;
import com.apocfarce.minestuck_alternia.command.OccupyHiveCommand;
import com.apocfarce.minestuck_alternia.data.AlterniaData;
import com.apocfarce.minestuck_alternia.network.AlterniaPacketHandler;
import com.apocfarce.minestuck_alternia.util.EventListener;
import com.apocfarce.minestuck_alternia.world.biome.AlterniaBiomes;
import com.apocfarce.minestuck_alternia.world.biome.provider.AlterniaBiomeProvider;
import com.apocfarce.minestuck_alternia.world.biome.provider.AlterniaBiomeProviders;
import com.apocfarce.minestuck_alternia.world.gen.feature.AlterniaFeatures;
import com.apocfarce.minestuck_alternia.world.gen.feature.structure.PieceTypes;
import com.apocfarce.minestuck_alternia.world.gen.surfacebuilder.AlterniaSurfaceBuilders;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.world.gen.feature.Feature;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
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
        
        AlterniaSurfaceBuilders.REGISTER.register(modBus);
    }
    
    private void setup(final FMLCommonSetupEvent event) {
        event.enqueueWork(PieceTypes::register);
        event.enqueueWork(AlterniaBiomes::initBiomeTypes);
        event.enqueueWork(AlterniaBiomeProvider::initBiomeList);
        event.enqueueWork(AlterniaBiomeProviders::init);
        AlterniaPacketHandler.registerPackets();
    }
    
    private void doClientStuff(final FMLClientSetupEvent event) {
        ClientProxy.setup();
    }
    
    @SubscribeEvent
    public void onRegisterCommands(RegisterCommandsEvent event) {
        OccupyHiveCommand.register(event.getDispatcher());
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
        public static void onFeatureRegistry(final RegistryEvent.Register<Feature<?>> event) {
            AlterniaFeatures.registerFeatures(event.getRegistry());
        }
    }

}
