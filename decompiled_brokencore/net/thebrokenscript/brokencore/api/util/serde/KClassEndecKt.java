/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.reflect.KClass
 */
package net.thebrokenscript.brokencore.api.util.serde;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import net.thebrokenscript.brokencore.api.util.serde.KClassEndec;

@Metadata(mv={2, 1, 0}, k=2, xi=48, d1={"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\".\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00048\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2={"endec", "Lnet/thebrokenscript/brokencore/api/util/serde/KClassEndec;", "S", "", "Lkotlin/reflect/KClass;", "getEndec", "(Lkotlin/reflect/KClass;)Lnet/thebrokenscript/brokencore/api/util/serde/KClassEndec;", "brokencore-common"})
public final class KClassEndecKt {
    public static final /* synthetic */ <S> KClassEndec<S> getEndec(KClass<S> $this$endec) {
        Intrinsics.checkNotNullParameter($this$endec, (String)"<this>");
        boolean $i$f$getEndec = false;
        return new KClassEndec<S>($this$endec);
    }
}

