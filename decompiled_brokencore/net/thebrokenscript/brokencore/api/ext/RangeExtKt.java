/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.ranges.IntRange
 *  kotlin.ranges.LongRange
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.ext;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.LongRange;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=2, xi=48, d1={"\u0000\u0012\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0086\u0002\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0086\u0002\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0086\u0002\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004H\u0086\u0002\u00a8\u0006\u0005"}, d2={"contains", "", "Lkotlin/ranges/IntRange;", "other", "Lkotlin/ranges/LongRange;", "brokencore-common"})
public final class RangeExtKt {
    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static final boolean contains(@NotNull IntRange $this$contains, @NotNull IntRange other) {
        boolean bl;
        Intrinsics.checkNotNullParameter((Object)$this$contains, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)other, (String)"other");
        int n = other.getFirst();
        int n2 = other.getLast();
        int n3 = $this$contains.getFirst();
        if (n <= n3) {
            if (n3 <= n2) {
                return true;
            }
            bl = false;
        } else {
            bl = false;
        }
        if (bl) return true;
        n = other.getFirst();
        n2 = other.getLast();
        n3 = $this$contains.getLast();
        if (n > n3) return false;
        if (n3 > n2) return false;
        return true;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static final boolean contains(@NotNull IntRange $this$contains, @NotNull LongRange other) {
        boolean bl;
        Intrinsics.checkNotNullParameter((Object)$this$contains, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)other, (String)"other");
        long l = other.getFirst();
        long l2 = other.getLast();
        long l3 = $this$contains.getFirst();
        if (l <= l3) {
            if (l3 <= l2) {
                return true;
            }
            bl = false;
        } else {
            bl = false;
        }
        if (bl) return true;
        l = other.getFirst();
        l2 = other.getLast();
        l3 = $this$contains.getLast();
        if (l > l3) return false;
        if (l3 > l2) return false;
        return true;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static final boolean contains(@NotNull LongRange $this$contains, @NotNull IntRange other) {
        boolean bl;
        Intrinsics.checkNotNullParameter((Object)$this$contains, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)other, (String)"other");
        int n = other.getFirst();
        int n2 = other.getLast();
        long l = $this$contains.getFirst();
        if ((long)n <= l) {
            if (l <= (long)n2) {
                return true;
            }
            bl = false;
        } else {
            bl = false;
        }
        if (bl) return true;
        n = other.getFirst();
        n2 = other.getLast();
        l = $this$contains.getLast();
        if ((long)n > l) return false;
        if (l > (long)n2) return false;
        return true;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static final boolean contains(@NotNull LongRange $this$contains, @NotNull LongRange other) {
        boolean bl;
        Intrinsics.checkNotNullParameter((Object)$this$contains, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)other, (String)"other");
        long l = other.getFirst();
        long l2 = other.getLast();
        long l3 = $this$contains.getFirst();
        if (l <= l3) {
            if (l3 <= l2) {
                return true;
            }
            bl = false;
        } else {
            bl = false;
        }
        if (bl) return true;
        l = other.getFirst();
        l2 = other.getLast();
        l3 = $this$contains.getLast();
        if (l > l3) return false;
        if (l3 > l2) return false;
        return true;
    }
}

