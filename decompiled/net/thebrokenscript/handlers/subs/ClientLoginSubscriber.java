/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.Minecraft
 *  net.thebrokenscript.brokencore.api.util.Side
 *  net.thebrokenscript.brokencore.api.util.SideOnly
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.handlers.subs;

import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.client.Minecraft;
import net.thebrokenscript.brokencore.api.util.Side;
import net.thebrokenscript.brokencore.api.util.SideOnly;
import org.jetbrains.annotations.NotNull;

@SideOnly(side=Side.CLIENT)
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\t\u001a\u00020\n2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006J\u000e\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u0007R \u0010\u0004\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00060\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2={"Lnet/thebrokenscript/handlers/subs/ClientLoginSubscriber;", "", "<init>", "()V", "listeners", "", "Lkotlin/Function1;", "Lnet/minecraft/client/Minecraft;", "", "add", "", "listener", "call", "mc", "thebrokenscript-common"})
@SourceDebugExtension(value={"SMAP\nClientLoginSubscriber.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ClientLoginSubscriber.kt\nnet/thebrokenscript/handlers/subs/ClientLoginSubscriber\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,13:1\n1869#2,2:14\n*S KotlinDebug\n*F\n+ 1 ClientLoginSubscriber.kt\nnet/thebrokenscript/handlers/subs/ClientLoginSubscriber\n*L\n12#1:14,2\n*E\n"})
public final class ClientLoginSubscriber {
    @NotNull
    public static final ClientLoginSubscriber INSTANCE = new ClientLoginSubscriber();
    @NotNull
    private static final Set<Function1<Minecraft, Unit>> listeners = new LinkedHashSet();

    private ClientLoginSubscriber() {
    }

    public final boolean add(@NotNull Function1<? super Minecraft, Unit> listener) {
        Intrinsics.checkNotNullParameter(listener, (String)"listener");
        return listeners.add(listener);
    }

    public final void call(@NotNull Minecraft mc) {
        Intrinsics.checkNotNullParameter((Object)mc, (String)"mc");
        Iterable $this$forEach$iv = listeners;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            Function1 it = (Function1)element$iv;
            boolean bl = false;
            it.invoke((Object)mc);
        }
    }
}

