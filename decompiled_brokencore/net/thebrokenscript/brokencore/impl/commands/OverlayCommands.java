/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.brigadier.arguments.ArgumentType
 *  com.mojang.brigadier.context.CommandContext
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.ChatFormatting
 *  net.minecraft.commands.CommandSourceStack
 *  net.minecraft.commands.arguments.EntityArgument
 *  net.minecraft.commands.arguments.ResourceLocationArgument
 *  net.minecraft.commands.arguments.TimeArgument
 *  net.minecraft.network.chat.Component
 *  net.minecraft.network.chat.MutableComponent
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.server.level.ServerPlayer
 *  net.minecraft.world.entity.player.Player
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.impl.commands;

import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.context.CommandContext;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.ChatFormatting;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.commands.arguments.ResourceLocationArgument;
import net.minecraft.commands.arguments.TimeArgument;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.thebrokenscript.brokencore.api.commands.CommandDSL;
import net.thebrokenscript.brokencore.api.dsl.CommandCxUtil;
import net.thebrokenscript.brokencore.api.dsl.PlayerUtil;
import net.thebrokenscript.brokencore.impl.BrokenCore;
import net.thebrokenscript.brokencore.impl.registry.BCSounds;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u0005*\b\u0012\u0004\u0012\u00020\u00070\u0006\u00a8\u0006\b"}, d2={"Lnet/thebrokenscript/brokencore/impl/commands/OverlayCommands;", "", "<init>", "()V", "addOverlayCommands", "", "Lnet/thebrokenscript/brokencore/api/commands/CommandDSL;", "Lnet/minecraft/commands/CommandSourceStack;", "brokencore-common"})
@SourceDebugExtension(value={"SMAP\nOverlayCommands.kt\nKotlin\n*S Kotlin\n*F\n+ 1 OverlayCommands.kt\nnet/thebrokenscript/brokencore/impl/commands/OverlayCommands\n+ 2 ComponentDSL.kt\nnet/thebrokenscript/brokencore/api/dsl/ComponentUtil\n*L\n1#1,71:1\n15#2:72\n94#2:73\n71#2:74\n48#2:75\n29#2:76\n24#2:77\n19#2,6:78\n18#2:84\n115#2:85\n69#2:86\n46#2:87\n29#2:88\n24#2:89\n18#2:90\n119#2:91\n73#2:92\n50#2:93\n29#2:94\n24#2:95\n18#2:96\n*S KotlinDebug\n*F\n+ 1 OverlayCommands.kt\nnet/thebrokenscript/brokencore/impl/commands/OverlayCommands\n*L\n39#1:72\n39#1:73\n39#1:74\n39#1:75\n39#1:76\n39#1:77\n39#1:78,6\n39#1:84\n39#1:85\n39#1:86\n39#1:87\n39#1:88\n39#1:89\n39#1:90\n39#1:91\n39#1:92\n39#1:93\n39#1:94\n39#1:95\n39#1:96\n*E\n"})
public final class OverlayCommands {
    @NotNull
    public static final OverlayCommands INSTANCE = new OverlayCommands();

    private OverlayCommands() {
    }

    public final void addOverlayCommands(@NotNull CommandDSL<CommandSourceStack> $this$addOverlayCommands) {
        Intrinsics.checkNotNullParameter($this$addOverlayCommands, (String)"<this>");
        $this$addOverlayCommands.group("overlay", OverlayCommands::addOverlayCommands$lambda$0);
    }

    private static final void addOverlayCommands$lambda$0(CommandDSL $this$group) {
        Intrinsics.checkNotNullParameter((Object)$this$group, (String)"$this$group");
        ArgumentType[] argumentTypeArray = new ArgumentType[1];
        Intrinsics.checkNotNullExpressionValue((Object)EntityArgument.players(), (String)"players(...)");
        $this$group.add("clear [players]", argumentTypeArray, OverlayCommands::addOverlayCommands$lambda$0$0);
        argumentTypeArray = new ArgumentType[3];
        Intrinsics.checkNotNullExpressionValue((Object)EntityArgument.players(), (String)"players(...)");
        Intrinsics.checkNotNullExpressionValue((Object)ResourceLocationArgument.id(), (String)"id(...)");
        Intrinsics.checkNotNullExpressionValue((Object)TimeArgument.time((int)1), (String)"time(...)");
        $this$group.add("show [players] [texture] [duration]", argumentTypeArray, OverlayCommands::addOverlayCommands$lambda$0$1);
        argumentTypeArray = new ArgumentType[1];
        Intrinsics.checkNotNullExpressionValue((Object)EntityArgument.players(), (String)"players(...)");
        $this$group.add("funny [players]", argumentTypeArray, OverlayCommands::addOverlayCommands$lambda$0$2);
        argumentTypeArray = new ArgumentType[1];
        Intrinsics.checkNotNullExpressionValue((Object)EntityArgument.players(), (String)"players(...)");
        $this$group.add("silly [players]", argumentTypeArray, OverlayCommands::addOverlayCommands$lambda$0$3);
    }

