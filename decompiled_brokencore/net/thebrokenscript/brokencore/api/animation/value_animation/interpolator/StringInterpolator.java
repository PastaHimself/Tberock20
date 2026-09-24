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

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B%\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0012\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u0006\"\u00020\u0002\u00a2\u0006\u0004\b\u0007\u0010\bB\u001d\b\u0016\u0012\u0012\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u0006\"\u00020\u0002\u00a2\u0006\u0004\b\u0007\u0010\tJ(\u0010\r\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0002H\u0016J \u0010\u0012\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0002H\u0016R\u0018\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u0006X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2={"Lnet/thebrokenscript/brokencore/api/animation/value_animation/interpolator/StringInterpolator;", "Lnet/thebrokenscript/brokencore/api/animation/value_animation/interpolator/Interpolator;", "", "easing", "Lnet/thebrokenscript/brokencore/api/animation/value_animation/Easing;", "strings", "", "<init>", "(Lnet/thebrokenscript/brokencore/api/animation/value_animation/Easing;[Ljava/lang/String;)V", "([Ljava/lang/String;)V", "[Ljava/lang/String;", "interpolator", "Lnet/thebrokenscript/brokencore/api/animation/value_animation/interpolator/IntInterpolator;", "withEasing", "delta", "", "min", "max", "interpolate", "brokencore-common"})
public final class StringInterpolator
extends Interpolator<String> {
    @NotNull
    private final String[] strings;
    @NotNull
    private final IntInterpolator interpolator;

    public StringInterpolator(@NotNull Easing easing, String ... strings) {
        Intrinsics.checkNotNullParameter((Object)easing, (String)"easing");
        Intrinsics.checkNotNullParameter((Object)strings, (String)"strings");
        super(Easing.Companion.getLINEAR());
        this.strings = strings;
        this.interpolator = new IntInterpolator(easing);
    }

    public StringInterpolator(String ... strings) {
        Intrinsics.checkNotNullParameter((Object)strings, (String)"strings");
        super(Easing.Companion.getLINEAR());
        this.strings = strings;
        this.interpolator = new IntInterpolator();
    }

    @Override
    @NotNull
    public String withEasing(@NotNull Easing easing, float delta, @NotNull String min, @NotNull String max) {
        Intrinsics.checkNotNullParameter((Object)easing, (String)"easing");
        Intrinsics.checkNotNullParameter((Object)min, (String)"min");
        Intrinsics.checkNotNullParameter((Object)max, (String)"max");
        int i = this.interpolator.withEasing(easing, delta, 0, this.strings.length - 1);
        return this.strings[i];
    }

    @Override
    @NotNull
    public String interpolate(float delta, @NotNull String min, @NotNull String max) {
        Intrinsics.checkNotNullParameter((Object)min, (String)"min");
        Intrinsics.checkNotNullParameter((Object)max, (String)"max");
        int i = this.interpolator.interpolate(delta, 0, this.strings.length - 1);
        return this.strings[i];
    }
}

