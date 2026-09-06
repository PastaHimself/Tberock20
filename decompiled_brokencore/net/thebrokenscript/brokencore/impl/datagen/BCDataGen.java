/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.data.DataProvider
 *  net.minecraft.data.PackOutput
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.impl.datagen;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.thebrokenscript.brokencore.impl.datagen.BCLangGen;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00050\t\u00a8\u0006\u000b"}, d2={"Lnet/thebrokenscript/brokencore/impl/datagen/BCDataGen;", "", "<init>", "()V", "register", "", "output", "Lnet/minecraft/data/PackOutput;", "consumer", "Lkotlin/Function1;", "Lnet/minecraft/data/DataProvider;", "brokencore-common"})
public final class BCDataGen {
    @NotNull
    public static final BCDataGen INSTANCE = new BCDataGen();

    private BCDataGen() {
    }

    public final void register(@NotNull PackOutput output, @NotNull Function1<? super DataProvider, Unit> consumer) {
        Intrinsics.checkNotNullParameter((Object)output, (String)"output");
        Intrinsics.checkNotNullParameter(consumer, (String)"consumer");
        consumer.invoke((Object)new BCLangGen(output));
    }
}

