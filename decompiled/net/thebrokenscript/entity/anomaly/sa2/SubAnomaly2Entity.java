/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.serialization.Dynamic
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.collections.IntIterator
 *  kotlin.collections.SetsKt
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.MutablePropertyReference1
 *  kotlin.jvm.internal.MutablePropertyReference1Impl
 *  kotlin.jvm.internal.Reflection
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.random.Random
 *  kotlin.ranges.IntRange
 *  kotlin.reflect.KProperty
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.network.syncher.EntityDataAccessor
 *  net.minecraft.network.syncher.EntityDataSerializer
 *  net.minecraft.network.syncher.EntityDataSerializers
 *  net.minecraft.network.syncher.SynchedEntityData
 *  net.minecraft.network.syncher.SynchedEntityData$Builder
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.util.Mth
 *  net.minecraft.world.DifficultyInstance
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.Mob
 *  net.minecraft.world.entity.MobSpawnType
 *  net.minecraft.world.entity.SpawnGroupData
 *  net.minecraft.world.entity.ai.Brain
 *  net.minecraft.world.entity.ai.Brain$Provider
 *  net.minecraft.world.entity.ai.attributes.AttributeSupplier$Builder
 *  net.minecraft.world.entity.ai.attributes.Attributes
 *  net.minecraft.world.entity.ai.control.FlyingMoveControl
 *  net.minecraft.world.entity.ai.control.MoveControl
 *  net.minecraft.world.entity.ai.navigation.FlyingPathNavigation
 *  net.minecraft.world.entity.ai.navigation.GroundPathNavigation
 *  net.minecraft.world.entity.ai.navigation.PathNavigation
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.level.ServerLevelAccessor
 *  net.minecraft.world.level.block.Block
 *  net.minecraft.world.level.block.Blocks
 *  net.thebrokenscript.brokencore.api.brain.util.BuiltBrain
 *  net.thebrokenscript.brokencore.api.dsl.AttributeUtil
 *  net.thebrokenscript.brokencore.api.dsl.EntityDataDelegate
 *  net.thebrokenscript.brokencore.api.dsl.GeckoUtil
 *  net.thebrokenscript.brokencore.api.entity.FinalizedSpawn
 *  net.thebrokenscript.brokencore.api.entity.base.BaseMonster
 *  net.thebrokenscript.brokencore.api.entity.base.UwuableMonster
 *  net.thebrokenscript.brokencore.api.platform.CancelProxy
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  software.bernie.geckolib.animatable.GeoAnimatable
 *  software.bernie.geckolib.animation.AnimatableManager$ControllerRegistrar
 *  software.bernie.geckolib.animation.AnimationController
 *  software.bernie.geckolib.animation.AnimationState
 *  software.bernie.geckolib.animation.PlayState
 */
package net.thebrokenscript.entity.anomaly.sa2;

