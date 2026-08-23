/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.platform.Window
 *  com.mojang.blaze3d.shaders.AbstractUniform
 *  com.mojang.blaze3d.vertex.VertexFormat
 *  com.mojang.blaze3d.vertex.VertexFormat$Mode
 *  javax.annotation.Nullable
 *  net.minecraft.client.renderer.ShaderInstance
 *  net.minecraft.server.packs.resources.ResourceProvider
 *  org.joml.Matrix4f
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package net.thebrokenscript.mixins.client.features.shaders;

import com.mojang.blaze3d.platform.Window;
import com.mojang.blaze3d.shaders.AbstractUniform;
import com.mojang.blaze3d.vertex.VertexFormat;
import javax.annotation.Nullable;
import net.minecraft.client.renderer.ShaderInstance;
import net.minecraft.server.packs.resources.ResourceProvider;
import net.thebrokenscript.boss.integrity.BossGlobals;
import net.thebrokenscript.boss.integrity.FinalCutsceneHandler;
import org.joml.Matrix4f;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={ShaderInstance.class})
public abstract class CutsceneTicksMixin {
    @Unique
    @Nullable
    public AbstractUniform tbs$CUTSCENE_TICKS;
    @Unique
    @Nullable
    public AbstractUniform tbs$VORTEX_SKY_ZOOM;

    @Inject(method={"setDefaultUniforms"}, at={@At(value="HEAD")})
    private void tbs$afterDefaultSamplers(VertexFormat.Mode mode, Matrix4f frustumMatrix, Matrix4f projectionMatrix, Window window, CallbackInfo ci) {
        if (this.tbs$CUTSCENE_TICKS != null) {
            this.tbs$CUTSCENE_TICKS.set(BossGlobals.CUTSCENE_TICKS);
        }
        if (this.tbs$VORTEX_SKY_ZOOM != null) {
            this.tbs$VORTEX_SKY_ZOOM.set(FinalCutsceneHandler.CUTSCENE.getZoomValue());
        }
    }

    @Shadow
    public abstract AbstractUniform safeGetUniform(String var1);

    @Inject(method={"<init>"}, at={@At(value="TAIL")})
    private void tbs$afterInit(ResourceProvider resourceProvider, String name, VertexFormat vertexFormat, CallbackInfo ci) {
        this.tbs$CUTSCENE_TICKS = this.safeGetUniform("CutsceneTicks");
        this.tbs$VORTEX_SKY_ZOOM = this.safeGetUniform("VortexSkyZoom");
    }
}

