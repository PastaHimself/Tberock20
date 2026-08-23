/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.wispforest.endec.Endec
 *  io.wispforest.endec.StructEndec
 *  io.wispforest.endec.impl.StructEndecBuilder
 *  io.wispforest.endec.impl.StructField
 *  io.wispforest.owo.serialization.endec.MinecraftEndecs
 *  kotlin.Metadata
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.reflect.KProperty1
 *  net.minecraft.resources.ResourceLocation
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.brokencore.api.client.overlay;

import io.wispforest.endec.Endec;
import io.wispforest.endec.StructEndec;
import io.wispforest.endec.impl.StructEndecBuilder;
import io.wispforest.endec.impl.StructField;
import io.wispforest.owo.serialization.endec.MinecraftEndecs;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty1;
import net.minecraft.resources.ResourceLocation;
import net.thebrokenscript.brokencore.api.client.overlay.OverlayQueueInfo;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000f\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0010\u001a\u00020\u0005H\u00c6\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0015\u001a\u00020\u0016H\u00d6\u0001J\t\u0010\u0017\u001a\u00020\u0018H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f\u00a8\u0006\u001a"}, d2={"Lnet/thebrokenscript/brokencore/api/client/overlay/OverlayQueueInfo;", "", "texture", "Lnet/minecraft/resources/ResourceLocation;", "duration", "", "delay", "<init>", "(Lnet/minecraft/resources/ResourceLocation;JJ)V", "getTexture", "()Lnet/minecraft/resources/ResourceLocation;", "getDuration", "()J", "getDelay", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Companion", "brokencore-common"})
public final class OverlayQueueInfo {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final ResourceLocation texture;
    private final long duration;
    private final long delay;
    @NotNull
    private static final Endec<OverlayQueueInfo> ENDEC;
    @NotNull
    private static final Endec<List<OverlayQueueInfo>> LIST_ENDEC;

    public OverlayQueueInfo(@NotNull ResourceLocation texture, long duration2, long delay) {
        Intrinsics.checkNotNullParameter((Object)texture, (String)"texture");
        this.texture = texture;
        this.duration = duration2;
        this.delay = delay;
    }

    @NotNull
    public final ResourceLocation getTexture() {
        return this.texture;
    }

    public final long getDuration() {
        return this.duration;
    }

    public final long getDelay() {
        return this.delay;
    }

    @NotNull
    public final ResourceLocation component1() {
        return this.texture;
    }

    public final long component2() {
        return this.duration;
    }

    public final long component3() {
        return this.delay;
    }

    @NotNull
    public final OverlayQueueInfo copy(@NotNull ResourceLocation texture, long duration2, long delay) {
        Intrinsics.checkNotNullParameter((Object)texture, (String)"texture");
        return new OverlayQueueInfo(texture, duration2, delay);
    }

    public static /* synthetic */ OverlayQueueInfo copy$default(OverlayQueueInfo overlayQueueInfo, ResourceLocation resourceLocation, long l, long l2, int n, Object object) {
        if ((n & 1) != 0) {
            resourceLocation = overlayQueueInfo.texture;
        }
        if ((n & 2) != 0) {
            l = overlayQueueInfo.duration;
        }
        if ((n & 4) != 0) {
            l2 = overlayQueueInfo.delay;
        }
        return overlayQueueInfo.copy(resourceLocation, l, l2);
    }

    @NotNull
    public String toString() {
        return "OverlayQueueInfo(texture=" + this.texture + ", duration=" + this.duration + ", delay=" + this.delay + ")";
    }

    public int hashCode() {
        int result = this.texture.hashCode();
        result = result * 31 + Long.hashCode(this.duration);
        result = result * 31 + Long.hashCode(this.delay);
        return result;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OverlayQueueInfo)) {
            return false;
        }
        OverlayQueueInfo overlayQueueInfo = (OverlayQueueInfo)other;
        if (!Intrinsics.areEqual((Object)this.texture, (Object)overlayQueueInfo.texture)) {
            return false;
        }
        if (this.duration != overlayQueueInfo.duration) {
            return false;
        }
        return this.delay == overlayQueueInfo.delay;
    }

    private static final ResourceLocation ENDEC$lambda$0(KProperty1 $tmp0, OverlayQueueInfo p0) {
        return (ResourceLocation)((Function1)$tmp0).invoke((Object)p0);
    }

    private static final Long ENDEC$lambda$1(KProperty1 $tmp0, OverlayQueueInfo p0) {
        return (Long)((Function1)$tmp0).invoke((Object)p0);
    }

    private static final Long ENDEC$lambda$2(KProperty1 $tmp0, OverlayQueueInfo p0) {
        return (Long)((Function1)$tmp0).invoke((Object)p0);
    }

    static {
        StructEndec structEndec = StructEndecBuilder.of((StructField)MinecraftEndecs.IDENTIFIER.fieldOf("texture", arg_0 -> OverlayQueueInfo.ENDEC$lambda$0((KProperty1)Companion.ENDEC.1.INSTANCE, arg_0)), (StructField)Endec.LONG.fieldOf("duration", arg_0 -> OverlayQueueInfo.ENDEC$lambda$1((KProperty1)Companion.ENDEC.2.INSTANCE, arg_0)), (StructField)Endec.LONG.fieldOf("delay", arg_0 -> OverlayQueueInfo.ENDEC$lambda$2((KProperty1)Companion.ENDEC.3.INSTANCE, arg_0)), OverlayQueueInfo::new);
        Intrinsics.checkNotNullExpressionValue((Object)structEndec, (String)"of(...)");
        ENDEC = (Endec)structEndec;
        Endec endec2 = ENDEC.listOf();
        Intrinsics.checkNotNullExpressionValue((Object)endec2, (String)"listOf(...)");
        LIST_ENDEC = endec2;
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001d\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\n0\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\b\u00a8\u0006\f"}, d2={"Lnet/thebrokenscript/brokencore/api/client/overlay/OverlayQueueInfo$Companion;", "", "<init>", "()V", "ENDEC", "Lio/wispforest/endec/Endec;", "Lnet/thebrokenscript/brokencore/api/client/overlay/OverlayQueueInfo;", "getENDEC", "()Lio/wispforest/endec/Endec;", "LIST_ENDEC", "", "getLIST_ENDEC", "brokencore-common"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final Endec<OverlayQueueInfo> getENDEC() {
            return ENDEC;
        }

        @NotNull
        public final Endec<List<OverlayQueueInfo>> getLIST_ENDEC() {
            return LIST_ENDEC;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

