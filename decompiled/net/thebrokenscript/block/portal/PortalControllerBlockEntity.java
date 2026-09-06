/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.HolderLookup$Provider
 *  net.minecraft.core.Vec3i
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket
 *  net.minecraft.world.level.block.entity.BlockEntity
 *  net.minecraft.world.level.block.entity.BlockEntityType
 *  net.minecraft.world.level.block.state.BlockState
 *  net.thebrokenscript.brokencore.api.dsl.BlockUtil
 *  net.thebrokenscript.brokencore.api.ext.TagExt
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.block.portal;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.Vec3i;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.thebrokenscript.block.portal.CornerBB;
import net.thebrokenscript.brokencore.api.dsl.BlockUtil;
import net.thebrokenscript.brokencore.api.ext.TagExt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B#\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0004\u001a\u00020\u0005J\u0018\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0014J\u0018\u0010#\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0014J\u0010\u0010$\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0016J\b\u0010%\u001a\u00020&H\u0016R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R \u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b\u00a8\u0006'"}, d2={"Lnet/thebrokenscript/block/portal/PortalControllerBlockEntity;", "Lnet/minecraft/world/level/block/entity/BlockEntity;", "type", "Lnet/minecraft/world/level/block/entity/BlockEntityType;", "pos", "Lnet/minecraft/core/BlockPos;", "state", "Lnet/minecraft/world/level/block/state/BlockState;", "<init>", "(Lnet/minecraft/world/level/block/entity/BlockEntityType;Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/level/block/state/BlockState;)V", "bb", "Lnet/thebrokenscript/block/portal/CornerBB;", "getBb", "()Lnet/thebrokenscript/block/portal/CornerBB;", "setBb", "(Lnet/thebrokenscript/block/portal/CornerBB;)V", "linked", "getLinked", "()Lnet/minecraft/core/BlockPos;", "setLinked", "(Lnet/minecraft/core/BlockPos;)V", "incoming", "", "Ljava/util/UUID;", "getIncoming", "()Ljava/util/List;", "setIncoming", "(Ljava/util/List;)V", "update", "", "saveAdditional", "tag", "Lnet/minecraft/nbt/CompoundTag;", "registries", "Lnet/minecraft/core/HolderLookup$Provider;", "loadAdditional", "getUpdateTag", "getUpdatePacket", "Lnet/minecraft/network/protocol/game/ClientboundBlockEntityDataPacket;", "thebrokenscript-common"})
@SourceDebugExtension(value={"SMAP\nPortalControllerBlockEntity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PortalControllerBlockEntity.kt\nnet/thebrokenscript/block/portal/PortalControllerBlockEntity\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,48:1\n1#2:49\n*E\n"})
public final class PortalControllerBlockEntity
extends BlockEntity {
    @NotNull
    private CornerBB bb;
    @Nullable
    private BlockPos linked;
    @NotNull
    private List<UUID> incoming;

    public PortalControllerBlockEntity(@NotNull BlockEntityType<?> type, @NotNull BlockPos pos, @NotNull BlockState state) {
        Intrinsics.checkNotNullParameter(type, (String)"type");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        Intrinsics.checkNotNullParameter((Object)state, (String)"state");
        super(type, pos, state);
        BlockPos blockPos = BlockPos.ZERO;
        Intrinsics.checkNotNullExpressionValue((Object)blockPos, (String)"ZERO");
        Vec3i vec3i = (Vec3i)blockPos;
        BlockPos blockPos2 = BlockPos.ZERO;
        Intrinsics.checkNotNullExpressionValue((Object)blockPos2, (String)"ZERO");
        this.bb = new CornerBB(vec3i, (Vec3i)blockPos2);
        this.incoming = new ArrayList();
    }

    @NotNull
    public final CornerBB getBb() {
        return this.bb;
    }

    public final void setBb(@NotNull CornerBB cornerBB) {
        Intrinsics.checkNotNullParameter((Object)cornerBB, (String)"<set-?>");
        this.bb = cornerBB;
    }

    @Nullable
    public final BlockPos getLinked() {
        return this.linked;
    }

    public final void setLinked(@Nullable BlockPos blockPos) {
        this.linked = blockPos;
    }

    @NotNull
    public final List<UUID> getIncoming() {
        return this.incoming;
    }

    public final void setIncoming(@NotNull List<UUID> list) {
        Intrinsics.checkNotNullParameter(list, (String)"<set-?>");
        this.incoming = list;
    }

    public final void update(@NotNull BlockPos pos) {
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        BlockPos blockPos = pos.subtract((Vec3i)this.getBlockPos());
        Intrinsics.checkNotNullExpressionValue((Object)blockPos, (String)"subtract(...)");
        this.bb.expand((Vec3i)blockPos);
        BlockUtil.setDirty((BlockEntity)this);
    }

    protected void saveAdditional(@NotNull CompoundTag tag, @NotNull HolderLookup.Provider registries) {
        block0: {
            Intrinsics.checkNotNullParameter((Object)tag, (String)"tag");
            Intrinsics.checkNotNullParameter((Object)registries, (String)"registries");
            super.saveAdditional(tag, registries);
            tag.putLong("posA", this.bb.getA().asLong());
            tag.putLong("posB", this.bb.getB().asLong());
            BlockPos blockPos = this.linked;
            if (blockPos == null) break block0;
            BlockPos it = blockPos;
            boolean bl = false;
            tag.putLong("linked", it.asLong());
        }
    }

    protected void loadAdditional(@NotNull CompoundTag tag, @NotNull HolderLookup.Provider registries) {
        block2: {
            long it;
            Intrinsics.checkNotNullParameter((Object)tag, (String)"tag");
            Intrinsics.checkNotNullParameter((Object)registries, (String)"registries");
            super.loadAdditional(tag, registries);
            Long l = TagExt.INSTANCE.getOptionalLong(tag, "posA");
            if (l != null) {
                it = ((Number)l).longValue();
                boolean bl = false;
                BlockPos blockPos = BlockPos.of((long)it);
                Intrinsics.checkNotNullExpressionValue((Object)blockPos, (String)"of(...)");
                this.bb.setA(blockPos);
            }
            Long l2 = TagExt.INSTANCE.getOptionalLong(tag, "posB");
            if (l2 != null) {
                it = ((Number)l2).longValue();
                boolean bl = false;
                BlockPos blockPos = BlockPos.of((long)it);
                Intrinsics.checkNotNullExpressionValue((Object)blockPos, (String)"of(...)");
                this.bb.setB(blockPos);
            }
            Long l3 = TagExt.INSTANCE.getOptionalLong(tag, "linked");
            if (l3 == null) break block2;
            it = ((Number)l3).longValue();
            boolean bl = false;
            this.linked = BlockPos.of((long)it);
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

