/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.llamalad7.mixinextras.injector.ModifyReturnValue
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.player.LocalPlayer
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.level.biome.BiomeSpecialEffects
 *  net.minecraft.world.phys.Vec3
 *  net.thebrokenscript.brokencore.api.util.Side
 *  net.thebrokenscript.brokencore.api.util.SideOnly
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 */
package net.thebrokenscript.mixins.features.events.sky;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.biome.BiomeSpecialEffects;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.brokencore.api.util.Side;
import net.thebrokenscript.brokencore.api.util.SideOnly;
import net.thebrokenscript.data.PlayerVariables;
import net.thebrokenscript.registry.TBSDataAttachments;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@SideOnly(side=Side.CLIENT)
@Mixin(value={BiomeSpecialEffects.class})
public class BiomeEffectsMixin {
    @ModifyReturnValue(method={"getFogColor"}, at={@At(value="RETURN")})
    public int tbs$modifyFog(int original) {
        Minecraft mc = Minecraft.getInstance();
        if (mc.player == null) {
            return original;
        }
        LocalPlayer player = mc.player;
        PlayerVariables vars = (PlayerVariables)TBSDataAttachments.PLAYER_VARIABLES.get((Entity)player);
        Vec3 color = vars.getCustomSkyColor();
        int r = (int)(color.x * 255.0) << 16;
        int g = (int)(color.y * 255.0) << 8;
        int b = (int)(color.z * 255.0);
        return vars.getEnableCustomSky() ? r | g | b : original;
    }
}

