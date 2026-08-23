/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.server.level.ServerPlayer
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package net.thebrokenscript.brokencore.impl.mixin.features.input;

import net.minecraft.server.level.ServerPlayer;
import net.thebrokenscript.brokencore.api.mixinterfaces.PlayerInputExt;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={ServerPlayer.class})
public class PlayerInputExtMixin
implements PlayerInputExt {
    @Unique
    private float bc$strafe;
    @Unique
    private float bc$forward;
    @Unique
    private boolean bc$jumping;
    @Unique
    private boolean bc$sneaking;

    @Inject(method={"setPlayerInput"}, at={@At(value="HEAD")})
    public void bc$updatePlayerInput(float strafe, float forward, boolean jumping, boolean sneaking, CallbackInfo ci) {
        this.bc$strafe = strafe;
        this.bc$forward = forward;
        this.bc$jumping = jumping;
        this.bc$sneaking = sneaking;
    }

    @Override
    public float bc$getStrafe() {
        return this.bc$strafe;
    }

    @Override
    public float bc$getForward() {
        return this.bc$forward;
    }

    @Override
    public boolean bc$getJumping() {
        return this.bc$jumping;
    }

    @Override
    public boolean bc$getSneaking() {
        return this.bc$sneaking;
    }
}

