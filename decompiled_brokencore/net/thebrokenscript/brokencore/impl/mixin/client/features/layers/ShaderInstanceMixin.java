/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.platform.Window
 *  com.mojang.blaze3d.shaders.Uniform
 *  com.mojang.blaze3d.vertex.VertexFormat
 *  com.mojang.blaze3d.vertex.VertexFormat$Mode
 *  javax.annotation.Nullable
 *  net.minecraft.client.renderer.ShaderInstance
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.server.packs.resources.ResourceProvider
 *  org.joml.Matrix4f
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package net.thebrokenscript.brokencore.impl.mixin.client.features.layers;

import com.mojang.blaze3d.platform.Window;
import com.mojang.blaze3d.shaders.Uniform;
import com.mojang.blaze3d.vertex.VertexFormat;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.client.renderer.ShaderInstance;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceProvider;
import net.thebrokenscript.brokencore.api.client.blocks.BlockRenderLayers;
import net.thebrokenscript.brokencore.api.client.blocks.uniforms.CustomUniformFactory;
import net.thebrokenscript.brokencore.impl.client.uniforms.CustomUniform;
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
    private final List<CustomUniform> bc$customUniforms = new ArrayList<CustomUniform>();

    @Shadow
    @Nullable
    public abstract Uniform getUniform(String var1);

    @Inject(method={"<init>"}, at={@At(value="TAIL")})
    public void bc$storeCustomUniforms(ResourceProvider resourceProvider, String name, VertexFormat vertexFormat, CallbackInfo ci) {
        List<CustomUniformFactory> uniforms;
        ResourceLocation id = ResourceLocation.tryParse((String)name);
        if (id != null && (uniforms = BlockRenderLayers.extraUniforms.get(id)) != null) {
            for (CustomUniformFactory uniformFactory : uniforms) {
                CustomUniform uniform = uniformFactory.create();
                uniform.bind((ShaderInstance)this);
                this.bc$customUniforms.add(uniform);
            }
        }
    }

    @Inject(method={"setDefaultUniforms"}, at={@At(value="HEAD")})
    public void bc$injectUniforms(VertexFormat.Mode mode, Matrix4f frustumMatrix, Matrix4f projectionMatrix, Window window, CallbackInfo ci) {
        for (CustomUniform uniform : this.bc$customUniforms) {
            uniform.set();
        }
    }
}

