/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.brigadier.arguments.ArgumentType
 *  com.mojang.brigadier.arguments.IntegerArgumentType
 *  com.mojang.brigadier.arguments.StringArgumentType
 *  com.mojang.brigadier.context.CommandContext
 *  com.mojang.brigadier.suggestion.SuggestionProvider
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.ChatFormatting
 *  net.minecraft.commands.CommandSourceStack
 *  net.minecraft.commands.arguments.DimensionArgument
 *  net.minecraft.commands.arguments.EntityArgument
 *  net.minecraft.network.chat.Component
 *  net.minecraft.network.chat.MutableComponent
 *  net.minecraft.network.protocol.common.custom.CustomPacketPayload
 *  net.minecraft.resources.ResourceKey
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.server.level.ServerPlayer
 *  net.minecraft.world.entity.player.Player
 *  net.thebrokenscript.brokencore.api.commands.CommandDSL
 *  net.thebrokenscript.brokencore.api.commands.SuggestingArgument
 *  net.thebrokenscript.brokencore.api.commands.suggestion.StringCollectionSuggestionProvider
 *  net.thebrokenscript.brokencore.api.dsl.CommandCxUtil
 *  net.thebrokenscript.brokencore.api.dsl.PlayerUtil
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.command.dev;

import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.suggestion.SuggestionProvider;
import java.lang.reflect.AccessFlag;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.ChatFormatting;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.arguments.DimensionArgument;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.thebrokenscript.api.ext.PlayerExt;
import net.thebrokenscript.brokencore.api.commands.CommandDSL;
import net.thebrokenscript.brokencore.api.commands.SuggestingArgument;
import net.thebrokenscript.brokencore.api.commands.suggestion.StringCollectionSuggestionProvider;
import net.thebrokenscript.brokencore.api.dsl.CommandCxUtil;
import net.thebrokenscript.brokencore.api.dsl.PlayerUtil;
import net.thebrokenscript.data.PlayerVariables;
import net.thebrokenscript.network.OpenCreditsPacket;
import net.thebrokenscript.registry.TBSPackets;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=2, xi=48, d1={"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002\u00a8\u0006\u0004"}, d2={"addPlayerCommands", "", "Lnet/thebrokenscript/brokencore/api/commands/CommandDSL;", "Lnet/minecraft/commands/CommandSourceStack;", "thebrokenscript-common"})
@SourceDebugExtension(value={"SMAP\nPlayerCommands.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PlayerCommands.kt\nnet/thebrokenscript/command/dev/PlayerCommandsKt\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 ComponentDSL.kt\nnet/thebrokenscript/brokencore/api/dsl/ComponentUtil\n*L\n1#1,105:1\n3919#2:106\n4434#2,2:107\n1563#3:109\n1634#3,3:110\n1869#3,2:113\n15#4:115\n71#4:116\n48#4:117\n29#4:118\n24#4:119\n19#4,6:120\n18#4:126\n73#4:127\n50#4:128\n29#4:129\n24#4:130\n18#4:131\n15#4:132\n71#4:133\n15#4:134\n48#4:135\n29#4:136\n24#4:137\n19#4,6:138\n15#4,4:144\n*S KotlinDebug\n*F\n+ 1 PlayerCommands.kt\nnet/thebrokenscript/command/dev/PlayerCommandsKt\n*L\n35#1:106\n35#1:107,2\n36#1:109\n36#1:110,3\n24#1:113,2\n54#1:115\n54#1:116\n54#1:117\n54#1:118\n54#1:119\n54#1:120,6\n54#1:126\n54#1:127\n54#1:128\n54#1:129\n54#1:130\n54#1:131\n56#1:132\n56#1:133\n56#1:134\n56#1:135\n56#1:136\n56#1:137\n56#1:138,6\n56#1:144,4\n*E\n"})
public final class PlayerCommandsKt {
    public static final void addPlayerCommands(@NotNull CommandDSL<CommandSourceStack> $this$addPlayerCommands) {
        Intrinsics.checkNotNullParameter($this$addPlayerCommands, (String)"<this>");
        $this$addPlayerCommands.group("player", PlayerCommandsKt::addPlayerCommands$lambda$0);
    }

