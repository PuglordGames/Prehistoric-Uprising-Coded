package net.puglordgames.prehistoricuprising.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.puglordgames.prehistoricuprising.PrehistoricUprising;
import net.puglordgames.prehistoricuprising.entity.custom.VelociraptorEntity;

public class VelociraptorRenderer  extends MobRenderer<VelociraptorEntity, VelociraptorModel<VelociraptorEntity>> {
    public VelociraptorRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new VelociraptorModel<>(pContext.bakeLayer(ModModelLayers.VELOCIRAPTOR_LAYER)), 2f);
    }

    @Override
    public ResourceLocation getTextureLocation(VelociraptorEntity velociraptorEntity) {
        return new ResourceLocation(PrehistoricUprising.MOD_ID, "textures/entity/velociraptor.png");
    }

    @Override
    public void render(VelociraptorEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack,
                       MultiBufferSource pBuffer, int pPackedLight) {
        if (pEntity.isBaby()) {
            pMatrixStack.scale(0.5f,0.5f,0.5f);
        }


        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }
}
