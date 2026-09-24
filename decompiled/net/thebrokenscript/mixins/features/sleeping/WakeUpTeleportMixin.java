/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.level.Level
 *  net.thebrokenscript.brokencore.api.dsl.PlayerUtil
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package net.thebrokenscript.mixins.features.sleeping;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.thebrokenscript.brokencore.api.dsl.PlayerUtil;
import net.thebrokenscript.config.TBSConfigs;
import net.thebrokenscript.data.PlayerVariables;
import net.thebrokenscript.registry.TBSDataAttachments;
import net.thebrokenscript.registry.TBSDimensions;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={Player.class}, priority=800)
public class WakeUpTeleportMixin {
    @Shadow
    private int sleepCounter;
    @Unique
    private int tbs$sleepCounterBeforeWake;

    @Inject(method={"stopSleepInBed"}, at={@At(value="HEAD")})
    private void captureSleepCounter(boolean wakeImmediately, boolean updateLevelForSleepingPlayers, CallbackInfo ci) {
        this.tbs$sleepCounterBeforeWake = this.sleepCounter;
    }

    @Inject(method={"stopSleepInBed"}, at={@At(value="RETURN")})
    private void stopSleepInBed(boolean wakeImmediately, boolean updateLevelForSleepingPlayers, CallbackInfo ci) {
        if (this.tbs$sleepCounterBeforeWake < 100) {
            return;
        }
        Player player = (Player)this;
        Level level = player.level();
        if (player == null || level == null) {
            return;
        }
        if (level.random.nextFloat() < (float)TBSConfigs.INSTANCE.getServer().getWorld().getNightmareTeleportChance() / 100.0f) {
            PlayerVariables vars = (PlayerVariables)TBSDataAttachments.PLAYER_VARIABLES.get((Entity)player);
            vars.setFixPos(true);
            vars.setSkipFallDamage(true);
            TBSDataAttachments.PLAYER_VARIABLES.set((Entity)player, (Object)vars);
            PlayerUtil.sendTo((Player)player, TBSDimensions.NIGHTMARES.get(player.getRandom().nextInt(0, 4)));
        }
    }
}

