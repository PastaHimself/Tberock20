/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.vertex.PoseStack
 *  com.mojang.math.Axis
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.client.model.CodModel
 *  net.minecraft.client.model.EntityModel
 *  net.minecraft.client.model.geom.ModelLayers
 *  net.minecraft.client.renderer.entity.EntityRendererProvider$Context
 *  net.minecraft.client.renderer.entity.MobRenderer
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.util.Mth
 *  net.minecraft.world.entity.LivingEntity
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.client.renderer.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.model.CodModel;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;
import net.thebrokenscript.api.TBSConstants;
import net.thebrokenscript.entity.NullCodEntity;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00030\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0002H\u0016J8\u0010\u000b\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0010H\u0014\u00a8\u0006\u0014"}, d2={"Lnet/thebrokenscript/client/renderer/entity/NullCodRenderer;", "Lnet/minecraft/client/renderer/entity/MobRenderer;", "Lnet/thebrokenscript/entity/NullCodEntity;", "Lnet/minecraft/client/model/CodModel;", "context", "Lnet/minecraft/client/renderer/entity/EntityRendererProvider$Context;", "<init>", "(Lnet/minecraft/client/renderer/entity/EntityRendererProvider$Context;)V", "getTextureLocation", "Lnet/minecraft/resources/ResourceLocation;", "entity", "setupRotations", "", "poseStack", "Lcom/mojang/blaze3d/vertex/PoseStack;", "bob", "", "yBodyRot", "partialTick", "scale", "thebrokenscript-common"})
public final class NullCodRenderer
extends MobRenderer<NullCodEntity, CodModel<NullCodEntity>> {
    public NullCodRenderer(@NotNull EntityRendererProvider.Context context) {
        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
        super(context, (EntityModel)new CodModel(context.bakeLayer(ModelLayers.COD)), 0.3f);
    }

    @NotNull
    public ResourceLocation getTextureLocation(@NotNull NullCodEntity entity) {
        Intrinsics.checkNotNullParameter((Object)((Object)entity), (String)"entity");
        return TBSConstants.id("textures/entities/null_cod.png");
    }

    protected void setupRotations(@NotNull NullCodEntity entity, @NotNull PoseStack poseStack, float bob, float yBodyRot, float partialTick, float scale) {
        Intrinsics.checkNotNullParameter((Object)((Object)entity), (String)"entity");
        Intrinsics.checkNotNullParameter((Object)poseStack, (String)"poseStack");
        super.setupRotations((LivingEntity)entity, poseStack, bob, yBodyRot, partialTick, scale);
        float f = 4.3f * Mth.sin((float)(0.6f * bob));
        poseStack.mulPose(Axis.YP.rotationDegrees(f));
        if (!entity.isInWater()) {
            poseStack.translate(0.1f, 0.1f, -0.1f);
            poseStack.mulPose(Axis.ZP.rotationDegrees(90.0f));
        }
    }
}

