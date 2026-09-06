/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.brigadier.context.CommandContext
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.ChatFormatting
 *  net.minecraft.commands.CommandSourceStack
 *  net.minecraft.network.chat.Component
 *  net.minecraft.network.chat.MutableComponent
 *  net.minecraft.server.level.ServerPlayer
 *  net.minecraft.world.entity.player.Player
 *  net.thebrokenscript.brokencore.api.commands.CommandDSL
 *  net.thebrokenscript.brokencore.api.dsl.CommandCxUtil
 *  net.thebrokenscript.brokencore.api.dsl.StyleConfigurator
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.command;

import com.mojang.brigadier.context.CommandContext;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.ChatFormatting;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.thebrokenscript.api.ext.PlayerExt;
import net.thebrokenscript.brokencore.api.commands.CommandDSL;
import net.thebrokenscript.brokencore.api.dsl.CommandCxUtil;
import net.thebrokenscript.brokencore.api.dsl.StyleConfigurator;
import net.thebrokenscript.data.PlayerVariables;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u0005*\b\u0012\u0004\u0012\u00020\u00070\u0006\u00a8\u0006\b"}, d2={"Lnet/thebrokenscript/command/ReputationCommand;", "", "<init>", "()V", "addReputation", "", "Lnet/thebrokenscript/brokencore/api/commands/CommandDSL;", "Lnet/minecraft/commands/CommandSourceStack;", "thebrokenscript-common"})
@SourceDebugExtension(value={"SMAP\nReputationCommand.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ReputationCommand.kt\nnet/thebrokenscript/command/ReputationCommand\n+ 2 ComponentDSL.kt\nnet/thebrokenscript/brokencore/api/dsl/ComponentUtil\n*L\n1#1,51:1\n15#2,10:52\n15#2:62\n71#2:63\n15#2:64\n48#2:65\n29#2:66\n24#2:67\n19#2,6:68\n66#2:74\n15#2:75\n43#2:76\n29#2:77\n24#2,3:78\n15#2:81\n24#2:82\n18#2:83\n*S KotlinDebug\n*F\n+ 1 ReputationCommand.kt\nnet/thebrokenscript/command/ReputationCommand\n*L\n40#1:52,10\n43#1:62\n43#1:63\n43#1:64\n43#1:65\n43#1:66\n43#1:67\n43#1:68,6\n43#1:74\n43#1:75\n43#1:76\n43#1:77\n43#1:78,3\n44#1:81\n43#1:82\n43#1:83\n*E\n"})
public final class ReputationCommand {
    @NotNull
    public static final ReputationCommand INSTANCE = new ReputationCommand();

    private ReputationCommand() {
    }

    public final void addReputation(@NotNull CommandDSL<CommandSourceStack> $this$addReputation) {
        Intrinsics.checkNotNullParameter($this$addReputation, (String)"<this>");
        $this$addReputation.add("reputation", ReputationCommand::addReputation$lambda$0);
    }

