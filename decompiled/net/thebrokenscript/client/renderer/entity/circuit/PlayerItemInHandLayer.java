/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.vertex.PoseStack
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.client.model.EntityModel
 *  net.minecraft.client.model.HeadedModel
 *  net.minecraft.client.model.geom.ModelPart
 *  net.minecraft.client.renderer.ItemInHandRenderer
 *  net.minecraft.client.renderer.MultiBufferSource
 *  net.minecraft.client.renderer.entity.RenderLayerParent
 *  net.minecraft.client.renderer.entity.layers.CustomHeadLayer
 *  net.minecraft.client.renderer.entity.layers.ItemInHandLayer
 *  net.minecraft.util.Mth
 *  net.minecraft.world.entity.HumanoidArm
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.item.ItemDisplayContext
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.item.Items
 *  net.thebrokenscript.brokencore.api.util.Side
 *  net.thebrokenscript.brokencore.api.util.SideOnly
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.client.renderer.entity.circuit;

import com.mojang.blaze3d.vertex.PoseStack;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.HeadedModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.ItemInHandRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.CustomHeadLayer;
import net.minecraft.client.renderer.entity.layers.ItemInHandLayer;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.thebrokenscript.brokencore.api.util.Side;
import net.thebrokenscript.brokencore.api.util.SideOnly;
import net.thebrokenscript.entity.circuit.FakePlayerEntity;
import org.jetbrains.annotations.NotNull;

@SideOnly(side=Side.CLIENT)
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000^\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0007\u0018\u0000 \"*\b\b\u0000\u0010\u0001*\u00020\u0002*\u0016\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00010\u0004*\u00020\u0005*\u00020\u00062\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u0007:\u0001\"B#\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u00a2\u0006\u0004\b\f\u0010\rJ@\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0014J8\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020\u00112\u0006\u0010 \u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010!\u001a\u00020\u001dH\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006#"}, d2={"Lnet/thebrokenscript/client/renderer/entity/circuit/PlayerItemInHandLayer;", "T", "Lnet/thebrokenscript/entity/circuit/FakePlayerEntity;", "M", "Lnet/minecraft/client/model/EntityModel;", "Lnet/minecraft/client/model/ArmedModel;", "Lnet/minecraft/client/model/HeadedModel;", "Lnet/minecraft/client/renderer/entity/layers/ItemInHandLayer;", "renderer", "Lnet/minecraft/client/renderer/entity/RenderLayerParent;", "itemInHandRenderer", "Lnet/minecraft/client/renderer/ItemInHandRenderer;", "<init>", "(Lnet/minecraft/client/renderer/entity/RenderLayerParent;Lnet/minecraft/client/renderer/ItemInHandRenderer;)V", "renderArmWithItem", "", "livingEntity", "Lnet/minecraft/world/entity/LivingEntity;", "itemStack", "Lnet/minecraft/world/item/ItemStack;", "displayContext", "Lnet/minecraft/world/item/ItemDisplayContext;", "arm", "Lnet/minecraft/world/entity/HumanoidArm;", "poseStack", "Lcom/mojang/blaze3d/vertex/PoseStack;", "buffer", "Lnet/minecraft/client/renderer/MultiBufferSource;", "packedLight", "", "renderArmWithSpyglass", "entity", "stack", "combinedLight", "Companion", "thebrokenscript-common"})
public final class PlayerItemInHandLayer<T extends FakePlayerEntity, M extends EntityModel<T> & HeadedModel>
extends ItemInHandLayer<T, M> {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final ItemInHandRenderer itemInHandRenderer;
    private static final float X_ROT_MIN = -0.5235988f;
    private static final float X_ROT_MAX = 1.5707964f;

    public PlayerItemInHandLayer(@NotNull RenderLayerParent<T, M> renderer, @NotNull ItemInHandRenderer itemInHandRenderer) {
        Intrinsics.checkNotNullParameter(renderer, (String)"renderer");
        Intrinsics.checkNotNullParameter((Object)itemInHandRenderer, (String)"itemInHandRenderer");
        super(renderer, itemInHandRenderer);
        this.itemInHandRenderer = itemInHandRenderer;
    }

    protected void renderArmWithItem(@NotNull LivingEntity livingEntity, @NotNull ItemStack itemStack, @NotNull ItemDisplayContext displayContext, @NotNull HumanoidArm arm, @NotNull PoseStack poseStack, @NotNull MultiBufferSource buffer, int packedLight) {
        Intrinsics.checkNotNullParameter((Object)livingEntity, (String)"livingEntity");
        Intrinsics.checkNotNullParameter((Object)itemStack, (String)"itemStack");
        Intrinsics.checkNotNullParameter((Object)displayContext, (String)"displayContext");
        Intrinsics.checkNotNullParameter((Object)arm, (String)"arm");
        Intrinsics.checkNotNullParameter((Object)poseStack, (String)"poseStack");
        Intrinsics.checkNotNullParameter((Object)buffer, (String)"buffer");
        if (itemStack.is(Items.SPYGLASS) && Intrinsics.areEqual((Object)livingEntity.getUseItem(), (Object)itemStack) && livingEntity.swingTime == 0) {
            this.renderArmWithSpyglass(livingEntity, itemStack, arm, poseStack, buffer, packedLight);
        } else {
            super.renderArmWithItem(livingEntity, itemStack, displayContext, arm, poseStack, buffer, packedLight);
        }
    }

    private final void renderArmWithSpyglass(LivingEntity entity, ItemStack stack, HumanoidArm arm, PoseStack poseStack, MultiBufferSource buffer, int combinedLight) {
        poseStack.pushPose();
        EntityModel entityModel = this.getParentModel();
        Intrinsics.checkNotNull((Object)entityModel, (String)"null cannot be cast to non-null type net.minecraft.client.model.HeadedModel");
        ModelPart part = ((HeadedModel)entityModel).getHead();
        float xRot = part.xRot;
        part.xRot = Mth.clamp((float)part.xRot, (float)-0.5235988f, (float)1.5707964f);
        part.translateAndRotate(poseStack);
        part.xRot = xRot;
        CustomHeadLayer.translateToHead((PoseStack)poseStack, (boolean)false);
        poseStack.translate((arm == HumanoidArm.LEFT ? -2.5f : 2.5f) / 16.0f, -0.0625f, 0.0f);
        this.itemInHandRenderer.renderItem(entity, stack, ItemDisplayContext.HEAD, false, poseStack, buffer, combinedLight);
        poseStack.popPose();
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0007"}, d2={"Lnet/thebrokenscript/client/renderer/entity/circuit/PlayerItemInHandLayer$Companion;", "", "<init>", "()V", "X_ROT_MIN", "", "X_ROT_MAX", "thebrokenscript-common"})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

