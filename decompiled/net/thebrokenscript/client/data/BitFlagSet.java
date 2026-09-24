/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.client.data;

import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0003J\u0010\u0010\f\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0003H\u0016J\u0010\u0010\r\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0003H\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005\u00a8\u0006\u000e"}, d2={"Lnet/thebrokenscript/client/data/BitFlagSet;", "", "value", "", "<init>", "(J)V", "getValue", "()J", "setValue", "has", "", "flag", "set", "unset", "thebrokenscript-common"})
@SourceDebugExtension(value={"SMAP\nBitFlagSet.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BitFlagSet.kt\nnet/thebrokenscript/client/data/BitFlagSet\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,8:1\n1#2:9\n*E\n"})
public class BitFlagSet {
    private long value;

    public BitFlagSet(long value) {
        this.value = value;
    }

    public final long getValue() {
        return this.value;
    }

    public final void setValue(long l) {
        this.value = l;
    }

    public final boolean has(long flag) {
        return (this.value & flag) != 0L;
    }

    @NotNull
    public BitFlagSet set(long flag) {
        BitFlagSet bitFlagSet;
        BitFlagSet $this$set_u24lambda_u240 = bitFlagSet = this;
        boolean bl = false;
        $this$set_u24lambda_u240.value |= flag;
        return bitFlagSet;
    }

    @NotNull
    public BitFlagSet unset(long flag) {
        BitFlagSet bitFlagSet;
        BitFlagSet $this$unset_u24lambda_u240 = bitFlagSet = this;
        boolean bl = false;
        $this$unset_u24lambda_u240.value &= flag ^ 0xFFFFFFFFFFFFFFFFL;
        return bitFlagSet;
    }
}

