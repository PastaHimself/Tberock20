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
package net.thebrokenscript.brokencore.api.util.data;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import net.thebrokenscript.brokencore.api.util.data.DefaultedMap;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0005\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0003B\u001b\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\f\u001a\u0004\u0018\u00018\u00012\u0006\u0010\r\u001a\u00028\u00002\u0006\u0010\u000e\u001a\u00028\u0001H\u0016\u00a2\u0006\u0002\u0010\u000fJ\u001e\u0010\u0010\u001a\u00020\u00112\u0014\u0010\u0012\u001a\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0011H\u0016J\u0017\u0010\u0015\u001a\u0004\u0018\u00018\u00012\u0006\u0010\r\u001a\u00028\u0000H\u0016\u00a2\u0006\u0002\u0010\u0016J\u0006\u0010\u0017\u001a\u00020\tR\u000e\u0010\b\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\t8F\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u0018"}, d2={"Lnet/thebrokenscript/brokencore/api/util/data/DirtyDefaultedMap;", "T", "E", "Lnet/thebrokenscript/brokencore/api/util/data/DefaultedMap;", "default", "Lkotlin/Function1;", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "dirty", "", "isDirty", "()Z", "put", "key", "value", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "putAll", "", "from", "", "clear", "remove", "(Ljava/lang/Object;)Ljava/lang/Object;", "checkDirty", "brokencore-common"})
public final class DirtyDefaultedMap<T, E>
extends DefaultedMap<T, E> {
    private boolean dirty;

    public DirtyDefaultedMap(@NotNull Function1<? super T, ? extends E> function1) {
        Intrinsics.checkNotNullParameter(function1, (String)"default");
        super(function1);
    }

    public final boolean isDirty() {
        return this.dirty;
    }

    @Override
    @Nullable
    public E put(T key, E value) {
        if (this.containsKey(key) && !Intrinsics.areEqual(this.get(key), value)) {
            this.dirty = true;
        }
        return super.put(key, value);
    }

    @Override
    public void putAll(@NotNull Map<? extends T, ? extends E> from) {
        Intrinsics.checkNotNullParameter(from, (String)"from");
        for (Map.Entry<T, E> entry : from.entrySet()) {
            T k = entry.getKey();
            E v = entry.getValue();
            if (Intrinsics.areEqual(this.get(k), v)) continue;
            this.dirty = true;
            break;
        }
        super.putAll(from);
    }

    @Override
    public void clear() {
        if (!((Map)this).isEmpty()) {
            this.dirty = true;
        }
        super.clear();
    }

    @Override
    @Nullable
    public E remove(Object key) {
        if (this.containsKey(key)) {
            this.dirty = true;
        }
        return super.remove(key);
    }

    public final boolean checkDirty() {
        boolean prev = this.dirty;
        this.dirty = false;
        return prev;
    }
}

