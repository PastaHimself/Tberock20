/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.brigadier.arguments.ArgumentType
 *  com.mojang.brigadier.arguments.DoubleArgumentType
 *  com.mojang.brigadier.arguments.IntegerArgumentType
 *  com.mojang.brigadier.arguments.StringArgumentType
 *  com.mojang.brigadier.context.CommandContext
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.commands.CommandSourceStack
 *  net.minecraft.resources.ResourceKey
 *  net.minecraft.world.level.Level
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.impl.commands;

import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.arguments.DoubleArgumentType;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.context.CommandContext;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.Level;
import net.thebrokenscript.brokencore.api.commands.CommandDSL;
import net.thebrokenscript.brokencore.api.commands.SuggestingArgument;
import net.thebrokenscript.brokencore.api.commands.suggestion.StringCollectionSuggestionProvider;
import net.thebrokenscript.brokencore.api.debug.Debugger;
import net.thebrokenscript.brokencore.api.dsl.CommandCxUtil;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u0005*\b\u0012\u0004\u0012\u00020\u00070\u0006\u00a8\u0006\b"}, d2={"Lnet/thebrokenscript/brokencore/impl/commands/DebuggerCommands;", "", "<init>", "()V", "addDebuggerCommands", "", "Lnet/thebrokenscript/brokencore/api/commands/CommandDSL;", "Lnet/minecraft/commands/CommandSourceStack;", "brokencore-common"})
public final class DebuggerCommands {
    @NotNull
    public static final DebuggerCommands INSTANCE = new DebuggerCommands();

    private DebuggerCommands() {
    }

    public final void addDebuggerCommands(@NotNull CommandDSL<CommandSourceStack> $this$addDebuggerCommands) {
        Intrinsics.checkNotNullParameter($this$addDebuggerCommands, (String)"<this>");
        $this$addDebuggerCommands.group("debugger", DebuggerCommands::addDebuggerCommands$lambda$0);
    }

    private static final void addDebuggerCommands$lambda$0(CommandDSL $this$group) {
        Intrinsics.checkNotNullParameter((Object)$this$group, (String)"$this$group");
        ArgumentType[] argumentTypeArray = new ArgumentType[1];
        StringArgumentType stringArgumentType = StringArgumentType.string();
        Intrinsics.checkNotNullExpressionValue((Object)stringArgumentType, (String)"string(...)");
        argumentTypeArray[0] = new SuggestingArgument((ArgumentType)stringArgumentType, new StringCollectionSuggestionProvider((Collection<String>)Debugger.INSTANCE.getDebuggerCategories()));
        $this$group.add("toggle [category]", argumentTypeArray, DebuggerCommands::addDebuggerCommands$lambda$0$0);
        $this$group.add("start", DebuggerCommands::addDebuggerCommands$lambda$0$1);
        argumentTypeArray = new ArgumentType[1];
        Intrinsics.checkNotNullExpressionValue((Object)IntegerArgumentType.integer(), (String)"integer(...)");
        $this$group.add("tickspeed [ticksPerDebugTick]", argumentTypeArray, DebuggerCommands::addDebuggerCommands$lambda$0$2);
        argumentTypeArray = new ArgumentType[1];
        StringArgumentType stringArgumentType2 = StringArgumentType.string();
        Intrinsics.checkNotNullExpressionValue((Object)stringArgumentType2, (String)"string(...)");
        argumentTypeArray[0] = new SuggestingArgument((ArgumentType)stringArgumentType2, new StringCollectionSuggestionProvider((Collection<String>)Debugger.INSTANCE.getTests().keySet()));
        $this$group.add("test [thing]", argumentTypeArray, DebuggerCommands::addDebuggerCommands$lambda$0$3);
        argumentTypeArray = new ArgumentType[2];
        Intrinsics.checkNotNullExpressionValue((Object)StringArgumentType.string(), (String)"string(...)");
        StringArgumentType stringArgumentType3 = StringArgumentType.string();
        Intrinsics.checkNotNullExpressionValue((Object)stringArgumentType3, (String)"string(...)");
        Object[] objectArray = new String[]{"constant", "incrementor"};
        argumentTypeArray[1] = new SuggestingArgument((ArgumentType)stringArgumentType3, new StringCollectionSuggestionProvider(CollectionsKt.listOf((Object[])objectArray)));
        $this$group.add("remove_value [valName] [type]", argumentTypeArray, DebuggerCommands::addDebuggerCommands$lambda$0$4);
        argumentTypeArray = new ArgumentType[3];
        Intrinsics.checkNotNullExpressionValue((Object)StringArgumentType.string(), (String)"string(...)");
        StringArgumentType stringArgumentType4 = StringArgumentType.string();
        Intrinsics.checkNotNullExpressionValue((Object)stringArgumentType4, (String)"string(...)");
        objectArray = new String[]{"constant", "incrementor"};
        argumentTypeArray[1] = new SuggestingArgument((ArgumentType)stringArgumentType4, new StringCollectionSuggestionProvider(CollectionsKt.listOf((Object[])objectArray)));
        Intrinsics.checkNotNullExpressionValue((Object)DoubleArgumentType.doubleArg(), (String)"doubleArg(...)");
        $this$group.add("set_value [valName] [type] [double]", argumentTypeArray, DebuggerCommands::addDebuggerCommands$lambda$0$5);
        argumentTypeArray = new ArgumentType[2];
        StringArgumentType stringArgumentType5 = StringArgumentType.string();
        Intrinsics.checkNotNullExpressionValue((Object)stringArgumentType5, (String)"string(...)");
        objectArray = new String[]{"constant", "incrementor"};
        argumentTypeArray[0] = new SuggestingArgument((ArgumentType)stringArgumentType5, new StringCollectionSuggestionProvider(CollectionsKt.listOf((Object[])objectArray)));
        StringArgumentType stringArgumentType6 = StringArgumentType.string();
        Intrinsics.checkNotNullExpressionValue((Object)stringArgumentType6, (String)"string(...)");
        argumentTypeArray[1] = new SuggestingArgument((ArgumentType)stringArgumentType6, new StringCollectionSuggestionProvider((Collection<String>)Debugger.INSTANCE.getValueNames()));
        $this$group.add("query_value [type] [valName]", argumentTypeArray, arg_0 -> DebuggerCommands.addDebuggerCommands$lambda$0$6($this$group, arg_0));
        $this$group.add("stop", DebuggerCommands::addDebuggerCommands$lambda$0$7);
        argumentTypeArray = new ArgumentType[1];
        Intrinsics.checkNotNullExpressionValue((Object)IntegerArgumentType.integer(), (String)"integer(...)");
        $this$group.add("tick [times]", argumentTypeArray, DebuggerCommands::addDebuggerCommands$lambda$0$8);
    }

