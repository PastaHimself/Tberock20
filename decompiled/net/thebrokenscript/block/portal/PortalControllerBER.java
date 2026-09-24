/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.vertex.PoseStack
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.client.player.LocalPlayer
 *  net.minecraft.client.renderer.MultiBufferSource
 *  net.minecraft.client.renderer.blockentity.BlockEntityRenderer
 *  net.minecraft.client.renderer.debug.DebugRenderer
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Holder
 *  net.minecraft.core.Vec3i
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.levelgen.structure.BoundingBox
 *  net.minecraft.world.phys.AABB
 *  net.thebrokenscript.brokencore.api.dsl.ClientDSLKt
 *  net.thebrokenscript.brokencore.api.ext.BoundingBoxExt
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.block.portal;

import com.mojang.blaze3d.vertex.PoseStack;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.debug.DebugRenderer;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.Vec3i;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.phys.AABB;
import net.thebrokenscript.block.portal.PortalControllerBlockEntity;
import net.thebrokenscript.brokencore.api.dsl.ClientDSLKt;
import net.thebrokenscript.brokencore.api.ext.BoundingBoxExt;
import net.thebrokenscript.registry.TBSBlocks;
import net.thebrokenscript.registry.TBSItems;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0003\u0010\u0004J8\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016\u00a8\u0006\u0011"}, d2={"Lnet/thebrokenscript/block/portal/PortalControllerBER;", "Lnet/minecraft/client/renderer/blockentity/BlockEntityRenderer;", "Lnet/thebrokenscript/block/portal/PortalControllerBlockEntity;", "<init>", "()V", "render", "", "blockEntity", "partialTick", "", "poseStack", "Lcom/mojang/blaze3d/vertex/PoseStack;", "bufferSource", "Lnet/minecraft/client/renderer/MultiBufferSource;", "packedLight", "", "packedOverlay", "thebrokenscript-common"})
public final class PortalControllerBER
implements BlockEntityRenderer<PortalControllerBlockEntity> {
    public void render(@NotNull PortalControllerBlockEntity blockEntity, float partialTick, @NotNull PoseStack poseStack, @NotNull MultiBufferSource bufferSource, int packedLight, int packedOverlay) {
        Intrinsics.checkNotNullParameter((Object)((Object)blockEntity), (String)"blockEntity");
        Intrinsics.checkNotNullParameter((Object)poseStack, (String)"poseStack");
        Intrinsics.checkNotNullParameter((Object)bufferSource, (String)"bufferSource");
        LocalPlayer localPlayer = ClientDSLKt.getMC().player;
        if (!(localPlayer != null && (localPlayer = localPlayer.getMainHandItem()) != null ? localPlayer.is((Holder)TBSItems.LINKER) : false)) {
            LocalPlayer localPlayer2 = ClientDSLKt.getMC().player;
            if (!(localPlayer2 != null && (localPlayer2 = localPlayer2.getOffhandItem()) != null ? localPlayer2.is((Holder)TBSItems.LINKER) : false)) {
                return;
            }
        }
        Level level = blockEntity.getLevel();
        if (level == null) {
            return;
        }
        Level level2 = level;
        BoundingBox bb = BoundingBox.fromCorners((Vec3i)((Vec3i)blockEntity.getBb().getA()), (Vec3i)((Vec3i)blockEntity.getBb().getB()));
        Intrinsics.checkNotNull((Object)bb);
        List blocks = BoundingBoxExt.INSTANCE.getPositions(bb);
        DebugRenderer.renderFilledBox((PoseStack)poseStack, (MultiBufferSource)bufferSource, (AABB)new AABB(BlockPos.ZERO).inflate(-0.1), (float)1.0f, (float)0.0f, (float)0.0f, (float)0.5f);
        for (BlockPos pos : blocks) {
            BlockState block = level2.getBlockState(pos.offset((Vec3i)blockEntity.getBlockPos()));
            if (!block.is((Holder)TBSBlocks.PORTAL_EXTENDER)) continue;
            DebugRenderer.renderFilledBox((PoseStack)poseStack, (MultiBufferSource)bufferSource, (AABB)new AABB(pos).inflate(-0.1), (float)1.0f, (float)1.0f, (float)0.0f, (float)0.5f);
        }
        DebugRenderer.renderFilledBox((PoseStack)poseStack, (MultiBufferSource)bufferSource, (AABB)AABB.of((BoundingBox)bb).inflate(0.1), (float)1.0f, (float)0.0f, (float)1.0f, (float)0.25f);
    }
}

