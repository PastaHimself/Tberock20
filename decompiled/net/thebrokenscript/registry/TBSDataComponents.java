/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.serialization.Codec
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.core.component.DataComponentType
 *  net.minecraft.core.component.DataComponentType$Builder
 *  net.minecraft.network.codec.ByteBufCodecs
 *  net.thebrokenscript.brokencore.api.registry.objects.RegistryEntry
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.registry;

import com.mojang.serialization.Codec;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.network.codec.ByteBufCodecs;
import net.thebrokenscript.brokencore.api.registry.objects.RegistryEntry;
import net.thebrokenscript.misc.ForceRuntimeInit;
import net.thebrokenscript.registry.TBSReg;
import org.jetbrains.annotations.NotNull;

@ForceRuntimeInit
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R'\u0010\u0004\u001a\u0018\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR'\u0010\n\u001a\u0018\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00060\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t\u00a8\u0006\r"}, d2={"Lnet/thebrokenscript/registry/TBSDataComponents;", "", "<init>", "()V", "LIBRARY_BOOK_NUM", "Lnet/thebrokenscript/brokencore/api/registry/objects/RegistryEntry;", "Lnet/minecraft/core/component/DataComponentType;", "", "getLIBRARY_BOOK_NUM", "()Lnet/thebrokenscript/brokencore/api/registry/objects/RegistryEntry;", "ADMINISTRATIVE_OVERRIDE", "", "getADMINISTRATIVE_OVERRIDE", "thebrokenscript-common"})
public final class TBSDataComponents {
    @NotNull
    public static final TBSDataComponents INSTANCE = new TBSDataComponents();
    @NotNull
    private static final RegistryEntry<DataComponentType<?>, DataComponentType<Integer>> LIBRARY_BOOK_NUM = TBSReg.INSTANCE.dataComponent("library_book_num", TBSDataComponents::LIBRARY_BOOK_NUM$lambda$0);
    @NotNull
    private static final RegistryEntry<DataComponentType<?>, DataComponentType<Boolean>> ADMINISTRATIVE_OVERRIDE = TBSReg.INSTANCE.dataComponent("administrative_override", TBSDataComponents::ADMINISTRATIVE_OVERRIDE$lambda$0);

    private TBSDataComponents() {
    }

    @NotNull
    public final RegistryEntry<DataComponentType<?>, DataComponentType<Integer>> getLIBRARY_BOOK_NUM() {
        return LIBRARY_BOOK_NUM;
    }

    @NotNull
    public final RegistryEntry<DataComponentType<?>, DataComponentType<Boolean>> getADMINISTRATIVE_OVERRIDE() {
        return ADMINISTRATIVE_OVERRIDE;
    }

    private static final DataComponentType.Builder LIBRARY_BOOK_NUM$lambda$0(DataComponentType.Builder builder) {
        Intrinsics.checkNotNullParameter((Object)builder, (String)"builder");
        builder.persistent((Codec)Codec.INT);
        DataComponentType.Builder builder2 = builder.networkSynchronized(ByteBufCodecs.VAR_INT);
        Intrinsics.checkNotNullExpressionValue((Object)builder2, (String)"networkSynchronized(...)");
        return builder2;
    }

    private static final DataComponentType.Builder ADMINISTRATIVE_OVERRIDE$lambda$0(DataComponentType.Builder builder) {
        Intrinsics.checkNotNullParameter((Object)builder, (String)"builder");
        builder.persistent((Codec)Codec.BOOL);
        DataComponentType.Builder builder2 = builder.networkSynchronized(ByteBufCodecs.BOOL);
        Intrinsics.checkNotNullExpressionValue((Object)builder2, (String)"networkSynchronized(...)");
        return builder2;
    }
}

