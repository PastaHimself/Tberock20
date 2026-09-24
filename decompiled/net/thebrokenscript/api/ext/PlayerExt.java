/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.network.protocol.common.custom.CustomPacketPayload
 *  net.minecraft.server.level.ServerPlayer
 *  net.minecraft.sounds.SoundEvent
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.phys.Vec3
 *  net.thebrokenscript.brokencore.api.dsl.PlayerUtil
 *  net.thebrokenscript.brokencore.api.learner.util.PlayerBase
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.api.ext;

import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.boss.kerfur.CustomMusicPayload;
import net.thebrokenscript.brokencore.api.dsl.PlayerUtil;
import net.thebrokenscript.brokencore.api.learner.util.PlayerBase;
import net.thebrokenscript.data.PlayerVariables;
import net.thebrokenscript.network.SetWindowedPacket;
import net.thebrokenscript.registry.TBSDataAttachments;
import net.thebrokenscript.registry.TBSPackets;
import net.thebrokenscript.util.InteractionTracker;
import net.thebrokenscript.util.ReputationEnum;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\u0014\u001a\u00020\u0015*\u00020\u0016J\u001c\u0010\u0017\u001a\u00020\u0018*\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001cJ\u0012\u0010\u001d\u001a\u00020\u0018*\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u001aJ:\u0010\u001e\u001a\u00020\u0018*\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010!\u001a\u00020\u001c2\b\b\u0002\u0010\"\u001a\u00020\u001cJ:\u0010#\u001a\u00020\u0018*\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010!\u001a\u00020\u001c2\b\b\u0002\u0010\"\u001a\u00020\u001cJ:\u0010$\u001a\u00020\u0018*\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010!\u001a\u00020\u001c2\b\b\u0002\u0010\"\u001a\u00020\u001cJ0\u0010%\u001a\u00020\u0018*\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\"\u001a\u00020\u001cJ#\u0010,\u001a\u00020 *\u00020\u00072\u0006\u0010-\u001a\u00020.2\n\b\u0002\u0010/\u001a\u0004\u0018\u00010&\u00a2\u0006\u0002\u00100J#\u00101\u001a\u00020\u0018*\u00020\u00072\u0017\u00102\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u001803\u00a2\u0006\u0002\b4J\u0012\u00105\u001a\u00020\u0018*\u00020\u00072\u0006\u00106\u001a\u000207J\n\u00108\u001a\u00020\u0018*\u00020\u0007J\n\u00109\u001a\u00020\u0018*\u00020\u0007R(\u0010\u0006\u001a\u00020\u0005*\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00058F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0015\u0010\f\u001a\u00020\r*\u00020\u00078F\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0015\u0010\u0010\u001a\u00020\u0011*\u00020\u00078F\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R(\u0010'\u001a\u00020&*\u00020\u00162\u0006\u0010\u0004\u001a\u00020&8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+\u00a8\u0006:"}, d2={"Lnet/thebrokenscript/api/ext/PlayerExt;", "", "<init>", "()V", "value", "Lnet/thebrokenscript/data/PlayerVariables;", "vars", "Lnet/minecraft/world/entity/player/Player;", "getVars", "(Lnet/minecraft/world/entity/player/Player;)Lnet/thebrokenscript/data/PlayerVariables;", "setVars", "(Lnet/minecraft/world/entity/player/Player;Lnet/thebrokenscript/data/PlayerVariables;)V", "interactionTracker", "Lnet/thebrokenscript/util/InteractionTracker;", "getInteractionTracker", "(Lnet/minecraft/world/entity/player/Player;)Lnet/thebrokenscript/util/InteractionTracker;", "base", "Lnet/thebrokenscript/brokencore/api/learner/util/PlayerBase;", "getBase", "(Lnet/minecraft/world/entity/player/Player;)Lnet/thebrokenscript/brokencore/api/learner/util/PlayerBase;", "getReputation", "Lnet/thebrokenscript/util/ReputationEnum;", "Lnet/minecraft/server/level/ServerPlayer;", "tryLoopSound", "", "sound", "Lnet/minecraft/sounds/SoundEvent;", "volume", "", "tryStopLoopingSound", "tryPlaySound", "loops", "", "pitch", "gain", "tryPlayChase", "tryPlayHostile", "tryPlayMusic", "", "moonGlitchDuration", "getMoonGlitchDuration", "(Lnet/minecraft/server/level/ServerPlayer;)D", "setMoonGlitchDuration", "(Lnet/minecraft/server/level/ServerPlayer;D)V", "isEntityInFovCone", "entity", "Lnet/minecraft/world/entity/Entity;", "fovDegrees", "(Lnet/minecraft/world/entity/player/Player;Lnet/minecraft/world/entity/Entity;Ljava/lang/Double;)Z", "updateVars", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "trySetWindowTitle", "title", "", "trySetWindowed", "syncVars", "thebrokenscript-common"})
public final class PlayerExt {
    @NotNull
    public static final PlayerExt INSTANCE = new PlayerExt();

