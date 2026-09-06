/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.commands.CommandSourceStack
 *  net.minecraft.network.chat.Component
 *  net.minecraft.server.commands.TeleportCommand
 *  net.minecraft.server.level.ServerPlayer
 *  net.minecraft.world.entity.Entity
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package net.thebrokenscript.mixins.features.commands;

import java.util.Collection;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.network.chat.Component;
import net.minecraft.server.commands.TeleportCommand;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.thebrokenscript.misc.GameProfiles;
import net.thebrokenscript.registry.TBSLang;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={TeleportCommand.class})
public class TeleportCommandMixin {
    @Inject(method={"teleportToEntity"}, at={@At(value="HEAD")}, cancellable=true)
    private static void tbs$teleportNull(CommandSourceStack source, Collection<? extends Entity> targets, Entity destination, CallbackInfoReturnable<Integer> cir) {
        if (destination instanceof ServerPlayer && ((ServerPlayer)destination).connection.getPlayer().getGameProfile() == GameProfiles.NULL_GAME_PROFILE) {
            source.sendFailure((Component)TBSLang.INSTANCE.getTP_COMMAND_FAIL());
            cir.cancel();
        }
    }
}

