/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.GuiMessage$Line
 *  net.minecraft.network.chat.Style
 *  org.jetbrains.annotations.Nullable
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Unique
 */
package net.thebrokenscript.mixins.features.chat;

import net.minecraft.client.GuiMessage;
import net.minecraft.network.chat.Style;
import net.thebrokenscript.mixinterfaces.GuiMessageLineExt;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

@Mixin(value={GuiMessage.Line.class})
public class GuiMessageLineMixin
implements GuiMessageLineExt {
    @Unique
    @Nullable
    private Style tbs$style = null;

    @Override
    public void tbs$setStyle(Style style) {
        this.tbs$style = style;
    }

    @Override
    @Nullable
    public Style tbs$getStyle() {
        return this.tbs$style;
    }
}

