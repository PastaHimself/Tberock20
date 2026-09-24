/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.functions.Function3
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.math.MathKt
 *  net.minecraft.client.Minecraft
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.client.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.math.MathKt;
import net.minecraft.client.Minecraft;
import net.thebrokenscript.brokencore.api.dsl.ClientDSLKt;
import net.thebrokenscript.brokencore.api.event.GameEvent;
import net.thebrokenscript.brokencore.api.event.game.ClientEvents;
import net.thebrokenscript.brokencore.impl.ForceRuntimeInit;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0014\u0018\u0000 *2\u00020\u0001:\u0001*B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0014\u001a\u00020\fJ\"\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u00172\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\u000fJ\"\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\n2\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\u000fJ\"\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u00052\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\u000fJ\u000e\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0017J\u000e\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\nJ\u000e\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005J\"\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\u000fJ\"\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\n2\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\u000fJ\u000e\u0010\u001c\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\u000bJ&\u0010\u001e\u001a\u00020\u00002\u001e\u0010\u001f\u001a\u001a\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\tJ\u0006\u0010 \u001a\u00020\fJ\u001a\u0010!\u001a\u00020\u00002\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\u000fJ\u0006\u0010)\u001a\u00020\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000RN\u0010\u0007\u001aB\u0012\u001c\u0012\u001a\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\t0\bj \u0012\u001c\u0012\u001a\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\t`\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R6\u0010\u000e\u001a*\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\u000f0\bj\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\u000f`\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0012\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010\"\u001a\u00020\n8F\u00a2\u0006\u0006\u001a\u0004\b#\u0010$R\u0011\u0010%\u001a\u00020\n8F\u00a2\u0006\u0006\u001a\u0004\b&\u0010$R\u0011\u0010'\u001a\u00020\n8F\u00a2\u0006\u0006\u001a\u0004\b(\u0010$\u00a8\u0006+"}, d2={"Lnet/thebrokenscript/brokencore/api/client/util/ClientTickTimer;", "", "<init>", "()V", "ticks", "", "endTime", "onTickFuncs", "Ljava/util/ArrayList;", "Lkotlin/Function3;", "", "Lnet/minecraft/client/Minecraft;", "", "Lkotlin/collections/ArrayList;", "onEndFuncs", "Lkotlin/Function1;", "started", "", "loop", "freed", "free", "start", "seconds", "", "onEnd", "delta", "then", "runnable", "tick", "client", "doOnTick", "tickSupplier", "clearEndFuncs", "doOnEnd", "timeLeft", "getTimeLeft", "()F", "waitTicks", "getWaitTicks", "waitTime", "getWaitTime", "getDelta", "Companion", "brokencore-common"})
@SourceDebugExtension(value={"SMAP\nClientTickTimer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ClientTickTimer.kt\nnet/thebrokenscript/brokencore/api/client/util/ClientTickTimer\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,175:1\n1869#2,2:176\n1869#2,2:178\n1869#2,2:180\n*S KotlinDebug\n*F\n+ 1 ClientTickTimer.kt\nnet/thebrokenscript/brokencore/api/client/util/ClientTickTimer\n*L\n157#1:176,2\n161#1:178,2\n165#1:180,2\n*E\n"})
public final class ClientTickTimer {
    @NotNull
    public static final Companion Companion = new Companion(null);
    private int ticks;
    private int endTime;
    @NotNull
    private final ArrayList<Function3<Integer, Float, Minecraft, Unit>> onTickFuncs = new ArrayList();
    @NotNull
    private final ArrayList<Function1<Minecraft, Unit>> onEndFuncs = new ArrayList();
    private boolean started;
    @JvmField
    public boolean loop;
    private boolean freed;
    private float delta;
    @NotNull
    private static final List<ClientTickTimer> TIMERS = new ArrayList();
    @NotNull
    private static final List<ClientTickTimer> TO_REMOVE = new ArrayList();
    @NotNull
    private static final List<ClientTickTimer> TO_ADD = new ArrayList();

    public ClientTickTimer() {
        TO_ADD.add(this);
    }

    public final void free() {
        TO_REMOVE.add(this);
        this.freed = true;
    }

    @NotNull
    public final ClientTickTimer start(double seconds, @NotNull Function1<? super Minecraft, Unit> onEnd) {
        Intrinsics.checkNotNullParameter(onEnd, (String)"onEnd");
        this.started = true;
        this.endTime = MathKt.roundToInt((double)(seconds * (double)20));
        this.ticks = 0;
        this.onEndFuncs.add(onEnd);
        return this;
    }

