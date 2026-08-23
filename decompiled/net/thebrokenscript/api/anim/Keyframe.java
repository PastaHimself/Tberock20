/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlinx.serialization.KSerializer
 *  kotlinx.serialization.SerialName
 *  kotlinx.serialization.Serializable
 *  kotlinx.serialization.SerializationStrategy
 *  kotlinx.serialization.descriptors.SerialDescriptor
 *  kotlinx.serialization.encoding.CompositeEncoder
 *  kotlinx.serialization.internal.PluginExceptionsKt
 *  kotlinx.serialization.internal.SerializationConstructorMarker
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.api.anim;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import net.thebrokenscript.api.anim.Keyframe$;
import net.thebrokenscript.api.anim.KeyframeInfo;
import net.thebrokenscript.api.anim.KeyframeInfo$;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Serializable
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 $2\u00020\u0001:\u0002#$B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007B/\b\u0010\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u00a2\u0006\u0004\b\u0006\u0010\fJ\t\u0010\u0013\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0014\u001a\u00020\u0005H\u00c6\u0003J\u001d\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0019\u001a\u00020\tH\u00d6\u0001J\t\u0010\u001a\u001a\u00020\u0005H\u00d6\u0001J%\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0001\u00a2\u0006\u0002\b\"R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u000e\n\u0000\u0012\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006%"}, d2={"Lnet/thebrokenscript/api/anim/Keyframe;", "", "post", "Lnet/thebrokenscript/api/anim/KeyframeInfo;", "lerpMode", "", "<init>", "(Lnet/thebrokenscript/api/anim/KeyframeInfo;Ljava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILnet/thebrokenscript/api/anim/KeyframeInfo;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getPost", "()Lnet/thebrokenscript/api/anim/KeyframeInfo;", "getLerpMode$annotations", "()V", "getLerpMode", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$thebrokenscript_common", "$serializer", "Companion", "thebrokenscript-common"})
public final class Keyframe {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final KeyframeInfo post;
    @NotNull
    private final String lerpMode;

    public Keyframe(@NotNull KeyframeInfo post, @NotNull String lerpMode) {
        Intrinsics.checkNotNullParameter((Object)post, (String)"post");
        Intrinsics.checkNotNullParameter((Object)lerpMode, (String)"lerpMode");
        this.post = post;
        this.lerpMode = lerpMode;
    }

    @NotNull
    public final KeyframeInfo getPost() {
        return this.post;
    }

    @NotNull
    public final String getLerpMode() {
        return this.lerpMode;
    }

    @SerialName(value="lerp_mode")
    public static /* synthetic */ void getLerpMode$annotations() {
    }

    @NotNull
    public final KeyframeInfo component1() {
        return this.post;
    }

    @NotNull
    public final String component2() {
        return this.lerpMode;
    }

    @NotNull
    public final Keyframe copy(@NotNull KeyframeInfo post, @NotNull String lerpMode) {
        Intrinsics.checkNotNullParameter((Object)post, (String)"post");
        Intrinsics.checkNotNullParameter((Object)lerpMode, (String)"lerpMode");
        return new Keyframe(post, lerpMode);
    }

    public static /* synthetic */ Keyframe copy$default(Keyframe keyframe, KeyframeInfo keyframeInfo, String string, int n, Object object) {
        if ((n & 1) != 0) {
            keyframeInfo = keyframe.post;
        }
        if ((n & 2) != 0) {
            string = keyframe.lerpMode;
        }
        return keyframe.copy(keyframeInfo, string);
    }

    @NotNull
    public String toString() {
        return "Keyframe(post=" + this.post + ", lerpMode=" + this.lerpMode + ")";
    }

    public int hashCode() {
        int result = this.post.hashCode();
        result = result * 31 + this.lerpMode.hashCode();
        return result;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Keyframe)) {
            return false;
        }
        Keyframe keyframe = (Keyframe)other;
        if (!Intrinsics.areEqual((Object)this.post, (Object)keyframe.post)) {
            return false;
        }
        return Intrinsics.areEqual((Object)this.lerpMode, (Object)keyframe.lerpMode);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$thebrokenscript_common(Keyframe self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeSerializableElement(serialDesc, 0, (SerializationStrategy)KeyframeInfo$.serializer.INSTANCE, (Object)self.post);
        output.encodeStringElement(serialDesc, 1, self.lerpMode);
    }

    public /* synthetic */ Keyframe(int seen0, KeyframeInfo post, String lerpMode, SerializationConstructorMarker serializationConstructorMarker) {
        if (3 != (3 & seen0)) {
            PluginExceptionsKt.throwMissingFieldException((int)seen0, (int)3, (SerialDescriptor)$serializer.INSTANCE.getDescriptor());
        }
        this.post = post;
        this.lerpMode = lerpMode;
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a8\u0006\u0007"}, d2={"Lnet/thebrokenscript/api/anim/Keyframe$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lnet/thebrokenscript/api/anim/Keyframe;", "thebrokenscript-common"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final KSerializer<Keyframe> serializer() {
            return (KSerializer)$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

