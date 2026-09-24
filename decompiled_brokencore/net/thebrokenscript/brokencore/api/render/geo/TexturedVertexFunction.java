/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.brokencore.api.render.geo;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import net.thebrokenscript.brokencore.api.render.geo.TexturedVertex;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\t\u001a\u00020\u0005J\u000e\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0004J\u0015\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u00c6\u0003J\u001f\u0010\f\u001a\u00020\u00002\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u00c6\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u00d6\u0003J\t\u0010\u0011\u001a\u00020\u0004H\u00d6\u0001J\t\u0010\u0012\u001a\u00020\u0013H\u00d6\u0001R\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\b\u00a8\u0006\u0014"}, d2={"Lnet/thebrokenscript/brokencore/api/render/geo/TexturedVertexFunction;", "Ljava/lang/Record;", "func", "Lkotlin/Function1;", "", "Lnet/thebrokenscript/brokencore/api/render/geo/TexturedVertex;", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "()Lkotlin/jvm/functions/Function1;", "run", "index", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "brokencore-common"})
public final class TexturedVertexFunction
extends Record {
    @NotNull
    private final Function1<Integer, TexturedVertex> func;

    public TexturedVertexFunction(@NotNull Function1<? super Integer, TexturedVertex> func) {
        Intrinsics.checkNotNullParameter(func, (String)"func");
        this.func = func;
    }

    @NotNull
    public final Function1<Integer, TexturedVertex> func() {
        return this.func;
    }

    @NotNull
    public final TexturedVertex run() {
        return (TexturedVertex)this.func.invoke((Object)0);
    }

    @NotNull
    public final TexturedVertex run(int index) {
        return (TexturedVertex)this.func.invoke((Object)index);
    }

    @NotNull
    public final Function1<Integer, TexturedVertex> component1() {
        return this.func;
    }

    @NotNull
    public final TexturedVertexFunction copy(@NotNull Function1<? super Integer, TexturedVertex> func) {
        Intrinsics.checkNotNullParameter(func, (String)"func");
        return new TexturedVertexFunction(func);
    }

    public static /* synthetic */ TexturedVertexFunction copy$default(TexturedVertexFunction texturedVertexFunction, Function1 function1, int n, Object object) {
        if ((n & 1) != 0) {
            function1 = texturedVertexFunction.func;
        }
        return texturedVertexFunction.copy(function1);
    }

    @Override
    @NotNull
    public String toString() {
        return "TexturedVertexFunction(func=" + this.func + ")";
    }

    @Override
    public int hashCode() {
        return this.func.hashCode();
    }

    @Override
    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TexturedVertexFunction)) {
            return false;
        }
        TexturedVertexFunction texturedVertexFunction = (TexturedVertexFunction)other;
        return Intrinsics.areEqual(this.func, texturedVertexFunction.func);
    }
}

