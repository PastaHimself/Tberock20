/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.JvmName
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.functions.Function3
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.ext;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.thebrokenscript.brokencore.api.util.InstanceConsumer;
import net.thebrokenscript.brokencore.impl.util.InstanceConsumerGlue;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J(\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u00020\u00070\u0005\"\u0004\b\u0000\u0010\u0006*\u000e\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u00020\u00070\u0005J0\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\n0\t\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\t2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u0002H\n\u0012\u0004\u0012\u0002H\n0\u0005J<\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\n\u0012\u0004\u0012\u00020\f0\u0005\"\u0004\b\u0000\u0010\n*\u000e\u0012\u0004\u0012\u0002H\n\u0012\u0004\u0012\u00020\f0\u00052\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u0002H\n\u0012\u0004\u0012\u00020\f0\u0005Jc\u0010\r\u001a\u0019\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\n\u0012\u0004\u0012\u00020\f0\u000e\u00a2\u0006\u0002\b\u0010\"\u0004\b\u0000\u0010\u000f\"\u0004\b\u0001\u0010\n*\u0019\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\n\u0012\u0004\u0012\u00020\f0\u000e\u00a2\u0006\u0002\b\u00102\u001d\u0010\u000b\u001a\u0019\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\n\u0012\u0004\u0012\u00020\f0\u000e\u00a2\u0006\u0002\b\u0010J{\u0010\u0011\u001a\u001f\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u0013\u0012\u0004\u0012\u0002H\u0014\u0012\u0004\u0012\u00020\f0\u0012\u00a2\u0006\u0002\b\u0010\"\u0004\b\u0000\u0010\u000f\"\u0004\b\u0001\u0010\u0013\"\u0004\b\u0002\u0010\u0014*\u001f\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u0013\u0012\u0004\u0012\u0002H\u0014\u0012\u0004\u0012\u00020\f0\u0012\u00a2\u0006\u0002\b\u00102#\u0010\u000b\u001a\u001f\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u0013\u0012\u0004\u0012\u0002H\u0014\u0012\u0004\u0012\u00020\f0\u0012\u00a2\u0006\u0002\b\u0010J7\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\n0\t\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\t2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u0002H\n\u0012\u0004\u0012\u00020\f0\u0005H\u0007\u00a2\u0006\u0002\b\u0015J1\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\n0\t\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\t2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\n0\u0016H\u0007\u00a2\u0006\u0002\b\u0017J7\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\n0\t\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\t2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u0002H\n\u0012\u0004\u0012\u00020\f0\u0005H\u0007\u00a2\u0006\u0002\b\u0018\u00a8\u0006\u0019"}, d2={"Lnet/thebrokenscript/brokencore/api/ext/KFuncExt;", "", "<init>", "()V", "negate", "Lkotlin/Function1;", "I", "", "chain", "Lkotlin/Function0;", "T", "other", "", "chain2", "Lkotlin/Function2;", "R", "Lkotlin/ExtensionFunctionType;", "chain3", "Lkotlin/Function3;", "A", "B", "chainApply", "Lnet/thebrokenscript/brokencore/api/util/InstanceConsumer;", "chainApplyConsumer", "chainApply_", "brokencore-common"})
@SourceDebugExtension(value={"SMAP\nKFuncExt.kt\nKotlin\n*S Kotlin\n*F\n+ 1 KFuncExt.kt\nnet/thebrokenscript/brokencore/api/ext/KFuncExt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,35:1\n1#2:36\n*E\n"})
public final class KFuncExt {
    @NotNull
    public static final KFuncExt INSTANCE = new KFuncExt();

    private KFuncExt() {
    }

    @NotNull
    public final <I> Function1<I, Boolean> negate(@NotNull Function1<? super I, Boolean> $this$negate) {
        Intrinsics.checkNotNullParameter($this$negate, (String)"<this>");
        return arg_0 -> KFuncExt.negate$lambda$0($this$negate, arg_0);
    }

    @NotNull
    public final <T> Function0<T> chain(@NotNull Function0<? extends T> $this$chain, @NotNull Function1<? super T, ? extends T> other) {
        Intrinsics.checkNotNullParameter($this$chain, (String)"<this>");
        Intrinsics.checkNotNullParameter(other, (String)"other");
        return () -> KFuncExt.chain$lambda$0($this$chain, other);
    }

