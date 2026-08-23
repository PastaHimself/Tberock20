/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.commands.arguments.EntityAnchorArgument$Anchor
 *  net.minecraft.core.Holder
 *  net.minecraft.network.chat.Component
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.server.level.ServerPlayer
 *  net.minecraft.sounds.SoundEvent
 *  net.minecraft.sounds.SoundSource
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.phys.Vec3
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.ext;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.commands.arguments.EntityAnchorArgument;
import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.brokencore.api.dsl.PlayerUtil;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J*\u0010\u0004\u001a\u00020\u0005\"\b\b\u0000\u0010\u0006*\u00020\u0007*\b\u0012\u0004\u0012\u0002H\u00060\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ*\u0010\r\u001a\u00020\u0005\"\b\b\u0000\u0010\u0006*\u00020\u0007*\b\u0012\u0004\u0012\u0002H\u00060\b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J\u001a\u0010\u0012\u001a\u00020\u0005\"\b\b\u0000\u0010\u0006*\u00020\u0007*\b\u0012\u0004\u0012\u0002H\u00060\bJ\u001a\u0010\u0013\u001a\u00020\u0005\"\b\b\u0000\u0010\u0006*\u00020\u0007*\b\u0012\u0004\u0012\u0002H\u00060\bJR\u0010\u0014\u001a\u00020\u0005\"\b\b\u0000\u0010\u0006*\u00020\u0007*\b\u0012\u0004\u0012\u0002H\u00060\b2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001a2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u0011JX\u0010\u0014\u001a\u00020\u0005\"\b\b\u0000\u0010\u0006*\u00020\u0007*\b\u0012\u0004\u0012\u0002H\u00060\b2\u0006\u0010\u0015\u001a\u00020\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u001f2\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001a2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u0011JR\u0010 \u001a\u00020\u0005\"\b\b\u0000\u0010\u0006*\u00020!*\b\u0012\u0004\u0012\u0002H\u00060\b2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001a2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u0011JX\u0010 \u001a\u00020\u0005\"\b\b\u0000\u0010\u0006*\u00020!*\b\u0012\u0004\u0012\u0002H\u00060\b2\u0006\u0010\u0015\u001a\u00020\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u001f2\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001a2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u0011J\u001a\u0010\"\u001a\u00020\u0005\"\b\b\u0000\u0010\u0006*\u00020!*\b\u0012\u0004\u0012\u0002H\u00060\bJ\"\u0010#\u001a\u00020\u0005\"\b\b\u0000\u0010\u0006*\u00020!*\b\u0012\u0004\u0012\u0002H\u00060\b2\u0006\u0010$\u001a\u00020%\u00a8\u0006&"}, d2={"Lnet/thebrokenscript/brokencore/api/ext/PlayerListExt;", "", "<init>", "()V", "lookAt", "", "T", "Lnet/minecraft/world/entity/player/Player;", "", "anchor", "Lnet/minecraft/commands/arguments/EntityAnchorArgument$Anchor;", "pos", "Lnet/minecraft/world/phys/Vec3;", "trySendOverlay", "texture", "Lnet/minecraft/resources/ResourceLocation;", "duration", "", "tryClearOverlays", "tryCrash", "trySendSound", "level", "Lnet/minecraft/world/level/LevelAccessor;", "sound", "Lnet/minecraft/sounds/SoundEvent;", "volume", "", "pitch", "source", "Lnet/minecraft/sounds/SoundSource;", "seed", "Lnet/minecraft/core/Holder;", "sendSound", "Lnet/minecraft/server/level/ServerPlayer;", "stopAllSounds", "kick", "text", "Lnet/minecraft/network/chat/Component;", "brokencore-common"})
@SourceDebugExtension(value={"SMAP\nPlayerListExt.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PlayerListExt.kt\nnet/thebrokenscript/brokencore/api/ext/PlayerListExt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,63:1\n1869#2,2:64\n1869#2,2:66\n1869#2,2:68\n1869#2,2:70\n1869#2,2:72\n1869#2,2:74\n1869#2,2:76\n1869#2,2:78\n1869#2,2:80\n1869#2,2:82\n*S KotlinDebug\n*F\n+ 1 PlayerListExt.kt\nnet/thebrokenscript/brokencore/api/ext/PlayerListExt\n*L\n16#1:64,2\n19#1:66,2\n21#1:68,2\n22#1:70,2\n31#1:72,2\n40#1:74,2\n49#1:76,2\n58#1:78,2\n60#1:80,2\n61#1:82,2\n*E\n"})
public final class PlayerListExt {
    @NotNull
    public static final PlayerListExt INSTANCE = new PlayerListExt();

