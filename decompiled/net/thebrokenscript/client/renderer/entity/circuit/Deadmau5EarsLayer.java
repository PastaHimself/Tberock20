/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.vertex.PoseStack
 *  com.mojang.blaze3d.vertex.VertexConsumer
 *  com.mojang.math.Axis
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.client.model.PlayerModel
 *  net.minecraft.client.renderer.MultiBufferSource
 *  net.minecraft.client.renderer.RenderType
 *  net.minecraft.client.renderer.entity.LivingEntityRenderer
 *  net.minecraft.client.renderer.entity.RenderLayerParent
 *  net.minecraft.client.renderer.entity.layers.RenderLayer
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.util.Mth
 *  net.minecraft.world.entity.LivingEntity
 *  net.thebrokenscript.brokencore.api.util.Side
 *  net.thebrokenscript.brokencore.api.util.SideOnly
 *  net.thebrokenscript.brokencore.api.util.math.MathUtilKt
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.client.renderer.entity.circuit;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;
import net.thebrokenscript.brokencore.api.util.Side;
import net.thebrokenscript.brokencore.api.util.SideOnly;
import net.thebrokenscript.brokencore.api.util.math.MathUtilKt;
import net.thebrokenscript.entity.circuit.FakePlayerEntity;
import org.jetbrains.annotations.NotNull;

@SideOnly(side=Side.CLIENT)
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\b\u0007\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00030\u0001B!\u0012\u0018\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00030\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007JX\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u0012H\u0016\u00a8\u0006\u0018"}, d2={"Lnet/thebrokenscript/client/renderer/entity/circuit/Deadmau5EarsLayer;", "Lnet/minecraft/client/renderer/entity/layers/RenderLayer;", "Lnet/thebrokenscript/entity/circuit/FakePlayerEntity;", "Lnet/minecraft/client/model/PlayerModel;", "renderer", "Lnet/minecraft/client/renderer/entity/RenderLayerParent;", "<init>", "(Lnet/minecraft/client/renderer/entity/RenderLayerParent;)V", "render", "", "ps", "Lcom/mojang/blaze3d/vertex/PoseStack;", "buffer", "Lnet/minecraft/client/renderer/MultiBufferSource;", "packedLight", "", "player", "limbSwing", "", "limbSwingAmount", "partialTicks", "ageInTicks", "netHeadYaw", "headPitch", "thebrokenscript-common"})
public final class Deadmau5EarsLayer
extends RenderLayer<FakePlayerEntity, PlayerModel<FakePlayerEntity>> {
    public Deadmau5EarsLayer(@NotNull RenderLayerParent<FakePlayerEntity, PlayerModel<FakePlayerEntity>> renderer) {
        Intrinsics.checkNotNullParameter(renderer, (String)"renderer");
        super(renderer);
    }

    public void render(@NotNull PoseStack ps, @NotNull MultiBufferSource buffer, int packedLight, @NotNull FakePlayerEntity player, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        Intrinsics.checkNotNullParameter((Object)ps, (String)"ps");
        Intrinsics.checkNotNullParameter((Object)buffer, (String)"buffer");
        Intrinsics.checkNotNullParameter((Object)((Object)player), (String)"player");
        if (Intrinsics.areEqual((Object)"deadmau5", (Object)player.getName().getString()) && !player.isInvisible()) {
            VertexConsumer cons = buffer.getBuffer(RenderType.entitySolid((ResourceLocation)player.getSkin().texture()));
            int overlay = LivingEntityRenderer.getOverlayCoords((LivingEntity)((LivingEntity)player), (float)0.0f);
            for (int i = 0; i < 2; ++i) {
                float yRot = MathUtilKt.lerpf((float)partialTicks, (Number)Float.valueOf(player.yRotO), (Number)Float.valueOf(player.getYRot())) - MathUtilKt.lerpf((float)partialTicks, (Number)Float.valueOf(player.yBodyRotO), (Number)Float.valueOf(player.yBodyRot));
                float xRot = Mth.lerp((float)partialTicks, (float)player.xRotO, (float)player.getXRot());
                ps.pushPose();
                ps.mulPose(Axis.YP.rotationDegrees(yRot));
                ps.mulPose(Axis.XP.rotationDegrees(xRot));
                ps.translate(0.375f * (float)(i * 2 - 1), 0.0f, 0.0f);
                ps.translate(0.0f, -0.375f, 0.0f);
                ps.mulPose(Axis.XP.rotationDegrees(-xRot));
                ps.mulPose(Axis.YP.rotationDegrees(-yRot));
                float scale = 1.3333334f;
                ps.scale(scale, scale, scale);
                ((PlayerModel)this.getParentModel()).renderEars(ps, cons, packedLight, overlay);
                ps.popPose();
            }
        }
    }
}

