/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.wispforest.endec.Endec
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.client.player.LocalPlayer
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.world.entity.player.Player
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.impl.packets;

import io.wispforest.endec.Endec;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.thebrokenscript.brokencore.api.client.level.DimensionInfo;
import net.thebrokenscript.brokencore.api.event.GameEvent;
import net.thebrokenscript.brokencore.api.event.game.PlayerEvents;
import net.thebrokenscript.brokencore.api.network.EndecPacket;
import net.thebrokenscript.brokencore.api.network.PacketHandlerContext;
import net.thebrokenscript.brokencore.impl.BrokenCore;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\rH\u0016R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\u000e"}, d2={"Lnet/thebrokenscript/brokencore/impl/packets/ClientPlayerDimensionChangePacket;", "Lnet/thebrokenscript/brokencore/api/network/EndecPacket;", "Lnet/thebrokenscript/brokencore/api/client/level/DimensionInfo;", "<init>", "()V", "id", "Lnet/minecraft/resources/ResourceLocation;", "getId", "()Lnet/minecraft/resources/ResourceLocation;", "handle", "", "data", "cx", "Lnet/thebrokenscript/brokencore/api/network/PacketHandlerContext;", "brokencore-common"})
public final class ClientPlayerDimensionChangePacket
extends EndecPacket<ClientPlayerDimensionChangePacket, DimensionInfo> {
    @NotNull
    private final ResourceLocation id = BrokenCore.id("client_player_dimension_change");

    public ClientPlayerDimensionChangePacket() {
        super((Endec)DimensionInfo.Companion.getENDEC());
    }

    @Override
    @NotNull
    public ResourceLocation getId() {
        return this.id;
    }

    @Override
    public void handle(@NotNull DimensionInfo data2, @NotNull PacketHandlerContext cx) {
        Intrinsics.checkNotNullParameter((Object)data2, (String)"data");
        Intrinsics.checkNotNullParameter((Object)cx, (String)"cx");
        if (cx.isClientbound) {
            cx.getEnqueueWork().invoke(() -> ClientPlayerDimensionChangePacket.handle$lambda$0(cx, data2));
        }
    }

    private static final void handle$lambda$0(PacketHandlerContext $cx, DimensionInfo $data) {
        Player player = $cx.getPlayer();
        Intrinsics.checkNotNull((Object)player, (String)"null cannot be cast to non-null type net.minecraft.client.player.LocalPlayer");
        GameEvent.Companion.call(PlayerEvents.CHANGE_DIMENSION_CLIENT, new PlayerEvents.ChangeDimensionClient((Player)((LocalPlayer)player), $data.getFrom(), $data.getTo()));
    }
}

