/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.ImmutableSet
 *  net.caffeinemc.mods.sodium.client.gl.GlObject
 *  net.caffeinemc.mods.sodium.client.gl.shader.GlProgram
 *  net.caffeinemc.mods.sodium.client.gl.shader.GlProgram$Builder
 *  net.caffeinemc.mods.sodium.client.gl.shader.GlShader
 *  net.caffeinemc.mods.sodium.client.render.chunk.shader.ChunkShaderInterface
 *  net.caffeinemc.mods.sodium.client.render.chunk.shader.ShaderBindingContext
 *  net.caffeinemc.mods.sodium.client.render.chunk.terrain.TerrainRenderPass
 *  net.irisshaders.iris.gl.GLDebug
 *  net.irisshaders.iris.gl.blending.AlphaTest
 *  net.irisshaders.iris.gl.blending.BufferBlendOverride
 *  net.irisshaders.iris.gl.framebuffer.GlFramebuffer
 *  net.irisshaders.iris.pipeline.IrisRenderingPipeline
 *  net.irisshaders.iris.pipeline.programs.SodiumPrograms
 *  net.irisshaders.iris.pipeline.transform.PatchShaderType
 *  net.irisshaders.iris.shaderpack.programs.ProgramFallbackResolver
 *  net.irisshaders.iris.shaderpack.programs.ProgramSet
 *  net.irisshaders.iris.shaderpack.programs.ProgramSource
 *  net.irisshaders.iris.shadows.ShadowRenderTargets
 *  net.irisshaders.iris.targets.RenderTargets
 *  net.irisshaders.iris.uniforms.custom.CustomUniforms
 *  net.minecraft.resources.ResourceLocation
 *  org.lwjgl.opengl.GL43C
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package net.thebrokenscript.brokencore.impl.mixin.compat.iris;

import com.google.common.collect.ImmutableSet;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.function.Supplier;
import net.caffeinemc.mods.sodium.client.gl.GlObject;
import net.caffeinemc.mods.sodium.client.gl.shader.GlProgram;
import net.caffeinemc.mods.sodium.client.gl.shader.GlShader;
import net.caffeinemc.mods.sodium.client.render.chunk.shader.ChunkShaderInterface;
import net.caffeinemc.mods.sodium.client.render.chunk.shader.ShaderBindingContext;
import net.caffeinemc.mods.sodium.client.render.chunk.terrain.TerrainRenderPass;
import net.irisshaders.iris.gl.GLDebug;
import net.irisshaders.iris.gl.blending.AlphaTest;
import net.irisshaders.iris.gl.blending.BufferBlendOverride;
import net.irisshaders.iris.gl.framebuffer.GlFramebuffer;
import net.irisshaders.iris.pipeline.IrisRenderingPipeline;
import net.irisshaders.iris.pipeline.programs.SodiumPrograms;
import net.irisshaders.iris.pipeline.transform.PatchShaderType;
import net.irisshaders.iris.shaderpack.programs.ProgramFallbackResolver;
import net.irisshaders.iris.shaderpack.programs.ProgramSet;
import net.irisshaders.iris.shaderpack.programs.ProgramSource;
import net.irisshaders.iris.shadows.ShadowRenderTargets;
import net.irisshaders.iris.targets.RenderTargets;
import net.irisshaders.iris.uniforms.custom.CustomUniforms;
import net.minecraft.resources.ResourceLocation;
import net.thebrokenscript.brokencore.impl.compat.iris.BCIrisShader;
import net.thebrokenscript.brokencore.impl.compat.iris.ProgramSourceGetter;
import net.thebrokenscript.brokencore.impl.compat.sodium.BCPasses;
import org.lwjgl.opengl.GL43C;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={SodiumPrograms.class})
public abstract class SodiumProgramsMixin {
    @Shadow
    private boolean hasNormal;
    @Shadow
    private boolean hasMidBlock;
    @Shadow
    private boolean hasBlockId;
    @Shadow
    private boolean hasMidUv;
    @Unique
    private final Map<TerrainRenderPass, GlFramebuffer> bc$extraBuffers = new HashMap<TerrainRenderPass, GlFramebuffer>();
    @Unique
    private final Map<TerrainRenderPass, GlProgram<ChunkShaderInterface>> bc$extraShaders = new HashMap<TerrainRenderPass, GlProgram<ChunkShaderInterface>>();

    @Shadow
    protected abstract Map<PatchShaderType, GlShader> createGlShaders(String var1, Map<PatchShaderType, String> var2);

    @Shadow
    protected abstract List<BufferBlendOverride> createBufferBlendOverrides(ProgramSource var1);

