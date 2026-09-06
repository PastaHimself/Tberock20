/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.audio.Channel
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.client.resources.sounds.SoundInstance
 *  net.minecraft.client.sounds.ChannelAccess$ChannelHandle
 *  net.minecraft.client.sounds.SoundEngine
 *  net.minecraft.client.sounds.SoundManager
 *  net.minecraft.resources.ResourceLocation
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.sound;

import com.mojang.blaze3d.audio.Channel;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.resources.sounds.SoundInstance;
import net.minecraft.client.sounds.ChannelAccess;
import net.minecraft.client.sounds.SoundEngine;
import net.minecraft.client.sounds.SoundManager;
import net.minecraft.resources.ResourceLocation;
import net.thebrokenscript.brokencore.api.mixinterfaces.AudioChannelExt;
import net.thebrokenscript.brokencore.api.sound.fx.AudioEffect;
import net.thebrokenscript.brokencore.impl.mixin.client.features.sounds.ChannelAccessor;
import net.thebrokenscript.brokencore.impl.mixin.client.features.sounds.SoundEngineAccessor;
import net.thebrokenscript.brokencore.impl.mixin.client.features.sounds.SoundManagerAccessor;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=2, xi=48, d1={"\u0000H\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0016\u0010\u0016\u001a\u00020\u0017*\u00020\u000e2\n\u0010\u0018\u001a\u0006\u0012\u0002\b\u00030\u0013\u001a\u0012\u0010\u0019\u001a\u00020\u0017*\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u001a\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"%\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\b\u0012\u00060\bR\u00020\t0\u0006*\u00020\u00018F\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000b\"\u0015\u0010\f\u001a\u00020\r*\u00020\u000e8F\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010\"\u001f\u0010\u0011\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00130\u0012*\u00020\u000e8F\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015\u00a8\u0006\u001b"}, d2={"engine", "Lnet/minecraft/client/sounds/SoundEngine;", "Lnet/minecraft/client/sounds/SoundManager;", "getEngine", "(Lnet/minecraft/client/sounds/SoundManager;)Lnet/minecraft/client/sounds/SoundEngine;", "instanceToChannel", "", "Lnet/minecraft/client/resources/sounds/SoundInstance;", "Lnet/minecraft/client/sounds/ChannelAccess$ChannelHandle;", "Lnet/minecraft/client/sounds/ChannelAccess;", "getInstanceToChannel", "(Lnet/minecraft/client/sounds/SoundEngine;)Ljava/util/Map;", "source", "", "Lcom/mojang/blaze3d/audio/Channel;", "getSource", "(Lcom/mojang/blaze3d/audio/Channel;)I", "effects", "", "Lnet/thebrokenscript/brokencore/api/sound/fx/AudioEffect;", "getEffects", "(Lcom/mojang/blaze3d/audio/Channel;)Ljava/util/List;", "addEffect", "", "effect", "removeEffect", "Lnet/minecraft/resources/ResourceLocation;", "brokencore-common"})
public final class SoundAccessorsKt {
    @NotNull
    public static final SoundEngine getEngine(@NotNull SoundManager $this$engine) {
        Intrinsics.checkNotNullParameter((Object)$this$engine, (String)"<this>");
        SoundEngine soundEngine = ((SoundManagerAccessor)$this$engine).bc$getSoundEngine();
        Intrinsics.checkNotNullExpressionValue((Object)soundEngine, (String)"bc$getSoundEngine(...)");
        return soundEngine;
    }

    @NotNull
    public static final Map<SoundInstance, ChannelAccess.ChannelHandle> getInstanceToChannel(@NotNull SoundEngine $this$instanceToChannel) {
        Intrinsics.checkNotNullParameter((Object)$this$instanceToChannel, (String)"<this>");
        Map<SoundInstance, ChannelAccess.ChannelHandle> map = ((SoundEngineAccessor)$this$instanceToChannel).bc$getInstanceToChannel();
        Intrinsics.checkNotNullExpressionValue(map, (String)"bc$getInstanceToChannel(...)");
        return map;
    }

    public static final int getSource(@NotNull Channel $this$source) {
        Intrinsics.checkNotNullParameter((Object)$this$source, (String)"<this>");
        return ((ChannelAccessor)$this$source).bc$getSource();
    }

    @NotNull
    public static final List<AudioEffect<?>> getEffects(@NotNull Channel $this$effects) {
        Intrinsics.checkNotNullParameter((Object)$this$effects, (String)"<this>");
        return ((AudioChannelExt)$this$effects).bc$getEffects();
    }

    public static final void addEffect(@NotNull Channel $this$addEffect, @NotNull AudioEffect<?> effect) {
        Intrinsics.checkNotNullParameter((Object)$this$addEffect, (String)"<this>");
        Intrinsics.checkNotNullParameter(effect, (String)"effect");
        ((AudioChannelExt)$this$addEffect).bc$addEffect(effect);
    }

    public static final void removeEffect(@NotNull Channel $this$removeEffect, @NotNull ResourceLocation effect) {
        Intrinsics.checkNotNullParameter((Object)$this$removeEffect, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)effect, (String)"effect");
        ((AudioChannelExt)$this$removeEffect).bc$removeEffect(effect);
    }
}

