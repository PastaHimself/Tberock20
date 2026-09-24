/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.resources.ResourceKey
 *  net.neoforged.neoforge.fluids.FluidType
 *  net.neoforged.neoforge.registries.NeoForgeRegistries$Keys
 *  net.thebrokenscript.brokencore.api.registry.objects.RegistryEntry
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.neoforge.registry;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.resources.ResourceKey;
import net.neoforged.neoforge.fluids.FluidType;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import net.thebrokenscript.brokencore.api.registry.objects.RegistryEntry;
import net.thebrokenscript.misc.ForceRuntimeInit;
import net.thebrokenscript.neoforge.fluids.VoidLiquidFluidType;
import net.thebrokenscript.neoforge.registry.TBSFluidTypes;
import net.thebrokenscript.registry.TBSReg;
import org.jetbrains.annotations.NotNull;

@ForceRuntimeInit
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R$\u0010\u0004\u001a\u0016\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u0006\u0012\u0004\u0012\u00020\b0\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2={"Lnet/thebrokenscript/neoforge/registry/TBSFluidTypes;", "", "<init>", "()V", "VOID_LIQUID", "Lnet/thebrokenscript/brokencore/api/registry/objects/RegistryEntry;", "Lnet/neoforged/neoforge/fluids/FluidType;", "kotlin.jvm.PlatformType", "Lnet/thebrokenscript/neoforge/fluids/VoidLiquidFluidType;", "thebrokenscript-neoforge"})
public final class TBSFluidTypes {
    @NotNull
    public static final TBSFluidTypes INSTANCE = new TBSFluidTypes();
    @JvmField
    @NotNull
    public static final RegistryEntry<FluidType, VoidLiquidFluidType> VOID_LIQUID;

    private TBSFluidTypes() {
    }

    static {
        ResourceKey resourceKey = NeoForgeRegistries.Keys.FLUID_TYPES;
        Intrinsics.checkNotNullExpressionValue((Object)resourceKey, (String)"FLUID_TYPES");
        VOID_LIQUID = TBSReg.INSTANCE.generic(resourceKey, "void_liquid", VOID_LIQUID.1.INSTANCE);
    }
}

