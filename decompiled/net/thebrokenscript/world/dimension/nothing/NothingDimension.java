/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.core.BlockPos
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.level.levelgen.Heightmap$Types
 *  net.minecraft.world.phys.Vec3
 *  net.thebrokenscript.brokencore.api.dsl.EntityUtil
 *  net.thebrokenscript.brokencore.api.dsl.PositionUtil
 *  net.thebrokenscript.brokencore.api.event.GameEvent
 *  net.thebrokenscript.brokencore.api.event.game.PlayerEvents
 *  net.thebrokenscript.brokencore.api.event.game.PlayerEvents$ChangeDimension
 *  net.thebrokenscript.brokencore.api.queue.WorkQueue
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.world.dimension.nothing;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.TheBrokenScript;
import net.thebrokenscript.api.ext.PlayerExt;
import net.thebrokenscript.brokencore.api.dsl.EntityUtil;
import net.thebrokenscript.brokencore.api.dsl.PositionUtil;
import net.thebrokenscript.brokencore.api.event.GameEvent;
import net.thebrokenscript.brokencore.api.event.game.PlayerEvents;
import net.thebrokenscript.brokencore.api.queue.WorkQueue;
import net.thebrokenscript.data.PlayerVariables;
import net.thebrokenscript.misc.ForceRuntimeInit;
import net.thebrokenscript.registry.TBSDimensions;
import org.jetbrains.annotations.NotNull;

@ForceRuntimeInit
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002\u00a8\u0006\u000b"}, d2={"Lnet/thebrokenscript/world/dimension/nothing/NothingDimension;", "", "<init>", "()V", "findSafeSpot", "Lnet/minecraft/core/BlockPos;", "blockPos", "level", "Lnet/minecraft/server/level/ServerLevel;", "depth", "", "thebrokenscript-common"})
public final class NothingDimension {
    @NotNull
    public static final NothingDimension INSTANCE = new NothingDimension();

    private NothingDimension() {
    }

    private final BlockPos findSafeSpot(BlockPos blockPos, ServerLevel level, int depth) {
        BlockPos blockPos2;
        if (depth > 10) {
            return null;
        }
        BlockPos newPos = blockPos.offset(25, 0, 25);
        int y = level.getHeight(Heightmap.Types.WORLD_SURFACE, newPos.getX(), newPos.getZ());
        if (y < 10) {
            Intrinsics.checkNotNull((Object)newPos);
            blockPos2 = this.findSafeSpot(newPos, level, depth + 1);
        } else {
            blockPos2 = newPos;
        }
        return blockPos2;
    }

    private static final Unit _init_$lambda$0(PlayerEvents.ChangeDimension $this$on) {
        Intrinsics.checkNotNullParameter((Object)$this$on, (String)"$this$on");
        if (!Intrinsics.areEqual((Object)$this$on.getTo(), TBSDimensions.NOTHING)) {
            return Unit.INSTANCE;
        }
        ServerLevel serverLevel = $this$on.getPlayer().server.getLevel(TBSDimensions.NOTHING);
        if (serverLevel == null) {
            return Unit.INSTANCE;
        }
        ServerLevel level = serverLevel;
        level.getChunk($this$on.getPlayer().getBlockX() >> 4, $this$on.getPlayer().getBlockZ() >> 4);
        if (PlayerExt.INSTANCE.getVars((Player)$this$on.getPlayer()).getFixPos()) {
            $this$on.getPlayer().getAbilities().flying = true;
            $this$on.getPlayer().getAbilities().mayfly = true;
            $this$on.getPlayer().onUpdateAbilities();
            $this$on.getPlayer().setDeltaMovement(Vec3.ZERO);
            $this$on.getPlayer().setNoGravity(true);
            WorkQueue.add$default((WorkQueue)TheBrokenScript.serverWorkQueue, (long)0L, () -> NothingDimension.lambda$0$0($this$on, level), (int)1, null);
            TheBrokenScript.serverWorkQueue.add(1L, () -> NothingDimension.lambda$0$1($this$on));
        }
        return Unit.INSTANCE;
    }

    private static final Unit lambda$0$0(PlayerEvents.ChangeDimension $this_on, ServerLevel $level) {
        PlayerExt.INSTANCE.updateVars((Player)$this_on.getPlayer(), (Function1<? super PlayerVariables, Unit>)((Function1)NothingDimension::lambda$0$0$0));
        int surfaceHeight = $level.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, $this_on.getPlayer().getBlockX(), $this_on.getPlayer().getBlockZ());
        if (!(0 <= surfaceHeight ? surfaceHeight < 11 : false)) {
            BlockPos blockPos = $this_on.getPlayer().blockPosition();
            Intrinsics.checkNotNullExpressionValue((Object)blockPos, (String)"blockPosition(...)");
            BlockPos newPos = INSTANCE.findSafeSpot(blockPos, $level, 0);
            if (newPos != null) {
                EntityUtil.teleport((Entity)((Entity)$this_on.getPlayer()), (BlockPos)newPos);
                surfaceHeight = $level.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, newPos.getX(), newPos.getZ());
            } else {
                surfaceHeight = 64;
            }
        }
        Entity entity = (Entity)$this_on.getPlayer();
        BlockPos blockPos = $this_on.getPlayer().blockPosition();
        Intrinsics.checkNotNullExpressionValue((Object)blockPos, (String)"blockPosition(...)");
        EntityUtil.teleport((Entity)entity, (BlockPos)PositionUtil.withY((BlockPos)blockPos, (Number)(surfaceHeight + 1)));
        return Unit.INSTANCE;
    }

    private static final Unit lambda$0$0$0(PlayerVariables $this$updateVars) {
        Intrinsics.checkNotNullParameter((Object)$this$updateVars, (String)"$this$updateVars");
        $this$updateVars.setSkipFallDamage(true);
        return Unit.INSTANCE;
    }

    private static final Unit lambda$0$1(PlayerEvents.ChangeDimension $this_on) {
        $this_on.getPlayer().getAbilities().flying = false;
        if (!$this_on.getPlayer().isCreative() && !$this_on.getPlayer().isSpectator()) {
            $this_on.getPlayer().getAbilities().mayfly = false;
        }
        $this_on.getPlayer().onUpdateAbilities();
        $this_on.getPlayer().setDeltaMovement(Vec3.ZERO);
        PlayerExt.INSTANCE.getVars((Player)$this_on.getPlayer()).setTicksUntilExit(1200L);
        PlayerExt.INSTANCE.getVars((Player)$this_on.getPlayer()).setFixPos(false);
        PlayerExt.INSTANCE.syncVars((Player)$this_on.getPlayer());
        $this_on.getPlayer().setNoGravity(false);
        return Unit.INSTANCE;
    }

    static {
        GameEvent.Companion.on(PlayerEvents.CHANGE_DIMENSION, NothingDimension::_init_$lambda$0);
    }
}

