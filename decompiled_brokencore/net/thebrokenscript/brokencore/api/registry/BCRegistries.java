/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.core.Registry
 *  net.minecraft.resources.ResourceKey
 *  net.minecraft.resources.ResourceLocation
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.registry;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.thebrokenscript.brokencore.api.entity.SpawnConditions;
import net.thebrokenscript.brokencore.api.event.RandomEvent;
import net.thebrokenscript.brokencore.api.event.StoryEvent;
import net.thebrokenscript.brokencore.api.platform.PlatformRegistries;
import net.thebrokenscript.brokencore.api.responses.ChatResponse;
import net.thebrokenscript.brokencore.impl.BrokenCore;
import net.thebrokenscript.brokencore.impl.ForceRuntimeInit;
import org.jetbrains.annotations.NotNull;

@ForceRuntimeInit
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\t0\u00068\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00068\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\r0\u00068\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2={"Lnet/thebrokenscript/brokencore/api/registry/BCRegistries;", "", "<init>", "()V", "EVENTS_KEY", "Lnet/minecraft/resources/ResourceKey;", "Lnet/minecraft/core/Registry;", "Lnet/thebrokenscript/brokencore/api/event/RandomEvent;", "CHAT_RESPONSE_KEY", "Lnet/thebrokenscript/brokencore/api/responses/ChatResponse;", "SPAWN_CONDITIONS_KEY", "Lnet/thebrokenscript/brokencore/api/entity/SpawnConditions;", "STORY_EVENTS_KEY", "Lnet/thebrokenscript/brokencore/api/event/StoryEvent;", "EVENT", "CHAT_RESPONSE", "SPAWN_CONDITIONS", "STORY_EVENTS", "brokencore-common"})
public final class BCRegistries {
    @NotNull
    public static final BCRegistries INSTANCE = new BCRegistries();
    @JvmField
    @NotNull
    public static final ResourceKey<Registry<RandomEvent>> EVENTS_KEY;
    @JvmField
    @NotNull
    public static final ResourceKey<Registry<ChatResponse>> CHAT_RESPONSE_KEY;
    @JvmField
    @NotNull
    public static final ResourceKey<Registry<SpawnConditions>> SPAWN_CONDITIONS_KEY;
    @JvmField
    @NotNull
    public static final ResourceKey<Registry<StoryEvent>> STORY_EVENTS_KEY;
    @JvmField
    @NotNull
    public static final Registry<RandomEvent> EVENT;
    @JvmField
    @NotNull
    public static final Registry<ChatResponse> CHAT_RESPONSE;
    @JvmField
    @NotNull
    public static final Registry<SpawnConditions> SPAWN_CONDITIONS;
    @JvmField
    @NotNull
    public static final Registry<StoryEvent> STORY_EVENTS;

    private BCRegistries() {
    }

    static {
        ResourceKey resourceKey = ResourceKey.createRegistryKey((ResourceLocation)BrokenCore.id("events"));
        Intrinsics.checkNotNullExpressionValue((Object)resourceKey, (String)"createRegistryKey(...)");
        EVENTS_KEY = resourceKey;
        ResourceKey resourceKey2 = ResourceKey.createRegistryKey((ResourceLocation)BrokenCore.id("chat_responses"));
        Intrinsics.checkNotNullExpressionValue((Object)resourceKey2, (String)"createRegistryKey(...)");
        CHAT_RESPONSE_KEY = resourceKey2;
        ResourceKey resourceKey3 = ResourceKey.createRegistryKey((ResourceLocation)BrokenCore.id("spawn_conditions"));
        Intrinsics.checkNotNullExpressionValue((Object)resourceKey3, (String)"createRegistryKey(...)");
        SPAWN_CONDITIONS_KEY = resourceKey3;
        ResourceKey resourceKey4 = ResourceKey.createRegistryKey((ResourceLocation)BrokenCore.id("story_events"));
        Intrinsics.checkNotNullExpressionValue((Object)resourceKey4, (String)"createRegistryKey(...)");
        STORY_EVENTS_KEY = resourceKey4;
        EVENT = PlatformRegistries.Companion.getINSTANCE().createSyncedRegistry(EVENTS_KEY);
        CHAT_RESPONSE = PlatformRegistries.Companion.getINSTANCE().createSyncedRegistry(CHAT_RESPONSE_KEY);
        SPAWN_CONDITIONS = PlatformRegistries.Companion.getINSTANCE().createSyncedRegistry(SPAWN_CONDITIONS_KEY);
        STORY_EVENTS = PlatformRegistries.Companion.getINSTANCE().createSyncedRegistry(STORY_EVENTS_KEY);
    }
}

