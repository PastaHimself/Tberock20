/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.event;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;
import java.util.function.Consumer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.thebrokenscript.brokencore.api.event.Cancelable;
import net.thebrokenscript.brokencore.api.event.EventListener;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u0000 \u000b*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001\u000bB\u0007\u00a2\u0006\u0004\b\u0003\u0010\u0004R&\u0010\u0005\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\b0\u0006X\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\f"}, d2={"Lnet/thebrokenscript/brokencore/api/event/GameEvent;", "D", "", "<init>", "()V", "listeners", "", "Ljava/util/UUID;", "Ljava/util/function/Consumer;", "getListeners$brokencore_common", "()Ljava/util/Map;", "Companion", "brokencore-common"})
public class GameEvent<D> {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final Map<UUID, Consumer<D>> listeners = new LinkedHashMap();

    @NotNull
    public final Map<UUID, Consumer<D>> getListeners$brokencore_common() {
        return this.listeners;
    }

    @JvmStatic
    @NotNull
    public static final <D, T extends GameEvent<D>> EventListener on(@NotNull T $this$on, @NotNull Function1<? super D, Unit> handler) {
        return Companion.on($this$on, handler);
    }

    @JvmStatic
    public static final <D, T extends GameEvent<D>> void call(@NotNull T $this$call, D data2) {
        Companion.call($this$call, data2);
    }

    @JvmStatic
    public static final <D extends Cancelable, T extends GameEvent<D>> boolean callCancelable(@NotNull T $this$callCancelable, @NotNull D data2) {
        return Companion.callCancelable($this$callCancelable, data2);
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J@\u0010\u0004\u001a\u00020\u0005\"\u0004\b\u0001\u0010\u0006\"\u000e\b\u0002\u0010\u0007*\b\u0012\u0004\u0012\u0002H\u00060\b*\u0002H\u00072\u0017\u0010\t\u001a\u0013\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u00020\u000b0\n\u00a2\u0006\u0002\b\fH\u0007\u00a2\u0006\u0002\u0010\rJ/\u0010\u000e\u001a\u00020\u000b\"\u0004\b\u0001\u0010\u0006\"\u000e\b\u0002\u0010\u0007*\b\u0012\u0004\u0012\u0002H\u00060\b*\u0002H\u00072\u0006\u0010\u000f\u001a\u0002H\u0006H\u0007\u00a2\u0006\u0002\u0010\u0010J3\u0010\u0011\u001a\u00020\u0012\"\b\b\u0001\u0010\u0006*\u00020\u0013\"\u000e\b\u0002\u0010\u0007*\b\u0012\u0004\u0012\u0002H\u00060\b*\u0002H\u00072\u0006\u0010\u000f\u001a\u0002H\u0006H\u0007\u00a2\u0006\u0002\u0010\u0014\u00a8\u0006\u0015"}, d2={"Lnet/thebrokenscript/brokencore/api/event/GameEvent$Companion;", "", "<init>", "()V", "on", "Lnet/thebrokenscript/brokencore/api/event/EventListener;", "D", "T", "Lnet/thebrokenscript/brokencore/api/event/GameEvent;", "handler", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "(Lnet/thebrokenscript/brokencore/api/event/GameEvent;Lkotlin/jvm/functions/Function1;)Lnet/thebrokenscript/brokencore/api/event/EventListener;", "call", "data", "(Lnet/thebrokenscript/brokencore/api/event/GameEvent;Ljava/lang/Object;)V", "callCancelable", "", "Lnet/thebrokenscript/brokencore/api/event/Cancelable;", "(Lnet/thebrokenscript/brokencore/api/event/GameEvent;Lnet/thebrokenscript/brokencore/api/event/Cancelable;)Z", "brokencore-common"})
    @SourceDebugExtension(value={"SMAP\nGameEvent.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GameEvent.kt\nnet/thebrokenscript/brokencore/api/event/GameEvent$Companion\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,58:1\n1869#2,2:59\n*S KotlinDebug\n*F\n+ 1 GameEvent.kt\nnet/thebrokenscript/brokencore/api/event/GameEvent$Companion\n*L\n44#1:59,2\n*E\n"})
    public static final class Companion {
        private Companion() {
        }

        @JvmStatic
        @NotNull
        public final <D, T extends GameEvent<D>> EventListener on(@NotNull T $this$on, @NotNull Function1<? super D, Unit> handler) {
            EventListener eventListener;
            Intrinsics.checkNotNullParameter($this$on, (String)"<this>");
            Intrinsics.checkNotNullParameter(handler, (String)"handler");
            UUID uUID = UUID.randomUUID();
            Intrinsics.checkNotNullExpressionValue((Object)uUID, (String)"randomUUID(...)");
            EventListener it = eventListener = new EventListener(uUID, $this$on);
            boolean bl = false;
            $this$on.getListeners$brokencore_common().put(it.getUuid(), arg_0 -> Companion.on$lambda$0$0(handler, arg_0));
            return eventListener;
        }

        @JvmStatic
        public final <D, T extends GameEvent<D>> void call(@NotNull T $this$call, D data2) {
            Intrinsics.checkNotNullParameter($this$call, (String)"<this>");
            Iterable $this$forEach$iv = $this$call.getListeners$brokencore_common().values();
            boolean $i$f$forEach = false;
            for (Object element$iv : $this$forEach$iv) {
                Consumer it = (Consumer)element$iv;
                boolean bl = false;
                it.accept(data2);
            }
        }

        @JvmStatic
        public final <D extends Cancelable, T extends GameEvent<D>> boolean callCancelable(@NotNull T $this$callCancelable, @NotNull D data2) {
            Intrinsics.checkNotNullParameter($this$callCancelable, (String)"<this>");
            Intrinsics.checkNotNullParameter(data2, (String)"data");
            Iterator<Consumer<D>> funcs = $this$callCancelable.getListeners$brokencore_common().values().iterator();
            while (!data2.getCanceled() && funcs.hasNext()) {
                funcs.next().accept(data2);
            }
            return data2.getCanceled();
        }

        private static final void on$lambda$0$0(Function1 $tmp0, Object p0) {
            $tmp0.invoke(p0);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

