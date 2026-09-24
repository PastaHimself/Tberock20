/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.ImmutableCollection
 *  com.google.common.collect.ImmutableMap
 *  com.google.common.collect.ImmutableMap$Builder
 *  com.google.common.collect.UnmodifiableIterator
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.enums.EnumEntries
 *  kotlin.jvm.JvmName
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.MutablePropertyReference1
 *  kotlin.jvm.internal.MutablePropertyReference1Impl
 *  kotlin.jvm.internal.Reflection
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.ranges.RangesKt
 *  kotlin.reflect.KProperty
 *  net.minecraft.client.player.LocalPlayer
 *  net.minecraft.core.BlockPos
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.network.protocol.common.custom.CustomPacketPayload
 *  net.minecraft.network.syncher.EntityDataAccessor
 *  net.minecraft.network.syncher.EntityDataSerializer
 *  net.minecraft.network.syncher.EntityDataSerializers
 *  net.minecraft.network.syncher.SynchedEntityData
 *  net.minecraft.network.syncher.SynchedEntityData$Builder
 *  net.minecraft.sounds.SoundEvent
 *  net.minecraft.sounds.SoundEvents
 *  net.minecraft.sounds.SoundSource
 *  net.minecraft.world.damagesource.DamageSource
 *  net.minecraft.world.damagesource.DamageTypes
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.Entity$RemovalReason
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.EquipmentSlot
 *  net.minecraft.world.entity.Mob
 *  net.minecraft.world.entity.PathfinderMob
 *  net.minecraft.world.entity.Pose
 *  net.minecraft.world.entity.ai.goal.Goal
 *  net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.item.Items
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.phys.AABB
 *  net.thebrokenscript.brokencore.api.dsl.ClientDSLKt
 *  net.thebrokenscript.brokencore.api.dsl.EntityDataDelegate
 *  net.thebrokenscript.brokencore.api.dsl.GeckoUtil
 *  net.thebrokenscript.brokencore.api.dsl.LevelUtil
 *  net.thebrokenscript.brokencore.api.dsl.SideUtil
 *  net.thebrokenscript.brokencore.api.entity.base.BaseMonster
 *  net.thebrokenscript.brokencore.api.network.PacketSender
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  org.joml.Vector3d
 *  software.bernie.geckolib.animatable.GeoAnimatable
 *  software.bernie.geckolib.animation.AnimatableManager$ControllerRegistrar
 *  software.bernie.geckolib.animation.AnimationController
 *  software.bernie.geckolib.animation.AnimationState
 *  software.bernie.geckolib.animation.PlayState
 *  software.bernie.geckolib.animation.keyframe.event.CustomInstructionKeyframeEvent
 *  software.bernie.geckolib.cache.object.GeoBone
 */
package net.thebrokenscript.entity.integrity.phase3;

import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.UnmodifiableIterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KProperty;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializer;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.thebrokenscript.api.entity.ai.integrity.phase3.IntegMoveControl;
import net.thebrokenscript.api.entity.ai.integrity.phase3.Phase3Goals;
import net.thebrokenscript.api.ext.PlayerExt;
import net.thebrokenscript.boss.integrity.Phase3;
import net.thebrokenscript.brokencore.api.dsl.ClientDSLKt;
import net.thebrokenscript.brokencore.api.dsl.EntityDataDelegate;
import net.thebrokenscript.brokencore.api.dsl.GeckoUtil;
import net.thebrokenscript.brokencore.api.dsl.LevelUtil;
import net.thebrokenscript.brokencore.api.dsl.SideUtil;
import net.thebrokenscript.brokencore.api.entity.base.BaseMonster;
import net.thebrokenscript.brokencore.api.network.PacketSender;
import net.thebrokenscript.client.data.ClientVariables;
import net.thebrokenscript.entity.integrity.IntegrityPhaseEntity;
import net.thebrokenscript.entity.integrity.phase3.IntegFireballEntity;
import net.thebrokenscript.entity.integrity.phase3.IntegrityPhase3Model;
import net.thebrokenscript.entity.integrity.phase3.attacks.Attack;
import net.thebrokenscript.entity.integrity.phase3.attacks.AttackType;
import net.thebrokenscript.entity.integrity.phase3.attacks.FireballAttack;
import net.thebrokenscript.entity.integrity.phase3.attacks.GravityAttack;
import net.thebrokenscript.entity.integrity.phase3.attacks.GroundAttack;
import net.thebrokenscript.entity.integrity.phase3.attacks.NoopAttack;
import net.thebrokenscript.entity.integrity.phase3.attacks.TentacleSwipeAttack;
import net.thebrokenscript.entity.integrity.phase3.attacks.TentaclesAttack;
import net.thebrokenscript.misc.ForceRuntimeInit;
import net.thebrokenscript.network.FireballEndecData;
import net.thebrokenscript.registry.TBSPackets;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector3d;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.animation.AnimationController;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.animation.PlayState;
import software.bernie.geckolib.animation.keyframe.event.CustomInstructionKeyframeEvent;
import software.bernie.geckolib.cache.object.GeoBone;

