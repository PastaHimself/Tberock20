/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.animation.value_animation.interpolator;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.thebrokenscript.brokencore.api.animation.value_animation.Easing;
import net.thebrokenscript.brokencore.api.animation.value_animation.interpolator.Interpolator;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u000b\u0018\u0000 \u00142\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0014B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0005\u0010\u0006B\t\b\u0016\u00a2\u0006\u0004\b\u0005\u0010\u0007J-\u0010\b\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0002H\u0016\u00a2\u0006\u0002\u0010\rJ%\u0010\u000e\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0002H\u0016\u00a2\u0006\u0002\u0010\u000fJ=\u0010\b\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0002H\u0016\u00a2\u0006\u0002\u0010\u0012J5\u0010\u000e\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0002H\u0016\u00a2\u0006\u0002\u0010\u0013\u00a8\u0006\u0015"}, d2={"Lnet/thebrokenscript/brokencore/api/animation/value_animation/interpolator/IntInterpolator;", "Lnet/thebrokenscript/brokencore/api/animation/value_animation/interpolator/Interpolator;", "", "easing", "Lnet/thebrokenscript/brokencore/api/animation/value_animation/Easing;", "<init>", "(Lnet/thebrokenscript/brokencore/api/animation/value_animation/Easing;)V", "()V", "withEasing", "delta", "", "min", "max", "(Lnet/thebrokenscript/brokencore/api/animation/value_animation/Easing;FII)Ljava/lang/Integer;", "interpolate", "(FII)Ljava/lang/Integer;", "prevMin", "nextMax", "(Lnet/thebrokenscript/brokencore/api/animation/value_animation/Easing;FIIII)Ljava/lang/Integer;", "(FIIII)Ljava/lang/Integer;", "Companion", "brokencore-common"})
public final class IntInterpolator
extends Interpolator<Integer> {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private static final IntInterpolator linear = new IntInterpolator();

    public IntInterpolator(@NotNull Easing easing) {
        Intrinsics.checkNotNullParameter((Object)easing, (String)"easing");
        super(easing);
    }

    public IntInterpolator() {
    }

    @Override
    @NotNull
    public Integer withEasing(@NotNull Easing easing, float delta, int min, int max) {
        Intrinsics.checkNotNullParameter((Object)easing, (String)"easing");
        return (int)Math.floor(easing.ease(delta, min, max, 1.0f));
    }

    @Override
    @NotNull
    public Integer interpolate(float delta, int min, int max) {
        return (int)Math.floor(this.easing.ease(delta, min, max, 1.0f));
    }

    @Override
    @NotNull
    public Integer withEasing(@NotNull Easing easing, float delta, int min, int max, int prevMin, int nextMax) {
        Intrinsics.checkNotNullParameter((Object)easing, (String)"easing");
        return (int)Math.floor(easing.ease(delta, min, max, 1.0f, prevMin, nextMax));
    }

    @Override
    @NotNull
    public Integer interpolate(float delta, int min, int max, int prevMin, int nextMax) {
        return (int)Math.floor(this.easing.ease(delta, min, max, 1.0f, prevMin, nextMax));
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2={"Lnet/thebrokenscript/brokencore/api/animation/value_animation/interpolator/IntInterpolator$Companion;", "", "<init>", "()V", "linear", "Lnet/thebrokenscript/brokencore/api/animation/value_animation/interpolator/IntInterpolator;", "getLinear", "()Lnet/thebrokenscript/brokencore/api/animation/value_animation/interpolator/IntInterpolator;", "brokencore-common"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final IntInterpolator getLinear() {
            return linear;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

