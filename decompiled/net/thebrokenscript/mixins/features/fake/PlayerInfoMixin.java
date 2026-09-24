/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.authlib.GameProfile
 *  net.minecraft.client.multiplayer.PlayerInfo
 *  net.minecraft.client.resources.PlayerSkin
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package net.thebrokenscript.mixins.features.fake;

import com.mojang.authlib.GameProfile;
import java.util.function.Supplier;
import net.minecraft.client.multiplayer.PlayerInfo;
import net.minecraft.client.resources.PlayerSkin;
import net.thebrokenscript.misc.PlayerInfos;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={PlayerInfo.class})
public class PlayerInfoMixin {
    @Inject(method={"createSkinLookup"}, at={@At(value="HEAD")}, cancellable=true)
    private static void modifySkinLookup(GameProfile profile, CallbackInfoReturnable<Supplier<PlayerSkin>> cir) {
        String id = profile.getId().toString();
        if (id.equals("00000000-0000-0000-0000-000000000000")) {
            cir.setReturnValue(() -> PlayerInfos.NULL_SKIN);
            cir.cancel();
        }
    }
}

