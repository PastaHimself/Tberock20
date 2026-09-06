/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.systems.RenderSystem
 *  net.minecraft.client.Camera
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.multiplayer.ClientLevel
 *  net.minecraft.client.player.LocalPlayer
 *  net.minecraft.client.renderer.FogRenderer
 *  net.minecraft.client.renderer.FogRenderer$FogMode
 *  net.minecraft.core.particles.ParticleOptions
 *  net.minecraft.core.particles.ParticleTypes
 *  net.minecraft.util.RandomSource
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.level.material.FogType
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package net.thebrokenscript.mixins.features.vfx;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.FogRenderer;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.material.FogType;
import net.thebrokenscript.api.ext.LevelExt;
import net.thebrokenscript.config.TBSConfigs;
import net.thebrokenscript.registry.TBSDimensions;
import net.thebrokenscript.registry.TBSParticleTypes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={FogRenderer.class})
public class VoidFogMixin {
    @Inject(method={"setupFog"}, at={@At(value="HEAD")}, cancellable=true)
    private static void setupFog(Camera camera, FogRenderer.FogMode mode, float viewDistance, boolean thickFog, float partialTicks, CallbackInfo ci) {
        Minecraft mc = Minecraft.getInstance();
        ClientLevel level = mc.level;
        LocalPlayer player = mc.player;
        FogType fogType = camera.getFluidInCamera();
        if (mc.isPaused()) {
            return;
        }
        if (fogType == FogType.NONE) {
            if (level != null && level.dimension() == TBSDimensions.NOWHERE) {
                if (player != null) {
                    VoidFogMixin.tbs$voidFog(player, level, 0.85f, 32.0f, 16.0f, 32.0f);
                }
            } else if (level != null && level.dimension() == TBSDimensions.STAGE2) {
                if (player != null && player.position().y < 150.0) {
                    VoidFogMixin.tbs$voidFog(player, level, 0.85f, 32.0f, 16.0f, 32.0f);
                }
            } else if (level != null && level.dimension() == TBSDimensions.LIBRARY && player != null) {
                VoidFogMixin.tbs$paperParticles(player, level, 0.01f, 32.0f, 16.0f, 32.0f);
            }
            if (level == null || level.dimension() != Level.OVERWORLD) {
                return;
            }
            boolean isFlat = LevelExt.INSTANCE.getVars((LevelAccessor)level).isFlat();
            if (!TBSConfigs.INSTANCE.getClient().getEnableVoidFog() || isFlat) {
                return;
            }
            if (camera.getPosition().y < -45.0) {
                float fadeStart = -45.0f;
                float fadeEnd = -50.0f;
                float cameraY = (float)camera.getPosition().y;
                float fogFactor = Math.clamp((fadeStart - cameraY) / (fadeStart - fadeEnd), 0.0f, 1.0f);
                float normalFogStart = 192.0f;
                float normalFogEnd = 256.0f;
                float deepFogStart = 2.0f;
                float deepFogEnd = 10.0f;
                float fogStart = (float)(Math.pow(normalFogStart, 1.0 - (double)fogFactor) * Math.pow(deepFogStart, fogFactor));
                float fogEnd = (float)(Math.pow(normalFogEnd, 1.0 - (double)fogFactor) * Math.pow(deepFogEnd, fogFactor));
                RenderSystem.setShaderFogStart((float)fogStart);
                RenderSystem.setShaderFogEnd((float)fogEnd);
                float fogAlpha = 0.5f * fogFactor;
                RenderSystem.setShaderFogColor((float)0.0f, (float)0.0f, (float)0.0f, (float)fogAlpha);
                if (player != null) {
                    VoidFogMixin.tbs$voidFog(player, level);
                }
                ci.cancel();
            }
        }
    }

    @Unique
    private static void tbs$voidFog(LocalPlayer player, ClientLevel level) {
        VoidFogMixin.tbs$voidFog(player, level, 0.1f, 16.0f, 8.0f, 16.0f);
    }

    @Unique
    private static void tbs$voidFog(LocalPlayer player, ClientLevel level, float rng, float x, float y, float z) {
        RandomSource random = level.random;
        if (random.nextFloat() < rng) {
            double px = player.getX() + (random.nextDouble() - 0.5) * (double)x;
            double py = player.getY() + (random.nextDouble() - 0.5) * (double)y;
            double pz = player.getZ() + (random.nextDouble() - 0.5) * (double)z;
            double vy = 0.01 + random.nextDouble() * 0.02;
            level.addParticle((ParticleOptions)ParticleTypes.ASH, px, py, pz, 0.0, vy, 0.0);
        }
    }

    @Unique
    private static void tbs$paperParticles(LocalPlayer player, ClientLevel level, float rng, float x, float y, float z) {
        RandomSource random = level.random;
        if (random.nextFloat() < rng) {
            double px = player.getX() + (random.nextDouble() - 0.5) * (double)x;
            double py = player.getY() + (random.nextDouble() - 0.5) * (double)y;
            double pz = player.getZ() + (random.nextDouble() - 0.5) * (double)z;
            double vy = 0.01 + random.nextDouble() * 0.02;
            level.addParticle((ParticleOptions)TBSParticleTypes.PAPER_PARTICLE.get(), px, py, pz, 0.0, vy, 0.0);
        }
    }
}

