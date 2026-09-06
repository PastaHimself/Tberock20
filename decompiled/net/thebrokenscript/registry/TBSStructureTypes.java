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
 *  net.minecraft.world.level.levelgen.structure.StructureType
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
import net.minecraft.world.level.levelgen.structure.StructureType;
import net.thebrokenscript.brokencore.api.registry.objects.RegistryEntry;
import net.thebrokenscript.misc.ForceRuntimeInit;
import net.thebrokenscript.registry.TBSReg;
import net.thebrokenscript.world.gen.structure.VoidGrowthStructure;
import org.jetbrains.annotations.NotNull;

@ForceRuntimeInit
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R:\u0010\u0004\u001a,\u0012\u0014\u0012\u0012\u0012\u0002\b\u0003 \u0007*\b\u0012\u0002\b\u0003\u0018\u00010\u00060\u0006\u0012\u0012\u0012\u0010\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\b0\b0\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2={"Lnet/thebrokenscript/registry/TBSStructureTypes;", "", "<init>", "()V", "VOID_GROWTH", "Lnet/thebrokenscript/brokencore/api/registry/objects/RegistryEntry;", "Lnet/minecraft/world/level/levelgen/structure/StructureType;", "kotlin.jvm.PlatformType", "Lnet/thebrokenscript/world/gen/structure/VoidGrowthStructure;", "thebrokenscript-common"})
public final class TBSStructureTypes {
    @NotNull
    public static final TBSStructureTypes INSTANCE = new TBSStructureTypes();
    @JvmField
    @NotNull
    public static final RegistryEntry<StructureType<?>, StructureType<VoidGrowthStructure>> VOID_GROWTH;

    private TBSStructureTypes() {
    }

    private static final StructureType VOID_GROWTH$lambda$0() {
        return TBSStructureTypes::VOID_GROWTH$lambda$0$0;
    }

    private static final MapCodec VOID_GROWTH$lambda$0$0() {
        return VoidGrowthStructure.Companion.getCODEC();
    }

    static {
        ResourceKey resourceKey = Registries.STRUCTURE_TYPE;
        Intrinsics.checkNotNullExpressionValue((Object)resourceKey, (String)"STRUCTURE_TYPE");
        VOID_GROWTH = TBSReg.INSTANCE.generic(resourceKey, "void_growth", TBSStructureTypes::VOID_GROWTH$lambda$0);
    }
}

