/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  net.minecraft.world.effect.MobEffect
 *  net.minecraft.world.effect.MobEffectCategory
 *  net.minecraft.world.entity.ai.attributes.AttributeModifier$Operation
 *  net.minecraft.world.entity.ai.attributes.Attributes
 */
package net.thebrokenscript.effects;

import kotlin.Metadata;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.thebrokenscript.api.TBSConstants;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016\u00a8\u0006\t"}, d2={"Lnet/thebrokenscript/effects/HeartCorruptionMobEffect;", "Lnet/minecraft/world/effect/MobEffect;", "<init>", "()V", "shouldApplyEffectTickThisTick", "", "duration", "", "amplifier", "thebrokenscript-common"})
public final class HeartCorruptionMobEffect
extends MobEffect {
    public HeartCorruptionMobEffect() {
        super(MobEffectCategory.HARMFUL, 0xFF00FF);
        this.addAttributeModifier(Attributes.MAX_HEALTH, TBSConstants.id("heart_corruption"), -1.0, AttributeModifier.Operation.ADD_VALUE);
    }

    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
        return true;
    }
}

