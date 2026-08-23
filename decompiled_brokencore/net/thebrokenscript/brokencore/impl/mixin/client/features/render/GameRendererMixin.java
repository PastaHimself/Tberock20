/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.llamalad7.mixinextras.sugar.Local
 *  net.minecraft.client.Camera
 *  net.minecraft.client.DeltaTracker
 *  net.minecraft.client.renderer.GameRenderer
 *  org.joml.Matrix4f
 *  org.joml.Matrix4fc
 *  org.joml.Quaternionf
 *  org.joml.Quaternionfc
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.At$Shift
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package net.thebrokenscript.brokencore.impl.mixin.client.features.render;

import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.client.Camera;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.renderer.GameRenderer;
import net.thebrokenscript.brokencore.api.client.util.ClientMixinBridge;
import org.joml.Matrix4f;
import org.joml.Matrix4fc;
import org.joml.Quaternionf;
import org.joml.Quaternionfc;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={GameRenderer.class})
public class GameRendererMixin {
    @Inject(method={"renderLevel"}, at={@At(value="INVOKE", target="Lnet/minecraft/client/renderer/GameRenderer;resetProjectionMatrix(Lorg/joml/Matrix4f;)V", shift=At.Shift.AFTER)})
    public void bc$getTrueFov(DeltaTracker deltaTracker, CallbackInfo ci, @Local(ordinal=0) double fov, @Local(ordinal=0) Camera camera, @Local(ordinal=0) Matrix4f projMat) {
        ClientMixinBridge.setTrueFov$brokencore_common(fov);
        ClientMixinBridge.setTrueCameraQuaternion$brokencore_common(new Quaternionf((Quaternionfc)camera.rotation()));
        ClientMixinBridge.setTrueWorldProjMat$brokencore_common(new Matrix4f((Matrix4fc)projMat));
    }

    @Inject(method={"renderLevel"}, at={@At(value="INVOKE", target="Lnet/minecraft/client/renderer/LevelRenderer;prepareCullFrustum(Lnet/minecraft/world/phys/Vec3;Lorg/joml/Matrix4f;Lorg/joml/Matrix4f;)V")})
    public void bc$getTrueModelMat(DeltaTracker deltaTracker, CallbackInfo ci, @Local(ordinal=0) double fov, @Local(ordinal=0) Camera camera, @Local(ordinal=1) Matrix4f modelMat) {
        ClientMixinBridge.setTrueWorldModelMat$brokencore_common(modelMat);
    }
}

