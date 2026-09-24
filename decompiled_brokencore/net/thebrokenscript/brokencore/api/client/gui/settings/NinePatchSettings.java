/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.brokencore.api.client.gui.settings;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 %2\u00020\u0001:\u0001%B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u00a2\u0006\u0004\b\t\u0010\nB)\b\u0016\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u00a2\u0006\u0004\b\t\u0010\u000eB!\b\u0016\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u00a2\u0006\u0004\b\t\u0010\u0010J\t\u0010\u0018\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0019\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001a\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001c\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001d\u001a\u00020\u0003H\u00c6\u0003JE\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\"\u001a\u00020\u0003H\u00d6\u0001J\t\u0010#\u001a\u00020$H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0011\u0010\b\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012\u00a8\u0006&"}, d2={"Lnet/thebrokenscript/brokencore/api/client/gui/settings/NinePatchSettings;", "", "l", "", "r", "t", "b", "w", "h", "<init>", "(IIIIII)V", "v", "width", "height", "(IIII)V", "padding", "(III)V", "getL", "()I", "getR", "getT", "getB", "getW", "getH", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "", "Companion", "brokencore-common"})
public final class NinePatchSettings {
    @NotNull
    public static final Companion Companion = new Companion(null);
    private final int l;
    private final int r;
    private final int t;
    private final int b;
    private final int w;
    private final int h;
    @NotNull
    private static final NinePatchSettings NONE = new NinePatchSettings(0, 0, 0, 0, 0, 0);

    public NinePatchSettings(int l, int r, int t, int b, int w, int h) {
        this.l = l;
        this.r = r;
        this.t = t;
        this.b = b;
        this.w = w;
        this.h = h;
    }

    public final int getL() {
        return this.l;
    }

    public final int getR() {
        return this.r;
    }

    public final int getT() {
        return this.t;
    }

    public final int getB() {
        return this.b;
    }

    public final int getW() {
        return this.w;
    }

    public final int getH() {
        return this.h;
    }

    public NinePatchSettings(int h, int v, int width, int height) {
        this(h, h, v, v, width, height);
    }

    public NinePatchSettings(int padding, int width, int height) {
        this(padding, padding, padding, padding, width, height);
    }

    public final int component1() {
        return this.l;
    }

    public final int component2() {
        return this.r;
    }

    public final int component3() {
        return this.t;
    }

    public final int component4() {
        return this.b;
    }

    public final int component5() {
        return this.w;
    }

    public final int component6() {
        return this.h;
    }

    @NotNull
    public final NinePatchSettings copy(int l, int r, int t, int b, int w, int h) {
        return new NinePatchSettings(l, r, t, b, w, h);
    }

    public static /* synthetic */ NinePatchSettings copy$default(NinePatchSettings ninePatchSettings, int n, int n2, int n3, int n4, int n5, int n6, int n7, Object object) {
        if ((n7 & 1) != 0) {
            n = ninePatchSettings.l;
        }
        if ((n7 & 2) != 0) {
            n2 = ninePatchSettings.r;
        }
        if ((n7 & 4) != 0) {
            n3 = ninePatchSettings.t;
        }
        if ((n7 & 8) != 0) {
            n4 = ninePatchSettings.b;
        }
        if ((n7 & 0x10) != 0) {
            n5 = ninePatchSettings.w;
        }
        if ((n7 & 0x20) != 0) {
            n6 = ninePatchSettings.h;
        }
        return ninePatchSettings.copy(n, n2, n3, n4, n5, n6);
    }

    @NotNull
    public String toString() {
        return "NinePatchSettings(l=" + this.l + ", r=" + this.r + ", t=" + this.t + ", b=" + this.b + ", w=" + this.w + ", h=" + this.h + ")";
    }

    public int hashCode() {
        int result = Integer.hashCode(this.l);
        result = result * 31 + Integer.hashCode(this.r);
        result = result * 31 + Integer.hashCode(this.t);
        result = result * 31 + Integer.hashCode(this.b);
        result = result * 31 + Integer.hashCode(this.w);
        result = result * 31 + Integer.hashCode(this.h);
        return result;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NinePatchSettings)) {
            return false;
        }
        NinePatchSettings ninePatchSettings = (NinePatchSettings)other;
        if (this.l != ninePatchSettings.l) {
            return false;
        }
        if (this.r != ninePatchSettings.r) {
            return false;
        }
        if (this.t != ninePatchSettings.t) {
            return false;
        }
        if (this.b != ninePatchSettings.b) {
            return false;
        }
        if (this.w != ninePatchSettings.w) {
            return false;
        }
        return this.h == ninePatchSettings.h;
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2={"Lnet/thebrokenscript/brokencore/api/client/gui/settings/NinePatchSettings$Companion;", "", "<init>", "()V", "NONE", "Lnet/thebrokenscript/brokencore/api/client/gui/settings/NinePatchSettings;", "getNONE", "()Lnet/thebrokenscript/brokencore/api/client/gui/settings/NinePatchSettings;", "brokencore-common"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final NinePatchSettings getNONE() {
            return NONE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

