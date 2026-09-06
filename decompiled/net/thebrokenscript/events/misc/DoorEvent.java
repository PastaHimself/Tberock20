/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.random.Random
 *  net.minecraft.core.BlockPos
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.server.level.ServerPlayer
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.block.Block
 *  net.minecraft.world.level.block.DoorBlock
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.phys.Vec3
 *  net.thebrokenscript.brokencore.api.event.RandomEvent
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.events.misc;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.random.Random;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.api.ext.PlayerExt;
import net.thebrokenscript.brokencore.api.event.RandomEvent;
import net.thebrokenscript.data.PlayerVariables;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0014\u00a8\u0006\f"}, d2={"Lnet/thebrokenscript/events/misc/DoorEvent;", "Lnet/thebrokenscript/brokencore/api/event/RandomEvent;", "<init>", "()V", "execute", "", "level", "Lnet/minecraft/server/level/ServerLevel;", "player", "Lnet/minecraft/server/level/ServerPlayer;", "pos", "Lnet/minecraft/world/phys/Vec3;", "thebrokenscript-common"})
@SourceDebugExtension(value={"SMAP\nDoorEvent.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DoorEvent.kt\nnet/thebrokenscript/events/misc/DoorEvent\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,27:1\n774#2:28\n865#2,2:29\n774#2:31\n865#2,2:32\n*S KotlinDebug\n*F\n+ 1 DoorEvent.kt\nnet/thebrokenscript/events/misc/DoorEvent\n*L\n13#1:28\n13#1:29,2\n21#1:31\n21#1:32,2\n*E\n"})
public final class DoorEvent
extends RandomEvent {
    public DoorEvent() {
        super((Number)1);
    }

    /*
     * WARNING - void declaration
     */
    protected void execute(@NotNull ServerLevel level, @NotNull ServerPlayer player, @NotNull Vec3 pos) {
        void $this$filterTo$iv$iv;
        void $this$filterTo$iv$iv2;
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)player, (String)"player");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        Iterable $this$filter$iv = PlayerExt.INSTANCE.getVars((Player)player).getDoors().getEntries();
        boolean $i$f$filter = false;
        Iterable iterable = $this$filter$iv;
        Collection destination$iv$iv = new ArrayList();
        boolean $i$f$filterTo22 = false;
        for (Object element$iv$iv : $this$filterTo$iv$iv2) {
            BlockPos it = (BlockPos)element$iv$iv;
            boolean bl = false;
            if (!(!level.isLoaded(it) || level.getBlockState(it).getBlock() instanceof DoorBlock)) continue;
            destination$iv$iv.add(element$iv$iv);
        }
        Set doors = CollectionsKt.toMutableSet((Iterable)((List)destination$iv$iv));
        PlayerExt.INSTANCE.updateVars((Player)player, (Function1<? super PlayerVariables, Unit>)((Function1)arg_0 -> DoorEvent.execute$lambda$1(doors, arg_0)));
        Iterable $this$filter$iv2 = doors;
        boolean $i$f$filter2 = false;
        Iterable $i$f$filterTo22 = $this$filter$iv2;
        Collection destination$iv$iv2 = new ArrayList();
        boolean $i$f$filterTo = false;
        for (Object element$iv$iv : $this$filterTo$iv$iv) {
            BlockPos it = (BlockPos)element$iv$iv;
            boolean bl = false;
            if (!level.isLoaded(it)) continue;
            destination$iv$iv2.add(element$iv$iv);
        }
        BlockPos blockPos = (BlockPos)CollectionsKt.randomOrNull((Collection)((List)destination$iv$iv2), (Random)((Random)Random.Default));
        if (blockPos == null) {
            return;
        }
        BlockPos doorPos = blockPos;
        BlockState state = level.getBlockState(doorPos);
        Block block = state.getBlock();
        Intrinsics.checkNotNull((Object)block, (String)"null cannot be cast to non-null type net.minecraft.world.level.block.DoorBlock");
        DoorBlock door = (DoorBlock)block;
        door.setOpen(null, (Level)level, state, doorPos, !door.isOpen(state));
    }

    private static final Unit execute$lambda$1(Set $doors, PlayerVariables $this$updateVars) {
        Intrinsics.checkNotNullParameter((Object)$this$updateVars, (String)"$this$updateVars");
        $this$updateVars.getDoors().setEntries($doors);
        return Unit.INSTANCE;
    }
}

