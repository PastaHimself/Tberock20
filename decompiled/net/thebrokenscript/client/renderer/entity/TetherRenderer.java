/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.vertex.PoseStack
 *  com.mojang.blaze3d.vertex.VertexConsumer
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.client.renderer.MultiBufferSource
 *  net.minecraft.client.renderer.RenderType
 *  net.minecraft.client.renderer.entity.EntityRendererProvider$Context
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.world.entity.Entity
 *  net.thebrokenscript.brokencore.api.util.Side
 *  net.thebrokenscript.brokencore.api.util.SideOnly
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  software.bernie.geckolib.animatable.GeoAnimatable
 *  software.bernie.geckolib.cache.object.BakedGeoModel
 *  software.bernie.geckolib.model.GeoModel
 *  software.bernie.geckolib.renderer.GeoEntityRenderer
 *  software.bernie.geckolib.renderer.GeoRenderer
 */
package net.thebrokenscript.client.renderer.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.thebrokenscript.brokencore.api.util.Side;
import net.thebrokenscript.brokencore.api.util.SideOnly;
import net.thebrokenscript.client.model.entity.TetherModel;
import net.thebrokenscript.entity.boss.TetherEntity;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;
import software.bernie.geckolib.renderer.GeoRenderer;

@SideOnly(side=Side.CLIENT)
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0002H\u0016J,\u0010\n\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\b2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0002H\u0014Jf\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\t\u001a\u00020\u00022\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u001eH\u0016\u00a8\u0006!"}, d2={"Lnet/thebrokenscript/client/renderer/entity/TetherRenderer;", "Lsoftware/bernie/geckolib/renderer/GeoEntityRenderer;", "Lnet/thebrokenscript/entity/boss/TetherEntity;", "renderManager", "Lnet/minecraft/client/renderer/entity/EntityRendererProvider$Context;", "<init>", "(Lnet/minecraft/client/renderer/entity/EntityRendererProvider$Context;)V", "getTextureLocation", "Lnet/minecraft/resources/ResourceLocation;", "animatable", "getRenderType", "Lnet/minecraft/client/renderer/RenderType;", "texture", "bufferSource", "Lnet/minecraft/client/renderer/MultiBufferSource;", "partialTick", "", "getDeathMaxRotation", "actuallyRender", "", "poseStack", "Lcom/mojang/blaze3d/vertex/PoseStack;", "model", "Lsoftware/bernie/geckolib/cache/object/BakedGeoModel;", "renderType", "buffer", "Lcom/mojang/blaze3d/vertex/VertexConsumer;", "isReRender", "", "packedLight", "", "packedOverlay", "colour", "thebrokenscript-common"})
public final class TetherRenderer
extends GeoEntityRenderer<TetherEntity> {
    public TetherRenderer(@NotNull EntityRendererProvider.Context renderManager) {
        Intrinsics.checkNotNullParameter((Object)renderManager, (String)"renderManager");
        super(renderManager, (GeoModel)new TetherModel());
    }

    @NotNull
    public ResourceLocation getTextureLocation(@NotNull TetherEntity animatable) {
        Intrinsics.checkNotNullParameter((Object)((Object)animatable), (String)"animatable");
        ResourceLocation resourceLocation = this.model.getTextureResource((GeoAnimatable)animatable, (GeoRenderer)this);
        Intrinsics.checkNotNullExpressionValue((Object)resourceLocation, (String)"getTextureResource(...)");
        return resourceLocation;
    }

    @NotNull
    public RenderType getRenderType(@NotNull TetherEntity animatable, @Nullable ResourceLocation texture, @Nullable MultiBufferSource bufferSource, float partialTick) {
        Intrinsics.checkNotNullParameter((Object)((Object)animatable), (String)"animatable");
        RenderType renderType = RenderType.entityTranslucent((ResourceLocation)this.getTextureLocation(animatable));
        Intrinsics.checkNotNullExpressionValue((Object)renderType, (String)"entityTranslucent(...)");
        return renderType;
    }

    protected float getDeathMaxRotation(@NotNull TetherEntity animatable) {
        Intrinsics.checkNotNullParameter((Object)((Object)animatable), (String)"animatable");
        return 0.0f;
    }

    public void actuallyRender(@NotNull PoseStack poseStack, @NotNull TetherEntity animatable, @Nullable BakedGeoModel model2, @Nullable RenderType renderType, @NotNull MultiBufferSource bufferSource, @Nullable VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, int colour) {
        Intrinsics.checkNotNullParameter((Object)poseStack, (String)"poseStack");
        Intrinsics.checkNotNullParameter((Object)((Object)animatable), (String)"animatable");
        Intrinsics.checkNotNullParameter((Object)bufferSource, (String)"bufferSource");
        super.actuallyRender(poseStack, (Entity)animatable, model2, renderType, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, colour);
        ResourceLocation baseTexture = this.getTextureLocation(animatable);
        poseStack.pushPose();
        VertexConsumer baseBuffer = bufferSource.getBuffer(RenderType.entityTranslucent((ResourceLocation)baseTexture));
        super.actuallyRender(poseStack, (Entity)animatable, model2, RenderType.entityTranslucentCull((ResourceLocation)baseTexture), bufferSource, baseBuffer, isReRender, partialTick, packedLight, packedOverlay, colour);
        poseStack.popPose();
        poseStack.pushPose();
        VertexConsumer glowBuffer = bufferSource.getBuffer(RenderType.eyes((ResourceLocation)baseTexture));
        super.actuallyRender(poseStack, (Entity)animatable, model2, RenderType.eyes((ResourceLocation)baseTexture), bufferSource, glowBuffer, isReRender, partialTick, 0xF000F0, packedOverlay, colour);
        poseStack.popPose();
    }
}

