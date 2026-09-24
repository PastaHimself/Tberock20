/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.wispforest.owo.ui.core.Sizing
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.reflect.KMutableProperty0
 *  kotlin.text.StringsKt
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.brokencore.api.client.cutscene.editor.components;

import io.wispforest.owo.ui.core.Sizing;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KMutableProperty0;
import kotlin.text.StringsKt;
import net.thebrokenscript.brokencore.api.client.cutscene.editor.components.NumberBox;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B1\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000f\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0010\u001a\u00020\u0011H\u0014\u00a2\u0006\u0002\u0010\u0012R\u0014\u0010\f\u001a\u00020\u0002X\u0094D\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0013"}, d2={"Lnet/thebrokenscript/brokencore/api/client/cutscene/editor/components/IntBox;", "Lnet/thebrokenscript/brokencore/api/client/cutscene/editor/components/NumberBox;", "", "horizontalSizing", "Lio/wispforest/owo/ui/core/Sizing;", "field", "Lkotlin/reflect/KMutableProperty0;", "update", "Lkotlin/Function0;", "", "<init>", "(Lio/wispforest/owo/ui/core/Sizing;Lkotlin/reflect/KMutableProperty0;Lkotlin/jvm/functions/Function0;)V", "zero", "getZero", "()Ljava/lang/Integer;", "parse", "value", "", "(Ljava/lang/String;)Ljava/lang/Integer;", "brokencore-common"})
public class IntBox
extends NumberBox<Integer> {
    private final int zero;

    public IntBox(@NotNull Sizing horizontalSizing, @Nullable KMutableProperty0<Integer> field, @NotNull Function0<Unit> update) {
        Intrinsics.checkNotNullParameter((Object)horizontalSizing, (String)"horizontalSizing");
        Intrinsics.checkNotNullParameter(update, (String)"update");
        super(horizontalSizing, field, update);
    }

    public /* synthetic */ IntBox(Sizing sizing, KMutableProperty0 kMutableProperty0, Function0 function0, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 2) != 0) {
            kMutableProperty0 = null;
        }
        if ((n & 4) != 0) {
            function0 = IntBox::_init_$lambda$0;
        }
        this(sizing, (KMutableProperty0<Integer>)kMutableProperty0, (Function0<Unit>)function0);
    }

    @Override
    @NotNull
    protected Integer getZero() {
        return this.zero;
    }

    @Override
    @Nullable
    protected Integer parse(@NotNull String value) {
        Intrinsics.checkNotNullParameter((Object)value, (String)"value");
        return StringsKt.toIntOrNull((String)value);
    }

    private static final Unit _init_$lambda$0() {
        return Unit.INSTANCE;
    }
}

