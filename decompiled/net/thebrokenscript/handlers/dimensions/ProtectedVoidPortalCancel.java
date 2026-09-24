/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function3
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Direction
 *  net.minecraft.server.level.ServerPlayer
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.block.Block
 *  net.minecraft.world.level.block.state.BlockState
 *  net.thebrokenscript.brokencore.api.platform.CancelProxy
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.handlers.dimensions;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.thebrokenscript.block.VoidDoorBlock;
import net.thebrokenscript.brokencore.api.platform.CancelProxy;
import net.thebrokenscript.handlers.subs.PlayerTeleportationSubscriber;
import net.thebrokenscript.misc.ForceRuntimeInit;
import net.thebrokenscript.registry.TBSDimensions;
import org.jetbrains.annotations.NotNull;

@ForceRuntimeInit
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b\u00a8\u0006\f"}, d2={"Lnet/thebrokenscript/handlers/dimensions/ProtectedVoidPortalCancel;", "", "<init>", "()V", "cancel", "", "player", "Lnet/minecraft/world/entity/player/Player;", "face", "Lnet/minecraft/core/Direction;", "cancelProxy", "Lnet/thebrokenscript/brokencore/api/platform/CancelProxy;", "thebrokenscript-common"})
public final class ProtectedVoidPortalCancel {
    @NotNull
    public static final ProtectedVoidPortalCancel INSTANCE = new ProtectedVoidPortalCancel();

    private ProtectedVoidPortalCancel() {
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public final void cancel(@NotNull Player player, @NotNull Direction face, @NotNull CancelProxy cancelProxy) {
        Intrinsics.checkNotNullParameter((Object)player, (String)"player");
        Intrinsics.checkNotNullParameter((Object)face, (String)"face");
        Intrinsics.checkNotNullParameter((Object)cancelProxy, (String)"cancelProxy");
        if (!(player instanceof ServerPlayer)) return;
        if (!Intrinsics.areEqual((Object)player.level().dimension(), TBSDimensions.PROTECTED_VOID)) {
            return;
        }
        BlockPos chunk = player.chunkPosition().getWorldPosition();
        BlockPos playerPos = player.blockPosition();
        int minX = chunk.getX() + 10;
        int maxX = chunk.getX() + 12;
        int minY = 79;
        int maxY = 107;
        int minZ = chunk.getZ() + 1;
        int maxZ = chunk.getZ() + 3;
        int n = playerPos.getX();
        if (minX > n) return;
        if (n > maxX) return;
        boolean bl = true;
        if (!bl) return;
        n = playerPos.getY();
        if (minY > n) return;
        if (n > maxY) return;
        boolean bl2 = true;
        if (!bl2) return;
        n = playerPos.getZ();
        if (minZ > n) return;
        if (n > maxZ) return;
        boolean bl3 = true;
        if (!bl3) return;
        boolean bl4 = true;
        boolean isInRestrictedArea = bl4;
        if (!isInRestrictedArea) return;
        if (((ServerPlayer)player).getY() > 102.0 && face != Direction.NORTH) {
            cancelProxy.setCanceled(true);
            return;
        }
        if (((ServerPlayer)player).getY() > 102.0) {
            BlockPos pos = player.chunkPosition().getWorldPosition().offset(11, 79, 3);
            BlockState block = ((ServerPlayer)player).serverLevel().getBlockState(pos);
            if (block.getBlock() instanceof VoidDoorBlock) {
                Block block2 = block.getBlock();
                Intrinsics.checkNotNull((Object)block2, (String)"null cannot be cast to non-null type net.thebrokenscript.block.VoidDoorBlock");
                ((VoidDoorBlock)block2).setOpen(null, (Level)((ServerPlayer)player).serverLevel(), block, pos, true);
            }
        }
        if (!((double)((ServerPlayer)player).getYRot() <= 160.0)) return;
        if (!((double)((ServerPlayer)player).getYRot() >= -160.0)) return;
        cancelProxy.setCanceled(true);
    }

    static {
        PlayerTeleportationSubscriber.INSTANCE.add((Function3<? super Player, ? super Direction, ? super CancelProxy, Unit>)((Function3)new Function3<Player, Direction, CancelProxy, Unit>((Object)INSTANCE){

            public final void invoke(Player p0, Direction p1, CancelProxy p2) {
                Intrinsics.checkNotNullParameter((Object)p0, (String)"p0");
                Intrinsics.checkNotNullParameter((Object)p1, (String)"p1");
                Intrinsics.checkNotNullParameter((Object)p2, (String)"p2");
                ((ProtectedVoidPortalCancel)this.receiver).cancel(p0, p1, p2);
            }
        }));
    }
}

