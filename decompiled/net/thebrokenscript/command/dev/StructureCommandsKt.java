/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.brigadier.arguments.ArgumentType
 *  com.mojang.brigadier.arguments.StringArgumentType
 *  com.mojang.brigadier.context.CommandContext
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.commands.CommandSourceStack
 *  net.minecraft.commands.arguments.coordinates.BlockPosArgument
 *  net.minecraft.core.BlockPos
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.world.level.block.entity.BlockEntity
 *  net.thebrokenscript.brokencore.api.commands.CommandDSL
 *  net.thebrokenscript.brokencore.api.dsl.CommandCxUtil
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.command.dev;

import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.context.CommandContext;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.arguments.coordinates.BlockPosArgument;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.thebrokenscript.block.entity.NullStructureBlockEntity;
import net.thebrokenscript.brokencore.api.commands.CommandDSL;
import net.thebrokenscript.brokencore.api.dsl.CommandCxUtil;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=2, xi=48, d1={"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002\u00a8\u0006\u0004"}, d2={"addStructureCommands", "", "Lnet/thebrokenscript/brokencore/api/commands/CommandDSL;", "Lnet/minecraft/commands/CommandSourceStack;", "thebrokenscript-common"})
public final class StructureCommandsKt {
    public static final void addStructureCommands(@NotNull CommandDSL<CommandSourceStack> $this$addStructureCommands) {
        Intrinsics.checkNotNullParameter($this$addStructureCommands, (String)"<this>");
        $this$addStructureCommands.group("structure", StructureCommandsKt::addStructureCommands$lambda$0);
    }

    private static final void addStructureCommands$lambda$0(CommandDSL $this$group) {
        Intrinsics.checkNotNullParameter((Object)$this$group, (String)"$this$group");
        $this$group.group("set", StructureCommandsKt::addStructureCommands$lambda$0$0);
    }

    private static final void addStructureCommands$lambda$0$0(CommandDSL $this$group) {
        Intrinsics.checkNotNullParameter((Object)$this$group, (String)"$this$group");
        ArgumentType[] argumentTypeArray = new ArgumentType[2];
        Intrinsics.checkNotNullExpressionValue((Object)BlockPosArgument.blockPos(), (String)"blockPos(...)");
        Intrinsics.checkNotNullExpressionValue((Object)StringArgumentType.word(), (String)"word(...)");
        $this$group.add("null_id [pos] [structure_id]", argumentTypeArray, StructureCommandsKt::addStructureCommands$lambda$0$0$0);
    }

    private static final int addStructureCommands$lambda$0$0$0(CommandContext it) {
        NullStructureBlockEntity bee;
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        BlockPos pos = BlockPosArgument.getLoadedBlockPos((CommandContext)it, (String)"pos");
        String id = StringArgumentType.getString((CommandContext)it, (String)"structure_id");
        ServerLevel level = ((CommandSourceStack)it.getSource()).getLevel();
        BlockEntity blockEntity = level.getBlockEntity(pos);
        NullStructureBlockEntity nullStructureBlockEntity = bee = blockEntity instanceof NullStructureBlockEntity ? (NullStructureBlockEntity)blockEntity : null;
        if (bee != null) {
            Intrinsics.checkNotNull((Object)id);
            bee.setStructureId(id);
            bee.setChanged();
            level.sendBlockUpdated(pos, bee.getBlockState(), bee.getBlockState(), 3);
            CommandCxUtil.success$default((String)("Successfully set Null Structure ID to " + id), (CommandContext)it, (boolean)false, (int)2, null);
        } else {
            CommandCxUtil.fail$default((String)"Not a Null Structure Block. Maybe try setting the coords right?", (CommandContext)it, (boolean)false, (int)2, null);
        }
        return 0;
    }
}

