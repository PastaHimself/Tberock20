/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.MutablePropertyReference1
 *  kotlin.jvm.internal.MutablePropertyReference1Impl
 *  kotlin.jvm.internal.Reflection
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.reflect.KProperty
 *  net.minecraft.commands.arguments.EntityAnchorArgument$Anchor
 *  net.minecraft.core.particles.ParticleOptions
 *  net.minecraft.core.particles.ParticleTypes
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.network.syncher.EntityDataAccessor
 *  net.minecraft.network.syncher.EntityDataSerializer
 *  net.minecraft.network.syncher.EntityDataSerializers
 *  net.minecraft.network.syncher.SynchedEntityData
 *  net.minecraft.network.syncher.SynchedEntityData$Builder
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.server.level.ServerPlayer
 *  net.minecraft.sounds.SoundEvent
 *  net.minecraft.sounds.SoundEvents
 *  net.minecraft.sounds.SoundSource
 *  net.minecraft.util.RandomSource
 *  net.minecraft.world.DifficultyInstance
 *  net.minecraft.world.effect.MobEffectInstance
 *  net.minecraft.world.effect.MobEffects
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.Mob
 *  net.minecraft.world.entity.MobSpawnType
 *  net.minecraft.world.entity.PathfinderMob
 *  net.minecraft.world.entity.SpawnGroupData
 *  net.minecraft.world.entity.ai.goal.FloatGoal
 *  net.minecraft.world.entity.ai.goal.Goal
 *  net.minecraft.world.entity.ai.goal.MeleeAttackGoal
 *  net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal
 *  net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.level.ServerLevelAccessor
 *  net.minecraft.world.level.pathfinder.PathType
 *  net.minecraft.world.phys.Vec3
 *  net.thebrokenscript.brokencore.api.dsl.ClientDSLKt
 *  net.thebrokenscript.brokencore.api.dsl.EntityDataDelegate
 *  net.thebrokenscript.brokencore.api.dsl.EntityFinder
 *  net.thebrokenscript.brokencore.api.dsl.EntityUtil
 *  net.thebrokenscript.brokencore.api.dsl.PlayerUtil
 *  net.thebrokenscript.brokencore.api.dsl.RandomUtil
 *  net.thebrokenscript.brokencore.api.dsl.SoundUtil
 *  net.thebrokenscript.brokencore.api.entity.FinalizedSpawn
 *  net.thebrokenscript.brokencore.api.entity.base.BaseMonster
 *  net.thebrokenscript.brokencore.api.entity.base.BaseMonster$BMC
 *  net.thebrokenscript.brokencore.api.entity.base.BaseMonster$Companion
 *  net.thebrokenscript.brokencore.api.ext.BaseMonsterExtKt
 *  net.thebrokenscript.brokencore.api.ext.EntityTypeExt
 *  net.thebrokenscript.brokencore.api.platform.CancelProxy
 *  net.thebrokenscript.brokencore.api.world.TimeOfDay
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.entity.siluet;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KProperty;
import net.minecraft.commands.arguments.EntityAnchorArgument;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializer;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.pathfinder.PathType;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.api.TBSConstants;
import net.thebrokenscript.api.entity.BaseSiluetEntity;
import net.thebrokenscript.api.ext.PlayerExt;
import net.thebrokenscript.brokencore.api.dsl.ClientDSLKt;
import net.thebrokenscript.brokencore.api.dsl.EntityDataDelegate;
import net.thebrokenscript.brokencore.api.dsl.EntityFinder;
import net.thebrokenscript.brokencore.api.dsl.EntityUtil;
import net.thebrokenscript.brokencore.api.dsl.PlayerUtil;
import net.thebrokenscript.brokencore.api.dsl.RandomUtil;
import net.thebrokenscript.brokencore.api.dsl.SoundUtil;
import net.thebrokenscript.brokencore.api.entity.FinalizedSpawn;
import net.thebrokenscript.brokencore.api.entity.base.BaseMonster;
import net.thebrokenscript.brokencore.api.ext.BaseMonsterExtKt;
import net.thebrokenscript.brokencore.api.ext.EntityTypeExt;
import net.thebrokenscript.brokencore.api.platform.CancelProxy;
import net.thebrokenscript.brokencore.api.world.TimeOfDay;
import net.thebrokenscript.config.TBSConfigs;
import net.thebrokenscript.registry.TBSAdvancements;
import net.thebrokenscript.registry.TBSEntities;
import net.thebrokenscript.registry.TBSParticleTypes;
import net.thebrokenscript.registry.TBSSounds;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000 32\u00020\u00012\u00020\u0002:\u00013B\u001f\u0012\u000e\u0010\u0003\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00000\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u0018\u001a\u00020\u0019H\u0014J\u0010\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0010\u0010!\u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020 H\u0016J4\u0010\"\u001a\u0004\u0018\u00010#2\u0006\u0010\u0005\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010#2\u0006\u0010*\u001a\u00020+H\u0016J\u000e\u0010,\u001a\u00020\u00192\u0006\u0010-\u001a\u00020.J\u0010\u0010/\u001a\u00020\u00192\u0006\u00100\u001a\u000201H\u0014J\b\u00102\u001a\u00020\u0019H\u0016R+\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R$\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u00138F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u001c\u0010\u0015\"\u0004\b\u001d\u0010\u0017\u00a8\u00064"}, d2={"Lnet/thebrokenscript/entity/siluet/SiluetEntity;", "Lnet/thebrokenscript/api/entity/BaseSiluetEntity;", "Lnet/thebrokenscript/brokencore/api/entity/FinalizedSpawn;", "type", "Lnet/minecraft/world/entity/EntityType;", "level", "Lnet/minecraft/world/level/Level;", "<init>", "(Lnet/minecraft/world/entity/EntityType;Lnet/minecraft/world/level/Level;)V", "<set-?>", "", "r2SpaceProgram", "getR2SpaceProgram", "()Z", "setR2SpaceProgram", "(Z)V", "r2SpaceProgram$delegate", "Lnet/thebrokenscript/brokencore/api/dsl/EntityDataDelegate;", "rocketDespawnDelay", "", "getRocketDespawnDelay", "()I", "setRocketDespawnDelay", "(I)V", "registerGoals", "", "value", "timer", "getTimer", "setTimer", "addAdditionalSaveData", "compound", "Lnet/minecraft/nbt/CompoundTag;", "readAdditionalSaveData", "onFinalizeSpawn", "Lnet/minecraft/world/entity/SpawnGroupData;", "Lnet/minecraft/world/level/ServerLevelAccessor;", "difficulty", "Lnet/minecraft/world/DifficultyInstance;", "spawnType", "Lnet/minecraft/world/entity/MobSpawnType;", "spawnData", "event", "Lnet/thebrokenscript/brokencore/api/platform/CancelProxy;", "tryLaunch", "player", "Lnet/minecraft/world/entity/player/Player;", "defineSynchedData", "builder", "Lnet/minecraft/network/syncher/SynchedEntityData$Builder;", "baseTick", "Companion", "thebrokenscript-common"})
@SourceDebugExtension(value={"SMAP\nSiluetEntity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SiluetEntity.kt\nnet/thebrokenscript/entity/siluet/SiluetEntity\n+ 2 BaseMonster.kt\nnet/thebrokenscript/brokencore/api/entity/base/BaseMonster$Companion\n*L\n1#1,233:1\n72#2:234\n*S KotlinDebug\n*F\n+ 1 SiluetEntity.kt\nnet/thebrokenscript/entity/siluet/SiluetEntity\n*L\n-1#1:234\n*E\n"})
public class SiluetEntity
extends BaseSiluetEntity
implements FinalizedSpawn {
    @NotNull
    public static final Companion Companion;
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;
    @NotNull
    private final EntityDataDelegate r2SpaceProgram$delegate;
    private int rocketDespawnDelay;
    @NotNull
    private static final String NATURAL_DESPAWN = "despawn_timer";
    @NotNull
    private static final String IS_ROCKET = "is_rocket";
    @NotNull
    private static final EntityDataAccessor<Boolean> ROCKET;
    @NotNull
    private static final String ROCKET_DESPAWN_DELAY = "despawn_delay";

    public SiluetEntity(@NotNull EntityType<? extends SiluetEntity> type, @NotNull Level level) {
        Intrinsics.checkNotNullParameter(type, (String)"type");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        super(type, level);
        this.xpReward = 0;
        this.setNoAi(false);
        this.setPersistenceRequired();
        this.setPathfindingMalus(PathType.LAVA, 0.0f);
        this.setPathfindingMalus(PathType.FENCE, 0.0f);
        this.setPathfindingMalus(PathType.RAIL, 0.0f);
        this.setPathfindingMalus(PathType.WATER, 0.0f);
        this.setPathfindingMalus(PathType.WATER_BORDER, 0.0f);
        this.r2SpaceProgram$delegate = this.entityData(ROCKET);
    }

    public final boolean getR2SpaceProgram() {
        Object object = this.r2SpaceProgram$delegate.getValue((BaseMonster)this, $$delegatedProperties[0]);
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"getValue(...)");
        return (Boolean)object;
    }

    public final void setR2SpaceProgram(boolean bl) {
        this.r2SpaceProgram$delegate.setValue((BaseMonster)this, $$delegatedProperties[0], (Object)bl);
    }

    public final int getRocketDespawnDelay() {
        return this.rocketDespawnDelay;
    }

    public final void setRocketDespawnDelay(int n) {
        this.rocketDespawnDelay = n;
    }

    protected void registerGoals() {
        super.registerGoals();
        this.targetSelector.addGoal(1, (Goal)new NearestAttackableTargetGoal((Mob)this, Player.class, false, false));
        this.goalSelector.addGoal(2, (Goal)new MeleeAttackGoal((PathfinderMob)this, 1.2, false));
        this.targetSelector.addGoal(4, (Goal)new HurtByTargetGoal((PathfinderMob)this, new Class[0]));
        this.goalSelector.addGoal(5, (Goal)new FloatGoal((Mob)this));
    }

    public final int getTimer() {
        return EntityUtil.getPersistentData((Entity)((Entity)this)).getInt(NATURAL_DESPAWN);
    }

    public final void setTimer(int value) {
        EntityUtil.getPersistentData((Entity)((Entity)this)).putInt(NATURAL_DESPAWN, value);
    }

    public void addAdditionalSaveData(@NotNull CompoundTag compound) {
        Intrinsics.checkNotNullParameter((Object)compound, (String)"compound");
        super.addAdditionalSaveData(compound);
        compound.putInt(NATURAL_DESPAWN, this.getTimer());
        compound.putBoolean(IS_ROCKET, this.getR2SpaceProgram());
        compound.putInt(ROCKET_DESPAWN_DELAY, this.rocketDespawnDelay);
    }

    public void readAdditionalSaveData(@NotNull CompoundTag compound) {
        Intrinsics.checkNotNullParameter((Object)compound, (String)"compound");
        super.readAdditionalSaveData(compound);
        compound.getInt(NATURAL_DESPAWN);
        this.setR2SpaceProgram(compound.getBoolean(IS_ROCKET));
        this.rocketDespawnDelay = compound.getInt(ROCKET_DESPAWN_DELAY);
    }

    @Nullable
    public SpawnGroupData onFinalizeSpawn(@NotNull ServerLevelAccessor level, @NotNull DifficultyInstance difficulty, @NotNull MobSpawnType spawnType, @Nullable SpawnGroupData spawnData, @NotNull CancelProxy event) {
        Player player;
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)difficulty, (String)"difficulty");
        Intrinsics.checkNotNullParameter((Object)spawnType, (String)"spawnType");
        Intrinsics.checkNotNullParameter((Object)event, (String)"event");
        if ((double)this.random.nextFloat() < 0.9 && (player = (Player)EntityFinder.findClosestEntityInRange((LevelAccessor)((LevelAccessor)level), Player.class, (Vec3)this.getPos(), (Number)1000.0)) != null) {
            PlayerUtil.awardAdvancement((Player)player, (ResourceLocation)TBSAdvancements.CAN_YOU_SEE_ME.getId());
        }
        LevelAccessor levelAccessor = (LevelAccessor)level;
        Vec3 vec3 = this.getPos();
        Object object = SoundEvents.AMBIENT_CAVE.value();
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"value(...)");
        SoundUtil.playSound$default((LevelAccessor)levelAccessor, (Vec3)vec3, (SoundEvent)((SoundEvent)object), (float)10.0f, (float)1.0f, null, (int)16, null);
        this.setTimer(18000);
        return null;
    }

    public final void tryLaunch(@NotNull Player player) {
        Intrinsics.checkNotNullParameter((Object)player, (String)"player");
        if (TBSConfigs.INSTANCE.getServer().getDanger().getFunnySetting() && Math.random() < 0.01) {
            Level level = this.getLevel();
            Vec3 vec3 = player.position();
            Intrinsics.checkNotNullExpressionValue((Object)vec3, (String)"position(...)");
            SoundUtil.tryPlaySound$default((Level)level, (Vec3)vec3, (SoundEvent)((SoundEvent)TBSSounds.SILUET_CHASE.get()), (float)10.0f, (float)0.0f, null, (int)16, null);
            this.setR2SpaceProgram(true);
            this.setNoGravity(true);
            this.setNoAi(true);
        }
    }

    protected void defineSynchedData(@NotNull SynchedEntityData.Builder builder) {
        Intrinsics.checkNotNullParameter((Object)builder, (String)"builder");
        super.defineSynchedData(builder);
        builder.define(ROCKET, (Object)false);
    }

    @Override
    public void baseTick() {
        super.baseTick();
        Level level = this.level();
        Intrinsics.checkNotNull((Object)level);
        Player player = EntityFinder.findClosestPlayerInRange((LevelAccessor)((LevelAccessor)level), (Vec3)this.getPos(), (Number)512.0);
        if (this.getR2SpaceProgram()) {
            this.setPos(this.getPos().x, this.getPos().y + 0.1, this.getPos().z);
            int d = 200;
            if (this.rocketDespawnDelay > d) {
                this.discard();
                if (level.isClientSide) {
                    ClientDSLKt.getMC().getSoundManager().stop(TBSSounds.SILUET_CHASE.getId(), SoundSource.NEUTRAL);
                }
            } else {
                if (this.rocketDespawnDelay == d) {
                    level.addParticle((ParticleOptions)ParticleTypes.EXPLOSION_EMITTER, this.getPos().x, this.getPos().y, this.getPos().z, 1.0, 0.0, 0.0);
                    Vec3 vec3 = this.getPos();
                    Object object = SoundEvents.GENERIC_EXPLODE.value();
                    Intrinsics.checkNotNullExpressionValue((Object)object, (String)"value(...)");
                    SoundUtil.tryPlaySound$default((Level)level, (Vec3)vec3, (SoundEvent)((SoundEvent)object), (float)10.0f, (float)0.5f, null, (int)16, null);
                    if (level.isClientSide) {
                        ClientDSLKt.getMC().getSoundManager().stop(TBSSounds.SILUET_CHASE.getId(), SoundSource.NEUTRAL);
                    }
                }
                int n = 4;
                int n2 = 0;
                while (n2 < n) {
                    int it = n2++;
                    boolean bl = false;
                    level.addParticle((ParticleOptions)ParticleTypes.FLAME, this.getPos().x + SiluetEntity.baseTick$r(), this.getPos().y, this.getPos().z + SiluetEntity.baseTick$r(), 0.0, -1.0, 0.0);
                    level.addParticle((ParticleOptions)ParticleTypes.LARGE_SMOKE, this.getPos().x + SiluetEntity.baseTick$r(), this.getPos().y, this.getPos().z + SiluetEntity.baseTick$r(), 0.0, -1.0, 0.0);
                }
            }
            ++this.rocketDespawnDelay;
        } else {
            if (!(level instanceof ServerLevel)) {
                return;
            }
            if (!(player instanceof ServerPlayer)) {
                return;
            }
            this.lookAt(EntityAnchorArgument.Anchor.EYES, ((ServerPlayer)player).position());
            if (this.isWithin((Entity)player, 15) && BaseMonsterExtKt.hasLineOfSightThroughTransparent((BaseMonster)((BaseMonster)this), (Player)player)) {
                this.tryLaunch(player);
                if (!this.getR2SpaceProgram()) {
                    if (((ServerLevel)level).random.nextBoolean()) {
                        this.discard();
                        ((ServerPlayer)player).addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 35, 1, false, false));
                        List players = EntityFinder.findPlayersInRange((ServerLevel)((ServerLevel)level), (Vec3)this.getPos(), (Number)25);
                        for (ServerPlayer player2 : players) {
                            PlayerExt.tryPlaySound$default(PlayerExt.INSTANCE, (Player)player2, (SoundEvent)TBSSounds.NULL_IS_HERE_LOOP.get(), false, 0.0f, 0.0f, 0.0f, 22, null);
                        }
                        if ((double)((ServerLevel)level).random.nextFloat() < 0.7) {
                            TimeOfDay.MIDNIGHT.setFake();
                        }
                    } else {
                        this.discard();
                        EntityTypeExt.trySummon((EntityType)((EntityType)TBSEntities.SILUET_CHASE.get()), (LevelAccessor)((LevelAccessor)level), (Vec3)this.getPos());
                    }
                }
            }
            if (this.isWithin((Entity)player, 20.0) && PlayerUtil.isLookingAtEntityHitbox((Player)player, (Entity)((Entity)this))) {
                this.tryLaunch(player);
                if (!this.getR2SpaceProgram()) {
                    this.discard();
                    ((ServerPlayer)player).lookAt(EntityAnchorArgument.Anchor.EYES, this.getPos().add(0.0, 1.0, 0.0));
                    if (this.random.nextBoolean()) {
                        if (this.getOnSurface()) {
                            EntityType entityType = EntityType.LIGHTNING_BOLT;
                            Intrinsics.checkNotNullExpressionValue((Object)entityType, (String)"LIGHTNING_BOLT");
                            LevelAccessor levelAccessor = (LevelAccessor)level;
                            Vec3 vec3 = ((ServerPlayer)player).position();
                            Intrinsics.checkNotNullExpressionValue((Object)vec3, (String)"position(...)");
                            EntityTypeExt.trySummon((EntityType)entityType, (LevelAccessor)levelAccessor, (Vec3)vec3);
                        }
                        EntityUtil.applyRandomRotation((Entity)EntityTypeExt.trySummon((EntityType)((EntityType)TBSEntities.SILUET_CHASE.get()), (LevelAccessor)((LevelAccessor)level), (Vec3)this.getPos()));
                    } else {
                        PlayerUtil.sendSound$default((ServerPlayer)((ServerPlayer)player), (SoundEvent)((SoundEvent)TBSSounds.TEXT_MADNESS_1.get()), (float)10.0f, (float)0.0f, null, null, (long)0L, (int)60, null);
                        PlayerUtil.trySendOverlay((Player)player, (ResourceLocation)TBSConstants.id("textures/screens/cantyousee.png"), (long)10L);
                    }
                }
            }
            if (((ServerLevel)level).isDay()) {
                this.discard();
                ((ServerLevel)level).sendParticles((ParticleOptions)TBSParticleTypes.NULL_PARTICLE.get(), this.getX(), this.getY(), this.getZ(), 50, 3.0, 3.0, 3.0, 0.0);
            }
            int n = this.getTimer();
            this.setTimer(n + -1);
            if (this.getTimer() <= 0) {
                this.discard();
                if ((double)this.random.nextFloat() < 0.01) {
                    EntityUtil.applyRandomRotation((Entity)EntityTypeExt.trySummon((EntityType)((EntityType)TBSEntities.SILUET_CHASE.get()), (LevelAccessor)((LevelAccessor)level), (Vec3)this.getPos()));
                }
            }
        }
        this.refreshDimensions();
    }

    private static final double baseTick$r() {
        RandomSource r = RandomSource.create();
        double v = 0.25;
        Intrinsics.checkNotNull((Object)r);
        return RandomUtil.nextDouble((RandomSource)r, (double)(-v), (double)v);
    }

    static {
        BaseMonster.Companion companion = new BaseMonster.Companion[]{Reflection.mutableProperty1((MutablePropertyReference1)((MutablePropertyReference1)new MutablePropertyReference1Impl(SiluetEntity.class, "r2SpaceProgram", "getR2SpaceProgram()Z", 0)))};
        $$delegatedProperties = companion;
        Companion = new Companion(null);
        companion = BaseMonster.Companion;
        BaseMonster.BMC bMC = Companion;
        EntityDataSerializer entityDataSerializer = EntityDataSerializers.BOOLEAN;
        Intrinsics.checkNotNullExpressionValue((Object)entityDataSerializer, (String)"BOOLEAN");
        EntityDataSerializer ser$iv = entityDataSerializer;
        boolean $i$f$data = false;
        EntityDataAccessor entityDataAccessor = SynchedEntityData.defineId(SiluetEntity.class, (EntityDataSerializer)ser$iv);
        Intrinsics.checkNotNullExpressionValue((Object)entityDataAccessor, (String)"defineId(...)");
        ROCKET = entityDataAccessor;
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0003\u0010\u0004R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u001f\u0010\b\u001a\u0010\u0012\f\u0012\n \u000b*\u0004\u0018\u00010\n0\n0\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2={"Lnet/thebrokenscript/entity/siluet/SiluetEntity$Companion;", "Lnet/thebrokenscript/brokencore/api/entity/base/BaseMonster$BMC;", "Lnet/thebrokenscript/entity/siluet/SiluetEntity;", "<init>", "()V", "NATURAL_DESPAWN", "", "IS_ROCKET", "ROCKET", "Lnet/minecraft/network/syncher/EntityDataAccessor;", "", "kotlin.jvm.PlatformType", "getROCKET", "()Lnet/minecraft/network/syncher/EntityDataAccessor;", "ROCKET_DESPAWN_DELAY", "thebrokenscript-common"})
    public static final class Companion
    implements BaseMonster.BMC<SiluetEntity> {
        private Companion() {
        }

        @NotNull
        public final EntityDataAccessor<Boolean> getROCKET() {
            return ROCKET;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

