/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.caffeinemc.mods.sodium.client.gl.shader.GlProgram
 *  net.caffeinemc.mods.sodium.client.gl.shader.GlShader
 *  net.caffeinemc.mods.sodium.client.gl.shader.ShaderConstants
 *  net.caffeinemc.mods.sodium.client.gl.shader.ShaderType
 *  net.caffeinemc.mods.sodium.client.render.chunk.ShaderChunkRenderer
 *  net.caffeinemc.mods.sodium.client.render.chunk.shader.ChunkShaderInterface
 *  net.caffeinemc.mods.sodium.client.render.chunk.shader.ChunkShaderOptions
 *  net.caffeinemc.mods.sodium.client.render.chunk.shader.ShaderBindingContext
 *  net.caffeinemc.mods.sodium.client.render.chunk.terrain.TerrainRenderPass
 *  net.minecraft.resources.ResourceLocation
 *  org.spongepowered.asm.mixin.Final
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package net.thebrokenscript.brokencore.impl.mixin.compat.sodium;

import java.util.Map;
import net.caffeinemc.mods.sodium.client.gl.shader.GlProgram;
import net.caffeinemc.mods.sodium.client.gl.shader.GlShader;
import net.caffeinemc.mods.sodium.client.gl.shader.ShaderConstants;
import net.caffeinemc.mods.sodium.client.gl.shader.ShaderType;
import net.caffeinemc.mods.sodium.client.render.chunk.ShaderChunkRenderer;
import net.caffeinemc.mods.sodium.client.render.chunk.shader.ChunkShaderInterface;
import net.caffeinemc.mods.sodium.client.render.chunk.shader.ChunkShaderOptions;
import net.caffeinemc.mods.sodium.client.render.chunk.shader.ShaderBindingContext;
import net.caffeinemc.mods.sodium.client.render.chunk.terrain.TerrainRenderPass;
import net.minecraft.resources.ResourceLocation;
import net.thebrokenscript.brokencore.impl.compat.sodium.BCPasses;
import net.thebrokenscript.brokencore.impl.compat.sodium.BCShaderInterface;
import net.thebrokenscript.brokencore.impl.compat.sodium.BCShaderLoader;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={ShaderChunkRenderer.class})
public class ShaderChunkRendererMixin {
    @Shadow
    @Final
    private Map<ChunkShaderOptions, GlProgram<ChunkShaderInterface>> programs;

    @Inject(method={"compileProgram"}, at={@At(value="HEAD")}, cancellable=true)
    public void bc$keepShaders(ChunkShaderOptions options, CallbackInfoReturnable<GlProgram<ChunkShaderInterface>> cir) {
        Map<TerrainRenderPass, ResourceLocation> passes = BCPasses.getReverse();
        if (passes.containsKey(options.pass())) {
            cir.setReturnValue((Object)this.programs.computeIfAbsent(options, _opts -> this.bc$createShader(((ResourceLocation)passes.get(options.pass())).withPrefix("sodium/"), options)));
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Unique
    private GlProgram<ChunkShaderInterface> bc$createShader(ResourceLocation path, ChunkShaderOptions options) {
        GlProgram program;
        ShaderConstants constants = options.constants();
        GlShader vertShader = BCShaderLoader.loadShader(ShaderType.VERTEX, path.withSuffix(".vsh"), constants);
        GlShader fragShader = BCShaderLoader.loadShader(ShaderType.FRAGMENT, path.withSuffix(".fsh"), constants);
        try {
            program = GlProgram.builder((ResourceLocation)path).attachShader(vertShader).attachShader(fragShader).bindAttribute("a_Position", 0).bindAttribute("a_Color", 1).bindAttribute("a_TexCoord", 2).bindAttribute("a_LightAndData", 3).bindFragmentData("fragColor", 0).link(shader -> new BCShaderInterface((ShaderBindingContext)shader, options));
        }
        finally {
            vertShader.delete();
            fragShader.delete();
        }
        return program;
    }
}

