/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.core.Direction
 *  net.minecraft.resources.ResourceLocation
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.render.geo;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.thebrokenscript.brokencore.api.render.geo.TexturedBakedQuad;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J(\u0010\u0004\u001a\u00020\u00032\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b2\u0006\u0010\t\u001a\u00020\nH\u0016J(\u0010\u0004\u001a\u00020\u00032\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b2\u0006\u0010\u000b\u001a\u00020\fH\u0016\u00a8\u0006\r"}, d2={"Lnet/thebrokenscript/brokencore/api/render/geo/BakeableQuadGeo;", "", "render", "", "collectQuads", "dest", "Ljava/util/ArrayList;", "Lnet/thebrokenscript/brokencore/api/render/geo/TexturedBakedQuad;", "Lkotlin/collections/ArrayList;", "texture", "Lnet/minecraft/resources/ResourceLocation;", "direction", "Lnet/minecraft/core/Direction;", "brokencore-common"})
public interface BakeableQuadGeo {
    public void render();

    public void collectQuads(@NotNull ArrayList<TexturedBakedQuad> var1, @NotNull ResourceLocation var2);

    public void collectQuads(@NotNull ArrayList<TexturedBakedQuad> var1, @NotNull Direction var2);

    @Metadata(mv={2, 1, 0}, k=3, xi=48)
    public static final class DefaultImpls {
        public static void render(@NotNull BakeableQuadGeo $this) {
        }

        public static void collectQuads(@NotNull BakeableQuadGeo $this, @NotNull ArrayList<TexturedBakedQuad> dest, @NotNull ResourceLocation texture) {
            Intrinsics.checkNotNullParameter(dest, (String)"dest");
            Intrinsics.checkNotNullParameter((Object)texture, (String)"texture");
        }

        public static void collectQuads(@NotNull BakeableQuadGeo $this, @NotNull ArrayList<TexturedBakedQuad> dest, @NotNull Direction direction) {
            Intrinsics.checkNotNullParameter(dest, (String)"dest");
            Intrinsics.checkNotNullParameter((Object)direction, (String)"direction");
        }
    }
}

