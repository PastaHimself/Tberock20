/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.pipeline.RenderTarget
 *  com.mojang.blaze3d.platform.GlStateManager
 *  com.mojang.blaze3d.systems.RenderSystem
 *  com.mojang.blaze3d.vertex.BufferBuilder
 *  com.mojang.blaze3d.vertex.BufferUploader
 *  com.mojang.blaze3d.vertex.DefaultVertexFormat
 *  com.mojang.blaze3d.vertex.MeshData
 *  com.mojang.blaze3d.vertex.Tesselator
 *  com.mojang.blaze3d.vertex.VertexFormat$Mode
 *  kotlin.Metadata
 *  kotlin.jvm.JvmOverloads
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.renderer.ShaderInstance
 *  net.thebrokenscript.brokencore.api.dsl.ClientDSLKt
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.client.util;

import com.mojang.blaze3d.pipeline.RenderTarget;
import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.BufferBuilder;
import com.mojang.blaze3d.vertex.BufferUploader;
import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import com.mojang.blaze3d.vertex.MeshData;
import com.mojang.blaze3d.vertex.Tesselator;
import com.mojang.blaze3d.vertex.VertexFormat;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.client.renderer.ShaderInstance;
import net.thebrokenscript.brokencore.api.dsl.ClientDSLKt;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=2, xi=48, d1={"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\u001a6\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\tH\u0007\u00a8\u0006\n"}, d2={"blitToScreenAt", "", "Lcom/mojang/blaze3d/pipeline/RenderTarget;", "x", "", "y", "width", "height", "disableBlend", "", "thebrokenscript-common"})
@SourceDebugExtension(value={"SMAP\nRenderTargetExt.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RenderTargetExt.kt\nnet/thebrokenscript/client/util/RenderTargetExtKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,41:1\n1#2:42\n*E\n"})
public final class RenderTargetExtKt {
    @JvmOverloads
    public static final void blitToScreenAt(@NotNull RenderTarget $this$blitToScreenAt, int x, int y, int width, int height, boolean disableBlend) {
        Intrinsics.checkNotNullParameter((Object)$this$blitToScreenAt, (String)"<this>");
        RenderSystem.assertOnRenderThread();
        GlStateManager._colorMask((boolean)true, (boolean)true, (boolean)true, (boolean)false);
        GlStateManager._disableDepthTest();
        GlStateManager._depthMask((boolean)false);
        GlStateManager._viewport((int)x, (int)y, (int)width, (int)height);
        if (disableBlend) {
            GlStateManager._disableBlend();
        }
        ShaderInstance shaderInstance = ClientDSLKt.getMC().gameRenderer.blitShader;
        if (shaderInstance == null) {
            boolean $i$a$-checkNotNull-RenderTargetExtKt$blitToScreenAt$blit$22 = false;
            String $i$a$-checkNotNull-RenderTargetExtKt$blitToScreenAt$blit$22 = "Blit shader not loaded";
            throw new IllegalStateException($i$a$-checkNotNull-RenderTargetExtKt$blitToScreenAt$blit$22.toString());
        }
        ShaderInstance blit = shaderInstance;
        blit.setSampler("DiffuseSampler", (Object)$this$blitToScreenAt.getColorTextureId());
        blit.apply();
        Tesselator tess = RenderSystem.renderThreadTesselator();
        BufferBuilder buf = tess.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.BLIT_SCREEN);
        buf.addVertex(0.0f, 0.0f, 0.0f);
        buf.addVertex(1.0f, 0.0f, 0.0f);
        buf.addVertex(1.0f, 1.0f, 0.0f);
        buf.addVertex(0.0f, 1.0f, 0.0f);
        BufferUploader.draw((MeshData)buf.buildOrThrow());
        blit.clear();
        GlStateManager._depthMask((boolean)true);
        GlStateManager._colorMask((boolean)true, (boolean)true, (boolean)true, (boolean)true);
    }

    public static /* synthetic */ void blitToScreenAt$default(RenderTarget renderTarget, int n, int n2, int n3, int n4, boolean bl, int n5, Object object) {
        if ((n5 & 0x10) != 0) {
            bl = true;
        }
        RenderTargetExtKt.blitToScreenAt(renderTarget, n, n2, n3, n4, bl);
    }

    @JvmOverloads
    public static final void blitToScreenAt(@NotNull RenderTarget $this$blitToScreenAt, int x, int y, int width, int height) {
        Intrinsics.checkNotNullParameter((Object)$this$blitToScreenAt, (String)"<this>");
        RenderTargetExtKt.blitToScreenAt$default($this$blitToScreenAt, x, y, width, height, false, 16, null);
    }
}

