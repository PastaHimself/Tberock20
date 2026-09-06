/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.authlib.GameProfile
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.network.protocol.common.custom.CustomPacketPayload
 *  net.minecraft.server.level.ServerPlayer
 *  net.minecraft.world.entity.player.Player
 *  net.thebrokenscript.brokencore.api.fake.CustomPlayerManager
 *  net.thebrokenscript.brokencore.api.network.PacketSender
 *  net.thebrokenscript.brokencore.impl.registry.BCPackets
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.handlers.player;

import com.mojang.authlib.GameProfile;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.thebrokenscript.brokencore.api.fake.CustomPlayerManager;
import net.thebrokenscript.brokencore.api.network.PacketSender;
import net.thebrokenscript.brokencore.impl.registry.BCPackets;
import net.thebrokenscript.handlers.subs.PlayerLoggedInSubscriber;
import net.thebrokenscript.misc.ForceRuntimeInit;
import org.jetbrains.annotations.NotNull;

@ForceRuntimeInit
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2={"Lnet/thebrokenscript/handlers/player/CustomPlayerSync;", "", "<init>", "()V", "thebrokenscript-common"})
public final class CustomPlayerSync {
    @NotNull
    public static final CustomPlayerSync INSTANCE = new CustomPlayerSync();

    private CustomPlayerSync() {
    }

    private static final Unit _init_$lambda$0(Player it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        if (!(it instanceof ServerPlayer)) {
            return Unit.INSTANCE;
        }
        Iterator iterator = CustomPlayerManager.customPlayers.entrySet().iterator();
        while (iterator.hasNext()) {
            ServerPlayer player = (ServerPlayer)iterator.next().getValue();
            ServerPlayer serverPlayer = (ServerPlayer)it;
            GameProfile gameProfile = player.getGameProfile();
            Intrinsics.checkNotNullExpressionValue((Object)gameProfile, (String)"getGameProfile(...)");
            PacketSender.INSTANCE.sendToPlayer(serverPlayer, (CustomPacketPayload)BCPackets.ADD_FAKE_PLAYER.of((Object)gameProfile), new CustomPacketPayload[0]);
        }
        return Unit.INSTANCE;
    }

    static {
        PlayerLoggedInSubscriber.INSTANCE.add((Function1<? super Player, Unit>)((Function1)CustomPlayerSync::_init_$lambda$0));
    }
}

