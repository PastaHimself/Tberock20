/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.animation.value_animation.interpolator;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import net.thebrokenscript.brokencore.api.animation.value_animation.Easing;
import net.thebrokenscript.brokencore.api.animation.value_animation.interpolator.IntInterpolator;
import net.thebrokenscript.brokencore.api.animation.value_animation.interpolator.Interpolator;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B5\b\u0016\u0012*\u0010\u0003\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00028\u00000\u00050\u0004\"\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00028\u00000\u0005\u00a2\u0006\u0004\b\u0007\u0010\bB=\b\u0016\u0012\u0006\u0010\t\u001a\u00020\n\u0012*\u0010\u0003\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00028\u00000\u00050\u0004\"\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00028\u00000\u0005\u00a2\u0006\u0004\b\u0007\u0010\u000bJ%\u0010\u000f\u001a\u00028\u00002\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00028\u00002\u0006\u0010\u0012\u001a\u00028\u0000H\u0016\u00a2\u0006\u0002\u0010\u0013J-\u0010\u0014\u001a\u00028\u00002\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00028\u00002\u0006\u0010\u0012\u001a\u00028\u0000H\u0016\u00a2\u0006\u0002\u0010\u0015R$\u0010\u0003\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00028\u00000\u00050\u0004X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2={"Lnet/thebrokenscript/brokencore/api/animation/value_animation/interpolator/FunctionInterpolator;", "T", "Lnet/thebrokenscript/brokencore/api/animation/value_animation/interpolator/Interpolator;", "funcs", "", "Lkotlin/Function1;", "", "<init>", "([Lkotlin/jvm/functions/Function1;)V", "easing", "Lnet/thebrokenscript/brokencore/api/animation/value_animation/Easing;", "(Lnet/thebrokenscript/brokencore/api/animation/value_animation/Easing;[Lkotlin/jvm/functions/Function1;)V", "[Lkotlin/jvm/functions/Function1;", "interpolator", "Lnet/thebrokenscript/brokencore/api/animation/value_animation/interpolator/IntInterpolator;", "interpolate", "delta", "min", "max", "(FLjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "withEasing", "(Lnet/thebrokenscript/brokencore/api/animation/value_animation/Easing;FLjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "brokencore-common"})
public final class FunctionInterpolator<T>
extends Interpolator<T> {
    @NotNull
    private final Function1<Float, T>[] funcs;
    @NotNull
    private final IntInterpolator interpolator;

    public FunctionInterpolator(Function1<? super Float, ? extends T> ... funcs) {
        Intrinsics.checkNotNullParameter(funcs, (String)"funcs");
        super(Easing.Companion.getLINEAR());
        this.funcs = funcs;
        this.interpolator = new IntInterpolator();
    }

    public FunctionInterpolator(@NotNull Easing easing, Function1<? super Float, ? extends T> ... funcs) {
        Intrinsics.checkNotNullParameter((Object)easing, (String)"easing");
        Intrinsics.checkNotNullParameter(funcs, (String)"funcs");
        super(Easing.Companion.getLINEAR());
        this.funcs = funcs;
        this.interpolator = new IntInterpolator(easing);
    }

    @Override
    public T interpolate(float delta, T min, T max) {
        int i = this.interpolator.interpolate(delta, 0, this.funcs.length - 1);
        return (T)this.funcs[i].invoke((Object)Float.valueOf(delta));
    }

    @Override
    public T withEasing(@NotNull Easing easing, float delta, T min, T max) {
        Intrinsics.checkNotNullParameter((Object)easing, (String)"easing");
        int i = this.interpolator.withEasing(easing, delta, 0, this.funcs.length - 1);
        return (T)this.funcs[i].invoke((Object)Float.valueOf(delta));
    }
}

