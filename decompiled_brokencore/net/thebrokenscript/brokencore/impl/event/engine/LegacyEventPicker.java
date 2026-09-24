/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Deprecated
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.math.MathKt
 *  net.minecraft.ChatFormatting
 *  net.minecraft.core.Registry
 *  net.minecraft.network.chat.Component
 *  net.minecraft.network.chat.MutableComponent
 *  net.minecraft.resources.ResourceKey
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.server.level.ServerPlayer
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.brokencore.impl.event.engine;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.math.MathKt;
import net.minecraft.ChatFormatting;
import net.minecraft.core.Registry;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.thebrokenscript.brokencore.api.engine.EngineControl;
import net.thebrokenscript.brokencore.api.engine.EventPicker;
import net.thebrokenscript.brokencore.api.event.RandomEvent;
import net.thebrokenscript.brokencore.impl.config.BCConfigs;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Deprecated(message="Use the StatisticsEventPicker instead.")
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\u0004\b\u0005\u0010\u0006J,\u0010\u0007\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\t\u0012\u0004\u0012\u00020\u0004\u0018\u00010\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2={"Lnet/thebrokenscript/brokencore/impl/event/engine/LegacyEventPicker;", "Lnet/thebrokenscript/brokencore/api/engine/EventPicker;", "registry", "Lnet/minecraft/core/Registry;", "Lnet/thebrokenscript/brokencore/api/event/RandomEvent;", "<init>", "(Lnet/minecraft/core/Registry;)V", "pickRandom", "", "Lnet/minecraft/resources/ResourceKey;", "level", "Lnet/minecraft/server/level/ServerLevel;", "player", "Lnet/minecraft/server/level/ServerPlayer;", "brokencore-common"})
@SourceDebugExtension(value={"SMAP\nLegacyEventPicker.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LegacyEventPicker.kt\nnet/thebrokenscript/brokencore/impl/event/engine/LegacyEventPicker\n+ 2 ComponentDSL.kt\nnet/thebrokenscript/brokencore/api/dsl/ComponentUtil\n*L\n1#1,88:1\n15#2:89\n47#2:90\n29#2:91\n24#2:92\n15#2:93\n49#2:94\n29#2:95\n24#2:96\n15#2:97\n44#2:98\n29#2:99\n24#2:100\n*S KotlinDebug\n*F\n+ 1 LegacyEventPicker.kt\nnet/thebrokenscript/brokencore/impl/event/engine/LegacyEventPicker\n*L\n68#1:89\n68#1:90\n68#1:91\n68#1:92\n75#1:93\n75#1:94\n75#1:95\n75#1:96\n83#1:97\n83#1:98\n83#1:99\n83#1:100\n*E\n"})
public final class LegacyEventPicker
implements EventPicker {
    @NotNull
    private final Registry<RandomEvent> registry;

    public LegacyEventPicker(@NotNull Registry<RandomEvent> registry) {
        Intrinsics.checkNotNullParameter(registry, (String)"registry");
        this.registry = registry;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    @Nullable
    public Map.Entry<ResourceKey<RandomEvent>, RandomEvent> pickRandom(@NotNull ServerLevel level, @NotNull ServerPlayer player) {
        boolean $i$f$mut;
        void $this$mut$iv$iv$iv;
        boolean $i$f$with;
        boolean $i$f$getC;
        Object $this$c$iv;
        Map.Entry item2;
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)player, (String)"player");
        if (level.random.nextFloat() > EngineControl.INSTANCE.globalEventWeight(level)) {
            return null;
        }
        Set entries2 = this.registry.entrySet();
        if (entries2.isEmpty()) {
            return null;
        }
        List weightedEntries = new ArrayList();
        for (Map.Entry entry : entries2) {
            int n = MathKt.roundToInt((float)((RandomEvent)entry.getValue()).getWeight());
            int n2 = 0;
            while (n2 < n) {
                int it = n2++;
                boolean bl = false;
                Intrinsics.checkNotNull((Object)entry);
                weightedEntries.add(entry);
            }
        }
        Map.Entry entry = item2 = weightedEntries.isEmpty() ? null : (Map.Entry)CollectionsKt.getOrNull((List)weightedEntries, (int)level.random.nextInt(weightedEntries.size()));
        if (item2 != null) {
            if (BCConfigs.INSTANCE.getServer().getEvents().getEventDebug()) {
                void $this$with$iv$iv;
                void $this$green$iv;
                $this$c$iv = "Trying to execute event " + ((ResourceKey)item2.getKey()).location().getPath();
                $i$f$getC = false;
                Component component = Component.nullToEmpty((String)$this$c$iv);
                Intrinsics.checkNotNullExpressionValue((Object)component, (String)"nullToEmpty(...)");
                $this$c$iv = component;
                boolean $i$f$getGreen = false;
                void var8_9 = $this$green$iv;
                ChatFormatting other$iv$iv = ChatFormatting.GREEN;
                $i$f$with = false;
                $this$mut$iv$iv$iv = $this$with$iv$iv;
                $i$f$mut = false;
                MutableComponent mutableComponent = $this$mut$iv$iv$iv instanceof MutableComponent ? (MutableComponent)$this$mut$iv$iv$iv : null;
                if (mutableComponent == null) {
                    MutableComponent mutableComponent2 = $this$mut$iv$iv$iv.copy();
                    mutableComponent = mutableComponent2;
                    Intrinsics.checkNotNullExpressionValue((Object)mutableComponent2, (String)"copy(...)");
                }
                MutableComponent mutableComponent3 = mutableComponent.withStyle(other$iv$iv);
                Intrinsics.checkNotNullExpressionValue((Object)mutableComponent3, (String)"withStyle(...)");
                player.sendSystemMessage((Component)mutableComponent3);
            }
            if (!RandomEvent.canExecute$default((RandomEvent)item2.getValue(), level, player, null, 4, null)) {
                if (BCConfigs.INSTANCE.getServer().getEvents().getEventDebug()) {
                    void $this$red$iv;
                    $this$c$iv = "event failed";
                    $i$f$getC = false;
                    Component component = Component.nullToEmpty((String)$this$c$iv);
                    Intrinsics.checkNotNullExpressionValue((Object)component, (String)"nullToEmpty(...)");
                    $this$c$iv = component;
                    boolean $i$f$getRed = false;
                    void $this$with$iv$iv = $this$red$iv;
                    ChatFormatting other$iv$iv = ChatFormatting.RED;
                    $i$f$with = false;
                    $this$mut$iv$iv$iv = $this$with$iv$iv;
                    $i$f$mut = false;
                    MutableComponent mutableComponent = $this$mut$iv$iv$iv instanceof MutableComponent ? (MutableComponent)$this$mut$iv$iv$iv : null;
                    if (mutableComponent == null) {
                        MutableComponent mutableComponent4 = $this$mut$iv$iv$iv.copy();
                        mutableComponent = mutableComponent4;
                        Intrinsics.checkNotNullExpressionValue((Object)mutableComponent4, (String)"copy(...)");
                    }
                    MutableComponent mutableComponent5 = mutableComponent.withStyle(other$iv$iv);
                    Intrinsics.checkNotNullExpressionValue((Object)mutableComponent5, (String)"withStyle(...)");
                    player.sendSystemMessage((Component)mutableComponent5);
                }
                return null;
            }
        }
        if (BCConfigs.INSTANCE.getServer().getEvents().getEventDebug()) {
            void $this$gray$iv;
            $this$c$iv = "event executed";
            $i$f$getC = false;
            Component component = Component.nullToEmpty((String)$this$c$iv);
            Intrinsics.checkNotNullExpressionValue((Object)component, (String)"nullToEmpty(...)");
            $this$c$iv = component;
            boolean $i$f$getGray = false;
            void $this$with$iv$iv = $this$gray$iv;
            ChatFormatting other$iv$iv = ChatFormatting.GRAY;
            $i$f$with = false;
            $this$mut$iv$iv$iv = $this$with$iv$iv;
            $i$f$mut = false;
            MutableComponent mutableComponent = $this$mut$iv$iv$iv instanceof MutableComponent ? (MutableComponent)$this$mut$iv$iv$iv : null;
            if (mutableComponent == null) {
                MutableComponent mutableComponent6 = $this$mut$iv$iv$iv.copy();
                mutableComponent = mutableComponent6;
                Intrinsics.checkNotNullExpressionValue((Object)mutableComponent6, (String)"copy(...)");
            }
            MutableComponent mutableComponent7 = mutableComponent.withStyle(other$iv$iv);
            Intrinsics.checkNotNullExpressionValue((Object)mutableComponent7, (String)"withStyle(...)");
            player.sendSystemMessage((Component)mutableComponent7);
        }
        return item2;
    }
}

