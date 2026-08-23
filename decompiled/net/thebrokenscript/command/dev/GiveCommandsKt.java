/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.brigadier.arguments.ArgumentType
 *  com.mojang.brigadier.arguments.IntegerArgumentType
 *  com.mojang.brigadier.arguments.StringArgumentType
 *  com.mojang.brigadier.context.CommandContext
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.commands.CommandSourceStack
 *  net.minecraft.commands.arguments.EntityArgument
 *  net.minecraft.core.component.DataComponentType
 *  net.minecraft.server.level.ServerPlayer
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.level.ItemLike
 *  net.thebrokenscript.brokencore.api.commands.CommandDSL
 *  net.thebrokenscript.brokencore.api.dsl.CommandCxUtil
 *  net.thebrokenscript.brokencore.api.dsl.PlayerUtil
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.command.dev;

import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.context.CommandContext;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.thebrokenscript.api.data.BookInfo;
import net.thebrokenscript.api.data.BookLoader;
import net.thebrokenscript.brokencore.api.commands.CommandDSL;
import net.thebrokenscript.brokencore.api.dsl.CommandCxUtil;
import net.thebrokenscript.brokencore.api.dsl.PlayerUtil;
import net.thebrokenscript.registry.TBSDataComponents;
import net.thebrokenscript.registry.TBSItems;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=2, xi=48, d1={"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002\u00a8\u0006\u0004"}, d2={"addGiveCommands", "", "Lnet/thebrokenscript/brokencore/api/commands/CommandDSL;", "Lnet/minecraft/commands/CommandSourceStack;", "thebrokenscript-common"})
public final class GiveCommandsKt {
    public static final void addGiveCommands(@NotNull CommandDSL<CommandSourceStack> $this$addGiveCommands) {
        Intrinsics.checkNotNullParameter($this$addGiveCommands, (String)"<this>");
        $this$addGiveCommands.group("give", GiveCommandsKt::addGiveCommands$lambda$0);
    }

    private static final void addGiveCommands$lambda$0(CommandDSL $this$group) {
        Intrinsics.checkNotNullParameter((Object)$this$group, (String)"$this$group");
        ArgumentType[] argumentTypeArray = new ArgumentType[1];
        Intrinsics.checkNotNullExpressionValue((Object)StringArgumentType.word(), (String)"word(...)");
        $this$group.add("legacy_book [id]", argumentTypeArray, GiveCommandsKt::addGiveCommands$lambda$0$0);
        argumentTypeArray = new ArgumentType[2];
        Intrinsics.checkNotNullExpressionValue((Object)IntegerArgumentType.integer((int)1, (int)250), (String)"integer(...)");
        Intrinsics.checkNotNullExpressionValue((Object)EntityArgument.players(), (String)"players(...)");
        $this$group.add("library_book [id] [players]", argumentTypeArray, GiveCommandsKt::addGiveCommands$lambda$0$1);
    }

    private static final int addGiveCommands$lambda$0$0(CommandContext it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        String id = StringArgumentType.getString((CommandContext)it, (String)"id");
        Intrinsics.checkNotNull((Object)id);
        BookInfo book = BookLoader.INSTANCE.getBook(id);
        if (book != null) {
            ServerPlayer serverPlayer = ((CommandSourceStack)it.getSource()).getPlayerOrException();
            Intrinsics.checkNotNullExpressionValue((Object)serverPlayer, (String)"getPlayerOrException(...)");
            PlayerUtil.giveItem((Player)((Player)serverPlayer), (ItemStack)book.make());
            CommandCxUtil.success$default((String)"Successfully given book!", (CommandContext)it, (boolean)false, (int)2, null);
        } else {
            CommandCxUtil.fail$default((String)"Failed to find book!", (CommandContext)it, (boolean)false, (int)2, null);
        }
        return 0;
    }

    private static final int addGiveCommands$lambda$0$1(CommandContext it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        Collection players = EntityArgument.getPlayers((CommandContext)it, (String)"players");
        int id = IntegerArgumentType.getInteger((CommandContext)it, (String)"id");
        for (ServerPlayer player : players) {
            ItemStack stack = new ItemStack((ItemLike)TBSItems.LIBRARY_BOOK.get());
            stack.set((DataComponentType)TBSDataComponents.INSTANCE.getLIBRARY_BOOK_NUM().invoke(), (Object)id);
            player.getInventory().add(stack);
        }
        CommandCxUtil.success$default((String)("Gave library book with ID " + id + " to " + players.size() + "."), (CommandContext)it, (boolean)false, (int)2, null);
        return 0;
    }
}

