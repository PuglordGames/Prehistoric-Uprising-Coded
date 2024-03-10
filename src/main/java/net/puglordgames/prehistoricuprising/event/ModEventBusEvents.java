package net.puglordgames.prehistoricuprising.event;

import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.puglordgames.prehistoricuprising.PrehistoricUprising;
import net.puglordgames.prehistoricuprising.entity.ModEntities;
import net.puglordgames.prehistoricuprising.entity.custom.VelociraptorEntity;

@Mod.EventBusSubscriber(modid = PrehistoricUprising.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void  registerAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntities.VELOCIRAPTOR.get(), VelociraptorEntity.createAttributes().build());
    }
}
