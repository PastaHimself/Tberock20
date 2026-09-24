/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.platform;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B)\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007\u00a2\u0006\u0004\b\b\u0010\tR\u001a\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R$\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00048F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\u0002\u0010\r\u00a8\u0006\u000e"}, d2={"Lnet/thebrokenscript/brokencore/api/platform/CancelProxy;", "", "setCanceled", "Lkotlin/Function1;", "", "", "getCanceled", "Lkotlin/Function0;", "<init>", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)V", "value", "isCanceled", "()Z", "(Z)V", "brokencore-common"})
public final class CancelProxy {
    @NotNull
    private final Function1<Boolean, Unit> setCanceled;
    @NotNull
    private final Function0<Boolean> getCanceled;

    public CancelProxy(@NotNull Function1<? super Boolean, Unit> setCanceled, @NotNull Function0<Boolean> getCanceled) {
        Intrinsics.checkNotNullParameter(setCanceled, (String)"setCanceled");
        Intrinsics.checkNotNullParameter(getCanceled, (String)"getCanceled");
        this.setCanceled = setCanceled;
        this.getCanceled = getCanceled;
    }

    public final boolean isCanceled() {
        return (Boolean)this.getCanceled.invoke();
    }

    public final void setCanceled(boolean value) {
        this.setCanceled.invoke((Object)value);
    }
}

