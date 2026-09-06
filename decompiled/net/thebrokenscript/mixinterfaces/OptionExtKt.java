/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.client.OptionInstance
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.mixinterfaces;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.OptionInstance;
import net.thebrokenscript.mixinterfaces.OptionExt;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=2, xi=48, d1={"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a#\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001a\u0002H\u0002\u00a2\u0006\u0002\u0010\u0005\u00a8\u0006\u0006"}, d2={"setForced", "", "T", "Lnet/minecraft/client/OptionInstance;", "value", "(Lnet/minecraft/client/OptionInstance;Ljava/lang/Object;)V", "thebrokenscript-common"})
public final class OptionExtKt {
    public static final <T> void setForced(@NotNull OptionInstance<T> $this$setForced, T value) {
        Intrinsics.checkNotNullParameter($this$setForced, (String)"<this>");
        ((OptionExt)$this$setForced).tbs$setForced(value);
    }
}

