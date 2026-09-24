/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.util.Mth
 *  org.jetbrains.annotations.NotNull
 *  org.joml.Vector3d
 */
package net.thebrokenscript.brokencore.api.math;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.util.Mth;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector3d;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0005J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0005\u00a8\u0006\u000f"}, d2={"Lnet/thebrokenscript/brokencore/api/math/MiscMath;", "", "<init>", "()V", "paraboloid", "", "pos", "Lorg/joml/Vector3d;", "start", "end", "apexHeight", "x", "z", "xWidth", "zWidth", "brokencore-common"})
public final class MiscMath {
    @NotNull
    public static final MiscMath INSTANCE = new MiscMath();

    private MiscMath() {
    }

    public final double paraboloid(@NotNull Vector3d pos, @NotNull Vector3d start, @NotNull Vector3d end, double apexHeight) {
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        Intrinsics.checkNotNullParameter((Object)start, (String)"start");
        Intrinsics.checkNotNullParameter((Object)end, (String)"end");
        double centerX = Mth.lerp((double)0.5, (double)start.x, (double)end.x);
        double centerZ = Mth.lerp((double)0.5, (double)start.z, (double)end.z);
        return pos.y + this.paraboloid(pos.x - centerX, pos.z - centerZ, apexHeight, apexHeight);
    }

    public final double paraboloid(double x, double z, double xWidth, double zWidth) {
        return Math.pow(x, 2) / Math.pow(xWidth, 2) + Math.pow(z, 2) / Math.pow(zWidth, 2);
    }
}

