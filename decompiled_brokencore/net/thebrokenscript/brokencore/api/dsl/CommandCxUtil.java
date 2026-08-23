/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.brigadier.context.CommandContext
 *  kotlin.Metadata
 *  kotlin.jvm.JvmName
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.ChatFormatting
 *  net.minecraft.commands.CommandSourceStack
 *  net.minecraft.network.chat.Component
 *  net.minecraft.network.chat.MutableComponent
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.dsl;

import com.mojang.brigadier.context.CommandContext;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.ChatFormatting;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=2, xi=48, d1={"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\b\u001a\"\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u001a\"\u0010\u0000\u001a\u00020\u0001*\u00020\b2\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u001a\"\u0010\t\u001a\u00020\u0001*\u00020\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u001a\"\u0010\t\u001a\u00020\u0001*\u00020\b2\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u001a\u001c\u0010\n\u001a\u00020\u0001*\u00020\u00052\u0006\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u001a\u001c\u0010\f\u001a\u00020\u0001*\u00020\u00052\u0006\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u001a\u001c\u0010\r\u001a\u00020\u0001*\u00020\u00052\u0006\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u001a\u001c\u0010\n\u001a\u00020\u0001*\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u001a\u001c\u0010\f\u001a\u00020\u0001*\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u001a\u001c\u0010\r\u001a\u00020\u0001*\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u001a\u0012\u0010\u000e\u001a\u00020\u0001*\u00020\u00052\u0006\u0010\u000b\u001a\u00020\b\u001a\u0012\u0010\u000e\u001a\u00020\u0001*\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0002\u001a\"\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u001a\"\u0010\u000f\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u001a\"\u0010\t\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u001a\"\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u001a\"\u0010\u000f\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u001a\"\u0010\t\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u001a\u0018\u0010\u000e\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u000b\u001a\u00020\b\u001a\u0018\u0010\u000e\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u000b\u001a\u00020\u0002\u00a8\u0006\u0010"}, d2={"fail", "", "", "cx", "Lcom/mojang/brigadier/context/CommandContext;", "Lnet/minecraft/commands/CommandSourceStack;", "styled", "", "Lnet/minecraft/network/chat/Component;", "success", "sendFailure", "msg", "sendWarning", "sendSuccess", "send", "warn", "brokencore-common"})
@JvmName(name="CommandCxUtil")
@SourceDebugExtension(value={"SMAP\nCommandCxDSL.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CommandCxDSL.kt\nnet/thebrokenscript/brokencore/api/dsl/CommandCxUtil\n+ 2 ComponentDSL.kt\nnet/thebrokenscript/brokencore/api/dsl/ComponentUtil\n*L\n1#1,45:1\n72#2:46\n15#2:47\n49#2:48\n29#2:49\n24#2:50\n15#2:51\n49#2:52\n29#2:53\n24#2:54\n70#2:55\n15#2:56\n47#2:57\n29#2:58\n24#2:59\n15#2:60\n47#2:61\n29#2:62\n24#2:63\n49#2:64\n29#2:65\n24#2:66\n51#2:67\n29#2:68\n24#2:69\n15#2:70\n15#2:71\n15#2:72\n15#2:73\n47#2:74\n29#2:75\n24#2:76\n*S KotlinDebug\n*F\n+ 1 CommandCxDSL.kt\nnet/thebrokenscript/brokencore/api/dsl/CommandCxUtil\n*L\n11#1:46\n11#1:47\n11#1:48\n11#1:49\n11#1:50\n11#1:51\n14#1:52\n14#1:53\n14#1:54\n17#1:55\n17#1:56\n17#1:57\n17#1:58\n17#1:59\n17#1:60\n20#1:61\n20#1:62\n20#1:63\n22#1:64\n22#1:65\n22#1:66\n23#1:67\n23#1:68\n23#1:69\n27#1:70\n28#1:71\n29#1:72\n32#1:73\n25#1:74\n25#1:75\n25#1:76\n*E\n"})
public final class CommandCxUtil {
    /*
     * WARNING - void declaration
     */
    public static final void fail(@NotNull String $this$fail, @NotNull CommandContext<CommandSourceStack> cx, boolean styled) {
        Component component;
        Intrinsics.checkNotNullParameter((Object)$this$fail, (String)"<this>");
        Intrinsics.checkNotNullParameter(cx, (String)"cx");
        CommandSourceStack commandSourceStack = (CommandSourceStack)cx.getSource();
        if (styled) {
            void $this$with$iv$iv$iv;
            void $this$red$iv$iv;
            String $this$red$iv = $this$fail;
            boolean $i$f$getRed = false;
            String $this$c$iv$iv = $this$red$iv;
            boolean $i$f$getC = false;
            Component component2 = Component.nullToEmpty((String)$this$c$iv$iv);
            Intrinsics.checkNotNullExpressionValue((Object)component2, (String)"nullToEmpty(...)");
            $this$c$iv$iv = component2;
            boolean $i$f$getRed2 = false;
            void var7_9 = $this$red$iv$iv;
            ChatFormatting other$iv$iv$iv = ChatFormatting.RED;
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
            component = (Component)mutableComponent3;
        } else {
            String $this$c$iv = $this$fail;
            boolean $i$f$getC = false;
            Component component3 = Component.nullToEmpty((String)$this$c$iv);
            component = component3;
            Intrinsics.checkNotNullExpressionValue((Object)component3, (String)"nullToEmpty(...)");
        }
        commandSourceStack.sendFailure(component);
    }