    private PlayerListExt() {
    }

    public final <T extends Player> void lookAt(@NotNull List<? extends T> $this$lookAt, @NotNull EntityAnchorArgument.Anchor anchor, @NotNull Vec3 pos) {
        Intrinsics.checkNotNullParameter($this$lookAt, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)anchor, (String)"anchor");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        Iterable $this$forEach$iv = $this$lookAt;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            Player it = (Player)element$iv;
            boolean bl = false;
            ((LivingEntity)it).lookAt(anchor, pos);
        }
    }

    public final <T extends Player> void trySendOverlay(@NotNull List<? extends T> $this$trySendOverlay, @NotNull ResourceLocation texture, long duration2) {
        Intrinsics.checkNotNullParameter($this$trySendOverlay, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)texture, (String)"texture");
        Iterable $this$forEach$iv = $this$trySendOverlay;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            Player it = (Player)element$iv;
            boolean bl = false;
            PlayerUtil.trySendOverlay(it, texture, duration2);
        }
    }

    public final <T extends Player> void tryClearOverlays(@NotNull List<? extends T> $this$tryClearOverlays) {
        Intrinsics.checkNotNullParameter($this$tryClearOverlays, (String)"<this>");
        Iterable $this$forEach$iv = $this$tryClearOverlays;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            Player it = (Player)element$iv;
            boolean bl = false;
            PlayerUtil.tryClearOverlays(it);
        }
    }

    public final <T extends Player> void tryCrash(@NotNull List<? extends T> $this$tryCrash) {
        Intrinsics.checkNotNullParameter($this$tryCrash, (String)"<this>");
        Iterable $this$forEach$iv = $this$tryCrash;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            Player it = (Player)element$iv;
            boolean bl = false;
            PlayerUtil.tryCrash(it);
        }
    }

    public final <T extends Player> void trySendSound(@NotNull List<? extends T> $this$trySendSound, @NotNull LevelAccessor level, @NotNull SoundEvent sound, float volume, float pitch, @NotNull SoundSource source, long seed) {
        Intrinsics.checkNotNullParameter($this$trySendSound, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)sound, (String)"sound");
        Intrinsics.checkNotNullParameter((Object)source, (String)"source");
        Iterable $this$forEach$iv = $this$trySendSound;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            Player it = (Player)element$iv;
            boolean bl = false;
            Vec3 vec3 = ((Entity)it).position();
            Intrinsics.checkNotNullExpressionValue((Object)vec3, (String)"position(...)");
            PlayerUtil.trySendSound(it, sound, volume, pitch, source, vec3, seed);
        }
    }

    public static /* synthetic */ void trySendSound$default(PlayerListExt playerListExt, List list, LevelAccessor levelAccessor, SoundEvent soundEvent, float f, float f2, SoundSource soundSource, long l, int n, Object object) {
        if ((n & 4) != 0) {
            f = 1.0f;
        }
        if ((n & 8) != 0) {
            f2 = 1.0f;
        }
        if ((n & 0x10) != 0) {
            soundSource = SoundSource.MASTER;
        }
        if ((n & 0x20) != 0) {
            l = levelAccessor.getRandom().nextLong();
        }
        playerListExt.trySendSound(list, levelAccessor, soundEvent, f, f2, soundSource, l);
    }

    public final <T extends Player> void trySendSound(@NotNull List<? extends T> $this$trySendSound, @NotNull LevelAccessor level, @NotNull Holder<SoundEvent> sound, float volume, float pitch, @NotNull SoundSource source, long seed) {
        Intrinsics.checkNotNullParameter($this$trySendSound, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter(sound, (String)"sound");
        Intrinsics.checkNotNullParameter((Object)source, (String)"source");
        Iterable $this$forEach$iv = $this$trySendSound;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            Player it = (Player)element$iv;
            boolean bl = false;
            Vec3 vec3 = ((Entity)it).position();
            Intrinsics.checkNotNullExpressionValue((Object)vec3, (String)"position(...)");
            PlayerUtil.trySendSound(it, sound, volume, pitch, source, vec3, seed);
        }
    }

    public static /* synthetic */ void trySendSound$default(PlayerListExt playerListExt, List list, LevelAccessor levelAccessor, Holder holder, float f, float f2, SoundSource soundSource, long l, int n, Object object) {
        if ((n & 4) != 0) {
            f = 1.0f;
        }
        if ((n & 8) != 0) {
            f2 = 1.0f;
        }
        if ((n & 0x10) != 0) {
            soundSource = SoundSource.MASTER;
        }
        if ((n & 0x20) != 0) {
            l = levelAccessor.getRandom().nextLong();
        }
        playerListExt.trySendSound(list, levelAccessor, (Holder<SoundEvent>)holder, f, f2, soundSource, l);
    }

    public final <T extends ServerPlayer> void sendSound(@NotNull List<? extends T> $this$sendSound, @NotNull LevelAccessor level, @NotNull SoundEvent sound, float volume, float pitch, @NotNull SoundSource source, long seed) {
        Intrinsics.checkNotNullParameter($this$sendSound, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)sound, (String)"sound");
        Intrinsics.checkNotNullParameter((Object)source, (String)"source");
        Iterable $this$forEach$iv = $this$sendSound;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            ServerPlayer it = (ServerPlayer)element$iv;
            boolean bl = false;
            Vec3 vec3 = ((Entity)it).position();
            Intrinsics.checkNotNullExpressionValue((Object)vec3, (String)"position(...)");
            PlayerUtil.sendSound(it, sound, volume, pitch, source, vec3, seed);
        }
    }

    public static /* synthetic */ void sendSound$default(PlayerListExt playerListExt, List list, LevelAccessor levelAccessor, SoundEvent soundEvent, float f, float f2, SoundSource soundSource, long l, int n, Object object) {
        if ((n & 4) != 0) {
            f = 1.0f;
        }
        if ((n & 8) != 0) {
            f2 = 1.0f;
        }
        if ((n & 0x10) != 0) {
            soundSource = SoundSource.MASTER;
        }
        if ((n & 0x20) != 0) {
            l = levelAccessor.getRandom().nextLong();
        }
        playerListExt.sendSound(list, levelAccessor, soundEvent, f, f2, soundSource, l);
    }

    public final <T extends ServerPlayer> void sendSound(@NotNull List<? extends T> $this$sendSound, @NotNull LevelAccessor level, @NotNull Holder<SoundEvent> sound, float volume, float pitch, @NotNull SoundSource source, long seed) {
        Intrinsics.checkNotNullParameter($this$sendSound, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter(sound, (String)"sound");
        Intrinsics.checkNotNullParameter((Object)source, (String)"source");
        Iterable $this$forEach$iv = $this$sendSound;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            ServerPlayer it = (ServerPlayer)element$iv;
            boolean bl = false;
            Vec3 vec3 = ((Entity)it).position();
            Intrinsics.checkNotNullExpressionValue((Object)vec3, (String)"position(...)");
            PlayerUtil.sendSound(it, sound, volume, pitch, source, vec3, seed);
        }
    }

    public static /* synthetic */ void sendSound$default(PlayerListExt playerListExt, List list, LevelAccessor levelAccessor, Holder holder, float f, float f2, SoundSource soundSource, long l, int n, Object object) {
        if ((n & 4) != 0) {
            f = 1.0f;
        }
        if ((n & 8) != 0) {
            f2 = 1.0f;
        }
        if ((n & 0x10) != 0) {
            soundSource = SoundSource.MASTER;
        }
        if ((n & 0x20) != 0) {
            l = levelAccessor.getRandom().nextLong();
        }
        playerListExt.sendSound(list, levelAccessor, (Holder<SoundEvent>)holder, f, f2, soundSource, l);
    }

    public final <T extends ServerPlayer> void stopAllSounds(@NotNull List<? extends T> $this$stopAllSounds) {
        Intrinsics.checkNotNullParameter($this$stopAllSounds, (String)"<this>");
        Iterable $this$forEach$iv = $this$stopAllSounds;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            ServerPlayer it = (ServerPlayer)element$iv;
            boolean bl = false;
            PlayerUtil.stopAllSounds((Player)it);
        }
    }

    public final <T extends ServerPlayer> void kick(@NotNull List<? extends T> $this$kick, @NotNull Component text) {
        Intrinsics.checkNotNullParameter($this$kick, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)text, (String)"text");
        Iterable $this$forEach$iv = $this$kick;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            ServerPlayer it = (ServerPlayer)element$iv;
            boolean bl = false;
            PlayerUtil.kick(it, text);
        }
    }
}

