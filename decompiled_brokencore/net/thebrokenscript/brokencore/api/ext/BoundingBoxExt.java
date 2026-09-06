/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.core.BlockPos
 *  net.minecraft.world.level.levelgen.structure.BoundingBox
 *  net.minecraft.world.phys.AABB
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.ext;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.phys.AABB;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\n\u001a\u00020\u000b*\u00020\u00072\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000b0\rR\u001b\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005*\u00020\u00078F\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0015\u0010\u000e\u001a\u00020\u000f*\u00020\u00078F\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0012"}, d2={"Lnet/thebrokenscript/brokencore/api/ext/BoundingBoxExt;", "", "<init>", "()V", "positions", "", "Lnet/minecraft/core/BlockPos;", "Lnet/minecraft/world/level/levelgen/structure/BoundingBox;", "getPositions", "(Lnet/minecraft/world/level/levelgen/structure/BoundingBox;)Ljava/util/List;", "forEachPos", "", "callback", "Lkotlin/Function1;", "aabb", "Lnet/minecraft/world/phys/AABB;", "getAabb", "(Lnet/minecraft/world/level/levelgen/structure/BoundingBox;)Lnet/minecraft/world/phys/AABB;", "brokencore-common"})
public final class BoundingBoxExt {
    @NotNull
    public static final BoundingBoxExt INSTANCE = new BoundingBoxExt();

    private BoundingBoxExt() {
    }

    @NotNull
    public final List<BlockPos> getPositions(@NotNull BoundingBox $this$positions) {
        Intrinsics.checkNotNullParameter((Object)$this$positions, (String)"<this>");
        List list = new ArrayList();
        int x = $this$positions.minX();
        int n = $this$positions.maxX();
        if (x <= n) {
            while (true) {
                int n2;
                int y;
                if ((y = $this$positions.minY()) <= (n2 = $this$positions.maxY())) {
                    while (true) {
                        int n3;
                        int z;
                        if ((z = $this$positions.minZ()) <= (n3 = $this$positions.maxZ())) {
                            while (true) {
                                list.add(new BlockPos(x, y, z));
                                if (z == n3) break;
                                ++z;
                            }
                        }
                        if (y == n2) break;
                        ++y;
                    }
                }
                if (x == n) break;
                ++x;
            }
        }
        return list;
    }

    public final void forEachPos(@NotNull BoundingBox $this$forEachPos, @NotNull Function1<? super BlockPos, Unit> callback) {
        Intrinsics.checkNotNullParameter((Object)$this$forEachPos, (String)"<this>");
        Intrinsics.checkNotNullParameter(callback, (String)"callback");
        int x = $this$forEachPos.minX();
        int n = $this$forEachPos.maxX();
        if (x <= n) {
            while (true) {
                int n2;
                int y;
                if ((y = $this$forEachPos.minY()) <= (n2 = $this$forEachPos.maxY())) {
                    while (true) {
                        int n3;
                        int z;
                        if ((z = $this$forEachPos.minZ()) <= (n3 = $this$forEachPos.maxZ())) {
                            while (true) {
                                callback.invoke((Object)new BlockPos(x, y, z));
                                if (z == n3) break;
                                ++z;
                            }
                        }
                        if (y == n2) break;
                        ++y;
                    }
                }
                if (x == n) break;
                ++x;
            }
        }
    }

    @NotNull
    public final AABB getAabb(@NotNull BoundingBox $this$aabb) {
        Intrinsics.checkNotNullParameter((Object)$this$aabb, (String)"<this>");
        return new AABB((double)$this$aabb.minX(), (double)$this$aabb.minY(), (double)$this$aabb.minZ(), (double)$this$aabb.maxX(), (double)$this$aabb.maxY(), (double)$this$aabb.maxZ());
    }
}

