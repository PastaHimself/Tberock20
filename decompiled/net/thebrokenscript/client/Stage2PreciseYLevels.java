/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.enums.EnumEntries
 *  kotlin.enums.EnumEntriesKt
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.ranges.ClosedFloatingPointRange
 *  kotlin.ranges.RangesKt
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.client;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.ClosedFloatingPointRange;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0086\u0081\u0002\u0018\u0000 \u00122\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0012B\u001b\b\u0002\u0012\u0010\u0010\u0002\u001a\f\u0012\u0004\u0012\u00020\u00040\u0003j\u0002`\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u001b\u0010\u0002\u001a\f\u0012\u0004\u0012\u00020\u00040\u0003j\u0002`\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011\u00a8\u0006\u0013"}, d2={"Lnet/thebrokenscript/client/Stage2PreciseYLevels;", "", "yRange", "Lkotlin/ranges/ClosedFloatingPointRange;", "", "Lnet/thebrokenscript/client/DoubleRange;", "<init>", "(Ljava/lang/String;ILkotlin/ranges/ClosedFloatingPointRange;)V", "getYRange", "()Lkotlin/ranges/ClosedFloatingPointRange;", "FLOOR_1", "FLOOR_2", "FLOOR_2_3", "FLOOR_3", "FLOOR_4", "FLOOR_5", "FLOOR_6", "FLOOR_7", "Companion", "thebrokenscript-common"})
public final class Stage2PreciseYLevels
extends Enum<Stage2PreciseYLevels> {
    @NotNull
    public static final Companion Companion;
    @NotNull
    private final ClosedFloatingPointRange<Double> yRange;
    public static final /* enum */ Stage2PreciseYLevels FLOOR_1;
    public static final /* enum */ Stage2PreciseYLevels FLOOR_2;
    public static final /* enum */ Stage2PreciseYLevels FLOOR_2_3;
    public static final /* enum */ Stage2PreciseYLevels FLOOR_3;
    public static final /* enum */ Stage2PreciseYLevels FLOOR_4;
    public static final /* enum */ Stage2PreciseYLevels FLOOR_5;
    public static final /* enum */ Stage2PreciseYLevels FLOOR_6;
    public static final /* enum */ Stage2PreciseYLevels FLOOR_7;
    private static final /* synthetic */ Stage2PreciseYLevels[] $VALUES;
    private static final /* synthetic */ EnumEntries $ENTRIES;

    private Stage2PreciseYLevels(ClosedFloatingPointRange<Double> yRange) {
        this.yRange = yRange;
    }

    @NotNull
    public final ClosedFloatingPointRange<Double> getYRange() {
        return this.yRange;
    }

    public static Stage2PreciseYLevels[] values() {
        return (Stage2PreciseYLevels[])$VALUES.clone();
    }

    public static Stage2PreciseYLevels valueOf(String value) {
        return Enum.valueOf(Stage2PreciseYLevels.class, value);
    }

    @NotNull
    public static EnumEntries<Stage2PreciseYLevels> getEntries() {
        return $ENTRIES;
    }

    static {
        FLOOR_1 = new Stage2PreciseYLevels((ClosedFloatingPointRange<Double>)RangesKt.rangeTo((double)253.0, (double)320.0));
        FLOOR_2 = new Stage2PreciseYLevels((ClosedFloatingPointRange<Double>)RangesKt.rangeTo((double)232.0, (double)253.0));
        FLOOR_2_3 = new Stage2PreciseYLevels((ClosedFloatingPointRange<Double>)RangesKt.rangeTo((double)231.0, (double)232.0));
        FLOOR_3 = new Stage2PreciseYLevels((ClosedFloatingPointRange<Double>)RangesKt.rangeTo((double)216.0, (double)231.0));
        FLOOR_4 = new Stage2PreciseYLevels((ClosedFloatingPointRange<Double>)RangesKt.rangeTo((double)206.0, (double)216.0));
        FLOOR_5 = new Stage2PreciseYLevels((ClosedFloatingPointRange<Double>)RangesKt.rangeTo((double)200.0, (double)206.0));
        FLOOR_6 = new Stage2PreciseYLevels((ClosedFloatingPointRange<Double>)RangesKt.rangeTo((double)160.0, (double)200.0));
        FLOOR_7 = new Stage2PreciseYLevels((ClosedFloatingPointRange<Double>)RangesKt.rangeTo((double)-64.0, (double)160.0));
        $VALUES = stage2PreciseYLevelsArray = new Stage2PreciseYLevels[]{Stage2PreciseYLevels.FLOOR_1, Stage2PreciseYLevels.FLOOR_2, Stage2PreciseYLevels.FLOOR_2_3, Stage2PreciseYLevels.FLOOR_3, Stage2PreciseYLevels.FLOOR_4, Stage2PreciseYLevels.FLOOR_5, Stage2PreciseYLevels.FLOOR_6, Stage2PreciseYLevels.FLOOR_7};
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
        Companion = new Companion(null);
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007\u00a8\u0006\b"}, d2={"Lnet/thebrokenscript/client/Stage2PreciseYLevels$Companion;", "", "<init>", "()V", "fromY", "Lnet/thebrokenscript/client/Stage2PreciseYLevels;", "y", "", "thebrokenscript-common"})
    @SourceDebugExtension(value={"SMAP\nTBSRenderEvents.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TBSRenderEvents.kt\nnet/thebrokenscript/client/Stage2PreciseYLevels$Companion\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,223:1\n295#2,2:224\n*S KotlinDebug\n*F\n+ 1 TBSRenderEvents.kt\nnet/thebrokenscript/client/Stage2PreciseYLevels$Companion\n*L\n49#1:224,2\n*E\n"})
    public static final class Companion {
        private Companion() {
        }

        @Nullable
        public final Stage2PreciseYLevels fromY(double y) {
            Object v0;
            block1: {
                Iterable $this$firstOrNull$iv = (Iterable)Stage2PreciseYLevels.getEntries();
                boolean $i$f$firstOrNull = false;
                for (Object element$iv : $this$firstOrNull$iv) {
                    Stage2PreciseYLevels it = (Stage2PreciseYLevels)((Object)element$iv);
                    boolean bl = false;
                    if (!it.getYRange().contains((Comparable)Double.valueOf(y))) continue;
                    v0 = element$iv;
                    break block1;
                }
                v0 = null;
            }
            return v0;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

