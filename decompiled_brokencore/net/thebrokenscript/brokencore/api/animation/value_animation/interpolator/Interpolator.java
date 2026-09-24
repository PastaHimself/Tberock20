/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.animation.value_animation.interpolator;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import net.thebrokenscript.brokencore.api.animation.value_animation.Easing;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\n\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0005\u0010\u0006B\t\b\u0016\u00a2\u0006\u0004\b\u0005\u0010\u0007J%\u0010\b\u001a\u00028\u00002\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00028\u00002\u0006\u0010\f\u001a\u00028\u0000H&\u00a2\u0006\u0002\u0010\rJ-\u0010\u000e\u001a\u00028\u00002\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00028\u00002\u0006\u0010\f\u001a\u00028\u0000H&\u00a2\u0006\u0002\u0010\u000fJ5\u0010\b\u001a\u00028\u00002\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00028\u00002\u0006\u0010\f\u001a\u00028\u00002\u0006\u0010\u0010\u001a\u00028\u00002\u0006\u0010\u0011\u001a\u00028\u0000H\u0016\u00a2\u0006\u0002\u0010\u0012J=\u0010\u000e\u001a\u00028\u00002\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00028\u00002\u0006\u0010\f\u001a\u00028\u00002\u0006\u0010\u0010\u001a\u00028\u00002\u0006\u0010\u0011\u001a\u00028\u0000H\u0016\u00a2\u0006\u0002\u0010\u0013R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2={"Lnet/thebrokenscript/brokencore/api/animation/value_animation/interpolator/Interpolator;", "T", "", "easing", "Lnet/thebrokenscript/brokencore/api/animation/value_animation/Easing;", "<init>", "(Lnet/thebrokenscript/brokencore/api/animation/value_animation/Easing;)V", "()V", "interpolate", "delta", "", "min", "max", "(FLjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "withEasing", "(Lnet/thebrokenscript/brokencore/api/animation/value_animation/Easing;FLjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "prevMin", "nextMax", "(FLjava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "(Lnet/thebrokenscript/brokencore/api/animation/value_animation/Easing;FLjava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "brokencore-common"})
public abstract class Interpolator<T> {
    @JvmField
    @NotNull
    public final Easing easing;

    public Interpolator(@NotNull Easing easing) {
        Intrinsics.checkNotNullParameter((Object)easing, (String)"easing");
        this.easing = easing;
    }

    public Interpolator() {
        this.easing = Easing.Companion.getLINEAR();
    }

    public abstract T interpolate(float var1, T var2, T var3);

    public abstract T withEasing(@NotNull Easing var1, float var2, T var3, T var4);

    public T interpolate(float delta, T min, T max, T prevMin, T nextMax) {
        return this.interpolate(delta, min, max);
    }

    public T withEasing(@NotNull Easing easing, float delta, T min, T max, T prevMin, T nextMax) {
        Intrinsics.checkNotNullParameter((Object)easing, (String)"easing");
        return this.withEasing(easing, delta, min, max);
    }
}

