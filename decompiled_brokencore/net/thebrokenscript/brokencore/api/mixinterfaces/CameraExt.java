/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.mixinterfaces;

import kotlin.Metadata;
import net.thebrokenscript.brokencore.api.client.cutscene.CameraOverrides;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\b\u001a\u00020\tH&R\u0018\u0010\u0002\u001a\u00020\u0003X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2={"Lnet/thebrokenscript/brokencore/api/mixinterfaces/CameraExt;", "", "bc$overrides", "Lnet/thebrokenscript/brokencore/api/client/cutscene/CameraOverrides;", "getBc$overrides", "()Lnet/thebrokenscript/brokencore/api/client/cutscene/CameraOverrides;", "setBc$overrides", "(Lnet/thebrokenscript/brokencore/api/client/cutscene/CameraOverrides;)V", "bc$updateOverrides", "", "brokencore-common"})
public interface CameraExt {
    @NotNull
    public CameraOverrides getBc$overrides();

    public void setBc$overrides(@NotNull CameraOverrides var1);

    public void bc$updateOverrides();
}

