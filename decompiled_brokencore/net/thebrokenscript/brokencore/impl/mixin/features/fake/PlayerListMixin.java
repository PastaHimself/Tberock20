/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.llamalad7.mixinextras.injector.ModifyReturnValue
 *  net.minecraft.server.level.ServerPlayer
 *  net.minecraft.server.players.PlayerList
 *  org.apache.commons.lang3.ArrayUtils
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package net.thebrokenscript.brokencore.impl.mixin.features.fake;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.players.PlayerList;
import net.thebrokenscript.brokencore.api.fake.CustomPlayerManager;
import net.thebrokenscript.brokencore.api.fake.FakePlayer;
import org.apache.commons.lang3.ArrayUtils;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={PlayerList.class})
public class PlayerListMixin {
    @Inject(method={"getPlayerByName"}, at={@At(value="HEAD")}, cancellable=true)
    public void tbs$getFakeByName(String username, CallbackInfoReturnable<ServerPlayer> cir) {
        ServerPlayer fake = CustomPlayerManager.getByName(username);
        if (fake != null) {
            cir.setReturnValue((Object)fake);
        }
    }

    @Inject(method={"getPlayer"}, at={@At(value="HEAD")}, cancellable=true)
    public void tbs$getFakeByUUID(UUID playerUUID, CallbackInfoReturnable<ServerPlayer> cir) {
        ServerPlayer fake = CustomPlayerManager.getByUUID(playerUUID);
        if (fake != null) {
            cir.setReturnValue((Object)fake);
        }
    }

    @ModifyReturnValue(method={"getPlayerNamesArray"}, at={@At(value="RETURN")})
    public String[] tbs$addFakeNames(String[] original) {
        return (String[])ArrayUtils.addAll((Object[])original, (Object[])CustomPlayerManager.names());
    }

    @ModifyReturnValue(method={"getPlayers"}, at={@At(value="RETURN")})
    public List<ServerPlayer> tbs$addFakePlayers(List<ServerPlayer> original) {
        ArrayList<ServerPlayer> proxy = new ArrayList<ServerPlayer>(original);
        proxy.addAll(CustomPlayerManager.customPlayers.values());
        return proxy;
    }

    @Inject(method={"remove"}, at={@At(value="HEAD")}, cancellable=true)
    public void tbs$removeFakePlayers(ServerPlayer player, CallbackInfo ci) {
        if (player instanceof FakePlayer) {
            CustomPlayerManager.remove(player.getGameProfile().getId());
            ci.cancel();
        }
    }
}

