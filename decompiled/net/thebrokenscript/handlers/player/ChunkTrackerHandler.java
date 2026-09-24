/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.functions.Function4
 *  kotlin.jvm.functions.Function5
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.core.BlockPos
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.level.ChunkPos
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.levelgen.Heightmap$Types
 *  net.thebrokenscript.brokencore.api.platform.CancelProxy
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.handlers.player;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.Heightmap;
import net.thebrokenscript.api.ext.LevelExt;
import net.thebrokenscript.brokencore.api.platform.CancelProxy;
import net.thebrokenscript.data.PlayerModifiedChunksData;
import net.thebrokenscript.handlers.player.ChunkTrackerHandler;
import net.thebrokenscript.handlers.subs.BlockBreakSubscriber;
import net.thebrokenscript.handlers.subs.EntityPlaceSubscriber;
import net.thebrokenscript.misc.ForceRuntimeInit;
import org.jetbrains.annotations.NotNull;

@ForceRuntimeInit
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2={"Lnet/thebrokenscript/handlers/player/ChunkTrackerHandler;", "", "<init>", "()V", "thebrokenscript-common"})
@SourceDebugExtension(value={"SMAP\nChunkTrackerHandler.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ChunkTrackerHandler.kt\nnet/thebrokenscript/handlers/player/ChunkTrackerHandler\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,42:1\n1#2:43\n*E\n"})
public final class ChunkTrackerHandler {
    @NotNull
    public static final ChunkTrackerHandler INSTANCE = new ChunkTrackerHandler();

    private ChunkTrackerHandler() {
    }

    private static final Unit _init_$lambda$0(BlockPos pos, LevelAccessor level, Entity entity, BlockState blockState, CancelProxy cancelProxy) {
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)blockState, (String)"<unused var>");
        Intrinsics.checkNotNullParameter((Object)cancelProxy, (String)"<unused var>");
        if (entity == null) {
            return Unit.INSTANCE;
        }
        if (!(entity instanceof Player)) {
            return Unit.INSTANCE;
        }
        if (!(level instanceof ServerLevel)) {
            return Unit.INSTANCE;
        }
        int surfaceY = ((ServerLevel)level).getHeight(Heightmap.Types.WORLD_SURFACE, pos.getX(), pos.getZ());
        if (pos.getY() < surfaceY) {
            return Unit.INSTANCE;
        }
        long chunkLong = new ChunkPos(pos).toLong();
        PlayerModifiedChunksData data = LevelExt.INSTANCE.getPlayerChunks(level);
        data.getChunks().merge(chunkLong, 1L, (arg_0, arg_1) -> ChunkTrackerHandler.lambda$0$0(1.1.INSTANCE, arg_0, arg_1));
        data.setDirty();
        return Unit.INSTANCE;
    }

    private static final Long lambda$0$0(Function2 $tmp0, Object p0, Object p1) {
        return (Long)$tmp0.invoke(p0, p1);
    }

    private static final Unit _init_$lambda$1(Level level, BlockPos pos, BlockState state, Entity entity) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        Intrinsics.checkNotNullParameter((Object)state, (String)"state");
        if (entity == null) {
            return Unit.INSTANCE;
        }
        if (!(entity instanceof Player)) {
            return Unit.INSTANCE;
        }
        if (!(level instanceof ServerLevel)) {
            return Unit.INSTANCE;
        }
        int surfaceY = ((ServerLevel)level).getHeight(Heightmap.Types.WORLD_SURFACE, pos.getX(), pos.getZ());
        if (pos.getY() < surfaceY) {
            return Unit.INSTANCE;
        }
        PlayerModifiedChunksData data = LevelExt.INSTANCE.getPlayerChunks((LevelAccessor)level);
        long chunkLong = new ChunkPos(pos).toLong();
        data.getChunks().computeIfPresent(chunkLong, (arg_0, arg_1) -> ChunkTrackerHandler.lambda$1$1(ChunkTrackerHandler::lambda$1$0, arg_0, arg_1));
        data.setDirty();
        return Unit.INSTANCE;
    }

    private static final Long lambda$1$0(Long l, Long count) {
        Intrinsics.checkNotNullParameter((Object)l, (String)"<unused var>");
        Intrinsics.checkNotNullParameter((Object)count, (String)"count");
        Long l2 = count - 1L;
        long it = ((Number)l2).longValue();
        boolean bl = false;
        return it > 0L ? l2 : null;
    }

    private static final Long lambda$1$1(Function2 $tmp0, Object p0, Object p1) {
        return (Long)$tmp0.invoke(p0, p1);
    }

    static {
        EntityPlaceSubscriber.INSTANCE.add((Function5<? super BlockPos, ? super LevelAccessor, ? super Entity, ? super BlockState, ? super CancelProxy, Unit>)((Function5)ChunkTrackerHandler::_init_$lambda$0));
        BlockBreakSubscriber.INSTANCE.add((Function4<? super Level, ? super BlockPos, ? super BlockState, ? super Entity, Unit>)((Function4)ChunkTrackerHandler::_init_$lambda$1));
    }
}

