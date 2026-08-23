/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 *  org.joml.Vector3f
 */
package net.thebrokenscript.brokencore.api.animation;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.thebrokenscript.brokencore.api.animation.BedrockTransform;
import net.thebrokenscript.brokencore.api.animation.value_animation.Easing;
import net.thebrokenscript.brokencore.api.animation.value_animation.interpolator.Interpolator;
import net.thebrokenscript.brokencore.api.animation.value_animation.interpolator.Vector3fInterpolator;
import net.thebrokenscript.brokencore.api.annotation.ExperimentalAnimationApi;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector3f;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0005\u0010\u0006J \u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0002H\u0016J(\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0002H\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2={"Lnet/thebrokenscript/brokencore/api/animation/BedrockTransformInterpolator;", "Lnet/thebrokenscript/brokencore/api/animation/value_animation/interpolator/Interpolator;", "Lnet/thebrokenscript/brokencore/api/animation/BedrockTransform;", "easing", "Lnet/thebrokenscript/brokencore/api/animation/value_animation/Easing;", "<init>", "(Lnet/thebrokenscript/brokencore/api/animation/value_animation/Easing;)V", "interpolator", "Lnet/thebrokenscript/brokencore/api/animation/value_animation/interpolator/Vector3fInterpolator;", "interpolate", "delta", "", "min", "max", "withEasing", "brokencore-common"})
@ExperimentalAnimationApi
public final class BedrockTransformInterpolator
extends Interpolator<BedrockTransform> {
    @NotNull
    private final Vector3fInterpolator interpolator;

    public BedrockTransformInterpolator(@NotNull Easing easing) {
        Intrinsics.checkNotNullParameter((Object)easing, (String)"easing");
        super(easing);
        this.interpolator = new Vector3fInterpolator(easing);
    }

    @Override
    @NotNull
    public BedrockTransform interpolate(float delta, @NotNull BedrockTransform min, @NotNull BedrockTransform max) {
        Intrinsics.checkNotNullParameter((Object)min, (String)"min");
        Intrinsics.checkNotNullParameter((Object)max, (String)"max");
        Vector3f posA = min.getPosition();
        Vector3f posB = max.getPosition();
        Vector3f rotA = min.getRotation();
        Vector3f rotB = max.getRotation();
        Vector3f scaleA = min.getScale();
        Vector3f scaleB = max.getScale();
        Vector3f pivotA = min.getPivot();
        Vector3f pivotB = max.getPivot();
        Vector3f pos = this.interpolator.interpolate(delta, posA, posB);
        Vector3f rot = this.interpolator.interpolate(delta, rotA, rotB);
        Vector3f scale = this.interpolator.interpolate(delta, scaleA, scaleB);
        Vector3f pivot = this.interpolator.interpolate(delta, pivotA, pivotB);
        return new BedrockTransform(pos, rot, scale, pivot);
    }

    @Override
    @NotNull
    public BedrockTransform withEasing(@NotNull Easing easing, float delta, @NotNull BedrockTransform min, @NotNull BedrockTransform max) {
        Intrinsics.checkNotNullParameter((Object)easing, (String)"easing");
        Intrinsics.checkNotNullParameter((Object)min, (String)"min");
        Intrinsics.checkNotNullParameter((Object)max, (String)"max");
        Vector3f posA = min.getPosition();
        Vector3f posB = max.getPosition();
        Vector3f rotA = min.getRotation();
        Vector3f rotB = max.getRotation();
        Vector3f scaleA = min.getScale();
        Vector3f scaleB = max.getScale();
        Vector3f pivotA = min.getPivot();
        Vector3f pivotB = max.getPivot();
        Vector3f pos = this.interpolator.withEasing(easing, delta, posA, posB);
        Vector3f rot = this.interpolator.withEasing(easing, delta, rotA, rotB);
        Vector3f scale = this.interpolator.withEasing(easing, delta, scaleA, scaleB);
        Vector3f pivot = this.interpolator.withEasing(easing, delta, pivotA, pivotB);
        return new BedrockTransform(pos, rot, scale, pivot);
    }
}

