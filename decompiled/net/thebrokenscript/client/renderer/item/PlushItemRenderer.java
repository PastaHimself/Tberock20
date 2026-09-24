/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.vertex.PoseStack
 *  com.mojang.blaze3d.vertex.VertexConsumer
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.client.renderer.MultiBufferSource
 *  net.minecraft.world.item.Item
 *  net.minecraft.world.item.ItemDisplayContext
 *  net.minecraft.world.item.ItemStack
 *  net.thebrokenscript.brokencore.api.ext.PoseStackExt
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  org.joml.Quaternionf
 *  software.bernie.geckolib.cache.object.BakedGeoModel
 *  software.bernie.geckolib.model.GeoModel
 *  software.bernie.geckolib.renderer.GeoItemRenderer
 */
package net.thebrokenscript.client.renderer.item;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.thebrokenscript.brokencore.api.ext.PoseStackExt;
import net.thebrokenscript.client.model.plush.BasePlushModel;
import net.thebrokenscript.item.PlushItem;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.joml.Quaternionf;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoItemRenderer;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0005\u0010\u0006J8\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\\\u0010\u0016\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020\u0014H\u0016J:\u0010 \u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u001eH\u0014R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006!"}, d2={"Lnet/thebrokenscript/client/renderer/item/PlushItemRenderer;", "Lsoftware/bernie/geckolib/renderer/GeoItemRenderer;", "Lnet/thebrokenscript/item/PlushItem;", "name", "", "<init>", "(Ljava/lang/String;)V", "isGui", "", "renderByItem", "", "stack", "Lnet/minecraft/world/item/ItemStack;", "transformType", "Lnet/minecraft/world/item/ItemDisplayContext;", "poseStack", "Lcom/mojang/blaze3d/vertex/PoseStack;", "bufferSource", "Lnet/minecraft/client/renderer/MultiBufferSource;", "packedLight", "", "packedOverlay", "preRender", "animatable", "model", "Lsoftware/bernie/geckolib/cache/object/BakedGeoModel;", "buffer", "Lcom/mojang/blaze3d/vertex/VertexConsumer;", "isReRender", "partialTick", "", "colour", "renderInGui", "thebrokenscript-common"})
public final class PlushItemRenderer
extends GeoItemRenderer<PlushItem> {
    private boolean isGui;

    public PlushItemRenderer(@NotNull String name) {
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        super((GeoModel)new BasePlushModel(name));
    }

    public void renderByItem(@NotNull ItemStack stack, @NotNull ItemDisplayContext transformType, @NotNull PoseStack poseStack, @NotNull MultiBufferSource bufferSource, int packedLight, int packedOverlay) {
        Intrinsics.checkNotNullParameter((Object)stack, (String)"stack");
        Intrinsics.checkNotNullParameter((Object)transformType, (String)"transformType");
        Intrinsics.checkNotNullParameter((Object)poseStack, (String)"poseStack");
        Intrinsics.checkNotNullParameter((Object)bufferSource, (String)"bufferSource");
        if (transformType == ItemDisplayContext.HEAD) {
            poseStack.translate(0.0f, 0.15f, 0.5f);
            Quaternionf quat = new Quaternionf();
            quat.rotateX(-0.7853982f);
            poseStack.mulPose(quat);
        }
        super.renderByItem(stack, transformType, poseStack, bufferSource, packedLight, packedOverlay);
    }

    public void preRender(@NotNull PoseStack poseStack, @NotNull PlushItem animatable, @NotNull BakedGeoModel model2, @Nullable MultiBufferSource bufferSource, @Nullable VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, int colour) {
        Intrinsics.checkNotNullParameter((Object)poseStack, (String)"poseStack");
        Intrinsics.checkNotNullParameter((Object)((Object)animatable), (String)"animatable");
        Intrinsics.checkNotNullParameter((Object)model2, (String)"model");
        super.preRender(poseStack, (Item)animatable, model2, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, colour);
        if (this.isGui) {
            Quaternionf quat = new Quaternionf();
            quat.rotateY((float)Math.PI);
            poseStack.translate(0.0f, -0.4f, 0.0f);
            poseStack.mulPose(quat);
            PoseStackExt.INSTANCE.scale(poseStack, (Number)Float.valueOf(1.3f));
        } else {
            Quaternionf quat = new Quaternionf();
            quat.rotateX(0.7853982f);
            poseStack.mulPose(quat);
        }
    }

    protected void renderInGui(@NotNull ItemDisplayContext transformType, @NotNull PoseStack poseStack, @Nullable MultiBufferSource bufferSource, int packedLight, int packedOverlay, float partialTick) {
        Intrinsics.checkNotNullParameter((Object)transformType, (String)"transformType");
        Intrinsics.checkNotNullParameter((Object)poseStack, (String)"poseStack");
        this.isGui = true;
        super.renderInGui(transformType, poseStack, bufferSource, packedLight, packedOverlay, partialTick);
        this.isGui = false;
    }
}

