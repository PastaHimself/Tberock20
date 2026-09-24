/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.network.protocol.common.custom.CustomPacketPayload
 *  net.minecraft.world.entity.player.Player
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.registry.handlers;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.world.entity.player.Player;
import net.thebrokenscript.brokencore.api.client.level.DimensionInfo;
import net.thebrokenscript.brokencore.api.dsl.PlayerUtil;
import net.thebrokenscript.brokencore.api.event.GameEvent;
import net.thebrokenscript.brokencore.api.event.game.PlayerEvents;
import net.thebrokenscript.brokencore.impl.ForceRuntimeInit;
import net.thebrokenscript.brokencore.impl.registry.BCPackets;
import org.jetbrains.annotations.NotNull;

@ForceRuntimeInit
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2={"Lnet/thebrokenscript/brokencore/api/registry/handlers/UpdateClientDimensionHandler;", "", "<init>", "()V", "brokencore-common"})
public final class UpdateClientDimensionHandler {
    @NotNull
    public static final UpdateClientDimensionHandler INSTANCE = new UpdateClientDimensionHandler();

    private UpdateClientDimensionHandler() {
    }

    private static final Unit _init_$lambda$0(PlayerEvents.ChangeDimension $this$on) {
        Intrinsics.checkNotNullParameter((Object)$this$on, (String)"$this$on");
        PlayerUtil.trySendCustomPacket((Player)$this$on.getPlayer(), (CustomPacketPayload)BCPackets.CHANGE_DIMENSION_CLIENT_PACKET.of(new DimensionInfo($this$on.getFrom(), $this$on.getTo())));
        return Unit.INSTANCE;
    }

    static {
        GameEvent.Companion.on(PlayerEvents.CHANGE_DIMENSION, UpdateClientDimensionHandler::_init_$lambda$0);
    }
}

