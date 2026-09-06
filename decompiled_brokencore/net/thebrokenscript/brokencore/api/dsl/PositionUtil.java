/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Position
 *  net.minecraft.core.Vec3i
 *  net.minecraft.world.level.ChunkPos
 *  net.minecraft.world.phys.AABB
 *  net.minecraft.world.phys.Vec2
 *  net.minecraft.world.phys.Vec3
 *  org.jetbrains.annotations.NotNull
 *  org.joml.Vector2f
 *  org.joml.Vector3d
 *  org.joml.Vector3f
 *  org.joml.Vector3fc
 *  org.joml.Vector3i
 *  org.joml.Vector4f
 */
package net.thebrokenscript.brokencore.api.dsl;

import kotlin.Metadata;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Position;
import net.minecraft.core.Vec3i;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.brokencore.api.dsl.PositionUtil__PositionConvDSLKt;
import net.thebrokenscript.brokencore.api.dsl.PositionUtil__PositionDSLKt;
import net.thebrokenscript.brokencore.api.dsl.PositionUtil__PositionEditDSLKt;
import net.thebrokenscript.brokencore.api.dsl.PositionUtil__PositionOpsDSLKt;
import net.thebrokenscript.brokencore.api.dsl.PositionUtil__PositionSwizzleDSLKt;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector2f;
import org.joml.Vector3d;
import org.joml.Vector3f;
import org.joml.Vector3fc;
import org.joml.Vector3i;
import org.joml.Vector4f;

@Metadata(mv={2, 1, 0}, k=4, xi=48, d1={"net/thebrokenscript/brokencore/api/dsl/PositionUtil__PositionConvDSLKt", "net/thebrokenscript/brokencore/api/dsl/PositionUtil__PositionDSLKt", "net/thebrokenscript/brokencore/api/dsl/PositionUtil__PositionEditDSLKt", "net/thebrokenscript/brokencore/api/dsl/PositionUtil__PositionOpsDSLKt", "net/thebrokenscript/brokencore/api/dsl/PositionUtil__PositionSwizzleDSLKt"})
public final class PositionUtil {
    @NotNull
    public static final Vector3f getJoml(@NotNull Position $this$joml) {
        return PositionUtil__PositionConvDSLKt.getJoml($this$joml);
    }

    @NotNull
    public static final Vec3i getVec3i(@NotNull Position $this$vec3i) {
        return PositionUtil__PositionConvDSLKt.getVec3i($this$vec3i);
    }

    @NotNull
    public static final Vec3 getVec3d(@NotNull Position $this$vec3d) {
        return PositionUtil__PositionConvDSLKt.getVec3d($this$vec3d);
    }

    @NotNull
    public static final BlockPos getBlockPos(@NotNull Position $this$blockPos) {
        return PositionUtil__PositionConvDSLKt.getBlockPos($this$blockPos);
    }

    @NotNull
    public static final AABB aabb(@NotNull Position $this$aabb, @NotNull Position max) {
        return PositionUtil__PositionConvDSLKt.aabb($this$aabb, max);
    }

    @NotNull
    public static final Vec3 toVec3(@NotNull Vector3fc $this$toVec3) {
        return PositionUtil__PositionConvDSLKt.toVec3($this$toVec3);
    }

    @NotNull
    public static final ChunkPos getChunk(@NotNull BlockPos $this$chunk) {
        return PositionUtil__PositionConvDSLKt.getChunk($this$chunk);
    }

    @NotNull
    public static final Vector3f v3(@NotNull Number x, @NotNull Number y, @NotNull Number z) {
        return PositionUtil__PositionDSLKt.v3(x, y, z);
    }

    @NotNull
    public static final Vector3f nv3(@NotNull Number x, @NotNull Number y, @NotNull Number z) {
        return PositionUtil__PositionDSLKt.nv3(x, y, z);
    }

    public static final float horizDist(@NotNull Vector3fc $this$horizDist, @NotNull Vec3 other) {
        return PositionUtil__PositionDSLKt.horizDist($this$horizDist, other);
    }

    @NotNull
    public static final Vector3f normalFacing(@NotNull Vector3f $this$normalFacing, @NotNull Vector3f other) {
        return PositionUtil__PositionDSLKt.normalFacing($this$normalFacing, other);
    }

    @NotNull
    public static final Vector3f center(@NotNull Vector3f $this$center, @NotNull Vector3f max) {
        return PositionUtil__PositionDSLKt.center($this$center, max);
    }

