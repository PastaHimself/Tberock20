/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.JvmName
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.core.BlockPos
 *  net.minecraft.world.level.BlockGetter
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.block.state.BlockState
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.dsl;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.thebrokenscript.brokencore.api.ext.MinecraftServerExtKt;
import net.thebrokenscript.brokencore.api.queue.WorkQueue;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=2, xi=48, d1={"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0015\u0010\u0005\u001a\u00020\u0006*\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0086\u0002\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\u00a8\u0006\n"}, d2={"queue", "Lnet/thebrokenscript/brokencore/api/queue/WorkQueue;", "Lnet/minecraft/world/level/Level;", "getQueue", "(Lnet/minecraft/world/level/Level;)Lnet/thebrokenscript/brokencore/api/queue/WorkQueue;", "get", "Lnet/minecraft/world/level/block/state/BlockState;", "Lnet/minecraft/world/level/BlockGetter;", "pos", "Lnet/minecraft/core/BlockPos;", "brokencore-common"})
@JvmName(name="LevelUtil")
public final class LevelUtil {
    @NotNull
    public static final WorkQueue getQueue(@NotNull Level $this$queue) {
        Intrinsics.checkNotNullParameter((Object)$this$queue, (String)"<this>");
        Object object = $this$queue.getServer();
        if (object == null || (object = MinecraftServerExtKt.getQueue(object)) == null) {
            throw new IllegalStateException("Cannot access queue from a non-server level".toString());
        }
        return object;
    }

    @NotNull
    public static final BlockState get(@NotNull BlockGetter $this$get, @NotNull BlockPos pos) {
        Intrinsics.checkNotNullParameter((Object)$this$get, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        BlockState blockState = $this$get.getBlockState(pos);
        Intrinsics.checkNotNullExpressionValue((Object)blockState, (String)"getBlockState(...)");
        return blockState;
    }
}

