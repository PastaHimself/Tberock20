/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.systems.RenderSystem
 *  net.minecraft.client.DeltaTracker
 *  net.minecraft.client.renderer.GameRenderer
 *  net.minecraft.client.renderer.PostChain
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package net.thebrokenscript.brokencore.impl.mixin.client.features.post;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.renderer.PostChain;
import net.thebrokenscript.brokencore.api.client.event.RenderEvents;
import net.thebrokenscript.brokencore.api.client.shader.PostShaderManager;
import net.thebrokenscript.brokencore.api.client.shader.ShaderStage;
import net.thebrokenscript.brokencore.api.event.GameEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={GameRenderer.class})
public abstract class GameRendererMixin {
    @Unique
    private boolean brokencore$hasInitialized = false;

    @Inject(method={"render"}, at={@At(value="INVOKE", target="Lnet/minecraft/client/renderer/LevelRenderer;doEntityOutline()V")})
    private void bc$addPostShaders(DeltaTracker deltaTracker, boolean renderLevel, CallbackInfo ci) {
        this.brokencore$hasInitialized = true;
        RenderSystem.disableBlend();
        RenderSystem.disableDepthTest();
        RenderSystem.resetTextureMatrix();
        float time2 = deltaTracker.getGameTimeDeltaTicks();
        GameEvent.call(RenderEvents.POST_RENDER, new RenderEvents.PostRender(RenderSystem.getModelViewMatrix(), deltaTracker));
        for (PostChain chain : PostShaderManager.INSTANCE.forStage(ShaderStage.WORLD)) {
            chain.process(time2);
        }
    }

    @Inject(method={"render"}, at={@At(value="TAIL")})
    private void bc$addOverlayPostShaders(DeltaTracker deltaTracker, boolean renderLevel, CallbackInfo ci) {
        if (!renderLevel) {
            return;
        }
        RenderSystem.disableBlend();
        RenderSystem.disableDepthTest();
        RenderSystem.resetTextureMatrix();
        float time2 = deltaTracker.getGameTimeDeltaTicks();
        for (PostChain shader : PostShaderManager.INSTANCE.forStage(ShaderStage.OVERLAY)) {
            shader.process(time2);
        }
    }

    @Inject(method={"resize"}, at={@At(value="HEAD")})
    private void onResize(int width, int height, CallbackInfo ci) {
        if (this.brokencore$hasInitialized) {
            for (PostChain postShader : PostShaderManager.INSTANCE) {
                postShader.resize(width, height);
            }
        }
    }
}

