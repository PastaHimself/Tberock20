/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.brigadier.arguments.ArgumentType
 *  com.mojang.brigadier.arguments.IntegerArgumentType
 *  com.mojang.brigadier.context.CommandContext
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.commands.CommandSourceStack
 *  net.minecraft.server.level.ServerPlayer
 *  net.minecraft.world.entity.player.Player
 *  net.thebrokenscript.brokencore.api.commands.CommandDSL
 *  net.thebrokenscript.brokencore.api.dsl.CommandCxUtil
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.command.dev;

import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.context.CommandContext;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.thebrokenscript.api.ext.PlayerExt;
import net.thebrokenscript.brokencore.api.commands.CommandDSL;
import net.thebrokenscript.brokencore.api.dsl.CommandCxUtil;
import net.thebrokenscript.data.PlayerVariables;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u0005*\b\u0012\u0004\u0012\u00020\u00070\u0006\u00a8\u0006\b"}, d2={"Lnet/thebrokenscript/command/dev/ReputationDebugCommand;", "", "<init>", "()V", "addReputationDebug", "", "Lnet/thebrokenscript/brokencore/api/commands/CommandDSL;", "Lnet/minecraft/commands/CommandSourceStack;", "thebrokenscript-common"})
public final class ReputationDebugCommand {
    @NotNull
    public static final ReputationDebugCommand INSTANCE = new ReputationDebugCommand();

    private ReputationDebugCommand() {
    }

    public final void addReputationDebug(@NotNull CommandDSL<CommandSourceStack> $this$addReputationDebug) {
        Intrinsics.checkNotNullParameter($this$addReputationDebug, (String)"<this>");
        $this$addReputationDebug.group("reputation", ReputationDebugCommand::addReputationDebug$lambda$0);
    }

    private static final void addReputationDebug$lambda$0(CommandDSL $this$group) {
        Intrinsics.checkNotNullParameter((Object)$this$group, (String)"$this$group");
        ArgumentType[] argumentTypeArray = new ArgumentType[1];
        Intrinsics.checkNotNullExpressionValue((Object)IntegerArgumentType.integer(), (String)"integer(...)");
        $this$group.add("add [amount]", argumentTypeArray, ReputationDebugCommand::addReputationDebug$lambda$0$0);
    }

    private static final int addReputationDebug$lambda$0$0(CommandContext it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        ServerPlayer player = ((CommandSourceStack)it.getSource()).getPlayer();
        int amount = IntegerArgumentType.getInteger((CommandContext)it, (String)"amount");
        if (player == null) {
            CommandCxUtil.fail$default((CommandContext)it, (String)"This command must be executed by a player!", (boolean)false, (int)2, null);
            return -1;
        }
        PlayerExt.INSTANCE.updateVars((Player)player, (Function1<? super PlayerVariables, Unit>)((Function1)arg_0 -> ReputationDebugCommand.addReputationDebug$lambda$0$0$0(amount, arg_0)));
        CommandCxUtil.success$default((CommandContext)it, (String)"Rep added :P", (boolean)false, (int)2, null);
        return 0;
    }

    private static final Unit addReputationDebug$lambda$0$0$0(int $amount, PlayerVariables $this$updateVars) {
        Intrinsics.checkNotNullParameter((Object)$this$updateVars, (String)"$this$updateVars");
        $this$updateVars.setEntityReputation($this$updateVars.getEntityReputation() + $amount);
        return Unit.INSTANCE;
    }
}

