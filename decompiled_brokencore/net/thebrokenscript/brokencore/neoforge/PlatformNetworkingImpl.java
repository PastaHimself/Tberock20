/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.network.protocol.common.custom.CustomPacketPayload
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.server.level.ServerPlayer
 *  net.neoforged.neoforge.network.PacketDistributor
 *  net.neoforged.neoforge.network.handling.IPayloadContext
 *  net.neoforged.neoforge.network.registration.PayloadRegistrar
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.neoforge;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;
import net.thebrokenscript.brokencore.api.network.BasePacket;
import net.thebrokenscript.brokencore.api.network.PacketDirection;
import net.thebrokenscript.brokencore.api.network.PacketHandlerContext;
import net.thebrokenscript.brokencore.api.platform.PlatformNetworking;
import net.thebrokenscript.brokencore.neoforge.PlatformNetworkingEvents;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J)\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0012\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\t\"\u00020\u0007H\u0016\u00a2\u0006\u0002\u0010\nJ1\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u00072\u0012\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\t\"\u00020\u0007H\u0016\u00a2\u0006\u0002\u0010\u000eJ)\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0012\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\t\"\u00020\u0007H\u0016\u00a2\u0006\u0002\u0010\nJ1\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0006\u001a\u00020\u00072\u0012\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\t\"\u00020\u0007H\u0016\u00a2\u0006\u0002\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J%\u0010\u0018\u001a\u0002H\u0019\"\u000e\b\u0000\u0010\u0019*\b\u0012\u0004\u0012\u0002H\u00190\u001a2\u0006\u0010\u0006\u001a\u0002H\u0019H\u0016\u00a2\u0006\u0002\u0010\u001b\u00a8\u0006\u001c"}, d2={"Lnet/thebrokenscript/brokencore/neoforge/PlatformNetworkingImpl;", "Lnet/thebrokenscript/brokencore/api/platform/PlatformNetworking;", "<init>", "()V", "sendToAllPlayers", "", "packet", "Lnet/minecraft/network/protocol/common/custom/CustomPacketPayload;", "packets", "", "(Lnet/minecraft/network/protocol/common/custom/CustomPacketPayload;[Lnet/minecraft/network/protocol/common/custom/CustomPacketPayload;)V", "sendToPlayer", "player", "Lnet/minecraft/server/level/ServerPlayer;", "(Lnet/minecraft/server/level/ServerPlayer;Lnet/minecraft/network/protocol/common/custom/CustomPacketPayload;[Lnet/minecraft/network/protocol/common/custom/CustomPacketPayload;)V", "sendToServer", "sendToPlayersInLevel", "level", "Lnet/minecraft/server/level/ServerLevel;", "(Lnet/minecraft/server/level/ServerLevel;Lnet/minecraft/network/protocol/common/custom/CustomPacketPayload;[Lnet/minecraft/network/protocol/common/custom/CustomPacketPayload;)V", "wrapContext", "Lnet/thebrokenscript/brokencore/api/network/PacketHandlerContext;", "cx", "Lnet/neoforged/neoforge/network/handling/IPayloadContext;", "registerPacket", "P", "Lnet/thebrokenscript/brokencore/api/network/BasePacket;", "(Lnet/thebrokenscript/brokencore/api/network/BasePacket;)Lnet/thebrokenscript/brokencore/api/network/BasePacket;", "brokencore-neoforge"})
public final class PlatformNetworkingImpl
implements PlatformNetworking {
    @Override
    public void sendToAllPlayers(@NotNull CustomPacketPayload packet, CustomPacketPayload ... packets) {
        Intrinsics.checkNotNullParameter((Object)packet, (String)"packet");
        Intrinsics.checkNotNullParameter((Object)packets, (String)"packets");
        PacketDistributor.sendToAllPlayers((CustomPacketPayload)packet, (CustomPacketPayload[])Arrays.copyOf(packets, packets.length));
    }

    @Override
    public void sendToPlayer(@NotNull ServerPlayer player, @NotNull CustomPacketPayload packet, CustomPacketPayload ... packets) {
        Intrinsics.checkNotNullParameter((Object)player, (String)"player");
        Intrinsics.checkNotNullParameter((Object)packet, (String)"packet");
        Intrinsics.checkNotNullParameter((Object)packets, (String)"packets");
        PacketDistributor.sendToPlayer((ServerPlayer)player, (CustomPacketPayload)packet, (CustomPacketPayload[])Arrays.copyOf(packets, packets.length));
    }

    @Override
    public void sendToServer(@NotNull CustomPacketPayload packet, CustomPacketPayload ... packets) {
        Intrinsics.checkNotNullParameter((Object)packet, (String)"packet");
        Intrinsics.checkNotNullParameter((Object)packets, (String)"packets");
        PacketDistributor.sendToServer((CustomPacketPayload)packet, (CustomPacketPayload[])Arrays.copyOf(packets, packets.length));
    }

    @Override
    public void sendToPlayersInLevel(@NotNull ServerLevel level, @NotNull CustomPacketPayload packet, CustomPacketPayload ... packets) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)packet, (String)"packet");
        Intrinsics.checkNotNullParameter((Object)packets, (String)"packets");
        PacketDistributor.sendToPlayersInDimension((ServerLevel)level, (CustomPacketPayload)packet, (CustomPacketPayload[])Arrays.copyOf(packets, packets.length));
    }

    private final PacketHandlerContext wrapContext(IPayloadContext cx) {
        PacketDirection packetDirection;
        if (cx.flow().isClientbound()) {
            packetDirection = PacketDirection.CLIENTBOUND;
        } else if (cx.flow().isServerbound()) {
            packetDirection = PacketDirection.SERVERBOUND;
        } else {
            throw new IllegalArgumentException("Could not determine direction of packet!");
        }
        PacketDirection dir = packetDirection;
        return new PacketHandlerContext(cx.protocol().isConfiguration() ? null : cx.player(), dir, (Function1<? super Runnable, Unit>)((Function1)new Function1<Runnable, Unit>((Object)cx){

            public final void invoke(Runnable p0) {
                ((IPayloadContext)this.receiver).enqueueWork(p0);
            }
        }));
    }

    @Override
    @NotNull
    public <P extends BasePacket<P>> P registerPacket(@NotNull P packet) {
        Intrinsics.checkNotNullParameter(packet, (String)"packet");
        PlatformNetworkingEvents.INSTANCE.getRegistrationQueue$brokencore_neoforge().add((Function1<PayloadRegistrar, Unit>)((Function1)arg_0 -> PlatformNetworkingImpl.registerPacket$lambda$0(packet, this, arg_0)));
        return packet;
    }

    private static final Unit registerPacket$lambda$0(BasePacket $packet, PlatformNetworkingImpl this$0, PayloadRegistrar it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        it.playBidirectional($packet.type(), $packet.streamCodec(), (arg_0, arg_1) -> PlatformNetworkingImpl.registerPacket$lambda$0$0(this$0, arg_0, arg_1));
        return Unit.INSTANCE;
    }

    private static final void registerPacket$lambda$0$0(PlatformNetworkingImpl this$0, BasePacket packet, IPayloadContext cx) {
        Intrinsics.checkNotNull((Object)packet);
        Intrinsics.checkNotNull((Object)cx);
        packet.handle(packet, this$0.wrapContext(cx));
    }
}

