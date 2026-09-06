/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.ImmutableSet
 *  com.mojang.blaze3d.platform.GlStateManager
 *  com.mojang.blaze3d.platform.Window
 *  com.mojang.blaze3d.systems.RenderSystem
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.caffeinemc.mods.sodium.client.gl.device.GLRenderDevice
 *  net.caffeinemc.mods.sodium.client.gl.shader.uniform.GlUniformFloat
 *  net.caffeinemc.mods.sodium.client.gl.shader.uniform.GlUniformFloat2v
 *  net.caffeinemc.mods.sodium.client.gl.shader.uniform.GlUniformFloat3v
 *  net.caffeinemc.mods.sodium.client.gl.shader.uniform.GlUniformMatrix4f
 *  net.caffeinemc.mods.sodium.client.render.chunk.shader.ChunkShaderInterface
 *  net.caffeinemc.mods.sodium.client.render.chunk.shader.ShaderBindingContext
 *  net.caffeinemc.mods.sodium.client.render.chunk.terrain.TerrainRenderPass
 *  net.irisshaders.iris.gl.IrisRenderSystem
 *  net.irisshaders.iris.gl.blending.BlendModeOverride
 *  net.irisshaders.iris.gl.blending.BufferBlendOverride
 *  net.irisshaders.iris.gl.image.ImageHolder
 *  net.irisshaders.iris.gl.program.ProgramImages
 *  net.irisshaders.iris.gl.program.ProgramImages$Builder
 *  net.irisshaders.iris.gl.program.ProgramSamplers
 *  net.irisshaders.iris.gl.program.ProgramSamplers$Builder
 *  net.irisshaders.iris.gl.program.ProgramUniforms
 *  net.irisshaders.iris.gl.program.ProgramUniforms$Builder
 *  net.irisshaders.iris.gl.sampler.SamplerHolder
 *  net.irisshaders.iris.gl.state.FogMode
 *  net.irisshaders.iris.gl.uniform.DynamicUniformHolder
 *  net.irisshaders.iris.gl.uniform.LocationalUniformHolder
 *  net.irisshaders.iris.gl.uniform.UniformHolder
 *  net.irisshaders.iris.mixin.texture.TextureAtlasAccessor
 *  net.irisshaders.iris.pipeline.IrisRenderingPipeline
 *  net.irisshaders.iris.pipeline.programs.GlUniformMatrix3f
 *  net.irisshaders.iris.samplers.IrisSamplers
 *  net.irisshaders.iris.uniforms.CapturedRenderingState
 *  net.irisshaders.iris.uniforms.CommonUniforms
 *  net.irisshaders.iris.uniforms.builtin.BuiltinReplacementUniforms
 *  net.irisshaders.iris.uniforms.custom.CustomUniforms
 *  net.irisshaders.iris.vertices.ImmediateState
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.renderer.texture.AbstractTexture
 *  net.minecraft.client.renderer.texture.TextureAtlas
 *  net.minecraft.resources.ResourceLocation
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  org.joml.Matrix3f
 *  org.joml.Matrix3fc
 *  org.joml.Matrix4f
 *  org.joml.Matrix4fc
 */
package net.thebrokenscript.brokencore.impl.compat.iris;

