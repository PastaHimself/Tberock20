/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Position
 *  net.minecraft.core.Vec3i
 *  net.minecraft.world.level.ChunkPos
 *  net.minecraft.world.phys.AABB
 *  net.minecraft.world.phys.Vec3
 *  org.jetbrains.annotations.NotNull
 *  org.joml.Vector3f
 *  org.joml.Vector3fc
 */
package net.thebrokenscript.brokencore.api.dsl;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Position;
import net.minecraft.core.Vec3i;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector3f;
import org.joml.Vector3fc;

@Metadata(mv={2, 1, 0}, k=5, xi=48, d1={"\u0000<\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0012\u0010\u0011\u001a\u00020\u0012*\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0002\u001a\n\u0010\u0014\u001a\u00020\n*\u00020\u0015\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0015\u0010\u0005\u001a\u00020\u0006*\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\b\"\u0015\u0010\t\u001a\u00020\n*\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\f\"\u0015\u0010\r\u001a\u00020\u000e*\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010\"\u0015\u0010\u0016\u001a\u00020\u0017*\u00020\u000e8F\u00a2\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001a"}, d2={"joml", "Lorg/joml/Vector3f;", "Lnet/minecraft/core/Position;", "getJoml", "(Lnet/minecraft/core/Position;)Lorg/joml/Vector3f;", "vec3i", "Lnet/minecraft/core/Vec3i;", "getVec3i", "(Lnet/minecraft/core/Position;)Lnet/minecraft/core/Vec3i;", "vec3d", "Lnet/minecraft/world/phys/Vec3;", "getVec3d", "(Lnet/minecraft/core/Position;)Lnet/minecraft/world/phys/Vec3;", "blockPos", "Lnet/minecraft/core/BlockPos;", "getBlockPos", "(Lnet/minecraft/core/Position;)Lnet/minecraft/core/BlockPos;", "aabb", "Lnet/minecraft/world/phys/AABB;", "max", "toVec3", "Lorg/joml/Vector3fc;", "chunk", "Lnet/minecraft/world/level/ChunkPos;", "getChunk", "(Lnet/minecraft/core/BlockPos;)Lnet/minecraft/world/level/ChunkPos;", "brokencore-common"}, xs="net/thebrokenscript/brokencore/api/dsl/PositionUtil")
final class PositionUtil__PositionConvDSLKt {
    @NotNull
    public static final Vector3f getJoml(@NotNull Position $this$joml) {
        Intrinsics.checkNotNullParameter((Object)$this$joml, (String)"<this>");
        return new Vector3f((float)$this$joml.x(), (float)$this$joml.y(), (float)$this$joml.z());
    }

    @NotNull
    public static final Vec3i getVec3i(@NotNull Position $this$vec3i) {
        Intrinsics.checkNotNullParameter((Object)$this$vec3i, (String)"<this>");
        return new Vec3i((int)$this$vec3i.x(), (int)$this$vec3i.y(), (int)$this$vec3i.z());
    }

    @NotNull
    public static final Vec3 getVec3d(@NotNull Position $this$vec3d) {
        Intrinsics.checkNotNullParameter((Object)$this$vec3d, (String)"<this>");
        return new Vec3($this$vec3d.x(), $this$vec3d.y(), $this$vec3d.z());
    }

    @NotNull
    public static final BlockPos getBlockPos(@NotNull Position $this$blockPos) {
        Intrinsics.checkNotNullParameter((Object)$this$blockPos, (String)"<this>");
        return new BlockPos((int)$this$blockPos.x(), (int)$this$blockPos.y(), (int)$this$blockPos.z());
    }

    @NotNull
    public static final AABB aabb(@NotNull Position $this$aabb, @NotNull Position max) {
        Intrinsics.checkNotNullParameter((Object)$this$aabb, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)max, (String)"max");
        return new AABB($this$aabb.x(), $this$aabb.y(), $this$aabb.z(), max.x(), max.y(), max.z());
    }

    @NotNull
    public static final Vec3 toVec3(@NotNull Vector3fc $this$toVec3) {
        Intrinsics.checkNotNullParameter((Object)$this$toVec3, (String)"<this>");
        return new Vec3((double)$this$toVec3.x(), (double)$this$toVec3.y(), (double)$this$toVec3.z());
    }

    @NotNull
    public static final ChunkPos getChunk(@NotNull BlockPos $this$chunk) {
        Intrinsics.checkNotNullParameter((Object)$this$chunk, (String)"<this>");
        return new ChunkPos($this$chunk.getX() >> 4, $this$chunk.getZ() >> 4);
    }
}

