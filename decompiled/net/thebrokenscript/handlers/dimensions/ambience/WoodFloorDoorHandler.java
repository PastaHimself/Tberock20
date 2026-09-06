/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Position
 *  net.minecraft.core.Vec3i
 *  net.minecraft.server.level.ServerPlayer
 *  net.minecraft.sounds.SoundEvents
 *  net.minecraft.sounds.SoundSource
 *  net.minecraft.tags.BlockTags
 *  net.minecraft.util.RandomSource
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.block.Block
 *  net.minecraft.world.level.block.DoorBlock
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.block.state.properties.Property
 *  net.minecraft.world.level.levelgen.structure.BoundingBox
 *  net.thebrokenscript.brokencore.api.ext.BoundingBoxExt
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.handlers.dimensions.ambience;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Position;
import net.minecraft.core.Vec3i;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.thebrokenscript.brokencore.api.ext.BoundingBoxExt;
import net.thebrokenscript.handlers.subs.PlayerTickSubscriber;
import net.thebrokenscript.misc.ForceRuntimeInit;
import net.thebrokenscript.registry.TBSDimensions;
import org.jetbrains.annotations.NotNull;

@ForceRuntimeInit
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0002\u00a8\u0006\b"}, d2={"Lnet/thebrokenscript/handlers/dimensions/ambience/WoodFloorDoorHandler;", "", "<init>", "()V", "ambience", "", "player", "Lnet/minecraft/world/entity/player/Player;", "thebrokenscript-common"})
public final class WoodFloorDoorHandler {
    @NotNull
    public static final WoodFloorDoorHandler INSTANCE = new WoodFloorDoorHandler();

    private WoodFloorDoorHandler() {
    }

    private final void ambience(Player player) {
        block6: {
            if (!(player instanceof ServerPlayer)) {
                return;
            }
            RandomSource random = ((ServerPlayer)player).getRandom();
            if (!Intrinsics.areEqual((Object)player.level().dimension(), TBSDimensions.CLAN_VOID)) {
                return;
            }
            Level level = player.level();
            if (level.getGameTime() % (long)random.nextInt(200, 501) != 0L) break block6;
            double d = ((ServerPlayer)player).getY();
            boolean bl = 216.0 <= d ? d <= 230.0 : false;
            if (bl && (double)random.nextFloat() < 0.3) {
                BlockPos origin = BlockPos.containing((Position)((Position)player.position()));
                int range = 12;
                BlockPos closestDoor = null;
                double closestDistSq = Double.MAX_VALUE;
                BoundingBox boundingBox = new BoundingBox(origin).inflatedBy(range);
                Intrinsics.checkNotNullExpressionValue((Object)boundingBox, (String)"inflatedBy(...)");
                for (BlockPos checkPos : BoundingBoxExt.INSTANCE.getPositions(boundingBox)) {
                    BlockState state = level.getBlockState(checkPos);
                    if (!state.is(BlockTags.WOODEN_DOORS)) continue;
                    double distSq = checkPos.distSqr((Vec3i)origin);
                    if (!((double)random.nextFloat() < 0.1) || !(distSq < closestDistSq)) continue;
                    closestDistSq = distSq;
                    closestDoor = checkPos;
                }
                BlockPos blockPos = closestDoor;
                if (blockPos != null) {
                    BlockPos dp = blockPos;
                    boolean bl2 = false;
                    BlockState state = level.getBlockState(dp);
                    Block block = state.getBlock();
                    DoorBlock doorBlock = block instanceof DoorBlock ? (DoorBlock)block : null;
                    if (doorBlock == null) {
                        return;
                    }
                    DoorBlock door = doorBlock;
                    Boolean isOpen = (Boolean)state.getValue((Property)DoorBlock.OPEN);
                    door.setOpen((Entity)player, level, state, dp, isOpen == false);
                    level.playSound(null, dp, isOpen != false ? SoundEvents.WOODEN_DOOR_CLOSE : SoundEvents.WOODEN_DOOR_OPEN, SoundSource.BLOCKS, 1.0f, 1.0f);
                }
            }
        }
    }

    static {
        PlayerTickSubscriber.INSTANCE.add((Function1<? super Player, Unit>)((Function1)new Function1<Player, Unit>((Object)INSTANCE){

            public final void invoke(Player p0) {
                Intrinsics.checkNotNullParameter((Object)p0, (String)"p0");
                ((WoodFloorDoorHandler)this.receiver).ambience(p0);
            }
        }));
    }
}

