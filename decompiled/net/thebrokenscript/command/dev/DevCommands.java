/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.brigadier.arguments.ArgumentType
 *  com.mojang.brigadier.context.CommandContext
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.commands.CommandBuildContext
 *  net.minecraft.commands.CommandSourceStack
 *  net.minecraft.commands.arguments.EntityArgument
 *  net.minecraft.network.protocol.common.custom.CustomPacketPayload
 *  net.minecraft.server.level.ServerPlayer
 *  net.minecraft.world.entity.player.Player
 *  net.thebrokenscript.brokencore.api.commands.CommandDSL
 *  net.thebrokenscript.brokencore.api.dsl.CommandCxUtil
 *  net.thebrokenscript.brokencore.api.dsl.PlayerUtil
 *  net.thebrokenscript.brokencore.impl.commands.ChunkCommands
 *  net.thebrokenscript.brokencore.impl.commands.EntityCommandsKt
 *  net.thebrokenscript.brokencore.impl.commands.EventCommands
 *  net.thebrokenscript.brokencore.impl.commands.InspectCommands
 *  net.thebrokenscript.brokencore.impl.commands.OverlayCommands
 *  net.thebrokenscript.brokencore.impl.commands.PopupCommands
 *  net.thebrokenscript.brokencore.impl.commands.TimeCommands
 *  net.thebrokenscript.brokencore.impl.config.BCConfigs
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.command.dev;

import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.context.CommandContext;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.commands.CommandBuildContext;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.thebrokenscript.brokencore.api.commands.CommandDSL;
import net.thebrokenscript.brokencore.api.dsl.CommandCxUtil;
import net.thebrokenscript.brokencore.api.dsl.PlayerUtil;
import net.thebrokenscript.brokencore.impl.commands.ChunkCommands;
import net.thebrokenscript.brokencore.impl.commands.EventCommands;
import net.thebrokenscript.brokencore.impl.commands.InspectCommands;
import net.thebrokenscript.brokencore.impl.commands.OverlayCommands;
import net.thebrokenscript.brokencore.impl.commands.PopupCommands;
import net.thebrokenscript.brokencore.impl.commands.TimeCommands;
import net.thebrokenscript.brokencore.impl.config.BCConfigs;
import net.thebrokenscript.command.dev.ArenaCommandsKt;
import net.thebrokenscript.command.dev.BossCommandsKt;
import net.thebrokenscript.command.dev.CodeCommandsKt;
import net.thebrokenscript.command.dev.CoordCommandsKt;
import net.thebrokenscript.command.dev.EntityCommandsKt;
import net.thebrokenscript.command.dev.FXCommands;
import net.thebrokenscript.command.dev.GiveCommandsKt;
import net.thebrokenscript.command.dev.JimArenaCommandsKt;
import net.thebrokenscript.command.dev.PlayerCommandsKt;
import net.thebrokenscript.command.dev.ReputationDebugCommand;
import net.thebrokenscript.command.dev.SetCommands;
import net.thebrokenscript.command.dev.StructureCommandsKt;
import net.thebrokenscript.command.dev.SummonCommand;
import net.thebrokenscript.command.dev.WorldCommandsKt;
import net.thebrokenscript.network.UpdateCapesPacket;
import net.thebrokenscript.registry.TBSPackets;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u0005*\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\tJ\u0016\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\rH\u0002\u00a8\u0006\u000e"}, d2={"Lnet/thebrokenscript/command/dev/DevCommands;", "", "<init>", "()V", "addDevCommands", "", "Lnet/thebrokenscript/brokencore/api/commands/CommandDSL;", "Lnet/minecraft/commands/CommandSourceStack;", "cx", "Lnet/minecraft/commands/CommandBuildContext;", "devCheck", "", "it", "Lcom/mojang/brigadier/context/CommandContext;", "thebrokenscript-common"})
public final class DevCommands {
    @NotNull
    public static final DevCommands INSTANCE = new DevCommands();

    private DevCommands() {
    }

