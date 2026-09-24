/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.brigadier.arguments.ArgumentType
 *  com.mojang.brigadier.context.CommandContext
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.jvm.optionals.OptionalsKt
 *  net.minecraft.ChatFormatting
 *  net.minecraft.commands.CommandSourceStack
 *  net.minecraft.commands.arguments.EntityArgument
 *  net.minecraft.commands.arguments.ResourceLocationArgument
 *  net.minecraft.network.chat.Component
 *  net.minecraft.network.chat.MutableComponent
 *  net.minecraft.resources.ResourceKey
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.server.level.ServerPlayer
 *  net.minecraft.world.phys.Vec3
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.impl.commands;

import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.context.CommandContext;
import java.util.Collection;
import java.util.Map;
import java.util.Optional;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.optionals.OptionalsKt;
import net.minecraft.ChatFormatting;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.commands.arguments.ResourceLocationArgument;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.brokencore.api.commands.CommandDSL;
import net.thebrokenscript.brokencore.api.commands.SuggestingArgument;
import net.thebrokenscript.brokencore.api.dsl.CommandCxUtil;
import net.thebrokenscript.brokencore.api.engine.EventEngine;
import net.thebrokenscript.brokencore.api.event.RandomEvent;
import net.thebrokenscript.brokencore.api.event.StoryEvent;
import net.thebrokenscript.brokencore.api.platform.PlatformUtil;
import net.thebrokenscript.brokencore.api.registry.BCRegistries;
import net.thebrokenscript.brokencore.impl.commands.EventSuggestionProvider;
import net.thebrokenscript.brokencore.impl.config.BCConfigs;
import net.thebrokenscript.brokencore.impl.event.StoryEvents;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u0005*\b\u0012\u0004\u0012\u00020\u00070\u0006\u00a8\u0006\b"}, d2={"Lnet/thebrokenscript/brokencore/impl/commands/EventCommands;", "", "<init>", "()V", "addEventCommands", "", "Lnet/thebrokenscript/brokencore/api/commands/CommandDSL;", "Lnet/minecraft/commands/CommandSourceStack;", "brokencore-common"})
@SourceDebugExtension(value={"SMAP\nEventCommands.kt\nKotlin\n*S Kotlin\n*F\n+ 1 EventCommands.kt\nnet/thebrokenscript/brokencore/impl/commands/EventCommands\n+ 2 ComponentDSL.kt\nnet/thebrokenscript/brokencore/api/dsl/ComponentUtil\n*L\n1#1,123:1\n15#2:124\n140#2:125\n94#2:126\n71#2:127\n48#2:128\n29#2:129\n24#2:130\n19#2,6:131\n18#2:137\n15#2:138\n71#2:139\n48#2:140\n29#2:141\n24#2:142\n19#2,6:143\n18#2:149\n15#2:150\n69#2:151\n46#2:152\n29#2:153\n24#2:154\n19#2,6:155\n18#2:161\n*S KotlinDebug\n*F\n+ 1 EventCommands.kt\nnet/thebrokenscript/brokencore/impl/commands/EventCommands\n*L\n72#1:124\n72#1:125\n72#1:126\n72#1:127\n72#1:128\n72#1:129\n72#1:130\n72#1:131,6\n72#1:137\n100#1:138\n100#1:139\n100#1:140\n100#1:141\n100#1:142\n100#1:143,6\n100#1:149\n116#1:150\n116#1:151\n116#1:152\n116#1:153\n116#1:154\n116#1:155,6\n116#1:161\n*E\n"})
public final class EventCommands {
    @NotNull
    public static final EventCommands INSTANCE = new EventCommands();

    private EventCommands() {
    }

    public final void addEventCommands(@NotNull CommandDSL<CommandSourceStack> $this$addEventCommands) {
        Intrinsics.checkNotNullParameter($this$addEventCommands, (String)"<this>");
        $this$addEventCommands.group("event", EventCommands::addEventCommands$lambda$0);
    }

