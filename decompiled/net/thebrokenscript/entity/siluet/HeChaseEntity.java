/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.commands.arguments.EntityAnchorArgument$Anchor
 *  net.minecraft.core.BlockPos
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.network.syncher.EntityDataAccessor
 *  net.minecraft.network.syncher.EntityDataSerializer
 *  net.minecraft.network.syncher.EntityDataSerializers
 *  net.minecraft.network.syncher.SynchedEntityData
 *  net.minecraft.network.syncher.SynchedEntityData$Builder
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.server.level.ServerPlayer
 *  net.minecraft.world.DifficultyInstance
 *  net.minecraft.world.damagesource.DamageSource
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.Mob
 *  net.minecraft.world.entity.MobSpawnType
 *  net.minecraft.world.entity.PathfinderMob
 *  net.minecraft.world.entity.SpawnGroupData
 *  net.minecraft.world.entity.ai.attributes.AttributeInstance
 *  net.minecraft.world.entity.ai.attributes.Attributes
 *  net.minecraft.world.entity.ai.goal.FloatGoal
 *  net.minecraft.world.entity.ai.goal.Goal
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.level.GameType
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.level.ServerLevelAccessor
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.pathfinder.PathType
 *  net.minecraft.world.phys.Vec3
 *  net.thebrokenscript.brokencore.api.dsl.EntityFinder
 *  net.thebrokenscript.brokencore.api.dsl.EntityUtil
 *  net.thebrokenscript.brokencore.api.dsl.PlayerUtil
 *  net.thebrokenscript.brokencore.api.entity.FinalizedSpawn
 *  net.thebrokenscript.brokencore.api.platform.CancelProxy
 *  net.thebrokenscript.brokencore.api.world.TimeOfDay
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.entity.siluet;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.commands.arguments.EntityAnchorArgument;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializer;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.PathType;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.api.entity.BaseSiluetEntity;
import net.thebrokenscript.api.entity.ai.siluet.SiluetGoals;
import net.thebrokenscript.api.util.BlockBreakHelper;
import net.thebrokenscript.brokencore.api.dsl.EntityFinder;
import net.thebrokenscript.brokencore.api.dsl.EntityUtil;
import net.thebrokenscript.brokencore.api.dsl.PlayerUtil;
import net.thebrokenscript.brokencore.api.entity.FinalizedSpawn;
import net.thebrokenscript.brokencore.api.platform.CancelProxy;
import net.thebrokenscript.brokencore.api.world.TimeOfDay;
import net.thebrokenscript.config.TBSConfigs;
import net.thebrokenscript.util.RepTier;
import net.thebrokenscript.util.RepUtilKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 $2\u00020\u00012\u00020\u0002:\u0001$B\u001d\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00000\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0004\b\u0007\u0010\bJ\b\u0010\t\u001a\u00020\nH\u0014J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\rH\u0014J\u0010\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J4\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0005\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J \u0010\u001c\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0016J\b\u0010#\u001a\u00020\nH\u0016\u00a8\u0006%"}, d2={"Lnet/thebrokenscript/entity/siluet/HeChaseEntity;", "Lnet/thebrokenscript/api/entity/BaseSiluetEntity;", "Lnet/thebrokenscript/brokencore/api/entity/FinalizedSpawn;", "type", "Lnet/minecraft/world/entity/EntityType;", "level", "Lnet/minecraft/world/level/Level;", "<init>", "(Lnet/minecraft/world/entity/EntityType;Lnet/minecraft/world/level/Level;)V", "registerGoals", "", "defineSynchedData", "builder", "Lnet/minecraft/network/syncher/SynchedEntityData$Builder;", "addAdditionalSaveData", "compound", "Lnet/minecraft/nbt/CompoundTag;", "readAdditionalSaveData", "onFinalizeSpawn", "Lnet/minecraft/world/entity/SpawnGroupData;", "Lnet/minecraft/world/level/ServerLevelAccessor;", "difficulty", "Lnet/minecraft/world/DifficultyInstance;", "spawnType", "Lnet/minecraft/world/entity/MobSpawnType;", "spawnData", "event", "Lnet/thebrokenscript/brokencore/api/platform/CancelProxy;", "awardKillScore", "entity", "Lnet/minecraft/world/entity/Entity;", "score", "", "source", "Lnet/minecraft/world/damagesource/DamageSource;", "baseTick", "Companion", "thebrokenscript-common"})
public final class HeChaseEntity
extends BaseSiluetEntity
implements FinalizedSpawn {
    @NotNull
    public static final Companion Companion = new Companion(null);
    private static final EntityDataAccessor<Integer> DESPAWN_TIMER = SynchedEntityData.defineId(HeChaseEntity.class, (EntityDataSerializer)EntityDataSerializers.INT);

    public HeChaseEntity(@NotNull EntityType<HeChaseEntity> type, @NotNull Level level) {
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
    }

    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(1, (Goal)new SiluetGoals.ContinuousMeleeAttackGoal((PathfinderMob)this, 1.125, 0.0, 0.0f, 0.0f, 28, null));
        this.goalSelector.addGoal(2, (Goal)new FloatGoal((Mob)this));
        this.targetSelector.addGoal(1, (Goal)new SiluetGoals.AlwaysTargetPlayerGoal((Mob)this, 800));
    }

    protected void defineSynchedData(@NotNull SynchedEntityData.Builder builder) {
        Intrinsics.checkNotNullParameter((Object)builder, (String)"builder");
        super.defineSynchedData(builder);
        builder.define(DESPAWN_TIMER, (Object)0);
    }

    public void addAdditionalSaveData(@NotNull CompoundTag compound) {
        Intrinsics.checkNotNullParameter((Object)compound, (String)"compound");
        super.addAdditionalSaveData(compound);
        Object object = this.entityData.get(DESPAWN_TIMER);
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"get(...)");
        compound.putInt("despawn_timer", ((Number)object).intValue());
    }

    public void readAdditionalSaveData(@NotNull CompoundTag compound) {
        Intrinsics.checkNotNullParameter((Object)compound, (String)"compound");
        super.readAdditionalSaveData(compound);
        if (compound.contains("despawn_timer")) {
            this.entityData.set(DESPAWN_TIMER, (Object)compound.getInt("despawn_timer"));
        }
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
        return null;
    }

    public void awardKillScore(@NotNull Entity entity, int score, @NotNull DamageSource source) {
        block2: {
            Intrinsics.checkNotNullParameter((Object)entity, (String)"entity");
            Intrinsics.checkNotNullParameter((Object)source, (String)"source");
            super.awardKillScore(entity, score, source);
            if (this.level().isClientSide) {
                return;
            }
            this.discard();
            if (!((double)this.random.nextFloat() < 0.3)) break block2;
            ServerPlayer serverPlayer = entity instanceof ServerPlayer ? (ServerPlayer)entity : null;
            if (serverPlayer != null) {
                PlayerUtil.tryCrash((Player)((Player)serverPlayer));
            }
        }
    }

    @Override
    public void baseTick() {
        super.baseTick();
        Level level = this.level();
        if (!(level instanceof ServerLevel)) {
            return;
        }
        SynchedEntityData synchedEntityData = this.entityData;
        Intrinsics.checkNotNullExpressionValue((Object)synchedEntityData, (String)"entityData");
        EntityDataAccessor<Integer> entityDataAccessor = DESPAWN_TIMER;
        Intrinsics.checkNotNullExpressionValue(entityDataAccessor, (String)"DESPAWN_TIMER");
        if (EntityUtil.incInt((SynchedEntityData)synchedEntityData, entityDataAccessor) > 800) {
            this.discard();
            if (this.getTarget() != null && this.getTarget() instanceof ServerPlayer) {
                LivingEntity livingEntity = this.getTarget();
                Intrinsics.checkNotNull((Object)livingEntity, (String)"null cannot be cast to non-null type net.minecraft.server.level.ServerPlayer");
                RepUtilKt.applyRep((Player)((ServerPlayer)livingEntity), RepTier.GAIN_MINOR);
            }
            return;
        }
        ServerPlayer serverPlayer = EntityFinder.findClosestPlayerInRange((ServerLevel)((ServerLevel)level), (Vec3)this.getPos(), (Number)800);
        if (serverPlayer == null) {
            return;
        }
        ServerPlayer player = serverPlayer;
        this.lookAt(EntityAnchorArgument.Anchor.EYES, player.position());
        if ((double)this.random.nextFloat() < 0.01) {
            TimeOfDay.MIDNIGHT.setFake();
        } else if ((double)this.random.nextFloat() < 0.01) {
            TimeOfDay.DAY.setFake();
        }
        if (player.isSpectator() || player.isCreative()) {
            player.setGameMode(GameType.SURVIVAL);
        }
        if (this.getTarget() != null) {
            boolean shouldBreakBlocks;
            LivingEntity livingEntity = this.getTarget();
            Intrinsics.checkNotNull((Object)livingEntity);
            double yDifference = Math.abs(livingEntity.getY() - this.getY());
            int maxYDifferenceForBreaking = 3;
            LivingEntity livingEntity2 = this.getTarget();
            Intrinsics.checkNotNull((Object)livingEntity2, (String)"null cannot be cast to non-null type net.minecraft.world.entity.Entity");
            double distanceToTarget = this.distanceToSqr((Entity)livingEntity2);
            boolean bl = shouldBreakBlocks = this.navigation.isStuck() || this.navigation.isDone() || distanceToTarget < 100.0 && this.getDeltaMovement().lengthSqr() < 0.01;
            if (shouldBreakBlocks && yDifference <= (double)maxYDifferenceForBreaking) {
                AttributeInstance attributeInstance = this.getAttribute(Attributes.STEP_HEIGHT);
                if (attributeInstance != null) {
                    attributeInstance.setBaseValue(0.6);
                }
                int lookDistance = 3;
                Vec3 facing = new Vec3(this.getLookAngle().x, 0.0, this.getLookAngle().z).normalize();
                int i = 1;
                while (true) {
                    BlockPos frontPos = this.blockPosition().offset((int)(facing.x * (double)i), 0, (int)(facing.z * (double)i));
                    int j = 0;
                    int n = (int)this.getBbHeight() + 1;
                    if (j <= n) {
                        while (true) {
                            BlockPos checkPos;
                            BlockState state;
                            if (!(state = ((ServerLevel)level).getBlockState(checkPos = frontPos.above(j))).isAir() && !TBSConfigs.INSTANCE.getServer().getDisableBlockBreaking()) {
                                LevelAccessor levelAccessor = (LevelAccessor)level;
                                Intrinsics.checkNotNull((Object)checkPos);
                                BlockBreakHelper.INSTANCE.tryBreakCircuit(levelAccessor, checkPos);
                            }
                            if (j == n) break;
                            ++j;
                        }
                    }
                    if (i != lookDistance) {
                        ++i;
                        continue;
                    }
                    break;
                }
            } else if (yDifference > (double)maxYDifferenceForBreaking) {
                AttributeInstance attributeInstance = this.getAttribute(Attributes.STEP_HEIGHT);
                if (attributeInstance != null) {
                    attributeInstance.setBaseValue(10.6);
                }
            } else {
                AttributeInstance attributeInstance = this.getAttribute(Attributes.STEP_HEIGHT);
                if (attributeInstance != null) {
                    attributeInstance.setBaseValue(0.6);
                }
            }
        } else {
            AttributeInstance attributeInstance = this.getAttribute(Attributes.STEP_HEIGHT);
            if (attributeInstance != null) {
                attributeInstance.setBaseValue(0.6);
            }
        }
        this.refreshDimensions();
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R2\u0010\u0004\u001a&\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u0006 \u0007*\u0012\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u0006\u0018\u00010\u00050\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2={"Lnet/thebrokenscript/entity/siluet/HeChaseEntity$Companion;", "", "<init>", "()V", "DESPAWN_TIMER", "Lnet/minecraft/network/syncher/EntityDataAccessor;", "", "kotlin.jvm.PlatformType", "thebrokenscript-common"})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

