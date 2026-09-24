/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.vertex.PoseStack
 *  com.mojang.blaze3d.vertex.VertexConsumer
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.renderer.MultiBufferSource
 *  net.minecraft.client.renderer.RenderType
 *  net.minecraft.client.renderer.culling.Frustum
 *  net.minecraft.core.BlockPos
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.phys.AABB
 *  net.thebrokenscript.brokencore.api.dsl.ClientDSLKt
 *  net.thebrokenscript.brokencore.api.util.Side
 *  net.thebrokenscript.brokencore.api.util.SideOnly
 *  org.jetbrains.annotations.NotNull
 *  org.joml.Matrix4f
 */
package net.thebrokenscript.client.renderer.block;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.thebrokenscript.block.entity.ExitBlockEntity;
import net.thebrokenscript.brokencore.api.dsl.ClientDSLKt;
import net.thebrokenscript.brokencore.api.util.Side;
import net.thebrokenscript.brokencore.api.util.SideOnly;
import net.thebrokenscript.client.registry.TBSRenderTypes;
import net.thebrokenscript.client.renderer.block.AllDeadRenderer;
import org.jetbrains.annotations.NotNull;
import org.joml.Matrix4f;

@SideOnly(side=Side.CLIENT)
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0003\u0010\u0004J8\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0010\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\tH\u0002J&\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u0016JX\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\t2\u0006\u0010 \u001a\u00020\t2\u0006\u0010!\u001a\u00020\t2\u0006\u0010\"\u001a\u00020\t2\u0006\u0010#\u001a\u00020\tH\u0002J\b\u0010$\u001a\u00020\u000fH\u0016\u00a8\u0006%"}, d2={"Lnet/thebrokenscript/client/renderer/block/ExitRenderer;", "Lnet/thebrokenscript/client/renderer/block/AllDeadRenderer;", "Lnet/thebrokenscript/block/entity/ExitBlockEntity;", "<init>", "()V", "render", "", "blockEntity", "partialTick", "", "poseStack", "Lcom/mojang/blaze3d/vertex/PoseStack;", "bufferSource", "Lnet/minecraft/client/renderer/MultiBufferSource;", "packedLight", "", "packedOverlay", "hash", "n", "renderExit", "entity", "offset", "", "vertex", "consumer", "Lcom/mojang/blaze3d/vertex/VertexConsumer;", "matrix", "Lorg/joml/Matrix4f;", "x", "y", "z", "u", "v", "r", "g", "b", "getViewDistance", "thebrokenscript-common"})
@SourceDebugExtension(value={"SMAP\nExitRenderer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ExitRenderer.kt\nnet/thebrokenscript/client/renderer/block/ExitRenderer\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,120:1\n1#2:121\n*E\n"})
public final class ExitRenderer
extends AllDeadRenderer<ExitBlockEntity> {
    @Override
    public void render(@NotNull ExitBlockEntity blockEntity, float partialTick, @NotNull PoseStack poseStack, @NotNull MultiBufferSource bufferSource, int packedLight, int packedOverlay) {
        Intrinsics.checkNotNullParameter((Object)((Object)blockEntity), (String)"blockEntity");
        Intrinsics.checkNotNullParameter((Object)poseStack, (String)"poseStack");
        Intrinsics.checkNotNullParameter((Object)bufferSource, (String)"bufferSource");
        Frustum frustum = ClientDSLKt.getMC().levelRenderer.cullingFrustum;
        if (frustum == null) {
            return;
        }
        Frustum frustum2 = frustum;
        BlockPos blockPos = blockEntity.getBlockPos();
        AABB aabb = new AABB((double)blockPos.getX(), (double)blockPos.getY(), (double)blockPos.getZ(), (double)blockPos.getX() + 1.0, (double)blockPos.getY() + 1.0, (double)blockPos.getZ() + 1.0);
        if (!frustum2.isVisible(aabb)) {
            return;
        }
        Level level = blockEntity.getLevel();
        double time = (level != null ? (double)level.getGameTime() : 0.0) + (double)partialTick;
        poseStack.pushPose();
        this.renderExit(blockEntity, poseStack, bufferSource, time);
        poseStack.popPose();
    }

    private final float hash(float n) {
        float it = (float)(Math.sin(n) * 43758.5453123);
        boolean bl = false;
        return it - (float)Math.floor(it);
    }

    public final void renderExit(@NotNull ExitBlockEntity entity, @NotNull PoseStack poseStack, @NotNull MultiBufferSource bufferSource, double offset) {
        Intrinsics.checkNotNullParameter((Object)((Object)entity), (String)"entity");
        Intrinsics.checkNotNullParameter((Object)poseStack, (String)"poseStack");
        Intrinsics.checkNotNullParameter((Object)bufferSource, (String)"bufferSource");
        poseStack.pushPose();
        VertexConsumer consumer = bufferSource.getBuffer((RenderType)TBSRenderTypes.EXIT_SHADER);
        Matrix4f matrix = poseStack.last().pose();
        float gray = 2.4f;
        Intrinsics.checkNotNull((Object)consumer);
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
        poseStack.popPose();
    }

    private final void vertex(VertexConsumer consumer, Matrix4f matrix, float x, float y, float z, float u, float v, float r, float g, float b) {
        consumer.addVertex(matrix, x, y, z).setColor(r, g, b, 1.0f).setUv(u, v);
    }

    @Override
    public int getViewDistance() {
        return 256;
    }
}

