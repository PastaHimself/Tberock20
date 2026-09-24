/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.random.Random
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.client;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import net.thebrokenscript.client.TBSLibraryAnimations;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\f\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003\u00a2\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aJ\t\u0010\u001e\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010 \u001a\u00020\u0003H\u00c6\u0003J\t\u0010!\u001a\u00020\u0007H\u00c6\u0003J\t\u0010\"\u001a\u00020\u0003H\u00c6\u0003J;\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010$\u001a\u00020\u001c2\b\u0010%\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010&\u001a\u00020\u0003H\u00d6\u0001J\t\u0010'\u001a\u00020(H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\f\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0011\u0010\b\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\fR\u000e\u0010\u0016\u001a\u00020\u0003X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u001b\u001a\u00020\u001c8F\u00a2\u0006\u0006\u001a\u0004\b\u001b\u0010\u001d\u00a8\u0006)"}, d2={"Lnet/thebrokenscript/client/NoisyScreenChar;", "", "x", "", "y", "lifeTime", "char", "", "refreshRate", "<init>", "(IIICI)V", "getX", "()I", "getY", "getLifeTime", "setLifeTime", "(I)V", "getChar", "()C", "setChar", "(C)V", "getRefreshRate", "ticksSinceLast", "update", "", "random", "Lkotlin/random/Random;", "isExpired", "", "()Z", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "", "thebrokenscript-common"})
public final class NoisyScreenChar {
    private final int x;
    private final int y;
    private int lifeTime;
    private char char;
    private final int refreshRate;
    private int ticksSinceLast;

    public NoisyScreenChar(int x, int y, int lifeTime, char c, int refreshRate) {
        this.x = x;
        this.y = y;
        this.lifeTime = lifeTime;
        this.char = c;
        this.refreshRate = refreshRate;
    }

    public final int getX() {
        return this.x;
    }

    public final int getY() {
        return this.y;
    }

    public final int getLifeTime() {
        return this.lifeTime;
    }

    public final void setLifeTime(int n) {
        this.lifeTime = n;
    }

    public final char getChar() {
        return this.char;
    }

    public final void setChar(char c) {
        this.char = c;
    }

    public final int getRefreshRate() {
        return this.refreshRate;
    }

    public final void update(@NotNull Random random) {
        Intrinsics.checkNotNullParameter((Object)random, (String)"random");
        int n = this.lifeTime;
        this.lifeTime = n + -1;
        n = this.ticksSinceLast;
        this.ticksSinceLast = n + 1;
        if (this.ticksSinceLast >= this.refreshRate) {
            this.char = TBSLibraryAnimations.INSTANCE.randomChar(random);
        }
    }

    public final boolean isExpired() {
        return this.lifeTime <= 0;
    }

    public final int component1() {
        return this.x;
    }

    public final int component2() {
        return this.y;
    }

    public final int component3() {
        return this.lifeTime;
    }

    public final char component4() {
        return this.char;
    }

    public final int component5() {
        return this.refreshRate;
    }

    @NotNull
    public final NoisyScreenChar copy(int x, int y, int lifeTime, char c, int refreshRate) {
        return new NoisyScreenChar(x, y, lifeTime, c, refreshRate);
    }

    public static /* synthetic */ NoisyScreenChar copy$default(NoisyScreenChar noisyScreenChar, int n, int n2, int n3, char c, int n4, int n5, Object object) {
        if ((n5 & 1) != 0) {
            n = noisyScreenChar.x;
        }
        if ((n5 & 2) != 0) {
            n2 = noisyScreenChar.y;
        }
        if ((n5 & 4) != 0) {
            n3 = noisyScreenChar.lifeTime;
        }
        if ((n5 & 8) != 0) {
            c = noisyScreenChar.char;
        }
        if ((n5 & 0x10) != 0) {
            n4 = noisyScreenChar.refreshRate;
        }
        return noisyScreenChar.copy(n, n2, n3, c, n4);
    }

    @NotNull
    public String toString() {
        return "NoisyScreenChar(x=" + this.x + ", y=" + this.y + ", lifeTime=" + this.lifeTime + ", char=" + this.char + ", refreshRate=" + this.refreshRate + ")";
    }

    public int hashCode() {
        int result = Integer.hashCode(this.x);
        result = result * 31 + Integer.hashCode(this.y);
        result = result * 31 + Integer.hashCode(this.lifeTime);
        result = result * 31 + Character.hashCode(this.char);
        result = result * 31 + Integer.hashCode(this.refreshRate);
        return result;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NoisyScreenChar)) {
            return false;
        }
        NoisyScreenChar noisyScreenChar = (NoisyScreenChar)other;
        if (this.x != noisyScreenChar.x) {
            return false;
        }
        if (this.y != noisyScreenChar.y) {
            return false;
        }
        if (this.lifeTime != noisyScreenChar.lifeTime) {
            return false;
        }
        if (this.char != noisyScreenChar.char) {
            return false;
        }
        return this.refreshRate == noisyScreenChar.refreshRate;
    }
}