    /*
     * WARNING - void declaration
     */
    private static final void addPlayerCommands$lambda$0(CommandDSL $this$group) {
        void $this$mapTo$iv$iv;
        void $this$map$iv;
        void $this$filterTo$iv$iv;
        Iterable $this$filter$iv;
        Intrinsics.checkNotNullParameter((Object)$this$group, (String)"$this$group");
        $this$group.add("list", PlayerCommandsKt::addPlayerCommands$lambda$0$0);
        ArgumentType[] argumentTypeArray = new ArgumentType[2];
        Intrinsics.checkNotNullExpressionValue((Object)EntityArgument.player(), (String)"player(...)");
        StringArgumentType stringArgumentType = StringArgumentType.word();
        Intrinsics.checkNotNullExpressionValue((Object)stringArgumentType, (String)"word(...)");
        ArgumentType argumentType = (ArgumentType)stringArgumentType;
        Field[] fieldArray = PlayerVariables.class.getDeclaredFields();
        Intrinsics.checkNotNullExpressionValue((Object)fieldArray, (String)"getDeclaredFields(...)");
        Object[] objectArray = fieldArray;
        ArgumentType argumentType2 = argumentType;
        int n = 1;
        ArgumentType[] argumentTypeArray2 = argumentTypeArray;
        String string = "var [player] [name]";
        CommandDSL commandDSL = $this$group;
        boolean $i$f$filter = false;
        void var4_9 = $this$filter$iv;
        Collection destination$iv$iv = new ArrayList();
        boolean $i$f$filterTo = false;
        for (Field element$iv$iv : $this$filterTo$iv$iv) {
            Field it = element$iv$iv;
            boolean bl = false;
            if (!(!it.accessFlags().contains((Object)AccessFlag.STATIC))) continue;
            destination$iv$iv.add(element$iv$iv);
        }
        Collection<String> collection = (List)destination$iv$iv;
        $this$filter$iv = collection;
        boolean $i$f$map = false;
        $this$filterTo$iv$iv = $this$map$iv;
        destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map$iv, (int)10));
        boolean $i$f$mapTo = false;
        for (Object item$iv$iv : $this$mapTo$iv$iv) {
            void it;
            Field element$iv$iv;
            element$iv$iv = (Field)item$iv$iv;
            collection = destination$iv$iv;
            boolean bl = false;
            collection.add(it.getName());
        }
        collection = (List)destination$iv$iv;
        Collection collection2 = collection;
        SuggestionProvider suggestionProvider = (SuggestionProvider)new StringCollectionSuggestionProvider(collection2);
        ArgumentType argumentType3 = argumentType2;
        argumentTypeArray2[n] = new SuggestingArgument(argumentType3, suggestionProvider);
        commandDSL.add(string, argumentTypeArray, PlayerCommandsKt::addPlayerCommands$lambda$0$3);
        argumentTypeArray = new ArgumentType[2];
        Intrinsics.checkNotNullExpressionValue((Object)EntityArgument.players(), (String)"players(...)");
        Intrinsics.checkNotNullExpressionValue((Object)IntegerArgumentType.integer(), (String)"integer(...)");
        $this$group.add("rep [players] [amount]", argumentTypeArray, PlayerCommandsKt::addPlayerCommands$lambda$0$4);
        argumentTypeArray = new ArgumentType[2];
        Intrinsics.checkNotNullExpressionValue((Object)EntityArgument.players(), (String)"players(...)");
        Intrinsics.checkNotNullExpressionValue((Object)DimensionArgument.dimension(), (String)"dimension(...)");
        $this$group.add("send [players] [dim]", argumentTypeArray, PlayerCommandsKt::addPlayerCommands$lambda$0$5);
        argumentTypeArray = new ArgumentType[1];
        Intrinsics.checkNotNullExpressionValue((Object)EntityArgument.players(), (String)"players(...)");
        $this$group.add("credits [players]", argumentTypeArray, PlayerCommandsKt::addPlayerCommands$lambda$0$6);
    }

    private static final int addPlayerCommands$lambda$0$0(CommandContext it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        CommandCxUtil.send((CommandContext)it, (String)("size: " + ((CommandSourceStack)it.getSource()).getServer().getPlayerCount()));
        CommandCxUtil.send((CommandContext)it, (String)"server players:");
        List list = ((CommandSourceStack)it.getSource()).getServer().getPlayerList().getPlayers();
        Intrinsics.checkNotNullExpressionValue((Object)list, (String)"getPlayers(...)");
        Iterable $this$forEach$iv = list;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            ServerPlayer player = (ServerPlayer)element$iv;
            boolean bl = false;
            Component component = player.getName();
            Intrinsics.checkNotNullExpressionValue((Object)component, (String)"getName(...)");
            CommandCxUtil.send((CommandContext)it, (Component)component);
        }
        return 0;
    }

    /*
     * WARNING - void declaration
     */
    private static final int addPlayerCommands$lambda$0$3(CommandContext it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        ServerPlayer player = EntityArgument.getPlayer((CommandContext)it, (String)"player");
        String playerVarName = StringArgumentType.getString((CommandContext)it, (String)"name");
        try {
            void $this$lightPurple$iv$iv;
            void other$iv;
            MutableComponent $this$plus$iv;
            void $this$with$iv$iv$iv;
            void $this$aqua$iv$iv;
            Field field = PlayerVariables.class.getDeclaredField(playerVarName);
            boolean bl = field.accessFlags().contains((Object)AccessFlag.PRIVATE);
            if (field.accessFlags().contains((Object)AccessFlag.STATIC)) {
                throw new NoSuchFieldException();
            }
            if (bl) {
                field.setAccessible(true);
            }
            Intrinsics.checkNotNull((Object)player);
            Object value = field.get(PlayerExt.INSTANCE.getVars((Player)player));
            if (bl) {
                field.setAccessible(false);
            }
            String $this$c$iv = "The value of ";
            boolean $i$f$getC = false;
            Component component = Component.nullToEmpty((String)$this$c$iv);
            Intrinsics.checkNotNullExpressionValue((Object)component, (String)"nullToEmpty(...)");
            $this$c$iv = component;
            Intrinsics.checkNotNull((Object)playerVarName);
            String $this$aqua$iv = playerVarName;
            boolean $i$f$getAqua = false;
            String $this$c$iv$iv = $this$aqua$iv;
            boolean $i$f$getC2 = false;
            Component component2 = Component.nullToEmpty((String)$this$c$iv$iv);
            Intrinsics.checkNotNullExpressionValue((Object)component2, (String)"nullToEmpty(...)");
            $this$c$iv$iv = component2;
            boolean $i$f$getAqua2 = false;
            void var11_21 = $this$aqua$iv$iv;
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
            String $this$c$iv2 = " is: ";
            boolean $i$f$getC3 = false;
            Component component3 = Component.nullToEmpty((String)$this$c$iv2);
            Intrinsics.checkNotNullExpressionValue((Object)component3, (String)"nullToEmpty(...)");
            $this$c$iv2 = component3;
            $i$f$plus = false;
            MutableComponent mutableComponent7 = $this$plus$iv.append((Component)other$iv);
            Intrinsics.checkNotNullExpressionValue((Object)mutableComponent7, (String)"append(...)");
            $this$plus$iv = mutableComponent7;
            String $this$lightPurple$iv = value.toString();
            boolean $i$f$getLightPurple = false;
            $this$c$iv$iv = $this$lightPurple$iv;
            $i$f$getC2 = false;
            Component component4 = Component.nullToEmpty((String)$this$c$iv$iv);
            Intrinsics.checkNotNullExpressionValue((Object)component4, (String)"nullToEmpty(...)");
            $this$c$iv$iv = component4;
            boolean $i$f$getLightPurple2 = false;
            $this$with$iv$iv$iv = $this$lightPurple$iv$iv;
            other$iv$iv$iv = ChatFormatting.LIGHT_PURPLE;
            $i$f$with = false;
            $this$mut$iv$iv$iv$iv = $this$with$iv$iv$iv;
            $i$f$mut = false;
            MutableComponent mutableComponent8 = $this$mut$iv$iv$iv$iv instanceof MutableComponent ? (MutableComponent)$this$mut$iv$iv$iv$iv : null;
            if (mutableComponent8 == null) {
                MutableComponent mutableComponent9 = $this$mut$iv$iv$iv$iv.copy();
                mutableComponent8 = mutableComponent9;
                Intrinsics.checkNotNullExpressionValue((Object)mutableComponent9, (String)"copy(...)");
            }
            MutableComponent mutableComponent10 = mutableComponent8.withStyle(other$iv$iv$iv);
            Intrinsics.checkNotNullExpressionValue((Object)mutableComponent10, (String)"withStyle(...)");
            $this$lightPurple$iv = (Component)mutableComponent10;
            $i$f$plus = false;
            MutableComponent mutableComponent11 = $this$plus$iv.append((Component)other$iv);
            Intrinsics.checkNotNullExpressionValue((Object)mutableComponent11, (String)"append(...)");
            CommandCxUtil.success$default((CommandContext)it, (Component)((Component)mutableComponent11), (boolean)false, (int)2, null);
        }
        catch (NoSuchFieldException noSuchFieldException) {
            void other$iv;
            MutableComponent $this$plus$iv;
            void $this$with$iv$iv$iv;
            void $this$aqua$iv$iv;
            String $this$c$iv = "Field '";
            boolean $i$f$getC = false;
            Component component = Component.nullToEmpty((String)$this$c$iv);
            Intrinsics.checkNotNullExpressionValue((Object)component, (String)"nullToEmpty(...)");
            $this$c$iv = component;
            Intrinsics.checkNotNull((Object)playerVarName);
            String $this$aqua$iv = playerVarName;
            boolean $i$f$getAqua = false;
            String $this$c$iv$iv = $this$aqua$iv;
            boolean $i$f$getC4 = false;
            Component component5 = Component.nullToEmpty((String)$this$c$iv$iv);
            Intrinsics.checkNotNullExpressionValue((Object)component5, (String)"nullToEmpty(...)");
            $this$c$iv$iv = component5;
            boolean $i$f$getAqua3 = false;
            void $this$lightPurple$iv$iv = $this$aqua$iv$iv;
            ChatFormatting other$iv$iv$iv = ChatFormatting.AQUA;
            boolean $i$f$with = false;
            void $this$mut$iv$iv$iv$iv = $this$with$iv$iv$iv;
            boolean $i$f$mut = false;
            MutableComponent mutableComponent = $this$mut$iv$iv$iv$iv instanceof MutableComponent ? (MutableComponent)$this$mut$iv$iv$iv$iv : null;
            if (mutableComponent == null) {
                MutableComponent mutableComponent12 = $this$mut$iv$iv$iv$iv.copy();
                mutableComponent = mutableComponent12;
                Intrinsics.checkNotNullExpressionValue((Object)mutableComponent12, (String)"copy(...)");
            }
            MutableComponent mutableComponent13 = mutableComponent.withStyle(other$iv$iv$iv);
            Intrinsics.checkNotNullExpressionValue((Object)mutableComponent13, (String)"withStyle(...)");
            $this$aqua$iv = (Component)mutableComponent13;
            boolean $i$f$plus = false;
            void $this$mut$iv$iv = $this$plus$iv;
            boolean $i$f$mut3 = false;
            MutableComponent mutableComponent14 = $this$mut$iv$iv instanceof MutableComponent ? (MutableComponent)$this$mut$iv$iv : null;
            if (mutableComponent14 == null) {
                MutableComponent mutableComponent15 = $this$mut$iv$iv.copy();
                mutableComponent14 = mutableComponent15;
                Intrinsics.checkNotNullExpressionValue((Object)mutableComponent15, (String)"copy(...)");
            }
            MutableComponent mutableComponent16 = mutableComponent14.append((Component)other$iv);
            Intrinsics.checkNotNullExpressionValue((Object)mutableComponent16, (String)"append(...)");
            $this$plus$iv = mutableComponent16;
            String $this$c$iv3 = "' does not exist.";
            boolean $i$f$getC5 = false;
            Component component6 = Component.nullToEmpty((String)$this$c$iv3);
            Intrinsics.checkNotNullExpressionValue((Object)component6, (String)"nullToEmpty(...)");
            $this$c$iv3 = component6;
            $i$f$plus = false;
            MutableComponent mutableComponent17 = $this$plus$iv.append((Component)other$iv);
            Intrinsics.checkNotNullExpressionValue((Object)mutableComponent17, (String)"append(...)");
            CommandCxUtil.fail$default((CommandContext)it, (Component)((Component)mutableComponent17), (boolean)false, (int)2, null);
        }
        return 0;
    }

    private static final int addPlayerCommands$lambda$0$4(CommandContext it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        Collection players = EntityArgument.getPlayers((CommandContext)it, (String)"players");
        int amount = IntegerArgumentType.getInteger((CommandContext)it, (String)"amount");
        for (ServerPlayer player : players) {
            Intrinsics.checkNotNull((Object)player);
            PlayerExt.INSTANCE.updateVars((Player)player, (Function1<? super PlayerVariables, Unit>)((Function1)arg_0 -> PlayerCommandsKt.addPlayerCommands$lambda$0$4$0(amount, arg_0)));
        }
        CommandCxUtil.success$default((CommandContext)it, (String)("Successfully gave " + amount + " reputation to " + players.size() + " players!"), (boolean)false, (int)2, null);
        return 0;
    }

    private static final Unit addPlayerCommands$lambda$0$4$0(int $amount, PlayerVariables $this$updateVars) {
        Intrinsics.checkNotNullParameter((Object)$this$updateVars, (String)"$this$updateVars");
        $this$updateVars.setEntityReputation($this$updateVars.getEntityReputation() + $amount);
        return Unit.INSTANCE;
    }

    private static final int addPlayerCommands$lambda$0$5(CommandContext it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        Collection players = EntityArgument.getPlayers((CommandContext)it, (String)"players");
        ServerLevel dim = DimensionArgument.getDimension((CommandContext)it, (String)"dim");
        for (ServerPlayer player : players) {
            Intrinsics.checkNotNull((Object)player);
            Player player2 = (Player)player;
            ResourceKey resourceKey = dim.dimension();
            Intrinsics.checkNotNullExpressionValue((Object)resourceKey, (String)"dimension(...)");
            PlayerUtil.sendTo((Player)player2, (ResourceKey)resourceKey);
        }
        CommandCxUtil.success$default((CommandContext)it, (String)("Successfully sent " + players.size() + " players to " + dim.dimension().location() + "!"), (boolean)false, (int)2, null);
        return 0;
    }

    private static final int addPlayerCommands$lambda$0$6(CommandContext it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        Collection targets = EntityArgument.getPlayers((CommandContext)it, (String)"players");
        CommandCxUtil.success$default((String)("Sending credits screen to " + targets.size() + " players!"), (CommandContext)it, (boolean)false, (int)2, null);
        OpenCreditsPacket packet = (OpenCreditsPacket)TBSPackets.OPEN_CREDITS.create();
        for (ServerPlayer target : targets) {
            Intrinsics.checkNotNull((Object)target);
            PlayerUtil.trySendCustomPacket((Player)((Player)target), (CustomPacketPayload)((CustomPacketPayload)packet));
        }
        return 0;
    }
}

