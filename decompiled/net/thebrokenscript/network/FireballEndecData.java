/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.wispforest.endec.Endec
 *  io.wispforest.endec.StructEndec
 *  io.wispforest.endec.impl.StructEndecBuilder
 *  io.wispforest.endec.impl.StructField
 *  kotlin.Metadata
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.reflect.KProperty1
 *  net.thebrokenscript.brokencore.api.util.serde.ExtraEndecs
 *  org.jetbrains.annotations.NotNull
 *  org.joml.Vector3d
 */
package net.thebrokenscript.network;

import io.wispforest.endec.Endec;
import io.wispforest.endec.StructEndec;
import io.wispforest.endec.impl.StructEndecBuilder;
import io.wispforest.endec.impl.StructField;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty1;
import net.thebrokenscript.brokencore.api.util.serde.ExtraEndecs;
import net.thebrokenscript.network.FireballEndecData;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector3d;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\r"}, d2={"Lnet/thebrokenscript/network/FireballEndecData;", "", "integ", "", "startPos", "Lorg/joml/Vector3d;", "<init>", "(ILorg/joml/Vector3d;)V", "getInteg", "()I", "getStartPos", "()Lorg/joml/Vector3d;", "Companion", "thebrokenscript-common"})
public final class FireballEndecData {
    @NotNull
    public static final Companion Companion = new Companion(null);
    private final int integ;
    @NotNull
    private final Vector3d startPos;
    @NotNull
    private static final Endec<FireballEndecData> ENDEC;

    public FireballEndecData(int integ, @NotNull Vector3d startPos) {
        Intrinsics.checkNotNullParameter((Object)startPos, (String)"startPos");
        this.integ = integ;
        this.startPos = startPos;
    }

    public final int getInteg() {
        return this.integ;
    }

    @NotNull
    public final Vector3d getStartPos() {
        return this.startPos;
    }

    private static final Integer ENDEC$lambda$0(KProperty1 $tmp0, FireballEndecData p0) {
        return (Integer)((Function1)$tmp0).invoke((Object)p0);
    }

    private static final Vector3d ENDEC$lambda$1(KProperty1 $tmp0, FireballEndecData p0) {
        return (Vector3d)((Function1)$tmp0).invoke((Object)p0);
    }

    static {
        StructEndec structEndec = StructEndecBuilder.of((StructField)Endec.INT.fieldOf("integ", arg_0 -> FireballEndecData.ENDEC$lambda$0((KProperty1)Companion.ENDEC.1.INSTANCE, arg_0)), (StructField)ExtraEndecs.VECTOR3D.fieldOf("startPos", arg_0 -> FireballEndecData.ENDEC$lambda$1((KProperty1)Companion.ENDEC.2.INSTANCE, arg_0)), FireballEndecData::new);
        Intrinsics.checkNotNullExpressionValue((Object)structEndec, (String)"of(...)");
        ENDEC = (Endec)structEndec;
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\t"}, d2={"Lnet/thebrokenscript/network/FireballEndecData$Companion;", "", "<init>", "()V", "ENDEC", "Lio/wispforest/endec/Endec;", "Lnet/thebrokenscript/network/FireballEndecData;", "getENDEC", "()Lio/wispforest/endec/Endec;", "thebrokenscript-common"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final Endec<FireballEndecData> getENDEC() {
            return ENDEC;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

