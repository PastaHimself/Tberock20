/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.brigadier.arguments.ArgumentType
 *  com.mojang.brigadier.arguments.IntegerArgumentType
 *  com.mojang.brigadier.context.CommandContext
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.commands.CommandSourceStack
 *  net.minecraft.network.protocol.common.custom.CustomPacketPayload
 *  net.minecraft.server.level.ServerLevel
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.impl.commands;

import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.context.CommandContext;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.server.level.ServerLevel;
import net.thebrokenscript.brokencore.api.commands.CommandDSL;
import net.thebrokenscript.brokencore.api.commands.arguments.EnumArgument;
import net.thebrokenscript.brokencore.api.network.PacketSender;
import net.thebrokenscript.brokencore.api.world.TimeOfDay;
import net.thebrokenscript.brokencore.impl.registry.BCPackets;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u0005*\b\u0012\u0004\u0012\u00020\u00070\u0006\u00a8\u0006\b"}, d2={"Lnet/thebrokenscript/brokencore/impl/commands/TimeCommands;", "", "<init>", "()V", "addTimeCommands", "", "Lnet/thebrokenscript/brokencore/api/commands/CommandDSL;", "Lnet/minecraft/commands/CommandSourceStack;", "brokencore-common"})
public final class TimeCommands {
    @NotNull
    public static final TimeCommands INSTANCE = new TimeCommands();

    private TimeCommands() {
    }

    public final void addTimeCommands(@NotNull CommandDSL<CommandSourceStack> $this$addTimeCommands) {
        Intrinsics.checkNotNullParameter($this$addTimeCommands, (String)"<this>");
        $this$addTimeCommands.group("time", TimeCommands::addTimeCommands$lambda$0);
    }

    private static final void addTimeCommands$lambda$0(CommandDSL $this$group) {
        Intrinsics.checkNotNullParameter((Object)$this$group, (String)"$this$group");
        ArgumentType[] argumentTypeArray = new ArgumentType[]{EnumArgument.Companion.enumArgument(TimeOfDay.class)};
        $this$group.add("set [time]", argumentTypeArray, TimeCommands::addTimeCommands$lambda$0$0);
        argumentTypeArray = new ArgumentType[]{EnumArgument.Companion.enumArgument(TimeOfDay.class)};
        $this$group.add("fake [time]", argumentTypeArray, TimeCommands::addTimeCommands$lambda$0$1);
        $this$group.add("fake off", TimeCommands::addTimeCommands$lambda$0$2);
        argumentTypeArray = new ArgumentType[1];
        Intrinsics.checkNotNullExpressionValue((Object)IntegerArgumentType.integer((int)0, (int)24000), (String)"integer(...)");
        $this$group.add("fake set [time]", argumentTypeArray, TimeCommands::addTimeCommands$lambda$0$3);
    }

    private static final int addTimeCommands$lambda$0$0(CommandContext it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        TimeOfDay timeOfDay = (TimeOfDay)((Object)it.getArgument("time", TimeOfDay.class));
        ServerLevel serverLevel = ((CommandSourceStack)it.getSource()).getLevel();
        Intrinsics.checkNotNullExpressionValue((Object)serverLevel, (String)"getLevel(...)");
        timeOfDay.set(serverLevel);
        return 0;
    }

    private static final int addTimeCommands$lambda$0$1(CommandContext it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        ((TimeOfDay)((Object)it.getArgument("time", TimeOfDay.class))).setFake();
        return 0;
    }

    private static final int addTimeCommands$lambda$0$2(CommandContext it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        PacketSender.INSTANCE.sendToAllPlayers(BCPackets.FAKE_TIME_OF_DAY.of(0, false), new CustomPacketPayload[0]);
        return 0;
    }

    private static final int addTimeCommands$lambda$0$3(CommandContext it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        PacketSender.INSTANCE.sendToAllPlayers(BCPackets.FAKE_TIME_OF_DAY.of(IntegerArgumentType.getInteger((CommandContext)it, (String)"time"), true), new CustomPacketPayload[0]);
        return 0;
    }
}

