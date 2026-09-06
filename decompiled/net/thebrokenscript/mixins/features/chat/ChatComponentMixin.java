/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.llamalad7.mixinextras.injector.wrapoperation.Operation
 *  com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation
 *  com.llamalad7.mixinextras.sugar.Local
 *  net.minecraft.client.GuiMessage
 *  net.minecraft.client.GuiMessage$Line
 *  net.minecraft.client.GuiMessageTag
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.gui.Font
 *  net.minecraft.client.gui.GuiGraphics
 *  net.minecraft.client.gui.components.ChatComponent
 *  net.minecraft.network.chat.Style
 *  net.minecraft.util.FormattedCharSequence
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package net.thebrokenscript.mixins.features.chat;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.llamalad7.mixinextras.sugar.Local;
import java.util.Objects;
import net.minecraft.client.GuiMessage;
import net.minecraft.client.GuiMessageTag;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.ChatComponent;
import net.minecraft.network.chat.Style;
import net.minecraft.util.FormattedCharSequence;
import net.thebrokenscript.api.TBSConstants;
import net.thebrokenscript.client.TBSLibraryAnimations;
import net.thebrokenscript.client.util.LibraryTextUtils;
import net.thebrokenscript.mixinterfaces.GuiMessageLineExt;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={ChatComponent.class})
public class ChatComponentMixin {
    @Unique
    private long tbs$opened = 0L;

    @Inject(method={"<init>"}, at={@At(value="TAIL")})
    private void tbs$setOpened(Minecraft minecraft, CallbackInfo ci) {
        this.tbs$opened = System.currentTimeMillis();
    }

    @WrapOperation(method={"render"}, at={@At(value="INVOKE", target="Lnet/minecraft/client/gui/GuiGraphics;drawString(Lnet/minecraft/client/gui/Font;Lnet/minecraft/util/FormattedCharSequence;III)I", ordinal=0)})
    public int tbs$renderShakyText(GuiGraphics instance, Font font, FormattedCharSequence text, int x, int y, int color, Operation<Integer> original, @Local GuiMessage.Line line) {
        Style style = ((GuiMessageLineExt)line).tbs$getStyle();
        if (style != null && Objects.equals(style.getFont().toString(), TBSConstants.id("shake").toString())) {
            TBSLibraryAnimations.INSTANCE.jitteryText(instance, text, font, x, y, (float)(System.currentTimeMillis() - this.tbs$opened) / 1000.0f, LibraryTextUtils.fromStyle(style));
            return 69420;
        }
        return (Integer)original.call(new Object[]{instance, font, text, x, y, color});
    }

    @WrapOperation(method={"addMessageToDisplayQueue"}, at={@At(value="NEW", target="(ILnet/minecraft/util/FormattedCharSequence;Lnet/minecraft/client/GuiMessageTag;Z)Lnet/minecraft/client/GuiMessage$Line;")})
    public GuiMessage.Line tbs$addStyle(int i, FormattedCharSequence formattedCharSequence, GuiMessageTag guiMessageTag, boolean bl, Operation<GuiMessage.Line> original, @Local(argsOnly=true) GuiMessage msg) {
        GuiMessage.Line orig = (GuiMessage.Line)original.call(new Object[]{i, formattedCharSequence, guiMessageTag, bl});
        ((GuiMessageLineExt)orig).tbs$setStyle(msg.content().getStyle());
        return orig;
    }
}

