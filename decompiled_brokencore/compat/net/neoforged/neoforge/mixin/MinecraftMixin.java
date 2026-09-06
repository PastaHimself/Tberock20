/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.main.GameConfig
 *  org.jetbrains.annotations.NotNull
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package compat.net.neoforged.neoforge.mixin;

import net.minecraft.client.Minecraft;
import net.minecraft.client.main.GameConfig;
import net.thebrokenscript.brokencore.api.mixinterfaces.MinecraftExt;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={Minecraft.class})
public class MinecraftMixin
implements MinecraftExt {
    @Unique
    private GameConfig brokencore$gameConfig;

    @Inject(method={"<init>"}, at={@At(value="INVOKE", target="Lnet/minecraft/Util;getNanos()J")})
    private void brokencore$saveGameConfig(GameConfig gameConfig, CallbackInfo ci) {
        this.brokencore$gameConfig = gameConfig;
    }

    @Override
    @NotNull
    public GameConfig bc$getGameConfig() {
        return this.brokencore$gameConfig;
    }
}

