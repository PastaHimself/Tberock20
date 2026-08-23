/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.gui.screens.PauseScreen
 *  net.minecraft.client.gui.screens.Screen
 *  net.minecraft.client.multiplayer.ClientLevel
 *  net.minecraft.client.player.LocalPlayer
 *  net.minecraft.client.sounds.SoundManager
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.player.Player
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.ModifyVariable
 *  org.spongepowered.asm.mixin.injection.Redirect
 */
package net.thebrokenscript.mixins.features.screen;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.PauseScreen;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.sounds.SoundManager;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.thebrokenscript.api.ext.PlayerExt;
import net.thebrokenscript.client.gui.FakeExitButton;
import net.thebrokenscript.client.gui.FakePauseScreen;
import net.thebrokenscript.handlers.player.ClientPlayerChasingHandler;
import net.thebrokenscript.registry.TBSTags;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value={Minecraft.class})
public class FakePauseMixin {
    @Unique
    private boolean tbs$isSelectedEntityNearby() {
        Minecraft minecraft = Minecraft.getInstance();
        LocalPlayer player = minecraft.player;
        ClientLevel level = minecraft.level;
        if (player == null || level == null) {
            return false;
        }
        boolean isNearby = false;
        for (Entity e : level.entitiesForRendering()) {
            if (!e.getType().is(TBSTags.META_PARANOIA_TRIGGERS) || !ClientPlayerChasingHandler.isBeingChased) continue;
            isNearby = true;
            if (e.getType().is(TBSTags.META_PARANOIA_TRIGGERS_GLITCH)) {
                FakeExitButton.metaType = "glitch";
                break;
            }
            if (!e.getType().is(TBSTags.META_PARANOIA_TRIGGERS_CORRUPT)) break;
            FakeExitButton.metaType = "corrupt";
            break;
        }
        return isNearby;
    }

    @ModifyVariable(method={"setScreen"}, at=@At(value="HEAD"), argsOnly=true)
    private Screen tbs$replacePause(Screen original) {
        Minecraft mc = Minecraft.getInstance();
        if (original instanceof PauseScreen && (this.tbs$isSelectedEntityNearby() || mc.player != null && PlayerExt.INSTANCE.getVars((Player)mc.player).getMetaParanoia())) {
            return new FakePauseScreen();
        }
        return original;
    }

    @Redirect(method={"pauseGame"}, at=@At(value="INVOKE", target="Lnet/minecraft/client/sounds/SoundManager;pause()V"))
    private void tbs$skipPauseWhenFake(SoundManager instance) {
        Minecraft mc = (Minecraft)this;
        if (!(mc.screen instanceof FakePauseScreen)) {
            instance.pause();
        }
    }
}

