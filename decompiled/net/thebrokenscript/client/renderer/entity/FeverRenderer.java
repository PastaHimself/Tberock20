/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.vertex.PoseStack
 *  com.mojang.blaze3d.vertex.VertexConsumer
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.player.LocalPlayer
 *  net.minecraft.client.renderer.MultiBufferSource
 *  net.minecraft.client.renderer.RenderType
 *  net.minecraft.client.renderer.entity.EntityRendererProvider$Context
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.world.entity.Entity
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  software.bernie.geckolib.cache.object.BakedGeoModel
 *  software.bernie.geckolib.model.GeoModel
 *  software.bernie.geckolib.renderer.GeoEntityRenderer
 */
package net.thebrokenscript.client.renderer.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import java.util.Optional;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.thebrokenscript.api.entity.BaseFeverEntity;
import net.thebrokenscript.client.model.entity.FeverModel;
import net.thebrokenscript.entity.fever.FeverStalkEntity;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0005\u0010\u0006J,\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016Jd\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001cH\u0016\u00a8\u0006\u001f"}, d2={"Lnet/thebrokenscript/client/renderer/entity/FeverRenderer;", "Lsoftware/bernie/geckolib/renderer/GeoEntityRenderer;", "Lnet/thebrokenscript/api/entity/BaseFeverEntity;", "renderManager", "Lnet/minecraft/client/renderer/entity/EntityRendererProvider$Context;", "<init>", "(Lnet/minecraft/client/renderer/entity/EntityRendererProvider$Context;)V", "getRenderType", "Lnet/minecraft/client/renderer/RenderType;", "entity", "texture", "Lnet/minecraft/resources/ResourceLocation;", "bufferSource", "Lnet/minecraft/client/renderer/MultiBufferSource;", "partialTick", "", "actuallyRender", "", "poseStack", "Lcom/mojang/blaze3d/vertex/PoseStack;", "model", "Lsoftware/bernie/geckolib/cache/object/BakedGeoModel;", "renderType", "buffer", "Lcom/mojang/blaze3d/vertex/VertexConsumer;", "isReRender", "", "packedLight", "", "packedOverlay", "colour", "thebrokenscript-common"})
public final class FeverRenderer
extends GeoEntityRenderer<BaseFeverEntity> {
    public FeverRenderer(@NotNull EntityRendererProvider.Context renderManager) {
        Intrinsics.checkNotNullParameter((Object)renderManager, (String)"renderManager");
        super(renderManager, (GeoModel)new FeverModel());
        this.shadowRadius = 0.5f;
    }

    @Nullable
    public RenderType getRenderType(@NotNull BaseFeverEntity entity, @NotNull ResourceLocation texture, @Nullable MultiBufferSource bufferSource, float partialTick) {
        Intrinsics.checkNotNullParameter((Object)((Object)entity), (String)"entity");
        Intrinsics.checkNotNullParameter((Object)texture, (String)"texture");
        return RenderType.entityTranslucent((ResourceLocation)this.getTextureLocation((Entity)entity));
    }

    public void actuallyRender(@NotNull PoseStack poseStack, @NotNull BaseFeverEntity entity, @NotNull BakedGeoModel model2, @Nullable RenderType renderType, @NotNull MultiBufferSource bufferSource, @Nullable VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, int colour) {
        Intrinsics.checkNotNullParameter((Object)poseStack, (String)"poseStack");
        Intrinsics.checkNotNullParameter((Object)((Object)entity), (String)"entity");
        Intrinsics.checkNotNullParameter((Object)model2, (String)"model");
        Intrinsics.checkNotNullParameter((Object)bufferSource, (String)"bufferSource");
        if (entity.isInvisible()) {
            return;
        }
        if (entity instanceof FeverStalkEntity) {
            Minecraft mc = Minecraft.getInstance();
            LocalPlayer localPlayer = mc.player;
            if (localPlayer == null || !Intrinsics.areEqual(((Optional)((FeverStalkEntity)entity).getEntityData().get(FeverStalkEntity.Companion.getTARGET_UUID())).orElse(null), (Object)localPlayer.getUUID())) {
                return;
            }
        }
        ResourceLocation baseTexture = this.getTextureLocation((Entity)entity);
        poseStack.pushPose();
        VertexConsumer baseBuffer = bufferSource.getBuffer(RenderType.entityTranslucent((ResourceLocation)baseTexture));
        super.actuallyRender(poseStack, (Entity)entity, model2, RenderType.entityTranslucentCull((ResourceLocation)baseTexture), bufferSource, baseBuffer, isReRender, partialTick, packedLight, packedOverlay, colour);
        poseStack.popPose();
        poseStack.pushPose();
        VertexConsumer glowBuffer = bufferSource.getBuffer(RenderType.eyes((ResourceLocation)baseTexture));
        super.actuallyRender(poseStack, (Entity)entity, model2, RenderType.eyes((ResourceLocation)baseTexture), bufferSource, glowBuffer, isReRender, partialTick, 0xF000F0, packedOverlay, colour);
        poseStack.popPose();
    }
}

