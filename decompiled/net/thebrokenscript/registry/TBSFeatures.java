/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.core.registries.Registries
 *  net.minecraft.resources.ResourceKey
 *  net.minecraft.world.level.levelgen.feature.Feature
 *  net.thebrokenscript.brokencore.api.registry.objects.RegistryEntry
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.registry;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.thebrokenscript.brokencore.api.registry.objects.RegistryEntry;
import net.thebrokenscript.misc.ForceRuntimeInit;
import net.thebrokenscript.registry.TBSFeatures;
import net.thebrokenscript.registry.TBSReg;
import net.thebrokenscript.world.gen.features.DayAFeature;
import net.thebrokenscript.world.gen.features.MoonChunkFeature;
import net.thebrokenscript.world.gen.features.VoidCystFeature;
import org.jetbrains.annotations.NotNull;

@ForceRuntimeInit
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R,\u0010\u0004\u001a\u001e\u0012\u0014\u0012\u0012\u0012\u0002\b\u0003 \u0007*\b\u0012\u0002\b\u0003\u0018\u00010\u00060\u0006\u0012\u0004\u0012\u00020\b0\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R,\u0010\t\u001a\u001e\u0012\u0014\u0012\u0012\u0012\u0002\b\u0003 \u0007*\b\u0012\u0002\b\u0003\u0018\u00010\u00060\u0006\u0012\u0004\u0012\u00020\n0\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R,\u0010\u000b\u001a\u001e\u0012\u0014\u0012\u0012\u0012\u0002\b\u0003 \u0007*\b\u0012\u0002\b\u0003\u0018\u00010\u00060\u0006\u0012\u0004\u0012\u00020\f0\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2={"Lnet/thebrokenscript/registry/TBSFeatures;", "", "<init>", "()V", "MOON_CHUNK", "Lnet/thebrokenscript/brokencore/api/registry/objects/RegistryEntry;", "Lnet/minecraft/world/level/levelgen/feature/Feature;", "kotlin.jvm.PlatformType", "Lnet/thebrokenscript/world/gen/features/MoonChunkFeature;", "DAY_A", "Lnet/thebrokenscript/world/gen/features/DayAFeature;", "VOID_CYST", "Lnet/thebrokenscript/world/gen/features/VoidCystFeature;", "thebrokenscript-common"})
public final class TBSFeatures {
    @NotNull
    public static final TBSFeatures INSTANCE = new TBSFeatures();
    @JvmField
    @NotNull
    public static final RegistryEntry<Feature<?>, MoonChunkFeature> MOON_CHUNK;
    @JvmField
    @NotNull
    public static final RegistryEntry<Feature<?>, DayAFeature> DAY_A;
    @JvmField
    @NotNull
    public static final RegistryEntry<Feature<?>, VoidCystFeature> VOID_CYST;

    private TBSFeatures() {
    }

    static {
        ResourceKey resourceKey = Registries.FEATURE;
        Intrinsics.checkNotNullExpressionValue((Object)resourceKey, (String)"FEATURE");
        MOON_CHUNK = TBSReg.INSTANCE.generic(resourceKey, "moon_chunk", MOON_CHUNK.1.INSTANCE);
        ResourceKey resourceKey2 = Registries.FEATURE;
        Intrinsics.checkNotNullExpressionValue((Object)resourceKey2, (String)"FEATURE");
        DAY_A = TBSReg.INSTANCE.generic(resourceKey2, "day_a", DAY_A.1.INSTANCE);
        ResourceKey resourceKey3 = Registries.FEATURE;
        Intrinsics.checkNotNullExpressionValue((Object)resourceKey3, (String)"FEATURE");
        VOID_CYST = TBSReg.INSTANCE.generic(resourceKey3, "void_cyst", VOID_CYST.1.INSTANCE);
    }
}

