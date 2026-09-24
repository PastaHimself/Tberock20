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
 *  kotlin.reflect.KMutableProperty1
 *  org.jetbrains.annotations.NotNull
 *  org.joml.Vector3f
 */
package net.thebrokenscript.client.tentacles;

import io.wispforest.endec.Endec;
import io.wispforest.endec.StructEndec;
import io.wispforest.endec.impl.StructEndecBuilder;
import io.wispforest.endec.impl.StructField;
import io.wispforest.owo.serialization.endec.MinecraftEndecs;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KMutableProperty1;
import net.thebrokenscript.client.tentacles.TentacleInfo;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector3f;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0018\u0018\u0000  2\u00020\u0001:\u0001 BC\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0006\u0010\u001f\u001a\u00020\u0000R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000e\"\u0004\b\u0012\u0010\u0010R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000e\"\u0004\b\u0014\u0010\u0010R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\n\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0016\"\u0004\b\u001e\u0010\u0018\u00a8\u0006!"}, d2={"Lnet/thebrokenscript/client/tentacles/TentacleInfo;", "", "start", "Lorg/joml/Vector3f;", "end", "rotator", "resolution", "", "sideRes", "", "size", "<init>", "(Lorg/joml/Vector3f;Lorg/joml/Vector3f;Lorg/joml/Vector3f;FIF)V", "getStart", "()Lorg/joml/Vector3f;", "setStart", "(Lorg/joml/Vector3f;)V", "getEnd", "setEnd", "getRotator", "setRotator", "getResolution", "()F", "setResolution", "(F)V", "getSideRes", "()I", "setSideRes", "(I)V", "getSize", "setSize", "copy", "Companion", "thebrokenscript-common"})
public final class TentacleInfo {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private Vector3f start;
    @NotNull
    private Vector3f end;
    @NotNull
    private Vector3f rotator;
    private float resolution;
    private int sideRes;
    private float size;
    @NotNull
    private static final Endec<TentacleInfo> ENDEC;

    public TentacleInfo(@NotNull Vector3f start, @NotNull Vector3f end, @NotNull Vector3f rotator, float resolution, int sideRes, float size) {
        Intrinsics.checkNotNullParameter((Object)start, (String)"start");
        Intrinsics.checkNotNullParameter((Object)end, (String)"end");
        Intrinsics.checkNotNullParameter((Object)rotator, (String)"rotator");
        this.start = start;
        this.end = end;
        this.rotator = rotator;
        this.resolution = resolution;
        this.sideRes = sideRes;
        this.size = size;
    }

