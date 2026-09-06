/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.ranges.RangesKt
 *  net.minecraft.util.Mth
 *  net.minecraft.world.level.levelgen.synth.ImprovedNoise
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.util;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import net.minecraft.util.Mth;
import net.minecraft.world.level.levelgen.synth.ImprovedNoise;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0005"}, d2={"Lnet/thebrokenscript/util/NoiseUtil;", "", "<init>", "()V", "Companion", "thebrokenscript-common"})
public final class NoiseUtil {
    @NotNull
    public static final Companion Companion = new Companion(null);

    @JvmStatic
    public static final double noise(double x, double y, double z, double yScale, double yMax, @NotNull ImprovedNoise noise) {
        return Companion.noise(x, y, z, yScale, yMax, noise);
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J8\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u000bH\u0007\u00a8\u0006\f"}, d2={"Lnet/thebrokenscript/util/NoiseUtil$Companion;", "", "<init>", "()V", "noise", "", "x", "y", "z", "yScale", "yMax", "Lnet/minecraft/world/level/levelgen/synth/ImprovedNoise;", "thebrokenscript-common"})
    public static final class Companion {
        private Companion() {
        }

        @JvmStatic
        public final double noise(double x, double y, double z, double yScale, double yMax, @NotNull ImprovedNoise noise) {
            Intrinsics.checkNotNullParameter((Object)noise, (String)"noise");
            double d0 = x + noise.xo;
            double d1 = y + noise.yo;
            double d2 = z + noise.zo;
            int i = Mth.floor((double)d0);
            int j = Mth.floor((double)d1);
            int k = Mth.floor((double)d2);
            double d3 = d0 - (double)i;
            double d4 = d1 - (double)j;
            double d5 = d2 - (double)k;
            double d6 = 0.0;
            if (!(yScale == 0.0)) {
                double d7 = RangesKt.rangeUntil((double)0.0, (double)d4).contains((Comparable)Double.valueOf(yMax)) ? yMax : d4;
                d6 = (double)Mth.floor((double)(d7 / yScale + 1.0E-7)) * yScale;
            } else {
                d6 = 0.0;
            }
            return noise.sampleAndLerp(i, j, k, d3, d4 - d6, d5, d4);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

