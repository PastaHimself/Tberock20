/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.brigadier.arguments.ArgumentType
 *  com.mojang.brigadier.context.CommandContext
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.commands.CommandSourceStack
 *  net.minecraft.commands.arguments.EntityArgument
 *  net.minecraft.network.chat.Component
 *  net.minecraft.network.chat.MutableComponent
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.player.Player
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.impl.commands;

import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.context.CommandContext;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.thebrokenscript.brokencore.api.commands.CommandDSL;
import net.thebrokenscript.brokencore.api.dsl.CommandCxUtil;
import net.thebrokenscript.brokencore.api.dsl.ComponentUtil;
import net.thebrokenscript.brokencore.impl.registry.BCLang;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=2, xi=48, d1={"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002\u00a8\u0006\u0004"}, d2={"addCoreEntityCommands", "", "Lnet/thebrokenscript/brokencore/api/commands/CommandDSL;", "Lnet/minecraft/commands/CommandSourceStack;", "brokencore-common"})
public final class EntityCommandsKt {
    public static final void addCoreEntityCommands(@NotNull CommandDSL<CommandSourceStack> $this$addCoreEntityCommands) {
        Intrinsics.checkNotNullParameter($this$addCoreEntityCommands, (String)"<this>");
        $this$addCoreEntityCommands.group("entity", EntityCommandsKt::addCoreEntityCommands$lambda$0);
    }

    private static final void addCoreEntityCommands$lambda$0(CommandDSL $this$group) {
        Intrinsics.checkNotNullParameter((Object)$this$group, (String)"$this$group");
        ArgumentType[] argumentTypeArray = new ArgumentType[1];
        Intrinsics.checkNotNullExpressionValue((Object)EntityArgument.entities(), (String)"entities(...)");
        $this$group.add("discard [targets]", argumentTypeArray, EntityCommandsKt::addCoreEntityCommands$lambda$0$0);
    }

    private static final int addCoreEntityCommands$lambda$0$0(CommandContext it) {
        block1: {
            Intrinsics.checkNotNullParameter((Object)it, (String)"it");
            Collection targets = EntityArgument.getEntities((CommandContext)it, (String)"targets");
            for (Entity target : targets) {
                if (target instanceof Player) continue;
                target.discard();
            }
            MutableComponent mutableComponent = ComponentUtil.format((Component)BCLang.INSTANCE.getCOMMAND_DISCARD_ENTITY_SUCCESS(), targets.size());
            if (mutableComponent == null) break block1;
            CommandCxUtil.success$default((Component)mutableComponent, it, false, 2, null);
        }
        return 0;
    }
}

