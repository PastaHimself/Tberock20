/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.llamalad7.mixinextras.injector.ModifyReturnValue
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.player.LocalPlayer
 *  net.minecraft.client.renderer.DimensionSpecialEffects
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.phys.Vec3
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 */
package net.thebrokenscript.mixins.features.events.sky;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.DimensionSpecialEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.data.PlayerVariables;
import net.thebrokenscript.registry.TBSDataAttachments;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(value={DimensionSpecialEffects.class})
public class DimensionSpecialEffectsMixin {
    @ModifyReturnValue(method={"getSunriseColor"}, at={@At(value="RETURN")})
    public float[] tbs$modifySunriseColor(float[] original) {
        float[] fArray;
        Minecraft mc = Minecraft.getInstance();
        if (mc.player == null) {
            return original;
        }
        LocalPlayer player = mc.player;
        PlayerVariables vars = (PlayerVariables)TBSDataAttachments.PLAYER_VARIABLES.get((Entity)player);
        Vec3 color = vars.getCustomSkyColor();
        if (vars.getEnableCustomSky()) {
            float[] fArray2 = new float[4];
            fArray2[0] = (float)color.x;
            fArray2[1] = (float)color.y;
            fArray2[2] = (float)color.z;
            fArray = fArray2;
            fArray2[3] = 1.0f;
        } else {
            fArray = original;
        }
        return fArray;
    }
}

