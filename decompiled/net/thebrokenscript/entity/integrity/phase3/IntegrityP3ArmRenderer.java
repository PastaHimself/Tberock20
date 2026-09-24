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
 *  software.bernie.geckolib.cache.object.BakedGeoModel
 *  software.bernie.geckolib.model.GeoModel
 *  software.bernie.geckolib.renderer.GeoEntityRenderer
 */
package net.thebrokenscript.entity.integrity.phase3;

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
import net.thebrokenscript.entity.integrity.phase3.IntegrityP3ArmModel;
import net.thebrokenscript.entity.integrity.phase3.IntegrityP3GroundArmEntity;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

@SideOnly(side=Side.CLIENT)
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0005\u0010\u0006J.\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016Jf\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00022\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u001dH\u0016J`\u0010 \u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u00022\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\u001dH\u0016\u00a8\u0006\""}, d2={"Lnet/thebrokenscript/entity/integrity/phase3/IntegrityP3ArmRenderer;", "Lsoftware/bernie/geckolib/renderer/GeoEntityRenderer;", "Lnet/thebrokenscript/entity/integrity/phase3/IntegrityP3GroundArmEntity;", "cx", "Lnet/minecraft/client/renderer/entity/EntityRendererProvider$Context;", "<init>", "(Lnet/minecraft/client/renderer/entity/EntityRendererProvider$Context;)V", "getRenderType", "Lnet/minecraft/client/renderer/RenderType;", "animatable", "texture", "Lnet/minecraft/resources/ResourceLocation;", "bufferSource", "Lnet/minecraft/client/renderer/MultiBufferSource;", "partialTick", "", "actuallyRender", "", "poseStack", "Lcom/mojang/blaze3d/vertex/PoseStack;", "entity", "model", "Lsoftware/bernie/geckolib/cache/object/BakedGeoModel;", "renderType", "buffer", "Lcom/mojang/blaze3d/vertex/VertexConsumer;", "isReRender", "", "packedLight", "", "packedOverlay", "colour", "preRender", "color", "thebrokenscript-common"})
public final class IntegrityP3ArmRenderer
extends GeoEntityRenderer<IntegrityP3GroundArmEntity> {
    public IntegrityP3ArmRenderer(@NotNull EntityRendererProvider.Context cx) {
        Intrinsics.checkNotNullParameter((Object)cx, (String)"cx");
        super(cx, (GeoModel)new IntegrityP3ArmModel());
        this.shadowRadius = 0.5f;
    }

    @Nullable
    public RenderType getRenderType(@NotNull IntegrityP3GroundArmEntity animatable, @Nullable ResourceLocation texture, @Nullable MultiBufferSource bufferSource, float partialTick) {
        Intrinsics.checkNotNullParameter((Object)((Object)animatable), (String)"animatable");
        return RenderType.entityTranslucent((ResourceLocation)this.getTextureLocation((Entity)animatable));
    }

    public void actuallyRender(@NotNull PoseStack poseStack, @NotNull IntegrityP3GroundArmEntity entity, @Nullable BakedGeoModel model2, @Nullable RenderType renderType, @NotNull MultiBufferSource bufferSource, @Nullable VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, int colour) {
        Intrinsics.checkNotNullParameter((Object)poseStack, (String)"poseStack");
        Intrinsics.checkNotNullParameter((Object)((Object)entity), (String)"entity");
        Intrinsics.checkNotNullParameter((Object)bufferSource, (String)"bufferSource");
        if (entity.isInvisible()) {
            return;
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

    public void preRender(@Nullable PoseStack poseStack, @NotNull IntegrityP3GroundArmEntity entity, @Nullable BakedGeoModel model2, @Nullable MultiBufferSource bufferSource, @Nullable VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, int color) {
        float scale;
        Intrinsics.checkNotNullParameter((Object)((Object)entity), (String)"entity");
        this.scaleHeight = scale = 1.0f;
        this.scaleWidth = scale;
        super.preRender(poseStack, (Entity)entity, model2, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, color);
    }
}

