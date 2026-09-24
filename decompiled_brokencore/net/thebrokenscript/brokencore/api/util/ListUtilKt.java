/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.TuplesKt
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=2, xi=48, d1={"\u0000$\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001c\n\u0000\u001aD\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032'\u0010\u0004\u001a#\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\u0005\u00a2\u0006\u0002\u0010\n\u001a?\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u000b2'\u0010\u0004\u001a#\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\u0005\u00a8\u0006\f"}, d2={"allIndexed", "", "T", "", "predicate", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "index", "([Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Z", "", "brokencore-common"})
@SourceDebugExtension(value={"SMAP\nListUtil.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ListUtil.kt\nnet/thebrokenscript/brokencore/api/util/ListUtilKt\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,8:1\n11651#2:9\n11762#2,4:10\n1740#3,3:14\n1573#3:17\n1604#3,4:18\n1740#3,3:22\n*S KotlinDebug\n*F\n+ 1 ListUtil.kt\nnet/thebrokenscript/brokencore/api/util/ListUtilKt\n*L\n4#1:9\n4#1:10,4\n4#1:14,3\n7#1:17\n7#1:18,4\n7#1:22,3\n*E\n"})
public final class ListUtilKt {
    /*
     * WARNING - void declaration
     */
    public static final <T> boolean allIndexed(@NotNull T[] $this$allIndexed, @NotNull Function2<? super Integer, ? super T, Boolean> predicate) {
        boolean bl;
        block4: {
            void $this$mapIndexedTo$iv$iv;
            Intrinsics.checkNotNullParameter($this$allIndexed, (String)"<this>");
            Intrinsics.checkNotNullParameter(predicate, (String)"predicate");
            T[] $this$mapIndexed$iv = $this$allIndexed;
            boolean $i$f$mapIndexed = false;
            T[] TArray = $this$mapIndexed$iv;
            Collection destination$iv$iv = new ArrayList($this$mapIndexed$iv.length);
            boolean $i$f$mapIndexedTo = false;
            int index$iv$iv = 0;
            for (void item$iv$iv : $this$mapIndexedTo$iv$iv) {
                void v;
                void i;
                int n = index$iv$iv++;
                void var11_13 = item$iv$iv;
                int n2 = n;
                Collection collection = destination$iv$iv;
                boolean bl2 = false;
                collection.add(TuplesKt.to((Object)((int)i), (Object)v));
            }
            Iterable $this$all$iv = (List)destination$iv$iv;
            boolean $i$f$all = false;
            if ($this$all$iv instanceof Collection && ((Collection)$this$all$iv).isEmpty()) {
                bl = true;
            } else {
                for (Object element$iv : $this$all$iv) {
                    Pair pair = (Pair)element$iv;
                    boolean bl3 = false;
                    int i = ((Number)pair.component1()).intValue();
                    Object v = pair.component2();
                    if (((Boolean)predicate.invoke((Object)i, v)).booleanValue()) continue;
                    bl = false;
                    break block4;
                }
                bl = true;
            }
        }
        return bl;
    }

    /*
     * WARNING - void declaration
     */
    public static final <T> boolean allIndexed(@NotNull Iterable<? extends T> $this$allIndexed, @NotNull Function2<? super Integer, ? super T, Boolean> predicate) {
        boolean bl;
        block5: {
            void $this$mapIndexedTo$iv$iv;
            Intrinsics.checkNotNullParameter($this$allIndexed, (String)"<this>");
            Intrinsics.checkNotNullParameter(predicate, (String)"predicate");
            Iterable<? extends T> $this$mapIndexed$iv = $this$allIndexed;
            boolean $i$f$mapIndexed = false;
            Iterable<? extends T> iterable = $this$mapIndexed$iv;
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$mapIndexed$iv, (int)10));
            boolean $i$f$mapIndexedTo = false;
            int index$iv$iv = 0;
            for (Object item$iv$iv : $this$mapIndexedTo$iv$iv) {
                void v;
                void i;
                int n;
                if ((n = index$iv$iv++) < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                Object t = item$iv$iv;
                int n2 = n;
                Collection collection = destination$iv$iv;
                boolean bl2 = false;
                collection.add(TuplesKt.to((Object)((int)i), (Object)v));
            }
            Iterable $this$all$iv = (List)destination$iv$iv;
            boolean $i$f$all = false;
            if ($this$all$iv instanceof Collection && ((Collection)$this$all$iv).isEmpty()) {
                bl = true;
            } else {
                for (Object element$iv : $this$all$iv) {
                    Pair pair = (Pair)element$iv;
                    boolean bl3 = false;
                    int i = ((Number)pair.component1()).intValue();
                    Object v = pair.component2();
                    if (((Boolean)predicate.invoke((Object)i, v)).booleanValue()) continue;
                    bl = false;
                    break block5;
                }
                bl = true;
            }
        }
        return bl;
    }
}

