/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.TuplesKt
 *  kotlin.collections.MapsKt
 *  kotlin.collections.SetsKt
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.jvm.internal.TypeIntrinsics
 *  kotlin.jvm.internal.markers.KMutableMap
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.brokencore.api.cutscene;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.jvm.internal.markers.KMutableMap;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010#\n\u0002\b\u0003\n\u0002\u0010\u001f\n\u0002\b\u0003\n\u0002\u0010'\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\u0018\u0000 12\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u00011B\u0007\u00a2\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u001eJ\u001a\u0010\u001f\u001a\u0004\u0018\u00010\u00032\u0006\u0010 \u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0003H\u0016J\u001e\u0010!\u001a\u00020\"2\u0014\u0010#\u001a\u0010\u0012\u0006\b\u0001\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u001eH\u0016J\u0010\u0010$\u001a\u00020\u001c2\u0006\u0010%\u001a\u00020\u0002H\u0016J\u0010\u0010&\u001a\u00020\u001c2\u0006\u0010\n\u001a\u00020\u0003H\u0016J\u000e\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0000J\u000e\u0010'\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0003J\u001b\u0010(\u001a\u0004\u0018\u00010\u00032\u0006\u0010 \u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0003H\u0086\u0002J\u0013\u0010)\u001a\u0004\u0018\u00010\u00032\u0006\u0010 \u001a\u00020\u0002H\u0096\u0002J\u0012\u0010*\u001a\u0004\u0018\u00010\u00032\u0006\u0010 \u001a\u00020\u0002H\u0016J\b\u0010+\u001a\u00020\"H\u0016J\u0015\u0010,\u001a\u0004\u0018\u00010\u00022\u0006\u0010\n\u001a\u00020\u0003\u00a2\u0006\u0002\u0010-J8\u0010.\u001a,\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010/\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010/\u0018\u00010/2\u0006\u0010 \u001a\u000200R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0002@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u00028VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\rR\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\u00118VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00030\u00158VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R&\u0010\u0018\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00190\u00118VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001a\u0010\u0013\u00a8\u00062"}, d2={"Lnet/thebrokenscript/brokencore/api/cutscene/Timeline;", "", "", "Ljava/util/UUID;", "<init>", "()V", "map", "reverseMap", "times", "Ljava/util/TreeSet;", "value", "duration", "getDuration", "()I", "size", "getSize", "keys", "", "getKeys", "()Ljava/util/Set;", "values", "", "getValues", "()Ljava/util/Collection;", "entries", "", "getEntries", "isEmpty", "", "serialize", "", "put", "time", "putAll", "", "from", "containsKey", "key", "containsValue", "append", "set", "get", "remove", "clear", "getKey", "(Ljava/util/UUID;)Ljava/lang/Integer;", "getPair", "Lkotlin/Pair;", "", "Companion", "brokencore-common"})
@SourceDebugExtension(value={"SMAP\nTimelineMap.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TimelineMap.kt\nnet/thebrokenscript/brokencore/api/cutscene/Timeline\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,115:1\n1#2:116\n*E\n"})
public final class Timeline
implements Map<Integer, UUID>,
KMutableMap {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private Map<Integer, UUID> map = new LinkedHashMap();
    @NotNull
    private Map<UUID, Integer> reverseMap = new LinkedHashMap();
    @NotNull
    private TreeSet<Integer> times = SetsKt.sortedSetOf((Object[])new Integer[0]);
    private int duration;

    public final int getDuration() {
        return this.duration;
    }

    public int getSize() {
        return this.map.size();
    }

    @NotNull
    public Set<Integer> getKeys() {
        return this.map.keySet();
    }

    @NotNull
    public Collection<UUID> getValues() {
        return this.map.values();
    }

    @NotNull
    public Set<Map.Entry<Integer, UUID>> getEntries() {
        return this.map.entrySet();
    }

    @Override
    public boolean isEmpty() {
        return this.map.isEmpty();
    }

    @NotNull
    public final Map<Integer, UUID> serialize() {
        return MapsKt.toMap(this.map);
    }

    @Override
    @Nullable
    public UUID put(int time2, @NotNull UUID value) {
        Intrinsics.checkNotNullParameter((Object)value, (String)"value");
        return this.set(time2, value);
    }

    @Override
    public void putAll(@NotNull Map<? extends Integer, ? extends UUID> from) {
        Intrinsics.checkNotNullParameter(from, (String)"from");
        for (Map.Entry<? extends Integer, ? extends UUID> entry : from.entrySet()) {
            int k = ((Number)entry.getKey()).intValue();
            UUID v = entry.getValue();
            this.put(k, v);
        }
    }

    public boolean containsKey(int key) {
        return this.map.containsKey(key);
    }

    public boolean containsValue(@NotNull UUID value) {
        Intrinsics.checkNotNullParameter((Object)value, (String)"value");
        return this.map.containsValue(value);
    }

    public final void putAll(@NotNull Timeline from) {
        Intrinsics.checkNotNullParameter((Object)from, (String)"from");
        this.putAll((Map<? extends Integer, ? extends UUID>)from.map);
    }

    public final int append(@NotNull UUID value) {
        Intrinsics.checkNotNullParameter((Object)value, (String)"value");
        int time2 = this.duration + 1;
        this.set(time2, value);
        return time2;
    }

    @Nullable
    public final UUID set(int time2, @NotNull UUID value) {
        Intrinsics.checkNotNullParameter((Object)value, (String)"value");
        UUID prev = this.map.get(time2);
        this.map.put(time2, value);
        this.reverseMap.put(value, time2);
        this.times.add(time2);
        Object e = this.times.getLast();
        Intrinsics.checkNotNullExpressionValue(e, (String)"getLast(...)");
        this.duration = ((Number)e).intValue();
        return prev;
    }

    @Nullable
    public UUID get(int time2) {
        return this.map.get(time2);
    }

    @Nullable
    public UUID remove(int time2) {
        int n;
        this.times.remove(time2);
        if (!((Collection)this.times).isEmpty()) {
            Object e = this.times.getLast();
            Intrinsics.checkNotNullExpressionValue(e, (String)"getLast(...)");
            n = ((Number)e).intValue();
        } else {
            n = 0;
        }
        this.duration = n;
        UUID uUID = this.map.remove(time2);
        Map<UUID, Integer> map = this.reverseMap;
        UUID p0 = uUID;
        boolean bl = false;
        TypeIntrinsics.asMutableMap(map).remove(p0);
        return uUID;
    }

    @Override
    public void clear() {
        this.times.clear();
        this.duration = 0;
        this.map.clear();
        this.reverseMap.clear();
    }

    @Nullable
    public final Integer getKey(@NotNull UUID value) {
        Intrinsics.checkNotNullParameter((Object)value, (String)"value");
        return this.reverseMap.get(value);
    }

    @Nullable
    public final Pair<Pair<Integer, UUID>, Pair<Integer, UUID>> getPair(float time2) {
        Pair pair;
        Pair pair2;
        UUID it;
        if (time2 > (float)this.duration) {
            return null;
        }
        UUID before = null;
        UUID after = null;
        int beforeIdx = 0;
        beforeIdx = -1;
        int afterIdx = 0;
        afterIdx = -1;
        Iterator<Integer> iterator = this.times.iterator();
        Intrinsics.checkNotNullExpressionValue(iterator, (String)"iterator(...)");
        Iterator<Integer> iterator2 = iterator;
        while (iterator2.hasNext()) {
            Integer n = iterator2.next();
            Intrinsics.checkNotNullExpressionValue((Object)n, (String)"next(...)");
            int key = ((Number)n).intValue();
            if ((float)key <= time2) {
                beforeIdx = key;
                continue;
            }
            afterIdx = key;
            break;
        }
        if (beforeIdx != -1) {
            before = this.map.get(beforeIdx);
        }
        if (afterIdx != -1) {
            after = this.map.get(afterIdx);
        }
        UUID uUID = before;
        if (uUID != null) {
            it = uUID;
            boolean bl = false;
            pair2 = TuplesKt.to((Object)beforeIdx, (Object)it);
        } else {
            pair2 = null;
        }
        UUID uUID2 = after;
        if (uUID2 != null) {
            it = uUID2;
            Pair pair3 = pair2;
            boolean bl = false;
            pair = TuplesKt.to((Object)afterIdx, (Object)it);
            pair2 = pair3;
        } else {
            pair = null;
        }
        return TuplesKt.to((Object)pair2, pair);
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007\u00a8\u0006\n"}, d2={"Lnet/thebrokenscript/brokencore/api/cutscene/Timeline$Companion;", "", "<init>", "()V", "deserialize", "Lnet/thebrokenscript/brokencore/api/cutscene/Timeline;", "map", "", "", "Ljava/util/UUID;", "brokencore-common"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final Timeline deserialize(@NotNull Map<Integer, UUID> map) {
            Timeline timeline;
            Intrinsics.checkNotNullParameter(map, (String)"map");
            Timeline $this$deserialize_u24lambda_u240 = timeline = new Timeline();
            boolean bl = false;
            for (Map.Entry<Integer, UUID> entry : map.entrySet()) {
                int k = ((Number)entry.getKey()).intValue();
                UUID v = entry.getValue();
                $this$deserialize_u24lambda_u240.set(k, v);
            }
            return timeline;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

