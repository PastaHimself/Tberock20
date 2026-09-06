/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.font.CodepointMap
 *  net.minecraft.client.gui.font.FontSet
 *  net.minecraft.client.gui.font.glyphs.BakedGlyph
 *  org.spongepowered.asm.mixin.Final
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 */
package net.thebrokenscript.mixins.features.font;

import net.minecraft.client.gui.font.CodepointMap;
import net.minecraft.client.gui.font.FontSet;
import net.minecraft.client.gui.font.glyphs.BakedGlyph;
import net.thebrokenscript.mixinterfaces.BakedGlyphExt;
import net.thebrokenscript.mixinterfaces.FontSetExt;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(value={FontSet.class})
public class FontSetMixin
implements FontSetExt {
    @Shadow
    @Final
    private CodepointMap<BakedGlyph> glyphs;

    @Override
    public void tbs$resetBoxes(float chance) {
        this.glyphs.forEach((idx, obj) -> {
            if (obj instanceof BakedGlyphExt) {
                BakedGlyphExt ext = (BakedGlyphExt)obj;
                ext.tbs$resetBox(chance);
            }
        });
    }
}

