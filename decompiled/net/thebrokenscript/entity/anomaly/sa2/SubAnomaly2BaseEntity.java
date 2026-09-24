/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.collections.IntIterator
 *  kotlin.collections.SetsKt
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.MutablePropertyReference1
 *  kotlin.jvm.internal.MutablePropertyReference1Impl
 *  kotlin.jvm.internal.Reflection
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.random.Random
 *  kotlin.ranges.IntRange
 *  kotlin.reflect.KProperty
 *  net.minecraft.core.BlockPos
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.network.syncher.EntityDataAccessor
 *  net.minecraft.network.syncher.EntityDataSerializer
 *  net.minecraft.network.syncher.EntityDataSerializers
 *  net.minecraft.network.syncher.SynchedEntityData
 *  net.minecraft.network.syncher.SynchedEntityData$Builder
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.sounds.SoundEvent
 *  net.minecraft.world.DifficultyInstance
 *  net.minecraft.world.damagesource.DamageSource
 *  net.minecraft.world.damagesource.DamageTypes
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.Mob
 *  net.minecraft.world.entity.MobSpawnType
 *  net.minecraft.world.entity.SpawnGroupData
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.level.LightLayer
 *  net.minecraft.world.level.ServerLevelAccessor
 *  net.minecraft.world.level.block.Block
 *  net.minecraft.world.level.block.Blocks
 *  net.minecraft.world.level.block.state.BlockState
 *  net.thebrokenscript.brokencore.api.dsl.EntityDataDelegate
 *  net.thebrokenscript.brokencore.api.entity.FinalizedSpawn
 *  net.thebrokenscript.brokencore.api.entity.base.BaseMonster
 *  net.thebrokenscript.brokencore.api.entity.base.UwuableMonster
 *  net.thebrokenscript.brokencore.api.platform.CancelProxy
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.entity.anomaly.sa2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.random.Random;
import kotlin.ranges.IntRange;
import kotlin.reflect.KProperty;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializer;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LightLayer;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.thebrokenscript.brokencore.api.dsl.EntityDataDelegate;
import net.thebrokenscript.brokencore.api.entity.FinalizedSpawn;
import net.thebrokenscript.brokencore.api.entity.base.BaseMonster;
import net.thebrokenscript.brokencore.api.entity.base.UwuableMonster;
import net.thebrokenscript.brokencore.api.platform.CancelProxy;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u001c\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000 X2\u00020\u00012\u00020\u0002:\u0001XB\u001f\u0012\u000e\u0010\u0003\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00000\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fH\u0014J\u0010\u00105\u001a\u00020\u001a2\u0006\u00106\u001a\u000207H\u0016J\b\u00108\u001a\u00020\u001aH\u0016J\b\u00109\u001a\u00020\u001aH\u0016J\u0018\u0010:\u001a\u00020\u001a2\u0006\u0010\u0005\u001a\u00020;2\u0006\u0010<\u001a\u00020=H\u0016J\u0010\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020AH\u0016J\u0010\u0010B\u001a\u00020?2\u0006\u0010@\u001a\u00020AH\u0016J\u0010\u0010C\u001a\u00020?2\u0006\u0010D\u001a\u00020EH\u0014J\b\u0010F\u001a\u00020?H\u0016J\b\u0010G\u001a\u00020?H\u0016J\u0018\u0010H\u001a\u00020?2\u0006\u0010I\u001a\u00020J2\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0018\u0010K\u001a\u00020\u001a2\u0006\u0010L\u001a\u00020\f2\u0006\u0010M\u001a\u00020NH\u0016J4\u0010O\u001a\u0004\u0018\u00010P2\u0006\u0010\u0005\u001a\u00020Q2\u0006\u0010R\u001a\u00020S2\u0006\u0010T\u001a\u00020=2\b\u0010U\u001a\u0004\u0018\u00010P2\u0006\u0010V\u001a\u00020WH\u0016R+\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u000e8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R+\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u000e8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u0015\u001a\u0004\b\u0017\u0010\u0011\"\u0004\b\u0018\u0010\u0013R+\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\r\u001a\u00020\u001a8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b \u0010\u0015\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR+\u0010!\u001a\u00020\u001a2\u0006\u0010\r\u001a\u00020\u001a8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b$\u0010\u0015\u001a\u0004\b\"\u0010\u001d\"\u0004\b#\u0010\u001fR+\u0010%\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u000e8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b(\u0010\u0015\u001a\u0004\b&\u0010\u0011\"\u0004\b'\u0010\u0013R+\u0010)\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u000e8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b,\u0010\u0015\u001a\u0004\b*\u0010\u0011\"\u0004\b+\u0010\u0013R+\u0010-\u001a\u00020\u001a2\u0006\u0010\r\u001a\u00020\u001a8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b0\u0010\u0015\u001a\u0004\b.\u0010\u001d\"\u0004\b/\u0010\u001fR+\u00101\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u000e8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b4\u0010\u0015\u001a\u0004\b2\u0010\u0011\"\u0004\b3\u0010\u0013\u00a8\u0006Y"}, d2={"Lnet/thebrokenscript/entity/anomaly/sa2/SubAnomaly2BaseEntity;", "Lnet/thebrokenscript/brokencore/api/entity/base/UwuableMonster;", "Lnet/thebrokenscript/brokencore/api/entity/FinalizedSpawn;", "type", "Lnet/minecraft/world/entity/EntityType;", "level", "Lnet/minecraft/world/level/Level;", "<init>", "(Lnet/minecraft/world/entity/EntityType;Lnet/minecraft/world/level/Level;)V", "getHurtSound", "Lnet/minecraft/sounds/SoundEvent;", "damageSource", "Lnet/minecraft/world/damagesource/DamageSource;", "<set-?>", "", "despawnTimer", "getDespawnTimer", "()I", "setDespawnTimer", "(I)V", "despawnTimer$delegate", "Lnet/thebrokenscript/brokencore/api/dsl/EntityDataDelegate;", "variant", "getVariant", "setVariant", "variant$delegate", "", "despawning", "getDespawning", "()Z", "setDespawning", "(Z)V", "despawning$delegate", "transforming", "getTransforming", "setTransforming", "transforming$delegate", "start", "getStart", "setStart", "start$delegate", "fearFactor", "getFearFactor", "setFearFactor", "fearFactor$delegate", "hasAlreadyTransformed", "getHasAlreadyTransformed", "setHasAlreadyTransformed", "hasAlreadyTransformed$delegate", "transformStart", "getTransformStart", "setTransformStart", "transformStart$delegate", "removeWhenFarAway", "distanceToClosestPlayer", "", "fireImmune", "isPushable", "checkSpawnRules", "Lnet/minecraft/world/level/LevelAccessor;", "reason", "Lnet/minecraft/world/entity/MobSpawnType;", "addAdditionalSaveData", "", "compound", "Lnet/minecraft/nbt/CompoundTag;", "readAdditionalSaveData", "defineSynchedData", "builder", "Lnet/minecraft/network/syncher/SynchedEntityData$Builder;", "baseTick", "tick", "destroyLight", "mob", "Lnet/minecraft/world/entity/Mob;", "hurt", "source", "amount", "", "onFinalizeSpawn", "Lnet/minecraft/world/entity/SpawnGroupData;", "Lnet/minecraft/world/level/ServerLevelAccessor;", "difficulty", "Lnet/minecraft/world/DifficultyInstance;", "spawnType", "spawnData", "event", "Lnet/thebrokenscript/brokencore/api/platform/CancelProxy;", "Companion", "thebrokenscript-common"})
@SourceDebugExtension(value={"SMAP\nSubAnomaly2BaseEntity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SubAnomaly2BaseEntity.kt\nnet/thebrokenscript/entity/anomaly/sa2/SubAnomaly2BaseEntity\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,233:1\n1374#2:234\n1460#2,5:235\n*S KotlinDebug\n*F\n+ 1 SubAnomaly2BaseEntity.kt\nnet/thebrokenscript/entity/anomaly/sa2/SubAnomaly2BaseEntity\n*L\n200#1:234\n200#1:235,5\n*E\n"})
public abstract class SubAnomaly2BaseEntity
extends UwuableMonster
implements FinalizedSpawn {
    @NotNull
    public static final Companion Companion;
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;
    @NotNull
    private final EntityDataDelegate despawnTimer$delegate;
    @NotNull
    private final EntityDataDelegate variant$delegate;
    @NotNull
    private final EntityDataDelegate despawning$delegate;
    @NotNull
    private final EntityDataDelegate transforming$delegate;
    @NotNull
    private final EntityDataDelegate start$delegate;
    @NotNull
    private final EntityDataDelegate fearFactor$delegate;
    @NotNull
    private final EntityDataDelegate hasAlreadyTransformed$delegate;
    @NotNull
    private final EntityDataDelegate transformStart$delegate;
    @NotNull
    private static final EntityDataAccessor<Integer> DESPAWN_TIMER;
    @NotNull
    private static final EntityDataAccessor<Integer> VARIANT;
    @NotNull
    private static final EntityDataAccessor<Boolean> IS_DESPAWNING;
    @NotNull
    private static final EntityDataAccessor<Boolean> IS_TRANSFORMING;
    @NotNull
    private static final EntityDataAccessor<Integer> DESPAWN_START_TICK;
    @NotNull
    private static final EntityDataAccessor<Integer> FEAR_FACTOR;
    @NotNull
    private static final EntityDataAccessor<Boolean> HAS_ALREADY_TRANSFORMED;
    @NotNull
    private static final EntityDataAccessor<Integer> TRANSFORM_START_TICK;
    private static final int SEARCH_RADIUS;
    @NotNull
    private static final Set<Block> TARGET_BLOCKS;

    public SubAnomaly2BaseEntity(@NotNull EntityType<? extends SubAnomaly2BaseEntity> type, @NotNull Level level) {
        Intrinsics.checkNotNullParameter(type, (String)"type");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        super(type, level);
        this.xpReward = 0;
        this.setNoAi(false);
        this.setPersistenceRequired();
        this.despawnTimer$delegate = this.entityData(DESPAWN_TIMER);
        this.variant$delegate = this.entityData(VARIANT);
        this.despawning$delegate = this.entityData(IS_DESPAWNING);
        this.transforming$delegate = this.entityData(IS_TRANSFORMING);
        this.start$delegate = this.entityData(DESPAWN_START_TICK);
        this.fearFactor$delegate = this.entityData(FEAR_FACTOR);
        this.hasAlreadyTransformed$delegate = this.entityData(HAS_ALREADY_TRANSFORMED);
        this.transformStart$delegate = this.entityData(TRANSFORM_START_TICK);
    }

    @Nullable
    protected SoundEvent getHurtSound(@NotNull DamageSource damageSource) {
        Intrinsics.checkNotNullParameter((Object)damageSource, (String)"damageSource");
        return null;
    }

    public final int getDespawnTimer() {
        return ((Number)this.despawnTimer$delegate.getValue((BaseMonster)this, $$delegatedProperties[0])).intValue();
    }

    public final void setDespawnTimer(int n) {
        this.despawnTimer$delegate.setValue((BaseMonster)this, $$delegatedProperties[0], (Object)n);
    }

    public final int getVariant() {
        return ((Number)this.variant$delegate.getValue((BaseMonster)this, $$delegatedProperties[1])).intValue();
    }

    public final void setVariant(int n) {
        this.variant$delegate.setValue((BaseMonster)this, $$delegatedProperties[1], (Object)n);
    }

    public final boolean getDespawning() {
        return (Boolean)this.despawning$delegate.getValue((BaseMonster)this, $$delegatedProperties[2]);
    }

    public final void setDespawning(boolean bl) {
        this.despawning$delegate.setValue((BaseMonster)this, $$delegatedProperties[2], (Object)bl);
    }

    public final boolean getTransforming() {
        return (Boolean)this.transforming$delegate.getValue((BaseMonster)this, $$delegatedProperties[3]);
    }

    public final void setTransforming(boolean bl) {
        this.transforming$delegate.setValue((BaseMonster)this, $$delegatedProperties[3], (Object)bl);
    }

    public final int getStart() {
        return ((Number)this.start$delegate.getValue((BaseMonster)this, $$delegatedProperties[4])).intValue();
    }

    public final void setStart(int n) {
        this.start$delegate.setValue((BaseMonster)this, $$delegatedProperties[4], (Object)n);
    }

    public final int getFearFactor() {
        return ((Number)this.fearFactor$delegate.getValue((BaseMonster)this, $$delegatedProperties[5])).intValue();
    }

    public final void setFearFactor(int n) {
        this.fearFactor$delegate.setValue((BaseMonster)this, $$delegatedProperties[5], (Object)n);
    }

    public final boolean getHasAlreadyTransformed() {
        return (Boolean)this.hasAlreadyTransformed$delegate.getValue((BaseMonster)this, $$delegatedProperties[6]);
    }

    public final void setHasAlreadyTransformed(boolean bl) {
        this.hasAlreadyTransformed$delegate.setValue((BaseMonster)this, $$delegatedProperties[6], (Object)bl);
    }

    public final int getTransformStart() {
        return ((Number)this.transformStart$delegate.getValue((BaseMonster)this, $$delegatedProperties[7])).intValue();
    }

    public final void setTransformStart(int n) {
        this.transformStart$delegate.setValue((BaseMonster)this, $$delegatedProperties[7], (Object)n);
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

    public void addAdditionalSaveData(@NotNull CompoundTag compound) {
        Intrinsics.checkNotNullParameter((Object)compound, (String)"compound");
        super.addAdditionalSaveData(compound);
        compound.putInt("despawn_timer", this.getDespawnTimer());
        compound.putInt("variant", this.getVariant());
        compound.putInt("fear_factor", this.getFearFactor());
        compound.putBoolean("is_despawning", this.getDespawning());
        compound.putBoolean("is_transforming", this.getTransforming());
        compound.putInt("despawn_start_tick", this.getStart());
        compound.putBoolean("has_already_transformed", this.getHasAlreadyTransformed());
        compound.putInt("transform_start_tick", this.getTransformStart());
    }

    public void readAdditionalSaveData(@NotNull CompoundTag compound) {
        Intrinsics.checkNotNullParameter((Object)compound, (String)"compound");
        super.readAdditionalSaveData(compound);
        if (compound.contains("despawn_timer")) {
            this.entityData.set(DESPAWN_TIMER, (Object)compound.getInt("despawn_timer"));
        }
        if (compound.contains("variant")) {
            this.entityData.set(VARIANT, (Object)compound.getInt("variant"));
        }
        if (compound.contains("fear_factor")) {
            this.entityData.set(FEAR_FACTOR, (Object)compound.getInt("fear_factor"));
        }
        if (compound.contains("is_despawning")) {
            this.entityData.set(IS_DESPAWNING, (Object)compound.getBoolean("is_despawning"));
        }
        if (compound.contains("is_transforming")) {
            this.entityData.set(IS_TRANSFORMING, (Object)compound.getBoolean("is_transforming"));
        }
        if (compound.contains("despawn_start_tick")) {
            this.entityData.set(DESPAWN_START_TICK, (Object)compound.getInt("despawn_start_tick"));
        }
        if (compound.contains("has_already_transformed")) {
            this.entityData.set(HAS_ALREADY_TRANSFORMED, (Object)compound.getBoolean("has_already_transformed"));
        }
        if (compound.contains("transform_start_tick")) {
            this.entityData.set(TRANSFORM_START_TICK, (Object)compound.getInt("transform_start_tick"));
        }
    }

    protected void defineSynchedData(@NotNull SynchedEntityData.Builder builder) {
        Intrinsics.checkNotNullParameter((Object)builder, (String)"builder");
        super.defineSynchedData(builder);
        builder.define(DESPAWN_TIMER, (Object)0);
        builder.define(VARIANT, (Object)1);
        builder.define(IS_DESPAWNING, (Object)false);
        builder.define(IS_TRANSFORMING, (Object)false);
        builder.define(DESPAWN_START_TICK, (Object)0);
        builder.define(FEAR_FACTOR, (Object)0);
        builder.define(HAS_ALREADY_TRANSFORMED, (Object)false);
        builder.define(TRANSFORM_START_TICK, (Object)0);
    }

    public void baseTick() {
        super.baseTick();
        Level level = this.level();
        if (!(level instanceof ServerLevel)) {
            return;
        }
        if (!this.getDespawning()) {
            int n = this.getDespawnTimer();
            this.setDespawnTimer(n + 1);
            if (((ServerLevel)level).isDay() && ((ServerLevel)level).canSeeSky(this.getBlockPos()) && ((ServerLevel)level).getBrightness(LightLayer.SKY, this.getBlockPos()) >= 15) {
                this.setDespawning(true);
                this.setStart(this.tickCount);
            }
            if (this.getDespawnTimer() > 3600) {
                this.setDespawning(true);
                this.setStart(this.tickCount);
            }
        } else if (this.tickCount > this.getStart() + 100) {
            this.discard();
        }
    }

    public void tick() {
        super.tick();
        if (this.getFearFactor() < 13) {
            return;
        }
        Mob mob = (Mob)this;
        Level level = this.level();
        Intrinsics.checkNotNullExpressionValue((Object)level, (String)"level(...)");
        this.destroyLight(mob, level);
    }

    private final void destroyLight(Mob mob, Level level) {
        BlockPos center = mob.blockPosition();
        int minX = center.getX() - SEARCH_RADIUS;
        int minY = center.getY() - SEARCH_RADIUS;
        int minZ = center.getZ() - SEARCH_RADIUS;
        int maxX = center.getX() + SEARCH_RADIUS;
        int maxY = center.getY() + SEARCH_RADIUS;
        int maxZ = center.getZ() + SEARCH_RADIUS;
        for (BlockPos pos : BlockPos.betweenClosed((int)minX, (int)minY, (int)minZ, (int)maxX, (int)maxY, (int)maxZ)) {
            BlockState state = level.getBlockState(pos);
            if (!TARGET_BLOCKS.contains(state.getBlock())) continue;
            level.destroyBlock(pos, false, (Entity)this);
        }
    }

    public boolean hurt(@NotNull DamageSource source, float amount) {
        Intrinsics.checkNotNullParameter((Object)source, (String)"source");
        return Intrinsics.areEqual((Object)source.type(), (Object)DamageTypes.GENERIC_KILL) || Intrinsics.areEqual((Object)source.type(), (Object)DamageTypes.FELL_OUT_OF_WORLD);
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
        SubAnomaly2BaseEntity subAnomaly2BaseEntity = this;
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
        subAnomaly2BaseEntity.setVariant(((Number)CollectionsKt.random((Collection)CollectionsKt.plus((Collection)CollectionsKt.plus((Collection)collection2, (Iterable)list), (Object)7), (Random)((Random)Random.Default))).intValue());
        this.setFearFactor(14);
        this.setHasAlreadyTransformed(false);
        return null;
    }

    static {
        Object[] objectArray = new KProperty[]{Reflection.mutableProperty1((MutablePropertyReference1)((MutablePropertyReference1)new MutablePropertyReference1Impl(SubAnomaly2BaseEntity.class, "despawnTimer", "getDespawnTimer()I", 0))), Reflection.mutableProperty1((MutablePropertyReference1)((MutablePropertyReference1)new MutablePropertyReference1Impl(SubAnomaly2BaseEntity.class, "variant", "getVariant()I", 0))), Reflection.mutableProperty1((MutablePropertyReference1)((MutablePropertyReference1)new MutablePropertyReference1Impl(SubAnomaly2BaseEntity.class, "despawning", "getDespawning()Z", 0))), Reflection.mutableProperty1((MutablePropertyReference1)((MutablePropertyReference1)new MutablePropertyReference1Impl(SubAnomaly2BaseEntity.class, "transforming", "getTransforming()Z", 0))), Reflection.mutableProperty1((MutablePropertyReference1)((MutablePropertyReference1)new MutablePropertyReference1Impl(SubAnomaly2BaseEntity.class, "start", "getStart()I", 0))), Reflection.mutableProperty1((MutablePropertyReference1)((MutablePropertyReference1)new MutablePropertyReference1Impl(SubAnomaly2BaseEntity.class, "fearFactor", "getFearFactor()I", 0))), Reflection.mutableProperty1((MutablePropertyReference1)((MutablePropertyReference1)new MutablePropertyReference1Impl(SubAnomaly2BaseEntity.class, "hasAlreadyTransformed", "getHasAlreadyTransformed()Z", 0))), Reflection.mutableProperty1((MutablePropertyReference1)((MutablePropertyReference1)new MutablePropertyReference1Impl(SubAnomaly2BaseEntity.class, "transformStart", "getTransformStart()I", 0)))};
        $$delegatedProperties = objectArray;
        Companion = new Companion(null);
        EntityDataAccessor entityDataAccessor = SynchedEntityData.defineId(SubAnomaly2BaseEntity.class, (EntityDataSerializer)EntityDataSerializers.INT);
        Intrinsics.checkNotNullExpressionValue((Object)entityDataAccessor, (String)"defineId(...)");
        DESPAWN_TIMER = entityDataAccessor;
        EntityDataAccessor entityDataAccessor2 = SynchedEntityData.defineId(SubAnomaly2BaseEntity.class, (EntityDataSerializer)EntityDataSerializers.INT);
        Intrinsics.checkNotNullExpressionValue((Object)entityDataAccessor2, (String)"defineId(...)");
        VARIANT = entityDataAccessor2;
        EntityDataAccessor entityDataAccessor3 = SynchedEntityData.defineId(SubAnomaly2BaseEntity.class, (EntityDataSerializer)EntityDataSerializers.BOOLEAN);
        Intrinsics.checkNotNullExpressionValue((Object)entityDataAccessor3, (String)"defineId(...)");
        IS_DESPAWNING = entityDataAccessor3;
        EntityDataAccessor entityDataAccessor4 = SynchedEntityData.defineId(SubAnomaly2BaseEntity.class, (EntityDataSerializer)EntityDataSerializers.BOOLEAN);
        Intrinsics.checkNotNullExpressionValue((Object)entityDataAccessor4, (String)"defineId(...)");
        IS_TRANSFORMING = entityDataAccessor4;
        EntityDataAccessor entityDataAccessor5 = SynchedEntityData.defineId(SubAnomaly2BaseEntity.class, (EntityDataSerializer)EntityDataSerializers.INT);
        Intrinsics.checkNotNullExpressionValue((Object)entityDataAccessor5, (String)"defineId(...)");
        DESPAWN_START_TICK = entityDataAccessor5;
        EntityDataAccessor entityDataAccessor6 = SynchedEntityData.defineId(SubAnomaly2BaseEntity.class, (EntityDataSerializer)EntityDataSerializers.INT);
        Intrinsics.checkNotNullExpressionValue((Object)entityDataAccessor6, (String)"defineId(...)");
        FEAR_FACTOR = entityDataAccessor6;
        EntityDataAccessor entityDataAccessor7 = SynchedEntityData.defineId(SubAnomaly2BaseEntity.class, (EntityDataSerializer)EntityDataSerializers.BOOLEAN);
        Intrinsics.checkNotNullExpressionValue((Object)entityDataAccessor7, (String)"defineId(...)");
        HAS_ALREADY_TRANSFORMED = entityDataAccessor7;
        EntityDataAccessor entityDataAccessor8 = SynchedEntityData.defineId(SubAnomaly2BaseEntity.class, (EntityDataSerializer)EntityDataSerializers.INT);
        Intrinsics.checkNotNullExpressionValue((Object)entityDataAccessor8, (String)"defineId(...)");
        TRANSFORM_START_TICK = entityDataAccessor8;
        SEARCH_RADIUS = 5;
        objectArray = new Block[]{Blocks.TORCH, Blocks.WALL_TORCH, Blocks.SOUL_TORCH, Blocks.SOUL_WALL_TORCH, Blocks.REDSTONE_TORCH, Blocks.REDSTONE_WALL_TORCH, Blocks.GLOWSTONE, Blocks.SEA_LANTERN, Blocks.END_ROD, Blocks.JACK_O_LANTERN, Blocks.LANTERN, Blocks.SOUL_LANTERN};
        TARGET_BLOCKS = SetsKt.setOf((Object[])objectArray);
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\bR\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\f0\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\bR\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\bR\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\bR\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\f0\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\bR\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\bR\u0014\u0010\u0018\u001a\u00020\u0006X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u001f\u0010\u001b\u001a\u0010\u0012\f\u0012\n \u001e*\u0004\u0018\u00010\u001d0\u001d0\u001c\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 \u00a8\u0006!"}, d2={"Lnet/thebrokenscript/entity/anomaly/sa2/SubAnomaly2BaseEntity$Companion;", "", "<init>", "()V", "DESPAWN_TIMER", "Lnet/minecraft/network/syncher/EntityDataAccessor;", "", "getDESPAWN_TIMER", "()Lnet/minecraft/network/syncher/EntityDataAccessor;", "VARIANT", "getVARIANT", "IS_DESPAWNING", "", "getIS_DESPAWNING", "IS_TRANSFORMING", "getIS_TRANSFORMING", "DESPAWN_START_TICK", "getDESPAWN_START_TICK", "FEAR_FACTOR", "getFEAR_FACTOR", "HAS_ALREADY_TRANSFORMED", "getHAS_ALREADY_TRANSFORMED", "TRANSFORM_START_TICK", "getTRANSFORM_START_TICK", "SEARCH_RADIUS", "getSEARCH_RADIUS", "()I", "TARGET_BLOCKS", "", "Lnet/minecraft/world/level/block/Block;", "kotlin.jvm.PlatformType", "getTARGET_BLOCKS", "()Ljava/util/Set;", "thebrokenscript-common"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final EntityDataAccessor<Integer> getDESPAWN_TIMER() {
            return DESPAWN_TIMER;
        }

        @NotNull
        public final EntityDataAccessor<Integer> getVARIANT() {
            return VARIANT;
        }

        @NotNull
        public final EntityDataAccessor<Boolean> getIS_DESPAWNING() {
            return IS_DESPAWNING;
        }

        @NotNull
        public final EntityDataAccessor<Boolean> getIS_TRANSFORMING() {
            return IS_TRANSFORMING;
        }

        @NotNull
        public final EntityDataAccessor<Integer> getDESPAWN_START_TICK() {
            return DESPAWN_START_TICK;
        }

        @NotNull
        public final EntityDataAccessor<Integer> getFEAR_FACTOR() {
            return FEAR_FACTOR;
        }

        @NotNull
        public final EntityDataAccessor<Boolean> getHAS_ALREADY_TRANSFORMED() {
            return HAS_ALREADY_TRANSFORMED;
        }

        @NotNull
        public final EntityDataAccessor<Integer> getTRANSFORM_START_TICK() {
            return TRANSFORM_START_TICK;
        }

        public final int getSEARCH_RADIUS() {
            return SEARCH_RADIUS;
        }

        @NotNull
        public final Set<Block> getTARGET_BLOCKS() {
            return TARGET_BLOCKS;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

