/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.random.Random
 *  net.minecraft.ChatFormatting
 *  net.minecraft.network.chat.Component
 *  net.minecraft.network.chat.MutableComponent
 *  net.minecraft.resources.ResourceKey
 *  net.minecraft.server.MinecraftServer
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.server.level.ServerPlayer
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.brokencore.api.engine;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.random.Random;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.thebrokenscript.brokencore.api.engine.EngineControl;
import net.thebrokenscript.brokencore.api.event.RandomEvent;
import net.thebrokenscript.brokencore.api.registry.BCRegistries;
import net.thebrokenscript.brokencore.impl.config.BCConfigs;
import net.thebrokenscript.brokencore.impl.event.engine.StatisticsEventPicker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0006\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2={"Lnet/thebrokenscript/brokencore/api/engine/EventEngine;", "", "<init>", "()V", "executor", "Lnet/thebrokenscript/brokencore/impl/event/engine/StatisticsEventPicker;", "forceExecute", "", "Lnet/minecraft/resources/ResourceKey;", "Lnet/thebrokenscript/brokencore/api/event/RandomEvent;", "player", "Lnet/minecraft/server/level/ServerPlayer;", "tick", "", "server", "Lnet/minecraft/server/MinecraftServer;", "brokencore-common"})
@SourceDebugExtension(value={"SMAP\nEventEngine.kt\nKotlin\n*S Kotlin\n*F\n+ 1 EventEngine.kt\nnet/thebrokenscript/brokencore/api/engine/EventEngine\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 ComponentDSL.kt\nnet/thebrokenscript/brokencore/api/dsl/ComponentUtil\n*L\n1#1,68:1\n1#2:69\n15#3:70\n57#3:71\n29#3:72\n24#3:73\n44#3:74\n29#3:75\n24#3:76\n*S KotlinDebug\n*F\n+ 1 EventEngine.kt\nnet/thebrokenscript/brokencore/api/engine/EventEngine\n*L\n61#1:70\n61#1:71\n61#1:72\n61#1:73\n61#1:74\n61#1:75\n61#1:76\n*E\n"})
public final class EventEngine {
    @NotNull
    public static final EventEngine INSTANCE = new EventEngine();
    @NotNull
    private static final StatisticsEventPicker executor = new StatisticsEventPicker(BCRegistries.EVENT);

    private EventEngine() {
    }

    @Nullable
    public final Map.Entry<ResourceKey<RandomEvent>, RandomEvent> forceExecute(@NotNull ServerPlayer player) {
        Map.Entry<ResourceKey<RandomEvent>, RandomEvent> entry;
        Intrinsics.checkNotNullParameter((Object)player, (String)"player");
        ServerLevel serverLevel = player.serverLevel();
        Intrinsics.checkNotNullExpressionValue((Object)serverLevel, (String)"serverLevel(...)");
        Map.Entry<ResourceKey<RandomEvent>, RandomEvent> entry2 = executor.pickRandom(serverLevel, player);
        if (entry2 != null) {
            Map.Entry<ResourceKey<RandomEvent>, RandomEvent> entry3;
            Map.Entry<ResourceKey<RandomEvent>, RandomEvent> it = entry3 = entry2;
            boolean bl = false;
            ServerLevel serverLevel2 = player.serverLevel();
            Intrinsics.checkNotNullExpressionValue((Object)serverLevel2, (String)"serverLevel(...)");
            RandomEvent.run$default(it.getValue(), serverLevel2, player, null, 4, null);
            entry = entry3;
        } else {
            entry = null;
        }
        return entry;
    }

    /*
     * WARNING - void declaration
     */
    public final void tick(@NotNull MinecraftServer server) {
        Intrinsics.checkNotNullParameter((Object)server, (String)"server");
        if (!BCConfigs.INSTANCE.getServer().getEvents().getEnableRandomEvents()) {
            return;
        }
        if (server.getPlayerList().getPlayerCount() <= 0) {
            return;
        }
        List list = server.getPlayerList().getPlayers();
        Intrinsics.checkNotNullExpressionValue((Object)list, (String)"getPlayers(...)");
        ServerPlayer player = (ServerPlayer)CollectionsKt.random((Collection)list, (Random)((Random)Random.Default));
        ServerLevel level = player.serverLevel();
        Intrinsics.checkNotNull((Object)level);
        float freq = EngineControl.INSTANCE.eventFrequency(level);
        if (!EngineControl.INSTANCE.enableEvents(level) || freq <= 0.0f) {
            return;
        }
        float randomFloat = level.random.nextFloat();
        if (randomFloat < freq) {
            Intrinsics.checkNotNull((Object)player);
            Map.Entry<ResourceKey<RandomEvent>, RandomEvent> entry = executor.pickRandom(level, player);
            if (entry == null) {
                return;
            }
            Map.Entry<ResourceKey<RandomEvent>, RandomEvent> event = entry;
            if (BCConfigs.INSTANCE.getServer().getEvents().getEventDebug()) {
                void $this$gray$iv;
                void $this$with$iv$iv;
                Component $this$italic$iv;
                String $this$c$iv = "Trying to execute event " + event.getKey().location();
                boolean $i$f$getC = false;
                Component component = Component.nullToEmpty((String)$this$c$iv);
                Intrinsics.checkNotNullExpressionValue((Object)component, (String)"nullToEmpty(...)");
                $this$c$iv = component;
                boolean $i$f$getItalic = false;
                void var9_9 = $this$italic$iv;
                ChatFormatting other$iv$iv = ChatFormatting.ITALIC;
                boolean $i$f$with = false;
                void $this$mut$iv$iv$iv = $this$with$iv$iv;
                boolean $i$f$mut = false;
                MutableComponent mutableComponent = $this$mut$iv$iv$iv instanceof MutableComponent ? (MutableComponent)$this$mut$iv$iv$iv : null;
                if (mutableComponent == null) {
                    MutableComponent mutableComponent2 = $this$mut$iv$iv$iv.copy();
                    mutableComponent = mutableComponent2;
                    Intrinsics.checkNotNullExpressionValue((Object)mutableComponent2, (String)"copy(...)");
                }
                MutableComponent mutableComponent3 = mutableComponent.withStyle(other$iv$iv);
                Intrinsics.checkNotNullExpressionValue((Object)mutableComponent3, (String)"withStyle(...)");
                $this$italic$iv = (Component)mutableComponent3;
                boolean $i$f$getGray = false;
                $this$with$iv$iv = $this$gray$iv;
                other$iv$iv = ChatFormatting.GRAY;
                $i$f$with = false;
                $this$mut$iv$iv$iv = $this$with$iv$iv;
                $i$f$mut = false;
                MutableComponent mutableComponent4 = $this$mut$iv$iv$iv instanceof MutableComponent ? (MutableComponent)$this$mut$iv$iv$iv : null;
                if (mutableComponent4 == null) {
                    MutableComponent mutableComponent5 = $this$mut$iv$iv$iv.copy();
                    mutableComponent4 = mutableComponent5;
                    Intrinsics.checkNotNullExpressionValue((Object)mutableComponent5, (String)"copy(...)");
                }
                MutableComponent mutableComponent6 = mutableComponent4.withStyle(other$iv$iv);
                Intrinsics.checkNotNullExpressionValue((Object)mutableComponent6, (String)"withStyle(...)");
                player.sendSystemMessage((Component)mutableComponent6);
            }
            RandomEvent.run$default(event.getValue(), level, player, null, 4, null);
        }
    }
}

