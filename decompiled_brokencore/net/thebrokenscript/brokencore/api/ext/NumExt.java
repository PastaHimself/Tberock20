/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.ext;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0004\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007\u00a8\u0006\b"}, d2={"Lnet/thebrokenscript/brokencore/api/ext/NumExt;", "", "<init>", "()V", "fractionOf", "", "fraction", "", "brokencore-common"})
public final class NumExt {
    @NotNull
    public static final NumExt INSTANCE = new NumExt();

    private NumExt() {
    }

    public final int fractionOf(int $this$fractionOf, @NotNull Number fraction) {
        Intrinsics.checkNotNullParameter((Object)fraction, (String)"fraction");
        return (int)((double)$this$fractionOf * fraction.doubleValue());
    }
}

