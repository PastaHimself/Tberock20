/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.JvmName
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.dsl;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=2, xi=48, d1={"\u0000 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u0004\n\u0002\b\u0003\u001a\u0015\u0010\b\u001a\u00020\u0001*\u00020\t2\u0006\u0010\n\u001a\u00020\u0001H\u0086\u0004\u001a\u0015\u0010\u000b\u001a\u00020\u0001*\u00020\t2\u0006\u0010\n\u001a\u00020\u0001H\u0086\u0004\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00018F\u00a2\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003\"\u0015\u0010\u0000\u001a\u00020\u0004*\u00020\u00048F\u00a2\u0006\u0006\u001a\u0004\b\u0002\u0010\u0005\"\u0015\u0010\u0000\u001a\u00020\u0006*\u00020\u00068F\u00a2\u0006\u0006\u001a\u0004\b\u0002\u0010\u0007\u00a8\u0006\f"}, d2={"squared", "", "getSquared", "(I)I", "", "(F)F", "", "(D)D", "ishr", "", "other", "ishl", "brokencore-common"})
@JvmName(name="MathUtil")
public final class MathUtil {
    public static final int getSquared(int $this$squared) {
        return $this$squared * $this$squared;
    }

    public static final float getSquared(float $this$squared) {
        return $this$squared * $this$squared;
    }

    public static final double getSquared(double $this$squared) {
        return $this$squared * $this$squared;
    }

    public static final int ishr(@NotNull Number $this$ishr, int other) {
        Intrinsics.checkNotNullParameter((Object)$this$ishr, (String)"<this>");
        return $this$ishr.intValue() >> other;
    }

    public static final int ishl(@NotNull Number $this$ishl, int other) {
        Intrinsics.checkNotNullParameter((Object)$this$ishl, (String)"<this>");
        return $this$ishl.intValue() << other;
    }
}

