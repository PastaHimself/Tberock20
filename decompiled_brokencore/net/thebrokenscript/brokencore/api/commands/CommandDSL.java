/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.brigadier.CommandDispatcher
 *  com.mojang.brigadier.arguments.ArgumentType
 *  com.mojang.brigadier.context.CommandContext
 *  kotlin.Metadata
 *  kotlin.jvm.JvmOverloads
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.commands.SharedSuggestionProvider
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.brokencore.api.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.context.CommandContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.commands.SharedSuggestionProvider;
import net.thebrokenscript.brokencore.api.commands.CommandNode;
import net.thebrokenscript.brokencore.api.ext.MiscExt;
import net.thebrokenscript.brokencore.api.util.InstanceConsumer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000T\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\u0017\b\u0002\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007B7\b\u0017\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u0012\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00000\r\u00a2\u0006\u0004\b\u0006\u0010\u000eJ(\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u001a\u0010\u0013\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0011JW\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0015\u001a\u00020\u00162\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\u001a\u0010\u0017\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00190\u0018\"\u0006\u0012\u0002\b\u00030\u00192\u0012\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00000\rH\u0007\u00a2\u0006\u0002\u0010\u001aJ(\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0015\u001a\u00020\u00162\u0012\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00000\rJO\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0015\u001a\u00020\u00162\u001a\u0010\u001c\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00190\u0018\"\u0006\u0012\u0002\b\u00030\u00192\u0018\u0010\u001d\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0012\u0012\u0004\u0012\u00020\u000b0\u0011\u00a2\u0006\u0002\u0010\u001eJ.\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0015\u001a\u00020\u00162\u0018\u0010\u001d\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0012\u0012\u0004\u0012\u00020\u000b0\u0011J\u0006\u0010\u001f\u001a\u00020 R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R(\u0010\u000f\u001a\u001c\u0012\u0018\u0012\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u00110\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006!"}, d2={"Lnet/thebrokenscript/brokencore/api/commands/CommandDSL;", "S", "Lnet/minecraft/commands/SharedSuggestionProvider;", "", "node", "Lnet/thebrokenscript/brokencore/api/commands/CommandNode;", "<init>", "(Lnet/thebrokenscript/brokencore/api/commands/CommandNode;)V", "dispatcher", "Lcom/mojang/brigadier/CommandDispatcher;", "permissionLevel", "", "block", "Lnet/thebrokenscript/brokencore/api/util/InstanceConsumer;", "(Lcom/mojang/brigadier/CommandDispatcher;Ljava/lang/Integer;Lnet/thebrokenscript/brokencore/api/util/InstanceConsumer;)V", "beforeAll", "", "Lkotlin/Function1;", "Lcom/mojang/brigadier/context/CommandContext;", "func", "group", "template", "", "argTypes", "", "Lcom/mojang/brigadier/arguments/ArgumentType;", "(Ljava/lang/String;Ljava/lang/Integer;[Lcom/mojang/brigadier/arguments/ArgumentType;Lnet/thebrokenscript/brokencore/api/util/InstanceConsumer;)Lnet/thebrokenscript/brokencore/api/commands/CommandDSL;", "add", "types", "execute", "(Ljava/lang/String;[Lcom/mojang/brigadier/arguments/ArgumentType;Lkotlin/jvm/functions/Function1;)Lnet/thebrokenscript/brokencore/api/commands/CommandDSL;", "finish", "", "brokencore-common"})
@SourceDebugExtension(value={"SMAP\nCommandDSL.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CommandDSL.kt\nnet/thebrokenscript/brokencore/api/commands/CommandDSL\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,63:1\n1#2:64\n*E\n"})
public final class CommandDSL<S extends SharedSuggestionProvider> {
    @NotNull
    private final CommandNode<S> node;
    @NotNull
    private List<Function1<CommandContext<S>, Integer>> beforeAll;

    private CommandDSL(CommandNode<S> node) {
        this.node = node;
        this.beforeAll = new ArrayList();
    }

    @JvmOverloads
    public CommandDSL(@NotNull CommandDispatcher<S> dispatcher, @Nullable Integer permissionLevel, @NotNull InstanceConsumer<CommandDSL<S>> block2) {
        Intrinsics.checkNotNullParameter(dispatcher, (String)"dispatcher");
        Intrinsics.checkNotNullParameter(block2, (String)"block");
        this(CommandNode.Companion.create(dispatcher, permissionLevel));
        MiscExt.gluedApply(this, block2);
        this.finish();
    }

