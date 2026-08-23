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
 *  net.minecraft.client.renderer.entity.RenderLayerParent
 *  net.minecraft.client.renderer.entity.layers.RenderLayer
 *  net.minecraft.client.renderer.texture.OverlayTexture
 *  net.minecraft.client.resources.PlayerSkin
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.util.Mth
 *  net.minecraft.world.entity.EquipmentSlot
 *  net.minecraft.world.entity.player.PlayerModelPart
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.item.Items
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
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.resources.PlayerSkin;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.PlayerModelPart;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.thebrokenscript.brokencore.api.util.Side;
import net.thebrokenscript.brokencore.api.util.SideOnly;
import net.thebrokenscript.brokencore.api.util.math.MathUtilKt;
import net.thebrokenscript.entity.circuit.FakePlayerEntity;
import org.jetbrains.annotations.NotNull;

@SideOnly(side=Side.CLIENT)
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\b\u0007\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00030\u0001B!\u0012\u0018\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00030\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007JX\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u0012H\u0016\u00a8\u0006\u0018"}, d2={"Lnet/thebrokenscript/client/renderer/entity/circuit/CapeLayer;", "Lnet/minecraft/client/renderer/entity/layers/RenderLayer;", "Lnet/thebrokenscript/entity/circuit/FakePlayerEntity;", "Lnet/minecraft/client/model/PlayerModel;", "renderer", "Lnet/minecraft/client/renderer/entity/RenderLayerParent;", "<init>", "(Lnet/minecraft/client/renderer/entity/RenderLayerParent;)V", "render", "", "poseStack", "Lcom/mojang/blaze3d/vertex/PoseStack;", "buffer", "Lnet/minecraft/client/renderer/MultiBufferSource;", "packedLight", "", "player", "limbSwing", "", "limbSwingAmount", "partialTicks", "ageInTicks", "netHeadYaw", "headPitch", "thebrokenscript-common"})
public final class CapeLayer
extends RenderLayer<FakePlayerEntity, PlayerModel<FakePlayerEntity>> {
    public CapeLayer(@NotNull RenderLayerParent<FakePlayerEntity, PlayerModel<FakePlayerEntity>> renderer) {
        Intrinsics.checkNotNullParameter(renderer, (String)"renderer");
        super(renderer);
    }

    public void render(@NotNull PoseStack poseStack, @NotNull MultiBufferSource buffer, int packedLight, @NotNull FakePlayerEntity player, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        ItemStack chest;
        PlayerSkin skin;
        Intrinsics.checkNotNullParameter((Object)poseStack, (String)"poseStack");
        Intrinsics.checkNotNullParameter((Object)buffer, (String)"buffer");
        Intrinsics.checkNotNullParameter((Object)((Object)player), (String)"player");
        if (!player.isInvisible() && player.isModelPartShown(PlayerModelPart.CAPE) && (skin = player.getSkin()).capeTexture() != null && !(chest = player.getItemBySlot(EquipmentSlot.CHEST)).is(Items.ELYTRA)) {
            poseStack.pushPose();
            poseStack.translate(0.0f, 0.0f, 0.125f);
            float dx = MathUtilKt.lerpf((float)partialTicks, (Number)player.getXCloakO(), (Number)player.getXCloak()) - MathUtilKt.lerpf((float)partialTicks, (Number)player.xo, (Number)player.getX());
            float dy = MathUtilKt.lerpf((float)partialTicks, (Number)player.getYCloakO(), (Number)player.getYCloak()) - MathUtilKt.lerpf((float)partialTicks, (Number)player.yo, (Number)player.getY());
            float dz = MathUtilKt.lerpf((float)partialTicks, (Number)player.getZCloakO(), (Number)player.getZCloak()) - MathUtilKt.lerpf((float)partialTicks, (Number)player.zo, (Number)player.getZ());
            float dRot = Mth.rotLerp((float)partialTicks, (float)player.yBodyRotO, (float)player.yBodyRot);
            double dRotY = Mth.sin((float)(dRot * ((float)Math.PI / 180)));
            double dRotX = -Mth.cos((float)(dRot * ((float)Math.PI / 180)));
            float f1 = ((Number)((Object)MathUtilKt.clamp((Comparable)Float.valueOf(dy * 10.0f), (Comparable)Float.valueOf(-6.0f), (Comparable)Float.valueOf(32.0f)))).floatValue();
            float f2 = ((Number)((Object)MathUtilKt.clamp((Comparable)Float.valueOf((float)((double)dx * dRotY + (double)dz * dRotX) * 100.0f), (Comparable)Float.valueOf(0.0f), (Comparable)Float.valueOf(150.0f)))).floatValue();
            float f3 = ((Number)((Object)MathUtilKt.clamp((Comparable)Float.valueOf((float)((double)dx * dRotX - (double)dz * dRotY) * 100.0f), (Comparable)Float.valueOf(-20.0f), (Comparable)Float.valueOf(20.0f)))).floatValue();
            if (f2 < 0.0f) {
                f2 = 0.0f;
            }
            float dBob = MathUtilKt.lerpf((float)partialTicks, (Number)Float.valueOf(player.getOBob()), (Number)Float.valueOf(player.getBob()));
            f1 += (float)Math.sin(MathUtilKt.lerpf((float)partialTicks, (Number)Float.valueOf(player.walkDistO), (Number)Float.valueOf(player.walkDist)) * 6.0f) * 32.0f * dBob;
            if (player.isCrouching()) {
                f1 += 25.0f;
            }
            poseStack.mulPose(Axis.XP.rotationDegrees(6.0f + f2 / 2.0f + f1));
            poseStack.mulPose(Axis.ZP.rotationDegrees(f3 / 2.0f));
            poseStack.mulPose(Axis.YP.rotationDegrees(180.0f - f3 / 2.0f));
            VertexConsumer cons = buffer.getBuffer(RenderType.entitySolid((ResourceLocation)skin.capeTexture()));
            ((PlayerModel)this.getParentModel()).renderCloak(poseStack, cons, packedLight, OverlayTexture.NO_OVERLAY);
            poseStack.popPose();
        }
    }
}

