/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.markers.KMutableMap
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.brokencore.api.util.data;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableMap;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000L\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\b\u0003\n\u0002\u0010\u001f\n\u0002\b\u0003\n\u0002\u0010'\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0003B\u001b\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\u0018\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0019\u001a\u00028\u00002\u0006\u0010\u001a\u001a\u00028\u0001H\u0016\u00a2\u0006\u0002\u0010\u001bJ\u0017\u0010\u001c\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0019\u001a\u00028\u0000H\u0016\u00a2\u0006\u0002\u0010\u001dJ\u001e\u0010\u001e\u001a\u00020\u001f2\u0014\u0010 \u001a\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010!H\u0016J\b\u0010\"\u001a\u00020\u001fH\u0016J\b\u0010#\u001a\u00020$H\u0016J\u0015\u0010%\u001a\u00020$2\u0006\u0010\u0019\u001a\u00028\u0000H\u0016\u00a2\u0006\u0002\u0010&J\u0015\u0010'\u001a\u00020$2\u0006\u0010\u001a\u001a\u00028\u0001H\u0016\u00a2\u0006\u0002\u0010&J\u0016\u0010(\u001a\u00028\u00012\u0006\u0010\u0019\u001a\u00028\u0000H\u0096\u0002\u00a2\u0006\u0002\u0010\u001dJ\u0015\u0010)\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0019\u001a\u00028\u0000\u00a2\u0006\u0002\u0010\u001dR\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\n8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00010\u00128VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R&\u0010\u0015\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00160\u000e8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0017\u0010\u0010\u00a8\u0006*"}, d2={"Lnet/thebrokenscript/brokencore/api/util/data/DefaultedMap;", "T", "E", "", "default", "Lkotlin/Function1;", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "inner", "size", "", "getSize", "()I", "keys", "", "getKeys", "()Ljava/util/Set;", "values", "", "getValues", "()Ljava/util/Collection;", "entries", "", "getEntries", "put", "key", "value", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "remove", "(Ljava/lang/Object;)Ljava/lang/Object;", "putAll", "", "from", "", "clear", "isEmpty", "", "containsKey", "(Ljava/lang/Object;)Z", "containsValue", "get", "tryGet", "brokencore-common"})
public class DefaultedMap<T, E>
implements Map<T, E>,
KMutableMap {
    @NotNull
    private final Function1<T, E> default;
    @NotNull
    private final Map<T, E> inner;

    public DefaultedMap(@NotNull Function1<? super T, ? extends E> function1) {
        Intrinsics.checkNotNullParameter(function1, (String)"default");
        this.default = function1;
        this.inner = new LinkedHashMap();
    }

    public int getSize() {
        return this.inner.size();
    }

    @NotNull
    public Set<T> getKeys() {
        return this.inner.keySet();
    }

    @NotNull
    public Collection<E> getValues() {
        return this.inner.values();
    }

    @NotNull
    public Set<Map.Entry<T, E>> getEntries() {
        return this.inner.entrySet();
    }

    @Override
    @Nullable
    public E put(T key, E value) {
        return this.inner.put(key, value);
    }

    @Override
    @Nullable
    public E remove(Object key) {
        return this.inner.remove(key);
    }

    @Override
    public void putAll(@NotNull Map<? extends T, ? extends E> from) {
        Intrinsics.checkNotNullParameter(from, (String)"from");
        this.inner.putAll(from);
    }

    @Override
    public void clear() {
        this.inner.clear();
    }

    @Override
    public boolean isEmpty() {
        return this.inner.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return this.inner.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return this.inner.containsValue(value);
    }

    @Override
    public E get(Object key) {
        if (!this.containsKey(key)) {
            ((Map)this).put(key, this.default.invoke(key));
        }
        E e = this.inner.get(key);
        Intrinsics.checkNotNull(e);
        return e;
    }

    @Nullable
    public final E tryGet(T key) {
        return this.inner.get(key);
    }
}

