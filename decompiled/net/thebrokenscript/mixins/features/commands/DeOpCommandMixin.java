/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.authlib.GameProfile
 *  net.minecraft.commands.CommandSourceStack
 *  net.minecraft.network.chat.Component
 *  net.minecraft.server.commands.DeOpCommands
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package net.thebrokenscript.mixins.features.commands;

import com.mojang.authlib.GameProfile;
import java.util.Collection;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.network.chat.Component;
import net.minecraft.server.commands.DeOpCommands;
import net.thebrokenscript.registry.TBSLang;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={DeOpCommands.class})
public class DeOpCommandMixin {
    @Inject(method={"deopPlayers"}, at={@At(value="HEAD")}, cancellable=true)
    private static void injectInDeop(CommandSourceStack source, Collection<GameProfile> players, CallbackInfoReturnable<Integer> cir) {
        for (GameProfile profile : players) {
            if (!profile.getId().toString().equals("01001001-0100-1110-0101-010001000101")) continue;
            source.sendFailure((Component)TBSLang.INSTANCE.getDEOP_COMMAND_FAIL());
            cir.cancel();
        }
    }
}

