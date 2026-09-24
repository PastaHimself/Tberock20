/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.systems.RenderSystem
 *  com.mojang.blaze3d.vertex.VertexBuffer
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.player.LocalPlayer
 *  net.minecraft.client.renderer.FogRenderer
 *  net.minecraft.client.renderer.LevelRenderer
 *  net.minecraft.client.renderer.ShaderInstance
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.phys.Vec3
 *  org.joml.Matrix4f
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Redirect
 */
package net.thebrokenscript.mixins.features.events.sky;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.VertexBuffer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.FogRenderer;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.client.renderer.ShaderInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.data.PlayerVariables;
import net.thebrokenscript.registry.TBSDataAttachments;
import org.joml.Matrix4f;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value={LevelRenderer.class})
public class LevelRendererMixin {
    @Redirect(method={"renderLevel"}, at=@At(value="INVOKE", target="Lnet/minecraft/client/renderer/FogRenderer;levelFogColor()V"))
    public void tbs$redirectFogColor() {
        Minecraft mc = Minecraft.getInstance();
        if (mc.player == null) {
            FogRenderer.levelFogColor();
            return;
        }
        LocalPlayer player = mc.player;
        PlayerVariables vars = (PlayerVariables)TBSDataAttachments.PLAYER_VARIABLES.get((Entity)player);
        if (vars.getEnableCustomSky()) {
            Vec3 color = vars.getCustomSkyColor();
            RenderSystem.setShaderFogColor((float)((float)color.x), (float)((float)color.y), (float)((float)color.z));
        } else {
            FogRenderer.levelFogColor();
        }
    }

    @Redirect(method={"renderSky"}, at=@At(value="INVOKE", target="Ljava/lang/Runnable;run()V"))
    public void tbs$modifyFogSetup(Runnable instance) {
        Minecraft mc = Minecraft.getInstance();
        if (mc.player == null) {
            instance.run();
            return;
        }
        LocalPlayer player = mc.player;
        PlayerVariables vars = (PlayerVariables)TBSDataAttachments.PLAYER_VARIABLES.get((Entity)player);
        if (!vars.getEnableCustomSky()) {
            instance.run();
        }
    }

    @Redirect(method={"renderSky"}, at=@At(value="INVOKE", target="Lcom/mojang/blaze3d/vertex/VertexBuffer;drawWithShader(Lorg/joml/Matrix4f;Lorg/joml/Matrix4f;Lnet/minecraft/client/renderer/ShaderInstance;)V", ordinal=2))
    public void tbs$redirectBufferDraw(VertexBuffer instance, Matrix4f modelViewMatrix, Matrix4f projectionMatrix, ShaderInstance shader) {
        Minecraft mc = Minecraft.getInstance();
        if (mc.player == null) {
            instance.drawWithShader(modelViewMatrix, projectionMatrix, shader);
            return;
        }
        LocalPlayer player = mc.player;
        PlayerVariables vars = (PlayerVariables)TBSDataAttachments.PLAYER_VARIABLES.get((Entity)player);
        if (!vars.getEnableCustomSky()) {
            instance.drawWithShader(modelViewMatrix, projectionMatrix, shader);
        }
    }
}

