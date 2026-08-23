/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.core.registries.Registries
 *  net.minecraft.resources.ResourceKey
 *  net.minecraft.world.effect.MobEffect
 *  net.thebrokenscript.brokencore.api.registry.objects.RegistryEntry
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.registry;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.effect.MobEffect;
import net.thebrokenscript.brokencore.api.registry.objects.RegistryEntry;
import net.thebrokenscript.effects.HeartCorruptionMobEffect;
import net.thebrokenscript.effects.WhyCantYouLeaveMobEffect;
import net.thebrokenscript.misc.ForceRuntimeInit;
import net.thebrokenscript.registry.TBSEffects;
import net.thebrokenscript.registry.TBSReg;
import org.jetbrains.annotations.NotNull;

@ForceRuntimeInit
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R$\u0010\u0004\u001a\u0016\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u0006\u0012\u0004\u0012\u00020\b0\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R$\u0010\t\u001a\u0016\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u0006\u0012\u0004\u0012\u00020\n0\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2={"Lnet/thebrokenscript/registry/TBSEffects;", "", "<init>", "()V", "WHY_CANT_YOU_LEAVE", "Lnet/thebrokenscript/brokencore/api/registry/objects/RegistryEntry;", "Lnet/minecraft/world/effect/MobEffect;", "kotlin.jvm.PlatformType", "Lnet/thebrokenscript/effects/WhyCantYouLeaveMobEffect;", "HEART_CORRUPTION", "Lnet/thebrokenscript/effects/HeartCorruptionMobEffect;", "thebrokenscript-common"})
public final class TBSEffects {
    @NotNull
    public static final TBSEffects INSTANCE = new TBSEffects();
    @JvmField
    @NotNull
    public static final RegistryEntry<MobEffect, WhyCantYouLeaveMobEffect> WHY_CANT_YOU_LEAVE;
    @JvmField
    @NotNull
    public static final RegistryEntry<MobEffect, HeartCorruptionMobEffect> HEART_CORRUPTION;

    private TBSEffects() {
    }

    static {
        ResourceKey resourceKey = Registries.MOB_EFFECT;
        Intrinsics.checkNotNullExpressionValue((Object)resourceKey, (String)"MOB_EFFECT");
        WHY_CANT_YOU_LEAVE = TBSReg.INSTANCE.generic(resourceKey, "why_cant_you_leave", WHY_CANT_YOU_LEAVE.1.INSTANCE);
        ResourceKey resourceKey2 = Registries.MOB_EFFECT;
        Intrinsics.checkNotNullExpressionValue((Object)resourceKey2, (String)"MOB_EFFECT");
        HEART_CORRUPTION = TBSReg.INSTANCE.generic(resourceKey2, "heart_corruption", HEART_CORRUPTION.1.INSTANCE);
        TBSReg.INSTANCE.getData().getLang().set("effect.thebrokenscript.why_cant_you_leave", "Why can't you just leave?");
        TBSReg.INSTANCE.getData().getLang().set("effect.thebrokenscript.heart_corruption", "ERR.HEALTH");
    }
}

