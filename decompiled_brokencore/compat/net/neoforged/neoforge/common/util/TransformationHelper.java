/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.math.Transformation
 *  kotlin.Metadata
 *  kotlin.enums.EnumEntries
 *  kotlin.enums.EnumEntriesKt
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.util.Mth
 *  net.minecraft.util.StringRepresentable
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  org.joml.Quaternionf
 *  org.joml.Quaternionfc
 *  org.joml.Vector3f
 *  org.joml.Vector3fc
 *  org.joml.Vector4f
 */
package compat.net.neoforged.neoforge.common.util;

import com.mojang.math.Transformation;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.util.Mth;
import net.minecraft.util.StringRepresentable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.joml.Quaternionf;
import org.joml.Quaternionfc;
import org.joml.Vector3f;
import org.joml.Vector3fc;
import org.joml.Vector4f;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001#B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\tJ&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\nJ\u001e\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\fJ\u001e\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\fJ\u001e\u0010\u0017\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u0014\u001a\u00020\fJ\u001e\u0010\u001f\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020 2\u0006\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020\fR\u000e\u0010\u0015\u001a\u00020\u0016X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006$"}, d2={"Lcompat/net/neoforged/neoforge/common/util/TransformationHelper;", "", "<init>", "()V", "quatFromXYZ", "Lorg/joml/Quaternionf;", "xyz", "Lorg/joml/Vector3f;", "degrees", "", "", "x", "", "y", "z", "makeQuaternion", "values", "lerp", "from", "to", "progress", "THRESHOLD", "", "slerp", "v0", "Lorg/joml/Quaternionfc;", "v1", "t", "Lcom/mojang/math/Transformation;", "one", "that", "epsilonEquals", "Lorg/joml/Vector4f;", "v2", "epsilon", "TransformOrigin", "brokencore-common"})
@SourceDebugExtension(value={"SMAP\nTransformationHelper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TransformationHelper.kt\ncompat/net/neoforged/neoforge/common/util/TransformationHelper\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,106:1\n1#2:107\n*E\n"})
public final class TransformationHelper {
    @NotNull
    public static final TransformationHelper INSTANCE = new TransformationHelper();
    private static final double THRESHOLD = 0.9995;

    private TransformationHelper() {
    }

    @NotNull
    public final Quaternionf quatFromXYZ(@NotNull Vector3f xyz, boolean degrees) {
        Intrinsics.checkNotNullParameter((Object)xyz, (String)"xyz");
        return this.quatFromXYZ(xyz.x, xyz.y, xyz.z, degrees);
    }

    @NotNull
    public final Quaternionf quatFromXYZ(@NotNull float[] xyz, boolean degrees) {
        Intrinsics.checkNotNullParameter((Object)xyz, (String)"xyz");
        return this.quatFromXYZ(xyz[0], xyz[1], xyz[2], degrees);
    }

    @NotNull
    public final Quaternionf quatFromXYZ(float x, float y, float z, boolean degrees) {
        float conversionFactor = degrees ? (float)Math.PI / 180 : 1.0f;
        Quaternionf quaternionf = new Quaternionf().rotationXYZ(x * conversionFactor, y * conversionFactor, z * conversionFactor);
        Intrinsics.checkNotNullExpressionValue((Object)quaternionf, (String)"rotationXYZ(...)");
        return quaternionf;
    }

    @NotNull
    public final Quaternionf makeQuaternion(@NotNull float[] values) {
        Intrinsics.checkNotNullParameter((Object)values, (String)"values");
        return new Quaternionf(values[0], values[1], values[2], values[3]);
    }

    @NotNull
    public final Vector3f lerp(@NotNull Vector3f from, @NotNull Vector3f to, float progress) {
        Vector3f vector3f;
        Intrinsics.checkNotNullParameter((Object)from, (String)"from");
        Intrinsics.checkNotNullParameter((Object)to, (String)"to");
        Vector3f it = vector3f = new Vector3f((Vector3fc)from);
        boolean bl = false;
        it.lerp((Vector3fc)to, progress);
        return vector3f;
    }

