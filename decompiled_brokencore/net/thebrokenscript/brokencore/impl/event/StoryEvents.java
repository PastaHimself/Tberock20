/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.ImmutableCollection
 *  com.google.common.collect.ImmutableMultimap
 *  com.google.common.collect.ImmutableMultimap$Builder
 *  com.google.common.collect.UnmodifiableIterator
 *  kotlin.Metadata
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.server.MinecraftServer
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.world.level.GameRules
 *  net.minecraft.world.level.saveddata.SavedData
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.impl.event;

import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.UnmodifiableIterator;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.saveddata.SavedData;
import net.thebrokenscript.brokencore.api.event.StoryEvent;
import net.thebrokenscript.brokencore.api.registry.BCRegistries;
import net.thebrokenscript.brokencore.impl.event.StoryEventsData;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u000f\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b0\u0005J\u0006\u0010\u0011\u001a\u00020\u0006J\u0010\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0006H\u0007J\u000e\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u0016RN\u0010\u0004\u001aB\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u0006\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\b0\b \u0007* \u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u0006\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\b0\b\u0018\u00010\u00050\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2={"Lnet/thebrokenscript/brokencore/impl/event/StoryEvents;", "", "<init>", "()V", "events", "Lcom/google/common/collect/ImmutableMultimap;", "", "kotlin.jvm.PlatformType", "Lnet/thebrokenscript/brokencore/api/event/StoryEvent;", "data", "Lnet/thebrokenscript/brokencore/impl/event/StoryEventsData;", "serverStarting", "", "server", "Lnet/minecraft/server/MinecraftServer;", "tick", "getEvents", "getTime", "addSkippedTime", "ticks", "debugSync", "level", "Lnet/minecraft/server/level/ServerLevel;", "brokencore-common"})
public final class StoryEvents {
    @NotNull
    public static final StoryEvents INSTANCE = new StoryEvents();
    private static ImmutableMultimap<Long, StoryEvent> events = ImmutableMultimap.of();
    @NotNull
    private static StoryEventsData data = new StoryEventsData(0L, 1, null);

    private StoryEvents() {
    }

    public final void serverStarting(@NotNull MinecraftServer server) {
        Intrinsics.checkNotNullParameter((Object)server, (String)"server");
        ImmutableMultimap.Builder builder = ImmutableMultimap.builder();
        for (StoryEvent event : BCRegistries.STORY_EVENTS) {
            for (Number time2 : event.getTimes()) {
                builder.put((Object)time2.longValue(), (Object)event);
            }
        }
        SavedData savedData = server.overworld().getDataStorage().computeIfAbsent(StoryEventsData.FACTORY, "brokencore$storyEventsData");
        Intrinsics.checkNotNullExpressionValue((Object)savedData, (String)"computeIfAbsent(...)");
        data = (StoryEventsData)savedData;
        events = builder.build();
    }

    public final void tick(@NotNull MinecraftServer server) {
        Intrinsics.checkNotNullParameter((Object)server, (String)"server");
        if (!server.getGameRules().getBoolean(GameRules.RULE_DAYLIGHT)) {
            return;
        }
        if (server.getPlayerCount() > 0) {
            StoryEventsData storyEventsData = data;
            storyEventsData.setTime(storyEventsData.getTime() + 1L);
            data.setDirty();
        }
        ImmutableCollection available = events.get((Object)data.getTime());
        UnmodifiableIterator unmodifiableIterator = available.iterator();
        Intrinsics.checkNotNullExpressionValue((Object)unmodifiableIterator, (String)"iterator(...)");
        UnmodifiableIterator unmodifiableIterator2 = unmodifiableIterator;
        while (unmodifiableIterator2.hasNext()) {
            StoryEvent event = (StoryEvent)unmodifiableIterator2.next();
            if (!event.canExecute(server)) continue;
            event.run(server);
        }
    }

    @NotNull
    public final ImmutableMultimap<Long, StoryEvent> getEvents() {
        ImmutableMultimap<Long, StoryEvent> immutableMultimap = events;
        Intrinsics.checkNotNullExpressionValue(immutableMultimap, (String)"events");
        return immutableMultimap;
    }

    public final long getTime() {
        return data.getTime();
    }

    @JvmStatic
    public static final void addSkippedTime(long ticks) {
        StoryEventsData storyEventsData = data;
        storyEventsData.setTime(storyEventsData.getTime() + ticks);
        data.setDirty();
    }

    public final void debugSync(@NotNull ServerLevel level) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        data.setTime(level.getDayTime());
        data.setDirty();
    }
}

