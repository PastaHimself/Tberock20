/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.commands.CommandSourceStack
 *  net.minecraft.commands.arguments.item.ItemInput
 *  net.minecraft.network.chat.Component
 *  net.minecraft.server.commands.GiveCommand
 *  net.minecraft.server.level.ServerPlayer
 *  net.minecraft.world.item.Item
 *  net.thebrokenscript.brokencore.api.platform.PlatformUtil
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package net.thebrokenscript.mixins.features.commands;

import java.util.Collection;
import java.util.Objects;
import java.util.Set;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.arguments.item.ItemInput;
import net.minecraft.network.chat.Component;
import net.minecraft.server.commands.GiveCommand;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.Item;
import net.thebrokenscript.brokencore.api.platform.PlatformUtil;
import net.thebrokenscript.registry.TBSBlocks;
import net.thebrokenscript.registry.TBSItems;
import net.thebrokenscript.registry.TBSLang;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={GiveCommand.class})
public class GiveCommandMixin {
    @Unique
    private static Set<Item> tbs$getInvalidItems() {
        return Set.of(Objects.requireNonNull(TBSBlocks.CORRUPTED_COMMAND_BLOCK.getItem()), (Item)TBSItems.TORN_PIECE_1.get(), (Item)TBSItems.TORN_PIECE_2.get(), (Item)TBSItems.TORN_PIECE_3.get(), (Item)TBSItems.TORN_PIECE_4.get(), (Item)TBSItems.TORN_PIECE_5.get(), (Item)TBSItems.POLAROID.get(), (Item)TBSItems.TORN_PAPER.get(), (Item)TBSItems.INTEGRITY_FIREBALL.get());
    }

    @Inject(method={"giveItem"}, at={@At(value="HEAD")}, cancellable=true)
    private static void tbs$cancelCommandBlock(CommandSourceStack source, ItemInput item, Collection<ServerPlayer> targets, int count, CallbackInfoReturnable<Integer> cir) {
        if (PlatformUtil.Companion.isProduction() && GiveCommandMixin.tbs$getInvalidItems().contains(item.getItem())) {
            source.sendFailure((Component)TBSLang.INSTANCE.getGIVE_COMMAND_FAIL());
            cir.cancel();
        }
    }
}

