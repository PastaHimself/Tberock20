/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.platform.Window
 *  com.mojang.blaze3d.shaders.Uniform
 *  com.mojang.blaze3d.vertex.VertexFormat
 *  com.mojang.blaze3d.vertex.VertexFormat$Mode
 *  javax.annotation.Nullable
 *  net.minecraft.client.Camera
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.renderer.ShaderInstance
 *  net.minecraft.server.packs.resources.ResourceProvider
 *  net.minecraft.util.Mth
 *  org.joml.Matrix4f
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package net.thebrokenscript.mixins.client.camerauniform;

import com.mojang.blaze3d.platform.Window;
import com.mojang.blaze3d.shaders.Uniform;
import com.mojang.blaze3d.vertex.VertexFormat;
import javax.annotation.Nullable;
import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ShaderInstance;
import net.minecraft.server.packs.resources.ResourceProvider;
import net.minecraft.util.Mth;
import org.joml.Matrix4f;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={ShaderInstance.class})
public abstract class ShaderInstanceMixin {
    @Unique
    @Nullable
    public Uniform CAMERA_POS;
    @Unique
    @Nullable
    public Uniform CAMERA_OFFSET;

    @Inject(method={"setDefaultUniforms"}, at={@At(value="HEAD")})
    private void afterDefaultSamplers(VertexFormat.Mode mode, Matrix4f frustumMatrix, Matrix4f projectionMatrix, Window window, CallbackInfo ci) {
        Camera cam = Minecraft.getInstance().gameRenderer.getMainCamera();
        int ix = Mth.floor((double)cam.getPosition().x);
        int iy = Mth.floor((double)cam.getPosition().y);
        int iz = Mth.floor((double)cam.getPosition().z);
        float ox = (float)(cam.getPosition().x - (double)ix);
        float oy = (float)(cam.getPosition().y - (double)iy);
        float oz = (float)(cam.getPosition().z - (double)iz);
        if (this.CAMERA_POS != null) {
            this.CAMERA_POS.set(ix, iy, iz);
        }
        if (this.CAMERA_OFFSET != null) {
            this.CAMERA_OFFSET.set(ox, oy, oz);
        }
    }

    @Shadow
    @Nullable
    public abstract Uniform getUniform(String var1);

    @Inject(method={"<init>"}, at={@At(value="TAIL")})
    private void afterInit(ResourceProvider resourceProvider, String name, VertexFormat vertexFormat, CallbackInfo ci) {
        this.CAMERA_POS = this.getUniform("CameraPos");
        this.CAMERA_OFFSET = this.getUniform("CameraOffset");
    }
}