    public /* synthetic */ CommandDSL(CommandDispatcher commandDispatcher, Integer n, InstanceConsumer instanceConsumer, int n2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n2 & 2) != 0) {
            n = null;
        }
        this(commandDispatcher, n, instanceConsumer);
    }

    @NotNull
    public final CommandDSL<S> beforeAll(@NotNull Function1<? super CommandContext<S>, Integer> func) {
        CommandDSL commandDSL;
        Intrinsics.checkNotNullParameter(func, (String)"func");
        CommandDSL $this$beforeAll_u24lambda_u240 = commandDSL = this;
        boolean bl = false;
        $this$beforeAll_u24lambda_u240.beforeAll.add(func);
        return commandDSL;
    }

    @JvmOverloads
    @NotNull
    public final CommandDSL<S> group(@NotNull String template, @Nullable Integer permissionLevel, @NotNull ArgumentType<?>[] argTypes, @NotNull InstanceConsumer<CommandDSL<S>> block2) {
        CommandDSL<S> commandDSL;
        CommandDSL commandDSL2;
        Intrinsics.checkNotNullParameter((Object)template, (String)"template");
        Intrinsics.checkNotNullParameter(argTypes, (String)"argTypes");
        Intrinsics.checkNotNullParameter(block2, (String)"block");
        CommandDSL $this$group_u24lambda_u240 = commandDSL2 = this;
        boolean bl = false;
        CommandDSL<S> it = commandDSL = new CommandDSL<S>($this$group_u24lambda_u240.node.child(template, permissionLevel, Arrays.copyOf(argTypes, argTypes.length)));
        boolean bl2 = false;
        it.beforeAll.addAll((Collection)$this$group_u24lambda_u240.beforeAll);
        MiscExt.gluedApply(commandDSL, block2).finish();
        return commandDSL2;
    }

    public static /* synthetic */ CommandDSL group$default(CommandDSL commandDSL, String string, Integer n, ArgumentType[] argumentTypeArray, InstanceConsumer instanceConsumer, int n2, Object object) {
        if ((n2 & 2) != 0) {
            n = null;
        }
        return commandDSL.group(string, n, argumentTypeArray, instanceConsumer);
    }

    @NotNull
    public final CommandDSL<S> group(@NotNull String template, @NotNull InstanceConsumer<CommandDSL<S>> block2) {
        CommandDSL<S> commandDSL;
        CommandDSL commandDSL2;
        Intrinsics.checkNotNullParameter((Object)template, (String)"template");
        Intrinsics.checkNotNullParameter(block2, (String)"block");
        CommandDSL $this$group_u24lambda_u241 = commandDSL2 = this;
        boolean bl = false;
        CommandDSL<S> it = commandDSL = new CommandDSL<S>(CommandNode.child$default($this$group_u24lambda_u241.node, template, null, new ArgumentType[0], 2, null));
        boolean bl2 = false;
        it.beforeAll.addAll((Collection)$this$group_u24lambda_u241.beforeAll);
        MiscExt.gluedApply(commandDSL, block2).finish();
        return commandDSL2;
    }

    @NotNull
    public final CommandDSL<S> add(@NotNull String template, @NotNull ArgumentType<?>[] types, @NotNull Function1<? super CommandContext<S>, Integer> execute) {
        CommandDSL commandDSL;
        Intrinsics.checkNotNullParameter((Object)template, (String)"template");
        Intrinsics.checkNotNullParameter(types, (String)"types");
        Intrinsics.checkNotNullParameter(execute, (String)"execute");
        CommandDSL $this$add_u24lambda_u240 = commandDSL = this;
        boolean bl = false;
        $this$add_u24lambda_u240.node.add(template, Arrays.copyOf(types, types.length), arg_0 -> CommandDSL.add$lambda$0$0($this$add_u24lambda_u240, execute, arg_0));
        return commandDSL;
    }

    @NotNull
    public final CommandDSL<S> add(@NotNull String template, @NotNull Function1<? super CommandContext<S>, Integer> execute) {
        CommandDSL commandDSL;
        Intrinsics.checkNotNullParameter((Object)template, (String)"template");
        Intrinsics.checkNotNullParameter(execute, (String)"execute");
        CommandDSL $this$add_u24lambda_u241 = commandDSL = this;
        boolean bl = false;
        $this$add_u24lambda_u241.node.add(template, new ArgumentType[0], arg_0 -> CommandDSL.add$lambda$1$0($this$add_u24lambda_u241, execute, arg_0));
        return commandDSL;
    }

    public final void finish() {
        this.node.finish();
    }

    @JvmOverloads
    public CommandDSL(@NotNull CommandDispatcher<S> dispatcher, @NotNull InstanceConsumer<CommandDSL<S>> block2) {
        Intrinsics.checkNotNullParameter(dispatcher, (String)"dispatcher");
        Intrinsics.checkNotNullParameter(block2, (String)"block");
        this(dispatcher, null, block2, 2, null);
    }

    @JvmOverloads
    @NotNull
    public final CommandDSL<S> group(@NotNull String template, @NotNull ArgumentType<?>[] argTypes, @NotNull InstanceConsumer<CommandDSL<S>> block2) {
        Intrinsics.checkNotNullParameter((Object)template, (String)"template");
        Intrinsics.checkNotNullParameter(argTypes, (String)"argTypes");
        Intrinsics.checkNotNullParameter(block2, (String)"block");
        return CommandDSL.group$default(this, template, null, argTypes, block2, 2, null);
    }

    private static final int add$lambda$0$0(CommandDSL $this_apply, Function1 $execute, CommandContext it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        for (Function1 func : $this_apply.beforeAll) {
            Integer n = (Integer)func.invoke((Object)it);
            if (n == null) continue;
            int res = ((Number)n).intValue();
            boolean bl = false;
            return res;
        }
        return ((Number)$execute.invoke((Object)it)).intValue();
    }

    private static final int add$lambda$1$0(CommandDSL $this_apply, Function1 $execute, CommandContext it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        for (Function1 func : $this_apply.beforeAll) {
            Integer n = (Integer)func.invoke((Object)it);
            if (n == null) continue;
            int res = ((Number)n).intValue();
            boolean bl = false;
            return res;
        }
        return ((Number)$execute.invoke((Object)it)).intValue();
    }
}

