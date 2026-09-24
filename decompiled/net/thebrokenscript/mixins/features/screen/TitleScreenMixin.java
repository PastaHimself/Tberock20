/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.gui.screens.Screen
 *  net.minecraft.client.gui.screens.TitleScreen
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package net.thebrokenscript.mixins.features.screen;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.TitleScreen;
import net.thebrokenscript.client.gui.WarningScreen;
import net.thebrokenscript.config.TBSConfigs;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={TitleScreen.class})
public class TitleScreenMixin {
    @Unique
    private static boolean tbs$hasShownCustomScreen = false;

    @Inject(method={"init"}, at={@At(value="HEAD")}, cancellable=true)
    private void onInit(CallbackInfo ci) {
        if (!tbs$hasShownCustomScreen) {
            if (TBSConfigs.INSTANCE.getClient().getAccessibility().getShowPhotosensitivityWarning()) {
                Minecraft.getInstance().setScreen((Screen)new WarningScreen());
            }
            tbs$hasShownCustomScreen = true;
            ci.cancel();
        }
    }
}

