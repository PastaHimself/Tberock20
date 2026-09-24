/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.pipeline.TextureTarget
 *  com.mojang.blaze3d.vertex.PoseStack
 *  com.mojang.blaze3d.vertex.VertexConsumer
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.renderer.MultiBufferSource
 *  net.minecraft.client.renderer.RenderType
 *  net.minecraft.client.renderer.blockentity.BlockEntityRenderer
 *  net.minecraft.client.renderer.culling.Frustum
 *  net.minecraft.core.BlockPos
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.block.entity.BlockEntity
 *  net.minecraft.world.phys.AABB
 *  net.thebrokenscript.brokencore.api.dsl.ClientDSLKt
 *  net.thebrokenscript.brokencore.api.util.Side
 *  net.thebrokenscript.brokencore.api.util.SideOnly
 *  org.jetbrains.annotations.NotNull
 *  org.joml.Matrix4f
 */
package net.thebrokenscript.client.renderer.block;

import com.mojang.blaze3d.pipeline.TextureTarget;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.phys.AABB;
import net.thebrokenscript.block.entity.AllDeadBlockEntity;
import net.thebrokenscript.brokencore.api.dsl.ClientDSLKt;
import net.thebrokenscript.brokencore.api.util.Side;
import net.thebrokenscript.brokencore.api.util.SideOnly;
import net.thebrokenscript.client.registry.TBSRenderTypes;
import org.jetbrains.annotations.NotNull;
import org.joml.Matrix4f;

