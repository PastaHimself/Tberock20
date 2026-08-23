/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.brigadier.context.CommandContext
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.commands.CommandSourceStack
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Position
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.server.level.ServerPlayer
 *  net.minecraft.world.phys.Vec3
 *  net.thebrokenscript.brokencore.api.commands.CommandDSL
 *  net.thebrokenscript.brokencore.api.dsl.CommandCxUtil
 *  net.thebrokenscript.brokencore.api.dsl.PositionUtil
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.command.dev;

import com.mojang.brigadier.context.CommandContext;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Position;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.boss.jimmy.JimArena;
import net.thebrokenscript.brokencore.api.commands.CommandDSL;
import net.thebrokenscript.brokencore.api.dsl.CommandCxUtil;
import net.thebrokenscript.brokencore.api.dsl.PositionUtil;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=2, xi=48, d1={"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002\u00a8\u0006\u0004"}, d2={"addJimArenaCommands", "", "Lnet/thebrokenscript/brokencore/api/commands/CommandDSL;", "Lnet/minecraft/commands/CommandSourceStack;", "thebrokenscript-common"})
public final class JimArenaCommandsKt {
    public static final void addJimArenaCommands(@NotNull CommandDSL<CommandSourceStack> $this$addJimArenaCommands) {
        Intrinsics.checkNotNullParameter($this$addJimArenaCommands, (String)"<this>");
        $this$addJimArenaCommands.group("jim_arena", JimArenaCommandsKt::addJimArenaCommands$lambda$0);
    }

    private static final void addJimArenaCommands$lambda$0(CommandDSL $this$group) {
        Intrinsics.checkNotNullParameter((Object)$this$group, (String)"$this$group");
        $this$group.add("start", JimArenaCommandsKt::addJimArenaCommands$lambda$0$0);
        $this$group.add("create", JimArenaCommandsKt::addJimArenaCommands$lambda$0$1);
        $this$group.add("destroy", JimArenaCommandsKt::addJimArenaCommands$lambda$0$2);
    }

    private static final int addJimArenaCommands$lambda$0$0(CommandContext it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        BlockPos blockPos = BlockPos.containing((Position)((Position)((CommandSourceStack)it.getSource()).getPosition()));
        Intrinsics.checkNotNullExpressionValue((Object)blockPos, (String)"containing(...)");
        ServerLevel serverLevel = ((CommandSourceStack)it.getSource()).getLevel();
        Intrinsics.checkNotNullExpressionValue((Object)serverLevel, (String)"getLevel(...)");
        JimArena.Companion.start(blockPos, serverLevel);
        CommandCxUtil.success$default((CommandContext)it, (String)"Have fun...", (boolean)false, (int)2, null);
        return 0;
    }

    private static final int addJimArenaCommands$lambda$0$1(CommandContext it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        JimArena jimArena = JimArena.instance;
        if (jimArena != null) {
            jimArena.reset();
        }
        Vec3 vec3 = ((CommandSourceStack)it.getSource()).getPosition();
        Intrinsics.checkNotNullExpressionValue((Object)vec3, (String)"getPosition(...)");
        BlockPos blockPos = PositionUtil.getBlockPos((Position)((Position)vec3));
        ServerLevel serverLevel = ((CommandSourceStack)it.getSource()).getLevel();
        Intrinsics.checkNotNullExpressionValue((Object)serverLevel, (String)"getLevel(...)");
        JimArena.instance = new JimArena(blockPos, serverLevel, null, 4, null);
        Object object = JimArena.instance;
        if (object != null && (object = ((JimArena)object).getPlayers()) != null) {
            ServerPlayer serverPlayer = ((CommandSourceStack)it.getSource()).getPlayerOrException();
            Intrinsics.checkNotNullExpressionValue((Object)serverPlayer, (String)"getPlayerOrException(...)");
            object.add(serverPlayer);
        }
        CommandCxUtil.success$default((CommandContext)it, (String)"Created arena!", (boolean)false, (int)2, null);
        return 0;
    }

    private static final int addJimArenaCommands$lambda$0$2(CommandContext it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        JimArena arena = JimArena.instance;
        if (arena != null) {
            arena.reset();
            JimArena.instance = null;
            CommandCxUtil.success$default((CommandContext)it, (String)"Successfully destroyed arena!", (boolean)false, (int)2, null);
        } else {
            CommandCxUtil.fail$default((CommandContext)it, (String)"No active arena!", (boolean)false, (int)2, null);
        }
        return 0;
    }
}

