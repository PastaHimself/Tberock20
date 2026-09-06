/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.audio.Channel
 *  net.minecraft.resources.ResourceLocation
 *  org.jetbrains.annotations.NotNull
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.At$Shift
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package net.thebrokenscript.brokencore.impl.mixin.client.features.sounds;

import com.mojang.blaze3d.audio.Channel;
import java.util.HashMap;
import java.util.List;
import net.minecraft.resources.ResourceLocation;
import net.thebrokenscript.brokencore.api.mixinterfaces.AudioChannelExt;
import net.thebrokenscript.brokencore.api.sound.fx.AudioEffect;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={Channel.class})
public class ChannelExtMixin
implements AudioChannelExt {
    @Unique
    private final HashMap<ResourceLocation, AudioEffect<?>> bc$effects = new HashMap();

    @Inject(method={"destroy"}, at={@At(value="INVOKE", target="Lcom/mojang/blaze3d/audio/OpenAlUtil;checkALError(Ljava/lang/String;)Z", ordinal=1, shift=At.Shift.AFTER)})
    private void bc$destroyEffects(CallbackInfo ci) {
        for (AudioEffect<?> effect : this.bc$effects.values()) {
            effect.destroy();
        }
    }

    @Inject(method={"updateStream"}, at={@At(value="TAIL")})
    private void bc$updateEffects(CallbackInfo ci) {
        for (AudioEffect<?> effect : this.bc$effects.values()) {
            effect.tick();
        }
    }

    @Override
    public void bc$addEffect(@NotNull AudioEffect<?> effect) {
        this.bc$effects.put(effect.getId(), effect);
        effect.create((Channel)this);
        effect.connect((Channel)this);
    }

    @Override
    public void bc$removeEffect(@NotNull ResourceLocation effect) {
        AudioEffect<?> inst = this.bc$effects.remove(effect);
        if (inst != null) {
            inst.destroy();
        }
    }

    @Override
    public boolean bc$hasEffect(@NotNull ResourceLocation effect) {
        return this.bc$effects.containsKey(effect);
    }

    @Override
    @NotNull
    public @NotNull List<@NotNull AudioEffect<?>> bc$getEffects() {
        return this.bc$effects.values().stream().toList();
    }
}

