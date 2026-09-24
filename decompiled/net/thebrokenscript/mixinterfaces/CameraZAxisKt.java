/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.client.Camera
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.mixinterfaces;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.Camera;
import net.thebrokenscript.mixinterfaces.CameraZAxis;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=2, xi=48, d1={"\u0000\u0018\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\"(\u0010\u0002\u001a\u00020\u0001*\u00020\u00032\u0006\u0010\u0000\u001a\u00020\u00018F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007\"(\u0010\u0002\u001a\u00020\u0001*\u00020\b2\u0006\u0010\u0000\u001a\u00020\u00018F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0004\u0010\t\"\u0004\b\u0006\u0010\n\u00a8\u0006\u000b"}, d2={"value", "", "angle", "Lnet/thebrokenscript/mixinterfaces/CameraZAxis;", "getAngle", "(Lnet/thebrokenscript/mixinterfaces/CameraZAxis;)F", "setAngle", "(Lnet/thebrokenscript/mixinterfaces/CameraZAxis;F)V", "Lnet/minecraft/client/Camera;", "(Lnet/minecraft/client/Camera;)F", "(Lnet/minecraft/client/Camera;F)V", "thebrokenscript-common"})
public final class CameraZAxisKt {
    public static final float getAngle(@NotNull CameraZAxis $this$angle) {
        Intrinsics.checkNotNullParameter((Object)$this$angle, (String)"<this>");
        return $this$angle.getBc$angle();
    }

    public static final void setAngle(@NotNull CameraZAxis $this$angle, float value) {
        Intrinsics.checkNotNullParameter((Object)$this$angle, (String)"<this>");
        $this$angle.setBc$angle(value);
    }

    public static final float getAngle(@NotNull Camera $this$angle) {
        Intrinsics.checkNotNullParameter((Object)$this$angle, (String)"<this>");
        return CameraZAxisKt.getAngle((CameraZAxis)$this$angle);
    }

    public static final void setAngle(@NotNull Camera $this$angle, float value) {
        Intrinsics.checkNotNullParameter((Object)$this$angle, (String)"<this>");
        CameraZAxisKt.setAngle((CameraZAxis)$this$angle, value);
    }
}

