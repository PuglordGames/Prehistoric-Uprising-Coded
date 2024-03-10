package net.puglordgames.prehistoricuprising;

import com.mojang.logging.LogUtils;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.puglordgames.prehistoricuprising.entity.ModEntities;
import net.puglordgames.prehistoricuprising.entity.client.VelociraptorRenderer;
import net.puglordgames.prehistoricuprising.item.ModItems;
import net.puglordgames.prehistoricuprising.item.ModeCreativeModTabs;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(PrehistoricUprising.MOD_ID)
public class PrehistoricUprising {
    public static final String MOD_ID = "prehistoricuprising";
    public static final Logger LOGGER = LogUtils.getLogger();

    public PrehistoricUprising() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModeCreativeModTabs.register(modEventBus);

        ModItems.register(modEventBus);

        modEventBus.addListener(this::commonSetup);

        ModEntities.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if(event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.accept(ModItems.TESTITEM);
        }
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            EntityRenderers.register(ModEntities.VELOCIRAPTOR.get(), VelociraptorRenderer::new);
        }
    }
}
