/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.network.chat.Component
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.server.level.ServerPlayer
 *  net.minecraft.world.entity.player.Player
 *  net.thebrokenscript.brokencore.api.dsl.ComponentUtil
 *  net.thebrokenscript.brokencore.api.dsl.PlayerUtil
 *  net.thebrokenscript.brokencore.api.event.GameEvent
 *  net.thebrokenscript.brokencore.api.event.game.PlayerEvents
 *  net.thebrokenscript.brokencore.api.event.game.PlayerEvents$Sleep
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.handlers;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.thebrokenscript.brokencore.api.dsl.ComponentUtil;
import net.thebrokenscript.brokencore.api.dsl.PlayerUtil;
import net.thebrokenscript.brokencore.api.event.GameEvent;
import net.thebrokenscript.brokencore.api.event.game.PlayerEvents;
import net.thebrokenscript.handlers.player.SleepHandler;
import net.thebrokenscript.misc.ForceRuntimeInit;
import net.thebrokenscript.registry.TBSLang;
import org.jetbrains.annotations.NotNull;

@ForceRuntimeInit
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002\u00a8\u0006\n"}, d2={"Lnet/thebrokenscript/handlers/CanSleepHandler;", "", "<init>", "()V", "showPopUp", "", "player", "Lnet/minecraft/server/level/ServerPlayer;", "text", "", "thebrokenscript-common"})
public final class CanSleepHandler {
    @NotNull
    public static final CanSleepHandler INSTANCE = new CanSleepHandler();

    private CanSleepHandler() {
    }

    private final void showPopUp(ServerPlayer player, String text) {
        Player player2 = (Player)player;
        String string = ComponentUtil.getTranslationKey((Component)((Component)TBSLang.INSTANCE.getALERT_TITLE()));
        Intrinsics.checkNotNull((Object)string);
        PlayerUtil.tryShowAlert((Player)player2, (String)string, (String)text);
    }

    private static final Unit _init_$lambda$0(PlayerEvents.Sleep $this$on) {
        Intrinsics.checkNotNullParameter((Object)$this$on, (String)"$this$on");
        ServerLevel serverLevel = $this$on.getPlayer().serverLevel();
        Intrinsics.checkNotNullExpressionValue((Object)serverLevel, (String)"serverLevel(...)");
        String message = SleepHandler.onPlayerInBed(serverLevel, $this$on.getPlayer());
        if (message != null) {
            INSTANCE.showPopUp($this$on.getPlayer(), message);
            $this$on.setCanceled(true);
        }
        return Unit.INSTANCE;
    }

    static {
        GameEvent.Companion.on(PlayerEvents.SLEEP, CanSleepHandler::_init_$lambda$0);
    }
}

