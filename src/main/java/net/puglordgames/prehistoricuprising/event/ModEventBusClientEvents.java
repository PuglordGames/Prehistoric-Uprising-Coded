package net.puglordgames.prehistoricuprising.event;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.puglordgames.prehistoricuprising.PrehistoricUprising;
import net.minecraftforge.fml.common.Mod;
import net.puglordgames.prehistoricuprising.entity.client.ModModelLayers;
import net.puglordgames.prehistoricuprising.entity.client.VelociraptorModel;

@Mod.EventBusSubscriber(modid = PrehistoricUprising.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModEventBusClientEvents {
    @SubscribeEvent
    public static void regiserLayer(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(ModModelLayers.VELOCIRAPTOR_LAYER, VelociraptorModel::createBodyLayer);
    }

}
