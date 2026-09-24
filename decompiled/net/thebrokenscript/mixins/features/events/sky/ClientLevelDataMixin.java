/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.llamalad7.mixinextras.injector.ModifyReturnValue
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.multiplayer.ClientLevel$ClientLevelData
 *  net.minecraft.client.player.LocalPlayer
 *  net.minecraft.world.entity.Entity
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 */
package net.thebrokenscript.mixins.features.events.sky;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.world.entity.Entity;
import net.thebrokenscript.data.PlayerVariables;
import net.thebrokenscript.registry.TBSDataAttachments;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(value={ClientLevel.ClientLevelData.class})
public class ClientLevelDataMixin {
    @ModifyReturnValue(method={"getHorizonHeight"}, at={@At(value="RETURN")})
    public double tbs$modifyHorizonHeight(double original) {
        Minecraft mc = Minecraft.getInstance();
        if (mc.player == null) {
            return original;
        }
        LocalPlayer player = mc.player;
        PlayerVariables vars = (PlayerVariables)TBSDataAttachments.PLAYER_VARIABLES.get((Entity)player);
        return vars.getEnableCustomSky() ? -1.0 : original;
    }
}

