/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 *  org.joml.Matrix4f
 *  org.joml.Vector2fc
 *  org.joml.Vector3fc
 */
package net.thebrokenscript.brokencore.api.client.blocks;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import net.thebrokenscript.brokencore.api.client.blocks.uniforms.CustomUniformFactory;
import net.thebrokenscript.brokencore.api.client.blocks.uniforms.UFloat2vDesc;
import net.thebrokenscript.brokencore.api.client.blocks.uniforms.UFloat3vDesc;
import net.thebrokenscript.brokencore.api.client.blocks.uniforms.UFloatDesc;
import net.thebrokenscript.brokencore.api.client.blocks.uniforms.UMat4fDesc;
import org.jetbrains.annotations.NotNull;
import org.joml.Matrix4f;
import org.joml.Vector2fc;
import org.joml.Vector3fc;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fJ\u001c\u0010\u000e\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u000f0\fJ\u001c\u0010\u0010\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u000f0\fJ\u001c\u0010\u0011\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u000f0\fJ\u001c\u0010\u0012\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00130\fJ\u001c\u0010\u0014\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00130\fJ\u001c\u0010\u0015\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00130\fJ\u001c\u0010\u0016\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00170\fJ\u001c\u0010\u0018\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00170\fJ\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00060\u001aR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001b"}, d2={"Lnet/thebrokenscript/brokencore/api/client/blocks/UniformsBuilder;", "", "<init>", "()V", "uniforms", "", "Lnet/thebrokenscript/brokencore/api/client/blocks/uniforms/CustomUniformFactory;", "float", "", "name", "", "getter", "Lkotlin/Function0;", "", "float2", "Lorg/joml/Vector2fc;", "float2v", "vector2f", "float3", "Lorg/joml/Vector3fc;", "float3v", "vector3f", "mat4", "Lorg/joml/Matrix4f;", "mat4f", "build", "", "brokencore-common"})
public final class UniformsBuilder {
    @NotNull
    private final List<CustomUniformFactory> uniforms = new ArrayList();

    public final boolean float(@NotNull String name, @NotNull Function0<Float> getter) {
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter(getter, (String)"getter");
        return this.uniforms.add(new UFloatDesc(name, getter));
    }

    public final boolean float2(@NotNull String name, @NotNull Function0<? extends Vector2fc> getter) {
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter(getter, (String)"getter");
        return this.uniforms.add(new UFloat2vDesc(name, getter));
    }

    public final boolean float2v(@NotNull String name, @NotNull Function0<? extends Vector2fc> getter) {
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter(getter, (String)"getter");
        return this.float2(name, getter);
    }

    public final boolean vector2f(@NotNull String name, @NotNull Function0<? extends Vector2fc> getter) {
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter(getter, (String)"getter");
        return this.float2(name, getter);
    }

    public final boolean float3(@NotNull String name, @NotNull Function0<? extends Vector3fc> getter) {
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter(getter, (String)"getter");
        return this.uniforms.add(new UFloat3vDesc(name, getter));
    }

    public final boolean float3v(@NotNull String name, @NotNull Function0<? extends Vector3fc> getter) {
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter(getter, (String)"getter");
        return this.float3(name, getter);
    }

    public final boolean vector3f(@NotNull String name, @NotNull Function0<? extends Vector3fc> getter) {
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter(getter, (String)"getter");
        return this.float3(name, getter);
    }

    public final boolean mat4(@NotNull String name, @NotNull Function0<? extends Matrix4f> getter) {
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter(getter, (String)"getter");
        return this.uniforms.add(new UMat4fDesc(name, getter));
    }

    public final boolean mat4f(@NotNull String name, @NotNull Function0<? extends Matrix4f> getter) {
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter(getter, (String)"getter");
        return this.uniforms.add(new UMat4fDesc(name, getter));
    }

    @NotNull
    public final List<CustomUniformFactory> build() {
        return CollectionsKt.toList((Iterable)this.uniforms);
    }
}

