/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.multiplayer.ClientLevel$ClientLevelData
 *  net.minecraft.client.renderer.FogRenderer
 *  net.minecraft.world.entity.player.Player
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.ModifyArg
 *  org.spongepowered.asm.mixin.injection.Redirect
 */
package net.thebrokenscript.mixins.features.render;

import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.FogRenderer;
import net.minecraft.world.entity.player.Player;
import net.thebrokenscript.api.ext.PlayerExt;
import net.thebrokenscript.config.TBSConfigs;
import net.thebrokenscript.util.MoonGlitchState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value={FogRenderer.class})
public class FogRendererMixin {
    @Unique
    private static float tbs$moonGlitchTimer = 0.0f;
    @Unique
    private static long tbs$lastUpdateTime = 0L;

    @ModifyArg(method={"setupFog"}, at=@At(value="INVOKE", target="Lcom/mojang/blaze3d/systems/RenderSystem;setShaderFogStart(F)V"), index=0)
    private static float tbs$setUpBlackoutStartFog(float value) {
        if (TBSConfigs.INSTANCE.getClient().getEnableMoonGlitch() && !Minecraft.getInstance().isPaused() && Minecraft.getInstance().player != null && (PlayerExt.INSTANCE.getVars((Player)Minecraft.getInstance().player).getMoonGlitchDuration() > 0.0 || tbs$moonGlitchTimer != 0.0f)) {
            FogRendererMixin.tbs$checkGlitchTimer();
        }
        return value / (tbs$moonGlitchTimer + 1.0f);
    }

    @ModifyArg(method={"setupFog"}, at=@At(value="INVOKE", target="Lcom/mojang/blaze3d/systems/RenderSystem;setShaderFogEnd(F)V"), index=0)
    private static float tbs$setUpBlackoutEndFog(float value) {
        return value / (tbs$moonGlitchTimer + 1.0f);
    }

    @Redirect(method={"setupColor"}, at=@At(value="INVOKE", target="Lnet/minecraft/client/multiplayer/ClientLevel$ClientLevelData;getClearColorScale()F"))
    private static float tbs$blackoutHugeFog(ClientLevel.ClientLevelData instance) {
        return instance.getClearColorScale() + tbs$moonGlitchTimer / 1.5f;
    }

    @Unique
    private static void tbs$checkGlitchTimer() {
        long currentTime = System.currentTimeMillis();
        if (tbs$lastUpdateTime == 0L) {
            tbs$lastUpdateTime = currentTime;
            MoonGlitchState.timer = tbs$moonGlitchTimer;
            return;
        }
        float deltaTime = (float)(currentTime - tbs$lastUpdateTime) / 1000.0f;
        tbs$lastUpdateTime = currentTime;
        deltaTime = Math.min(deltaTime, 0.1f);
        if (Minecraft.getInstance().player != null && PlayerExt.INSTANCE.getVars((Player)Minecraft.getInstance().player).getMoonGlitchDuration() > 0.0 && tbs$moonGlitchTimer < 10.0f) {
            tbs$moonGlitchTimer += 2.2f * deltaTime;
            tbs$moonGlitchTimer = Math.min(tbs$moonGlitchTimer, 10.0f);
        } else if (Minecraft.getInstance().player != null && PlayerExt.INSTANCE.getVars((Player)Minecraft.getInstance().player).getMoonGlitchDuration() == 0.0 && tbs$moonGlitchTimer != 0.0f && (tbs$moonGlitchTimer -= 3.0f * deltaTime) < 0.0f) {
            tbs$moonGlitchTimer = 0.0f;
            tbs$lastUpdateTime = 0L;
        }
        MoonGlitchState.timer = tbs$moonGlitchTimer;
    }
}

