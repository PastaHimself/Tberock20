/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.gui.screens.Screen
 *  net.minecraft.client.sounds.SoundManager
 *  org.spongepowered.asm.mixin.Final
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.Redirect
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package net.thebrokenscript.brokencore.impl.mixin.client.features.sounds;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.sounds.SoundManager;
import net.thebrokenscript.brokencore.impl.mixin.client.features.sounds.SoundManagerAccessor;
import net.thebrokenscript.brokencore.impl.mixinterfaces.ShittyStopExt;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={Minecraft.class})
public class MinecraftMixin {
    @Shadow
    @Final
    private SoundManager soundManager;

    @Redirect(method={"updateScreenAndTick"}, at=@At(value="INVOKE", target="Lnet/minecraft/client/sounds/SoundManager;stop()V"))
    public void bc$allowFancyAudioBypass(SoundManager instance) {
        ShittyStopExt extra = (ShittyStopExt)((SoundManagerAccessor)instance).bc$getSoundEngine();
        extra.bc$setStopFancyAudio(false);
        instance.stop();
        extra.bc$setStopFancyAudio(true);
    }

    @Inject(method={"disconnect(Lnet/minecraft/client/gui/screens/Screen;Z)V"}, at={@At(value="HEAD")})
    public void bc$stopFancyAudio(Screen nextScreen, boolean keepResourcePacks, CallbackInfo ci) {
        ((ShittyStopExt)((SoundManagerAccessor)this.soundManager).bc$getSoundEngine()).bc$setStopFancyAudio(true);
        this.soundManager.stop();
    }
}

