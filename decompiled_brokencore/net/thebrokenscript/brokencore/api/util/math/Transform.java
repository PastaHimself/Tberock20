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
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.phys.Vec3
 *  org.jetbrains.annotations.NotNull
 *  org.joml.Vector3f
 *  org.joml.Vector3fc
 */
package net.thebrokenscript.brokencore.api.util.math;

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
import net.minecraft.world.entity.Entity;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.brokencore.api.util.math.Rotation;
import net.thebrokenscript.brokencore.api.util.math.Transform;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector3f;
import org.joml.Vector3fc;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013J\u000e\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013J\u0006\u0010\u0015\u001a\u00020\u0000R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0017"}, d2={"Lnet/thebrokenscript/brokencore/api/util/math/Transform;", "", "position", "Lorg/joml/Vector3f;", "rotation", "Lnet/thebrokenscript/brokencore/api/util/math/Rotation;", "<init>", "(Lorg/joml/Vector3f;Lnet/thebrokenscript/brokencore/api/util/math/Rotation;)V", "getPosition", "()Lorg/joml/Vector3f;", "setPosition", "(Lorg/joml/Vector3f;)V", "getRotation", "()Lnet/thebrokenscript/brokencore/api/util/math/Rotation;", "setRotation", "(Lnet/thebrokenscript/brokencore/api/util/math/Rotation;)V", "applyTo", "", "entity", "Lnet/minecraft/world/entity/Entity;", "copyFrom", "copy", "Companion", "brokencore-common"})
public final class Transform {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private Vector3f position;
    @NotNull
    private Rotation rotation;
    @NotNull
    private static final Endec<Transform> ENDEC;

    public Transform(@NotNull Vector3f position, @NotNull Rotation rotation) {
        Intrinsics.checkNotNullParameter((Object)position, (String)"position");
        Intrinsics.checkNotNullParameter((Object)rotation, (String)"rotation");
        this.position = position;
        this.rotation = rotation;
    }

    public /* synthetic */ Transform(Vector3f vector3f, Rotation rotation, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 1) != 0) {
            vector3f = new Vector3f();
        }
        if ((n & 2) != 0) {
            rotation = new Rotation(0.0f, 0.0f, 3, null);
        }
        this(vector3f, rotation);
    }

    @NotNull
    public final Vector3f getPosition() {
        return this.position;
    }

    public final void setPosition(@NotNull Vector3f vector3f) {
        Intrinsics.checkNotNullParameter((Object)vector3f, (String)"<set-?>");
        this.position = vector3f;
    }

    @NotNull
    public final Rotation getRotation() {
        return this.rotation;
    }

    public final void setRotation(@NotNull Rotation rotation) {
        Intrinsics.checkNotNullParameter((Object)rotation, (String)"<set-?>");
        this.rotation = rotation;
    }

    public final void applyTo(@NotNull Entity entity) {
        Intrinsics.checkNotNullParameter((Object)entity, (String)"entity");
        entity.setPos(new Vec3(this.position));
        this.rotation.applyTo(entity);
    }

    public final void copyFrom(@NotNull Entity entity) {
        Intrinsics.checkNotNullParameter((Object)entity, (String)"entity");
        Vector3f vector3f = entity.position().toVector3f();
        Intrinsics.checkNotNullExpressionValue((Object)vector3f, (String)"toVector3f(...)");
        this.position = vector3f;
        this.rotation.copyFrom(entity);
    }

    @NotNull
    public final Transform copy() {
        return new Transform(new Vector3f((Vector3fc)this.position), this.rotation.copy());
    }

    private static final Vector3f ENDEC$lambda$0(KMutableProperty1 $tmp0, Transform p0) {
        return (Vector3f)((Function1)$tmp0).invoke((Object)p0);
    }

    private static final Rotation ENDEC$lambda$1(KMutableProperty1 $tmp0, Transform p0) {
        return (Rotation)((Function1)$tmp0).invoke((Object)p0);
    }

    public Transform() {
        this(null, null, 3, null);
    }

    static {
        StructEndec structEndec = StructEndecBuilder.of((StructField)MinecraftEndecs.VECTOR3F.fieldOf("position", arg_0 -> Transform.ENDEC$lambda$0((KMutableProperty1)Companion.ENDEC.1.INSTANCE, arg_0)), (StructField)Rotation.Companion.getENDEC().fieldOf("rotation", arg_0 -> Transform.ENDEC$lambda$1((KMutableProperty1)Companion.ENDEC.2.INSTANCE, arg_0)), Transform::new);
        Intrinsics.checkNotNullExpressionValue((Object)structEndec, (String)"of(...)");
        ENDEC = (Endec)structEndec;
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\t"}, d2={"Lnet/thebrokenscript/brokencore/api/util/math/Transform$Companion;", "", "<init>", "()V", "ENDEC", "Lio/wispforest/endec/Endec;", "Lnet/thebrokenscript/brokencore/api/util/math/Transform;", "getENDEC", "()Lio/wispforest/endec/Endec;", "brokencore-common"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final Endec<Transform> getENDEC() {
            return ENDEC;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

