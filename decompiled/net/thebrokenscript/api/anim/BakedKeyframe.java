/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 *  org.joml.Vector3f
 */
package net.thebrokenscript.api.anim;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector3f;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0010"}, d2={"Lnet/thebrokenscript/api/anim/BakedKeyframe;", "", "time", "", "value", "Lorg/joml/Vector3f;", "lerpMode", "", "<init>", "(FLorg/joml/Vector3f;Ljava/lang/String;)V", "getTime", "()F", "getValue", "()Lorg/joml/Vector3f;", "getLerpMode", "()Ljava/lang/String;", "thebrokenscript-common"})
public final class BakedKeyframe {
    private final float time;
    @NotNull
    private final Vector3f value;
    @NotNull
    private final String lerpMode;

    public BakedKeyframe(float time, @NotNull Vector3f value, @NotNull String lerpMode) {
        Intrinsics.checkNotNullParameter((Object)value, (String)"value");
        Intrinsics.checkNotNullParameter((Object)lerpMode, (String)"lerpMode");
        this.time = time;
        this.value = value;
        this.lerpMode = lerpMode;
    }

    public final float getTime() {
        return this.time;
    }

    @NotNull
    public final Vector3f getValue() {
        return this.value;
    }

    @NotNull
    public final String getLerpMode() {
        return this.lerpMode;
    }
}

