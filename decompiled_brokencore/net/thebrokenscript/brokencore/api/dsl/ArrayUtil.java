/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.JvmName
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.util.RandomSource
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.dsl;

import java.util.Collection;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.util.RandomSource;
import net.thebrokenscript.brokencore.api.util.math.MathUtilKt;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=2, xi=48, d1={"\u0000T\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\u0010\u000b\n\u0002\u0010\u0018\n\u0002\u0010\n\n\u0002\u0010\u0017\n\u0002\u0010\u0015\n\u0002\u0010\u0006\n\u0002\u0010\u0013\n\u0002\u0010\u0007\n\u0002\u0010\u0014\n\u0002\u0010\t\n\u0002\u0010\u0016\n\u0002\u0010\u0011\n\u0002\b\u0002\u001a#\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005\u001a\u0012\u0010\u0006\u001a\u00020\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\n\u001a\u0012\u0010\u0006\u001a\u00020\u000b*\u00020\f2\u0006\u0010\t\u001a\u00020\n\u001a\u0012\u0010\u0006\u001a\u00020\r*\u00020\u000e2\u0006\u0010\t\u001a\u00020\n\u001a\u0012\u0010\u0006\u001a\u00020\n*\u00020\u000f2\u0006\u0010\t\u001a\u00020\n\u001a\u0012\u0010\u0006\u001a\u00020\u0010*\u00020\u00112\u0006\u0010\t\u001a\u00020\n\u001a\u0012\u0010\u0006\u001a\u00020\u0012*\u00020\u00132\u0006\u0010\t\u001a\u00020\n\u001a\u0012\u0010\u0006\u001a\u00020\u0014*\u00020\u00152\u0006\u0010\t\u001a\u00020\n\u001a#\u0010\u0006\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00162\u0006\u0010\t\u001a\u00020\n\u00a2\u0006\u0002\u0010\u0017\u00a8\u0006\u0018"}, d2={"random", "T", "", "rng", "Lnet/minecraft/util/RandomSource;", "(Ljava/util/Collection;Lnet/minecraft/util/RandomSource;)Ljava/lang/Object;", "wGet", "", "", "index", "", "", "", "", "", "", "", "", "", "", "", "", "", "([Ljava/lang/Object;I)Ljava/lang/Object;", "brokencore-common"})
@JvmName(name="ArrayUtil")
public final class ArrayUtil {
    public static final <T> T random(@NotNull Collection<? extends T> $this$random, @NotNull RandomSource rng) {
        Intrinsics.checkNotNullParameter($this$random, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)rng, (String)"rng");
        return (T)CollectionsKt.elementAt((Iterable)$this$random, (int)rng.nextInt(0, $this$random.size()));
    }

    public static final byte wGet(@NotNull byte[] $this$wGet, int index) {
        Intrinsics.checkNotNullParameter((Object)$this$wGet, (String)"<this>");
        return $this$wGet[MathUtilKt.wrap(index, (Number)0, (Number)$this$wGet.length)];
    }

    public static final boolean wGet(@NotNull boolean[] $this$wGet, int index) {
        Intrinsics.checkNotNullParameter((Object)$this$wGet, (String)"<this>");
        return $this$wGet[MathUtilKt.wrap(index, (Number)0, (Number)$this$wGet.length)];
    }

    public static final short wGet(@NotNull short[] $this$wGet, int index) {
        Intrinsics.checkNotNullParameter((Object)$this$wGet, (String)"<this>");
        return $this$wGet[MathUtilKt.wrap(index, (Number)0, (Number)$this$wGet.length)];
    }

    public static final int wGet(@NotNull int[] $this$wGet, int index) {
        Intrinsics.checkNotNullParameter((Object)$this$wGet, (String)"<this>");
        return $this$wGet[MathUtilKt.wrap(index, (Number)0, (Number)$this$wGet.length)];
    }

    public static final double wGet(@NotNull double[] $this$wGet, int index) {
        Intrinsics.checkNotNullParameter((Object)$this$wGet, (String)"<this>");
        return $this$wGet[MathUtilKt.wrap(index, (Number)0, (Number)$this$wGet.length)];
    }

    public static final float wGet(@NotNull float[] $this$wGet, int index) {
        Intrinsics.checkNotNullParameter((Object)$this$wGet, (String)"<this>");
        return $this$wGet[MathUtilKt.wrap(index, (Number)0, (Number)$this$wGet.length)];
    }

    public static final long wGet(@NotNull long[] $this$wGet, int index) {
        Intrinsics.checkNotNullParameter((Object)$this$wGet, (String)"<this>");
        return $this$wGet[MathUtilKt.wrap(index, (Number)0, (Number)$this$wGet.length)];
    }

    public static final <T> T wGet(@NotNull T[] $this$wGet, int index) {
        Intrinsics.checkNotNullParameter($this$wGet, (String)"<this>");
        return $this$wGet[MathUtilKt.wrap(index, (Number)0, (Number)$this$wGet.length)];
    }
}

