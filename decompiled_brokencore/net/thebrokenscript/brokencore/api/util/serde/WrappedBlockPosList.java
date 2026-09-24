/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.core.BlockPos
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.util.serde;

import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.core.BlockPos;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\u0004\b\u0005\u0010\u0006R \u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0006\u00a8\u0006\n"}, d2={"Lnet/thebrokenscript/brokencore/api/util/serde/WrappedBlockPosList;", "", "entries", "", "Lnet/minecraft/core/BlockPos;", "<init>", "(Ljava/util/Set;)V", "getEntries", "()Ljava/util/Set;", "setEntries", "brokencore-common"})
public final class WrappedBlockPosList {
    @NotNull
    private Set<BlockPos> entries;

    public WrappedBlockPosList(@NotNull Set<BlockPos> entries2) {
        Intrinsics.checkNotNullParameter(entries2, (String)"entries");
        this.entries = entries2;
    }

    @NotNull
    public final Set<BlockPos> getEntries() {
        return this.entries;
    }

    public final void setEntries(@NotNull Set<BlockPos> set) {
        Intrinsics.checkNotNullParameter(set, (String)"<set-?>");
        this.entries = set;
    }
}

