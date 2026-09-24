/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.brigadier.context.CommandContext
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.random.Random
 *  net.minecraft.commands.CommandSourceStack
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.world.level.LevelAccessor
 *  net.thebrokenscript.brokencore.api.commands.CommandDSL
 *  net.thebrokenscript.brokencore.api.dsl.CommandCxUtil
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.command.dev;

import com.mojang.brigadier.context.CommandContext;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.LevelAccessor;
import net.thebrokenscript.api.ext.LevelExt;
import net.thebrokenscript.api.ext.StringExt;
import net.thebrokenscript.brokencore.api.commands.CommandDSL;
import net.thebrokenscript.brokencore.api.dsl.CommandCxUtil;
import net.thebrokenscript.data.MapVariables;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=2, xi=48, d1={"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002\u00a8\u0006\u0004"}, d2={"addCodeCommands", "", "Lnet/thebrokenscript/brokencore/api/commands/CommandDSL;", "Lnet/minecraft/commands/CommandSourceStack;", "thebrokenscript-common"})
public final class CodeCommandsKt {
    public static final void addCodeCommands(@NotNull CommandDSL<CommandSourceStack> $this$addCodeCommands) {
        Intrinsics.checkNotNullParameter($this$addCodeCommands, (String)"<this>");
        $this$addCodeCommands.group("code", CodeCommandsKt::addCodeCommands$lambda$0);
    }

    private static final void addCodeCommands$lambda$0(CommandDSL $this$group) {
        Intrinsics.checkNotNullParameter((Object)$this$group, (String)"$this$group");
        $this$group.add("get", CodeCommandsKt::addCodeCommands$lambda$0$0);
        $this$group.add("reroll", CodeCommandsKt::addCodeCommands$lambda$0$1);
        $this$group.add("status", CodeCommandsKt::addCodeCommands$lambda$0$2);
    }

    private static final int addCodeCommands$lambda$0$0(CommandContext it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        ServerLevel serverLevel = ((CommandSourceStack)it.getSource()).getLevel();
        Intrinsics.checkNotNullExpressionValue((Object)serverLevel, (String)"getLevel(...)");
        CommandCxUtil.success$default((CommandContext)it, (String)("Code: " + LevelExt.INSTANCE.getVars((LevelAccessor)serverLevel).getCode()), (boolean)false, (int)2, null);
        return 0;
    }

    private static final int addCodeCommands$lambda$0$1(CommandContext it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        ServerLevel serverLevel = ((CommandSourceStack)it.getSource()).getLevel();
        Intrinsics.checkNotNullExpressionValue((Object)serverLevel, (String)"getLevel(...)");
        LevelExt.INSTANCE.updateVars((LevelAccessor)serverLevel, (Function1<? super MapVariables, Unit>)((Function1)CodeCommandsKt::addCodeCommands$lambda$0$1$0));
        ServerLevel serverLevel2 = ((CommandSourceStack)it.getSource()).getLevel();
        Intrinsics.checkNotNullExpressionValue((Object)serverLevel2, (String)"getLevel(...)");
        CommandCxUtil.success$default((CommandContext)it, (String)("code rerolled into: " + LevelExt.INSTANCE.getVars((LevelAccessor)serverLevel2).getCode()), (boolean)false, (int)2, null);
        return 0;
    }

    private static final Unit addCodeCommands$lambda$0$1$0(MapVariables $this$updateVars) {
        Intrinsics.checkNotNullParameter((Object)((Object)$this$updateVars), (String)"$this$updateVars");
        $this$updateVars.setCode(StringExt.nextString$default(StringExt.INSTANCE, (Random)Random.Default, Random.Default.nextInt(6, 13), null, 2, null));
        return Unit.INSTANCE;
    }

    private static final int addCodeCommands$lambda$0$2(CommandContext it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        ServerLevel serverLevel = ((CommandSourceStack)it.getSource()).getLevel();
        Intrinsics.checkNotNullExpressionValue((Object)serverLevel, (String)"getLevel(...)");
        CommandCxUtil.success$default((CommandContext)it, (String)("Code applied?: " + LevelExt.INSTANCE.getVars((LevelAccessor)serverLevel).getCodeApplied()), (boolean)false, (int)2, null);
        return 0;
    }
}

