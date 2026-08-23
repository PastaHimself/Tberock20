/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.player.LocalPlayer
 *  net.minecraft.client.resources.sounds.SoundInstance
 *  net.minecraft.network.syncher.EntityDataAccessor
 *  net.minecraft.network.syncher.EntityDataSerializer
 *  net.minecraft.network.syncher.EntityDataSerializers
 *  net.minecraft.network.syncher.SynchedEntityData
 *  net.minecraft.network.syncher.SynchedEntityData$Builder
 *  net.minecraft.sounds.SoundEvent
 *  net.minecraft.sounds.SoundSource
 *  net.minecraft.util.RandomSource
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.Mob
 *  net.minecraft.world.entity.MobSpawnType
 *  net.minecraft.world.entity.ai.goal.Goal
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.LevelAccessor
 *  net.thebrokenscript.brokencore.api.dsl.ClientDSLKt
 *  net.thebrokenscript.brokencore.api.dsl.PlayerUtil
 *  net.thebrokenscript.brokencore.api.dsl.SideUtil
 *  net.thebrokenscript.brokencore.api.sound.FancyEntitySoundInstance
 *  net.thebrokenscript.brokencore.api.sound.fx.AudioEffect
 *  net.thebrokenscript.brokencore.api.sound.fx.ReverbPreset
 *  net.thebrokenscript.brokencore.api.sound.fx.ReverbPresets
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.entity.fever;

