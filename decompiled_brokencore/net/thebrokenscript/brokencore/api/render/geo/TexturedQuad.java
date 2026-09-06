/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.systems.RenderSystem
 *  com.mojang.blaze3d.vertex.BufferBuilder
 *  com.mojang.blaze3d.vertex.BufferUploader
 *  com.mojang.blaze3d.vertex.DefaultVertexFormat
 *  com.mojang.blaze3d.vertex.MeshData
 *  com.mojang.blaze3d.vertex.PoseStack
 *  com.mojang.blaze3d.vertex.Tesselator
 *  com.mojang.blaze3d.vertex.VertexConsumer
 *  com.mojang.blaze3d.vertex.VertexFormat$Mode
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.client.renderer.GameRenderer
 *  net.minecraft.client.renderer.MultiBufferSource
 *  net.minecraft.client.renderer.RenderType
 *  net.minecraft.client.renderer.texture.TextureAtlas
 *  net.minecraft.client.renderer.texture.TextureAtlasSprite
 *  net.minecraft.core.Direction
 *  net.minecraft.resources.ResourceLocation
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  org.joml.Vector2f
 *  org.joml.Vector3f
 *  org.joml.Vector3fc
 */
package net.thebrokenscript.brokencore.api.render.geo;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.BufferBuilder;
import com.mojang.blaze3d.vertex.BufferUploader;
import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import com.mojang.blaze3d.vertex.MeshData;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.Tesselator;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.VertexFormat;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.texture.TextureAtlas;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.thebrokenscript.brokencore.api.dsl.ClientDSLKt;
import net.thebrokenscript.brokencore.api.render.geo.BakeableQuadGeo;
import net.thebrokenscript.brokencore.api.render.geo.TexturedBakedQuad;
import net.thebrokenscript.brokencore.api.render.geo.TexturedVertex;
import net.thebrokenscript.brokencore.api.render.geo.VertexFunction;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector2f;
import org.joml.Vector3f;
import org.joml.Vector3fc;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0016\u0018\u0000 (2\u00020\u0001:\u0001(B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0007\u0010\bJ.\u0010\u000e\u001a\u00020\u000f2\u0016\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u00120\u0011j\b\u0012\u0004\u0012\u00020\u0012`\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017J@\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$J0\u0010\u0018\u001a\u00020\u000f2\u0006\u0010%\u001a\u00020\u001a2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001d2\b\u0010#\u001a\u0004\u0018\u00010$J\b\u0010&\u001a\u00020'H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n\u00a8\u0006)"}, d2={"Lnet/thebrokenscript/brokencore/api/render/geo/TexturedQuad;", "Lnet/thebrokenscript/brokencore/api/render/geo/BakeableQuadGeo;", "bl", "Lnet/thebrokenscript/brokencore/api/render/geo/TexturedVertex;", "br", "tl", "tr", "<init>", "(Lnet/thebrokenscript/brokencore/api/render/geo/TexturedVertex;Lnet/thebrokenscript/brokencore/api/render/geo/TexturedVertex;Lnet/thebrokenscript/brokencore/api/render/geo/TexturedVertex;Lnet/thebrokenscript/brokencore/api/render/geo/TexturedVertex;)V", "getBl", "()Lnet/thebrokenscript/brokencore/api/render/geo/TexturedVertex;", "getBr", "getTl", "getTr", "collectQuads", "", "dest", "Ljava/util/ArrayList;", "Lnet/thebrokenscript/brokencore/api/render/geo/TexturedBakedQuad;", "Lkotlin/collections/ArrayList;", "texture", "Lnet/minecraft/resources/ResourceLocation;", "direction", "Lnet/minecraft/core/Direction;", "render", "matricies", "Lcom/mojang/blaze3d/vertex/PoseStack;", "blockTexture", "light", "", "index", "layer", "Lnet/minecraft/client/renderer/RenderType;", "provider", "Lnet/minecraft/client/renderer/MultiBufferSource;", "vertexFunction", "Lnet/thebrokenscript/brokencore/api/render/geo/VertexFunction;", "matrices", "toString", "", "Companion", "brokencore-common"})
public class TexturedQuad
implements BakeableQuadGeo {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final TexturedVertex bl;
    @NotNull
    private final TexturedVertex br;
    @NotNull
    private final TexturedVertex tl;
    @NotNull
    private final TexturedVertex tr;

    public TexturedQuad(@NotNull TexturedVertex bl, @NotNull TexturedVertex br, @NotNull TexturedVertex tl, @NotNull TexturedVertex tr) {
        Intrinsics.checkNotNullParameter((Object)bl, (String)"bl");
        Intrinsics.checkNotNullParameter((Object)br, (String)"br");
        Intrinsics.checkNotNullParameter((Object)tl, (String)"tl");
        Intrinsics.checkNotNullParameter((Object)tr, (String)"tr");
        this.bl = bl;
        this.br = br;
        this.tl = tl;
        this.tr = tr;
    }

    @NotNull
    public final TexturedVertex getBl() {
        return this.bl;
    }

    @NotNull
    public final TexturedVertex getBr() {
        return this.br;
    }

    @NotNull
    public final TexturedVertex getTl() {
        return this.tl;
    }

    @NotNull
    public final TexturedVertex getTr() {
        return this.tr;
    }

    public final void collectQuads(@NotNull ArrayList<TexturedBakedQuad> dest, @NotNull ResourceLocation texture, @NotNull Direction direction) {
        Intrinsics.checkNotNullParameter(dest, (String)"dest");
        Intrinsics.checkNotNullParameter((Object)texture, (String)"texture");
        Intrinsics.checkNotNullParameter((Object)direction, (String)"direction");
        dest.add(new TexturedBakedQuad(this, texture, direction));
    }

    public final void render(@NotNull PoseStack matricies, @NotNull ResourceLocation blockTexture, int light, int index, @NotNull RenderType layer, @NotNull MultiBufferSource provider, @Nullable VertexFunction vertexFunction) {
        Intrinsics.checkNotNullParameter((Object)matricies, (String)"matricies");
        Intrinsics.checkNotNullParameter((Object)blockTexture, (String)"blockTexture");
        Intrinsics.checkNotNullParameter((Object)layer, (String)"layer");
        Intrinsics.checkNotNullParameter((Object)provider, (String)"provider");
        RenderSystem.enableDepthTest();
        RenderSystem.disableCull();
        TextureAtlasSprite atlas = (TextureAtlasSprite)ClientDSLKt.getMC().getTextureAtlas(TextureAtlas.LOCATION_BLOCKS).apply(blockTexture);
        VertexConsumer consumer = atlas.wrap(provider.getBuffer(layer));
        Intrinsics.checkNotNull((Object)consumer);
        this.bl.render(matricies, consumer, light, index, vertexFunction);
        this.br.render(matricies, consumer, light, index, vertexFunction);
        this.tl.render(matricies, consumer, light, index + 1, vertexFunction);
        this.tr.render(matricies, consumer, light, index + 1, vertexFunction);
        this.tr.render(matricies, consumer, light, index, vertexFunction);
        this.tl.render(matricies, consumer, light, index, vertexFunction);
        this.br.render(matricies, consumer, light, index + 1, vertexFunction);
        this.bl.render(matricies, consumer, light, index + 1, vertexFunction);
        RenderSystem.disableDepthTest();
        RenderSystem.enableCull();
    }

    public final void render(@NotNull PoseStack matrices, @NotNull ResourceLocation texture, int light, int index, @Nullable VertexFunction vertexFunction) {
        Intrinsics.checkNotNullParameter((Object)matrices, (String)"matrices");
        Intrinsics.checkNotNullParameter((Object)texture, (String)"texture");
        RenderSystem.setShader(GameRenderer::getPositionColorTexLightmapShader);
        RenderSystem.setShaderTexture((int)0, (ResourceLocation)texture);
        RenderSystem.enableBlend();
        RenderSystem.enableDepthTest();
        RenderSystem.disableCull();
        BufferBuilder consumer = Tesselator.getInstance().begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_COLOR_TEX_LIGHTMAP);
        Intrinsics.checkNotNull((Object)consumer);
        this.bl.render(matrices, consumer, light, index, vertexFunction);
        this.tl.render(matrices, consumer, light, index + 1, vertexFunction);
        this.tr.render(matrices, consumer, light, index + 1, vertexFunction);
        this.br.render(matrices, consumer, light, index, vertexFunction);
        BufferUploader.draw((MeshData)consumer.buildOrThrow());
        RenderSystem.disableDepthTest();
        RenderSystem.enableCull();
    }

    @NotNull
    public String toString() {
        return "TexturedQuad{bl=" + this.bl + ", br=" + this.br + ", tl=" + this.tl + ", tr=" + this.tr + "}";
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bJ&\u0010\f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bJ&\u0010\r\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bJ&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000fJ&\u0010\f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000fJ&\u0010\r\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000f\u00a8\u0006\u0010"}, d2={"Lnet/thebrokenscript/brokencore/api/render/geo/TexturedQuad$Companion;", "", "<init>", "()V", "createVerticalX", "Lnet/thebrokenscript/brokencore/api/render/geo/TexturedQuad;", "size", "Lorg/joml/Vector2f;", "u", "v", "ofs", "Lorg/joml/Vector3f;", "createVerticalZ", "createHorizontal", "depth_ofs", "", "brokencore-common"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final TexturedQuad createVerticalX(@NotNull Vector2f size, @NotNull Vector2f u, @NotNull Vector2f v, @NotNull Vector3f ofs) {
            Intrinsics.checkNotNullParameter((Object)size, (String)"size");
            Intrinsics.checkNotNullParameter((Object)u, (String)"u");
            Intrinsics.checkNotNullParameter((Object)v, (String)"v");
            Intrinsics.checkNotNullParameter((Object)ofs, (String)"ofs");
            TexturedVertex bl = new TexturedVertex(ofs, new Vector2f(u.x, v.x));
            Vector3f vector3f = new Vector3f(size.x, 0.0f, 0.0f).add((Vector3fc)ofs);
            Intrinsics.checkNotNullExpressionValue((Object)vector3f, (String)"add(...)");
            TexturedVertex br = new TexturedVertex(vector3f, new Vector2f(u.y, v.x));
            Vector3f vector3f2 = new Vector3f(0.0f, size.y, 0.0f).add((Vector3fc)ofs);
            Intrinsics.checkNotNullExpressionValue((Object)vector3f2, (String)"add(...)");
            TexturedVertex tl = new TexturedVertex(vector3f2, new Vector2f(u.x, v.y));
            Vector3f vector3f3 = new Vector3f(size.x, size.y, 0.0f).add((Vector3fc)ofs);
            Intrinsics.checkNotNullExpressionValue((Object)vector3f3, (String)"add(...)");
            TexturedVertex tr = new TexturedVertex(vector3f3, new Vector2f(u.y, v.y));
            return new TexturedQuad(bl, br, tl, tr);
        }

        @NotNull
        public final TexturedQuad createVerticalZ(@NotNull Vector2f size, @NotNull Vector2f u, @NotNull Vector2f v, @NotNull Vector3f ofs) {
            Intrinsics.checkNotNullParameter((Object)size, (String)"size");
            Intrinsics.checkNotNullParameter((Object)u, (String)"u");
            Intrinsics.checkNotNullParameter((Object)v, (String)"v");
            Intrinsics.checkNotNullParameter((Object)ofs, (String)"ofs");
            TexturedVertex bl = new TexturedVertex(ofs, new Vector2f(u.x, v.x));
            Vector3f vector3f = new Vector3f(0.0f, 0.0f, size.x).add((Vector3fc)ofs);
            Intrinsics.checkNotNullExpressionValue((Object)vector3f, (String)"add(...)");
            TexturedVertex br = new TexturedVertex(vector3f, new Vector2f(u.y, v.x));
            Vector3f vector3f2 = new Vector3f(0.0f, size.y, 0.0f).add((Vector3fc)ofs);
            Intrinsics.checkNotNullExpressionValue((Object)vector3f2, (String)"add(...)");
            TexturedVertex tl = new TexturedVertex(vector3f2, new Vector2f(u.x, v.y));
            Vector3f vector3f3 = new Vector3f(0.0f, size.y, size.x).add((Vector3fc)ofs);
            Intrinsics.checkNotNullExpressionValue((Object)vector3f3, (String)"add(...)");
            TexturedVertex tr = new TexturedVertex(vector3f3, new Vector2f(u.y, v.y));
            return new TexturedQuad(bl, br, tl, tr);
        }

        @NotNull
        public final TexturedQuad createHorizontal(@NotNull Vector2f size, @NotNull Vector2f u, @NotNull Vector2f v, @NotNull Vector3f ofs) {
            Intrinsics.checkNotNullParameter((Object)size, (String)"size");
            Intrinsics.checkNotNullParameter((Object)u, (String)"u");
            Intrinsics.checkNotNullParameter((Object)v, (String)"v");
            Intrinsics.checkNotNullParameter((Object)ofs, (String)"ofs");
            TexturedVertex bl = new TexturedVertex(ofs, new Vector2f(u.x, v.x));
            Vector3f vector3f = new Vector3f(size.x, 0.0f, 0.0f).add((Vector3fc)ofs);
            Intrinsics.checkNotNullExpressionValue((Object)vector3f, (String)"add(...)");
            TexturedVertex br = new TexturedVertex(vector3f, new Vector2f(u.y, v.x));
            Vector3f vector3f2 = new Vector3f(0.0f, 0.0f, size.y).add((Vector3fc)ofs);
            Intrinsics.checkNotNullExpressionValue((Object)vector3f2, (String)"add(...)");
            TexturedVertex tl = new TexturedVertex(vector3f2, new Vector2f(u.x, v.y));
            Vector3f vector3f3 = new Vector3f(size.x, 0.0f, size.y).add((Vector3fc)ofs);
            Intrinsics.checkNotNullExpressionValue((Object)vector3f3, (String)"add(...)");
            TexturedVertex tr = new TexturedVertex(vector3f3, new Vector2f(u.y, v.y));
            return new TexturedQuad(bl, br, tl, tr);
        }

        @NotNull
        public final TexturedQuad createVerticalX(@NotNull Vector2f size, @NotNull Vector2f u, @NotNull Vector2f v, float depth_ofs) {
            Intrinsics.checkNotNullParameter((Object)size, (String)"size");
            Intrinsics.checkNotNullParameter((Object)u, (String)"u");
            Intrinsics.checkNotNullParameter((Object)v, (String)"v");
            TexturedVertex bl = new TexturedVertex(new Vector3f(0.0f, 0.0f, depth_ofs), new Vector2f(u.x, v.x));
            TexturedVertex br = new TexturedVertex(new Vector3f(size.x, 0.0f, depth_ofs), new Vector2f(u.y, v.x));
            TexturedVertex tl = new TexturedVertex(new Vector3f(0.0f, size.y, depth_ofs), new Vector2f(u.x, v.y));
            TexturedVertex tr = new TexturedVertex(new Vector3f(size.x, size.y, depth_ofs), new Vector2f(u.y, v.y));
            return new TexturedQuad(bl, br, tl, tr);
        }

        @NotNull
        public final TexturedQuad createVerticalZ(@NotNull Vector2f size, @NotNull Vector2f u, @NotNull Vector2f v, float depth_ofs) {
            Intrinsics.checkNotNullParameter((Object)size, (String)"size");
            Intrinsics.checkNotNullParameter((Object)u, (String)"u");
            Intrinsics.checkNotNullParameter((Object)v, (String)"v");
            TexturedVertex bl = new TexturedVertex(new Vector3f(depth_ofs, 0.0f, 0.0f), new Vector2f(u.x, v.x));
            TexturedVertex br = new TexturedVertex(new Vector3f(depth_ofs, 0.0f, size.x), new Vector2f(u.y, v.x));
            TexturedVertex tl = new TexturedVertex(new Vector3f(depth_ofs, size.y, 0.0f), new Vector2f(u.x, v.y));
            TexturedVertex tr = new TexturedVertex(new Vector3f(depth_ofs, size.y, size.x), new Vector2f(u.y, v.y));
            return new TexturedQuad(bl, br, tl, tr);
        }

        @NotNull
        public final TexturedQuad createHorizontal(@NotNull Vector2f size, @NotNull Vector2f u, @NotNull Vector2f v, float depth_ofs) {
            Intrinsics.checkNotNullParameter((Object)size, (String)"size");
            Intrinsics.checkNotNullParameter((Object)u, (String)"u");
            Intrinsics.checkNotNullParameter((Object)v, (String)"v");
            TexturedVertex bl = new TexturedVertex(new Vector3f(0.0f, depth_ofs, 0.0f), new Vector2f(u.x, v.x));
            TexturedVertex br = new TexturedVertex(new Vector3f(size.x, depth_ofs, 0.0f), new Vector2f(u.y, v.x));
            TexturedVertex tl = new TexturedVertex(new Vector3f(0.0f, depth_ofs, size.y), new Vector2f(u.x, v.y));
            TexturedVertex tr = new TexturedVertex(new Vector3f(size.x, depth_ofs, size.y), new Vector2f(u.y, v.y));
            return new TexturedQuad(bl, br, tl, tr);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

