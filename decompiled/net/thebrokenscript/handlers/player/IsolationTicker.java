/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.server.MinecraftServer
 *  net.minecraft.server.level.ServerPlayer
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.player.Player
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.handlers.player;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.thebrokenscript.api.ext.PlayerExt;
import net.thebrokenscript.data.PlayerVariables;
import net.thebrokenscript.handlers.subs.PlayerTickSubscriber;
import net.thebrokenscript.misc.ForceRuntimeInit;
import org.jetbrains.annotations.NotNull;

@ForceRuntimeInit
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2={"Lnet/thebrokenscript/handlers/player/IsolationTicker;", "", "<init>", "()V", "thebrokenscript-common"})
public final class IsolationTicker {
    @NotNull
    public static final IsolationTicker INSTANCE = new IsolationTicker();

    private IsolationTicker() {
    }

    private static final Unit _init_$lambda$0(Player it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        ServerPlayer serverPlayer = it instanceof ServerPlayer ? (ServerPlayer)it : null;
        if (serverPlayer == null) {
            return Unit.INSTANCE;
        }
        ServerPlayer player = serverPlayer;
        MinecraftServer server = ((ServerPlayer)it).server;
        if (PlayerExt.INSTANCE.getVars((Player)player).getIsolationActive()) {
            Set remove = new LinkedHashSet();
            for (UUID id : PlayerExt.INSTANCE.getVars((Player)player).getIsolationAllowedUsers().getEntries()) {
                ServerPlayer entity = server.getPlayerList().getPlayer(id);
                if (entity != null && PlayerExt.isEntityInFovCone$default(PlayerExt.INSTANCE, (Player)player, (Entity)entity, null, 2, null)) continue;
                remove.add(id);
            }
            PlayerExt.INSTANCE.updateVars((Player)player, (Function1<? super PlayerVariables, Unit>)((Function1)arg_0 -> IsolationTicker.lambda$0$0(remove, arg_0)));
        }
        return Unit.INSTANCE;
    }

    private static final Unit lambda$0$0(Set $remove, PlayerVariables $this$updateVars) {
        Intrinsics.checkNotNullParameter((Object)$this$updateVars, (String)"$this$updateVars");
        $this$updateVars.getIsolationAllowedUsers().getEntries().removeAll($remove);
        return Unit.INSTANCE;
    }

    static {
        PlayerTickSubscriber.INSTANCE.add((Function1<? super Player, Unit>)((Function1)IsolationTicker::_init_$lambda$0));
    }
}

