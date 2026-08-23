/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.animation.value_animation.interpolator;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import net.thebrokenscript.brokencore.api.animation.value_animation.Easing;
import net.thebrokenscript.brokencore.api.animation.value_animation.interpolator.IntInterpolator;
import net.thebrokenscript.brokencore.api.animation.value_animation.interpolator.Interpolator;
import net.thebrokenscript.brokencore.api.annotation.ExperimentalAnimationApi;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B=\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012*\u0010\u0005\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00070\u0006\"\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007\u00a2\u0006\u0004\b\n\u0010\u000bB5\b\u0016\u0012*\u0010\u0005\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00070\u0006\"\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007\u00a2\u0006\u0004\b\n\u0010\fJ-\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0002H\u0016\u00a2\u0006\u0002\u0010\u0014J%\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0002H\u0016\u00a2\u0006\u0002\u0010\u0016R$\u0010\u0005\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00070\u0006X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2={"Lnet/thebrokenscript/brokencore/api/animation/value_animation/interpolator/ConsumerInterpolator;", "Lnet/thebrokenscript/brokencore/api/animation/value_animation/interpolator/Interpolator;", "", "easing", "Lnet/thebrokenscript/brokencore/api/animation/value_animation/Easing;", "funcs", "", "Lkotlin/Function1;", "", "", "<init>", "(Lnet/thebrokenscript/brokencore/api/animation/value_animation/Easing;[Lkotlin/jvm/functions/Function1;)V", "([Lkotlin/jvm/functions/Function1;)V", "[Lkotlin/jvm/functions/Function1;", "interpolator", "Lnet/thebrokenscript/brokencore/api/animation/value_animation/interpolator/IntInterpolator;", "withEasing", "delta", "min", "max", "(Lnet/thebrokenscript/brokencore/api/animation/value_animation/Easing;FII)Ljava/lang/Integer;", "interpolate", "(FII)Ljava/lang/Integer;", "brokencore-common"})
@ExperimentalAnimationApi
public final class ConsumerInterpolator
extends Interpolator<Integer> {
    @NotNull
    private final Function1<Float, Unit>[] funcs;
    @NotNull
    private final IntInterpolator interpolator;

    public ConsumerInterpolator(@NotNull Easing easing, Function1<? super Float, Unit> ... funcs) {
        Intrinsics.checkNotNullParameter((Object)easing, (String)"easing");
        Intrinsics.checkNotNullParameter(funcs, (String)"funcs");
        super(Easing.Companion.getLINEAR());
        this.funcs = funcs;
        this.interpolator = new IntInterpolator(easing);
    }

    public ConsumerInterpolator(Function1<? super Float, Unit> ... funcs) {
        Intrinsics.checkNotNullParameter(funcs, (String)"funcs");
        super(Easing.Companion.getLINEAR());
        this.funcs = funcs;
        this.interpolator = new IntInterpolator();
    }

    @Override
    @NotNull
    public Integer withEasing(@NotNull Easing easing, float delta, int min, int max) {
        Intrinsics.checkNotNullParameter((Object)easing, (String)"easing");
        int i = this.interpolator.withEasing(easing, delta, 0, this.funcs.length - 1);
        this.funcs[i].invoke((Object)Float.valueOf(delta));
        return 0;
    }

    @Override
    @NotNull
    public Integer interpolate(float delta, int min, int max) {
        int i = this.interpolator.interpolate(delta, 0, this.funcs.length - 1);
        this.funcs[i].invoke((Object)Float.valueOf(delta));
        return 0;
    }
}

