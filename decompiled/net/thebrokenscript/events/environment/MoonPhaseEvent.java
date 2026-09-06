/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.ChatFormatting
 *  net.minecraft.network.chat.Component
 *  net.minecraft.network.chat.MutableComponent
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.server.level.ServerPlayer
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.phys.Vec3
 *  net.thebrokenscript.brokencore.impl.config.BCConfigs
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.events.environment;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.api.event.NullEvent;
import net.thebrokenscript.api.ext.LevelExt;
import net.thebrokenscript.brokencore.impl.config.BCConfigs;
import net.thebrokenscript.data.MapVariables;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J \u0010\f\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0014\u00a8\u0006\u000e"}, d2={"Lnet/thebrokenscript/events/environment/MoonPhaseEvent;", "Lnet/thebrokenscript/api/event/NullEvent;", "<init>", "()V", "canExecute", "", "level", "Lnet/minecraft/server/level/ServerLevel;", "player", "Lnet/minecraft/server/level/ServerPlayer;", "pos", "Lnet/minecraft/world/phys/Vec3;", "execute", "", "thebrokenscript-common"})
@SourceDebugExtension(value={"SMAP\nMoonPhaseEvent.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MoonPhaseEvent.kt\nnet/thebrokenscript/events/environment/MoonPhaseEvent\n+ 2 ComponentDSL.kt\nnet/thebrokenscript/brokencore/api/dsl/ComponentUtil\n*L\n1#1,47:1\n15#2:48\n49#2:49\n29#2:50\n24#2:51\n15#2:52\n15#2:53\n15#2:54\n15#2:55\n*S KotlinDebug\n*F\n+ 1 MoonPhaseEvent.kt\nnet/thebrokenscript/events/environment/MoonPhaseEvent\n*L\n22#1:48\n22#1:49\n22#1:50\n22#1:51\n24#1:52\n27#1:53\n30#1:54\n33#1:55\n*E\n"})
public final class MoonPhaseEvent
extends NullEvent {
    public MoonPhaseEvent() {
        super(5);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public boolean canExecute(@NotNull ServerLevel level, @NotNull ServerPlayer player, @NotNull Vec3 pos) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)player, (String)"player");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        boolean phase = level.getMoonPhase() + 1 == 1;
        boolean canExecute = super.canExecute(level, player, pos);
        boolean isDay = level.isDay();
        boolean shouldChange = LevelExt.INSTANCE.getVars((LevelAccessor)level).getMoonShouldChange();
        if (!(!BCConfigs.INSTANCE.getServer().getEvents().getEventDebug() || canExecute && isDay && shouldChange)) {
            void $this$with$iv$iv;
            void $this$red$iv;
            String $this$c$iv = "Moon Corruption failed, Reasons:";
            boolean $i$f$getC = false;
            Component component = Component.nullToEmpty((String)$this$c$iv);
            Intrinsics.checkNotNullExpressionValue((Object)component, (String)"nullToEmpty(...)");
            $this$c$iv = component;
            boolean $i$f$getRed = false;
            void var10_10 = $this$red$iv;
            ChatFormatting other$iv$iv = ChatFormatting.RED;
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
            player.sendSystemMessage((Component)mutableComponent3);
            if (!canExecute) {
                $this$c$iv = "canExecute: false (null might not be in game yet or player isn't in survival.)";
                $i$f$getC = false;
                Component component2 = Component.nullToEmpty((String)$this$c$iv);
                Intrinsics.checkNotNullExpressionValue((Object)component2, (String)"nullToEmpty(...)");
                player.sendSystemMessage(component2);
            }
            if (!isDay) {
                $this$c$iv = "isDay: false (it needs to be day for moon corruption to start)";
                $i$f$getC = false;
                Component component3 = Component.nullToEmpty((String)$this$c$iv);
                Intrinsics.checkNotNullExpressionValue((Object)component3, (String)"nullToEmpty(...)");
                player.sendSystemMessage(component3);
            }
            if (!shouldChange) {
                $this$c$iv = "shouldChange: false (it hasn't passed 8 phases since last moon corruption.)";
                $i$f$getC = false;
                Component component4 = Component.nullToEmpty((String)$this$c$iv);
                Intrinsics.checkNotNullExpressionValue((Object)component4, (String)"nullToEmpty(...)");
                player.sendSystemMessage(component4);
            }
            if (!phase) {
                $this$c$iv = "phase: false (it's not first moon phase)";
                $i$f$getC = false;
                Component component5 = Component.nullToEmpty((String)$this$c$iv);
                Intrinsics.checkNotNullExpressionValue((Object)component5, (String)"nullToEmpty(...)");
                player.sendSystemMessage(component5);
            }
        }
        return canExecute && isDay && shouldChange && phase;
    }

    protected void execute(@NotNull ServerLevel level, @NotNull ServerPlayer player, @NotNull Vec3 pos) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)player, (String)"player");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        LevelExt.INSTANCE.updateVars((LevelAccessor)level, (Function1<? super MapVariables, Unit>)((Function1)MoonPhaseEvent::execute$lambda$0));
    }

    private static final Unit execute$lambda$0(MapVariables $this$updateVars) {
        Intrinsics.checkNotNullParameter((Object)((Object)$this$updateVars), (String)"$this$updateVars");
        $this$updateVars.setMoonStage($this$updateVars.getMoonStage() >= 2 ? 0 : $this$updateVars.getMoonStage() + 1);
        $this$updateVars.setMoonShouldChange(false);
        return Unit.INSTANCE;
    }
}

