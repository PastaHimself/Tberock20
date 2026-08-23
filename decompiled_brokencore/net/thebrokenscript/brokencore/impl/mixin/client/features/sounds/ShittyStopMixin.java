/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.Multimap
 *  net.minecraft.client.resources.sounds.SoundInstance
 *  net.minecraft.client.resources.sounds.TickableSoundInstance
 *  net.minecraft.client.sounds.ChannelAccess
 *  net.minecraft.client.sounds.ChannelAccess$ChannelHandle
 *  net.minecraft.client.sounds.SoundEngine
 *  net.minecraft.sounds.SoundSource
 *  org.spongepowered.asm.mixin.Final
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Redirect
 */
package net.thebrokenscript.brokencore.impl.mixin.client.features.sounds;

import com.google.common.collect.Multimap;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import net.minecraft.client.resources.sounds.SoundInstance;
import net.minecraft.client.resources.sounds.TickableSoundInstance;
import net.minecraft.client.sounds.ChannelAccess;
import net.minecraft.client.sounds.SoundEngine;
import net.minecraft.sounds.SoundSource;
import net.thebrokenscript.brokencore.api.sound.FancyAudioMarker;
import net.thebrokenscript.brokencore.impl.mixinterfaces.ShittyStopChannelsExt;
import net.thebrokenscript.brokencore.impl.mixinterfaces.ShittyStopExt;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value={SoundEngine.class})
public class ShittyStopMixin
implements ShittyStopExt {
    @Shadow
    @Final
    private Map<SoundInstance, ChannelAccess.ChannelHandle> instanceToChannel;
    @Unique
    private boolean bc$stopFancyAudio = true;

    @Redirect(method={"stopAll"}, at=@At(value="INVOKE", target="Ljava/util/Map;clear()V"))
    public void bc$redirectMapClear(Map<SoundInstance, ?> instance) {
        if (this.bc$stopFancyAudio) {
            instance.clear();
        } else {
            for (SoundInstance key : Set.copyOf(instance.keySet())) {
                if (key instanceof FancyAudioMarker) continue;
                instance.remove(key);
            }
        }
    }

    @Redirect(method={"stopAll"}, at=@At(value="INVOKE", target="Lnet/minecraft/client/sounds/ChannelAccess;clear()V"))
    public void bc$redirectChannelAccessClear(ChannelAccess instance) {
        ShittyStopChannelsExt extra = (ShittyStopChannelsExt)instance;
        extra.bc$setStopFancyAudio(this.bc$stopFancyAudio);
        if (!this.bc$stopFancyAudio) {
            extra.bc$setBlacklist(this.instanceToChannel.entrySet().stream().filter(it -> it.getKey() instanceof FancyAudioMarker).map(Map.Entry::getValue).toList());
        }
        instance.clear();
    }

    @Redirect(method={"stopAll"}, at=@At(value="INVOKE", target="Ljava/util/List;clear()V"))
    public void bc$redirectListClear(List<TickableSoundInstance> instance) {
        if (this.bc$stopFancyAudio) {
            instance.clear();
        } else {
            instance.removeIf(it -> !(it instanceof FancyAudioMarker));
        }
    }

    @Redirect(method={"stopAll"}, at=@At(value="INVOKE", target="Lcom/google/common/collect/Multimap;clear()V"))
    public void bc$redirectMultimapClear(Multimap<SoundSource, SoundInstance> instance) {
        if (this.bc$stopFancyAudio) {
            instance.clear();
        } else {
            for (SoundSource key : Set.copyOf(instance.keySet())) {
                if (!instance.get((Object)key).removeIf(it -> !(it instanceof FancyAudioMarker))) continue;
                instance.removeAll((Object)key);
            }
        }
    }

    @Redirect(method={"stopAll"}, at=@At(value="INVOKE", target="Ljava/util/Map;values()Ljava/util/Collection;"))
    public Collection<ChannelAccess.ChannelHandle> bc$redirectValuesNoFancyAudio(Map<SoundInstance, ChannelAccess.ChannelHandle> instance) {
        if (this.bc$stopFancyAudio) {
            return instance.values();
        }
        return instance.entrySet().stream().filter(it -> !(it.getKey() instanceof FancyAudioMarker)).map(Map.Entry::getValue).toList();
    }

    @Override
    public boolean bc$stopFancyAudio() {
        return this.bc$stopFancyAudio;
    }

    @Override
    public void bc$setStopFancyAudio(boolean value) {
        this.bc$stopFancyAudio = value;
    }
}

