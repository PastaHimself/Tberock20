/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.data.models.blockstates.Condition
 *  net.minecraft.data.models.blockstates.Condition$TerminalCondition
 *  net.minecraft.data.models.blockstates.Variant
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.util;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.data.models.blockstates.Condition;
import net.minecraft.data.models.blockstates.Variant;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\u0004\u001a\u00020\u00052\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007\u00a2\u0006\u0002\b\tJ\u001f\u0010\n\u001a\u00020\u000b2\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\b0\u0007\u00a2\u0006\u0002\b\t\u00a8\u0006\f"}, d2={"Lnet/thebrokenscript/brokencore/api/util/Models;", "", "<init>", "()V", "variant", "Lnet/minecraft/data/models/blockstates/Variant;", "block", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "cond", "Lnet/minecraft/data/models/blockstates/Condition$TerminalCondition;", "brokencore-common"})
public final class Models {
    @NotNull
    public static final Models INSTANCE = new Models();

    private Models() {
    }

    @NotNull
    public final Variant variant(@NotNull Function1<? super Variant, Unit> block2) {
        Intrinsics.checkNotNullParameter(block2, (String)"block");
        Variant variant = new Variant();
        block2.invoke((Object)variant);
        return variant;
    }

    @NotNull
    public final Condition.TerminalCondition cond(@NotNull Function1<? super Condition.TerminalCondition, Unit> block2) {
        Intrinsics.checkNotNullParameter(block2, (String)"block");
        Condition.TerminalCondition terminalCondition = Condition.condition();
        block2.invoke((Object)terminalCondition);
        Condition.TerminalCondition terminalCondition2 = terminalCondition;
        Intrinsics.checkNotNullExpressionValue((Object)terminalCondition2, (String)"apply(...)");
        return terminalCondition2;
    }
}

