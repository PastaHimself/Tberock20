/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.core.BlockPos
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.level.chunk.ChunkAccess
 *  net.thebrokenscript.brokencore.api.dsl.EntityUtil
 *  net.thebrokenscript.brokencore.api.dsl.PositionUtil
 *  net.thebrokenscript.brokencore.api.event.GameEvent
 *  net.thebrokenscript.brokencore.api.event.game.PlayerEvents
 *  net.thebrokenscript.brokencore.api.event.game.PlayerEvents$ChangeDimension
 *  net.thebrokenscript.brokencore.api.queue.WorkQueue
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.world.dimension.null_torture;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.thebrokenscript.TheBrokenScript;
import net.thebrokenscript.api.ext.LevelExt;
import net.thebrokenscript.api.ext.PlayerExt;
import net.thebrokenscript.brokencore.api.dsl.EntityUtil;
import net.thebrokenscript.brokencore.api.dsl.PositionUtil;
import net.thebrokenscript.brokencore.api.event.GameEvent;
import net.thebrokenscript.brokencore.api.event.game.PlayerEvents;
import net.thebrokenscript.brokencore.api.queue.WorkQueue;
import net.thebrokenscript.data.MapVariables;
import net.thebrokenscript.data.PlayerVariables;
import net.thebrokenscript.misc.ForceRuntimeInit;
import net.thebrokenscript.registry.TBSDimensions;
import org.jetbrains.annotations.NotNull;

@ForceRuntimeInit
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2={"Lnet/thebrokenscript/world/dimension/null_torture/NullTortureDimension;", "", "<init>", "()V", "thebrokenscript-common"})
public final class NullTortureDimension {
    @NotNull
    public static final NullTortureDimension INSTANCE = new NullTortureDimension();

    private NullTortureDimension() {
    }

    private static final Unit _init_$lambda$0(PlayerEvents.ChangeDimension $this$on) {
        Intrinsics.checkNotNullParameter((Object)$this$on, (String)"$this$on");
        if (!Intrinsics.areEqual((Object)$this$on.getTo(), TBSDimensions.NULL_TORTURE)) {
            return Unit.INSTANCE;
        }
        Level level = $this$on.getPlayer().level();
        PlayerVariables vars = PlayerExt.INSTANCE.getVars((Player)$this$on.getPlayer());
        if (vars.getFixPos()) {
            WorkQueue.add$default((WorkQueue)TheBrokenScript.serverWorkQueue, (long)0L, () -> NullTortureDimension.lambda$0$0(level, $this$on, vars), (int)1, null);
        }
        PlayerExt.INSTANCE.getVars((Player)$this$on.getPlayer()).setTicksUntilExit(4000L);
        return Unit.INSTANCE;
    }

    private static final Unit lambda$0$0(Level $level, PlayerEvents.ChangeDimension $this_on, PlayerVariables $vars) {
        Intrinsics.checkNotNull((Object)$level);
        if (!LevelExt.INSTANCE.getVars((LevelAccessor)$level).getHasGeneratedNullDimension()) {
            LevelExt.INSTANCE.updateVars((LevelAccessor)$level, (Function1<? super MapVariables, Unit>)((Function1)NullTortureDimension::lambda$0$0$0));
            ChunkAccess chunkAccess = $this_on.getPlayer().level().getChunk($this_on.getPlayer().blockPosition());
            Intrinsics.checkNotNullExpressionValue((Object)chunkAccess, (String)"getChunk(...)");
            ChunkAccess chunk = chunkAccess;
            PlayerExt.INSTANCE.updateVars((Player)$this_on.getPlayer(), (Function1<? super PlayerVariables, Unit>)((Function1)arg_0 -> NullTortureDimension.lambda$0$0$1(chunk, arg_0)));
            EntityUtil.teleport((Entity)((Entity)$this_on.getPlayer()), (BlockPos)$vars.getSpawnPos());
        } else {
            EntityUtil.teleport((Entity)((Entity)$this_on.getPlayer()), (BlockPos)$vars.getSpawnPos());
        }
        $vars.setFixPos(false);
        PlayerExt.INSTANCE.syncVars((Player)$this_on.getPlayer());
        return Unit.INSTANCE;
    }

    private static final Unit lambda$0$0$0(MapVariables $this$updateVars) {
        Intrinsics.checkNotNullParameter((Object)((Object)$this$updateVars), (String)"$this$updateVars");
        $this$updateVars.setHasGeneratedNullDimension(true);
        return Unit.INSTANCE;
    }

    private static final Unit lambda$0$0$1(ChunkAccess $chunk, PlayerVariables $this$updateVars) {
        Intrinsics.checkNotNullParameter((Object)$this$updateVars, (String)"$this$updateVars");
        BlockPos blockPos = $chunk.getPos().getWorldPosition().offset(5, 0, 0);
        Intrinsics.checkNotNullExpressionValue((Object)blockPos, (String)"offset(...)");
        $this$updateVars.setSpawnPos(PositionUtil.withY((BlockPos)blockPos, (Number)66));
        return Unit.INSTANCE;
    }

    static {
        GameEvent.Companion.on(PlayerEvents.CHANGE_DIMENSION, NullTortureDimension::_init_$lambda$0);
    }
}