    @Inject(method={"<init>"}, at={@At(value="TAIL")})
    public void bc$addExtraBuffers(IrisRenderingPipeline pipeline, ProgramSet programSet, ProgramFallbackResolver resolver, RenderTargets renderTargets, Supplier<ShadowRenderTargets> shadowRenderTargets, CustomUniforms customUniforms, CallbackInfo ci) {
        for (Map.Entry<ResourceLocation, TerrainRenderPass> entry : BCPasses.get().entrySet()) {
            int[] nArray;
            ProgramSource source = ProgramSourceGetter.get(entry.getKey().withPrefix("sodium/"), programSet);
            Supplier<ImmutableSet<Integer>> flipState = () -> ((IrisRenderingPipeline)pipeline).getFlippedAfterPrepare();
            if (source.getDirectives().hasUnknownDrawBuffers()) {
                int[] nArray2 = new int[1];
                nArray = nArray2;
                nArray2[0] = 0;
            } else {
                nArray = source.getDirectives().getDrawBuffers();
            }
            GlFramebuffer framebuffer = renderTargets.createGbufferFramebuffer(flipState.get(), nArray);
            this.bc$extraBuffers.put(entry.getValue(), framebuffer);
            AlphaTest alphaTest = source.getDirectives().getAlphaTestOverride().orElse(AlphaTest.ALWAYS);
            HashMap<PatchShaderType, String> transformed = new HashMap<PatchShaderType, String>();
            transformed.put(PatchShaderType.VERTEX, (String)source.getVertexSource().orElseThrow());
            transformed.put(PatchShaderType.FRAGMENT, (String)source.getFragmentSource().orElseThrow());
            String id = entry.getKey().getNamespace() + "_" + entry.getKey().getPath();
            GlProgram<ChunkShaderInterface> shader = this.bc$createShader(entry.getKey(), pipeline, entry.getValue(), source, alphaTest, customUniforms, flipState, this.createGlShaders(id, transformed));
            this.bc$extraShaders.put(entry.getValue(), shader);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Unique
    private GlProgram<ChunkShaderInterface> bc$createShader(ResourceLocation name, IrisRenderingPipeline pipeline, TerrainRenderPass pass, ProgramSource source, AlphaTest alphaTest, CustomUniforms customUniforms, Supplier<ImmutableSet<Integer>> flipState, Map<PatchShaderType, GlShader> transformed) {
        GlProgram<ChunkShaderInterface> program;
        GlProgram.Builder builder = GlProgram.builder((ResourceLocation)ResourceLocation.fromNamespaceAndPath((String)name.getNamespace(), (String)("chunk_shader_for_" + name.getPath().toLowerCase(Locale.ROOT))));
        for (GlShader shader : transformed.values()) {
            builder.attachShader(shader);
        }
        boolean containsTessellation = source.getTessEvalSource().isPresent();
        try {
            program = this.bc$buildProgram(name, builder, pipeline, pass, source, alphaTest, customUniforms, flipState, containsTessellation);
        }
        finally {
            transformed.values().forEach(GlShader::delete);
        }
        return program;
    }

    @Unique
    private GlProgram<ChunkShaderInterface> bc$buildProgram(ResourceLocation name, GlProgram.Builder builder, IrisRenderingPipeline pipeline, TerrainRenderPass pass, ProgramSource source, AlphaTest alphaTest, CustomUniforms customUniforms, Supplier<ImmutableSet<Integer>> flipState, boolean containsTessellation) {
        return builder.bindAttribute("a_Position", 0).bindAttribute("a_Color", 1).bindAttribute("a_TexCoord", 2).bindAttribute("a_LightAndData", 3).bindAttribute("mc_Entity", 11).bindAttribute("mc_midTexCoord", 12).bindAttribute("at_tangent", 13).bindAttribute("iris_Normal", 10).bindAttribute("at_midBlock", 14).link(shader -> {
            int handle = ((GlObject)shader).handle();
            GLDebug.nameObject((int)33506, (int)handle, (String)(name.getNamespace().toLowerCase(Locale.ROOT) + "-terrain-" + name.getPath().toLowerCase(Locale.ROOT)));
            if (!this.hasNormal) {
                boolean bl = this.hasNormal = GL43C.glGetAttribLocation((int)handle, (CharSequence)"iris_Normal") != -1;
            }
            if (!this.hasMidBlock) {
                boolean bl = this.hasMidBlock = GL43C.glGetAttribLocation((int)handle, (CharSequence)"at_midBlock") != -1;
            }
            if (!this.hasBlockId) {
                boolean bl = this.hasBlockId = GL43C.glGetAttribLocation((int)handle, (CharSequence)"mc_Entity") != -1;
            }
            if (!this.hasMidUv) {
                this.hasMidUv = GL43C.glGetAttribLocation((int)handle, (CharSequence)"mc_midTexCoord") != -1;
            }
            return new BCIrisShader(name, pipeline, pass, (ShaderBindingContext)shader, handle, source.getDirectives().getBlendModeOverride().orElse(null), this.createBufferBlendOverrides(source), customUniforms, flipState, alphaTest.reference(), containsTessellation);
        });
    }

    @Inject(method={"getProgram"}, at={@At(value="HEAD")}, cancellable=true)
    public void bc$useExtraProgram(TerrainRenderPass pass, CallbackInfoReturnable<GlProgram<ChunkShaderInterface>> cir) {
        if (this.bc$extraShaders.containsKey(pass)) {
            cir.setReturnValue(this.bc$extraShaders.get(pass));
        }
    }

    @Inject(method={"getFramebuffer"}, at={@At(value="HEAD")}, cancellable=true)
    public void bc$useExtraFramebuffer(TerrainRenderPass pass, CallbackInfoReturnable<GlFramebuffer> cir) {
        if (this.bc$extraBuffers.containsKey(pass)) {
            cir.setReturnValue((Object)this.bc$extraBuffers.get(pass));
        }
    }
}

