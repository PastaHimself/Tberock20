/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
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
 *  net.caffeinemc.mods.sodium.client.gl.shader.uniform.GlUniformInt
 *  net.caffeinemc.mods.sodium.client.gl.shader.uniform.GlUniformMatrix4f
 *  net.caffeinemc.mods.sodium.client.render.chunk.shader.ChunkShaderFogComponent
 *  net.caffeinemc.mods.sodium.client.render.chunk.shader.ChunkShaderInterface
 *  net.caffeinemc.mods.sodium.client.render.chunk.shader.ChunkShaderOptions
 *  net.caffeinemc.mods.sodium.client.render.chunk.shader.ChunkShaderTextureSlot
 *  net.caffeinemc.mods.sodium.client.render.chunk.shader.ShaderBindingContext
 *  net.caffeinemc.mods.sodium.client.util.TextureUtil
 *  net.minecraft.client.renderer.texture.AbstractTexture
 *  net.minecraft.client.renderer.texture.TextureAtlas
 *  net.minecraft.resources.ResourceLocation
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  org.joml.Matrix4fc
 */
package net.thebrokenscript.brokencore.impl.compat.sodium;

import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.platform.Window;
import com.mojang.blaze3d.systems.RenderSystem;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.caffeinemc.mods.sodium.client.gl.device.GLRenderDevice;
import net.caffeinemc.mods.sodium.client.gl.shader.uniform.GlUniformFloat;
import net.caffeinemc.mods.sodium.client.gl.shader.uniform.GlUniformFloat2v;
import net.caffeinemc.mods.sodium.client.gl.shader.uniform.GlUniformFloat3v;
import net.caffeinemc.mods.sodium.client.gl.shader.uniform.GlUniformInt;
import net.caffeinemc.mods.sodium.client.gl.shader.uniform.GlUniformMatrix4f;
import net.caffeinemc.mods.sodium.client.render.chunk.shader.ChunkShaderFogComponent;
import net.caffeinemc.mods.sodium.client.render.chunk.shader.ChunkShaderInterface;
import net.caffeinemc.mods.sodium.client.render.chunk.shader.ChunkShaderOptions;
import net.caffeinemc.mods.sodium.client.render.chunk.shader.ChunkShaderTextureSlot;
import net.caffeinemc.mods.sodium.client.render.chunk.shader.ShaderBindingContext;
import net.caffeinemc.mods.sodium.client.util.TextureUtil;
import net.minecraft.client.renderer.texture.AbstractTexture;
import net.minecraft.client.renderer.texture.TextureAtlas;
import net.minecraft.resources.ResourceLocation;
import net.thebrokenscript.brokencore.api.client.blocks.BlockRenderLayers;
import net.thebrokenscript.brokencore.api.client.blocks.uniforms.CustomUniformFactory;
import net.thebrokenscript.brokencore.api.dsl.ClientDSLKt;
import net.thebrokenscript.brokencore.impl.client.uniforms.CustomUniform;
import net.thebrokenscript.brokencore.impl.compat.sodium.BCPasses;
import net.thebrokenscript.brokencore.impl.mixin.compat.sodium.BCTextureAtlasAccessor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.joml.Matrix4fc;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u001c\u001a\u00020\u001dH\u0016J\u0018\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\n2\u0006\u0010 \u001a\u00020!H\u0002J\b\u0010\"\u001a\u00020\u001dH\u0016J\u0010\u0010#\u001a\u00020\u001d2\u0006\u0010$\u001a\u00020%H\u0016J\u0010\u0010&\u001a\u00020\u001d2\u0006\u0010$\u001a\u00020%H\u0016J \u0010'\u001a\u00020\u001d2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020)2\u0006\u0010+\u001a\u00020)H\u0016R\u001c\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0015\u0010\f\u001a\t\u0018\u00010\r\u00a2\u0006\u0002\b\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0015\u0010\u000f\u001a\t\u0018\u00010\r\u00a2\u0006\u0002\b\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0015\u0010\u0010\u001a\t\u0018\u00010\u0011\u00a2\u0006\u0002\b\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0015\u0010\u0012\u001a\t\u0018\u00010\u0013\u00a2\u0006\u0002\b\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0015\u0010\u0014\u001a\t\u0018\u00010\u0015\u00a2\u0006\u0002\b\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0015\u0010\u0016\u001a\t\u0018\u00010\u0013\u00a2\u0006\u0002\b\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006,"}, d2={"Lnet/thebrokenscript/brokencore/impl/compat/sodium/BCShaderInterface;", "Lnet/caffeinemc/mods/sodium/client/render/chunk/shader/ChunkShaderInterface;", "cx", "Lnet/caffeinemc/mods/sodium/client/render/chunk/shader/ShaderBindingContext;", "options", "Lnet/caffeinemc/mods/sodium/client/render/chunk/shader/ChunkShaderOptions;", "<init>", "(Lnet/caffeinemc/mods/sodium/client/render/chunk/shader/ShaderBindingContext;Lnet/caffeinemc/mods/sodium/client/render/chunk/shader/ChunkShaderOptions;)V", "uniformTextures", "Ljava/util/EnumMap;", "Lnet/caffeinemc/mods/sodium/client/render/chunk/shader/ChunkShaderTextureSlot;", "Lnet/caffeinemc/mods/sodium/client/gl/shader/uniform/GlUniformInt;", "uniformModelViewMatrix", "Lnet/caffeinemc/mods/sodium/client/gl/shader/uniform/GlUniformMatrix4f;", "Lorg/jetbrains/annotations/Nullable;", "uniformProjectionMatrix", "uniformRegionOffset", "Lnet/caffeinemc/mods/sodium/client/gl/shader/uniform/GlUniformFloat3v;", "uniformTexCoordShrink", "Lnet/caffeinemc/mods/sodium/client/gl/shader/uniform/GlUniformFloat2v;", "uniformGameTime", "Lnet/caffeinemc/mods/sodium/client/gl/shader/uniform/GlUniformFloat;", "uniformScreenSize", "customUniforms", "", "Lnet/thebrokenscript/brokencore/impl/client/uniforms/CustomUniform;", "fogShader", "Lnet/caffeinemc/mods/sodium/client/render/chunk/shader/ChunkShaderFogComponent;", "setupState", "", "bindTexture", "slot", "textureId", "", "resetState", "setProjectionMatrix", "matrix", "Lorg/joml/Matrix4fc;", "setModelViewMatrix", "setRegionOffset", "x", "", "y", "z", "brokencore-common"})
@SourceDebugExtension(value={"SMAP\nBCShaderInterface.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BCShaderInterface.kt\nnet/thebrokenscript/brokencore/impl/compat/sodium/BCShaderInterface\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,103:1\n1869#2,2:104\n*S KotlinDebug\n*F\n+ 1 BCShaderInterface.kt\nnet/thebrokenscript/brokencore/impl/compat/sodium/BCShaderInterface\n*L\n65#1:104,2\n*E\n"})
public final class BCShaderInterface
implements ChunkShaderInterface {
    @NotNull
    private final EnumMap<ChunkShaderTextureSlot, GlUniformInt> uniformTextures;
    @Nullable
    private final GlUniformMatrix4f uniformModelViewMatrix;
    @Nullable
    private final GlUniformMatrix4f uniformProjectionMatrix;
    @Nullable
    private final GlUniformFloat3v uniformRegionOffset;
    @Nullable
    private final GlUniformFloat2v uniformTexCoordShrink;
    @Nullable
    private final GlUniformFloat uniformGameTime;
    @Nullable
    private final GlUniformFloat2v uniformScreenSize;
    @NotNull
    private final List<CustomUniform> customUniforms;
    @Nullable
    private final ChunkShaderFogComponent fogShader;

    public BCShaderInterface(@NotNull ShaderBindingContext cx, @NotNull ChunkShaderOptions options) {
        ChunkShaderFogComponent chunkShaderFogComponent;
        BCShaderInterface bCShaderInterface;
        List<CustomUniformFactory> extra;
        Intrinsics.checkNotNullParameter((Object)cx, (String)"cx");
        Intrinsics.checkNotNullParameter((Object)options, (String)"options");
        this.uniformTextures = new EnumMap(ChunkShaderTextureSlot.class);
        this.uniformModelViewMatrix = (GlUniformMatrix4f)cx.bindUniformOptional("u_ModelViewMatrix", GlUniformMatrix4f::new);
        this.uniformProjectionMatrix = (GlUniformMatrix4f)cx.bindUniformOptional("u_ProjectionMatrix", GlUniformMatrix4f::new);
        this.uniformRegionOffset = (GlUniformFloat3v)cx.bindUniformOptional("u_RegionOffset", GlUniformFloat3v::new);
        this.uniformTexCoordShrink = (GlUniformFloat2v)cx.bindUniformOptional("u_TexCoordShrink", GlUniformFloat2v::new);
        this.uniformGameTime = (GlUniformFloat)cx.bindUniformOptional("u_GameTime", GlUniformFloat::new);
        this.uniformScreenSize = (GlUniformFloat2v)cx.bindUniformOptional("u_ScreenSize", GlUniformFloat2v::new);
        this.customUniforms = new ArrayList();
        ((Map)this.uniformTextures).put(ChunkShaderTextureSlot.BLOCK, cx.bindUniformOptional("u_BlockTex", GlUniformInt::new));
        ((Map)this.uniformTextures).put(ChunkShaderTextureSlot.LIGHT, cx.bindUniformOptional("u_LightTex", GlUniformInt::new));
        ResourceLocation id = BCPasses.getReverse().get(options.pass());
        if (id != null && (extra = BlockRenderLayers.extraUniforms.get(id)) != null) {
            for (CustomUniformFactory uniform : extra) {
                CustomUniform it = uniform.create();
                it.bindSodium(cx);
                this.customUniforms.add(it);
            }
        }
        BCShaderInterface bCShaderInterface2 = this;
        try {
            bCShaderInterface = bCShaderInterface2;
            chunkShaderFogComponent = (ChunkShaderFogComponent)options.fog().getFactory().apply(cx);
        }
        catch (Exception exception) {
            bCShaderInterface = bCShaderInterface2;
            chunkShaderFogComponent = null;
        }
        bCShaderInterface.fogShader = chunkShaderFogComponent;
    }

    public void setupState() {
        block4: {
            this.bindTexture(ChunkShaderTextureSlot.BLOCK, TextureUtil.getBlockTextureId());
            this.bindTexture(ChunkShaderTextureSlot.LIGHT, TextureUtil.getLightTextureId());
            Window window = ClientDSLKt.getMC().getWindow();
            GlUniformFloat glUniformFloat = this.uniformGameTime;
            if (glUniformFloat != null) {
                glUniformFloat.set(Float.valueOf(RenderSystem.getShaderGameTime()));
            }
            GlUniformFloat2v glUniformFloat2v = this.uniformScreenSize;
            if (glUniformFloat2v != null) {
                glUniformFloat2v.set((float)window.getWidth(), (float)window.getHeight());
            }
            Iterable $this$forEach$iv = this.customUniforms;
            boolean $i$f$forEach = false;
            for (Object element$iv : $this$forEach$iv) {
                CustomUniform p0 = (CustomUniform)element$iv;
                boolean bl = false;
                p0.setSodium();
            }
            AbstractTexture abstractTexture = ClientDSLKt.getMC().getTextureManager().getTexture(TextureAtlas.LOCATION_BLOCKS);
            Intrinsics.checkNotNull((Object)abstractTexture, (String)"null cannot be cast to non-null type net.thebrokenscript.brokencore.impl.mixin.compat.sodium.BCTextureAtlasAccessor");
            BCTextureAtlasAccessor textureAtlas = (BCTextureAtlasAccessor)abstractTexture;
            double subTexelPrecision = 1 << GLRenderDevice.INSTANCE.getSubTexelPrecisionBits();
            float subTexelOffset = 3.0517578E-5f;
            GlUniformFloat2v glUniformFloat2v2 = this.uniformTexCoordShrink;
            if (glUniformFloat2v2 != null) {
                glUniformFloat2v2.set((float)((double)subTexelOffset - 1.0 / (double)textureAtlas.tbs$getWidth() / subTexelPrecision), (float)((double)subTexelOffset - 1.0 / (double)textureAtlas.tbs$getHeight() / subTexelPrecision));
            }
            ChunkShaderFogComponent chunkShaderFogComponent = this.fogShader;
            if (chunkShaderFogComponent == null) break block4;
            chunkShaderFogComponent.setup();
        }
    }

    private final void bindTexture(ChunkShaderTextureSlot slot, int textureId) {
        block0: {
            GlStateManager._activeTexture((int)(33984 + slot.ordinal()));
            GlStateManager._bindTexture((int)textureId);
            GlUniformInt glUniformInt = this.uniformTextures.get(slot);
            if (glUniformInt == null) break block0;
            glUniformInt.setInt(slot.ordinal());
        }
    }

    public void resetState() {
    }

    public void setProjectionMatrix(@NotNull Matrix4fc matrix) {
        block0: {
            Intrinsics.checkNotNullParameter((Object)matrix, (String)"matrix");
            GlUniformMatrix4f glUniformMatrix4f = this.uniformProjectionMatrix;
            if (glUniformMatrix4f == null) break block0;
            glUniformMatrix4f.set(matrix);
        }
    }

    public void setModelViewMatrix(@NotNull Matrix4fc matrix) {
        block0: {
            Intrinsics.checkNotNullParameter((Object)matrix, (String)"matrix");
            GlUniformMatrix4f glUniformMatrix4f = this.uniformModelViewMatrix;
            if (glUniformMatrix4f == null) break block0;
            glUniformMatrix4f.set(matrix);
        }
    }

    public void setRegionOffset(float x, float y, float z) {
        block0: {
            GlUniformFloat3v glUniformFloat3v = this.uniformRegionOffset;
            if (glUniformFloat3v == null) break block0;
            glUniformFloat3v.set(x, y, z);
        }
    }
}

