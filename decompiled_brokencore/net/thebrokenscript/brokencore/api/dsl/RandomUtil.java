/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.JvmName
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.util.Mth
 *  net.minecraft.util.RandomSource
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.dsl;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=2, xi=48, d1={"\u0000&\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0000\u001a#\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0004\u00a2\u0006\u0002\u0010\u0005\u001a#\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0006\u00a2\u0006\u0002\u0010\u0007\u001a\u001a\u0010\b\u001a\u00020\t*\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t\u001a\u001a\u0010\f\u001a\u00020\r*\u00020\u00022\u0006\u0010\n\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\r\u00a8\u0006\u000e"}, d2={"choose", "T", "Lnet/minecraft/util/RandomSource;", "from", "", "(Lnet/minecraft/util/RandomSource;[Ljava/lang/Object;)Ljava/lang/Object;", "", "(Lnet/minecraft/util/RandomSource;Ljava/util/List;)Ljava/lang/Object;", "nextFloat", "", "min", "max", "nextDouble", "", "brokencore-common"})
@JvmName(name="RandomUtil")
public final class RandomUtil {
    public static final <T> T choose(@NotNull RandomSource $this$choose, @NotNull T[] from) {
        Intrinsics.checkNotNullParameter((Object)$this$choose, (String)"<this>");
        Intrinsics.checkNotNullParameter(from, (String)"from");
        return from[$this$choose.nextInt(0, from.length)];
    }

    public static final <T> T choose(@NotNull RandomSource $this$choose, @NotNull List<? extends T> from) {
        Intrinsics.checkNotNullParameter((Object)$this$choose, (String)"<this>");
        Intrinsics.checkNotNullParameter(from, (String)"from");
        return from.get($this$choose.nextInt(0, from.size()));
    }

    public static final float nextFloat(@NotNull RandomSource $this$nextFloat, float min, float max) {
        Intrinsics.checkNotNullParameter((Object)$this$nextFloat, (String)"<this>");
        return Mth.nextFloat((RandomSource)$this$nextFloat, (float)min, (float)max);
    }

    public static final double nextDouble(@NotNull RandomSource $this$nextDouble, double min, double max) {
        Intrinsics.checkNotNullParameter((Object)$this$nextDouble, (String)"<this>");
        return Mth.nextDouble((RandomSource)$this$nextDouble, (double)min, (double)max);
    }
}

