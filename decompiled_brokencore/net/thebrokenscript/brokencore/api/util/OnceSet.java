/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.properties.ReadWriteProperty
 *  kotlin.reflect.KProperty
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.brokencore.api.util;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0003:\u0001\u0013B\u0007\u00a2\u0006\u0004\b\u0004\u0010\u0005J\"\u0010\u000b\u001a\u00028\u00012\u0006\u0010\f\u001a\u00028\u00002\n\u0010\r\u001a\u0006\u0012\u0002\b\u00030\u000eH\u0096\u0002\u00a2\u0006\u0002\u0010\u000fJ*\u0010\u0010\u001a\u00020\u00112\u0006\u0010\f\u001a\u00028\u00002\n\u0010\r\u001a\u0006\u0012\u0002\b\u00030\u000e2\u0006\u0010\u0006\u001a\u00028\u0001H\u0096\u0002\u00a2\u0006\u0002\u0010\u0012R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2={"Lnet/thebrokenscript/brokencore/api/util/OnceSet;", "V", "T", "Lkotlin/properties/ReadWriteProperty;", "<init>", "()V", "value", "", "isSet", "", "lock", "getValue", "thisRef", "property", "Lkotlin/reflect/KProperty;", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;)Ljava/lang/Object;", "setValue", "", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;Ljava/lang/Object;)V", "UNSET", "brokencore-common"})
public final class OnceSet<V, T>
implements ReadWriteProperty<V, T> {
    @Nullable
    private Object value = UNSET.INSTANCE;
    private boolean isSet;
    @NotNull
    private final Object lock = new Object();

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public T getValue(V thisRef, @NotNull KProperty<?> property) {
        Intrinsics.checkNotNullParameter(property, (String)"property");
        if (this.value == UNSET.INSTANCE) {
            Object object = this.lock;
            synchronized (object) {
                boolean bl = false;
                if (this.value == UNSET.INSTANCE) {
                    throw new IllegalStateException(("Property " + property.getName() + " has not been set yet.").toString());
                }
                Unit unit = Unit.INSTANCE;
            }
        }
        return (T)this.value;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void setValue(V thisRef, @NotNull KProperty<?> property, T value) {
        Intrinsics.checkNotNullParameter(property, (String)"property");
        if (this.isSet) {
            throw new IllegalStateException(("Cannot set finalized property " + property.getName()).toString());
        }
        Object object = this.lock;
        synchronized (object) {
            boolean bl = false;
            if (!this.isSet) {
                this.isSet = true;
            }
            Unit unit = Unit.INSTANCE;
        }
        this.value = value;
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u00c2\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2={"Lnet/thebrokenscript/brokencore/api/util/OnceSet$UNSET;", "", "<init>", "()V", "brokencore-common"})
    private static final class UNSET {
        @NotNull
        public static final UNSET INSTANCE = new UNSET();

        private UNSET() {
        }
    }
}

