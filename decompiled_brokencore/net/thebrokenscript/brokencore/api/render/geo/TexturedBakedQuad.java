/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.core.Direction
 *  net.minecraft.resources.ResourceLocation
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.brokencore.api.render.geo;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.thebrokenscript.brokencore.api.render.geo.TexturedQuad;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0011\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0012\u001a\u00020\u0007H\u00c6\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u00c6\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0017\u001a\u00020\u0018H\u00d6\u0001J\t\u0010\u0019\u001a\u00020\u001aH\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u001b"}, d2={"Lnet/thebrokenscript/brokencore/api/render/geo/TexturedBakedQuad;", "", "quad", "Lnet/thebrokenscript/brokencore/api/render/geo/TexturedQuad;", "sprite", "Lnet/minecraft/resources/ResourceLocation;", "side", "Lnet/minecraft/core/Direction;", "<init>", "(Lnet/thebrokenscript/brokencore/api/render/geo/TexturedQuad;Lnet/minecraft/resources/ResourceLocation;Lnet/minecraft/core/Direction;)V", "getQuad", "()Lnet/thebrokenscript/brokencore/api/render/geo/TexturedQuad;", "getSprite", "()Lnet/minecraft/resources/ResourceLocation;", "getSide", "()Lnet/minecraft/core/Direction;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "brokencore-common"})
public final class TexturedBakedQuad {
    @NotNull
    private final TexturedQuad quad;
    @NotNull
    private final ResourceLocation sprite;
    @NotNull
    private final Direction side;

    public TexturedBakedQuad(@NotNull TexturedQuad quad, @NotNull ResourceLocation sprite, @NotNull Direction side) {
        Intrinsics.checkNotNullParameter((Object)quad, (String)"quad");
        Intrinsics.checkNotNullParameter((Object)sprite, (String)"sprite");
        Intrinsics.checkNotNullParameter((Object)side, (String)"side");
        this.quad = quad;
        this.sprite = sprite;
        this.side = side;
    }

    @NotNull
    public final TexturedQuad getQuad() {
        return this.quad;
    }

    @NotNull
    public final ResourceLocation getSprite() {
        return this.sprite;
    }

    @NotNull
    public final Direction getSide() {
        return this.side;
    }

    @NotNull
    public final TexturedQuad component1() {
        return this.quad;
    }

    @NotNull
    public final ResourceLocation component2() {
        return this.sprite;
    }

    @NotNull
    public final Direction component3() {
        return this.side;
    }

    @NotNull
    public final TexturedBakedQuad copy(@NotNull TexturedQuad quad, @NotNull ResourceLocation sprite, @NotNull Direction side) {
        Intrinsics.checkNotNullParameter((Object)quad, (String)"quad");
        Intrinsics.checkNotNullParameter((Object)sprite, (String)"sprite");
        Intrinsics.checkNotNullParameter((Object)side, (String)"side");
        return new TexturedBakedQuad(quad, sprite, side);
    }

    public static /* synthetic */ TexturedBakedQuad copy$default(TexturedBakedQuad texturedBakedQuad, TexturedQuad texturedQuad, ResourceLocation resourceLocation, Direction direction, int n, Object object) {
        if ((n & 1) != 0) {
            texturedQuad = texturedBakedQuad.quad;
        }
        if ((n & 2) != 0) {
            resourceLocation = texturedBakedQuad.sprite;
        }
        if ((n & 4) != 0) {
            direction = texturedBakedQuad.side;
        }
        return texturedBakedQuad.copy(texturedQuad, resourceLocation, direction);
    }

    @NotNull
    public String toString() {
        return "TexturedBakedQuad(quad=" + this.quad + ", sprite=" + this.sprite + ", side=" + this.side + ")";
    }

    public int hashCode() {
        int result = this.quad.hashCode();
        result = result * 31 + this.sprite.hashCode();
        result = result * 31 + this.side.hashCode();
        return result;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TexturedBakedQuad)) {
            return false;
        }
        TexturedBakedQuad texturedBakedQuad = (TexturedBakedQuad)other;
        if (!Intrinsics.areEqual((Object)this.quad, (Object)texturedBakedQuad.quad)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.sprite, (Object)texturedBakedQuad.sprite)) {
            return false;
        }
        return this.side == texturedBakedQuad.side;
    }
}

