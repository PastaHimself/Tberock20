/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.util.Mth
 *  org.jetbrains.annotations.NotNull
 *  org.joml.Quaternionf
 *  org.joml.Quaternionfc
 *  org.joml.Vector3f
 *  org.joml.Vector3fc
 */
package net.thebrokenscript.client.tentacles;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.util.Mth;
import org.jetbrains.annotations.NotNull;
import org.joml.Quaternionf;
import org.joml.Quaternionfc;
import org.joml.Vector3f;
import org.joml.Vector3fc;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u000fB\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003JA\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\n\u00a2\u0006\u0002\u0010\u000e\u00a8\u0006\u0010"}, d2={"Lnet/thebrokenscript/client/tentacles/TentacleVertexBuilder;", "", "<init>", "()V", "build", "", "Lorg/joml/Vector3f;", "end", "rotator", "resolution", "", "sideRes", "", "size", "(Lorg/joml/Vector3f;Lorg/joml/Vector3f;FIF)[Lorg/joml/Vector3f;", "State", "thebrokenscript-common"})
public final class TentacleVertexBuilder {
    @NotNull
    public static final TentacleVertexBuilder INSTANCE = new TentacleVertexBuilder();

    private TentacleVertexBuilder() {
    }

    @NotNull
    public final Vector3f[] build(@NotNull Vector3f end, @NotNull Vector3f rotator, float resolution, int sideRes, float size) {
        Intrinsics.checkNotNullParameter((Object)end, (String)"end");
        Intrinsics.checkNotNullParameter((Object)rotator, (String)"rotator");
        Quaternionf totalRot = new Quaternionf().rotationTo((Vector3fc)rotator, (Vector3fc)end);
        Quaternionf quat = new Quaternionf();
        float length = Mth.sqrt((float)totalRot.lengthSquared()) * end.length();
        float min = 0.0f;
        int layers = (int)(length / resolution) + 1;
        int n = 0;
        int n2 = layers * 4 * sideRes;
        Vector3f[] vector3fArray = new Vector3f[n2];
        while (n < n2) {
            int n3 = n++;
            vector3fArray[n3] = new Vector3f();
        }
        Vector3f[] vertices = vector3fArray;
        State prev = new State(sideRes, null, 2, null);
        int idx = 0;
        float part = (float)Math.PI * 2 / (float)sideRes;
        for (int layer = 0; layer < layers; ++layer) {
            int i;
            new Quaternionf().slerp((Quaternionfc)totalRot, (float)layer / (float)layers, quat);
            float step = (float)layer * resolution;
            int n4 = 0;
            Vector3f[] vector3fArray2 = new Vector3f[sideRes];
            while (n4 < sideRes) {
                int n5 = n4++;
                vector3fArray2[n5] = new Vector3f();
            }
            Vector3f[] points = vector3fArray2;
            float rad = -size * Mth.square((float)((float)layer / (float)layers)) + size;
            for (i = 0; i < sideRes; ++i) {
                float rot = part * (float)i;
                float x = Mth.cos((float)rot) * rad;
                float z = Mth.sin((float)rot) * rad;
                Vector3f point = new Vector3f(x, min + step, z).rotate((Quaternionfc)quat);
                Intrinsics.checkNotNull((Object)point);
                points[i] = point;
            }
            if (layer == 0) {
                idx += 4;
            } else {
                for (i = 0; i < sideRes; ++i) {
                    Vector3f topLeft = points[i];
                    Vector3f topRight = i == sideRes - 1 ? points[0] : points[i + 1];
                    Vector3f bottomLeft = prev.getPoints()[i];
                    Vector3f bottomRight = i == sideRes - 1 ? prev.getPoints()[0] : prev.getPoints()[i + 1];
                    vertices[idx] = topLeft;
                    vertices[idx + 1] = bottomLeft;
                    vertices[idx + 2] = bottomRight;
                    vertices[idx + 3] = topRight;
                    idx += 4;
                }
            }
            prev.setPoints(points);
        }
        return vertices;
    }

    public static /* synthetic */ Vector3f[] build$default(TentacleVertexBuilder tentacleVertexBuilder, Vector3f vector3f, Vector3f vector3f2, float f, int n, float f2, int n2, Object object) {
        if ((n2 & 2) != 0) {
            vector3f2 = new Vector3f(0.0f, 1.0f, 0.0f);
        }
        if ((n2 & 4) != 0) {
            f = 2.0f;
        }
        if ((n2 & 8) != 0) {
            n = 16;
        }
        if ((n2 & 0x10) != 0) {
            f2 = 4.0f;
        }
        return tentacleVertexBuilder.build(vector3f, vector3f2, f, n, f2);
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\n\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\"\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u0010"}, d2={"Lnet/thebrokenscript/client/tentacles/TentacleVertexBuilder$State;", "", "size", "", "points", "", "Lorg/joml/Vector3f;", "<init>", "(I[Lorg/joml/Vector3f;)V", "getSize", "()I", "getPoints", "()[Lorg/joml/Vector3f;", "setPoints", "([Lorg/joml/Vector3f;)V", "[Lorg/joml/Vector3f;", "thebrokenscript-common"})
    private static final class State {
        private final int size;
        @NotNull
        private Vector3f[] points;

        public State(int size, @NotNull Vector3f[] points) {
            Intrinsics.checkNotNullParameter((Object)points, (String)"points");
            this.size = size;
            this.points = points;
        }

        public /* synthetic */ State(int n, Vector3f[] vector3fArray, int n2, DefaultConstructorMarker defaultConstructorMarker) {
            if ((n2 & 2) != 0) {
                int n3 = 0;
                Vector3f[] vector3fArray2 = new Vector3f[n];
                while (n3 < n) {
                    int n4 = n3++;
                    vector3fArray2[n4] = new Vector3f();
                }
                vector3fArray = vector3fArray2;
            }
            this(n, vector3fArray);
        }

        public final int getSize() {
            return this.size;
        }

        @NotNull
        public final Vector3f[] getPoints() {
            return this.points;
        }

        public final void setPoints(@NotNull Vector3f[] vector3fArray) {
            Intrinsics.checkNotNullParameter((Object)vector3fArray, (String)"<set-?>");
            this.points = vector3fArray;
        }
    }
}

