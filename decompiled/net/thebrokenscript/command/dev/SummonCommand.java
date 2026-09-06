/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.brigadier.arguments.ArgumentType
 *  com.mojang.brigadier.arguments.StringArgumentType
 *  com.mojang.brigadier.context.CommandContext
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.commands.CommandSourceStack
 *  net.minecraft.network.chat.Component
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.phys.Vec3
 *  net.thebrokenscript.brokencore.api.commands.CommandDSL
 *  net.thebrokenscript.brokencore.api.dsl.CommandCxUtil
 *  net.thebrokenscript.brokencore.api.ext.EntityTypeExt
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.command.dev;

import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.context.CommandContext;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.TheBrokenScript;
import net.thebrokenscript.brokencore.api.commands.CommandDSL;
import net.thebrokenscript.brokencore.api.dsl.CommandCxUtil;
import net.thebrokenscript.brokencore.api.ext.EntityTypeExt;
import net.thebrokenscript.command.dev.UserAPI;
import net.thebrokenscript.entity.circuit.FakePlayerEntity;
import net.thebrokenscript.registry.TBSEntities;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u0005*\b\u0012\u0004\u0012\u00020\u00070\u0006\u00a8\u0006\b"}, d2={"Lnet/thebrokenscript/command/dev/SummonCommand;", "", "<init>", "()V", "addSummonCommands", "", "Lnet/thebrokenscript/brokencore/api/commands/CommandDSL;", "Lnet/minecraft/commands/CommandSourceStack;", "thebrokenscript-common"})
@SourceDebugExtension(value={"SMAP\nSummonCommand.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SummonCommand.kt\nnet/thebrokenscript/command/dev/SummonCommand\n+ 2 ComponentDSL.kt\nnet/thebrokenscript/brokencore/api/dsl/ComponentUtil\n*L\n1#1,40:1\n15#2:41\n*S KotlinDebug\n*F\n+ 1 SummonCommand.kt\nnet/thebrokenscript/command/dev/SummonCommand\n*L\n33#1:41\n*E\n"})
public final class SummonCommand {
    @NotNull
    public static final SummonCommand INSTANCE = new SummonCommand();

    private SummonCommand() {
    }

    public final void addSummonCommands(@NotNull CommandDSL<CommandSourceStack> $this$addSummonCommands) {
        Intrinsics.checkNotNullParameter($this$addSummonCommands, (String)"<this>");
        $this$addSummonCommands.group("summon", SummonCommand::addSummonCommands$lambda$0);
    }

    private static final void addSummonCommands$lambda$0(CommandDSL $this$group) {
        Intrinsics.checkNotNullParameter((Object)$this$group, (String)"$this$group");
        ArgumentType[] argumentTypeArray = new ArgumentType[1];
        Intrinsics.checkNotNullExpressionValue((Object)StringArgumentType.string(), (String)"string(...)");
        $this$group.add("fake_player [user]", argumentTypeArray, SummonCommand::addSummonCommands$lambda$0$0);
    }

    private static final int addSummonCommands$lambda$0$0(CommandContext it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        String user = StringArgumentType.getString((CommandContext)it, (String)"user");
        Intrinsics.checkNotNull((Object)user);
        UUID uuid = UserAPI.INSTANCE.lookupUuid(user);
        if (uuid == null) {
            CommandCxUtil.fail$default((String)"Failed to retrieve user UUID!", (CommandContext)it, (boolean)false, (int)2, null);
            return 0;
        }
        EntityType entityType = (EntityType)TBSEntities.FAKE_PLAYER.get();
        ServerLevel serverLevel = ((CommandSourceStack)it.getSource()).getLevel();
        Intrinsics.checkNotNullExpressionValue((Object)serverLevel, (String)"getLevel(...)");
        LevelAccessor levelAccessor = (LevelAccessor)serverLevel;
        Vec3 vec3 = ((CommandSourceStack)it.getSource()).getPosition();
        Intrinsics.checkNotNullExpressionValue((Object)vec3, (String)"getPosition(...)");
        FakePlayerEntity entity = (FakePlayerEntity)EntityTypeExt.trySummonTyped((EntityType)entityType, (LevelAccessor)levelAccessor, (Vec3)vec3);
        if (entity == null) {
            CommandCxUtil.fail$default((String)"Failed to summon entity!", (CommandContext)it, (boolean)false, (int)2, null);
            return 0;
        }
        TheBrokenScript.serverWorkQueue.add(10L, () -> SummonCommand.addSummonCommands$lambda$0$0$0(entity, uuid, user));
        return 0;
    }

    private static final Unit addSummonCommands$lambda$0$0$0(FakePlayerEntity $entity, UUID $uuid, String $user) {
        $entity.setSelectedPlayer($uuid);
        String $this$c$iv = $user;
        boolean $i$f$getC = false;
        Component component = Component.nullToEmpty((String)$this$c$iv);
        Intrinsics.checkNotNullExpressionValue((Object)component, (String)"nullToEmpty(...)");
        $entity.setCustomName(component);
        return Unit.INSTANCE;
    }
}

