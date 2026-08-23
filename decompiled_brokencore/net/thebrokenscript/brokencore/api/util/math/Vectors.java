/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.world.phys.Vec3
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.util.math;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0004\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u001e\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0007\u00a8\u0006\f"}, d2={"Lnet/thebrokenscript/brokencore/api/util/math/Vectors;", "", "<init>", "()V", "all", "Lnet/minecraft/world/phys/Vec3;", "value", "", "of", "x", "y", "z", "brokencore-common"})
public final class Vectors {
    @NotNull
    public static final Vectors INSTANCE = new Vectors();

    private Vectors() {
    }

    @NotNull
    public final Vec3 all(@NotNull Number value) {
        Intrinsics.checkNotNullParameter((Object)value, (String)"value");
        return new Vec3(value.doubleValue(), value.doubleValue(), value.doubleValue());
    }

    @NotNull
    public final Vec3 of(@NotNull Number x, @NotNull Number y, @NotNull Number z) {
        Intrinsics.checkNotNullParameter((Object)x, (String)"x");
        Intrinsics.checkNotNullParameter((Object)y, (String)"y");
        Intrinsics.checkNotNullParameter((Object)z, (String)"z");
        return new Vec3(x.doubleValue(), y.doubleValue(), z.doubleValue());
    }
}

