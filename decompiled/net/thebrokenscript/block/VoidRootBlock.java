/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.collections.IntIterator
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.random.Random
 *  kotlin.ranges.IntRange
 *  kotlin.ranges.RangesKt
 *  net.minecraft.core.BlockPos
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.util.RandomSource
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.block.Block
 *  net.minecraft.world.level.block.Blocks
 *  net.minecraft.world.level.block.state.BlockBehaviour$Properties
 *  net.minecraft.world.level.block.state.BlockState
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.block;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.random.Random;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.thebrokenscript.boss.integrity.Arena;
import net.thebrokenscript.registry.TBSTags;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J(\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0014J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\b\u001a\u00020\tH\u0014J0\u0010\u0012\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u0011H\u0014\u00a8\u0006\u0016"}, d2={"Lnet/thebrokenscript/block/VoidRootBlock;", "Lnet/minecraft/world/level/block/Block;", "properties", "Lnet/minecraft/world/level/block/state/BlockBehaviour$Properties;", "<init>", "(Lnet/minecraft/world/level/block/state/BlockBehaviour$Properties;)V", "randomTick", "", "state", "Lnet/minecraft/world/level/block/state/BlockState;", "level", "Lnet/minecraft/server/level/ServerLevel;", "pos", "Lnet/minecraft/core/BlockPos;", "random", "Lnet/minecraft/util/RandomSource;", "isRandomlyTicking", "", "onPlace", "Lnet/minecraft/world/level/Level;", "oldState", "movedByPiston", "thebrokenscript-common"})
@SourceDebugExtension(value={"SMAP\nVoidRootBlock.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VoidRootBlock.kt\nnet/thebrokenscript/block/VoidRootBlock\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,58:1\n1740#2,3:59\n*S KotlinDebug\n*F\n+ 1 VoidRootBlock.kt\nnet/thebrokenscript/block/VoidRootBlock\n*L\n48#1:59,3\n*E\n"})
public final class VoidRootBlock
extends Block {
    public VoidRootBlock(@NotNull BlockBehaviour.Properties properties) {
        Intrinsics.checkNotNullParameter((Object)properties, (String)"properties");
        super(properties);
    }

    protected void randomTick(@NotNull BlockState state, @NotNull ServerLevel level, @NotNull BlockPos pos, @NotNull RandomSource random) {
        Intrinsics.checkNotNullParameter((Object)state, (String)"state");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        Intrinsics.checkNotNullParameter((Object)random, (String)"random");
        super.randomTick(state, level, pos, random);
        if (Arena.Companion.getInstance() == null) {
            return;
        }
        BlockPos[] blockPosArray = new BlockPos[]{pos.below(), pos.above(), pos.east(), pos.west(), pos.north(), pos.south()};
        List directions = CollectionsKt.shuffled((Iterable)CollectionsKt.listOf((Object[])blockPosArray));
        for (BlockPos direction : directions) {
            if (!level.getBlockState(direction).is(TBSTags.ROOT_REPLACEABLE)) continue;
            level.setBlock(direction, this.defaultBlockState(), 3);
            return;
        }
    }

    protected boolean isRandomlyTicking(@NotNull BlockState state) {
        Intrinsics.checkNotNullParameter((Object)state, (String)"state");
        return true;
    }

    protected void onPlace(@NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos, @NotNull BlockState oldState, boolean movedByPiston) {
        Intrinsics.checkNotNullParameter((Object)state, (String)"state");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        Intrinsics.checkNotNullParameter((Object)oldState, (String)"oldState");
        super.onPlace(state, level, pos, oldState, movedByPiston);
        if (Arena.Companion.getInstance() != null && RangesKt.random((IntRange)new IntRange(1, 30), (Random)((Random)Random.Default)) == 30) {
            int loopy;
            boolean bl;
            int length;
            block6: {
                length = RangesKt.random((IntRange)new IntRange(4, 6), (Random)((Random)Random.Default));
                Iterable $this$all$iv = (Iterable)new IntRange(1, length);
                boolean $i$f$all = false;
                if ($this$all$iv instanceof Collection && ((Collection)$this$all$iv).isEmpty()) {
                    bl = true;
                } else {
                    Iterator iterator = $this$all$iv.iterator();
                    while (iterator.hasNext()) {
                        int element$iv;
                        int it = element$iv = ((IntIterator)iterator).nextInt();
                        boolean bl2 = false;
                        if (level.getBlockState(pos.above(it)).is(Blocks.AIR)) continue;
                        bl = false;
                        break block6;
                    }
                    bl = true;
                }
            }
            if (bl && (loopy = 1) <= length) {
                while (true) {
                    level.setBlock(pos.above(loopy), this.defaultBlockState(), 3);
                    if (loopy == length) break;
                    ++loopy;
                }
            }
        }
    }
}

