/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.vertex.VertexFormat
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.client.renderer.ShaderInstance
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.server.packs.resources.ResourceProvider
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.neoforge;

import com.mojang.blaze3d.vertex.VertexFormat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.renderer.ShaderInstance;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceProvider;
import net.thebrokenscript.brokencore.api.client.shader.BCShader;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0004\b\t\u0010\nJ\u0006\u0010\u000b\u001a\u00020\f\u00a8\u0006\r"}, d2={"Lnet/thebrokenscript/brokencore/neoforge/XShaderInstance;", "Lnet/minecraft/client/renderer/ShaderInstance;", "Lnet/thebrokenscript/brokencore/api/client/shader/BCShader;", "prov", "Lnet/minecraft/server/packs/resources/ResourceProvider;", "loc", "Lnet/minecraft/resources/ResourceLocation;", "fmt", "Lcom/mojang/blaze3d/vertex/VertexFormat;", "<init>", "(Lnet/minecraft/server/packs/resources/ResourceProvider;Lnet/minecraft/resources/ResourceLocation;Lcom/mojang/blaze3d/vertex/VertexFormat;)V", "iris$skipDraw", "", "brokencore-neoforge"})
public final class XShaderInstance
extends ShaderInstance
implements BCShader {
    public XShaderInstance(@NotNull ResourceProvider prov, @NotNull ResourceLocation loc, @NotNull VertexFormat fmt) {
        Intrinsics.checkNotNullParameter((Object)prov, (String)"prov");
        Intrinsics.checkNotNullParameter((Object)loc, (String)"loc");
        Intrinsics.checkNotNullParameter((Object)fmt, (String)"fmt");
        super(prov, loc, fmt);
    }

    public final boolean iris$skipDraw() {
        return true;
    }
}

