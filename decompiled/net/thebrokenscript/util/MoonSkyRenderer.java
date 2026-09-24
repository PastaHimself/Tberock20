/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.systems.RenderSystem
 *  com.mojang.blaze3d.vertex.BufferBuilder
 *  com.mojang.blaze3d.vertex.BufferUploader
 *  com.mojang.blaze3d.vertex.DefaultVertexFormat
 *  com.mojang.blaze3d.vertex.MeshData
 *  com.mojang.blaze3d.vertex.Tesselator
 *  com.mojang.blaze3d.vertex.VertexFormat$Mode
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.client.Camera
 *  net.minecraft.client.multiplayer.ClientLevel
 *  net.minecraft.client.renderer.ShaderInstance
 *  net.thebrokenscript.brokencore.api.util.Side
 *  net.thebrokenscript.brokencore.api.util.SideOnly
 *  org.jetbrains.annotations.NotNull
 *  org.joml.Matrix4f
 *  org.joml.Matrix4fc
 */
package net.thebrokenscript.util;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.BufferBuilder;
import com.mojang.blaze3d.vertex.BufferUploader;
import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import com.mojang.blaze3d.vertex.MeshData;
import com.mojang.blaze3d.vertex.Tesselator;
import com.mojang.blaze3d.vertex.VertexFormat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.Camera;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.ShaderInstance;
import net.thebrokenscript.brokencore.api.util.Side;
import net.thebrokenscript.brokencore.api.util.SideOnly;
import net.thebrokenscript.client.registry.TBSRenderTypes;
import net.thebrokenscript.config.TBSConfigs;
import net.thebrokenscript.util.CustomSkyRender;
import org.jetbrains.annotations.NotNull;
import org.joml.Matrix4f;
import org.joml.Matrix4fc;

@SideOnly(side=Side.CLIENT)
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003JH\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016\u00a8\u0006\u0015"}, d2={"Lnet/thebrokenscript/util/MoonSkyRenderer;", "Lnet/thebrokenscript/util/CustomSkyRender;", "<init>", "()V", "renderSky", "", "level", "Lnet/minecraft/client/multiplayer/ClientLevel;", "ticks", "", "partialTick", "", "modelViewMatrix", "Lorg/joml/Matrix4f;", "camera", "Lnet/minecraft/client/Camera;", "projectionMatrix", "isFoggy", "", "setupFog", "Ljava/lang/Runnable;", "thebrokenscript-common"})
public final class MoonSkyRenderer
implements CustomSkyRender {
    @Override
    public void renderSky(@NotNull ClientLevel level, int ticks, float partialTick, @NotNull Matrix4f modelViewMatrix, @NotNull Camera camera, @NotNull Matrix4f projectionMatrix, boolean isFoggy, @NotNull Runnable setupFog) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)modelViewMatrix, (String)"modelViewMatrix");
        Intrinsics.checkNotNullParameter((Object)camera, (String)"camera");
        Intrinsics.checkNotNullParameter((Object)projectionMatrix, (String)"projectionMatrix");
        Intrinsics.checkNotNullParameter((Object)setupFog, (String)"setupFog");
        ShaderInstance shaderInstance = TBSRenderTypes.INSTANCE.getSpaceSkyShader();
        if (shaderInstance == null) {
            return;
        }
        ShaderInstance shader = shaderInstance;
        RenderSystem.depthMask((boolean)false);
        RenderSystem.disableCull();
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        Matrix4f inverseViewRot = new Matrix4f((Matrix4fc)modelViewMatrix);
        inverseViewRot.m30(0.0f);
        inverseViewRot.m31(0.0f);
        inverseViewRot.m32(0.0f);
        inverseViewRot.invert();
        Matrix4f inverseProjMat = new Matrix4f((Matrix4fc)projectionMatrix).invert();
        shader.safeGetUniform("InverseProjMat").set(inverseProjMat);
        shader.safeGetUniform("ProjMat").set(projectionMatrix);
        shader.safeGetUniform("InverseViewRotMat").set(inverseViewRot);
        shader.safeGetUniform("GameTime").set((float)level.getGameTime() + partialTick);
        shader.safeGetUniform("FancyRendering").set(TBSConfigs.INSTANCE.getClient().getFancyRendering() ? 1.0f : 0.0f);
        RenderSystem.setShader(() -> MoonSkyRenderer.renderSky$lambda$0(shader));
        Tesselator tesselator = Tesselator.getInstance();
        BufferBuilder buf = tesselator.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION);
        buf.addVertex(-1.0f, -1.0f, 0.0f);
        buf.addVertex(1.0f, -1.0f, 0.0f);
        buf.addVertex(1.0f, 1.0f, 0.0f);
        buf.addVertex(-1.0f, 1.0f, 0.0f);
        BufferUploader.drawWithShader((MeshData)buf.buildOrThrow());
        RenderSystem.disableBlend();
        RenderSystem.enableCull();
        RenderSystem.depthMask((boolean)true);
    }

    private static final ShaderInstance renderSky$lambda$0(ShaderInstance $shader) {
        return $shader;
    }
}