    @NotNull
    public static final Vector3f rotatedAroundX(@NotNull Vector3f $this$rotatedAroundX, float centerX, float rotationDeg) {
        return PositionUtil__PositionDSLKt.rotatedAroundX($this$rotatedAroundX, centerX, rotationDeg);
    }

    @NotNull
    public static final Vector3f rotatedAroundY(@NotNull Vector3f $this$rotatedAroundY, float centerY, float rotationDeg) {
        return PositionUtil__PositionDSLKt.rotatedAroundY($this$rotatedAroundY, centerY, rotationDeg);
    }

    @NotNull
    public static final Vector3f rotatedAroundZ(@NotNull Vector3f $this$rotatedAroundZ, float centerZ, float rotationDeg) {
        return PositionUtil__PositionDSLKt.rotatedAroundZ($this$rotatedAroundZ, centerZ, rotationDeg);
    }

    @NotNull
    public static final Vector3f rotatedAround(@NotNull Vector3f $this$rotatedAround, @NotNull Vector3f center, @NotNull Vector3f rotationDeg) {
        return PositionUtil__PositionDSLKt.rotatedAround($this$rotatedAround, center, rotationDeg);
    }

    public static final boolean getAsScaleIsVisible(@NotNull Vector3f $this$asScaleIsVisible) {
        return PositionUtil__PositionDSLKt.getAsScaleIsVisible($this$asScaleIsVisible);
    }

    @NotNull
    public static final Vector3d normalFacing(@NotNull Vector3d $this$normalFacing, @NotNull Vector3d other) {
        return PositionUtil__PositionDSLKt.normalFacing($this$normalFacing, other);
    }

    @NotNull
    public static final ChunkPos floorDiv(@NotNull ChunkPos $this$floorDiv, @NotNull Number factor) {
        return PositionUtil__PositionDSLKt.floorDiv($this$floorDiv, factor);
    }

    @NotNull
    public static final ChunkPos times(@NotNull ChunkPos $this$times, @NotNull Number other) {
        return PositionUtil__PositionDSLKt.times($this$times, other);
    }

    @NotNull
    public static final ChunkPos overBy(@NotNull ChunkPos $this$overBy, @NotNull Number other) {
        return PositionUtil__PositionDSLKt.overBy($this$overBy, other);
    }

    @NotNull
    public static final Vec2 lerp(@NotNull Vec2 $this$lerp, @NotNull Vec2 other, float delta) {
        return PositionUtil__PositionDSLKt.lerp($this$lerp, other, delta);
    }

    @NotNull
    public static final Vec3 withY(@NotNull Vec2 $this$withY, @NotNull Number y) {
        return PositionUtil__PositionEditDSLKt.withY($this$withY, y);
    }

    @NotNull
    public static final Vec3 withY(@NotNull Vec3 $this$withY, @NotNull Number value) {
        return PositionUtil__PositionEditDSLKt.withY($this$withY, value);
    }

    @NotNull
    public static final Vector3d setY(@NotNull Vector3d $this$setY, @NotNull Number y) {
        return PositionUtil__PositionEditDSLKt.setY($this$setY, y);
    }

    @NotNull
    public static final BlockPos withX(@NotNull BlockPos $this$withX, @NotNull Number x) {
        return PositionUtil__PositionEditDSLKt.withX($this$withX, x);
    }

    @NotNull
    public static final BlockPos withY(@NotNull BlockPos $this$withY, @NotNull Number y) {
        return PositionUtil__PositionEditDSLKt.withY($this$withY, y);
    }

    @NotNull
    public static final BlockPos withZ(@NotNull BlockPos $this$withZ, @NotNull Number z) {
        return PositionUtil__PositionEditDSLKt.withZ($this$withZ, z);
    }

    @NotNull
    public static final Vec3 getNorm(@NotNull Vec3 $this$norm) {
        return PositionUtil__PositionOpsDSLKt.getNorm($this$norm);
    }

    @NotNull
    public static final Vec3 plus(@NotNull Vec3 $this$plus, @NotNull Vec3 other) {
        return PositionUtil__PositionOpsDSLKt.plus($this$plus, other);
    }

    @NotNull
    public static final Vec3 minus(@NotNull Vec3 $this$minus, @NotNull Vec3 other) {
        return PositionUtil__PositionOpsDSLKt.minus($this$minus, other);
    }

    @NotNull
    public static final Vec3 times(@NotNull Vec3 $this$times, @NotNull Number other) {
        return PositionUtil__PositionOpsDSLKt.times($this$times, other);
    }

    @NotNull
    public static final Vec3 div(@NotNull Vec3 $this$div, @NotNull Number other) {
        return PositionUtil__PositionOpsDSLKt.div($this$div, other);
    }

