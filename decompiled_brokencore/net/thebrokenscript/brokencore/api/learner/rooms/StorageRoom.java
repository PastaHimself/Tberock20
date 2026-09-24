/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.block.entity.BaseContainerBlockEntity
 *  net.minecraft.world.level.block.entity.BlockEntity
 *  net.minecraft.world.phys.shapes.VoxelShape
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.brokencore.api.learner.rooms;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BaseContainerBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.thebrokenscript.brokencore.api.learner.room_poi.RoomPoi;
import net.thebrokenscript.brokencore.api.learner.rooms.AbstractRoom;
import net.thebrokenscript.brokencore.api.learner.rooms.RoomType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001BA\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012.\u0010\u0004\u001a*\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0005j\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007`\t\u00a2\u0006\u0004\b\n\u0010\u000bB\u0011\b\u0016\u0012\u0006\u0010\f\u001a\u00020\r\u00a2\u0006\u0004\b\n\u0010\u000eJ\"\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u00180\u001cR\u0014\u0010\u000f\u001a\u00020\u0010X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u0014\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001e"}, d2={"Lnet/thebrokenscript/brokencore/api/learner/rooms/StorageRoom;", "Lnet/thebrokenscript/brokencore/api/learner/rooms/AbstractRoom;", "shape", "Lnet/minecraft/world/phys/shapes/VoxelShape;", "pois", "Ljava/util/HashMap;", "", "", "Lnet/thebrokenscript/brokencore/api/learner/room_poi/RoomPoi;", "Lkotlin/collections/HashMap;", "<init>", "(Lnet/minecraft/world/phys/shapes/VoxelShape;Ljava/util/HashMap;)V", "tag", "Lnet/minecraft/nbt/CompoundTag;", "(Lnet/minecraft/nbt/CompoundTag;)V", "type", "Lnet/thebrokenscript/brokencore/api/learner/rooms/RoomType;", "getType", "()Lnet/thebrokenscript/brokencore/api/learner/rooms/RoomType;", "containerCount", "", "getContainerCount", "()I", "forEachContainer", "", "level", "Lnet/minecraft/world/level/Level;", "consumer", "Lkotlin/Function1;", "Lnet/minecraft/world/level/block/entity/BaseContainerBlockEntity;", "brokencore-common"})
public final class StorageRoom
extends AbstractRoom {
    @NotNull
    private final RoomType type;
    private final int containerCount;

    public StorageRoom(@Nullable VoxelShape shape, @NotNull HashMap<String, List<RoomPoi>> pois) {
        Intrinsics.checkNotNullParameter(pois, (String)"pois");
        super(shape, pois);
        this.type = RoomType.STORAGE;
        List<RoomPoi> list = pois.get("container");
        this.containerCount = list != null ? list.size() : 0;
    }

    @Override
    @NotNull
    public RoomType getType() {
        return this.type;
    }

    public final int getContainerCount() {
        return this.containerCount;
    }

    public final void forEachContainer(@NotNull Level level, @NotNull Function1<? super BaseContainerBlockEntity, Unit> consumer) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter(consumer, (String)"consumer");
        for (Map.Entry entry : ((Map)this.getPois()).entrySet()) {
            for (RoomPoi poi : (List)entry.getValue()) {
                BlockEntity ent;
                if (level.getBlockEntity(poi.getPos()) == null || !(ent instanceof BaseContainerBlockEntity)) continue;
                consumer.invoke((Object)ent);
            }
        }
    }

    public StorageRoom(@NotNull CompoundTag tag) {
        Intrinsics.checkNotNullParameter((Object)tag, (String)"tag");
        this(AbstractRoom.Companion.getShape$brokencore_common(tag), AbstractRoom.Companion.getPois$brokencore_common(tag));
    }
}

