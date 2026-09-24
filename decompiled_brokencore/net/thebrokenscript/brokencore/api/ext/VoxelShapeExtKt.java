/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.vertex.PoseStack
 *  com.mojang.blaze3d.vertex.VertexConsumer
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.random.Random
 *  net.minecraft.client.renderer.MultiBufferSource
 *  net.minecraft.client.renderer.RenderType
 *  net.minecraft.core.BlockPos
 *  net.minecraft.util.Mth
 *  net.minecraft.world.phys.AABB
 *  net.minecraft.world.phys.Vec3
 *  net.minecraft.world.phys.shapes.VoxelShape
 *  org.jetbrains.annotations.NotNull
 *  org.joml.Vector3f
 */
package net.thebrokenscript.brokencore.api.ext;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector3f;

@Metadata(mv={2, 1, 0}, k=2, xi=48, d1={"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0003\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0004\u001a\u00020\u0005*\u00020\u0002\u001a\n\u0010\u0006\u001a\u00020\u0005*\u00020\u0002\u001a2\u0010\u0007\u001a\u00020\b*\u00020\u00022\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e\u00a8\u0006\u0011"}, d2={"randomPosition", "Lnet/minecraft/world/phys/Vec3;", "Lnet/minecraft/world/phys/shapes/VoxelShape;", "randomBottomPosition", "randomBlockPos", "Lnet/minecraft/core/BlockPos;", "randomBottomBlockPos", "renderLines", "", "buffer", "Lnet/minecraft/client/renderer/MultiBufferSource;", "poseStack", "Lcom/mojang/blaze3d/vertex/PoseStack;", "r", "", "g", "b", "brokencore-common"})
public final class VoxelShapeExtKt {
    @NotNull
    public static final Vec3 randomPosition(@NotNull VoxelShape $this$randomPosition) {
        Intrinsics.checkNotNullParameter((Object)$this$randomPosition, (String)"<this>");
        List list = $this$randomPosition.toAabbs();
        Intrinsics.checkNotNullExpressionValue((Object)list, (String)"toAabbs(...)");
        AABB aabb = (AABB)CollectionsKt.random((Collection)list, (Random)((Random)Random.Default));
        double x = Mth.lerp((double)Math.random(), (double)aabb.minX, (double)aabb.maxX);
        double y = Mth.lerp((double)Math.random(), (double)aabb.minY, (double)aabb.maxY);
        double z = Mth.lerp((double)Math.random(), (double)aabb.minZ, (double)aabb.maxZ);
        return new Vec3(x, y, z);
    }

    @NotNull
    public static final Vec3 randomBottomPosition(@NotNull VoxelShape $this$randomBottomPosition) {
        Intrinsics.checkNotNullParameter((Object)$this$randomBottomPosition, (String)"<this>");
        List list = $this$randomBottomPosition.toAabbs();
        Intrinsics.checkNotNullExpressionValue((Object)list, (String)"toAabbs(...)");
        AABB aabb = (AABB)CollectionsKt.random((Collection)list, (Random)((Random)Random.Default));
        double x = Mth.lerp((double)Math.random(), (double)aabb.minX, (double)aabb.maxX);
        double y = aabb.minY;
        double z = Mth.lerp((double)Math.random(), (double)aabb.minZ, (double)aabb.maxZ);
        return new Vec3(x, y, z);
    }

    @NotNull
    public static final BlockPos randomBlockPos(@NotNull VoxelShape $this$randomBlockPos) {
        Intrinsics.checkNotNullParameter((Object)$this$randomBlockPos, (String)"<this>");
        Vec3 pos = VoxelShapeExtKt.randomPosition($this$randomBlockPos);
        return new BlockPos((int)Math.rint(pos.x), (int)Math.rint(pos.y), (int)Math.rint(pos.z));
    }

    @NotNull
    public static final BlockPos randomBottomBlockPos(@NotNull VoxelShape $this$randomBottomBlockPos) {
        Intrinsics.checkNotNullParameter((Object)$this$randomBottomBlockPos, (String)"<this>");
        Vec3 pos = VoxelShapeExtKt.randomBottomPosition($this$randomBottomBlockPos);
        return new BlockPos((int)Math.rint(pos.x), (int)Math.rint(pos.y), (int)Math.rint(pos.z));
    }

    public static final void renderLines(@NotNull VoxelShape $this$renderLines, @NotNull MultiBufferSource buffer, @NotNull PoseStack poseStack, float r, float g, float b) {
        Intrinsics.checkNotNullParameter((Object)$this$renderLines, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)buffer, (String)"buffer");
        Intrinsics.checkNotNullParameter((Object)poseStack, (String)"poseStack");
        $this$renderLines.forAllEdges((arg_0, arg_1, arg_2, arg_3, arg_4, arg_5) -> VoxelShapeExtKt.renderLines$lambda$0(buffer, poseStack, r, g, b, arg_0, arg_1, arg_2, arg_3, arg_4, arg_5));
    }

    private static final void renderLines$lambda$0(MultiBufferSource $buffer, PoseStack $poseStack, float $r, float $g, float $b, double x1, double y1, double z1, double x2, double y2, double z2) {
        VertexConsumer buf = $buffer.getBuffer(RenderType.lines());
        Vector3f n1 = new Vector3f((float)(x1 - x2), (float)(y1 - y2), (float)(z1 - z2));
        Vector3f n2 = new Vector3f((float)(x2 - x1), (float)(y2 - y1), (float)(z2 - z1));
        buf.addVertex($poseStack.last(), (float)x1, (float)y1, (float)z1).setColor($r, $g, $b, 1.0f).setNormal(n1.x, n1.y, n1.z);
        buf.addVertex($poseStack.last(), (float)x2, (float)y2, (float)z2).setColor($r, $g, $b, 1.0f).setNormal(n2.x, n2.y, n2.z);
    }
}

