/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.systems.RenderSystem
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.gui.GuiGraphics
 *  net.minecraft.client.gui.screens.inventory.InventoryScreen
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.world.level.LevelAccessor
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package net.thebrokenscript.mixins.features.inventory;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.InventoryScreen;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.LevelAccessor;
import net.thebrokenscript.api.TBSConstants;
import net.thebrokenscript.api.ext.LevelExt;
import net.thebrokenscript.mixins.features.inventory.AbstractContainerScreenAccessor;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={InventoryScreen.class})
public class InventoryScreenMixin {
    @Inject(method={"renderBg"}, at={@At(value="TAIL")})
    private void tbs$corruptedInventoryOverlay(GuiGraphics guiGraphics, float partialTick, int mouseX, int mouseY, CallbackInfo ci) {
        int stage;
        Minecraft mc = Minecraft.getInstance();
        if (mc.player != null && (stage = LevelExt.INSTANCE.getVars((LevelAccessor)mc.player.level()).getInventoryCorruption()) > 0) {
            ResourceLocation frame = TBSConstants.id("textures/gui/playercorruption/inventorycorruption" + stage + "_" + (mc.player.tickCount / 3 % 3 + 1) + ".png");
            AbstractContainerScreenAccessor accessor = (AbstractContainerScreenAccessor)((Object)this);
            RenderSystem.enableBlend();
            RenderSystem.defaultBlendFunc();
            guiGraphics.blit(frame, accessor.tbs$getLeftPos(), accessor.tbs$getTopPos(), 0, 0, 176, 166);
            RenderSystem.disableBlend();
        }
    }
}

