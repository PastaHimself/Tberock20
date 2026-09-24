/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.systems.RenderSystem
 *  com.mojang.blaze3d.vertex.BufferBuilder
 *  com.mojang.blaze3d.vertex.BufferUploader
 *  com.mojang.blaze3d.vertex.DefaultVertexFormat
 *  com.mojang.blaze3d.vertex.MeshData
 *  com.mojang.blaze3d.vertex.PoseStack
 *  com.mojang.blaze3d.vertex.Tesselator
 *  com.mojang.blaze3d.vertex.VertexConsumer
 *  com.mojang.blaze3d.vertex.VertexFormat$Mode
 *  com.mojang.math.Axis
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.jvm.optionals.OptionalsKt
 *  kotlin.math.MathKt
 *  net.minecraft.client.renderer.GameRenderer
 *  net.minecraft.client.renderer.MultiBufferSource
 *  net.minecraft.client.renderer.ShaderInstance
 *  net.minecraft.client.renderer.entity.EntityRendererProvider$Context
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.util.Mth
 *  net.minecraft.world.entity.player.Player
 *  net.thebrokenscript.brokencore.api.dsl.ClientDSLKt
 *  net.thebrokenscript.brokencore.api.util.math.MathUtilKt
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  org.joml.Matrix4f
 *  org.joml.Vector2f
 *  org.joml.Vector3f
 *  org.joml.Vector3fc
 *  software.bernie.geckolib.cache.object.BakedGeoModel
 *  software.bernie.geckolib.model.GeoModel
 *  software.bernie.geckolib.renderer.GeoEntityRenderer
 */
