/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.vertex.PoseStack
 *  com.mojang.blaze3d.vertex.PoseStack$Pose
 *  com.mojang.blaze3d.vertex.VertexConsumer
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.ranges.RangesKt
 *  net.minecraft.client.renderer.MultiBufferSource
 *  net.minecraft.client.renderer.RenderType
 *  net.minecraft.client.renderer.blockentity.BlockEntityRenderer
 *  net.minecraft.core.Position
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.phys.Vec3
 *  net.thebrokenscript.brokencore.api.client.util.Billboarder
 *  net.thebrokenscript.brokencore.api.dsl.ClientDSLKt
 *  net.thebrokenscript.brokencore.api.dsl.PositionUtil
 *  net.thebrokenscript.brokencore.api.util.Side
 *  net.thebrokenscript.brokencore.api.util.SideOnly
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  org.joml.Matrix4f
 *  org.joml.Vector3f
 */
package net.thebrokenscript.client.renderer.block;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.core.Position;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.api.TBSConstants;
import net.thebrokenscript.api.ext.LevelExt;
import net.thebrokenscript.block.entity.TetherBloomBlockEntity;
import net.thebrokenscript.brokencore.api.client.util.Billboarder;
import net.thebrokenscript.brokencore.api.dsl.ClientDSLKt;
import net.thebrokenscript.brokencore.api.dsl.PositionUtil;
import net.thebrokenscript.brokencore.api.util.Side;
import net.thebrokenscript.brokencore.api.util.SideOnly;
import net.thebrokenscript.data.MapVariables;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.joml.Matrix4f;
import org.joml.Vector3f;

