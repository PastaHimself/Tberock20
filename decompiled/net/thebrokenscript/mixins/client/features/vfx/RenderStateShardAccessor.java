/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.renderer.RenderStateShard
 *  net.minecraft.client.renderer.RenderStateShard$LightmapStateShard
 *  net.minecraft.client.renderer.RenderStateShard$TextureStateShard
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.gen.Accessor
 */
package net.thebrokenscript.mixins.client.features.vfx;

import net.minecraft.client.renderer.RenderStateShard;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value={RenderStateShard.class})
public interface RenderStateShardAccessor {
    @Accessor(value="LIGHTMAP")
    public static RenderStateShard.LightmapStateShard getLightmap() {
        throw new AssertionError((Object)"Implemented by mixin");
    }

    @Accessor(value="BLOCK_SHEET")
    public static RenderStateShard.TextureStateShard getBlockSheet() {
        throw new AssertionError((Object)"Implemented by mixin");
    }

    @Accessor(value="BLOCK_SHEET_MIPPED")
    public static RenderStateShard.TextureStateShard getBlockSheetMipped() {
        throw new AssertionError((Object)"Implemented by mixin");
    }
}