    public static /* synthetic */ void fail$default(String string, CommandContext commandContext, boolean bl, int n, Object object) {
        if ((n & 2) != 0) {
            bl = true;
        }
        CommandCxUtil.fail(string, (CommandContext<CommandSourceStack>)commandContext, bl);
    }

    /*
     * WARNING - void declaration
     */
    public static final void fail(@NotNull Component $this$fail, @NotNull CommandContext<CommandSourceStack> cx, boolean styled) {
        Component component;
        Intrinsics.checkNotNullParameter((Object)$this$fail, (String)"<this>");
        Intrinsics.checkNotNullParameter(cx, (String)"cx");
        CommandSourceStack commandSourceStack = (CommandSourceStack)cx.getSource();
        if (styled) {
            void $this$with$iv$iv;
            Component $this$red$iv = $this$fail;
            boolean $i$f$getRed = false;
            Component component2 = $this$red$iv;
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
            component = (Component)mutableComponent3;
        } else {
            component = $this$fail;
        }
        commandSourceStack.sendFailure(component);
    }

    public static /* synthetic */ void fail$default(Component component, CommandContext commandContext, boolean bl, int n, Object object) {
        if ((n & 2) != 0) {
            bl = true;
        }
        CommandCxUtil.fail(component, (CommandContext<CommandSourceStack>)commandContext, bl);
    }

