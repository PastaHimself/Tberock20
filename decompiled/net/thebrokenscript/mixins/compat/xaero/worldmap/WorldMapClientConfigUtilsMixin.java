/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 *  xaero.map.config.util.WorldMapClientConfigUtils
 */
package net.thebrokenscript.mixins.compat.xaero.worldmap;

import net.minecraft.client.Minecraft;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import xaero.map.config.util.WorldMapClientConfigUtils;

@Mixin(value={WorldMapClientConfigUtils.class})
public class WorldMapClientConfigUtilsMixin {
    @Inject(method={"getEffectiveCaveModeAllowed"}, at={@At(value="HEAD")}, cancellable=true)
    private static void tbs$begoneXaeroWorldMapCaveMode(CallbackInfoReturnable<Boolean> cir) {
        Minecraft mc = Minecraft.getInstance();
        if (mc.level != null && mc.level.dimension().location().getNamespace().equals("thebrokenscript") && !mc.level.dimension().location().getPath().equals("nowhere")) {
            cir.setReturnValue((Object)false);
        }
    }
}

