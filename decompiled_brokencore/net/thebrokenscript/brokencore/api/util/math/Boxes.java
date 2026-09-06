/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.core.BlockPos
 *  net.minecraft.world.level.levelgen.structure.BoundingBox
 *  net.minecraft.world.phys.AABB
 *  net.minecraft.world.phys.Vec3
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.util.math;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0004\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\t\u00a8\u0006\r"}, d2={"Lnet/thebrokenscript/brokencore/api/util/math/Boxes;", "", "<init>", "()V", "aabb", "Lnet/minecraft/world/phys/AABB;", "center", "Lnet/minecraft/world/phys/Vec3;", "size", "", "bounding", "Lnet/minecraft/world/level/levelgen/structure/BoundingBox;", "Lnet/minecraft/core/BlockPos;", "brokencore-common"})
public final class Boxes {
    @NotNull
    public static final Boxes INSTANCE = new Boxes();

    private Boxes() {
    }

    @NotNull
    public final AABB aabb(@NotNull Vec3 center, @NotNull Number size) {
        Intrinsics.checkNotNullParameter((Object)center, (String)"center");
        Intrinsics.checkNotNullParameter((Object)size, (String)"size");
        AABB aABB = AABB.ofSize((Vec3)center, (double)(size.doubleValue() * (double)2), (double)(size.doubleValue() * (double)2), (double)(size.doubleValue() * (double)2));
        Intrinsics.checkNotNullExpressionValue((Object)aABB, (String)"ofSize(...)");
        return aABB;
    }

    @NotNull
    public final BoundingBox bounding(@NotNull BlockPos center, @NotNull Number size) {
        Intrinsics.checkNotNullParameter((Object)center, (String)"center");
        Intrinsics.checkNotNullParameter((Object)size, (String)"size");
        BoundingBox boundingBox = new BoundingBox(center).inflatedBy(size.intValue());
        Intrinsics.checkNotNullExpressionValue((Object)boundingBox, (String)"inflatedBy(...)");
        return boundingBox;
    }
}

