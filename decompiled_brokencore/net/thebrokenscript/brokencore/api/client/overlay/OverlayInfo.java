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
 */
package net.thebrokenscript.brokencore.api.client.overlay;

import io.wispforest.endec.Endec;
import io.wispforest.endec.StructEndec;
import io.wispforest.endec.impl.StructEndecBuilder;
import io.wispforest.endec.impl.StructField;
import io.wispforest.owo.serialization.endec.MinecraftEndecs;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty1;
import net.minecraft.resources.ResourceLocation;
import net.thebrokenscript.brokencore.api.client.overlay.OverlayInfo;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\b\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\r"}, d2={"Lnet/thebrokenscript/brokencore/api/client/overlay/OverlayInfo;", "", "texture", "Lnet/minecraft/resources/ResourceLocation;", "duration", "", "<init>", "(Lnet/minecraft/resources/ResourceLocation;J)V", "getTexture", "()Lnet/minecraft/resources/ResourceLocation;", "getDuration", "()J", "Companion", "brokencore-common"})
public final class OverlayInfo {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final ResourceLocation texture;
    private final long duration;
    @NotNull
    private static final Endec<OverlayInfo> ENDEC;

    public OverlayInfo(@NotNull ResourceLocation texture, long duration2) {
        Intrinsics.checkNotNullParameter((Object)texture, (String)"texture");
        this.texture = texture;
        this.duration = duration2;
    }

    @NotNull
    public final ResourceLocation getTexture() {
        return this.texture;
    }

    public final long getDuration() {
        return this.duration;
    }

    private static final ResourceLocation ENDEC$lambda$0(KProperty1 $tmp0, OverlayInfo p0) {
        return (ResourceLocation)((Function1)$tmp0).invoke((Object)p0);
    }

    private static final Long ENDEC$lambda$1(KProperty1 $tmp0, OverlayInfo p0) {
        return (Long)((Function1)$tmp0).invoke((Object)p0);
    }

    static {
        StructEndec structEndec = StructEndecBuilder.of((StructField)MinecraftEndecs.IDENTIFIER.fieldOf("texture", arg_0 -> OverlayInfo.ENDEC$lambda$0((KProperty1)Companion.ENDEC.1.INSTANCE, arg_0)), (StructField)Endec.LONG.fieldOf("duration", arg_0 -> OverlayInfo.ENDEC$lambda$1((KProperty1)Companion.ENDEC.2.INSTANCE, arg_0)), OverlayInfo::new);
        Intrinsics.checkNotNullExpressionValue((Object)structEndec, (String)"of(...)");
        ENDEC = (Endec)structEndec;
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\t"}, d2={"Lnet/thebrokenscript/brokencore/api/client/overlay/OverlayInfo$Companion;", "", "<init>", "()V", "ENDEC", "Lio/wispforest/endec/Endec;", "Lnet/thebrokenscript/brokencore/api/client/overlay/OverlayInfo;", "getENDEC", "()Lio/wispforest/endec/Endec;", "brokencore-common"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final Endec<OverlayInfo> getENDEC() {
            return ENDEC;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