    @NotNull
    public final ClientTickTimer start(float seconds, @NotNull Function1<? super Minecraft, Unit> onEnd) {
        Intrinsics.checkNotNullParameter(onEnd, (String)"onEnd");
        this.started = true;
        this.endTime = MathKt.roundToInt((float)(seconds * (float)20));
        this.ticks = 0;
        this.onEndFuncs.add(onEnd);
        return this;
    }

    @NotNull
    public final ClientTickTimer start(int endTime, @NotNull Function1<? super Minecraft, Unit> onEnd) {
        Intrinsics.checkNotNullParameter(onEnd, (String)"onEnd");
        this.started = true;
        this.endTime = endTime;
        this.ticks = 0;
        this.onEndFuncs.add(onEnd);
        return this;
    }

    @NotNull
    public final ClientTickTimer start(double seconds) {
        this.started = true;
        this.endTime = MathKt.roundToInt((double)(seconds * (double)20));
        this.ticks = 0;
        return this;
    }

    @NotNull
    public final ClientTickTimer start(float seconds) {
        this.started = true;
        this.endTime = MathKt.roundToInt((float)(seconds * (float)20));
        this.ticks = 0;
        return this;
    }

    @NotNull
    public final ClientTickTimer start(int endTime) {
        this.started = true;
        this.endTime = endTime;
        this.ticks = 0;
        return this;
    }

    @NotNull
    public final ClientTickTimer then(int ticks, @NotNull Function1<? super Minecraft, Unit> runnable) {
        Intrinsics.checkNotNullParameter(runnable, (String)"runnable");
        ClientTickTimer timer = new ClientTickTimer();
        timer.doOnEnd((Function1<? super Minecraft, Unit>)((Function1)arg_0 -> ClientTickTimer.then$lambda$0(runnable, timer, arg_0)));
        this.doOnEnd((Function1<? super Minecraft, Unit>)((Function1)arg_0 -> ClientTickTimer.then$lambda$1(timer, ticks, arg_0)));
        return timer;
    }

    @NotNull
    public final ClientTickTimer then(float seconds, @NotNull Function1<? super Minecraft, Unit> runnable) {
        Intrinsics.checkNotNullParameter(runnable, (String)"runnable");
        ClientTickTimer timer = new ClientTickTimer();
        timer.doOnEnd((Function1<? super Minecraft, Unit>)((Function1)arg_0 -> ClientTickTimer.then$lambda$2(runnable, timer, arg_0)));
        this.doOnEnd((Function1<? super Minecraft, Unit>)((Function1)arg_0 -> ClientTickTimer.then$lambda$3(timer, seconds, arg_0)));
        return timer;
    }

    public final void tick(@NotNull Minecraft client) {
        Intrinsics.checkNotNullParameter((Object)client, (String)"client");
        if (client.isPaused()) {
            return;
        }
        if (this.freed) {
            this.free();
        }
        if (this.started && !this.freed) {
            if (this.delta >= 1.0f) {
                this.delta = 0.0f;
            }
            if (this.ticks < this.endTime) {
                Iterator<Function3<Integer, Float, Minecraft, Unit>> iterator = this.onTickFuncs.iterator();
                Intrinsics.checkNotNullExpressionValue(iterator, (String)"iterator(...)");
                Iterator<Function3<Integer, Float, Minecraft, Unit>> iterator2 = iterator;
                while (iterator2.hasNext()) {
                    Function3<Integer, Float, Minecraft, Unit> func;
                    Intrinsics.checkNotNullExpressionValue(iterator2.next(), (String)"next(...)");
                    func.invoke((Object)this.ticks, (Object)Float.valueOf(this.getDelta()), (Object)client);
                }
                ++this.ticks;
            } else {
                Iterator<Function1<Minecraft, Unit>> iterator = this.onEndFuncs.iterator();
                Intrinsics.checkNotNullExpressionValue(iterator, (String)"iterator(...)");
                Iterator<Function1<Minecraft, Unit>> iterator3 = iterator;
                while (iterator3.hasNext()) {
                    Function1<Minecraft, Unit> runnable;
                    Intrinsics.checkNotNullExpressionValue(iterator3.next(), (String)"next(...)");
                    runnable.invoke((Object)client);
                }
                if (this.loop) {
                    this.start(this.endTime);
                } else {
                    this.started = false;
                }
            }
        }
    }

