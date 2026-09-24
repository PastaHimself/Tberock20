/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.multiplayer.ClientPacketListener
 *  net.minecraft.client.player.LocalPlayer
 *  net.minecraft.network.protocol.game.ClientboundPlayerChatPacket
 *  net.minecraft.world.entity.player.Player
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package net.thebrokenscript.mixins.client.features.isolation;

import java.util.UUID;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientPacketListener;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.network.protocol.game.ClientboundPlayerChatPacket;
import net.minecraft.world.entity.player.Player;
import net.thebrokenscript.api.ext.PlayerExt;
import net.thebrokenscript.data.PlayerVariables;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={ClientPacketListener.class})
public class ClientPacketListenerMixin {
    @Inject(method={"handlePlayerChat"}, at={@At(value="HEAD")}, cancellable=true)
    public void tbs$fuckUpTheChat__SmileyFaceEmoji(ClientboundPlayerChatPacket packet, CallbackInfo ci) {
        LocalPlayer player = Minecraft.getInstance().player;
        if (player == null) {
            return;
        }
        PlayerVariables vars = PlayerExt.INSTANCE.getVars((Player)player);
        UUID uuid = packet.sender();
        if (vars.getIsolationActive() && !vars.getIsolationAllowedUsers().getEntries().contains(uuid)) {
            ci.cancel();
        }
    }
}

