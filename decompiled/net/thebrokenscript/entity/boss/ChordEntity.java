/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.NoWhenBranchMatchedException
 *  kotlin.Unit
 *  kotlin.enums.EnumEntries
 *  kotlin.enums.EnumEntriesKt
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.MutablePropertyReference1
 *  kotlin.jvm.internal.MutablePropertyReference1Impl
 *  kotlin.jvm.internal.Reflection
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.jvm.optionals.OptionalsKt
 *  kotlin.math.MathKt
 *  kotlin.random.Random
 *  kotlin.ranges.IntRange
 *  kotlin.ranges.RangesKt
 *  kotlin.reflect.KProperty
 *  net.minecraft.client.player.LocalPlayer
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.network.protocol.common.custom.CustomPacketPayload
 *  net.minecraft.network.syncher.EntityDataAccessor
 *  net.minecraft.network.syncher.EntityDataSerializer
 *  net.minecraft.network.syncher.EntityDataSerializers
 *  net.minecraft.network.syncher.SynchedEntityData
 *  net.minecraft.network.syncher.SynchedEntityData$Builder
 *  net.minecraft.server.level.ServerPlayer
 *  net.minecraft.sounds.SoundEvent
 *  net.minecraft.util.Mth
 *  net.minecraft.world.DifficultyInstance
 *  net.minecraft.world.damagesource.DamageSource
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.Entity$RemovalReason
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.Mob
 *  net.minecraft.world.entity.MobSpawnType
 *  net.minecraft.world.entity.SpawnGroupData
 *  net.minecraft.world.entity.ai.attributes.Attributes
 *  net.minecraft.world.entity.ai.control.MoveControl
 *  net.minecraft.world.entity.ai.control.MoveControl$Operation
 *  net.minecraft.world.entity.ai.goal.Goal
 *  net.minecraft.world.entity.ai.goal.Goal$Flag
 *  net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal
 *  net.minecraft.world.entity.ai.navigation.FlyingPathNavigation
 *  net.minecraft.world.entity.monster.RangedAttackMob
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.ServerLevelAccessor
 *  net.minecraft.world.phys.AABB
 *  net.minecraft.world.phys.Vec3
 *  net.thebrokenscript.brokencore.api.dsl.ClientDSLKt
 *  net.thebrokenscript.brokencore.api.dsl.EntityDataDelegate
 *  net.thebrokenscript.brokencore.api.dsl.GeckoUtil
 *  net.thebrokenscript.brokencore.api.dsl.PositionUtil
 *  net.thebrokenscript.brokencore.api.dsl.SideUtil
 *  net.thebrokenscript.brokencore.api.entity.FinalizedSpawn
 *  net.thebrokenscript.brokencore.api.entity.base.BaseMonster
 *  net.thebrokenscript.brokencore.api.entity.base.UwuableMonster
 *  net.thebrokenscript.brokencore.api.network.PacketSender
 *  net.thebrokenscript.brokencore.api.platform.CancelProxy
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  org.joml.Vector3f
 *  org.joml.Vector3fc
 *  software.bernie.geckolib.animatable.GeoAnimatable
 *  software.bernie.geckolib.animation.AnimatableManager$ControllerRegistrar
 *  software.bernie.geckolib.animation.Animation
 *  software.bernie.geckolib.animation.AnimationController
 *  software.bernie.geckolib.animation.AnimationProcessor$QueuedAnimation
 *  software.bernie.geckolib.animation.AnimationState
 *  software.bernie.geckolib.animation.PlayState
 *  software.bernie.geckolib.animation.RawAnimation
 *  software.bernie.geckolib.animation.keyframe.event.CustomInstructionKeyframeEvent
 */
package net.thebrokenscript.entity.boss;

