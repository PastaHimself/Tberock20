/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.functions.Function5
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.core.BlockPos
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.world.InteractionHand
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.block.DoorBlock
 *  net.minecraft.world.phys.BlockHitResult
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.handlers;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.phys.BlockHitResult;
import net.thebrokenscript.api.ext.PlayerExt;
import net.thebrokenscript.data.PlayerVariables;
import net.thebrokenscript.handlers.subs.PlayerRightClickInteractSubscriber;
import net.thebrokenscript.misc.ForceRuntimeInit;
import org.jetbrains.annotations.NotNull;

@ForceRuntimeInit
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2={"Lnet/thebrokenscript/handlers/DoorTracker;", "", "<init>", "()V", "thebrokenscript-common"})
public final class DoorTracker {
    @NotNull
    public static final DoorTracker INSTANCE = new DoorTracker();

    private DoorTracker() {
    }

    private static final Unit _init_$lambda$0(Player e, Level lvl, BlockPos pos, InteractionHand h, BlockHitResult hit) {
        Intrinsics.checkNotNullParameter((Object)e, (String)"e");
        Intrinsics.checkNotNullParameter((Object)lvl, (String)"lvl");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        Intrinsics.checkNotNullParameter((Object)h, (String)"h");
        Intrinsics.checkNotNullParameter((Object)hit, (String)"hit");
        if (!(lvl instanceof ServerLevel)) {
            return Unit.INSTANCE;
        }
        if (!(((ServerLevel)lvl).getBlockState(pos).getBlock() instanceof DoorBlock)) {
            return Unit.INSTANCE;
        }
        PlayerExt.INSTANCE.updateVars(e, (Function1<? super PlayerVariables, Unit>)((Function1)arg_0 -> DoorTracker.lambda$0$0(pos, arg_0)));
        return Unit.INSTANCE;
    }

    private static final Unit lambda$0$0(BlockPos $pos, PlayerVariables $this$updateVars) {
        Intrinsics.checkNotNullParameter((Object)$this$updateVars, (String)"$this$updateVars");
        $this$updateVars.getDoors().getEntries().add($pos);
        return Unit.INSTANCE;
    }

    static {
        PlayerRightClickInteractSubscriber.INSTANCE.add((Function5<? super Player, ? super Level, ? super BlockPos, ? super InteractionHand, ? super BlockHitResult, Unit>)((Function5)DoorTracker::_init_$lambda$0));
    }
}

