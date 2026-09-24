/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function4
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.core.BlockPos
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.block.state.BlockState
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.handlers.subs;

import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J.\u0010\f\u001a\u00020\r2&\u0010\u000e\u001a\"\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0004\u0012\u00020\u000b0\u0006J(\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\t2\b\u0010\u0013\u001a\u0004\u0018\u00010\nR4\u0010\u0004\u001a(\u0012$\u0012\"\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0004\u0012\u00020\u000b0\u00060\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2={"Lnet/thebrokenscript/handlers/subs/BlockBreakSubscriber;", "", "<init>", "()V", "listeners", "", "Lkotlin/Function4;", "Lnet/minecraft/world/level/Level;", "Lnet/minecraft/core/BlockPos;", "Lnet/minecraft/world/level/block/state/BlockState;", "Lnet/minecraft/world/entity/Entity;", "", "add", "", "listener", "call", "level", "pos", "state", "entity", "thebrokenscript-common"})
@SourceDebugExtension(value={"SMAP\nBlockBreakSubscriber.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BlockBreakSubscriber.kt\nnet/thebrokenscript/handlers/subs/BlockBreakSubscriber\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,13:1\n1869#2,2:14\n*S KotlinDebug\n*F\n+ 1 BlockBreakSubscriber.kt\nnet/thebrokenscript/handlers/subs/BlockBreakSubscriber\n*L\n12#1:14,2\n*E\n"})
public final class BlockBreakSubscriber {
    @NotNull
    public static final BlockBreakSubscriber INSTANCE = new BlockBreakSubscriber();
    @NotNull
    private static final Set<Function4<Level, BlockPos, BlockState, Entity, Unit>> listeners = new LinkedHashSet();

    private BlockBreakSubscriber() {
    }

    public final boolean add(@NotNull Function4<? super Level, ? super BlockPos, ? super BlockState, ? super Entity, Unit> listener) {
        Intrinsics.checkNotNullParameter(listener, (String)"listener");
        return listeners.add(listener);
    }

    public final void call(@NotNull Level level, @NotNull BlockPos pos, @NotNull BlockState state, @Nullable Entity entity) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        Intrinsics.checkNotNullParameter((Object)state, (String)"state");
        Iterable $this$forEach$iv = listeners;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            Function4 it = (Function4)element$iv;
            boolean bl = false;
            it.invoke((Object)level, (Object)pos, (Object)state, (Object)entity);
        }
    }
}

