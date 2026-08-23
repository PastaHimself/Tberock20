/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.properties.ReadWriteProperty
 *  kotlin.reflect.KProperty
 *  net.minecraft.network.syncher.EntityDataAccessor
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.dsl;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.thebrokenscript.brokencore.api.entity.base.BaseMonster;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000*\u0004\b\u0000\u0010\u00012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u0002H\u00010\u0002B\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J\"\u0010\b\u001a\u00028\u00002\u0006\u0010\t\u001a\u00020\u00032\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u000bH\u0096\u0002\u00a2\u0006\u0002\u0010\fJ*\u0010\r\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\u00032\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u000b2\u0006\u0010\u000f\u001a\u00028\u0000H\u0096\u0002\u00a2\u0006\u0002\u0010\u0010R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2={"Lnet/thebrokenscript/brokencore/api/dsl/EntityDataDelegate;", "T", "Lkotlin/properties/ReadWriteProperty;", "Lnet/thebrokenscript/brokencore/api/entity/base/BaseMonster;", "acc", "Lnet/minecraft/network/syncher/EntityDataAccessor;", "<init>", "(Lnet/minecraft/network/syncher/EntityDataAccessor;)V", "getValue", "thisRef", "property", "Lkotlin/reflect/KProperty;", "(Lnet/thebrokenscript/brokencore/api/entity/base/BaseMonster;Lkotlin/reflect/KProperty;)Ljava/lang/Object;", "setValue", "", "value", "(Lnet/thebrokenscript/brokencore/api/entity/base/BaseMonster;Lkotlin/reflect/KProperty;Ljava/lang/Object;)V", "brokencore-common"})
public final class EntityDataDelegate<T>
implements ReadWriteProperty<BaseMonster, T> {
    @NotNull
    private final EntityDataAccessor<T> acc;

    public EntityDataDelegate(@NotNull EntityDataAccessor<T> acc) {
        Intrinsics.checkNotNullParameter(acc, (String)"acc");
        this.acc = acc;
    }

    public T getValue(@NotNull BaseMonster thisRef, @NotNull KProperty<?> property) {
        Intrinsics.checkNotNullParameter((Object)((Object)thisRef), (String)"thisRef");
        Intrinsics.checkNotNullParameter(property, (String)"property");
        return (T)thisRef.getEntityData().get(this.acc);
    }

    public void setValue(@NotNull BaseMonster thisRef, @NotNull KProperty<?> property, T value) {
        Intrinsics.checkNotNullParameter((Object)((Object)thisRef), (String)"thisRef");
        Intrinsics.checkNotNullParameter(property, (String)"property");
        thisRef.getEntityData().set(this.acc, value);
    }
}

