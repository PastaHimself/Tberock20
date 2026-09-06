/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.markers.KMappedMarker
 *  net.minecraft.core.BlockPos
 *  net.minecraft.world.level.levelgen.structure.BoundingBox
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.util;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B7\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\u0004\u0012\u0006\u0010\t\u001a\u00020\u0004\u00a2\u0006\u0004\b\n\u0010\u000bB\u0019\b\u0016\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0002\u00a2\u0006\u0004\b\n\u0010\u000eB\u0011\b\u0016\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u00a2\u0006\u0004\b\n\u0010\u0011J\t\u0010+\u001a\u00020\u0002H\u0096\u0002J\t\u0010,\u001a\u00020(H\u0096\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0012\u001a\u00020\u0002\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0015\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0018\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u0011\u0010\u001a\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0017R\u0011\u0010\u001c\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0017R\u001e\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u0004@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010\u0017R\u001e\u0010!\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u0004@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0017R\u001e\u0010#\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u0004@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0017R\u001e\u0010%\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u0004@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0017R\u0011\u0010'\u001a\u00020(8F\u00a2\u0006\u0006\u001a\u0004\b)\u0010*\u00a8\u0006-"}, d2={"Lnet/thebrokenscript/brokencore/api/util/CuboidBlockIterator;", "", "Lnet/minecraft/core/BlockPos;", "startX", "", "startY", "startZ", "endX", "endY", "endZ", "<init>", "(IIIIII)V", "minPos", "maxPos", "(Lnet/minecraft/core/BlockPos;Lnet/minecraft/core/BlockPos;)V", "box", "Lnet/minecraft/world/level/levelgen/structure/BoundingBox;", "(Lnet/minecraft/world/level/levelgen/structure/BoundingBox;)V", "startPos", "getStartPos", "()Lnet/minecraft/core/BlockPos;", "sizeX", "getSizeX", "()I", "sizeY", "getSizeY", "sizeZ", "getSizeZ", "totalSize", "getTotalSize", "value", "blocksIterated", "getBlocksIterated", "x", "getX", "y", "getY", "z", "getZ", "finished", "", "getFinished", "()Z", "next", "hasNext", "brokencore-common"})
public final class CuboidBlockIterator
implements Iterator<BlockPos>,
KMappedMarker {
    private final int startX;
    private final int startY;
    private final int startZ;
    @NotNull
    private final BlockPos startPos;
    private final int sizeX;
    private final int sizeY;
    private final int sizeZ;
    private final int totalSize;
    private int blocksIterated;
    private int x;
    private int y;
    private int z;

    public CuboidBlockIterator(int startX, int startY, int startZ, int endX, int endY, int endZ) {
        this.startX = startX;
        this.startY = startY;
        this.startZ = startZ;
        this.startPos = new BlockPos(this.startX, this.startY, this.startZ);
        this.sizeX = endX - this.startX;
        this.sizeY = endY - this.startY;
        this.sizeZ = endZ - this.startZ;
        this.totalSize = this.sizeX * this.sizeY * this.sizeZ;
    }

    public CuboidBlockIterator(@NotNull BlockPos minPos, @NotNull BlockPos maxPos) {
        Intrinsics.checkNotNullParameter((Object)minPos, (String)"minPos");
        Intrinsics.checkNotNullParameter((Object)maxPos, (String)"maxPos");
        this(minPos.getX(), minPos.getY(), minPos.getZ(), maxPos.getX(), maxPos.getY(), maxPos.getZ());
    }

    public CuboidBlockIterator(@NotNull BoundingBox box) {
        Intrinsics.checkNotNullParameter((Object)box, (String)"box");
        this(box.minX(), box.minY(), box.minZ(), box.maxX(), box.maxY(), box.maxZ());
    }

    @NotNull
    public final BlockPos getStartPos() {
        return this.startPos;
    }

    public final int getSizeX() {
        return this.sizeX;
    }

    public final int getSizeY() {
        return this.sizeY;
    }

    public final int getSizeZ() {
        return this.sizeZ;
    }

    public final int getTotalSize() {
        return this.totalSize;
    }

    public final int getBlocksIterated() {
        return this.blocksIterated;
    }

    public final int getX() {
        return this.x;
    }

    public final int getY() {
        return this.y;
    }

    public final int getZ() {
        return this.z;
    }

    public final boolean getFinished() {
        return this.blocksIterated == this.totalSize;
    }

    @Override
    @NotNull
    public BlockPos next() {
        if (this.hasNext()) {
            this.x = this.blocksIterated % this.sizeX;
            int i = this.blocksIterated / this.sizeX;
            this.y = i % this.sizeY;
            this.z = i / this.sizeY;
            ++this.blocksIterated;
        }
        return new BlockPos(this.startX + this.x, this.startY + this.y, this.startZ + this.z);
    }

    @Override
    public boolean hasNext() {
        return this.blocksIterated != this.totalSize;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}

