/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 *  xaero.hud.minimap.module.MinimapRenderer
 */
package net.thebrokenscript.mixins.compat.xaero.minimap;

import net.minecraft.client.Minecraft;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import xaero.hud.minimap.module.MinimapRenderer;

@Mixin(value={MinimapRenderer.class})
public class MinimapRendererMixin {
    @Inject(method={"render(Lxaero/hud/minimap/module/MinimapSession;Lxaero/hud/render/module/ModuleRenderContext;Lnet/minecraft/client/gui/GuiGraphics;F)V"}, at={@At(value="HEAD")}, cancellable=true)
    public void tbs$begoneXaeroMinimap(CallbackInfo ci) {
        Minecraft mc = Minecraft.getInstance();
        if (mc.level != null && mc.level.dimension().location().getNamespace().equals("thebrokenscript") && !mc.level.dimension().location().getPath().equals("nowhere")) {
            ci.cancel();
        }
    }
}