@SideOnly(side=Side.CLIENT)
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000T\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0017\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0007\u00a2\u0006\u0004\b\u0004\u0010\u0005J=\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00028\u00002\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0016\u00a2\u0006\u0002\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\nH\u0002J-\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00028\u00002\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u001aH\u0002\u00a2\u0006\u0002\u0010\u001bJ\u0018\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002JX\u0010\u001f\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\n2\u0006\u0010#\u001a\u00020\n2\u0006\u0010$\u001a\u00020\n2\u0006\u0010%\u001a\u00020\n2\u0006\u0010&\u001a\u00020\n2\u0006\u0010'\u001a\u00020\n2\u0006\u0010(\u001a\u00020\n2\u0006\u0010)\u001a\u00020\nH\u0002J\b\u0010*\u001a\u00020\u0010H\u0016R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006+"}, d2={"Lnet/thebrokenscript/client/renderer/block/AllDeadRenderer;", "T", "Lnet/thebrokenscript/block/entity/AllDeadBlockEntity;", "Lnet/minecraft/client/renderer/blockentity/BlockEntityRenderer;", "<init>", "()V", "render", "", "blockEntity", "partialTick", "", "poseStack", "Lcom/mojang/blaze3d/vertex/PoseStack;", "bufferSource", "Lnet/minecraft/client/renderer/MultiBufferSource;", "packedLight", "", "packedOverlay", "(Lnet/thebrokenscript/block/entity/AllDeadBlockEntity;FLcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/MultiBufferSource;II)V", "hash", "n", "tex", "Lcom/mojang/blaze3d/pipeline/TextureTarget;", "renderCube", "entity", "offset", "", "(Lnet/thebrokenscript/block/entity/AllDeadBlockEntity;Lcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/MultiBufferSource;D)V", "cube", "consumer", "Lcom/mojang/blaze3d/vertex/VertexConsumer;", "vertex", "matrix", "Lorg/joml/Matrix4f;", "x", "y", "z", "u", "v", "r", "g", "b", "getViewDistance", "thebrokenscript-common"})
@SourceDebugExtension(value={"SMAP\nAllDeadRenderer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AllDeadRenderer.kt\nnet/thebrokenscript/client/renderer/block/AllDeadRenderer\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,127:1\n1#2:128\n*E\n"})
public class AllDeadRenderer<T extends AllDeadBlockEntity>
implements BlockEntityRenderer<T> {
    @NotNull
    private final TextureTarget tex = new TextureTarget(128, 128, true, false);

    public void render(@NotNull T blockEntity, float partialTick, @NotNull PoseStack poseStack, @NotNull MultiBufferSource bufferSource, int packedLight, int packedOverlay) {
        Intrinsics.checkNotNullParameter(blockEntity, (String)"blockEntity");
        Intrinsics.checkNotNullParameter((Object)poseStack, (String)"poseStack");
        Intrinsics.checkNotNullParameter((Object)bufferSource, (String)"bufferSource");
        Level level = ((BlockEntity)blockEntity).getLevel();
        if (level == null) {
            return;
        }
        double animationOffset = level.getGameTime();
        Frustum frustum = ClientDSLKt.getMC().levelRenderer.cullingFrustum;
        if (frustum == null) {
            return;
        }
        Frustum frustum2 = frustum;
        BlockPos blockPos = ((BlockEntity)blockEntity).getBlockPos();
        AABB aabb = new AABB((double)blockPos.getX(), (double)blockPos.getY(), (double)blockPos.getZ(), (double)blockPos.getX() + 1.0, (double)blockPos.getY() + 1.0, (double)blockPos.getZ() + 1.0);
        if (!frustum2.isVisible(aabb)) {
            return;
        }
        poseStack.pushPose();
        this.renderCube(blockEntity, poseStack, bufferSource, animationOffset);
        poseStack.popPose();
    }

    private final float hash(float n) {
        float it = (float)(Math.sin(n) * 43758.5453123);
        boolean bl = false;
        return it - (float)Math.floor(it);
    }

    private final void renderCube(T entity, PoseStack poseStack, MultiBufferSource bufferSource, double offset) {
        poseStack.pushPose();
        poseStack.translate(0.5, 0.5, 0.5);
        poseStack.translate(-0.5, -0.5, -0.5);
        VertexConsumer consumer = bufferSource.getBuffer((RenderType)TBSRenderTypes.CUSTOM_END_GATEWAY);
        Intrinsics.checkNotNull((Object)consumer);
        this.cube(poseStack, consumer);
        poseStack.popPose();
    }

    private final void cube(PoseStack poseStack, VertexConsumer consumer) {
        float[] fArray = new float[]{0.2f, 0.1f, 0.3f};
        float[] colors = fArray;
        Matrix4f matrix = poseStack.last().pose();
        float gray = colors[0] * 0.299f + colors[1] * 0.587f + colors[2] * 0.114f;
        Intrinsics.checkNotNull((Object)matrix);
        this.vertex(consumer, matrix, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, gray, gray, gray);
        this.vertex(consumer, matrix, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, gray, gray, gray);
        this.vertex(consumer, matrix, 1.0f, 1.0f, 1.0f, 1.0f, 0.0f, gray, gray, gray);
        this.vertex(consumer, matrix, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f, gray, gray, gray);
        this.vertex(consumer, matrix, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, gray, gray, gray);
        this.vertex(consumer, matrix, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, gray, gray, gray);
        this.vertex(consumer, matrix, 1.0f, 0.0f, 1.0f, 1.0f, 0.0f, gray, gray, gray);
        this.vertex(consumer, matrix, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, gray, gray, gray);
        this.vertex(consumer, matrix, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, gray, gray, gray);
        this.vertex(consumer, matrix, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, gray, gray, gray);
        this.vertex(consumer, matrix, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f, gray, gray, gray);
        this.vertex(consumer, matrix, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, gray, gray, gray);
        this.vertex(consumer, matrix, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, gray, gray, gray);
        this.vertex(consumer, matrix, 1.0f, 1.0f, 0.0f, 0.0f, 0.0f, gray, gray, gray);
        this.vertex(consumer, matrix, 1.0f, 1.0f, 1.0f, 1.0f, 0.0f, gray, gray, gray);
        this.vertex(consumer, matrix, 1.0f, 0.0f, 1.0f, 1.0f, 1.0f, gray, gray, gray);
        this.vertex(consumer, matrix, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, gray, gray, gray);
        this.vertex(consumer, matrix, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, gray, gray, gray);
        this.vertex(consumer, matrix, 1.0f, 1.0f, 0.0f, 1.0f, 0.0f, gray, gray, gray);
        this.vertex(consumer, matrix, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, gray, gray, gray);
        this.vertex(consumer, matrix, 0.0f, 0.0f, 1.0f, 0.0f, 1.0f, gray, gray, gray);
        this.vertex(consumer, matrix, 1.0f, 0.0f, 1.0f, 1.0f, 1.0f, gray, gray, gray);
        this.vertex(consumer, matrix, 1.0f, 1.0f, 1.0f, 1.0f, 0.0f, gray, gray, gray);
        this.vertex(consumer, matrix, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, gray, gray, gray);
    }

    private final void vertex(VertexConsumer consumer, Matrix4f matrix, float x, float y, float z, float u, float v, float r, float g, float b) {
        consumer.addVertex(matrix, x, y, z).setColor(r, g, b, 1.0f).setUv(u, v);
    }

    public int getViewDistance() {
        return 256;
    }
}