    /*
     * WARNING - void declaration
     */
    private static final int addReputation$lambda$0(CommandContext it) {
        Component $this$with$iv;
        void $this$addReputation_u24lambda_u240_u240;
        StyleConfigurator $this$gold$iv$iv;
        void $this$with$iv$iv$iv;
        void $this$aqua$iv$iv;
        MutableComponent $this$plus$iv;
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        ServerPlayer player = ((CommandSourceStack)it.getSource()).getPlayer();
        if (player == null) {
            CommandCxUtil.fail$default((CommandContext)it, (String)"This command must be executed by a player!", (boolean)false, (int)2, null);
            return -1;
        }
        int rep = PlayerExt.INSTANCE.getVars((Player)player).getEntityReputation();
        String text = rep <= 25 ? "BAD" : (rep <= 75 ? "NORMAL" : "GOOD");
        String desc = rep <= 25 ? "Null is pissed and his hatred for you is at maximum. Expect hell from null. Null will now more often attack the player." : (rep <= 75 ? "Null and you are neutral between each other. Null can sometimes hurt the player." : "Null is cool and doesn't care about you being here. Null will rarely hurt the player.");
        String $this$c$iv = "Reputation value: ";
        boolean $i$f$getC = false;
        Component component = Component.nullToEmpty((String)$this$c$iv);
        Intrinsics.checkNotNullExpressionValue((Object)component, (String)"nullToEmpty(...)");
        $this$c$iv = component;
        Object object = ((CommandSourceStack)it.getSource()).getPlayer();
        MutableComponent mutableComponent = Component.literal((String)String.valueOf(object != null && (object = PlayerExt.INSTANCE.getVars((Player)object)) != null ? Integer.valueOf(((PlayerVariables)object).getEntityReputation()) : null));
        Intrinsics.checkNotNullExpressionValue((Object)mutableComponent, (String)"literal(...)");
        Component other$iv = (Component)mutableComponent;
        boolean $i$f$plus = false;
        void $this$mut$iv$iv = $this$plus$iv;
        boolean $i$f$mut = false;
        MutableComponent mutableComponent2 = $this$mut$iv$iv instanceof MutableComponent ? (MutableComponent)$this$mut$iv$iv : null;
        if (mutableComponent2 == null) {
            MutableComponent mutableComponent3 = $this$mut$iv$iv.copy();
            mutableComponent2 = mutableComponent3;
            Intrinsics.checkNotNullExpressionValue((Object)mutableComponent3, (String)"copy(...)");
        }
        MutableComponent mutableComponent4 = mutableComponent2.append(other$iv);
        Intrinsics.checkNotNullExpressionValue((Object)mutableComponent4, (String)"append(...)");
        CommandCxUtil.success$default((CommandContext)it, (Component)((Component)mutableComponent4), (boolean)false, (int)2, null);
        $this$c$iv = "Reputation: ";
        $i$f$getC = false;
        Component component2 = Component.nullToEmpty((String)$this$c$iv);
        Intrinsics.checkNotNullExpressionValue((Object)component2, (String)"nullToEmpty(...)");
        $this$c$iv = component2;
        String $this$aqua$iv = text;
        boolean $i$f$getAqua = false;
        String $this$c$iv$iv = $this$aqua$iv;
        boolean $i$f$getC2 = false;
        Component component3 = Component.nullToEmpty((String)$this$c$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)component3, (String)"nullToEmpty(...)");
        $this$c$iv$iv = component3;
        boolean $i$f$getAqua2 = false;
        void var10_14 = $this$aqua$iv$iv;
        ChatFormatting other$iv$iv$iv = ChatFormatting.AQUA;
        boolean $i$f$with = false;
        void $this$mut$iv$iv$iv$iv = $this$with$iv$iv$iv;
        boolean $i$f$mut2 = false;
        MutableComponent mutableComponent5 = $this$mut$iv$iv$iv$iv instanceof MutableComponent ? (MutableComponent)$this$mut$iv$iv$iv$iv : null;
        if (mutableComponent5 == null) {
            MutableComponent mutableComponent6 = $this$mut$iv$iv$iv$iv.copy();
            mutableComponent5 = mutableComponent6;
            Intrinsics.checkNotNullExpressionValue((Object)mutableComponent6, (String)"copy(...)");
        }
        MutableComponent mutableComponent7 = mutableComponent5.withStyle(other$iv$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)mutableComponent7, (String)"withStyle(...)");
        $this$aqua$iv = (Component)mutableComponent7;
        $i$f$plus = false;
        $this$mut$iv$iv = $this$plus$iv;
        $i$f$mut = false;
        MutableComponent mutableComponent8 = $this$mut$iv$iv instanceof MutableComponent ? (MutableComponent)$this$mut$iv$iv : null;
        if (mutableComponent8 == null) {
            MutableComponent mutableComponent9 = $this$mut$iv$iv.copy();
            mutableComponent8 = mutableComponent9;
            Intrinsics.checkNotNullExpressionValue((Object)mutableComponent9, (String)"copy(...)");
        }
        MutableComponent mutableComponent10 = mutableComponent8.append((Component)other$iv);
        Intrinsics.checkNotNullExpressionValue((Object)mutableComponent10, (String)"append(...)");
        $this$plus$iv = mutableComponent10;
        String $this$gold$iv = " (hover for more information)";
        boolean $i$f$getGold = false;
        $this$c$iv$iv = $this$gold$iv;
        $i$f$getC2 = false;
        Component component4 = Component.nullToEmpty((String)$this$c$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)component4, (String)"nullToEmpty(...)");
        $this$c$iv$iv = component4;
        boolean $i$f$getGold22 = false;
        $this$with$iv$iv$iv = $this$gold$iv$iv;
        other$iv$iv$iv = ChatFormatting.GOLD;
        $i$f$with = false;
        $this$mut$iv$iv$iv$iv = $this$with$iv$iv$iv;
        $i$f$mut2 = false;
        MutableComponent mutableComponent11 = $this$mut$iv$iv$iv$iv instanceof MutableComponent ? (MutableComponent)$this$mut$iv$iv$iv$iv : null;
        if (mutableComponent11 == null) {
            MutableComponent mutableComponent12 = $this$mut$iv$iv$iv$iv.copy();
            mutableComponent11 = mutableComponent12;
            Intrinsics.checkNotNullExpressionValue((Object)mutableComponent12, (String)"copy(...)");
        }
        MutableComponent mutableComponent13 = mutableComponent11.withStyle(other$iv$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)mutableComponent13, (String)"withStyle(...)");
        $this$gold$iv = (Component)mutableComponent13;
        boolean $i$f$with2 = false;
        StyleConfigurator $i$f$getGold22 = $this$gold$iv$iv = new StyleConfigurator();
        CommandContext commandContext = it;
        boolean bl = false;
        String $this$c$iv2 = desc;
        boolean $i$f$getC3 = false;
        Component component5 = Component.nullToEmpty((String)$this$c$iv2);
        Intrinsics.checkNotNullExpressionValue((Object)component5, (String)"nullToEmpty(...)");
        $this$addReputation_u24lambda_u240_u240.setHoverText(component5);
        $this$mut$iv$iv = $this$with$iv;
        boolean $i$f$mut3 = false;
        MutableComponent mutableComponent14 = $this$mut$iv$iv instanceof MutableComponent ? (MutableComponent)$this$mut$iv$iv : null;
        if (mutableComponent14 == null) {
            MutableComponent mutableComponent15 = $this$mut$iv$iv.copy();
            mutableComponent14 = mutableComponent15;
            Intrinsics.checkNotNullExpressionValue((Object)mutableComponent15, (String)"copy(...)");
        }
        $this$with$iv = (Component)$this$gold$iv$iv.apply(mutableComponent14);
        $i$f$plus = false;
        MutableComponent mutableComponent16 = $this$plus$iv.append((Component)other$iv);
        Intrinsics.checkNotNullExpressionValue((Object)mutableComponent16, (String)"append(...)");
        CommandCxUtil.success$default((CommandContext)commandContext, (Component)((Component)mutableComponent16), (boolean)false, (int)2, null);
        return 0;
    }
}

