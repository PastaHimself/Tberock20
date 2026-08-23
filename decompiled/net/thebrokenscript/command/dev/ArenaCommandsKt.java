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
import net.thebrokenscript.boss.integrity.Arena;
import net.thebrokenscript.brokencore.api.commands.CommandDSL;
import net.thebrokenscript.brokencore.api.dsl.CommandCxUtil;
import net.thebrokenscript.brokencore.api.dsl.PositionUtil;
import net.thebrokenscript.entity.integrity.phase3.IntegrityPhase3Entity;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=2, xi=48, d1={"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002\u00a8\u0006\u0004"}, d2={"addArenaCommands", "", "Lnet/thebrokenscript/brokencore/api/commands/CommandDSL;", "Lnet/minecraft/commands/CommandSourceStack;", "thebrokenscript-common"})
public final class ArenaCommandsKt {
    public static final void addArenaCommands(@NotNull CommandDSL<CommandSourceStack> $this$addArenaCommands) {
        Intrinsics.checkNotNullParameter($this$addArenaCommands, (String)"<this>");
        $this$addArenaCommands.group("arena", ArenaCommandsKt::addArenaCommands$lambda$0);
    }

    private static final void addArenaCommands$lambda$0(CommandDSL $this$group) {
        Intrinsics.checkNotNullParameter((Object)$this$group, (String)"$this$group");
        $this$group.add("start", ArenaCommandsKt::addArenaCommands$lambda$0$0);
        $this$group.add("create", ArenaCommandsKt::addArenaCommands$lambda$0$1);
        $this$group.add("next", ArenaCommandsKt::addArenaCommands$lambda$0$2);
        $this$group.add("kill_phase_3", ArenaCommandsKt::addArenaCommands$lambda$0$3);
        $this$group.add("destroy", ArenaCommandsKt::addArenaCommands$lambda$0$4);
        $this$group.add("arms", ArenaCommandsKt::addArenaCommands$lambda$0$5);
    }

    private static final int addArenaCommands$lambda$0$0(CommandContext it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        BlockPos blockPos = BlockPos.containing((Position)((Position)((CommandSourceStack)it.getSource()).getPosition()));
        Intrinsics.checkNotNullExpressionValue((Object)blockPos, (String)"containing(...)");
        ServerLevel serverLevel = ((CommandSourceStack)it.getSource()).getLevel();
        Intrinsics.checkNotNullExpressionValue((Object)serverLevel, (String)"getLevel(...)");
        Arena.Companion.start(blockPos, serverLevel);
        CommandCxUtil.success$default((CommandContext)it, (String)"Have fun...", (boolean)false, (int)2, null);
        return 0;
    }

    private static final int addArenaCommands$lambda$0$1(CommandContext it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        Arena arena = Arena.Companion.getInstance();
        if (arena != null) {
            arena.reset();
        }
        Vec3 vec3 = ((CommandSourceStack)it.getSource()).getPosition();
        Intrinsics.checkNotNullExpressionValue((Object)vec3, (String)"getPosition(...)");
        BlockPos blockPos = PositionUtil.getBlockPos((Position)((Position)vec3));
        ServerLevel serverLevel = ((CommandSourceStack)it.getSource()).getLevel();
        Intrinsics.checkNotNullExpressionValue((Object)serverLevel, (String)"getLevel(...)");
        Arena.instance = new Arena(blockPos, serverLevel, null, 4, null);
        Object object = Arena.instance;
        if (object != null && (object = ((Arena)object).getPlayers()) != null) {
            ServerPlayer serverPlayer = ((CommandSourceStack)it.getSource()).getPlayerOrException();
            Intrinsics.checkNotNullExpressionValue((Object)serverPlayer, (String)"getPlayerOrException(...)");
            object.add(serverPlayer);
        }
        CommandCxUtil.success$default((CommandContext)it, (String)"Created arena!", (boolean)false, (int)2, null);
        return 0;
    }

    private static final int addArenaCommands$lambda$0$2(CommandContext it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        Arena arena = Arena.Companion.getInstance();
        if (arena != null) {
            arena.nextPhase();
            CommandCxUtil.success$default((CommandContext)it, (String)"Moved to next arena phase!", (boolean)false, (int)2, null);
        } else {
            CommandCxUtil.fail$default((CommandContext)it, (String)"No active arena!", (boolean)false, (int)2, null);
        }
        return 0;
    }

    private static final int addArenaCommands$lambda$0$3(CommandContext it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        Arena arena = Arena.Companion.getInstance();
        if (arena != null) {
            IntegrityPhase3Entity integrityPhase3Entity = arena.getPhase3().getIntegrity();
            if (integrityPhase3Entity != null) {
                integrityPhase3Entity.kill();
            }
            CommandCxUtil.success$default((CommandContext)it, (String)"Killed Integrity!", (boolean)false, (int)2, null);
        } else {
            CommandCxUtil.fail$default((CommandContext)it, (String)"No active arena!", (boolean)false, (int)2, null);
        }
        return 0;
    }

    private static final int addArenaCommands$lambda$0$4(CommandContext it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        Arena arena = Arena.Companion.getInstance();
        if (arena != null) {
            arena.reset();
            Arena.instance = null;
            CommandCxUtil.success$default((CommandContext)it, (String)"Successfully destroyed arena!", (boolean)false, (int)2, null);
        } else {
            CommandCxUtil.fail$default((CommandContext)it, (String)"No active arena!", (boolean)false, (int)2, null);
        }
        return 0;
    }

    private static final int addArenaCommands$lambda$0$5(CommandContext it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        Arena arena = Arena.Companion.getInstance();
        if (arena != null) {
            arena.getPhase3().spawnIntegrityFlailingGasStationArms();
            CommandCxUtil.success$default((CommandContext)it, (String)"Spawned wacky wavy inflatable gas station arms!", (boolean)false, (int)2, null);
        } else {
            CommandCxUtil.fail$default((CommandContext)it, (String)"No active arena!", (boolean)false, (int)2, null);
        }
        return 0;
    }
}

