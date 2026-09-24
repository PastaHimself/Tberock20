/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.math.MathKt
 *  org.jetbrains.annotations.NotNull
 *  org.joml.Vector4f
 */
package net.thebrokenscript.brokencore.api.util;

import kotlin.Metadata;
import kotlin.math.MathKt;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector4f;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u001e\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0007\u00a8\u0006\u000f"}, d2={"Lnet/thebrokenscript/brokencore/api/util/Colors;", "", "<init>", "()V", "splitRgba", "Lorg/joml/Vector4f;", "color", "", "splitArgb", "splitRgb", "lerp", "progress", "", "a", "b", "brokencore-common"})
public final class Colors {
    @NotNull
    public static final Colors INSTANCE = new Colors();

    private Colors() {
    }

    @NotNull
    public final Vector4f splitRgba(int color) {
        int r = color >> 24 & 0xFF;
        int g = color >> 16 & 0xFF;
        int b = color >> 8 & 0xFF;
        int a = color & 0xFF;
        return new Vector4f((float)r / 255.0f, (float)g / 255.0f, (float)b / 255.0f, (float)a / 255.0f);
    }

    @NotNull
    public final Vector4f splitArgb(int color) {
        int a = color >> 24 & 0xFF;
        int r = color >> 16 & 0xFF;
        int g = color >> 8 & 0xFF;
        int b = color & 0xFF;
        return new Vector4f((float)r / 255.0f, (float)g / 255.0f, (float)b / 255.0f, (float)a / 255.0f);
    }

    @NotNull
    public final Vector4f splitRgb(int color) {
        int r = color >> 16 & 0xFF;
        int g = color >> 8 & 0xFF;
        int b = color & 0xFF;
        return new Vector4f((float)r / 255.0f, (float)g / 255.0f, (float)b / 255.0f, 1.0f);
    }

    public final int lerp(float progress, int a, int b) {
        int ar = a >> 16 & 0xFF;
        int ag = a >> 8 & 0xFF;
        int ab = a & 0xFF;
        int br = b >> 16 & 0xFF;
        int bg = b >> 8 & 0xFF;
        int bb = b & 0xFF;
        int cr = MathKt.roundToInt((float)((float)ar * progress + (float)br * (1.0f - progress)));
        int cg = MathKt.roundToInt((float)((float)ag * progress + (float)bg * (1.0f - progress)));
        int cb = MathKt.roundToInt((float)((float)ab * progress + (float)bb * (1.0f - progress)));
        return cr << 16 | cg << 8 | cb;
    }
}

