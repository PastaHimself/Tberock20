/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.vertex.PoseStack
 *  com.mojang.blaze3d.vertex.VertexConsumer
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.client.renderer.MultiBufferSource
 *  net.minecraft.client.renderer.RenderType
 *  net.minecraft.client.renderer.entity.EntityRendererProvider$Context
 *  net.minecraft.world.entity.Entity
 *  net.thebrokenscript.brokencore.api.ext.PoseStackExt
 *  net.thebrokenscript.brokencore.api.ext.RenderExtKt
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  software.bernie.geckolib.cache.object.BakedGeoModel
 *  software.bernie.geckolib.model.GeoModel
 *  software.bernie.geckolib.renderer.GeoEntityRenderer
 */
package net.thebrokenscript.client.renderer.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.world.entity.Entity;
import net.thebrokenscript.brokencore.api.ext.PoseStackExt;
import net.thebrokenscript.brokencore.api.ext.RenderExtKt;
import net.thebrokenscript.client.model.entity.JonModel;
import net.thebrokenscript.entity.misc.JonEntity;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0005\u0010\u0006Jf\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0019H\u0016\u00a8\u0006\u001c"}, d2={"Lnet/thebrokenscript/client/renderer/entity/JonRenderer;", "Lsoftware/bernie/geckolib/renderer/GeoEntityRenderer;", "Lnet/thebrokenscript/entity/misc/JonEntity;", "renderManager", "Lnet/minecraft/client/renderer/entity/EntityRendererProvider$Context;", "<init>", "(Lnet/minecraft/client/renderer/entity/EntityRendererProvider$Context;)V", "actuallyRender", "", "poseStack", "Lcom/mojang/blaze3d/vertex/PoseStack;", "animatable", "model", "Lsoftware/bernie/geckolib/cache/object/BakedGeoModel;", "renderType", "Lnet/minecraft/client/renderer/RenderType;", "bufferSource", "Lnet/minecraft/client/renderer/MultiBufferSource;", "buffer", "Lcom/mojang/blaze3d/vertex/VertexConsumer;", "isReRender", "", "partialTick", "", "packedLight", "", "packedOverlay", "colour", "thebrokenscript-common"})
public final class JonRenderer
extends GeoEntityRenderer<JonEntity> {
    public JonRenderer(@NotNull EntityRendererProvider.Context renderManager) {
        Intrinsics.checkNotNullParameter((Object)renderManager, (String)"renderManager");
        super(renderManager, (GeoModel)new JonModel());
        this.shadowRadius = 0.5f;
    }

    public void actuallyRender(@NotNull PoseStack poseStack, @NotNull JonEntity animatable, @NotNull BakedGeoModel model2, @Nullable RenderType renderType, @Nullable MultiBufferSource bufferSource, @Nullable VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, int colour) {
        Intrinsics.checkNotNullParameter((Object)poseStack, (String)"poseStack");
        Intrinsics.checkNotNullParameter((Object)((Object)animatable), (String)"animatable");
        Intrinsics.checkNotNullParameter((Object)model2, (String)"model");
        RenderExtKt.pushPop((PoseStack)poseStack, () -> JonRenderer.actuallyRender$lambda$0(poseStack, this, animatable, model2, renderType, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, colour));
    }

    private static final Unit actuallyRender$lambda$0(PoseStack $poseStack, JonRenderer this$0, JonEntity $animatable, BakedGeoModel $model, RenderType $renderType, MultiBufferSource $bufferSource, VertexConsumer $buffer, boolean $isReRender, float $partialTick, int $packedLight, int $packedOverlay, int $colour) {
        PoseStackExt.INSTANCE.scale($poseStack, (Number)Float.valueOf(1.2f));
        super.actuallyRender($poseStack, (Entity)$animatable, $model, $renderType, $bufferSource, $buffer, $isReRender, $partialTick, $packedLight, $packedOverlay, $colour);
        return Unit.INSTANCE;
    }
}

