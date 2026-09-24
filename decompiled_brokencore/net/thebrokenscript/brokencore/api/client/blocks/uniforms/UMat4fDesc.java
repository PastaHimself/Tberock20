/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 *  org.joml.Matrix4f
 */
package net.thebrokenscript.brokencore.api.client.blocks.uniforms;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import net.thebrokenscript.brokencore.api.client.blocks.uniforms.CustomUniformFactory;
import net.thebrokenscript.brokencore.impl.client.uniforms.UMat4f;
import org.jetbrains.annotations.NotNull;
import org.joml.Matrix4f;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\u0004\b\u0007\u0010\bJ\b\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2={"Lnet/thebrokenscript/brokencore/api/client/blocks/uniforms/UMat4fDesc;", "Lnet/thebrokenscript/brokencore/api/client/blocks/uniforms/CustomUniformFactory;", "name", "", "getter", "Lkotlin/Function0;", "Lorg/joml/Matrix4f;", "<init>", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "create", "Lnet/thebrokenscript/brokencore/impl/client/uniforms/UMat4f;", "brokencore-common"})
public final class UMat4fDesc
implements CustomUniformFactory {
    @NotNull
    private final String name;
    @NotNull
    private final Function0<Matrix4f> getter;

    public UMat4fDesc(@NotNull String name, @NotNull Function0<? extends Matrix4f> getter) {
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter(getter, (String)"getter");
        this.name = name;
        this.getter = getter;
    }

    @Override
    @NotNull
    public UMat4f create() {
        return new UMat4f(this.name, this.getter);
    }
}

