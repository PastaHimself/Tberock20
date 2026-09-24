/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.ImmutableCollection
 *  com.google.common.collect.ImmutableMap
 *  com.google.common.collect.ImmutableMap$Builder
 *  com.google.common.collect.UnmodifiableIterator
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.enums.EnumEntries
 *  kotlin.jvm.JvmName
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.MutablePropertyReference1
 *  kotlin.jvm.internal.MutablePropertyReference1Impl
 *  kotlin.jvm.internal.Reflection
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.reflect.KProperty
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.network.protocol.common.custom.CustomPacketPayload
 *  net.minecraft.network.syncher.EntityDataAccessor
 *  net.minecraft.network.syncher.EntityDataSerializer
 *  net.minecraft.network.syncher.EntityDataSerializers
 *  net.minecraft.network.syncher.SynchedEntityData
 *  net.minecraft.network.syncher.SynchedEntityData$Builder
 *  net.minecraft.world.DifficultyInstance
 *  net.minecraft.world.damagesource.DamageSource
 *  net.minecraft.world.damagesource.DamageTypes
 *  net.minecraft.world.effect.MobEffects
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.Mob
 *  net.minecraft.world.entity.MobSpawnType
 *  net.minecraft.world.entity.PathfinderMob
 *  net.minecraft.world.entity.SpawnGroupData
 *  net.minecraft.world.entity.ai.goal.FloatGoal
 *  net.minecraft.world.entity.ai.goal.Goal
 *  net.minecraft.world.entity.ai.goal.LookAtPlayerGoal
 *  net.minecraft.world.entity.ai.goal.RandomStrollGoal
 *  net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal
 *  net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal
 *  net.minecraft.world.entity.ai.util.DefaultRandomPos
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.ServerLevelAccessor
 *  net.minecraft.world.phys.Vec3
 *  net.thebrokenscript.brokencore.api.dsl.EntityDataDelegate
 *  net.thebrokenscript.brokencore.api.dsl.GeckoUtil
 *  net.thebrokenscript.brokencore.api.entity.FinalizedSpawn
 *  net.thebrokenscript.brokencore.api.entity.base.BaseMonster
 *  net.thebrokenscript.brokencore.api.ext.JomlVecExtKt
 *  net.thebrokenscript.brokencore.api.network.PacketSender
 *  net.thebrokenscript.brokencore.api.platform.CancelProxy
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
package net.thebrokenscript.entity.fractured;

