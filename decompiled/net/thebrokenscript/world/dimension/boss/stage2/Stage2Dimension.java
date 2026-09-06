/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.random.Random
 *  kotlin.ranges.IntRange
 *  kotlin.ranges.RangesKt
 *  net.minecraft.core.BlockPos
 *  net.minecraft.server.level.ServerPlayer
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.phys.Vec3
 *  net.thebrokenscript.brokencore.api.dsl.EntityUtil
 *  net.thebrokenscript.brokencore.api.event.GameEvent
 *  net.thebrokenscript.brokencore.api.event.game.PlayerEvents
 *  net.thebrokenscript.brokencore.api.event.game.PlayerEvents$ChangeDimension
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.world.dimension.boss.stage2;

import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.random.Random;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.TheBrokenScript;
import net.thebrokenscript.api.ext.PlayerExt;
import net.thebrokenscript.boss.integrity.Arena;
import net.thebrokenscript.boss.integrity.ArenaPhase;
import net.thebrokenscript.boss.integrity.Phase2;
import net.thebrokenscript.boss.integrity.Phase2Floors;
import net.thebrokenscript.brokencore.api.dsl.EntityUtil;
import net.thebrokenscript.brokencore.api.event.GameEvent;
import net.thebrokenscript.brokencore.api.event.game.PlayerEvents;
import net.thebrokenscript.data.PlayerVariables;
import net.thebrokenscript.misc.ForceRuntimeInit;
import net.thebrokenscript.registry.TBSDimensions;
import org.jetbrains.annotations.NotNull;

@ForceRuntimeInit
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2={"Lnet/thebrokenscript/world/dimension/boss/stage2/Stage2Dimension;", "", "<init>", "()V", "thebrokenscript-common"})
@SourceDebugExtension(value={"SMAP\nStage2Dimension.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Stage2Dimension.kt\nnet/thebrokenscript/world/dimension/boss/stage2/Stage2Dimension\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,71:1\n360#2,7:72\n*S KotlinDebug\n*F\n+ 1 Stage2Dimension.kt\nnet/thebrokenscript/world/dimension/boss/stage2/Stage2Dimension\n*L\n39#1:72,7\n*E\n"})
public final class Stage2Dimension {
    @NotNull
    public static final Stage2Dimension INSTANCE = new Stage2Dimension();

    private Stage2Dimension() {
    }

    private static final Unit _init_$lambda$0(PlayerEvents.ChangeDimension $this$on) {
        Intrinsics.checkNotNullParameter((Object)$this$on, (String)"$this$on");
        if (!Intrinsics.areEqual((Object)$this$on.getTo(), TBSDimensions.STAGE2)) {
            return Unit.INSTANCE;
        }
        $this$on.getPlayer().getAbilities().flying = true;
        $this$on.getPlayer().getAbilities().mayfly = true;
        $this$on.getPlayer().onUpdateAbilities();
        $this$on.getPlayer().setDeltaMovement(Vec3.ZERO);
        $this$on.getPlayer().setNoGravity(true);
        TheBrokenScript.serverWorkQueue.add(1L, () -> Stage2Dimension.lambda$0$0($this$on));
        TheBrokenScript.serverWorkQueue.add(35L, () -> Stage2Dimension.lambda$0$1($this$on));
        return Unit.INSTANCE;
    }

    private static final Unit lambda$0$0(PlayerEvents.ChangeDimension $this_on) {
        block4: {
            int index;
            Arena arena;
            block3: {
                int n;
                Function0 offset = Stage2Dimension::lambda$0$0$0;
                EntityUtil.teleport((Entity)((Entity)$this_on.getPlayer()), (BlockPos)new BlockPos(85 + ((Number)offset.invoke()).intValue(), 255, 85 + ((Number)offset.invoke()).intValue()));
                Arena arena2 = Arena.Companion.getInstance();
                if (arena2 == null) break block4;
                arena = arena2;
                boolean bl = false;
                List<ServerPlayer> $this$indexOfFirst$iv = arena.getPlayers();
                boolean $i$f$indexOfFirst = false;
                int index$iv = 0;
                Iterator<ServerPlayer> iterator = $this$indexOfFirst$iv.iterator();
                while (iterator.hasNext()) {
                    ServerPlayer item$iv;
                    ServerPlayer it = item$iv = iterator.next();
                    boolean bl2 = false;
                    if (Intrinsics.areEqual((Object)it.getUUID(), (Object)$this_on.getPlayer().getUUID())) {
                        n = index$iv;
                        break block3;
                    }
                    ++index$iv;
                }
                n = index = -1;
            }
            if (index != -1) {
                arena.getPlayers().set(index, $this_on.getPlayer());
            }
        }
        return Unit.INSTANCE;
    }

    private static final int lambda$0$0$0() {
        return RangesKt.random((IntRange)new IntRange(-10, 10), (Random)((Random)Random.Default));
    }

    private static final Unit lambda$0$1(PlayerEvents.ChangeDimension $this_on) {
        $this_on.getPlayer().getAbilities().flying = false;
        if (!$this_on.getPlayer().isCreative() && !$this_on.getPlayer().isSpectator()) {
            $this_on.getPlayer().getAbilities().mayfly = false;
        }
        $this_on.getPlayer().onUpdateAbilities();
        $this_on.getPlayer().setDeltaMovement(Vec3.ZERO);
        PlayerExt.INSTANCE.getVars((Player)$this_on.getPlayer()).setFixPos(false);
        PlayerExt.INSTANCE.syncVars((Player)$this_on.getPlayer());
        $this_on.getPlayer().setNoGravity(false);
        if (Arena.Companion.getPhase() == ArenaPhase.Phase2) {
            Object object = Arena.instance;
            if (object != null && (object = ((Arena)object).getPhase2()) != null) {
                ((Phase2)object).setIntegrityLocation$thebrokenscript_common(Phase2Floors.Floor1);
            }
            TheBrokenScript.serverWorkQueue.add(5L, () -> Stage2Dimension.lambda$0$1$0($this_on));
        }
        return Unit.INSTANCE;
    }

    private static final Unit lambda$0$1$0(PlayerEvents.ChangeDimension $this_on) {
        PlayerExt.INSTANCE.updateVars((Player)$this_on.getPlayer(), (Function1<? super PlayerVariables, Unit>)((Function1)Stage2Dimension::lambda$0$1$0$0));
        return Unit.INSTANCE;
    }

    private static final Unit lambda$0$1$0$0(PlayerVariables $this$updateVars) {
        Intrinsics.checkNotNullParameter((Object)$this$updateVars, (String)"$this$updateVars");
        $this$updateVars.setLoadingPhase2(false);
        return Unit.INSTANCE;
    }

    static {
        GameEvent.Companion.on(PlayerEvents.CHANGE_DIMENSION, Stage2Dimension::_init_$lambda$0);
    }
}

