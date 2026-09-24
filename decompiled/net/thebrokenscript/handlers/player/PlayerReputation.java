/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.ranges.RangesKt
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.server.level.ServerPlayer
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.level.Level
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.handlers.player;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.thebrokenscript.api.ext.PlayerExt;
import net.thebrokenscript.data.PlayerVariables;
import net.thebrokenscript.handlers.subs.PlayerTickSubscriber;
import net.thebrokenscript.misc.ForceRuntimeInit;
import org.jetbrains.annotations.NotNull;

@ForceRuntimeInit
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0002\u00a8\u0006\b"}, d2={"Lnet/thebrokenscript/handlers/player/PlayerReputation;", "", "<init>", "()V", "onPlayerTick", "", "player", "Lnet/minecraft/world/entity/player/Player;", "thebrokenscript-common"})
public final class PlayerReputation {
    @NotNull
    public static final PlayerReputation INSTANCE = new PlayerReputation();

    private PlayerReputation() {
    }

    private final void onPlayerTick(Player player) {
        ServerPlayer serverPlayer = player instanceof ServerPlayer ? (ServerPlayer)player : null;
        if (serverPlayer == null) {
            return;
        }
        ServerPlayer player2 = serverPlayer;
        Level level = player2.level();
        ServerLevel serverLevel = level instanceof ServerLevel ? (ServerLevel)level : null;
        if (serverLevel == null) {
            return;
        }
        ServerLevel level2 = serverLevel;
        if (level2.getGameTime() % (long)100 == 0L) {
            int n = PlayerExt.INSTANCE.getVars((Player)player2).getEntityReputation();
            if (!(0 <= n ? n < 101 : false)) {
                PlayerExt.INSTANCE.updateVars((Player)player2, (Function1<? super PlayerVariables, Unit>)((Function1)PlayerReputation::onPlayerTick$lambda$0));
            }
        }
    }

    private static final Unit onPlayerTick$lambda$0(PlayerVariables $this$updateVars) {
        Intrinsics.checkNotNullParameter((Object)$this$updateVars, (String)"$this$updateVars");
        $this$updateVars.setEntityReputation(RangesKt.coerceIn((int)$this$updateVars.getEntityReputation(), (int)0, (int)100));
        return Unit.INSTANCE;
    }

    static {
        PlayerTickSubscriber.INSTANCE.add((Function1<? super Player, Unit>)((Function1)new Function1<Player, Unit>((Object)INSTANCE){

            public final void invoke(Player p0) {
                Intrinsics.checkNotNullParameter((Object)p0, (String)"p0");
                ((PlayerReputation)this.receiver).onPlayerTick(p0);
            }
        }));
    }
}

