/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.random.Random
 *  net.minecraft.client.player.LocalPlayer
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Holder
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.server.level.ServerPlayer
 *  net.minecraft.sounds.SoundEvent
 *  net.minecraft.sounds.SoundEvents
 *  net.minecraft.world.DifficultyInstance
 *  net.minecraft.world.damagesource.DamageSource
 *  net.minecraft.world.damagesource.DamageTypes
 *  net.minecraft.world.effect.MobEffectInstance
 *  net.minecraft.world.effect.MobEffects
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.Mob
 *  net.minecraft.world.entity.MobSpawnType
 *  net.minecraft.world.entity.PathfinderMob
 *  net.minecraft.world.entity.SpawnGroupData
 *  net.minecraft.world.entity.ai.attributes.AttributeSupplier$Builder
 *  net.minecraft.world.entity.ai.attributes.Attributes
 *  net.minecraft.world.entity.ai.goal.FloatGoal
 *  net.minecraft.world.entity.ai.goal.Goal
 *  net.minecraft.world.entity.ai.goal.MeleeAttackGoal
 *  net.minecraft.world.entity.ai.goal.RandomLookAroundGoal
 *  net.minecraft.world.entity.ai.goal.RandomStrollGoal
 *  net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal
 *  net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal
 *  net.minecraft.world.entity.animal.IronGolem
 *  net.minecraft.world.entity.monster.Monster
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.level.ServerLevelAccessor
 *  net.minecraft.world.phys.Vec3
 *  net.minecraft.world.phys.shapes.VoxelShape
 *  net.thebrokenscript.brokencore.api.dsl.ClientDSLKt
 *  net.thebrokenscript.brokencore.api.dsl.EntityFinder
 *  net.thebrokenscript.brokencore.api.dsl.EntityUtil
 *  net.thebrokenscript.brokencore.api.dsl.ParticleUtil
 *  net.thebrokenscript.brokencore.api.dsl.PlayerUtil
 *  net.thebrokenscript.brokencore.api.dsl.SideUtil
 *  net.thebrokenscript.brokencore.api.dsl.SoundUtil
 *  net.thebrokenscript.brokencore.api.entity.FinalizedSpawn
 *  net.thebrokenscript.brokencore.api.entity.base.BaseMonster
 *  net.thebrokenscript.brokencore.api.ext.EntityTypeExt
 *  net.thebrokenscript.brokencore.api.ext.VoxelShapeExtKt
 *  net.thebrokenscript.brokencore.api.learner.rooms.AbstractRoom
 *  net.thebrokenscript.brokencore.api.platform.CancelProxy
 *  net.thebrokenscript.brokencore.api.util.math.Vectors
 *  net.thebrokenscript.brokencore.api.world.TimeOfDay
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.entity.nullent;

