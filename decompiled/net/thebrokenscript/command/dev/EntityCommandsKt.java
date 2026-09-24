/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.brigadier.arguments.ArgumentType
 *  com.mojang.brigadier.context.CommandContext
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.Ref$IntRef
 *  net.minecraft.commands.CommandSourceStack
 *  net.minecraft.commands.arguments.EntityArgument
 *  net.minecraft.network.chat.Component
 *  net.minecraft.network.chat.MutableComponent
 *  net.minecraft.world.entity.Entity
 *  net.thebrokenscript.brokencore.api.commands.CommandDSL
 *  net.thebrokenscript.brokencore.api.dsl.CommandCxUtil
 *  net.thebrokenscript.brokencore.api.dsl.ComponentUtil
 *  net.thebrokenscript.brokencore.api.dsl.EntityUtil
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.command.dev;

import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.context.CommandContext;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.entity.Entity;
import net.thebrokenscript.brokencore.api.commands.CommandDSL;
import net.thebrokenscript.brokencore.api.dsl.CommandCxUtil;
import net.thebrokenscript.brokencore.api.dsl.ComponentUtil;
import net.thebrokenscript.brokencore.api.dsl.EntityUtil;
import net.thebrokenscript.data.CircuitInhabited;
import net.thebrokenscript.registry.TBSDataAttachments;
import net.thebrokenscript.registry.TBSLang;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=2, xi=48, d1={"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002\u00a8\u0006\u0004"}, d2={"addEntityCommands", "", "Lnet/thebrokenscript/brokencore/api/commands/CommandDSL;", "Lnet/minecraft/commands/CommandSourceStack;", "thebrokenscript-common"})
public final class EntityCommandsKt {
    public static final void addEntityCommands(@NotNull CommandDSL<CommandSourceStack> $this$addEntityCommands) {
        Intrinsics.checkNotNullParameter($this$addEntityCommands, (String)"<this>");
        $this$addEntityCommands.group("entity", EntityCommandsKt::addEntityCommands$lambda$0);
    }

    private static final void addEntityCommands$lambda$0(CommandDSL $this$group) {
        Intrinsics.checkNotNullParameter((Object)$this$group, (String)"$this$group");
        ArgumentType[] argumentTypeArray = new ArgumentType[1];
        Intrinsics.checkNotNullExpressionValue((Object)EntityArgument.entities(), (String)"entities(...)");
        $this$group.add("inhabit [targets]", argumentTypeArray, EntityCommandsKt::addEntityCommands$lambda$0$0);
    }

    private static final int addEntityCommands$lambda$0$0(CommandContext it) {
        block1: {
            Intrinsics.checkNotNullParameter((Object)it, (String)"it");
            Collection targets = EntityArgument.getEntities((CommandContext)it, (String)"targets");
            Ref.IntRef success = new Ref.IntRef();
            for (Entity target : targets) {
                EntityUtil.updateData((Entity)target, TBSDataAttachments.CIRCUIT_INHABITED, arg_0 -> EntityCommandsKt.addEntityCommands$lambda$0$0$0(success, arg_0));
            }
            MutableComponent mutableComponent = ComponentUtil.format((Component)((Component)TBSLang.INSTANCE.getCMD_INHABIT_SUCCESS()), (Object)success.element);
            if (mutableComponent == null) break block1;
            CommandCxUtil.success$default((Component)((Component)mutableComponent), (CommandContext)it, (boolean)false, (int)2, null);
        }
        return 0;
    }

    private static final Unit addEntityCommands$lambda$0$0$0(Ref.IntRef $success, CircuitInhabited dat) {
        Intrinsics.checkNotNullParameter((Object)dat, (String)"dat");
        dat.setInhabited(true);
        int n = $success.element;
        $success.element = n + 1;
        return Unit.INSTANCE;
    }
}

