/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.brigadier.CommandDispatcher
 *  com.mojang.brigadier.arguments.ArgumentType
 *  com.mojang.brigadier.context.CommandContext
 *  kotlin.Metadata
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.commands.CommandSourceStack
 *  net.minecraft.commands.arguments.coordinates.BlockPosArgument
 *  net.minecraft.core.BlockPos
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.server.level.ServerLevel
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.impl.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.context.CommandContext;
import java.util.Collection;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.arguments.coordinates.BlockPosArgument;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.thebrokenscript.brokencore.api.commands.CommandDSL;
import net.thebrokenscript.brokencore.api.commands.arguments.ResourceLocationSetArgument;
import net.thebrokenscript.brokencore.api.dsl.CommandCxUtil;
import net.thebrokenscript.brokencore.api.xcsf.XcsfStructure;
import net.thebrokenscript.brokencore.impl.commands.ChunkCommands;
import net.thebrokenscript.brokencore.impl.commands.DebuggerCommands;
import net.thebrokenscript.brokencore.impl.commands.EntityCommandsKt;
import net.thebrokenscript.brokencore.impl.commands.EventCommands;
import net.thebrokenscript.brokencore.impl.commands.InspectCommands;
import net.thebrokenscript.brokencore.impl.commands.OverlayCommands;
import net.thebrokenscript.brokencore.impl.commands.PopupCommands;
import net.thebrokenscript.brokencore.impl.commands.TimeCommands;
import net.thebrokenscript.brokencore.impl.config.BCConfigs;
import net.thebrokenscript.brokencore.impl.resources.ReloadListener;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007J\u0016\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\fH\u0002\u00a8\u0006\r"}, d2={"Lnet/thebrokenscript/brokencore/impl/commands/BCCommands;", "", "<init>", "()V", "register", "", "dispatcher", "Lcom/mojang/brigadier/CommandDispatcher;", "Lnet/minecraft/commands/CommandSourceStack;", "devCheck", "", "it", "Lcom/mojang/brigadier/context/CommandContext;", "brokencore-common"})
public final class BCCommands {
    @NotNull
    public static final BCCommands INSTANCE = new BCCommands();

    private BCCommands() {
    }

    public final void register(@NotNull CommandDispatcher<CommandSourceStack> dispatcher) {
        Intrinsics.checkNotNullParameter(dispatcher, (String)"dispatcher");
        new CommandDSL(dispatcher, null, BCCommands::register$lambda$0, 2, null);
    }

    private final boolean devCheck(CommandContext<CommandSourceStack> it) {
        if (!BCConfigs.INSTANCE.getServer().getEnableCheats()) {
            CommandCxUtil.fail$default(it, "Cheats are not enabled!", false, 2, null);
            return false;
        }
        return true;
    }

    private static final void register$lambda$0(CommandDSL $this$CommandDSL) {
        Intrinsics.checkNotNullParameter((Object)$this$CommandDSL, (String)"$this$CommandDSL");
        $this$CommandDSL.group("bc", BCCommands::register$lambda$0$0);
    }

    private static final void register$lambda$0$0(CommandDSL $this$group) {
        Intrinsics.checkNotNullParameter((Object)$this$group, (String)"$this$group");
        $this$group.beforeAll(BCCommands::register$lambda$0$0$0);
        ChunkCommands.INSTANCE.addChunkCommands($this$group);
        TimeCommands.INSTANCE.addTimeCommands($this$group);
        OverlayCommands.INSTANCE.addOverlayCommands($this$group);
        EventCommands.INSTANCE.addEventCommands($this$group);
        PopupCommands.INSTANCE.addPopupCommands($this$group);
        InspectCommands.INSTANCE.addInspectCommands($this$group);
        EntityCommandsKt.addCoreEntityCommands($this$group);
        DebuggerCommands.INSTANCE.addDebuggerCommands($this$group);
        $this$group.group("xcsf", BCCommands::register$lambda$0$0$1);
    }

    private static final Integer register$lambda$0$0$0(CommandContext it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        return !INSTANCE.devCheck((CommandContext<CommandSourceStack>)it) ? Integer.valueOf(0) : null;
    }

    private static final void register$lambda$0$0$1(CommandDSL $this$group) {
        Intrinsics.checkNotNullParameter((Object)$this$group, (String)"$this$group");
        ArgumentType[] argumentTypeArray = new ArgumentType[2];
        argumentTypeArray[0] = ResourceLocationSetArgument.Companion.idSet((Function0<? extends Collection<ResourceLocation>>)((Function0)BCCommands::register$lambda$0$0$1$0));
        Intrinsics.checkNotNullExpressionValue((Object)BlockPosArgument.blockPos(), (String)"blockPos(...)");
        $this$group.add("place [id] [pos]", argumentTypeArray, BCCommands::register$lambda$0$0$1$1);
    }

    private static final Collection register$lambda$0$0$1$0() {
        Set set = ReloadListener.INSTANCE.getXcsfStructures().keySet();
        Intrinsics.checkNotNullExpressionValue((Object)set, (String)"<get-keys>(...)");
        return set;
    }

    private static final int register$lambda$0$0$1$1(CommandContext it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        ResourceLocation id = (ResourceLocation)it.getArgument("id", ResourceLocation.class);
        BlockPos pos = BlockPosArgument.getBlockPos((CommandContext)it, (String)"pos");
        XcsfStructure res = (XcsfStructure)ReloadListener.INSTANCE.getXcsfStructures().get((Object)id);
        if (res == null) {
            CommandCxUtil.fail$default(it, "Failed to find XCSF structure \"" + id + "\"", false, 2, null);
        } else {
            ServerLevel serverLevel = ((CommandSourceStack)it.getSource()).getLevel();
            Intrinsics.checkNotNullExpressionValue((Object)serverLevel, (String)"getLevel(...)");
            Intrinsics.checkNotNull((Object)pos);
            res.place(serverLevel, pos);
            CommandCxUtil.success$default(it, "Successfully placed XCSF structure \"" + id + "\" at [" + pos.getX() + " " + pos.getY() + " " + pos.getZ() + "]!", false, 2, null);
        }
        return 0;
    }
}

