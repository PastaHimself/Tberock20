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
 *  net.minecraft.world.phys.Vec3
 *  net.thebrokenscript.brokencore.api.dsl.EntityUtil
 *  net.thebrokenscript.brokencore.api.dsl.PositionUtil
 *  net.thebrokenscript.brokencore.api.event.GameEvent
 *  net.thebrokenscript.brokencore.api.event.game.PlayerEvents
 *  net.thebrokenscript.brokencore.api.event.game.PlayerEvents$ChangeDimension
 *  net.thebrokenscript.brokencore.api.queue.WorkQueue
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.world.dimension.clan_void;

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
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.TheBrokenScript;
import net.thebrokenscript.api.ext.LevelExt;
import net.thebrokenscript.api.ext.PlayerExt;
import net.thebrokenscript.brokencore.api.dsl.EntityUtil;
import net.thebrokenscript.brokencore.api.dsl.PositionUtil;
import net.thebrokenscript.brokencore.api.event.GameEvent;
import net.thebrokenscript.brokencore.api.event.game.PlayerEvents;
import net.thebrokenscript.brokencore.api.queue.WorkQueue;
import net.thebrokenscript.data.MapVariables;
import net.thebrokenscript.misc.ForceRuntimeInit;
import net.thebrokenscript.registry.TBSDimensions;
import org.jetbrains.annotations.NotNull;

@ForceRuntimeInit
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2={"Lnet/thebrokenscript/world/dimension/clan_void/ClanVoidDimension;", "", "<init>", "()V", "thebrokenscript-common"})
public final class ClanVoidDimension {
    @NotNull
    public static final ClanVoidDimension INSTANCE = new ClanVoidDimension();

    private ClanVoidDimension() {
    }

    private static final Unit _init_$lambda$0(PlayerEvents.ChangeDimension $this$on) {
        Intrinsics.checkNotNullParameter((Object)$this$on, (String)"$this$on");
        if (!Intrinsics.areEqual((Object)$this$on.getTo(), TBSDimensions.CLAN_VOID)) {
            return Unit.INSTANCE;
        }
        Level level = $this$on.getPlayer().level();
        Intrinsics.checkNotNull((Object)level);
        if (!LevelExt.INSTANCE.getVars((LevelAccessor)level).getHasGeneratedClanBuildDimension()) {
            LevelExt.INSTANCE.updateVars((LevelAccessor)level, (Function1<? super MapVariables, Unit>)((Function1)ClanVoidDimension::lambda$0$0));
        }
        if (PlayerExt.INSTANCE.getVars((Player)$this$on.getPlayer()).getFixPos()) {
            $this$on.getPlayer().setNoGravity(true);
            ChunkAccess chunkAccess = $this$on.getPlayer().level().getChunk($this$on.getPlayer().blockPosition());
            Intrinsics.checkNotNullExpressionValue((Object)chunkAccess, (String)"getChunk(...)");
            ChunkAccess chunk = chunkAccess;
            WorkQueue.add$default((WorkQueue)TheBrokenScript.serverWorkQueue, (long)0L, () -> ClanVoidDimension.lambda$0$1(level, chunk, $this$on), (int)1, null);
            PlayerExt.INSTANCE.getVars((Player)$this$on.getPlayer()).setFixPos(false);
            PlayerExt.INSTANCE.syncVars((Player)$this$on.getPlayer());
        }
        return Unit.INSTANCE;
    }

    private static final Unit lambda$0$0(MapVariables $this$updateVars) {
        Intrinsics.checkNotNullParameter((Object)((Object)$this$updateVars), (String)"$this$updateVars");
        $this$updateVars.setHasGeneratedClanBuildDimension(true);
        return Unit.INSTANCE;
    }

    private static final Unit lambda$0$1(Level $level, ChunkAccess $chunk, PlayerEvents.ChangeDimension $this_on) {
        int y = $level.random.nextBoolean() ? 201 : ($level.random.nextBoolean() ? 206 : ($level.random.nextBoolean() ? 216 : 253));
        BlockPos blockPos = $chunk.getPos().getWorldPosition().offset(9, 0, 9);
        Intrinsics.checkNotNullExpressionValue((Object)blockPos, (String)"offset(...)");
        if ($level.getBlockState(PositionUtil.withY((BlockPos)blockPos, (Number)y)).isAir()) {
            Entity entity = (Entity)$this_on.getPlayer();
            BlockPos blockPos2 = $chunk.getPos().getWorldPosition().offset(8, 0, 8);
            Intrinsics.checkNotNullExpressionValue((Object)blockPos2, (String)"offset(...)");
            Vec3 vec3 = PositionUtil.withY((BlockPos)blockPos2, (Number)(y + 1)).getCenter().add(-0.5, -0.5, -0.5);
            Intrinsics.checkNotNullExpressionValue((Object)vec3, (String)"add(...)");
            EntityUtil.teleport((Entity)entity, (Vec3)vec3);
        } else {
            Entity entity = (Entity)$this_on.getPlayer();
            BlockPos blockPos3 = $chunk.getPos().getWorldPosition().offset(4, 0, 4);
            Intrinsics.checkNotNullExpressionValue((Object)blockPos3, (String)"offset(...)");
            Vec3 vec3 = PositionUtil.withY((BlockPos)blockPos3, (Number)y).getCenter().add(-0.5, -0.5, -0.5);
            Intrinsics.checkNotNullExpressionValue((Object)vec3, (String)"add(...)");
            EntityUtil.teleport((Entity)entity, (Vec3)vec3);
        }
        TheBrokenScript.serverWorkQueue.add(1L, () -> ClanVoidDimension.lambda$0$1$0($level, $this_on));
        $this_on.getPlayer().setNoGravity(false);
        return Unit.INSTANCE;
    }

    private static final Unit lambda$0$1$0(Level $level, PlayerEvents.ChangeDimension $this_on) {
        if (!$level.getBlockState($this_on.getPlayer().blockPosition().above()).isAir()) {
            Entity entity = (Entity)$this_on.getPlayer();
            Vec3 vec3 = $this_on.getPlayer().position().add(2.0, 0.0, 0.0);
            Intrinsics.checkNotNullExpressionValue((Object)vec3, (String)"add(...)");
            EntityUtil.teleport((Entity)entity, (Vec3)vec3);
        }
        return Unit.INSTANCE;
    }

    static {
        GameEvent.Companion.on(PlayerEvents.CHANGE_DIMENSION, ClanVoidDimension::_init_$lambda$0);
    }
}

