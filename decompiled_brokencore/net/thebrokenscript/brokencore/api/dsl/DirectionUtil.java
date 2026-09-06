/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.NoWhenBranchMatchedException
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.JvmName
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.core.Direction
 *  net.minecraft.core.Direction$Axis
 *  net.minecraft.data.models.blockstates.VariantProperties$Rotation
 *  net.minecraft.world.level.block.PipeBlock
 *  net.minecraft.world.level.block.state.properties.BooleanProperty
 *  org.jetbrains.annotations.NotNull
 *  org.joml.Math
 *  org.joml.Quaternionf
 *  org.joml.Vector3f
 */
package net.thebrokenscript.brokencore.api.dsl;

import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.core.Direction;
import net.minecraft.data.models.blockstates.VariantProperties;
import net.minecraft.world.level.block.PipeBlock;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.thebrokenscript.brokencore.api.dsl.PositionUtil;
import org.jetbrains.annotations.NotNull;
import org.joml.Math;
import org.joml.Quaternionf;
import org.joml.Vector3f;

@Metadata(mv={2, 1, 0}, k=2, xi=48, d1={"\u0000R\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u001a\u0010$\u001a\u00020!*\u00020\u00022\u0006\u0010%\u001a\u00020!2\u0006\u0010&\u001a\u00020!\"\u001c\u0010\u0000\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00010\u0001X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0003\"\u0015\u0010\u0004\u001a\u00020\u0005*\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\"\u0015\u0010\b\u001a\u00020\t*\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000b\"\u0015\u0010\f\u001a\u00020\r*\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\u000e\"\u0015\u0010\u000f\u001a\u00020\u0010*\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012\"\u001b\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\u0014*\u00020\u00158F\u00a2\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017\"\u0015\u0010\u0018\u001a\u00020\u0019*\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b\"\u0015\u0010\u001c\u001a\u00020\u001d*\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b\u001e\u0010\u001f\"\u0015\u0010 \u001a\u00020!*\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b\"\u0010#\u00a8\u0006'"}, d2={"dirAxisRotations", "", "Lnet/minecraft/core/Direction;", "[[Lnet/minecraft/core/Direction;", "blockProp", "Lnet/minecraft/world/level/block/state/properties/BooleanProperty;", "getBlockProp", "(Lnet/minecraft/core/Direction;)Lnet/minecraft/world/level/block/state/properties/BooleanProperty;", "blockRot", "Lnet/minecraft/data/models/blockstates/VariantProperties$Rotation;", "getBlockRot", "(Lnet/minecraft/core/Direction;)Lnet/minecraft/data/models/blockstates/VariantProperties$Rotation;", "isPositive", "", "(Lnet/minecraft/core/Direction;)Z", "quaternion", "Lorg/joml/Quaternionf;", "getQuaternion", "(Lnet/minecraft/core/Direction;)Lorg/joml/Quaternionf;", "orthogonalDirections", "", "Lnet/minecraft/core/Direction$Axis;", "getOrthogonalDirections", "(Lnet/minecraft/core/Direction$Axis;)Ljava/util/List;", "blockRotInt", "", "getBlockRotInt", "(Lnet/minecraft/core/Direction;)I", "blockRotFloat", "", "getBlockRotFloat", "(Lnet/minecraft/core/Direction;)F", "blockRotDegVec", "Lorg/joml/Vector3f;", "getBlockRotDegVec", "(Lnet/minecraft/core/Direction;)Lorg/joml/Vector3f;", "rotatedAround", "vec", "center", "brokencore-common"})
@JvmName(name="DirectionUtil")
public final class DirectionUtil {
    @NotNull
    private static final Direction[][] dirAxisRotations;

    @NotNull
    public static final BooleanProperty getBlockProp(@NotNull Direction $this$blockProp) {
        Intrinsics.checkNotNullParameter((Object)$this$blockProp, (String)"<this>");
        Object v = PipeBlock.PROPERTY_BY_DIRECTION.get($this$blockProp);
        Intrinsics.checkNotNull(v);
        return (BooleanProperty)v;
    }

    @NotNull
    public static final VariantProperties.Rotation getBlockRot(@NotNull Direction $this$blockRot) {
        Intrinsics.checkNotNullParameter((Object)$this$blockRot, (String)"<this>");
        return switch (WhenMappings.$EnumSwitchMapping$0[$this$blockRot.ordinal()]) {
            case 1 -> VariantProperties.Rotation.R0;
            case 2 -> VariantProperties.Rotation.R90;
            case 3 -> VariantProperties.Rotation.R180;
            case 4 -> VariantProperties.Rotation.R270;
            case 5 -> VariantProperties.Rotation.R270;
            case 6 -> VariantProperties.Rotation.R90;
            default -> throw new NoWhenBranchMatchedException();
        };
    }

    public static final boolean isPositive(@NotNull Direction $this$isPositive) {
        Intrinsics.checkNotNullParameter((Object)$this$isPositive, (String)"<this>");
        return $this$isPositive != Direction.DOWN && $this$isPositive != Direction.NORTH && $this$isPositive != Direction.WEST;
    }

