/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.random.Random
 *  kotlin.ranges.IntRange
 *  kotlin.ranges.RangesKt
 *  net.minecraft.core.BlockPos
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.phys.Vec3
 *  net.thebrokenscript.brokencore.api.dsl.EntityUtil
 *  net.thebrokenscript.brokencore.api.event.GameEvent
 *  net.thebrokenscript.brokencore.api.event.game.PlayerEvents
 *  net.thebrokenscript.brokencore.api.event.game.PlayerEvents$ChangeDimension
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.world.dimension.boss.stage3;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.TheBrokenScript;
import net.thebrokenscript.api.ext.PlayerExt;
import net.thebrokenscript.boss.integrity.Arena;
import net.thebrokenscript.boss.integrity.ArenaPhase;
import net.thebrokenscript.brokencore.api.dsl.EntityUtil;
import net.thebrokenscript.brokencore.api.event.GameEvent;
import net.thebrokenscript.brokencore.api.event.game.PlayerEvents;
import net.thebrokenscript.data.PlayerVariables;
import net.thebrokenscript.misc.ForceRuntimeInit;
import net.thebrokenscript.registry.TBSDimensions;
import org.jetbrains.annotations.NotNull;

@ForceRuntimeInit
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2={"Lnet/thebrokenscript/world/dimension/boss/stage3/Stage3Dimension;", "", "<init>", "()V", "thebrokenscript-common"})
public final class Stage3Dimension {
    @NotNull
    public static final Stage3Dimension INSTANCE = new Stage3Dimension();

    private Stage3Dimension() {
    }

    private static final Unit _init_$lambda$0(PlayerEvents.ChangeDimension $this$on) {
        Intrinsics.checkNotNullParameter((Object)$this$on, (String)"$this$on");
        if (!Intrinsics.areEqual((Object)$this$on.getTo(), TBSDimensions.STAGE3)) {
            return Unit.INSTANCE;
        }
        if (Arena.Companion.getPhase() == ArenaPhase.Phase2) {
            Arena arena = Arena.Companion.getInstance();
            if (arena != null) {
                arena.nextPhase();
            }
        }
        PlayerExt.INSTANCE.updateVars((Player)$this$on.getPlayer(), (Function1<? super PlayerVariables, Unit>)((Function1)Stage3Dimension::lambda$0$0));
        $this$on.getPlayer().getAbilities().flying = true;
        $this$on.getPlayer().getAbilities().mayfly = true;
        $this$on.getPlayer().onUpdateAbilities();
        $this$on.getPlayer().setDeltaMovement(Vec3.ZERO);
        $this$on.getPlayer().setNoGravity(true);
        TheBrokenScript.serverWorkQueue.add(5L, () -> Stage3Dimension.lambda$0$1($this$on));
        TheBrokenScript.serverWorkQueue.add(35L, () -> Stage3Dimension.lambda$0$2($this$on));
        return Unit.INSTANCE;
    }

    private static final Unit lambda$0$0(PlayerVariables $this$updateVars) {
        Intrinsics.checkNotNullParameter((Object)$this$updateVars, (String)"$this$updateVars");
        $this$updateVars.setSkipFallDamage(true);
        return Unit.INSTANCE;
    }

    private static final Unit lambda$0$1(PlayerEvents.ChangeDimension $this_on) {
        Function0 offset = Stage3Dimension::lambda$0$1$0;
        EntityUtil.teleport((Entity)((Entity)$this_on.getPlayer()), (BlockPos)new BlockPos(216 + ((Number)offset.invoke()).intValue(), -59, 216 + ((Number)offset.invoke()).intValue()));
        return Unit.INSTANCE;
    }

    private static final int lambda$0$1$0() {
        return RangesKt.random((IntRange)new IntRange(-10, 10), (Random)((Random)Random.Default));
    }

    private static final Unit lambda$0$2(PlayerEvents.ChangeDimension $this_on) {
        $this_on.getPlayer().getAbilities().flying = false;
        if (!$this_on.getPlayer().isCreative() && !$this_on.getPlayer().isSpectator()) {
            $this_on.getPlayer().getAbilities().mayfly = false;
        }
        $this_on.getPlayer().onUpdateAbilities();
        $this_on.getPlayer().setDeltaMovement(Vec3.ZERO);
        PlayerExt.INSTANCE.getVars((Player)$this_on.getPlayer()).setFixPos(false);
        PlayerExt.INSTANCE.syncVars((Player)$this_on.getPlayer());
        $this_on.getPlayer().setNoGravity(false);
        if (Arena.Companion.getPhase() == ArenaPhase.Phase3) {
            TheBrokenScript.serverWorkQueue.add(5L, () -> Stage3Dimension.lambda$0$2$0($this_on));
        }
        return Unit.INSTANCE;
    }

    private static final Unit lambda$0$2$0(PlayerEvents.ChangeDimension $this_on) {
        PlayerExt.INSTANCE.updateVars((Player)$this_on.getPlayer(), (Function1<? super PlayerVariables, Unit>)((Function1)Stage3Dimension::lambda$0$2$0$0));
        return Unit.INSTANCE;
    }

    private static final Unit lambda$0$2$0$0(PlayerVariables $this$updateVars) {
        Intrinsics.checkNotNullParameter((Object)$this$updateVars, (String)"$this$updateVars");
        $this$updateVars.setLoadingPhase3(false);
        return Unit.INSTANCE;
    }

    static {
        GameEvent.Companion.on(PlayerEvents.CHANGE_DIMENSION, Stage3Dimension::_init_$lambda$0);
    }
}

