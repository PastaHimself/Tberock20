/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.animation.value_animation.interpolator;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.thebrokenscript.brokencore.api.animation.value_animation.Easing;
import net.thebrokenscript.brokencore.api.animation.value_animation.interpolator.IntInterpolator;
import net.thebrokenscript.brokencore.api.animation.value_animation.interpolator.Interpolator;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B%\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0012\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0006\"\u00028\u0000\u00a2\u0006\u0004\b\u0007\u0010\bB\u001d\b\u0016\u0012\u0012\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0006\"\u00028\u0000\u00a2\u0006\u0004\b\u0007\u0010\tJ-\u0010\r\u001a\u00028\u00002\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00028\u00002\u0006\u0010\u0011\u001a\u00028\u0000H\u0016\u00a2\u0006\u0002\u0010\u0012J%\u0010\u0013\u001a\u00028\u00002\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00028\u00002\u0006\u0010\u0011\u001a\u00028\u0000H\u0016\u00a2\u0006\u0002\u0010\u0014R\u0018\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0006X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2={"Lnet/thebrokenscript/brokencore/api/animation/value_animation/interpolator/GenericInterpolator;", "T", "Lnet/thebrokenscript/brokencore/api/animation/value_animation/interpolator/Interpolator;", "easing", "Lnet/thebrokenscript/brokencore/api/animation/value_animation/Easing;", "objs", "", "<init>", "(Lnet/thebrokenscript/brokencore/api/animation/value_animation/Easing;[Ljava/lang/Object;)V", "([Ljava/lang/Object;)V", "[Ljava/lang/Object;", "interpolator", "Lnet/thebrokenscript/brokencore/api/animation/value_animation/interpolator/IntInterpolator;", "withEasing", "delta", "", "min", "max", "(Lnet/thebrokenscript/brokencore/api/animation/value_animation/Easing;FLjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "interpolate", "(FLjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "brokencore-common"})
public final class GenericInterpolator<T>
extends Interpolator<T> {
    @NotNull
    private final T[] objs;
    @NotNull
    private final IntInterpolator interpolator;

    public GenericInterpolator(@NotNull Easing easing, T ... objs) {
        Intrinsics.checkNotNullParameter((Object)easing, (String)"easing");
        Intrinsics.checkNotNullParameter(objs, (String)"objs");
        super(Easing.Companion.getLINEAR());
        this.objs = objs;
        this.interpolator = new IntInterpolator(easing);
    }

    public GenericInterpolator(T ... objs) {
        Intrinsics.checkNotNullParameter(objs, (String)"objs");
        super(Easing.Companion.getLINEAR());
        this.objs = objs;
        this.interpolator = new IntInterpolator();
    }

    @Override
    public T withEasing(@NotNull Easing easing, float delta, T min, T max) {
        Intrinsics.checkNotNullParameter((Object)easing, (String)"easing");
        int i = this.interpolator.withEasing(easing, delta, 0, this.objs.length - 1);
        return this.objs[i];
    }

    @Override
    public T interpolate(float delta, T min, T max) {
        int i = this.interpolator.interpolate(delta, 0, this.objs.length - 1);
        return this.objs[i];
    }
}

