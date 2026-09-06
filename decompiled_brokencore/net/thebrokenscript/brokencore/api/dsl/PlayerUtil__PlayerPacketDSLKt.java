/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.network.chat.Component
 *  net.minecraft.network.protocol.Packet
 *  net.minecraft.network.protocol.common.custom.CustomPacketPayload
 *  net.minecraft.network.protocol.game.ClientboundStopSoundPacket
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.server.level.ServerPlayer
 *  net.minecraft.world.entity.player.Player
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.dsl;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.network.protocol.game.ClientboundStopSoundPacket;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.thebrokenscript.brokencore.api.dsl.PlayerUtil;
import net.thebrokenscript.brokencore.api.network.PacketSender;
import net.thebrokenscript.brokencore.impl.registry.BCPackets;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=5, xi=48, d1={"\u0000<\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\u001a\u0010\u0003\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007\u001a\n\u0010\b\u001a\u00020\u0001*\u00020\u0002\u001a\u001a\u0010\t\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b\u001a!\u0010\r\u001a\u00020\u0001\"\b\b\u0000\u0010\u000e*\u00020\u000f*\u00020\u00022\u0006\u0010\u0010\u001a\u0002H\u000e\u00a2\u0006\u0002\u0010\u0011\u001a\u0012\u0010\u0012\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0014\u001a\n\u0010\u0015\u001a\u00020\u0001*\u00020\u0002\u001a!\u0010\u0016\u001a\u00020\u0001\"\b\b\u0000\u0010\u000e*\u00020\u000f*\u00020\u00172\u0006\u0010\u0010\u001a\u0002H\u000e\u00a2\u0006\u0002\u0010\u0018\u00a8\u0006\u0019"}, d2={"tryCrash", "", "Lnet/minecraft/world/entity/player/Player;", "trySendOverlay", "texture", "Lnet/minecraft/resources/ResourceLocation;", "duration", "", "tryClearOverlays", "tryShowAlert", "title", "", "message", "trySendCustomPacket", "P", "Lnet/minecraft/network/protocol/common/custom/CustomPacketPayload;", "packet", "(Lnet/minecraft/world/entity/player/Player;Lnet/minecraft/network/protocol/common/custom/CustomPacketPayload;)V", "setActionBar", "text", "Lnet/minecraft/network/chat/Component;", "stopAllSounds", "sendPacket", "Lnet/minecraft/server/level/ServerPlayer;", "(Lnet/minecraft/server/level/ServerPlayer;Lnet/minecraft/network/protocol/common/custom/CustomPacketPayload;)V", "brokencore-common"}, xs="net/thebrokenscript/brokencore/api/dsl/PlayerUtil")
final class PlayerUtil__PlayerPacketDSLKt {
    public static final void tryCrash(@NotNull Player $this$tryCrash) {
        Intrinsics.checkNotNullParameter((Object)$this$tryCrash, (String)"<this>");
        if ($this$tryCrash instanceof ServerPlayer) {
            if (((ServerPlayer)$this$tryCrash).server.isSingleplayer()) {
                ((ServerPlayer)$this$tryCrash).server.saveEverything(true, true, true);
            }
            ((ServerPlayer)$this$tryCrash).server.execute(() -> PlayerUtil__PlayerPacketDSLKt.tryCrash$lambda$0$PlayerUtil__PlayerPacketDSLKt($this$tryCrash));
        }
    }

    public static final void trySendOverlay(@NotNull Player $this$trySendOverlay, @NotNull ResourceLocation texture, long duration2) {
        Intrinsics.checkNotNullParameter((Object)$this$trySendOverlay, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)texture, (String)"texture");
        PlayerUtil.trySendCustomPacket($this$trySendOverlay, (CustomPacketPayload)BCPackets.SHOW_OVERLAY.of(texture, duration2));
    }

    public static final void tryClearOverlays(@NotNull Player $this$tryClearOverlays) {
        Intrinsics.checkNotNullParameter((Object)$this$tryClearOverlays, (String)"<this>");
        PlayerUtil.trySendCustomPacket($this$tryClearOverlays, (CustomPacketPayload)BCPackets.CLEAR_OVERLAYS.create());
    }

    public static final void tryShowAlert(@NotNull Player $this$tryShowAlert, @NotNull String title, @NotNull String message) {
        Intrinsics.checkNotNullParameter((Object)$this$tryShowAlert, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)title, (String)"title");
        Intrinsics.checkNotNullParameter((Object)message, (String)"message");
        PlayerUtil.trySendCustomPacket($this$tryShowAlert, (CustomPacketPayload)BCPackets.OPEN_ALERT_POPUP.of(title, message));
    }

    public static final <P extends CustomPacketPayload> void trySendCustomPacket(@NotNull Player $this$trySendCustomPacket, @NotNull P packet) {
        Intrinsics.checkNotNullParameter((Object)$this$trySendCustomPacket, (String)"<this>");
        Intrinsics.checkNotNullParameter(packet, (String)"packet");
        if ($this$trySendCustomPacket instanceof ServerPlayer && ((ServerPlayer)$this$trySendCustomPacket).connection != null) {
            PacketSender.INSTANCE.sendToPlayer((ServerPlayer)$this$trySendCustomPacket, packet, new CustomPacketPayload[0]);
        }
    }

    public static final void setActionBar(@NotNull Player $this$setActionBar, @NotNull Component text) {
        Intrinsics.checkNotNullParameter((Object)$this$setActionBar, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)text, (String)"text");
        $this$setActionBar.displayClientMessage(text, true);
    }

    public static final void stopAllSounds(@NotNull Player $this$stopAllSounds) {
        Intrinsics.checkNotNullParameter((Object)$this$stopAllSounds, (String)"<this>");
        if ($this$stopAllSounds instanceof ServerPlayer && ((ServerPlayer)$this$stopAllSounds).connection != null) {
            ((ServerPlayer)$this$stopAllSounds).connection.send((Packet)new ClientboundStopSoundPacket(null, null));
        }
    }

    public static final <P extends CustomPacketPayload> void sendPacket(@NotNull ServerPlayer $this$sendPacket, @NotNull P packet) {
        Intrinsics.checkNotNullParameter((Object)$this$sendPacket, (String)"<this>");
        Intrinsics.checkNotNullParameter(packet, (String)"packet");
        PacketSender.INSTANCE.sendToPlayer($this$sendPacket, packet, new CustomPacketPayload[0]);
    }

    private static final void tryCrash$lambda$0$PlayerUtil__PlayerPacketDSLKt(Player $this_tryCrash) {
        PlayerUtil.trySendCustomPacket($this_tryCrash, (CustomPacketPayload)BCPackets.FORCE_CRASH.create());
    }
}

