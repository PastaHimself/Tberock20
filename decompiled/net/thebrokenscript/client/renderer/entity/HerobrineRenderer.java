/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.vertex.PoseStack
 *  com.mojang.blaze3d.vertex.VertexConsumer
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.client.model.HumanoidModel
 *  net.minecraft.client.model.geom.ModelLayers
 *  net.minecraft.client.renderer.MultiBufferSource
 *  net.minecraft.client.renderer.RenderType
 *  net.minecraft.client.renderer.entity.EntityRendererProvider$Context
 *  net.minecraft.client.renderer.entity.HumanoidMobRenderer
 *  net.minecraft.client.renderer.entity.RenderLayerParent
 *  net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer
 *  net.minecraft.client.renderer.entity.layers.RenderLayer
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.world.entity.LivingEntity
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.client.renderer.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.thebrokenscript.api.TBSConstants;
import net.thebrokenscript.entity.HerobrineEntity;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00030\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0002H\u0016\u00a8\u0006\u000b"}, d2={"Lnet/thebrokenscript/client/renderer/entity/HerobrineRenderer;", "Lnet/minecraft/client/renderer/entity/HumanoidMobRenderer;", "Lnet/thebrokenscript/entity/HerobrineEntity;", "Lnet/minecraft/client/model/HumanoidModel;", "context", "Lnet/minecraft/client/renderer/entity/EntityRendererProvider$Context;", "<init>", "(Lnet/minecraft/client/renderer/entity/EntityRendererProvider$Context;)V", "getTextureLocation", "Lnet/minecraft/resources/ResourceLocation;", "entity", "thebrokenscript-common"})
public final class HerobrineRenderer
extends HumanoidMobRenderer<HerobrineEntity, HumanoidModel<HerobrineEntity>> {
    public HerobrineRenderer(@NotNull EntityRendererProvider.Context context) {
        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
        super(context, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER)), 0.5f);
        this.addLayer((RenderLayer)new HumanoidArmorLayer((RenderLayerParent)this, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_INNER_ARMOR)), new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_OUTER_ARMOR)), context.getModelManager()));
        this.addLayer((RenderLayer)new RenderLayer<HerobrineEntity, HumanoidModel<HerobrineEntity>>(this){
            private ResourceLocation LAYER_TEXTURE = TBSConstants.id("textures/entities/herobrineeyes.png");

            public final ResourceLocation getLAYER_TEXTURE() {
                return this.LAYER_TEXTURE;
            }

            public final void setLAYER_TEXTURE(ResourceLocation resourceLocation) {
                Intrinsics.checkNotNullParameter((Object)resourceLocation, (String)"<set-?>");
                this.LAYER_TEXTURE = resourceLocation;
            }

            public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, HerobrineEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
                Intrinsics.checkNotNullParameter((Object)poseStack, (String)"poseStack");
                Intrinsics.checkNotNullParameter((Object)bufferSource, (String)"bufferSource");
                Intrinsics.checkNotNullParameter((Object)((Object)entity), (String)"entity");
                VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.eyes((ResourceLocation)this.LAYER_TEXTURE));
                ((HumanoidModel)this.getParentModel()).renderToBuffer(poseStack, vertexConsumer, light, HumanoidMobRenderer.getOverlayCoords((LivingEntity)((LivingEntity)entity), (float)0.0f), 0xFFFFFF);
            }
        });
    }

    @NotNull
    public ResourceLocation getTextureLocation(@NotNull HerobrineEntity entity) {
        Intrinsics.checkNotNullParameter((Object)((Object)entity), (String)"entity");
        return TBSConstants.id("textures/entities/98cf58d9c891cb7a.png");
    }
}

