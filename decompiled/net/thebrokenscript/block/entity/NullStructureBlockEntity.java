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
 *  net.minecraft.nbt.IntArrayTag
 *  net.minecraft.nbt.ListTag
 *  net.minecraft.nbt.NbtUtils
 *  net.minecraft.nbt.Tag
 *  net.minecraft.world.level.block.entity.BlockEntity
 *  net.minecraft.world.level.block.entity.BlockEntityType
 *  net.minecraft.world.level.block.state.BlockState
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.block.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.IntArrayTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.NbtUtils;
import net.minecraft.nbt.Tag;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B#\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0012J\u0018\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0014J\u0018\u0010#\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0014R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0016X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a\u00a8\u0006$"}, d2={"Lnet/thebrokenscript/block/entity/NullStructureBlockEntity;", "Lnet/minecraft/world/level/block/entity/BlockEntity;", "type", "Lnet/minecraft/world/level/block/entity/BlockEntityType;", "pos", "Lnet/minecraft/core/BlockPos;", "blockState", "Lnet/minecraft/world/level/block/state/BlockState;", "<init>", "(Lnet/minecraft/world/level/block/entity/BlockEntityType;Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/level/block/state/BlockState;)V", "structureId", "", "getStructureId", "()Ljava/lang/String;", "setStructureId", "(Ljava/lang/String;)V", "players", "", "Ljava/util/UUID;", "getPlayers", "()Ljava/util/List;", "triggered", "", "getTriggered", "()Z", "setTriggered", "(Z)V", "addPlayer", "", "uuid", "saveAdditional", "tag", "Lnet/minecraft/nbt/CompoundTag;", "registries", "Lnet/minecraft/core/HolderLookup$Provider;", "loadAdditional", "thebrokenscript-common"})
@SourceDebugExtension(value={"SMAP\nNullStructureBlockEntity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NullStructureBlockEntity.kt\nnet/thebrokenscript/block/entity/NullStructureBlockEntity\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,49:1\n1869#2:50\n1870#2:52\n1#3:51\n*S KotlinDebug\n*F\n+ 1 NullStructureBlockEntity.kt\nnet/thebrokenscript/block/entity/NullStructureBlockEntity\n*L\n26#1:50\n26#1:52\n*E\n"})
public final class NullStructureBlockEntity
extends BlockEntity {
    @NotNull
    private String structureId;
    @NotNull
    private final List<UUID> players;
    private boolean triggered;

    public NullStructureBlockEntity(@NotNull BlockEntityType<?> type, @NotNull BlockPos pos, @NotNull BlockState blockState) {
        Intrinsics.checkNotNullParameter(type, (String)"type");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        Intrinsics.checkNotNullParameter((Object)blockState, (String)"blockState");
        super(type, pos, blockState);
        this.structureId = "";
        this.players = new ArrayList();
    }

    @NotNull
    public final String getStructureId() {
        return this.structureId;
    }

    public final void setStructureId(@NotNull String string) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"<set-?>");
        this.structureId = string;
    }

    @NotNull
    public final List<UUID> getPlayers() {
        return this.players;
    }

    public final boolean getTriggered() {
        return this.triggered;
    }

    public final void setTriggered(boolean bl) {
        this.triggered = bl;
    }

    public final void addPlayer(@NotNull UUID uuid) {
        Intrinsics.checkNotNullParameter((Object)uuid, (String)"uuid");
        if (!this.players.contains(uuid)) {
            this.players.add(uuid);
        }
    }

    protected void saveAdditional(@NotNull CompoundTag tag, @NotNull HolderLookup.Provider registries) {
        Intrinsics.checkNotNullParameter((Object)tag, (String)"tag");
        Intrinsics.checkNotNullParameter((Object)registries, (String)"registries");
        super.saveAdditional(tag, registries);
        tag.putString("structureid", this.structureId);
        ListTag playerList = tag.getList("players", 10);
        Iterable $this$forEach$iv = this.players;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            IntArrayTag intArrayTag;
            UUID uuid = (UUID)element$iv;
            boolean bl = false;
            CompoundTag uuidTag = new CompoundTag();
            IntArrayTag it = intArrayTag = NbtUtils.createUUID((UUID)uuid);
            boolean bl2 = false;
            uuidTag.put("uuid", (Tag)it);
            playerList.add((Object)uuidTag);
        }
        tag.put("players", (Tag)playerList);
        tag.putBoolean("triggered", this.triggered);
    }

    protected void loadAdditional(@NotNull CompoundTag tag, @NotNull HolderLookup.Provider registries) {
        Intrinsics.checkNotNullParameter((Object)tag, (String)"tag");
        Intrinsics.checkNotNullParameter((Object)registries, (String)"registries");
        super.loadAdditional(tag, registries);
        String string = tag.getString("structureid");
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"getString(...)");
        this.structureId = string;
        this.players.clear();
        ListTag playerList = tag.getList("players", 10);
        int n = ((Collection)playerList).size();
        for (int i = 0; i < n; ++i) {
            CompoundTag uuidTag = playerList.getCompound(i);
            Tag tag2 = uuidTag.get("uuid");
            Intrinsics.checkNotNull((Object)tag2);
            UUID uUID = NbtUtils.loadUUID((Tag)tag2);
            Intrinsics.checkNotNullExpressionValue((Object)uUID, (String)"loadUUID(...)");
            this.players.add(uUID);
        }
        this.triggered = tag.getBoolean("triggered");
    }
}

