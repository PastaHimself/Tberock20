/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.core.registries.Registries
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.resources.ResourceKey
 *  net.minecraft.world.level.levelgen.structure.StructurePiece
 *  net.minecraft.world.level.levelgen.structure.pieces.StructurePieceSerializationContext
 *  net.minecraft.world.level.levelgen.structure.pieces.StructurePieceType
 *  net.thebrokenscript.brokencore.api.registry.objects.RegistryEntry
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.registry;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.structure.StructurePiece;
import net.minecraft.world.level.levelgen.structure.pieces.StructurePieceSerializationContext;
import net.minecraft.world.level.levelgen.structure.pieces.StructurePieceType;
import net.thebrokenscript.brokencore.api.registry.objects.RegistryEntry;
import net.thebrokenscript.misc.ForceRuntimeInit;
import net.thebrokenscript.registry.TBSReg;
import net.thebrokenscript.world.gen.structure.VoidGrowthPiece;
import org.jetbrains.annotations.NotNull;

@ForceRuntimeInit
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R$\u0010\u0004\u001a\u0016\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2={"Lnet/thebrokenscript/registry/TBSStructurePieceTypes;", "", "<init>", "()V", "VOID_GROWTH", "Lnet/thebrokenscript/brokencore/api/registry/objects/RegistryEntry;", "Lnet/minecraft/world/level/levelgen/structure/pieces/StructurePieceType;", "kotlin.jvm.PlatformType", "thebrokenscript-common"})
public final class TBSStructurePieceTypes {
    @NotNull
    public static final TBSStructurePieceTypes INSTANCE = new TBSStructurePieceTypes();
    @JvmField
    @NotNull
    public static final RegistryEntry<StructurePieceType, StructurePieceType> VOID_GROWTH;

    private TBSStructurePieceTypes() {
    }

    private static final StructurePieceType VOID_GROWTH$lambda$0() {
        return TBSStructurePieceTypes::VOID_GROWTH$lambda$0$0;
    }

    private static final StructurePiece VOID_GROWTH$lambda$0$0(StructurePieceSerializationContext structurePieceSerializationContext, CompoundTag tag) {
        Intrinsics.checkNotNull((Object)tag);
        return new VoidGrowthPiece(tag);
    }

    static {
        ResourceKey resourceKey = Registries.STRUCTURE_PIECE;
        Intrinsics.checkNotNullExpressionValue((Object)resourceKey, (String)"STRUCTURE_PIECE");
        VOID_GROWTH = TBSReg.INSTANCE.generic(resourceKey, "void_growth", TBSStructurePieceTypes::VOID_GROWTH$lambda$0);
    }
}

