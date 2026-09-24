/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Deprecated
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.player.LocalPlayer
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.world.phys.Vec3
 *  net.thebrokenscript.brokencore.api.util.Side
 *  net.thebrokenscript.brokencore.api.util.SideOnly
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  software.bernie.geckolib.animatable.GeoAnimatable
 *  software.bernie.geckolib.animation.AnimationState
 *  software.bernie.geckolib.cache.object.GeoBone
 *  software.bernie.geckolib.model.GeoModel
 *  software.bernie.geckolib.renderer.GeoRenderer
 */
package net.thebrokenscript.client.model.entity;

import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.api.TBSConstants;
import net.thebrokenscript.brokencore.api.util.Side;
import net.thebrokenscript.brokencore.api.util.SideOnly;
import net.thebrokenscript.entity.boss.TetherEntity;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoRenderer;

@SideOnly(side=Side.CLIENT)
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0003\u0010\u0004J$\u0010\r\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\u00022\u0010\u0010\u000f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u0010H\u0016J\u0012\u0010\r\u001a\u00020\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002H\u0017J$\u0010\u0012\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\u00022\u0010\u0010\u000f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u0010H\u0016J\u0012\u0010\u0012\u001a\u00020\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002H\u0017J\u0010\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0002H\u0016J*\u0010\u0014\u001a\u00020\u00152\b\u0010\u000e\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0016\u001a\u00020\u00172\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0019H\u0016R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u0011\u0010\u000b\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\b\u00a8\u0006\u001a"}, d2={"Lnet/thebrokenscript/client/model/entity/TetherModel;", "Lsoftware/bernie/geckolib/model/GeoModel;", "Lnet/thebrokenscript/entity/boss/TetherEntity;", "<init>", "()V", "modelPath", "Lnet/minecraft/resources/ResourceLocation;", "getModelPath", "()Lnet/minecraft/resources/ResourceLocation;", "texturePath", "getTexturePath", "animationPath", "getAnimationPath", "getModelResource", "animatable", "renderer", "Lsoftware/bernie/geckolib/renderer/GeoRenderer;", "p0", "getTextureResource", "getAnimationResource", "setCustomAnimations", "", "instanceId", "", "animationState", "Lsoftware/bernie/geckolib/animation/AnimationState;", "thebrokenscript-common"})
public final class TetherModel
extends GeoModel<TetherEntity> {
    @NotNull
    private final ResourceLocation modelPath = TBSConstants.id("geo/tether.geo.json");
    @NotNull
    private final ResourceLocation texturePath = TBSConstants.id("textures/entities/tether.png");
    @NotNull
    private final ResourceLocation animationPath = TBSConstants.id("animations/tether.animation.json");

    @NotNull
    public final ResourceLocation getModelPath() {
        return this.modelPath;
    }

    @NotNull
    public final ResourceLocation getTexturePath() {
        return this.texturePath;
    }

    @NotNull
    public final ResourceLocation getAnimationPath() {
        return this.animationPath;
    }

    @NotNull
    public ResourceLocation getModelResource(@Nullable TetherEntity animatable, @Nullable GeoRenderer<TetherEntity> renderer) {
        return this.modelPath;
    }

    @Deprecated(message="Deprecated in Java")
    @NotNull
    public ResourceLocation getModelResource(@Nullable TetherEntity p0) {
        return this.modelPath;
    }

    @NotNull
    public ResourceLocation getTextureResource(@Nullable TetherEntity animatable, @Nullable GeoRenderer<TetherEntity> renderer) {
        return this.texturePath;
    }

    @Deprecated(message="Deprecated in Java")
    @NotNull
    public ResourceLocation getTextureResource(@Nullable TetherEntity p0) {
        return this.texturePath;
    }

    @NotNull
    public ResourceLocation getAnimationResource(@NotNull TetherEntity animatable) {
        Intrinsics.checkNotNullParameter((Object)((Object)animatable), (String)"animatable");
        return this.animationPath;
    }

    public void setCustomAnimations(@Nullable TetherEntity animatable, long instanceId, @Nullable AnimationState<TetherEntity> animationState) {
        super.setCustomAnimations((GeoAnimatable)animatable, instanceId, animationState);
        TetherEntity tetherEntity = animatable;
        if (tetherEntity == null) {
            return;
        }
        TetherEntity entity = tetherEntity;
        Minecraft mc = Minecraft.getInstance();
        LocalPlayer localPlayer = mc.player;
        if (localPlayer == null) {
            return;
        }
        LocalPlayer player = localPlayer;
        GeoBone geoBone = this.getBone("eye").orElse(null);
        if (geoBone == null) {
            return;
        }
        GeoBone bone = geoBone;
        if (!entity.isDeadOrDying()) {
            bone.setRotX(0.0f);
            bone.setRotY(0.0f);
            bone.setRotZ(0.0f);
            Vec3 entityPos = entity.position();
            double dx = player.getX() - entityPos.x;
            double dy = player.getY() + (double)player.getEyeHeight() - 0.25 - (entityPos.y + (double)(entity.getBbHeight() / (float)2));
            double dz = player.getZ() - entityPos.z;
            float yaw = (float)Math.toDegrees(Math.atan2(-dx, dz));
            double horizontalDist = Math.sqrt(dx * dx + dz * dz);
            float pitch = (float)Math.toDegrees(Math.atan2(-dy, horizontalDist));
            bone.updateRotation((float)Math.toRadians(-((double)pitch)), (float)Math.toRadians(-yaw + entity.getYRot()), bone.getRotZ());
        } else {
            Vec3 entityPos = entity.position();
            double dx = player.getX() - entityPos.x;
            double dy = player.getY() + (double)player.getEyeHeight() - 0.25 - (entityPos.y + (double)(entity.getBbHeight() / (float)2));
            double dz = player.getZ() - entityPos.z;
            float yaw = (float)Math.toDegrees(Math.atan2(-dx, dz));
            double horizontalDist = Math.sqrt(dx * dx + dz * dz);
            float pitch = (float)Math.toDegrees(Math.atan2(-dy, horizontalDist));
            bone.updateRotation((float)Math.toRadians(-((double)pitch)), (float)Math.toRadians(-yaw + entity.getYRot()), bone.getRotZ());
        }
    }
}

