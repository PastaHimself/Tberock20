/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.util;

import kotlin.Metadata;
import net.thebrokenscript.brokencore.api.util.OnceSet;
import net.thebrokenscript.brokencore.api.util.ValProperty;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=2, xi=48, d1={"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001a\u0010\u0000\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0003\u001a'\u0010\u0004\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u0002H\u00030\u0005\"\u0004\b\u0000\u0010\u00032\u0006\u0010\u0006\u001a\u0002H\u0003\u00a2\u0006\u0002\u0010\u0007\u00a8\u0006\b"}, d2={"onceSet", "Lnet/thebrokenscript/brokencore/api/util/OnceSet;", "", "T", "valOf", "Lnet/thebrokenscript/brokencore/api/util/ValProperty;", "v", "(Ljava/lang/Object;)Lnet/thebrokenscript/brokencore/api/util/ValProperty;", "brokencore-common"})
public final class PropertiesKt {
    @NotNull
    public static final <T> OnceSet<Object, T> onceSet() {
        return new OnceSet();
    }

    @NotNull
    public static final <T> ValProperty<Object, T> valOf(T v) {
        return new ValProperty(v);
    }
}

