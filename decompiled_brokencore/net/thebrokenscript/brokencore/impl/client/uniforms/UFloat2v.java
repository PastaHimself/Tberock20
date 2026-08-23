/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.shaders.Uniform
 *  kotlin.Metadata
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.internal.Intrinsics
 *  net.caffeinemc.mods.sodium.client.gl.shader.uniform.GlUniformFloat2v
 *  net.caffeinemc.mods.sodium.client.render.chunk.shader.ShaderBindingContext
 *  net.minecraft.client.renderer.ShaderInstance
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  org.joml.Vector2fc
 */
package net.thebrokenscript.brokencore.impl.client.uniforms;

import com.mojang.blaze3d.shaders.Uniform;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import net.caffeinemc.mods.sodium.client.gl.shader.uniform.GlUniformFloat2v;
import net.caffeinemc.mods.sodium.client.render.chunk.shader.ShaderBindingContext;
import net.minecraft.client.renderer.ShaderInstance;
import net.thebrokenscript.brokencore.impl.client.uniforms.CustomUniform;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector2fc;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u000eH\u0016J\b\u0010\u0015\u001a\u00020\u000eH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2={"Lnet/thebrokenscript/brokencore/impl/client/uniforms/UFloat2v;", "Lnet/thebrokenscript/brokencore/impl/client/uniforms/CustomUniform;", "name", "", "getter", "Lkotlin/Function0;", "Lorg/joml/Vector2fc;", "<init>", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "uniform", "Lcom/mojang/blaze3d/shaders/Uniform;", "sodium", "Lnet/caffeinemc/mods/sodium/client/gl/shader/uniform/GlUniformFloat2v;", "bind", "", "shader", "Lnet/minecraft/client/renderer/ShaderInstance;", "bindSodium", "cx", "Lnet/caffeinemc/mods/sodium/client/render/chunk/shader/ShaderBindingContext;", "set", "setSodium", "brokencore-common"})
public final class UFloat2v
implements CustomUniform {
    @NotNull
    private final String name;
    @NotNull
    private final Function0<Vector2fc> getter;
    @Nullable
    private Uniform uniform;
    @Nullable
    private GlUniformFloat2v sodium;

    public UFloat2v(@NotNull String name, @NotNull Function0<? extends Vector2fc> getter) {
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter(getter, (String)"getter");
        this.name = name;
        this.getter = getter;
    }

    @Override
    public void bind(@NotNull ShaderInstance shader) {
        Intrinsics.checkNotNullParameter((Object)shader, (String)"shader");
        this.uniform = shader.getUniform(this.name);
    }

    @Override
    public void bindSodium(@NotNull ShaderBindingContext cx) {
        Intrinsics.checkNotNullParameter((Object)cx, (String)"cx");
        this.sodium = (GlUniformFloat2v)cx.bindUniformOptional(this.name, GlUniformFloat2v::new);
    }

    @Override
    public void set() {
        block0: {
            Vector2fc vec = (Vector2fc)this.getter.invoke();
            Uniform uniform = this.uniform;
            if (uniform == null) break block0;
            uniform.set(vec.x(), vec.y());
        }
    }

    @Override
    public void setSodium() {
        block0: {
            Vector2fc vec = (Vector2fc)this.getter.invoke();
            GlUniformFloat2v glUniformFloat2v = this.sodium;
            if (glUniformFloat2v == null) break block0;
            glUniformFloat2v.set(vec.x(), vec.y());
        }
    }
}

