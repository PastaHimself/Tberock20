/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.llamalad7.mixinextras.sugar.Local
 *  net.minecraft.server.MinecraftServer
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.world.level.Level
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.At$Shift
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package net.thebrokenscript.brokencore.impl.mixin.events;

import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.Level;
import net.thebrokenscript.brokencore.api.event.GameEvent;
import net.thebrokenscript.brokencore.api.event.game.LevelTickEvents;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={MinecraftServer.class})
public class MinecraftServerMixin {
    @Inject(method={"tickChildren"}, at={@At(value="INVOKE", target="Lnet/minecraft/server/level/ServerLevel;tick(Ljava/util/function/BooleanSupplier;)V", shift=At.Shift.BY, by=-3)})
    public void bc$tickLevelPre(CallbackInfo ci, @Local(name={"serverlevel"}) ServerLevel serverLevel) {
        GameEvent.call(LevelTickEvents.PRE, new LevelTickEvents.Data((Level)serverLevel));
    }

    @Inject(method={"tickChildren"}, at={@At(value="INVOKE", target="Lnet/minecraft/server/level/ServerLevel;tick(Ljava/util/function/BooleanSupplier;)V", shift=At.Shift.AFTER)})
    public void bc$tickLevelPost(CallbackInfo ci, @Local(name={"serverlevel"}) ServerLevel serverLevel) {
        GameEvent.call(LevelTickEvents.POST, new LevelTickEvents.Data((Level)serverLevel));
    }
}

