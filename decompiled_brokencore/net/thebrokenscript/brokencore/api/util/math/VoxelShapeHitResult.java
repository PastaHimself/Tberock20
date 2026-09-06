/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.core.Direction
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  org.joml.Vector3f
 */
package net.thebrokenscript.brokencore.api.util.math;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.core.Direction;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector3f;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0011\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0012\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0013\u001a\u00020\u0007H\u00c6\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u00c6\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0018\u001a\u00020\u0019H\u00d6\u0001J\t\u0010\u001a\u001a\u00020\u001bH\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u001c"}, d2={"Lnet/thebrokenscript/brokencore/api/util/math/VoxelShapeHitResult;", "", "origin", "Lorg/joml/Vector3f;", "dir", "hitPos", "face", "Lnet/minecraft/core/Direction;", "<init>", "(Lorg/joml/Vector3f;Lorg/joml/Vector3f;Lorg/joml/Vector3f;Lnet/minecraft/core/Direction;)V", "getOrigin", "()Lorg/joml/Vector3f;", "getDir", "getHitPos", "getFace", "()Lnet/minecraft/core/Direction;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "", "brokencore-common"})
public final class VoxelShapeHitResult {
    @NotNull
    private final Vector3f origin;
    @NotNull
    private final Vector3f dir;
    @NotNull
    private final Vector3f hitPos;
    @NotNull
    private final Direction face;

    public VoxelShapeHitResult(@NotNull Vector3f origin, @NotNull Vector3f dir, @NotNull Vector3f hitPos, @NotNull Direction face2) {
        Intrinsics.checkNotNullParameter((Object)origin, (String)"origin");
        Intrinsics.checkNotNullParameter((Object)dir, (String)"dir");
        Intrinsics.checkNotNullParameter((Object)hitPos, (String)"hitPos");
        Intrinsics.checkNotNullParameter((Object)face2, (String)"face");
        this.origin = origin;
        this.dir = dir;
        this.hitPos = hitPos;
        this.face = face2;
    }

    @NotNull
    public final Vector3f getOrigin() {
        return this.origin;
    }

    @NotNull
    public final Vector3f getDir() {
        return this.dir;
    }

    @NotNull
    public final Vector3f getHitPos() {
        return this.hitPos;
    }

    @NotNull
    public final Direction getFace() {
        return this.face;
    }

    @NotNull
    public final Vector3f component1() {
        return this.origin;
    }

    @NotNull
    public final Vector3f component2() {
        return this.dir;
    }

    @NotNull
    public final Vector3f component3() {
        return this.hitPos;
    }

    @NotNull
    public final Direction component4() {
        return this.face;
    }

    @NotNull
    public final VoxelShapeHitResult copy(@NotNull Vector3f origin, @NotNull Vector3f dir, @NotNull Vector3f hitPos, @NotNull Direction face2) {
        Intrinsics.checkNotNullParameter((Object)origin, (String)"origin");
        Intrinsics.checkNotNullParameter((Object)dir, (String)"dir");
        Intrinsics.checkNotNullParameter((Object)hitPos, (String)"hitPos");
        Intrinsics.checkNotNullParameter((Object)face2, (String)"face");
        return new VoxelShapeHitResult(origin, dir, hitPos, face2);
    }

    public static /* synthetic */ VoxelShapeHitResult copy$default(VoxelShapeHitResult voxelShapeHitResult, Vector3f vector3f, Vector3f vector3f2, Vector3f vector3f3, Direction direction, int n, Object object) {
        if ((n & 1) != 0) {
            vector3f = voxelShapeHitResult.origin;
        }
        if ((n & 2) != 0) {
            vector3f2 = voxelShapeHitResult.dir;
        }
        if ((n & 4) != 0) {
            vector3f3 = voxelShapeHitResult.hitPos;
        }
        if ((n & 8) != 0) {
            direction = voxelShapeHitResult.face;
        }
        return voxelShapeHitResult.copy(vector3f, vector3f2, vector3f3, direction);
    }

    @NotNull
    public String toString() {
        return "VoxelShapeHitResult(origin=" + this.origin + ", dir=" + this.dir + ", hitPos=" + this.hitPos + ", face=" + this.face + ")";
    }

    public int hashCode() {
        int result = this.origin.hashCode();
        result = result * 31 + this.dir.hashCode();
        result = result * 31 + this.hitPos.hashCode();
        result = result * 31 + this.face.hashCode();
        return result;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VoxelShapeHitResult)) {
            return false;
        }
        VoxelShapeHitResult voxelShapeHitResult = (VoxelShapeHitResult)other;
        if (!Intrinsics.areEqual((Object)this.origin, (Object)voxelShapeHitResult.origin)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.dir, (Object)voxelShapeHitResult.dir)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.hitPos, (Object)voxelShapeHitResult.hitPos)) {
            return false;
        }
        return this.face == voxelShapeHitResult.face;
    }
}

