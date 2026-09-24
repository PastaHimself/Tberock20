/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.api.anim;

import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.thebrokenscript.api.anim.Keyframe;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t\u00a8\u0006\f"}, d2={"Lnet/thebrokenscript/api/anim/AnimEval;", "", "<init>", "()V", "doLerp", "", "ticks", "", "map", "", "", "Lnet/thebrokenscript/api/anim/Keyframe;", "thebrokenscript-common"})
public final class AnimEval {
    @NotNull
    public static final AnimEval INSTANCE = new AnimEval();

    private AnimEval() {
    }

    public final void doLerp(long ticks, @NotNull Map<Float, Keyframe> map) {
        Intrinsics.checkNotNullParameter(map, (String)"map");
        Iterator<Map.Entry<Float, Keyframe>> iter = map.entrySet().iterator();
    }
}

