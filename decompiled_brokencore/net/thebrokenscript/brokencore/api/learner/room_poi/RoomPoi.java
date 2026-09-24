/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.core.BlockPos
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.nbt.NbtUtils
 *  net.minecraft.world.phys.shapes.VoxelShape
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.learner.room_poi;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtUtils;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.thebrokenscript.brokencore.api.ext.MiscExt;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u0010\u001a\u00020\u0011R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0012"}, d2={"Lnet/thebrokenscript/brokencore/api/learner/room_poi/RoomPoi;", "", "shape", "Lnet/minecraft/world/phys/shapes/VoxelShape;", "pos", "Lnet/minecraft/core/BlockPos;", "subtype", "", "<init>", "(Lnet/minecraft/world/phys/shapes/VoxelShape;Lnet/minecraft/core/BlockPos;Ljava/lang/String;)V", "getShape", "()Lnet/minecraft/world/phys/shapes/VoxelShape;", "getPos", "()Lnet/minecraft/core/BlockPos;", "getSubtype", "()Ljava/lang/String;", "toNbt", "Lnet/minecraft/nbt/CompoundTag;", "brokencore-common"})
public final class RoomPoi {
    @NotNull
    private final VoxelShape shape;
    @NotNull
    private final BlockPos pos;
    @NotNull
    private final String subtype;

    public RoomPoi(@NotNull VoxelShape shape, @NotNull BlockPos pos, @NotNull String subtype) {
        Intrinsics.checkNotNullParameter((Object)shape, (String)"shape");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        Intrinsics.checkNotNullParameter((Object)subtype, (String)"subtype");
        this.shape = shape;
        this.pos = pos;
        this.subtype = subtype;
    }

    @NotNull
    public final VoxelShape getShape() {
        return this.shape;
    }

    @NotNull
    public final BlockPos getPos() {
        return this.pos;
    }

    @NotNull
    public final String getSubtype() {
        return this.subtype;
    }

    @NotNull
    public final CompoundTag toNbt() {
        CompoundTag tag = new CompoundTag();
        MiscExt.putVoxelShape(tag, "shape", this.shape);
        tag.put("pos", NbtUtils.writeBlockPos((BlockPos)this.pos));
        tag.putString("subtype", this.subtype);
        return tag;
    }
}

