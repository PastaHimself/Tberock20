/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  dev.emi.emi.api.EmiEntrypoint
 *  dev.emi.emi.api.EmiPlugin
 *  dev.emi.emi.api.EmiRegistry
 *  dev.emi.emi.api.stack.EmiStack
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.compat.emi;

import dev.emi.emi.api.EmiEntrypoint;
import dev.emi.emi.api.EmiPlugin;
import dev.emi.emi.api.EmiRegistry;
import dev.emi.emi.api.stack.EmiStack;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@EmiEntrypoint
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016\u00a8\u0006\b"}, d2={"Lnet/thebrokenscript/compat/emi/TBSEmiPlugin;", "Ldev/emi/emi/api/EmiPlugin;", "<init>", "()V", "register", "", "registry", "Ldev/emi/emi/api/EmiRegistry;", "thebrokenscript-common"})
public final class TBSEmiPlugin
implements EmiPlugin {
    public void register(@NotNull EmiRegistry registry) {
        Intrinsics.checkNotNullParameter((Object)registry, (String)"registry");
        registry.removeEmiStacks(TBSEmiPlugin::register$lambda$0);
    }

    private static final boolean register$lambda$0(EmiStack it) {
        return Intrinsics.areEqual((Object)it.getId().getNamespace(), (Object)"thebrokenscript");
    }
}

