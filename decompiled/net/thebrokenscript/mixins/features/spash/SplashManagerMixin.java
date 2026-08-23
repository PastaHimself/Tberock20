/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.gui.components.SplashRenderer
 *  net.minecraft.client.resources.SplashManager
 *  net.minecraft.util.RandomSource
 *  net.thebrokenscript.brokencore.api.files.UserDirs
 *  org.spongepowered.asm.mixin.Final
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package net.thebrokenscript.mixins.features.spash;

import java.util.UUID;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.SplashRenderer;
import net.minecraft.client.resources.SplashManager;
import net.minecraft.util.RandomSource;
import net.thebrokenscript.brokencore.api.files.UserDirs;
import net.thebrokenscript.config.TBSConfigs;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={SplashManager.class})
public class SplashManagerMixin {
    @Shadow
    @Final
    private static RandomSource RANDOM;

    @Inject(method={"getSplash"}, at={@At(value="RETURN")}, cancellable=true)
    private void tbs$customSplash(CallbackInfoReturnable<SplashRenderer> cir) {
        UUID playerUUID = Minecraft.getInstance().getUser().getProfileId();
        if (RANDOM.nextFloat() < 0.01f) {
            cir.setReturnValue((Object)new SplashRenderer(UserDirs.Companion.home().getAbsolutePath()));
        }
        if (RANDOM.nextFloat() < 0.01f && TBSConfigs.INSTANCE.isLoaded() && TBSConfigs.INSTANCE.getServer().getDanger().getFunnySetting()) {
            cir.setReturnValue((Object)new SplashRenderer("R2 infinity and beyond!"));
        }
    }
}

