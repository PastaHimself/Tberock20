/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.world.level.Level
 *  net.thebrokenscript.brokencore.api.dsl.LevelUtil
 *  net.thebrokenscript.brokencore.api.event.GameEvent
 *  net.thebrokenscript.brokencore.api.event.game.PlayerEvents
 *  net.thebrokenscript.brokencore.api.event.game.PlayerEvents$ChangeDimension
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.handlers.dimensions;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.Level;
import net.thebrokenscript.boss.integrity.Arena;
import net.thebrokenscript.boss.integrity.Phase;
import net.thebrokenscript.brokencore.api.dsl.LevelUtil;
import net.thebrokenscript.brokencore.api.event.GameEvent;
import net.thebrokenscript.brokencore.api.event.game.PlayerEvents;
import net.thebrokenscript.misc.ForceRuntimeInit;
import org.jetbrains.annotations.NotNull;

@ForceRuntimeInit
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2={"Lnet/thebrokenscript/handlers/dimensions/ArenaDimensionHandler;", "", "<init>", "()V", "thebrokenscript-common"})
public final class ArenaDimensionHandler {
    @NotNull
    public static final ArenaDimensionHandler INSTANCE = new ArenaDimensionHandler();

    private ArenaDimensionHandler() {
    }

    private static final Unit _init_$lambda$0(PlayerEvents.ChangeDimension $this$on) {
        Intrinsics.checkNotNullParameter((Object)$this$on, (String)"$this$on");
        Object object = Arena.instance;
        if (object == null || (object = ((Arena)object).getPhase()) == null) {
            return Unit.INSTANCE;
        }
        Object phase = object;
        if (Intrinsics.areEqual((Object)$this$on.getTo(), ((Phase)phase).getDimension())) {
            ServerLevel serverLevel = $this$on.getPlayer().serverLevel();
            Intrinsics.checkNotNullExpressionValue((Object)serverLevel, (String)"serverLevel(...)");
            LevelUtil.getQueue((Level)((Level)serverLevel)).add(35L, () -> ArenaDimensionHandler.lambda$0$0((Phase)phase, $this$on));
        }
        return Unit.INSTANCE;
    }

    private static final Unit lambda$0$0(Phase $phase, PlayerEvents.ChangeDimension $this_on) {
        $phase.playerEnteredDimension($this_on.getPlayer());
        return Unit.INSTANCE;
    }

    static {
        GameEvent.Companion.on(PlayerEvents.CHANGE_DIMENSION, ArenaDimensionHandler::_init_$lambda$0);
    }
}

