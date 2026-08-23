/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.WorldVersion
 *  net.minecraft.client.gui.components.DebugScreenOverlay
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Redirect
 */
package net.thebrokenscript.mixins.features.version;

import net.minecraft.WorldVersion;
import net.minecraft.client.gui.components.DebugScreenOverlay;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value={DebugScreenOverlay.class})
public class DebugScreenOverlayMixin {
    @Redirect(method={"getGameInformation"}, at=@At(value="INVOKE", target="Lnet/minecraft/WorldVersion;getName()Ljava/lang/String;"))
    private String replaceVersionCall(WorldVersion instance) {
        return "1.12.2";
    }
}

