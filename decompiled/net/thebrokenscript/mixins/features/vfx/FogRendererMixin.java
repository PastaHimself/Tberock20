/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.systems.RenderSystem
 *  net.minecraft.client.Camera
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.multiplayer.ClientLevel
 *  net.minecraft.client.renderer.FogRenderer
 *  net.minecraft.util.Mth
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package net.thebrokenscript.mixins.features.vfx;

import com.mojang.blaze3d.systems.RenderSystem;
import java.util.Objects;
import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.FogRenderer;
import net.minecraft.util.Mth;
import net.thebrokenscript.mixins.features.vfx.FogRendererAccessor;
import net.thebrokenscript.registry.TBSDimensions;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={FogRenderer.class})
public class FogRendererMixin {
    @Inject(method={"levelFogColor"}, at={@At(value="RETURN")})
    private static void modifyFogColorByHeight(CallbackInfo ci) {
        if (Minecraft.getInstance().level != null && Minecraft.getInstance().level.dimension() != TBSDimensions.CLAN_VOID && Minecraft.getInstance().level.dimension() != TBSDimensions.STAGE2) {
            return;
        }
        if (Objects.requireNonNull(Minecraft.getInstance().level).dimension() == TBSDimensions.STAGE2) {
            RenderSystem.setShaderFogColor((float)0.0f, (float)0.0f, (float)0.0f, (float)0.0f);
            return;
        }
        Minecraft mc = Minecraft.getInstance();
        Camera camera = mc.gameRenderer.getMainCamera();
        double playerY = camera.getPosition().y;
        if (Objects.requireNonNull(Minecraft.getInstance().level).dimension() == TBSDimensions.STAGE2 && playerY > 251.1) {
            RenderSystem.setShaderFogColor((float)1.0f, (float)1.0f, (float)1.0f, (float)0.0f);
            return;
        }
        if (playerY < 251.1) {
            RenderSystem.setShaderFogColor((float)0.0f, (float)0.0f, (float)0.0f);
            return;
        }
        float lowerBound = 400.0f;
        float upperBound = 450.0f;
        float transitionFactor = playerY < (double)lowerBound ? 0.0f : (playerY > (double)upperBound ? 1.0f : (float)(playerY - (double)lowerBound) / (upperBound - lowerBound));
        float r = 1.0f - transitionFactor;
        float g = 1.0f - transitionFactor;
        float b = 1.0f - transitionFactor;
        RenderSystem.setShaderFogColor((float)r, (float)g, (float)b);
    }

    @Inject(method={"setupColor"}, at={@At(value="RETURN")})
    private static void modifyFogColorByHeight(Camera activeRenderInfo, float partialTicks, ClientLevel level, int renderDistanceChunks, float bossColorModifier, CallbackInfo ci) {
        if (level.dimension() != TBSDimensions.CLAN_VOID && level.dimension() != TBSDimensions.STAGE2) {
            return;
        }
        double playerY = activeRenderInfo.getPosition().y;
        if (Objects.requireNonNull(Minecraft.getInstance().level).dimension() == TBSDimensions.STAGE2 && playerY > 251.1) {
            RenderSystem.setShaderFogColor((float)1.0f, (float)1.0f, (float)1.0f, (float)0.0f);
            return;
        }
        if (playerY < 251.1) {
            RenderSystem.clearColor((float)0.0f, (float)0.0f, (float)0.0f, (float)0.0f);
            return;
        }
        float lowerBound = 400.0f;
        float upperBound = 450.0f;
        float transitionFactor = playerY < (double)lowerBound ? 0.0f : (playerY > (double)upperBound ? 1.0f : (float)(playerY - (double)lowerBound) / (upperBound - lowerBound));
        float whiteR = 1.0f;
        float whiteG = 1.0f;
        float whiteB = 1.0f;
        float blackR = 0.0f;
        float blackG = 0.0f;
        float blackB = 0.0f;
        float currentRed = FogRendererAccessor.getFogRed();
        float currentGreen = FogRendererAccessor.getFogGreen();
        float currentBlue = FogRendererAccessor.getFogBlue();
        float targetR = Mth.lerp((float)transitionFactor, (float)whiteR, (float)blackR);
        float targetG = Mth.lerp((float)transitionFactor, (float)whiteG, (float)blackG);
        float targetB = Mth.lerp((float)transitionFactor, (float)whiteB, (float)blackB);
        float blendStrength = 1.0f;
        float finalR = Mth.lerp((float)blendStrength, (float)currentRed, (float)targetR);
        float finalG = Mth.lerp((float)blendStrength, (float)currentGreen, (float)targetG);
        float finalB = Mth.lerp((float)blendStrength, (float)currentBlue, (float)targetB);
        RenderSystem.clearColor((float)finalR, (float)finalG, (float)finalB, (float)0.0f);
    }
}

