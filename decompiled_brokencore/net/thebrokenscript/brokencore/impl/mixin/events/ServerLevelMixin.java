/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.server.level.ServerPlayer
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Redirect
 */
package net.thebrokenscript.brokencore.impl.mixin.events;

import java.util.List;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.thebrokenscript.brokencore.impl.event.StoryEvents;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value={ServerLevel.class})
public abstract class ServerLevelMixin {
    @Shadow
    public abstract List<ServerPlayer> players();

    @Redirect(method={"tick"}, at=@At(value="INVOKE", target="Lnet/minecraft/server/level/ServerLevel;setDayTime(J)V"))
    private void bc$onSleepSkip(ServerLevel level, long newTime) {
        long oldTime = level.getDayTime();
        level.setDayTime(newTime);
        long skipped = newTime - oldTime;
        if (skipped > 0L) {
            StoryEvents.addSkippedTime(skipped);
        }
    }
}

