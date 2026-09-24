/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function5
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.core.BlockPos
 *  net.minecraft.world.InteractionHand
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.phys.BlockHitResult
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.handlers.subs;

import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J}\u0010\u0014\u001a\u00020\u00152u\u0010\u0016\u001aq\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\r\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u000f\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0011\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u00130\u0006J.\u0010\u0017\u001a\u00020\u00132\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011R\u0083\u0001\u0010\u0004\u001aw\u0012s\u0012q\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\r\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u000f\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0011\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u00130\u00060\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2={"Lnet/thebrokenscript/handlers/subs/PlayerRightClickInteractSubscriber;", "", "<init>", "()V", "listeners", "", "Lkotlin/Function5;", "Lnet/minecraft/world/entity/player/Player;", "Lkotlin/ParameterName;", "name", "ent", "Lnet/minecraft/world/level/Level;", "level", "Lnet/minecraft/core/BlockPos;", "pos", "Lnet/minecraft/world/InteractionHand;", "hand", "Lnet/minecraft/world/phys/BlockHitResult;", "hitVec", "", "add", "", "listener", "call", "thebrokenscript-common"})
@SourceDebugExtension(value={"SMAP\nPlayerRightClickInteractSubscriber.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PlayerRightClickInteractSubscriber.kt\nnet/thebrokenscript/handlers/subs/PlayerRightClickInteractSubscriber\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,18:1\n1869#2,2:19\n*S KotlinDebug\n*F\n+ 1 PlayerRightClickInteractSubscriber.kt\nnet/thebrokenscript/handlers/subs/PlayerRightClickInteractSubscriber\n*L\n17#1:19,2\n*E\n"})
public final class PlayerRightClickInteractSubscriber {
    @NotNull
    public static final PlayerRightClickInteractSubscriber INSTANCE = new PlayerRightClickInteractSubscriber();
    @NotNull
    private static final Set<Function5<Player, Level, BlockPos, InteractionHand, BlockHitResult, Unit>> listeners = new LinkedHashSet();

    private PlayerRightClickInteractSubscriber() {
    }

    public final boolean add(@NotNull Function5<? super Player, ? super Level, ? super BlockPos, ? super InteractionHand, ? super BlockHitResult, Unit> listener) {
        Intrinsics.checkNotNullParameter(listener, (String)"listener");
        return listeners.add(listener);
    }

    public final void call(@NotNull Player ent, @NotNull Level level, @NotNull BlockPos pos, @NotNull InteractionHand hand, @NotNull BlockHitResult hitVec) {
        Intrinsics.checkNotNullParameter((Object)ent, (String)"ent");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        Intrinsics.checkNotNullParameter((Object)hand, (String)"hand");
        Intrinsics.checkNotNullParameter((Object)hitVec, (String)"hitVec");
        Iterable $this$forEach$iv = listeners;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            Function5 it = (Function5)element$iv;
            boolean bl = false;
            it.invoke((Object)ent, (Object)level, (Object)pos, (Object)hand, (Object)hitVec);
        }
    }
}

