/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.core.registries.Registries
 *  net.minecraft.resources.ResourceKey
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.world.level.biome.Biome
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.registry;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.thebrokenscript.api.TBSConstants;
import net.thebrokenscript.misc.ForceRuntimeInit;
import net.thebrokenscript.registry.TBSReg;
import org.jetbrains.annotations.NotNull;

@ForceRuntimeInit
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0015\u001a\u00020\u0016H\u0002R\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2={"Lnet/thebrokenscript/registry/TBSBiomes;", "", "<init>", "()V", "LIMBO_BIOME", "Lnet/minecraft/resources/ResourceKey;", "Lnet/minecraft/world/level/biome/Biome;", "MOON_BIOME", "NOTHING_BIOME", "NOWHERE_BIOME", "CONCRETE_BIOME", "NULL_BIOME", "PROTECTED_VOID_BIOME", "LUCID_BIOME", "CLAN_VOID_BIOME", "DAY_A_BIOME", "STEREOGENIC_GROWTH", "DYSAPHYTIC_WEN", "STAGE2_BIOME", "STAGE3_BIOME", "biome", "id", "", "thebrokenscript-common"})
public final class TBSBiomes {
    @NotNull
    public static final TBSBiomes INSTANCE = new TBSBiomes();
    @JvmField
    @NotNull
    public static final ResourceKey<Biome> LIMBO_BIOME = INSTANCE.biome("limbo");
    @JvmField
    @NotNull
    public static final ResourceKey<Biome> MOON_BIOME = INSTANCE.biome("moon");
    @JvmField
    @NotNull
    public static final ResourceKey<Biome> NOTHING_BIOME = INSTANCE.biome("nothing");
    @JvmField
    @NotNull
    public static final ResourceKey<Biome> NOWHERE_BIOME = INSTANCE.biome("nowhere");
    @JvmField
    @NotNull
    public static final ResourceKey<Biome> CONCRETE_BIOME = INSTANCE.biome("concrete");
    @JvmField
    @NotNull
    public static final ResourceKey<Biome> NULL_BIOME = INSTANCE.biome("null_biome");
    @JvmField
    @NotNull
    public static final ResourceKey<Biome> PROTECTED_VOID_BIOME = INSTANCE.biome("protected_void");
    @JvmField
    @NotNull
    public static final ResourceKey<Biome> LUCID_BIOME = INSTANCE.biome("lucid");
    @JvmField
    @NotNull
    public static final ResourceKey<Biome> CLAN_VOID_BIOME = INSTANCE.biome("void");
    @JvmField
    @NotNull
    public static final ResourceKey<Biome> DAY_A_BIOME = INSTANCE.biome("day_a");
    @JvmField
    @NotNull
    public static final ResourceKey<Biome> STEREOGENIC_GROWTH = INSTANCE.biome("stereogenic_growth");
    @JvmField
    @NotNull
    public static final ResourceKey<Biome> DYSAPHYTIC_WEN = INSTANCE.biome("dysaphytic_wen");
    @JvmField
    @NotNull
    public static final ResourceKey<Biome> STAGE2_BIOME = INSTANCE.biome("stage2");
    @JvmField
    @NotNull
    public static final ResourceKey<Biome> STAGE3_BIOME = INSTANCE.biome("stage3");

    private TBSBiomes() {
    }

    private final ResourceKey<Biome> biome(String id) {
        ResourceKey resourceKey = ResourceKey.create((ResourceKey)Registries.BIOME, (ResourceLocation)TBSConstants.id(id));
        Intrinsics.checkNotNullExpressionValue((Object)resourceKey, (String)"create(...)");
        return resourceKey;
    }

    static {
        TBSReg.INSTANCE.getData().getLang().set("biome.thebrokenscript.moon", "The Moon");
        TBSReg.INSTANCE.getData().getLang().set("biome.thebrokenscript.void", "Under Day A");
        TBSReg.INSTANCE.getData().getLang().set("biome.thebrokenscript.day_a", "Day A");
        TBSReg.INSTANCE.getData().getLang().set("biome.thebrokenscript.stereogenic_growth", "Stereogenic Growth");
        TBSReg.INSTANCE.getData().getLang().set("biome.thebrokenscript.dysaphytic_wen", "Dysaphytic Wen");
    }
}

