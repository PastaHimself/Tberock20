/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.vertex.VertexConsumer
 *  net.minecraft.client.gui.font.GlyphRenderTypes
 *  net.minecraft.client.gui.font.glyphs.BakedGlyph
 *  net.minecraft.util.RandomSource
 *  org.joml.Matrix4f
 *  org.spongepowered.asm.mixin.Final
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Mutable
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package net.thebrokenscript.mixins.features.font;

import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.gui.font.GlyphRenderTypes;
import net.minecraft.client.gui.font.glyphs.BakedGlyph;
import net.minecraft.util.RandomSource;
import net.thebrokenscript.mixinterfaces.BakedGlyphExt;
import org.joml.Matrix4f;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={BakedGlyph.class})
public class BakedGlyphMixin
implements BakedGlyphExt {
    @Shadow
    @Final
    private float right;
    @Shadow
    @Final
    private float left;
    @Shadow
    @Final
    private float up;
    @Shadow
    @Final
    private float down;
    @Mutable
    @Unique
    @Final
    private boolean tbs$hasBox;
    @Mutable
    @Unique
    @Final
    private float tbs$boxX;
    @Mutable
    @Unique
    @Final
    private float tbs$boxY;
    @Mutable
    @Unique
    @Final
    private float tbs$boxWidth;
    @Mutable
    @Unique
    @Final
    private float tbs$boxHeight;

    @Inject(method={"<init>"}, at={@At(value="TAIL")})
    private void tbs$setBox(GlyphRenderTypes renderTypes, float u0, float u1, float v0, float v1, float left, float right, float up, float down, CallbackInfo ci) {
        this.tbs$resetBox(0.0f);
    }

    @Override
    @Unique
    public void tbs$resetBox(float chance) {
        RandomSource random = RandomSource.create();
        boolean bl = this.tbs$hasBox = random.nextFloat() < chance;
        if (this.tbs$hasBox) {
            this.tbs$boxX = random.nextFloat() * (this.right - this.left) + this.left;
            this.tbs$boxY = random.nextFloat() * (this.down - this.up) + this.up;
            this.tbs$boxWidth = random.nextFloat() * (this.right - this.left) + this.left;
            this.tbs$boxHeight = random.nextFloat() * (this.down - this.up) + this.up;
        }
    }

    @Override
    @Unique
    public void tbs$renderBox(float x, float y, Matrix4f matrix, VertexConsumer buffer, float red, float green, float blue, float alpha) {
        if (this.tbs$hasBox) {
            float boxX = x + this.tbs$boxX;
            float boxY = y + this.tbs$boxY;
            this.tbs$fillBox(matrix, buffer, boxX, boxY, boxX + this.tbs$boxWidth, boxY + this.tbs$boxHeight, red, green, blue, alpha);
        }
    }

    @Unique
    private void tbs$fillBox(Matrix4f matrix, VertexConsumer cons, float minX, float minY, float maxX, float maxY, float r, float g, float b, float a) {
        if (minX < maxX) {
            float i = minX;
            minX = maxX;
            maxX = i;
        }
        if (minY < maxY) {
            float j = minY;
            minY = maxY;
            maxY = j;
        }
        cons.addVertex(matrix, minX, minY, 0.0f).setColor(r, g, b, a);
        cons.addVertex(matrix, minX, maxY, 0.0f).setColor(r, g, b, a);
        cons.addVertex(matrix, maxX, maxY, 0.0f).setColor(r, g, b, a);
        cons.addVertex(matrix, maxX, minY, 0.0f).setColor(r, g, b, a);
    }
}

