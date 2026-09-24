/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.brokencore.api.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 \u0012*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0003\u0011\u0012\u0013B>\b\u0002\u0012\b\u0010\u0003\u001a\u0004\b\u00028\u0000\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0012\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\t0\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0006\u0010\u0010\u001a\u00020\u0006R\u0015\u0010\u0003\u001a\u0004\b\u00028\u0000X\u0082\u000e\u00f8\u0001\u0000\u00a2\u0006\u0004\n\u0002\u0010\fR\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b9\u00a8\u0006\u0014"}, d2={"Lnet/thebrokenscript/brokencore/api/util/TickSteppedTask;", "T", "", "value", "completionCallback", "Lkotlin/Function1;", "", "steps", "", "Lnet/thebrokenscript/brokencore/api/util/TickSteppedTask$Step;", "<init>", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Ljava/util/List;)V", "Ljava/lang/Object;", "stepIndex", "", "currentStep", "tick", "Step", "Companion", "TaskBuilder", "brokencore-common"})
public final class TickSteppedTask<T> {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private T value;
    @NotNull
    private Function1<? super T, Unit> completionCallback;
    private int stepIndex;
    @NotNull
    private Step<T> currentStep;

    private TickSteppedTask(T value, Function1<? super T, Unit> completionCallback, List<Step<T>> steps) {
        this.value = value;
        this.completionCallback = completionCallback;
        if (!(!((Collection)steps).isEmpty())) {
            throw new RuntimeException("Task must have at least one step");
        }
        this.currentStep = steps.get(0);
    }

    public final void tick() {
    }