    private static final void addEventCommands$lambda$0(CommandDSL $this$group) {
        Intrinsics.checkNotNullParameter((Object)$this$group, (String)"$this$group");
        $this$group.group("debug", EventCommands::addEventCommands$lambda$0$0);
        $this$group.add("random", EventCommands::addEventCommands$lambda$0$1);
        ArgumentType[] argumentTypeArray = new ArgumentType[1];
        ResourceLocationArgument resourceLocationArgument = ResourceLocationArgument.id();
        Intrinsics.checkNotNullExpressionValue((Object)resourceLocationArgument, (String)"id(...)");
        argumentTypeArray[0] = new SuggestingArgument((ArgumentType)resourceLocationArgument, new EventSuggestionProvider());
        $this$group.add("force [event]", argumentTypeArray, EventCommands::addEventCommands$lambda$0$2);
        argumentTypeArray = new ArgumentType[1];
        Intrinsics.checkNotNullExpressionValue((Object)EntityArgument.players(), (String)"players(...)");
        $this$group.add("all [players]", argumentTypeArray, EventCommands::addEventCommands$lambda$0$3);
    }

    private static final void addEventCommands$lambda$0$0(CommandDSL $this$group) {
        Intrinsics.checkNotNullParameter((Object)$this$group, (String)"$this$group");
        $this$group.add("story_time", EventCommands::addEventCommands$lambda$0$0$0);
        if (!PlatformUtil.Companion.isProduction()) {
            $this$group.add("sync_story_time", EventCommands::addEventCommands$lambda$0$0$1);
        }
    }

    private static final int addEventCommands$lambda$0$0$0(CommandContext it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        if (!BCConfigs.INSTANCE.getServer().getEvents().getEventDebug()) {
            CommandCxUtil.fail$default(it, "Cannot view, Event debug is off", false, 2, null);
            return 0;
        }
        CommandCxUtil.success$default(it, "Story Event Current Time: \n\n " + StoryEvents.INSTANCE.getTime() / (long)24000 + " day/s, " + StoryEvents.INSTANCE.getTime() + " total ticks", false, 2, null);
        CommandCxUtil.success$default(it, "Minecraft Day Time: \n\n " + ((CommandSourceStack)it.getSource()).getLevel().getDayTime() / (long)24000 + " day/s, " + ((CommandSourceStack)it.getSource()).getLevel().getDayTime() + " total ticks \n", false, 2, null);
        boolean sync = ((CommandSourceStack)it.getSource()).getLevel().getDayTime() == StoryEvents.INSTANCE.getTime();
        CommandCxUtil.success$default(it, "Synchronized? " + sync, false, 2, null);
        if (!sync) {
            CommandCxUtil.send((CommandContext<CommandSourceStack>)it, "reason could be player used time set command or could be older world");
        }
        CommandCxUtil.send((CommandContext<CommandSourceStack>)it, "Story Events and when they should execute (day):");
        StoryEvents.INSTANCE.getEvents().forEach((arg_0, arg_1) -> EventCommands.addEventCommands$lambda$0$0$0$1((arg_0, arg_1) -> EventCommands.addEventCommands$lambda$0$0$0$0(sync, it, arg_0, arg_1), arg_0, arg_1));
        return 0;
    }

    private static final Unit addEventCommands$lambda$0$0$0$0(boolean $sync, CommandContext $it, Long time2, StoryEvent event) {
        if ($sync) {
            CommandCxUtil.send((CommandContext<CommandSourceStack>)$it, "Event: " + event.getEventName() + ", Execution Day: " + time2 / (long)24000);
        } else {
            long mcTime = ((CommandSourceStack)$it.getSource()).getLevel().getDayTime();
            long storyTime = StoryEvents.INSTANCE.getTime();
            long offset = mcTime - storyTime;
            long adjustedExec = time2 + offset;
            CommandCxUtil.send((CommandContext<CommandSourceStack>)$it, "Event: " + event.getEventName() + ", Adjusted Execution Day: " + adjustedExec / (long)24000);
        }
        return Unit.INSTANCE;
    }

    private static final void addEventCommands$lambda$0$0$0$1(Function2 $tmp0, Object p0, Object p1) {
        $tmp0.invoke(p0, p1);
    }

    private static final int addEventCommands$lambda$0$0$1(CommandContext it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        ServerLevel serverLevel = ((CommandSourceStack)it.getSource()).getLevel();
        Intrinsics.checkNotNullExpressionValue((Object)serverLevel, (String)"getLevel(...)");
        StoryEvents.INSTANCE.debugSync(serverLevel);
        return 0;
    }