    @NotNull
    public final Quaternionf slerp(@NotNull Quaternionfc v0, @NotNull Quaternionfc v1, float t) {
        Intrinsics.checkNotNullParameter((Object)v0, (String)"v0");
        Intrinsics.checkNotNullParameter((Object)v1, (String)"v1");
        Quaternionfc v12 = v1;
        float dot = v0.x() * v12.x() + v0.y() * v12.y() + v0.z() * v12.z() + v0.w() * v12.w();
        if (dot < 0.0f) {
            v12 = (Quaternionfc)new Quaternionf(-v12.x(), -v12.y(), -v12.z(), -v12.w());
            dot = -dot;
        }
        if ((double)dot > 0.9995) {
            float x = Mth.lerp((float)t, (float)v0.x(), (float)v12.x());
            float y = Mth.lerp((float)t, (float)v0.y(), (float)v12.y());
            float z = Mth.lerp((float)t, (float)v0.z(), (float)v12.z());
            float w = Mth.lerp((float)t, (float)v0.w(), (float)v12.w());
            return new Quaternionf(x, y, z, w);
        }
        float angle01 = (float)Math.acos(dot);
        float angle0t = angle01 * t;
        float sin0t = Mth.sin((float)angle0t);
        float sin01 = Mth.sin((float)angle01);
        float sin1t = Mth.sin((float)(angle01 - angle0t));
        float s1 = sin0t / sin01;
        float s0 = sin1t / sin01;
        return new Quaternionf(s0 * v0.x() + s1 * v12.x(), s0 * v0.y() + s1 * v12.y(), s0 * v0.z() + s1 * v12.z(), s0 * v0.w() + s1 * v12.w());
    }

    @NotNull
    public final Transformation slerp(@NotNull Transformation one, @NotNull Transformation that, float progress) {
        Intrinsics.checkNotNullParameter((Object)one, (String)"one");
        Intrinsics.checkNotNullParameter((Object)that, (String)"that");
        Vector3f vector3f = one.getTranslation();
        Intrinsics.checkNotNullExpressionValue((Object)vector3f, (String)"getTranslation(...)");
        Vector3f vector3f2 = that.getTranslation();
        Intrinsics.checkNotNullExpressionValue((Object)vector3f2, (String)"getTranslation(...)");
        Vector3f vector3f3 = this.lerp(vector3f, vector3f2, progress);
        Quaternionf quaternionf = one.getLeftRotation();
        Intrinsics.checkNotNullExpressionValue((Object)quaternionf, (String)"getLeftRotation(...)");
        Quaternionfc quaternionfc = (Quaternionfc)quaternionf;
        Quaternionf quaternionf2 = that.getLeftRotation();
        Intrinsics.checkNotNullExpressionValue((Object)quaternionf2, (String)"getLeftRotation(...)");
        Quaternionf quaternionf3 = this.slerp(quaternionfc, (Quaternionfc)quaternionf2, progress);
        Vector3f vector3f4 = one.getScale();
        Intrinsics.checkNotNullExpressionValue((Object)vector3f4, (String)"getScale(...)");
        Vector3f vector3f5 = that.getScale();
        Intrinsics.checkNotNullExpressionValue((Object)vector3f5, (String)"getScale(...)");
        Vector3f vector3f6 = this.lerp(vector3f4, vector3f5, progress);
        Quaternionf quaternionf4 = one.getRightRotation();
        Intrinsics.checkNotNullExpressionValue((Object)quaternionf4, (String)"getRightRotation(...)");
        Quaternionfc quaternionfc2 = (Quaternionfc)quaternionf4;
        Quaternionf quaternionf5 = that.getRightRotation();
        Intrinsics.checkNotNullExpressionValue((Object)quaternionf5, (String)"getRightRotation(...)");
        return new Transformation(vector3f3, quaternionf3, vector3f6, this.slerp(quaternionfc2, (Quaternionfc)quaternionf5, progress));
    }

