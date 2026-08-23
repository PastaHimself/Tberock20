/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.renderer.FogRenderer
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.gen.Accessor
 */
package net.thebrokenscript.mixins.features.vfx;

import net.minecraft.client.renderer.FogRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value={FogRenderer.class})
public interface FogRendererAccessor {
    @Accessor(value="fogRed")
    public static float getFogRed() {
        throw new AssertionError();
    }

    @Accessor(value="fogGreen")
    public static float getFogGreen() {
        throw new AssertionError();
    }

    @Accessor(value="fogBlue")
    public static float getFogBlue() {
        throw new AssertionError();
    }
}

