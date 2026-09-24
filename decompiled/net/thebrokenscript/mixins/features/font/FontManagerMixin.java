/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.font.FontManager
 *  net.minecraft.client.gui.font.FontSet
 *  net.minecraft.resources.ResourceLocation
 *  org.spongepowered.asm.mixin.Final
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 */
package net.thebrokenscript.mixins.features.font;

import java.util.Map;
import net.minecraft.client.gui.font.FontManager;
import net.minecraft.client.gui.font.FontSet;
import net.minecraft.resources.ResourceLocation;
import net.thebrokenscript.mixinterfaces.FontManagerExt;
import net.thebrokenscript.mixinterfaces.FontSetExt;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(value={FontManager.class})
public class FontManagerMixin
implements FontManagerExt {
    @Shadow
    @Final
    private Map<ResourceLocation, FontSet> fontSets;

    @Override
    public void tbs$resetBoxes(float chance) {
        for (FontSet set : this.fontSets.values()) {
            if (!(set instanceof FontSetExt)) continue;
            FontSetExt ext = (FontSetExt)set;
            ext.tbs$resetBoxes(chance);
        }
    }
}

