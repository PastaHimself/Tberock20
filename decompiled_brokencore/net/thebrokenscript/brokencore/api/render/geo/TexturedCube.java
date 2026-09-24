/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.vertex.PoseStack
 *  kotlin.Metadata
 *  kotlin.enums.EnumEntries
 *  kotlin.enums.EnumEntriesKt
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.client.renderer.MultiBufferSource
 *  net.minecraft.client.renderer.RenderType
 *  net.minecraft.core.Direction
 *  net.minecraft.resources.ResourceLocation
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  org.joml.Vector2f
 */
package net.thebrokenscript.brokencore.api.render.geo;

import com.mojang.blaze3d.vertex.PoseStack;
import java.util.ArrayList;
import java.util.function.Function;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.thebrokenscript.brokencore.api.render.geo.BakeableQuadGeo;
import net.thebrokenscript.brokencore.api.render.geo.TexturedBakedQuad;
import net.thebrokenscript.brokencore.api.render.geo.TexturedQuad;
import net.thebrokenscript.brokencore.api.render.geo.VertexFunction;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector2f;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\b\u0018\u0000 12\u00020\u00012\u00020\u0002:\u000201B7\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\u0004\u0012\u0006\u0010\t\u001a\u00020\u0004\u00a2\u0006\u0004\b\n\u0010\u000bJ(\u0010\r\u001a\u00020\u000e2\u0016\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00110\u0010j\b\u0012\u0004\u0012\u00020\u0011`\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J0\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00192\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cJ@\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00192\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cJ\t\u0010\"\u001a\u00020\u0004H\u00c6\u0003J\t\u0010#\u001a\u00020\u0004H\u00c6\u0003J\t\u0010$\u001a\u00020\u0004H\u00c6\u0003J\t\u0010%\u001a\u00020\u0004H\u00c6\u0003J\t\u0010&\u001a\u00020\u0004H\u00c6\u0003J\t\u0010'\u001a\u00020\u0004H\u00c6\u0003JE\u0010(\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u00042\b\b\u0002\u0010\t\u001a\u00020\u0004H\u00c6\u0001J\u0013\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010,H\u00d6\u0003J\t\u0010-\u001a\u00020\u0019H\u00d6\u0001J\t\u0010.\u001a\u00020/H\u00d6\u0001R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\fR\u0011\u0010\b\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\fR\u0011\u0010\t\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\f\u00a8\u00062"}, d2={"Lnet/thebrokenscript/brokencore/api/render/geo/TexturedCube;", "Lnet/thebrokenscript/brokencore/api/render/geo/BakeableQuadGeo;", "Ljava/lang/Record;", "t", "Lnet/thebrokenscript/brokencore/api/render/geo/TexturedQuad;", "b", "n", "s", "e", "w", "<init>", "(Lnet/thebrokenscript/brokencore/api/render/geo/TexturedQuad;Lnet/thebrokenscript/brokencore/api/render/geo/TexturedQuad;Lnet/thebrokenscript/brokencore/api/render/geo/TexturedQuad;Lnet/thebrokenscript/brokencore/api/render/geo/TexturedQuad;Lnet/thebrokenscript/brokencore/api/render/geo/TexturedQuad;Lnet/thebrokenscript/brokencore/api/render/geo/TexturedQuad;)V", "()Lnet/thebrokenscript/brokencore/api/render/geo/TexturedQuad;", "collectQuads", "", "dest", "Ljava/util/ArrayList;", "Lnet/thebrokenscript/brokencore/api/render/geo/TexturedBakedQuad;", "Lkotlin/collections/ArrayList;", "texture", "Lnet/minecraft/resources/ResourceLocation;", "render", "matrices", "Lcom/mojang/blaze3d/vertex/PoseStack;", "light", "", "index", "vertexFunction", "Lnet/thebrokenscript/brokencore/api/render/geo/VertexFunction;", "blockTexture", "consumer", "Lnet/minecraft/client/renderer/MultiBufferSource;", "layer", "Lnet/minecraft/client/renderer/RenderType;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "", "hashCode", "toString", "", "CubeSide", "Companion", "brokencore-common"})
public final class TexturedCube
extends Record
implements BakeableQuadGeo {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final TexturedQuad t;
    @NotNull
    private final TexturedQuad b;
    @NotNull
    private final TexturedQuad n;
    @NotNull
    private final TexturedQuad s;
    @NotNull
    private final TexturedQuad e;
    @NotNull
    private final TexturedQuad w;

    public TexturedCube(@NotNull TexturedQuad t, @NotNull TexturedQuad b, @NotNull TexturedQuad n, @NotNull TexturedQuad s, @NotNull TexturedQuad e, @NotNull TexturedQuad w) {
        Intrinsics.checkNotNullParameter((Object)t, (String)"t");
        Intrinsics.checkNotNullParameter((Object)b, (String)"b");
        Intrinsics.checkNotNullParameter((Object)n, (String)"n");
        Intrinsics.checkNotNullParameter((Object)s, (String)"s");
        Intrinsics.checkNotNullParameter((Object)e, (String)"e");
        Intrinsics.checkNotNullParameter((Object)w, (String)"w");
        this.t = t;
        this.b = b;
        this.n = n;
        this.s = s;
        this.e = e;
        this.w = w;
    }

    @NotNull
    public final TexturedQuad t() {
        return this.t;
    }

    @NotNull
    public final TexturedQuad b() {
        return this.b;
    }

    @NotNull
    public final TexturedQuad n() {
        return this.n;
    }

    @NotNull
    public final TexturedQuad s() {
        return this.s;
    }

    @NotNull
    public final TexturedQuad e() {
        return this.e;
    }

    @NotNull
    public final TexturedQuad w() {
        return this.w;
    }

    @Override
    public void collectQuads(@NotNull ArrayList<TexturedBakedQuad> dest, @NotNull ResourceLocation texture) {
        Intrinsics.checkNotNullParameter(dest, (String)"dest");
        Intrinsics.checkNotNullParameter((Object)texture, (String)"texture");
        this.t.collectQuads(dest, texture, Direction.UP);
        this.b.collectQuads(dest, texture, Direction.DOWN);
        this.n.collectQuads(dest, texture, Direction.NORTH);
        this.s.collectQuads(dest, texture, Direction.SOUTH);
        this.e.collectQuads(dest, texture, Direction.EAST);
        this.w.collectQuads(dest, texture, Direction.WEST);
    }

    public final void render(@NotNull PoseStack matrices, @NotNull ResourceLocation texture, int light, int index, @Nullable VertexFunction vertexFunction) {
        Intrinsics.checkNotNullParameter((Object)matrices, (String)"matrices");
        Intrinsics.checkNotNullParameter((Object)texture, (String)"texture");
        this.t.render(matrices, texture, light, index, vertexFunction);
        this.b.render(matrices, texture, light, index, vertexFunction);
        this.n.render(matrices, texture, light, index, vertexFunction);
        this.s.render(matrices, texture, light, index, vertexFunction);
        this.e.render(matrices, texture, light, index, vertexFunction);
        this.w.render(matrices, texture, light, index, vertexFunction);
    }

    public final void render(@NotNull PoseStack matrices, @NotNull ResourceLocation blockTexture, @NotNull MultiBufferSource consumer, @NotNull RenderType layer, int light, int index, @Nullable VertexFunction vertexFunction) {
        Intrinsics.checkNotNullParameter((Object)matrices, (String)"matrices");
        Intrinsics.checkNotNullParameter((Object)blockTexture, (String)"blockTexture");
        Intrinsics.checkNotNullParameter((Object)consumer, (String)"consumer");
        Intrinsics.checkNotNullParameter((Object)layer, (String)"layer");
        this.t.render(matrices, blockTexture, light, index, layer, consumer, vertexFunction);
        this.b.render(matrices, blockTexture, light, index, layer, consumer, vertexFunction);
        this.n.render(matrices, blockTexture, light, index, layer, consumer, vertexFunction);
        this.s.render(matrices, blockTexture, light, index, layer, consumer, vertexFunction);
        this.e.render(matrices, blockTexture, light, index, layer, consumer, vertexFunction);
        this.w.render(matrices, blockTexture, light, index, layer, consumer, vertexFunction);
    }

    @NotNull
    public final TexturedQuad component1() {
        return this.t;
    }

    @NotNull
    public final TexturedQuad component2() {
        return this.b;
    }

    @NotNull
    public final TexturedQuad component3() {
        return this.n;
    }

    @NotNull
    public final TexturedQuad component4() {
        return this.s;
    }

    @NotNull
    public final TexturedQuad component5() {
        return this.e;
    }

    @NotNull
    public final TexturedQuad component6() {
        return this.w;
    }

    @NotNull
    public final TexturedCube copy(@NotNull TexturedQuad t, @NotNull TexturedQuad b, @NotNull TexturedQuad n, @NotNull TexturedQuad s, @NotNull TexturedQuad e, @NotNull TexturedQuad w) {
        Intrinsics.checkNotNullParameter((Object)t, (String)"t");
        Intrinsics.checkNotNullParameter((Object)b, (String)"b");
        Intrinsics.checkNotNullParameter((Object)n, (String)"n");
        Intrinsics.checkNotNullParameter((Object)s, (String)"s");
        Intrinsics.checkNotNullParameter((Object)e, (String)"e");
        Intrinsics.checkNotNullParameter((Object)w, (String)"w");
        return new TexturedCube(t, b, n, s, e, w);
    }

    public static /* synthetic */ TexturedCube copy$default(TexturedCube texturedCube, TexturedQuad texturedQuad, TexturedQuad texturedQuad2, TexturedQuad texturedQuad3, TexturedQuad texturedQuad4, TexturedQuad texturedQuad5, TexturedQuad texturedQuad6, int n, Object object) {
        if ((n & 1) != 0) {
            texturedQuad = texturedCube.t;
        }
        if ((n & 2) != 0) {
            texturedQuad2 = texturedCube.b;
        }
        if ((n & 4) != 0) {
            texturedQuad3 = texturedCube.n;
        }
        if ((n & 8) != 0) {
            texturedQuad4 = texturedCube.s;
        }
        if ((n & 0x10) != 0) {
            texturedQuad5 = texturedCube.e;
        }
        if ((n & 0x20) != 0) {
            texturedQuad6 = texturedCube.w;
        }
        return texturedCube.copy(texturedQuad, texturedQuad2, texturedQuad3, texturedQuad4, texturedQuad5, texturedQuad6);
    }

    @Override
    @NotNull
    public String toString() {
        return "TexturedCube(t=" + this.t + ", b=" + this.b + ", n=" + this.n + ", s=" + this.s + ", e=" + this.e + ", w=" + this.w + ")";
    }

    @Override
    public int hashCode() {
        int result = this.t.hashCode();
        result = result * 31 + this.b.hashCode();
        result = result * 31 + this.n.hashCode();
        result = result * 31 + this.s.hashCode();
        result = result * 31 + this.e.hashCode();
        result = result * 31 + this.w.hashCode();
        return result;
    }

    @Override
    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TexturedCube)) {
            return false;
        }
        TexturedCube texturedCube = (TexturedCube)other;
        if (!Intrinsics.areEqual((Object)this.t, (Object)texturedCube.t)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.b, (Object)texturedCube.b)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.n, (Object)texturedCube.n)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.s, (Object)texturedCube.s)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.e, (Object)texturedCube.e)) {
            return false;
        }
        return Intrinsics.areEqual((Object)this.w, (Object)texturedCube.w);
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J\u0006\u0010\u0006\u001a\u00020\u0005\u00a8\u0006\u0007"}, d2={"Lnet/thebrokenscript/brokencore/api/render/geo/TexturedCube$Companion;", "", "<init>", "()V", "oneTextureBlockCentered", "Lnet/thebrokenscript/brokencore/api/render/geo/TexturedCube;", "oneTextureBlock", "brokencore-common"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final TexturedCube oneTextureBlockCentered() {
            TexturedQuad t = TexturedQuad.Companion.createHorizontal(new Vector2f(0.5f, 0.5f), new Vector2f(-0.5f, 0.5f), new Vector2f(-0.5f, 0.5f), 0.5f);
            TexturedQuad b = TexturedQuad.Companion.createHorizontal(new Vector2f(0.5f, 0.5f), new Vector2f(-0.5f, 0.5f), new Vector2f(-0.5f, 0.5f), 0.0f);
            TexturedQuad n = TexturedQuad.Companion.createVerticalZ(new Vector2f(0.5f, 0.5f), new Vector2f(-0.5f, 0.5f), new Vector2f(-0.5f, 0.5f), 0.0f);
            TexturedQuad s = TexturedQuad.Companion.createVerticalZ(new Vector2f(0.5f, 0.5f), new Vector2f(-0.5f, 0.5f), new Vector2f(-0.5f, 0.5f), 0.5f);
            TexturedQuad e = TexturedQuad.Companion.createVerticalX(new Vector2f(0.5f, 0.5f), new Vector2f(-0.5f, 0.5f), new Vector2f(-0.5f, 0.5f), 0.0f);
            TexturedQuad w = TexturedQuad.Companion.createVerticalX(new Vector2f(0.5f, 0.5f), new Vector2f(-0.5f, 0.5f), new Vector2f(-0.5f, 0.5f), 0.5f);
            return new TexturedCube(t, b, n, s, e, w);
        }

        @NotNull
        public final TexturedCube oneTextureBlock() {
            TexturedQuad t = TexturedQuad.Companion.createHorizontal(new Vector2f(1.0f, 1.0f), new Vector2f(0.0f, 1.0f), new Vector2f(0.0f, 1.0f), 1.0f);
            TexturedQuad b = TexturedQuad.Companion.createHorizontal(new Vector2f(1.0f, 1.0f), new Vector2f(0.0f, 1.0f), new Vector2f(0.0f, 1.0f), 0.0f);
            TexturedQuad n = TexturedQuad.Companion.createVerticalZ(new Vector2f(1.0f, 1.0f), new Vector2f(0.0f, 1.0f), new Vector2f(0.0f, 1.0f), 0.0f);
            TexturedQuad s = TexturedQuad.Companion.createVerticalZ(new Vector2f(1.0f, 1.0f), new Vector2f(0.0f, 1.0f), new Vector2f(0.0f, 1.0f), 1.0f);
            TexturedQuad e = TexturedQuad.Companion.createVerticalX(new Vector2f(1.0f, 1.0f), new Vector2f(0.0f, 1.0f), new Vector2f(0.0f, 1.0f), 0.0f);
            TexturedQuad w = TexturedQuad.Companion.createVerticalX(new Vector2f(1.0f, 1.0f), new Vector2f(0.0f, 1.0f), new Vector2f(0.0f, 1.0f), 1.0f);
            return new TexturedCube(t, b, n, s, e, w);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u001d\b\u0002\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f\u00a8\u0006\u0010"}, d2={"Lnet/thebrokenscript/brokencore/api/render/geo/TexturedCube$CubeSide;", "", "func", "Ljava/util/function/Function;", "Lnet/thebrokenscript/brokencore/api/render/geo/TexturedCube;", "Lnet/thebrokenscript/brokencore/api/render/geo/TexturedQuad;", "<init>", "(Ljava/lang/String;ILjava/util/function/Function;)V", "getFunc", "()Ljava/util/function/Function;", "U", "D", "N", "S", "E", "W", "brokencore-common"})
    public static final class CubeSide
    extends Enum<CubeSide> {
        @NotNull
        private final Function<TexturedCube, TexturedQuad> func;
        public static final /* enum */ CubeSide U = new CubeSide(CubeSide::_init_$lambda$0);
        public static final /* enum */ CubeSide D = new CubeSide(CubeSide::_init_$lambda$1);
        public static final /* enum */ CubeSide N = new CubeSide(CubeSide::_init_$lambda$2);
        public static final /* enum */ CubeSide S = new CubeSide(CubeSide::_init_$lambda$3);
        public static final /* enum */ CubeSide E = new CubeSide(CubeSide::_init_$lambda$4);
        public static final /* enum */ CubeSide W = new CubeSide(CubeSide::_init_$lambda$5);
        private static final /* synthetic */ CubeSide[] $VALUES;
        private static final /* synthetic */ EnumEntries $ENTRIES;

        private CubeSide(Function<TexturedCube, TexturedQuad> func) {
            this.func = func;
        }

        @NotNull
        public final Function<TexturedCube, TexturedQuad> getFunc() {
            return this.func;
        }

        public static CubeSide[] values() {
            return (CubeSide[])$VALUES.clone();
        }

        public static CubeSide valueOf(String value) {
            return Enum.valueOf(CubeSide.class, value);
        }

        @NotNull
        public static EnumEntries<CubeSide> getEntries() {
            return $ENTRIES;
        }

        private static final TexturedQuad _init_$lambda$0(TexturedCube cube) {
            Intrinsics.checkNotNullParameter((Object)cube, (String)"cube");
            return cube.t();
        }

        private static final TexturedQuad _init_$lambda$1(TexturedCube cube) {
            Intrinsics.checkNotNullParameter((Object)cube, (String)"cube");
            return cube.b();
        }

        private static final TexturedQuad _init_$lambda$2(TexturedCube cube) {
            Intrinsics.checkNotNullParameter((Object)cube, (String)"cube");
            return cube.n();
        }

        private static final TexturedQuad _init_$lambda$3(TexturedCube cube) {
            Intrinsics.checkNotNullParameter((Object)cube, (String)"cube");
            return cube.s();
        }

        private static final TexturedQuad _init_$lambda$4(TexturedCube cube) {
            Intrinsics.checkNotNullParameter((Object)cube, (String)"cube");
            return cube.e();
        }

        private static final TexturedQuad _init_$lambda$5(TexturedCube cube) {
            Intrinsics.checkNotNullParameter((Object)cube, (String)"cube");
            return cube.w();
        }

        static {
            $VALUES = cubeSideArray = new CubeSide[]{CubeSide.U, CubeSide.D, CubeSide.N, CubeSide.S, CubeSide.E, CubeSide.W};
            $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
        }
    }
}

