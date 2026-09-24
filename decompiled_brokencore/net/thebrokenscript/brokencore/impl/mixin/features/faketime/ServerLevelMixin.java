/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.server.level.ServerLevel
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Redirect
 */
package net.thebrokenscript.brokencore.impl.mixin.features.faketime;

import net.minecraft.server.level.ServerLevel;
import net.thebrokenscript.brokencore.api.fake.CustomPlayerManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value={ServerLevel.class})
public class ServerLevelMixin {
    @Redirect(method={"tickTime"}, at=@At(value="INVOKE", target="Lnet/minecraft/server/level/ServerLevel;setDayTime(J)V"))
    private void tbs$pauseDayTimeWithoutPlayers(ServerLevel self, long time2) {
        boolean hasRealPlayers = self.getServer().getPlayerList().getPlayers().stream().anyMatch(p -> !CustomPlayerManager.customPlayers.containsKey(p.getUUID()));
        if (hasRealPlayers) {
            self.setDayTime(time2);
        }
    }
}