import java.util.Optional;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.resources.sounds.SoundInstance;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializer;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.thebrokenscript.TheBrokenScript;
import net.thebrokenscript.api.entity.BaseFeverEntity;
import net.thebrokenscript.api.entity.ai.fever.FeverGoals;
import net.thebrokenscript.brokencore.api.dsl.ClientDSLKt;
import net.thebrokenscript.brokencore.api.dsl.PlayerUtil;
import net.thebrokenscript.brokencore.api.dsl.SideUtil;
import net.thebrokenscript.brokencore.api.sound.FancyEntitySoundInstance;
import net.thebrokenscript.brokencore.api.sound.fx.AudioEffect;
import net.thebrokenscript.brokencore.api.sound.fx.ReverbPreset;
import net.thebrokenscript.brokencore.api.sound.fx.ReverbPresets;
import net.thebrokenscript.registry.TBSSounds;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 )2\u00020\u0001:\u0001)B\u001d\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0017\u001a\u00020\u0018H\u0014J\u0018\u0010\u0019\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\"\u001a\u00020\u0018H\u0016J\u0012\u0010#\u001a\u00020\t2\b\u0010$\u001a\u0004\u0018\u00010%H\u0002J\u0010\u0010&\u001a\u00020\u00182\u0006\u0010'\u001a\u00020(H\u0014R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\rR\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u001d\u001a\u00020\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0014\"\u0004\b\u001f\u0010\u0016R\u0014\u0010 \u001a\u00020\u0012X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0014\u00a8\u0006*"}, d2={"Lnet/thebrokenscript/entity/fever/FeverStalkEntity;", "Lnet/thebrokenscript/api/entity/BaseFeverEntity;", "type", "Lnet/minecraft/world/entity/EntityType;", "level", "Lnet/minecraft/world/level/Level;", "<init>", "(Lnet/minecraft/world/entity/EntityType;Lnet/minecraft/world/level/Level;)V", "enraged", "", "getEnraged", "()Z", "setEnraged", "(Z)V", "playerStaring", "getPlayerStaring", "setPlayerStaring", "stareTimer", "", "getStareTimer", "()I", "setStareTimer", "(I)V", "registerGoals", "", "checkSpawnRules", "Lnet/minecraft/world/level/LevelAccessor;", "spawnReason", "Lnet/minecraft/world/entity/MobSpawnType;", "wingCooldown", "getWingCooldown", "setWingCooldown", "agroTicks", "getAgroTicks", "tick", "shouldAttackPlayer", "player", "Lnet/minecraft/world/entity/player/Player;", "defineSynchedData", "builder", "Lnet/minecraft/network/syncher/SynchedEntityData$Builder;", "Companion", "thebrokenscript-common"})
public final class FeverStalkEntity
extends BaseFeverEntity {
    @NotNull
    public static final Companion Companion = new Companion(null);
    private boolean enraged;
    private boolean playerStaring;
    private int stareTimer;
    private int wingCooldown;
    private final int agroTicks;
    @NotNull
    private static final EntityDataAccessor<Optional<UUID>> TARGET_UUID;

    public FeverStalkEntity(@NotNull EntityType<BaseFeverEntity> type, @NotNull Level level) {
        Intrinsics.checkNotNullParameter(type, (String)"type");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        super(type, level);
        this.agroTicks = 10;
    }

    public final boolean getEnraged() {
        return this.enraged;
    }

    public final void setEnraged(boolean bl) {
        this.enraged = bl;
    }

    public final boolean getPlayerStaring() {
        return this.playerStaring;
    }

    public final void setPlayerStaring(boolean bl) {
        this.playerStaring = bl;
    }

    public final int getStareTimer() {
        return this.stareTimer;
    }

    public final void setStareTimer(int n) {
        this.stareTimer = n;
    }

    protected void registerGoals() {
        this.targetSelector.addGoal(1, (Goal)new FeverGoals.FeverTargeting((Mob)this, null, 2, null));
        this.goalSelector.addGoal(1, (Goal)new FeverGoals.FlyToPlayerEnragedGoal(this, 1.4, (Function1<? super Player, Boolean>)((Function1)arg_0 -> FeverStalkEntity.registerGoals$lambda$0(this, arg_0))));
        this.goalSelector.addGoal(2, (Goal)new FeverGoals.FlyToPlayerStalkGoal(this, 0.4, (Function1<? super Player, Boolean>)((Function1)arg_0 -> FeverStalkEntity.registerGoals$lambda$1(this, arg_0))));
    }

    public boolean checkSpawnRules(@NotNull LevelAccessor level, @NotNull MobSpawnType spawnReason) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)spawnReason, (String)"spawnReason");
        return true;
    }

    public final int getWingCooldown() {
        return this.wingCooldown;
    }

    public final void setWingCooldown(int n) {
        this.wingCooldown = n;
    }

    public final int getAgroTicks() {
        return this.agroTicks;
    }

    @Override
    public void tick() {
        super.tick();
        SideUtil.serverSide((Entity)((Entity)this), () -> FeverStalkEntity.tick$lambda$0(this));
        SideUtil.clientSide((Entity)((Entity)this), () -> FeverStalkEntity.tick$lambda$1(this));
        LivingEntity livingEntity = this.getTarget();
        this.playerStaring = this.shouldAttackPlayer(livingEntity instanceof Player ? (Player)livingEntity : null);
    }

    private final boolean shouldAttackPlayer(Player player) {
        if (player == null) {
            return false;
        }
        return PlayerUtil.isLookingAtEntityHitbox((Player)player, (Entity)((Entity)this));
    }

    @Override
    protected void defineSynchedData(@NotNull SynchedEntityData.Builder builder) {
        Intrinsics.checkNotNullParameter((Object)builder, (String)"builder");
        super.defineSynchedData(builder);
        builder.define(TARGET_UUID, Optional.empty());
    }

    private static final boolean registerGoals$lambda$0(FeverStalkEntity this$0, Player it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        return this$0.enraged;
    }

    private static final boolean registerGoals$lambda$1(FeverStalkEntity this$0, Player it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        return !this$0.enraged;
    }

    private static final Unit tick$lambda$0(FeverStalkEntity this$0) {
        int n;
        LivingEntity livingEntity = this$0.getTarget();
        this$0.entityData.set(TARGET_UUID, Optional.ofNullable(livingEntity != null ? livingEntity.getUUID() : null));
        TheBrokenScript.LOGGER.debug("stareTimer: " + this$0.stareTimer + ", playerStaring: " + this$0.playerStaring + ", enraged: " + this$0.enraged);
        if (this$0.playerStaring) {
            n = this$0.stareTimer;
            this$0.stareTimer = n + 1;
        }
        if (this$0.stareTimer > this$0.agroTicks) {
            this$0.enraged = true;
        }
        if (!this$0.playerStaring && !this$0.enraged && this$0.stareTimer > 0) {
            n = this$0.stareTimer;
            this$0.stareTimer = n + -1;
        }
        return Unit.INSTANCE;
    }

    private static final Unit tick$lambda$1(FeverStalkEntity this$0) {
        Minecraft mc = Minecraft.getInstance();
        LocalPlayer localPlayer = mc.player;
        if (localPlayer == null) {
            return Unit.INSTANCE;
        }
        LocalPlayer localPlayer2 = localPlayer;
        if (Intrinsics.areEqual(((Optional)this$0.entityData.get(TARGET_UUID)).orElse(null), (Object)localPlayer2.getUUID())) {
            if (this$0.wingCooldown <= 0) {
                FancyEntitySoundInstance fancyEntitySoundInstance;
                this$0.wingCooldown = 15;
                SoundEvent soundEvent = (SoundEvent)TBSSounds.FEVER_WING.get();
                Entity entity = (Entity)this$0;
                RandomSource randomSource = this$0.level().random;
                Intrinsics.checkNotNullExpressionValue((Object)randomSource, (String)"random");
                FancyEntitySoundInstance $this$tick_u24lambda_u241_u240 = fancyEntitySoundInstance = new FancyEntitySoundInstance(soundEvent, SoundSource.HOSTILE, 1.5f, 1.0f, entity, false, randomSource);
                boolean bl = false;
                $this$tick_u24lambda_u241_u240.addEffect((AudioEffect)ReverbPreset.create$default((ReverbPreset)ReverbPresets.EFX_REVERB_PRESET_MOOD_HELL, null, (int)1, null));
                $this$tick_u24lambda_u241_u240.setAttenuation(3.0f, 32.0f, 1.5f);
                FancyEntitySoundInstance wingInstance = fancyEntitySoundInstance;
                ClientDSLKt.getMC().getSoundManager().play((SoundInstance)wingInstance);
            } else {
                --this$0.wingCooldown;
            }
        }
        return Unit.INSTANCE;
    }

    static {
        EntityDataAccessor entityDataAccessor = SynchedEntityData.defineId(FeverStalkEntity.class, (EntityDataSerializer)EntityDataSerializers.OPTIONAL_UUID);
        Intrinsics.checkNotNullExpressionValue((Object)entityDataAccessor, (String)"defineId(...)");
        TARGET_UUID = entityDataAccessor;
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u001d\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\u00a8\u0006\n"}, d2={"Lnet/thebrokenscript/entity/fever/FeverStalkEntity$Companion;", "", "<init>", "()V", "TARGET_UUID", "Lnet/minecraft/network/syncher/EntityDataAccessor;", "Ljava/util/Optional;", "Ljava/util/UUID;", "getTARGET_UUID", "()Lnet/minecraft/network/syncher/EntityDataAccessor;", "thebrokenscript-common"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final EntityDataAccessor<Optional<UUID>> getTARGET_UUID() {
            return TARGET_UUID;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

