/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.server.level.ServerPlayer
 *  net.minecraft.server.players.PlayerList
 *  net.minecraft.world.entity.Entity$RemovalReason
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package net.thebrokenscript.mixins.features.inventory;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.players.PlayerList;
import net.minecraft.world.entity.Entity;
import net.thebrokenscript.util.KeepInventoryRules;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={PlayerList.class})
public abstract class PlayerListRespawnMixin {
    @Inject(method={"respawn"}, at={@At(value="INVOKE", target="Lnet/minecraft/server/level/ServerPlayer;initInventoryMenu()V")})
    private void onRespawnRestoreXp(ServerPlayer player, boolean keepInventory, Entity.RemovalReason reason, CallbackInfoReturnable<ServerPlayer> cir) {
        ServerPlayer newPlayer = (ServerPlayer)cir.getReturnValue();
        if (newPlayer == null) {
            return;
        }
        if (KeepInventoryRules.shouldKeepInventory(player)) {
            newPlayer.totalExperience = player.totalExperience;
            newPlayer.experienceLevel = player.experienceLevel;
            newPlayer.experienceProgress = player.experienceProgress;
        }
    }
}

