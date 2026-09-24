/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.HolderGetter
 *  net.minecraft.core.HolderLookup$Provider
 *  net.minecraft.core.registries.Registries
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.nbt.NbtUtils
 *  net.minecraft.nbt.Tag
 *  net.minecraft.world.level.block.entity.BlockEntity
 *  net.minecraft.world.level.block.entity.BlockEntityType
 *  net.minecraft.world.level.block.state.BlockState
 *  net.thebrokenscript.brokencore.api.dsl.BlockUtil
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.block.entity;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtUtils;
import net.minecraft.nbt.Tag;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.thebrokenscript.brokencore.api.dsl.BlockUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B%\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00000\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\fJ\b\u0010\u0011\u001a\u0004\u0018\u00010\u0007J\b\u0010\u0012\u001a\u0004\u0018\u00010\fJ\u0018\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u0015H\u0014J\u0018\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u0015H\u0014R\u0010\u0010\n\u001a\u0004\u0018\u00010\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2={"Lnet/thebrokenscript/block/entity/ShadowBugBlockEntity;", "Lnet/minecraft/world/level/block/entity/BlockEntity;", "type", "Lnet/minecraft/world/level/block/entity/BlockEntityType;", "position", "Lnet/minecraft/core/BlockPos;", "state", "Lnet/minecraft/world/level/block/state/BlockState;", "<init>", "(Lnet/minecraft/world/level/block/entity/BlockEntityType;Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/level/block/state/BlockState;)V", "previousState", "previousEntityTag", "Lnet/minecraft/nbt/CompoundTag;", "setPrevious", "", "setPreviousTag", "tag", "getPreviousState", "getPreviousEntityTag", "loadAdditional", "registries", "Lnet/minecraft/core/HolderLookup$Provider;", "saveAdditional", "thebrokenscript-common"})
public final class ShadowBugBlockEntity
extends BlockEntity {
    @Nullable
    private BlockState previousState;
    @Nullable
    private CompoundTag previousEntityTag;

    public ShadowBugBlockEntity(@NotNull BlockEntityType<ShadowBugBlockEntity> type, @NotNull BlockPos position, @NotNull BlockState state) {
        Intrinsics.checkNotNullParameter(type, (String)"type");
        Intrinsics.checkNotNullParameter((Object)position, (String)"position");
        Intrinsics.checkNotNullParameter((Object)state, (String)"state");
        super(type, position, state);
    }

    public final void setPrevious(@NotNull BlockState state) {
        Intrinsics.checkNotNullParameter((Object)state, (String)"state");
        this.previousState = state;
        BlockUtil.setDirty((BlockEntity)this);
    }

    public final void setPreviousTag(@NotNull CompoundTag tag) {
        Intrinsics.checkNotNullParameter((Object)tag, (String)"tag");
        this.previousEntityTag = tag;
        BlockUtil.setDirty((BlockEntity)this);
    }

    @Nullable
    public final BlockState getPreviousState() {
        return this.previousState;
    }

    @Nullable
    public final CompoundTag getPreviousEntityTag() {
        return this.previousEntityTag;
    }

    protected void loadAdditional(@NotNull CompoundTag tag, @NotNull HolderLookup.Provider registries) {
        Intrinsics.checkNotNullParameter((Object)tag, (String)"tag");
        Intrinsics.checkNotNullParameter((Object)registries, (String)"registries");
        super.loadAdditional(tag, registries);
        if (tag.contains("previousState")) {
            this.previousState = NbtUtils.readBlockState((HolderGetter)((HolderGetter)registries.lookupOrThrow(Registries.BLOCK)), (CompoundTag)tag.getCompound("previousState"));
        }
        if (tag.contains("previousEntityTag")) {
            this.previousEntityTag = tag.getCompound("previousEntityTag");
        }
    }

    protected void saveAdditional(@NotNull CompoundTag tag, @NotNull HolderLookup.Provider registries) {
        Intrinsics.checkNotNullParameter((Object)tag, (String)"tag");
        Intrinsics.checkNotNullParameter((Object)registries, (String)"registries");
        super.saveAdditional(tag, registries);
        if (this.previousState != null) {
            BlockState blockState = this.previousState;
            Intrinsics.checkNotNull((Object)blockState);
            tag.put("previousState", (Tag)NbtUtils.writeBlockState((BlockState)blockState));
        }
        if (this.previousEntityTag != null) {
            CompoundTag compoundTag = this.previousEntityTag;
            Intrinsics.checkNotNull((Object)compoundTag);
            tag.put("previousEntityTag", (Tag)compoundTag);
        }
    }
}

