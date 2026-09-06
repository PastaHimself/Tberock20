/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.brigadier.context.CommandContext
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.ChatFormatting
 *  net.minecraft.client.Minecraft
 *  net.minecraft.commands.SharedSuggestionProvider
 *  net.minecraft.network.chat.Component
 *  net.minecraft.network.chat.MutableComponent
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.impl.client.commands;

import com.mojang.brigadier.context.CommandContext;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.commands.SharedSuggestionProvider;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.thebrokenscript.brokencore.api.commands.CommandDSL;
import net.thebrokenscript.brokencore.api.dsl.ClientDSLKt;
import net.thebrokenscript.brokencore.api.queue.QueuedTask;
import net.thebrokenscript.brokencore.impl.client.BCClient;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u00020\u0005\"\b\b\u0000\u0010\u0006*\u00020\u0007*\b\u0012\u0004\u0012\u0002H\u00060\b\u00a8\u0006\t"}, d2={"Lnet/thebrokenscript/brokencore/impl/client/commands/ClientInspectCommands;", "", "<init>", "()V", "addClientInspectCommands", "", "S", "Lnet/minecraft/commands/SharedSuggestionProvider;", "Lnet/thebrokenscript/brokencore/api/commands/CommandDSL;", "brokencore-common"})
@SourceDebugExtension(value={"SMAP\nClientInspectCommands.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ClientInspectCommands.kt\nnet/thebrokenscript/brokencore/impl/client/commands/ClientInspectCommands\n+ 2 ComponentDSL.kt\nnet/thebrokenscript/brokencore/api/dsl/ComponentUtil\n*L\n1#1,30:1\n66#2:31\n15#2:32\n43#2:33\n29#2:34\n24#2:35\n71#2:36\n15#2:37\n48#2:38\n29#2:39\n24#2:40\n15#2,4:41\n70#2:45\n15#2:46\n47#2:47\n29#2:48\n24#2:49\n18#2:50\n*S KotlinDebug\n*F\n+ 1 ClientInspectCommands.kt\nnet/thebrokenscript/brokencore/impl/client/commands/ClientInspectCommands\n*L\n19#1:31\n19#1:32\n19#1:33\n19#1:34\n19#1:35\n22#1:36\n22#1:37\n22#1:38\n22#1:39\n22#1:40\n22#1:41,4\n22#1:45\n22#1:46\n22#1:47\n22#1:48\n22#1:49\n22#1:50\n*E\n"})
public final class ClientInspectCommands {
    @NotNull
    public static final ClientInspectCommands INSTANCE = new ClientInspectCommands();

    private ClientInspectCommands() {
    }

    public final <S extends SharedSuggestionProvider> void addClientInspectCommands(@NotNull CommandDSL<S> $this$addClientInspectCommands) {
        Intrinsics.checkNotNullParameter($this$addClientInspectCommands, (String)"<this>");
        $this$addClientInspectCommands.group("inspect", ClientInspectCommands::addClientInspectCommands$lambda$0);
    }

    private static final void addClientInspectCommands$lambda$0(CommandDSL $this$group) {
        Intrinsics.checkNotNullParameter((Object)$this$group, (String)"$this$group");
        $this$group.group("tasks", ClientInspectCommands::addClientInspectCommands$lambda$0$0);
    }

    private static final void addClientInspectCommands$lambda$0$0(CommandDSL $this$group) {
        Intrinsics.checkNotNullParameter((Object)$this$group, (String)"$this$group");
        $this$group.add("client", ClientInspectCommands::addClientInspectCommands$lambda$0$0$0);
    }

