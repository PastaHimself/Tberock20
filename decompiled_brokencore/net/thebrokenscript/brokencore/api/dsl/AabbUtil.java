/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.JvmName
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.level.levelgen.structure.BoundingBox
 *  net.minecraft.world.phys.AABB
 *  net.minecraft.world.phys.Vec3
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.dsl;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=2, xi=48, d1={"\u0000*\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0003\u001a\u0012\u0010\u000b\u001a\u00020\f*\u00020\u00022\u0006\u0010\r\u001a\u00020\u000e\u001a\u0012\u0010\u000f\u001a\u00020\u0010*\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0002\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0015\u0010\u0005\u001a\u00020\u0001*\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0004\"\u0015\u0010\u0007\u001a\u00020\u0001*\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\u0004\"\u0015\u0010\t\u001a\u00020\u0001*\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u0004\"\u0015\u0010\u0012\u001a\u00020\u0013*\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0016"}, d2={"truncBox", "Lnet/minecraft/world/level/levelgen/structure/BoundingBox;", "Lnet/minecraft/world/phys/AABB;", "getTruncBox", "(Lnet/minecraft/world/phys/AABB;)Lnet/minecraft/world/level/levelgen/structure/BoundingBox;", "roundBox", "getRoundBox", "floorBox", "getFloorBox", "ceilBox", "getCeilBox", "eyeCenter", "Lnet/minecraft/world/phys/Vec3;", "entity", "Lnet/minecraft/world/entity/Entity;", "contains", "", "other", "volume", "", "getVolume", "(Lnet/minecraft/world/phys/AABB;)D", "brokencore-common"})
@JvmName(name="AabbUtil")
public final class AabbUtil {
    @NotNull
    public static final BoundingBox getTruncBox(@NotNull AABB $this$truncBox) {
        Intrinsics.checkNotNullParameter((Object)$this$truncBox, (String)"<this>");
        return new BoundingBox((int)$this$truncBox.minX, (int)$this$truncBox.minY, (int)$this$truncBox.minZ, (int)$this$truncBox.maxX, (int)$this$truncBox.maxY, (int)$this$truncBox.maxZ);
    }

    @NotNull
    public static final BoundingBox getRoundBox(@NotNull AABB $this$roundBox) {
        Intrinsics.checkNotNullParameter((Object)$this$roundBox, (String)"<this>");
        return new BoundingBox((int)Math.rint($this$roundBox.minX), (int)Math.rint($this$roundBox.minY), (int)Math.rint($this$roundBox.minZ), (int)Math.rint($this$roundBox.maxX), (int)Math.rint($this$roundBox.maxY), (int)Math.rint($this$roundBox.maxZ));
    }

    @NotNull
    public static final BoundingBox getFloorBox(@NotNull AABB $this$floorBox) {
        Intrinsics.checkNotNullParameter((Object)$this$floorBox, (String)"<this>");
        return new BoundingBox((int)Math.floor($this$floorBox.minX), (int)Math.floor($this$floorBox.minY), (int)Math.floor($this$floorBox.minZ), (int)Math.floor($this$floorBox.maxX), (int)Math.floor($this$floorBox.maxY), (int)Math.floor($this$floorBox.maxZ));
    }

    @NotNull
    public static final BoundingBox getCeilBox(@NotNull AABB $this$ceilBox) {
        Intrinsics.checkNotNullParameter((Object)$this$ceilBox, (String)"<this>");
        return new BoundingBox((int)Math.ceil($this$ceilBox.minX), (int)Math.ceil($this$ceilBox.minY), (int)Math.ceil($this$ceilBox.minZ), (int)Math.ceil($this$ceilBox.maxX), (int)Math.ceil($this$ceilBox.maxY), (int)Math.ceil($this$ceilBox.maxZ));
    }

    @NotNull
    public static final Vec3 eyeCenter(@NotNull AABB $this$eyeCenter, @NotNull Entity entity) {
        Intrinsics.checkNotNullParameter((Object)$this$eyeCenter, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)entity, (String)"entity");
        float eyeHeight = entity.getEyeHeight(entity.getPose());
        Vec3 vec3 = $this$eyeCenter.getBottomCenter().add(0.0, (double)eyeHeight, 0.0);
        Intrinsics.checkNotNullExpressionValue((Object)vec3, (String)"add(...)");
        return vec3;
    }

    public static final boolean contains(@NotNull AABB $this$contains, @NotNull AABB other) {
        Intrinsics.checkNotNullParameter((Object)$this$contains, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)other, (String)"other");
        return other.maxX <= $this$contains.maxX && other.maxY <= $this$contains.maxY && other.maxZ <= $this$contains.maxZ && other.minX >= $this$contains.minX && other.minY >= $this$contains.minY && other.minZ >= $this$contains.minZ;
    }

    public static final double getVolume(@NotNull AABB $this$volume) {
        Intrinsics.checkNotNullParameter((Object)$this$volume, (String)"<this>");
        return $this$volume.getXsize() * $this$volume.getYsize() * $this$volume.getZsize();
    }
}

