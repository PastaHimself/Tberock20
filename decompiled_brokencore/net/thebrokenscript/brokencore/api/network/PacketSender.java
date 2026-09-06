/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.client.Minecraft
 *  net.minecraft.network.protocol.common.custom.CustomPacketPayload
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.server.level.ServerPlayer
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.network;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.Minecraft;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.thebrokenscript.brokencore.api.platform.PlatformNetworking;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J'\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0012\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\t\"\u00020\u0007\u00a2\u0006\u0002\u0010\nJ/\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u00072\u0012\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\t\"\u00020\u0007\u00a2\u0006\u0002\u0010\u000eJ'\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0012\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\t\"\u00020\u0007\u00a2\u0006\u0002\u0010\nJ/\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0006\u001a\u00020\u00072\u0012\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\t\"\u00020\u0007\u00a2\u0006\u0002\u0010\u0013\u00a8\u0006\u0014"}, d2={"Lnet/thebrokenscript/brokencore/api/network/PacketSender;", "", "<init>", "()V", "sendToAllPlayers", "", "packet", "Lnet/minecraft/network/protocol/common/custom/CustomPacketPayload;", "packets", "", "(Lnet/minecraft/network/protocol/common/custom/CustomPacketPayload;[Lnet/minecraft/network/protocol/common/custom/CustomPacketPayload;)V", "sendToPlayer", "player", "Lnet/minecraft/server/level/ServerPlayer;", "(Lnet/minecraft/server/level/ServerPlayer;Lnet/minecraft/network/protocol/common/custom/CustomPacketPayload;[Lnet/minecraft/network/protocol/common/custom/CustomPacketPayload;)V", "sendToServer", "sendToPlayersInLevel", "level", "Lnet/minecraft/server/level/ServerLevel;", "(Lnet/minecraft/server/level/ServerLevel;Lnet/minecraft/network/protocol/common/custom/CustomPacketPayload;[Lnet/minecraft/network/protocol/common/custom/CustomPacketPayload;)V", "brokencore-common"})
public final class PacketSender {
    @NotNull
    public static final PacketSender INSTANCE = new PacketSender();

    private PacketSender() {
    }

    public final void sendToAllPlayers(@NotNull CustomPacketPayload packet, CustomPacketPayload ... packets) {
        Intrinsics.checkNotNullParameter((Object)packet, (String)"packet");
        Intrinsics.checkNotNullParameter((Object)packets, (String)"packets");
        PlatformNetworking.Companion.getINSTANCE().sendToAllPlayers(packet, Arrays.copyOf(packets, packets.length));
    }

    public final void sendToPlayer(@NotNull ServerPlayer player, @NotNull CustomPacketPayload packet, CustomPacketPayload ... packets) {
        Intrinsics.checkNotNullParameter((Object)player, (String)"player");
        Intrinsics.checkNotNullParameter((Object)packet, (String)"packet");
        Intrinsics.checkNotNullParameter((Object)packets, (String)"packets");
        PlatformNetworking.Companion.getINSTANCE().sendToPlayer(player, packet, Arrays.copyOf(packets, packets.length));
    }

    public final void sendToServer(@NotNull CustomPacketPayload packet, CustomPacketPayload ... packets) {
        Intrinsics.checkNotNullParameter((Object)packet, (String)"packet");
        Intrinsics.checkNotNullParameter((Object)packets, (String)"packets");
        Minecraft minceraft = Minecraft.getInstance();
        if (minceraft.getConnection() == null || minceraft.level == null) {
            return;
        }
        PlatformNetworking.Companion.getINSTANCE().sendToServer(packet, Arrays.copyOf(packets, packets.length));
    }

    public final void sendToPlayersInLevel(@NotNull ServerLevel level, @NotNull CustomPacketPayload packet, CustomPacketPayload ... packets) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)packet, (String)"packet");
        Intrinsics.checkNotNullParameter((Object)packets, (String)"packets");
        PlatformNetworking.Companion.getINSTANCE().sendToPlayersInLevel(level, packet, Arrays.copyOf(packets, packets.length));
    }
}

