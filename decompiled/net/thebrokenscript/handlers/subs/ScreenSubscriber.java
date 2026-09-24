/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.gui.screens.Screen
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
import net.minecraft.client.gui.screens.Screen;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\t\u001a\u00020\n2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006J\u000e\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u0007R \u0010\u0004\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00060\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2={"Lnet/thebrokenscript/handlers/subs/ScreenSubscriber;", "", "<init>", "()V", "listeners", "", "Lkotlin/Function1;", "Lnet/minecraft/client/gui/screens/Screen;", "", "add", "", "listener", "call", "screen", "thebrokenscript-common"})
@SourceDebugExtension(value={"SMAP\nScreenSubscriber.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ScreenSubscriber.kt\nnet/thebrokenscript/handlers/subs/ScreenSubscriber\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,10:1\n1869#2,2:11\n*S KotlinDebug\n*F\n+ 1 ScreenSubscriber.kt\nnet/thebrokenscript/handlers/subs/ScreenSubscriber\n*L\n9#1:11,2\n*E\n"})
public final class ScreenSubscriber {
    @NotNull
    public static final ScreenSubscriber INSTANCE = new ScreenSubscriber();
    @NotNull
    private static final Set<Function1<Screen, Unit>> listeners = new LinkedHashSet();

    private ScreenSubscriber() {
    }

    public final boolean add(@NotNull Function1<? super Screen, Unit> listener) {
        Intrinsics.checkNotNullParameter(listener, (String)"listener");
        return listeners.add(listener);
    }

    public final void call(@NotNull Screen screen) {
        Intrinsics.checkNotNullParameter((Object)screen, (String)"screen");
        Iterable $this$forEach$iv = listeners;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            Function1 it = (Function1)element$iv;
            boolean bl = false;
            it.invoke((Object)screen);
        }
    }
}