import com.google.common.collect.ImmutableSet;
import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.platform.Window;
import com.mojang.blaze3d.systems.RenderSystem;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.function.Supplier;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.caffeinemc.mods.sodium.client.gl.device.GLRenderDevice;
import net.caffeinemc.mods.sodium.client.gl.shader.uniform.GlUniformFloat;
import net.caffeinemc.mods.sodium.client.gl.shader.uniform.GlUniformFloat2v;
import net.caffeinemc.mods.sodium.client.gl.shader.uniform.GlUniformFloat3v;
import net.caffeinemc.mods.sodium.client.gl.shader.uniform.GlUniformMatrix4f;
import net.caffeinemc.mods.sodium.client.render.chunk.shader.ChunkShaderInterface;
import net.caffeinemc.mods.sodium.client.render.chunk.shader.ShaderBindingContext;
import net.caffeinemc.mods.sodium.client.render.chunk.terrain.TerrainRenderPass;
import net.irisshaders.iris.gl.IrisRenderSystem;
import net.irisshaders.iris.gl.blending.BlendModeOverride;
import net.irisshaders.iris.gl.blending.BufferBlendOverride;
import net.irisshaders.iris.gl.image.ImageHolder;
import net.irisshaders.iris.gl.program.ProgramImages;
import net.irisshaders.iris.gl.program.ProgramSamplers;
import net.irisshaders.iris.gl.program.ProgramUniforms;
import net.irisshaders.iris.gl.sampler.SamplerHolder;
import net.irisshaders.iris.gl.state.FogMode;
import net.irisshaders.iris.gl.uniform.DynamicUniformHolder;
import net.irisshaders.iris.gl.uniform.LocationalUniformHolder;
import net.irisshaders.iris.gl.uniform.UniformHolder;
import net.irisshaders.iris.mixin.texture.TextureAtlasAccessor;
import net.irisshaders.iris.pipeline.IrisRenderingPipeline;
import net.irisshaders.iris.pipeline.programs.GlUniformMatrix3f;
import net.irisshaders.iris.samplers.IrisSamplers;
import net.irisshaders.iris.uniforms.CapturedRenderingState;
import net.irisshaders.iris.uniforms.CommonUniforms;
import net.irisshaders.iris.uniforms.builtin.BuiltinReplacementUniforms;
import net.irisshaders.iris.uniforms.custom.CustomUniforms;
import net.irisshaders.iris.vertices.ImmediateState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.AbstractTexture;
import net.minecraft.client.renderer.texture.TextureAtlas;
import net.minecraft.resources.ResourceLocation;
import net.thebrokenscript.brokencore.api.client.blocks.BlockRenderLayers;
import net.thebrokenscript.brokencore.api.client.blocks.uniforms.CustomUniformFactory;
import net.thebrokenscript.brokencore.api.dsl.ClientDSLKt;
import net.thebrokenscript.brokencore.impl.client.uniforms.CustomUniform;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.joml.Matrix3f;
import org.joml.Matrix3fc;
import org.joml.Matrix4f;
import org.joml.Matrix4fc;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u00a6\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001Bs\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\u0012\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00150\u0014\u0012\u0006\u0010\u0016\u001a\u00020\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0019\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0018\u00103\u001a\u0002022\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J,\u00104\u001a\u0002002\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0012\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00150\u0014H\u0002J,\u00105\u001a\u00020.2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0012\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00150\u0014H\u0002J \u00106\u001a\u0002072\u0006\u00108\u001a\u00020\u00172\u0006\u00109\u001a\u00020\u00172\u0006\u0010:\u001a\u00020\u0017H\u0016J\u0010\u0010;\u001a\u0002072\u0006\u0010<\u001a\u00020=H\u0016J\u0010\u0010>\u001a\u0002072\u0006\u0010<\u001a\u00020=H\u0016J\b\u0010?\u001a\u000207H\u0016J\b\u0010@\u001a\u000207H\u0002J\b\u0010A\u001a\u000207H\u0002J\b\u0010B\u001a\u000207H\u0002J\b\u0010C\u001a\u000207H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0015\u0010\u001c\u001a\t\u0018\u00010\u001d\u00a2\u0006\u0002\b\u001eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0015\u0010\u001f\u001a\t\u0018\u00010\u001d\u00a2\u0006\u0002\b\u001eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0015\u0010 \u001a\t\u0018\u00010\u001d\u00a2\u0006\u0002\b\u001eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0015\u0010!\u001a\t\u0018\u00010\u001d\u00a2\u0006\u0002\b\u001eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0015\u0010\"\u001a\t\u0018\u00010#\u00a2\u0006\u0002\b\u001eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0015\u0010$\u001a\t\u0018\u00010%\u00a2\u0006\u0002\b\u001eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0015\u0010&\u001a\t\u0018\u00010'\u00a2\u0006\u0002\b\u001eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0015\u0010(\u001a\t\u0018\u00010)\u00a2\u0006\u0002\b\u001eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0015\u0010*\u001a\t\u0018\u00010'\u00a2\u0006\u0002\b\u001eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010+\u001a\b\u0012\u0004\u0012\u00020,0\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020.X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u000200X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u00101\u001a\u000202X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006D"}, d2={"Lnet/thebrokenscript/brokencore/impl/compat/iris/BCIrisShader;", "Lnet/caffeinemc/mods/sodium/client/render/chunk/shader/ChunkShaderInterface;", "name", "Lnet/minecraft/resources/ResourceLocation;", "pipeline", "Lnet/irisshaders/iris/pipeline/IrisRenderingPipeline;", "pass", "Lnet/caffeinemc/mods/sodium/client/render/chunk/terrain/TerrainRenderPass;", "cx", "Lnet/caffeinemc/mods/sodium/client/render/chunk/shader/ShaderBindingContext;", "handle", "", "blendModeOverride", "Lnet/irisshaders/iris/gl/blending/BlendModeOverride;", "bufferBlendOverrides", "", "Lnet/irisshaders/iris/gl/blending/BufferBlendOverride;", "customUniforms", "Lnet/irisshaders/iris/uniforms/custom/CustomUniforms;", "flipState", "Ljava/util/function/Supplier;", "Lcom/google/common/collect/ImmutableSet;", "alphaTest", "", "containsTessellation", "", "<init>", "(Lnet/minecraft/resources/ResourceLocation;Lnet/irisshaders/iris/pipeline/IrisRenderingPipeline;Lnet/caffeinemc/mods/sodium/client/render/chunk/terrain/TerrainRenderPass;Lnet/caffeinemc/mods/sodium/client/render/chunk/shader/ShaderBindingContext;ILnet/irisshaders/iris/gl/blending/BlendModeOverride;Ljava/util/List;Lnet/irisshaders/iris/uniforms/custom/CustomUniforms;Ljava/util/function/Supplier;FZ)V", "uniformModelViewMatrix", "Lnet/caffeinemc/mods/sodium/client/gl/shader/uniform/GlUniformMatrix4f;", "Lorg/jetbrains/annotations/Nullable;", "uniformModelViewMatrixInv", "uniformProjectionMatrix", "uniformProjectionMatrixInv", "uniformNormalMatrix", "Lnet/irisshaders/iris/pipeline/programs/GlUniformMatrix3f;", "uniformRegionOffset", "Lnet/caffeinemc/mods/sodium/client/gl/shader/uniform/GlUniformFloat3v;", "uniformTexCoordShrink", "Lnet/caffeinemc/mods/sodium/client/gl/shader/uniform/GlUniformFloat2v;", "uniformGameTime", "Lnet/caffeinemc/mods/sodium/client/gl/shader/uniform/GlUniformFloat;", "uniformScreenSize", "extraUniforms", "Lnet/thebrokenscript/brokencore/impl/client/uniforms/CustomUniform;", "images", "Lnet/irisshaders/iris/gl/program/ProgramImages;", "samplers", "Lnet/irisshaders/iris/gl/program/ProgramSamplers;", "uniforms", "Lnet/irisshaders/iris/gl/program/ProgramUniforms;", "buildUniforms", "buildSamplers", "buildImages", "setRegionOffset", "", "x", "y", "z", "setModelViewMatrix", "matrix", "Lorg/joml/Matrix4fc;", "setProjectionMatrix", "setupState", "bindTextures", "applyBlendModes", "updateUniforms", "resetState", "brokencore-common"})
@SourceDebugExtension(value={"SMAP\nBCIrisShader.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BCIrisShader.kt\nnet/thebrokenscript/brokencore/impl/compat/iris/BCIrisShader\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,216:1\n1869#2,2:217\n1869#2,2:219\n*S KotlinDebug\n*F\n+ 1 BCIrisShader.kt\nnet/thebrokenscript/brokencore/impl/compat/iris/BCIrisShader\n*L\n174#1:217,2\n199#1:219,2\n*E\n"})
public final class BCIrisShader
implements ChunkShaderInterface {
    @NotNull
    private final ResourceLocation name;
    private final float alphaTest;
    private final boolean containsTessellation;
    @Nullable
    private final GlUniformMatrix4f uniformModelViewMatrix;
    @Nullable
    private final GlUniformMatrix4f uniformModelViewMatrixInv;
    @Nullable
    private final GlUniformMatrix4f uniformProjectionMatrix;
    @Nullable
    private final GlUniformMatrix4f uniformProjectionMatrixInv;
    @Nullable
    private final GlUniformMatrix3f uniformNormalMatrix;
    @Nullable
    private final GlUniformFloat3v uniformRegionOffset;
    @Nullable
    private final GlUniformFloat2v uniformTexCoordShrink;
    @Nullable
    private final GlUniformFloat uniformGameTime;
    @Nullable
    private final GlUniformFloat2v uniformScreenSize;
    @NotNull
    private final List<CustomUniform> extraUniforms;
    @NotNull
    private final ProgramImages images;
    @NotNull
    private final ProgramSamplers samplers;
    @NotNull
    private final ProgramUniforms uniforms;
    @NotNull
    private final CustomUniforms customUniforms;
    @Nullable
    private final BlendModeOverride blendModeOverride;
    @NotNull
    private final List<BufferBlendOverride> bufferBlendOverrides;

    public BCIrisShader(@NotNull ResourceLocation name, @NotNull IrisRenderingPipeline pipeline, @NotNull TerrainRenderPass pass, @NotNull ShaderBindingContext cx, int handle, @Nullable BlendModeOverride blendModeOverride, @NotNull List<BufferBlendOverride> bufferBlendOverrides, @NotNull CustomUniforms customUniforms, @NotNull Supplier<ImmutableSet<Integer>> flipState, float alphaTest, boolean containsTessellation) {
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter((Object)pipeline, (String)"pipeline");
        Intrinsics.checkNotNullParameter((Object)pass, (String)"pass");
        Intrinsics.checkNotNullParameter((Object)cx, (String)"cx");
        Intrinsics.checkNotNullParameter(bufferBlendOverrides, (String)"bufferBlendOverrides");
        Intrinsics.checkNotNullParameter((Object)customUniforms, (String)"customUniforms");
        Intrinsics.checkNotNullParameter(flipState, (String)"flipState");
        this.name = name;
        this.alphaTest = alphaTest;
        this.containsTessellation = containsTessellation;
        this.uniformModelViewMatrix = (GlUniformMatrix4f)cx.bindUniformOptional("iris_ModelViewMatrix", GlUniformMatrix4f::new);
        this.uniformModelViewMatrixInv = (GlUniformMatrix4f)cx.bindUniformOptional("iris_ModelViewMatrixInverse", GlUniformMatrix4f::new);
        this.uniformProjectionMatrix = (GlUniformMatrix4f)cx.bindUniformOptional("iris_ProjectionMatrix", GlUniformMatrix4f::new);
        this.uniformProjectionMatrixInv = (GlUniformMatrix4f)cx.bindUniformOptional("iris_ProjectionMatrixInv", GlUniformMatrix4f::new);
        this.uniformNormalMatrix = (GlUniformMatrix3f)cx.bindUniformOptional("iris_NormalMatrix", GlUniformMatrix3f::new);
        this.uniformRegionOffset = (GlUniformFloat3v)cx.bindUniformOptional("u_RegionOffset", GlUniformFloat3v::new);
        this.uniformTexCoordShrink = (GlUniformFloat2v)cx.bindUniformOptional("u_TexCoordShrink", GlUniformFloat2v::new);
        this.uniformGameTime = (GlUniformFloat)cx.bindUniformOptional("u_GameTime", GlUniformFloat::new);
        this.uniformScreenSize = (GlUniformFloat2v)cx.bindUniformOptional("u_ScreenSize", GlUniformFloat2v::new);
        this.extraUniforms = new ArrayList();
        this.uniforms = this.buildUniforms(handle, customUniforms);
        this.customUniforms = customUniforms;
        this.samplers = this.buildSamplers(pipeline, handle, flipState);
        this.images = this.buildImages(pipeline, handle, flipState);
        this.blendModeOverride = blendModeOverride;
        this.bufferBlendOverrides = bufferBlendOverrides;
        List<CustomUniformFactory> extra = BlockRenderLayers.extraUniforms.get(this.name);
        if (extra != null) {
            for (CustomUniformFactory uniform : extra) {
                CustomUniform it = uniform.create();
                it.bindSodium(cx);
                this.extraUniforms.add(it);
            }
        }
    }

    private final ProgramUniforms buildUniforms(int handle, CustomUniforms customUniforms) {
        ProgramUniforms.Builder builder = ProgramUniforms.builder((String)(this.name.getNamespace() + "_" + this.name.getPath()), (int)handle);
        CommonUniforms.addDynamicUniforms((DynamicUniformHolder)((DynamicUniformHolder)builder), (FogMode)FogMode.PER_VERTEX);
        customUniforms.assignTo((LocationalUniformHolder)builder);
        BuiltinReplacementUniforms.addBuiltinReplacementUniforms((UniformHolder)((UniformHolder)builder));
        customUniforms.mapholderToPass((LocationalUniformHolder)builder, (Object)this);
        ProgramUniforms programUniforms = builder.buildUniforms();
        Intrinsics.checkNotNullExpressionValue((Object)programUniforms, (String)"buildUniforms(...)");
        return programUniforms;
    }

    private final ProgramSamplers buildSamplers(IrisRenderingPipeline pipeline, int handle, Supplier<ImmutableSet<Integer>> flipState) {
        ProgramSamplers.Builder builder = ProgramSamplers.builder((int)handle, (Set)((Set)IrisSamplers.SODIUM_RESERVED_TEXTURE_UNITS));
        pipeline.addGbufferOrShadowSamplers((SamplerHolder)builder, (ImageHolder)ProgramImages.builder((int)handle), flipState, false, true, true, false);
        ProgramSamplers programSamplers = builder.build();
        Intrinsics.checkNotNullExpressionValue((Object)programSamplers, (String)"build(...)");
        return programSamplers;
    }

    private final ProgramImages buildImages(IrisRenderingPipeline pipeline, int handle, Supplier<ImmutableSet<Integer>> flipState) {
        ProgramImages.Builder builder = ProgramImages.builder((int)handle);
        pipeline.addGbufferOrShadowSamplers((SamplerHolder)ProgramSamplers.builder((int)handle, (Set)((Set)IrisSamplers.SODIUM_RESERVED_TEXTURE_UNITS)), (ImageHolder)builder, flipState, false, true, true, false);
        ProgramImages programImages = builder.build();
        Intrinsics.checkNotNullExpressionValue((Object)programImages, (String)"build(...)");
        return programImages;
    }

    public void setRegionOffset(float x, float y, float z) {
        block0: {
            GlUniformFloat3v glUniformFloat3v = this.uniformRegionOffset;
            if (glUniformFloat3v == null) break block0;
            glUniformFloat3v.set(x, y, z);
        }
    }

    public void setModelViewMatrix(@NotNull Matrix4fc matrix) {
        Intrinsics.checkNotNullParameter((Object)matrix, (String)"matrix");
        GlUniformMatrix4f glUniformMatrix4f = this.uniformModelViewMatrix;
        if (glUniformMatrix4f != null) {
            glUniformMatrix4f.set(matrix);
        }
        Matrix4f invertedMatrix = matrix.invert(new Matrix4f());
        GlUniformMatrix4f glUniformMatrix4f2 = this.uniformModelViewMatrixInv;
        if (glUniformMatrix4f2 != null) {
            glUniformMatrix4f2.set((Matrix4fc)invertedMatrix);
        }
        if (this.uniformNormalMatrix != null) {
            Matrix3f normalMatrix = invertedMatrix.transpose3x3(new Matrix3f());
            this.uniformNormalMatrix.set((Matrix3fc)normalMatrix);
        }
    }

    public void setProjectionMatrix(@NotNull Matrix4fc matrix) {
        Intrinsics.checkNotNullParameter((Object)matrix, (String)"matrix");
        GlUniformMatrix4f glUniformMatrix4f = this.uniformProjectionMatrix;
        if (glUniformMatrix4f != null) {
            glUniformMatrix4f.set(matrix);
        }
        if (this.uniformProjectionMatrixInv != null) {
            Matrix4f invertedMatrix = matrix.invert(new Matrix4f());
            this.uniformProjectionMatrixInv.set((Matrix4fc)invertedMatrix);
        }
    }

    public void setupState() {
        this.applyBlendModes();
        this.updateUniforms();
        this.images.update();
        this.bindTextures();
        Window window = ClientDSLKt.getMC().getWindow();
        GlUniformFloat glUniformFloat = this.uniformGameTime;
        if (glUniformFloat != null) {
            glUniformFloat.set(Float.valueOf(RenderSystem.getShaderGameTime()));
        }
        GlUniformFloat2v glUniformFloat2v = this.uniformScreenSize;
        if (glUniformFloat2v != null) {
            glUniformFloat2v.set((float)window.getWidth(), (float)window.getHeight());
        }
        Iterable $this$forEach$iv = this.extraUniforms;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            CustomUniform p0 = (CustomUniform)element$iv;
            boolean bl = false;
            p0.setSodium();
        }
        AbstractTexture abstractTexture = ClientDSLKt.getMC().getTextureManager().getTexture(TextureAtlas.LOCATION_BLOCKS);
        Intrinsics.checkNotNull((Object)abstractTexture, (String)"null cannot be cast to non-null type net.irisshaders.iris.mixin.texture.TextureAtlasAccessor");
        TextureAtlasAccessor textureAtlas = (TextureAtlasAccessor)abstractTexture;
        double subTexelPrecision = 1 << GLRenderDevice.INSTANCE.getSubTexelPrecisionBits();
        float subTexelOffset = 3.0517578E-5f;
        GlUniformFloat2v glUniformFloat2v2 = this.uniformTexCoordShrink;
        if (glUniformFloat2v2 != null) {
            glUniformFloat2v2.set((float)((double)subTexelOffset - 1.0 / (double)textureAtlas.callGetWidth() / subTexelPrecision), (float)((double)subTexelOffset - 1.0 / (double)textureAtlas.callGetHeight() / subTexelPrecision));
        }
        if (this.containsTessellation) {
            ImmediateState.usingTessellation = true;
        }
    }

    private final void bindTextures() {
        IrisRenderSystem.bindTextureToUnit((int)3553, (int)0, (int)RenderSystem.getShaderTexture((int)0));
        IrisRenderSystem.bindTextureToUnit((int)3553, (int)2, (int)RenderSystem.getShaderTexture((int)2));
        GlStateManager._activeTexture((int)33986);
    }

    private final void applyBlendModes() {
        BlendModeOverride blendModeOverride = this.blendModeOverride;
        if (blendModeOverride != null) {
            blendModeOverride.apply();
        }
        Iterable $this$forEach$iv = this.bufferBlendOverrides;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            BufferBlendOverride p0 = (BufferBlendOverride)element$iv;
            boolean bl = false;
            p0.apply();
        }
    }

    private final void updateUniforms() {
        CapturedRenderingState.INSTANCE.setCurrentAlphaTest(this.alphaTest);
        this.samplers.update();
        this.uniforms.update();
        this.customUniforms.push((Object)this);
    }

    public void resetState() {
        ProgramUniforms.clearActiveUniforms();
        ProgramSamplers.clearActiveSamplers();
        BlendModeOverride.restore();
        Minecraft.getInstance().getMainRenderTarget().bindWrite(false);
        ImmediateState.usingTessellation = false;
    }
}

