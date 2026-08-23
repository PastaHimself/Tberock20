/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.serialization.MapCodec
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.core.registries.Registries
 *  net.minecraft.resources.ResourceKey
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.registry;

import com.mojang.serialization.MapCodec;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.thebrokenscript.misc.ForceRuntimeInit;
import net.thebrokenscript.registry.TBSReg;
import net.thebrokenscript.world.dimension.backrooms.BackroomsGenerator;
import net.thebrokenscript.world.dimension.boss.stage2.Stage2Generator;
import net.thebrokenscript.world.dimension.boss.stage3.Stage3Generator;
import net.thebrokenscript.world.dimension.clan_void.ClanVoidGenerator;
import net.thebrokenscript.world.dimension.concrete.ConcreteGenerator;
import net.thebrokenscript.world.dimension.library.LibraryGenerator;
import net.thebrokenscript.world.dimension.limbo.LimboGenerator;
import net.thebrokenscript.world.dimension.lucid.LucidGenerator;
import net.thebrokenscript.world.dimension.nothing.NothingGenerator;
import net.thebrokenscript.world.dimension.nowhere.NowhereGenerator;
import net.thebrokenscript.world.dimension.null_torture.NullTortureGenerator;
import net.thebrokenscript.world.dimension.protected_void.ProtectedVoidGenerator;
import org.jetbrains.annotations.NotNull;

@ForceRuntimeInit
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2={"Lnet/thebrokenscript/registry/TBSDimensionGenerators;", "", "<init>", "()V", "thebrokenscript-common"})
public final class TBSDimensionGenerators {
    @NotNull
    public static final TBSDimensionGenerators INSTANCE = new TBSDimensionGenerators();

    private TBSDimensionGenerators() {
    }

    private static final MapCodec _init_$lambda$0() {
        return ClanVoidGenerator.Companion.getCODEC();
    }

    private static final MapCodec _init_$lambda$1() {
        return NullTortureGenerator.Companion.getCODEC();
    }

    private static final MapCodec _init_$lambda$2() {
        return LimboGenerator.Companion.getCODEC();
    }

    private static final MapCodec _init_$lambda$3() {
        return NothingGenerator.Companion.getCODEC();
    }

    private static final MapCodec _init_$lambda$4() {
        return NowhereGenerator.Companion.getCODEC();
    }

    private static final MapCodec _init_$lambda$5() {
        return ProtectedVoidGenerator.Companion.getCODEC();
    }

    private static final MapCodec _init_$lambda$6() {
        return LibraryGenerator.Companion.getCODEC();
    }

    private static final MapCodec _init_$lambda$7() {
        return ConcreteGenerator.Companion.getCODEC();
    }

    private static final MapCodec _init_$lambda$8() {
        return LucidGenerator.Companion.getCODEC();
    }

    private static final MapCodec _init_$lambda$9() {
        return Stage2Generator.Companion.getCODEC();
    }

    private static final MapCodec _init_$lambda$10() {
        return Stage3Generator.Companion.getCODEC();
    }

    private static final MapCodec _init_$lambda$11() {
        return BackroomsGenerator.Companion.getCODEC();
    }

    static {
        ResourceKey resourceKey = Registries.CHUNK_GENERATOR;
        Intrinsics.checkNotNullExpressionValue((Object)resourceKey, (String)"CHUNK_GENERATOR");
        TBSReg.INSTANCE.generic(resourceKey, "clan_void_generator", TBSDimensionGenerators::_init_$lambda$0);
        ResourceKey resourceKey2 = Registries.CHUNK_GENERATOR;
        Intrinsics.checkNotNullExpressionValue((Object)resourceKey2, (String)"CHUNK_GENERATOR");
        TBSReg.INSTANCE.generic(resourceKey2, "null_torture_generator", TBSDimensionGenerators::_init_$lambda$1);
        ResourceKey resourceKey3 = Registries.CHUNK_GENERATOR;
        Intrinsics.checkNotNullExpressionValue((Object)resourceKey3, (String)"CHUNK_GENERATOR");
        TBSReg.INSTANCE.generic(resourceKey3, "limbo", TBSDimensionGenerators::_init_$lambda$2);
        ResourceKey resourceKey4 = Registries.CHUNK_GENERATOR;
        Intrinsics.checkNotNullExpressionValue((Object)resourceKey4, (String)"CHUNK_GENERATOR");
        TBSReg.INSTANCE.generic(resourceKey4, "nothing", TBSDimensionGenerators::_init_$lambda$3);
        ResourceKey resourceKey5 = Registries.CHUNK_GENERATOR;
        Intrinsics.checkNotNullExpressionValue((Object)resourceKey5, (String)"CHUNK_GENERATOR");
        TBSReg.INSTANCE.generic(resourceKey5, "nowhere", TBSDimensionGenerators::_init_$lambda$4);
        ResourceKey resourceKey6 = Registries.CHUNK_GENERATOR;
        Intrinsics.checkNotNullExpressionValue((Object)resourceKey6, (String)"CHUNK_GENERATOR");
        TBSReg.INSTANCE.generic(resourceKey6, "protected_void", TBSDimensionGenerators::_init_$lambda$5);
        ResourceKey resourceKey7 = Registries.CHUNK_GENERATOR;
        Intrinsics.checkNotNullExpressionValue((Object)resourceKey7, (String)"CHUNK_GENERATOR");
        TBSReg.INSTANCE.generic(resourceKey7, "library", TBSDimensionGenerators::_init_$lambda$6);
        ResourceKey resourceKey8 = Registries.CHUNK_GENERATOR;
        Intrinsics.checkNotNullExpressionValue((Object)resourceKey8, (String)"CHUNK_GENERATOR");
        TBSReg.INSTANCE.generic(resourceKey8, "concrete", TBSDimensionGenerators::_init_$lambda$7);
        ResourceKey resourceKey9 = Registries.CHUNK_GENERATOR;
        Intrinsics.checkNotNullExpressionValue((Object)resourceKey9, (String)"CHUNK_GENERATOR");
        TBSReg.INSTANCE.generic(resourceKey9, "lucid", TBSDimensionGenerators::_init_$lambda$8);
        ResourceKey resourceKey10 = Registries.CHUNK_GENERATOR;
        Intrinsics.checkNotNullExpressionValue((Object)resourceKey10, (String)"CHUNK_GENERATOR");
        TBSReg.INSTANCE.generic(resourceKey10, "stage2", TBSDimensionGenerators::_init_$lambda$9);
        ResourceKey resourceKey11 = Registries.CHUNK_GENERATOR;
        Intrinsics.checkNotNullExpressionValue((Object)resourceKey11, (String)"CHUNK_GENERATOR");
        TBSReg.INSTANCE.generic(resourceKey11, "stage3", TBSDimensionGenerators::_init_$lambda$10);
        ResourceKey resourceKey12 = Registries.CHUNK_GENERATOR;
        Intrinsics.checkNotNullExpressionValue((Object)resourceKey12, (String)"CHUNK_GENERATOR");
        TBSReg.INSTANCE.generic(resourceKey12, "backrooms_generator", TBSDimensionGenerators::_init_$lambda$11);
    }
}

