/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DoubleCompanionObject
 *  kotlin.jvm.internal.FloatCompanionObject
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.ranges.ClosedFloatingPointRange
 *  kotlin.ranges.IntRange
 *  kotlin.ranges.LongRange
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.global;

import kotlin.Metadata;
import kotlin.jvm.internal.DoubleCompanionObject;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.ClosedFloatingPointRange;
import kotlin.ranges.IntRange;
import kotlin.ranges.LongRange;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=2, xi=48, d1={"\u0000B\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0015\u0010\u000e\u001a\u00020\u000f*\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0086\u0004\u001a\u0015\u0010\u000e\u001a\u00020\u0012*\u00020\u00122\u0006\u0010\u0010\u001a\u00020\u0011H\u0086\u0004\u001a\u0015\u0010\u000e\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u0011H\u0086\u0004\u001a\u0015\u0010\u000e\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0011H\u0086\u0004\u001a\u0015\u0010\u0013\u001a\u00020\u000f*\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0086\u0004\u001a\u0015\u0010\u0013\u001a\u00020\u0012*\u00020\u00122\u0006\u0010\u0010\u001a\u00020\u0011H\u0086\u0004\u001a\u0015\u0010\u0013\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u0011H\u0086\u0004\u001a\u0015\u0010\u0013\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0011H\u0086\u0004\u001a\u0015\u0010\u0014\u001a\u00020\u000f*\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0016H\u0086\u0004\u001a\u0015\u0010\u0014\u001a\u00020\u0012*\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0017H\u0086\u0004\u001a\u001b\u0010\u0014\u001a\u00020\u0001*\u00020\u00012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00010\u0018H\u0086\u0004\u001a\u001b\u0010\u0014\u001a\u00020\u0006*\u00020\u00062\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00060\u0018H\u0086\u0004\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00018F\u00a2\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003\"\u0015\u0010\u0004\u001a\u00020\u0001*\u00020\u00018F\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0003\"\u0015\u0010\u0000\u001a\u00020\u0006*\u00020\u00068F\u00a2\u0006\u0006\u001a\u0004\b\u0002\u0010\u0007\"\u0015\u0010\u0004\u001a\u00020\u0006*\u00020\u00068F\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0007\"\u0015\u0010\b\u001a\u00020\u0001*\u00020\t8F\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000b\"\u0015\u0010\b\u001a\u00020\u0006*\u00020\f8F\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\r\u00a8\u0006\u0019"}, d2={"toRadians", "", "getToRadians", "(F)F", "toDegrees", "getToDegrees", "", "(D)D", "PI", "Lkotlin/Float$Companion;", "getPI", "(Lkotlin/jvm/internal/FloatCompanionObject;)F", "Lkotlin/Double$Companion;", "(Lkotlin/jvm/internal/DoubleCompanionObject;)D", "min", "", "other", "", "", "max", "clamp", "range", "Lkotlin/ranges/IntRange;", "Lkotlin/ranges/LongRange;", "Lkotlin/ranges/ClosedFloatingPointRange;", "brokencore-common"})
public final class GlobalMathKt {
    public static final float getToRadians(float $this$toRadians) {
        return $this$toRadians * (GlobalMathKt.getPI(FloatCompanionObject.INSTANCE) / 180.0f);
    }

    public static final float getToDegrees(float $this$toDegrees) {
        return $this$toDegrees * (180.0f / GlobalMathKt.getPI(FloatCompanionObject.INSTANCE));
    }

    public static final double getToRadians(double $this$toRadians) {
        return $this$toRadians * (GlobalMathKt.getPI(DoubleCompanionObject.INSTANCE) / 180.0);
    }

    public static final double getToDegrees(double $this$toDegrees) {
        return $this$toDegrees * (180.0 / GlobalMathKt.getPI(DoubleCompanionObject.INSTANCE));
    }

    public static final float getPI(@NotNull FloatCompanionObject $this$PI) {
        Intrinsics.checkNotNullParameter((Object)$this$PI, (String)"<this>");
        return 3.141592f;
    }

    public static final double getPI(@NotNull DoubleCompanionObject $this$PI) {
        Intrinsics.checkNotNullParameter((Object)$this$PI, (String)"<this>");
        return 3.14159265359;
    }

    public static final int min(int $this$min, @NotNull Number other) {
        Intrinsics.checkNotNullParameter((Object)other, (String)"other");
        return Math.min($this$min, other.intValue());
    }

    public static final long min(long $this$min, @NotNull Number other) {
        Intrinsics.checkNotNullParameter((Object)other, (String)"other");
        return Math.min($this$min, other.longValue());
    }

    public static final float min(float $this$min, @NotNull Number other) {
        Intrinsics.checkNotNullParameter((Object)other, (String)"other");
        return Math.min($this$min, other.floatValue());
    }

    public static final double min(double $this$min, @NotNull Number other) {
        Intrinsics.checkNotNullParameter((Object)other, (String)"other");
        return Math.min($this$min, other.doubleValue());
    }

    public static final int max(int $this$max, @NotNull Number other) {
        Intrinsics.checkNotNullParameter((Object)other, (String)"other");
        return Math.max($this$max, other.intValue());
    }

    public static final long max(long $this$max, @NotNull Number other) {
        Intrinsics.checkNotNullParameter((Object)other, (String)"other");
        return Math.max($this$max, other.longValue());
    }

    public static final float max(float $this$max, @NotNull Number other) {
        Intrinsics.checkNotNullParameter((Object)other, (String)"other");
        return Math.max($this$max, other.floatValue());
    }

    public static final double max(double $this$max, @NotNull Number other) {
        Intrinsics.checkNotNullParameter((Object)other, (String)"other");
        return Math.max($this$max, other.doubleValue());
    }

    public static final int clamp(int $this$clamp, @NotNull IntRange range) {
        Intrinsics.checkNotNullParameter((Object)range, (String)"range");
        return GlobalMathKt.min(GlobalMathKt.max($this$clamp, (Number)range.getFirst()), (Number)range.getLast());
    }

    public static final long clamp(long $this$clamp, @NotNull LongRange range) {
        Intrinsics.checkNotNullParameter((Object)range, (String)"range");
        return GlobalMathKt.min(GlobalMathKt.max($this$clamp, (Number)range.getFirst()), (Number)range.getLast());
    }

    public static final float clamp(float $this$clamp, @NotNull ClosedFloatingPointRange<Float> range) {
        Intrinsics.checkNotNullParameter(range, (String)"range");
        return GlobalMathKt.min(GlobalMathKt.max($this$clamp, (Number)((Object)range.getStart())), (Number)((Object)range.getEndInclusive()));
    }

    public static final double clamp(double $this$clamp, @NotNull ClosedFloatingPointRange<Double> range) {
        Intrinsics.checkNotNullParameter(range, (String)"range");
        return GlobalMathKt.min(GlobalMathKt.max($this$clamp, (Number)((Object)range.getStart())), (Number)((Object)range.getEndInclusive()));
    }
}

