/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.maxhenkel.voicechat.voice.common.PlayerState
 *  de.maxhenkel.voicechat.voice.common.SoundPacket
 *  de.maxhenkel.voicechat.voice.server.ClientConnection
 *  de.maxhenkel.voicechat.voice.server.Server
 *  net.minecraft.server.level.ServerPlayer
 *  net.minecraft.world.entity.player.Player
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package net.thebrokenscript.mixins.compat.voicechat;

import de.maxhenkel.voicechat.voice.common.PlayerState;
import de.maxhenkel.voicechat.voice.common.SoundPacket;
import de.maxhenkel.voicechat.voice.server.ClientConnection;
import de.maxhenkel.voicechat.voice.server.Server;
import java.util.Objects;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.thebrokenscript.api.ext.PlayerExt;
import net.thebrokenscript.data.PlayerVariables;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={Server.class})
public class ServerMixin {
    @Inject(method={"sendSoundPacket"}, at={@At(value="HEAD")}, cancellable=true)
    public void tbs$filterSoundPackets(ServerPlayer sender, PlayerState senderState, ServerPlayer receiver, PlayerState receiverState, ClientConnection connection, SoundPacket<?> soundPacket, String source, CallbackInfo ci) {
        PlayerVariables senderVars = PlayerExt.INSTANCE.getVars((Player)sender);
        PlayerVariables receiverVars = PlayerExt.INSTANCE.getVars((Player)receiver);
        if (senderVars.getIsolationActive()) {
            boolean denyRecv;
            boolean denySend;
            if (Objects.equals(source, "group")) {
                denySend = senderVars.getIsolationAllowedUsers().getEntries().isEmpty();
                denyRecv = receiverVars.getIsolationActive() && receiverVars.getIsolationAllowedUsers().getEntries().isEmpty();
            } else {
                denySend = !senderVars.getIsolationAllowedUsers().getEntries().contains(receiver.getUUID());
                boolean bl = denyRecv = receiverVars.getIsolationActive() && !receiverVars.getIsolationAllowedUsers().getEntries().contains(sender.getUUID());
            }
            if (denySend || denyRecv) {
                ci.cancel();
            }
        } else if (receiverVars.getIsolationActive() && receiverVars.getIsolationActive() && !receiverVars.getIsolationAllowedUsers().getEntries().contains(sender.getUUID())) {
            ci.cancel();
        }
    }
}

