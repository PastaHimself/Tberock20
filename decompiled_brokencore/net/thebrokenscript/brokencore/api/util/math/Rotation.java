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
 *  kotlin.reflect.KMutableProperty1
 *  net.minecraft.world.entity.Entity
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.util.math;

import io.wispforest.endec.Endec;
import io.wispforest.endec.StructEndec;
import io.wispforest.endec.impl.StructEndecBuilder;
import io.wispforest.endec.impl.StructField;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KMutableProperty1;
import net.minecraft.world.entity.Entity;
import net.thebrokenscript.brokencore.api.util.math.Rotation;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\u0012\u001a\u00020\u0000R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\n\u00a8\u0006\u0014"}, d2={"Lnet/thebrokenscript/brokencore/api/util/math/Rotation;", "", "pitch", "", "yaw", "<init>", "(FF)V", "getPitch", "()F", "setPitch", "(F)V", "getYaw", "setYaw", "applyTo", "", "entity", "Lnet/minecraft/world/entity/Entity;", "copyFrom", "copy", "Companion", "brokencore-common"})
public final class Rotation {
    @NotNull
    public static final Companion Companion = new Companion(null);
    private float pitch;
    private float yaw;
    @NotNull
    private static final Endec<Rotation> ENDEC;

    public Rotation(float pitch, float yaw) {
        this.pitch = pitch;
        this.yaw = yaw;
    }

    public /* synthetic */ Rotation(float f, float f2, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 1) != 0) {
            f = 0.0f;
        }
        if ((n & 2) != 0) {
            f2 = 0.0f;
        }
        this(f, f2);
    }

    public final float getPitch() {
        return this.pitch;
    }

    public final void setPitch(float f) {
        this.pitch = f;
    }

    public final float getYaw() {
        return this.yaw;
    }

    public final void setYaw(float f) {
        this.yaw = f;
    }

    public final void applyTo(@NotNull Entity entity) {
        Intrinsics.checkNotNullParameter((Object)entity, (String)"entity");
        entity.setXRot(this.pitch);
        entity.setYRot(this.yaw);
    }

    public final void copyFrom(@NotNull Entity entity) {
        Intrinsics.checkNotNullParameter((Object)entity, (String)"entity");
        this.pitch = entity.getXRot();
        this.yaw = entity.getYRot();
    }

    @NotNull
    public final Rotation copy() {
        return new Rotation(this.pitch, this.yaw);
    }

    private static final Float ENDEC$lambda$0(KMutableProperty1 $tmp0, Rotation p0) {
        return (Float)((Function1)$tmp0).invoke((Object)p0);
    }

    private static final Float ENDEC$lambda$1(KMutableProperty1 $tmp0, Rotation p0) {
        return (Float)((Function1)$tmp0).invoke((Object)p0);
    }

    public Rotation() {
        this(0.0f, 0.0f, 3, null);
    }

    static {
        StructEndec structEndec = StructEndecBuilder.of((StructField)Endec.FLOAT.fieldOf("pitch", arg_0 -> Rotation.ENDEC$lambda$0((KMutableProperty1)Companion.ENDEC.1.INSTANCE, arg_0)), (StructField)Endec.FLOAT.fieldOf("yaw", arg_0 -> Rotation.ENDEC$lambda$1((KMutableProperty1)Companion.ENDEC.2.INSTANCE, arg_0)), Rotation::new);
        Intrinsics.checkNotNullExpressionValue((Object)structEndec, (String)"of(...)");
        ENDEC = (Endec)structEndec;
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\t"}, d2={"Lnet/thebrokenscript/brokencore/api/util/math/Rotation$Companion;", "", "<init>", "()V", "ENDEC", "Lio/wispforest/endec/Endec;", "Lnet/thebrokenscript/brokencore/api/util/math/Rotation;", "getENDEC", "()Lio/wispforest/endec/Endec;", "brokencore-common"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final Endec<Rotation> getENDEC() {
            return ENDEC;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

