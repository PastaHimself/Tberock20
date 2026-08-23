/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.brigadier.arguments.ArgumentType
 *  com.mojang.brigadier.arguments.StringArgumentType
 *  com.mojang.brigadier.context.CommandContext
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.ChatFormatting
 *  net.minecraft.commands.CommandSourceStack
 *  net.minecraft.commands.arguments.EntityArgument
 *  net.minecraft.network.chat.Component
 *  net.minecraft.network.chat.MutableComponent
 *  net.minecraft.network.protocol.common.custom.CustomPacketPayload
 *  net.minecraft.server.level.ServerPlayer
 *  net.minecraft.world.entity.player.Player
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.impl.commands;

import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.context.CommandContext;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.ChatFormatting;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.thebrokenscript.brokencore.api.commands.CommandDSL;
import net.thebrokenscript.brokencore.api.dsl.CommandCxUtil;
import net.thebrokenscript.brokencore.api.dsl.PlayerUtil;
import net.thebrokenscript.brokencore.impl.registry.BCPackets;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u0005*\b\u0012\u0004\u0012\u00020\u00070\u0006\u00a8\u0006\b"}, d2={"Lnet/thebrokenscript/brokencore/impl/commands/PopupCommands;", "", "<init>", "()V", "addPopupCommands", "", "Lnet/thebrokenscript/brokencore/api/commands/CommandDSL;", "Lnet/minecraft/commands/CommandSourceStack;", "brokencore-common"})
@SourceDebugExtension(value={"SMAP\nPopupCommands.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PopupCommands.kt\nnet/thebrokenscript/brokencore/impl/commands/PopupCommands\n+ 2 ComponentDSL.kt\nnet/thebrokenscript/brokencore/api/dsl/ComponentUtil\n*L\n1#1,34:1\n15#2:35\n115#2:36\n69#2:37\n46#2:38\n29#2:39\n24#2:40\n19#2,6:41\n18#2:47\n*S KotlinDebug\n*F\n+ 1 PopupCommands.kt\nnet/thebrokenscript/brokencore/impl/commands/PopupCommands\n*L\n27#1:35\n27#1:36\n27#1:37\n27#1:38\n27#1:39\n27#1:40\n27#1:41,6\n27#1:47\n*E\n"})
public final class PopupCommands {
    @NotNull
    public static final PopupCommands INSTANCE = new PopupCommands();

    private PopupCommands() {
    }

    public final void addPopupCommands(@NotNull CommandDSL<CommandSourceStack> $this$addPopupCommands) {
        Intrinsics.checkNotNullParameter($this$addPopupCommands, (String)"<this>");
        $this$addPopupCommands.group("popup", PopupCommands::addPopupCommands$lambda$0);
    }

    private static final void addPopupCommands$lambda$0(CommandDSL $this$group) {
        Intrinsics.checkNotNullParameter((Object)$this$group, (String)"$this$group");
        ArgumentType[] argumentTypeArray = new ArgumentType[3];
        Intrinsics.checkNotNullExpressionValue((Object)EntityArgument.players(), (String)"players(...)");
        Intrinsics.checkNotNullExpressionValue((Object)StringArgumentType.string(), (String)"string(...)");
        Intrinsics.checkNotNullExpressionValue((Object)StringArgumentType.greedyString(), (String)"greedyString(...)");
        $this$group.add("show [players] [title] [message]", argumentTypeArray, PopupCommands::addPopupCommands$lambda$0$0);
    }

    /*
     * WARNING - void declaration
     */
    private static final int addPopupCommands$lambda$0$0(CommandContext it) {
        void other$iv;
        MutableComponent $this$plus$iv;
        void $this$with$iv$iv$iv$iv;
        void $this$blue$iv$iv$iv;
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        Collection players = EntityArgument.getPlayers((CommandContext)it, (String)"players");
        String title = StringArgumentType.getString((CommandContext)it, (String)"title");
        String message = StringArgumentType.getString((CommandContext)it, (String)"message");
        for (ServerPlayer player : players) {
            Intrinsics.checkNotNull((Object)player);
            Player player2 = (Player)player;
            Intrinsics.checkNotNull((Object)title);
            Intrinsics.checkNotNull((Object)message);
            PlayerUtil.trySendCustomPacket(player2, (CustomPacketPayload)BCPackets.OPEN_ALERT_POPUP.of(title, message));
        }
        String $this$c$iv = "Sent popup to ";
        boolean $i$f$getC = false;
        Component component = Component.nullToEmpty((String)$this$c$iv);
        Intrinsics.checkNotNullExpressionValue((Object)component, (String)"nullToEmpty(...)");
        $this$c$iv = component;
        Number $this$blue$iv = players.size();
        boolean $i$f$getBlue = false;
        String $this$blue$iv$iv = $this$blue$iv.toString();
        boolean $i$f$getBlue2 = false;
        String $this$c$iv$iv$iv = $this$blue$iv$iv;
        boolean $i$f$getC2 = false;
        Component component2 = Component.nullToEmpty((String)$this$c$iv$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)component2, (String)"nullToEmpty(...)");
        $this$c$iv$iv$iv = component2;
        boolean $i$f$getBlue3 = false;
        void var11_13 = $this$blue$iv$iv$iv;
        ChatFormatting other$iv$iv$iv$iv = ChatFormatting.BLUE;
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
        $this$blue$iv = (Component)mutableComponent3;
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
        String $this$c$iv2 = " players.";
        boolean $i$f$getC3 = false;
        Component component3 = Component.nullToEmpty((String)$this$c$iv2);
        Intrinsics.checkNotNullExpressionValue((Object)component3, (String)"nullToEmpty(...)");
        $this$c$iv2 = component3;
        $i$f$plus = false;
        MutableComponent mutableComponent7 = $this$plus$iv.append((Component)other$iv);
        Intrinsics.checkNotNullExpressionValue((Object)mutableComponent7, (String)"append(...)");
        CommandCxUtil.success$default(it, (Component)mutableComponent7, false, 2, null);
        return 0;
    }
}