@ForceRuntimeInit
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 w2\u00020\u0001:\u0001wB\u001d\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00000\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0016J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\tJ\b\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\tH\u0016J\u0010\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\tH\u0016J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\u0010\u0010\u001c\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\u0018H\u0016J\b\u0010X\u001a\u00020\u000bH\u0014J\u0010\u0010Y\u001a\u00020\u000b2\u0006\u0010Z\u001a\u00020[H\u0014J\u0010\u0010\\\u001a\u00020\u000b2\u0006\u0010]\u001a\u00020^H\u0016J\u0018\u0010_\u001a\u00020\u000b2\u0006\u0010`\u001a\u00020a2\u0006\u0010b\u001a\u00020cH\u0014J\u0012\u0010d\u001a\u0004\u0018\u00010e2\u0006\u0010`\u001a\u00020aH\u0014J\u0018\u0010f\u001a\u00020\t2\u0006\u0010g\u001a\u00020a2\u0006\u0010h\u001a\u00020cH\u0016J\u0010\u0010i\u001a\u00020\t2\u0006\u0010j\u001a\u00020kH\u0002J\u0010\u0010l\u001a\u00020\u000b2\u0006\u0010j\u001a\u00020kH\u0002J\u0010\u0010m\u001a\u00020\u000b2\u0006\u0010]\u001a\u00020^H\u0016J\b\u0010n\u001a\u00020\u000bH\u0016J\u0006\u0010o\u001a\u00020\u000bJ\u0010\u0010p\u001a\u00020\u000b2\u0006\u0010`\u001a\u00020aH\u0016J\b\u0010q\u001a\u00020\u000bH\u0014J\u0010\u0010r\u001a\u00020\u000b2\u0006\u0010s\u001a\u00020tH\u0016J\b\u0010u\u001a\u00020vH\u0016R\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010 \u001a\u00020\u001f2\u0006\u0010\u001e\u001a\u00020\u001f8G@GX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R+\u0010'\u001a\u00020&2\u0006\u0010%\u001a\u00020&8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001a\u0010.\u001a\u00020\u0014X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001a\u00103\u001a\u00020\u0014X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b4\u00100\"\u0004\b5\u00102R\u001a\u00106\u001a\u00020\u0014X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b7\u00100\"\u0004\b8\u00102R\u001a\u00109\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\u001a\u0010>\u001a\u00020\u0014X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b?\u00100\"\u0004\b@\u00102R\u001c\u0010A\u001a\u0004\u0018\u00010BX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\u001a\u0010G\u001a\u00020\u0014X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bH\u00100\"\u0004\bI\u00102R\u001a\u0010J\u001a\u00020\u0014X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bK\u00100\"\u0004\bL\u00102R\u001a\u0010M\u001a\u00020\u0014X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bN\u00100\"\u0004\bO\u00102R+\u0010P\u001a\u00020\t2\u0006\u0010%\u001a\u00020\t8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\bS\u0010-\u001a\u0004\bQ\u0010;\"\u0004\bR\u0010=R+\u0010T\u001a\u00020\t2\u0006\u0010%\u001a\u00020\t8G@GX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\bW\u0010-\u001a\u0004\bU\u0010;\"\u0004\bV\u0010=\u00a8\u0006x"}, d2={"Lnet/thebrokenscript/entity/integrity/phase3/IntegrityPhase3Entity;", "Lnet/thebrokenscript/entity/integrity/IntegrityPhaseEntity;", "entityType", "Lnet/minecraft/world/entity/EntityType;", "level", "Lnet/minecraft/world/level/Level;", "<init>", "(Lnet/minecraft/world/entity/EntityType;Lnet/minecraft/world/level/Level;)V", "isPushedByFluid", "", "setStuck", "", "stuck", "previousAttack", "Lnet/thebrokenscript/entity/integrity/phase3/attacks/AttackType;", "getPreviousAttack", "()Lnet/thebrokenscript/entity/integrity/phase3/attacks/AttackType;", "setPreviousAttack", "(Lnet/thebrokenscript/entity/integrity/phase3/attacks/AttackType;)V", "getMaxFallDistance", "", "isPersistenceRequired", "removeWhenFarAway", "distanceToClosestPlayer", "", "fireImmune", "getBoundingBoxForCulling", "Lnet/minecraft/world/phys/AABB;", "shouldRenderAtSqrDistance", "dist", "value", "Lnet/thebrokenscript/entity/integrity/phase3/attacks/Attack;", "attack", "getAttackStateInternal", "()Lnet/thebrokenscript/entity/integrity/phase3/attacks/Attack;", "setAttackStateInternal", "(Lnet/thebrokenscript/entity/integrity/phase3/attacks/Attack;)V", "<set-?>", "", "attackDelay", "getAttackDelay", "()J", "setAttackDelay", "(J)V", "attackDelay$delegate", "Lnet/thebrokenscript/brokencore/api/dsl/EntityDataDelegate;", "attackTicks", "getAttackTicks", "()I", "setAttackTicks", "(I)V", "hurtFrames", "getHurtFrames", "setHurtFrames", "maceParryCooldown", "getMaceParryCooldown", "setMaceParryCooldown", "shotFireball", "getShotFireball", "()Z", "setShotFireball", "(Z)V", "groundAttackTimer", "getGroundAttackTimer", "setGroundAttackTimer", "groundAttackTargetPos", "Lnet/minecraft/core/BlockPos;", "getGroundAttackTargetPos", "()Lnet/minecraft/core/BlockPos;", "setGroundAttackTargetPos", "(Lnet/minecraft/core/BlockPos;)V", "swipeAttackTimer", "getSwipeAttackTimer", "setSwipeAttackTimer", "aoeAttackTimer", "getAoeAttackTimer", "setAoeAttackTimer", "stuckTimer", "getStuckTimer", "setStuckTimer", "dying", "getDying", "setDying", "dying$delegate", "isStuck", "stuckStatus", "setStuckStatus", "isStuck$delegate", "registerGoals", "defineSynchedData", "builder", "Lnet/minecraft/network/syncher/SynchedEntityData$Builder;", "addAdditionalSaveData", "compound", "Lnet/minecraft/nbt/CompoundTag;", "actuallyHurt", "damageSource", "Lnet/minecraft/world/damagesource/DamageSource;", "damageAmount", "", "getHurtSound", "Lnet/minecraft/sounds/SoundEvent;", "hurt", "source", "amount", "isMaceAttack", "player", "Lnet/minecraft/world/entity/player/Player;", "onMaceParried", "readAdditionalSaveData", "tick", "finishAttack", "die", "tickDeath", "registerControllers", "reg", "Lsoftware/bernie/geckolib/animation/AnimatableManager$ControllerRegistrar;", "getPose", "Lnet/minecraft/world/entity/Pose;", "Companion", "thebrokenscript-common"})
@SourceDebugExtension(value={"SMAP\nIntegrityPhase3Entity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 IntegrityPhase3Entity.kt\nnet/thebrokenscript/entity/integrity/phase3/IntegrityPhase3Entity\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,349:1\n1#2:350\n*E\n"})
public final class IntegrityPhase3Entity
extends IntegrityPhaseEntity {
    @NotNull
    public static final Companion Companion;
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;
    @Nullable
    private AttackType previousAttack;
    @NotNull
    private final EntityDataDelegate attackDelay$delegate;
    private int attackTicks;
    private int hurtFrames;
    private int maceParryCooldown;
    private boolean shotFireball;
    private int groundAttackTimer;
    @Nullable
    private BlockPos groundAttackTargetPos;
    private int swipeAttackTimer;
    private int aoeAttackTimer;
    private int stuckTimer;
    @NotNull
    private final EntityDataDelegate dying$delegate;
    @NotNull
    private final EntityDataDelegate isStuck$delegate;
    @NotNull
    private static final ImmutableMap<AttackType, Attack> ATTACKS;
    @NotNull
    private static final EntityDataAccessor<Integer> DATA_ATTACK_ID;
    @NotNull
    private static final EntityDataAccessor<Long> DATA_ATTACK_DELAY;
    @NotNull
    private static final EntityDataAccessor<Boolean> DATA_STUCK;
    @NotNull
    private static final EntityDataAccessor<Boolean> DYING;
    private static final int MACE_PARRY_WINDOW = 80;

    public IntegrityPhase3Entity(@NotNull EntityType<IntegrityPhase3Entity> entityType, @NotNull Level level) {
        Intrinsics.checkNotNullParameter(entityType, (String)"entityType");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        super(entityType, level);
        this.noCulling = true;
        this.moveControl = new IntegMoveControl(this);
        this.attackDelay$delegate = this.entityData(DATA_ATTACK_DELAY);
        this.dying$delegate = this.entityData(DYING);
        this.isStuck$delegate = this.entityData(DATA_STUCK);
    }

    public boolean isPushedByFluid() {
        return false;
    }

    public final void setStuck(boolean stuck) {
        if (this.stuckStatus() != stuck) {
            this.setStuckStatus(stuck);
        }
    }

    @Nullable
    public final AttackType getPreviousAttack() {
        return this.previousAttack;
    }

    public final void setPreviousAttack(@Nullable AttackType attackType) {
        this.previousAttack = attackType;
    }

    public int getMaxFallDistance() {
        return 10;
    }

    public boolean isPersistenceRequired() {
        return true;
    }

    public boolean removeWhenFarAway(double distanceToClosestPlayer) {
        return false;
    }

    public boolean fireImmune() {
        return true;
    }

    @NotNull
    public AABB getBoundingBoxForCulling() {
        AABB aABB = super.getBoundingBoxForCulling().inflate(32.0);
        Intrinsics.checkNotNullExpressionValue((Object)aABB, (String)"inflate(...)");
        return aABB;
    }

    public boolean shouldRenderAtSqrDistance(double dist) {
        return true;
    }

    @JvmName(name="getAttackStateInternal")
    @NotNull
    public final Attack getAttackStateInternal() {
        EnumEntries<AttackType> enumEntries = AttackType.getEntries();
        Object object = this.entityData.get(DATA_ATTACK_ID);
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"get(...)");
        Object object2 = ATTACKS.get(enumEntries.get(((Number)object).intValue()));
        Intrinsics.checkNotNull((Object)object2);
        return (Attack)object2;
    }

    @JvmName(name="setAttackStateInternal")
    public final void setAttackStateInternal(@NotNull Attack value) {
        Intrinsics.checkNotNullParameter((Object)value, (String)"value");
        this.entityData.set(DATA_ATTACK_ID, (Object)value.getType().ordinal());
    }

    public final long getAttackDelay() {
        return ((Number)this.attackDelay$delegate.getValue((BaseMonster)this, $$delegatedProperties[0])).longValue();
    }

    public final void setAttackDelay(long l) {
        this.attackDelay$delegate.setValue((BaseMonster)this, $$delegatedProperties[0], (Object)l);
    }

    public final int getAttackTicks() {
        return this.attackTicks;
    }

    public final void setAttackTicks(int n) {
        this.attackTicks = n;
    }

    public final int getHurtFrames() {
        return this.hurtFrames;
    }

    public final void setHurtFrames(int n) {
        this.hurtFrames = n;
    }

    public final int getMaceParryCooldown() {
        return this.maceParryCooldown;
    }

    public final void setMaceParryCooldown(int n) {
        this.maceParryCooldown = n;
    }

    public final boolean getShotFireball() {
        return this.shotFireball;
    }

    public final void setShotFireball(boolean bl) {
        this.shotFireball = bl;
    }

    public final int getGroundAttackTimer() {
        return this.groundAttackTimer;
    }

    public final void setGroundAttackTimer(int n) {
        this.groundAttackTimer = n;
    }

    @Nullable
    public final BlockPos getGroundAttackTargetPos() {
        return this.groundAttackTargetPos;
    }

    public final void setGroundAttackTargetPos(@Nullable BlockPos blockPos) {
        this.groundAttackTargetPos = blockPos;
    }

    public final int getSwipeAttackTimer() {
        return this.swipeAttackTimer;
    }

    public final void setSwipeAttackTimer(int n) {
        this.swipeAttackTimer = n;
    }

    public final int getAoeAttackTimer() {
        return this.aoeAttackTimer;
    }

    public final void setAoeAttackTimer(int n) {
        this.aoeAttackTimer = n;
    }

    public final int getStuckTimer() {
        return this.stuckTimer;
    }

    public final void setStuckTimer(int n) {
        this.stuckTimer = n;
    }

    public final boolean getDying() {
        return (Boolean)this.dying$delegate.getValue((BaseMonster)this, $$delegatedProperties[1]);
    }

    public final void setDying(boolean bl) {
        this.dying$delegate.setValue((BaseMonster)this, $$delegatedProperties[1], (Object)bl);
    }

    @JvmName(name="stuckStatus")
    public final boolean stuckStatus() {
        return (Boolean)this.isStuck$delegate.getValue((BaseMonster)this, $$delegatedProperties[2]);
    }

    @JvmName(name="setStuckStatus")
    public final void setStuckStatus(boolean bl) {
        this.isStuck$delegate.setValue((BaseMonster)this, $$delegatedProperties[2], (Object)bl);
    }

    protected void registerGoals() {
        super.registerGoals();
        this.targetSelector.addGoal(0, (Goal)new HurtByTargetGoal((PathfinderMob)this, new Class[0]));
        this.targetSelector.addGoal(1, (Goal)new Phase3Goals.AlwaysTargetPlayerGoal((Mob)this));
        this.goalSelector.addGoal(0, (Goal)new Phase3Goals.MoveToTargetGoal(this, 0.75));
        this.goalSelector.addGoal(1, (Goal)new Phase3Goals.AttackSelectorGoal(this));
    }

    protected void defineSynchedData(@NotNull SynchedEntityData.Builder builder) {
        Intrinsics.checkNotNullParameter((Object)builder, (String)"builder");
        super.defineSynchedData(builder);
        builder.define(DATA_ATTACK_ID, (Object)AttackType.NOOP.ordinal());
        builder.define(DATA_ATTACK_DELAY, (Object)100L);
        builder.define(DATA_STUCK, (Object)false);
        builder.define(DYING, (Object)false);
    }

    public void addAdditionalSaveData(@NotNull CompoundTag compound) {
        Intrinsics.checkNotNullParameter((Object)compound, (String)"compound");
        super.addAdditionalSaveData(compound);
        compound.putInt("attack_id", this.getAttackStateInternal().getType().ordinal());
        compound.putLong("attack_delay", this.getAttackDelay());
        compound.putBoolean("is_stuck", this.stuckStatus());
        compound.putBoolean("dying", this.getDying());
    }

    protected void actuallyHurt(@NotNull DamageSource damageSource, float damageAmount) {
        Intrinsics.checkNotNullParameter((Object)damageSource, (String)"damageSource");
        if (this.getDying()) {
            return;
        }
        super.actuallyHurt(damageSource, damageAmount);
    }

    @Nullable
    protected SoundEvent getHurtSound(@NotNull DamageSource damageSource) {
        Intrinsics.checkNotNullParameter((Object)damageSource, (String)"damageSource");
        return null;
    }

    public boolean hurt(@NotNull DamageSource source, float amount) {
        boolean applied;
        Intrinsics.checkNotNullParameter((Object)source, (String)"source");
        if (this.getDying()) {
            return false;
        }
        if (source.is(DamageTypes.FELL_OUT_OF_WORLD) || source.is(DamageTypes.GENERIC_KILL)) {
            this.die(source);
            return false;
        }
        Entity sourceEnt = source.getEntity();
        if (this.hurtFrames > 0) {
            return false;
        }
        if (sourceEnt instanceof Player && this.isMaceAttack((Player)sourceEnt)) {
            if (this.maceParryCooldown > 0) {
                this.onMaceParried((Player)sourceEnt);
                return false;
            }
            this.maceParryCooldown = 80;
        }
        if (sourceEnt instanceof IntegFireballEntity) {
            boolean applied2 = super.hurt(source, 50.0f);
            if (applied2 && this.stuckStatus()) {
                this.hurtFrames = 10;
            } else if (applied2) {
                this.hurtFrames = 30;
            }
            return applied2;
        }
        boolean bl = sourceEnt instanceof Player && (this.stuckStatus() ? super.hurt(source, RangesKt.coerceAtMost((float)(amount * (float)3), (float)40.0f)) : super.hurt(source, RangesKt.coerceAtMost((float)(amount / (float)2), (float)10.0f))) ? true : (applied = false);
        if (applied && this.stuckStatus()) {
            this.hurtFrames = 10;
        } else if (applied) {
            this.hurtFrames = 30;
        }
        return applied;
    }

    private final boolean isMaceAttack(Player player) {
        ItemStack stack = player.getMainHandItem();
        return stack.is(Items.MACE) && !player.isFallFlying() && player.fallDistance >= 1.5f;
    }

    private final void onMaceParried(Player player) {
        ItemStack mainHand = player.getMainHandItem();
        if (mainHand.is(Items.MACE) && mainHand.isDamageableItem()) {
            mainHand.setDamageValue(mainHand.getMaxDamage());
            this.level().playSound(player, player.blockPosition(), SoundEvents.ITEM_BREAK, SoundSource.HOSTILE, 1.0f, 1.0f);
            player.onEquippedItemBroken(mainHand.getItem(), EquipmentSlot.MAINHAND);
        }
    }

    public void readAdditionalSaveData(@NotNull CompoundTag compound) {
        Intrinsics.checkNotNullParameter((Object)compound, (String)"compound");
        super.readAdditionalSaveData(compound);
        if (compound.contains("attack_id")) {
            Object object;
            int ordinal = compound.getInt("attack_id");
            IntegrityPhase3Entity integrityPhase3Entity = this;
            ImmutableMap<AttackType, Attack> immutableMap = ATTACKS;
            List list = (List)AttackType.getEntries();
            boolean bl = 0 <= ordinal ? ordinal < list.size() : false;
            if (bl) {
                object = list.get(ordinal);
            } else {
                int n = ordinal;
                ImmutableMap<AttackType, Attack> immutableMap2 = immutableMap;
                IntegrityPhase3Entity integrityPhase3Entity2 = integrityPhase3Entity;
                boolean bl2 = false;
                AttackType attackType = AttackType.NOOP;
                integrityPhase3Entity = integrityPhase3Entity2;
                immutableMap = immutableMap2;
                object = attackType;
            }
            Object object2 = immutableMap.get(object);
            Intrinsics.checkNotNull((Object)object2);
            integrityPhase3Entity.setAttackStateInternal((Attack)object2);
        }
        if (compound.contains("attack_delay")) {
            this.setAttackDelay(compound.getLong("attack_delay"));
        }
        if (compound.contains("is_stuck")) {
            this.setStuckStatus(compound.getBoolean("is_stuck"));
        }
        if (compound.contains("dying")) {
            this.setDying(compound.getBoolean("dying"));
        }
    }

    public void tick() {
        super.tick();
        if (this.getAttackDelay() > 0L) {
            long l = this.getAttackDelay();
            this.setAttackDelay(l + -1L);
        }
        SideUtil.clientSide((Entity)((Entity)this), () -> IntegrityPhase3Entity.tick$lambda$0(this));
        if (this.hurtFrames > 0) {
            int n = this.hurtFrames;
            this.hurtFrames = n + -1;
        }
        if (this.maceParryCooldown > 0) {
            int n = this.maceParryCooldown;
            this.maceParryCooldown = n + -1;
        }
        if (this.stuckTimer > 0) {
            int n = this.stuckTimer;
            this.stuckTimer = n + -1;
            if (this.stuckTimer <= 0) {
                this.setStuck(false);
                this.stuckTimer = 0;
            }
        }
        if (this.stuckStatus() && this.stuckTimer == 0 && Intrinsics.areEqual((Object)this.getAttackStateInternal(), (Object)ATTACKS.get((Object)AttackType.NOOP))) {
            this.stuckTimer = 100;
        }
        if (this.getAttackDelay() <= 0L) {
            int n = this.attackTicks;
            this.attackTicks = n + 1;
            this.getAttackStateInternal().tick(this);
            if ((long)this.attackTicks >= this.getAttackStateInternal().length(this)) {
                this.finishAttack();
            }
        }
    }

    public final void finishAttack() {
        this.getAttackStateInternal().finish(this);
        this.setAttackDelay(this.getAttackStateInternal().getAttackCooldown());
        this.attackTicks = 0;
        this.groundAttackTimer = 0;
        this.setStuck(false);
        Object object = ATTACKS.get((Object)AttackType.NOOP);
        Intrinsics.checkNotNull((Object)object);
        this.setAttackStateInternal((Attack)object);
    }

    public void die(@NotNull DamageSource damageSource) {
        Intrinsics.checkNotNullParameter((Object)damageSource, (String)"damageSource");
        if (this.getDying()) {
            return;
        }
        this.setDying(true);
        this.setTarget(null);
        this.finishAttack();
        this.moveTo(Phase3.Companion.getCENTER());
        LevelUtil.getQueue((Level)this.getLevel()).add(298L, () -> IntegrityPhase3Entity.die$lambda$0(this, damageSource));
    }

    protected void tickDeath() {
        int n = this.deathTime;
        this.deathTime = n + 1;
        if (this.deathTime >= 298 && !this.level().isClientSide() && !this.isRemoved()) {
            this.level().broadcastEntityEvent((Entity)this, (byte)60);
            this.remove(Entity.RemovalReason.KILLED);
        }
    }

    public void registerControllers(@NotNull AnimatableManager.ControllerRegistrar reg) {
        Intrinsics.checkNotNullParameter((Object)reg, (String)"reg");
        UnmodifiableIterator unmodifiableIterator = ((ImmutableCollection)ATTACKS.values()).iterator();
        Intrinsics.checkNotNullExpressionValue((Object)unmodifiableIterator, (String)"iterator(...)");
        UnmodifiableIterator unmodifiableIterator2 = unmodifiableIterator;
        while (unmodifiableIterator2.hasNext()) {
            Attack attack = (Attack)unmodifiableIterator2.next();
            reg.add(new AnimationController((GeoAnimatable)this, "attack_" + attack.getType().name(), 0, arg_0 -> IntegrityPhase3Entity.registerControllers$lambda$0(this, attack, arg_0)).setCustomInstructionKeyframeHandler(arg_0 -> IntegrityPhase3Entity.registerControllers$lambda$1(this, arg_0)));
        }
        reg.add(new AnimationController((GeoAnimatable)this, "dying", 0, arg_0 -> IntegrityPhase3Entity.registerControllers$lambda$2(this, arg_0)));
    }

    @NotNull
    public Pose getPose() {
        return Pose.STANDING;
    }

    private static final Object tick$lambda$0(IntegrityPhase3Entity this$0) {
        if (!ClientVariables.INSTANCE.has(256L)) {
            LocalPlayer localPlayer = ClientDSLKt.getMC().player;
            if (localPlayer == null) {
                return false;
            }
            LocalPlayer player = localPlayer;
            if (PlayerExt.INSTANCE.isEntityInFovCone((Player)player, (Entity)this$0, Double.valueOf(((Number)ClientDSLKt.getMC().options.fov().get()).intValue()))) {
                ClientVariables.INSTANCE.set(256L);
            }
        }
        return Unit.INSTANCE;
    }

    private static final Unit die$lambda$0(IntegrityPhase3Entity this$0, DamageSource $damageSource) {
        super.die($damageSource);
        return Unit.INSTANCE;
    }

    private static final PlayState registerControllers$lambda$0(IntegrityPhase3Entity this$0, Attack $attack, AnimationState it) {
        if (((IntegrityPhase3Entity)it.getAnimatable()).getDying()) {
            return PlayState.STOP;
        }
        Integer n = (Integer)this$0.entityData.get(DATA_ATTACK_ID);
        int n2 = $attack.getType().ordinal();
        if (n == null || n != n2) {
            return PlayState.STOP;
        }
        Intrinsics.checkNotNull((Object)it);
        return $attack.animate((AnimationState<IntegrityPhase3Entity>)it);
    }

    private static final void registerControllers$lambda$1(IntegrityPhase3Entity this$0, CustomInstructionKeyframeEvent event) {
        if (Intrinsics.areEqual((Object)event.getKeyframeData().getInstructions(), (Object)"ballin;")) {
            GeoBone geoBone = IntegrityPhase3Model.Companion.getINSTANCE().getBone("righttendrils5").orElse(null);
            if (geoBone == null) {
                return;
            }
            GeoBone bone = geoBone;
            Vector3d worldPos = bone.getWorldPosition();
            int n = this$0.getId();
            Intrinsics.checkNotNull((Object)worldPos);
            PacketSender.INSTANCE.sendToServer((CustomPacketPayload)TBSPackets.FIREBALL_PACKET.of(new FireballEndecData(n, worldPos)), new CustomPacketPayload[0]);
        }
    }

    private static final PlayState registerControllers$lambda$2(IntegrityPhase3Entity this$0, AnimationState it) {
        PlayState playState;
        if (((IntegrityPhase3Entity)it.getAnimatable()).getDying()) {
            Entity entity = (Entity)this$0;
            Intrinsics.checkNotNull((Object)it);
            playState = GeckoUtil.hold((Entity)entity, (AnimationState)it, (String)"defeatTentacleYoink");
        } else {
            playState = PlayState.STOP;
        }
        return playState;
    }

    static {
        KProperty[] kPropertyArray = new KProperty[]{Reflection.mutableProperty1((MutablePropertyReference1)((MutablePropertyReference1)new MutablePropertyReference1Impl(IntegrityPhase3Entity.class, "attackDelay", "getAttackDelay()J", 0))), Reflection.mutableProperty1((MutablePropertyReference1)((MutablePropertyReference1)new MutablePropertyReference1Impl(IntegrityPhase3Entity.class, "dying", "getDying()Z", 0))), Reflection.mutableProperty1((MutablePropertyReference1)((MutablePropertyReference1)new MutablePropertyReference1Impl(IntegrityPhase3Entity.class, "isStuck", "stuckStatus()Z", 0)))};
        $$delegatedProperties = kPropertyArray;
        Companion = new Companion(null);
        Attack[] attackArray = new Attack[]{new NoopAttack(), new GroundAttack(), new FireballAttack(), new TentacleSwipeAttack(), new GravityAttack(), new TentaclesAttack()};
        ImmutableMap immutableMap = IntegrityPhase3Entity.Companion.attacks(attackArray);
        Intrinsics.checkNotNullExpressionValue((Object)immutableMap, (String)"access$attacks(...)");
        ATTACKS = immutableMap;
        EntityDataAccessor entityDataAccessor = SynchedEntityData.defineId(IntegrityPhase3Entity.class, (EntityDataSerializer)EntityDataSerializers.INT);
        Intrinsics.checkNotNullExpressionValue((Object)entityDataAccessor, (String)"defineId(...)");
        DATA_ATTACK_ID = entityDataAccessor;
        EntityDataAccessor entityDataAccessor2 = SynchedEntityData.defineId(IntegrityPhase3Entity.class, (EntityDataSerializer)EntityDataSerializers.LONG);
        Intrinsics.checkNotNullExpressionValue((Object)entityDataAccessor2, (String)"defineId(...)");
        DATA_ATTACK_DELAY = entityDataAccessor2;
        EntityDataAccessor entityDataAccessor3 = SynchedEntityData.defineId(IntegrityPhase3Entity.class, (EntityDataSerializer)EntityDataSerializers.BOOLEAN);
        Intrinsics.checkNotNullExpressionValue((Object)entityDataAccessor3, (String)"defineId(...)");
        DATA_STUCK = entityDataAccessor3;
        EntityDataAccessor entityDataAccessor4 = SynchedEntityData.defineId(IntegrityPhase3Entity.class, (EntityDataSerializer)EntityDataSerializers.BOOLEAN);
        Intrinsics.checkNotNullExpressionValue((Object)entityDataAccessor4, (String)"defineId(...)");
        DYING = entityDataAccessor4;
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003Ja\u0010\u0004\u001aB\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u0006\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\b0\b \u0007* \u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u0006\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\b0\b\u0018\u00010\u00050\u00052\u0012\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\t\"\u00020\bH\u0002\u00a2\u0006\u0002\u0010\nR \u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b0\u0005X\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0010X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2={"Lnet/thebrokenscript/entity/integrity/phase3/IntegrityPhase3Entity$Companion;", "", "<init>", "()V", "attacks", "Lcom/google/common/collect/ImmutableMap;", "Lnet/thebrokenscript/entity/integrity/phase3/attacks/AttackType;", "kotlin.jvm.PlatformType", "Lnet/thebrokenscript/entity/integrity/phase3/attacks/Attack;", "", "([Lnet/thebrokenscript/entity/integrity/phase3/attacks/Attack;)Lcom/google/common/collect/ImmutableMap;", "ATTACKS", "getATTACKS$thebrokenscript_common", "()Lcom/google/common/collect/ImmutableMap;", "DATA_ATTACK_ID", "Lnet/minecraft/network/syncher/EntityDataAccessor;", "", "DATA_ATTACK_DELAY", "", "DATA_STUCK", "", "DYING", "MACE_PARRY_WINDOW", "thebrokenscript-common"})
    public static final class Companion {
        private Companion() {
        }

        private final ImmutableMap<AttackType, Attack> attacks(Attack ... attacks) {
            ImmutableMap.Builder builder;
            ImmutableMap.Builder $this$attacks_u24lambda_u240 = builder = ImmutableMap.builder();
            boolean bl = false;
            for (Attack attack : attacks) {
                $this$attacks_u24lambda_u240.put((Object)attack.getType(), (Object)attack);
            }
            return builder.build();
        }

        @NotNull
        public final ImmutableMap<AttackType, Attack> getATTACKS$thebrokenscript_common() {
            return ATTACKS;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

