/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.JvmOverloads
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.core.HolderLookup$Provider
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.resources.ResourceKey
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.world.level.saveddata.SavedData
 *  net.minecraft.world.level.saveddata.SavedData$Factory
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.impl.event.engine;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.saveddata.SavedData;
import net.thebrokenscript.brokencore.api.event.RandomEvent;
import net.thebrokenscript.brokencore.api.ext.TagExt;
import net.thebrokenscript.brokencore.api.registry.BCRegistries;
import net.thebrokenscript.brokencore.api.util.data.DefaultedMap;
import net.thebrokenscript.brokencore.api.util.data.DirtyDefaultedMap;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010&\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB%\b\u0007\u0012\u001a\b\u0002\u0010\u0002\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0004\u0012\u00020\u00060\u0003\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0016\u0010\r\u001a\u00020\u00062\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002J\u001e\u0010\u000f\u001a\u00020\u000b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0010\u001a\u00020\u0005H\u0002J \u0010\u0011\u001a\u00020\u000b2\u0018\u0010\u0010\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0004\u0012\u00020\u00050\u0012J&\u0010\u0013\u001a\u00020\u000b2\u001e\u0010\u0014\u001a\u001a\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0004\u0012\u00020\u00050\u00120\u0015J \u0010\u0016\u001a\u00020\u00172\u0018\u0010\u0010\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0004\u0012\u00020\u00050\u0012J\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u001cH\u0016R \u0010\u0002\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0004\u0012\u00020\u00060\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R \u0010\t\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001e"}, d2={"Lnet/thebrokenscript/brokencore/impl/event/engine/EventWeightTracker;", "Lnet/minecraft/world/level/saveddata/SavedData;", "instWeights", "Lnet/thebrokenscript/brokencore/api/util/data/DefaultedMap;", "Lnet/minecraft/resources/ResourceKey;", "Lnet/thebrokenscript/brokencore/api/event/RandomEvent;", "", "<init>", "(Lnet/thebrokenscript/brokencore/api/util/data/DefaultedMap;)V", "weightCache", "Lnet/thebrokenscript/brokencore/api/util/data/DirtyDefaultedMap;", "", "totalWeightCache", "instWeight", "key", "cacheWeight", "event", "getWeight", "", "totalWeight", "events", "", "incWeight", "", "save", "Lnet/minecraft/nbt/CompoundTag;", "tag", "prov", "Lnet/minecraft/core/HolderLookup$Provider;", "Companion", "brokencore-common"})
public final class EventWeightTracker
extends SavedData {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final DefaultedMap<ResourceKey<RandomEvent>, Integer> instWeights;
    @NotNull
    private final DirtyDefaultedMap<ResourceKey<RandomEvent>, Float> weightCache;
    private float totalWeightCache;
    @JvmField
    @NotNull
    public static final SavedData.Factory<EventWeightTracker> FACTORY = new SavedData.Factory(() -> new EventWeightTracker(null, 1, null), (arg_0, arg_1) -> Companion.access$read(Companion, arg_0, arg_1), null);

    @JvmOverloads
    public EventWeightTracker(@NotNull DefaultedMap<ResourceKey<RandomEvent>, Integer> instWeights) {
        Intrinsics.checkNotNullParameter(instWeights, (String)"instWeights");
        this.instWeights = instWeights;
        this.weightCache = new DirtyDefaultedMap(EventWeightTracker::weightCache$lambda$0);
    }

    public /* synthetic */ EventWeightTracker(DefaultedMap defaultedMap, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 1) != 0) {
            defaultedMap = new DefaultedMap(EventWeightTracker::_init_$lambda$0);
        }
        this(defaultedMap);
    }

    private final int instWeight(ResourceKey<RandomEvent> key) {
        int n;
        int it = ((Number)this.instWeights.get(key)).intValue();
        boolean bl = false;
        if (it <= 0) {
            ((Map)this.instWeights).put(key, 1);
            this.setDirty();
            n = 1;
        } else {
            n = it;
        }
        return n;
    }

    private final float cacheWeight(ResourceKey<RandomEvent> key, RandomEvent event) {
        float f;
        float it = f = event.getWeight() * (1.0f / (float)this.instWeight(key));
        boolean bl = false;
        ((Map)this.weightCache).put(key, Float.valueOf(it));
        return f;
    }

    public final float getWeight(@NotNull Map.Entry<? extends ResourceKey<RandomEvent>, ? extends RandomEvent> event) {
        Intrinsics.checkNotNullParameter(event, (String)"event");
        Float f = (Float)this.weightCache.tryGet(event.getKey());
        return f != null ? f.floatValue() : this.cacheWeight(event.getKey(), event.getValue());
    }

    public final float totalWeight(@NotNull Collection<? extends Map.Entry<? extends ResourceKey<RandomEvent>, ? extends RandomEvent>> events) {
        ResourceKey<RandomEvent> k;
        Intrinsics.checkNotNullParameter(events, (String)"events");
        boolean needsCache = false;
        Iterator<? extends Map.Entry<? extends ResourceKey<RandomEvent>, ? extends RandomEvent>> iterator = events.iterator();
        while (iterator.hasNext()) {
            k = iterator.next().getKey();
            if (((Map)this.weightCache).containsKey(k)) continue;
            needsCache = true;
            break;
        }
        if (needsCache) {
            for (Map.Entry<? extends ResourceKey<RandomEvent>, ? extends RandomEvent> entry : events) {
                k = entry.getKey();
                RandomEvent v = entry.getValue();
                ((Map)this.weightCache).put(k, Float.valueOf(this.cacheWeight(k, v)));
            }
        }
        if (this.weightCache.checkDirty()) {
            this.totalWeightCache = CollectionsKt.sumOfFloat((Iterable)this.weightCache.values());
        }
        return this.totalWeightCache;
    }

    public final void incWeight(@NotNull Map.Entry<? extends ResourceKey<RandomEvent>, ? extends RandomEvent> event) {
        Intrinsics.checkNotNullParameter(event, (String)"event");
        DefaultedMap<ResourceKey<RandomEvent>, Integer> defaultedMap = this.instWeights;
        ResourceKey<RandomEvent> resourceKey = event.getKey();
        ((Map)defaultedMap).put(resourceKey, ((Number)defaultedMap.get(resourceKey)).intValue() + 1);
        this.cacheWeight(event.getKey(), event.getValue());
        this.setDirty();
    }

    @NotNull
    public CompoundTag save(@NotNull CompoundTag tag, @NotNull HolderLookup.Provider prov) {
        Intrinsics.checkNotNullParameter((Object)tag, (String)"tag");
        Intrinsics.checkNotNullParameter((Object)prov, (String)"prov");
        for (Map.Entry entry : ((Map)this.instWeights).entrySet()) {
            ResourceKey k = (ResourceKey)entry.getKey();
            int v = ((Number)entry.getValue()).intValue();
            tag.putInt(k.location().toString(), v);
        }
        return tag;
    }

    @JvmOverloads
    public EventWeightTracker() {
        this(null, 1, null);
    }

    private static final int _init_$lambda$0(ResourceKey it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        return 1;
    }

    private static final float weightCache$lambda$0(ResourceKey it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        return 0.0f;
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u0012\u0004\b\u0007\u0010\u0003\u00a8\u0006\r"}, d2={"Lnet/thebrokenscript/brokencore/impl/event/engine/EventWeightTracker$Companion;", "", "<init>", "()V", "FACTORY", "Lnet/minecraft/world/level/saveddata/SavedData$Factory;", "Lnet/thebrokenscript/brokencore/impl/event/engine/EventWeightTracker;", "getFACTORY$annotations", "read", "tag", "Lnet/minecraft/nbt/CompoundTag;", "prov", "Lnet/minecraft/core/HolderLookup$Provider;", "brokencore-common"})
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ void getFACTORY$annotations() {
        }

        private final EventWeightTracker read(CompoundTag tag, HolderLookup.Provider prov) {
            DefaultedMap<ResourceKey<RandomEvent>, Integer> instWeights = new DefaultedMap<ResourceKey<RandomEvent>, Integer>(Companion::read$lambda$0);
            for (String k : tag.getAllKeys()) {
                ResourceLocation loc;
                if (ResourceLocation.tryParse((String)k) == null) continue;
                ResourceKey key = ResourceKey.create(BCRegistries.EVENTS_KEY, (ResourceLocation)loc);
                Intrinsics.checkNotNull((Object)k);
                Integer n = TagExt.INSTANCE.getOptionalInt(tag, k);
                if (n == null) {
                    continue;
                }
                int value = n;
                ((Map)instWeights).put(key, value);
            }
            return new EventWeightTracker(instWeights);
        }

        private static final int read$lambda$0(ResourceKey it) {
            Intrinsics.checkNotNullParameter((Object)it, (String)"it");
            return 1;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        public static final /* synthetic */ EventWeightTracker access$read(Companion $this, CompoundTag tag, HolderLookup.Provider prov) {
            return $this.read(tag, prov);
        }
    }
}

