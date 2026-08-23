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
 *  kotlinx.serialization.SerialName
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
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.LinkedHashMapSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import net.thebrokenscript.api.anim.AnimBone;
import net.thebrokenscript.api.anim.AnimBone$;
import net.thebrokenscript.api.anim.Animation$;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Serializable
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 -2\u00020\u0001:\u0002,-BC\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007\u0012\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007\u00a2\u0006\u0004\b\u000b\u0010\fBW\b\u0010\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007\u0012\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u00a2\u0006\u0004\b\u000b\u0010\u0011J\t\u0010\u001b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001c\u001a\u00020\u0005H\u00c6\u0003J\u0015\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007H\u00c6\u0003J\u0015\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007H\u00c6\u0003JI\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00072\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007H\u00c6\u0001J\u0013\u0010 \u001a\u00020\u00032\b\u0010!\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\"\u001a\u00020\u000eH\u00d6\u0001J\t\u0010#\u001a\u00020\bH\u00d6\u0001J%\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u00002\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0001\u00a2\u0006\u0002\b+R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u000e\n\u0000\u0012\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001d\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u001d\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019\u00a8\u0006."}, d2={"Lnet/thebrokenscript/api/anim/Animation;", "", "loop", "", "animationLength", "", "bones", "", "", "Lnet/thebrokenscript/api/anim/AnimBone;", "timeline", "<init>", "(ZFLjava/util/Map;Ljava/util/Map;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IZFLjava/util/Map;Ljava/util/Map;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getLoop", "()Z", "getAnimationLength$annotations", "()V", "getAnimationLength", "()F", "getBones", "()Ljava/util/Map;", "getTimeline", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$thebrokenscript_common", "$serializer", "Companion", "thebrokenscript-common"})
public final class Animation {
    @NotNull
    public static final Companion Companion = new Companion(null);
    private final boolean loop;
    private final float animationLength;
    @NotNull
    private final Map<String, AnimBone> bones;
    @NotNull
    private final Map<String, String> timeline;
    @JvmField
    @NotNull
    private static final Lazy<KSerializer<Object>>[] $childSerializers;

    public Animation(boolean loop, float animationLength, @NotNull Map<String, AnimBone> bones, @NotNull Map<String, String> timeline) {
        Intrinsics.checkNotNullParameter(bones, (String)"bones");
        Intrinsics.checkNotNullParameter(timeline, (String)"timeline");
        this.loop = loop;
        this.animationLength = animationLength;
        this.bones = bones;
        this.timeline = timeline;
    }

    public /* synthetic */ Animation(boolean bl, float f, Map map, Map map2, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 4) != 0) {
            map = new LinkedHashMap();
        }
        if ((n & 8) != 0) {
            map2 = new LinkedHashMap();
        }
        this(bl, f, map, map2);
    }

    public final boolean getLoop() {
        return this.loop;
    }

    public final float getAnimationLength() {
        return this.animationLength;
    }

    @SerialName(value="animation_length")
    public static /* synthetic */ void getAnimationLength$annotations() {
    }

    @NotNull
    public final Map<String, AnimBone> getBones() {
        return this.bones;
    }

    @NotNull
    public final Map<String, String> getTimeline() {
        return this.timeline;
    }

    public final boolean component1() {
        return this.loop;
    }

    public final float component2() {
        return this.animationLength;
    }

    @NotNull
    public final Map<String, AnimBone> component3() {
        return this.bones;
    }

    @NotNull
    public final Map<String, String> component4() {
        return this.timeline;
    }

    @NotNull
    public final Animation copy(boolean loop, float animationLength, @NotNull Map<String, AnimBone> bones, @NotNull Map<String, String> timeline) {
        Intrinsics.checkNotNullParameter(bones, (String)"bones");
        Intrinsics.checkNotNullParameter(timeline, (String)"timeline");
        return new Animation(loop, animationLength, bones, timeline);
    }

    public static /* synthetic */ Animation copy$default(Animation animation, boolean bl, float f, Map map, Map map2, int n, Object object) {
        if ((n & 1) != 0) {
            bl = animation.loop;
        }
        if ((n & 2) != 0) {
            f = animation.animationLength;
        }
        if ((n & 4) != 0) {
            map = animation.bones;
        }
        if ((n & 8) != 0) {
            map2 = animation.timeline;
        }
        return animation.copy(bl, f, map, map2);
    }

    @NotNull
    public String toString() {
        return "Animation(loop=" + this.loop + ", animationLength=" + this.animationLength + ", bones=" + this.bones + ", timeline=" + this.timeline + ")";
    }

    public int hashCode() {
        int result = Boolean.hashCode(this.loop);
        result = result * 31 + Float.hashCode(this.animationLength);
        result = result * 31 + ((Object)this.bones).hashCode();
        result = result * 31 + ((Object)this.timeline).hashCode();
        return result;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Animation)) {
            return false;
        }
        Animation animation = (Animation)other;
        if (this.loop != animation.loop) {
            return false;
        }
        if (Float.compare(this.animationLength, animation.animationLength) != 0) {
            return false;
        }
        if (!Intrinsics.areEqual(this.bones, animation.bones)) {
            return false;
        }
        return Intrinsics.areEqual(this.timeline, animation.timeline);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$thebrokenscript_common(Animation self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Lazy<KSerializer<Object>>[] lazyArray = $childSerializers;
        output.encodeBooleanElement(serialDesc, 0, self.loop);
        output.encodeFloatElement(serialDesc, 1, self.animationLength);
        if (output.shouldEncodeElementDefault(serialDesc, 2) ? true : !Intrinsics.areEqual(self.bones, (Object)new LinkedHashMap())) {
            output.encodeSerializableElement(serialDesc, 2, (SerializationStrategy)lazyArray[2].getValue(), self.bones);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) ? true : !Intrinsics.areEqual(self.timeline, (Object)new LinkedHashMap())) {
            output.encodeSerializableElement(serialDesc, 3, (SerializationStrategy)lazyArray[3].getValue(), self.timeline);
        }
    }

    public /* synthetic */ Animation(int seen0, boolean loop, float animationLength, Map bones, Map timeline, SerializationConstructorMarker serializationConstructorMarker) {
        if (3 != (3 & seen0)) {
            PluginExceptionsKt.throwMissingFieldException((int)seen0, (int)3, (SerialDescriptor)$serializer.INSTANCE.getDescriptor());
        }
        this.loop = loop;
        this.animationLength = animationLength;
        this.bones = (seen0 & 4) == 0 ? (Map)new LinkedHashMap() : bones;
        this.timeline = (seen0 & 8) == 0 ? (Map)new LinkedHashMap() : timeline;
    }

    public static final /* synthetic */ Lazy[] access$get$childSerializers$cp() {
        return $childSerializers;
    }

    static {
        Lazy[] lazyArray = new Lazy[]{null, null, LazyKt.lazy((LazyThreadSafetyMode)LazyThreadSafetyMode.PUBLICATION, () -> (KSerializer)new LinkedHashMapSerializer((KSerializer)StringSerializer.INSTANCE, (KSerializer)AnimBone$.serializer.INSTANCE)), LazyKt.lazy((LazyThreadSafetyMode)LazyThreadSafetyMode.PUBLICATION, () -> (KSerializer)new LinkedHashMapSerializer((KSerializer)StringSerializer.INSTANCE, (KSerializer)StringSerializer.INSTANCE))};
        $childSerializers = lazyArray;
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a8\u0006\u0007"}, d2={"Lnet/thebrokenscript/api/anim/Animation$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lnet/thebrokenscript/api/anim/Animation;", "thebrokenscript-common"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final KSerializer<Animation> serializer() {
            return (KSerializer)$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

