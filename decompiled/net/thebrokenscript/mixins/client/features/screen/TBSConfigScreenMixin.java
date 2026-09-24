/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.gui.components.Button
 *  net.minecraft.client.gui.components.events.GuiEventListener
 *  net.minecraft.client.gui.screens.Screen
 *  net.minecraft.network.chat.Component
 *  net.thebrokenscript.brokencore.api.client.config.BrokenConfigScreen
 *  net.thebrokenscript.brokencore.api.config.ConfigContainer
 *  net.thebrokenscript.brokencore.impl.config.BCConfigs
 *  org.spongepowered.asm.mixin.Final
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package net.thebrokenscript.mixins.client.features.screen;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.events.GuiEventListener;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.thebrokenscript.brokencore.api.client.config.BrokenConfigScreen;
import net.thebrokenscript.brokencore.api.config.ConfigContainer;
import net.thebrokenscript.brokencore.impl.config.BCConfigs;
import net.thebrokenscript.config.TBSConfigs;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={BrokenConfigScreen.class})
public abstract class TBSConfigScreenMixin
extends Screen {
    @Shadow
    @Final
    private ConfigContainer container;

    protected TBSConfigScreenMixin(Component title) {
        super(title);
    }

    @Inject(method={"init"}, at={@At(value="TAIL")})
    private void tbs$addBrokenCoreConfigButton(CallbackInfo ci) {
        if (this.container != TBSConfigs.INSTANCE) {
            return;
        }
        this.addRenderableWidget((GuiEventListener)Button.builder((Component)Component.literal((String)"BrokenCore Config"), button -> Minecraft.getInstance().setScreen((Screen)new BrokenConfigScreen((ConfigContainer)BCConfigs.INSTANCE, (Screen)this, (Component)Component.literal((String)"BrokenCore")))).bounds(this.width - 128, 8, 120, 20).build());
    }
}