    private static final int addOverlayCommands$lambda$0$0(CommandContext it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        Collection players = EntityArgument.getPlayers((CommandContext)it, (String)"players");
        for (ServerPlayer player : players) {
            Intrinsics.checkNotNull((Object)player);
            PlayerUtil.tryClearOverlays((Player)player);
        }
        CommandCxUtil.success$default(it, "Cleared all overlays!", false, 2, null);
        return 0;
    }

    /*
     * WARNING - void declaration
     */
    private static final int addOverlayCommands$lambda$0$1(CommandContext it) {
        void $this$lightPurple$iv$iv$iv;
        void $this$blue$iv$iv$iv;
        void other$iv;
        MutableComponent $this$plus$iv;
        void $this$with$iv$iv$iv$iv;
        void $this$aqua$iv$iv$iv;
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        Collection players = EntityArgument.getPlayers((CommandContext)it, (String)"players");
        ResourceLocation texture = ResourceLocationArgument.getId((CommandContext)it, (String)"texture");
        long duration2 = ((Number)it.getArgument("duration", Integer.TYPE)).intValue();
        for (ServerPlayer player : players) {
            Intrinsics.checkNotNull((Object)player);
            Player player2 = (Player)player;
            Intrinsics.checkNotNull((Object)texture);
            PlayerUtil.trySendOverlay(player2, texture, duration2);
        }
        String $this$c$iv = "Showing overlay ";
        boolean $i$f$getC = false;
        Component component = Component.nullToEmpty((String)$this$c$iv);
        Intrinsics.checkNotNullExpressionValue((Object)component, (String)"nullToEmpty(...)");
        $this$c$iv = component;
        Intrinsics.checkNotNull((Object)texture);
        ResourceLocation $this$aqua$iv = texture;
        boolean $i$f$getAqua = false;
        String string = $this$aqua$iv.toString();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"toString(...)");
        String $this$aqua$iv$iv = string;
        boolean $i$f$getAqua2 = false;
        String $this$c$iv$iv$iv = $this$aqua$iv$iv;
        boolean $i$f$getC2 = false;
        Component component2 = Component.nullToEmpty((String)$this$c$iv$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)component2, (String)"nullToEmpty(...)");
        $this$c$iv$iv$iv = component2;
        boolean $i$f$getAqua3 = false;
        void var12_13 = $this$aqua$iv$iv$iv;
        ChatFormatting other$iv$iv$iv$iv = ChatFormatting.AQUA;
        boolean $i$f$with = false;
        void $this$mut$iv$iv$iv$iv$iv = $this$with$iv$iv$iv$iv;
        boolean $i$f$mut = false;
        MutableComponent mutableComponent = $this$mut$iv$iv$iv$iv$iv instanceof MutableComponent ? (MutableComponent)$this$mut$iv$iv$iv$iv$iv : null;
        if (mutableComponent == null) {
            MutableComponent mutableComponent2 = $this$mut$iv$iv$iv$iv$iv.copy();
            mutableComponent = mutableComponent2;
            Intrinsics.checkNotNullExpressionValue((Object)mutableComponent2, (String)"copy(...)");
        }
        MutableComponent mutableComponent3 = mutableComponent.withStyle(other$iv$iv$iv$iv);
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
        String $this$c$iv2 = " to ";
        boolean $i$f$getC3 = false;
        Component component3 = Component.nullToEmpty((String)$this$c$iv2);
        Intrinsics.checkNotNullExpressionValue((Object)component3, (String)"nullToEmpty(...)");
        $this$c$iv2 = component3;
        $i$f$plus = false;
        MutableComponent mutableComponent7 = $this$plus$iv.append((Component)other$iv);
        Intrinsics.checkNotNullExpressionValue((Object)mutableComponent7, (String)"append(...)");
        $this$plus$iv = mutableComponent7;
        Number $this$blue$iv = players.size();
        boolean $i$f$getBlue = false;
        String $this$blue$iv$iv = $this$blue$iv.toString();
        boolean $i$f$getBlue2 = false;
        $this$c$iv$iv$iv = $this$blue$iv$iv;
        $i$f$getC2 = false;
        Component component4 = Component.nullToEmpty((String)$this$c$iv$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)component4, (String)"nullToEmpty(...)");
        $this$c$iv$iv$iv = component4;
        boolean $i$f$getBlue3 = false;
        $this$with$iv$iv$iv$iv = $this$blue$iv$iv$iv;
        other$iv$iv$iv$iv = ChatFormatting.BLUE;
        $i$f$with = false;
        $this$mut$iv$iv$iv$iv$iv = $this$with$iv$iv$iv$iv;
        $i$f$mut = false;
        MutableComponent mutableComponent8 = $this$mut$iv$iv$iv$iv$iv instanceof MutableComponent ? (MutableComponent)$this$mut$iv$iv$iv$iv$iv : null;
        if (mutableComponent8 == null) {
            MutableComponent mutableComponent9 = $this$mut$iv$iv$iv$iv$iv.copy();
            mutableComponent8 = mutableComponent9;
            Intrinsics.checkNotNullExpressionValue((Object)mutableComponent9, (String)"copy(...)");
        }
        MutableComponent mutableComponent10 = mutableComponent8.withStyle(other$iv$iv$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)mutableComponent10, (String)"withStyle(...)");
        $this$blue$iv = (Component)mutableComponent10;
        $i$f$plus = false;
        MutableComponent mutableComponent11 = $this$plus$iv.append((Component)other$iv);
        Intrinsics.checkNotNullExpressionValue((Object)mutableComponent11, (String)"append(...)");
        $this$plus$iv = mutableComponent11;
        $this$c$iv2 = " players for ";
        $i$f$getC3 = false;
        Component component5 = Component.nullToEmpty((String)$this$c$iv2);
        Intrinsics.checkNotNullExpressionValue((Object)component5, (String)"nullToEmpty(...)");
        $this$c$iv2 = component5;
        $i$f$plus = false;
        MutableComponent mutableComponent12 = $this$plus$iv.append((Component)other$iv);
        Intrinsics.checkNotNullExpressionValue((Object)mutableComponent12, (String)"append(...)");
        $this$plus$iv = mutableComponent12;
        Number $this$lightPurple$iv = duration2;
        boolean $i$f$getLightPurple = false;
        String $this$lightPurple$iv$iv = $this$lightPurple$iv.toString();
        boolean $i$f$getLightPurple2 = false;
        $this$c$iv$iv$iv = $this$lightPurple$iv$iv;
        $i$f$getC2 = false;
        Component component6 = Component.nullToEmpty((String)$this$c$iv$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)component6, (String)"nullToEmpty(...)");
        $this$c$iv$iv$iv = component6;
        boolean $i$f$getLightPurple3 = false;
        $this$with$iv$iv$iv$iv = $this$lightPurple$iv$iv$iv;
        other$iv$iv$iv$iv = ChatFormatting.LIGHT_PURPLE;
        $i$f$with = false;
        $this$mut$iv$iv$iv$iv$iv = $this$with$iv$iv$iv$iv;
        $i$f$mut = false;
        MutableComponent mutableComponent13 = $this$mut$iv$iv$iv$iv$iv instanceof MutableComponent ? (MutableComponent)$this$mut$iv$iv$iv$iv$iv : null;
        if (mutableComponent13 == null) {
            MutableComponent mutableComponent14 = $this$mut$iv$iv$iv$iv$iv.copy();
            mutableComponent13 = mutableComponent14;
            Intrinsics.checkNotNullExpressionValue((Object)mutableComponent14, (String)"copy(...)");
        }
        MutableComponent mutableComponent15 = mutableComponent13.withStyle(other$iv$iv$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)mutableComponent15, (String)"withStyle(...)");
        $this$lightPurple$iv = (Component)mutableComponent15;
        $i$f$plus = false;
        MutableComponent mutableComponent16 = $this$plus$iv.append((Component)other$iv);
        Intrinsics.checkNotNullExpressionValue((Object)mutableComponent16, (String)"append(...)");
        $this$plus$iv = mutableComponent16;
        $this$c$iv2 = " ticks...";
        $i$f$getC3 = false;
        Component component7 = Component.nullToEmpty((String)$this$c$iv2);
        Intrinsics.checkNotNullExpressionValue((Object)component7, (String)"nullToEmpty(...)");
        $this$c$iv2 = component7;
        $i$f$plus = false;
        MutableComponent mutableComponent17 = $this$plus$iv.append((Component)other$iv);
        Intrinsics.checkNotNullExpressionValue((Object)mutableComponent17, (String)"append(...)");
        CommandCxUtil.success$default(it, (Component)mutableComponent17, false, 2, null);
        return 0;
    }

    private static final int addOverlayCommands$lambda$0$2(CommandContext it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        for (ServerPlayer player : EntityArgument.getPlayers((CommandContext)it, (String)"players")) {
            Intrinsics.checkNotNull((Object)player);
            PlayerUtil.sendSound$default(player, BCSounds.INSTANCE.getVINE_BOOM(), 0.0f, 0.0f, null, null, 0L, 62, null);
            PlayerUtil.trySendOverlay((Player)player, BrokenCore.id("textures/screens/flipper.png"), 15L);
        }
        CommandCxUtil.success$default(it, "Performed funny :3", false, 2, null);
        return 0;
    }

    private static final int addOverlayCommands$lambda$0$3(CommandContext it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        for (ServerPlayer player : EntityArgument.getPlayers((CommandContext)it, (String)"players")) {
            Intrinsics.checkNotNull((Object)player);
            PlayerUtil.trySendOverlay((Player)player, BrokenCore.id("textures/animated/integatlas.png"), 15L);
        }
        CommandCxUtil.success$default(it, "Performed silly :3", false, 2, null);
        return 0;
    }
}

