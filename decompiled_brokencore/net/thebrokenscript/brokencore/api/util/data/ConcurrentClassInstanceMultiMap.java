/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.ImmutableList
 *  com.google.common.collect.Iterators
 *  com.google.common.collect.UnmodifiableIterator
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.jvm.internal.TypeIntrinsics
 *  net.minecraft.util.ClassInstanceMultiMap
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.util.data;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterators;
import com.google.common.collect.UnmodifiableIterator;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.TypeIntrinsics;
import net.minecraft.util.ClassInstanceMultiMap;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000J\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u001e\n\u0002\b\u0003\n\u0002\u0010)\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0015\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00028\u0000H\u0016\u00a2\u0006\u0002\u0010\u0010J\u0015\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00028\u0000H\u0016\u00a2\u0006\u0002\u0010\u0010J\u0016\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00028\u0000H\u0096\u0002\u00a2\u0006\u0002\u0010\u0010J\"\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00160\u0015\"\u0004\b\u0001\u0010\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00160\u0004H\u0016J\u000f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u0019H\u0096\u0002J\u000e\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00000\u001bH\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R$\u0010\u0007\u001a\u0018\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\u00020\u001d8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001e\u0010\u001f\u00a8\u0006 "}, d2={"Lnet/thebrokenscript/brokencore/api/util/data/ConcurrentClassInstanceMultiMap;", "T", "Lnet/minecraft/util/ClassInstanceMultiMap;", "baseClass", "Ljava/lang/Class;", "<init>", "(Ljava/lang/Class;)V", "byClass", "Ljava/util/concurrent/ConcurrentMap;", "", "allInstances", "lock", "", "add", "", "value", "(Ljava/lang/Object;)Z", "remove", "key", "contains", "find", "", "S", "type", "iterator", "", "getAllInstances", "", "size", "", "getSize", "()I", "brokencore-common"})
@SourceDebugExtension(value={"SMAP\nConcurrentClassInstanceMultiMap.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ConcurrentClassInstanceMultiMap.kt\nnet/thebrokenscript/brokencore/api/util/data/ConcurrentClassInstanceMultiMap\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,83:1\n1#2:84\n865#3,2:85\n*S KotlinDebug\n*F\n+ 1 ConcurrentClassInstanceMultiMap.kt\nnet/thebrokenscript/brokencore/api/util/data/ConcurrentClassInstanceMultiMap\n*L\n65#1:85,2\n*E\n"})
public final class ConcurrentClassInstanceMultiMap<T>
extends ClassInstanceMultiMap<T> {
    @NotNull
    private final Class<T> baseClass;
    @NotNull
    private final ConcurrentMap<Class<?>, List<T>> byClass;
    @NotNull
    private final List<T> allInstances;
    @NotNull
    private final Object lock;

    public ConcurrentClassInstanceMultiMap(@NotNull Class<T> baseClass) {
        Intrinsics.checkNotNullParameter(baseClass, (String)"baseClass");
        super(baseClass);
        this.baseClass = baseClass;
        this.byClass = new ConcurrentHashMap();
        this.allInstances = new CopyOnWriteArrayList();
        this.lock = new Object();
        ((Map)this.byClass).put(this.baseClass, this.allInstances);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean add(T value) {
        boolean bl;
        Object object = this.lock;
        synchronized (object) {
            boolean bl2 = false;
            boolean flag = false;
            for (Map.Entry entry : this.byClass.entrySet()) {
                if (!((Class)entry.getKey()).isInstance(value)) continue;
                flag |= ((List)entry.getValue()).add(value);
            }
            bl = flag;
        }
        return bl;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean remove(Object key) {
        boolean bl;
        Object object = this.lock;
        synchronized (object) {
            boolean bl2 = false;
            boolean flag = false;
            for (Map.Entry entry : this.byClass.entrySet()) {
                if (!((Class)entry.getKey()).isInstance(key)) continue;
                flag |= ((List)entry.getValue()).remove(key);
            }
            bl = flag;
        }
        return bl;
    }

    public boolean contains(Object key) {
        boolean bl;
        Object object = key;
        if (object != null) {
            Object it = object;
            boolean bl2 = false;
            bl = this.find(it.getClass()).contains(key);
        } else {
            bl = false;
        }
        return bl;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * WARNING - void declaration
     */
    @NotNull
    public <S> Collection<S> find(@NotNull Class<S> type) {
        List list;
        Intrinsics.checkNotNullParameter(type, (String)"type");
        if (!(type.isInterface() || this.baseClass.isAssignableFrom(type))) {
            boolean bl = false;
            String string = "Don't know how to search for " + type;
            throw new IllegalArgumentException(string.toString());
        }
        List list2 = (List)this.byClass.get(type);
        if (list2 != null) {
            List it = list2;
            boolean bl = false;
            Collection collection = Collections.unmodifiableCollection(TypeIntrinsics.asMutableList((Object)it));
            Intrinsics.checkNotNullExpressionValue(collection, (String)"unmodifiableCollection(...)");
            return collection;
        }
        Object object = this.lock;
        synchronized (object) {
            List list3;
            boolean bl = false;
            List list4 = (List)this.byClass.get(type);
            if (list4 != null) {
                List it = list4;
                boolean bl2 = false;
                list3 = it;
            } else {
                void $this$filterTo$iv;
                List list5 = new CopyOnWriteArrayList();
                Iterable iterable = this.allInstances;
                Collection destination$iv = list5;
                boolean $i$f$filterTo = false;
                Iterator iterator = $this$filterTo$iv.iterator();
                while (iterator.hasNext()) {
                    Object element$iv;
                    Object p0 = element$iv = iterator.next();
                    boolean bl3 = false;
                    if (!type.isInstance(p0)) continue;
                    destination$iv.add(element$iv);
                }
                ((Map)this.byClass).put(type, list5);
                list3 = list5;
            }
            list = list3;
        }
        List list6 = list;
        Intrinsics.checkNotNull((Object)list6, (String)"null cannot be cast to non-null type kotlin.collections.MutableList<S of net.thebrokenscript.brokencore.api.util.data.ConcurrentClassInstanceMultiMap.find>");
        Collection collection = Collections.unmodifiableCollection(TypeIntrinsics.asMutableList((Object)list6));
        Intrinsics.checkNotNullExpressionValue(collection, (String)"unmodifiableCollection(...)");
        return collection;
    }

    @NotNull
    public Iterator<T> iterator() {
        Iterator iterator;
        if (this.allInstances.isEmpty()) {
            Iterator iterator2 = Collections.emptyIterator();
            iterator = iterator2;
            Intrinsics.checkNotNullExpressionValue(iterator2, (String)"emptyIterator(...)");
        } else {
            UnmodifiableIterator unmodifiableIterator = Iterators.unmodifiableIterator(this.allInstances.iterator());
            Intrinsics.checkNotNullExpressionValue((Object)unmodifiableIterator, (String)"unmodifiableIterator(...)");
            iterator = (Iterator)unmodifiableIterator;
        }
        return iterator;
    }

    @NotNull
    public List<T> getAllInstances() {
        ImmutableList immutableList = ImmutableList.copyOf((Collection)this.allInstances);
        Intrinsics.checkNotNullExpressionValue((Object)immutableList, (String)"copyOf(...)");
        return (List)immutableList;
    }

    public int getSize() {
        return this.allInstances.size();
    }
}

