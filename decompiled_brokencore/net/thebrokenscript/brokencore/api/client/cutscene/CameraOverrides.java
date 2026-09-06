/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.client.cutscene;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.thebrokenscript.brokencore.api.util.math.Transform;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0010"}, d2={"Lnet/thebrokenscript/brokencore/api/client/cutscene/CameraOverrides;", "", "<init>", "()V", "active", "", "getActive", "()Z", "setActive", "(Z)V", "transform", "Lnet/thebrokenscript/brokencore/api/util/math/Transform;", "getTransform", "()Lnet/thebrokenscript/brokencore/api/util/math/Transform;", "setTransform", "(Lnet/thebrokenscript/brokencore/api/util/math/Transform;)V", "brokencore-common"})
public final class CameraOverrides {
    private boolean active;
    @NotNull
    private Transform transform = new Transform(null, null, 3, null);

    public final boolean getActive() {
        return this.active;
    }

    public final void setActive(boolean bl) {
        this.active = bl;
    }

    @NotNull
    public final Transform getTransform() {
        return this.transform;
    }

    public final void setTransform(@NotNull Transform transform2) {
        Intrinsics.checkNotNullParameter((Object)transform2, (String)"<set-?>");
        this.transform = transform2;
    }
}

