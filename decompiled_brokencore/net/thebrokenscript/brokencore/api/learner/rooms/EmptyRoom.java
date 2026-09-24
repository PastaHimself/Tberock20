/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.world.phys.shapes.VoxelShape
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.brokencore.api.learner.rooms;

import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.thebrokenscript.brokencore.api.learner.room_poi.RoomPoi;
import net.thebrokenscript.brokencore.api.learner.rooms.AbstractRoom;
import net.thebrokenscript.brokencore.api.learner.rooms.RoomType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005B\u0011\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0004\b\u0004\u0010\bR\u0014\u0010\t\u001a\u00020\nX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\r"}, d2={"Lnet/thebrokenscript/brokencore/api/learner/rooms/EmptyRoom;", "Lnet/thebrokenscript/brokencore/api/learner/rooms/AbstractRoom;", "shape", "Lnet/minecraft/world/phys/shapes/VoxelShape;", "<init>", "(Lnet/minecraft/world/phys/shapes/VoxelShape;)V", "tag", "Lnet/minecraft/nbt/CompoundTag;", "(Lnet/minecraft/nbt/CompoundTag;)V", "type", "Lnet/thebrokenscript/brokencore/api/learner/rooms/RoomType;", "getType", "()Lnet/thebrokenscript/brokencore/api/learner/rooms/RoomType;", "brokencore-common"})
public final class EmptyRoom
extends AbstractRoom {
    @NotNull
    private final RoomType type;

    public EmptyRoom(@Nullable VoxelShape shape) {
        super(shape, new HashMap<String, List<RoomPoi>>());
        this.type = RoomType.EMPTY;
    }

    @Override
    @NotNull
    public RoomType getType() {
        return this.type;
    }

    public EmptyRoom(@NotNull CompoundTag tag) {
        Intrinsics.checkNotNullParameter((Object)tag, (String)"tag");
        this(AbstractRoom.Companion.getShape$brokencore_common(tag));
    }
}

