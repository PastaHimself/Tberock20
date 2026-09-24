/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.authlib.GameProfile
 *  net.minecraft.server.players.GameProfileCache
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package net.thebrokenscript.mixins.features.fake;

import com.mojang.authlib.GameProfile;
import java.util.Objects;
import java.util.Optional;
import net.minecraft.server.players.GameProfileCache;
import net.thebrokenscript.misc.GameProfiles;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={GameProfileCache.class})
public class GameProfileCacheMixin {
    @Inject(method={"get(Ljava/lang/String;)Ljava/util/Optional;"}, at={@At(value="RETURN")}, cancellable=true)
    public void injectIntegrity(String name, CallbackInfoReturnable<Optional<GameProfile>> cir) {
        if (Objects.equals(name, "Integrity")) {
            cir.setReturnValue(Optional.of(GameProfiles.INTEGRITY_GAME_PROFILE));
        }
    }
}