import java.util.EnumSet;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.optionals.OptionalsKt;
import kotlin.math.MathKt;
import kotlin.random.Random;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KProperty;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializer;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.Mth;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.navigation.FlyingPathNavigation;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.api.ext.PlayerExt;
import net.thebrokenscript.brokencore.api.dsl.ClientDSLKt;
import net.thebrokenscript.brokencore.api.dsl.EntityDataDelegate;
import net.thebrokenscript.brokencore.api.dsl.GeckoUtil;
import net.thebrokenscript.brokencore.api.dsl.PositionUtil;
import net.thebrokenscript.brokencore.api.dsl.SideUtil;
import net.thebrokenscript.brokencore.api.entity.FinalizedSpawn;
import net.thebrokenscript.brokencore.api.entity.base.BaseMonster;
import net.thebrokenscript.brokencore.api.entity.base.UwuableMonster;
import net.thebrokenscript.brokencore.api.network.PacketSender;
import net.thebrokenscript.brokencore.api.platform.CancelProxy;
import net.thebrokenscript.client.data.ClientVariables;
import net.thebrokenscript.entity.boss.ChordProjectileEntity;
import net.thebrokenscript.registry.TBSDamageTypes;
import net.thebrokenscript.registry.TBSPackets;
import net.thebrokenscript.registry.TBSSounds;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector3f;
import org.joml.Vector3fc;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.animation.Animation;
import software.bernie.geckolib.animation.AnimationController;
import software.bernie.geckolib.animation.AnimationProcessor;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.animation.PlayState;
import software.bernie.geckolib.animation.RawAnimation;
import software.bernie.geckolib.animation.keyframe.event.CustomInstructionKeyframeEvent;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u00ae\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 q2\u00020\u00012\u00020\u00022\u00020\u0003:\u0005mnopqB\u001d\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00000\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\b\u00107\u001a\u000201H\u0016J\b\u00108\u001a\u000201H\u0016J\u0010\u00109\u001a\u0002012\u0006\u0010:\u001a\u00020;H\u0016J \u0010<\u001a\u0002012\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020>2\u0006\u0010@\u001a\u00020AH\u0016J\u0010\u0010B\u001a\u00020C2\u0006\u0010\u0006\u001a\u00020\u0007H\u0014J\b\u0010D\u001a\u00020EH\u0014J\u0010\u0010F\u001a\u00020E2\u0006\u0010G\u001a\u00020AH\u0016J\b\u0010H\u001a\u00020EH\u0014J\b\u0010I\u001a\u00020EH\u0016J\u0018\u0010J\u001a\u0002012\u0006\u0010@\u001a\u00020A2\u0006\u0010K\u001a\u00020>H\u0016J\b\u0010L\u001a\u00020\u000bH\u0016J\b\u0010M\u001a\u00020\u000bH\u0016J\u0010\u0010Q\u001a\u00020E2\u0006\u0010R\u001a\u00020SH\u0016J\u0018\u0010T\u001a\u00020E2\u0006\u0010U\u001a\u00020V2\u0006\u0010W\u001a\u00020>H\u0016J\u000e\u0010X\u001a\u00020E2\u0006\u0010U\u001a\u00020VJ\u000e\u0010Y\u001a\u00020E2\u0006\u0010U\u001a\u00020VJ\u0010\u0010Z\u001a\u00020E2\u0006\u0010[\u001a\u00020\\H\u0016J\u0010\u0010]\u001a\u00020E2\u0006\u0010[\u001a\u00020\\H\u0016J4\u0010^\u001a\u0004\u0018\u00010_2\u0006\u0010\u0006\u001a\u00020`2\u0006\u0010a\u001a\u00020b2\u0006\u0010c\u001a\u00020d2\b\u0010e\u001a\u0004\u0018\u00010_2\u0006\u0010f\u001a\u00020gH\u0016J\u0012\u0010h\u001a\u0004\u0018\u00010i2\u0006\u0010G\u001a\u00020AH\u0014J\u0010\u0010j\u001a\u00020E2\u0006\u0010k\u001a\u00020lH\u0014R+\u0010\u0004\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR7\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u0011\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R+\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\u0011\u001a\u0004\b\u001b\u0010\r\"\u0004\b\u001c\u0010\u000fR+\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\n\u001a\u00020\u001e8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b$\u0010\u0011\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001a\u0010%\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\r\"\u0004\b'\u0010\u000fR\u0014\u0010(\u001a\u00020\u000bX\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b)\u0010\rR\u001a\u0010*\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\r\"\u0004\b,\u0010\u000fR\u001a\u0010-\u001a\u00020\u001eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b.\u0010!\"\u0004\b/\u0010#R\u001a\u00100\u001a\u000201X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u000e\u00106\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010N\u001a\u000201X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bO\u00103\"\u0004\bP\u00105\u00a8\u0006r"}, d2={"Lnet/thebrokenscript/entity/boss/ChordEntity;", "Lnet/thebrokenscript/brokencore/api/entity/base/UwuableMonster;", "Lnet/minecraft/world/entity/monster/RangedAttackMob;", "Lnet/thebrokenscript/brokencore/api/entity/FinalizedSpawn;", "type", "Lnet/minecraft/world/entity/EntityType;", "level", "Lnet/minecraft/world/level/Level;", "<init>", "(Lnet/minecraft/world/entity/EntityType;Lnet/minecraft/world/level/Level;)V", "<set-?>", "", "getType", "()I", "setType", "(I)V", "type$delegate", "Lnet/thebrokenscript/brokencore/api/dsl/EntityDataDelegate;", "Ljava/util/Optional;", "Ljava/util/UUID;", "targetUUID", "getTargetUUID", "()Ljava/util/Optional;", "setTargetUUID", "(Ljava/util/Optional;)V", "targetUUID$delegate", "laserType", "getLaserType", "setLaserType", "laserType$delegate", "Lorg/joml/Vector3f;", "targetPos", "getTargetPos", "()Lorg/joml/Vector3f;", "setTargetPos", "(Lorg/joml/Vector3f;)V", "targetPos$delegate", "clientLaserAnimTimer", "getClientLaserAnimTimer", "setClientLaserAnimTimer", "clientLaserAnimLength", "getClientLaserAnimLength", "clientLaserAnimSegments", "getClientLaserAnimSegments", "setClientLaserAnimSegments", "clientLaserAnimDir", "getClientLaserAnimDir", "setClientLaserAnimDir", "meleeCharge", "", "getMeleeCharge", "()Z", "setMeleeCharge", "(Z)V", "meleeChargeTimer", "shouldBeSaved", "isPersistenceRequired", "removeWhenFarAway", "distanceToClosestPlayer", "", "causeFallDamage", "fallDistance", "", "multiplier", "source", "Lnet/minecraft/world/damagesource/DamageSource;", "createNavigation", "Lnet/minecraft/world/entity/ai/navigation/FlyingPathNavigation;", "registerGoals", "", "die", "damageSource", "tickDeath", "tick", "hurt", "amount", "getMaxHeadYRot", "getMaxHeadXRot", "spawnAnimPlayed", "getSpawnAnimPlayed", "setSpawnAnimPlayed", "registerControllers", "reg", "Lsoftware/bernie/geckolib/animation/AnimatableManager$ControllerRegistrar;", "performRangedAttack", "target", "Lnet/minecraft/world/entity/LivingEntity;", "distanceFactor", "createChargeLazer", "performProjectileAttack", "addAdditionalSaveData", "compound", "Lnet/minecraft/nbt/CompoundTag;", "readAdditionalSaveData", "onFinalizeSpawn", "Lnet/minecraft/world/entity/SpawnGroupData;", "Lnet/minecraft/world/level/ServerLevelAccessor;", "difficulty", "Lnet/minecraft/world/DifficultyInstance;", "spawnType", "Lnet/minecraft/world/entity/MobSpawnType;", "spawnData", "event", "Lnet/thebrokenscript/brokencore/api/platform/CancelProxy;", "getHurtSound", "Lnet/minecraft/sounds/SoundEvent;", "defineSynchedData", "builder", "Lnet/minecraft/network/syncher/SynchedEntityData$Builder;", "SmoothFlyingMoveControl", "FlyingRangedAttackGoal", "FlyToPlayerGoal", "PersistentTargetGoal", "Companion", "thebrokenscript-common"})
@SourceDebugExtension(value={"SMAP\nChordEntity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ChordEntity.kt\nnet/thebrokenscript/entity/boss/ChordEntity\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,539:1\n1869#2,2:540\n*S KotlinDebug\n*F\n+ 1 ChordEntity.kt\nnet/thebrokenscript/entity/boss/ChordEntity\n*L\n447#1:540,2\n*E\n"})
public final class ChordEntity
extends UwuableMonster
implements RangedAttackMob,
FinalizedSpawn {
    @NotNull
    public static final Companion Companion;
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;
    @NotNull
    private final EntityDataDelegate type$delegate;
    @NotNull
    private final EntityDataDelegate targetUUID$delegate;
    @NotNull
    private final EntityDataDelegate laserType$delegate;
    @NotNull
    private final EntityDataDelegate targetPos$delegate;
    private int clientLaserAnimTimer;
    private final int clientLaserAnimLength;
    private int clientLaserAnimSegments;
    @NotNull
    private Vector3f clientLaserAnimDir;
    private boolean meleeCharge;
    private int meleeChargeTimer;
    private boolean spawnAnimPlayed;
    public static final float LASER_QUAD_SIZE = 0.2f;
    @NotNull
    private static final EntityDataAccessor<Integer> TYPE;
    @NotNull
    private static final EntityDataAccessor<Integer> LASER_TYPE;
    @NotNull
    private static final EntityDataAccessor<Vector3f> TARGET_POS;
    @NotNull
    private static final EntityDataAccessor<Optional<UUID>> TARGET_UUID;

    public ChordEntity(@NotNull EntityType<ChordEntity> type, @NotNull Level level) {
        Intrinsics.checkNotNullParameter(type, (String)"type");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        super(type, level);
        this.type$delegate = this.entityData(TYPE);
        this.targetUUID$delegate = this.entityData(TARGET_UUID);
        this.laserType$delegate = this.entityData(LASER_TYPE);
        this.targetPos$delegate = this.entityData(TARGET_POS);
        this.clientLaserAnimLength = 20;
        this.clientLaserAnimDir = new Vector3f();
        this.setNoGravity(true);
        this.noCulling = true;
        this.moveControl = new SmoothFlyingMoveControl((Mob)this, 45.0f, 0.06, 6.0, 0.9);
        this.setPersistenceRequired();
        this.xpReward = 0;
    }

    public final int getType() {
        return ((Number)this.type$delegate.getValue((BaseMonster)this, $$delegatedProperties[0])).intValue();
    }

    public final void setType(int n) {
        this.type$delegate.setValue((BaseMonster)this, $$delegatedProperties[0], (Object)n);
    }

    @NotNull
    public final Optional<UUID> getTargetUUID() {
        return (Optional)this.targetUUID$delegate.getValue((BaseMonster)this, $$delegatedProperties[1]);
    }

    public final void setTargetUUID(@NotNull Optional<UUID> optional) {
        Intrinsics.checkNotNullParameter(optional, (String)"<set-?>");
        this.targetUUID$delegate.setValue((BaseMonster)this, $$delegatedProperties[1], optional);
    }

    public final int getLaserType() {
        return ((Number)this.laserType$delegate.getValue((BaseMonster)this, $$delegatedProperties[2])).intValue();
    }

    public final void setLaserType(int n) {
        this.laserType$delegate.setValue((BaseMonster)this, $$delegatedProperties[2], (Object)n);
    }

    @NotNull
    public final Vector3f getTargetPos() {
        return (Vector3f)this.targetPos$delegate.getValue((BaseMonster)this, $$delegatedProperties[3]);
    }

    public final void setTargetPos(@NotNull Vector3f vector3f) {
        Intrinsics.checkNotNullParameter((Object)vector3f, (String)"<set-?>");
        this.targetPos$delegate.setValue((BaseMonster)this, $$delegatedProperties[3], (Object)vector3f);
    }

    public final int getClientLaserAnimTimer() {
        return this.clientLaserAnimTimer;
    }

    public final void setClientLaserAnimTimer(int n) {
        this.clientLaserAnimTimer = n;
    }

    public final int getClientLaserAnimLength() {
        return this.clientLaserAnimLength;
    }

    public final int getClientLaserAnimSegments() {
        return this.clientLaserAnimSegments;
    }

    public final void setClientLaserAnimSegments(int n) {
        this.clientLaserAnimSegments = n;
    }

    @NotNull
    public final Vector3f getClientLaserAnimDir() {
        return this.clientLaserAnimDir;
    }

    public final void setClientLaserAnimDir(@NotNull Vector3f vector3f) {
        Intrinsics.checkNotNullParameter((Object)vector3f, (String)"<set-?>");
        this.clientLaserAnimDir = vector3f;
    }

    public final boolean getMeleeCharge() {
        return this.meleeCharge;
    }

    public final void setMeleeCharge(boolean bl) {
        this.meleeCharge = bl;
    }

    public boolean shouldBeSaved() {
        return false;
    }

    public boolean isPersistenceRequired() {
        return false;
    }

    public boolean removeWhenFarAway(double distanceToClosestPlayer) {
        return false;
    }

    public boolean causeFallDamage(float fallDistance, float multiplier, @NotNull DamageSource source) {
        Intrinsics.checkNotNullParameter((Object)source, (String)"source");
        return false;
    }

    @NotNull
    protected FlyingPathNavigation createNavigation(@NotNull Level level) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        return new FlyingPathNavigation((Mob)this, level);
    }

    protected void registerGoals() {
        this.targetSelector.addGoal(1, (Goal)new PersistentTargetGoal((Mob)this, Player.class, 0, 4, null));
        this.goalSelector.addGoal(1, (Goal)new FlyToPlayerGoal((Mob)this, 128, 2.25));
        this.goalSelector.addGoal(2, (Goal)new FlyingRangedAttackGoal(this, this, 20, 80.0f, 0.0f, 16, null));
    }

    public void die(@NotNull DamageSource damageSource) {
        Intrinsics.checkNotNullParameter((Object)damageSource, (String)"damageSource");
        super.die(damageSource);
        this.triggerAnim("Chord_Death", "Death");
        this.playSound((SoundEvent)TBSSounds.CHORD_DEATH.get(), 0.1f, 1.0f / (this.getRandom().nextFloat() * 0.4f + 0.8f));
    }

    protected void tickDeath() {
        int n = this.deathTime;
        this.deathTime = n + 1;
        if (this.deathTime >= 78) {
            this.remove(Entity.RemovalReason.KILLED);
        }
    }

    public void tick() {
        super.tick();
        this.uuid.getLeastSignificantBits();
        SideUtil.clientSide((Entity)((Entity)this), () -> ChordEntity.tick$lambda$0(this));
        if (!this.level().isClientSide) {
            Vec3 vel = this.getDeltaMovement();
            if (vel.y > 0.5 || vel.y < -0.5) {
                this.setDeltaMovement(new Vec3(vel.x, RangesKt.coerceIn((double)vel.y, (double)-0.5, (double)0.5), vel.z));
            }
        }
        if (this.tickCount == 1) {
            this.playSound((SoundEvent)TBSSounds.CHORD_SPAWN.get(), 0.1f, 1.0f / (this.getRandom().nextFloat() * 0.4f + 0.8f));
        }
    }

    public boolean hurt(@NotNull DamageSource source, float amount) {
        Intrinsics.checkNotNullParameter((Object)source, (String)"source");
        if (!this.isDeadOrDying()) {
            this.triggerAnim("Chord_Hurt", "Damaged");
            this.playSound((SoundEvent)TBSSounds.CHORD_DEATH.get(), 0.1f, 1.35f / (this.getRandom().nextFloat() * 0.4f + 0.8f));
        }
        return super.hurt(source, amount);
    }

    public int getMaxHeadYRot() {
        return 75;
    }

    public int getMaxHeadXRot() {
        return 60;
    }

    public final boolean getSpawnAnimPlayed() {
        return this.spawnAnimPlayed;
    }

    public final void setSpawnAnimPlayed(boolean bl) {
        this.spawnAnimPlayed = bl;
    }

    public void registerControllers(@NotNull AnimatableManager.ControllerRegistrar reg) {
        Intrinsics.checkNotNullParameter((Object)reg, (String)"reg");
        reg.add(new AnimationController((GeoAnimatable)this, "Chord", 0, arg_0 -> ChordEntity.registerControllers$lambda$0(this, arg_0)).triggerableAnim("Attack laser", RawAnimation.begin().thenPlay("Attack laser")).triggerableAnim("Attack jelly", RawAnimation.begin().thenPlay("Attack jelly")).setCustomInstructionKeyframeHandler(arg_0 -> ChordEntity.registerControllers$lambda$1(this, arg_0)));
        reg.add(new AnimationController((GeoAnimatable)this, "Chord_Death", 0, arg_0 -> ChordEntity.registerControllers$lambda$2(this, arg_0)));
        reg.add(new AnimationController((GeoAnimatable)this, "Chord_Hurt", 0, ChordEntity::registerControllers$lambda$3).triggerableAnim("Damaged", RawAnimation.begin().thenPlay("Damaged")));
    }

    public void performRangedAttack(@NotNull LivingEntity target, float distanceFactor) {
        Intrinsics.checkNotNullParameter((Object)target, (String)"target");
        Vector3f vector3f = new Vector3f((Vector3fc)this.getTargetPos()).sub(0.5f, 0.5f, 0.5f);
        Intrinsics.checkNotNullExpressionValue((Object)vector3f, (String)"sub(...)");
        Vec3 vec3 = PositionUtil.toVec3((Vector3fc)((Vector3fc)vector3f));
        Vector3f vector3f2 = new Vector3f((Vector3fc)this.getTargetPos()).add(0.5f, 0.5f, 0.5f);
        Intrinsics.checkNotNullExpressionValue((Object)vector3f2, (String)"add(...)");
        AABB box = new AABB(vec3, PositionUtil.toVec3((Vector3fc)((Vector3fc)vector3f2)));
        List list = this.getLevel().getEntities(null, box);
        Intrinsics.checkNotNullExpressionValue((Object)list, (String)"getEntities(...)");
        Iterable $this$forEach$iv = list;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            Entity it = (Entity)element$iv;
            boolean bl = false;
            it.hurt(this.damageSources().source(TBSDamageTypes.CHORD_LAZER.getKey()), (float)this.getAttributeValue(Attributes.ATTACK_DAMAGE));
        }
    }

    public final void createChargeLazer(@NotNull LivingEntity target) {
        Intrinsics.checkNotNullParameter((Object)target, (String)"target");
        if (target instanceof Player) {
            Optional<UUID> optional = Optional.of(((Player)target).getUUID());
            Intrinsics.checkNotNullExpressionValue(optional, (String)"of(...)");
            this.setTargetUUID(optional);
            Vector3f vector3f = target.position().toVector3f();
            Intrinsics.checkNotNullExpressionValue((Object)vector3f, (String)"toVector3f(...)");
            this.setTargetPos(vector3f);
        }
    }

    public final void performProjectileAttack(@NotNull LivingEntity target) {
        Intrinsics.checkNotNullParameter((Object)target, (String)"target");
        ChordProjectileEntity projectile = new ChordProjectileEntity(this.getLevel(), (LivingEntity)this);
        double x = target.getX() - this.getX();
        double y = target.getY(1.0) - projectile.getY();
        double z = target.getZ() - this.getZ();
        projectile.setInitialPos(this.getPos());
        projectile.shoot(x, y, z, 1.6f, 0.0f);
        projectile.setBaseDamageFromMob(2.0f);
        this.playSound((SoundEvent)TBSSounds.CHORD_SHOOT.get(), 0.5f, 1.0f / (this.getRandom().nextFloat() * 0.4f + 0.8f));
        this.level().addFreshEntity((Entity)projectile);
    }

    public void addAdditionalSaveData(@NotNull CompoundTag compound) {
        block0: {
            Intrinsics.checkNotNullParameter((Object)compound, (String)"compound");
            super.addAdditionalSaveData(compound);
            compound.putInt("type", this.getType());
            compound.putInt("laserType", this.getLaserType());
            UUID uUID = (UUID)OptionalsKt.getOrNull(this.getTargetUUID());
            if (uUID == null) break block0;
            UUID it = uUID;
            boolean bl = false;
            compound.putUUID("target", it);
        }
    }

    public void readAdditionalSaveData(@NotNull CompoundTag compound) {
        Intrinsics.checkNotNullParameter((Object)compound, (String)"compound");
        super.readAdditionalSaveData(compound);
        if (compound.contains("type")) {
            this.entityData.set(TYPE, (Object)compound.getInt("type"));
        }
        if (compound.contains("laserType")) {
            this.entityData.set(TYPE, (Object)compound.getInt("laserType"));
        }
        if (compound.contains("target")) {
            this.entityData.set(TARGET_UUID, Optional.of(compound.getUUID("target")));
        }
    }

    @Nullable
    public SpawnGroupData onFinalizeSpawn(@NotNull ServerLevelAccessor level, @NotNull DifficultyInstance difficulty, @NotNull MobSpawnType spawnType, @Nullable SpawnGroupData spawnData, @NotNull CancelProxy event) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)difficulty, (String)"difficulty");
        Intrinsics.checkNotNullParameter((Object)spawnType, (String)"spawnType");
        Intrinsics.checkNotNullParameter((Object)event, (String)"event");
        this.setType(RangesKt.random((IntRange)new IntRange(0, 1), (Random)((Random)Random.Default)));
        return null;
    }

    @Nullable
    protected SoundEvent getHurtSound(@NotNull DamageSource damageSource) {
        Intrinsics.checkNotNullParameter((Object)damageSource, (String)"damageSource");
        return null;
    }

    protected void defineSynchedData(@NotNull SynchedEntityData.Builder builder) {
        Intrinsics.checkNotNullParameter((Object)builder, (String)"builder");
        super.defineSynchedData(builder);
        builder.define(TYPE, (Object)-1);
        builder.define(LASER_TYPE, (Object)0);
        builder.define(TARGET_POS, (Object)new Vector3f(0.0f));
        builder.define(TARGET_UUID, Optional.empty());
    }

    private static final Object tick$lambda$0(ChordEntity this$0) {
        if (this$0.clientLaserAnimTimer > 0) {
            int n = this$0.clientLaserAnimTimer;
            this$0.clientLaserAnimTimer = n + -1;
        }
        if (!ClientVariables.INSTANCE.has(8L)) {
            LocalPlayer localPlayer = ClientDSLKt.getMC().player;
            if (localPlayer == null) {
                return false;
            }
            LocalPlayer player = localPlayer;
            if (PlayerExt.INSTANCE.isEntityInFovCone((Player)player, (Entity)this$0, Double.valueOf(((Number)ClientDSLKt.getMC().options.fov().get()).intValue()))) {
                ClientVariables.INSTANCE.set(8L);
            }
        }
        return Unit.INSTANCE;
    }

    private static final PlayState registerControllers$lambda$0(ChordEntity this$0, AnimationState it) {
        if (!this$0.spawnAnimPlayed) {
            this$0.spawnAnimPlayed = true;
            it.getController().setAnimation(RawAnimation.begin().thenPlay("spawn").thenLoop("Idle"));
        } else {
            AnimationProcessor.QueuedAnimation queuedAnimation;
            Animation animation;
            AnimationProcessor.QueuedAnimation queuedAnimation2 = it.getController().getCurrentAnimation();
            if (!(Intrinsics.areEqual(queuedAnimation2 != null && (animation = queuedAnimation2.animation()) != null ? animation.name() : null, (Object)"spawn") || Intrinsics.areEqual((queuedAnimation2 = it.getController().getCurrentAnimation()) != null && (animation = queuedAnimation2.animation()) != null ? animation.name() : null, (Object)"Damaged") || Intrinsics.areEqual((Object)((queuedAnimation = it.getController().getCurrentAnimation()) != null && (queuedAnimation = queuedAnimation.animation()) != null ? queuedAnimation.name() : null), (Object)"Death"))) {
                if (it.isMoving()) {
                    Entity entity = (Entity)this$0;
                    AnimationController animationController = it.getController();
                    Intrinsics.checkNotNullExpressionValue((Object)animationController, (String)"getController(...)");
                    GeckoUtil.loop((Entity)entity, (AnimationController)animationController, (String)"flying");
                } else {
                    Entity entity = (Entity)this$0;
                    AnimationController animationController = it.getController();
                    Intrinsics.checkNotNullExpressionValue((Object)animationController, (String)"getController(...)");
                    GeckoUtil.loop((Entity)entity, (AnimationController)animationController, (String)"Idle");
                }
            }
        }
        return PlayState.CONTINUE;
    }

    private static final void registerControllers$lambda$1(ChordEntity this$0, CustomInstructionKeyframeEvent event) {
        block17: {
            String string = event.getKeyframeData().getInstructions();
            if (string == null) break block17;
            int n = -1;
            switch (string.hashCode()) {
                case -892483559: {
                    if (string.equals("start;")) {
                        n = 1;
                    }
                    break;
                }
                case 3202824: {
                    if (string.equals("hit;")) {
                        n = 2;
                    }
                    break;
                }
                case 114855648: {
                    if (string.equals("yeet;")) {
                        n = 3;
                    }
                    break;
                }
            }
            switch (n) {
                case 1: {
                    this$0.setLaserType(0);
                    if (this$0.level().isClientSide) {
                        UUID uUID = (UUID)OptionalsKt.getOrNull(this$0.getTargetUUID());
                        if (uUID != null) {
                            UUID it = uUID;
                            boolean bl = false;
                            Player player = this$0.getLevel().getPlayerByUUID(it);
                            if (player != null) {
                                Player player2 = player;
                                boolean bl2 = false;
                                float dist = this$0.getTargetPos().distance((Vector3fc)this$0.getEyePosition(1.0f).toVector3f());
                                if (dist < 50.0f) {
                                    this$0.clientLaserAnimSegments = MathKt.roundToInt((float)((dist + 0.001f) / 0.2f));
                                    this$0.clientLaserAnimTimer = this$0.clientLaserAnimLength;
                                    Vector3f vector3f = this$0.position().toVector3f().sub((Vector3fc)this$0.getTargetPos()).normalize();
                                    Intrinsics.checkNotNullExpressionValue((Object)vector3f, (String)"normalize(...)");
                                    this$0.clientLaserAnimDir = vector3f;
                                }
                            }
                        }
                    }
                    PacketSender.INSTANCE.sendToServer((CustomPacketPayload)TBSPackets.CHORD_LAZER_CHARGE.of(this$0.getId()), new CustomPacketPayload[0]);
                    break;
                }
                case 2: {
                    this$0.setLaserType(1);
                    PacketSender.INSTANCE.sendToServer((CustomPacketPayload)TBSPackets.CHORD_LAZER_ATTACK.of(this$0.getId()), new CustomPacketPayload[0]);
                    break;
                }
                case 3: {
                    PacketSender.INSTANCE.sendToServer((CustomPacketPayload)TBSPackets.CHORD_PROJECTILE_ATTACK.of(this$0.getId()), new CustomPacketPayload[0]);
                }
            }
        }
    }

    private static final PlayState registerControllers$lambda$2(ChordEntity this$0, AnimationState it) {
        if (this$0.isDeadOrDying()) {
            it.getController().setAnimation(RawAnimation.begin().thenPlayAndHold("Death"));
            return PlayState.CONTINUE;
        }
        return PlayState.STOP;
    }

    private static final PlayState registerControllers$lambda$3(AnimationState it) {
        return PlayState.STOP;
    }

    static {
        KProperty[] kPropertyArray = new KProperty[]{Reflection.mutableProperty1((MutablePropertyReference1)((MutablePropertyReference1)new MutablePropertyReference1Impl(ChordEntity.class, "type", "getType()I", 0))), Reflection.mutableProperty1((MutablePropertyReference1)((MutablePropertyReference1)new MutablePropertyReference1Impl(ChordEntity.class, "targetUUID", "getTargetUUID()Ljava/util/Optional;", 0))), Reflection.mutableProperty1((MutablePropertyReference1)((MutablePropertyReference1)new MutablePropertyReference1Impl(ChordEntity.class, "laserType", "getLaserType()I", 0))), Reflection.mutableProperty1((MutablePropertyReference1)((MutablePropertyReference1)new MutablePropertyReference1Impl(ChordEntity.class, "targetPos", "getTargetPos()Lorg/joml/Vector3f;", 0)))};
        $$delegatedProperties = kPropertyArray;
        Companion = new Companion(null);
        EntityDataAccessor entityDataAccessor = SynchedEntityData.defineId(ChordEntity.class, (EntityDataSerializer)EntityDataSerializers.INT);
        Intrinsics.checkNotNullExpressionValue((Object)entityDataAccessor, (String)"defineId(...)");
        TYPE = entityDataAccessor;
        EntityDataAccessor entityDataAccessor2 = SynchedEntityData.defineId(ChordEntity.class, (EntityDataSerializer)EntityDataSerializers.INT);
        Intrinsics.checkNotNullExpressionValue((Object)entityDataAccessor2, (String)"defineId(...)");
        LASER_TYPE = entityDataAccessor2;
        EntityDataAccessor entityDataAccessor3 = SynchedEntityData.defineId(ChordEntity.class, (EntityDataSerializer)EntityDataSerializers.VECTOR3);
        Intrinsics.checkNotNullExpressionValue((Object)entityDataAccessor3, (String)"defineId(...)");
        TARGET_POS = entityDataAccessor3;
        EntityDataAccessor entityDataAccessor4 = SynchedEntityData.defineId(ChordEntity.class, (EntityDataSerializer)EntityDataSerializers.OPTIONAL_UUID);
        Intrinsics.checkNotNullExpressionValue((Object)entityDataAccessor4, (String)"defineId(...)");
        TARGET_UUID = entityDataAccessor4;
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\nR\u001d\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\n\u00a8\u0006\u0014"}, d2={"Lnet/thebrokenscript/entity/boss/ChordEntity$Companion;", "", "<init>", "()V", "LASER_QUAD_SIZE", "", "TYPE", "Lnet/minecraft/network/syncher/EntityDataAccessor;", "", "getTYPE", "()Lnet/minecraft/network/syncher/EntityDataAccessor;", "LASER_TYPE", "getLASER_TYPE", "TARGET_POS", "Lorg/joml/Vector3f;", "getTARGET_POS", "TARGET_UUID", "Ljava/util/Optional;", "Ljava/util/UUID;", "getTARGET_UUID", "thebrokenscript-common"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final EntityDataAccessor<Integer> getTYPE() {
            return TYPE;
        }

        @NotNull
        public final EntityDataAccessor<Integer> getLASER_TYPE() {
            return LASER_TYPE;
        }

        @NotNull
        public final EntityDataAccessor<Vector3f> getTARGET_POS() {
            return TARGET_POS;
        }

        @NotNull
        public final EntityDataAccessor<Optional<UUID>> getTARGET_UUID() {
            return TARGET_UUID;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0004\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u001aB\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\b\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0015H\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0018H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u0007X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001b"}, d2={"Lnet/thebrokenscript/entity/boss/ChordEntity$FlyToPlayerGoal;", "Lnet/minecraft/world/entity/ai/goal/Goal;", "mob", "Lnet/minecraft/world/entity/Mob;", "distance", "", "entSpeed", "", "<init>", "(Lnet/minecraft/world/entity/Mob;Ljava/lang/Number;D)V", "getDistance", "()Ljava/lang/Number;", "getEntSpeed", "()D", "meleeDistance", "holdDistance", "approachThreshold", "retreatMargin", "state", "Lnet/thebrokenscript/entity/boss/ChordEntity$FlyToPlayerGoal$State;", "canUse", "", "canContinueToUse", "start", "", "tick", "State", "thebrokenscript-common"})
    public static final class FlyToPlayerGoal
    extends Goal {
        @NotNull
        private final Mob mob;
        @NotNull
        private final Number distance;
        private final double entSpeed;
        private final double meleeDistance;
        private final double holdDistance;
        private final double approachThreshold;
        private final double retreatMargin;
        @NotNull
        private State state;

        public FlyToPlayerGoal(@NotNull Mob mob, @NotNull Number distance, double entSpeed) {
            Intrinsics.checkNotNullParameter((Object)mob, (String)"mob");
            Intrinsics.checkNotNullParameter((Object)distance, (String)"distance");
            this.mob = mob;
            this.distance = distance;
            this.entSpeed = entSpeed;
            this.meleeDistance = 4.0;
            this.holdDistance = 8.0;
            this.approachThreshold = 12.0;
            this.retreatMargin = 1.0;
            this.state = State.APPROACHING;
            this.setFlags(EnumSet.of((Enum)Goal.Flag.MOVE, (Enum)Goal.Flag.LOOK));
        }

        @NotNull
        public final Number getDistance() {
            return this.distance;
        }

        public final double getEntSpeed() {
            return this.entSpeed;
        }

        public boolean canUse() {
            Player player = this.mob.level().getNearestPlayer((Entity)this.mob, this.distance.doubleValue());
            return player != null && player.isAlive() && !player.isSpectator() && !player.isCreative();
        }

        public boolean canContinueToUse() {
            return this.canUse();
        }

        public void start() {
            this.state = State.APPROACHING;
        }

        public void tick() {
            ChordEntity chord;
            Player player = this.mob.level().getNearestPlayer((Entity)this.mob, this.distance.doubleValue());
            if (player == null) {
                return;
            }
            Player player2 = player;
            this.mob.setTarget((LivingEntity)player2);
            this.mob.getLookControl().setLookAt((Entity)player2);
            Mob mob = this.mob;
            ChordEntity chordEntity = chord = mob instanceof ChordEntity ? (ChordEntity)mob : null;
            boolean bl = chordEntity != null ? chordEntity.getMeleeCharge() : false;
            if (bl) {
                ((ChordEntity)this.mob).moveControl.setWantedPosition(player2.getX(), player2.getY(0.5), player2.getZ(), this.entSpeed * 1.3);
                return;
            }
            double horizontalDist = new Vec3(this.mob.getX() - player2.getX(), 0.0, this.mob.getZ() - player2.getZ()).length();
            double hoverY = player2.getY() + 8.0;
            this.state = switch (WhenMappings.$EnumSwitchMapping$0[this.state.ordinal()]) {
                case 1 -> {
                    if (horizontalDist <= this.holdDistance) {
                        yield State.HOLDING;
                    }
                    yield State.APPROACHING;
                }
                case 2 -> {
                    if (horizontalDist >= this.holdDistance) {
                        yield State.HOLDING;
                    }
                    yield State.RETREATING;
                }
                case 3 -> {
                    if (horizontalDist < this.meleeDistance - this.retreatMargin) {
                        yield State.RETREATING;
                    }
                    if (horizontalDist > this.approachThreshold) {
                        yield State.APPROACHING;
                    }
                    yield State.HOLDING;
                }
                default -> throw new NoWhenBranchMatchedException();
            };
            switch (WhenMappings.$EnumSwitchMapping$0[this.state.ordinal()]) {
                case 1: {
                    this.mob.getMoveControl().setWantedPosition(player2.getX(), hoverY, player2.getZ(), this.entSpeed);
                    break;
                }
                case 2: {
                    Vec3 awayDir = horizontalDist > 0.01 ? new Vec3(this.mob.getX() - player2.getX(), 0.0, this.mob.getZ() - player2.getZ()).normalize() : new Vec3(1.0, 0.0, 0.0);
                    this.mob.getMoveControl().setWantedPosition(player2.getX() + awayDir.x * this.holdDistance, hoverY, player2.getZ() + awayDir.z * this.holdDistance, this.entSpeed);
                    break;
                }
                case 3: {
                    this.mob.setDeltaMovement(this.mob.getDeltaMovement().multiply(0.85, 1.0, 0.85));
                    break;
                }
                default: {
                    throw new NoWhenBranchMatchedException();
                }
            }
        }

        @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006\u00a8\u0006\u0007"}, d2={"Lnet/thebrokenscript/entity/boss/ChordEntity$FlyToPlayerGoal$State;", "", "<init>", "(Ljava/lang/String;I)V", "APPROACHING", "HOLDING", "RETREATING", "thebrokenscript-common"})
        private static final class State
        extends Enum<State> {
            public static final /* enum */ State APPROACHING = new State();
            public static final /* enum */ State HOLDING = new State();
            public static final /* enum */ State RETREATING = new State();
            private static final /* synthetic */ State[] $VALUES;
            private static final /* synthetic */ EnumEntries $ENTRIES;

            public static State[] values() {
                return (State[])$VALUES.clone();
            }

            public static State valueOf(String value) {
                return Enum.valueOf(State.class, value);
            }

            @NotNull
            public static EnumEntries<State> getEntries() {
                return $ENTRIES;
            }

            static {
                $VALUES = stateArray = new State[]{State.APPROACHING, State.HOLDING, State.RETREATING};
                $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
            }
        }

        @Metadata(mv={2, 1, 0}, k=3, xi=48)
        public static final class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] nArray = new int[State.values().length];
                try {
                    nArray[State.APPROACHING.ordinal()] = 1;
                }
                catch (NoSuchFieldError noSuchFieldError) {
                    // empty catch block
                }
                try {
                    nArray[State.RETREATING.ordinal()] = 2;
                }
                catch (NoSuchFieldError noSuchFieldError) {
                    // empty catch block
                }
                try {
                    nArray[State.HOLDING.ordinal()] = 3;
                }
                catch (NoSuchFieldError noSuchFieldError) {
                    // empty catch block
                }
                $EnumSwitchMapping$0 = nArray;
            }
        }
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u00a2\u0006\u0004\b\n\u0010\u000bJ\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0014H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2={"Lnet/thebrokenscript/entity/boss/ChordEntity$FlyingRangedAttackGoal;", "Lnet/minecraft/world/entity/ai/goal/Goal;", "mob", "Lnet/thebrokenscript/entity/boss/ChordEntity;", "attackMob", "attackIntervalMin", "", "attackRadius", "", "meleeRange", "<init>", "(Lnet/thebrokenscript/entity/boss/ChordEntity;Lnet/thebrokenscript/entity/boss/ChordEntity;IFF)V", "attackTime", "canUse", "", "canContinueToUse", "tick", "", "performMelee", "target", "Lnet/minecraft/world/entity/LivingEntity;", "thebrokenscript-common"})
    public static final class FlyingRangedAttackGoal
    extends Goal {
        @NotNull
        private final ChordEntity mob;
        @NotNull
        private final ChordEntity attackMob;
        private final int attackIntervalMin;
        private final float attackRadius;
        private final float meleeRange;
        private int attackTime;

        public FlyingRangedAttackGoal(@NotNull ChordEntity mob, @NotNull ChordEntity attackMob, int attackIntervalMin, float attackRadius, float meleeRange) {
            Intrinsics.checkNotNullParameter((Object)((Object)mob), (String)"mob");
            Intrinsics.checkNotNullParameter((Object)((Object)attackMob), (String)"attackMob");
            this.mob = mob;
            this.attackMob = attackMob;
            this.attackIntervalMin = attackIntervalMin;
            this.attackRadius = attackRadius;
            this.meleeRange = meleeRange;
            this.attackTime = -1;
            this.setFlags(EnumSet.noneOf(Goal.Flag.class));
        }

        public /* synthetic */ FlyingRangedAttackGoal(ChordEntity chordEntity, ChordEntity chordEntity2, int n, float f, float f2, int n2, DefaultConstructorMarker defaultConstructorMarker) {
            if ((n2 & 0x10) != 0) {
                f2 = 4.0f;
            }
            this(chordEntity, chordEntity2, n, f, f2);
        }

        public boolean canUse() {
            LivingEntity livingEntity = this.mob.getTarget();
            ServerPlayer player = livingEntity instanceof ServerPlayer ? (ServerPlayer)livingEntity : null;
            return player != null && player.isAlive() && !player.isSpectator() && !player.isCreative();
        }

        public boolean canContinueToUse() {
            return this.canUse();
        }

        public void tick() {
            LivingEntity livingEntity = this.mob.getTarget();
            if (livingEntity == null) {
                return;
            }
            LivingEntity target = livingEntity;
            float dist = this.mob.distanceTo((Entity)target);
            if (this.mob.getMeleeCharge()) {
                ChordEntity chordEntity = this.mob;
                int n = chordEntity.meleeChargeTimer;
                chordEntity.meleeChargeTimer = n + -1;
                if (dist <= this.meleeRange) {
                    this.performMelee(target);
                    this.mob.setMeleeCharge(false);
                    this.attackTime = this.attackIntervalMin + Random.Default.nextInt(5, 15);
                } else if (this.mob.meleeChargeTimer <= 0 || !this.mob.getSensing().hasLineOfSight((Entity)target)) {
                    this.mob.setMeleeCharge(false);
                    this.attackTime = this.attackIntervalMin;
                }
                return;
            }
            int n = this.attackTime;
            this.attackTime = n + -1;
            if (this.attackTime <= 0 && this.mob.getSensing().hasLineOfSight((Entity)target)) {
                if (dist <= this.meleeRange) {
                    this.performMelee(target);
                    this.attackTime = this.attackIntervalMin + Random.Default.nextInt(5, 15);
                } else if (dist <= this.attackRadius) {
                    if (Random.Default.nextInt(3) == 0) {
                        this.mob.setMeleeCharge(true);
                        this.mob.meleeChargeTimer = 60;
                    } else {
                        this.attackTime = this.attackIntervalMin + Random.Default.nextInt(5, 15);
                        if (this.mob.getType() == 0) {
                            this.mob.triggerAnim("Chord", "Attack laser");
                        } else if (this.mob.getType() == 1) {
                            this.mob.triggerAnim("Chord", "Attack jelly");
                        }
                    }
                }
            }
        }

        private final void performMelee(LivingEntity target) {
            this.mob.doHurtTarget((Entity)target);
            this.mob.playSound((SoundEvent)TBSSounds.CHORD_SHOOT.get(), 0.5f, 0.6f / (this.mob.random.nextFloat() * 0.4f + 0.8f));
        }
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B'\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0004\b\t\u0010\nJ\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2={"Lnet/thebrokenscript/entity/boss/ChordEntity$PersistentTargetGoal;", "Lnet/minecraft/world/entity/ai/goal/target/NearestAttackableTargetGoal;", "Lnet/minecraft/world/entity/player/Player;", "mob", "Lnet/minecraft/world/entity/Mob;", "targetType", "Ljava/lang/Class;", "losMemoryTicks", "", "<init>", "(Lnet/minecraft/world/entity/Mob;Ljava/lang/Class;I)V", "lastTickSeen", "canContinueToUse", "", "start", "", "thebrokenscript-common"})
    public static final class PersistentTargetGoal
    extends NearestAttackableTargetGoal<Player> {
        private final int losMemoryTicks;
        private int lastTickSeen;

        public PersistentTargetGoal(@NotNull Mob mob, @NotNull Class<Player> targetType, int losMemoryTicks) {
            Intrinsics.checkNotNullParameter((Object)mob, (String)"mob");
            Intrinsics.checkNotNullParameter(targetType, (String)"targetType");
            super(mob, targetType, true);
            this.losMemoryTicks = losMemoryTicks;
        }

        public /* synthetic */ PersistentTargetGoal(Mob mob, Class clazz, int n, int n2, DefaultConstructorMarker defaultConstructorMarker) {
            if ((n2 & 4) != 0) {
                n = 200;
            }
            this(mob, clazz, n);
        }

        public boolean canContinueToUse() {
            LivingEntity livingEntity = this.mob.getTarget();
            if (livingEntity == null) {
                return false;
            }
            LivingEntity target = livingEntity;
            if (this.mob.getSensing().hasLineOfSight((Entity)target)) {
                this.lastTickSeen = 0;
                return super.canContinueToUse();
            }
            int n = this.lastTickSeen;
            this.lastTickSeen = n + 1;
            return this.lastTickSeen < this.losMemoryTicks ? true : super.canContinueToUse();
        }

        public void start() {
            super.start();
            this.lastTickSeen = 0;
        }
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\b\u0010\f\u001a\u00020\rH\u0016J \u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0005H\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2={"Lnet/thebrokenscript/entity/boss/ChordEntity$SmoothFlyingMoveControl;", "Lnet/minecraft/world/entity/ai/control/MoveControl;", "chord", "Lnet/minecraft/world/entity/Mob;", "maxTurnDeg", "", "acceleration", "", "arrivalRadius", "maxSpeedMultiplier", "<init>", "(Lnet/minecraft/world/entity/Mob;FDDD)V", "tick", "", "rotlerp", "current", "target", "maxChange", "thebrokenscript-common"})
    public static final class SmoothFlyingMoveControl
    extends MoveControl {
        @NotNull
        private final Mob chord;
        private final float maxTurnDeg;
        private final double acceleration;
        private final double arrivalRadius;
        private final double maxSpeedMultiplier;

        public SmoothFlyingMoveControl(@NotNull Mob chord, float maxTurnDeg, double acceleration, double arrivalRadius, double maxSpeedMultiplier) {
            Intrinsics.checkNotNullParameter((Object)chord, (String)"chord");
            super(chord);
            this.chord = chord;
            this.maxTurnDeg = maxTurnDeg;
            this.acceleration = acceleration;
            this.arrivalRadius = arrivalRadius;
            this.maxSpeedMultiplier = maxSpeedMultiplier;
        }

        public /* synthetic */ SmoothFlyingMoveControl(Mob mob, float f, double d, double d2, double d3, int n, DefaultConstructorMarker defaultConstructorMarker) {
            if ((n & 2) != 0) {
                f = 45.0f;
            }
            if ((n & 4) != 0) {
                d = 0.08;
            }
            if ((n & 8) != 0) {
                d2 = 1.5;
            }
            if ((n & 0x10) != 0) {
                d3 = 1.0;
            }
            this(mob, f, d, d2, d3);
        }

        public void tick() {
            double dz;
            double dy;
            if (this.operation != MoveControl.Operation.MOVE_TO) {
                this.chord.setSpeed(0.0f);
                return;
            }
            double dx = this.wantedX - this.chord.getX();
            double dist = Math.sqrt(dx * dx + (dy = this.wantedY - this.chord.getY()) * dy + (dz = this.wantedZ - this.chord.getZ()) * dz);
            if (dist < 1.0E-4) {
                this.operation = MoveControl.Operation.WAIT;
                return;
            }
            double baseSpeed = this.chord.getAttributeValue(Attributes.FLYING_SPEED) * this.speedModifier * this.maxSpeedMultiplier;
            double speedScale = RangesKt.coerceIn((double)(dist / this.arrivalRadius), (double)0.2, (double)1.0);
            double targetSpeed = baseSpeed * speedScale;
            double dirX = dx / dist;
            double dirY = dy / dist;
            double dirZ = dz / dist;
            Vec3 desiredVel = new Vec3(dirX * targetSpeed, dirY * targetSpeed, dirZ * targetSpeed);
            Vec3 currentVel = this.chord.getDeltaMovement();
            Vec3 newVel = new Vec3(Mth.lerp((double)this.acceleration, (double)currentVel.x, (double)desiredVel.x), Mth.lerp((double)this.acceleration, (double)currentVel.y, (double)desiredVel.y), Mth.lerp((double)this.acceleration, (double)currentVel.z, (double)desiredVel.z));
            this.chord.setDeltaMovement(newVel);
            if (newVel.horizontalDistanceSqr() > 1.0E-5) {
                float targetYaw = (float)(Mth.atan2((double)newVel.z, (double)newVel.x) * 57.29577951308232) - 90.0f;
                this.chord.setYRot(this.rotlerp(this.chord.getYRot(), targetYaw, this.maxTurnDeg));
                this.chord.yBodyRot = this.chord.getYRot();
            }
            double horizontalDist = Math.sqrt(newVel.x * newVel.x + newVel.z * newVel.z);
            float targetPitch = (float)(-(Mth.atan2((double)newVel.y, (double)horizontalDist) * 57.29577951308232));
            this.chord.setXRot(this.rotlerp(this.chord.getXRot(), targetPitch, this.maxTurnDeg));
        }

        protected float rotlerp(float current, float target, float maxChange) {
            float delta = Mth.wrapDegrees((float)(target - current));
            float clamped = RangesKt.coerceIn((float)delta, (float)(-maxChange), (float)maxChange);
            return current + clamped;
        }
    }
}

