/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.llamalad7.mixinextras.injector.ModifyReturnValue
 *  com.mojang.blaze3d.audio.Channel
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package net.thebrokenscript.brokencore.impl.mixin.client.features.sounds;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import com.mojang.blaze3d.audio.Channel;
import net.thebrokenscript.brokencore.api.mixinterfaces.AudioChannelExt;
import net.thebrokenscript.brokencore.api.sound.AudioEffects;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={Channel.class})
public class ChannelMixin {
    @Unique
    private int bc$ticksSinceStop = 0;

    @Inject(method={"updateStream"}, at={@At(value="HEAD")})
    private void bc$incrementTicks(CallbackInfo ci) {
        ++this.bc$ticksSinceStop;
    }

    @ModifyReturnValue(method={"stopped"}, at={@At(value="RETURN")})
    private boolean bc$waitForReverb(boolean original) {
        boolean hasReverb;
        AudioChannelExt ext = (AudioChannelExt)((Object)this);
        boolean bl = hasReverb = ext.bc$hasEffect(AudioEffects.REVERB.getId()) || ext.bc$hasEffect(AudioEffects.EAX_REVERB.getId());
        return hasReverb ? original && this.bc$ticksSinceStop > 160 : original;
    }
}