import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.UnmodifiableIterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KProperty;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializer;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.util.DefaultRandomPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.TheBrokenScript;
import net.thebrokenscript.api.entity.BaseFracturedEntity;
import net.thebrokenscript.brokencore.api.dsl.EntityDataDelegate;
import net.thebrokenscript.brokencore.api.dsl.GeckoUtil;
import net.thebrokenscript.brokencore.api.entity.FinalizedSpawn;
import net.thebrokenscript.brokencore.api.entity.base.BaseMonster;
import net.thebrokenscript.brokencore.api.ext.JomlVecExtKt;
import net.thebrokenscript.brokencore.api.network.PacketSender;
import net.thebrokenscript.brokencore.api.platform.CancelProxy;
import net.thebrokenscript.client.model.entity.FracturedModel;
import net.thebrokenscript.entity.fractured.JimAttackSelectorGoal;
import net.thebrokenscript.entity.fractured.attacks.AirLiftAttack;
import net.thebrokenscript.entity.fractured.attacks.JimAttack;
import net.thebrokenscript.entity.fractured.attacks.JimAttackType;
import net.thebrokenscript.entity.fractured.attacks.MoonRockTossAttack;
import net.thebrokenscript.entity.fractured.attacks.NoopAttack;
import net.thebrokenscript.entity.fractured.attacks.SlamAttack;
import net.thebrokenscript.entity.fractured.attacks.StompAttack;
import net.thebrokenscript.network.FracturedEndecData;
import net.thebrokenscript.registry.TBSDamageTypes;
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

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 K2\u00020\u00012\u00020\u0002:\u0001KB\u001d\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00000\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.H\u0014J\u0010\u0010/\u001a\u00020,2\u0006\u00100\u001a\u000201H\u0016J\u0010\u00102\u001a\u00020,2\u0006\u00100\u001a\u000201H\u0016J\b\u00103\u001a\u00020,H\u0016J\u0006\u00104\u001a\u00020,J\u0010\u00105\u001a\u00020,2\u0006\u00106\u001a\u000207H\u0016J4\u00108\u001a\u0004\u0018\u0001092\u0006\u0010\u0005\u001a\u00020:2\u0006\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020>2\b\u0010?\u001a\u0004\u0018\u0001092\u0006\u0010@\u001a\u00020AH\u0016J\b\u0010B\u001a\u00020,H\u0014J\u0010\u0010C\u001a\u00020,2\u0006\u0010D\u001a\u00020EH\u0016J\u0018\u0010F\u001a\u00020G2\u0006\u0010H\u001a\u0002072\u0006\u0010I\u001a\u00020(H\u0016J\u0006\u0010J\u001a\u00020GR$\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n8G@GX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR+\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u00118F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0019\u001a\u00020\u001aX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR+\u0010\u001f\u001a\u00020\u001a2\u0006\u0010\u0010\u001a\u00020\u001a8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\"\u0010\u0018\u001a\u0004\b \u0010\u001c\"\u0004\b!\u0010\u001eR+\u0010#\u001a\u00020\u001a2\u0006\u0010\u0010\u001a\u00020\u001a8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b&\u0010\u0018\u001a\u0004\b$\u0010\u001c\"\u0004\b%\u0010\u001eR\u0014\u0010'\u001a\u00020(X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b)\u0010*\u00a8\u0006L"}, d2={"Lnet/thebrokenscript/entity/fractured/FracturedEntity;", "Lnet/thebrokenscript/api/entity/BaseFracturedEntity;", "Lnet/thebrokenscript/brokencore/api/entity/FinalizedSpawn;", "type", "Lnet/minecraft/world/entity/EntityType;", "level", "Lnet/minecraft/world/level/Level;", "<init>", "(Lnet/minecraft/world/entity/EntityType;Lnet/minecraft/world/level/Level;)V", "value", "Lnet/thebrokenscript/entity/fractured/attacks/JimAttack;", "attack", "getAttackStateInternal", "()Lnet/thebrokenscript/entity/fractured/attacks/JimAttack;", "setAttackStateInternal", "(Lnet/thebrokenscript/entity/fractured/attacks/JimAttack;)V", "<set-?>", "", "attackDelay", "getAttackDelay", "()J", "setAttackDelay", "(J)V", "attackDelay$delegate", "Lnet/thebrokenscript/brokencore/api/dsl/EntityDataDelegate;", "attackTicks", "", "getAttackTicks", "()I", "setAttackTicks", "(I)V", "timesAttacked", "getTimesAttacked", "setTimesAttacked", "timesAttacked$delegate", "attackedCooldown", "getAttackedCooldown", "setAttackedCooldown", "attackedCooldown$delegate", "amountOfSA2AttacksNeeded", "", "getAmountOfSA2AttacksNeeded", "()F", "defineSynchedData", "", "builder", "Lnet/minecraft/network/syncher/SynchedEntityData$Builder;", "addAdditionalSaveData", "compound", "Lnet/minecraft/nbt/CompoundTag;", "readAdditionalSaveData", "tick", "finishAttack", "die", "damageSource", "Lnet/minecraft/world/damagesource/DamageSource;", "onFinalizeSpawn", "Lnet/minecraft/world/entity/SpawnGroupData;", "Lnet/minecraft/world/level/ServerLevelAccessor;", "difficulty", "Lnet/minecraft/world/DifficultyInstance;", "spawnType", "Lnet/minecraft/world/entity/MobSpawnType;", "spawnData", "event", "Lnet/thebrokenscript/brokencore/api/platform/CancelProxy;", "registerGoals", "registerControllers", "reg", "Lsoftware/bernie/geckolib/animation/AnimatableManager$ControllerRegistrar;", "hurt", "", "source", "amount", "checkForConditionsSub", "Companion", "thebrokenscript-common"})
@SourceDebugExtension(value={"SMAP\nFracturedEntity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FracturedEntity.kt\nnet/thebrokenscript/entity/fractured/FracturedEntity\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,320:1\n1#2:321\n*E\n"})
public final class FracturedEntity
extends BaseFracturedEntity
implements FinalizedSpawn {
    @NotNull
    public static final Companion Companion;
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;
    @NotNull
    private final EntityDataDelegate attackDelay$delegate;
    private int attackTicks;
    @NotNull
    private final EntityDataDelegate timesAttacked$delegate;
    @NotNull
    private final EntityDataDelegate attackedCooldown$delegate;
    private final float amountOfSA2AttacksNeeded;
    @NotNull
    private static final ImmutableMap<JimAttackType, JimAttack> ATTACKS;
    @NotNull
    private static final EntityDataAccessor<Integer> DATA_ATTACK_ID;
    @NotNull
    private static final EntityDataAccessor<Long> DATA_ATTACK_DELAY;
    private static final EntityDataAccessor<Integer> TIMES_ATTACKED;
    private static final EntityDataAccessor<Integer> ATTACKED_COOLDOWN;

    public FracturedEntity(@NotNull EntityType<FracturedEntity> type, @NotNull Level level) {
        Intrinsics.checkNotNullParameter(type, (String)"type");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        super(type, level);
        this.moveControl = new BaseFracturedEntity.RoamMoveControl(this);
        this.attackDelay$delegate = this.entityData(DATA_ATTACK_DELAY);
        EntityDataAccessor<Integer> entityDataAccessor = TIMES_ATTACKED;
        Intrinsics.checkNotNullExpressionValue(entityDataAccessor, (String)"TIMES_ATTACKED");
        this.timesAttacked$delegate = this.entityData(entityDataAccessor);
        EntityDataAccessor<Integer> entityDataAccessor2 = ATTACKED_COOLDOWN;
        Intrinsics.checkNotNullExpressionValue(entityDataAccessor2, (String)"ATTACKED_COOLDOWN");
        this.attackedCooldown$delegate = this.entityData(entityDataAccessor2);
        this.amountOfSA2AttacksNeeded = 6.0f;
    }

    @JvmName(name="getAttackStateInternal")
    @NotNull
    public final JimAttack getAttackStateInternal() {
        EnumEntries<JimAttackType> enumEntries = JimAttackType.getEntries();
        Object object = this.entityData.get(DATA_ATTACK_ID);
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"get(...)");
        Object object2 = ATTACKS.get(enumEntries.get(((Number)object).intValue()));
        Intrinsics.checkNotNull((Object)object2);
        return (JimAttack)object2;
    }

    @JvmName(name="setAttackStateInternal")
    public final void setAttackStateInternal(@NotNull JimAttack value) {
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

    public final int getTimesAttacked() {
        Object object = this.timesAttacked$delegate.getValue((BaseMonster)this, $$delegatedProperties[1]);
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"getValue(...)");
        return ((Number)object).intValue();
    }

    public final void setTimesAttacked(int n) {
        this.timesAttacked$delegate.setValue((BaseMonster)this, $$delegatedProperties[1], (Object)n);
    }

    public final int getAttackedCooldown() {
        Object object = this.attackedCooldown$delegate.getValue((BaseMonster)this, $$delegatedProperties[2]);
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"getValue(...)");
        return ((Number)object).intValue();
    }

    public final void setAttackedCooldown(int n) {
        this.attackedCooldown$delegate.setValue((BaseMonster)this, $$delegatedProperties[2], (Object)n);
    }

    public final float getAmountOfSA2AttacksNeeded() {
        return this.amountOfSA2AttacksNeeded;
    }

    @Override
    protected void defineSynchedData(@NotNull SynchedEntityData.Builder builder) {
        Intrinsics.checkNotNullParameter((Object)builder, (String)"builder");
        super.defineSynchedData(builder);
        builder.define(DATA_ATTACK_ID, (Object)JimAttackType.NOOP.ordinal());
        builder.define(DATA_ATTACK_DELAY, (Object)100L);
        builder.define(TIMES_ATTACKED, (Object)0);
        builder.define(ATTACKED_COOLDOWN, (Object)0);
    }

    @Override
    public void addAdditionalSaveData(@NotNull CompoundTag compound) {
        Intrinsics.checkNotNullParameter((Object)compound, (String)"compound");
        super.addAdditionalSaveData(compound);
        compound.putInt("attack_id", this.getAttackStateInternal().getType().ordinal());
        compound.putLong("attack_delay", this.getAttackDelay());
        compound.putInt("times_attacked", this.getTimesAttacked());
        compound.putInt("attacked_cooldown", this.getAttackedCooldown());
    }

    @Override
    public void readAdditionalSaveData(@NotNull CompoundTag compound) {
        Intrinsics.checkNotNullParameter((Object)compound, (String)"compound");
        super.readAdditionalSaveData(compound);
        if (compound.contains("attack_id")) {
            Object object;
            int ordinal = compound.getInt("attack_id");
            FracturedEntity fracturedEntity = this;
            ImmutableMap<JimAttackType, JimAttack> immutableMap = ATTACKS;
            List list = (List)JimAttackType.getEntries();
            boolean bl = 0 <= ordinal ? ordinal < list.size() : false;
            if (bl) {
                object = list.get(ordinal);
            } else {
                int n = ordinal;
                ImmutableMap<JimAttackType, JimAttack> immutableMap2 = immutableMap;
                FracturedEntity fracturedEntity2 = fracturedEntity;
                boolean bl2 = false;
                JimAttackType jimAttackType = JimAttackType.NOOP;
                fracturedEntity = fracturedEntity2;
                immutableMap = immutableMap2;
                object = jimAttackType;
            }
            Object object2 = immutableMap.get(object);
            Intrinsics.checkNotNull((Object)object2);
            fracturedEntity.setAttackStateInternal((JimAttack)object2);
        }
        if (compound.contains("attack_delay")) {
            this.setAttackDelay(compound.getLong("attack_delay"));
        }
        if (compound.contains("times_attacked")) {
            this.setTimesAttacked(compound.getInt("times_attacked"));
        }
        if (compound.contains("attacked_cooldown")) {
            this.setAttackedCooldown(compound.getInt("attacked_cooldown"));
        }
    }

    @Override
    public void tick() {
        super.tick();
        if (this.getAttackDelay() > 0L) {
            long l = this.getAttackDelay();
            this.setAttackDelay(l + -1L);
        }
        if (this.getAttackDelay() <= 0L) {
            int n = this.attackTicks;
            this.attackTicks = n + 1;
            this.getAttackStateInternal().tick(this);
            if ((long)this.attackTicks >= this.getAttackStateInternal().length(this)) {
                this.finishAttack();
            }
        }
        if (this.getAttackedCooldown() > 0) {
            int n = this.getAttackedCooldown();
            this.setAttackedCooldown(n + -1);
            this.clearFire();
            this.removeEffect(MobEffects.GLOWING);
        }
        if ((float)this.getTimesAttacked() >= this.amountOfSA2AttacksNeeded) {
            this.setCurrentState(BaseFracturedEntity.JimmyStates.DEFEATED);
        }
    }

    public final void finishAttack() {
        this.getAttackStateInternal().finish(this);
        this.setAttackDelay(this.getAttackStateInternal().getAttackCooldown());
        this.attackTicks = 0;
        Object object = ATTACKS.get((Object)JimAttackType.NOOP);
        Intrinsics.checkNotNull((Object)object);
        this.setAttackStateInternal((JimAttack)object);
    }

    public void die(@NotNull DamageSource damageSource) {
        Intrinsics.checkNotNullParameter((Object)damageSource, (String)"damageSource");
        this.finishAttack();
        super.die(damageSource);
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

    protected void registerGoals() {
        super.registerGoals();
        this.targetSelector.addGoal(1, (Goal)new NearestAttackableTargetGoal((Mob)this, Player.class, false, false));
        this.targetSelector.addGoal(1, (Goal)new HurtByTargetGoal((PathfinderMob)this, new Class[0]));
        this.goalSelector.addGoal(1, (Goal)new JimAttackSelectorGoal(this));
        this.goalSelector.addGoal(2, (Goal)new RandomStrollGoal(this){
            final /* synthetic */ FracturedEntity this$0;
            {
                this.this$0 = $receiver;
                super((PathfinderMob)$receiver, 0.4, 45);
            }

            public boolean canUse() {
                return super.canUse() && this.this$0.getTarget() == null;
            }

            protected Vec3 getPosition() {
                return DefaultRandomPos.getPos((PathfinderMob)this.mob, (int)85, (int)7);
            }
        });
        this.goalSelector.addGoal(3, (Goal)new LookAtPlayerGoal((Mob)this, Player.class, 400.0f, 5.0E-4f));
        this.goalSelector.addGoal(4, (Goal)new FloatGoal((Mob)this));
    }

    @Override
    public void registerControllers(@NotNull AnimatableManager.ControllerRegistrar reg) {
        Intrinsics.checkNotNullParameter((Object)reg, (String)"reg");
        UnmodifiableIterator unmodifiableIterator = ((ImmutableCollection)ATTACKS.values()).iterator();
        Intrinsics.checkNotNullExpressionValue((Object)unmodifiableIterator, (String)"iterator(...)");
        UnmodifiableIterator unmodifiableIterator2 = unmodifiableIterator;
        while (unmodifiableIterator2.hasNext()) {
            JimAttack attack = (JimAttack)unmodifiableIterator2.next();
            reg.add(new AnimationController((GeoAnimatable)this, "attack_" + attack.getType().name(), 0, arg_0 -> FracturedEntity.registerControllers$lambda$0(this, attack, arg_0)).setCustomInstructionKeyframeHandler(arg_0 -> FracturedEntity.registerControllers$lambda$1(this, arg_0)));
        }
        super.registerControllers(reg);
        reg.add(new AnimationController((GeoAnimatable)this, "death_controller", 0, arg_0 -> FracturedEntity.registerControllers$lambda$2(this, arg_0)));
    }

    @Override
    public boolean hurt(@NotNull DamageSource source, float amount) {
        Intrinsics.checkNotNullParameter((Object)source, (String)"source");
        if (this.getArrowCount() > 0) {
            this.setArrowCount(this.getArrowCount() - 1);
        }
        if (source.is(DamageTypes.ARROW)) {
            return this.getHitViaPart() && super.hurt(source, amount);
        }
        if (source.is(DamageTypes.IN_FIRE)) {
            return true;
        }
        if (source.is(DamageTypes.ON_FIRE)) {
            return true;
        }
        if (source.is(TBSDamageTypes.INSTANCE.getSUB_ANOM_2().getKey()) && this.checkForConditionsSub()) {
            this.clearFire();
            this.removeEffect(MobEffects.GLOWING);
            int n = this.getTimesAttacked();
            this.setTimesAttacked(n + 1);
            this.setAttackedCooldown(800);
            return true;
        }
        return false;
    }

    public final boolean checkForConditionsSub() {
        return this.getAttackedCooldown() <= 0;
    }

    private static final PlayState registerControllers$lambda$0(FracturedEntity this$0, JimAttack $attack, AnimationState it) {
        Integer n = (Integer)this$0.entityData.get(DATA_ATTACK_ID);
        int n2 = $attack.getType().ordinal();
        if (n == null || n != n2) {
            return PlayState.STOP;
        }
        Intrinsics.checkNotNull((Object)it);
        return $attack.animate((AnimationState<FracturedEntity>)it);
    }

    private static final void registerControllers$lambda$1(FracturedEntity this$0, CustomInstructionKeyframeEvent event) {
        block22: {
            String string = event.getKeyframeData().getInstructions();
            if (string == null) break block22;
            int n = -1;
            switch (string.hashCode()) {
                case 79966326: {
                    if (string.equals("Slam;")) {
                        n = 1;
                    }
                    break;
                }
                case -1553272052: {
                    if (string.equals("DefensiveRockRelease;")) {
                        n = 2;
                    }
                    break;
                }
                case -996998140: {
                    if (string.equals("OffenseRockThrow;")) {
                        n = 3;
                    }
                    break;
                }
                case 1972011154: {
                    if (string.equals("SingleStomp;")) {
                        n = 4;
                    }
                    break;
                }
            }
            switch (n) {
                case 3: {
                    GeoBone geoBone = FracturedModel.Companion.getINSTANCE().getBone("ROCK").orElse(null);
                    if (geoBone == null) {
                        return;
                    }
                    GeoBone bone = geoBone;
                    Vector3d worldPos = bone.getWorldPosition();
                    int n2 = this$0.getId();
                    Intrinsics.checkNotNull((Object)worldPos);
                    PacketSender.INSTANCE.sendToServer((CustomPacketPayload)TBSPackets.ROCK_THROW_PACKET.of(new FracturedEndecData(n2, worldPos)), new CustomPacketPayload[0]);
                    break;
                }
                case 1: {
                    GeoBone geoBone = FracturedModel.Companion.getINSTANCE().getBone("right_l_claw").orElse(null);
                    if (geoBone == null) {
                        return;
                    }
                    GeoBone bone1 = geoBone;
                    GeoBone geoBone2 = FracturedModel.Companion.getINSTANCE().getBone("left_l_claw").orElse(null);
                    if (geoBone2 == null) {
                        return;
                    }
                    GeoBone bone2 = geoBone2;
                    Object[] objectArray = new Vector3d[]{bone1.getWorldPosition(), bone2.getWorldPosition()};
                    List worldPos = CollectionsKt.listOf((Object[])objectArray);
                    Vector3d vector3d = bone1.getWorldPosition();
                    Intrinsics.checkNotNullExpressionValue((Object)vector3d, (String)"getWorldPosition(...)");
                    Vec3 vec3 = JomlVecExtKt.toVec3((Vector3d)vector3d);
                    Vector3d vector3d2 = bone2.getWorldPosition();
                    Intrinsics.checkNotNullExpressionValue((Object)vector3d2, (String)"getWorldPosition(...)");
                    TheBrokenScript.LOGGER.debug("{}, {}", (Object)vec3, (Object)JomlVecExtKt.toVec3((Vector3d)vector3d2));
                    for (int bone = 0; bone < 2; ++bone) {
                        int n3 = this$0.getId();
                        Object e = worldPos.get(bone);
                        Intrinsics.checkNotNullExpressionValue(e, (String)"get(...)");
                        PacketSender.INSTANCE.sendToServer((CustomPacketPayload)TBSPackets.JIMMY_SLAM_HIT.of(new FracturedEndecData(n3, (Vector3d)e)), new CustomPacketPayload[0]);
                    }
                    break;
                }
                case 2: {
                    GeoBone geoBone = FracturedModel.Companion.getINSTANCE().getBone("ROCK").orElse(null);
                    if (geoBone == null) {
                        return;
                    }
                    GeoBone bone = geoBone;
                    Vector3d worldPos = bone.getWorldPosition();
                    int n4 = this$0.getId();
                    Intrinsics.checkNotNull((Object)worldPos);
                    PacketSender.INSTANCE.sendToServer((CustomPacketPayload)TBSPackets.ROCK_DROP_PACKET.of(new FracturedEndecData(n4, worldPos)), new CustomPacketPayload[0]);
                    break;
                }
                case 4: {
                    GeoBone geoBone = FracturedModel.Companion.getINSTANCE().getBone("right_f_tarsus").orElse(null);
                    if (geoBone == null) {
                        return;
                    }
                    GeoBone bone = geoBone;
                    Vector3d worldPos = bone.getWorldPosition();
                    int n5 = this$0.getId();
                    Intrinsics.checkNotNull((Object)worldPos);
                    PacketSender.INSTANCE.sendToServer((CustomPacketPayload)TBSPackets.JIMMY_BIG_STOMP.of(new FracturedEndecData(n5, worldPos)), new CustomPacketPayload[0]);
                }
            }
        }
    }

    private static final PlayState registerControllers$lambda$2(FracturedEntity this$0, AnimationState event) {
        if (this$0.getCurrentState() == BaseFracturedEntity.JimmyStates.DEFEATED) {
            Entity entity = (Entity)this$0;
            AnimationController animationController = event.getController();
            Intrinsics.checkNotNullExpressionValue((Object)animationController, (String)"getController(...)");
            GeckoUtil.once((Entity)entity, (AnimationController)animationController, (String)"Loss");
            return PlayState.CONTINUE;
        }
        return PlayState.STOP;
    }

    static {
        KProperty[] kPropertyArray = new KProperty[]{Reflection.mutableProperty1((MutablePropertyReference1)((MutablePropertyReference1)new MutablePropertyReference1Impl(FracturedEntity.class, "attackDelay", "getAttackDelay()J", 0))), Reflection.mutableProperty1((MutablePropertyReference1)((MutablePropertyReference1)new MutablePropertyReference1Impl(FracturedEntity.class, "timesAttacked", "getTimesAttacked()I", 0))), Reflection.mutableProperty1((MutablePropertyReference1)((MutablePropertyReference1)new MutablePropertyReference1Impl(FracturedEntity.class, "attackedCooldown", "getAttackedCooldown()I", 0)))};
        $$delegatedProperties = kPropertyArray;
        Companion = new Companion(null);
        JimAttack[] jimAttackArray = new JimAttack[]{new NoopAttack(), new StompAttack(), new SlamAttack(), new MoonRockTossAttack(), new AirLiftAttack()};
        ImmutableMap immutableMap = FracturedEntity.Companion.attacks(jimAttackArray);
        Intrinsics.checkNotNullExpressionValue((Object)immutableMap, (String)"access$attacks(...)");
        ATTACKS = immutableMap;
        EntityDataAccessor entityDataAccessor = SynchedEntityData.defineId(FracturedEntity.class, (EntityDataSerializer)EntityDataSerializers.INT);
        Intrinsics.checkNotNullExpressionValue((Object)entityDataAccessor, (String)"defineId(...)");
        DATA_ATTACK_ID = entityDataAccessor;
        EntityDataAccessor entityDataAccessor2 = SynchedEntityData.defineId(FracturedEntity.class, (EntityDataSerializer)EntityDataSerializers.LONG);
        Intrinsics.checkNotNullExpressionValue((Object)entityDataAccessor2, (String)"defineId(...)");
        DATA_ATTACK_DELAY = entityDataAccessor2;
        TIMES_ATTACKED = SynchedEntityData.defineId(FracturedEntity.class, (EntityDataSerializer)EntityDataSerializers.INT);
        ATTACKED_COOLDOWN = SynchedEntityData.defineId(FracturedEntity.class, (EntityDataSerializer)EntityDataSerializers.INT);
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003Ja\u0010\u0004\u001aB\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u0006\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\b0\b \u0007* \u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u0006\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\b0\b\u0018\u00010\u00050\u00052\u0012\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\t\"\u00020\bH\u0002\u00a2\u0006\u0002\u0010\nR \u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b0\u0005X\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R2\u0010\u0013\u001a&\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00100\u0010 \u0007*\u0012\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00100\u0010\u0018\u00010\u000f0\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R2\u0010\u0014\u001a&\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00100\u0010 \u0007*\u0012\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00100\u0010\u0018\u00010\u000f0\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2={"Lnet/thebrokenscript/entity/fractured/FracturedEntity$Companion;", "", "<init>", "()V", "attacks", "Lcom/google/common/collect/ImmutableMap;", "Lnet/thebrokenscript/entity/fractured/attacks/JimAttackType;", "kotlin.jvm.PlatformType", "Lnet/thebrokenscript/entity/fractured/attacks/JimAttack;", "", "([Lnet/thebrokenscript/entity/fractured/attacks/JimAttack;)Lcom/google/common/collect/ImmutableMap;", "ATTACKS", "getATTACKS$thebrokenscript_common", "()Lcom/google/common/collect/ImmutableMap;", "DATA_ATTACK_ID", "Lnet/minecraft/network/syncher/EntityDataAccessor;", "", "DATA_ATTACK_DELAY", "", "TIMES_ATTACKED", "ATTACKED_COOLDOWN", "thebrokenscript-common"})
    public static final class Companion {
        private Companion() {
        }

        private final ImmutableMap<JimAttackType, JimAttack> attacks(JimAttack ... attacks) {
            ImmutableMap.Builder builder;
            ImmutableMap.Builder $this$attacks_u24lambda_u240 = builder = ImmutableMap.builder();
            boolean bl = false;
            for (JimAttack attack : attacks) {
                $this$attacks_u24lambda_u240.put((Object)attack.getType(), (Object)attack);
            }
            return builder.build();
        }

        @NotNull
        public final ImmutableMap<JimAttackType, JimAttack> getATTACKS$thebrokenscript_common() {
            return ATTACKS;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

