/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.vertex.PoseStack
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.client.renderer.entity.EntityRendererProvider$Context
 *  net.minecraft.world.entity.Entity
 *  net.thebrokenscript.brokencore.api.ext.PoseStackExt
 *  org.jetbrains.annotations.NotNull
 *  software.bernie.geckolib.model.GeoModel
 *  software.bernie.geckolib.renderer.GeoEntityRenderer
 */
package net.thebrokenscript.client.renderer.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.world.entity.Entity;
import net.thebrokenscript.brokencore.api.ext.PoseStackExt;
import net.thebrokenscript.client.model.entity.VoidTentacleModel;
import net.thebrokenscript.entity.boss.VoidTentacleEntity;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0005\u0010\u0006J8\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\rH\u0014\u00a8\u0006\u0011"}, d2={"Lnet/thebrokenscript/client/renderer/entity/VoidTentacleRenderer;", "Lsoftware/bernie/geckolib/renderer/GeoEntityRenderer;", "Lnet/thebrokenscript/entity/boss/VoidTentacleEntity;", "cx", "Lnet/minecraft/client/renderer/entity/EntityRendererProvider$Context;", "<init>", "(Lnet/minecraft/client/renderer/entity/EntityRendererProvider$Context;)V", "applyRotations", "", "animatable", "poseStack", "Lcom/mojang/blaze3d/vertex/PoseStack;", "ageInTicks", "", "rotationYaw", "partialTick", "nativeScale", "thebrokenscript-common"})
public final class VoidTentacleRenderer
extends GeoEntityRenderer<VoidTentacleEntity> {
    public VoidTentacleRenderer(@NotNull EntityRendererProvider.Context cx) {
        Intrinsics.checkNotNullParameter((Object)cx, (String)"cx");
        super(cx, (GeoModel)new VoidTentacleModel());
    }

    protected void applyRotations(@NotNull VoidTentacleEntity animatable, @NotNull PoseStack poseStack, float ageInTicks, float rotationYaw, float partialTick, float nativeScale) {
        Intrinsics.checkNotNullParameter((Object)((Object)animatable), (String)"animatable");
        Intrinsics.checkNotNullParameter((Object)poseStack, (String)"poseStack");
        super.applyRotations((Entity)animatable, poseStack, ageInTicks, rotationYaw, partialTick, nativeScale);
        PoseStackExt.INSTANCE.scale(poseStack, (Number)Float.valueOf(0.5f));
    }
}

