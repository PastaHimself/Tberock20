/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.brigadier.context.CommandContext
 *  net.minecraft.commands.CommandSourceStack
 *  net.minecraft.server.commands.GameRuleCommand
 *  net.minecraft.world.level.GameRules
 *  net.minecraft.world.level.GameRules$Key
 *  net.minecraft.world.level.GameRules$Value
 *  net.minecraft.world.level.LevelAccessor
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package net.thebrokenscript.mixins.features.commands;

import com.mojang.brigadier.context.CommandContext;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.server.commands.GameRuleCommand;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.LevelAccessor;
import net.thebrokenscript.api.ext.LevelExt;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={GameRuleCommand.class})
public class GameRuleCommandMixin {
    @Inject(method={"setRule"}, at={@At(value="HEAD")}, cancellable=true)
    private static <T extends GameRules.Value<T>> void setRule(CommandContext<CommandSourceStack> source, GameRules.Key<T> gameRule, CallbackInfoReturnable<Integer> cir) {
        if (!LevelExt.INSTANCE.getVars((LevelAccessor)((CommandSourceStack)source.getSource()).getLevel()).getDaylightCycle() && gameRule.equals((Object)GameRules.RULE_DAYLIGHT)) {
            cir.cancel();
        }
    }
}

