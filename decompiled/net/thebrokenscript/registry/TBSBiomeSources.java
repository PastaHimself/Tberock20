/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.serialization.MapCodec
 *  kotlin.Metadata
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.core.registries.Registries
 *  net.minecraft.resources.ResourceKey
 *  net.minecraft.world.level.biome.BiomeSource
 *  net.thebrokenscript.brokencore.api.registry.objects.RegistryEntry
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.registry;

import com.mojang.serialization.MapCodec;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.BiomeSource;
import net.thebrokenscript.brokencore.api.registry.objects.RegistryEntry;
import net.thebrokenscript.misc.ForceRuntimeInit;
import net.thebrokenscript.registry.TBSReg;
import net.thebrokenscript.world.dimension.clan_void.ClanVoidBiomeSource;
import net.thebrokenscript.world.dimension.moon.MoonBiomeSource;
import org.jetbrains.annotations.NotNull;

@ForceRuntimeInit
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003RJ\u0010\u0004\u001a<\u0012,\u0012*\u0012\u000e\b\u0001\u0012\n \b*\u0004\u0018\u00010\u00070\u0007 \b*\u0014\u0012\u000e\b\u0001\u0012\n \b*\u0004\u0018\u00010\u00070\u0007\u0018\u00010\u00060\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000RJ\u0010\n\u001a<\u0012,\u0012*\u0012\u000e\b\u0001\u0012\n \b*\u0004\u0018\u00010\u00070\u0007 \b*\u0014\u0012\u000e\b\u0001\u0012\n \b*\u0004\u0018\u00010\u00070\u0007\u0018\u00010\u00060\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2={"Lnet/thebrokenscript/registry/TBSBiomeSources;", "", "<init>", "()V", "CLAN_VOID_BIOME_SOURCE", "Lnet/thebrokenscript/brokencore/api/registry/objects/RegistryEntry;", "Lcom/mojang/serialization/MapCodec;", "Lnet/minecraft/world/level/biome/BiomeSource;", "kotlin.jvm.PlatformType", "Lnet/thebrokenscript/world/dimension/clan_void/ClanVoidBiomeSource;", "MOON_BIOME_SOURCE", "Lnet/thebrokenscript/world/dimension/moon/MoonBiomeSource;", "thebrokenscript-common"})
public final class TBSBiomeSources {
    @NotNull
    public static final TBSBiomeSources INSTANCE = new TBSBiomeSources();
    @JvmField
    @NotNull
    public static final RegistryEntry<MapCodec<? extends BiomeSource>, MapCodec<ClanVoidBiomeSource>> CLAN_VOID_BIOME_SOURCE;
    @JvmField
    @NotNull
    public static final RegistryEntry<MapCodec<? extends BiomeSource>, MapCodec<MoonBiomeSource>> MOON_BIOME_SOURCE;

    private TBSBiomeSources() {
    }

    private static final MapCodec CLAN_VOID_BIOME_SOURCE$lambda$0() {
        return ClanVoidBiomeSource.Companion.getCODEC();
    }

    private static final MapCodec MOON_BIOME_SOURCE$lambda$0() {
        return MoonBiomeSource.Companion.getCODEC();
    }

    static {
        ResourceKey resourceKey = Registries.BIOME_SOURCE;
        Intrinsics.checkNotNullExpressionValue((Object)resourceKey, (String)"BIOME_SOURCE");
        CLAN_VOID_BIOME_SOURCE = TBSReg.INSTANCE.generic(resourceKey, "clan_void_biomes", TBSBiomeSources::CLAN_VOID_BIOME_SOURCE$lambda$0);
        ResourceKey resourceKey2 = Registries.BIOME_SOURCE;
        Intrinsics.checkNotNullExpressionValue((Object)resourceKey2, (String)"BIOME_SOURCE");
        MOON_BIOME_SOURCE = TBSReg.INSTANCE.generic(resourceKey2, "moon_biomes", TBSBiomeSources::MOON_BIOME_SOURCE$lambda$0);
    }
}