@SideOnly(side=Side.CLIENT)
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 #2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001#B\u0007\u00a2\u0006\u0004\b\u0003\u0010\u0004J8\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J8\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002JX\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\t2\u0006\u0010 \u001a\u00020\t2\u0006\u0010!\u001a\u00020\t2\u0006\u0010\"\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002\u00a8\u0006$"}, d2={"Lnet/thebrokenscript/client/renderer/block/TetherBloomRenderer;", "Lnet/minecraft/client/renderer/blockentity/BlockEntityRenderer;", "Lnet/thebrokenscript/block/entity/TetherBloomBlockEntity;", "<init>", "()V", "render", "", "bloom", "partialTick", "", "stack", "Lcom/mojang/blaze3d/vertex/PoseStack;", "buf", "Lnet/minecraft/client/renderer/MultiBufferSource;", "light", "", "overlay", "renderFace", "poseStack", "bufferSource", "frameIndex", "hasBeenActivated", "", "vertex", "consumer", "Lcom/mojang/blaze3d/vertex/VertexConsumer;", "matrix", "Lorg/joml/Matrix4f;", "pose", "Lcom/mojang/blaze3d/vertex/PoseStack$Pose;", "x", "y", "z", "u", "v", "Companion", "thebrokenscript-common"})
public final class TetherBloomRenderer
implements BlockEntityRenderer<TetherBloomBlockEntity> {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private static final ResourceLocation IDLE = TBSConstants.id("textures/block/tether_bloom_idle.png");
    @NotNull
    private static final ResourceLocation ROT = TBSConstants.id("textures/block/tether_bloom_rot.png");
    @NotNull
    private static final ResourceLocation DISINTEGRATE = TBSConstants.id("textures/block/tether_bloom_disintegrate.png");
    public static final int FRAME_COUNT = 8;
    public static final int REFRESH_RATE = 4;
    public static final int IDLE_FRAME_COUNT = 4;
    public static final int ROT_FRAME_COUNT = 10;
    public static final int DISINTEGRATE_FRAME_COUNT = 9;
    @Nullable
    private static Double startTime;

    public void render(@NotNull TetherBloomBlockEntity bloom, float partialTick, @NotNull PoseStack stack, @NotNull MultiBufferSource buf, int light, int overlay) {
        int n;
        Intrinsics.checkNotNullParameter((Object)((Object)bloom), (String)"bloom");
        Intrinsics.checkNotNullParameter((Object)stack, (String)"stack");
        Intrinsics.checkNotNullParameter((Object)buf, (String)"buf");
        Level level = bloom.getLevel();
        double time = (level != null ? (double)level.getGameTime() : 0.0) + (double)partialTick;
        Object object = bloom.getLevel();
        boolean timeToMoveAndGroove = object != null && (object = LevelExt.INSTANCE.getVars((LevelAccessor)object)) != null ? ((MapVariables)((Object)object)).getCanFracturedSpawn() : false;
        stack.pushPose();
        stack.translate(0.5, 0.0, 0.5);
        if (ClientDSLKt.getMC().cameraEntity != null) {
            Vector3f vector3f = bloom.getBlockPos().getCenter().toVector3f();
            Intrinsics.checkNotNullExpressionValue((Object)vector3f, (String)"toVector3f(...)");
            Entity entity = ClientDSLKt.getMC().cameraEntity;
            Intrinsics.checkNotNull((Object)entity);
            Vec3 vec3 = entity.position();
            Intrinsics.checkNotNullExpressionValue((Object)vec3, (String)"position(...)");
            Billboarder.INSTANCE.withHorizRotationTo(stack, vector3f, PositionUtil.getJoml((Position)((Position)vec3)));
        }
        if (timeToMoveAndGroove) {
            if (startTime == null) {
                startTime = time;
            }
            Double d = startTime;
            Intrinsics.checkNotNull((Object)d);
            double elapsed = time - d;
            int progress = (int)(elapsed / (double)4);
            n = RangesKt.coerceIn((int)progress, (int)0, (int)9);
        } else {
            startTime = null;
            n = (int)(time / (double)4) % 4;
        }
        int frameIndex = n;
        this.renderFace(stack, buf, light, overlay, frameIndex, timeToMoveAndGroove);
        stack.popPose();
    }

    private final void renderFace(PoseStack poseStack, MultiBufferSource bufferSource, int light, int overlay, int frameIndex, boolean hasBeenActivated) {
        ResourceLocation texture = hasBeenActivated ? ROT : IDLE;
        int frameCount = hasBeenActivated ? 10 : 4;
        VertexConsumer consumer = bufferSource.getBuffer(RenderType.entityTranslucent((ResourceLocation)texture));
        PoseStack.Pose stack = poseStack.last();
        Matrix4f matrix = stack.pose();
        float half = 0.75f;
        float height = 1.5f;
        float vFrameSize = 1.0f / (float)frameCount;
        float vMin = (float)frameIndex * vFrameSize;
        float vMax = vMin + vFrameSize;
        Intrinsics.checkNotNull((Object)consumer);
        Intrinsics.checkNotNull((Object)matrix);
        Intrinsics.checkNotNull((Object)stack);
        this.vertex(consumer, matrix, stack, -half, 0.0f, 0.0f, 1.0f, vMax, light, overlay);
        this.vertex(consumer, matrix, stack, -half, height, 0.0f, 1.0f, vMin, light, overlay);
        this.vertex(consumer, matrix, stack, half, height, 0.0f, 0.0f, vMin, light, overlay);
        this.vertex(consumer, matrix, stack, half, 0.0f, 0.0f, 0.0f, vMax, light, overlay);
    }

    private final void vertex(VertexConsumer consumer, Matrix4f matrix, PoseStack.Pose pose, float x, float y, float z, float u, float v, int light, int overlay) {
        consumer.addVertex(matrix, x, y, z).setColor(1.0f, 1.0f, 1.0f, 1.0f).setUv(u, v).setOverlay(overlay).setLight(light).setNormal(pose, 0.0f, 1.0f, 1.0f);
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0011\u0010\n\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0007R\u000e\u0010\f\u001a\u00020\rX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\rX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\rX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\rX\u0086T\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0014\u00a8\u0006\u0015"}, d2={"Lnet/thebrokenscript/client/renderer/block/TetherBloomRenderer$Companion;", "", "<init>", "()V", "IDLE", "Lnet/minecraft/resources/ResourceLocation;", "getIDLE", "()Lnet/minecraft/resources/ResourceLocation;", "ROT", "getROT", "DISINTEGRATE", "getDISINTEGRATE", "FRAME_COUNT", "", "REFRESH_RATE", "IDLE_FRAME_COUNT", "ROT_FRAME_COUNT", "DISINTEGRATE_FRAME_COUNT", "startTime", "", "Ljava/lang/Double;", "thebrokenscript-common"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final ResourceLocation getIDLE() {
            return IDLE;
        }

        @NotNull
        public final ResourceLocation getROT() {
            return ROT;
        }

        @NotNull
        public final ResourceLocation getDISINTEGRATE() {
            return DISINTEGRATE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

