/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.vertex.PoseStack
 *  com.mojang.math.Axis
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.client.model.HumanoidModel
 *  net.minecraft.client.model.PlayerModel
 *  net.minecraft.client.model.geom.ModelLayers
 *  net.minecraft.client.renderer.MultiBufferSource
 *  net.minecraft.client.renderer.entity.EntityRendererProvider$Context
 *  net.minecraft.client.renderer.entity.HumanoidMobRenderer
 *  net.minecraft.client.renderer.entity.RenderLayerParent
 *  net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer
 *  net.minecraft.client.renderer.entity.layers.RenderLayer
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.LivingEntity
 *  net.thebrokenscript.brokencore.api.entity.base.BaseMonster
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.client.renderer.entity.entnull;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.thebrokenscript.api.TBSConstants;
import net.thebrokenscript.brokencore.api.entity.base.BaseMonster;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000N\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u0014\u0012\u0004\u0012\u0002H\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u00040\u0003B/\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u00a2\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00028\u0000H\u0016\u00a2\u0006\u0002\u0010\u0011J=\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00028\u00002\u0006\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016\u00a2\u0006\u0002\u0010\u001cJ=\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00028\u00002\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\t2\u0006\u0010 \u001a\u00020\tH\u0014\u00a2\u0006\u0002\u0010!R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\""}, d2={"Lnet/thebrokenscript/client/renderer/entity/entnull/NullRenderer;", "T", "Lnet/thebrokenscript/brokencore/api/entity/base/BaseMonster;", "Lnet/minecraft/client/renderer/entity/HumanoidMobRenderer;", "Lnet/minecraft/client/model/PlayerModel;", "context", "Lnet/minecraft/client/renderer/entity/EntityRendererProvider$Context;", "model", "shadowRadius", "", "texturePath", "", "<init>", "(Lnet/minecraft/client/renderer/entity/EntityRendererProvider$Context;Lnet/minecraft/client/model/PlayerModel;FLjava/lang/String;)V", "getTextureLocation", "Lnet/minecraft/resources/ResourceLocation;", "entity", "(Lnet/thebrokenscript/brokencore/api/entity/base/BaseMonster;)Lnet/minecraft/resources/ResourceLocation;", "render", "", "entityYaw", "partialTick", "poseStack", "Lcom/mojang/blaze3d/vertex/PoseStack;", "buffer", "Lnet/minecraft/client/renderer/MultiBufferSource;", "packedLight", "", "(Lnet/thebrokenscript/brokencore/api/entity/base/BaseMonster;FFLcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/MultiBufferSource;I)V", "setupRotations", "bob", "yBodyRot", "scale", "(Lnet/thebrokenscript/brokencore/api/entity/base/BaseMonster;Lcom/mojang/blaze3d/vertex/PoseStack;FFFF)V", "thebrokenscript-common"})
public final class NullRenderer<T extends BaseMonster>
extends HumanoidMobRenderer<T, PlayerModel<T>> {
    @NotNull
    private final String texturePath;

    public NullRenderer(@NotNull EntityRendererProvider.Context context, @NotNull PlayerModel<T> model2, float shadowRadius, @NotNull String texturePath) {
        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
        Intrinsics.checkNotNullParameter(model2, (String)"model");
        Intrinsics.checkNotNullParameter((Object)texturePath, (String)"texturePath");
        super(context, (HumanoidModel)model2, shadowRadius);
        this.texturePath = texturePath;
        this.addLayer((RenderLayer)new HumanoidArmorLayer((RenderLayerParent)this, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_INNER_ARMOR)), new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_OUTER_ARMOR)), context.getModelManager()));
    }

    public /* synthetic */ NullRenderer(EntityRendererProvider.Context context, PlayerModel playerModel, float f, String string, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 4) != 0) {
            f = 0.5f;
        }
        this(context, playerModel, f, string);
    }

    @NotNull
    public ResourceLocation getTextureLocation(@NotNull T entity) {
        Intrinsics.checkNotNullParameter(entity, (String)"entity");
        return TBSConstants.id(this.texturePath);
    }

    public void render(@NotNull T entity, float entityYaw, float partialTick, @NotNull PoseStack poseStack, @NotNull MultiBufferSource buffer, int packedLight) {
        Intrinsics.checkNotNullParameter(entity, (String)"entity");
        Intrinsics.checkNotNullParameter((Object)poseStack, (String)"poseStack");
        Intrinsics.checkNotNullParameter((Object)buffer, (String)"buffer");
        ((PlayerModel)this.model).swimAmount = ((LivingEntity)entity).getSwimAmount(partialTick);
        super.render((LivingEntity)entity, entityYaw, partialTick, poseStack, buffer, packedLight);
    }

    protected void setupRotations(@NotNull T entity, @NotNull PoseStack poseStack, float bob, float yBodyRot, float partialTick, float scale) {
        Intrinsics.checkNotNullParameter(entity, (String)"entity");
        Intrinsics.checkNotNullParameter((Object)poseStack, (String)"poseStack");
        super.setupRotations((LivingEntity)entity, poseStack, bob, yBodyRot, partialTick, scale);
        float swimAmount = ((LivingEntity)entity).getSwimAmount(partialTick);
        if (swimAmount > 0.0f) {
            float halfHeight = ((Entity)entity).getBbHeight() / 2.0f;
            poseStack.translate(0.0f, halfHeight, 0.0f);
            poseStack.mulPose(Axis.XP.rotationDegrees(swimAmount * -90.0f));
            poseStack.translate(0.0f, -halfHeight, 0.0f);
        }
    }
}