    public /* synthetic */ TentacleInfo(Vector3f vector3f, Vector3f vector3f2, Vector3f vector3f3, float f, int n, float f2, int n2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n2 & 1) != 0) {
            vector3f = new Vector3f();
        }
        if ((n2 & 2) != 0) {
            vector3f2 = new Vector3f();
        }
        if ((n2 & 4) != 0) {
            vector3f3 = new Vector3f(0.0f, 1.0f, 0.0f);
        }
        if ((n2 & 8) != 0) {
            f = 2.0f;
        }
        if ((n2 & 0x10) != 0) {
            n = 16;
        }
        if ((n2 & 0x20) != 0) {
            f2 = 4.0f;
        }
        this(vector3f, vector3f2, vector3f3, f, n, f2);
    }

    @NotNull
    public final Vector3f getStart() {
        return this.start;
    }

    public final void setStart(@NotNull Vector3f vector3f) {
        Intrinsics.checkNotNullParameter((Object)vector3f, (String)"<set-?>");
        this.start = vector3f;
    }

    @NotNull
    public final Vector3f getEnd() {
        return this.end;
    }

    public final void setEnd(@NotNull Vector3f vector3f) {
        Intrinsics.checkNotNullParameter((Object)vector3f, (String)"<set-?>");
        this.end = vector3f;
    }

    @NotNull
    public final Vector3f getRotator() {
        return this.rotator;
    }

    public final void setRotator(@NotNull Vector3f vector3f) {
        Intrinsics.checkNotNullParameter((Object)vector3f, (String)"<set-?>");
        this.rotator = vector3f;
    }

    public final float getResolution() {
        return this.resolution;
    }

    public final void setResolution(float f) {
        this.resolution = f;
    }

    public final int getSideRes() {
        return this.sideRes;
    }

    public final void setSideRes(int n) {
        this.sideRes = n;
    }

    public final float getSize() {
        return this.size;
    }

    public final void setSize(float f) {
        this.size = f;
    }

    @NotNull
    public final TentacleInfo copy() {
        Vector3f vector3f = this.start.get(new Vector3f());
        Intrinsics.checkNotNullExpressionValue((Object)vector3f, (String)"get(...)");
        Vector3f vector3f2 = this.end.get(new Vector3f());
        Intrinsics.checkNotNullExpressionValue((Object)vector3f2, (String)"get(...)");
        Vector3f vector3f3 = this.rotator.get(new Vector3f());
        Intrinsics.checkNotNullExpressionValue((Object)vector3f3, (String)"get(...)");
        return new TentacleInfo(vector3f, vector3f2, vector3f3, this.resolution, this.sideRes, this.size);
    }

    private static final Vector3f ENDEC$lambda$0(KMutableProperty1 $tmp0, TentacleInfo p0) {
        return (Vector3f)((Function1)$tmp0).invoke((Object)p0);
    }

    private static final Vector3f ENDEC$lambda$1(KMutableProperty1 $tmp0, TentacleInfo p0) {
        return (Vector3f)((Function1)$tmp0).invoke((Object)p0);
    }

    private static final Vector3f ENDEC$lambda$2(KMutableProperty1 $tmp0, TentacleInfo p0) {
        return (Vector3f)((Function1)$tmp0).invoke((Object)p0);
    }

    private static final Float ENDEC$lambda$3(KMutableProperty1 $tmp0, TentacleInfo p0) {
        return (Float)((Function1)$tmp0).invoke((Object)p0);
    }

    private static final Integer ENDEC$lambda$4(KMutableProperty1 $tmp0, TentacleInfo p0) {
        return (Integer)((Function1)$tmp0).invoke((Object)p0);
    }

    private static final Float ENDEC$lambda$5(KMutableProperty1 $tmp0, TentacleInfo p0) {
        return (Float)((Function1)$tmp0).invoke((Object)p0);
    }

    public TentacleInfo() {
        this(null, null, null, 0.0f, 0, 0.0f, 63, null);
    }

    static {
        StructEndec structEndec = StructEndecBuilder.of((StructField)MinecraftEndecs.VECTOR3F.fieldOf("start", arg_0 -> TentacleInfo.ENDEC$lambda$0((KMutableProperty1)Companion.ENDEC.1.INSTANCE, arg_0)), (StructField)MinecraftEndecs.VECTOR3F.fieldOf("end", arg_0 -> TentacleInfo.ENDEC$lambda$1((KMutableProperty1)Companion.ENDEC.2.INSTANCE, arg_0)), (StructField)MinecraftEndecs.VECTOR3F.fieldOf("rotator", arg_0 -> TentacleInfo.ENDEC$lambda$2((KMutableProperty1)Companion.ENDEC.3.INSTANCE, arg_0)), (StructField)Endec.FLOAT.fieldOf("resolution", arg_0 -> TentacleInfo.ENDEC$lambda$3((KMutableProperty1)Companion.ENDEC.4.INSTANCE, arg_0)), (StructField)Endec.INT.fieldOf("sideRes", arg_0 -> TentacleInfo.ENDEC$lambda$4((KMutableProperty1)Companion.ENDEC.5.INSTANCE, arg_0)), (StructField)Endec.FLOAT.fieldOf("size", arg_0 -> TentacleInfo.ENDEC$lambda$5((KMutableProperty1)Companion.ENDEC.6.INSTANCE, arg_0)), TentacleInfo::new);
        Intrinsics.checkNotNullExpressionValue((Object)structEndec, (String)"of(...)");
        ENDEC = (Endec)structEndec;
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\t"}, d2={"Lnet/thebrokenscript/client/tentacles/TentacleInfo$Companion;", "", "<init>", "()V", "ENDEC", "Lio/wispforest/endec/Endec;", "Lnet/thebrokenscript/client/tentacles/TentacleInfo;", "getENDEC", "()Lio/wispforest/endec/Endec;", "thebrokenscript-common"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final Endec<TentacleInfo> getENDEC() {
            return ENDEC;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

