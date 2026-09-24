/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Lazy
 *  kotlin.LazyKt
 *  kotlin.LazyThreadSafetyMode
 *  kotlin.Metadata
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlinx.serialization.KSerializer
 *  kotlinx.serialization.Serializable
 *  kotlinx.serialization.SerializationStrategy
 *  kotlinx.serialization.descriptors.SerialDescriptor
 *  kotlinx.serialization.encoding.CompositeEncoder
 *  kotlinx.serialization.internal.LinkedHashMapSerializer
 *  kotlinx.serialization.internal.PluginExceptionsKt
 *  kotlinx.serialization.internal.SerializationConstructorMarker
 *  kotlinx.serialization.internal.StringSerializer
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.api.anim;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.LinkedHashMapSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import net.thebrokenscript.api.anim.AnimBone$;
import net.thebrokenscript.api.anim.Keyframe;
import net.thebrokenscript.api.anim.Keyframe$;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Serializable
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \"2\u00020\u0001:\u0002!\"B3\u0012\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u00a2\u0006\u0004\b\u0007\u0010\bBG\b\u0010\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0014\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003\u0012\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u00a2\u0006\u0004\b\u0007\u0010\rJ\u0015\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u00c6\u0003J\u0015\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u00c6\u0003J5\u0010\u0013\u001a\u00020\u00002\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u00c6\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0017\u001a\u00020\nH\u00d6\u0001J\t\u0010\u0018\u001a\u00020\u0004H\u00d6\u0001J%\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0001\u00a2\u0006\u0002\b R\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000f\u00a8\u0006#"}, d2={"Lnet/thebrokenscript/api/anim/AnimBone;", "", "rotation", "", "", "Lnet/thebrokenscript/api/anim/Keyframe;", "position", "<init>", "(Ljava/util/Map;Ljava/util/Map;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/util/Map;Ljava/util/Map;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getRotation", "()Ljava/util/Map;", "getPosition", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$thebrokenscript_common", "$serializer", "Companion", "thebrokenscript-common"})
public final class AnimBone {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final Map<String, Keyframe> rotation;
    @NotNull
    private final Map<String, Keyframe> position;
    @JvmField
    @NotNull
    private static final Lazy<KSerializer<Object>>[] $childSerializers;

    public AnimBone(@NotNull Map<String, Keyframe> rotation, @NotNull Map<String, Keyframe> position) {
        Intrinsics.checkNotNullParameter(rotation, (String)"rotation");
        Intrinsics.checkNotNullParameter(position, (String)"position");
        this.rotation = rotation;
        this.position = position;
    }

    public /* synthetic */ AnimBone(Map map, Map map2, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 1) != 0) {
            map = new LinkedHashMap();
        }
        if ((n & 2) != 0) {
            map2 = new LinkedHashMap();
        }
        this(map, map2);
    }

    @NotNull
    public final Map<String, Keyframe> getRotation() {
        return this.rotation;
    }

    @NotNull
    public final Map<String, Keyframe> getPosition() {
        return this.position;
    }

    @NotNull
    public final Map<String, Keyframe> component1() {
        return this.rotation;
    }

    @NotNull
    public final Map<String, Keyframe> component2() {
        return this.position;
    }

    @NotNull
    public final AnimBone copy(@NotNull Map<String, Keyframe> rotation, @NotNull Map<String, Keyframe> position) {
        Intrinsics.checkNotNullParameter(rotation, (String)"rotation");
        Intrinsics.checkNotNullParameter(position, (String)"position");
        return new AnimBone(rotation, position);
    }

    public static /* synthetic */ AnimBone copy$default(AnimBone animBone, Map map, Map map2, int n, Object object) {
        if ((n & 1) != 0) {
            map = animBone.rotation;
        }
        if ((n & 2) != 0) {
            map2 = animBone.position;
        }
        return animBone.copy(map, map2);
    }

    @NotNull
    public String toString() {
        return "AnimBone(rotation=" + this.rotation + ", position=" + this.position + ")";
    }

    public int hashCode() {
        int result = ((Object)this.rotation).hashCode();
        result = result * 31 + ((Object)this.position).hashCode();
        return result;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AnimBone)) {
            return false;
        }
        AnimBone animBone = (AnimBone)other;
        if (!Intrinsics.areEqual(this.rotation, animBone.rotation)) {
            return false;
        }
        return Intrinsics.areEqual(this.position, animBone.position);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$thebrokenscript_common(AnimBone self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Lazy<KSerializer<Object>>[] lazyArray = $childSerializers;
        if (output.shouldEncodeElementDefault(serialDesc, 0) ? true : !Intrinsics.areEqual(self.rotation, (Object)new LinkedHashMap())) {
            output.encodeSerializableElement(serialDesc, 0, (SerializationStrategy)lazyArray[0].getValue(), self.rotation);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) ? true : !Intrinsics.areEqual(self.position, (Object)new LinkedHashMap())) {
            output.encodeSerializableElement(serialDesc, 1, (SerializationStrategy)lazyArray[1].getValue(), self.position);
        }
    }

    public /* synthetic */ AnimBone(int seen0, Map rotation, Map position, SerializationConstructorMarker serializationConstructorMarker) {
        if ((0 & seen0) != 0) {
            PluginExceptionsKt.throwMissingFieldException((int)seen0, (int)0, (SerialDescriptor)$serializer.INSTANCE.getDescriptor());
        }
        this.rotation = (seen0 & 1) == 0 ? (Map)new LinkedHashMap() : rotation;
        this.position = (seen0 & 2) == 0 ? (Map)new LinkedHashMap() : position;
    }

    public AnimBone() {
        this(null, null, 3, null);
    }

    public static final /* synthetic */ Lazy[] access$get$childSerializers$cp() {
        return $childSerializers;
    }

    static {
        Lazy[] lazyArray = new Lazy[]{LazyKt.lazy((LazyThreadSafetyMode)LazyThreadSafetyMode.PUBLICATION, () -> (KSerializer)new LinkedHashMapSerializer((KSerializer)StringSerializer.INSTANCE, (KSerializer)Keyframe$.serializer.INSTANCE)), LazyKt.lazy((LazyThreadSafetyMode)LazyThreadSafetyMode.PUBLICATION, () -> (KSerializer)new LinkedHashMapSerializer((KSerializer)StringSerializer.INSTANCE, (KSerializer)Keyframe$.serializer.INSTANCE))};
        $childSerializers = lazyArray;
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a8\u0006\u0007"}, d2={"Lnet/thebrokenscript/api/anim/AnimBone$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lnet/thebrokenscript/api/anim/AnimBone;", "thebrokenscript-common"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final KSerializer<AnimBone> serializer() {
            return (KSerializer)$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