    /*
     * WARNING - void declaration
     */
    private static final int addClientInspectCommands$lambda$0$0$0(CommandContext it) {
        void $this$with$iv$iv$iv;
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        Minecraft minecraft = ClientDSLKt.getMC();
        String $this$gold$iv = BCClient.INSTANCE.getQueue().size() + " tasks queued (client)";
        boolean $i$f$getGold = false;
        String $this$c$iv$iv = $this$gold$iv;
        boolean $i$f$getC = false;
        Component component = Component.nullToEmpty((String)$this$c$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)component, (String)"nullToEmpty(...)");
        Component $this$gold$iv$iv = component;
        boolean $i$f$getGold2 = false;
        Component component2 = $this$gold$iv$iv;
        ChatFormatting other$iv$iv$iv = ChatFormatting.GOLD;
        boolean $i$f$with2 = false;
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
        ClientDSLKt.chat(minecraft, (Component)mutableComponent3);
        for (QueuedTask task : BCClient.INSTANCE.getQueue()) {
            void $this$with$iv$iv$iv2;
            void $this$green$iv$iv;
            void other$iv;
            MutableComponent $this$plus$iv;
            void $this$with$iv$iv$iv3;
            void $this$aqua$iv$iv;
            Minecraft minecraft2 = ClientDSLKt.getMC();
            String $this$aqua$iv = task.getDelay() + " ticks";
            boolean $i$f$getAqua = false;
            String $this$c$iv$iv2 = $this$aqua$iv;
            boolean $i$f$getC2 = false;
            Component component3 = Component.nullToEmpty((String)$this$c$iv$iv2);
            Intrinsics.checkNotNullExpressionValue((Object)component3, (String)"nullToEmpty(...)");
            $this$c$iv$iv2 = component3;
            boolean $i$f$getAqua2 = false;
            void $i$f$with2 = $this$aqua$iv$iv;
            ChatFormatting other$iv$iv$iv2 = ChatFormatting.AQUA;
            boolean $i$f$with3 = false;
            void $this$mut$iv$iv$iv$iv2 = $this$with$iv$iv$iv3;
            boolean $i$f$mut2 = false;
            MutableComponent mutableComponent4 = $this$mut$iv$iv$iv$iv2 instanceof MutableComponent ? (MutableComponent)$this$mut$iv$iv$iv$iv2 : null;
            if (mutableComponent4 == null) {
                MutableComponent mutableComponent5 = $this$mut$iv$iv$iv$iv2.copy();
                mutableComponent4 = mutableComponent5;
                Intrinsics.checkNotNullExpressionValue((Object)mutableComponent5, (String)"copy(...)");
            }
            MutableComponent mutableComponent6 = mutableComponent4.withStyle(other$iv$iv$iv2);
            Intrinsics.checkNotNullExpressionValue((Object)mutableComponent6, (String)"withStyle(...)");
            $this$aqua$iv = mutableComponent6;
            String $this$c$iv = " - ";
            boolean $i$f$getC3 = false;
            Component component4 = Component.nullToEmpty((String)$this$c$iv);
            Intrinsics.checkNotNullExpressionValue((Object)component4, (String)"nullToEmpty(...)");
            $this$c$iv = component4;
            boolean $i$f$plus = false;
            Intrinsics.checkNotNullExpressionValue((Object)$this$plus$iv.append((Component)other$iv), (String)"append(...)");
            String string = task.getClass().getSimpleName();
            Intrinsics.checkNotNullExpressionValue((Object)string, (String)"getSimpleName(...)");
            String $this$green$iv = string;
            boolean $i$f$getGreen = false;
            String $this$c$iv$iv3 = $this$green$iv;
            boolean $i$f$getC4 = false;
            Component component5 = Component.nullToEmpty((String)$this$c$iv$iv3);
            Intrinsics.checkNotNullExpressionValue((Object)component5, (String)"nullToEmpty(...)");
            $this$c$iv$iv3 = component5;
            boolean $i$f$getGreen2 = false;
            other$iv$iv$iv2 = $this$green$iv$iv;
            ChatFormatting other$iv$iv$iv3 = ChatFormatting.GREEN;
            boolean $i$f$with4 = false;
            void $this$mut$iv$iv$iv$iv3 = $this$with$iv$iv$iv2;
            boolean $i$f$mut3 = false;
            MutableComponent mutableComponent7 = $this$mut$iv$iv$iv$iv3 instanceof MutableComponent ? (MutableComponent)$this$mut$iv$iv$iv$iv3 : null;
            if (mutableComponent7 == null) {
                MutableComponent mutableComponent8 = $this$mut$iv$iv$iv$iv3.copy();
                mutableComponent7 = mutableComponent8;
                Intrinsics.checkNotNullExpressionValue((Object)mutableComponent8, (String)"copy(...)");
            }
            MutableComponent mutableComponent9 = mutableComponent7.withStyle(other$iv$iv$iv3);
            Intrinsics.checkNotNullExpressionValue((Object)mutableComponent9, (String)"withStyle(...)");
            $this$green$iv = (Component)mutableComponent9;
            $i$f$plus = false;
            MutableComponent mutableComponent10 = $this$plus$iv.append((Component)other$iv);
            Intrinsics.checkNotNullExpressionValue((Object)mutableComponent10, (String)"append(...)");
            ClientDSLKt.chat(minecraft2, (Component)mutableComponent10);
        }
        return 0;
    }
}

