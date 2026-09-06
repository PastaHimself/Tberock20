/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.llamalad7.mixinextras.injector.ModifyReturnValue
 *  javax.annotation.Nullable
 *  net.minecraft.client.multiplayer.PlayerInfo
 *  net.minecraft.client.player.AbstractClientPlayer
 *  net.minecraft.client.resources.PlayerSkin
 *  net.minecraft.resources.ResourceLocation
 *  net.thebrokenscript.brokencore.api.util.Side
 *  net.thebrokenscript.brokencore.api.util.SideOnly
 *  net.thebrokenscript.brokencore.api.util.system.FileHelper
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.injection.At
 */
package net.thebrokenscript.mixins.features.cape;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import javax.annotation.Nullable;
import net.minecraft.client.multiplayer.PlayerInfo;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.resources.PlayerSkin;
import net.minecraft.resources.ResourceLocation;
import net.thebrokenscript.api.TBSConstants;
import net.thebrokenscript.api.misc.CapeLoader;
import net.thebrokenscript.brokencore.api.util.Side;
import net.thebrokenscript.brokencore.api.util.SideOnly;
import net.thebrokenscript.brokencore.api.util.system.FileHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;

@SideOnly(side=Side.CLIENT)
@Mixin(value={AbstractClientPlayer.class})
public abstract class AbstractClientPlayerMixin {
    @Shadow
    @Nullable
    protected abstract PlayerInfo getPlayerInfo();

    @ModifyReturnValue(method={"getSkin"}, at={@At(value="RETURN")})
    private PlayerSkin getCapeTexture(PlayerSkin original) {
        ResourceLocation id;
        PlayerInfo playerInfo = this.getPlayerInfo();
        if (playerInfo == null) {
            return original;
        }
        String fileName = CapeLoader.getCapes().get(playerInfo.getProfile().getId());
        if (fileName != null && FileHelper.fileExists((ResourceLocation)(id = TBSConstants.id("textures/cape/" + fileName + ".png")))) {
            return new PlayerSkin(original.texture(), original.textureUrl(), id, original.elytraTexture(), original.model(), original.secure());
        }
        return original;
    }
}

