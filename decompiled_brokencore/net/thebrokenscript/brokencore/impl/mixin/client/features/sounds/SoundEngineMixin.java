/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.llamalad7.mixinextras.injector.wrapoperation.Operation
 *  com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation
 *  com.llamalad7.mixinextras.sugar.Local
 *  com.mojang.blaze3d.audio.Channel
 *  com.mojang.blaze3d.audio.SoundBuffer
 *  net.minecraft.client.Options
 *  net.minecraft.client.resources.sounds.SoundInstance
 *  net.minecraft.client.resources.sounds.TickableSoundInstance
 *  net.minecraft.client.sounds.AudioStream
 *  net.minecraft.client.sounds.ChannelAccess$ChannelHandle
 *  net.minecraft.client.sounds.SoundEngine
 *  net.minecraft.sounds.SoundSource
 *  org.spongepowered.asm.mixin.Final
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.Redirect
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package net.thebrokenscript.brokencore.impl.mixin.client.features.sounds;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.llamalad7.mixinextras.sugar.Local;
import com.mojang.blaze3d.audio.Channel;
import com.mojang.blaze3d.audio.SoundBuffer;
import java.util.Map;
import java.util.function.Consumer;
import net.minecraft.client.Options;
import net.minecraft.client.resources.sounds.SoundInstance;
import net.minecraft.client.resources.sounds.TickableSoundInstance;
import net.minecraft.client.sounds.AudioStream;
import net.minecraft.client.sounds.ChannelAccess;
import net.minecraft.client.sounds.SoundEngine;
import net.minecraft.sounds.SoundSource;
import net.thebrokenscript.brokencore.api.sound.FancyAudioMarker;
import net.thebrokenscript.brokencore.api.sound.FancyEntitySoundInstance;
import net.thebrokenscript.brokencore.api.sound.FancyPositionedSoundInstance;
import net.thebrokenscript.brokencore.api.sound.FancySoundInstance;
import net.thebrokenscript.brokencore.impl.mixinterfaces.ShittyStopExt;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={SoundEngine.class})
public class SoundEngineMixin {
    @Shadow
    @Final
    private Map<SoundInstance, ChannelAccess.ChannelHandle> instanceToChannel;

    @WrapOperation(method={"lambda$updateCategoryVolume$1"}, at={@At(value="INVOKE", target="Lnet/minecraft/client/sounds/SoundEngine;calculateVolume(Lnet/minecraft/client/resources/sounds/SoundInstance;)F")})
    private static float bc$fixVolumeStop(SoundEngine instance, SoundInstance sound, Operation<Float> original) {
        float orig = ((Float)original.call(new Object[]{instance, sound})).floatValue();
        if ((sound instanceof FancySoundInstance || sound instanceof FancyEntitySoundInstance) && orig == 0.0f) {
            return -1.0f;
        }
        return orig;
    }

    @Redirect(method={"lambda$updateCategoryVolume$0"}, at=@At(value="INVOKE", target="Lcom/mojang/blaze3d/audio/Channel;stop()V"))
    private static void bc$fixVolumeNegativeStop(Channel instance, @Local(argsOnly=true) float value) {
        if (value == -1.0f) {
            instance.setVolume(0.0f);
        } else {
            instance.stop();
        }
    }

    @Redirect(method={"tickNonPaused"}, at=@At(value="INVOKE", target="Lnet/minecraft/client/Options;getSoundSourceVolume(Lnet/minecraft/sounds/SoundSource;)F"))
    private static float bc$fixNonPaused(Options instance, SoundSource category, @Local SoundInstance snd) {
        if (snd instanceof FancySoundInstance || snd instanceof FancyEntitySoundInstance) {
            return 1.0f;
        }
        return instance.getSoundSourceVolume(category);
    }

