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

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001BA\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012.\u0010\u0004\u001a*\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0005j\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007`\t\u00a2\u0006\u0004\b\n\u0010\u000bB\u0011\b\u0016\u0012\u0006\u0010\f\u001a\u00020\r\u00a2\u0006\u0004\b\n\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u0010X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0013"}, d2={"Lnet/thebrokenscript/brokencore/api/learner/rooms/GenericRoom;", "Lnet/thebrokenscript/brokencore/api/learner/rooms/AbstractRoom;", "shape", "Lnet/minecraft/world/phys/shapes/VoxelShape;", "pois", "Ljava/util/HashMap;", "", "", "Lnet/thebrokenscript/brokencore/api/learner/room_poi/RoomPoi;", "Lkotlin/collections/HashMap;", "<init>", "(Lnet/minecraft/world/phys/shapes/VoxelShape;Ljava/util/HashMap;)V", "tag", "Lnet/minecraft/nbt/CompoundTag;", "(Lnet/minecraft/nbt/CompoundTag;)V", "type", "Lnet/thebrokenscript/brokencore/api/learner/rooms/RoomType;", "getType", "()Lnet/thebrokenscript/brokencore/api/learner/rooms/RoomType;", "brokencore-common"})
public final class GenericRoom
extends AbstractRoom {
    @NotNull
    private final RoomType type;

    public GenericRoom(@Nullable VoxelShape shape, @NotNull HashMap<String, List<RoomPoi>> pois) {
        Intrinsics.checkNotNullParameter(pois, (String)"pois");
        super(shape, pois);
        this.type = RoomType.GENERIC;
    }

    @Override
    @NotNull
    public RoomType getType() {
        return this.type;
    }

    public GenericRoom(@NotNull CompoundTag tag) {
        Intrinsics.checkNotNullParameter((Object)tag, (String)"tag");
        this(AbstractRoom.Companion.getShape$brokencore_common(tag), AbstractRoom.Companion.getPois$brokencore_common(tag));
    }
}

