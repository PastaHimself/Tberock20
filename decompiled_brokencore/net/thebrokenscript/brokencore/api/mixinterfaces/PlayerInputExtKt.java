/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.server.level.ServerPlayer
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.mixinterfaces;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.server.level.ServerPlayer;
import net.thebrokenscript.brokencore.api.mixinterfaces.PlayerInputExt;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=2, xi=48, d1={"\u0000\u0016\n\u0000\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0015\u0010\u0005\u001a\u00020\u0001*\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0004\"\u0015\u0010\u0007\u001a\u00020\b*\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\t\"\u0015\u0010\n\u001a\u00020\b*\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\t\"\u0015\u0010\u000b\u001a\u00020\b*\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\t\"\u0015\u0010\f\u001a\u00020\b*\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\t\"\u0015\u0010\r\u001a\u00020\b*\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\t\"\u0015\u0010\u000e\u001a\u00020\b*\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\t\u00a8\u0006\u000f"}, d2={"strafeInput", "", "Lnet/minecraft/server/level/ServerPlayer;", "getStrafeInput", "(Lnet/minecraft/server/level/ServerPlayer;)F", "forwardInput", "getForwardInput", "isJumpInput", "", "(Lnet/minecraft/server/level/ServerPlayer;)Z", "isSneakInput", "isLeftInput", "isRightInput", "isForwardInput", "isBackwardInput", "brokencore-common"})
public final class PlayerInputExtKt {
    public static final float getStrafeInput(@NotNull ServerPlayer $this$strafeInput) {
        Intrinsics.checkNotNullParameter((Object)$this$strafeInput, (String)"<this>");
        return ((PlayerInputExt)$this$strafeInput).bc$getStrafe();
    }

    public static final float getForwardInput(@NotNull ServerPlayer $this$forwardInput) {
        Intrinsics.checkNotNullParameter((Object)$this$forwardInput, (String)"<this>");
        return ((PlayerInputExt)$this$forwardInput).bc$getForward();
    }

    public static final boolean isJumpInput(@NotNull ServerPlayer $this$isJumpInput) {
        Intrinsics.checkNotNullParameter((Object)$this$isJumpInput, (String)"<this>");
        return ((PlayerInputExt)$this$isJumpInput).bc$getJumping();
    }

    public static final boolean isSneakInput(@NotNull ServerPlayer $this$isSneakInput) {
        Intrinsics.checkNotNullParameter((Object)$this$isSneakInput, (String)"<this>");
        return ((PlayerInputExt)$this$isSneakInput).bc$getSneaking();
    }

    public static final boolean isLeftInput(@NotNull ServerPlayer $this$isLeftInput) {
        Intrinsics.checkNotNullParameter((Object)$this$isLeftInput, (String)"<this>");
        return PlayerInputExtKt.getStrafeInput($this$isLeftInput) > 0.0f;
    }

    public static final boolean isRightInput(@NotNull ServerPlayer $this$isRightInput) {
        Intrinsics.checkNotNullParameter((Object)$this$isRightInput, (String)"<this>");
        return PlayerInputExtKt.getStrafeInput($this$isRightInput) < 0.0f;
    }

    public static final boolean isForwardInput(@NotNull ServerPlayer $this$isForwardInput) {
        Intrinsics.checkNotNullParameter((Object)$this$isForwardInput, (String)"<this>");
        return PlayerInputExtKt.getForwardInput($this$isForwardInput) > 0.0f;
    }

    public static final boolean isBackwardInput(@NotNull ServerPlayer $this$isBackwardInput) {
        Intrinsics.checkNotNullParameter((Object)$this$isBackwardInput, (String)"<this>");
        return PlayerInputExtKt.getForwardInput($this$isBackwardInput) < 0.0f;
    }
}

