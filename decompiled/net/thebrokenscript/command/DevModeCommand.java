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
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.phys.Vec3
 *  net.thebrokenscript.brokencore.api.commands.CommandDSL
 *  net.thebrokenscript.brokencore.api.dsl.CommandCxUtil
 *  net.thebrokenscript.brokencore.api.ext.EntityTypeExt
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.command;

import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.context.CommandContext;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.brokencore.api.commands.CommandDSL;
import net.thebrokenscript.brokencore.api.dsl.CommandCxUtil;
import net.thebrokenscript.brokencore.api.ext.EntityTypeExt;
import net.thebrokenscript.registry.TBSEntities;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0007\u001a\u00020\b*\b\u0012\u0004\u0012\u00020\n0\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2={"Lnet/thebrokenscript/command/DevModeCommand;", "", "<init>", "()V", "DEV_CODE", "", "DEV_CODE_2_0", "addDevMode", "", "Lnet/thebrokenscript/brokencore/api/commands/CommandDSL;", "Lnet/minecraft/commands/CommandSourceStack;", "thebrokenscript-common"})
public final class DevModeCommand {
    @NotNull
    public static final DevModeCommand INSTANCE = new DevModeCommand();
    @NotNull
    private static final String DEV_CODE = "2018";
    @NotNull
    private static final String DEV_CODE_2_0 = "544253";

    private DevModeCommand() {
    }

    public final void addDevMode(@NotNull CommandDSL<CommandSourceStack> $this$addDevMode) {
        Intrinsics.checkNotNullParameter($this$addDevMode, (String)"<this>");
        ArgumentType[] argumentTypeArray = new ArgumentType[1];
        Intrinsics.checkNotNullExpressionValue((Object)StringArgumentType.string(), (String)"string(...)");
        $this$addDevMode.add("devmode [code]", argumentTypeArray, DevModeCommand::addDevMode$lambda$0);
    }

    private static final int addDevMode$lambda$0(CommandContext it) {
        String code;
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        String string = code = StringArgumentType.getString((CommandContext)it, (String)"code");
        if (Intrinsics.areEqual((Object)string, (Object)DEV_CODE)) {
            CommandCxUtil.success$default((CommandContext)it, (String)"Have fun!", (boolean)false, (int)2, null);
            EntityType entityType = (EntityType)TBSEntities.CIRCUIT.get();
            ServerLevel serverLevel = ((CommandSourceStack)it.getSource()).getLevel();
            Intrinsics.checkNotNullExpressionValue((Object)serverLevel, (String)"getLevel(...)");
            Level level = (Level)serverLevel;
            Vec3 vec3 = ((CommandSourceStack)it.getSource()).getPosition();
            Intrinsics.checkNotNullExpressionValue((Object)vec3, (String)"getPosition(...)");
            EntityTypeExt.trySpawnOneThousand((EntityType)entityType, (Level)level, (Vec3)vec3);
        } else if (Intrinsics.areEqual((Object)string, (Object)DEV_CODE_2_0)) {
            CommandCxUtil.success$default((CommandContext)it, (String)"Have fun!", (boolean)false, (int)2, null);
            EntityType entityType = (EntityType)TBSEntities.THE_BROKEN_END.get();
            ServerLevel serverLevel = ((CommandSourceStack)it.getSource()).getLevel();
            Intrinsics.checkNotNullExpressionValue((Object)serverLevel, (String)"getLevel(...)");
            Level level = (Level)serverLevel;
            Vec3 vec3 = ((CommandSourceStack)it.getSource()).getPosition();
            Intrinsics.checkNotNullExpressionValue((Object)vec3, (String)"getPosition(...)");
            EntityTypeExt.trySpawnOneThousand((EntityType)entityType, (Level)level, (Vec3)vec3);
        } else {
            CommandCxUtil.fail$default((CommandContext)it, (String)"Dev mode code is invalid!", (boolean)false, (int)2, null);
        }
        return 0;
    }
}

