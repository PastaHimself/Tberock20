/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.util;

import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\u0018\u00002\u00020\u0001BM\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00126\u0010\u0005\u001a\u001c\u0012\u0018\b\u0001\u0012\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00070\u0006\"\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\u0006\u0010\r\u001a\u00020\u0004R\u001a\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2={"Lnet/thebrokenscript/brokencore/api/util/Schedule;", "", "onUnscheduled", "Lkotlin/Function0;", "", "schedule", "", "Lkotlin/Pair;", "", "<init>", "(Lkotlin/jvm/functions/Function0;[Lkotlin/Pair;)V", "", "index", "call", "brokencore-common"})
@SourceDebugExtension(value={"SMAP\nSchedule.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Schedule.kt\nnet/thebrokenscript/brokencore/api/util/Schedule\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n+ 4 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,21:1\n1#2:22\n37#3,2:23\n13805#4,2:25\n*S KotlinDebug\n*F\n+ 1 Schedule.kt\nnet/thebrokenscript/brokencore/api/util/Schedule\n*L\n7#1:23,2\n8#1:25,2\n*E\n"})
public final class Schedule {
    @NotNull
    private final List<Function0<Unit>> schedule;
    private int index;

    /*
     * WARNING - void declaration
     */
    public Schedule(@NotNull Function0<Unit> onUnscheduled, Pair<Integer, ? extends Function0<Unit>> ... schedule) {
        void $this$schedule_u24lambda_u240;
        void $this$toTypedArray$iv;
        Collection collection;
        List list;
        Intrinsics.checkNotNullParameter(onUnscheduled, (String)"onUnscheduled");
        Intrinsics.checkNotNullParameter(schedule, (String)"schedule");
        List list2 = list = CollectionsKt.createListBuilder();
        Schedule schedule2 = this;
        boolean bl = false;
        List $this$schedule_u24lambda_u240_u240 = collection = CollectionsKt.createListBuilder();
        boolean bl2 = false;
        $this$schedule_u24lambda_u240_u240.add(onUnscheduled);
        collection = CollectionsKt.build((List)collection);
        boolean $i$f$toTypedArray = false;
        void thisCollection$iv = $this$toTypedArray$iv;
        Object[] array = thisCollection$iv.toArray(new Function0[0]);
        Pair<Integer, ? extends Function0<Unit>>[] $this$forEach$iv = schedule;
        boolean $i$f$forEach = false;
        int n = $this$forEach$iv.length;
        for (int i = 0; i < n; ++i) {
            Pair<Integer, ? extends Function0<Unit>> element$iv;
            Pair<Integer, ? extends Function0<Unit>> it = element$iv = $this$forEach$iv[i];
            boolean bl3 = false;
            array[((Number)it.getFirst()).intValue()] = it.getSecond();
        }
        CollectionsKt.addAll((Collection)((Collection)$this$schedule_u24lambda_u240), (Object[])array);
        schedule2.schedule = CollectionsKt.build((List)list);
    }

    public final void call() {
        this.schedule.get(this.index);
        this.index = (this.index + 1) % this.schedule.size();
    }
}

