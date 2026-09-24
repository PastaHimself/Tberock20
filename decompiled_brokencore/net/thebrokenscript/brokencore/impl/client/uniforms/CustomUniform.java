/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  net.caffeinemc.mods.sodium.client.render.chunk.shader.ShaderBindingContext
 *  net.minecraft.client.renderer.ShaderInstance
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.impl.client.uniforms;

import kotlin.Metadata;
import net.caffeinemc.mods.sodium.client.render.chunk.shader.ShaderBindingContext;
import net.minecraft.client.renderer.ShaderInstance;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\u0003H&J\b\u0010\n\u001a\u00020\u0003H&\u00a8\u0006\u000b"}, d2={"Lnet/thebrokenscript/brokencore/impl/client/uniforms/CustomUniform;", "", "bind", "", "shader", "Lnet/minecraft/client/renderer/ShaderInstance;", "bindSodium", "cx", "Lnet/caffeinemc/mods/sodium/client/render/chunk/shader/ShaderBindingContext;", "set", "setSodium", "brokencore-common"})
public interface CustomUniform {
    public void bind(@NotNull ShaderInstance var1);

    public void bindSodium(@NotNull ShaderBindingContext var1);

    public void set();

    public void setSodium();
}

