/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.brigadier.Command
 *  com.mojang.brigadier.CommandDispatcher
 *  com.mojang.brigadier.arguments.ArgumentType
 *  com.mojang.brigadier.builder.ArgumentBuilder
 *  com.mojang.brigadier.builder.LiteralArgumentBuilder
 *  com.mojang.brigadier.context.CommandContext
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.TuplesKt
 *  kotlin.collections.CollectionsKt
 *  kotlin.collections.MapsKt
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.text.StringsKt
 *  net.minecraft.commands.SharedSuggestionProvider
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.brokencore.api.commands;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.builder.ArgumentBuilder;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import net.minecraft.commands.SharedSuggestionProvider;
import net.thebrokenscript.brokencore.api.commands.CommandPart;
import net.thebrokenscript.brokencore.api.commands.CommandUtil;
import net.thebrokenscript.brokencore.api.commands.PartType;
import net.thebrokenscript.brokencore.api.commands.SuggestingArgument;
import net.thebrokenscript.brokencore.api.ext.MiscExt;
import net.thebrokenscript.brokencore.api.ext.StringExtKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000d\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 (*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003:\u0001(B[\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012.\b\u0002\u0010\u0006\u001a(\u0012\u0004\u0012\u00028\u0000\u0012\u0010\b\u0001\u0012\f\u0012\u0004\u0012\u00028\u0000\u0012\u0002\b\u00030\u0007\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0083\u0001\u0010\u0017\u001a6\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0012\u0012&\u0012$\u0012\u0004\u0012\u00028\u0000\u0012\u0010\b\u0001\u0012\f\u0012\u0004\u0012\u00028\u0000\u0012\u0002\b\u00030\u00070\u0007j\b\u0012\u0004\u0012\u00028\u0000`\b0\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u001a\u0010\u001b\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u001d0\u001c\"\u0006\u0012\u0002\b\u00030\u001d2\u001c\b\u0002\u0010\u001e\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000 \u0012\u0004\u0012\u00020\f\u0018\u00010\u001fH\u0002\u00a2\u0006\u0002\u0010!JI\u0010\"\u001a\u00020#2\u0006\u0010\u0019\u001a\u00020\u001a2\u001a\u0010\u001b\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u001d0\u001c\"\u0006\u0012\u0002\b\u00030\u001d2\u0018\u0010\u001e\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000 \u0012\u0004\u0012\u00020\f0\u001f\u00a2\u0006\u0002\u0010$JA\u0010%\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0019\u001a\u00020\u001a2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\u001a\u0010\u001b\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u001d0\u001c\"\u0006\u0012\u0002\b\u00030\u001d\u00a2\u0006\u0002\u0010&J\u0006\u0010'\u001a\u00020#R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R4\u0010\u0006\u001a(\u0012\u0004\u0012\u00028\u0000\u0012\u0010\b\u0001\u0012\f\u0012\u0004\u0012\u00028\u0000\u0012\u0002\b\u00030\u0007\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u000fR&\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00120\u0011X\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016\u00a8\u0006)"}, d2={"Lnet/thebrokenscript/brokencore/api/commands/CommandNode;", "S", "Lnet/minecraft/commands/SharedSuggestionProvider;", "", "dispatcher", "Lcom/mojang/brigadier/CommandDispatcher;", "parent", "Lcom/mojang/brigadier/builder/ArgumentBuilder;", "Lnet/thebrokenscript/brokencore/api/commands/CommandArg;", "isRoot", "", "permissionLevel", "", "<init>", "(Lcom/mojang/brigadier/CommandDispatcher;Lcom/mojang/brigadier/builder/ArgumentBuilder;ZLjava/lang/Integer;)V", "Ljava/lang/Integer;", "roots", "", "Lcom/mojang/brigadier/builder/LiteralArgumentBuilder;", "getRoots$brokencore_common", "()Ljava/util/List;", "setRoots$brokencore_common", "(Ljava/util/List;)V", "buildCommand", "Lkotlin/Pair;", "cmd", "", "argTypes", "", "Lcom/mojang/brigadier/arguments/ArgumentType;", "executes", "Lkotlin/Function1;", "Lcom/mojang/brigadier/context/CommandContext;", "(Ljava/lang/String;[Lcom/mojang/brigadier/arguments/ArgumentType;Lkotlin/jvm/functions/Function1;)Lkotlin/Pair;", "add", "", "(Ljava/lang/String;[Lcom/mojang/brigadier/arguments/ArgumentType;Lkotlin/jvm/functions/Function1;)V", "child", "(Ljava/lang/String;Ljava/lang/Integer;[Lcom/mojang/brigadier/arguments/ArgumentType;)Lnet/thebrokenscript/brokencore/api/commands/CommandNode;", "finish", "Companion", "brokencore-common"})
@SourceDebugExtension(value={"SMAP\nCommandNode.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CommandNode.kt\nnet/thebrokenscript/brokencore/api/commands/CommandNode\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,105:1\n1#2:106\n774#3:107\n865#3,2:108\n1563#3:110\n1634#3,3:111\n1563#3:114\n1634#3,3:115\n1563#3:118\n1634#3,3:119\n1803#3,3:122\n1869#3,2:125\n1869#3,2:127\n*S KotlinDebug\n*F\n+ 1 CommandNode.kt\nnet/thebrokenscript/brokencore/api/commands/CommandNode\n*L\n37#1:107\n37#1:108,2\n37#1:110\n37#1:111,3\n47#1:114\n47#1:115,3\n65#1:118\n65#1:119,3\n82#1:122,3\n96#1:125,2\n97#1:127,2\n*E\n"})
public final class CommandNode<S extends SharedSuggestionProvider> {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final CommandDispatcher<S> dispatcher;
    @Nullable
    private ArgumentBuilder<S, ? extends ArgumentBuilder<S, ?>> parent;
    private final boolean isRoot;
    @Nullable
    private final Integer permissionLevel;
    @NotNull
    private List<LiteralArgumentBuilder<S>> roots;

    public CommandNode(@NotNull CommandDispatcher<S> dispatcher, @Nullable ArgumentBuilder<S, ? extends ArgumentBuilder<S, ?>> parent, boolean isRoot, @Nullable Integer permissionLevel) {
        Intrinsics.checkNotNullParameter(dispatcher, (String)"dispatcher");
        this.dispatcher = dispatcher;
        this.parent = parent;
        this.isRoot = isRoot;
        this.permissionLevel = permissionLevel;
        this.roots = new ArrayList();
    }

    public /* synthetic */ CommandNode(CommandDispatcher commandDispatcher, ArgumentBuilder argumentBuilder, boolean bl, Integer n, int n2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n2 & 2) != 0) {
            argumentBuilder = null;
        }
        if ((n2 & 4) != 0) {
            bl = false;
        }
        if ((n2 & 8) != 0) {
            n = null;
        }
        this(commandDispatcher, argumentBuilder, bl, n);
    }

    @NotNull
    public final List<LiteralArgumentBuilder<S>> getRoots$brokencore_common() {
        return this.roots;
    }

    public final void setRoots$brokencore_common(@NotNull List<LiteralArgumentBuilder<S>> list) {
        Intrinsics.checkNotNullParameter(list, (String)"<set-?>");
        this.roots = list;
    }

    /*
     * WARNING - void declaration
     */
    private final Pair<LiteralArgumentBuilder<S>, ArgumentBuilder<S, ? extends ArgumentBuilder<S, ?>>> buildCommand(String cmd, ArgumentType<?>[] argTypes, Function1<? super CommandContext<S>, Integer> executes) {
        void $this$fold$iv;
        boolean bl;
        Function1<? super CommandContext<S>, Integer> it;
        Object[] $this$mapTo$iv$iv;
        Collection collection;
        void $this$mapTo$iv$iv2;
        void $this$map$iv;
        CommandPart it2;
        void $this$filterTo$iv$iv;
        Object object;
        String[] stringArray = new String[]{" "};
        List bits = CollectionsKt.toMutableList((Collection)StringsKt.split$default((CharSequence)StringsKt.removePrefix((String)cmd, (CharSequence)"/"), (String[])stringArray, (boolean)false, (int)0, (int)6, null));
        List parts = new ArrayList();
        for (Object e : bits) {
            Intrinsics.checkNotNullExpressionValue(e, (String)"next(...)");
            String bit = (String)e;
            Collection collection2 = parts;
            object = StringExtKt.isSurrounded(bit, "[", "]") ? new CommandPart(PartType.ARGUMENT, StringsKt.removeSurrounding((String)bit, (CharSequence)"[", (CharSequence)"]"), null, 4, null) : new CommandPart(PartType.LITERAL, bit, null, 4, null);
            collection2.add(object);
        }
        if (!(!((Collection)parts).isEmpty())) {
            boolean $i$a$-check-CommandNode$buildCommand$332 = false;
            String $i$a$-check-CommandNode$buildCommand$332 = "Commands must not be empty!";
            throw new IllegalStateException($i$a$-check-CommandNode$buildCommand$332.toString());
        }
        Iterable $this$filter$iv = parts;
        boolean $i$f$filter = false;
        object = $this$filter$iv;
        Collection destination$iv$iv = new ArrayList();
        boolean $i$f$filterTo = false;
        for (Object element$iv$iv : $this$filterTo$iv$iv) {
            it2 = (CommandPart)element$iv$iv;
            boolean bl2 = false;
            if (!(it2.getType() == PartType.ARGUMENT)) continue;
            destination$iv$iv.add(element$iv$iv);
        }
        $this$filter$iv = (List)destination$iv$iv;
        boolean $i$f$map = false;
        $this$filterTo$iv$iv = $this$map$iv;
        destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map$iv, (int)10));
        boolean $i$f$mapTo232 = false;
        for (Object item$iv$iv : $this$mapTo$iv$iv2) {
            Iterator it3;
            it2 = (CommandPart)item$iv$iv;
            collection = destination$iv$iv;
            boolean bl3 = false;
            collection.add(((CommandPart)((Object)it3)).getName());
        }
        List argNames = (List)destination$iv$iv;
        if (!(argNames.size() == argTypes.length)) {
            boolean $i$a$-check-CommandNode$buildCommand$432 = false;
            String $i$a$-check-CommandNode$buildCommand$432 = "There must be one argument type for every argument!";
            throw new IllegalStateException($i$a$-check-CommandNode$buildCommand$432.toString());
        }
        Map argsMap = MapsKt.toMap((Iterable)CollectionsKt.zip((Iterable)argNames, (Object[])argTypes));
        for (CommandPart part : parts) {
            if (part.getType() != PartType.ARGUMENT) continue;
            part.setArgument((ArgumentType)argsMap.get(part.getName()));
        }
        Iterable $this$map$iv2 = parts;
        boolean $i$f$map2 = false;
        Iterable $i$f$mapTo232 = $this$map$iv2;
        Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map$iv2, (int)10));
        boolean $i$f$mapTo = false;
        for (Object t : $this$mapTo$iv$iv) {
            ArgumentBuilder argumentBuilder;
            CommandPart commandPart = (CommandPart)t;
            collection = destination$iv$iv2;
            boolean bl4 = false;
            ArgumentType<?> argumentType = it.getArgument();
            SuggestingArgument arg = argumentType instanceof SuggestingArgument ? (SuggestingArgument)argumentType : null;
            if (it.getType() == PartType.LITERAL) {
                argumentBuilder = (ArgumentBuilder)CommandUtil.INSTANCE.literal(it.getName());
            } else if (arg != null) {
                argumentBuilder = (ArgumentBuilder)CommandUtil.INSTANCE.argument(it.getName(), arg.getArg()).suggests(arg.getSuggester());
            } else {
                String string = it.getName();
                ArgumentType<?> argumentType2 = it.getArgument();
                Intrinsics.checkNotNull(argumentType2, (String)"null cannot be cast to non-null type com.mojang.brigadier.arguments.ArgumentType<*>");
                argumentBuilder = (ArgumentBuilder)CommandUtil.INSTANCE.argument(string, argumentType2);
            }
            ArgumentBuilder out = argumentBuilder;
            collection.add(TuplesKt.to((Object)it.getName(), (Object)(this.permissionLevel != null ? out.requires(arg_0 -> CommandNode.buildCommand$lambda$4$0(this, arg_0)) : out)));
        }
        List componentMap = CollectionsKt.toMutableList((Collection)((List)destination$iv$iv2));
        Object e = componentMap.removeFirst();
        Intrinsics.checkNotNullExpressionValue(e, (String)"removeFirst(...)");
        Pair first = (Pair)e;
        $this$mapTo$iv$iv = new ArgumentBuilder[1];
        Function1<? super CommandContext<S>, Integer> function1 = executes;
        $this$mapTo$iv$iv[0] = ((ArgumentBuilder)first.getSecond()).executes((Command)(function1 != null ? arg_0 -> CommandNode.buildCommand$lambda$5(function1, arg_0) : null));
        List tree = CollectionsKt.mutableListOf((Object[])$this$mapTo$iv$iv);
        if (!componentMap.isEmpty()) {
            Object e2 = componentMap.removeLast();
            Intrinsics.checkNotNullExpressionValue(e2, (String)"removeLast(...)");
            Pair last = (Pair)e2;
            Object object2 = tree;
            Object $this$map$iv3 = componentMap;
            boolean $i$f$map3 = false;
            Iterable iterable = $this$map$iv3;
            Collection destination$iv$iv3 = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map$iv3, (int)10));
            boolean $i$f$mapTo3 = false;
            for (Object item$iv$iv2 : iterable) {
                void it3;
                Pair pair = (Pair)item$iv$iv2;
                collection = destination$iv$iv3;
                bl = false;
                collection.add((ArgumentBuilder)it3.getSecond());
            }
            $this$map$iv3 = (List)destination$iv$iv3;
            CollectionsKt.addAll((Collection)object2, (Iterable)$this$map$iv3);
            object2 = tree;
            $this$map$iv3 = last.getSecond();
            ArgumentBuilder $this$buildCommand_u24lambda_u247 = (ArgumentBuilder)$this$map$iv3;
            boolean bl5 = false;
            Function1<? super CommandContext<S>, Integer> function12 = executes;
            if (function12 != null) {
                it = function12;
                boolean bl2 = false;
                $this$buildCommand_u24lambda_u247.executes(arg_0 -> CommandNode.buildCommand$lambda$7$0$0(executes, arg_0));
            }
            object2.add($this$map$iv3);
        }
        ArgumentBuilder end = (ArgumentBuilder)tree.removeLast();
        Iterable $this$map$iv3 = CollectionsKt.reversed((Iterable)tree);
        ArgumentBuilder initial$iv = end;
        boolean bl6 = false;
        ArgumentBuilder accumulator$iv = initial$iv;
        for (Object element$iv : $this$fold$iv) {
            void it4;
            Object item$iv$iv2;
            item$iv$iv2 = (ArgumentBuilder)element$iv;
            ArgumentBuilder cur = accumulator$iv;
            bl = false;
            accumulator$iv = it4.then(cur);
        }
        ArgumentBuilder argumentBuilder = accumulator$iv;
        Intrinsics.checkNotNull((Object)argumentBuilder, (String)"null cannot be cast to non-null type com.mojang.brigadier.builder.LiteralArgumentBuilder<S of net.thebrokenscript.brokencore.api.commands.CommandNode>");
        return TuplesKt.to((Object)((LiteralArgumentBuilder)argumentBuilder), (Object)end);
    }

    static /* synthetic */ Pair buildCommand$default(CommandNode commandNode, String string, ArgumentType[] argumentTypeArray, Function1 function1, int n, Object object) {
        if ((n & 4) != 0) {
            function1 = null;
        }
        return commandNode.buildCommand(string, argumentTypeArray, function1);
    }

    public final void add(@NotNull String cmd, @NotNull ArgumentType<?>[] argTypes, @NotNull Function1<? super CommandContext<S>, Integer> executes) {
        Intrinsics.checkNotNullParameter((Object)cmd, (String)"cmd");
        Intrinsics.checkNotNullParameter(argTypes, (String)"argTypes");
        Intrinsics.checkNotNullParameter(executes, (String)"executes");
        MiscExt.void(this.roots.add((LiteralArgumentBuilder<S>)this.buildCommand(cmd, Arrays.copyOf(argTypes, argTypes.length), arg_0 -> CommandNode.add$lambda$0(executes, arg_0)).getFirst()));
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public final CommandNode<S> child(@NotNull String cmd, @Nullable Integer permissionLevel, ArgumentType<?> ... argTypes) {
        void it;
        Pair pair;
        Intrinsics.checkNotNullParameter((Object)cmd, (String)"cmd");
        Intrinsics.checkNotNullParameter(argTypes, (String)"argTypes");
        Pair pair2 = pair = CommandNode.buildCommand$default(this, cmd, Arrays.copyOf(argTypes, argTypes.length), null, 4, null);
        CommandDispatcher<S> commandDispatcher = this.dispatcher;
        boolean bl = false;
        this.roots.add((LiteralArgumentBuilder<S>)it.getFirst());
        ArgumentBuilder argumentBuilder = (ArgumentBuilder)pair.getSecond();
        Integer n = permissionLevel;
        if (n == null) {
            n = this.permissionLevel;
        }
        Integer n2 = n;
        boolean bl2 = false;
        ArgumentBuilder argumentBuilder2 = argumentBuilder;
        CommandDispatcher<S> commandDispatcher2 = commandDispatcher;
        return new CommandNode<S>(commandDispatcher2, argumentBuilder2, bl2, n2);
    }

    public static /* synthetic */ CommandNode child$default(CommandNode commandNode, String string, Integer n, ArgumentType[] argumentTypeArray, int n2, Object object) {
        if ((n2 & 2) != 0) {
            n = null;
        }
        return commandNode.child(string, n, argumentTypeArray);
    }

    public final void finish() {
        if (this.isRoot) {
            Iterable $this$forEach$iv = this.roots;
            boolean $i$f$forEach = false;
            for (Object element$iv : $this$forEach$iv) {
                LiteralArgumentBuilder it = (LiteralArgumentBuilder)element$iv;
                boolean bl = false;
                this.dispatcher.register(it);
            }
        } else {
            Iterable $this$forEach$iv = this.roots;
            boolean $i$f$forEach = false;
            for (Object element$iv : $this$forEach$iv) {
                LiteralArgumentBuilder it = (LiteralArgumentBuilder)element$iv;
                boolean bl = false;
                ArgumentBuilder<S, ? extends ArgumentBuilder<S, ?>> argumentBuilder = this.parent;
                if (argumentBuilder == null) continue;
                argumentBuilder.then((ArgumentBuilder)it);
            }
        }
    }

    private static final boolean buildCommand$lambda$4$0(CommandNode this$0, SharedSuggestionProvider s) {
        return s.hasPermission(this$0.permissionLevel.intValue());
    }

    private static final int buildCommand$lambda$5(Function1 $tmp0, CommandContext p0) {
        return ((Number)$tmp0.invoke((Object)p0)).intValue();
    }

    private static final int buildCommand$lambda$7$0$0(Function1 $tmp0, CommandContext p0) {
        return ((Number)$tmp0.invoke((Object)p0)).intValue();
    }

    private static final int add$lambda$0(Function1 $executes, CommandContext it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        return ((Number)$executes.invoke((Object)it)).intValue();
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J5\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0005\"\b\b\u0001\u0010\u0006*\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00060\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u00a2\u0006\u0002\u0010\f\u00a8\u0006\r"}, d2={"Lnet/thebrokenscript/brokencore/api/commands/CommandNode$Companion;", "", "<init>", "()V", "create", "Lnet/thebrokenscript/brokencore/api/commands/CommandNode;", "S", "Lnet/minecraft/commands/SharedSuggestionProvider;", "dispatcher", "Lcom/mojang/brigadier/CommandDispatcher;", "permissionLevel", "", "(Lcom/mojang/brigadier/CommandDispatcher;Ljava/lang/Integer;)Lnet/thebrokenscript/brokencore/api/commands/CommandNode;", "brokencore-common"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final <S extends SharedSuggestionProvider> CommandNode<S> create(@NotNull CommandDispatcher<S> dispatcher, @Nullable Integer permissionLevel) {
            Intrinsics.checkNotNullParameter(dispatcher, (String)"dispatcher");
            return new CommandNode<S>(dispatcher, null, true, permissionLevel);
        }

        public static /* synthetic */ CommandNode create$default(Companion companion, CommandDispatcher commandDispatcher, Integer n, int n2, Object object) {
            if ((n2 & 2) != 0) {
                n = null;
            }
            return companion.create(commandDispatcher, n);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

