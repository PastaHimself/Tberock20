/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.world.entity.player.Player
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.api.util;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.world.entity.player.Player;
import net.thebrokenscript.api.ext.PlayerExt;
import net.thebrokenscript.data.CameraMode;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=2, xi=48, d1={"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b\u0000\u0010\u0003\u00a8\u0006\u0004"}, d2={"isLookingAtSky", "", "Lnet/minecraft/world/entity/player/Player;", "(Lnet/minecraft/world/entity/player/Player;)Z", "thebrokenscript-common"})
public final class CameraUtilKt {
    public static final boolean isLookingAtSky(@NotNull Player $this$isLookingAtSky) {
        boolean isFrontTP;
        Intrinsics.checkNotNullParameter((Object)$this$isLookingAtSky, (String)"<this>");
        boolean bl = isFrontTP = PlayerExt.INSTANCE.getVars($this$isLookingAtSky).getCameraMode() == CameraMode.THIRD_PERSON_FRONT;
        boolean lookingAtSkyCam = isFrontTP ? $this$isLookingAtSky.getXRot() >= 0.0f : $this$isLookingAtSky.getXRot() <= 0.0f;
        return lookingAtSkyCam && $this$isLookingAtSky.level().canSeeSkyFromBelowWater($this$isLookingAtSky.blockPosition());
    }
}

