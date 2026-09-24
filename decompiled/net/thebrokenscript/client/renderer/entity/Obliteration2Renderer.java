/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.vertex.PoseStack
 *  com.mojang.blaze3d.vertex.VertexConsumer
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.client.renderer.MultiBufferSource
 *  net.minecraft.client.renderer.RenderType
 *  net.minecraft.client.renderer.culling.Frustum
 *  net.minecraft.client.renderer.entity.EntityRendererProvider$Context
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.world.entity.Entity
 *  net.thebrokenscript.brokencore.api.util.Side
 *  net.thebrokenscript.brokencore.api.util.SideOnly
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
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.thebrokenscript.brokencore.api.util.Side;
import net.thebrokenscript.brokencore.api.util.SideOnly;
import net.thebrokenscript.client.model.entity.Obliteration2Model;
import net.thebrokenscript.entity.oblit.Obliteration2Entity;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

@SideOnly(side=Side.CLIENT)
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0005\u0010\u0006Jd\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0019H\u0016J0\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020 H\u0016J.\u0010#\u001a\u0004\u0018\u00010\u000f2\u0006\u0010$\u001a\u00020\u00022\b\u0010%\u001a\u0004\u0018\u00010&2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010'\u001a\u00020\u0017H\u0016\u00a8\u0006("}, d2={"Lnet/thebrokenscript/client/renderer/entity/Obliteration2Renderer;", "Lsoftware/bernie/geckolib/renderer/GeoEntityRenderer;", "Lnet/thebrokenscript/entity/oblit/Obliteration2Entity;", "renderManager", "Lnet/minecraft/client/renderer/entity/EntityRendererProvider$Context;", "<init>", "(Lnet/minecraft/client/renderer/entity/EntityRendererProvider$Context;)V", "actuallyRender", "", "poseStack", "Lcom/mojang/blaze3d/vertex/PoseStack;", "entity", "model", "Lsoftware/bernie/geckolib/cache/object/BakedGeoModel;", "renderType", "Lnet/minecraft/client/renderer/RenderType;", "bufferSource", "Lnet/minecraft/client/renderer/MultiBufferSource;", "buffer", "Lcom/mojang/blaze3d/vertex/VertexConsumer;", "isReRender", "", "partialTicks", "", "packedLight", "", "packedOverlay", "colour", "shouldRender", "frustum", "Lnet/minecraft/client/renderer/culling/Frustum;", "x", "", "y", "z", "getRenderType", "animatable", "texture", "Lnet/minecraft/resources/ResourceLocation;", "partialTick", "thebrokenscript-common"})
public final class Obliteration2Renderer
extends GeoEntityRenderer<Obliteration2Entity> {
    public Obliteration2Renderer(@NotNull EntityRendererProvider.Context renderManager) {
        Intrinsics.checkNotNullParameter((Object)renderManager, (String)"renderManager");
        super(renderManager, (GeoModel)new Obliteration2Model());
        this.shadowRadius = 1.5f;
    }

    public void actuallyRender(@NotNull PoseStack poseStack, @NotNull Obliteration2Entity entity, @NotNull BakedGeoModel model2, @Nullable RenderType renderType, @NotNull MultiBufferSource bufferSource, @Nullable VertexConsumer buffer, boolean isReRender, float partialTicks, int packedLight, int packedOverlay, int colour) {
        Intrinsics.checkNotNullParameter((Object)poseStack, (String)"poseStack");
        Intrinsics.checkNotNullParameter((Object)((Object)entity), (String)"entity");
        Intrinsics.checkNotNullParameter((Object)model2, (String)"model");
        Intrinsics.checkNotNullParameter((Object)bufferSource, (String)"bufferSource");
        poseStack.pushPose();
        super.actuallyRender(poseStack, (Entity)entity, model2, renderType, bufferSource, buffer, isReRender, partialTicks, packedLight, packedOverlay, colour);
        poseStack.popPose();
    }

    public boolean shouldRender(@NotNull Obliteration2Entity entity, @NotNull Frustum frustum, double x, double y, double z) {
        Intrinsics.checkNotNullParameter((Object)((Object)entity), (String)"entity");
        Intrinsics.checkNotNullParameter((Object)frustum, (String)"frustum");
        return true;
    }

    @Nullable
    public RenderType getRenderType(@NotNull Obliteration2Entity animatable, @Nullable ResourceLocation texture, @Nullable MultiBufferSource bufferSource, float partialTick) {
        Intrinsics.checkNotNullParameter((Object)((Object)animatable), (String)"animatable");
        return RenderType.entityTranslucent((ResourceLocation)this.getTextureLocation((Entity)animatable));
    }
}

