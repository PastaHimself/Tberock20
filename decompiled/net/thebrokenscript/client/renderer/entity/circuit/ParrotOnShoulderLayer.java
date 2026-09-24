/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.vertex.PoseStack
 *  com.mojang.blaze3d.vertex.VertexConsumer
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.client.model.ParrotModel
 *  net.minecraft.client.model.PlayerModel
 *  net.minecraft.client.model.geom.EntityModelSet
 *  net.minecraft.client.model.geom.ModelLayers
 *  net.minecraft.client.renderer.MultiBufferSource
 *  net.minecraft.client.renderer.entity.ParrotRenderer
 *  net.minecraft.client.renderer.entity.RenderLayerParent
 *  net.minecraft.client.renderer.entity.layers.RenderLayer
 *  net.minecraft.client.renderer.texture.OverlayTexture
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.animal.Parrot$Variant
 *  net.thebrokenscript.brokencore.api.util.Side
 *  net.thebrokenscript.brokencore.api.util.SideOnly
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.client.renderer.entity.circuit;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.model.ParrotModel;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.ParrotRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.Parrot;
import net.thebrokenscript.brokencore.api.util.Side;
import net.thebrokenscript.brokencore.api.util.SideOnly;
import net.thebrokenscript.entity.circuit.FakePlayerEntity;
import org.jetbrains.annotations.NotNull;

@SideOnly(side=Side.CLIENT)
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000R\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u0014\u0012\u0004\u0012\u0002H\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u00040\u0003B)\u0012\u0018\u0010\u0005\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00040\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0004\b\t\u0010\nJ]\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00028\u00002\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u0017H\u0016\u00a2\u0006\u0002\u0010\u001dJU\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00028\u00002\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u001fH\u0002\u00a2\u0006\u0002\u0010 R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006!"}, d2={"Lnet/thebrokenscript/client/renderer/entity/circuit/ParrotOnShoulderLayer;", "T", "Lnet/thebrokenscript/entity/circuit/FakePlayerEntity;", "Lnet/minecraft/client/renderer/entity/layers/RenderLayer;", "Lnet/minecraft/client/model/PlayerModel;", "renderer", "Lnet/minecraft/client/renderer/entity/RenderLayerParent;", "modelSet", "Lnet/minecraft/client/model/geom/EntityModelSet;", "<init>", "(Lnet/minecraft/client/renderer/entity/RenderLayerParent;Lnet/minecraft/client/model/geom/EntityModelSet;)V", "model", "Lnet/minecraft/client/model/ParrotModel;", "render", "", "poseStack", "Lcom/mojang/blaze3d/vertex/PoseStack;", "buffer", "Lnet/minecraft/client/renderer/MultiBufferSource;", "packedLight", "", "livingEntity", "limbSwing", "", "limbSwingAmount", "partialTicks", "ageInTicks", "netHeadYaw", "headPitch", "(Lcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/MultiBufferSource;ILnet/thebrokenscript/entity/circuit/FakePlayerEntity;FFFFFF)V", "leftShoulder", "", "(Lcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/MultiBufferSource;ILnet/thebrokenscript/entity/circuit/FakePlayerEntity;FFFFZ)V", "thebrokenscript-common"})
public final class ParrotOnShoulderLayer<T extends FakePlayerEntity>
extends RenderLayer<T, PlayerModel<T>> {
    @NotNull
    private final ParrotModel model;

    public ParrotOnShoulderLayer(@NotNull RenderLayerParent<T, PlayerModel<T>> renderer, @NotNull EntityModelSet modelSet) {
        Intrinsics.checkNotNullParameter(renderer, (String)"renderer");
        Intrinsics.checkNotNullParameter((Object)modelSet, (String)"modelSet");
        super(renderer);
        this.model = new ParrotModel(modelSet.bakeLayer(ModelLayers.PARROT));
    }

    public void render(@NotNull PoseStack poseStack, @NotNull MultiBufferSource buffer, int packedLight, @NotNull T livingEntity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        Intrinsics.checkNotNullParameter((Object)poseStack, (String)"poseStack");
        Intrinsics.checkNotNullParameter((Object)buffer, (String)"buffer");
        Intrinsics.checkNotNullParameter(livingEntity, (String)"livingEntity");
        this.render(poseStack, buffer, packedLight, livingEntity, limbSwing, limbSwingAmount, netHeadYaw, headPitch, true);
        this.render(poseStack, buffer, packedLight, livingEntity, limbSwing, limbSwingAmount, netHeadYaw, headPitch, false);
    }

    private final void render(PoseStack poseStack, MultiBufferSource buffer, int packedLight, T livingEntity, float limbSwing, float limbSwingAmount, float netHeadYaw, float headPitch, boolean leftShoulder) {
        CompoundTag tag = leftShoulder ? ((FakePlayerEntity)((Object)livingEntity)).getShoulderEntityLeft() : ((FakePlayerEntity)((Object)livingEntity)).getShoulderEntityRight();
        EntityType.byString((String)tag.getString("id")).filter(arg_0 -> ParrotOnShoulderLayer.render$lambda$1(ParrotOnShoulderLayer::render$lambda$0, arg_0)).ifPresent(arg_0 -> ParrotOnShoulderLayer.render$lambda$3(arg_0 -> ParrotOnShoulderLayer.render$lambda$2(poseStack, leftShoulder, livingEntity, tag, buffer, this, packedLight, limbSwing, limbSwingAmount, netHeadYaw, headPitch, arg_0), arg_0));
    }

    private static final boolean render$lambda$0(EntityType it) {
        return Intrinsics.areEqual((Object)it, (Object)EntityType.PARROT);
    }

    private static final boolean render$lambda$1(Function1 $tmp0, Object p0) {
        return (Boolean)$tmp0.invoke(p0);
    }

    private static final Unit render$lambda$2(PoseStack $poseStack, boolean $leftShoulder, FakePlayerEntity $livingEntity, CompoundTag $tag, MultiBufferSource $buffer, ParrotOnShoulderLayer this$0, int $packedLight, float $limbSwing, float $limbSwingAmount, float $netHeadYaw, float $headPitch, EntityType it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        $poseStack.pushPose();
        $poseStack.translate($leftShoulder ? 0.4f : -0.4f, ((Entity)$livingEntity).isCrouching() ? -1.3f : -1.5f, 0.0f);
        Parrot.Variant variant = Parrot.Variant.byId((int)$tag.getInt("Variant"));
        VertexConsumer cons = $buffer.getBuffer(this$0.model.renderType(ParrotRenderer.getVariantTexture((Parrot.Variant)variant)));
        this$0.model.renderOnShoulder($poseStack, cons, $packedLight, OverlayTexture.NO_OVERLAY, $limbSwing, $limbSwingAmount, $netHeadYaw, $headPitch, $livingEntity.tickCount);
        $poseStack.popPose();
        return Unit.INSTANCE;
    }

    private static final void render$lambda$3(Function1 $tmp0, Object p0) {
        $tmp0.invoke(p0);
    }
}

