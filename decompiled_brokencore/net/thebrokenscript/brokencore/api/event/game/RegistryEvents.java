/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.brigadier.CommandDispatcher
 *  kotlin.Metadata
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.commands.CommandBuildContext
 *  net.minecraft.commands.CommandSourceStack
 *  net.minecraft.commands.Commands$CommandSelection
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.event.game;

import com.mojang.brigadier.CommandDispatcher;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.commands.CommandBuildContext;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.thebrokenscript.brokencore.api.event.GameEvent;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u0007B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2={"Lnet/thebrokenscript/brokencore/api/event/game/RegistryEvents;", "", "<init>", "()V", "REGISTER_COMMANDS", "Lnet/thebrokenscript/brokencore/api/event/GameEvent;", "Lnet/thebrokenscript/brokencore/api/event/game/RegistryEvents$RegisterCommands;", "RegisterCommands", "brokencore-common"})
public final class RegistryEvents {
    @NotNull
    public static final RegistryEvents INSTANCE = new RegistryEvents();
    @JvmField
    @NotNull
    public static final GameEvent<RegisterCommands> REGISTER_COMMANDS = new GameEvent();

    private RegistryEvents() {
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0016\u0018\u00002\u00020\u0001B%\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0004\b\t\u0010\nR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0011"}, d2={"Lnet/thebrokenscript/brokencore/api/event/game/RegistryEvents$RegisterCommands;", "", "dispatcher", "Lcom/mojang/brigadier/CommandDispatcher;", "Lnet/minecraft/commands/CommandSourceStack;", "commandSelection", "Lnet/minecraft/commands/Commands$CommandSelection;", "buildContext", "Lnet/minecraft/commands/CommandBuildContext;", "<init>", "(Lcom/mojang/brigadier/CommandDispatcher;Lnet/minecraft/commands/Commands$CommandSelection;Lnet/minecraft/commands/CommandBuildContext;)V", "getDispatcher", "()Lcom/mojang/brigadier/CommandDispatcher;", "getCommandSelection", "()Lnet/minecraft/commands/Commands$CommandSelection;", "getBuildContext", "()Lnet/minecraft/commands/CommandBuildContext;", "brokencore-common"})
    public static class RegisterCommands {
        @NotNull
        private final CommandDispatcher<CommandSourceStack> dispatcher;
        @NotNull
        private final Commands.CommandSelection commandSelection;
        @NotNull
        private final CommandBuildContext buildContext;

        public RegisterCommands(@NotNull CommandDispatcher<CommandSourceStack> dispatcher, @NotNull Commands.CommandSelection commandSelection, @NotNull CommandBuildContext buildContext) {
            Intrinsics.checkNotNullParameter(dispatcher, (String)"dispatcher");
            Intrinsics.checkNotNullParameter((Object)commandSelection, (String)"commandSelection");
            Intrinsics.checkNotNullParameter((Object)buildContext, (String)"buildContext");
            this.dispatcher = dispatcher;
            this.commandSelection = commandSelection;
            this.buildContext = buildContext;
        }

        @NotNull
        public final CommandDispatcher<CommandSourceStack> getDispatcher() {
            return this.dispatcher;
        }

        @NotNull
        public final Commands.CommandSelection getCommandSelection() {
            return this.commandSelection;
        }

        @NotNull
        public final CommandBuildContext getBuildContext() {
            return this.buildContext;
        }
    }
}

