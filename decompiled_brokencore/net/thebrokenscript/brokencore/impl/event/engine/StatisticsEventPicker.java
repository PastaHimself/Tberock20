/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.core.Registry
 *  net.minecraft.resources.ResourceKey
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.server.level.ServerPlayer
 *  net.minecraft.world.level.storage.DimensionDataStorage
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.brokencore.impl.event.engine;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.storage.DimensionDataStorage;
import net.thebrokenscript.brokencore.api.engine.EngineControl;
import net.thebrokenscript.brokencore.api.event.RandomEvent;
import net.thebrokenscript.brokencore.impl.config.BCConfigs;
import net.thebrokenscript.brokencore.impl.config.EventsConfig;
import net.thebrokenscript.brokencore.impl.event.engine.EventWeightTracker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\u0004\b\u0005\u0010\u0006J,\u0010\u0007\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\t\u0012\u0004\u0012\u00020\u0004\u0018\u00010\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002J2\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00112\u0018\u0010\u0012\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\t\u0012\u0004\u0012\u00020\u00040\bH\u0002J,\u0010\u0013\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\t\u0012\u0004\u0012\u00020\u0004\u0018\u00010\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J*\u0010\u0014\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\t\u0012\u0004\u0012\u00020\u0004\u0018\u00010\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0011R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2={"Lnet/thebrokenscript/brokencore/impl/event/engine/StatisticsEventPicker;", "", "registry", "Lnet/minecraft/core/Registry;", "Lnet/thebrokenscript/brokencore/api/event/RandomEvent;", "<init>", "(Lnet/minecraft/core/Registry;)V", "random", "", "Lnet/minecraft/resources/ResourceKey;", "tracker", "Lnet/thebrokenscript/brokencore/impl/event/engine/EventWeightTracker;", "level", "Lnet/minecraft/server/level/ServerLevel;", "isValid", "", "player", "Lnet/minecraft/server/level/ServerPlayer;", "event", "pick", "pickRandom", "brokencore-common"})
@SourceDebugExtension(value={"SMAP\nStatisticsEventPicker.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StatisticsEventPicker.kt\nnet/thebrokenscript/brokencore/impl/event/engine/StatisticsEventPicker\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,68:1\n774#2:69\n865#2,2:70\n*S KotlinDebug\n*F\n+ 1 StatisticsEventPicker.kt\nnet/thebrokenscript/brokencore/impl/event/engine/StatisticsEventPicker\n*L\n24#1:69\n24#1:70,2\n*E\n"})
public final class StatisticsEventPicker {
    @NotNull
    private final Registry<RandomEvent> registry;

    public StatisticsEventPicker(@NotNull Registry<RandomEvent> registry) {
        Intrinsics.checkNotNullParameter(registry, (String)"registry");
        this.registry = registry;
    }

    /*
     * WARNING - void declaration
     */
    private final Map.Entry<ResourceKey<RandomEvent>, RandomEvent> random(EventWeightTracker tracker, ServerLevel level) {
        void $this$filterTo$iv$iv;
        Set set = this.registry.entrySet();
        Intrinsics.checkNotNullExpressionValue((Object)set, (String)"entrySet(...)");
        Iterable $this$filter$iv = set;
        boolean $i$f$filter = false;
        Iterable iterable = $this$filter$iv;
        Collection destination$iv$iv = new ArrayList();
        boolean $i$f$filterTo = false;
        for (Object element$iv$iv : $this$filterTo$iv$iv) {
            Map.Entry it = (Map.Entry)element$iv$iv;
            boolean bl = false;
            EventsConfig eventsConfig = BCConfigs.INSTANCE.getServer().getEvents();
            Object k = it.getKey();
            Intrinsics.checkNotNullExpressionValue(k, (String)"<get-key>(...)");
            if (!eventsConfig.isEnabled((ResourceKey<RandomEvent>)((ResourceKey)k))) continue;
            destination$iv$iv.add(element$iv$iv);
        }
        List events = (List)destination$iv$iv;
        if (events.isEmpty()) {
            return null;
        }
        float total = tracker.totalWeight(events);
        float num = total > 0.0f ? level.random.nextFloat() * total : level.random.nextFloat() * (float)events.size();
        for (Map.Entry entry : events) {
            float f;
            if (total > 0.0f) {
                Intrinsics.checkNotNull((Object)entry);
                f = tracker.getWeight(entry);
            } else {
                f = 1.0f;
            }
            if (!((num -= f) <= 0.0f)) continue;
            return entry;
        }
        return (Map.Entry)CollectionsKt.lastOrNull((List)events);
    }

    private final boolean isValid(ServerLevel level, ServerPlayer player, Map.Entry<? extends ResourceKey<RandomEvent>, ? extends RandomEvent> event) {
        return RandomEvent.canExecute$default(event.getValue(), level, player, null, 4, null);
    }

    private final Map.Entry<ResourceKey<RandomEvent>, RandomEvent> pick(ServerLevel level, ServerPlayer player) {
        DimensionDataStorage storage = level.getServer().overworld().getDataStorage();
        EventWeightTracker tracker = (EventWeightTracker)storage.computeIfAbsent(EventWeightTracker.FACTORY, "brokencore_event_weights");
        boolean reroll = BCConfigs.INSTANCE.getServer().getEvents().getRerollEvents();
        Intrinsics.checkNotNull((Object)((Object)tracker));
        Map.Entry<ResourceKey<RandomEvent>, RandomEvent> entry = this.random(tracker, level);
        if (entry == null) {
            return null;
        }
        Map.Entry<ResourceKey<RandomEvent>, RandomEvent> event = entry;
        int attempts = 0;
        while (!this.isValid(level, player, event)) {
            if (!reroll || attempts++ > this.registry.size()) {
                return null;
            }
            if (this.random(tracker, level) != null) continue;
            return null;
        }
        tracker.incWeight(event);
        return event;
    }

    @Nullable
    public final Map.Entry<ResourceKey<RandomEvent>, RandomEvent> pickRandom(@NotNull ServerLevel level, @NotNull ServerPlayer player) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)player, (String)"player");
        if (level.random.nextFloat() > EngineControl.INSTANCE.globalEventWeight(level)) {
            return null;
        }
        return this.pick(level, player);
    }
}

