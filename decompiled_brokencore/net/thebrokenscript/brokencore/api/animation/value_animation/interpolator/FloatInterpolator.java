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

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 \u00132\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0013B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0005\u0010\u0006B\t\b\u0016\u00a2\u0006\u0004\b\u0005\u0010\u0007J-\u0010\b\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0002H\u0016\u00a2\u0006\u0002\u0010\fJ%\u0010\r\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0002H\u0016\u00a2\u0006\u0002\u0010\u000eJ=\u0010\b\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0002H\u0016\u00a2\u0006\u0002\u0010\u0011J5\u0010\r\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0002H\u0016\u00a2\u0006\u0002\u0010\u0012\u00a8\u0006\u0014"}, d2={"Lnet/thebrokenscript/brokencore/api/animation/value_animation/interpolator/FloatInterpolator;", "Lnet/thebrokenscript/brokencore/api/animation/value_animation/interpolator/Interpolator;", "", "easing", "Lnet/thebrokenscript/brokencore/api/animation/value_animation/Easing;", "<init>", "(Lnet/thebrokenscript/brokencore/api/animation/value_animation/Easing;)V", "()V", "withEasing", "delta", "min", "max", "(Lnet/thebrokenscript/brokencore/api/animation/value_animation/Easing;FFF)Ljava/lang/Float;", "interpolate", "(FFF)Ljava/lang/Float;", "prevMin", "nextMax", "(Lnet/thebrokenscript/brokencore/api/animation/value_animation/Easing;FFFFF)Ljava/lang/Float;", "(FFFFF)Ljava/lang/Float;", "Companion", "brokencore-common"})
public final class FloatInterpolator
extends Interpolator<Float> {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private static final FloatInterpolator linear = new FloatInterpolator();
    @NotNull
    private static final FloatInterpolator sine_out = new FloatInterpolator(Easing.Companion.getSINE_OUT());
    @NotNull
    private static final FloatInterpolator sine_in = new FloatInterpolator(Easing.Companion.getSINE_IN());
    @NotNull
    private static final FloatInterpolator sine_in_out = new FloatInterpolator(Easing.Companion.getSINE_IN_OUT());

    public FloatInterpolator(@NotNull Easing easing) {
        Intrinsics.checkNotNullParameter((Object)easing, (String)"easing");
        super(easing);
    }

    public FloatInterpolator() {
    }

    @Override
    @NotNull
    public Float withEasing(@NotNull Easing easing, float delta, float min, float max) {
        Intrinsics.checkNotNullParameter((Object)easing, (String)"easing");
        return Float.valueOf(easing.ease(min < max ? delta : 1.0f - delta, Math.min(max, min), Math.max(max, min), 1.0f));
    }

    @Override
    @NotNull
    public Float interpolate(float delta, float min, float max) {
        Easing easing = this.easing;
        Intrinsics.checkNotNull((Object)easing);
        return Float.valueOf(easing.ease(min < max ? delta : 1.0f - delta, Math.min(max, min), Math.max(max, min), 1.0f));
    }

    @Override
    @NotNull
    public Float withEasing(@NotNull Easing easing, float delta, float min, float max, float prevMin, float nextMax) {
        Intrinsics.checkNotNullParameter((Object)easing, (String)"easing");
        return Float.valueOf(easing.ease(min < max ? delta : 1.0f - delta, Math.min(max, min), Math.max(max, min), 1.0f, prevMin, nextMax));
    }

    @Override
    @NotNull
    public Float interpolate(float delta, float min, float max, float prevMin, float nextMax) {
        Easing easing = this.easing;
        Intrinsics.checkNotNull((Object)easing);
        return Float.valueOf(easing.ease(min < max ? delta : 1.0f - delta, Math.min(max, min), Math.max(max, min), 1.0f, prevMin, nextMax));
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0011\u0010\n\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0007R\u0011\u0010\f\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0007\u00a8\u0006\u000e"}, d2={"Lnet/thebrokenscript/brokencore/api/animation/value_animation/interpolator/FloatInterpolator$Companion;", "", "<init>", "()V", "linear", "Lnet/thebrokenscript/brokencore/api/animation/value_animation/interpolator/FloatInterpolator;", "getLinear", "()Lnet/thebrokenscript/brokencore/api/animation/value_animation/interpolator/FloatInterpolator;", "sine_out", "getSine_out", "sine_in", "getSine_in", "sine_in_out", "getSine_in_out", "brokencore-common"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final FloatInterpolator getLinear() {
            return linear;
        }

        @NotNull
        public final FloatInterpolator getSine_out() {
            return sine_out;
        }

        @NotNull
        public final FloatInterpolator getSine_in() {
            return sine_in;
        }

        @NotNull
        public final FloatInterpolator getSine_in_out() {
            return sine_in_out;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

