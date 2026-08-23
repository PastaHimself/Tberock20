/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.server.level.ServerPlayer
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package net.thebrokenscript.mixins.features.inventory;

import net.minecraft.server.level.ServerPlayer;
import net.thebrokenscript.util.KeepInventoryRules;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={ServerPlayer.class})
public abstract class ServerPlayerRestoreFromMixin {
    @Inject(method={"restoreFrom"}, at={@At(value="TAIL")})
    private void onRestoreFrom(ServerPlayer oldPlayer, boolean keepInventory, CallbackInfo ci) {
        ServerPlayer self = (ServerPlayer)this;
        if (KeepInventoryRules.shouldKeepInventory(oldPlayer)) {
            self.getInventory().replaceWith(oldPlayer.getInventory());
            self.totalExperience = oldPlayer.totalExperience;
            self.experienceLevel = oldPlayer.experienceLevel;
            self.experienceProgress = oldPlayer.experienceProgress;
            self.setScore(oldPlayer.getScore());
        }
    }
}

