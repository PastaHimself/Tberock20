/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.vertex.PoseStack
 *  com.mojang.blaze3d.vertex.VertexConsumer
 *  net.minecraft.client.renderer.LevelRenderer
 *  net.minecraft.client.renderer.entity.EntityRenderDispatcher
 *  net.minecraft.util.Mth
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.phys.AABB
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package net.thebrokenscript.brokencore.impl.mixin.features.multipart;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.client.renderer.entity.EntityRenderDispatcher;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.phys.AABB;
import net.thebrokenscript.brokencore.api.entity.multipart.MultipartEntity;
import net.thebrokenscript.brokencore.api.entity.multipart.MultipartEntityPart;
import net.thebrokenscript.brokencore.api.entity.multipart.MultipartSubEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={EntityRenderDispatcher.class})
public class EntityRenderDispatcherMixin {
    @Inject(method={"renderHitbox"}, at={@At(value="INVOKE", target="Lnet/minecraft/client/renderer/LevelRenderer;renderLineBox(Lcom/mojang/blaze3d/vertex/PoseStack;Lcom/mojang/blaze3d/vertex/VertexConsumer;Lnet/minecraft/world/phys/AABB;FFFF)V")})
    private static void bc$renderMultipartBoxes(PoseStack poseStack, VertexConsumer buffer, Entity p_entity, float red, float green, float blue, float alpha, CallbackInfo ci) {
        if (p_entity instanceof MultipartEntity) {
            double zOffs;
            double yOffs;
            double xOffs;
            MultipartEntity mpe = (MultipartEntity)p_entity;
            double x = -Mth.lerp((double)red, (double)p_entity.xOld, (double)p_entity.getX());
            double y = -Mth.lerp((double)red, (double)p_entity.yOld, (double)p_entity.getY());
            double z = -Mth.lerp((double)red, (double)p_entity.zOld, (double)p_entity.getZ());
            for (MultipartEntityPart<?> multipartEntityPart : mpe.getParts()) {
                poseStack.pushPose();
                xOffs = x + Mth.lerp((double)red, (double)multipartEntityPart.xOld, (double)multipartEntityPart.getX());
                yOffs = y + Mth.lerp((double)red, (double)multipartEntityPart.yOld, (double)multipartEntityPart.getY());
                zOffs = z + Mth.lerp((double)red, (double)multipartEntityPart.zOld, (double)multipartEntityPart.getZ());
                poseStack.translate(xOffs, yOffs, zOffs);
                LevelRenderer.renderLineBox((PoseStack)poseStack, (VertexConsumer)buffer, (AABB)multipartEntityPart.getBoundingBox().move(-multipartEntityPart.getX(), -multipartEntityPart.getY(), -multipartEntityPart.getZ()), (float)0.25f, (float)1.0f, (float)0.0f, (float)1.0f);
                poseStack.popPose();
            }
            for (MultipartSubEntity multipartSubEntity : mpe.getSubEntities()) {
                poseStack.pushPose();
                xOffs = x + Mth.lerp((double)red, (double)multipartSubEntity.xOld, (double)multipartSubEntity.getX());
                yOffs = y + Mth.lerp((double)red, (double)multipartSubEntity.yOld, (double)multipartSubEntity.getY());
                zOffs = z + Mth.lerp((double)red, (double)multipartSubEntity.zOld, (double)multipartSubEntity.getZ());
                poseStack.translate(multipartSubEntity.getX(), multipartSubEntity.getY(), multipartSubEntity.getZ());
                LevelRenderer.renderLineBox((PoseStack)poseStack, (VertexConsumer)buffer, (AABB)multipartSubEntity.getBoundingBox().move(-multipartSubEntity.getX() + x, -multipartSubEntity.getY() + y, -multipartSubEntity.getZ() + z), (float)0.0f, (float)0.0f, (float)1.0f, (float)1.0f);
                poseStack.popPose();
            }
        }
    }
}