import com.mojang.serialization.Dynamic;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.random.Random;
import kotlin.ranges.IntRange;
import kotlin.reflect.KProperty;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializer;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.Brain;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.FlyingMoveControl;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.navigation.FlyingPathNavigation;
import net.minecraft.world.entity.ai.navigation.GroundPathNavigation;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.thebrokenscript.api.entity.ai.anomaly2.SubAnomaly2Ai;
import net.thebrokenscript.brokencore.api.brain.util.BuiltBrain;
import net.thebrokenscript.brokencore.api.dsl.AttributeUtil;
import net.thebrokenscript.brokencore.api.dsl.EntityDataDelegate;
import net.thebrokenscript.brokencore.api.dsl.GeckoUtil;
import net.thebrokenscript.brokencore.api.entity.FinalizedSpawn;
import net.thebrokenscript.brokencore.api.entity.base.BaseMonster;
import net.thebrokenscript.brokencore.api.entity.base.UwuableMonster;
import net.thebrokenscript.brokencore.api.platform.CancelProxy;
import net.thebrokenscript.entity.anomaly.sa2.transforming.SubAnomaly2Type;
import net.thebrokenscript.entity.fractured.FracturedEntity;
import net.thebrokenscript.registry.TBSDamageTypes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.animation.AnimationController;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.animation.PlayState;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u00ae\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 f2\u00020\u00012\u00020\u0002:\u0001fB\u001f\u0012\u000e\u0010\u0003\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00000\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010;\u001a\u00020\u001a2\u0006\u0010<\u001a\u00020=H\u0016J\u0010\u0010>\u001a\u00020\u001a2\u0006\u0010?\u001a\u00020@H\u0016J\b\u0010A\u001a\u00020\u001aH\u0016J\b\u0010B\u001a\u00020\u001aH\u0016J\u0018\u0010C\u001a\u00020\u001a2\u0006\u0010\u0005\u001a\u00020D2\u0006\u0010E\u001a\u00020FH\u0016J\u0010\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020JH\u0016J\u0010\u0010K\u001a\u00020H2\u0006\u0010L\u001a\u00020MH\u0016J\u0010\u0010N\u001a\u00020H2\u0006\u0010L\u001a\u00020MH\u0016J\u0010\u0010O\u001a\u00020H2\u0006\u0010P\u001a\u00020QH\u0014J4\u0010R\u001a\u0004\u0018\u00010S2\u0006\u0010\u0005\u001a\u00020T2\u0006\u0010U\u001a\u00020V2\u0006\u0010W\u001a\u00020F2\b\u0010X\u001a\u0004\u0018\u00010S2\u0006\u0010Y\u001a\u00020ZH\u0016J\b\u0010[\u001a\u00020HH\u0016J\b\u0010\\\u001a\u00020HH\u0002J\u000e\u0010]\u001a\u00020\u001a2\u0006\u0010\u0005\u001a\u00020\u0006J\f\u0010^\u001a\u0006\u0012\u0002\b\u00030_H\u0014J\u0018\u0010`\u001a\u0006\u0012\u0002\b\u00030a2\n\u0010b\u001a\u0006\u0012\u0002\b\u00030cH\u0014J\u000e\u0010d\u001a\u00020H2\u0006\u0010e\u001a\u000205R+\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR+\u0010\u0012\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0011\u001a\u0004\b\u0013\u0010\r\"\u0004\b\u0014\u0010\u000fR+\u0010\u0016\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u0011\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000fR+\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\t\u001a\u00020\u001a8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b \u0010\u0011\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR+\u0010\"\u001a\u00020!2\u0006\u0010\t\u001a\u00020!8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b'\u0010\u0011\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R7\u0010*\u001a\b\u0012\u0004\u0012\u00020)0(2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020)0(8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b/\u0010\u0011\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R7\u00100\u001a\b\u0012\u0004\u0012\u00020)0(2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020)0(8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b3\u0010\u0011\u001a\u0004\b1\u0010,\"\u0004\b2\u0010.R$\u00106\u001a\u0002052\u0006\u00104\u001a\u0002058F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b7\u00108\"\u0004\b9\u0010:\u00a8\u0006g"}, d2={"Lnet/thebrokenscript/entity/anomaly/sa2/SubAnomaly2Entity;", "Lnet/thebrokenscript/brokencore/api/entity/base/UwuableMonster;", "Lnet/thebrokenscript/brokencore/api/entity/FinalizedSpawn;", "type", "Lnet/minecraft/world/entity/EntityType;", "level", "Lnet/minecraft/world/level/Level;", "<init>", "(Lnet/minecraft/world/entity/EntityType;Lnet/minecraft/world/level/Level;)V", "<set-?>", "", "variant", "getVariant", "()I", "setVariant", "(I)V", "variant$delegate", "Lnet/thebrokenscript/brokencore/api/dsl/EntityDataDelegate;", "fearFactor", "getFearFactor", "setFearFactor", "fearFactor$delegate", "transTimer", "getTransTimer", "setTransTimer", "transTimer$delegate", "", "hasTarget", "getHasTarget", "()Z", "setHasTarget", "(Z)V", "hasTarget$delegate", "", "lastPathAttempt", "getLastPathAttempt", "()J", "setLastPathAttempt", "(J)V", "lastPathAttempt$delegate", "Ljava/util/Optional;", "Ljava/util/UUID;", "fracturedInstance", "getFracturedInstance", "()Ljava/util/Optional;", "setFracturedInstance", "(Ljava/util/Optional;)V", "fracturedInstance$delegate", "targetUUID", "getTargetUUID", "setTargetUUID", "targetUUID$delegate", "value", "Lnet/thebrokenscript/entity/anomaly/sa2/transforming/SubAnomaly2Type;", "transState", "getTransState", "()Lnet/thebrokenscript/entity/anomaly/sa2/transforming/SubAnomaly2Type;", "setTransState", "(Lnet/thebrokenscript/entity/anomaly/sa2/transforming/SubAnomaly2Type;)V", "doHurtTarget", "target", "Lnet/minecraft/world/entity/Entity;", "removeWhenFarAway", "distanceToClosestPlayer", "", "fireImmune", "isPushable", "checkSpawnRules", "Lnet/minecraft/world/level/LevelAccessor;", "reason", "Lnet/minecraft/world/entity/MobSpawnType;", "registerControllers", "", "reg", "Lsoftware/bernie/geckolib/animation/AnimatableManager$ControllerRegistrar;", "addAdditionalSaveData", "compound", "Lnet/minecraft/nbt/CompoundTag;", "readAdditionalSaveData", "defineSynchedData", "builder", "Lnet/minecraft/network/syncher/SynchedEntityData$Builder;", "onFinalizeSpawn", "Lnet/minecraft/world/entity/SpawnGroupData;", "Lnet/minecraft/world/level/ServerLevelAccessor;", "difficulty", "Lnet/minecraft/world/DifficultyInstance;", "spawnType", "spawnData", "event", "Lnet/thebrokenscript/brokencore/api/platform/CancelProxy;", "tick", "doNothing", "isPlayerNear", "brainProvider", "Lnet/minecraft/world/entity/ai/Brain$Provider;", "makeBrain", "Lnet/minecraft/world/entity/ai/Brain;", "dynamic", "Lcom/mojang/serialization/Dynamic;", "swapMovementAfterTransform", "state", "Companion", "thebrokenscript-common"})
@SourceDebugExtension(value={"SMAP\nSubAnomaly2Entity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SubAnomaly2Entity.kt\nnet/thebrokenscript/entity/anomaly/sa2/SubAnomaly2Entity\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,297:1\n1#2:298\n1374#3:299\n1460#3,5:300\n2423#3,14:305\n*S KotlinDebug\n*F\n+ 1 SubAnomaly2Entity.kt\nnet/thebrokenscript/entity/anomaly/sa2/SubAnomaly2Entity\n*L\n162#1:299\n162#1:300,5\n210#1:305,14\n*E\n"})
public final class SubAnomaly2Entity
extends UwuableMonster
implements FinalizedSpawn {
    @NotNull
    public static final Companion Companion;
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;
    @NotNull
    private final EntityDataDelegate variant$delegate;
    @NotNull
    private final EntityDataDelegate fearFactor$delegate;
    @NotNull
    private final EntityDataDelegate transTimer$delegate;
    @NotNull
    private final EntityDataDelegate hasTarget$delegate;
    @NotNull
    private final EntityDataDelegate lastPathAttempt$delegate;
    @NotNull
    private final EntityDataDelegate fracturedInstance$delegate;
    @NotNull
    private final EntityDataDelegate targetUUID$delegate;
    @NotNull
    private static final EntityDataAccessor<Integer> VARIANT;
    @NotNull
    private static final EntityDataAccessor<Integer> FEAR_FACTOR;
    @NotNull
    private static final EntityDataAccessor<Integer> TRANS_STATE;
    @NotNull
    private static final EntityDataAccessor<Integer> TRANS_TIMER;
    @NotNull
    private static final EntityDataAccessor<Boolean> HAS_TARGET;
    @NotNull
    private static final EntityDataAccessor<Long> LAST_PATH_ATTEMPT;
    @NotNull
    private static final EntityDataAccessor<Optional<UUID>> FRACTURED_INSTANCE;
    @NotNull
    private static final EntityDataAccessor<Optional<UUID>> TARGET;
    @NotNull
    private static final Set<Block> TARGET_BLOCKS;

    public SubAnomaly2Entity(@NotNull EntityType<? extends SubAnomaly2Entity> type, @NotNull Level level) {
        Intrinsics.checkNotNullParameter(type, (String)"type");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        super(type, level);
        this.variant$delegate = this.entityData(VARIANT);
        this.fearFactor$delegate = this.entityData(FEAR_FACTOR);
        this.transTimer$delegate = this.entityData(TRANS_TIMER);
        this.hasTarget$delegate = this.entityData(HAS_TARGET);
        this.lastPathAttempt$delegate = this.entityData(LAST_PATH_ATTEMPT);
        this.fracturedInstance$delegate = this.entityData(FRACTURED_INSTANCE);
        this.targetUUID$delegate = this.entityData(TARGET);
        this.xpReward = 0;
        this.setNoAi(false);
        this.setPersistenceRequired();
    }

    public final int getVariant() {
        return ((Number)this.variant$delegate.getValue((BaseMonster)this, $$delegatedProperties[0])).intValue();
    }

    public final void setVariant(int n) {
        this.variant$delegate.setValue((BaseMonster)this, $$delegatedProperties[0], (Object)n);
    }

    public final int getFearFactor() {
        return ((Number)this.fearFactor$delegate.getValue((BaseMonster)this, $$delegatedProperties[1])).intValue();
    }

    public final void setFearFactor(int n) {
        this.fearFactor$delegate.setValue((BaseMonster)this, $$delegatedProperties[1], (Object)n);
    }

    public final int getTransTimer() {
        return ((Number)this.transTimer$delegate.getValue((BaseMonster)this, $$delegatedProperties[2])).intValue();
    }

    public final void setTransTimer(int n) {
        this.transTimer$delegate.setValue((BaseMonster)this, $$delegatedProperties[2], (Object)n);
    }

    public final boolean getHasTarget() {
        return (Boolean)this.hasTarget$delegate.getValue((BaseMonster)this, $$delegatedProperties[3]);
    }

    public final void setHasTarget(boolean bl) {
        this.hasTarget$delegate.setValue((BaseMonster)this, $$delegatedProperties[3], (Object)bl);
    }

    public final long getLastPathAttempt() {
        return ((Number)this.lastPathAttempt$delegate.getValue((BaseMonster)this, $$delegatedProperties[4])).longValue();
    }

    public final void setLastPathAttempt(long l) {
        this.lastPathAttempt$delegate.setValue((BaseMonster)this, $$delegatedProperties[4], (Object)l);
    }

    @NotNull
    public final Optional<UUID> getFracturedInstance() {
        return (Optional)this.fracturedInstance$delegate.getValue((BaseMonster)this, $$delegatedProperties[5]);
    }

    public final void setFracturedInstance(@NotNull Optional<UUID> optional) {
        Intrinsics.checkNotNullParameter(optional, (String)"<set-?>");
        this.fracturedInstance$delegate.setValue((BaseMonster)this, $$delegatedProperties[5], optional);
    }

    @NotNull
    public final Optional<UUID> getTargetUUID() {
        return (Optional)this.targetUUID$delegate.getValue((BaseMonster)this, $$delegatedProperties[6]);
    }

    public final void setTargetUUID(@NotNull Optional<UUID> optional) {
        Intrinsics.checkNotNullParameter(optional, (String)"<set-?>");
        this.targetUUID$delegate.setValue((BaseMonster)this, $$delegatedProperties[6], optional);
    }

    @NotNull
    public final SubAnomaly2Type getTransState() {
        Object object;
        List list = (List)SubAnomaly2Type.getEntries();
        Object object2 = this.entityData.get(TRANS_STATE);
        Intrinsics.checkNotNullExpressionValue((Object)object2, (String)"get(...)");
        int n = ((Number)object2).intValue();
        boolean bl = 0 <= n ? n < list.size() : false;
        if (bl) {
            object = list.get(n);
        } else {
            int it = n;
            boolean bl2 = false;
            object = SubAnomaly2Type.SPIDER;
        }
        return (SubAnomaly2Type)((Object)object);
    }

    public final void setTransState(@NotNull SubAnomaly2Type value) {
        Intrinsics.checkNotNullParameter((Object)((Object)value), (String)"value");
        this.entityData.set(TRANS_STATE, (Object)value.ordinal());
    }

    public boolean doHurtTarget(@NotNull Entity target) {
        Intrinsics.checkNotNullParameter((Object)target, (String)"target");
        return target.hurt(this.damageSources().source(TBSDamageTypes.INSTANCE.getSUB_ANOM_2().getKey()), (float)this.getAttributeValue(Attributes.ATTACK_DAMAGE));
    }

    public boolean removeWhenFarAway(double distanceToClosestPlayer) {
        return false;
    }

    public boolean fireImmune() {
        return true;
    }

    public boolean isPushable() {
        return false;
    }

    public boolean checkSpawnRules(@NotNull LevelAccessor level, @NotNull MobSpawnType reason) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)reason, (String)"reason");
        return true;
    }

    public void registerControllers(@NotNull AnimatableManager.ControllerRegistrar reg) {
        Intrinsics.checkNotNullParameter((Object)reg, (String)"reg");
        reg.add(new AnimationController((GeoAnimatable)this, "base", 0, arg_0 -> SubAnomaly2Entity.registerControllers$lambda$0(this, arg_0)));
    }

    public void addAdditionalSaveData(@NotNull CompoundTag compound) {
        Intrinsics.checkNotNullParameter((Object)compound, (String)"compound");
        super.addAdditionalSaveData(compound);
        compound.putInt("variant", this.getVariant());
        compound.putInt("fear_factor", this.getFearFactor());
        compound.putInt("trans_state", this.getTransState().ordinal());
        compound.putInt("trans_timer", this.getTransTimer());
        compound.putBoolean("has_target", this.getHasTarget());
        compound.putLong("last_path_attempt", this.getLastPathAttempt());
    }

    public void readAdditionalSaveData(@NotNull CompoundTag compound) {
        Intrinsics.checkNotNullParameter((Object)compound, (String)"compound");
        super.readAdditionalSaveData(compound);
        if (compound.contains("variant")) {
            this.setVariant(compound.getInt("variant"));
        }
        if (compound.contains("fear_factor")) {
            this.setFearFactor(compound.getInt("fear_factor"));
        }
        if (compound.contains("trans_timer")) {
            this.setTransTimer(compound.getInt("trans_timer"));
        }
        if (compound.contains("has_target")) {
            this.setHasTarget(compound.getBoolean("has_target"));
        }
        if (compound.contains("last_path_attempt")) {
            this.setLastPathAttempt(compound.getLong("last_path_attempt"));
        }
        if (compound.contains("trans_state")) {
            Object object;
            SubAnomaly2Entity subAnomaly2Entity = this;
            List list = (List)SubAnomaly2Type.getEntries();
            int n = compound.getInt("trans_state");
            boolean bl = 0 <= n ? n < list.size() : false;
            if (bl) {
                object = list.get(n);
            } else {
                int n2 = n;
                SubAnomaly2Entity subAnomaly2Entity2 = subAnomaly2Entity;
                boolean bl2 = false;
                object = SubAnomaly2Type.SPIDER;
                subAnomaly2Entity = subAnomaly2Entity2;
            }
            subAnomaly2Entity.setTransState((SubAnomaly2Type)((Object)object));
        }
    }

    protected void defineSynchedData(@NotNull SynchedEntityData.Builder builder) {
        Intrinsics.checkNotNullParameter((Object)builder, (String)"builder");
        super.defineSynchedData(builder);
        builder.define(VARIANT, (Object)1);
        builder.define(FEAR_FACTOR, (Object)0);
        builder.define(TRANS_STATE, (Object)SubAnomaly2Type.SPIDER.ordinal());
        builder.define(TRANS_TIMER, (Object)0);
        builder.define(HAS_TARGET, (Object)false);
        builder.define(LAST_PATH_ATTEMPT, (Object)0L);
        builder.define(FRACTURED_INSTANCE, Optional.empty());
        builder.define(TARGET, Optional.empty());
    }

    /*
     * WARNING - void declaration
     */
    @Nullable
    public SpawnGroupData onFinalizeSpawn(@NotNull ServerLevelAccessor level, @NotNull DifficultyInstance difficulty, @NotNull MobSpawnType spawnType, @Nullable SpawnGroupData spawnData, @NotNull CancelProxy event) {
        void $this$flatMapTo$iv$iv;
        void $this$flatMap$iv;
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)difficulty, (String)"difficulty");
        Intrinsics.checkNotNullParameter((Object)spawnType, (String)"spawnType");
        Intrinsics.checkNotNullParameter((Object)event, (String)"event");
        Object object = new Integer[]{1, 1, 1, 1};
        Collection collection = CollectionsKt.listOf((Object[])object);
        object = (Iterable)new IntRange(2, 6);
        Collection collection2 = collection;
        SubAnomaly2Entity subAnomaly2Entity = this;
        boolean $i$f$flatMap = false;
        void var8_10 = $this$flatMap$iv;
        Collection destination$iv$iv = new ArrayList();
        boolean $i$f$flatMapTo = false;
        Iterator iterator = $this$flatMapTo$iv$iv.iterator();
        while (iterator.hasNext()) {
            int element$iv$iv;
            int it = element$iv$iv = ((IntIterator)iterator).nextInt();
            boolean bl = false;
            Object[] objectArray = new Integer[]{it, it};
            Iterable list$iv$iv = CollectionsKt.listOf((Object[])objectArray);
            CollectionsKt.addAll((Collection)destination$iv$iv, (Iterable)list$iv$iv);
        }
        List list = (List)destination$iv$iv;
        subAnomaly2Entity.setVariant(((Number)CollectionsKt.random((Collection)CollectionsKt.plus((Collection)CollectionsKt.plus((Collection)collection2, (Iterable)list), (Object)7), (Random)((Random)Random.Default))).intValue());
        this.setFearFactor(6);
        this.setTransState(SubAnomaly2Type.SPIDER);
        return null;
    }

    public void tick() {
        super.tick();
        Brain brain = this.brain;
        Intrinsics.checkNotNull((Object)brain, (String)"null cannot be cast to non-null type net.minecraft.world.entity.ai.Brain<net.minecraft.world.entity.LivingEntity>");
        Brain brain2 = brain;
        Level level = this.level();
        if (level instanceof ServerLevel) {
            Object v3;
            Level level2 = this.level();
            Intrinsics.checkNotNull((Object)level2, (String)"null cannot be cast to non-null type net.minecraft.server.level.ServerLevel");
            brain2.tick((ServerLevel)level2, (LivingEntity)this);
            LivingEntity target = this.getTarget();
            this.setHasTarget(target != null);
            switch (WhenMappings.$EnumSwitchMapping$0[this.getTransState().ordinal()]) {
                case 1: {
                    int n = this.getTransTimer();
                    this.setTransTimer(n + -1);
                    if (this.getTransTimer() > 0) break;
                    this.setTransState(SubAnomaly2Type.STALK);
                    break;
                }
                case 2: {
                    int n = this.getTransTimer();
                    this.setTransTimer(n + -1);
                    if (this.getTransTimer() > 0) break;
                    this.setTransState(SubAnomaly2Type.DIVEBOMB);
                    break;
                }
                case 3: {
                    int n = this.getTransTimer();
                    this.setTransTimer(n + -1);
                    if (this.getTransTimer() > 0) break;
                    this.setTransState(SubAnomaly2Type.STALK);
                    break;
                }
                case 4: {
                    int n = this.getTransTimer();
                    this.setTransTimer(n + -1);
                    if (this.getTransTimer() > 0) break;
                    this.setTransState(SubAnomaly2Type.SPIDER);
                    break;
                }
                case 5: {
                    int n = this.getTransTimer();
                    this.setTransTimer(n + -1);
                    if (this.getTransTimer() > 0) break;
                    this.setTransState(SubAnomaly2Type.SPIDER);
                    break;
                }
                case 6: {
                    int n = this.getTransTimer();
                    this.setTransTimer(n + -1);
                    if (this.getTransTimer() > 0) break;
                    this.setTransState(SubAnomaly2Type.CANNONBALL);
                    break;
                }
                case 7: {
                    int n = this.getTransTimer();
                    this.setTransTimer(n + -1);
                    if (this.getTransTimer() > 0) break;
                    this.setTransState(SubAnomaly2Type.SPIDER);
                }
            }
            List list = this.level().getEntitiesOfClass(FracturedEntity.class, this.getBoundingBox().inflate(512.0));
            Intrinsics.checkNotNullExpressionValue((Object)list, (String)"getEntitiesOfClass(...)");
            Iterable $this$minByOrNull$iv = list;
            boolean $i$f$minByOrNull = false;
            Iterator iterator$iv = $this$minByOrNull$iv.iterator();
            if (!iterator$iv.hasNext()) {
                v3 = null;
            } else {
                Object minElem$iv = iterator$iv.next();
                if (!iterator$iv.hasNext()) {
                    v3 = minElem$iv;
                } else {
                    FracturedEntity it = (FracturedEntity)((Object)minElem$iv);
                    boolean bl = false;
                    double minValue$iv = it.distanceToSqr((Entity)this);
                    do {
                        Object e$iv = iterator$iv.next();
                        FracturedEntity it2 = (FracturedEntity)((Object)e$iv);
                        $i$a$-minByOrNull-SubAnomaly2Entity$tick$targetFractured$1 = false;
                        double v$iv = it2.distanceToSqr((Entity)this);
                        if (Double.compare(minValue$iv, v$iv) <= 0) continue;
                        minElem$iv = e$iv;
                        minValue$iv = v$iv;
                    } while (iterator$iv.hasNext());
                    v3 = minElem$iv;
                }
            }
            FracturedEntity targetFractured = v3;
            Optional<UUID> optional = targetFractured != null ? Optional.of(targetFractured.getUUID()) : Optional.empty();
            Intrinsics.checkNotNull(optional);
            this.setFracturedInstance(optional);
        }
    }

    private final void doNothing() {
    }

    public final boolean isPlayerNear(@NotNull Level level) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        List nearbyPlayers = level.getEntitiesOfClass(Player.class, this.getBoundingBox().inflate(8.0));
        Intrinsics.checkNotNull((Object)nearbyPlayers);
        return !((Collection)nearbyPlayers).isEmpty();
    }

    @NotNull
    protected Brain.Provider<?> brainProvider() {
        return SubAnomaly2Ai.INSTANCE.getAi().provider();
    }

    @NotNull
    protected Brain<?> makeBrain(@NotNull Dynamic<?> dynamic) {
        Intrinsics.checkNotNullParameter(dynamic, (String)"dynamic");
        Brain brain = super.makeBrain(dynamic);
        BuiltBrain<SubAnomaly2Entity> builtBrain = SubAnomaly2Ai.INSTANCE.getAi();
        Intrinsics.checkNotNull((Object)brain);
        builtBrain.addTo(brain);
        return brain;
    }

    public final void swapMovementAfterTransform(@NotNull SubAnomaly2Type state) {
        Intrinsics.checkNotNullParameter((Object)((Object)state), (String)"state");
        switch (WhenMappings.$EnumSwitchMapping$0[state.ordinal()]) {
            case 4: {
                this.setNoGravity(false);
                this.moveControl = new MoveControl((Mob)this);
                this.navigation = (PathNavigation)new GroundPathNavigation((Mob)this, this.level());
                break;
            }
            case 1: 
            case 2: {
                this.setNoGravity(true);
                this.moveControl = (MoveControl)new FlyingMoveControl((Mob)this, 20, true);
                this.navigation = (PathNavigation)new FlyingPathNavigation((Mob)this, this.level());
            }
        }
    }

    private static final PlayState registerControllers$lambda$0(SubAnomaly2Entity this$0, AnimationState state) {
        state.getController().setAnimationSpeed(1.0);
        state.getController().transitionLength(0);
        if (this$0.getTransState() == SubAnomaly2Type.STALK && this$0.tickCount < 42) {
            Entity entity = (Entity)this$0;
            AnimationController animationController = state.getController();
            Intrinsics.checkNotNullExpressionValue((Object)animationController, (String)"getController(...)");
            GeckoUtil.once((Entity)entity, (AnimationController)animationController, (String)"StalkSpawn");
        } else if (this$0.getTransState() == SubAnomaly2Type.SPIDER_TO_STALK) {
            Entity entity = (Entity)this$0;
            AnimationController animationController = state.getController();
            Intrinsics.checkNotNullExpressionValue((Object)animationController, (String)"getController(...)");
            GeckoUtil.once((Entity)entity, (AnimationController)animationController, (String)"SpiderTransformToStalk");
        } else if (this$0.getTransState() == SubAnomaly2Type.STALK_TO_DIVEBOMB) {
            Entity entity = (Entity)this$0;
            AnimationController animationController = state.getController();
            Intrinsics.checkNotNullExpressionValue((Object)animationController, (String)"getController(...)");
            GeckoUtil.once((Entity)entity, (AnimationController)animationController, (String)"StalkToDivebomb");
        } else if (this$0.getTransState() == SubAnomaly2Type.DIVEBOMB_TO_STALK) {
            Entity entity = (Entity)this$0;
            AnimationController animationController = state.getController();
            Intrinsics.checkNotNullExpressionValue((Object)animationController, (String)"getController(...)");
            GeckoUtil.once((Entity)entity, (AnimationController)animationController, (String)"DivebombToStalk");
        } else if (this$0.getTransState() == SubAnomaly2Type.DIVEBOMB) {
            Entity entity = (Entity)this$0;
            AnimationController animationController = state.getController();
            Intrinsics.checkNotNullExpressionValue((Object)animationController, (String)"getController(...)");
            GeckoUtil.once((Entity)entity, (AnimationController)animationController, (String)"Divebomb");
        } else if (this$0.getTransState() == SubAnomaly2Type.SPIDER_TO_CANNONBALL) {
            Entity entity = (Entity)this$0;
            AnimationController animationController = state.getController();
            Intrinsics.checkNotNullExpressionValue((Object)animationController, (String)"getController(...)");
            GeckoUtil.once((Entity)entity, (AnimationController)animationController, (String)"SpiderToCannonball");
        } else if (this$0.getTransState() == SubAnomaly2Type.CANNONBALL_TO_SPIDER) {
            Entity entity = (Entity)this$0;
            AnimationController animationController = state.getController();
            Intrinsics.checkNotNullExpressionValue((Object)animationController, (String)"getController(...)");
            GeckoUtil.once((Entity)entity, (AnimationController)animationController, (String)"CannonballToSpider");
        } else if (this$0.getTransState() == SubAnomaly2Type.CANNONBALL) {
            Entity entity = (Entity)this$0;
            AnimationController animationController = state.getController();
            Intrinsics.checkNotNullExpressionValue((Object)animationController, (String)"getController(...)");
            GeckoUtil.once((Entity)entity, (AnimationController)animationController, (String)"Cannonball");
        } else if (this$0.getTransState() == SubAnomaly2Type.STALK_TO_SPIDER) {
            Entity entity = (Entity)this$0;
            AnimationController animationController = state.getController();
            Intrinsics.checkNotNullExpressionValue((Object)animationController, (String)"getController(...)");
            GeckoUtil.once((Entity)entity, (AnimationController)animationController, (String)"StalkTransformToSpider");
        } else if (this$0.getTransState() == SubAnomaly2Type.MIMIC_TO_SPIDER) {
            Entity entity = (Entity)this$0;
            AnimationController animationController = state.getController();
            Intrinsics.checkNotNullExpressionValue((Object)animationController, (String)"getController(...)");
            GeckoUtil.once((Entity)entity, (AnimationController)animationController, (String)"MimicTransformToSpider");
        } else if (this$0.getTransState() == SubAnomaly2Type.SPIDER && this$0.getHasTarget() && this$0.isMoving()) {
            Entity entity = (Entity)this$0;
            AnimationController animationController = state.getController();
            Intrinsics.checkNotNullExpressionValue((Object)animationController, (String)"getController(...)");
            GeckoUtil.loop((Entity)entity, (AnimationController)animationController, (String)"SpiderChase");
        } else if (this$0.getTransState() == SubAnomaly2Type.STALK && this$0.getHasTarget() && this$0.isMoving()) {
            Entity entity = (Entity)this$0;
            AnimationController animationController = state.getController();
            Intrinsics.checkNotNullExpressionValue((Object)animationController, (String)"getController(...)");
            GeckoUtil.loop((Entity)entity, (AnimationController)animationController, (String)"StalkChase");
        } else if (this$0.getTransState() == SubAnomaly2Type.SPIDER && this$0.isMoving()) {
            Entity entity = (Entity)this$0;
            AnimationController animationController = state.getController();
            Intrinsics.checkNotNullExpressionValue((Object)animationController, (String)"getController(...)");
            GeckoUtil.loop((Entity)entity, (AnimationController)animationController, (String)"SpiderWalk");
            state.getController().transitionLength(5);
            state.getController().setAnimationSpeed(Mth.lerp((double)(this$0.getDeltaMovement().length() / 0.15), (double)0.0, (double)1.0));
        } else if (this$0.getTransState() == SubAnomaly2Type.BREAK_LIGHT) {
            Entity entity = (Entity)this$0;
            AnimationController animationController = state.getController();
            Intrinsics.checkNotNullExpressionValue((Object)animationController, (String)"getController(...)");
            GeckoUtil.once((Entity)entity, (AnimationController)animationController, (String)"attack");
        } else if (this$0.getTransState() == SubAnomaly2Type.STALK && this$0.isMoving()) {
            Entity entity = (Entity)this$0;
            AnimationController animationController = state.getController();
            Intrinsics.checkNotNullExpressionValue((Object)animationController, (String)"getController(...)");
            GeckoUtil.loop((Entity)entity, (AnimationController)animationController, (String)"StalkFlying");
        } else if (this$0.getTransState() == SubAnomaly2Type.STALK) {
            Entity entity = (Entity)this$0;
            AnimationController animationController = state.getController();
            Intrinsics.checkNotNullExpressionValue((Object)animationController, (String)"getController(...)");
            GeckoUtil.loop((Entity)entity, (AnimationController)animationController, (String)"StalkIdle");
        } else if (this$0.getTransState() == SubAnomaly2Type.SPIDER) {
            Entity entity = (Entity)this$0;
            AnimationController animationController = state.getController();
            Intrinsics.checkNotNullExpressionValue((Object)animationController, (String)"getController(...)");
            GeckoUtil.loop((Entity)entity, (AnimationController)animationController, (String)"SpiderIdle");
        }
        return PlayState.CONTINUE;
    }

    public static final /* synthetic */ AttributeSupplier.Builder access$attrs$s910975913(Function1 block) {
        return BaseMonster.attrs((Function1)block);
    }

    static {
        Object[] objectArray = new KProperty[]{Reflection.mutableProperty1((MutablePropertyReference1)((MutablePropertyReference1)new MutablePropertyReference1Impl(SubAnomaly2Entity.class, "variant", "getVariant()I", 0))), Reflection.mutableProperty1((MutablePropertyReference1)((MutablePropertyReference1)new MutablePropertyReference1Impl(SubAnomaly2Entity.class, "fearFactor", "getFearFactor()I", 0))), Reflection.mutableProperty1((MutablePropertyReference1)((MutablePropertyReference1)new MutablePropertyReference1Impl(SubAnomaly2Entity.class, "transTimer", "getTransTimer()I", 0))), Reflection.mutableProperty1((MutablePropertyReference1)((MutablePropertyReference1)new MutablePropertyReference1Impl(SubAnomaly2Entity.class, "hasTarget", "getHasTarget()Z", 0))), Reflection.mutableProperty1((MutablePropertyReference1)((MutablePropertyReference1)new MutablePropertyReference1Impl(SubAnomaly2Entity.class, "lastPathAttempt", "getLastPathAttempt()J", 0))), Reflection.mutableProperty1((MutablePropertyReference1)((MutablePropertyReference1)new MutablePropertyReference1Impl(SubAnomaly2Entity.class, "fracturedInstance", "getFracturedInstance()Ljava/util/Optional;", 0))), Reflection.mutableProperty1((MutablePropertyReference1)((MutablePropertyReference1)new MutablePropertyReference1Impl(SubAnomaly2Entity.class, "targetUUID", "getTargetUUID()Ljava/util/Optional;", 0)))};
        $$delegatedProperties = objectArray;
        Companion = new Companion(null);
        EntityDataAccessor entityDataAccessor = SynchedEntityData.defineId(SubAnomaly2Entity.class, (EntityDataSerializer)EntityDataSerializers.INT);
        Intrinsics.checkNotNullExpressionValue((Object)entityDataAccessor, (String)"defineId(...)");
        VARIANT = entityDataAccessor;
        EntityDataAccessor entityDataAccessor2 = SynchedEntityData.defineId(SubAnomaly2Entity.class, (EntityDataSerializer)EntityDataSerializers.INT);
        Intrinsics.checkNotNullExpressionValue((Object)entityDataAccessor2, (String)"defineId(...)");
        FEAR_FACTOR = entityDataAccessor2;
        EntityDataAccessor entityDataAccessor3 = SynchedEntityData.defineId(SubAnomaly2Entity.class, (EntityDataSerializer)EntityDataSerializers.INT);
        Intrinsics.checkNotNullExpressionValue((Object)entityDataAccessor3, (String)"defineId(...)");
        TRANS_STATE = entityDataAccessor3;
        EntityDataAccessor entityDataAccessor4 = SynchedEntityData.defineId(SubAnomaly2Entity.class, (EntityDataSerializer)EntityDataSerializers.INT);
        Intrinsics.checkNotNullExpressionValue((Object)entityDataAccessor4, (String)"defineId(...)");
        TRANS_TIMER = entityDataAccessor4;
        EntityDataAccessor entityDataAccessor5 = SynchedEntityData.defineId(SubAnomaly2Entity.class, (EntityDataSerializer)EntityDataSerializers.BOOLEAN);
        Intrinsics.checkNotNullExpressionValue((Object)entityDataAccessor5, (String)"defineId(...)");
        HAS_TARGET = entityDataAccessor5;
        EntityDataAccessor entityDataAccessor6 = SynchedEntityData.defineId(SubAnomaly2Entity.class, (EntityDataSerializer)EntityDataSerializers.LONG);
        Intrinsics.checkNotNullExpressionValue((Object)entityDataAccessor6, (String)"defineId(...)");
        LAST_PATH_ATTEMPT = entityDataAccessor6;
        EntityDataAccessor entityDataAccessor7 = SynchedEntityData.defineId(SubAnomaly2Entity.class, (EntityDataSerializer)EntityDataSerializers.OPTIONAL_UUID);
        Intrinsics.checkNotNullExpressionValue((Object)entityDataAccessor7, (String)"defineId(...)");
        FRACTURED_INSTANCE = entityDataAccessor7;
        EntityDataAccessor entityDataAccessor8 = SynchedEntityData.defineId(SubAnomaly2Entity.class, (EntityDataSerializer)EntityDataSerializers.OPTIONAL_UUID);
        Intrinsics.checkNotNullExpressionValue((Object)entityDataAccessor8, (String)"defineId(...)");
        TARGET = entityDataAccessor8;
        objectArray = new Block[]{Blocks.TORCH, Blocks.WALL_TORCH, Blocks.SOUL_TORCH, Blocks.SOUL_WALL_TORCH, Blocks.REDSTONE_TORCH, Blocks.REDSTONE_WALL_TORCH, Blocks.GLOWSTONE, Blocks.SEA_LANTERN, Blocks.END_ROD, Blocks.JACK_O_LANTERN, Blocks.LANTERN, Blocks.SOUL_LANTERN};
        TARGET_BLOCKS = SetsKt.setOf((Object[])objectArray);
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010!\u001a\u00020\"R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\bR\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\bR\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\bR\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\bR\u001d\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00160\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\bR\u001d\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00160\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\bR\u001f\u0010\u001b\u001a\u0010\u0012\f\u0012\n \u001e*\u0004\u0018\u00010\u001d0\u001d0\u001c\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 \u00a8\u0006#"}, d2={"Lnet/thebrokenscript/entity/anomaly/sa2/SubAnomaly2Entity$Companion;", "", "<init>", "()V", "VARIANT", "Lnet/minecraft/network/syncher/EntityDataAccessor;", "", "getVARIANT", "()Lnet/minecraft/network/syncher/EntityDataAccessor;", "FEAR_FACTOR", "getFEAR_FACTOR", "TRANS_STATE", "getTRANS_STATE", "TRANS_TIMER", "getTRANS_TIMER", "HAS_TARGET", "", "getHAS_TARGET", "LAST_PATH_ATTEMPT", "", "getLAST_PATH_ATTEMPT", "FRACTURED_INSTANCE", "Ljava/util/Optional;", "Ljava/util/UUID;", "getFRACTURED_INSTANCE", "TARGET", "getTARGET", "TARGET_BLOCKS", "", "Lnet/minecraft/world/level/block/Block;", "kotlin.jvm.PlatformType", "getTARGET_BLOCKS", "()Ljava/util/Set;", "attributes", "Lnet/minecraft/world/entity/ai/attributes/AttributeSupplier$Builder;", "thebrokenscript-common"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final EntityDataAccessor<Integer> getVARIANT() {
            return VARIANT;
        }

        @NotNull
        public final EntityDataAccessor<Integer> getFEAR_FACTOR() {
            return FEAR_FACTOR;
        }

        @NotNull
        public final EntityDataAccessor<Integer> getTRANS_STATE() {
            return TRANS_STATE;
        }

        @NotNull
        public final EntityDataAccessor<Integer> getTRANS_TIMER() {
            return TRANS_TIMER;
        }

        @NotNull
        public final EntityDataAccessor<Boolean> getHAS_TARGET() {
            return HAS_TARGET;
        }

        @NotNull
        public final EntityDataAccessor<Long> getLAST_PATH_ATTEMPT() {
            return LAST_PATH_ATTEMPT;
        }

        @NotNull
        public final EntityDataAccessor<Optional<UUID>> getFRACTURED_INSTANCE() {
            return FRACTURED_INSTANCE;
        }

        @NotNull
        public final EntityDataAccessor<Optional<UUID>> getTARGET() {
            return TARGET;
        }

        @NotNull
        public final Set<Block> getTARGET_BLOCKS() {
            return TARGET_BLOCKS;
        }

        @NotNull
        public final AttributeSupplier.Builder attributes() {
            return SubAnomaly2Entity.access$attrs$s910975913(Companion::attributes$lambda$0);
        }

        private static final Unit attributes$lambda$0(AttributeSupplier.Builder $this$attrs) {
            Intrinsics.checkNotNullParameter((Object)$this$attrs, (String)"$this$attrs");
            AttributeUtil.setMovementSpeed((AttributeSupplier.Builder)$this$attrs, (Number)0.33);
            AttributeUtil.setMaxHealth((AttributeSupplier.Builder)$this$attrs, (Number)910);
            AttributeUtil.setArmor((AttributeSupplier.Builder)$this$attrs, (Number)0);
            AttributeUtil.setAttackDamage((AttributeSupplier.Builder)$this$attrs, (Number)1);
            AttributeUtil.setFollowRange((AttributeSupplier.Builder)$this$attrs, (Number)40);
            AttributeUtil.setStepHeight((AttributeSupplier.Builder)$this$attrs, (Number)3);
            AttributeUtil.setFlyingSpeed((AttributeSupplier.Builder)$this$attrs, (Number)0.85);
            return Unit.INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }

    @Metadata(mv={2, 1, 0}, k=3, xi=48)
    public static final class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] nArray = new int[SubAnomaly2Type.values().length];
            try {
                nArray[SubAnomaly2Type.SPIDER_TO_STALK.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[SubAnomaly2Type.STALK_TO_DIVEBOMB.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[SubAnomaly2Type.DIVEBOMB_TO_STALK.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[SubAnomaly2Type.STALK_TO_SPIDER.ordinal()] = 4;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[SubAnomaly2Type.MIMIC_TO_SPIDER.ordinal()] = 5;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[SubAnomaly2Type.SPIDER_TO_CANNONBALL.ordinal()] = 6;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[SubAnomaly2Type.CANNONBALL_TO_SPIDER.ordinal()] = 7;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            $EnumSwitchMapping$0 = nArray;
        }
    }
}

