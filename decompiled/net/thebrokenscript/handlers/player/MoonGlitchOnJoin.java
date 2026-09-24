/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.core.Holder
 *  net.minecraft.server.level.ServerPlayer
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.LevelAccessor
 *  net.thebrokenscript.brokencore.api.dsl.EntityUtil
 *  net.thebrokenscript.brokencore.api.dsl.PlayerUtil
 *  net.thebrokenscript.brokencore.impl.config.BCConfigs
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.handlers.player;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.core.Holder;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.thebrokenscript.api.ext.LevelExt;
import net.thebrokenscript.api.ext.PlayerExt;
import net.thebrokenscript.brokencore.api.dsl.EntityUtil;
import net.thebrokenscript.brokencore.api.dsl.PlayerUtil;
import net.thebrokenscript.brokencore.impl.config.BCConfigs;
import net.thebrokenscript.handlers.subs.PlayerLoggedInSubscriber;
import net.thebrokenscript.misc.ForceRuntimeInit;
import net.thebrokenscript.registry.TBSSounds;
import org.jetbrains.annotations.NotNull;

@ForceRuntimeInit
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0002\u00a8\u0006\b"}, d2={"Lnet/thebrokenscript/handlers/player/MoonGlitchOnJoin;", "", "<init>", "()V", "onPlayerLoggedIn", "", "player", "Lnet/minecraft/world/entity/player/Player;", "thebrokenscript-common"})
public final class MoonGlitchOnJoin {
    @NotNull
    public static final MoonGlitchOnJoin INSTANCE = new MoonGlitchOnJoin();

    private MoonGlitchOnJoin() {
    }

    private final void onPlayerLoggedIn(Player player) {
        ServerPlayer serverPlayer = player instanceof ServerPlayer ? (ServerPlayer)player : null;
        if (serverPlayer == null) {
            return;
        }
        ServerPlayer player2 = serverPlayer;
        Level level = player2.level();
        Intrinsics.checkNotNullExpressionValue((Object)level, (String)"level(...)");
        if (LevelExt.INSTANCE.getVars((LevelAccessor)level).isNullHere() || !BCConfigs.INSTANCE.getServer().getEvents().getEnableRandomEvents()) {
            return;
        }
        EntityUtil.getQueue((Entity)((Entity)player2)).add(12000L, () -> MoonGlitchOnJoin.onPlayerLoggedIn$lambda$0(player2));
    }

    private static final Unit onPlayerLoggedIn$lambda$0(ServerPlayer $player) {
        if (PlayerExt.INSTANCE.getMoonGlitchDuration($player) < 1.0) {
            PlayerUtil.sendSound$default((ServerPlayer)$player, (Holder)((Holder)TBSSounds.MOON_GLITCH), (float)10.0f, (float)0.0f, null, null, (long)0L, (int)60, null);
            PlayerExt.INSTANCE.setMoonGlitchDuration($player, 1600.0);
        }
        return Unit.INSTANCE;
    }

    static {
        PlayerLoggedInSubscriber.INSTANCE.add((Function1<? super Player, Unit>)((Function1)new Function1<Player, Unit>((Object)INSTANCE){

            public final void invoke(Player p0) {
                Intrinsics.checkNotNullParameter((Object)p0, (String)"p0");
                ((MoonGlitchOnJoin)this.receiver).onPlayerLoggedIn(p0);
            }
        }));
    }
}

