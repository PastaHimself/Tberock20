/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Position
 *  net.minecraft.core.Vec3i
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.server.level.ServerPlayer
 *  net.minecraft.sounds.SoundEvents
 *  net.minecraft.sounds.SoundSource
 *  net.minecraft.tags.BlockTags
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.block.Block
 *  net.minecraft.world.level.block.DoorBlock
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.block.state.properties.Property
 *  net.minecraft.world.level.levelgen.structure.BoundingBox
 *  net.minecraft.world.phys.Vec3
 *  net.thebrokenscript.brokencore.api.ext.BoundingBoxExt
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.events.sounds;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Position;
import net.minecraft.core.Vec3i;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.api.event.TBSEvent;
import net.thebrokenscript.brokencore.api.ext.BoundingBoxExt;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0014\u00a8\u0006\f"}, d2={"Lnet/thebrokenscript/events/sounds/DoorsEvent;", "Lnet/thebrokenscript/api/event/TBSEvent;", "<init>", "()V", "execute", "", "level", "Lnet/minecraft/server/level/ServerLevel;", "player", "Lnet/minecraft/server/level/ServerPlayer;", "pos", "Lnet/minecraft/world/phys/Vec3;", "thebrokenscript-common"})
public final class DoorsEvent
extends TBSEvent {
    public DoorsEvent() {
        super(1);
    }

    protected void execute(@NotNull ServerLevel level, @NotNull ServerPlayer player, @NotNull Vec3 pos) {
        block2: {
            Intrinsics.checkNotNullParameter((Object)level, (String)"level");
            Intrinsics.checkNotNullParameter((Object)player, (String)"player");
            Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
            BlockPos origin = BlockPos.containing((Position)((Position)pos));
            int range = 12;
            BlockPos closestDoor = null;
            double closestDistSq = Double.MAX_VALUE;
            BoundingBox boundingBox = new BoundingBox(origin).inflatedBy(range);
            Intrinsics.checkNotNullExpressionValue((Object)boundingBox, (String)"inflatedBy(...)");
            for (BlockPos checkPos : BoundingBoxExt.INSTANCE.getPositions(boundingBox)) {
                double distSq;
                BlockState state = level.getBlockState(checkPos);
                if (!state.is(BlockTags.WOODEN_DOORS) || !((distSq = checkPos.distSqr((Vec3i)origin)) < closestDistSq)) continue;
                closestDistSq = distSq;
                closestDoor = checkPos;
            }
            BlockPos blockPos = closestDoor;
            if (blockPos == null) break block2;
            BlockPos dp = blockPos;
            boolean bl = false;
            BlockState state = level.getBlockState(dp);
            Block block = state.getBlock();
            DoorBlock doorBlock = block instanceof DoorBlock ? (DoorBlock)block : null;
            if (doorBlock == null) {
                return;
            }
            DoorBlock door = doorBlock;
            Boolean isOpen = (Boolean)state.getValue((Property)DoorBlock.OPEN);
            door.setOpen((Entity)player, (Level)level, state, dp, isOpen == false);
            level.playSound(null, dp, isOpen != false ? SoundEvents.WOODEN_DOOR_CLOSE : SoundEvents.WOODEN_DOOR_OPEN, SoundSource.BLOCKS, 1.0f, 1.0f);
        }
    }
}

