/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.nbt.LongArrayTag
 *  net.minecraft.nbt.NbtException
 *  net.minecraft.world.phys.shapes.Shapes
 *  net.minecraft.world.phys.shapes.VoxelShape
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.util;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.nbt.LongArrayTag;
import net.minecraft.nbt.NbtException;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0016\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005B\u0011\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0004\b\u0004\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u000b"}, d2={"Lnet/thebrokenscript/brokencore/api/util/VoxelShapeTag;", "Lnet/minecraft/nbt/LongArrayTag;", "shape", "Lnet/minecraft/world/phys/shapes/VoxelShape;", "<init>", "(Lnet/minecraft/world/phys/shapes/VoxelShape;)V", "nbt", "", "([J)V", "getShape", "()Lnet/minecraft/world/phys/shapes/VoxelShape;", "brokencore-common"})
public final class VoxelShapeTag
extends LongArrayTag {
    @NotNull
    private final VoxelShape shape;

    /*
     * WARNING - void declaration
     */
    public VoxelShapeTag(@NotNull VoxelShape shape) {
        void $this$_init__u24lambda_u240;
        List list;
        Intrinsics.checkNotNullParameter((Object)shape, (String)"shape");
        List list2 = list = CollectionsKt.createListBuilder();
        VoxelShapeTag voxelShapeTag = this;
        boolean bl = false;
        shape.forAllBoxes((arg_0, arg_1, arg_2, arg_3, arg_4, arg_5) -> VoxelShapeTag._init_$lambda$0$0((List)$this$_init__u24lambda_u240, arg_0, arg_1, arg_2, arg_3, arg_4, arg_5));
        super(CollectionsKt.build((List)list));
        this.shape = shape;
    }

    @NotNull
    public final VoxelShape getShape() {
        return this.shape;
    }

    public VoxelShapeTag(@NotNull long[] nbt) {
        Intrinsics.checkNotNullParameter((Object)nbt, (String)"nbt");
        long[] lArray = nbt;
        VoxelShapeTag voxelShapeTag = this;
        boolean bl = false;
        if (nbt.length < 6) {
            throw new NbtException("Voxel shape tags must contain at least 6 longs");
        }
        VoxelShape shape = Shapes.empty();
        int n = nbt.length / 6;
        for (int i = 0; i < n; ++i) {
            VoxelShape shapeA = Shapes.create((double)Double.longBitsToDouble(nbt[i * 6]), (double)Double.longBitsToDouble(nbt[i * 6 + 1]), (double)Double.longBitsToDouble(nbt[i * 6 + 2]), (double)Double.longBitsToDouble(nbt[i * 6 + 3]), (double)Double.longBitsToDouble(nbt[i * 6 + 4]), (double)Double.longBitsToDouble(nbt[i * 6 + 5]));
            shape = Shapes.or((VoxelShape)shapeA, (VoxelShape)shape);
        }
        VoxelShape voxelShape = shape;
        Intrinsics.checkNotNullExpressionValue((Object)voxelShape, (String)"run(...)");
        voxelShapeTag(voxelShape);
    }

    private static final void _init_$lambda$0$0(List $this_buildList, double d, double d1, double d2, double d3, double d4, double d5) {
        $this_buildList.add(Double.doubleToRawLongBits(d));
        $this_buildList.add(Double.doubleToRawLongBits(d1));
        $this_buildList.add(Double.doubleToRawLongBits(d2));
        $this_buildList.add(Double.doubleToRawLongBits(d3));
        $this_buildList.add(Double.doubleToRawLongBits(d4));
        $this_buildList.add(Double.doubleToRawLongBits(d5));
    }
}

