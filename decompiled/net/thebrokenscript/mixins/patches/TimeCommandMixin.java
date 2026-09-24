/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.commands.CommandSourceStack
 *  net.minecraft.server.commands.TimeCommand
 *  net.thebrokenscript.brokencore.api.platform.PlatformUtil
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package net.thebrokenscript.mixins.patches;

import net.minecraft.commands.CommandSourceStack;
import net.minecraft.server.commands.TimeCommand;
import net.thebrokenscript.brokencore.api.platform.PlatformUtil;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={TimeCommand.class})
public class TimeCommandMixin {
    @Inject(method={"addTime"}, at={@At(value="HEAD")}, cancellable=true)
    private static void tbs$stopClickbait(CommandSourceStack source, int amount, CallbackInfoReturnable<Integer> cir) {
        if (amount >= 24000 && PlatformUtil.Companion.isProduction()) {
            cir.cancel();
        }
    }
}