    /*
     * WARNING - void declaration
     */
    public static final void success(@NotNull String $this$success, @NotNull CommandContext<CommandSourceStack> cx, boolean styled) {
        Component component;
        Intrinsics.checkNotNullParameter((Object)$this$success, (String)"<this>");
        Intrinsics.checkNotNullParameter(cx, (String)"cx");
        Object object = cx.getSource();
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"getSource(...)");
        CommandSourceStack commandSourceStack = (CommandSourceStack)object;
        if (styled) {
            void $this$with$iv$iv$iv;
            void $this$green$iv$iv;
            String $this$green$iv = $this$success;
            boolean $i$f$getGreen = false;
            String $this$c$iv$iv = $this$green$iv;
            boolean $i$f$getC = false;
            Component component2 = Component.nullToEmpty((String)$this$c$iv$iv);
            Intrinsics.checkNotNullExpressionValue((Object)component2, (String)"nullToEmpty(...)");
            $this$c$iv$iv = component2;
            boolean $i$f$getGreen2 = false;
            void var7_9 = $this$green$iv$iv;
            ChatFormatting other$iv$iv$iv = ChatFormatting.GREEN;
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
            component = (Component)mutableComponent3;
        } else {
            String $this$c$iv = $this$success;
            boolean $i$f$getC = false;
            Component component3 = Component.nullToEmpty((String)$this$c$iv);
            component = component3;
            Intrinsics.checkNotNullExpressionValue((Object)component3, (String)"nullToEmpty(...)");
        }
        CommandCxUtil.sendSuccess$default(commandSourceStack, component, false, 2, null);
    }

    public static /* synthetic */ void success$default(String string, CommandContext commandContext, boolean bl, int n, Object object) {
        if ((n & 2) != 0) {
            bl = true;
        }
        CommandCxUtil.success(string, (CommandContext<CommandSourceStack>)commandContext, bl);
    }

    /*
     * WARNING - void declaration
     */
    public static final void success(@NotNull Component $this$success, @NotNull CommandContext<CommandSourceStack> cx, boolean styled) {
        Component component;
        Intrinsics.checkNotNullParameter((Object)$this$success, (String)"<this>");
        Intrinsics.checkNotNullParameter(cx, (String)"cx");
        Object object = cx.getSource();
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"getSource(...)");
        CommandSourceStack commandSourceStack = (CommandSourceStack)object;
        if (styled) {
            void $this$with$iv$iv;
            Component $this$green$iv = $this$success;
            boolean $i$f$getGreen = false;
            Component component2 = $this$green$iv;
            ChatFormatting other$iv$iv = ChatFormatting.GREEN;
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
            component = (Component)mutableComponent3;
        } else {
            component = $this$success;
        }
        CommandCxUtil.sendSuccess$default(commandSourceStack, component, false, 2, null);
    }

    public static /* synthetic */ void success$default(Component component, CommandContext commandContext, boolean bl, int n, Object object) {
        if ((n & 2) != 0) {
            bl = true;
        }
        CommandCxUtil.success(component, (CommandContext<CommandSourceStack>)commandContext, bl);
    }

    /*
     * WARNING - void declaration
     */
    public static final void sendFailure(@NotNull CommandSourceStack $this$sendFailure, @NotNull Component msg, boolean styled) {
        Component component;
        Intrinsics.checkNotNullParameter((Object)$this$sendFailure, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)msg, (String)"msg");
        if (styled) {
            void $this$with$iv$iv;
            Component $this$red$iv = msg;
            boolean $i$f$getRed = false;
            Component component2 = $this$red$iv;
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
            component = (Component)mutableComponent3;
        } else {
            component = msg;
        }
        $this$sendFailure.sendFailure(component);
    }

    public static /* synthetic */ void sendFailure$default(CommandSourceStack commandSourceStack, Component component, boolean bl, int n, Object object) {
        if ((n & 2) != 0) {
            bl = true;
        }
        CommandCxUtil.sendFailure(commandSourceStack, component, bl);
    }

    /*
     * WARNING - void declaration
     */
    public static final void sendWarning(@NotNull CommandSourceStack $this$sendWarning, @NotNull Component msg, boolean styled) {
        Component component;
        Intrinsics.checkNotNullParameter((Object)$this$sendWarning, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)msg, (String)"msg");
        if (styled) {
            void $this$with$iv$iv;
            Component $this$yellow$iv = msg;
            boolean $i$f$getYellow = false;
            Component component2 = $this$yellow$iv;
            ChatFormatting other$iv$iv = ChatFormatting.YELLOW;
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
            component = (Component)mutableComponent3;
        } else {
            component = msg;
        }
        CommandCxUtil.send($this$sendWarning, component);
    }

    public static /* synthetic */ void sendWarning$default(CommandSourceStack commandSourceStack, Component component, boolean bl, int n, Object object) {
        if ((n & 2) != 0) {
            bl = true;
        }
        CommandCxUtil.sendWarning(commandSourceStack, component, bl);
    }

    public static final void sendSuccess(@NotNull CommandSourceStack $this$sendSuccess, @NotNull Component msg, boolean styled) {
        Intrinsics.checkNotNullParameter((Object)$this$sendSuccess, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)msg, (String)"msg");
        $this$sendSuccess.sendSuccess(() -> CommandCxUtil.sendSuccess$lambda$0(styled, msg), true);
    }

    public static /* synthetic */ void sendSuccess$default(CommandSourceStack commandSourceStack, Component component, boolean bl, int n, Object object) {
        if ((n & 2) != 0) {
            bl = true;
        }
        CommandCxUtil.sendSuccess(commandSourceStack, component, bl);
    }

    public static final void sendFailure(@NotNull CommandSourceStack $this$sendFailure, @NotNull String msg, boolean styled) {
        Intrinsics.checkNotNullParameter((Object)$this$sendFailure, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)msg, (String)"msg");
        String $this$c$iv = msg;
        boolean $i$f$getC = false;
        Component component = Component.nullToEmpty((String)$this$c$iv);
        Intrinsics.checkNotNullExpressionValue((Object)component, (String)"nullToEmpty(...)");
        CommandCxUtil.sendFailure($this$sendFailure, component, styled);
    }

    public static /* synthetic */ void sendFailure$default(CommandSourceStack commandSourceStack, String string, boolean bl, int n, Object object) {
        if ((n & 2) != 0) {
            bl = true;
        }
        CommandCxUtil.sendFailure(commandSourceStack, string, bl);
    }

    public static final void sendWarning(@NotNull CommandSourceStack $this$sendWarning, @NotNull String msg, boolean styled) {
        Intrinsics.checkNotNullParameter((Object)$this$sendWarning, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)msg, (String)"msg");
        String $this$c$iv = msg;
        boolean $i$f$getC = false;
        Component component = Component.nullToEmpty((String)$this$c$iv);
        Intrinsics.checkNotNullExpressionValue((Object)component, (String)"nullToEmpty(...)");
        CommandCxUtil.sendWarning($this$sendWarning, component, styled);
    }

    public static /* synthetic */ void sendWarning$default(CommandSourceStack commandSourceStack, String string, boolean bl, int n, Object object) {
        if ((n & 2) != 0) {
            bl = true;
        }
        CommandCxUtil.sendWarning(commandSourceStack, string, bl);
    }

    public static final void sendSuccess(@NotNull CommandSourceStack $this$sendSuccess, @NotNull String msg, boolean styled) {
        Intrinsics.checkNotNullParameter((Object)$this$sendSuccess, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)msg, (String)"msg");
        String $this$c$iv = msg;
        boolean $i$f$getC = false;
        Component component = Component.nullToEmpty((String)$this$c$iv);
        Intrinsics.checkNotNullExpressionValue((Object)component, (String)"nullToEmpty(...)");
        CommandCxUtil.sendSuccess($this$sendSuccess, component, styled);
    }

    public static /* synthetic */ void sendSuccess$default(CommandSourceStack commandSourceStack, String string, boolean bl, int n, Object object) {
        if ((n & 2) != 0) {
            bl = true;
        }
        CommandCxUtil.sendSuccess(commandSourceStack, string, bl);
    }

    public static final void send(@NotNull CommandSourceStack $this$send, @NotNull Component msg) {
        Intrinsics.checkNotNullParameter((Object)$this$send, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)msg, (String)"msg");
        $this$send.sendSystemMessage(msg);
    }

    public static final void send(@NotNull CommandSourceStack $this$send, @NotNull String msg) {
        Intrinsics.checkNotNullParameter((Object)$this$send, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)msg, (String)"msg");
        String $this$c$iv = msg;
        boolean $i$f$getC = false;
        Component component = Component.nullToEmpty((String)$this$c$iv);
        Intrinsics.checkNotNullExpressionValue((Object)component, (String)"nullToEmpty(...)");
        CommandCxUtil.send($this$send, component);
    }

    public static final void fail(@NotNull CommandContext<CommandSourceStack> $this$fail, @NotNull Component msg, boolean styled) {
        Intrinsics.checkNotNullParameter($this$fail, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)msg, (String)"msg");
        Object object = $this$fail.getSource();
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"getSource(...)");
        CommandCxUtil.sendFailure((CommandSourceStack)object, msg, styled);
    }

    public static /* synthetic */ void fail$default(CommandContext commandContext, Component component, boolean bl, int n, Object object) {
        if ((n & 2) != 0) {
            bl = true;
        }
        CommandCxUtil.fail((CommandContext<CommandSourceStack>)commandContext, component, bl);
    }

    public static final void warn(@NotNull CommandContext<CommandSourceStack> $this$warn, @NotNull Component msg, boolean styled) {
        Intrinsics.checkNotNullParameter($this$warn, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)msg, (String)"msg");
        Object object = $this$warn.getSource();
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"getSource(...)");
        CommandCxUtil.sendWarning((CommandSourceStack)object, msg, styled);
    }

    public static /* synthetic */ void warn$default(CommandContext commandContext, Component component, boolean bl, int n, Object object) {
        if ((n & 2) != 0) {
            bl = true;
        }
        CommandCxUtil.warn((CommandContext<CommandSourceStack>)commandContext, component, bl);
    }

    public static final void success(@NotNull CommandContext<CommandSourceStack> $this$success, @NotNull Component msg, boolean styled) {
        Intrinsics.checkNotNullParameter($this$success, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)msg, (String)"msg");
        Object object = $this$success.getSource();
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"getSource(...)");
        CommandCxUtil.sendSuccess((CommandSourceStack)object, msg, styled);
    }

    public static /* synthetic */ void success$default(CommandContext commandContext, Component component, boolean bl, int n, Object object) {
        if ((n & 2) != 0) {
            bl = true;
        }
        CommandCxUtil.success((CommandContext<CommandSourceStack>)commandContext, component, bl);
    }

    public static final void fail(@NotNull CommandContext<CommandSourceStack> $this$fail, @NotNull String msg, boolean styled) {
        Intrinsics.checkNotNullParameter($this$fail, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)msg, (String)"msg");
        Object object = $this$fail.getSource();
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"getSource(...)");
        CommandCxUtil.sendFailure((CommandSourceStack)object, msg, styled);
    }

    public static /* synthetic */ void fail$default(CommandContext commandContext, String string, boolean bl, int n, Object object) {
        if ((n & 2) != 0) {
            bl = true;
        }
        CommandCxUtil.fail((CommandContext<CommandSourceStack>)commandContext, string, bl);
    }

    public static final void warn(@NotNull CommandContext<CommandSourceStack> $this$warn, @NotNull String msg, boolean styled) {
        Intrinsics.checkNotNullParameter($this$warn, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)msg, (String)"msg");
        Object object = $this$warn.getSource();
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"getSource(...)");
        CommandCxUtil.sendWarning((CommandSourceStack)object, msg, styled);
    }

    public static /* synthetic */ void warn$default(CommandContext commandContext, String string, boolean bl, int n, Object object) {
        if ((n & 2) != 0) {
            bl = true;
        }
        CommandCxUtil.warn((CommandContext<CommandSourceStack>)commandContext, string, bl);
    }

    public static final void success(@NotNull CommandContext<CommandSourceStack> $this$success, @NotNull String msg, boolean styled) {
        Intrinsics.checkNotNullParameter($this$success, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)msg, (String)"msg");
        Object object = $this$success.getSource();
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"getSource(...)");
        CommandCxUtil.sendSuccess((CommandSourceStack)object, msg, styled);
    }

    public static /* synthetic */ void success$default(CommandContext commandContext, String string, boolean bl, int n, Object object) {
        if ((n & 2) != 0) {
            bl = true;
        }
        CommandCxUtil.success((CommandContext<CommandSourceStack>)commandContext, string, bl);
    }

    public static final void send(@NotNull CommandContext<CommandSourceStack> $this$send, @NotNull Component msg) {
        Intrinsics.checkNotNullParameter($this$send, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)msg, (String)"msg");
        Object object = $this$send.getSource();
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"getSource(...)");
        CommandCxUtil.send((CommandSourceStack)object, msg);
    }

    public static final void send(@NotNull CommandContext<CommandSourceStack> $this$send, @NotNull String msg) {
        Intrinsics.checkNotNullParameter($this$send, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)msg, (String)"msg");
        Object object = $this$send.getSource();
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"getSource(...)");
        CommandCxUtil.send((CommandSourceStack)object, msg);
    }

    /*
     * WARNING - void declaration
     */
    private static final Component sendSuccess$lambda$0(boolean $styled, Component $msg) {
        Component component;
        if ($styled) {
            void $this$with$iv$iv;
            Component $this$green$iv = $msg;
            boolean $i$f$getGreen = false;
            Component component2 = $this$green$iv;
            ChatFormatting other$iv$iv = ChatFormatting.GREEN;
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
            component = (Component)mutableComponent3;
        } else {
            component = $msg;
        }
        return component;
    }
}

