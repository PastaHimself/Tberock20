/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.HolderLookup$Provider
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket
 *  net.minecraft.world.level.block.entity.BlockEntity
 *  net.minecraft.world.level.block.entity.BlockEntityType
 *  net.minecraft.world.level.block.state.BlockState
 *  net.thebrokenscript.brokencore.api.ext.TagExt
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.block.portal;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.thebrokenscript.brokencore.api.ext.TagExt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B#\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0014J\u0018\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0014J\u0010\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u0019"}, d2={"Lnet/thebrokenscript/block/portal/PortalExtenderBlockEntity;", "Lnet/minecraft/world/level/block/entity/BlockEntity;", "type", "Lnet/minecraft/world/level/block/entity/BlockEntityType;", "pos", "Lnet/minecraft/core/BlockPos;", "state", "Lnet/minecraft/world/level/block/state/BlockState;", "<init>", "(Lnet/minecraft/world/level/block/entity/BlockEntityType;Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/level/block/state/BlockState;)V", "parent", "getParent", "()Lnet/minecraft/core/BlockPos;", "setParent", "(Lnet/minecraft/core/BlockPos;)V", "saveAdditional", "", "tag", "Lnet/minecraft/nbt/CompoundTag;", "registries", "Lnet/minecraft/core/HolderLookup$Provider;", "loadAdditional", "getUpdateTag", "getUpdatePacket", "Lnet/minecraft/network/protocol/game/ClientboundBlockEntityDataPacket;", "thebrokenscript-common"})
@SourceDebugExtension(value={"SMAP\nPortalExtenderBlockEntity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PortalExtenderBlockEntity.kt\nnet/thebrokenscript/block/portal/PortalExtenderBlockEntity\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,36:1\n1#2:37\n*E\n"})
public final class PortalExtenderBlockEntity
extends BlockEntity {
    @Nullable
    private BlockPos parent;

    public PortalExtenderBlockEntity(@NotNull BlockEntityType<?> type, @NotNull BlockPos pos, @NotNull BlockState state) {
        Intrinsics.checkNotNullParameter(type, (String)"type");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        Intrinsics.checkNotNullParameter((Object)state, (String)"state");
        super(type, pos, state);
    }

    @Nullable
    public final BlockPos getParent() {
        return this.parent;
    }

    public final void setParent(@Nullable BlockPos blockPos) {
        this.parent = blockPos;
    }

    protected void saveAdditional(@NotNull CompoundTag tag, @NotNull HolderLookup.Provider registries) {
        block0: {
            Intrinsics.checkNotNullParameter((Object)tag, (String)"tag");
            Intrinsics.checkNotNullParameter((Object)registries, (String)"registries");
            super.saveAdditional(tag, registries);
            BlockPos blockPos = this.parent;
            if (blockPos == null) break block0;
            BlockPos it = blockPos;
            boolean bl = false;
            tag.putLong("parent", it.asLong());
        }
    }

    protected void loadAdditional(@NotNull CompoundTag tag, @NotNull HolderLookup.Provider registries) {
        block0: {
            Intrinsics.checkNotNullParameter((Object)tag, (String)"tag");
            Intrinsics.checkNotNullParameter((Object)registries, (String)"registries");
            super.loadAdditional(tag, registries);
            Long l = TagExt.INSTANCE.getOptionalLong(tag, "parent");
            if (l == null) break block0;
            long it = ((Number)l).longValue();
            boolean bl = false;
            this.parent = BlockPos.of((long)it);
        }
    }

    @NotNull
    public CompoundTag getUpdateTag(@NotNull HolderLookup.Provider registries) {
        CompoundTag compoundTag;
        Intrinsics.checkNotNullParameter((Object)registries, (String)"registries");
        CompoundTag it = compoundTag = super.getUpdateTag(registries);
        boolean bl = false;
        Intrinsics.checkNotNull((Object)it);
        this.saveAdditional(it, registries);
        CompoundTag compoundTag2 = compoundTag;
        Intrinsics.checkNotNullExpressionValue((Object)compoundTag2, (String)"also(...)");
        return compoundTag2;
    }

    @NotNull
    public ClientboundBlockEntityDataPacket getUpdatePacket() {
        ClientboundBlockEntityDataPacket clientboundBlockEntityDataPacket = ClientboundBlockEntityDataPacket.create((BlockEntity)this);
        Intrinsics.checkNotNullExpressionValue((Object)clientboundBlockEntityDataPacket, (String)"create(...)");
        return clientboundBlockEntityDataPacket;
    }
}