    private PlayerExt() {
    }

    @NotNull
    public final PlayerVariables getVars(@NotNull Player $this$vars) {
        Intrinsics.checkNotNullParameter((Object)$this$vars, (String)"<this>");
        return (PlayerVariables)TBSDataAttachments.PLAYER_VARIABLES.get((Entity)$this$vars);
    }

    public final void setVars(@NotNull Player $this$vars, @NotNull PlayerVariables value) {
        Intrinsics.checkNotNullParameter((Object)$this$vars, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)value, (String)"value");
        TBSDataAttachments.PLAYER_VARIABLES.set((Entity)$this$vars, (Object)value);
    }

    @NotNull
    public final InteractionTracker getInteractionTracker(@NotNull Player $this$interactionTracker) {
        Intrinsics.checkNotNullParameter((Object)$this$interactionTracker, (String)"<this>");
        Map map = InteractionTracker.Companion.getTrackerObjects();
        Object v = map.get($this$interactionTracker.getUUID());
        if (v == null) {
            boolean bl = false;
            InteractionTracker newTracker = (InteractionTracker)TBSDataAttachments.INTERACTION_TRACKER.get((Entity)$this$interactionTracker);
            ((Map)InteractionTracker.Companion.getTrackerObjects()).put($this$interactionTracker.getUUID(), newTracker);
            return newTracker;
        }
        return (InteractionTracker)v;
    }

    @NotNull
    public final PlayerBase getBase(@NotNull Player $this$base) {
        Intrinsics.checkNotNullParameter((Object)$this$base, (String)"<this>");
        Map map = PlayerBase.Companion.getBaseObjects();
        Object v = map.get($this$base.getUUID());
        if (v == null) {
            boolean bl = false;
            PlayerBase newBase = (PlayerBase)TBSDataAttachments.PLAYER_BASE.get((Entity)$this$base);
            ((Map)PlayerBase.Companion.getBaseObjects()).put($this$base.getUUID(), newBase);
            return newBase;
        }
        return (PlayerBase)v;
    }

    @NotNull
    public final ReputationEnum getReputation(@NotNull ServerPlayer $this$getReputation) {
        Intrinsics.checkNotNullParameter((Object)$this$getReputation, (String)"<this>");
        int rep = this.getVars((Player)$this$getReputation).getEntityReputation();
        return rep < 25 ? ReputationEnum.BAD : ((25 <= rep ? rep < 76 : false) ? ReputationEnum.NORMAL : ReputationEnum.GOOD);
    }

    public final void tryLoopSound(@NotNull Player $this$tryLoopSound, @NotNull SoundEvent sound, float volume) {
        Intrinsics.checkNotNullParameter((Object)$this$tryLoopSound, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)sound, (String)"sound");
        PlayerUtil.trySendCustomPacket((Player)$this$tryLoopSound, (CustomPacketPayload)((CustomPacketPayload)TBSPackets.CUSTOM_SOUND.of(new CustomMusicPayload(sound, true, volume, 0.0f, 0.0f, 24, null))));
    }

    public static /* synthetic */ void tryLoopSound$default(PlayerExt playerExt, Player player, SoundEvent soundEvent, float f, int n, Object object) {
        if ((n & 2) != 0) {
            f = 1.0f;
        }
        playerExt.tryLoopSound(player, soundEvent, f);
    }

    public final void tryStopLoopingSound(@NotNull Player $this$tryStopLoopingSound, @NotNull SoundEvent sound) {
        Intrinsics.checkNotNullParameter((Object)$this$tryStopLoopingSound, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)sound, (String)"sound");
        PlayerUtil.trySendCustomPacket((Player)$this$tryStopLoopingSound, (CustomPacketPayload)((CustomPacketPayload)TBSPackets.STOP_LOOPING_MUSIC.of(sound)));
    }

    public final void tryPlaySound(@NotNull Player $this$tryPlaySound, @NotNull SoundEvent sound, boolean loops, float volume, float pitch, float gain) {
        Intrinsics.checkNotNullParameter((Object)$this$tryPlaySound, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)sound, (String)"sound");
        PlayerUtil.trySendCustomPacket((Player)$this$tryPlaySound, (CustomPacketPayload)((CustomPacketPayload)TBSPackets.CUSTOM_SOUND.of(new CustomMusicPayload(sound, loops, volume, pitch, gain))));
    }

    public static /* synthetic */ void tryPlaySound$default(PlayerExt playerExt, Player player, SoundEvent soundEvent, boolean bl, float f, float f2, float f3, int n, Object object) {
        if ((n & 2) != 0) {
            bl = false;
        }
        if ((n & 4) != 0) {
            f = 1.0f;
        }
        if ((n & 8) != 0) {
            f2 = 1.0f;
        }
        if ((n & 0x10) != 0) {
            f3 = 1.0f;
        }
        playerExt.tryPlaySound(player, soundEvent, bl, f, f2, f3);
    }

    public final void tryPlayChase(@NotNull Player $this$tryPlayChase, @NotNull SoundEvent sound, boolean loops, float volume, float pitch, float gain) {
        Intrinsics.checkNotNullParameter((Object)$this$tryPlayChase, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)sound, (String)"sound");
        PlayerUtil.trySendCustomPacket((Player)$this$tryPlayChase, (CustomPacketPayload)((CustomPacketPayload)TBSPackets.CHASE_SOUND.of(new CustomMusicPayload(sound, loops, volume, pitch, gain))));
    }

    public static /* synthetic */ void tryPlayChase$default(PlayerExt playerExt, Player player, SoundEvent soundEvent, boolean bl, float f, float f2, float f3, int n, Object object) {
        if ((n & 2) != 0) {
            bl = false;
        }
        if ((n & 4) != 0) {
            f = 1.0f;
        }
        if ((n & 8) != 0) {
            f2 = 1.0f;
        }
        if ((n & 0x10) != 0) {
            f3 = 1.0f;
        }
        playerExt.tryPlayChase(player, soundEvent, bl, f, f2, f3);
    }

    public final void tryPlayHostile(@NotNull Player $this$tryPlayHostile, @NotNull SoundEvent sound, boolean loops, float volume, float pitch, float gain) {
        Intrinsics.checkNotNullParameter((Object)$this$tryPlayHostile, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)sound, (String)"sound");
        PlayerUtil.trySendCustomPacket((Player)$this$tryPlayHostile, (CustomPacketPayload)((CustomPacketPayload)TBSPackets.CUSTOM_HOSTILE.of(new CustomMusicPayload(sound, loops, volume, pitch, gain))));
    }

    public static /* synthetic */ void tryPlayHostile$default(PlayerExt playerExt, Player player, SoundEvent soundEvent, boolean bl, float f, float f2, float f3, int n, Object object) {
        if ((n & 2) != 0) {
            bl = false;
        }
        if ((n & 4) != 0) {
            f = 1.0f;
        }
        if ((n & 8) != 0) {
            f2 = 1.0f;
        }
        if ((n & 0x10) != 0) {
            f3 = 1.0f;
        }
        playerExt.tryPlayHostile(player, soundEvent, bl, f, f2, f3);
    }

    public final void tryPlayMusic(@NotNull Player $this$tryPlayMusic, @NotNull SoundEvent sound, boolean loops, float volume, float gain) {
        Intrinsics.checkNotNullParameter((Object)$this$tryPlayMusic, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)sound, (String)"sound");
        PlayerUtil.trySendCustomPacket((Player)$this$tryPlayMusic, (CustomPacketPayload)((CustomPacketPayload)TBSPackets.CUSTOM_MUSIC.of(new CustomMusicPayload(sound, loops, volume, 0.0f, gain, 8, null))));
    }

    public static /* synthetic */ void tryPlayMusic$default(PlayerExt playerExt, Player player, SoundEvent soundEvent, boolean bl, float f, float f2, int n, Object object) {
        if ((n & 2) != 0) {
            bl = false;
        }
        if ((n & 4) != 0) {
            f = 1.0f;
        }
        if ((n & 8) != 0) {
            f2 = 1.0f;
        }
        playerExt.tryPlayMusic(player, soundEvent, bl, f, f2);
    }

    public final double getMoonGlitchDuration(@NotNull ServerPlayer $this$moonGlitchDuration) {
        Intrinsics.checkNotNullParameter((Object)$this$moonGlitchDuration, (String)"<this>");
        return this.getVars((Player)$this$moonGlitchDuration).getMoonGlitchDuration();
    }

    public final void setMoonGlitchDuration(@NotNull ServerPlayer $this$moonGlitchDuration, double value) {
        PlayerVariables playerVariables;
        Intrinsics.checkNotNullParameter((Object)$this$moonGlitchDuration, (String)"<this>");
        PlayerVariables it = playerVariables = this.getVars((Player)$this$moonGlitchDuration);
        boolean bl = false;
        it.setMoonGlitchDuration(value);
        it.syncTo((Player)$this$moonGlitchDuration);
    }

    public final boolean isEntityInFovCone(@NotNull Player $this$isEntityInFovCone, @NotNull Entity entity, @Nullable Double fovDegrees) {
        Intrinsics.checkNotNullParameter((Object)$this$isEntityInFovCone, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)entity, (String)"entity");
        if (!Intrinsics.areEqual((Object)$this$isEntityInFovCone.level().dimension(), (Object)entity.level().dimension())) {
            return false;
        }
        if (this.getVars($this$isEntityInFovCone).getFov() == 0.0 && fovDegrees == null) {
            return false;
        }
        Double d = fovDegrees;
        double fov = d != null ? d.doubleValue() : this.getVars($this$isEntityInFovCone).getFov();
        Vec3 eyePos = $this$isEntityInFovCone.getEyePosition();
        Vec3 toEntity = entity.position().subtract(eyePos).normalize();
        Vec3 lookVec = $this$isEntityInFovCone.getViewVector(1.0f).normalize();
        double dot = lookVec.dot(toEntity);
        double threshold = Math.cos(Math.toRadians(fov / 1.5));
        return dot >= threshold ? $this$isEntityInFovCone.hasLineOfSight(entity) : false;
    }

    public static /* synthetic */ boolean isEntityInFovCone$default(PlayerExt playerExt, Player player, Entity entity, Double d, int n, Object object) {
        if ((n & 2) != 0) {
            d = null;
        }
        return playerExt.isEntityInFovCone(player, entity, d);
    }

    public final void updateVars(@NotNull Player $this$updateVars, @NotNull Function1<? super PlayerVariables, Unit> block) {
        Intrinsics.checkNotNullParameter((Object)$this$updateVars, (String)"<this>");
        Intrinsics.checkNotNullParameter(block, (String)"block");
        PlayerVariables vars = this.getVars($this$updateVars);
        block.invoke((Object)vars);
        vars.syncTo($this$updateVars);
    }

    public final void trySetWindowTitle(@NotNull Player $this$trySetWindowTitle, @NotNull String title) {
        Intrinsics.checkNotNullParameter((Object)$this$trySetWindowTitle, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)title, (String)"title");
        this.getVars($this$trySetWindowTitle).setTitleName(title);
        this.getVars($this$trySetWindowTitle).syncTo($this$trySetWindowTitle);
        PlayerUtil.trySendCustomPacket((Player)$this$trySetWindowTitle, (CustomPacketPayload)((CustomPacketPayload)TBSPackets.WINDOW_TITLE_PACKET.of(title)));
    }

    public final void trySetWindowed(@NotNull Player $this$trySetWindowed) {
        Intrinsics.checkNotNullParameter((Object)$this$trySetWindowed, (String)"<this>");
        PlayerUtil.trySendCustomPacket((Player)$this$trySetWindowed, (CustomPacketPayload)((CustomPacketPayload)new SetWindowedPacket()));
    }

    public final void syncVars(@NotNull Player $this$syncVars) {
        Intrinsics.checkNotNullParameter((Object)$this$syncVars, (String)"<this>");
        this.getVars($this$syncVars).syncTo($this$syncVars);
    }
}

