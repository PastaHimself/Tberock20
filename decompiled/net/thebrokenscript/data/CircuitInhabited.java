/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.wispforest.endec.Endec
 *  kotlin.Metadata
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.Reflection
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.reflect.KClass
 *  net.minecraft.core.HolderLookup$Provider
 *  net.minecraft.nbt.Tag
 *  net.thebrokenscript.brokencore.api.data.NbtSerializable
 *  net.thebrokenscript.brokencore.api.ext.EndecExt
 *  net.thebrokenscript.brokencore.api.util.serde.KClassEndec
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.data;

import io.wispforest.endec.Endec;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KClass;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.Tag;
import net.thebrokenscript.brokencore.api.data.NbtSerializable;
import net.thebrokenscript.brokencore.api.ext.EndecExt;
import net.thebrokenscript.brokencore.api.util.serde.KClassEndec;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\nH\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005\u00a8\u0006\u0011"}, d2={"Lnet/thebrokenscript/data/CircuitInhabited;", "Lnet/thebrokenscript/brokencore/api/data/NbtSerializable;", "inhabited", "", "<init>", "(Z)V", "getInhabited", "()Z", "setInhabited", "serializeNbt", "Lnet/minecraft/nbt/Tag;", "provider", "Lnet/minecraft/core/HolderLookup$Provider;", "deserializeNbt", "", "tag", "Companion", "thebrokenscript-common"})
@SourceDebugExtension(value={"SMAP\nCircuitInhabited.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CircuitInhabited.kt\nnet/thebrokenscript/data/CircuitInhabited\n+ 2 KClassEndec.kt\nnet/thebrokenscript/brokencore/api/util/serde/KClassEndecKt\n*L\n1#1,24:1\n14#2:25\n*S KotlinDebug\n*F\n+ 1 CircuitInhabited.kt\nnet/thebrokenscript/data/CircuitInhabited\n*L\n21#1:25\n*E\n"})
public final class CircuitInhabited
implements NbtSerializable {
    @NotNull
    public static final Companion Companion = new Companion(null);
    private boolean inhabited;
    @JvmField
    @NotNull
    public static final KClassEndec<CircuitInhabited> ENDEC;

    public CircuitInhabited(boolean inhabited) {
        this.inhabited = inhabited;
    }

    public /* synthetic */ CircuitInhabited(boolean bl, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 1) != 0) {
            bl = false;
        }
        this(bl);
    }

    public final boolean getInhabited() {
        return this.inhabited;
    }

    public final void setInhabited(boolean bl) {
        this.inhabited = bl;
    }

    @NotNull
    public Tag serializeNbt(@NotNull HolderLookup.Provider provider2) {
        Intrinsics.checkNotNullParameter((Object)provider2, (String)"provider");
        return EndecExt.INSTANCE.encodeNbtOrThrow((Endec)ENDEC, (Object)this);
    }

    public void deserializeNbt(@NotNull HolderLookup.Provider provider2, @NotNull Tag tag) {
        Intrinsics.checkNotNullParameter((Object)provider2, (String)"provider");
        Intrinsics.checkNotNullParameter((Object)tag, (String)"tag");
        CircuitInhabited data = (CircuitInhabited)EndecExt.INSTANCE.decodeNbtOrThrow((Endec)ENDEC, tag);
        this.inhabited = data.inhabited;
    }

    public CircuitInhabited() {
        this(false, 1, null);
    }

    static {
        KClass $this$endec$iv = Reflection.getOrCreateKotlinClass(CircuitInhabited.class);
        boolean $i$f$getEndec = false;
        ENDEC = new KClassEndec($this$endec$iv);
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0007"}, d2={"Lnet/thebrokenscript/data/CircuitInhabited$Companion;", "", "<init>", "()V", "ENDEC", "Lnet/thebrokenscript/brokencore/api/util/serde/KClassEndec;", "Lnet/thebrokenscript/data/CircuitInhabited;", "thebrokenscript-common"})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

