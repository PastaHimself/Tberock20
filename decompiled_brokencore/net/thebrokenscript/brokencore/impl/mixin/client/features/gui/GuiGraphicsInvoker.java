/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.GuiGraphics
 *  net.minecraft.client.renderer.texture.TextureAtlasSprite
 *  net.minecraft.client.resources.metadata.gui.GuiSpriteScaling$NineSlice
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.gen.Invoker
 */
package net.thebrokenscript.brokencore.impl.mixin.client.features.gui;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.resources.metadata.gui.GuiSpriteScaling;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(value={GuiGraphics.class})
public interface GuiGraphicsInvoker {
    @Invoker(value="blitTiledSprite")
    public void bc$blitTiledSprite(TextureAtlasSprite var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12);

    @Invoker(value="blitNineSlicedSprite")
    public void bc$blitNineSlicedSprite(TextureAtlasSprite var1, GuiSpriteScaling.NineSlice var2, int var3, int var4, int var5, int var6, int var7);
}