    /*
     * WARNING - void declaration
     */
    private static final int addEventCommands$lambda$0$1(CommandContext it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        ServerPlayer serverPlayer = ((CommandSourceStack)it.getSource()).getPlayerOrException();
        Intrinsics.checkNotNullExpressionValue((Object)serverPlayer, (String)"getPlayerOrException(...)");
        Map.Entry<ResourceKey<RandomEvent>, RandomEvent> ev = EventEngine.INSTANCE.forceExecute(serverPlayer);
        if (ev != null) {
            MutableComponent $this$plus$iv;
            void $this$with$iv$iv$iv$iv$iv;
            void $this$aqua$iv$iv$iv$iv;
            String $this$c$iv = "Triggered event ";
            boolean $i$f$getC = false;
            Component component = Component.nullToEmpty((String)$this$c$iv);
            Intrinsics.checkNotNullExpressionValue((Object)component, (String)"nullToEmpty(...)");
            $this$c$iv = component;
            ResourceKey<RandomEvent> $this$aqua$iv = ev.getKey();
            boolean $i$f$getAqua = false;
            ResourceLocation resourceLocation = $this$aqua$iv.location();
            Intrinsics.checkNotNullExpressionValue((Object)resourceLocation, (String)"location(...)");
            ResourceLocation $this$aqua$iv$iv = resourceLocation;
            boolean $i$f$getAqua2 = false;
            String string = $this$aqua$iv$iv.toString();
            Intrinsics.checkNotNullExpressionValue((Object)string, (String)"toString(...)");
            String $this$aqua$iv$iv$iv = string;
            boolean $i$f$getAqua3 = false;
            String $this$c$iv$iv$iv$iv = $this$aqua$iv$iv$iv;
            boolean $i$f$getC2 = false;
            Component component2 = Component.nullToEmpty((String)$this$c$iv$iv$iv$iv);
            Intrinsics.checkNotNullExpressionValue((Object)component2, (String)"nullToEmpty(...)");
            $this$c$iv$iv$iv$iv = component2;
            boolean $i$f$getAqua4 = false;
            void var11_12 = $this$aqua$iv$iv$iv$iv;
            ChatFormatting other$iv$iv$iv$iv$iv = ChatFormatting.AQUA;
            boolean $i$f$with = false;
            void $this$mut$iv$iv$iv$iv$iv$iv = $this$with$iv$iv$iv$iv$iv;
            boolean $i$f$mut = false;
            MutableComponent mutableComponent = $this$mut$iv$iv$iv$iv$iv$iv instanceof MutableComponent ? (MutableComponent)$this$mut$iv$iv$iv$iv$iv$iv : null;
            if (mutableComponent == null) {
                MutableComponent mutableComponent2 = $this$mut$iv$iv$iv$iv$iv$iv.copy();
                mutableComponent = mutableComponent2;
                Intrinsics.checkNotNullExpressionValue((Object)mutableComponent2, (String)"copy(...)");
            }
            MutableComponent mutableComponent3 = mutableComponent.withStyle(other$iv$iv$iv$iv$iv);
            Intrinsics.checkNotNullExpressionValue((Object)mutableComponent3, (String)"withStyle(...)");
            Component other$iv = (Component)mutableComponent3;
            boolean $i$f$plus = false;
            void $this$mut$iv$iv = $this$plus$iv;
            boolean $i$f$mut2 = false;
            MutableComponent mutableComponent4 = $this$mut$iv$iv instanceof MutableComponent ? (MutableComponent)$this$mut$iv$iv : null;
            if (mutableComponent4 == null) {
                MutableComponent mutableComponent5 = $this$mut$iv$iv.copy();
                mutableComponent4 = mutableComponent5;
                Intrinsics.checkNotNullExpressionValue((Object)mutableComponent5, (String)"copy(...)");
            }
            MutableComponent mutableComponent6 = mutableComponent4.append(other$iv);
            Intrinsics.checkNotNullExpressionValue((Object)mutableComponent6, (String)"append(...)");
            $this$plus$iv = mutableComponent6;
            String $this$c$iv2 = "!";
            boolean $i$f$getC3 = false;
            Component component3 = Component.nullToEmpty((String)$this$c$iv2);
            Intrinsics.checkNotNullExpressionValue((Object)component3, (String)"nullToEmpty(...)");
            other$iv = component3;
            $i$f$plus = false;
            MutableComponent mutableComponent7 = $this$plus$iv.append(other$iv);
            Intrinsics.checkNotNullExpressionValue((Object)mutableComponent7, (String)"append(...)");
            CommandCxUtil.success$default(it, (Component)mutableComponent7, false, 2, null);
        } else {
            CommandCxUtil.success$default(it, "No event triggered (picked nothing)!", false, 2, null);
        }
        return 0;
    }

