/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.maxhenkel.voicechat.voice.client.ClientManager
 *  de.maxhenkel.voicechat.voice.client.TalkCache
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.player.LocalPlayer
 *  net.minecraft.world.entity.player.Player
 *  net.thebrokenscript.brokencore.api.util.Side
 *  net.thebrokenscript.brokencore.api.util.SideOnly
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package net.thebrokenscript.mixins.compat.voicechat;

import de.maxhenkel.voicechat.voice.client.ClientManager;
import de.maxhenkel.voicechat.voice.client.TalkCache;
import java.util.UUID;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.world.entity.player.Player;
import net.thebrokenscript.api.ext.PlayerExt;
import net.thebrokenscript.brokencore.api.util.Side;
import net.thebrokenscript.brokencore.api.util.SideOnly;
import net.thebrokenscript.compat.voicechat.VoiceChatSupport;
import net.thebrokenscript.data.PlayerVariables;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@SideOnly(side=Side.CLIENT)
@Mixin(value={TalkCache.class})
public class TalkCacheMixin {
    @Unique
    private void tbs$checkCancel(UUID id, CallbackInfo ci) {
        LocalPlayer player = Minecraft.getInstance().player;
        if (player == null) {
            return;
        }
        PlayerVariables vars = PlayerExt.INSTANCE.getVars((Player)player);
        if (!vars.getIsolationActive()) {
            return;
        }
        if (id == ClientManager.getPlayerStateManager().getOwnID()) {
            return;
        }
        if (VoiceChatSupport.getGroupMembers().contains(id)) {
            if (vars.getIsolationAllowedUsers().getEntries().isEmpty()) {
                ci.cancel();
            }
        } else if (!vars.getIsolationAllowedUsers().getEntries().contains(id)) {
            ci.cancel();
        }
    }

    @Inject(method={"updateTalking(Ljava/util/UUID;ZD)V"}, at={@At(value="HEAD")}, cancellable=true)
    public void tbs$stopUpdatingTalking(UUID entity, boolean whispering, double audioLevel, CallbackInfo ci) {
        this.tbs$checkCancel(entity, ci);
    }

    @Inject(method={"updateLevel"}, at={@At(value="HEAD")}, cancellable=true)
    public void tbs$stopUpdatingLevel(UUID id, String category, boolean whispering, short[] audio, CallbackInfo ci) {
        this.tbs$checkCancel(id, ci);
    }
}

