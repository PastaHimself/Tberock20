/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.world.phys.Vec2
 *  net.minecraft.world.phys.Vec3
 *  org.jetbrains.annotations.NotNull
 *  org.joml.Vector2f
 *  org.joml.Vector3f
 *  org.joml.Vector4f
 */
package net.thebrokenscript.brokencore.api.dsl;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector2f;
import org.joml.Vector3f;
import org.joml.Vector4f;

@Metadata(mv={2, 1, 0}, k=5, xi=48, d1={"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0015\u0010\u0005\u001a\u00020\u0006*\u00020\u00078F\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\t\"\u0015\u0010\n\u001a\u00020\u000b*\u00020\u00078F\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\r\"\u0015\u0010\u000e\u001a\u00020\u0006*\u00020\u00078F\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\t\"\u0015\u0010\u0000\u001a\u00020\u0006*\u00020\u000b8F\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010\u0010\u00a8\u0006\u0011"}, d2={"xz", "Lnet/minecraft/world/phys/Vec2;", "Lnet/minecraft/world/phys/Vec3;", "getXz", "(Lnet/minecraft/world/phys/Vec3;)Lnet/minecraft/world/phys/Vec2;", "xy", "Lorg/joml/Vector2f;", "Lorg/joml/Vector4f;", "getXy", "(Lorg/joml/Vector4f;)Lorg/joml/Vector2f;", "xyz", "Lorg/joml/Vector3f;", "getXyz", "(Lorg/joml/Vector4f;)Lorg/joml/Vector3f;", "zw", "getZw", "(Lorg/joml/Vector3f;)Lorg/joml/Vector2f;", "brokencore-common"}, xs="net/thebrokenscript/brokencore/api/dsl/PositionUtil")
final class PositionUtil__PositionSwizzleDSLKt {
    @NotNull
    public static final Vec2 getXz(@NotNull Vec3 $this$xz) {
        Intrinsics.checkNotNullParameter((Object)$this$xz, (String)"<this>");
        return new Vec2((float)$this$xz.x, (float)$this$xz.z);
    }

    @NotNull
    public static final Vector2f getXy(@NotNull Vector4f $this$xy) {
        Intrinsics.checkNotNullParameter((Object)$this$xy, (String)"<this>");
        return new Vector2f($this$xy.x, $this$xy.y);
    }

    @NotNull
    public static final Vector3f getXyz(@NotNull Vector4f $this$xyz) {
        Intrinsics.checkNotNullParameter((Object)$this$xyz, (String)"<this>");
        return new Vector3f($this$xyz.x, $this$xyz.y, $this$xyz.z);
    }

    @NotNull
    public static final Vector2f getZw(@NotNull Vector4f $this$zw) {
        Intrinsics.checkNotNullParameter((Object)$this$zw, (String)"<this>");
        return new Vector2f($this$zw.z, $this$zw.w);
    }

    @NotNull
    public static final Vector2f getXz(@NotNull Vector3f $this$xz) {
        Intrinsics.checkNotNullParameter((Object)$this$xz, (String)"<this>");
        return new Vector2f($this$xz.x, $this$xz.z);
    }
}

