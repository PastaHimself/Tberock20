/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.network.protocol.common.custom.CustomPacketPayload
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.server.level.ServerPlayer
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.client.overlay;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.thebrokenscript.brokencore.api.client.overlay.OverlayQueueInfo;
import net.thebrokenscript.brokencore.api.network.PacketSender;
import net.thebrokenscript.brokencore.impl.registry.BCPackets;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\bJ\u001f\u0010\u000f\u001a\u00020\n2\u0012\u0010\u0010\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00120\u0011\"\u00020\u0012\u00a2\u0006\u0002\u0010\u0013R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0014\u001a\u00020\b8F\u00a2\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006\u0017"}, d2={"Lnet/thebrokenscript/brokencore/api/client/overlay/OverlayQueue;", "", "<init>", "()V", "infos", "", "Lnet/thebrokenscript/brokencore/api/client/overlay/OverlayQueueInfo;", "currentDelay", "", "add", "", "delay", "texture", "Lnet/minecraft/resources/ResourceLocation;", "duration", "send", "players", "", "Lnet/minecraft/server/level/ServerPlayer;", "([Lnet/minecraft/server/level/ServerPlayer;)V", "totalTime", "getTotalTime", "()J", "brokencore-common"})
public final class OverlayQueue {
    @NotNull
    private final List<OverlayQueueInfo> infos = new ArrayList();
    private long currentDelay;

    public final void add(long delay, @NotNull ResourceLocation texture, long duration2) {
        Intrinsics.checkNotNullParameter((Object)texture, (String)"texture");
        this.currentDelay += delay;
        this.infos.add(new OverlayQueueInfo(texture, duration2, this.currentDelay));
    }

    public final void send(ServerPlayer ... players) {
        Intrinsics.checkNotNullParameter((Object)players, (String)"players");
        for (ServerPlayer player : players) {
            PacketSender.INSTANCE.sendToPlayer(player, (CustomPacketPayload)BCPackets.OVERLAY_QUEUE.of(this.infos), new CustomPacketPayload[0]);
        }
    }

    public final long getTotalTime() {
        return this.currentDelay;
    }
}

