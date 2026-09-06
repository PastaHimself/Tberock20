/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.JvmName
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.block.Block
 *  net.minecraft.world.level.block.entity.BlockEntity
 *  net.minecraft.world.level.block.state.BlockState
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.dsl;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
@Metadata(mv={2, 1, 0}, k=2, xi=48, d1={"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\u0015\u0010\u0003\u001a\u00020\u0004*\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0002H\u0086\u0004\u001a\n\u0010\u0006\u001a\u00020\u0007*\u00020\b\u00a8\u0006\t"}, d2={"default", "Lnet/minecraft/world/level/block/state/BlockState;", "Lnet/minecraft/world/level/block/Block;", "matches", "", "other", "setDirty", "", "Lnet/minecraft/world/level/block/entity/BlockEntity;", "brokencore-common"})
@JvmName(name="BlockUtil")
public final class BlockUtil {
    @NotNull
    public static final BlockState default(@NotNull Block $this$default) {
        Intrinsics.checkNotNullParameter((Object)$this$default, (String)"<this>");
        BlockState blockState = $this$default.defaultBlockState();
        Intrinsics.checkNotNullExpressionValue((Object)blockState, (String)"defaultBlockState(...)");
        return blockState;
    }

    public static final boolean matches(@NotNull BlockState $this$matches, @NotNull Block other) {
        Intrinsics.checkNotNullParameter((Object)$this$matches, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)other, (String)"other");
        return $this$matches.is(other);
    }

    public static final void setDirty(@NotNull BlockEntity $this$setDirty) {
        block0: {
            Intrinsics.checkNotNullParameter((Object)$this$setDirty, (String)"<this>");
            $this$setDirty.setChanged();
            Level level = $this$setDirty.getLevel();
            if (level == null) break block0;
            level.sendBlockUpdated($this$setDirty.getBlockPos(), $this$setDirty.getBlockState(), $this$setDirty.getBlockState(), 3);
        }
    }
}

