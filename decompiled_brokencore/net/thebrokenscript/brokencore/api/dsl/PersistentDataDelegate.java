/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.properties.ReadWriteProperty
 *  kotlin.reflect.KProperty
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.brokencore.api.dsl;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import net.thebrokenscript.brokencore.api.entity.base.BaseMonster;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000*\u0004\b\u0000\u0010\u00012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u0002H\u00010\u0002B?\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00028\u00000\u0007\u0012\u0018\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\n0\t\u00a2\u0006\u0004\b\u000b\u0010\fJ\"\u0010\r\u001a\u00028\u00002\u0006\u0010\u000e\u001a\u00020\u00032\n\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u0010H\u0096\u0002\u00a2\u0006\u0002\u0010\u0011J*\u0010\u0012\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u00032\n\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u00102\u0006\u0010\u0013\u001a\u00028\u0000H\u0096\u0002\u00a2\u0006\u0002\u0010\u0014R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00028\u00000\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R \u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2={"Lnet/thebrokenscript/brokencore/api/dsl/PersistentDataDelegate;", "T", "Lkotlin/properties/ReadWriteProperty;", "Lnet/thebrokenscript/brokencore/api/entity/base/BaseMonster;", "name", "", "getter", "Lkotlin/Function1;", "setter", "Lkotlin/Function2;", "", "<init>", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)V", "getValue", "thisRef", "property", "Lkotlin/reflect/KProperty;", "(Lnet/thebrokenscript/brokencore/api/entity/base/BaseMonster;Lkotlin/reflect/KProperty;)Ljava/lang/Object;", "setValue", "value", "(Lnet/thebrokenscript/brokencore/api/entity/base/BaseMonster;Lkotlin/reflect/KProperty;Ljava/lang/Object;)V", "brokencore-common"})
public final class PersistentDataDelegate<T>
implements ReadWriteProperty<BaseMonster, T> {
    @Nullable
    private final String name;
    @NotNull
    private final Function1<String, T> getter;
    @NotNull
    private final Function2<String, T, Unit> setter;

    public PersistentDataDelegate(@Nullable String name, @NotNull Function1<? super String, ? extends T> getter, @NotNull Function2<? super String, ? super T, Unit> setter) {
        Intrinsics.checkNotNullParameter(getter, (String)"getter");
        Intrinsics.checkNotNullParameter(setter, (String)"setter");
        this.name = name;
        this.getter = getter;
        this.setter = setter;
    }

    public T getValue(@NotNull BaseMonster thisRef, @NotNull KProperty<?> property) {
        Intrinsics.checkNotNullParameter((Object)((Object)thisRef), (String)"thisRef");
        Intrinsics.checkNotNullParameter(property, (String)"property");
        String string = this.name;
        if (string == null) {
            string = property.getName();
        }
        return (T)this.getter.invoke((Object)string);
    }

    public void setValue(@NotNull BaseMonster thisRef, @NotNull KProperty<?> property, T value) {
        Intrinsics.checkNotNullParameter((Object)((Object)thisRef), (String)"thisRef");
        Intrinsics.checkNotNullParameter(property, (String)"property");
        String string = this.name;
        if (string == null) {
            string = property.getName();
        }
        this.setter.invoke((Object)string, value);
    }
}

