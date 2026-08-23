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
 *  net.minecraft.core.Position
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.phys.Vec3
 *  net.thebrokenscript.brokencore.api.client.util.Billboarder
 *  net.thebrokenscript.brokencore.api.dsl.PositionUtil
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  org.joml.Vector3f
 *  software.bernie.geckolib.cache.object.BakedGeoModel
 *  software.bernie.geckolib.model.GeoModel
 *  software.bernie.geckolib.renderer.GeoEntityRenderer
 */
package net.thebrokenscript.client.renderer.entity.tbe;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.core.Position;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.api.TBSConstants;
import net.thebrokenscript.brokencore.api.client.util.Billboarder;
import net.thebrokenscript.brokencore.api.dsl.PositionUtil;
import net.thebrokenscript.client.model.entity.TheBrokenEndCuriousModel;
import net.thebrokenscript.entity.tbe.TheBrokenEndCuriousEntity;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector3f;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0002H\u0016J.\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016Jf\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\t\u001a\u00020\u00022\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u001eH\u0016J8\u0010!\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020\u00112\u0006\u0010#\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010$\u001a\u00020\u0011H\u0014\u00a8\u0006%"}, d2={"Lnet/thebrokenscript/client/renderer/entity/tbe/TheBrokenEndCuriousRenderer;", "Lsoftware/bernie/geckolib/renderer/GeoEntityRenderer;", "Lnet/thebrokenscript/entity/tbe/TheBrokenEndCuriousEntity;", "renderManager", "Lnet/minecraft/client/renderer/entity/EntityRendererProvider$Context;", "<init>", "(Lnet/minecraft/client/renderer/entity/EntityRendererProvider$Context;)V", "getTextureLocation", "Lnet/minecraft/resources/ResourceLocation;", "entity", "getRenderType", "Lnet/minecraft/client/renderer/RenderType;", "animatable", "texture", "bufferSource", "Lnet/minecraft/client/renderer/MultiBufferSource;", "partialTick", "", "actuallyRender", "", "poseStack", "Lcom/mojang/blaze3d/vertex/PoseStack;", "model", "Lsoftware/bernie/geckolib/cache/object/BakedGeoModel;", "renderType", "buffer", "Lcom/mojang/blaze3d/vertex/VertexConsumer;", "isReRender", "", "packedLight", "", "packedOverlay", "colour", "applyRotations", "ageInTicks", "rotationYaw", "nativeScale", "thebrokenscript-common"})
public final class TheBrokenEndCuriousRenderer
extends GeoEntityRenderer<TheBrokenEndCuriousEntity> {
    public TheBrokenEndCuriousRenderer(@NotNull EntityRendererProvider.Context renderManager) {
        Intrinsics.checkNotNullParameter((Object)renderManager, (String)"renderManager");
        super(renderManager, (GeoModel)new TheBrokenEndCuriousModel());
        this.shadowRadius = 2.5f;
    }

    @NotNull
    public ResourceLocation getTextureLocation(@NotNull TheBrokenEndCuriousEntity entity) {
        Intrinsics.checkNotNullParameter((Object)((Object)entity), (String)"entity");
        return TBSConstants.id("textures/entities/tbe_overhaul_ver4.png");
    }

    @Nullable
    public RenderType getRenderType(@NotNull TheBrokenEndCuriousEntity animatable, @Nullable ResourceLocation texture, @Nullable MultiBufferSource bufferSource, float partialTick) {
        Intrinsics.checkNotNullParameter((Object)((Object)animatable), (String)"animatable");
        return RenderType.entityTranslucent((ResourceLocation)this.getTextureLocation(animatable));
    }

    public void actuallyRender(@NotNull PoseStack poseStack, @NotNull TheBrokenEndCuriousEntity entity, @Nullable BakedGeoModel model2, @Nullable RenderType renderType, @NotNull MultiBufferSource bufferSource, @Nullable VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, int colour) {
        Intrinsics.checkNotNullParameter((Object)poseStack, (String)"poseStack");
        Intrinsics.checkNotNullParameter((Object)((Object)entity), (String)"entity");
        Intrinsics.checkNotNullParameter((Object)bufferSource, (String)"bufferSource");
        if (entity.isInvisible()) {
            return;
        }
        ResourceLocation baseTexture = this.getTextureLocation(entity);
        poseStack.pushPose();
        VertexConsumer baseBuffer = bufferSource.getBuffer(RenderType.entityTranslucent((ResourceLocation)baseTexture));
        super.actuallyRender(poseStack, (Entity)entity, model2, RenderType.entityTranslucentCull((ResourceLocation)baseTexture), bufferSource, baseBuffer, isReRender, partialTick, packedLight, packedOverlay, colour);
        poseStack.popPose();
        poseStack.pushPose();
        VertexConsumer glowBuffer = bufferSource.getBuffer(RenderType.eyes((ResourceLocation)baseTexture));
        super.actuallyRender(poseStack, (Entity)entity, model2, RenderType.eyes((ResourceLocation)baseTexture), bufferSource, glowBuffer, isReRender, partialTick, 0xF000F0, packedOverlay, colour);
        poseStack.popPose();
    }

    protected void applyRotations(@NotNull TheBrokenEndCuriousEntity entity, @NotNull PoseStack poseStack, float ageInTicks, float rotationYaw, float partialTick, float nativeScale) {
        Intrinsics.checkNotNullParameter((Object)((Object)entity), (String)"entity");
        Intrinsics.checkNotNullParameter((Object)poseStack, (String)"poseStack");
        Vec3 vec3 = entity.getPos().add(0.0, (double)this.entityRenderDispatcher.camera.getEntity().getEyeHeight(), 0.0);
        Intrinsics.checkNotNullExpressionValue((Object)vec3, (String)"add(...)");
        Vector3f entPos = PositionUtil.getJoml((Position)((Position)vec3));
        Vec3 vec32 = this.entityRenderDispatcher.camera.getPosition();
        Intrinsics.checkNotNullExpressionValue((Object)vec32, (String)"getPosition(...)");
        Vector3f ppos = PositionUtil.getJoml((Position)((Position)vec32));
        if (entPos.distanceSquared(ppos.x, entPos.y, ppos.z) > 400.0f) {
            Billboarder.INSTANCE.withHorizRotationTo(poseStack, entPos, ppos);
        } else {
            super.applyRotations((Entity)entity, poseStack, ageInTicks, rotationYaw, partialTick, nativeScale);
        }
    }
}

