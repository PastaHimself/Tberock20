/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.core.BlockPos
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.util;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.core.BlockPos;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0013\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0000\u00a2\u0006\u0004\b\b\u0010\tJ\u0011\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0000H\u0096\u0002J\t\u0010\u001b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001c\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u001d\u001a\u00020\u0005H\u00c6\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0000H\u00c6\u0003J3\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0000H\u00c6\u0001J\u0013\u0010 \u001a\u00020!2\b\u0010\u001a\u001a\u0004\u0018\u00010\"H\u00d6\u0003J\t\u0010#\u001a\u00020\u0019H\u00d6\u0001J\t\u0010$\u001a\u00020%H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u000fR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0000X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0016\u001a\u00020\u00058F\u00a2\u0006\u0006\u001a\u0004\b\u0017\u0010\r\u00a8\u0006&"}, d2={"Lnet/thebrokenscript/util/PathNode;", "", "pos", "Lnet/minecraft/core/BlockPos;", "gCost", "", "hCost", "parent", "<init>", "(Lnet/minecraft/core/BlockPos;DDLnet/thebrokenscript/util/PathNode;)V", "getPos", "()Lnet/minecraft/core/BlockPos;", "getGCost", "()D", "setGCost", "(D)V", "getHCost", "setHCost", "getParent", "()Lnet/thebrokenscript/util/PathNode;", "setParent", "(Lnet/thebrokenscript/util/PathNode;)V", "fCost", "getFCost", "compareTo", "", "other", "component1", "component2", "component3", "component4", "copy", "equals", "", "", "hashCode", "toString", "", "thebrokenscript-common"})
public final class PathNode
implements Comparable<PathNode> {
    @NotNull
    private final BlockPos pos;
    private double gCost;
    private double hCost;
    @Nullable
    private PathNode parent;

    public PathNode(@NotNull BlockPos pos, double gCost, double hCost, @Nullable PathNode parent) {
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        this.pos = pos;
        this.gCost = gCost;
        this.hCost = hCost;
        this.parent = parent;
    }

    public /* synthetic */ PathNode(BlockPos blockPos, double d, double d2, PathNode pathNode, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 2) != 0) {
            d = Double.MAX_VALUE;
        }
        if ((n & 4) != 0) {
            d2 = 0.0;
        }
        if ((n & 8) != 0) {
            pathNode = null;
        }
        this(blockPos, d, d2, pathNode);
    }

    @NotNull
    public final BlockPos getPos() {
        return this.pos;
    }

    public final double getGCost() {
        return this.gCost;
    }

    public final void setGCost(double d) {
        this.gCost = d;
    }

    public final double getHCost() {
        return this.hCost;
    }

    public final void setHCost(double d) {
        this.hCost = d;
    }

    @Nullable
    public final PathNode getParent() {
        return this.parent;
    }

    public final void setParent(@Nullable PathNode pathNode) {
        this.parent = pathNode;
    }

    public final double getFCost() {
        return this.gCost + this.hCost;
    }

    @Override
    public int compareTo(@NotNull PathNode other) {
        Intrinsics.checkNotNullParameter((Object)other, (String)"other");
        return Double.compare(this.getFCost(), other.getFCost());
    }

    @NotNull
    public final BlockPos component1() {
        return this.pos;
    }

    public final double component2() {
        return this.gCost;
    }

    public final double component3() {
        return this.hCost;
    }

    @Nullable
    public final PathNode component4() {
        return this.parent;
    }

    @NotNull
    public final PathNode copy(@NotNull BlockPos pos, double gCost, double hCost, @Nullable PathNode parent) {
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        return new PathNode(pos, gCost, hCost, parent);
    }

    public static /* synthetic */ PathNode copy$default(PathNode pathNode, BlockPos blockPos, double d, double d2, PathNode pathNode2, int n, Object object) {
        if ((n & 1) != 0) {
            blockPos = pathNode.pos;
        }
        if ((n & 2) != 0) {
            d = pathNode.gCost;
        }
        if ((n & 4) != 0) {
            d2 = pathNode.hCost;
        }
        if ((n & 8) != 0) {
            pathNode2 = pathNode.parent;
        }
        return pathNode.copy(blockPos, d, d2, pathNode2);
    }

    @NotNull
    public String toString() {
        return "PathNode(pos=" + this.pos + ", gCost=" + this.gCost + ", hCost=" + this.hCost + ", parent=" + this.parent + ")";
    }

    public int hashCode() {
        int result = this.pos.hashCode();
        result = result * 31 + Double.hashCode(this.gCost);
        result = result * 31 + Double.hashCode(this.hCost);
        result = result * 31 + (this.parent == null ? 0 : this.parent.hashCode());
        return result;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PathNode)) {
            return false;
        }
        PathNode pathNode = (PathNode)other;
        if (!Intrinsics.areEqual((Object)this.pos, (Object)pathNode.pos)) {
            return false;
        }
        if (Double.compare(this.gCost, pathNode.gCost) != 0) {
            return false;
        }
        if (Double.compare(this.hCost, pathNode.hCost) != 0) {
            return false;
        }
        return Intrinsics.areEqual((Object)this.parent, (Object)pathNode.parent);
    }
}

