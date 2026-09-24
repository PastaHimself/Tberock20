/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.commands.CommandSourceStack
 *  net.minecraft.network.chat.Component
 *  net.minecraft.server.commands.KickCommand
 *  net.minecraft.server.level.ServerPlayer
 *  net.minecraft.world.level.LevelAccessor
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package net.thebrokenscript.mixins.features.commands;

import java.util.Collection;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.network.chat.Component;
import net.minecraft.server.commands.KickCommand;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.LevelAccessor;
import net.thebrokenscript.api.ext.LevelExt;
import net.thebrokenscript.misc.GameProfiles;
import net.thebrokenscript.registry.TBSLang;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={KickCommand.class})
public class KickCommandMixin {
    @Inject(method={"kickPlayers"}, at={@At(value="HEAD")}, cancellable=true)
    private static void tbs$kickPlayers(CommandSourceStack source, Collection<ServerPlayer> players, Component reason, CallbackInfoReturnable<Integer> cir) {
        if (players.stream().anyMatch(it -> it.getGameProfile() == GameProfiles.NULL_GAME_PROFILE) && LevelExt.INSTANCE.getVars((LevelAccessor)source.getLevel()).isNullHere()) {
            source.sendFailure((Component)TBSLang.INSTANCE.getKICK_COMMAND_FAIL());
            cir.cancel();
        }
    }
}