    public final void addDevCommands(@NotNull CommandDSL<CommandSourceStack> $this$addDevCommands, @NotNull CommandBuildContext cx) {
        Intrinsics.checkNotNullParameter($this$addDevCommands, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)cx, (String)"cx");
        $this$addDevCommands.group("dev", DevCommands::addDevCommands$lambda$0);
    }

    private final boolean devCheck(CommandContext<CommandSourceStack> it) {
        if (!BCConfigs.INSTANCE.getServer().getEnableCheats()) {
            CommandCxUtil.fail$default(it, (String)"Cheats are not enabled!", (boolean)false, (int)2, null);
            return false;
        }
        return true;
    }

    private static final void addDevCommands$lambda$0(CommandDSL $this$group) {
        Intrinsics.checkNotNullParameter((Object)$this$group, (String)"$this$group");
        $this$group.beforeAll(DevCommands::addDevCommands$lambda$0$0);
        ArenaCommandsKt.addArenaCommands((CommandDSL<CommandSourceStack>)$this$group);
        JimArenaCommandsKt.addJimArenaCommands((CommandDSL<CommandSourceStack>)$this$group);
        BossCommandsKt.addBossCommands((CommandDSL<CommandSourceStack>)$this$group);
        EntityCommandsKt.addEntityCommands((CommandDSL<CommandSourceStack>)$this$group);
        GiveCommandsKt.addGiveCommands((CommandDSL<CommandSourceStack>)$this$group);
        PlayerCommandsKt.addPlayerCommands((CommandDSL<CommandSourceStack>)$this$group);
        StructureCommandsKt.addStructureCommands((CommandDSL<CommandSourceStack>)$this$group);
        WorldCommandsKt.addWorldCommands((CommandDSL<CommandSourceStack>)$this$group);
        ChunkCommands.INSTANCE.addChunkCommands($this$group);
        TimeCommands.INSTANCE.addTimeCommands($this$group);
        OverlayCommands.INSTANCE.addOverlayCommands($this$group);
        EventCommands.INSTANCE.addEventCommands($this$group);
        SetCommands.INSTANCE.addSetCommands((CommandDSL<CommandSourceStack>)$this$group);
        FXCommands.INSTANCE.addFXCommands((CommandDSL<CommandSourceStack>)$this$group);
        PopupCommands.INSTANCE.addPopupCommands($this$group);
        InspectCommands.INSTANCE.addInspectCommands($this$group);
        net.thebrokenscript.brokencore.impl.commands.EntityCommandsKt.addCoreEntityCommands((CommandDSL)$this$group);
        SummonCommand.INSTANCE.addSummonCommands((CommandDSL<CommandSourceStack>)$this$group);
        ReputationDebugCommand.INSTANCE.addReputationDebug((CommandDSL<CommandSourceStack>)$this$group);
        CodeCommandsKt.addCodeCommands((CommandDSL<CommandSourceStack>)$this$group);
        CoordCommandsKt.addCoordCommands((CommandDSL<CommandSourceStack>)$this$group);
        ArgumentType[] argumentTypeArray = new ArgumentType[1];
        Intrinsics.checkNotNullExpressionValue((Object)EntityArgument.players(), (String)"players(...)");
        $this$group.add("update_capes [players]", argumentTypeArray, DevCommands::addDevCommands$lambda$0$1);
    }

    private static final Integer addDevCommands$lambda$0$0(CommandContext it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        return !INSTANCE.devCheck((CommandContext<CommandSourceStack>)it) ? Integer.valueOf(0) : null;
    }

    private static final int addDevCommands$lambda$0$1(CommandContext it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        Collection players = EntityArgument.getPlayers((CommandContext)it, (String)"players");
        UpdateCapesPacket packet = (UpdateCapesPacket)TBSPackets.UPDATE_CAPES.create();
        for (ServerPlayer player : players) {
            Intrinsics.checkNotNull((Object)player);
            PlayerUtil.trySendCustomPacket((Player)((Player)player), (CustomPacketPayload)((CustomPacketPayload)packet));
        }
        CommandCxUtil.success$default((CommandContext)it, (String)("Forced cape update for " + players.size() + " players!"), (boolean)false, (int)2, null);
        return 0;
    }
}

