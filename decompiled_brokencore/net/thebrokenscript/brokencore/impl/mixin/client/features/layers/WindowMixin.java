/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.platform.Window
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package net.thebrokenscript.brokencore.impl.mixin.client.features.layers;

import com.mojang.blaze3d.platform.Window;
import net.thebrokenscript.brokencore.api.render.BufferStateShard;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={Window.class})
public abstract class WindowMixin {
    @Inject(method={"onFramebufferResize"}, at={@At(value="TAIL")})
    public void bc$updateBufferShards(long window, int framebufferWidth, int framebufferHeight, CallbackInfo ci) {
        BufferStateShard.Companion.getShards$brokencore_common().forEach(it -> it.invoke((Object)framebufferWidth, (Object)framebufferHeight));
    }
}

