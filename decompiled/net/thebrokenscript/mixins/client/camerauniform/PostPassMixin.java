/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Camera
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.renderer.EffectInstance
 *  net.minecraft.client.renderer.PostPass
 *  net.minecraft.util.Mth
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package net.thebrokenscript.mixins.client.camerauniform;

import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.EffectInstance;
import net.minecraft.client.renderer.PostPass;
import net.minecraft.util.Mth;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={PostPass.class})
public class PostPassMixin {
    @Shadow
    private EffectInstance effect;

    @Inject(method={"process"}, at={@At(value="FIELD", target="Lnet/minecraft/client/renderer/PostPass;shaderOrthoMatrix:Lorg/joml/Matrix4f;", opcode=180)})
    private void afterForLoop(float partialTicks, CallbackInfo ci) {
        Camera cam = Minecraft.getInstance().gameRenderer.getMainCamera();
        int ix = Mth.floor((double)cam.getPosition().x);
        int iy = Mth.floor((double)cam.getPosition().y);
        int iz = Mth.floor((double)cam.getPosition().z);
        float ox = (float)(cam.getPosition().x - (double)ix);
        float oy = (float)(cam.getPosition().y - (double)iy);
        float oz = (float)(cam.getPosition().z - (double)iz);
        this.effect.safeGetUniform("CameraPos").set(ix, iy, iz);
        this.effect.safeGetUniform("CameraOffset").set(ox, oy, oz);
    }
}