    /*
     * WARNING - void declaration
     */
    private static final int addEventCommands$lambda$0$2(CommandContext it) {
        void other$iv;
        MutableComponent $this$plus$iv;
        void $this$with$iv$iv$iv;
        void $this$aqua$iv$iv;
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        ServerPlayer entity = ((CommandSourceStack)it.getSource()).getPlayer();
        if (entity == null) {
            CommandCxUtil.fail$default(it, "This command must only be executed by a player!", false, 2, null);
            return 0;
        }
        ResourceLocation id = ResourceLocationArgument.getId((CommandContext)it, (String)"event");
        Optional optional = BCRegistries.EVENT.getOptional(id);
        Intrinsics.checkNotNullExpressionValue((Object)optional, (String)"getOptional(...)");
        RandomEvent item2 = (RandomEvent)OptionalsKt.getOrNull((Optional)optional);
        if (item2 == null) {
            CommandCxUtil.fail$default(it, "Could not find event with id: " + id, false, 2, null);
            return 0;
        }
        String $this$c$iv = "Triggering event ";
        boolean $i$f$getC = false;
        Component component = Component.nullToEmpty((String)$this$c$iv);
        Intrinsics.checkNotNullExpressionValue((Object)component, (String)"nullToEmpty(...)");
        $this$c$iv = component;
        String string = id.toString();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"toString(...)");
        String $this$aqua$iv = string;
        boolean $i$f$getAqua = false;
        String $this$c$iv$iv = $this$aqua$iv;
        boolean $i$f$getC2 = false;
        Component component2 = Component.nullToEmpty((String)$this$c$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)component2, (String)"nullToEmpty(...)");
        $this$c$iv$iv = component2;
        boolean $i$f$getAqua2 = false;
        void var9_10 = $this$aqua$iv$iv;
        ChatFormatting other$iv$iv$iv = ChatFormatting.AQUA;
        boolean $i$f$with = false;
        void $this$mut$iv$iv$iv$iv = $this$with$iv$iv$iv;
        boolean $i$f$mut = false;
        MutableComponent mutableComponent = $this$mut$iv$iv$iv$iv instanceof MutableComponent ? (MutableComponent)$this$mut$iv$iv$iv$iv : null;
        if (mutableComponent == null) {
            MutableComponent mutableComponent2 = $this$mut$iv$iv$iv$iv.copy();
            mutableComponent = mutableComponent2;
            Intrinsics.checkNotNullExpressionValue((Object)mutableComponent2, (String)"copy(...)");
        }
        MutableComponent mutableComponent3 = mutableComponent.withStyle(other$iv$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)mutableComponent3, (String)"withStyle(...)");
        $this$aqua$iv = (Component)mutableComponent3;
        boolean $i$f$plus = false;
        void $this$mut$iv$iv = $this$plus$iv;
        boolean $i$f$mut2 = false;
        MutableComponent mutableComponent4 = $this$mut$iv$iv instanceof MutableComponent ? (MutableComponent)$this$mut$iv$iv : null;
        if (mutableComponent4 == null) {
            MutableComponent mutableComponent5 = $this$mut$iv$iv.copy();
            mutableComponent4 = mutableComponent5;
            Intrinsics.checkNotNullExpressionValue((Object)mutableComponent5, (String)"copy(...)");
        }
        MutableComponent mutableComponent6 = mutableComponent4.append((Component)other$iv);
        Intrinsics.checkNotNullExpressionValue((Object)mutableComponent6, (String)"append(...)");
        $this$plus$iv = mutableComponent6;
        String $this$c$iv2 = "...";
        boolean $i$f$getC3 = false;
        Component component3 = Component.nullToEmpty((String)$this$c$iv2);
        Intrinsics.checkNotNullExpressionValue((Object)component3, (String)"nullToEmpty(...)");
        $this$c$iv2 = component3;
        $i$f$plus = false;
        MutableComponent mutableComponent7 = $this$plus$iv.append((Component)other$iv);
        Intrinsics.checkNotNullExpressionValue((Object)mutableComponent7, (String)"append(...)");
        CommandCxUtil.success$default(it, (Component)mutableComponent7, false, 2, null);
        ServerLevel serverLevel = entity.serverLevel();
        Intrinsics.checkNotNullExpressionValue((Object)serverLevel, (String)"serverLevel(...)");
        Vec3 vec3 = ((CommandSourceStack)it.getSource()).getPosition();
        Intrinsics.checkNotNullExpressionValue((Object)vec3, (String)"getPosition(...)");
        item2.run(serverLevel, entity, vec3);
        return 0;
    }

    /*
     * WARNING - void declaration
     */
    private static final int addEventCommands$lambda$0$3(CommandContext it) {
        MutableComponent $this$plus$iv;
        void $this$with$iv$iv$iv;
        void $this$blue$iv$iv;
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        Collection players = EntityArgument.getPlayers((CommandContext)it, (String)"players");
        for (ServerPlayer player : players) {
            for (RandomEvent event : BCRegistries.EVENT) {
                Intrinsics.checkNotNull((Object)event);
                ServerLevel serverLevel = player.serverLevel();
                Intrinsics.checkNotNullExpressionValue((Object)serverLevel, (String)"serverLevel(...)");
                Intrinsics.checkNotNull((Object)player);
                RandomEvent.run$default(event, serverLevel, player, null, 4, null);
            }
        }
        String $this$c$iv = "Sent ALL events to ";
        boolean $i$f$getC = false;
        Component component = Component.nullToEmpty((String)$this$c$iv);
        Intrinsics.checkNotNullExpressionValue((Object)component, (String)"nullToEmpty(...)");
        $this$c$iv = component;
        String $this$blue$iv = String.valueOf(players.size());
        boolean $i$f$getBlue = false;
        String $this$c$iv$iv = $this$blue$iv;
        boolean $i$f$getC2 = false;
        Component component2 = Component.nullToEmpty((String)$this$c$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)component2, (String)"nullToEmpty(...)");
        $this$c$iv$iv = component2;
        boolean $i$f$getBlue2 = false;
        void var7_10 = $this$blue$iv$iv;
        ChatFormatting other$iv$iv$iv = ChatFormatting.BLUE;
        boolean $i$f$with = false;
        void $this$mut$iv$iv$iv$iv = $this$with$iv$iv$iv;
        boolean $i$f$mut = false;
        MutableComponent mutableComponent = $this$mut$iv$iv$iv$iv instanceof MutableComponent ? (MutableComponent)$this$mut$iv$iv$iv$iv : null;
        if (mutableComponent == null) {
            MutableComponent mutableComponent2 = $this$mut$iv$iv$iv$iv.copy();
            mutableComponent = mutableComponent2;
            Intrinsics.checkNotNullExpressionValue((Object)mutableComponent2, (String)"copy(...)");
        }
        MutableComponent mutableComponent3 = mutableComponent.withStyle(other$iv$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)mutableComponent3, (String)"withStyle(...)");
        Component other$iv = (Component)mutableComponent3;
        boolean $i$f$plus = false;
        void $this$mut$iv$iv = $this$plus$iv;
        boolean $i$f$mut2 = false;
        MutableComponent mutableComponent4 = $this$mut$iv$iv instanceof MutableComponent ? (MutableComponent)$this$mut$iv$iv : null;
        if (mutableComponent4 == null) {
            MutableComponent mutableComponent5 = $this$mut$iv$iv.copy();
            mutableComponent4 = mutableComponent5;
            Intrinsics.checkNotNullExpressionValue((Object)mutableComponent5, (String)"copy(...)");
        }
        MutableComponent mutableComponent6 = mutableComponent4.append(other$iv);
        Intrinsics.checkNotNullExpressionValue((Object)mutableComponent6, (String)"append(...)");
        $this$plus$iv = mutableComponent6;
        String $this$c$iv2 = " players.";
        boolean $i$f$getC3 = false;
        Component component3 = Component.nullToEmpty((String)$this$c$iv2);
        Intrinsics.checkNotNullExpressionValue((Object)component3, (String)"nullToEmpty(...)");
        other$iv = component3;
        $i$f$plus = false;
        MutableComponent mutableComponent7 = $this$plus$iv.append(other$iv);
        Intrinsics.checkNotNullExpressionValue((Object)mutableComponent7, (String)"append(...)");
        CommandCxUtil.success$default(it, (Component)mutableComponent7, false, 2, null);
        return 0;
    }
}

