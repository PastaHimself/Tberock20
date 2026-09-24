/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.llamalad7.mixinextras.sugar.Local
 *  com.mojang.blaze3d.vertex.VertexConsumer
 *  net.minecraft.client.gui.Font$StringRenderOutput
 *  net.minecraft.client.gui.font.glyphs.BakedGlyph
 *  net.minecraft.client.renderer.MultiBufferSource
 *  net.minecraft.client.renderer.RenderType
 *  net.minecraft.network.chat.Style
 *  org.joml.Matrix4f
 *  org.spongepowered.asm.mixin.Final
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.At$Shift
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package net.thebrokenscript.mixins.features.font;

import com.llamalad7.mixinextras.sugar.Local;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.font.glyphs.BakedGlyph;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.network.chat.Style;
import net.thebrokenscript.mixinterfaces.BakedGlyphExt;
import org.joml.Matrix4f;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={Font.StringRenderOutput.class})
public class FontMixin {
    @Shadow
    float x;
    @Shadow
    float y;
    @Shadow
    @Final
    MultiBufferSource bufferSource;
    @Shadow
    @Final
    private Matrix4f pose;

    @Inject(method={"accept"}, at={@At(value="INVOKE", target="Lnet/minecraft/client/gui/Font;renderChar(Lnet/minecraft/client/gui/font/glyphs/BakedGlyph;ZZFFFLorg/joml/Matrix4f;Lcom/mojang/blaze3d/vertex/VertexConsumer;FFFFI)V", shift=At.Shift.AFTER)})
    private void tbs$drawBox(int positionInCurrentSequence, Style style, int codePoint, CallbackInfoReturnable<Boolean> cir, @Local BakedGlyph glyph, @Local(ordinal=0) float f3, @Local(ordinal=1) float f, @Local(ordinal=2) float f1, @Local(ordinal=3) float f2, @Local(ordinal=4) float f5, @Local(ordinal=5) float f4) {
        if (glyph instanceof BakedGlyphExt) {
            BakedGlyphExt ext = (BakedGlyphExt)glyph;
            VertexConsumer cons = this.bufferSource.getBuffer(RenderType.gui());
            ext.tbs$renderBox(this.x + f4, this.y + f4, this.pose, cons, f, f1, f2, f3);
        }
    }
}