    @NotNull
    public final ClientTickTimer doOnTick(@NotNull Function3<? super Integer, ? super Float, ? super Minecraft, Unit> tickSupplier) {
        Intrinsics.checkNotNullParameter(tickSupplier, (String)"tickSupplier");
        this.onTickFuncs.add(tickSupplier);
        return this;
    }

    public final void clearEndFuncs() {
        this.onEndFuncs.clear();
    }

    @NotNull
    public final ClientTickTimer doOnEnd(@NotNull Function1<? super Minecraft, Unit> runnable) {
        Intrinsics.checkNotNullParameter(runnable, (String)"runnable");
        this.onEndFuncs.add(runnable);
        return this;
    }

    public final float getTimeLeft() {
        return (float)this.ticks + ClientDSLKt.getMC().getTimer().getGameTimeDeltaPartialTick(true);
    }

    public final float getWaitTicks() {
        return this.endTime;
    }

    public final float getWaitTime() {
        return (float)this.endTime / 20.0f;
    }

    public final float getDelta() {
        return this.endTime <= 0 ? 0.0f : (float)this.ticks / (float)this.endTime;
    }

    private static final Unit then$lambda$0(Function1 $runnable, ClientTickTimer $timer, Minecraft server) {
        Intrinsics.checkNotNullParameter((Object)server, (String)"server");
        $runnable.invoke((Object)server);
        $timer.free();
        return Unit.INSTANCE;
    }

    private static final Unit then$lambda$1(ClientTickTimer $timer, int $ticks, Minecraft minecraft) {
        Intrinsics.checkNotNullParameter((Object)minecraft, (String)"<unused var>");
        $timer.start($ticks);
        return Unit.INSTANCE;
    }

    private static final Unit then$lambda$2(Function1 $runnable, ClientTickTimer $timer, Minecraft server) {
        Intrinsics.checkNotNullParameter((Object)server, (String)"server");
        $runnable.invoke((Object)server);
        $timer.free();
        return Unit.INSTANCE;
    }

    private static final Unit then$lambda$3(ClientTickTimer $timer, float $seconds, Minecraft minecraft) {
        Intrinsics.checkNotNullParameter((Object)minecraft, (String)"<unused var>");
        $timer.start($seconds);
        return Unit.INSTANCE;
    }

    private static final Unit _init_$lambda$0(ClientEvents.Data $this$on) {
        ClientTickTimer it;
        Intrinsics.checkNotNullParameter((Object)$this$on, (String)"$this$on");
        Iterable $this$forEach$iv = TIMERS;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            it = (ClientTickTimer)element$iv;
            boolean bl = false;
            it.tick(ClientDSLKt.getMC());
        }
        $this$forEach$iv = TO_ADD;
        $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            it = (ClientTickTimer)element$iv;
            boolean bl = false;
            TIMERS.add(it);
        }
        $this$forEach$iv = TO_REMOVE;
        $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            it = (ClientTickTimer)element$iv;
            boolean bl = false;
            TIMERS.remove(it);
        }
        TO_REMOVE.clear();
        TO_ADD.clear();
        return Unit.INSTANCE;
    }

    static {
        GameEvent.Companion.on(ClientEvents.INACTIVE_TICK_END, ClientTickTimer::_init_$lambda$0);
    }

    @ForceRuntimeInit
    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0081\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\b\u00a8\u0006\r"}, d2={"Lnet/thebrokenscript/brokencore/api/client/util/ClientTickTimer$Companion;", "", "<init>", "()V", "TIMERS", "", "Lnet/thebrokenscript/brokencore/api/client/util/ClientTickTimer;", "getTIMERS$brokencore_common", "()Ljava/util/List;", "TO_REMOVE", "getTO_REMOVE$brokencore_common", "TO_ADD", "getTO_ADD$brokencore_common", "brokencore-common"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final List<ClientTickTimer> getTIMERS$brokencore_common() {
            return TIMERS;
        }

        @NotNull
        public final List<ClientTickTimer> getTO_REMOVE$brokencore_common() {
            return TO_REMOVE;
        }

        @NotNull
        public final List<ClientTickTimer> getTO_ADD$brokencore_common() {
            return TO_ADD;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

