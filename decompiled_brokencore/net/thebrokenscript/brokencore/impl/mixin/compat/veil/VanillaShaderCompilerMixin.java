/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  foundry.veil.impl.client.render.dynamicbuffer.VanillaShaderCompiler
 *  net.minecraft.client.renderer.ShaderInstance
 *  org.lwjgl.opengl.GLCapabilities
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package net.thebrokenscript.brokencore.impl.mixin.compat.veil;

import foundry.veil.impl.client.render.dynamicbuffer.VanillaShaderCompiler;
import net.minecraft.client.renderer.ShaderInstance;
import net.thebrokenscript.brokencore.api.client.shader.BCShader;
import org.lwjgl.opengl.GLCapabilities;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={VanillaShaderCompiler.class})
public class VanillaShaderCompilerMixin {
    @Inject(method={"compileShader"}, at={@At(value="HEAD")}, cancellable=true)
    public void bc$ignoreCustomShaders(ShaderInstance shader, int activeBuffers, GLCapabilities glCapabilities, CallbackInfo ci) {
        if (shader instanceof BCShader) {
            ci.cancel();
        }
    }
}

