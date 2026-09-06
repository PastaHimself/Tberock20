/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.reflect.KProperty
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.brokencore.api.dsl;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\u00a2\u0006\u0004\b\u0007\u0010\bJ$\u0010\u000b\u001a\u0004\u0018\u00018\u00002\u0006\u0010\f\u001a\u00020\u00022\n\u0010\r\u001a\u0006\u0012\u0002\b\u00030\u000eH\u0086\u0002\u00a2\u0006\u0002\u0010\u000fJ,\u0010\u0010\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\u00022\n\u0010\r\u001a\u0006\u0012\u0002\b\u00030\u000e2\b\u0010\u0012\u001a\u0004\u0018\u00018\u0000H\u0086\u0002\u00a2\u0006\u0002\u0010\u0013R\u0012\u0010\t\u001a\u0004\u0018\u00018\u0000X\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\n\u00a8\u0006\u0014"}, d2={"Lnet/thebrokenscript/brokencore/api/dsl/OnlyIfAvailableMut;", "T", "", "available", "", "ctor", "Lkotlin/Function0;", "<init>", "(ZLkotlin/jvm/functions/Function0;)V", "value", "Ljava/lang/Object;", "getValue", "thisRef", "property", "Lkotlin/reflect/KProperty;", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;)Ljava/lang/Object;", "setValue", "", "new", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;Ljava/lang/Object;)V", "brokencore-common"})
public final class OnlyIfAvailableMut<T> {
    @Nullable
    private T value;

    public OnlyIfAvailableMut(boolean available, @NotNull Function0<? extends T> ctor) {
        Intrinsics.checkNotNullParameter(ctor, (String)"ctor");
        this.value = available ? ctor.invoke() : null;
    }

    @Nullable
    public final T getValue(@NotNull Object thisRef, @NotNull KProperty<?> property) {
        Intrinsics.checkNotNullParameter((Object)thisRef, (String)"thisRef");
        Intrinsics.checkNotNullParameter(property, (String)"property");
        return this.value;
    }

    public final void setValue(@NotNull Object thisRef, @NotNull KProperty<?> property, @Nullable T t) {
        Intrinsics.checkNotNullParameter((Object)thisRef, (String)"thisRef");
        Intrinsics.checkNotNullParameter(property, (String)"property");
        this.value = t;
    }
}

