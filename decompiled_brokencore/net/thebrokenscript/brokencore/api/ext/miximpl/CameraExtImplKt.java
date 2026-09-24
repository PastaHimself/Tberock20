/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.client.Camera
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.ext.miximpl;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.Camera;
import net.thebrokenscript.brokencore.api.client.cutscene.CameraOverrides;
import net.thebrokenscript.brokencore.api.mixinterfaces.CameraExt;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=2, xi=48, d1={"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\u001a\n\u0010\b\u001a\u00020\t*\u00020\u0003\"(\u0010\u0002\u001a\u00020\u0001*\u00020\u00032\u0006\u0010\u0000\u001a\u00020\u00018F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2={"value", "Lnet/thebrokenscript/brokencore/api/client/cutscene/CameraOverrides;", "overrides", "Lnet/minecraft/client/Camera;", "getOverrides", "(Lnet/minecraft/client/Camera;)Lnet/thebrokenscript/brokencore/api/client/cutscene/CameraOverrides;", "setOverrides", "(Lnet/minecraft/client/Camera;Lnet/thebrokenscript/brokencore/api/client/cutscene/CameraOverrides;)V", "updateOverrides", "", "brokencore-common"})
public final class CameraExtImplKt {
    @NotNull
    public static final CameraOverrides getOverrides(@NotNull Camera $this$overrides) {
        Intrinsics.checkNotNullParameter((Object)$this$overrides, (String)"<this>");
        return ((CameraExt)$this$overrides).getBc$overrides();
    }

    public static final void setOverrides(@NotNull Camera $this$overrides, @NotNull CameraOverrides value) {
        Intrinsics.checkNotNullParameter((Object)$this$overrides, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)value, (String)"value");
        ((CameraExt)$this$overrides).setBc$overrides(value);
    }

    public static final void updateOverrides(@NotNull Camera $this$updateOverrides) {
        Intrinsics.checkNotNullParameter((Object)$this$updateOverrides, (String)"<this>");
        ((CameraExt)$this$updateOverrides).bc$updateOverrides();
    }
}

