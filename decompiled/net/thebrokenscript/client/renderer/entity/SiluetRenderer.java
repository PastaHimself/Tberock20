/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.vertex.PoseStack
 *  com.mojang.blaze3d.vertex.VertexConsumer
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.Reflection
 *  kotlin.reflect.KClass
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.player.LocalPlayer
 *  net.minecraft.client.renderer.MultiBufferSource
 *  net.minecraft.client.renderer.RenderType
 *  net.minecraft.client.renderer.culling.Frustum
 *  net.minecraft.client.renderer.entity.EntityRenderer
 *  net.minecraft.client.renderer.entity.EntityRendererProvider
 *  net.minecraft.client.renderer.entity.EntityRendererProvider$Context
 *  net.minecraft.core.Position
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.phys.Vec3
 *  net.thebrokenscript.brokencore.api.client.util.Billboarder
 *  net.thebrokenscript.brokencore.api.dsl.PositionUtil
 *  net.thebrokenscript.brokencore.api.entity.base.BaseMonster
 *  net.thebrokenscript.brokencore.api.util.Side
 *  net.thebrokenscript.brokencore.api.util.SideOnly
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  org.joml.Vector3f
 *  software.bernie.geckolib.cache.object.BakedGeoModel
 *  software.bernie.geckolib.model.GeoModel
 *  software.bernie.geckolib.renderer.GeoEntityRenderer
 */
package net.thebrokenscript.client.renderer.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.core.Position;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.api.TBSConstants;
import net.thebrokenscript.api.entity.BaseSiluetEntity;
import net.thebrokenscript.brokencore.api.client.util.Billboarder;
import net.thebrokenscript.brokencore.api.dsl.PositionUtil;
import net.thebrokenscript.brokencore.api.entity.base.BaseMonster;
import net.thebrokenscript.brokencore.api.util.Side;
import net.thebrokenscript.brokencore.api.util.SideOnly;
import net.thebrokenscript.client.model.entity.SiluetModel;
import net.thebrokenscript.entity.siluet.HeChaseEntity;
import net.thebrokenscript.entity.siluet.HeEntity;
import net.thebrokenscript.entity.siluet.HeHallucinationEntity;
import net.thebrokenscript.entity.siluet.SiluetChaseEntity;
import net.thebrokenscript.entity.siluet.SiluetEntity;
import net.thebrokenscript.entity.siluet.SiluetHallucinationEntity;
import net.thebrokenscript.entity.siluet.SiluetStareEntity;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector3f;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