    @Inject(method={"lambda$play$8"}, at={@At(value="INVOKE", target="Lcom/mojang/blaze3d/audio/Channel;attachBufferStream(Lnet/minecraft/client/sounds/AudioStream;)V")})
    private static void bc$fireChannelReadyStreamed(AudioStream p_194504_, SoundInstance p_sound, Channel p_194498_, CallbackInfo ci) {
        if (p_sound instanceof FancySoundInstance) {
            FancySoundInstance fsi = (FancySoundInstance)p_sound;
            fsi.channelReady$brokencore_common();
        }
        if (p_sound instanceof FancyEntitySoundInstance) {
            FancyEntitySoundInstance fesi = (FancyEntitySoundInstance)p_sound;
            fesi.channelReady$brokencore_common();
        }
        if (p_sound instanceof FancyPositionedSoundInstance) {
            FancyPositionedSoundInstance fpsi = (FancyPositionedSoundInstance)p_sound;
            fpsi.channelReady$brokencore_common();
        }
    }

    @Inject(method={"lambda$play$6"}, at={@At(value="INVOKE", target="Lcom/mojang/blaze3d/audio/Channel;attachStaticBuffer(Lcom/mojang/blaze3d/audio/SoundBuffer;)V")})
    private static void bc$fireChannelReadyStatic(SoundBuffer p_194501_, SoundInstance p_sound, Channel p_194495_, CallbackInfo ci) {
        if (p_sound instanceof FancySoundInstance) {
            FancySoundInstance fsi = (FancySoundInstance)p_sound;
            fsi.channelReady$brokencore_common();
        }
        if (p_sound instanceof FancyEntitySoundInstance) {
            FancyEntitySoundInstance fesi = (FancyEntitySoundInstance)p_sound;
            fesi.channelReady$brokencore_common();
        }
        if (p_sound instanceof FancyPositionedSoundInstance) {
            FancyPositionedSoundInstance fpsi = (FancyPositionedSoundInstance)p_sound;
            fpsi.channelReady$brokencore_common();
        }
    }

    @Redirect(method={"tickNonPaused"}, at=@At(value="INVOKE", target="Lnet/minecraft/client/sounds/ChannelAccess$ChannelHandle;execute(Ljava/util/function/Consumer;)V", ordinal=0))
    public void bc$redirectTickChannel(ChannelAccess.ChannelHandle instance, Consumer<Channel> soundConsumer, @Local TickableSoundInstance tickableSoundInstance) {
        if (!(tickableSoundInstance instanceof FancySoundInstance || tickableSoundInstance instanceof FancyEntitySoundInstance || tickableSoundInstance instanceof FancyPositionedSoundInstance)) {
            instance.execute(soundConsumer);
        }
    }

    @Inject(method={"stop(Lnet/minecraft/client/resources/sounds/SoundInstance;)V"}, at={@At(value="TAIL")})
    public void bc$applyStopCallback(SoundInstance sound, CallbackInfo ci) {
        FancyAudioMarker inst;
        if (sound instanceof FancySoundInstance) {
            inst = (FancySoundInstance)sound;
            ((FancySoundInstance)inst).stopHandler$brokencore_common();
        }
        if (sound instanceof FancyEntitySoundInstance) {
            inst = (FancyEntitySoundInstance)sound;
            ((FancyEntitySoundInstance)inst).stopHandler$brokencore_common();
        }
        if (sound instanceof FancyPositionedSoundInstance) {
            inst = (FancyPositionedSoundInstance)sound;
            ((FancyPositionedSoundInstance)inst).stopHandler$brokencore_common();
        }
    }

    @Inject(method={"stopAll"}, at={@At(value="HEAD")})
    public void bc$applyStopAllCallback(CallbackInfo ci) {
        if (!((ShittyStopExt)((Object)this)).bc$stopFancyAudio()) {
            return;
        }
        for (SoundInstance sound : Map.copyOf(this.instanceToChannel).keySet()) {
            FancyAudioMarker inst;
            if (sound instanceof FancySoundInstance) {
                inst = (FancySoundInstance)sound;
                ((FancySoundInstance)inst).stopHandler$brokencore_common();
            }
            if (sound instanceof FancyEntitySoundInstance) {
                inst = (FancyEntitySoundInstance)sound;
                ((FancyEntitySoundInstance)inst).stopHandler$brokencore_common();
            }
            if (!(sound instanceof FancyPositionedSoundInstance)) continue;
            inst = (FancyPositionedSoundInstance)sound;
            ((FancyPositionedSoundInstance)inst).stopHandler$brokencore_common();
        }
    }
}

