/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.GuiMessage
 *  net.minecraft.client.GuiMessageTag
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package net.thebrokenscript.mixins.features.chat;

import net.minecraft.client.GuiMessage;
import net.minecraft.client.GuiMessageTag;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={GuiMessage.class})
public class GuiMessageMixin {
    @Inject(method={"tag"}, at={@At(value="RETURN")}, cancellable=true)
    public void tbs$rewriteTag(CallbackInfoReturnable<GuiMessageTag> cir) {
        cir.setReturnValue(null);
    }
}

