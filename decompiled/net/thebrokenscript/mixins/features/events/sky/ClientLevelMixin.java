/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.llamalad7.mixinextras.injector.ModifyReturnValue
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.multiplayer.ClientLevel
 *  net.minecraft.client.player.LocalPlayer
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.phys.Vec3
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 */
package net.thebrokenscript.mixins.features.events.sky;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.data.PlayerVariables;
import net.thebrokenscript.registry.TBSDataAttachments;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(value={ClientLevel.class})
public class ClientLevelMixin {
    @ModifyReturnValue(method={"getSkyColor"}, at={@At(value="RETURN")})
    public Vec3 tbs$modifySkyColor(Vec3 original) {
        Minecraft mc = Minecraft.getInstance();
        if (mc.player == null) {
            return original;
        }
        LocalPlayer player = mc.player;
        PlayerVariables vars = (PlayerVariables)TBSDataAttachments.PLAYER_VARIABLES.get((Entity)player);
        return vars.getEnableCustomSky() ? vars.getCustomSkyColor() : original;
    }
}

