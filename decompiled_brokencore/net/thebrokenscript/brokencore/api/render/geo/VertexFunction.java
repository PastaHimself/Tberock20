/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 *  org.joml.Vector3f
 */
package net.thebrokenscript.brokencore.api.render.geo;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector3f;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001b\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\n\u001a\u00020\u0005J\u000e\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0004R\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\u00a8\u0006\f"}, d2={"Lnet/thebrokenscript/brokencore/api/render/geo/VertexFunction;", "", "func", "Lkotlin/Function1;", "", "Lorg/joml/Vector3f;", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "getFunc", "()Lkotlin/jvm/functions/Function1;", "run", "index", "brokencore-common"})
public final class VertexFunction {
    @NotNull
    private final Function1<Integer, Vector3f> func;

    public VertexFunction(@NotNull Function1<? super Integer, ? extends Vector3f> func) {
        Intrinsics.checkNotNullParameter(func, (String)"func");
        this.func = func;
    }

    @NotNull
    public final Function1<Integer, Vector3f> getFunc() {
        return this.func;
    }

    @NotNull
    public final Vector3f run() {
        return (Vector3f)this.func.invoke((Object)0);
    }

    @NotNull
    public final Vector3f run(int index) {
        return (Vector3f)this.func.invoke((Object)index);
    }
}