import java.util.Collection;
import java.util.function.Supplier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.thebrokenscript.api.ext.PlayerExt;
import net.thebrokenscript.brokencore.api.dsl.ClientDSLKt;
import net.thebrokenscript.brokencore.api.dsl.EntityFinder;
import net.thebrokenscript.brokencore.api.dsl.EntityUtil;
import net.thebrokenscript.brokencore.api.dsl.ParticleUtil;
import net.thebrokenscript.brokencore.api.dsl.PlayerUtil;
import net.thebrokenscript.brokencore.api.dsl.SideUtil;
import net.thebrokenscript.brokencore.api.dsl.SoundUtil;
import net.thebrokenscript.brokencore.api.entity.FinalizedSpawn;
import net.thebrokenscript.brokencore.api.entity.base.BaseMonster;
import net.thebrokenscript.brokencore.api.ext.EntityTypeExt;
import net.thebrokenscript.brokencore.api.ext.VoxelShapeExtKt;
import net.thebrokenscript.brokencore.api.learner.rooms.AbstractRoom;
import net.thebrokenscript.brokencore.api.platform.CancelProxy;
import net.thebrokenscript.brokencore.api.util.math.Vectors;
import net.thebrokenscript.brokencore.api.world.TimeOfDay;
import net.thebrokenscript.client.data.ClientVariables;
import net.thebrokenscript.data.PlayerVariables;
import net.thebrokenscript.registry.TBSDimensions;
import net.thebrokenscript.registry.TBSEntities;
import net.thebrokenscript.registry.TBSParticleTypes;
import net.thebrokenscript.registry.TBSSounds;
import net.thebrokenscript.util.RepTier;
import net.thebrokenscript.util.RepUtilKt;
import net.thebrokenscript.util.ReputationEnum;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 52\u00020\u00012\u00020\u0002:\u00015B\u001d\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00000\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0004\b\u0007\u0010\bJ\b\u0010\t\u001a\u00020\nH\u0014J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\fH\u0016J\u0018\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0018\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0010\u0010%\u001a\u00020\n2\u0006\u0010&\u001a\u00020'H\u0016J\u0010\u0010(\u001a\u00020\n2\u0006\u0010&\u001a\u00020'H\u0016J4\u0010)\u001a\u0004\u0018\u00010*2\u0006\u0010\u0005\u001a\u00020+2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u00132\b\u0010/\u001a\u0004\u0018\u00010*2\u0006\u00100\u001a\u000201H\u0016J\b\u00102\u001a\u00020\nH\u0016J\b\u00103\u001a\u00020\nH\u0016J\b\u00104\u001a\u00020\fH\u0016R\u001a\u0010\u0019\u001a\u00020\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR$\u0010 \u001a\u00020\u001f2\u0006\u0010\u001e\u001a\u00020\u001f8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$\u00a8\u00066"}, d2={"Lnet/thebrokenscript/entity/nullent/NullWatchingEntity;", "Lnet/thebrokenscript/brokencore/api/entity/base/BaseMonster;", "Lnet/thebrokenscript/brokencore/api/entity/FinalizedSpawn;", "type", "Lnet/minecraft/world/entity/EntityType;", "level", "Lnet/minecraft/world/level/Level;", "<init>", "(Lnet/minecraft/world/entity/EntityType;Lnet/minecraft/world/level/Level;)V", "registerGoals", "", "removeWhenFarAway", "", "distanceToClosestPlayer", "", "fireImmune", "checkSpawnRules", "Lnet/minecraft/world/level/LevelAccessor;", "reason", "Lnet/minecraft/world/entity/MobSpawnType;", "hurt", "source", "Lnet/minecraft/world/damagesource/DamageSource;", "amount", "", "jumpscare", "getJumpscare", "()Z", "setJumpscare", "(Z)V", "value", "", "timer", "getTimer", "()I", "setTimer", "(I)V", "addAdditionalSaveData", "compound", "Lnet/minecraft/nbt/CompoundTag;", "readAdditionalSaveData", "onFinalizeSpawn", "Lnet/minecraft/world/entity/SpawnGroupData;", "Lnet/minecraft/world/level/ServerLevelAccessor;", "difficulty", "Lnet/minecraft/world/DifficultyInstance;", "spawnType", "spawnData", "event", "Lnet/thebrokenscript/brokencore/api/platform/CancelProxy;", "baseTick", "tick", "isPushedByFluid", "Companion", "thebrokenscript-common"})
public final class NullWatchingEntity
extends BaseMonster
implements FinalizedSpawn {
    @NotNull
    public static final Companion Companion = new Companion(null);
    private boolean jumpscare;
    @NotNull
    private static final String NATURAL_DESPAWN = "despawn_timer";

    public NullWatchingEntity(@NotNull EntityType<NullWatchingEntity> type, @NotNull Level level) {
        Intrinsics.checkNotNullParameter(type, (String)"type");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        super(type, level);
        this.xpReward = 10;
        this.setNoAi(false);
        this.setPersistenceRequired();
    }

    protected void registerGoals() {
        super.registerGoals();
        this.targetSelector.addGoal(1, (Goal)new NearestAttackableTargetGoal((Mob)this, Player.class, false, false));
        this.goalSelector.addGoal(2, (Goal)new MeleeAttackGoal((PathfinderMob)this, 1.2, false));
        this.goalSelector.addGoal(3, (Goal)new RandomStrollGoal((PathfinderMob)this, 1.0));
        this.targetSelector.addGoal(4, (Goal)new HurtByTargetGoal((PathfinderMob)this, new Class[0]));
        this.goalSelector.addGoal(5, (Goal)new RandomLookAroundGoal((Mob)this));
        this.goalSelector.addGoal(6, (Goal)new FloatGoal((Mob)this));
    }

    public boolean removeWhenFarAway(double distanceToClosestPlayer) {
        return false;
    }

    public boolean fireImmune() {
        return true;
    }

    public boolean checkSpawnRules(@NotNull LevelAccessor level, @NotNull MobSpawnType reason) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)reason, (String)"reason");
        return true;
    }

    public boolean hurt(@NotNull DamageSource source, float amount) {
        Intrinsics.checkNotNullParameter((Object)source, (String)"source");
        return Intrinsics.areEqual((Object)source.type(), (Object)DamageTypes.GENERIC_KILL) || Intrinsics.areEqual((Object)source.type(), (Object)DamageTypes.FELL_OUT_OF_WORLD);
    }

    public final boolean getJumpscare() {
        return this.jumpscare;
    }

    public final void setJumpscare(boolean bl) {
        this.jumpscare = bl;
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
    }

    public void readAdditionalSaveData(@NotNull CompoundTag compound) {
        Intrinsics.checkNotNullParameter((Object)compound, (String)"compound");
        super.readAdditionalSaveData(compound);
        compound.getInt(NATURAL_DESPAWN);
    }

    @Nullable
    public SpawnGroupData onFinalizeSpawn(@NotNull ServerLevelAccessor level, @NotNull DifficultyInstance difficulty, @NotNull MobSpawnType spawnType, @Nullable SpawnGroupData spawnData, @NotNull CancelProxy event) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)difficulty, (String)"difficulty");
        Intrinsics.checkNotNullParameter((Object)spawnType, (String)"spawnType");
        Intrinsics.checkNotNullParameter((Object)event, (String)"event");
        LevelAccessor levelAccessor = (LevelAccessor)level;
        Vec3 vec3 = new Vec3(this.getX(), this.getY(), this.getZ());
        Object object = SoundEvents.AMBIENT_CAVE.value();
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"value(...)");
        SoundUtil.playSound$default((LevelAccessor)levelAccessor, (Vec3)vec3, (SoundEvent)((SoundEvent)object), (float)10.0f, (float)0.0f, null, (int)16, null);
        this.setTimer(8000);
        return null;
    }

    public void baseTick() {
        Level level;
        super.baseTick();
        int n = this.getTimer();
        this.setTimer(n + -1);
        if (this.getTimer() == 0) {
            this.discard();
        }
        if (!((level = this.level()) instanceof ServerLevel)) {
            return;
        }
        ServerPlayer player = EntityFinder.findClosestPlayerInRange((ServerLevel)((ServerLevel)level), (Vec3)new Vec3(this.getX(), this.getY(), this.getZ()), (Number)400.0);
        if (player != null) {
            this.lookControl.setLookAt((Entity)player);
        }
        IronGolem ironGolem = (IronGolem)EntityFinder.findClosestEntityInRange((LevelAccessor)((LevelAccessor)level), IronGolem.class, (Vec3)this.getPos(), (Number)10);
        if (ironGolem != null) {
            ironGolem.hurt(((ServerLevel)level).damageSources().generic(), 55.0f);
        }
        if (player != null && EntityUtil.isWithin((Entity)((Entity)player), (Vec3)this.getPos(), (Number)30) && PlayerExt.isEntityInFovCone$default(PlayerExt.INSTANCE, (Player)player, (Entity)this, null, 2, null)) {
            if (((ServerLevel)level).random.nextBoolean() && !this.jumpscare) {
                if ((double)((ServerLevel)level).random.nextFloat() < 0.7) {
                    TimeOfDay.DAY.setFake();
                    this.jumpscare = true;
                }
            } else if (this.random.nextBoolean() && !this.jumpscare) {
                Vec3 lookDir = player.getLookAngle().normalize();
                Vec3 summonPos = player.position().add(lookDir.scale(2.0));
                Vec3 summonPosAbove = summonPos.add(0.0, 1.0, 0.0);
                EntityType entityType = (EntityType)TBSEntities.NULL_SCARE.get();
                LevelAccessor levelAccessor = (LevelAccessor)level;
                Intrinsics.checkNotNull((Object)summonPosAbove);
                EntityTypeExt.trySummon((EntityType)entityType, (LevelAccessor)levelAccessor, (Vec3)summonPosAbove);
                this.jumpscare = true;
            } else {
                this.jumpscare = true;
            }
        }
        if (player != null && EntityUtil.isWithin((Entity)((Entity)player), (Vec3)this.getPos(), (Number)20) && PlayerExt.isEntityInFovCone$default(PlayerExt.INSTANCE, (Player)player, (Entity)this, null, 2, null)) {
            int angerType = this.random.nextInt(1, 10);
            if (!this.hasLineOfSight((Entity)player)) {
                this.discard();
            } else {
                RepUtilKt.applyRep((Player)player, RepTier.LOSS_SMALL);
            }
            switch (angerType) {
                case 1: {
                    this.discard();
                    player.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 80, 1, false, false));
                    PlayerUtil.sendSound$default((ServerPlayer)player, (Holder)((Holder)TBSSounds.NULL_FLEE), (float)10.0f, (float)0.0f, null, null, (long)0L, (int)60, null);
                    break;
                }
                case 2: {
                    if (PlayerExt.INSTANCE.getReputation(player) != ReputationEnum.GOOD) {
                        this.discard();
                        EntityUtil.applyRandomRotation((Entity)EntityTypeExt.trySummon((EntityType)((EntityType)TBSEntities.NULL_CHASE.get()), (LevelAccessor)((LevelAccessor)level), (Vec3)this.getPos()));
                        player.addEffect(new MobEffectInstance(MobEffects.DARKNESS, 50, 1, false, false));
                        PlayerVariables vars = PlayerExt.INSTANCE.getVars((Player)player);
                        vars.setAberrationEnabled(true);
                        vars.setAberrationTimer(2400L);
                        vars.syncTo((Player)player);
                        break;
                    }
                    this.discard();
                    break;
                }
                case 3: {
                    this.discard();
                    if (PlayerExt.INSTANCE.getReputation(player) == ReputationEnum.BAD) {
                        EntityUtil.applyRandomRotation((Entity)EntityTypeExt.trySummon((EntityType)((EntityType)TBSEntities.NULL_UNBEATABLE_BOSSFIGHT.get()), (LevelAccessor)((LevelAccessor)level), (Vec3)this.getPos()));
                        break;
                    }
                    EntityUtil.applyRandomRotation((Entity)EntityTypeExt.trySummon((EntityType)((EntityType)TBSEntities.NULL_CHASE.get()), (LevelAccessor)((LevelAccessor)level), (Vec3)this.getPos()));
                    break;
                }
                case 4: {
                    this.discard();
                    ParticleUtil.sendParticles((ServerLevel)((ServerLevel)level), (Supplier)((Supplier)TBSParticleTypes.NULL_PARTICLE), (Vec3)this.getPos(), (Number)50, (Vec3)Vectors.INSTANCE.all((Number)3), (Number)0);
                    break;
                }
                case 5: {
                    this.discard();
                    ParticleUtil.sendParticles((ServerLevel)((ServerLevel)level), (Supplier)((Supplier)TBSParticleTypes.EYES), (Vec3)this.getPos(), (Number)50, (Vec3)Vectors.INSTANCE.all((Number)3), (Number)0);
                    break;
                }
                case 6: {
                    this.discard();
                    ParticleUtil.sendParticles((ServerLevel)((ServerLevel)level), (Supplier)((Supplier)TBSParticleTypes.NULL_PARTICLE), (Vec3)this.getPos(), (Number)50, (Vec3)Vectors.INSTANCE.all((Number)3), (Number)0);
                    PlayerExt.INSTANCE.updateVars((Player)player, (Function1<? super PlayerVariables, Unit>)((Function1)NullWatchingEntity::baseTick$lambda$0));
                    PlayerUtil.sendTo((Player)((Player)player), TBSDimensions.NULL_TORTURE);
                    break;
                }
                case 7: {
                    if ((double)this.random.nextFloat() < 0.35) {
                        this.discard();
                        ParticleUtil.sendParticles((ServerLevel)((ServerLevel)level), (Supplier)((Supplier)TBSParticleTypes.NULL_PARTICLE), (Vec3)this.getPos(), (Number)50, (Vec3)Vectors.INSTANCE.all((Number)3), (Number)0);
                        PlayerExt.INSTANCE.updateVars((Player)player, (Function1<? super PlayerVariables, Unit>)((Function1)NullWatchingEntity::baseTick$lambda$1));
                        PlayerUtil.sendTo((Player)((Player)player), TBSDimensions.CORRUPTED_MOON);
                        break;
                    }
                    this.discard();
                    break;
                }
                case 8: {
                    BlockPos blockPos;
                    ParticleUtil.sendParticles((ServerLevel)((ServerLevel)level), (Supplier)((Supplier)TBSParticleTypes.NULL_PARTICLE), (Vec3)this.getPos(), (Number)50, (Vec3)Vectors.INSTANCE.all((Number)3), (Number)0);
                    VoxelShape voxelShape = ((AbstractRoom)CollectionsKt.random((Collection)PlayerExt.INSTANCE.getBase((Player)player).getRooms(), (Random)((Random)Random.Default))).getShape();
                    Object object = blockPos = voxelShape != null ? VoxelShapeExtKt.randomBottomBlockPos((VoxelShape)voxelShape) : null;
                    if (blockPos == null) break;
                    player.teleportTo(blockPos.getCenter().x, blockPos.getCenter().y + 1.0, blockPos.getCenter().z);
                    break;
                }
                case 9: {
                    BlockPos blockPos;
                    this.discard();
                    ParticleUtil.sendParticles((ServerLevel)((ServerLevel)level), (Supplier)((Supplier)TBSParticleTypes.NULL_PARTICLE), (Vec3)this.getPos(), (Number)50, (Vec3)Vectors.INSTANCE.all((Number)3), (Number)0);
                    VoxelShape voxelShape = ((AbstractRoom)CollectionsKt.random((Collection)PlayerExt.INSTANCE.getBase((Player)player).getRooms(), (Random)((Random)Random.Default))).getShape();
                    Object object = blockPos = voxelShape != null ? VoxelShapeExtKt.randomBottomBlockPos((VoxelShape)voxelShape) : null;
                    if (blockPos == null) break;
                    player.teleportTo(blockPos.getCenter().x, blockPos.getCenter().y + 1.0, blockPos.getCenter().z);
                    break;
                }
                case 10: {
                    this.discard();
                    EntityType entityType = EntityType.LIGHTNING_BOLT;
                    Intrinsics.checkNotNullExpressionValue((Object)entityType, (String)"LIGHTNING_BOLT");
                    EntityTypeExt.trySummon((EntityType)entityType, (LevelAccessor)((LevelAccessor)level), (Vec3)this.getPos());
                    break;
                }
                default: {
                    this.discard();
                }
            }
        }
    }

    public void tick() {
        super.tick();
        SideUtil.clientSide((Entity)((Entity)this), () -> NullWatchingEntity.tick$lambda$0(this));
    }

    public boolean isPushedByFluid() {
        return false;
    }

    private static final Unit baseTick$lambda$0(PlayerVariables $this$updateVars) {
        Intrinsics.checkNotNullParameter((Object)$this$updateVars, (String)"$this$updateVars");
        $this$updateVars.setFixPos(true);
        return Unit.INSTANCE;
    }

    private static final Unit baseTick$lambda$1(PlayerVariables $this$updateVars) {
        Intrinsics.checkNotNullParameter((Object)$this$updateVars, (String)"$this$updateVars");
        $this$updateVars.setFixPos(true);
        return Unit.INSTANCE;
    }

    private static final Object tick$lambda$0(NullWatchingEntity this$0) {
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

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2={"Lnet/thebrokenscript/entity/nullent/NullWatchingEntity$Companion;", "", "<init>", "()V", "createAttributes", "Lnet/minecraft/world/entity/ai/attributes/AttributeSupplier$Builder;", "NATURAL_DESPAWN", "", "thebrokenscript-common"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final AttributeSupplier.Builder createAttributes() {
            AttributeSupplier.Builder builder = Monster.createMobAttributes();
            builder = builder.add(Attributes.MOVEMENT_SPEED, 0.0);
            builder = builder.add(Attributes.MAX_HEALTH, 910.0);
            builder = builder.add(Attributes.ARMOR, 10.0);
            builder = builder.add(Attributes.ATTACK_DAMAGE, 63.0);
            builder = builder.add(Attributes.FOLLOW_RANGE, 916.0);
            builder = builder.add(Attributes.KNOCKBACK_RESISTANCE, 10.0);
            AttributeSupplier.Builder builder2 = builder = builder.add(Attributes.ATTACK_KNOCKBACK, 10.0);
            Intrinsics.checkNotNull((Object)builder2);
            return builder2;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

