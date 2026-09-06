/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.shaders.Uniform
 *  net.minecraft.client.Camera
 *  net.minecraft.client.DeltaTracker
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.renderer.GameRenderer
 *  net.minecraft.client.renderer.ShaderInstance
 *  org.joml.Vector3f
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package net.thebrokenscript.mixins.features.vfx;

import com.mojang.blaze3d.shaders.Uniform;
import net.minecraft.client.Camera;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.renderer.ShaderInstance;
import net.thebrokenscript.client.registry.TBSRenderTypes;
import org.joml.Vector3f;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={GameRenderer.class})
public abstract class GameRendererMixin {
    @Inject(method={"renderLevel"}, at={@At(value="HEAD")})
    private void onRender(DeltaTracker deltaTracker, CallbackInfo ci) {
        Uniform uniform;
        Camera cam = Minecraft.getInstance().gameRenderer.getMainCamera();
        ShaderInstance shader = TBSRenderTypes.INSTANCE.getFleshShader();
        if (shader != null && (uniform = shader.getUniform("cameraPos")) != null) {
            uniform.set(new Vector3f((float)(-cam.getPosition().x), (float)cam.getPosition().y, (float)(-cam.getPosition().z)));
        }
    }
}

