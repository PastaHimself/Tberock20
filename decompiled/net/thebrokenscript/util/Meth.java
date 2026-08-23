/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.world.phys.Vec2
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.util;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.world.phys.Vec2;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t\u00a8\u0006\n"}, d2={"Lnet/thebrokenscript/util/Meth;", "", "<init>", "()V", "snort", "", "angle2d", "", "p", "Lnet/minecraft/world/phys/Vec2;", "thebrokenscript-common"})
public final class Meth {
    @NotNull
    public static final Meth INSTANCE = new Meth();

    private Meth() {
    }

    public final void snort() {
        throw new IllegalStateException("please get us some more");
    }

    public final float angle2d(@NotNull Vec2 p) {
        Intrinsics.checkNotNullParameter((Object)p, (String)"p");
        Vec2 pn = p.normalized();
        float t = pn.x == 0.0f ? 1.0f : pn.x / Math.abs(pn.x);
        float angle = 0.5f * (t - 1.0f) * (float)Math.PI + t * (float)Math.asin(pn.y);
        return angle;
    }
}

