/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  net.minecraft.world.phys.Vec3
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.api.util;

import kotlin.Metadata;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007\u00a8\u0006\b"}, d2={"Lnet/thebrokenscript/api/util/Colors;", "", "<init>", "()V", "rgb", "Lnet/minecraft/world/phys/Vec3;", "hex", "", "thebrokenscript-common"})
public final class Colors {
    @NotNull
    public static final Colors INSTANCE = new Colors();

    private Colors() {
    }

    @NotNull
    public final Vec3 rgb(int hex) {
        return new Vec3((double)(hex >> 16 & 0xFF) / 255.0, (double)(hex >> 8 & 0xFF) / 255.0, (double)(hex & 0xFF) / 255.0);
    }
}