    @NotNull
    public static final Quaternionf getQuaternion(@NotNull Direction $this$quaternion) {
        Quaternionf quaternionf;
        Intrinsics.checkNotNullParameter((Object)$this$quaternion, (String)"<this>");
        switch (WhenMappings.$EnumSwitchMapping$0[$this$quaternion.ordinal()]) {
            case 1: {
                quaternionf = new Quaternionf(-1.0f, 0.0f, 0.0f, 1.0f);
                break;
            }
            case 2: {
                quaternionf = new Quaternionf(0.0f, 0.0f, -1.0f, 1.0f);
                break;
            }
            case 3: {
                quaternionf = new Quaternionf(1.0f, 0.0f, 0.0f, 1.0f);
                break;
            }
            case 4: {
                quaternionf = new Quaternionf(0.0f, 0.0f, 1.0f, 1.0f);
                break;
            }
            case 5: {
                quaternionf = new Quaternionf(0.0f, 1.0f, 0.0f, 1.0f);
                break;
            }
            case 6: {
                Quaternionf quaternionf2 = new Quaternionf(0.0f, 1.0f, 0.0f, 1.0f).rotateX(Math.toRadians((float)180.0f));
                quaternionf = quaternionf2;
                Intrinsics.checkNotNullExpressionValue((Object)quaternionf2, (String)"rotateX(...)");
                break;
            }
            default: {
                throw new NoWhenBranchMatchedException();
            }
        }
        return quaternionf;
    }

    @NotNull
    public static final List<Direction> getOrthogonalDirections(@NotNull Direction.Axis $this$orthogonalDirections) {
        Intrinsics.checkNotNullParameter((Object)$this$orthogonalDirections, (String)"<this>");
        return switch (WhenMappings.$EnumSwitchMapping$1[$this$orthogonalDirections.ordinal()]) {
            case 1 -> {
                Object[] var1_1 = new Direction[]{Direction.UP, Direction.DOWN, Direction.NORTH, Direction.SOUTH};
                yield CollectionsKt.listOf((Object[])var1_1);
            }
            case 2 -> {
                Object[] var1_2 = new Direction[]{Direction.NORTH, Direction.SOUTH, Direction.EAST, Direction.WEST};
                yield CollectionsKt.listOf((Object[])var1_2);
            }
            case 3 -> {
                Object[] var1_3 = new Direction[]{Direction.UP, Direction.DOWN, Direction.EAST, Direction.WEST};
                yield CollectionsKt.listOf((Object[])var1_3);
            }
            default -> throw new NoWhenBranchMatchedException();
        };
    }

    public static final int getBlockRotInt(@NotNull Direction $this$blockRotInt) {
        Intrinsics.checkNotNullParameter((Object)$this$blockRotInt, (String)"<this>");
        return switch (WhenMappings.$EnumSwitchMapping$0[$this$blockRotInt.ordinal()]) {
            case 1 -> 0;
            case 2 -> 90;
            case 3 -> 180;
            case 4 -> 270;
            case 5 -> 270;
            case 6 -> 90;
            default -> throw new NoWhenBranchMatchedException();
        };
    }

    public static final float getBlockRotFloat(@NotNull Direction $this$blockRotFloat) {
        Intrinsics.checkNotNullParameter((Object)$this$blockRotFloat, (String)"<this>");
        return DirectionUtil.getBlockRotInt($this$blockRotFloat);
    }

    @NotNull
    public static final Vector3f getBlockRotDegVec(@NotNull Direction $this$blockRotDegVec) {
        Intrinsics.checkNotNullParameter((Object)$this$blockRotDegVec, (String)"<this>");
        return switch (WhenMappings.$EnumSwitchMapping$0[$this$blockRotDegVec.ordinal()]) {
            case 5 -> new Vector3f(270.0f, 0.0f, 0.0f);
            case 6 -> new Vector3f(90.0f, 0.0f, 0.0f);
            case 1 -> new Vector3f(0.0f);
            case 3 -> new Vector3f(0.0f, 180.0f, 0.0f);
            case 2 -> new Vector3f(0.0f, 90.0f, 0.0f);
            case 4 -> new Vector3f(0.0f, 270.0f, 0.0f);
            default -> throw new NoWhenBranchMatchedException();
        };
    }

    @NotNull
    public static final Vector3f rotatedAround(@NotNull Direction $this$rotatedAround, @NotNull Vector3f vec, @NotNull Vector3f center) {
        Intrinsics.checkNotNullParameter((Object)$this$rotatedAround, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)vec, (String)"vec");
        Intrinsics.checkNotNullParameter((Object)center, (String)"center");
        return PositionUtil.rotatedAround(vec, center, DirectionUtil.getBlockRotDegVec($this$rotatedAround));
    }

    static {
        Direction[][] directionArrayArray = new Direction[3][];
        Direction[] directionArray = new Direction[]{Direction.UP, Direction.NORTH, Direction.DOWN, Direction.SOUTH};
        directionArrayArray[0] = directionArray;
        directionArray = new Direction[]{Direction.NORTH, Direction.EAST, Direction.SOUTH, Direction.WEST};
        directionArrayArray[1] = directionArray;
        directionArray = new Direction[]{Direction.UP, Direction.EAST, Direction.DOWN, Direction.WEST};
        directionArrayArray[2] = directionArray;
        dirAxisRotations = directionArrayArray;
    }

    @Metadata(mv={2, 1, 0}, k=3, xi=48)
    public static final class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] nArray = new int[Direction.values().length];
            try {
                nArray[Direction.NORTH.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[Direction.EAST.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[Direction.SOUTH.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[Direction.WEST.ordinal()] = 4;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[Direction.UP.ordinal()] = 5;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[Direction.DOWN.ordinal()] = 6;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            $EnumSwitchMapping$0 = nArray;
            nArray = new int[Direction.Axis.values().length];
            try {
                nArray[Direction.Axis.X.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[Direction.Axis.Y.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[Direction.Axis.Z.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            $EnumSwitchMapping$1 = nArray;
        }
    }
}

