/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.player.LocalPlayer
 *  net.minecraft.client.resources.sounds.SoundInstance
 *  net.minecraft.client.sounds.SoundManager
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.sounds.SoundEvent
 *  net.minecraft.sounds.SoundEvents
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.level.LevelAccessor
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package net.thebrokenscript.mixins.features.sounds;

import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.resources.sounds.SoundInstance;
import net.minecraft.client.sounds.SoundManager;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.thebrokenscript.api.ext.LevelExt;
import net.thebrokenscript.api.ext.PlayerExt;
import net.thebrokenscript.config.TBSConfigs;
import net.thebrokenscript.registry.TBSDimensions;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={SoundManager.class})
public class SoundManagerMixin {
    @Unique
    private void tbs$checkMusic(SoundInstance sound, CallbackInfo ci) {
        ResourceLocation location;
        if (sound == null) {
            return;
        }
        if (TBSConfigs.INSTANCE.isLoaded() && sound.getLocation().equals((Object)((SoundEvent)SoundEvents.MUSIC_MENU.value()).getLocation()) && TBSConfigs.INSTANCE.getClient().getEnableMenuMusic()) {
            ci.cancel();
            return;
        }
        Minecraft mc = Minecraft.getInstance();
        LocalPlayer player = mc.player;
        if (!(player == null || !LevelExt.INSTANCE.getVars((LevelAccessor)player.clientLevel).isNullHere() && !TBSDimensions.ALL.stream().anyMatch(dim -> dim.equals(player.level().dimension())) || !(location = sound.getLocation()).getPath().contains("music.") && !location.getPath().contains("music/") || location.getNamespace().equals("thebrokenscript") || location.toString().contains("disc") || PlayerExt.INSTANCE.getVars((Player)player).getMusicCausedByTBS())) {
            ci.cancel();
        }
    }

    @Inject(method={"play"}, at={@At(value="HEAD")}, cancellable=true)
    private void injectPlayDirect(SoundInstance sound, CallbackInfo ci) {
        this.tbs$checkMusic(sound, ci);
    }

    @Inject(method={"playDelayed"}, at={@At(value="HEAD")}, cancellable=true)
    private void injectPlayDelayed(SoundInstance sound, int delay, CallbackInfo ci) {
        this.tbs$checkMusic(sound, ci);
    }
}

