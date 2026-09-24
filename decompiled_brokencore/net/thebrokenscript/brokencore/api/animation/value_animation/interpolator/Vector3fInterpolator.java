/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 *  org.joml.Vector3f
 */
package net.thebrokenscript.brokencore.api.animation.value_animation.interpolator;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.thebrokenscript.brokencore.api.animation.value_animation.Easing;
import net.thebrokenscript.brokencore.api.animation.value_animation.interpolator.Interpolator;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector3f;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0007\u0018\u0000 \u00102\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0010B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0005\u0010\u0006B\t\b\u0016\u00a2\u0006\u0004\b\u0005\u0010\u0007J(\u0010\b\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0002H\u0016J \u0010\r\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0002H\u0016J8\u0010\b\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0002H\u0016J0\u0010\r\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0002H\u0016\u00a8\u0006\u0011"}, d2={"Lnet/thebrokenscript/brokencore/api/animation/value_animation/interpolator/Vector3fInterpolator;", "Lnet/thebrokenscript/brokencore/api/animation/value_animation/interpolator/Interpolator;", "Lorg/joml/Vector3f;", "easing", "Lnet/thebrokenscript/brokencore/api/animation/value_animation/Easing;", "<init>", "(Lnet/thebrokenscript/brokencore/api/animation/value_animation/Easing;)V", "()V", "withEasing", "delta", "", "min", "max", "interpolate", "prevMin", "nextMax", "Companion", "brokencore-common"})
public final class Vector3fInterpolator
extends Interpolator<Vector3f> {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private static final Vector3fInterpolator linear = new Vector3fInterpolator();

    public Vector3fInterpolator(@NotNull Easing easing) {
        Intrinsics.checkNotNullParameter((Object)easing, (String)"easing");
        super(easing);
    }

    public Vector3fInterpolator() {
    }

    @Override
    @NotNull
    public Vector3f withEasing(@NotNull Easing easing, float delta, @NotNull Vector3f min, @NotNull Vector3f max) {
        Intrinsics.checkNotNullParameter((Object)easing, (String)"easing");
        Intrinsics.checkNotNullParameter((Object)min, (String)"min");
        Intrinsics.checkNotNullParameter((Object)max, (String)"max");
        return new Vector3f(easing.ease(delta, min.x(), max.x(), 1.0f), easing.ease(delta, min.y(), max.y(), 1.0f), easing.ease(delta, min.z(), max.z(), 1.0f));
    }

    @Override
    @NotNull
    public Vector3f interpolate(float delta, @NotNull Vector3f min, @NotNull Vector3f max) {
        Intrinsics.checkNotNullParameter((Object)min, (String)"min");
        Intrinsics.checkNotNullParameter((Object)max, (String)"max");
        Easing easing = this.easing;
        Intrinsics.checkNotNull((Object)easing);
        return new Vector3f(easing.ease(delta, min.x(), max.x(), 1.0f), this.easing.ease(delta, min.y(), max.y(), 1.0f), this.easing.ease(delta, min.z(), max.z(), 1.0f));
    }

    @Override
    @NotNull
    public Vector3f withEasing(@NotNull Easing easing, float delta, @NotNull Vector3f min, @NotNull Vector3f max, @NotNull Vector3f prevMin, @NotNull Vector3f nextMax) {
        Intrinsics.checkNotNullParameter((Object)easing, (String)"easing");
        Intrinsics.checkNotNullParameter((Object)min, (String)"min");
        Intrinsics.checkNotNullParameter((Object)max, (String)"max");
        Intrinsics.checkNotNullParameter((Object)prevMin, (String)"prevMin");
        Intrinsics.checkNotNullParameter((Object)nextMax, (String)"nextMax");
        return new Vector3f(easing.ease(delta, min.x(), max.x(), 1.0f, prevMin.x, nextMax.x), easing.ease(delta, min.y(), max.y(), 1.0f, prevMin.y, nextMax.y), easing.ease(delta, min.z(), max.z(), 1.0f, prevMin.z, nextMax.z));
    }

    @Override
    @NotNull
    public Vector3f interpolate(float delta, @NotNull Vector3f min, @NotNull Vector3f max, @NotNull Vector3f prevMin, @NotNull Vector3f nextMax) {
        Intrinsics.checkNotNullParameter((Object)min, (String)"min");
        Intrinsics.checkNotNullParameter((Object)max, (String)"max");
        Intrinsics.checkNotNullParameter((Object)prevMin, (String)"prevMin");
        Intrinsics.checkNotNullParameter((Object)nextMax, (String)"nextMax");
        Easing easing = this.easing;
        Intrinsics.checkNotNull((Object)easing);
        return new Vector3f(easing.ease(delta, min.x(), max.x(), 1.0f, prevMin.x, nextMax.x), this.easing.ease(delta, min.y(), max.y(), 1.0f, prevMin.y, nextMax.y), this.easing.ease(delta, min.z(), max.z(), 1.0f, prevMin.z, nextMax.z));
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2={"Lnet/thebrokenscript/brokencore/api/animation/value_animation/interpolator/Vector3fInterpolator$Companion;", "", "<init>", "()V", "linear", "Lnet/thebrokenscript/brokencore/api/animation/value_animation/interpolator/Vector3fInterpolator;", "getLinear", "()Lnet/thebrokenscript/brokencore/api/animation/value_animation/interpolator/Vector3fInterpolator;", "brokencore-common"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final Vector3fInterpolator getLinear() {
            return linear;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

