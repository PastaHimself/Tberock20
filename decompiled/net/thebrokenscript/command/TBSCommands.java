/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.brigadier.CommandDispatcher
 *  com.mojang.brigadier.arguments.ArgumentType
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.commands.CommandBuildContext
 *  net.minecraft.commands.CommandSourceStack
 *  net.minecraft.commands.Commands$CommandSelection
 *  net.minecraft.server.commands.DeOpCommands
 *  net.thebrokenscript.brokencore.api.commands.CommandDSL
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.ArgumentType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.commands.CommandBuildContext;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.server.commands.DeOpCommands;
import net.thebrokenscript.brokencore.api.commands.CommandDSL;
import net.thebrokenscript.command.DevModeCommand;
import net.thebrokenscript.command.ReputationCommand;
import net.thebrokenscript.command.dev.DevCommands;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f\u00a8\u0006\r"}, d2={"Lnet/thebrokenscript/command/TBSCommands;", "", "<init>", "()V", "register", "", "dispatcher", "Lcom/mojang/brigadier/CommandDispatcher;", "Lnet/minecraft/commands/CommandSourceStack;", "buildContext", "Lnet/minecraft/commands/CommandBuildContext;", "selection", "Lnet/minecraft/commands/Commands$CommandSelection;", "thebrokenscript-common"})
public final class TBSCommands {
    @NotNull
    public static final TBSCommands INSTANCE = new TBSCommands();

    private TBSCommands() {
    }

    public final void register(@NotNull CommandDispatcher<CommandSourceStack> dispatcher, @NotNull CommandBuildContext buildContext, @NotNull Commands.CommandSelection selection) {
        Intrinsics.checkNotNullParameter(dispatcher, (String)"dispatcher");
        Intrinsics.checkNotNullParameter((Object)buildContext, (String)"buildContext");
        Intrinsics.checkNotNullParameter((Object)selection, (String)"selection");
        new CommandDSL(dispatcher, null, arg_0 -> TBSCommands.register$lambda$0(buildContext, arg_0), 2, null);
        if (selection == Commands.CommandSelection.INTEGRATED) {
            DeOpCommands.register(dispatcher);
        }
    }

    private static final void register$lambda$0(CommandBuildContext $buildContext, CommandDSL $this$CommandDSL) {
        Intrinsics.checkNotNullParameter((Object)$this$CommandDSL, (String)"$this$CommandDSL");
        $this$CommandDSL.group("tbs", Integer.valueOf(4), new ArgumentType[0], arg_0 -> TBSCommands.register$lambda$0$0($buildContext, arg_0));
    }

    private static final void register$lambda$0$0(CommandBuildContext $buildContext, CommandDSL $this$group) {
        Intrinsics.checkNotNullParameter((Object)$this$group, (String)"$this$group");
        DevModeCommand.INSTANCE.addDevMode((CommandDSL<CommandSourceStack>)$this$group);
        ReputationCommand.INSTANCE.addReputation((CommandDSL<CommandSourceStack>)$this$group);
        DevCommands.INSTANCE.addDevCommands((CommandDSL<CommandSourceStack>)$this$group, $buildContext);
    }
}

