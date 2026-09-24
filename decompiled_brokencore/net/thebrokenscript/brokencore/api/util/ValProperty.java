/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.properties.ReadOnlyProperty
 *  kotlin.reflect.KProperty
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.util;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0003B\u000f\u0012\u0006\u0010\u0004\u001a\u00028\u0001\u00a2\u0006\u0004\b\u0005\u0010\u0006B\u0017\b\u0016\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\b\u00a2\u0006\u0004\b\u0005\u0010\tJ\"\u0010\n\u001a\u00028\u00012\u0006\u0010\r\u001a\u00028\u00002\n\u0010\u000e\u001a\u0006\u0012\u0002\b\u00030\u000fH\u0096\u0002\u00a2\u0006\u0002\u0010\u0010R\u0013\u0010\u0004\u001a\u00028\u0001\u00a2\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u0011"}, d2={"Lnet/thebrokenscript/brokencore/api/util/ValProperty;", "T", "V", "Lkotlin/properties/ReadOnlyProperty;", "value", "<init>", "(Ljava/lang/Object;)V", "init", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)V", "getValue", "()Ljava/lang/Object;", "Ljava/lang/Object;", "thisRef", "property", "Lkotlin/reflect/KProperty;", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;)Ljava/lang/Object;", "brokencore-common"})
public final class ValProperty<T, V>
implements ReadOnlyProperty<T, V> {
    private final V value;

    public ValProperty(V value) {
        this.value = value;
    }

    public final V getValue() {
        return this.value;
    }

    public ValProperty(@NotNull Function0<? extends V> init) {
        Intrinsics.checkNotNullParameter(init, (String)"init");
        this(init.invoke());
    }

    public V getValue(T thisRef, @NotNull KProperty<?> property) {
        Intrinsics.checkNotNullParameter(property, (String)"property");
        return this.value;
    }
}

