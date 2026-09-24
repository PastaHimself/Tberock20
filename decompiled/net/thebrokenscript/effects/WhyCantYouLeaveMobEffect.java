/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.core.particles.ParticleOptions
 *  net.minecraft.world.effect.MobEffect
 *  net.minecraft.world.effect.MobEffectCategory
 *  net.minecraft.world.effect.MobEffectInstance
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.effects;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.thebrokenscript.registry.TBSParticleTypes;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016\u00a8\u0006\b"}, d2={"Lnet/thebrokenscript/effects/WhyCantYouLeaveMobEffect;", "Lnet/minecraft/world/effect/MobEffect;", "<init>", "()V", "createParticleOptions", "Lnet/minecraft/core/particles/ParticleOptions;", "effect", "Lnet/minecraft/world/effect/MobEffectInstance;", "thebrokenscript-common"})
public final class WhyCantYouLeaveMobEffect
extends MobEffect {
    public WhyCantYouLeaveMobEffect() {
        super(MobEffectCategory.NEUTRAL, -16777216);
    }

    @NotNull
    public ParticleOptions createParticleOptions(@NotNull MobEffectInstance effect) {
        Intrinsics.checkNotNullParameter((Object)effect, (String)"effect");
        return (ParticleOptions)TBSParticleTypes.EYES.get();
    }
}