@SideOnly(side=Side.CLIENT)
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000l\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0007\b\u0007\u0018\u0000 7*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u00017B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00028\u0000H\u0016\u00a2\u0006\u0002\u0010\u000bJ/\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00028\u00002\u0006\u0010\u000f\u001a\u00020\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016\u00a2\u0006\u0002\u0010\u0014Ji\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\n\u001a\u00028\u00002\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020!H\u0016\u00a2\u0006\u0002\u0010$J=\u0010%\u001a\u00020\u00162\u0006\u0010\u000e\u001a\u00028\u00002\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010&\u001a\u00020\u00132\u0006\u0010'\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010(\u001a\u00020\u0013H\u0014\u00a2\u0006\u0002\u0010)J\u0015\u0010*\u001a\u00020\u00132\u0006\u0010\n\u001a\u00028\u0000H\u0014\u00a2\u0006\u0002\u0010+J5\u0010,\u001a\u00020\u001f2\u0006\u0010-\u001a\u00028\u00002\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u0002012\u0006\u00103\u001a\u000201H\u0016\u00a2\u0006\u0002\u00104J\u000e\u00105\u001a\u00020\t2\u0006\u00106\u001a\u00020!\u00a8\u00068"}, d2={"Lnet/thebrokenscript/client/renderer/entity/SiluetRenderer;", "T", "Lnet/thebrokenscript/api/entity/BaseSiluetEntity;", "Lsoftware/bernie/geckolib/renderer/GeoEntityRenderer;", "renderManager", "Lnet/minecraft/client/renderer/entity/EntityRendererProvider$Context;", "<init>", "(Lnet/minecraft/client/renderer/entity/EntityRendererProvider$Context;)V", "getTextureLocation", "Lnet/minecraft/resources/ResourceLocation;", "entity", "(Lnet/thebrokenscript/api/entity/BaseSiluetEntity;)Lnet/minecraft/resources/ResourceLocation;", "getRenderType", "Lnet/minecraft/client/renderer/RenderType;", "animatable", "texture", "bufferSource", "Lnet/minecraft/client/renderer/MultiBufferSource;", "partialTick", "", "(Lnet/thebrokenscript/api/entity/BaseSiluetEntity;Lnet/minecraft/resources/ResourceLocation;Lnet/minecraft/client/renderer/MultiBufferSource;F)Lnet/minecraft/client/renderer/RenderType;", "actuallyRender", "", "poseStack", "Lcom/mojang/blaze3d/vertex/PoseStack;", "model", "Lsoftware/bernie/geckolib/cache/object/BakedGeoModel;", "renderType", "buffer", "Lcom/mojang/blaze3d/vertex/VertexConsumer;", "isReRender", "", "packedLight", "", "packedOverlay", "colour", "(Lcom/mojang/blaze3d/vertex/PoseStack;Lnet/thebrokenscript/api/entity/BaseSiluetEntity;Lsoftware/bernie/geckolib/cache/object/BakedGeoModel;Lnet/minecraft/client/renderer/RenderType;Lnet/minecraft/client/renderer/MultiBufferSource;Lcom/mojang/blaze3d/vertex/VertexConsumer;ZFIII)V", "applyRotations", "ageInTicks", "rotationYaw", "scale", "(Lnet/thebrokenscript/api/entity/BaseSiluetEntity;Lcom/mojang/blaze3d/vertex/PoseStack;FFFF)V", "getShadowRadius", "(Lnet/thebrokenscript/api/entity/BaseSiluetEntity;)F", "shouldRender", "livingEntity", "camera", "Lnet/minecraft/client/renderer/culling/Frustum;", "camX", "", "camY", "camZ", "(Lnet/thebrokenscript/api/entity/BaseSiluetEntity;Lnet/minecraft/client/renderer/culling/Frustum;DDD)Z", "getHimFrame", "tickFrame", "Companion", "thebrokenscript-common"})
public final class SiluetRenderer<T extends BaseSiluetEntity>
extends GeoEntityRenderer<T> {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private static final ResourceLocation FRAME1 = TBSConstants.id("textures/entities/himframe1.png");
    @NotNull
    private static final ResourceLocation FRAME2 = TBSConstants.id("textures/entities/himframe2.png");
    @NotNull
    private static final ResourceLocation FRAME3 = TBSConstants.id("textures/entities/himframe3.png");
    @NotNull
    private static final ResourceLocation FRAME4 = TBSConstants.id("textures/entities/himframe4.png");

    public SiluetRenderer(@NotNull EntityRendererProvider.Context renderManager) {
        Intrinsics.checkNotNullParameter((Object)renderManager, (String)"renderManager");
        super(renderManager, (GeoModel)new SiluetModel());
        this.shadowRadius = 0.5f;
    }

    @NotNull
    public ResourceLocation getTextureLocation(@NotNull T entity) {
        ResourceLocation resourceLocation;
        Intrinsics.checkNotNullParameter(entity, (String)"entity");
        KClass kClass = Reflection.getOrCreateKotlinClass(entity.getClass());
        if (Intrinsics.areEqual((Object)kClass, (Object)Reflection.getOrCreateKotlinClass(HeHallucinationEntity.class)) || Intrinsics.areEqual((Object)kClass, (Object)Reflection.getOrCreateKotlinClass(HeEntity.class)) || Intrinsics.areEqual((Object)kClass, (Object)Reflection.getOrCreateKotlinClass(HeChaseEntity.class))) {
            resourceLocation = TBSConstants.id("textures/entities/he_overhaul.png");
        } else if (Intrinsics.areEqual((Object)kClass, (Object)Reflection.getOrCreateKotlinClass(SiluetEntity.class)) || Intrinsics.areEqual((Object)kClass, (Object)Reflection.getOrCreateKotlinClass(SiluetHallucinationEntity.class)) || Intrinsics.areEqual((Object)kClass, (Object)Reflection.getOrCreateKotlinClass(SiluetChaseEntity.class)) || Intrinsics.areEqual((Object)kClass, (Object)Reflection.getOrCreateKotlinClass(SiluetStareEntity.class))) {
            resourceLocation = TBSConstants.id("textures/entities/siluetoverhaul.png");
        } else {
            throw new Exception("Unknown Siluet/Him Entity");
        }
        return resourceLocation;
    }

    @NotNull
    public RenderType getRenderType(@NotNull T animatable, @NotNull ResourceLocation texture, @Nullable MultiBufferSource bufferSource, float partialTick) {
        Intrinsics.checkNotNullParameter(animatable, (String)"animatable");
        Intrinsics.checkNotNullParameter((Object)texture, (String)"texture");
        RenderType renderType = RenderType.entityTranslucent((ResourceLocation)texture);
        Intrinsics.checkNotNullExpressionValue((Object)renderType, (String)"entityTranslucent(...)");
        return renderType;
    }

    public void actuallyRender(@NotNull PoseStack poseStack, @NotNull T entity, @NotNull BakedGeoModel model2, @Nullable RenderType renderType, @NotNull MultiBufferSource bufferSource, @Nullable VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, int colour) {
        LocalPlayer localPlayer;
        Minecraft mc;
        Intrinsics.checkNotNullParameter((Object)poseStack, (String)"poseStack");
        Intrinsics.checkNotNullParameter(entity, (String)"entity");
        Intrinsics.checkNotNullParameter((Object)model2, (String)"model");
        Intrinsics.checkNotNullParameter((Object)bufferSource, (String)"bufferSource");
        if (entity instanceof SiluetHallucinationEntity) {
            mc = Minecraft.getInstance();
            localPlayer = mc.player;
            if (localPlayer == null || !Intrinsics.areEqual((Object)((SiluetHallucinationEntity)((Object)entity)).getPlayerUUID(), (Object)localPlayer.getUUID())) {
                return;
            }
        }
        if (entity instanceof HeHallucinationEntity) {
            mc = Minecraft.getInstance();
            localPlayer = mc.player;
            if (localPlayer == null || !Intrinsics.areEqual((Object)((HeHallucinationEntity)((Object)entity)).getPlayerUUID(), (Object)localPlayer.getUUID())) {
                return;
            }
        }
        poseStack.pushPose();
        Vec3 vec3 = ((BaseMonster)entity).getPos().add(0.0, (double)this.entityRenderDispatcher.camera.getEntity().getEyeHeight(), 0.0);
        Intrinsics.checkNotNullExpressionValue((Object)vec3, (String)"add(...)");
        Vector3f vector3f = PositionUtil.getJoml((Position)((Position)vec3));
        Vec3 vec32 = this.entityRenderDispatcher.camera.getPosition();
        Intrinsics.checkNotNullExpressionValue((Object)vec32, (String)"getPosition(...)");
        Billboarder.INSTANCE.withRotationTo(poseStack, vector3f, PositionUtil.getJoml((Position)((Position)vec32)));
        ResourceLocation baseTexture = this.getTextureLocation(entity);
        if (baseTexture.getPath().equals("textures/entities/he_overhaul.png")) {
            baseBuffer = bufferSource.getBuffer(RenderType.entityTranslucent((ResourceLocation)baseTexture));
            super.actuallyRender(poseStack, (Entity)entity, model2, RenderType.entityTranslucentCull((ResourceLocation)baseTexture), bufferSource, baseBuffer, isReRender, partialTick, packedLight, packedOverlay, colour);
            ResourceLocation tickFrame = this.getHimFrame(((BaseSiluetEntity)((Object)entity)).tickCount % 4);
            VertexConsumer glowBuffer = bufferSource.getBuffer(RenderType.eyes((ResourceLocation)tickFrame));
            super.actuallyRender(poseStack, (Entity)entity, model2, RenderType.eyes((ResourceLocation)tickFrame), bufferSource, glowBuffer, isReRender, partialTick, 0xF000F0, packedOverlay, colour);
        } else {
            baseBuffer = bufferSource.getBuffer(RenderType.entityTranslucent((ResourceLocation)baseTexture));
            super.actuallyRender(poseStack, (Entity)entity, model2, RenderType.entityTranslucentCull((ResourceLocation)baseTexture), bufferSource, baseBuffer, isReRender, partialTick, packedLight, packedOverlay, colour);
        }
        poseStack.popPose();
    }

    protected void applyRotations(@NotNull T animatable, @NotNull PoseStack poseStack, float ageInTicks, float rotationYaw, float partialTick, float scale) {
        Intrinsics.checkNotNullParameter(animatable, (String)"animatable");
        Intrinsics.checkNotNullParameter((Object)poseStack, (String)"poseStack");
    }

    protected float getShadowRadius(@NotNull T entity) {
        Intrinsics.checkNotNullParameter(entity, (String)"entity");
        Minecraft mc = Minecraft.getInstance();
        LocalPlayer localPlayer = mc.player;
        if (entity instanceof SiluetHallucinationEntity) {
            return localPlayer == null || !Intrinsics.areEqual((Object)((SiluetHallucinationEntity)((Object)entity)).getPlayerUUID(), (Object)localPlayer.getUUID()) ? 0.0f : super.getShadowRadius((Entity)entity);
        }
        if (entity instanceof HeHallucinationEntity) {
            return localPlayer == null || !Intrinsics.areEqual((Object)((HeHallucinationEntity)((Object)entity)).getPlayerUUID(), (Object)localPlayer.getUUID()) ? 0.0f : super.getShadowRadius((Entity)entity);
        }
        return super.getShadowRadius((Entity)entity);
    }

    public boolean shouldRender(@NotNull T livingEntity, @NotNull Frustum camera, double camX, double camY, double camZ) {
        Intrinsics.checkNotNullParameter(livingEntity, (String)"livingEntity");
        Intrinsics.checkNotNullParameter((Object)camera, (String)"camera");
        Minecraft mc = Minecraft.getInstance();
        LocalPlayer localPlayer = mc.player;
        if (livingEntity instanceof SiluetHallucinationEntity) {
            return localPlayer != null && Intrinsics.areEqual((Object)((SiluetHallucinationEntity)((Object)livingEntity)).getPlayerUUID(), (Object)localPlayer.getUUID()) && super.shouldRender((Entity)livingEntity, camera, camX, camY, camZ);
        }
        if (livingEntity instanceof HeHallucinationEntity) {
            return localPlayer != null && Intrinsics.areEqual((Object)((HeHallucinationEntity)((Object)livingEntity)).getPlayerUUID(), (Object)localPlayer.getUUID()) && super.shouldRender((Entity)livingEntity, camera, camX, camY, camZ);
        }
        return super.shouldRender((Entity)livingEntity, camera, camX, camY, camZ);
    }

    @NotNull
    public final ResourceLocation getHimFrame(int tickFrame) {
        return switch (tickFrame) {
            case 0 -> FRAME1;
            case 1 -> FRAME2;
            case 2 -> FRAME3;
            case 3 -> FRAME4;
            default -> FRAME1;
        };
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0005\"\b\b\u0001\u0010\u0006*\u00020\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2={"Lnet/thebrokenscript/client/renderer/entity/SiluetRenderer$Companion;", "", "<init>", "()V", "provider", "Lnet/minecraft/client/renderer/entity/EntityRendererProvider;", "T", "Lnet/thebrokenscript/api/entity/BaseSiluetEntity;", "FRAME1", "Lnet/minecraft/resources/ResourceLocation;", "FRAME2", "FRAME3", "FRAME4", "thebrokenscript-common"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final <T extends BaseSiluetEntity> EntityRendererProvider<T> provider() {
            return Companion::provider$lambda$0;
        }

        private static final EntityRenderer provider$lambda$0(EntityRendererProvider.Context it) {
            Intrinsics.checkNotNull((Object)it);
            return (EntityRenderer)new SiluetRenderer(it);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

