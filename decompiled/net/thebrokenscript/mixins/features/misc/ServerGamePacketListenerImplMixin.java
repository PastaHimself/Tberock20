/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.server.level.ServerPlayer
 *  net.minecraft.server.network.ServerGamePacketListenerImpl
 *  net.minecraft.world.entity.Entity
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.ModifyVariable
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package net.thebrokenscript.mixins.features.misc;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.network.ServerGamePacketListenerImpl;
import net.minecraft.world.entity.Entity;
import net.thebrokenscript.data.PlayerVariables;
import net.thebrokenscript.registry.TBSDataAttachments;
import net.thebrokenscript.registry.TBSDimensions;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={ServerGamePacketListenerImpl.class})
public abstract class ServerGamePacketListenerImplMixin {
    @Shadow
    public ServerPlayer player;

    @ModifyVariable(method={"handleMovePlayer"}, at=@At(value="STORE"), name={"d10"})
    private double reduceMovementDistance(double d10) {
        if (this.player.level().dimension() == TBSDimensions.LIBRARY) {
            long lastTeleport = ((PlayerVariables)TBSDataAttachments.PLAYER_VARIABLES.get((Entity)this.player)).getLastTeleport();
            long lastTeleport2 = ((PlayerVariables)TBSDataAttachments.PLAYER_VARIABLES.get((Entity)this.player)).getLastClanVoidTeleport();
            long currentTime = this.player.serverLevel().getGameTime();
            if (currentTime - lastTeleport < 20L || currentTime - lastTeleport2 < 20L) {
                return 0.0;
            }
        }
        return d10;
    }

    @Inject(method={"getMaximumFlyingTicks"}, at={@At(value="RETURN")}, cancellable=true)
    private void tbs$getMaximumFlyingTicks(CallbackInfoReturnable<Integer> cir) {
        cir.setReturnValue((Object)Integer.MAX_VALUE);
    }
}

