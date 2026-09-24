/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.core.BlockPos
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.levelgen.Heightmap$Types
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.boss.integrity;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.levelgen.Heightmap;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0096\u0002J\b\u0010\u0010\u001a\u00020\u0003H\u0016J\t\u0010\u0011\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0012\u001a\u00020\u0003H\u00c6\u0003J\u001d\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u00c6\u0001J\t\u0010\u0014\u001a\u00020\u0015H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0007\u00a8\u0006\u0016"}, d2={"Lnet/thebrokenscript/boss/integrity/PartialBlockPos;", "Ljava/lang/Record;", "x", "", "z", "<init>", "(II)V", "()I", "finish", "Lnet/minecraft/core/BlockPos;", "level", "Lnet/minecraft/world/level/Level;", "equals", "", "other", "", "hashCode", "component1", "component2", "copy", "toString", "", "thebrokenscript-common"})
public final class PartialBlockPos
extends Record {
    private final int x;
    private final int z;

    public PartialBlockPos(int x, int z) {
        this.x = x;
        this.z = z;
    }

    public final int x() {
        return this.x;
    }

    public final int z() {
        return this.z;
    }

    @NotNull
    public final BlockPos finish(@NotNull Level level) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        int y = level.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, this.x, this.z) - 1;
        return new BlockPos(this.x, y, this.z);
    }

    @Override
    public boolean equals(@Nullable Object other) {
        return other instanceof PartialBlockPos && ((PartialBlockPos)other).x == this.x && ((PartialBlockPos)other).z == this.z;
    }

    @Override
    public int hashCode() {
        return 31 * this.x + this.z;
    }

    public final int component1() {
        return this.x;
    }

    public final int component2() {
        return this.z;
    }

    @NotNull
    public final PartialBlockPos copy(int x, int z) {
        return new PartialBlockPos(x, z);
    }

    public static /* synthetic */ PartialBlockPos copy$default(PartialBlockPos partialBlockPos, int n, int n2, int n3, Object object) {
        if ((n3 & 1) != 0) {
            n = partialBlockPos.x;
        }
        if ((n3 & 2) != 0) {
            n2 = partialBlockPos.z;
        }
        return partialBlockPos.copy(n, n2);
    }

    @Override
    @NotNull
    public String toString() {
        return "PartialBlockPos(x=" + this.x + ", z=" + this.z + ")";
    }
}

