/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.brigadier.context.CommandContext
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
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
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.LevelAccessor;
import net.thebrokenscript.api.ext.LevelExt;
import net.thebrokenscript.brokencore.api.commands.CommandDSL;
import net.thebrokenscript.brokencore.api.dsl.CommandCxUtil;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=2, xi=48, d1={"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002\u00a8\u0006\u0004"}, d2={"addCoordCommands", "", "Lnet/thebrokenscript/brokencore/api/commands/CommandDSL;", "Lnet/minecraft/commands/CommandSourceStack;", "thebrokenscript-common"})
public final class CoordCommandsKt {
    public static final void addCoordCommands(@NotNull CommandDSL<CommandSourceStack> $this$addCoordCommands) {
        Intrinsics.checkNotNullParameter($this$addCoordCommands, (String)"<this>");
        $this$addCoordCommands.group("coord", CoordCommandsKt::addCoordCommands$lambda$0);
    }

    private static final void addCoordCommands$lambda$0(CommandDSL $this$group) {
        Intrinsics.checkNotNullParameter((Object)$this$group, (String)"$this$group");
        $this$group.add("clanvoid", CoordCommandsKt::addCoordCommands$lambda$0$0);
        $this$group.add("maze", CoordCommandsKt::addCoordCommands$lambda$0$1);
        $this$group.add("wood", CoordCommandsKt::addCoordCommands$lambda$0$2);
        $this$group.add("stone", CoordCommandsKt::addCoordCommands$lambda$0$3);
        $this$group.add("day_A", CoordCommandsKt::addCoordCommands$lambda$0$4);
    }

    private static final int addCoordCommands$lambda$0$0(CommandContext it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        ServerLevel serverLevel = ((CommandSourceStack)it.getSource()).getLevel();
        Intrinsics.checkNotNullExpressionValue((Object)serverLevel, (String)"getLevel(...)");
        int cx = Math.floorDiv(LevelExt.INSTANCE.getVars((LevelAccessor)serverLevel).getClanVoidX(), 16) * 16 + 8;
        ServerLevel serverLevel2 = ((CommandSourceStack)it.getSource()).getLevel();
        Intrinsics.checkNotNullExpressionValue((Object)serverLevel2, (String)"getLevel(...)");
        int cz = Math.floorDiv(LevelExt.INSTANCE.getVars((LevelAccessor)serverLevel2).getClanVoidZ(), 16) * 16 + 8;
        CommandCxUtil.success$default((CommandContext)it, (String)("X: " + cx + ", Z: " + cz), (boolean)false, (int)2, null);
        return 0;
    }

    private static final int addCoordCommands$lambda$0$1(CommandContext it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        ServerLevel serverLevel = ((CommandSourceStack)it.getSource()).getLevel();
        Intrinsics.checkNotNullExpressionValue((Object)serverLevel, (String)"getLevel(...)");
        int cx = Math.floorDiv(LevelExt.INSTANCE.getVars((LevelAccessor)serverLevel).getMazeFloorX(), 16) * 16 + 8;
        ServerLevel serverLevel2 = ((CommandSourceStack)it.getSource()).getLevel();
        Intrinsics.checkNotNullExpressionValue((Object)serverLevel2, (String)"getLevel(...)");
        int cz = Math.floorDiv(LevelExt.INSTANCE.getVars((LevelAccessor)serverLevel2).getMazeFloorZ(), 16) * 16 + 8;
        CommandCxUtil.success$default((CommandContext)it, (String)("X: " + cx + ", Z: " + cz), (boolean)false, (int)2, null);
        return 0;
    }

    private static final int addCoordCommands$lambda$0$2(CommandContext it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        ServerLevel serverLevel = ((CommandSourceStack)it.getSource()).getLevel();
        Intrinsics.checkNotNullExpressionValue((Object)serverLevel, (String)"getLevel(...)");
        int cx = Math.floorDiv(LevelExt.INSTANCE.getVars((LevelAccessor)serverLevel).getWoodenFloorX(), 16) * 16 + 8;
        ServerLevel serverLevel2 = ((CommandSourceStack)it.getSource()).getLevel();
        Intrinsics.checkNotNullExpressionValue((Object)serverLevel2, (String)"getLevel(...)");
        int cz = Math.floorDiv(LevelExt.INSTANCE.getVars((LevelAccessor)serverLevel2).getWoodenFloorZ(), 16) * 16 + 8;
        CommandCxUtil.success$default((CommandContext)it, (String)("X: " + cx + ", Z: " + cz), (boolean)false, (int)2, null);
        return 0;
    }

    private static final int addCoordCommands$lambda$0$3(CommandContext it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        ServerLevel serverLevel = ((CommandSourceStack)it.getSource()).getLevel();
        Intrinsics.checkNotNullExpressionValue((Object)serverLevel, (String)"getLevel(...)");
        int cx = Math.floorDiv(LevelExt.INSTANCE.getVars((LevelAccessor)serverLevel).getStoneFloorX(), 16) * 16 + 8;
        ServerLevel serverLevel2 = ((CommandSourceStack)it.getSource()).getLevel();
        Intrinsics.checkNotNullExpressionValue((Object)serverLevel2, (String)"getLevel(...)");
        int cz = Math.floorDiv(LevelExt.INSTANCE.getVars((LevelAccessor)serverLevel2).getStoneFloorZ(), 16) * 16 + 8;
        CommandCxUtil.success$default((CommandContext)it, (String)("X: " + cx + ", Z: " + cz), (boolean)false, (int)2, null);
        return 0;
    }

    private static final int addCoordCommands$lambda$0$4(CommandContext it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        ServerLevel serverLevel = ((CommandSourceStack)it.getSource()).getLevel();
        Intrinsics.checkNotNullExpressionValue((Object)serverLevel, (String)"getLevel(...)");
        int cx = Math.floorDiv(LevelExt.INSTANCE.getVars((LevelAccessor)serverLevel).getDayAX(), 16) * 16 + 8;
        ServerLevel serverLevel2 = ((CommandSourceStack)it.getSource()).getLevel();
        Intrinsics.checkNotNullExpressionValue((Object)serverLevel2, (String)"getLevel(...)");
        int cz = Math.floorDiv(LevelExt.INSTANCE.getVars((LevelAccessor)serverLevel2).getDayAZ(), 16) * 16 + 8;
        CommandCxUtil.success$default((CommandContext)it, (String)("X: " + cx + ", Z: " + cz), (boolean)false, (int)2, null);
        return 0;
    }
}

