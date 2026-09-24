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
 *  net.minecraft.world.phys.Vec3
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.impl.commands;

import com.mojang.brigadier.context.CommandContext;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.brokencore.api.commands.CommandDSL;
import net.thebrokenscript.brokencore.api.dsl.CommandCxUtil;
import net.thebrokenscript.brokencore.api.dsl.MathUtil;
import net.thebrokenscript.brokencore.api.world.ChunkHelper;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u0005*\b\u0012\u0004\u0012\u00020\u00070\u0006\u00a8\u0006\b"}, d2={"Lnet/thebrokenscript/brokencore/impl/commands/ChunkCommands;", "", "<init>", "()V", "addChunkCommands", "", "Lnet/thebrokenscript/brokencore/api/commands/CommandDSL;", "Lnet/minecraft/commands/CommandSourceStack;", "brokencore-common"})
public final class ChunkCommands {
    @NotNull
    public static final ChunkCommands INSTANCE = new ChunkCommands();

    private ChunkCommands() {
    }

    public final void addChunkCommands(@NotNull CommandDSL<CommandSourceStack> $this$addChunkCommands) {
        Intrinsics.checkNotNullParameter($this$addChunkCommands, (String)"<this>");
        $this$addChunkCommands.group("chunk", ChunkCommands::addChunkCommands$lambda$0);
    }

    private static final void addChunkCommands$lambda$0(CommandDSL $this$group) {
        Intrinsics.checkNotNullParameter((Object)$this$group, (String)"$this$group");
        $this$group.add("remove", ChunkCommands::addChunkCommands$lambda$0$0);
    }

    private static final int addChunkCommands$lambda$0$0(CommandContext it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        Vec3 pos = ((CommandSourceStack)it.getSource()).getPosition();
        ServerLevel serverLevel = ((CommandSourceStack)it.getSource()).getLevel();
        Intrinsics.checkNotNullExpressionValue((Object)serverLevel, (String)"getLevel(...)");
        ChunkHelper.INSTANCE.clearChunk((LevelAccessor)serverLevel, pos.x, pos.z);
        CommandCxUtil.success$default(it, "Successfully cleared the chunk at (" + MathUtil.ishr(pos.x, 4) + ", " + MathUtil.ishr(pos.z, 4) + ")", false, 2, null);
        return 0;
    }
}

