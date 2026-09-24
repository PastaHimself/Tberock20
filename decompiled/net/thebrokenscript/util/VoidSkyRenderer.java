/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.shaders.Uniform
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
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.multiplayer.ClientLevel
 *  net.minecraft.client.renderer.ShaderInstance
 *  net.minecraft.resources.ResourceLocation
 *  net.thebrokenscript.brokencore.api.util.Side
 *  net.thebrokenscript.brokencore.api.util.SideOnly
 *  org.jetbrains.annotations.NotNull
 *  org.joml.Matrix4f
 *  org.joml.Matrix4fc
 *  org.lwjgl.opengl.GL11
 *  org.lwjgl.opengl.GL30
 */
package net.thebrokenscript.util;

import com.mojang.blaze3d.shaders.Uniform;
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
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.ShaderInstance;
import net.minecraft.resources.ResourceLocation;
import net.thebrokenscript.api.TBSConstants;
import net.thebrokenscript.boss.integrity.FinalCutsceneHandler;
import net.thebrokenscript.brokencore.api.util.Side;
import net.thebrokenscript.brokencore.api.util.SideOnly;
import net.thebrokenscript.client.registry.TBSRenderTypes;
import net.thebrokenscript.util.CustomSkyRender;
import org.jetbrains.annotations.NotNull;
import org.joml.Matrix4f;
import org.joml.Matrix4fc;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL30;

@SideOnly(side=Side.CLIENT)
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003JH\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0015H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2={"Lnet/thebrokenscript/util/VoidSkyRenderer;", "Lnet/thebrokenscript/util/CustomSkyRender;", "<init>", "()V", "mipmapsGenerated", "", "renderSky", "", "level", "Lnet/minecraft/client/multiplayer/ClientLevel;", "ticks", "", "partialTick", "", "modelViewMatrix", "Lorg/joml/Matrix4f;", "camera", "Lnet/minecraft/client/Camera;", "projectionMatrix", "isFoggy", "setupFog", "Ljava/lang/Runnable;", "thebrokenscript-common"})
public final class VoidSkyRenderer
implements CustomSkyRender {
    private boolean mipmapsGenerated;

    @Override
    public void renderSky(@NotNull ClientLevel level, int ticks, float partialTick, @NotNull Matrix4f modelViewMatrix, @NotNull Camera camera, @NotNull Matrix4f projectionMatrix, boolean isFoggy, @NotNull Runnable setupFog) {
        Matrix4f matrix4f;
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)modelViewMatrix, (String)"modelViewMatrix");
        Intrinsics.checkNotNullParameter((Object)camera, (String)"camera");
        Intrinsics.checkNotNullParameter((Object)projectionMatrix, (String)"projectionMatrix");
        Intrinsics.checkNotNullParameter((Object)setupFog, (String)"setupFog");
        ShaderInstance shaderInstance = TBSRenderTypes.INSTANCE.getVoidSkyShader();
        if (shaderInstance == null) {
            return;
        }
        ShaderInstance shader = shaderInstance;
        RenderSystem.setShaderTexture((int)0, (ResourceLocation)TBSConstants.id("textures/environment/arena_sky.png"));
        if (!this.mipmapsGenerated) {
            GL11.glTexParameteri((int)3553, (int)10241, (int)9987);
            GL11.glTexParameteri((int)3553, (int)10240, (int)9729);
            GL30.glGenerateMipmap((int)3553);
            this.mipmapsGenerated = true;
        }
        shader.setSampler("Sampler0", (Object)0);
        RenderSystem.setShaderTexture((int)1, (ResourceLocation)TBSConstants.id("textures/environment/void_sky_fx.png"));
        shader.setSampler("Sampler1", (Object)1);
        setupFog.run();
        Matrix4f $this$renderSky_u24lambda_u240 = matrix4f = new Matrix4f((Matrix4fc)modelViewMatrix);
        boolean bl = false;
        $this$renderSky_u24lambda_u240.m30(0.0f);
        $this$renderSky_u24lambda_u240.m31(0.0f);
        $this$renderSky_u24lambda_u240.m32(0.0f);
        Matrix4f viewMatInverse = matrix4f.invert();
        Matrix4f projMatInverse = new Matrix4f((Matrix4fc)projectionMatrix).invert();
        Uniform uniform = shader.getUniform("uTime");
        if (uniform != null) {
            uniform.set((float)(level.getGameTime() % (long)24000) + partialTick);
        }
        Uniform uniform2 = shader.getUniform("ViewMatInverse");
        if (uniform2 != null) {
            uniform2.set(viewMatInverse);
        }
        Uniform uniform3 = shader.getUniform("ProjMatInverse");
        if (uniform3 != null) {
            uniform3.set(projMatInverse);
        }
        Uniform uniform4 = shader.getUniform("VortexSkyZoom");
        if (uniform4 != null) {
            uniform4.set(FinalCutsceneHandler.CUTSCENE.getZoomValue());
        }
        Uniform uniform5 = shader.getUniform("FogColor");
        if (uniform5 != null) {
            uniform5.set(RenderSystem.getShaderFogColor()[0], RenderSystem.getShaderFogColor()[1], RenderSystem.getShaderFogColor()[2], RenderSystem.getShaderFogColor()[3]);
        }
        float renderDistanceBlocks = ((Number)Minecraft.getInstance().options.renderDistance().get()).floatValue() * 16.0f;
        Uniform uniform6 = shader.getUniform("RenderDistance");
        if (uniform6 != null) {
            uniform6.set(renderDistanceBlocks);
        }
        RenderSystem.setShader(() -> VoidSkyRenderer.renderSky$lambda$1(shader));
        RenderSystem.setShaderFogColor((float)0.05f, (float)0.05f, (float)0.05f, (float)0.935f);
        RenderSystem.disableDepthTest();
        RenderSystem.depthMask((boolean)false);
        RenderSystem.disableCull();
        BufferBuilder buf = Tesselator.getInstance().begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION);
        buf.addVertex(-1.0f, -1.0f, 0.0f);
        buf.addVertex(1.0f, -1.0f, 0.0f);
        buf.addVertex(1.0f, 1.0f, 0.0f);
        buf.addVertex(-1.0f, 1.0f, 0.0f);
        BufferUploader.drawWithShader((MeshData)buf.buildOrThrow());
        RenderSystem.enableCull();
        RenderSystem.depthMask((boolean)true);
        RenderSystem.enableDepthTest();
    }

    private static final ShaderInstance renderSky$lambda$1(ShaderInstance $shader) {
        return $shader;
    }
}