    @NotNull
    public static final Vec3 unaryMinus(@NotNull Vec3 $this$unaryMinus) {
        return PositionUtil__PositionOpsDSLKt.unaryMinus($this$unaryMinus);
    }

    @NotNull
    public static final Vec3 times(@NotNull Vec3 $this$times, @NotNull Vec3 other) {
        return PositionUtil__PositionOpsDSLKt.times($this$times, other);
    }

    @NotNull
    public static final Vec3 plus(@NotNull Vec3 $this$plus, @NotNull Number x, @NotNull Number y, @NotNull Number z) {
        return PositionUtil__PositionOpsDSLKt.plus($this$plus, x, y, z);
    }

    @NotNull
    public static final Vec3 above(@NotNull Vec3 $this$above, @NotNull Number value) {
        return PositionUtil__PositionOpsDSLKt.above($this$above, value);
    }

    public static /* synthetic */ Vec3 above$default(Vec3 vec3, Number number, int n, Object object) {
        return PositionUtil__PositionOpsDSLKt.above$default(vec3, number, n, object);
    }

    @NotNull
    public static final Vec3i max(@NotNull Vec3i $this$max, @NotNull Vec3i other) {
        return PositionUtil__PositionOpsDSLKt.max($this$max, other);
    }

    @NotNull
    public static final Vec3i min(@NotNull Vec3i $this$min, @NotNull Vec3i other) {
        return PositionUtil__PositionOpsDSLKt.min($this$min, other);
    }

    @NotNull
    public static final Vector3f getNorm(@NotNull Vector3f $this$norm) {
        return PositionUtil__PositionOpsDSLKt.getNorm($this$norm);
    }

    @NotNull
    public static final Vector3f plus(@NotNull Vector3f $this$plus, @NotNull Vector3f other) {
        return PositionUtil__PositionOpsDSLKt.plus($this$plus, other);
    }

    @NotNull
    public static final Vector3f minus(@NotNull Vector3f $this$minus, @NotNull Vector3f other) {
        return PositionUtil__PositionOpsDSLKt.minus($this$minus, other);
    }

    @NotNull
    public static final Vector3f times(@NotNull Vector3f $this$times, @NotNull Number other) {
        return PositionUtil__PositionOpsDSLKt.times($this$times, other);
    }

    @NotNull
    public static final Vector3f div(@NotNull Vector3f $this$div, @NotNull Number other) {
        return PositionUtil__PositionOpsDSLKt.div($this$div, other);
    }

    @NotNull
    public static final Vector3f unaryMinus(@NotNull Vector3f $this$unaryMinus) {
        return PositionUtil__PositionOpsDSLKt.unaryMinus($this$unaryMinus);
    }

    @NotNull
    public static final Vector3f times(@NotNull Vector3f $this$times, @NotNull Vector3f other) {
        return PositionUtil__PositionOpsDSLKt.times($this$times, other);
    }

    public static final int sum(@NotNull Vector3i $this$sum) {
        return PositionUtil__PositionOpsDSLKt.sum($this$sum);
    }

    public static final boolean isZero(@NotNull BlockPos $this$isZero) {
        return PositionUtil__PositionOpsDSLKt.isZero($this$isZero);
    }

    public static final int sum(@NotNull BlockPos $this$sum) {
        return PositionUtil__PositionOpsDSLKt.sum($this$sum);
    }

    @NotNull
    public static final BlockPos negate(@NotNull BlockPos $this$negate) {
        return PositionUtil__PositionOpsDSLKt.negate($this$negate);
    }

    @NotNull
    public static final Vec2 getXz(@NotNull Vec3 $this$xz) {
        return PositionUtil__PositionSwizzleDSLKt.getXz($this$xz);
    }

    @NotNull
    public static final Vector2f getXy(@NotNull Vector4f $this$xy) {
        return PositionUtil__PositionSwizzleDSLKt.getXy($this$xy);
    }

    @NotNull
    public static final Vector3f getXyz(@NotNull Vector4f $this$xyz) {
        return PositionUtil__PositionSwizzleDSLKt.getXyz($this$xyz);
    }

    @NotNull
    public static final Vector2f getZw(@NotNull Vector4f $this$zw) {
        return PositionUtil__PositionSwizzleDSLKt.getZw($this$zw);
    }

    @NotNull
    public static final Vector2f getXz(@NotNull Vector3f $this$xz) {
        return PositionUtil__PositionSwizzleDSLKt.getXz($this$xz);
    }
}

