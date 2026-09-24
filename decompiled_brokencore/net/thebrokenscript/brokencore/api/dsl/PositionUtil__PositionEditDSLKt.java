/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Direction$Axis
 *  net.minecraft.world.phys.Vec2
 *  net.minecraft.world.phys.Vec3
 *  org.jetbrains.annotations.NotNull
 *  org.joml.Vector3d
 */
package net.thebrokenscript.brokencore.api.dsl;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector3d;

@Metadata(mv={2, 1, 0}, k=5, xi=48, d1={"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0004\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0004\u001a\u0012\u0010\u0006\u001a\u00020\u0007*\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u0012\u0010\b\u001a\u00020\t*\u00020\t2\u0006\u0010\n\u001a\u00020\u0004\u001a\u0012\u0010\u0000\u001a\u00020\t*\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u0012\u0010\u000b\u001a\u00020\t*\u00020\t2\u0006\u0010\f\u001a\u00020\u0004\u00a8\u0006\r"}, d2={"withY", "Lnet/minecraft/world/phys/Vec3;", "Lnet/minecraft/world/phys/Vec2;", "y", "", "value", "setY", "Lorg/joml/Vector3d;", "withX", "Lnet/minecraft/core/BlockPos;", "x", "withZ", "z", "brokencore-common"}, xs="net/thebrokenscript/brokencore/api/dsl/PositionUtil")
@SourceDebugExtension(value={"SMAP\nPositionEditDSL.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PositionEditDSL.kt\nnet/thebrokenscript/brokencore/api/dsl/PositionUtil__PositionEditDSLKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,21:1\n1#2:22\n*E\n"})
final class PositionUtil__PositionEditDSLKt {
    @NotNull
    public static final Vec3 withY(@NotNull Vec2 $this$withY, @NotNull Number y) {
        Intrinsics.checkNotNullParameter((Object)$this$withY, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)y, (String)"y");
        return new Vec3((double)$this$withY.x, y.doubleValue(), (double)$this$withY.y);
    }

    @NotNull
    public static final Vec3 withY(@NotNull Vec3 $this$withY, @NotNull Number value) {
        Intrinsics.checkNotNullParameter((Object)$this$withY, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)value, (String)"value");
        Vec3 vec3 = $this$withY.with(Direction.Axis.Y, value.doubleValue());
        Intrinsics.checkNotNullExpressionValue((Object)vec3, (String)"with(...)");
        return vec3;
    }

    @NotNull
    public static final Vector3d setY(@NotNull Vector3d $this$setY, @NotNull Number y) {
        Vector3d vector3d;
        Intrinsics.checkNotNullParameter((Object)$this$setY, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)y, (String)"y");
        Vector3d $this$setY_u24lambda_u240 = vector3d = $this$setY;
        boolean bl = false;
        $this$setY_u24lambda_u240.y = y.doubleValue();
        return vector3d;
    }

    @NotNull
    public static final BlockPos withX(@NotNull BlockPos $this$withX, @NotNull Number x) {
        Intrinsics.checkNotNullParameter((Object)$this$withX, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)x, (String)"x");
        return new BlockPos(x.intValue(), $this$withX.getY(), $this$withX.getZ());
    }

    @NotNull
    public static final BlockPos withY(@NotNull BlockPos $this$withY, @NotNull Number y) {
        Intrinsics.checkNotNullParameter((Object)$this$withY, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)y, (String)"y");
        return new BlockPos($this$withY.getX(), y.intValue(), $this$withY.getZ());
    }

    @NotNull
    public static final BlockPos withZ(@NotNull BlockPos $this$withZ, @NotNull Number z) {
        Intrinsics.checkNotNullParameter((Object)$this$withZ, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)z, (String)"z");
        return new BlockPos($this$withZ.getX(), $this$withZ.getY(), z.intValue());
    }
}