    public /* synthetic */ TickSteppedTask(Object value, Function1 completionCallback, List steps, DefaultConstructorMarker $constructor_marker) {
        this(value, completionCallback, steps);
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J4\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0005\"\u0004\b\u0001\u0010\u00062\u001d\u0010\u0007\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00060\t\u0012\u0004\u0012\u00020\n0\b\u00a2\u0006\u0002\b\u000bH\u0086\u0002\u00a8\u0006\f"}, d2={"Lnet/thebrokenscript/brokencore/api/util/TickSteppedTask$Companion;", "", "<init>", "()V", "invoke", "Lnet/thebrokenscript/brokencore/api/util/TickSteppedTask;", "T", "init", "Lkotlin/Function1;", "Lnet/thebrokenscript/brokencore/api/util/TickSteppedTask$TaskBuilder;", "", "Lkotlin/ExtensionFunctionType;", "brokencore-common"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final <T> TickSteppedTask<T> invoke(@NotNull Function1<? super TaskBuilder<T>, Unit> init) {
            Intrinsics.checkNotNullParameter(init, (String)"init");
            TaskBuilder task = new TaskBuilder();
            init.invoke(task);
            return new TickSteppedTask(task.getInitialValue(), task.callback(), CollectionsKt.toList((Iterable)task.stepList()), null);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u0000*\u0004\b\u0001\u0010\u00012\u00020\u0002B/\u0012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00010\u0004\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u00060\u0004\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0013\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00028\u0001\u00a2\u0006\u0002\u0010\rR\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00010\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u0004\u0018\u00018\u0001X\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\n\u00a8\u0006\u000e"}, d2={"Lnet/thebrokenscript/brokencore/api/util/TickSteppedTask$Step;", "T", "", "tickFunc", "Lkotlin/Function1;", "endCond", "", "<init>", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "currentValue", "Ljava/lang/Object;", "tick", "input", "(Ljava/lang/Object;)Z", "brokencore-common"})
    public static final class Step<T> {
        @NotNull
        private final Function1<T, T> tickFunc;
        @NotNull
        private final Function1<T, Boolean> endCond;
        @Nullable
        private T currentValue;

        public Step(@NotNull Function1<? super T, ? extends T> tickFunc, @NotNull Function1<? super T, Boolean> endCond) {
            Intrinsics.checkNotNullParameter(tickFunc, (String)"tickFunc");
            Intrinsics.checkNotNullParameter(endCond, (String)"endCond");
            this.tickFunc = tickFunc;
            this.endCond = endCond;
        }

        public final boolean tick(T input) {
            if (((Boolean)this.endCond.invoke(input)).booleanValue()) {
                return true;
            }
            this.currentValue = this.tickFunc.invoke(input);
            return false;
        }
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\u00020\u0002:\u0001\u0019B\u0007\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00100\u0012J\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\r0\fJ\u001a\u0010\u0014\u001a\u00020\r2\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\r0\fJ%\u0010\u0016\u001a\u00020\r2\u001d\u0010\u0015\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0017\u0012\u0004\u0012\u00020\r0\f\u00a2\u0006\u0002\b\u0018R!\u0010\u0005\u001a\u0004\b\u00028\u0001X\u0086.\u00f8\u0001\u0000\u00a2\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\r0\fX\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00100\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b9\u00a8\u0006\u001a"}, d2={"Lnet/thebrokenscript/brokencore/api/util/TickSteppedTask$TaskBuilder;", "T", "", "<init>", "()V", "initialValue", "getInitialValue", "()Ljava/lang/Object;", "setInitialValue", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "completionCallback", "Lkotlin/Function1;", "", "steps", "", "Lnet/thebrokenscript/brokencore/api/util/TickSteppedTask$Step;", "stepList", "", "callback", "onComplete", "func", "step", "Lnet/thebrokenscript/brokencore/api/util/TickSteppedTask$TaskBuilder$StepBuilder;", "Lkotlin/ExtensionFunctionType;", "StepBuilder", "brokencore-common"})
    public static final class TaskBuilder<T> {
        public T initialValue;
        private Function1<? super T, Unit> completionCallback;
        @NotNull
        private final List<Step<T>> steps = new ArrayList();

        @NotNull
        public final T getInitialValue() {
            T t = this.initialValue;
            if (t != null) {
                return t;
            }
            Intrinsics.throwUninitializedPropertyAccessException((String)"initialValue");
            return (T)Unit.INSTANCE;
        }

        public final void setInitialValue(@NotNull T t) {
            Intrinsics.checkNotNullParameter(t, (String)"<set-?>");
            this.initialValue = t;
        }

        @NotNull
        public final List<Step<T>> stepList() {
            return CollectionsKt.toList((Iterable)this.steps);
        }

        @NotNull
        public final Function1<T, Unit> callback() {
            Function1<? super T, Unit> function1 = this.completionCallback;
            if (function1 == null) {
                Intrinsics.throwUninitializedPropertyAccessException((String)"completionCallback");
                function1 = null;
            }
            return function1;
        }

        public final void onComplete(@NotNull Function1<? super T, Unit> func) {
            Intrinsics.checkNotNullParameter(func, (String)"func");
            this.completionCallback = func;
        }

        public final void step(@NotNull Function1<? super StepBuilder<T>, Unit> func) {
            Intrinsics.checkNotNullParameter(func, (String)"func");
            StepBuilder stepBuilder = new StepBuilder();
            func.invoke(stepBuilder);
            this.steps.add(new Step(stepBuilder.tFun(), stepBuilder.endC()));
        }

        @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000*\u0004\b\u0002\u0010\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00020\u0006J\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00020\b0\u0006J\u001a\u0010\u000b\u001a\u00020\f2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00020\u0006J\u001a\u0010\u000e\u001a\u00020\f2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00020\b0\u0006R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00020\b0\u0006X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2={"Lnet/thebrokenscript/brokencore/api/util/TickSteppedTask$TaskBuilder$StepBuilder;", "T", "", "<init>", "()V", "tickFuncV", "Lkotlin/Function1;", "endCondV", "", "tFun", "endC", "tickFunc", "", "func", "endCond", "brokencore-common"})
        public static final class StepBuilder<T> {
            private Function1<? super T, ? extends T> tickFuncV;
            private Function1<? super T, Boolean> endCondV;

            @NotNull
            public final Function1<T, T> tFun() {
                Function1<? super T, ? extends T> function1 = this.tickFuncV;
                if (function1 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException((String)"tickFuncV");
                    function1 = null;
                }
                return function1;
            }

            @NotNull
            public final Function1<T, Boolean> endC() {
                Function1<? super T, Boolean> function1 = this.endCondV;
                if (function1 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException((String)"endCondV");
                    function1 = null;
                }
                return function1;
            }

            public final void tickFunc(@NotNull Function1<? super T, ? extends T> func) {
                Intrinsics.checkNotNullParameter(func, (String)"func");
                this.tickFuncV = func;
            }

            public final void endCond(@NotNull Function1<? super T, Boolean> func) {
                Intrinsics.checkNotNullParameter(func, (String)"func");
                this.endCondV = func;
            }
        }
    }
}