package net.thebrokenscript.client.renderer.entity;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.BufferBuilder;
import com.mojang.blaze3d.vertex.BufferUploader;
import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import com.mojang.blaze3d.vertex.MeshData;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.Tesselator;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.VertexFormat;
import com.mojang.math.Axis;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.optionals.OptionalsKt;
import kotlin.math.MathKt;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.ShaderInstance;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Player;
import net.thebrokenscript.api.TBSConstants;
import net.thebrokenscript.brokencore.api.dsl.ClientDSLKt;
import net.thebrokenscript.brokencore.api.util.math.MathUtilKt;
import net.thebrokenscript.client.model.entity.ChordModel;
import net.thebrokenscript.entity.boss.ChordEntity;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.joml.Matrix4f;
import org.joml.Vector2f;
import org.joml.Vector3f;
import org.joml.Vector3fc;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 \u001a2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001aB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0005\u0010\u0006JT\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0015H\u0016J\u0010\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u0002H\u0014\u00a8\u0006\u001b"}, d2={"Lnet/thebrokenscript/client/renderer/entity/ChordRenderer;", "Lsoftware/bernie/geckolib/renderer/GeoEntityRenderer;", "Lnet/thebrokenscript/entity/boss/ChordEntity;", "renderManager", "Lnet/minecraft/client/renderer/entity/EntityRendererProvider$Context;", "<init>", "(Lnet/minecraft/client/renderer/entity/EntityRendererProvider$Context;)V", "renderFinal", "", "poseStack", "Lcom/mojang/blaze3d/vertex/PoseStack;", "entity", "model", "Lsoftware/bernie/geckolib/cache/object/BakedGeoModel;", "bufferSource", "Lnet/minecraft/client/renderer/MultiBufferSource;", "buffer", "Lcom/mojang/blaze3d/vertex/VertexConsumer;", "partialTick", "", "packedLight", "", "packedOverlay", "colour", "getDeathMaxRotation", "animatable", "Companion", "thebrokenscript-common"})
@SourceDebugExtension(value={"SMAP\nChordRenderer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ChordRenderer.kt\nnet/thebrokenscript/client/renderer/entity/ChordRenderer\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,122:1\n1#2:123\n*E\n"})
public final class ChordRenderer
extends GeoEntityRenderer<ChordEntity> {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private static final ResourceLocation laserLocation = TBSConstants.id("textures/particle/laser.png");
    @NotNull
    private static final ResourceLocation chargeLaserLocation = TBSConstants.id("textures/particle/charge_laser.png");

    public ChordRenderer(@NotNull EntityRendererProvider.Context renderManager) {
        Intrinsics.checkNotNullParameter((Object)renderManager, (String)"renderManager");
        super(renderManager, (GeoModel)new ChordModel());
    }

    public void renderFinal(@NotNull PoseStack poseStack, @NotNull ChordEntity entity, @Nullable BakedGeoModel model2, @NotNull MultiBufferSource bufferSource, @Nullable VertexConsumer buffer, float partialTick, int packedLight, int packedOverlay, int colour) {
        Intrinsics.checkNotNullParameter((Object)poseStack, (String)"poseStack");
        Intrinsics.checkNotNullParameter((Object)((Object)entity), (String)"entity");
        Intrinsics.checkNotNullParameter((Object)bufferSource, (String)"bufferSource");
        if (entity.getClientLaserAnimTimer() > 0 && buffer != null) {
            UUID uUID = (UUID)OptionalsKt.getOrNull(entity.getTargetUUID());
            if (uUID != null) {
                UUID targetUUID = uUID;
                boolean bl = false;
                Player player = entity.getLevel().getPlayerByUUID(targetUUID);
                if (player != null) {
                    Player target = player;
                    boolean bl2 = false;
                    float partialTick2 = ClientDSLKt.getMC().getTimer().getGameTimeDeltaPartialTick(true);
                    Vector3f selfPos = entity.getPosition(partialTick2).toVector3f().add(0.0f, 0.5f, 0.0f);
                    Vector3f targetPos = entity.getTargetPos();
                    float xN = selfPos.x - targetPos.x;
                    float yN = selfPos.y + entity.getEyeHeight() - (targetPos.y + 1.0f);
                    float zN = selfPos.z - targetPos.z;
                    float sqr = (float)Math.sqrt(xN * xN + zN * zN);
                    float xRot = (float)(Mth.atan2((double)yN, (double)sqr) * 180.0 / 3.1415927410125732) + (float)180;
                    float yRot = MathUtilKt.getAngleTo((Vector2f)new Vector2f(selfPos.x, selfPos.z), (Vector2f)new Vector2f(targetPos.x, targetPos.z));
                    poseStack.pushPose();
                    float d = 1.0f - ((float)entity.getClientLaserAnimTimer() - partialTick2) / (float)entity.getClientLaserAnimLength();
                    float scale = (float)Math.sin((entity.getClientLaserAnimTimer() < 10 ? d * (float)4 : d) * 1.5707964f) * 0.5f;
                    float rot = (float)Math.cos((1.0f - ((float)entity.getClientLaserAnimTimer() - partialTick2) / (float)entity.getClientLaserAnimLength()) * 1.5707964f) * 0.5f;
                    poseStack.mulPose(Axis.YP.rotationDegrees(yRot));
                    poseStack.translate(0.0f, entity.getEyeHeight() + 0.5f, 0.0f);
                    poseStack.mulPose(Axis.XP.rotationDegrees(xRot));
                    float vOfs = -(rot * (float)16 % 1.0f);
                    int n = MathKt.roundToInt((float)(targetPos.distance((Vector3fc)selfPos) / 0.2f)) + 4;
                    for (int i = 0; i < n; ++i) {
                        int it = i;
                        boolean bl3 = false;
                        poseStack.pushPose();
                        poseStack.translate(0.0f, 0.0f, (float)it * -0.2f);
                        float s = 0.2f;
                        Tesselator tess = Tesselator.getInstance();
                        BufferBuilder buf = tess.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_TEX);
                        Matrix4f mat = poseStack.last().pose();
                        poseStack.mulPose(Axis.XP.rotationDegrees(90.0f));
                        poseStack.mulPose(Axis.YP.rotationDegrees(rot * (float)720));
                        buf.addVertex(mat, -s * scale, 0.0f, 0.0f).setUv(vOfs, 1.0f).setUv1(0, 0).setUv2(0, 0).setNormal(0.0f, 0.0f, 0.0f).setColor(-1).addVertex(mat, -s * scale, s, 0.0f).setUv(1.0f + vOfs, 1.0f).setUv1(0, 0).setUv2(0, 0).setNormal(0.0f, 0.0f, 0.0f).setColor(-1).addVertex(mat, s * scale, s, 0.0f).setUv(1.0f + vOfs, 0.0f).setUv1(0, 0).setUv2(0, 0).setNormal(0.0f, 0.0f, 0.0f).setColor(-1).addVertex(mat, s * scale, 0.0f, 0.0f).setUv(vOfs, 0.0f).setUv1(0, 0).setUv2(0, 0).setNormal(0.0f, 0.0f, 0.0f).setColor(-1).addVertex(mat, 0.0f, 0.0f, -s * scale).setUv(vOfs, 1.0f).setUv1(0, 0).setUv2(0, 0).setNormal(0.0f, 0.0f, 0.0f).setColor(-1).addVertex(mat, 0.0f, s, -s * scale).setUv(1.0f + vOfs, 1.0f).setUv1(0, 0).setUv2(0, 0).setNormal(0.0f, 0.0f, 0.0f).setColor(-1).addVertex(mat, 0.0f, s, s * scale).setUv(1.0f + vOfs, 0.0f).setUv1(0, 0).setUv2(0, 0).setNormal(0.0f, 0.0f, 0.0f).setColor(-1).addVertex(mat, 0.0f, 0.0f, s * scale).setUv(vOfs, 0.0f).setUv1(0, 0).setUv2(0, 0).setNormal(0.0f, 0.0f, 0.0f).setColor(-1);
                        RenderSystem.setShader(ChordRenderer::renderFinal$lambda$0$0$0$0);
                        if (entity.getLaserType() == 0) {
                            RenderSystem.setShaderTexture((int)0, (ResourceLocation)chargeLaserLocation);
                        } else {
                            RenderSystem.setShaderTexture((int)0, (ResourceLocation)laserLocation);
                        }
                        RenderSystem.disableCull();
                        RenderSystem.enableDepthTest();
                        BufferUploader.drawWithShader((MeshData)buf.buildOrThrow());
                        RenderSystem.enableCull();
                        poseStack.popPose();
                    }
                    poseStack.popPose();
                }
            }
        }
        super.renderFinal(poseStack, this.animatable, model2, bufferSource, buffer, partialTick, packedLight, packedOverlay, colour);
    }

    protected float getDeathMaxRotation(@NotNull ChordEntity animatable) {
        Intrinsics.checkNotNullParameter((Object)((Object)animatable), (String)"animatable");
        return 0.0f;
    }

    private static final ShaderInstance renderFinal$lambda$0$0$0$0() {
        return GameRenderer.getPositionTexShader();
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007\u00a8\u0006\n"}, d2={"Lnet/thebrokenscript/client/renderer/entity/ChordRenderer$Companion;", "", "<init>", "()V", "laserLocation", "Lnet/minecraft/resources/ResourceLocation;", "getLaserLocation", "()Lnet/minecraft/resources/ResourceLocation;", "chargeLaserLocation", "getChargeLaserLocation", "thebrokenscript-common"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final ResourceLocation getLaserLocation() {
            return laserLocation;
        }

        @NotNull
        public final ResourceLocation getChargeLaserLocation() {
            return chargeLaserLocation;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

