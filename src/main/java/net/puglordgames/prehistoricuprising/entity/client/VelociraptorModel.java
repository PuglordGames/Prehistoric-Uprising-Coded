package net.puglordgames.prehistoricuprising.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.Entity;

public class VelociraptorModel<T extends Entity> extends HierarchicalModel<T> {
	private final ModelPart Velociraptor;

	public VelociraptorModel(ModelPart root) {
		this.Velociraptor = root.getChild("Velociraptor");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Velociraptor = partdefinition.addOrReplaceChild("Velociraptor", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition Body = Velociraptor.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(21, 25).addBox(-2.0F, -2.0F, -7.0F, 4.0F, 5.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -8.0F, -1.0F));

		PartDefinition Tail = Body.addOrReplaceChild("Tail", CubeListBuilder.create().texOffs(23, 0).addBox(-1.0F, -1.0F, 0.0F, 2.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, 3.0F, 0.0F, 0.0F, 0.0F));

		PartDefinition Tail2 = Tail.addOrReplaceChild("Tail2", CubeListBuilder.create().texOffs(0, 19).addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 13.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-2.0F, 0.0F, 1.0F, 4.0F, 4.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 5.0F, 0.0F, 0.0F, 0.0F));

		PartDefinition Head = Body.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(34, 9).addBox(-1.0F, -4.0F, -6.0F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(33, 0).addBox(-1.5F, -5.0F, -3.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(40, 24).addBox(0.0F, -7.0F, -4.0F, 0.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(17, 19).addBox(-1.5F, -5.2F, -2.0F, 3.0F, 6.0F, 3.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(0.0F, 0.0F, -7.0F, 0.0F, 0.0F, 0.0F));

		PartDefinition Jaw = Head.addOrReplaceChild("Jaw", CubeListBuilder.create().texOffs(0, 10).addBox(-1.5F, 0.0F, -2.0F, 3.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(23, 9).addBox(-1.0F, 0.0F, -5.0F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -3.0F, -1.0F));

		PartDefinition LeftArm = Body.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(0, 19).addBox(0.0F, -1.0F, -1.0F, 1.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(1.975F, 1.0F, -5.0F));

		PartDefinition RightArm = Body.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -1.0F, -1.0F, 1.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.975F, 1.0F, -5.0F));

		PartDefinition LeftLeg = Velociraptor.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(0, 35).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, -7.0F, -1.0F, 0.0F, 0.0F, 0.0F));

		PartDefinition LowerLeftLeg = LeftLeg.addOrReplaceChild("LowerLeftLeg", CubeListBuilder.create().texOffs(11, 5).addBox(-1.0F, 0.0F, 0.0F, 1.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 3.0F, 2.0F));

		PartDefinition LeftFoot = LowerLeftLeg.addOrReplaceChild("LeftFoot", CubeListBuilder.create().texOffs(29, 19).addBox(-1.0F, -2.0F, -2.0F, 0.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(11, 38).addBox(-1.0F, 0.0F, -3.0F, 2.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 4.0F, 0.0F));

		PartDefinition RightLeg = Velociraptor.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(34, 16).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, -7.0F, -1.0F, 0.0F, 0.0F, 0.0F));

		PartDefinition LowerRightLeg = RightLeg.addOrReplaceChild("LowerRightLeg", CubeListBuilder.create().texOffs(11, 0).addBox(0.0F, 0.0F, 0.0F, 1.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 3.0F, 2.0F));

		PartDefinition RightFoot = LowerRightLeg.addOrReplaceChild("RightFoot", CubeListBuilder.create().texOffs(23, 0).addBox(1.0F, -2.0F, -2.0F, 0.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(38, 5).addBox(-1.0F, 0.0F, -3.0F, 2.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 4.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Velociraptor.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart root() {
		return Velociraptor;
	}
}