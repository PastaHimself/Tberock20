/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.vertex.PoseStack
 *  com.mojang.blaze3d.vertex.VertexConsumer
 *  kotlin.Metadata
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.client.renderer.MultiBufferSource
 *  net.minecraft.client.renderer.RenderType
 *  net.minecraft.client.renderer.texture.OverlayTexture
 *  net.minecraft.resources.ResourceLocation
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  software.bernie.geckolib.animatable.GeoAnimatable
 *  software.bernie.geckolib.cache.object.BakedGeoModel
 *  software.bernie.geckolib.renderer.GeoRenderer
 *  software.bernie.geckolib.renderer.layer.GeoRenderLayer
 */
package net.thebrokenscript.brokencore.api.entity.layer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoRenderer;
import software.bernie.geckolib.renderer.layer.GeoRenderLayer;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000R\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u0000 \u001d*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0001\u001dB\u001d\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\u00a2\u0006\u0004\b\b\u0010\tJY\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00028\u00002\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001aH\u0016\u00a2\u0006\u0002\u0010\u001cR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001e"}, d2={"Lnet/thebrokenscript/brokencore/api/entity/layer/BasicTexturedLayer;", "T", "Lsoftware/bernie/geckolib/animatable/GeoAnimatable;", "Lsoftware/bernie/geckolib/renderer/layer/GeoRenderLayer;", "texture", "Lnet/minecraft/resources/ResourceLocation;", "entityRendererIn", "Lsoftware/bernie/geckolib/renderer/GeoRenderer;", "<init>", "(Lnet/minecraft/resources/ResourceLocation;Lsoftware/bernie/geckolib/renderer/GeoRenderer;)V", "render", "", "poseStack", "Lcom/mojang/blaze3d/vertex/PoseStack;", "animatable", "bakedModel", "Lsoftware/bernie/geckolib/cache/object/BakedGeoModel;", "renderType", "Lnet/minecraft/client/renderer/RenderType;", "bufferSource", "Lnet/minecraft/client/renderer/MultiBufferSource;", "buffer", "Lcom/mojang/blaze3d/vertex/VertexConsumer;", "partialTick", "", "packedLight", "", "packedOverlay", "(Lcom/mojang/blaze3d/vertex/PoseStack;Lsoftware/bernie/geckolib/animatable/GeoAnimatable;Lsoftware/bernie/geckolib/cache/object/BakedGeoModel;Lnet/minecraft/client/renderer/RenderType;Lnet/minecraft/client/renderer/MultiBufferSource;Lcom/mojang/blaze3d/vertex/VertexConsumer;FII)V", "Companion", "brokencore-common"})
public final class BasicTexturedLayer<T extends GeoAnimatable>
extends GeoRenderLayer<T> {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final ResourceLocation texture;

    public BasicTexturedLayer(@NotNull ResourceLocation texture, @NotNull GeoRenderer<T> entityRendererIn) {
        Intrinsics.checkNotNullParameter((Object)texture, (String)"texture");
        Intrinsics.checkNotNullParameter(entityRendererIn, (String)"entityRendererIn");
        super(entityRendererIn);
        this.texture = texture;
    }

    public void render(@NotNull PoseStack poseStack, @NotNull T animatable, @NotNull BakedGeoModel bakedModel, @Nullable RenderType renderType, @NotNull MultiBufferSource bufferSource, @Nullable VertexConsumer buffer, float partialTick, int packedLight, int packedOverlay) {
        Intrinsics.checkNotNullParameter((Object)poseStack, (String)"poseStack");
        Intrinsics.checkNotNullParameter(animatable, (String)"animatable");
        Intrinsics.checkNotNullParameter((Object)bakedModel, (String)"bakedModel");
        Intrinsics.checkNotNullParameter((Object)bufferSource, (String)"bufferSource");
        RenderType glowRenderType = RenderType.eyes((ResourceLocation)this.texture);
        this.getRenderer().reRender(this.getDefaultBakedModel((GeoAnimatable)animatable), poseStack, bufferSource, animatable, glowRenderType, bufferSource.getBuffer(glowRenderType), partialTick, packedLight, OverlayTexture.NO_OVERLAY, 0xFFFFFF);
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J?\u0010\u0004\u001a)\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u0002H\u00070\u0006\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00070\u000b0\u0005\"\b\b\u0001\u0010\u0007*\u00020\f2\u0006\u0010\r\u001a\u00020\u000e\u00a8\u0006\u000f"}, d2={"Lnet/thebrokenscript/brokencore/api/entity/layer/BasicTexturedLayer$Companion;", "", "<init>", "()V", "create", "Lkotlin/Function1;", "Lsoftware/bernie/geckolib/renderer/GeoRenderer;", "T", "Lkotlin/ParameterName;", "name", "entityRendererIn", "Lnet/thebrokenscript/brokencore/api/entity/layer/BasicTexturedLayer;", "Lsoftware/bernie/geckolib/animatable/GeoAnimatable;", "id", "Lnet/minecraft/resources/ResourceLocation;", "brokencore-common"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final <T extends GeoAnimatable> Function1<GeoRenderer<T>, BasicTexturedLayer<T>> create(@NotNull ResourceLocation id) {
            Intrinsics.checkNotNullParameter((Object)id, (String)"id");
            return arg_0 -> Companion.create$lambda$0(id, arg_0);
        }

        private static final BasicTexturedLayer create$lambda$0(ResourceLocation $id, GeoRenderer it) {
            Intrinsics.checkNotNullParameter((Object)it, (String)"it");
            return new BasicTexturedLayer($id, it);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