    public final boolean epsilonEquals(@NotNull Vector4f v1, @NotNull Vector4f v2, float epsilon) {
        Intrinsics.checkNotNullParameter((Object)v1, (String)"v1");
        Intrinsics.checkNotNullParameter((Object)v2, (String)"v2");
        return Mth.abs((float)(v1.x() - v2.x())) < epsilon && Mth.abs((float)(v1.y() - v2.y())) < epsilon && Mth.abs((float)(v1.z() - v2.z())) < epsilon && Mth.abs((float)(v1.w() - v2.w())) < epsilon;
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u0000 \u000f2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u000fB\u0019\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u000e\u001a\u00020\u0006H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000j\u0002\b\u000bj\u0002\b\fj\u0002\b\r\u00a8\u0006\u0010"}, d2={"Lcompat/net/neoforged/neoforge/common/util/TransformationHelper$TransformOrigin;", "Lnet/minecraft/util/StringRepresentable;", "", "vector", "Lorg/joml/Vector3f;", "transformName", "", "<init>", "(Ljava/lang/String;ILorg/joml/Vector3f;Ljava/lang/String;)V", "getVector", "()Lorg/joml/Vector3f;", "CENTER", "CORNER", "OPPOSING_CORNER", "getSerializedName", "Companion", "brokencore-common"})
    public static final class TransformOrigin
    extends Enum<TransformOrigin>
    implements StringRepresentable {
        @NotNull
        public static final Companion Companion;
        @NotNull
        private final Vector3f vector;
        @NotNull
        private final String transformName;
        public static final /* enum */ TransformOrigin CENTER;
        public static final /* enum */ TransformOrigin CORNER;
        public static final /* enum */ TransformOrigin OPPOSING_CORNER;
        private static final /* synthetic */ TransformOrigin[] $VALUES;
        private static final /* synthetic */ EnumEntries $ENTRIES;

        private TransformOrigin(Vector3f vector, String transformName) {
            this.vector = vector;
            this.transformName = transformName;
        }

        @NotNull
        public final Vector3f getVector() {
            return this.vector;
        }

        @NotNull
        public String getSerializedName() {
            return this.transformName;
        }

        public static TransformOrigin[] values() {
            return (TransformOrigin[])$VALUES.clone();
        }

        public static TransformOrigin valueOf(String value) {
            return Enum.valueOf(TransformOrigin.class, value);
        }

        @NotNull
        public static EnumEntries<TransformOrigin> getEntries() {
            return $ENTRIES;
        }

        static {
            CENTER = new TransformOrigin(new Vector3f(0.5f, 0.5f, 0.5f), "center");
            CORNER = new TransformOrigin(new Vector3f(), "corner");
            OPPOSING_CORNER = new TransformOrigin(new Vector3f(1.0f, 1.0f, 1.0f), "opposing-corner");
            $VALUES = transformOriginArray = new TransformOrigin[]{TransformOrigin.CENTER, TransformOrigin.CORNER, TransformOrigin.OPPOSING_CORNER};
            $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
            Companion = new Companion(null);
        }

        @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007\u00a8\u0006\b"}, d2={"Lcompat/net/neoforged/neoforge/common/util/TransformationHelper$TransformOrigin$Companion;", "", "<init>", "()V", "fromString", "Lcompat/net/neoforged/neoforge/common/util/TransformationHelper$TransformOrigin;", "originName", "", "brokencore-common"})
        public static final class Companion {
            private Companion() {
            }

            @Nullable
            public final TransformOrigin fromString(@NotNull String originName) {
                Intrinsics.checkNotNullParameter((Object)originName, (String)"originName");
                if (Intrinsics.areEqual((Object)CENTER.getSerializedName(), (Object)originName)) {
                }
                if (Intrinsics.areEqual((Object)CORNER.getSerializedName(), (Object)originName)) {
                }
                if (Intrinsics.areEqual((Object)OPPOSING_CORNER.getSerializedName(), (Object)originName)) {
                }
                return null;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
                this();
            }
        }
    }
}

