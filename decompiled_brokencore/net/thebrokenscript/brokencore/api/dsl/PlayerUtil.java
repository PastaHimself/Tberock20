/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  net.minecraft.core.Holder
 *  net.minecraft.network.chat.Component
 *  net.minecraft.network.protocol.common.custom.CustomPacketPayload
 *  net.minecraft.resources.ResourceKey
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.server.level.ServerPlayer
 *  net.minecraft.sounds.SoundEvent
 *  net.minecraft.sounds.SoundSource
 *  net.minecraft.world.effect.MobEffect
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.level.GameType
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.phys.Vec3
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.brokencore.api.dsl;

import kotlin.Metadata;
import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.brokencore.api.dsl.PlayerUtil__PlayerCheckDSLKt;
import net.thebrokenscript.brokencore.api.dsl.PlayerUtil__PlayerDSLKt;
import net.thebrokenscript.brokencore.api.dsl.PlayerUtil__PlayerPacketDSLKt;
import net.thebrokenscript.brokencore.api.dsl.PlayerUtil__PlayerSoundDSLKt;
import net.thebrokenscript.brokencore.api.entity.base.BaseMonster;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=4, xi=48, d1={"net/thebrokenscript/brokencore/api/dsl/PlayerUtil__PlayerCheckDSLKt", "net/thebrokenscript/brokencore/api/dsl/PlayerUtil__PlayerDSLKt", "net/thebrokenscript/brokencore/api/dsl/PlayerUtil__PlayerPacketDSLKt", "net/thebrokenscript/brokencore/api/dsl/PlayerUtil__PlayerSoundDSLKt"})
public final class PlayerUtil {
    public static final boolean isLookingAt(@NotNull Player $this$isLookingAt, @NotNull Entity entity) {
        return PlayerUtil__PlayerCheckDSLKt.isLookingAt($this$isLookingAt, entity);
    }

    public static final boolean isLookingAtEntityHitbox(@NotNull Player $this$isLookingAtEntityHitbox, @NotNull Entity entity) {
        return PlayerUtil__PlayerCheckDSLKt.isLookingAtEntityHitbox($this$isLookingAtEntityHitbox, entity);
    }

    public static final boolean isMultiplayer(@NotNull Player $this$isMultiplayer) {
        return PlayerUtil__PlayerCheckDSLKt.isMultiplayer($this$isMultiplayer);
    }

    public static final boolean effect(@NotNull Player $this$effect, @NotNull Holder<MobEffect> fx, int duration2, int amplifier, boolean ambient, boolean visible) {
        return PlayerUtil__PlayerDSLKt.effect($this$effect, fx, duration2, amplifier, ambient, visible);
    }

    public static /* synthetic */ boolean effect$default(Player player, Holder holder, int n, int n2, boolean bl, boolean bl2, int n3, Object object) {
        return PlayerUtil__PlayerDSLKt.effect$default(player, holder, n, n2, bl, bl2, n3, object);
    }

    public static final boolean smoothTeleport(@NotNull ServerPlayer $this$smoothTeleport, @NotNull Vec3 targetPos) {
        return PlayerUtil__PlayerDSLKt.smoothTeleport($this$smoothTeleport, targetPos);
    }

    public static final boolean sendTo(@NotNull Player $this$sendTo, @NotNull ResourceKey<Level> dest) {
        return PlayerUtil__PlayerDSLKt.sendTo($this$sendTo, dest);
    }

    public static final void awardAdvancement(@NotNull Player $this$awardAdvancement, @NotNull ResourceLocation location) {
        PlayerUtil__PlayerDSLKt.awardAdvancement($this$awardAdvancement, location);
    }

    @Nullable
    public static final GameType getGameMode(@NotNull Player $this$gameMode) {
        return PlayerUtil__PlayerDSLKt.getGameMode($this$gameMode);
    }

    public static final void setGameMode(@NotNull Player $this$gameMode, @Nullable GameType value) {
        PlayerUtil__PlayerDSLKt.setGameMode($this$gameMode, value);
    }

    public static final void kick(@NotNull ServerPlayer $this$kick, @NotNull Component text) {
        PlayerUtil__PlayerDSLKt.kick($this$kick, text);
    }

    public static final void giveItem(@NotNull Player $this$giveItem, @NotNull ItemStack stack) {
        PlayerUtil__PlayerDSLKt.giveItem($this$giveItem, stack);
    }

    public static final boolean hasLineOfSightThroughTransparent(@NotNull Player $this$hasLineOfSightThroughTransparent, @NotNull BaseMonster target) {
        return PlayerUtil__PlayerDSLKt.hasLineOfSightThroughTransparent($this$hasLineOfSightThroughTransparent, target);
    }

