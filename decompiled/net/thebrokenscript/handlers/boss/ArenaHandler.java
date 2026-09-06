/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.internal.Intrinsics
 *  net.thebrokenscript.brokencore.api.event.GameEvent
 *  net.thebrokenscript.brokencore.api.event.game.LevelTickEvents
 *  net.thebrokenscript.brokencore.api.event.game.LevelTickEvents$Data
 *  net.thebrokenscript.brokencore.api.event.game.ServerEvents
 *  net.thebrokenscript.brokencore.api.event.game.ServerEvents$Data
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.handlers.boss;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import net.thebrokenscript.boss.integrity.Arena;
import net.thebrokenscript.boss.jimmy.JimArena;
import net.thebrokenscript.brokencore.api.event.GameEvent;
import net.thebrokenscript.brokencore.api.event.game.LevelTickEvents;
import net.thebrokenscript.brokencore.api.event.game.ServerEvents;
import net.thebrokenscript.misc.ForceRuntimeInit;
import org.jetbrains.annotations.NotNull;

@ForceRuntimeInit
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2={"Lnet/thebrokenscript/handlers/boss/ArenaHandler;", "", "<init>", "()V", "thebrokenscript-common"})
public final class ArenaHandler {
    @NotNull
    public static final ArenaHandler INSTANCE = new ArenaHandler();

    private ArenaHandler() {
    }

    private static final Unit _init_$lambda$0(LevelTickEvents.Data $this$on) {
        block2: {
            Intrinsics.checkNotNullParameter((Object)$this$on, (String)"$this$on");
            if ($this$on.getLevel().isClientSide) break block2;
            Arena arena = Arena.Companion.getInstance();
            if (arena != null) {
                arena.tick();
            }
            JimArena jimArena = JimArena.instance;
            if (jimArena != null) {
                jimArena.tick();
            }
        }
        return Unit.INSTANCE;
    }

    private static final Unit _init_$lambda$1(ServerEvents.Data $this$on) {
        Intrinsics.checkNotNullParameter((Object)$this$on, (String)"$this$on");
        Arena.instance = null;
        JimArena.instance = null;
        return Unit.INSTANCE;
    }

    private static final Unit _init_$lambda$2(ServerEvents.Data $this$on) {
        Intrinsics.checkNotNullParameter((Object)$this$on, (String)"$this$on");
        Arena.instance = null;
        JimArena.instance = null;
        return Unit.INSTANCE;
    }

    static {
        GameEvent.Companion.on(LevelTickEvents.POST, ArenaHandler::_init_$lambda$0);
        GameEvent.Companion.on(ServerEvents.STOP, ArenaHandler::_init_$lambda$1);
        GameEvent.Companion.on(ServerEvents.START, ArenaHandler::_init_$lambda$2);
    }
}

