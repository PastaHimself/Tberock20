/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.llamalad7.mixinextras.injector.ModifyReturnValue
 *  net.minecraft.client.multiplayer.ClientPacketListener
 *  net.minecraft.client.multiplayer.PlayerInfo
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package net.thebrokenscript.brokencore.impl.mixin.features.fake;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;
import net.minecraft.client.multiplayer.ClientPacketListener;
import net.minecraft.client.multiplayer.PlayerInfo;
import net.thebrokenscript.brokencore.api.fake.ClientCustomPlayerManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={ClientPacketListener.class})
public class ClientPacketListenerMixin {
    @ModifyReturnValue(method={"getListedOnlinePlayers"}, at={@At(value="RETURN")})
    public Collection<PlayerInfo> tbs$modifyListedOnlinePlayers(Collection<PlayerInfo> original) {
        ArrayList<PlayerInfo> proxy = new ArrayList<PlayerInfo>(original);
        proxy.addAll(ClientCustomPlayerManager.playerInfos.values());
        return proxy;
    }

    @ModifyReturnValue(method={"getOnlinePlayers"}, at={@At(value="RETURN")})
    public Collection<PlayerInfo> tbs$modifyOnlinePlayers(Collection<PlayerInfo> original) {
        ArrayList<PlayerInfo> proxy = new ArrayList<PlayerInfo>(original);
        proxy.addAll(ClientCustomPlayerManager.playerInfos.values());
        return proxy;
    }

    @ModifyReturnValue(method={"getOnlinePlayerIds"}, at={@At(value="RETURN")})
    public Collection<UUID> tbs$modifyOnlinePlayerIds(Collection<UUID> original) {
        ArrayList<UUID> proxy = new ArrayList<UUID>(original);
        proxy.addAll(ClientCustomPlayerManager.playerInfos.keySet());
        return proxy;
    }

    @Inject(method={"getPlayerInfo(Ljava/lang/String;)Lnet/minecraft/client/multiplayer/PlayerInfo;"}, at={@At(value="HEAD")}, cancellable=true)
    public void tbs$addFakePlayerInfo(String name, CallbackInfoReturnable<PlayerInfo> cir) {
        PlayerInfo info = ClientCustomPlayerManager.getByName(name);
        if (info != null) {
            cir.setReturnValue((Object)info);
        }
    }

    @Inject(method={"getPlayerInfo(Ljava/util/UUID;)Lnet/minecraft/client/multiplayer/PlayerInfo;"}, at={@At(value="HEAD")}, cancellable=true)
    public void tbs$addFakePlayerInfoUUID(UUID uniqueId, CallbackInfoReturnable<PlayerInfo> cir) {
        PlayerInfo info = ClientCustomPlayerManager.getByUUID(uniqueId);
        if (info != null) {
            cir.setReturnValue((Object)info);
        }
    }
}

