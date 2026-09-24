/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.core.BlockPos
 *  net.minecraft.resources.ResourceKey
 *  net.minecraft.world.level.block.entity.BlockEntity
 *  net.minecraft.world.level.block.entity.BlockEntityType
 *  net.minecraft.world.level.block.state.BlockState
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.registry.objects;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.thebrokenscript.brokencore.api.registry.objects.RegistryEntry;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u0018\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u00040\u0003B\u0019\u0012\u0010\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\u0006\u00a2\u0006\u0004\b\u0007\u0010\bJ\u001b\u0010\t\u001a\u00028\u00002\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r\u00a2\u0006\u0002\u0010\u000e\u00a8\u0006\u000f"}, d2={"Lnet/thebrokenscript/brokencore/api/registry/objects/BlockEntityEntry;", "T", "Lnet/minecraft/world/level/block/entity/BlockEntity;", "Lnet/thebrokenscript/brokencore/api/registry/objects/RegistryEntry;", "Lnet/minecraft/world/level/block/entity/BlockEntityType;", "key", "Lnet/minecraft/resources/ResourceKey;", "<init>", "(Lnet/minecraft/resources/ResourceKey;)V", "create", "pos", "Lnet/minecraft/core/BlockPos;", "state", "Lnet/minecraft/world/level/block/state/BlockState;", "(Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/level/block/state/BlockState;)Lnet/minecraft/world/level/block/entity/BlockEntity;", "brokencore-common"})
public final class BlockEntityEntry<T extends BlockEntity>
extends RegistryEntry<BlockEntityType<?>, BlockEntityType<T>> {
    public BlockEntityEntry(@NotNull ResourceKey<BlockEntityType<?>> key) {
        Intrinsics.checkNotNullParameter(key, (String)"key");
        super(key);
    }

    @NotNull
    public final T create(@NotNull BlockPos pos, @NotNull BlockState state) {
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        Intrinsics.checkNotNullParameter((Object)state, (String)"state");
        BlockEntity blockEntity = ((BlockEntityType)this.get()).create(pos, state);
        Intrinsics.checkNotNull((Object)blockEntity);
        return (T)blockEntity;
    }
}