    @NotNull
    public final <T> Function1<T, Unit> chain(@NotNull Function1<? super T, Unit> $this$chain, @NotNull Function1<? super T, Unit> other) {
        Intrinsics.checkNotNullParameter($this$chain, (String)"<this>");
        Intrinsics.checkNotNullParameter(other, (String)"other");
        return arg_0 -> KFuncExt.chain$lambda$1($this$chain, other, arg_0);
    }

    @NotNull
    public final <R, T> Function2<R, T, Unit> chain2(@NotNull Function2<? super R, ? super T, Unit> $this$chain2, @NotNull Function2<? super R, ? super T, Unit> other) {
        Intrinsics.checkNotNullParameter($this$chain2, (String)"<this>");
        Intrinsics.checkNotNullParameter(other, (String)"other");
        return (arg_0, arg_1) -> KFuncExt.chain2$lambda$0($this$chain2, other, arg_0, arg_1);
    }

    @NotNull
    public final <R, A, B> Function3<R, A, B, Unit> chain3(@NotNull Function3<? super R, ? super A, ? super B, Unit> $this$chain3, @NotNull Function3<? super R, ? super A, ? super B, Unit> other) {
        Intrinsics.checkNotNullParameter($this$chain3, (String)"<this>");
        Intrinsics.checkNotNullParameter(other, (String)"other");
        return (arg_0, arg_1, arg_2) -> KFuncExt.chain3$lambda$0($this$chain3, other, arg_0, arg_1, arg_2);
    }

    @JvmName(name="chainApply")
    @NotNull
    public final <T> Function0<T> chainApply(@NotNull Function0<? extends T> $this$chain, @NotNull Function1<? super T, Unit> other) {
        Intrinsics.checkNotNullParameter($this$chain, (String)"<this>");
        Intrinsics.checkNotNullParameter(other, (String)"other");
        return () -> KFuncExt.chain$lambda$2($this$chain, other);
    }

    @JvmName(name="chainApplyConsumer")
    @NotNull
    public final <T> Function0<T> chainApplyConsumer(@NotNull Function0<? extends T> $this$chain, @NotNull InstanceConsumer<T> other) {
        Intrinsics.checkNotNullParameter($this$chain, (String)"<this>");
        Intrinsics.checkNotNullParameter(other, (String)"other");
        return () -> KFuncExt.chain$lambda$3($this$chain, other);
    }

    @JvmName(name="chainApply_")
    @NotNull
    public final <T> Function0<T> chainApply_(@NotNull Function0<? extends T> $this$chainApply, @NotNull Function1<? super T, Unit> other) {
        Intrinsics.checkNotNullParameter($this$chainApply, (String)"<this>");
        Intrinsics.checkNotNullParameter(other, (String)"other");
        return () -> KFuncExt.chainApply$lambda$0($this$chainApply, other);
    }

    private static final boolean negate$lambda$0(Function1 $this_negate, Object input) {
        return (Boolean)$this_negate.invoke(input) == false;
    }

    private static final Object chain$lambda$0(Function0 $this_chain, Function1 $other) {
        return $other.invoke($this_chain.invoke());
    }

    private static final Unit chain$lambda$1(Function1 $this_chain, Function1 $other, Object it) {
        $this_chain.invoke(it);
        $other.invoke(it);
        return Unit.INSTANCE;
    }

    private static final Unit chain2$lambda$0(Function2 $this_chain2, Function2 $other, Object object, Object it) {
        $this_chain2.invoke(object, it);
        $other.invoke(object, it);
        return Unit.INSTANCE;
    }

    private static final Unit chain3$lambda$0(Function3 $this_chain3, Function3 $other, Object object, Object a, Object b) {
        $this_chain3.invoke(object, a, b);
        $other.invoke(object, a, b);
        return Unit.INSTANCE;
    }

    private static final Object chain$lambda$2(Function0 $this_chain, Function1 $other) {
        Object object = $this_chain.invoke();
        $other.invoke(object);
        return object;
    }

    private static final Object chain$lambda$3(Function0 $this_chain, InstanceConsumer $other) {
        Object object;
        Object $this$chain_u24lambda_u243_u240 = object = $this_chain.invoke();
        boolean bl = false;
        InstanceConsumerGlue.accept($this$chain_u24lambda_u243_u240, $other);
        return object;
    }

    private static final Object chainApply$lambda$0(Function0 $this_chainApply, Function1 $other) {
        Object object = $this_chainApply.invoke();
        $other.invoke(object);
        return object;
    }
}

