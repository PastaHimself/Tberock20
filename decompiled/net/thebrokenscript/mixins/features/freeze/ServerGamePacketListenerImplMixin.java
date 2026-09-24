/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.llamalad7.mixinextras.injector.ModifyReturnValue
 *  com.llamalad7.mixinextras.injector.wrapmethod.WrapMethod
 *  com.llamalad7.mixinextras.injector.wrapoperation.Operation
 *  com.llamalad7.mixinextras.sugar.Local
 *  javax.annotation.Nullable
 *  kotlin.Pair
 *  net.minecraft.Util
 *  net.minecraft.network.PacketSendListener
 *  net.minecraft.network.protocol.Packet
 *  net.minecraft.network.protocol.PacketType
 *  net.minecraft.network.protocol.common.CommonPacketTypes
 *  net.minecraft.network.protocol.common.custom.CustomPacketPayload
 *  net.minecraft.network.protocol.game.GamePacketTypes
 *  net.minecraft.network.protocol.game.ServerboundUseItemPacket
 *  net.minecraft.server.level.ServerPlayer
 *  net.minecraft.server.network.ServerCommonPacketListenerImpl
 *  net.minecraft.server.network.ServerGamePacketListenerImpl
 *  net.minecraft.server.network.ServerPlayerConnection
 *  net.minecraft.world.entity.player.Player
 *  org.jetbrains.annotations.NotNull
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 */
package net.thebrokenscript.mixins.features.freeze;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import com.llamalad7.mixinextras.injector.wrapmethod.WrapMethod;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.sugar.Local;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import javax.annotation.Nullable;
import kotlin.Pair;
import net.minecraft.Util;
import net.minecraft.network.PacketSendListener;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.PacketType;
import net.minecraft.network.protocol.common.CommonPacketTypes;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.network.protocol.game.GamePacketTypes;
import net.minecraft.network.protocol.game.ServerboundUseItemPacket;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.network.ServerCommonPacketListenerImpl;
import net.minecraft.server.network.ServerGamePacketListenerImpl;
import net.minecraft.server.network.ServerPlayerConnection;
import net.minecraft.world.entity.player.Player;
import net.thebrokenscript.api.ext.PlayerExt;
import net.thebrokenscript.mixinterfaces.ServerConnectionExt;
import net.thebrokenscript.registry.TBSPackets;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(value={ServerGamePacketListenerImpl.class})
public abstract class ServerGamePacketListenerImplMixin
extends ServerCommonPacketListenerImpl
implements ServerPlayerConnection,
ServerConnectionExt {
    @Unique
    private static final Set<PacketType<?>> ALLOWED_PACKETS = (Set)Util.make(new HashSet(), s -> {
        s.add(CommonPacketTypes.SERVERBOUND_KEEP_ALIVE);
        s.add(CommonPacketTypes.SERVERBOUND_CLIENT_INFORMATION);
        s.add(CommonPacketTypes.SERVERBOUND_PONG);
        s.add(GamePacketTypes.SERVERBOUND_USE_ITEM);
        s.add(CommonPacketTypes.CLIENTBOUND_CUSTOM_PAYLOAD);
        s.add(CommonPacketTypes.CLIENTBOUND_KEEP_ALIVE);
        s.add(CommonPacketTypes.CLIENTBOUND_PING);
    });
    @Unique
    private final Collection<Pair<Packet<?>, PacketSendListener>> tbs$deferredPackets = new ConcurrentLinkedQueue();

    public ServerGamePacketListenerImplMixin() {
        super(null, null, null);
    }

    @WrapMethod(method={"tick"})
    private void maybeTick(Operation<Void> original) {
        ServerPlayer player = this.getPlayer();
        if (PlayerExt.INSTANCE.getVars((Player)player).isDesync()) {
            this.keepConnectionAlive();
        } else {
            original.call(new Object[0]);
        }
    }

    @ModifyReturnValue(method={"shouldHandleMessage"}, at={@At(value="RETURN")})
    private boolean maybeHandleMessage(boolean original, @Local(argsOnly=true) Packet<?> packet) {
        if (!original) {
            return false;
        }
        if (PlayerExt.INSTANCE.getVars((Player)this.getPlayer()).isDesync()) {
            CustomPacketPayload c;
            if (packet instanceof CustomPacketPayload && (c = (CustomPacketPayload)packet).type().id().equals((Object)TBSPackets.PLAYER_VARS_SYNC.getId())) {
                return true;
            }
            return ALLOWED_PACKETS.contains(packet.type());
        }
        return true;
    }

    @WrapMethod(method={"handleUseItem"})
    private void maybeUseItem(ServerboundUseItemPacket packet, Operation<Void> original) {
        ServerPlayer player = this.getPlayer();
        if (!PlayerExt.INSTANCE.getVars((Player)player).isDesync()) {
            original.call(new Object[]{new ServerboundUseItemPacket(packet.getHand(), packet.getSequence(), player.getYRot(), player.getXRot())});
        }
    }

    public void send(@NotNull Packet<?> packet, @Nullable PacketSendListener listener) {
        ServerPlayer player = this.getPlayer();
        boolean send = false;
        if (PlayerExt.INSTANCE.getVars((Player)player).isDesync()) {
            CustomPacketPayload customPacket;
            if (packet instanceof CustomPacketPayload && (customPacket = (CustomPacketPayload)packet).type().id().equals((Object)TBSPackets.PLAYER_VARS_SYNC.getId())) {
                send = true;
            }
            if (ALLOWED_PACKETS.contains(packet.type())) {
                send = true;
            }
        } else {
            send = true;
        }
        if (send) {
            super.send(packet, listener);
        } else {
            this.tbs$deferredPackets.add(new Pair(packet, (Object)listener));
        }
    }

    @Override
    public void tbs$sendDeferredPackets() {
        for (Pair<Packet<?>, PacketSendListener> pair : this.tbs$deferredPackets) {
            super.send((Packet)pair.getFirst(), (PacketSendListener)pair.getSecond());
        }
        this.tbs$deferredPackets.clear();
    }
}

