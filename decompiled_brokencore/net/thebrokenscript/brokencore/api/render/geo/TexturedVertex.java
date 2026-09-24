/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.vertex.BufferBuilder
 *  com.mojang.blaze3d.vertex.PoseStack
 *  com.mojang.blaze3d.vertex.VertexConsumer
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  org.joml.Vector2f
 *  org.joml.Vector3f
 */
package net.thebrokenscript.brokencore.api.render.geo;

import com.mojang.blaze3d.vertex.BufferBuilder;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.thebrokenscript.brokencore.api.render.geo.TexturedVertexFunction;
import net.thebrokenscript.brokencore.api.render.geo.VertexFunction;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector2f;
import org.joml.Vector3f;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J0\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014J0\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014J.\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\t\u0010\u0019\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001a\u001a\u00020\u0005H\u00c6\u0003J\u001d\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u00d6\u0003J\t\u0010 \u001a\u00020\u0011H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\t\u00a8\u0006!"}, d2={"Lnet/thebrokenscript/brokencore/api/render/geo/TexturedVertex;", "Ljava/lang/Record;", "position", "Lorg/joml/Vector3f;", "uv", "Lorg/joml/Vector2f;", "<init>", "(Lorg/joml/Vector3f;Lorg/joml/Vector2f;)V", "()Lorg/joml/Vector3f;", "()Lorg/joml/Vector2f;", "render", "", "matrices", "Lcom/mojang/blaze3d/vertex/PoseStack;", "consumer", "Lcom/mojang/blaze3d/vertex/VertexConsumer;", "light", "", "index", "vertexFunction", "Lnet/thebrokenscript/brokencore/api/render/geo/VertexFunction;", "Lcom/mojang/blaze3d/vertex/BufferBuilder;", "Lnet/thebrokenscript/brokencore/api/render/geo/TexturedVertexFunction;", "toString", "", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "brokencore-common"})
public final class TexturedVertex
extends Record {
    @NotNull
    private final Vector3f position;
    @NotNull
    private final Vector2f uv;

    public TexturedVertex(@NotNull Vector3f position, @NotNull Vector2f uv) {
        Intrinsics.checkNotNullParameter((Object)position, (String)"position");
        Intrinsics.checkNotNullParameter((Object)uv, (String)"uv");
        this.position = position;
        this.uv = uv;
    }

    @NotNull
    public final Vector3f position() {
        return this.position;
    }

    @NotNull
    public final Vector2f uv() {
        return this.uv;
    }

    public final void render(@NotNull PoseStack matrices, @NotNull VertexConsumer consumer, int light, int index, @Nullable VertexFunction vertexFunction) {
        Intrinsics.checkNotNullParameter((Object)matrices, (String)"matrices");
        Intrinsics.checkNotNullParameter((Object)consumer, (String)"consumer");
        Vector3f ofs = new Vector3f(0.0f);
        if (vertexFunction != null) {
            ofs = vertexFunction.run(index);
        }
        consumer.addVertex(matrices.last().pose(), this.position.x + ofs.x, this.position.y + ofs.y, this.position.z + ofs.z).setColor(1.0f, 1.0f, 1.0f, 1.0f).setUv(this.uv.x, this.uv.y).setOverlay(0).setNormal(0.0f, 0.0f, 0.0f).setLight(light);
    }

    public final void render(@NotNull PoseStack matrices, @NotNull BufferBuilder consumer, int light, int index, @Nullable VertexFunction vertexFunction) {
        Intrinsics.checkNotNullParameter((Object)matrices, (String)"matrices");
        Intrinsics.checkNotNullParameter((Object)consumer, (String)"consumer");
        Vector3f ofs = new Vector3f(0.0f);
        if (vertexFunction != null) {
            ofs = vertexFunction.run(index);
        }
        consumer.addVertex(matrices.last().pose(), this.position.x + ofs.x, this.position.y + ofs.y, this.position.z + ofs.z).setColor(1.0f, 1.0f, 1.0f, 1.0f).setUv(this.uv.x, this.uv.y).setOverlay(0).setNormal(0.0f, 0.0f, 0.0f).setLight(light);
    }

    public final void render(@NotNull PoseStack matrices, @NotNull BufferBuilder consumer, int light, int index, @NotNull TexturedVertexFunction vertexFunction) {
        Intrinsics.checkNotNullParameter((Object)matrices, (String)"matrices");
        Intrinsics.checkNotNullParameter((Object)consumer, (String)"consumer");
        Intrinsics.checkNotNullParameter((Object)vertexFunction, (String)"vertexFunction");
        TexturedVertex vec = vertexFunction.run(index);
        Vector3f ofs = vec.position;
        Vector2f uvOfs = vec.uv;
        consumer.addVertex(matrices.last().pose(), this.position.x + ofs.x, this.position.y + ofs.y, this.position.z + ofs.z).setColor(1.0f, 1.0f, 1.0f, 1.0f).setUv(this.uv.x + uvOfs.x, this.uv.y + uvOfs.y).setLight(light);
    }

    @Override
    @NotNull
    public String toString() {
        return "Position:" + this.position.x + "|" + this.position.y + "|" + this.position.z + " UV:" + this.uv.x + "|" + this.uv.y;
    }

    @NotNull
    public final Vector3f component1() {
        return this.position;
    }

    @NotNull
    public final Vector2f component2() {
        return this.uv;
    }

    @NotNull
    public final TexturedVertex copy(@NotNull Vector3f position, @NotNull Vector2f uv) {
        Intrinsics.checkNotNullParameter((Object)position, (String)"position");
        Intrinsics.checkNotNullParameter((Object)uv, (String)"uv");
        return new TexturedVertex(position, uv);
    }

    public static /* synthetic */ TexturedVertex copy$default(TexturedVertex texturedVertex, Vector3f vector3f, Vector2f vector2f, int n, Object object) {
        if ((n & 1) != 0) {
            vector3f = texturedVertex.position;
        }
        if ((n & 2) != 0) {
            vector2f = texturedVertex.uv;
        }
        return texturedVertex.copy(vector3f, vector2f);
    }

    @Override
    public int hashCode() {
        int result = this.position.hashCode();
        result = result * 31 + this.uv.hashCode();
        return result;
    }

    @Override
    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TexturedVertex)) {
            return false;
        }
        TexturedVertex texturedVertex = (TexturedVertex)other;
        if (!Intrinsics.areEqual((Object)this.position, (Object)texturedVertex.position)) {
            return false;
        }
        return Intrinsics.areEqual((Object)this.uv, (Object)texturedVertex.uv);
    }
}