    public static final void tryCrash(@NotNull Player $this$tryCrash) {
        PlayerUtil__PlayerPacketDSLKt.tryCrash($this$tryCrash);
    }

    public static final void trySendOverlay(@NotNull Player $this$trySendOverlay, @NotNull ResourceLocation texture, long duration2) {
        PlayerUtil__PlayerPacketDSLKt.trySendOverlay($this$trySendOverlay, texture, duration2);
    }

    public static final void tryClearOverlays(@NotNull Player $this$tryClearOverlays) {
        PlayerUtil__PlayerPacketDSLKt.tryClearOverlays($this$tryClearOverlays);
    }

    public static final void tryShowAlert(@NotNull Player $this$tryShowAlert, @NotNull String title, @NotNull String message) {
        PlayerUtil__PlayerPacketDSLKt.tryShowAlert($this$tryShowAlert, title, message);
    }

    public static final <P extends CustomPacketPayload> void trySendCustomPacket(@NotNull Player $this$trySendCustomPacket, @NotNull P packet) {
        PlayerUtil__PlayerPacketDSLKt.trySendCustomPacket($this$trySendCustomPacket, packet);
    }

    public static final void setActionBar(@NotNull Player $this$setActionBar, @NotNull Component text) {
        PlayerUtil__PlayerPacketDSLKt.setActionBar($this$setActionBar, text);
    }

    public static final void stopAllSounds(@NotNull Player $this$stopAllSounds) {
        PlayerUtil__PlayerPacketDSLKt.stopAllSounds($this$stopAllSounds);
    }

    public static final <P extends CustomPacketPayload> void sendPacket(@NotNull ServerPlayer $this$sendPacket, @NotNull P packet) {
        PlayerUtil__PlayerPacketDSLKt.sendPacket($this$sendPacket, packet);
    }

    public static final void trySendSound(@NotNull Player $this$trySendSound, @NotNull SoundEvent sound, float volume, float pitch, @NotNull SoundSource source, @NotNull Vec3 pos, long seed) {
        PlayerUtil__PlayerSoundDSLKt.trySendSound($this$trySendSound, sound, volume, pitch, source, pos, seed);
    }

    public static /* synthetic */ void trySendSound$default(Player player, SoundEvent soundEvent, float f, float f2, SoundSource soundSource, Vec3 vec3, long l, int n, Object object) {
        PlayerUtil__PlayerSoundDSLKt.trySendSound$default(player, soundEvent, f, f2, soundSource, vec3, l, n, object);
    }

    public static final void trySendSound(@NotNull Player $this$trySendSound, @NotNull Holder<SoundEvent> sound, float volume, float pitch, @NotNull SoundSource source, @NotNull Vec3 pos, long seed) {
        PlayerUtil__PlayerSoundDSLKt.trySendSound($this$trySendSound, sound, volume, pitch, source, pos, seed);
    }

    public static /* synthetic */ void trySendSound$default(Player player, Holder holder, float f, float f2, SoundSource soundSource, Vec3 vec3, long l, int n, Object object) {
        PlayerUtil__PlayerSoundDSLKt.trySendSound$default(player, holder, f, f2, soundSource, vec3, l, n, object);
    }

    public static final void sendSound(@NotNull ServerPlayer $this$sendSound, @NotNull SoundEvent sound, float volume, float pitch, @NotNull SoundSource source, @NotNull Vec3 pos, long seed) {
        PlayerUtil__PlayerSoundDSLKt.sendSound($this$sendSound, sound, volume, pitch, source, pos, seed);
    }

    public static /* synthetic */ void sendSound$default(ServerPlayer serverPlayer, SoundEvent soundEvent, float f, float f2, SoundSource soundSource, Vec3 vec3, long l, int n, Object object) {
        PlayerUtil__PlayerSoundDSLKt.sendSound$default(serverPlayer, soundEvent, f, f2, soundSource, vec3, l, n, object);
    }

    public static final void sendSound(@NotNull ServerPlayer $this$sendSound, @NotNull Holder<SoundEvent> sound, float volume, float pitch, @NotNull SoundSource source, @NotNull Vec3 pos, long seed) {
        PlayerUtil__PlayerSoundDSLKt.sendSound($this$sendSound, sound, volume, pitch, source, pos, seed);
    }

    public static /* synthetic */ void sendSound$default(ServerPlayer serverPlayer, Holder holder, float f, float f2, SoundSource soundSource, Vec3 vec3, long l, int n, Object object) {
        PlayerUtil__PlayerSoundDSLKt.sendSound$default(serverPlayer, holder, f, f2, soundSource, vec3, l, n, object);
    }
}

