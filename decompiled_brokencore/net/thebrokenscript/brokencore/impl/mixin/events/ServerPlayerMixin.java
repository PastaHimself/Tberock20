/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.authlib.GameProfile
 *  net.minecraft.core.BlockPos
 *  net.minecraft.resources.ResourceKey
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.server.level.ServerPlayer
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.portal.DimensionTransition
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package net.thebrokenscript.brokencore.impl.mixin.events;

import com.mojang.authlib.GameProfile;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.portal.DimensionTransition;
import net.thebrokenscript.brokencore.api.event.GameEvent;
import net.thebrokenscript.brokencore.api.event.game.PlayerEvents;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={ServerPlayer.class})
public abstract class ServerPlayerMixin
extends Player {
    public ServerPlayerMixin(Level level, BlockPos pos, float yRot, GameProfile gameProfile) {
        super(level, pos, yRot, gameProfile);
    }

    @Shadow
    public abstract ServerLevel serverLevel();

    @Inject(method={"changeDimension"}, at={@At(value="HEAD")}, cancellable=true)
    public void bc$changeDimension(DimensionTransition transition, CallbackInfoReturnable<Entity> cir) {
        if (this.isRemoved()) {
            return;
        }
        if (this.serverLevel().dimension() != transition.newLevel().dimension() && GameEvent.callCancelable(PlayerEvents.CHANGE_DIMENSION, new PlayerEvents.ChangeDimension((ServerPlayer)this, (ResourceKey<Level>)this.serverLevel().dimension(), (ResourceKey<Level>)transition.newLevel().dimension()))) {
            cir.setReturnValue(null);
        }
    }

    @Inject(method={"startSleeping"}, at={@At(value="TAIL")}, cancellable=true)
    private void canSleep(BlockPos pos, CallbackInfo ci) {
        boolean canceled = GameEvent.callCancelable(PlayerEvents.SLEEP, new PlayerEvents.Sleep((ServerPlayer)this));
        if (canceled) {
            this.stopSleepInBed(true, true);
            ci.cancel();
        }
    }
}

