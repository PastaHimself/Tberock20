/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.server.level.ServerPlayer
 *  net.minecraft.world.entity.player.Inventory
 *  net.minecraft.world.entity.player.Player
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Redirect
 */
package net.thebrokenscript.mixins.features.inventory;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.thebrokenscript.util.KeepInventoryRules;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value={Player.class})
public abstract class PlayerDropEquipmentMixin {
    @Redirect(method={"dropEquipment"}, at=@At(value="INVOKE", target="Lnet/minecraft/world/entity/player/Inventory;dropAll()V"))
    private void redirectDropAll(Inventory inventory) {
        ServerPlayer serverPlayer;
        Player self = (Player)this;
        if (self instanceof ServerPlayer && KeepInventoryRules.shouldKeepInventory(serverPlayer = (ServerPlayer)self)) {
            return;
        }
        inventory.dropAll();
    }
}

