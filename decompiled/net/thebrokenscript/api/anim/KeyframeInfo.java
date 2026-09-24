/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlinx.serialization.KSerializer
 *  kotlinx.serialization.Serializable
 *  kotlinx.serialization.SerializationStrategy
 *  kotlinx.serialization.descriptors.SerialDescriptor
 *  kotlinx.serialization.encoding.CompositeEncoder
 *  kotlinx.serialization.internal.FloatArraySerializer
 *  kotlinx.serialization.internal.PluginExceptionsKt
 *  kotlinx.serialization.internal.SerializationConstructorMarker
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.api.anim;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.FloatArraySerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import net.thebrokenscript.api.anim.KeyframeInfo$;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Serializable
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u001e2\u00020\u0001:\u0002\u001d\u001eB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005B%\b\u0010\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u00a2\u0006\u0004\b\u0004\u0010\nJ\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0010\u001a\u00020\u0007H\u0016J\t\u0010\u0011\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\t\u0010\u0013\u001a\u00020\u0014H\u00d6\u0001J%\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0001\u00a2\u0006\u0002\b\u001cR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u001f"}, d2={"Lnet/thebrokenscript/api/anim/KeyframeInfo;", "", "vector", "", "<init>", "([F)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(I[FLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getVector", "()[F", "equals", "", "other", "hashCode", "component1", "copy", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$thebrokenscript_common", "$serializer", "Companion", "thebrokenscript-common"})
public final class KeyframeInfo {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final float[] vector;

    public KeyframeInfo(@NotNull float[] vector) {
        Intrinsics.checkNotNullParameter((Object)vector, (String)"vector");
        this.vector = vector;
    }

    @NotNull
    public final float[] getVector() {
        return this.vector;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        Object object = other;
        if (!Intrinsics.areEqual(this.getClass(), object != null ? object.getClass() : null)) {
            return false;
        }
        Object object2 = other;
        Intrinsics.checkNotNull((Object)object2, (String)"null cannot be cast to non-null type net.thebrokenscript.api.anim.KeyframeInfo");
        KeyframeInfo cfr_ignored_0 = (KeyframeInfo)object2;
        return Arrays.equals(this.vector, ((KeyframeInfo)other).vector);
    }

    public int hashCode() {
        return Arrays.hashCode(this.vector);
    }

    @NotNull
    public final float[] component1() {
        return this.vector;
    }

    @NotNull
    public final KeyframeInfo copy(@NotNull float[] vector) {
        Intrinsics.checkNotNullParameter((Object)vector, (String)"vector");
        return new KeyframeInfo(vector);
    }

    public static /* synthetic */ KeyframeInfo copy$default(KeyframeInfo keyframeInfo, float[] fArray, int n, Object object) {
        if ((n & 1) != 0) {
            fArray = keyframeInfo.vector;
        }
        return keyframeInfo.copy(fArray);
    }

    @NotNull
    public String toString() {
        return "KeyframeInfo(vector=" + Arrays.toString(this.vector) + ")";
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$thebrokenscript_common(KeyframeInfo self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeSerializableElement(serialDesc, 0, (SerializationStrategy)FloatArraySerializer.INSTANCE, (Object)self.vector);
    }

    public /* synthetic */ KeyframeInfo(int seen0, float[] vector, SerializationConstructorMarker serializationConstructorMarker) {
        if (1 != (1 & seen0)) {
            PluginExceptionsKt.throwMissingFieldException((int)seen0, (int)1, (SerialDescriptor)$serializer.INSTANCE.getDescriptor());
        }
        this.vector = vector;
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a8\u0006\u0007"}, d2={"Lnet/thebrokenscript/api/anim/KeyframeInfo$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lnet/thebrokenscript/api/anim/KeyframeInfo;", "thebrokenscript-common"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final KSerializer<KeyframeInfo> serializer() {
            return (KSerializer)$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

