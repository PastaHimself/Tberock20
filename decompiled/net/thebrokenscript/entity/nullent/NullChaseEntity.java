/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.ranges.RangesKt
 *  net.minecraft.client.player.LocalPlayer
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.particles.ParticleOptions
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.network.chat.Component
 *  net.minecraft.network.chat.MutableComponent
 *  net.minecraft.network.protocol.Packet
 *  net.minecraft.network.protocol.game.ClientboundStopSoundPacket
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.server.level.ServerPlayer
 *  net.minecraft.sounds.SoundEvent
 *  net.minecraft.util.Mth
 *  net.minecraft.world.DifficultyInstance
 *  net.minecraft.world.damagesource.DamageSource
 *  net.minecraft.world.damagesource.DamageTypes
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntityDimensions
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.Mob
 *  net.minecraft.world.entity.MobSpawnType
 *  net.minecraft.world.entity.MoverType
 *  net.minecraft.world.entity.PathfinderMob
 *  net.minecraft.world.entity.Pose
 *  net.minecraft.world.entity.SpawnGroupData
 *  net.minecraft.world.entity.ai.attributes.Attributes
 *  net.minecraft.world.entity.ai.control.MoveControl
 *  net.minecraft.world.entity.ai.control.MoveControl$Operation
 *  net.minecraft.world.entity.ai.goal.FloatGoal
 *  net.minecraft.world.entity.ai.goal.Goal
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.level.GameType
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.level.ServerLevelAccessor
 *  net.minecraft.world.level.material.FluidState
 *  net.minecraft.world.level.pathfinder.PathType
 *  net.minecraft.world.phys.Vec3
 *  net.thebrokenscript.brokencore.api.dsl.ClientDSLKt
 *  net.thebrokenscript.brokencore.api.dsl.ComponentUtil
 *  net.thebrokenscript.brokencore.api.dsl.EntityFinder
 *  net.thebrokenscript.brokencore.api.dsl.EntityUtil
 *  net.thebrokenscript.brokencore.api.dsl.PacketUtil
 *  net.thebrokenscript.brokencore.api.dsl.PlayerUtil
 *  net.thebrokenscript.brokencore.api.dsl.SideUtil
 *  net.thebrokenscript.brokencore.api.dsl.SoundUtil
 *  net.thebrokenscript.brokencore.api.entity.FinalizedSpawn
 *  net.thebrokenscript.brokencore.api.entity.base.BaseMonster
 *  net.thebrokenscript.brokencore.api.ext.BaseMonsterExtKt
 *  net.thebrokenscript.brokencore.api.ext.EntityTypeExt
 *  net.thebrokenscript.brokencore.api.platform.CancelProxy
 *  net.thebrokenscript.brokencore.api.world.TimeOfDay
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.entity.nullent;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientboundStopSoundPacket;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.Mth;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.pathfinder.PathType;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.api.ext.PlayerExt;
import net.thebrokenscript.api.util.BlockBreakHelper;
import net.thebrokenscript.brokencore.api.dsl.ClientDSLKt;
import net.thebrokenscript.brokencore.api.dsl.ComponentUtil;
import net.thebrokenscript.brokencore.api.dsl.EntityFinder;
import net.thebrokenscript.brokencore.api.dsl.EntityUtil;
import net.thebrokenscript.brokencore.api.dsl.PacketUtil;
import net.thebrokenscript.brokencore.api.dsl.PlayerUtil;
import net.thebrokenscript.brokencore.api.dsl.SideUtil;
import net.thebrokenscript.brokencore.api.dsl.SoundUtil;
import net.thebrokenscript.brokencore.api.entity.FinalizedSpawn;
import net.thebrokenscript.brokencore.api.entity.base.BaseMonster;
import net.thebrokenscript.brokencore.api.ext.BaseMonsterExtKt;
import net.thebrokenscript.brokencore.api.ext.EntityTypeExt;
import net.thebrokenscript.brokencore.api.platform.CancelProxy;
import net.thebrokenscript.brokencore.api.world.TimeOfDay;
import net.thebrokenscript.client.data.ClientVariables;
import net.thebrokenscript.config.TBSConfigs;
import net.thebrokenscript.data.PlayerVariables;
import net.thebrokenscript.registry.TBSEntities;
import net.thebrokenscript.registry.TBSLang;
import net.thebrokenscript.registry.TBSParticleTypes;
import net.thebrokenscript.registry.TBSSounds;
import net.thebrokenscript.util.CustomGoals;
import net.thebrokenscript.util.RepTier;
import net.thebrokenscript.util.RepUtilKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 ?2\u00020\u00012\u00020\u0002:\u0002>?B\u001d\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00000\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0004\b\u0007\u0010\bJ\b\u0010\t\u001a\u00020\nH\u0014J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0018\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\fH\u0016J\u0010\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0010\u0010\u001f\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0010\u0010 \u001a\u00020\f2\u0006\u0010!\u001a\u00020\"H\u0016J\u0010\u0010#\u001a\u00020\n2\u0006\u0010$\u001a\u00020%H\u0016J4\u0010&\u001a\u0004\u0018\u00010'2\u0006\u0010\u0005\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010'2\u0006\u0010.\u001a\u00020/H\u0016J \u00100\u001a\u00020\n2\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u00020\u00162\u0006\u00104\u001a\u00020\u0011H\u0016J\u0010\u00105\u001a\u0002062\u0006\u00107\u001a\u000208H\u0014J\b\u00109\u001a\u00020\fH\u0016J\b\u0010:\u001a\u00020\nH\u0016J\b\u0010;\u001a\u00020\nH\u0016J\u0010\u0010<\u001a\u00020\n2\u0006\u00104\u001a\u00020\u0011H\u0016J\b\u0010=\u001a\u00020\fH\u0016R$\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u00168F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b\u00a8\u0006@"}, d2={"Lnet/thebrokenscript/entity/nullent/NullChaseEntity;", "Lnet/thebrokenscript/brokencore/api/entity/base/BaseMonster;", "Lnet/thebrokenscript/brokencore/api/entity/FinalizedSpawn;", "type", "Lnet/minecraft/world/entity/EntityType;", "level", "Lnet/minecraft/world/level/Level;", "<init>", "(Lnet/minecraft/world/entity/EntityType;Lnet/minecraft/world/level/Level;)V", "registerGoals", "", "removeWhenFarAway", "", "distanceToClosestPlayer", "", "hurt", "source", "Lnet/minecraft/world/damagesource/DamageSource;", "amount", "", "fireImmune", "value", "", "timer", "getTimer", "()I", "setTimer", "(I)V", "addAdditionalSaveData", "compound", "Lnet/minecraft/nbt/CompoundTag;", "readAdditionalSaveData", "canStandOnFluid", "fluidState", "Lnet/minecraft/world/level/material/FluidState;", "travel", "travelVector", "Lnet/minecraft/world/phys/Vec3;", "onFinalizeSpawn", "Lnet/minecraft/world/entity/SpawnGroupData;", "Lnet/minecraft/world/level/ServerLevelAccessor;", "difficulty", "Lnet/minecraft/world/DifficultyInstance;", "spawnType", "Lnet/minecraft/world/entity/MobSpawnType;", "spawnData", "event", "Lnet/thebrokenscript/brokencore/api/platform/CancelProxy;", "awardKillScore", "entity", "Lnet/minecraft/world/entity/Entity;", "score", "damageSource", "getDefaultDimensions", "Lnet/minecraft/world/entity/EntityDimensions;", "pose", "Lnet/minecraft/world/entity/Pose;", "isVisuallySwimming", "tick", "baseTick", "die", "isPushedByFluid", "NullMoveControl", "Companion", "thebrokenscript-common"})
public final class NullChaseEntity
extends BaseMonster
implements FinalizedSpawn {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private static final String NULL_TIMER = "nullTimer";

    public NullChaseEntity(@NotNull EntityType<NullChaseEntity> type, @NotNull Level level) {
        Intrinsics.checkNotNullParameter(type, (String)"type");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        super(type, level);
        this.xpReward = 50;
        this.setNoAi(false);
        this.setPersistenceRequired();
        this.setPathfindingMalus(PathType.LAVA, 0.0f);
        this.setPathfindingMalus(PathType.FENCE, 0.0f);
        this.setPathfindingMalus(PathType.RAIL, 0.0f);
        this.setPathfindingMalus(PathType.WATER, 0.0f);
        this.setPathfindingMalus(PathType.WATER_BORDER, 0.0f);
        this.moveControl = new NullMoveControl(this);
    }

    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(1, (Goal)new CustomGoals.ContinuousMeleeAttackGoal((PathfinderMob)this, 1.325, 0.0f, 0.0, 12, null));
        this.goalSelector.addGoal(2, (Goal)new FloatGoal((Mob)this));
        this.targetSelector.addGoal(1, (Goal)new CustomGoals.AlwaysTargetPlayerGoal((Mob)this, 800));
    }

    public boolean removeWhenFarAway(double distanceToClosestPlayer) {
        return false;
    }

    public boolean hurt(@NotNull DamageSource source, float amount) {
        Intrinsics.checkNotNullParameter((Object)source, (String)"source");
        boolean isPlayer = source.getDirectEntity() instanceof Player;
        return isPlayer || Intrinsics.areEqual((Object)source.type(), (Object)DamageTypes.GENERIC_KILL) || Intrinsics.areEqual((Object)source.type(), (Object)DamageTypes.FELL_OUT_OF_WORLD) ? super.hurt(source, amount) : false;
    }

    public boolean fireImmune() {
        return true;
    }

    public final int getTimer() {
        return EntityUtil.getPersistentData((Entity)((Entity)this)).getInt(NULL_TIMER);
    }

    public final void setTimer(int value) {
        EntityUtil.getPersistentData((Entity)((Entity)this)).putInt(NULL_TIMER, value);
    }

    public void addAdditionalSaveData(@NotNull CompoundTag compound) {
        Intrinsics.checkNotNullParameter((Object)compound, (String)"compound");
        super.addAdditionalSaveData(compound);
        compound.putInt(NULL_TIMER, this.getTimer());
    }

    public void readAdditionalSaveData(@NotNull CompoundTag compound) {
        Intrinsics.checkNotNullParameter((Object)compound, (String)"compound");
        super.readAdditionalSaveData(compound);
        this.setTimer(compound.getInt(NULL_TIMER));
    }

    public boolean canStandOnFluid(@NotNull FluidState fluidState) {
        block7: {
            block5: {
                block6: {
                    block4: {
                        Intrinsics.checkNotNullParameter((Object)fluidState, (String)"fluidState");
                        if (this.getTarget() == null) {
                            return !fluidState.isEmpty();
                        }
                        LivingEntity livingEntity = this.getTarget();
                        Intrinsics.checkNotNull((Object)livingEntity);
                        if (!livingEntity.isSwimming()) break block4;
                        LivingEntity livingEntity2 = this.getTarget();
                        Intrinsics.checkNotNull((Object)livingEntity2);
                        if (livingEntity2.isInWater()) break block5;
                    }
                    LivingEntity livingEntity = this.getTarget();
                    Intrinsics.checkNotNull((Object)livingEntity);
                    if (!livingEntity.isVisuallySwimming()) break block6;
                    LivingEntity livingEntity3 = this.getTarget();
                    Intrinsics.checkNotNull((Object)livingEntity3);
                    if (livingEntity3.isInWater()) break block5;
                }
                LivingEntity livingEntity = this.getTarget();
                Intrinsics.checkNotNull((Object)livingEntity);
                if (!livingEntity.isInWater()) break block7;
            }
            return false;
        }
        return !fluidState.isEmpty();
    }

    /*
     * Unable to fully structure code
     */
    public void travel(@NotNull Vec3 travelVector) {
        block2: {
            Intrinsics.checkNotNullParameter((Object)travelVector, (String)"travelVector");
            if (!this.isControlledByLocalInstance()) break block2;
            fluidstate = this.level().getFluidState(this.blockPosition());
            if (!this.isInWater() || !this.isAffectedByFluids()) ** GOTO lbl-1000
            Intrinsics.checkNotNull((Object)fluidstate);
            if (!this.canStandOnFluid(fluidstate)) {
                this.moveRelative(this.getSpeed(), travelVector);
                this.move(MoverType.SELF, this.getDeltaMovement());
                this.setDeltaMovement(this.getDeltaMovement().multiply(0.6, 0.98, 0.6));
            } else lbl-1000:
            // 2 sources

            {
                super.travel(travelVector);
                return;
            }
        }
        this.calculateEntityAnimation(false);
    }

    @Nullable
    public SpawnGroupData onFinalizeSpawn(@NotNull ServerLevelAccessor level, @NotNull DifficultyInstance difficulty, @NotNull MobSpawnType spawnType, @Nullable SpawnGroupData spawnData, @NotNull CancelProxy event) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)difficulty, (String)"difficulty");
        Intrinsics.checkNotNullParameter((Object)spawnType, (String)"spawnType");
        Intrinsics.checkNotNullParameter((Object)event, (String)"event");
        if (!level.getBlockState(this.getBlockPos()).getFluidState().isEmpty()) {
            Entity entity = (Entity)this;
            Vec3 vec3 = this.getPos().add(0.0, 0.5, 0.0);
            Intrinsics.checkNotNullExpressionValue((Object)vec3, (String)"add(...)");
            EntityUtil.teleport((Entity)entity, (Vec3)vec3);
        }
        List players = EntityFinder.findPlayersInRange((ServerLevelAccessor)level, (Vec3)this.getPos(), (Number)150);
        for (ServerPlayer player : players) {
            if (!BaseMonsterExtKt.hasLineOfSightThroughTransparent((BaseMonster)this, (Player)((Player)player)) && !this.hasLineOfSight((Entity)player)) continue;
            PlayerExt playerExt = PlayerExt.INSTANCE;
            SoundEvent soundEvent = (SoundEvent)TBSSounds.NULL_JUMPSCARE_LOUD.invoke();
            PlayerExt.tryPlayHostile$default(playerExt, (Player)player, soundEvent, false, 0.075f, 0.65f, 0.2f, 2, null);
        }
        this.setTimer(450);
        for (ServerPlayer player : EntityFinder.findPlayersInRange((ServerLevelAccessor)level, (Vec3)this.getPos(), (Number)200)) {
            PlayerVariables vars = PlayerExt.INSTANCE.getVars((Player)player);
            if (vars.getEntityReputation() > 5) {
                RepUtilKt.applyRep((Player)player, RepTier.LOSS_TEENYTINY);
            }
            vars.syncTo((Player)player);
        }
        return null;
    }

    public void awardKillScore(@NotNull Entity entity, int score, @NotNull DamageSource damageSource) {
        Intrinsics.checkNotNullParameter((Object)entity, (String)"entity");
        Intrinsics.checkNotNullParameter((Object)damageSource, (String)"damageSource");
        super.awardKillScore(entity, score, damageSource);
        Level level = this.level();
        if (!(level instanceof ServerLevel)) {
            return;
        }
        PacketUtil.tryBroadcastPacket((LevelAccessor)((LevelAccessor)level), (Packet)((Packet)new ClientboundStopSoundPacket(null, null)));
        SoundUtil.playSound$default((LevelAccessor)((LevelAccessor)level), (Vec3)this.getPos(), (SoundEvent)((SoundEvent)TBSSounds.NULL_KILLS_PLAYER.get()), (float)5.0f, (float)0.0f, null, (int)24, null);
        if (entity instanceof ServerPlayer) {
            PlayerExt.INSTANCE.updateVars((Player)entity, (Function1<? super PlayerVariables, Unit>)((Function1)NullChaseEntity::awardKillScore$lambda$0));
            ServerPlayer serverPlayer = (ServerPlayer)entity;
            String string = ComponentUtil.getTranslationKey((Component)((Component)TBSLang.INSTANCE.getNULL_CHASE_KICK()));
            Intrinsics.checkNotNull((Object)string);
            MutableComponent mutableComponent = Component.translatable((String)string);
            Intrinsics.checkNotNullExpressionValue((Object)mutableComponent, (String)"translatable(...)");
            PlayerUtil.kick((ServerPlayer)serverPlayer, (Component)((Component)mutableComponent));
        }
        this.discard();
    }

    @NotNull
    protected EntityDimensions getDefaultDimensions(@NotNull Pose pose) {
        EntityDimensions entityDimensions;
        Intrinsics.checkNotNullParameter((Object)pose, (String)"pose");
        if (pose == Pose.SWIMMING) {
            EntityDimensions entityDimensions2 = EntityDimensions.scalable((float)0.6f, (float)0.3f);
            Intrinsics.checkNotNull((Object)entityDimensions2);
            entityDimensions = entityDimensions2;
        } else {
            EntityDimensions entityDimensions3 = super.getDefaultDimensions(pose);
            Intrinsics.checkNotNull((Object)entityDimensions3);
            entityDimensions = entityDimensions3;
        }
        return entityDimensions;
    }

    public boolean isVisuallySwimming() {
        return this.getPose() == Pose.SWIMMING;
    }

    public void tick() {
        super.tick();
        SideUtil.clientSide((Entity)((Entity)this), () -> NullChaseEntity.tick$lambda$0(this));
    }

    /*
     * Unable to fully structure code
     */
    public void baseTick() {
        super.baseTick();
        level = this.level();
        if (level.getBlockState(this.getBlockPos()).getFluidState().isEmpty() && level.getBlockState(this.getBlockPos().above()).getFluidState().isEmpty()) ** GOTO lbl-1000
        if (level.isClientSide) ** GOTO lbl-1000
        v0 = this.getBlockStateOn().getFluidState();
        Intrinsics.checkNotNullExpressionValue((Object)v0, (String)"getFluidState(...)");
        if (!this.canStandOnFluid(v0)) lbl-1000:
        // 2 sources

        {
            v1 = true;
        } else lbl-1000:
        // 2 sources

        {
            v1 = inFluid = false;
        }
        if (inFluid) {
            this.navigation.setCanFloat(true);
            this.setSwimming(true);
            if (this.getPose() != Pose.SWIMMING) {
                this.setPose(Pose.SWIMMING);
            }
            if (this.getTarget() != null) {
                this.navigation.stop();
                v2 = this.getTarget();
                Intrinsics.checkNotNull((Object)v2);
                if (v2.getY() > this.getPos().y) {
                    this.setDeltaMovement(this.getDeltaMovement().x, 0.1, this.getDeltaMovement().z);
                } else {
                    this.setDeltaMovement(this.getDeltaMovement().x, -0.1, this.getDeltaMovement().z);
                }
                v3 = this.getTarget();
                Intrinsics.checkNotNull((Object)v3);
                v4 = v3.getX();
                v5 = this.getTarget();
                Intrinsics.checkNotNull((Object)v5);
                v6 = v5.getY();
                v7 = this.getTarget();
                Intrinsics.checkNotNull((Object)v7);
                this.moveControl.setWantedPosition(v4, v6, v7.getZ(), 0.75);
            }
        } else {
            if (this.isUnderWater()) {
                v8 = this.getBlockStateOn().getFluidState();
                Intrinsics.checkNotNullExpressionValue((Object)v8, (String)"getFluidState(...)");
                if (this.canStandOnFluid(v8)) {
                    this.setDeltaMovement(this.getDeltaMovement().x, 0.75, this.getDeltaMovement().z);
                }
            }
            this.setSwimming(false);
            if (this.getPose() != Pose.STANDING) {
                this.setPose(Pose.STANDING);
            }
        }
        if (this.isVisuallySwimming()) {
            this.yBodyRot = Mth.rotateIfNecessary((float)this.yBodyRot, (float)this.getYRot(), (float)10.0f);
        }
        if (!(level instanceof ServerLevel)) {
            return;
        }
        if ((double)this.random.nextFloat() < 0.25) {
            ((ServerLevel)level).sendParticles((ParticleOptions)TBSParticleTypes.NULL_PARTICLE.get(), this.getX(), this.getY(), this.getZ(), 2, 2.0, 3.0, 2.0, 0.0);
        }
        v9 = EntityFinder.findClosestPlayerInRange((ServerLevel)((ServerLevel)level), (Vec3)this.getPos(), (Number)520.0);
        if (v9 == null) {
            this.discard();
            return;
        }
        player = v9;
        this.setTarget((LivingEntity)player);
        if ((double)this.random.nextFloat() < 0.01) {
            TimeOfDay.MIDNIGHT.setFake();
        } else if ((double)this.random.nextFloat() < 0.01) {
            TimeOfDay.DAY.setFake();
        }
        pos = BlockPos.containing((double)this.getX(), (double)this.getY(), (double)this.getZ());
        if (!TBSConfigs.INSTANCE.getServer().getDisableBlockBreaking() && (this.navigation.isStuck() || this.navigation.isDone()) && this.getTarget() != null) {
            lookDistance = 3;
            facing = new Vec3(this.getLookAngle().x, 0.0, this.getLookAngle().z).normalize();
            i = 1;
            while (true) {
                frontPos = this.blockPosition().offset((int)(facing.x * (double)i), 0, (int)(facing.z * (double)i));
                j = 0;
                var10_10 = (int)this.getBbHeight() + 1;
                if (j <= var10_10) {
                    while (true) {
                        if (!(state = ((ServerLevel)level).getBlockState(checkPos = frontPos.above(j))).isAir()) {
                            v10 = (LevelAccessor)level;
                            Intrinsics.checkNotNull((Object)checkPos);
                            BlockBreakHelper.INSTANCE.tryBreakCircuit(v10, checkPos);
                        }
                        if (j == var10_10) break;
                        ++j;
                    }
                }
                if (i == lookDistance) break;
                ++i;
            }
        }
        player.setGameMode(GameType.SURVIVAL);
        var5_5 = this.getTimer();
        this.setTimer(var5_5 + -1);
        if (this.getTimer() <= 0) {
            PacketUtil.tryBroadcastPacket((LevelAccessor)((LevelAccessor)level), (Packet)((Packet)new ClientboundStopSoundPacket(null, null)));
            this.discard();
            if ((double)this.random.nextFloat() > 0.7) {
                v11 = (EntityType)TBSEntities.NULL_IS_HERE.get();
                v12 = (LevelAccessor)level;
                Intrinsics.checkNotNull((Object)pos);
                EntityUtil.applyRandomRotation((Entity)EntityTypeExt.trySummon((EntityType)v11, (LevelAccessor)v12, (BlockPos)pos));
            }
        }
    }

    public void die(@NotNull DamageSource damageSource) {
        Intrinsics.checkNotNullParameter((Object)damageSource, (String)"damageSource");
        Entity entity = damageSource.getEntity();
        if (entity instanceof ServerPlayer) {
            RepUtilKt.applyRep((Player)entity, RepTier.LOSS_IHY);
        }
        super.die(damageSource);
    }

    public boolean isPushedByFluid() {
        return false;
    }

    private static final Unit awardKillScore$lambda$0(PlayerVariables $this$updateVars) {
        Intrinsics.checkNotNullParameter((Object)$this$updateVars, (String)"$this$updateVars");
        $this$updateVars.setAberrationEnabled(false);
        return Unit.INSTANCE;
    }

    private static final Object tick$lambda$0(NullChaseEntity this$0) {
        if (!ClientVariables.INSTANCE.has(16L)) {
            LocalPlayer localPlayer = ClientDSLKt.getMC().player;
            if (localPlayer == null) {
                return false;
            }
            LocalPlayer player = localPlayer;
            if (PlayerExt.INSTANCE.isEntityInFovCone((Player)player, (Entity)this$0, Double.valueOf(((Number)ClientDSLKt.getMC().options.fov().get()).intValue()))) {
                ClientVariables.INSTANCE.set(16L);
            }
        }
        return Unit.INSTANCE;
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2={"Lnet/thebrokenscript/entity/nullent/NullChaseEntity$Companion;", "", "<init>", "()V", "NULL_TIMER", "", "thebrokenscript-common"})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2={"Lnet/thebrokenscript/entity/nullent/NullChaseEntity$NullMoveControl;", "Lnet/minecraft/world/entity/ai/control/MoveControl;", "nullChaseEntity", "Lnet/thebrokenscript/entity/nullent/NullChaseEntity;", "<init>", "(Lnet/thebrokenscript/entity/nullent/NullChaseEntity;)V", "tick", "", "thebrokenscript-common"})
    private static final class NullMoveControl
    extends MoveControl {
        @NotNull
        private final NullChaseEntity nullChaseEntity;

        public NullMoveControl(@NotNull NullChaseEntity nullChaseEntity) {
            Intrinsics.checkNotNullParameter((Object)((Object)nullChaseEntity), (String)"nullChaseEntity");
            super((Mob)nullChaseEntity);
            this.nullChaseEntity = nullChaseEntity;
        }

        public void tick() {
            if (this.nullChaseEntity.isVisuallySwimming()) {
                this.operation = MoveControl.Operation.WAIT;
                double d0 = this.wantedX - this.nullChaseEntity.getX();
                double d1 = this.wantedZ - this.nullChaseEntity.getZ();
                double d2 = this.wantedY - this.nullChaseEntity.getY();
                double dist = d0 * d0 + d2 * d2 + d1 * d1;
                if (dist < 2.5000003E-7) {
                    this.nullChaseEntity.zza = 0.0f;
                    return;
                }
                float f = (float)(Mth.atan2((double)d1, (double)d0) * 57.29577951308232) - 90.0f;
                this.nullChaseEntity.setYRot(this.rotlerp(this.nullChaseEntity.getYRot(), f, 5.0f));
                this.nullChaseEntity.yBodyRot = this.nullChaseEntity.getYRot();
                float angleDiff = Mth.abs((float)Mth.wrapDegrees((float)(this.nullChaseEntity.getYRot() - f)));
                float alignmentFactor = RangesKt.coerceIn((float)(1.0f - angleDiff / 90.0f), (float)0.0f, (float)1.0f);
                this.nullChaseEntity.setSpeed((float)(this.speedModifier * this.nullChaseEntity.getAttributeValue(Attributes.MOVEMENT_SPEED)));
                this.nullChaseEntity.zza = alignmentFactor;
            } else {
                super.tick();
            }
        }
    }
}

