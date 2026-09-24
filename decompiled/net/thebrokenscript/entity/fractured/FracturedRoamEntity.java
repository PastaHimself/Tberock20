/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.MutablePropertyReference1
 *  kotlin.jvm.internal.MutablePropertyReference1Impl
 *  kotlin.jvm.internal.Reflection
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.random.Random
 *  kotlin.ranges.IntRange
 *  kotlin.ranges.RangesKt
 *  kotlin.reflect.KProperty
 *  net.minecraft.client.player.LocalPlayer
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Position
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.network.syncher.EntityDataAccessor
 *  net.minecraft.network.syncher.EntityDataSerializer
 *  net.minecraft.network.syncher.EntityDataSerializers
 *  net.minecraft.network.syncher.SynchedEntityData
 *  net.minecraft.network.syncher.SynchedEntityData$Builder
 *  net.minecraft.tags.DamageTypeTags
 *  net.minecraft.world.DifficultyInstance
 *  net.minecraft.world.damagesource.DamageSource
 *  net.minecraft.world.damagesource.DamageTypes
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.Mob
 *  net.minecraft.world.entity.MobSpawnType
 *  net.minecraft.world.entity.PathfinderMob
 *  net.minecraft.world.entity.SpawnGroupData
 *  net.minecraft.world.entity.ai.control.MoveControl
 *  net.minecraft.world.entity.ai.control.MoveControl$Operation
 *  net.minecraft.world.entity.ai.goal.Goal
 *  net.minecraft.world.entity.ai.goal.RandomLookAroundGoal
 *  net.minecraft.world.entity.ai.goal.RandomStrollGoal
 *  net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal
 *  net.minecraft.world.entity.ai.util.DefaultRandomPos
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.ServerLevelAccessor
 *  net.minecraft.world.phys.Vec3
 *  net.thebrokenscript.brokencore.api.dsl.ClientDSLKt
 *  net.thebrokenscript.brokencore.api.dsl.EntityDataDelegate
 *  net.thebrokenscript.brokencore.api.dsl.SideUtil
 *  net.thebrokenscript.brokencore.api.entity.FinalizedSpawn
 *  net.thebrokenscript.brokencore.api.entity.base.BaseMonster
 *  net.thebrokenscript.brokencore.api.entity.base.BaseMonster$BMC
 *  net.thebrokenscript.brokencore.api.entity.base.BaseMonster$Companion
 *  net.thebrokenscript.brokencore.api.platform.CancelProxy
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.entity.fractured;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.random.Random;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KProperty;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Position;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializer;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.util.DefaultRandomPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.api.entity.BaseFracturedEntity;
import net.thebrokenscript.api.entity.ai.fractured.FracturedRoamGoUnDerGroundGoal;
import net.thebrokenscript.api.ext.PlayerExt;
import net.thebrokenscript.brokencore.api.dsl.ClientDSLKt;
import net.thebrokenscript.brokencore.api.dsl.EntityDataDelegate;
import net.thebrokenscript.brokencore.api.dsl.SideUtil;
import net.thebrokenscript.brokencore.api.entity.FinalizedSpawn;
import net.thebrokenscript.brokencore.api.entity.base.BaseMonster;
import net.thebrokenscript.brokencore.api.platform.CancelProxy;
import net.thebrokenscript.client.data.ClientVariables;
import net.thebrokenscript.entity.fractured.FracturedRoamEntity;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 42\u00020\u00012\u00020\u0002:\u00014B\u001d\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00000\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0010\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0010\u0010\u001f\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020!H\u0014J\b\u0010\"\u001a\u00020\u001bH\u0014J\u0018\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(H\u0016J\b\u0010)\u001a\u00020\u001bH\u0016J4\u0010*\u001a\u0004\u0018\u00010+2\u0006\u0010\u0005\u001a\u00020,2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u00010+2\u0006\u00102\u001a\u000203H\u0016R+\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR+\u0010\u0012\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0011\u001a\u0004\b\u0013\u0010\r\"\u0004\b\u0014\u0010\u000fR+\u0010\u0016\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u0011\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000f\u00a8\u00065"}, d2={"Lnet/thebrokenscript/entity/fractured/FracturedRoamEntity;", "Lnet/thebrokenscript/api/entity/BaseFracturedEntity;", "Lnet/thebrokenscript/brokencore/api/entity/FinalizedSpawn;", "type", "Lnet/minecraft/world/entity/EntityType;", "level", "Lnet/minecraft/world/level/Level;", "<init>", "(Lnet/minecraft/world/entity/EntityType;Lnet/minecraft/world/level/Level;)V", "<set-?>", "", "timer", "getTimer", "()I", "setTimer", "(I)V", "timer$delegate", "Lnet/thebrokenscript/brokencore/api/dsl/EntityDataDelegate;", "digCooldown", "getDigCooldown", "setDigCooldown", "digCooldown$delegate", "despawnTimer", "getDespawnTimer", "setDespawnTimer", "despawnTimer$delegate", "addAdditionalSaveData", "", "compound", "Lnet/minecraft/nbt/CompoundTag;", "readAdditionalSaveData", "defineSynchedData", "builder", "Lnet/minecraft/network/syncher/SynchedEntityData$Builder;", "registerGoals", "hurt", "", "source", "Lnet/minecraft/world/damagesource/DamageSource;", "amount", "", "tick", "onFinalizeSpawn", "Lnet/minecraft/world/entity/SpawnGroupData;", "Lnet/minecraft/world/level/ServerLevelAccessor;", "difficulty", "Lnet/minecraft/world/DifficultyInstance;", "spawnType", "Lnet/minecraft/world/entity/MobSpawnType;", "spawnData", "event", "Lnet/thebrokenscript/brokencore/api/platform/CancelProxy;", "Companion", "thebrokenscript-common"})
@SourceDebugExtension(value={"SMAP\nFracturedRoamEntity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FracturedRoamEntity.kt\nnet/thebrokenscript/entity/fractured/FracturedRoamEntity\n+ 2 BaseMonster.kt\nnet/thebrokenscript/brokencore/api/entity/base/BaseMonster$Companion\n*L\n1#1,243:1\n72#2:244\n*S KotlinDebug\n*F\n+ 1 FracturedRoamEntity.kt\nnet/thebrokenscript/entity/fractured/FracturedRoamEntity\n*L\n-1#1:244\n*E\n"})
public final class FracturedRoamEntity
extends BaseFracturedEntity
implements FinalizedSpawn {
    @NotNull
    public static final Companion Companion;
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;
    @NotNull
    private final EntityDataDelegate timer$delegate;
    @NotNull
    private final EntityDataDelegate digCooldown$delegate;
    @NotNull
    private final EntityDataDelegate despawnTimer$delegate;
    @NotNull
    private static final EntityDataAccessor<Integer> SPAWN_TIMER;
    @NotNull
    private static final EntityDataAccessor<Integer> DIG_COOLDOWN;
    @NotNull
    private static final EntityDataAccessor<Integer> DESPAWN_TIMER;

    public FracturedRoamEntity(@NotNull EntityType<FracturedRoamEntity> type, @NotNull Level level) {
        Intrinsics.checkNotNullParameter(type, (String)"type");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        super(type, level);
        this.setPersistenceRequired();
        this.moveControl = new BaseFracturedEntity.RoamMoveControl(this);
        this.setNoAi(true);
        this.timer$delegate = this.entityData(SPAWN_TIMER);
        this.digCooldown$delegate = this.entityData(DIG_COOLDOWN);
        this.despawnTimer$delegate = this.entityData(DESPAWN_TIMER);
    }

    public final int getTimer() {
        Object object = this.timer$delegate.getValue((BaseMonster)this, $$delegatedProperties[0]);
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"getValue(...)");
        return ((Number)object).intValue();
    }

    public final void setTimer(int n) {
        this.timer$delegate.setValue((BaseMonster)this, $$delegatedProperties[0], (Object)n);
    }

    public final int getDigCooldown() {
        Object object = this.digCooldown$delegate.getValue((BaseMonster)this, $$delegatedProperties[1]);
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"getValue(...)");
        return ((Number)object).intValue();
    }

    public final void setDigCooldown(int n) {
        this.digCooldown$delegate.setValue((BaseMonster)this, $$delegatedProperties[1], (Object)n);
    }

    public final int getDespawnTimer() {
        Object object = this.despawnTimer$delegate.getValue((BaseMonster)this, $$delegatedProperties[2]);
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"getValue(...)");
        return ((Number)object).intValue();
    }

    public final void setDespawnTimer(int n) {
        this.despawnTimer$delegate.setValue((BaseMonster)this, $$delegatedProperties[2], (Object)n);
    }

    @Override
    public void addAdditionalSaveData(@NotNull CompoundTag compound) {
        Intrinsics.checkNotNullParameter((Object)compound, (String)"compound");
        super.addAdditionalSaveData(compound);
        compound.putInt("timer", this.getTimer());
        compound.putInt("dig_cooldown", this.getDigCooldown());
        compound.putInt("despawn_timer", this.getDespawnTimer());
    }

    @Override
    public void readAdditionalSaveData(@NotNull CompoundTag compound) {
        Intrinsics.checkNotNullParameter((Object)compound, (String)"compound");
        super.readAdditionalSaveData(compound);
        if (compound.contains("timer")) {
            this.setTimer(compound.getInt("timer"));
        }
        if (compound.contains("dig_cooldown")) {
            this.setDigCooldown(compound.getInt("dig_cooldown"));
        }
        if (compound.contains("despawn_timer")) {
            this.setDespawnTimer(compound.getInt("despawn_timer"));
        }
    }

    @Override
    protected void defineSynchedData(@NotNull SynchedEntityData.Builder builder) {
        Intrinsics.checkNotNullParameter((Object)builder, (String)"builder");
        super.defineSynchedData(builder);
        builder.define(SPAWN_TIMER, (Object)149);
        builder.define(DIG_COOLDOWN, (Object)0);
        builder.define(DESPAWN_TIMER, (Object)RangesKt.random((IntRange)new IntRange(18000, 24000), (Random)((Random)Random.Default)));
    }

    protected void registerGoals() {
        super.registerGoals();
        this.targetSelector.addGoal(1, (Goal)new NearestAttackableTargetGoal((Mob)this, Player.class, false, false));
        this.goalSelector.addGoal(1, (Goal)new FracturedRoamGoUnDerGroundGoal(this));
        this.goalSelector.addGoal(2, (Goal)new RandomStrollGoal(this){
            private int stuckTicks;
            private Vec3 lastPos;
            final /* synthetic */ FracturedRoamEntity this$0;
            {
                this.this$0 = $receiver;
                super((PathfinderMob)$receiver, 0.6, 45);
                Vec3 vec3 = Vec3.ZERO;
                Intrinsics.checkNotNullExpressionValue((Object)vec3, (String)"ZERO");
                this.lastPos = vec3;
            }

            protected Vec3 getPosition() {
                return DefaultRandomPos.getPos((PathfinderMob)this.mob, (int)100, (int)7);
            }

            private final boolean hasSupportNear(Vec3 pos, int checkDepth) {
                BlockPos base = BlockPos.containing((Position)((Position)pos));
                int dy = 1;
                if (dy <= checkDepth) {
                    while (true) {
                        if (!this.mob.level().getBlockState(base.below(dy)).isAir()) {
                            return true;
                        }
                        if (dy == checkDepth) break;
                        ++dy;
                    }
                }
                return false;
            }

            static /* synthetic */ boolean hasSupportNear$default(registerGoals.1 var0, Vec3 vec3, int n, int n2, Object object) {
                if ((n2 & 2) != 0) {
                    n = 10;
                }
                return var0.hasSupportNear(vec3, n);
            }

            private final boolean hasSupportAhead(double lookaheadDist) {
                double dz;
                double dx = this.wantedX - this.mob.getX();
                double dist = Math.sqrt(dx * dx + (dz = this.wantedZ - this.mob.getZ()) * dz);
                if (dist < 0.001) {
                    return true;
                }
                double nx = dx / dist;
                double nz = dz / dist;
                double checkDist = Math.min(lookaheadDist, dist);
                Vec3 checkPos = new Vec3(this.mob.getX() + nx * checkDist, this.mob.getY(), this.mob.getZ() + nz * checkDist);
                return registerGoals.1.hasSupportNear$default(this, checkPos, 0, 2, null);
            }

            static /* synthetic */ boolean hasSupportAhead$default(registerGoals.1 var0, double d, int n, Object object) {
                if ((n & 1) != 0) {
                    d = 8.0;
                }
                return var0.hasSupportAhead(d);
            }

            public void start() {
                block0: {
                    this.stuckTicks = 0;
                    Vec3 vec3 = this.mob.position();
                    Intrinsics.checkNotNullExpressionValue((Object)vec3, (String)"position(...)");
                    this.lastPos = vec3;
                    MoveControl moveControl = this.mob.getMoveControl();
                    BaseFracturedEntity.RoamMoveControl roamMoveControl = moveControl instanceof BaseFracturedEntity.RoamMoveControl ? (BaseFracturedEntity.RoamMoveControl)moveControl : null;
                    if (roamMoveControl == null) break block0;
                    roamMoveControl.setWantedPosition(this.wantedX, this.wantedY, this.wantedZ, this.speedModifier);
                }
            }

            public void tick() {
                if (!registerGoals.1.hasSupportAhead$default(this, 0.0, 1, null)) {
                    MoveControl moveControl = this.mob.getMoveControl();
                    BaseFracturedEntity.RoamMoveControl roamMoveControl = moveControl instanceof BaseFracturedEntity.RoamMoveControl ? (BaseFracturedEntity.RoamMoveControl)moveControl : null;
                    if (roamMoveControl != null) {
                        roamMoveControl.changeOperation(MoveControl.Operation.WAIT);
                    }
                    this.stuckTicks = 21;
                    return;
                }
                MoveControl moveControl = this.mob.getMoveControl();
                BaseFracturedEntity.RoamMoveControl roamMoveControl = moveControl instanceof BaseFracturedEntity.RoamMoveControl ? (BaseFracturedEntity.RoamMoveControl)moveControl : null;
                if (roamMoveControl != null) {
                    roamMoveControl.setWantedPosition(this.wantedX, this.wantedY, this.wantedZ, this.speedModifier);
                }
                Vec3 current = this.mob.position();
                if (current.distanceToSqr(this.lastPos) < 0.0025) {
                    int n = this.stuckTicks;
                    this.stuckTicks = n + 1;
                } else {
                    this.stuckTicks = 0;
                    Intrinsics.checkNotNull((Object)current);
                    this.lastPos = current;
                }
            }

            public boolean canUse() {
                if (!super.canUse()) {
                    return false;
                }
                if (this.this$0.getCurrentState() != BaseFracturedEntity.JimmyStates.NORMAL) {
                    return false;
                }
                return registerGoals.1.hasSupportNear$default(this, new Vec3(this.wantedX, this.wantedY, this.wantedZ), 0, 2, null);
            }

            public boolean canContinueToUse() {
                double dz;
                if (this.stuckTicks > 20) {
                    return false;
                }
                double dx = this.wantedX - this.mob.getX();
                return dx * dx + (dz = this.wantedZ - this.mob.getZ()) * dz > 1.0 && !this.mob.hasControllingPassenger() && this.this$0.getCurrentState() == BaseFracturedEntity.JimmyStates.NORMAL;
            }

            public void stop() {
                MoveControl moveControl = this.mob.getMoveControl();
                BaseFracturedEntity.RoamMoveControl roamMoveControl = moveControl instanceof BaseFracturedEntity.RoamMoveControl ? (BaseFracturedEntity.RoamMoveControl)moveControl : null;
                if (roamMoveControl != null) {
                    moveControl = roamMoveControl;
                    FracturedRoamEntity fracturedRoamEntity = this.this$0;
                    MoveControl it = moveControl;
                    boolean bl = false;
                    it.setWantedPosition(fracturedRoamEntity.getPos().x, fracturedRoamEntity.getPos().y, fracturedRoamEntity.getPos().z, this.speedModifier);
                    it.changeOperation(MoveControl.Operation.WAIT);
                }
                this.stuckTicks = 0;
                super.stop();
            }
        });
        this.goalSelector.addGoal(3, (Goal)new RandomLookAroundGoal(this){
            final /* synthetic */ FracturedRoamEntity this$0;
            {
                this.this$0 = $receiver;
                super((Mob)$receiver);
            }

            public boolean canUse() {
                return super.canUse() && this.this$0.getCurrentState() == BaseFracturedEntity.JimmyStates.NORMAL;
            }

            public boolean canContinueToUse() {
                return super.canContinueToUse() && this.this$0.getCurrentState() == BaseFracturedEntity.JimmyStates.NORMAL;
            }
        });
    }

    @Override
    public boolean hurt(@NotNull DamageSource source, float amount) {
        Intrinsics.checkNotNullParameter((Object)source, (String)"source");
        if (this.getArrowCount() > 0) {
            this.setArrowCount(this.getArrowCount() - 1);
        }
        if (source.is(DamageTypeTags.IS_FALL)) {
            return false;
        }
        if (source.is(DamageTypes.IN_WALL)) {
            return false;
        }
        super.hurt(source, amount);
        return false;
    }

    @Override
    public void tick() {
        int n;
        super.tick();
        if (this.getDigCooldown() > 0 && this.getCurrentState() == BaseFracturedEntity.JimmyStates.NORMAL) {
            n = this.getDigCooldown();
            this.setDigCooldown(n + -1);
        }
        if (this.getDespawnTimer() > 0) {
            n = this.getDespawnTimer();
            this.setDespawnTimer(n + -1);
        } else if (this.getCurrentState() == BaseFracturedEntity.JimmyStates.NORMAL) {
            this.setCurrentState(BaseFracturedEntity.JimmyStates.DESPAWNING);
        }
        SideUtil.clientSide((Entity)((Entity)this), () -> FracturedRoamEntity.tick$lambda$0(this));
        SideUtil.serverSide((Entity)((Entity)this), () -> FracturedRoamEntity.tick$lambda$1(this));
    }

    @Override
    @Nullable
    public SpawnGroupData onFinalizeSpawn(@NotNull ServerLevelAccessor level, @NotNull DifficultyInstance difficulty, @NotNull MobSpawnType spawnType, @Nullable SpawnGroupData spawnData, @NotNull CancelProxy event) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)difficulty, (String)"difficulty");
        Intrinsics.checkNotNullParameter((Object)spawnType, (String)"spawnType");
        Intrinsics.checkNotNullParameter((Object)event, (String)"event");
        this.setCurrentState(BaseFracturedEntity.JimmyStates.RISING);
        return null;
    }

    private static final Object tick$lambda$0(FracturedRoamEntity this$0) {
        if (!ClientVariables.INSTANCE.has(4L)) {
            LocalPlayer localPlayer = ClientDSLKt.getMC().player;
            if (localPlayer == null) {
                return false;
            }
            LocalPlayer player = localPlayer;
            if (PlayerExt.INSTANCE.isEntityInFovCone((Player)player, (Entity)this$0, Double.valueOf(((Number)ClientDSLKt.getMC().options.fov().get()).intValue()))) {
                ClientVariables.INSTANCE.set(4L);
            }
        }
        return Unit.INSTANCE;
    }

    private static final Unit tick$lambda$1(FracturedRoamEntity this$0) {
        if (this$0.getTimer() > 0) {
            int n = this$0.getTimer();
            this$0.setTimer(n + -1);
            if (this$0.getTimer() == 0) {
                this$0.setNoAi(false);
            }
        }
        return Unit.INSTANCE;
    }

    static {
        BaseMonster.Companion companion = new BaseMonster.Companion[]{Reflection.mutableProperty1((MutablePropertyReference1)((MutablePropertyReference1)new MutablePropertyReference1Impl(FracturedRoamEntity.class, "timer", "getTimer()I", 0))), Reflection.mutableProperty1((MutablePropertyReference1)((MutablePropertyReference1)new MutablePropertyReference1Impl(FracturedRoamEntity.class, "digCooldown", "getDigCooldown()I", 0))), Reflection.mutableProperty1((MutablePropertyReference1)((MutablePropertyReference1)new MutablePropertyReference1Impl(FracturedRoamEntity.class, "despawnTimer", "getDespawnTimer()I", 0)))};
        $$delegatedProperties = companion;
        Companion = new Companion(null);
        companion = BaseMonster.Companion;
        BaseMonster.BMC bMC = Companion;
        EntityDataSerializer entityDataSerializer = EntityDataSerializers.INT;
        Intrinsics.checkNotNullExpressionValue((Object)entityDataSerializer, (String)"INT");
        EntityDataSerializer ser$iv = entityDataSerializer;
        boolean $i$f$data = false;
        EntityDataAccessor entityDataAccessor = SynchedEntityData.defineId(FracturedRoamEntity.class, (EntityDataSerializer)ser$iv);
        Intrinsics.checkNotNullExpressionValue((Object)entityDataAccessor, (String)"defineId(...)");
        SPAWN_TIMER = entityDataAccessor;
        BaseMonster.Companion this_$iv = BaseMonster.Companion;
        BaseMonster.BMC bMC2 = Companion;
        EntityDataSerializer entityDataSerializer2 = EntityDataSerializers.INT;
        Intrinsics.checkNotNullExpressionValue((Object)entityDataSerializer2, (String)"INT");
        ser$iv = entityDataSerializer2;
        $i$f$data = false;
        EntityDataAccessor entityDataAccessor2 = SynchedEntityData.defineId(FracturedRoamEntity.class, (EntityDataSerializer)ser$iv);
        Intrinsics.checkNotNullExpressionValue((Object)entityDataAccessor2, (String)"defineId(...)");
        DIG_COOLDOWN = entityDataAccessor2;
        this_$iv = BaseMonster.Companion;
        bMC2 = Companion;
        EntityDataSerializer entityDataSerializer3 = EntityDataSerializers.INT;
        Intrinsics.checkNotNullExpressionValue((Object)entityDataSerializer3, (String)"INT");
        ser$iv = entityDataSerializer3;
        $i$f$data = false;
        EntityDataAccessor entityDataAccessor3 = SynchedEntityData.defineId(FracturedRoamEntity.class, (EntityDataSerializer)ser$iv);
        Intrinsics.checkNotNullExpressionValue((Object)entityDataAccessor3, (String)"defineId(...)");
        DESPAWN_TIMER = entityDataAccessor3;
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0003\u0010\u0004R\u001c\u0010\u0005\u001a\u0010\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00070\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u0010\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00070\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u0010\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00070\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2={"Lnet/thebrokenscript/entity/fractured/FracturedRoamEntity$Companion;", "Lnet/thebrokenscript/brokencore/api/entity/base/BaseMonster$BMC;", "Lnet/thebrokenscript/entity/fractured/FracturedRoamEntity;", "<init>", "()V", "SPAWN_TIMER", "Lnet/minecraft/network/syncher/EntityDataAccessor;", "", "kotlin.jvm.PlatformType", "DIG_COOLDOWN", "DESPAWN_TIMER", "thebrokenscript-common"})
    public static final class Companion
    implements BaseMonster.BMC<FracturedRoamEntity> {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