    private static final int addDebuggerCommands$lambda$0$0(CommandContext it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        String category = StringArgumentType.getString((CommandContext)it, (String)"category");
        if (!Debugger.INSTANCE.getDebuggerCategories().contains(category)) {
            CommandCxUtil.fail$default(it, "Unknown debugger category \"" + category + "\"", false, 2, null);
        } else {
            List<String> debuggers = Debugger.INSTANCE.getEnabledDebuggers();
            if (debuggers.contains(category)) {
                debuggers.remove(category);
                Object object = it.getSource();
                Intrinsics.checkNotNullExpressionValue((Object)object, (String)"getSource(...)");
                CommandCxUtil.sendSuccess$default((CommandSourceStack)object, "Debugger Category " + category + " Disabled", false, 2, null);
            } else {
                Intrinsics.checkNotNull((Object)category);
                debuggers.add(category);
                Object object = it.getSource();
                Intrinsics.checkNotNullExpressionValue((Object)object, (String)"getSource(...)");
                CommandCxUtil.sendSuccess$default((CommandSourceStack)object, "Debugger Category " + category + " Enabled", false, 2, null);
            }
        }
        return 0;
    }

    private static final int addDebuggerCommands$lambda$0$1(CommandContext it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        Debugger.INSTANCE.setEnabled(true);
        Object object = it.getSource();
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"getSource(...)");
        CommandCxUtil.sendSuccess$default((CommandSourceStack)object, "Debugging Started", false, 2, null);
        return 0;
    }

    private static final int addDebuggerCommands$lambda$0$2(CommandContext it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        int n = IntegerArgumentType.getInteger((CommandContext)it, (String)"ticksPerDebugTick");
        Debugger.INSTANCE.setTickspeed(n);
        return 0;
    }

    private static final int addDebuggerCommands$lambda$0$3(CommandContext it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        Function1<CommandContext<CommandSourceStack>, Unit> thing = Debugger.INSTANCE.getTests().get(StringArgumentType.getString((CommandContext)it, (String)"thing"));
        ResourceKey resourceKey = ((CommandSourceStack)it.getSource()).getLevel().dimension();
        Intrinsics.checkNotNullExpressionValue((Object)resourceKey, (String)"dimension(...)");
        Debugger.INSTANCE.setTestLevel((ResourceKey<Level>)resourceKey);
        if (thing != null) {
            thing.invoke((Object)it);
        }
        return 0;
    }

    private static final int addDebuggerCommands$lambda$0$4(CommandContext it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        String valName = StringArgumentType.getString((CommandContext)it, (String)"valName");
        String type = StringArgumentType.getString((CommandContext)it, (String)"type");
        if (Intrinsics.areEqual((Object)type, (Object)"incrementor")) {
            Intrinsics.checkNotNull((Object)valName);
            if (Debugger.INSTANCE.getValue(valName) != null) {
                CommandCxUtil.warn$default(it, "Incrementor " + valName + " doesn't exist", false, 2, null);
            } else {
                CommandCxUtil.success$default(it, "Removed incrementor " + valName, false, 2, null);
            }
            Debugger.INSTANCE.removeIncrementor(valName);
        } else if (Intrinsics.areEqual((Object)type, (Object)"constant")) {
            Intrinsics.checkNotNull((Object)valName);
            if (Debugger.INSTANCE.getValue(valName) != null) {
                CommandCxUtil.warn$default(it, "Value " + valName + " doesn't exist", false, 2, null);
            } else {
                CommandCxUtil.success$default(it, "Removed value " + valName, false, 2, null);
            }
            Debugger.INSTANCE.removeValue(valName);
        } else {
            CommandCxUtil.fail$default(it, "Unknown value type " + type, false, 2, null);
        }
        return 0;
    }

    private static final int addDebuggerCommands$lambda$0$5(CommandContext it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        String valName = StringArgumentType.getString((CommandContext)it, (String)"valName");
        double value = DoubleArgumentType.getDouble((CommandContext)it, (String)"double");
        String type = StringArgumentType.getString((CommandContext)it, (String)"type");
        if (Intrinsics.areEqual((Object)type, (Object)"incrementor")) {
            Intrinsics.checkNotNull((Object)valName);
            if (Debugger.INSTANCE.getValue(valName) != null) {
                CommandCxUtil.warn$default(it, "Replaced existing value " + valName, false, 2, null);
            } else {
                CommandCxUtil.success$default(it, "Added incrementor " + valName, false, 2, null);
            }
            Debugger.INSTANCE.addIncrementor(valName, value);
        } else if (Intrinsics.areEqual((Object)type, (Object)"constant")) {
            Intrinsics.checkNotNull((Object)valName);
            if (Debugger.INSTANCE.getValue(valName) != null) {
                CommandCxUtil.warn$default(it, "Replaced existing value " + valName, false, 2, null);
            } else {
                CommandCxUtil.success$default(it, "Added constant " + valName, false, 2, null);
            }
            Debugger.INSTANCE.addValue(valName, value);
        } else {
            CommandCxUtil.fail$default(it, "Unknown value type " + type, false, 2, null);
        }
        return 0;
    }

    private static final int addDebuggerCommands$lambda$0$6(CommandDSL $this_group, CommandContext it) {
        Serializable serializable;
        String type;
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        String valName = StringArgumentType.getString((CommandContext)it, (String)"valName");
        String string = type = StringArgumentType.getString((CommandContext)it, (String)"type");
        if (Intrinsics.areEqual((Object)string, (Object)"incrementor")) {
            CommandDSL $this$addDebuggerCommands_u24lambda_u240_u246_u240 = $this_group;
            boolean bl = false;
            Intrinsics.checkNotNull((Object)valName);
            Pair<Double, Double> v = Debugger.INSTANCE.getIncrementor(valName);
            if (v.getFirst() == null || v.getSecond() == null) {
                CommandCxUtil.fail$default(it, "Unknown value " + valName, false, 2, null);
                return 0;
            }
            serializable = (Serializable)v;
        } else if (Intrinsics.areEqual((Object)string, (Object)"constant")) {
            Intrinsics.checkNotNull((Object)valName);
            Double d = Debugger.INSTANCE.getValue(valName);
            if (d == null) {
                CommandDSL $this$addDebuggerCommands_u24lambda_u240_u246_u241 = $this_group;
                boolean bl = false;
                CommandCxUtil.fail$default(it, "Unknown value " + valName, false, 2, null);
                return 0;
            }
            serializable = d;
        } else {
            CommandCxUtil.fail$default(it, "Unknown value type " + type, false, 2, null);
            return 0;
        }
        Serializable v = serializable;
        string = type;
        if (Intrinsics.areEqual((Object)string, (Object)"incrementor")) {
            CommandDSL $this$addDebuggerCommands_u24lambda_u240_u246_u242 = $this_group;
            boolean bl = false;
            Intrinsics.checkNotNull((Object)v, (String)"null cannot be cast to non-null type kotlin.Pair<kotlin.Double, kotlin.Double>");
            Pair cfr_ignored_0 = (Pair)v;
            CommandCxUtil.success$default(it, "increment: " + ((Pair)v).getFirst() + ", value:" + ((Pair)v).getSecond(), false, 2, null);
        } else if (Intrinsics.areEqual((Object)string, (Object)"constant")) {
            CommandDSL $this$addDebuggerCommands_u24lambda_u240_u246_u243 = $this_group;
            boolean bl = false;
            Intrinsics.checkNotNull((Object)v, (String)"null cannot be cast to non-null type kotlin.Double");
            Double cfr_ignored_1 = (Double)v;
            CommandCxUtil.success$default(it, String.valueOf(((Number)v).doubleValue()), false, 2, null);
        }
        return 0;
    }

    private static final int addDebuggerCommands$lambda$0$7(CommandContext it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        Debugger.INSTANCE.setEnabled(false);
        Object object = it.getSource();
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"getSource(...)");
        CommandCxUtil.sendSuccess$default((CommandSourceStack)object, "Debugging Stopped", false, 2, null);
        Debugger.INSTANCE.getDebuggables().clear();
        Debugger.INSTANCE.setTicks(0);
        return 0;
    }

    private static final int addDebuggerCommands$lambda$0$8(CommandContext it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        int n = IntegerArgumentType.getInteger((CommandContext)it, (String)"times");
        Debugger.INSTANCE.setTicks(n);
        return 0;
    }
}

