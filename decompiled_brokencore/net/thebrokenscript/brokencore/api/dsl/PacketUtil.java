/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.JvmName
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.network.protocol.Packet
 *  net.minecraft.server.MinecraftServer
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.server.level.ServerPlayer
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.phys.Vec3
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.brokencore.api.dsl;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.network.protocol.Packet;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.brokencore.api.dsl.EntityFinder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=2, xi=48, d1={"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0004\n\u0002\b\u0002\u001a\u001d\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004\u00a2\u0006\u0002\u0010\u0005\u001a-\u0010\u0006\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004\u00a2\u0006\u0002\u0010\u000b\u00a8\u0006\f"}, d2={"tryBroadcastPacket", "", "Lnet/minecraft/world/level/LevelAccessor;", "packet", "Lnet/minecraft/network/protocol/Packet;", "(Lnet/minecraft/world/level/LevelAccessor;Lnet/minecraft/network/protocol/Packet;)Lkotlin/Unit;", "tryBroadcastPacketInRange", "pos", "Lnet/minecraft/world/phys/Vec3;", "range", "", "(Lnet/minecraft/world/level/LevelAccessor;Lnet/minecraft/world/phys/Vec3;Ljava/lang/Number;Lnet/minecraft/network/protocol/Packet;)Lkotlin/Unit;", "brokencore-common"})
@JvmName(name="PacketUtil")
@SourceDebugExtension(value={"SMAP\nPacketDSL.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PacketDSL.kt\nnet/thebrokenscript/brokencore/api/dsl/PacketUtil\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,14:1\n1869#2,2:15\n*S KotlinDebug\n*F\n+ 1 PacketDSL.kt\nnet/thebrokenscript/brokencore/api/dsl/PacketUtil\n*L\n13#1:15,2\n*E\n"})
public final class PacketUtil {
    @Nullable
    public static final Unit tryBroadcastPacket(@NotNull LevelAccessor $this$tryBroadcastPacket, @NotNull Packet<?> packet) {
        Unit unit;
        Intrinsics.checkNotNullParameter((Object)$this$tryBroadcastPacket, (String)"<this>");
        Intrinsics.checkNotNullParameter(packet, (String)"packet");
        MinecraftServer minecraftServer = $this$tryBroadcastPacket.getServer();
        if (minecraftServer != null && (minecraftServer = minecraftServer.getPlayerList()) != null) {
            minecraftServer.broadcastAll(packet);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        return unit;
    }

    @Nullable
    public static final Unit tryBroadcastPacketInRange(@NotNull LevelAccessor $this$tryBroadcastPacketInRange, @NotNull Vec3 pos, @NotNull Number range, @NotNull Packet<?> packet) {
        Unit unit;
        Intrinsics.checkNotNullParameter((Object)$this$tryBroadcastPacketInRange, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        Intrinsics.checkNotNullParameter((Object)range, (String)"range");
        Intrinsics.checkNotNullParameter(packet, (String)"packet");
        Object object = $this$tryBroadcastPacketInRange instanceof ServerLevel ? (ServerLevel)$this$tryBroadcastPacketInRange : null;
        if (object != null && (object = EntityFinder.findPlayersInRange(object, pos, range)) != null) {
            Iterable $this$forEach$iv = (Iterable)object;
            boolean $i$f$forEach = false;
            for (Object element$iv : $this$forEach$iv) {
                ServerPlayer it = (ServerPlayer)element$iv;
                boolean bl = false;
                it.connection.send(packet);
            }
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        return unit;
    }
}

