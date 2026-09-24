/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.MutablePropertyReference1
 *  kotlin.jvm.internal.MutablePropertyReference1Impl
 *  kotlin.jvm.internal.Reflection
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.reflect.KProperty
 *  net.minecraft.client.player.LocalPlayer
 *  net.minecraft.commands.arguments.EntityAnchorArgument$Anchor
 *  net.minecraft.core.particles.ParticleOptions
 *  net.minecraft.core.particles.SimpleParticleType
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
 *  net.minecraft.world.DifficultyInstance
 *  net.minecraft.world.damagesource.DamageSource
 *  net.minecraft.world.damagesource.DamageTypes
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.Mob
 *  net.minecraft.world.entity.MobSpawnType
 *  net.minecraft.world.entity.SpawnGroupData
 *  net.minecraft.world.entity.ai.attributes.AttributeSupplier$Builder
 *  net.minecraft.world.entity.ai.goal.FloatGoal
 *  net.minecraft.world.entity.ai.goal.Goal
 *  net.minecraft.world.entity.ai.goal.Goal$Flag
 *  net.minecraft.world.entity.ai.goal.LookAtPlayerGoal
 *  net.minecraft.world.entity.ai.navigation.GroundPathNavigation
 *  net.minecraft.world.entity.ai.navigation.PathNavigation
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.level.ServerLevelAccessor
 *  net.minecraft.world.phys.Vec3
 *  net.thebrokenscript.brokencore.api.dsl.AttributeUtil
 *  net.thebrokenscript.brokencore.api.dsl.ClientDSLKt
 *  net.thebrokenscript.brokencore.api.dsl.EntityDataDelegate
 *  net.thebrokenscript.brokencore.api.dsl.EntityFinder
 *  net.thebrokenscript.brokencore.api.dsl.EntityUtil
 *  net.thebrokenscript.brokencore.api.dsl.ParticleUtil
 *  net.thebrokenscript.brokencore.api.dsl.PlayerUtil
 *  net.thebrokenscript.brokencore.api.dsl.SideUtil
 *  net.thebrokenscript.brokencore.api.entity.FinalizedSpawn
 *  net.thebrokenscript.brokencore.api.entity.base.BaseMonster
 *  net.thebrokenscript.brokencore.api.entity.base.BaseMonster$BMC
 *  net.thebrokenscript.brokencore.api.entity.base.BaseMonster$Companion
 *  net.thebrokenscript.brokencore.api.platform.CancelProxy
 *  net.thebrokenscript.brokencore.api.util.math.Vectors
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.entity;

import java.util.EnumSet;
import java.util.function.Supplier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KProperty;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.commands.arguments.EntityAnchorArgument;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializer;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.navigation.GroundPathNavigation;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.api.TBSConstants;
import net.thebrokenscript.api.ext.PlayerExt;
import net.thebrokenscript.brokencore.api.dsl.AttributeUtil;
import net.thebrokenscript.brokencore.api.dsl.ClientDSLKt;
import net.thebrokenscript.brokencore.api.dsl.EntityDataDelegate;
import net.thebrokenscript.brokencore.api.dsl.EntityFinder;
import net.thebrokenscript.brokencore.api.dsl.EntityUtil;
import net.thebrokenscript.brokencore.api.dsl.ParticleUtil;
import net.thebrokenscript.brokencore.api.dsl.PlayerUtil;
import net.thebrokenscript.brokencore.api.dsl.SideUtil;
import net.thebrokenscript.brokencore.api.entity.FinalizedSpawn;
import net.thebrokenscript.brokencore.api.entity.base.BaseMonster;
import net.thebrokenscript.brokencore.api.platform.CancelProxy;
import net.thebrokenscript.brokencore.api.util.math.Vectors;
import net.thebrokenscript.client.data.ClientVariables;
import net.thebrokenscript.config.TBSConfigs;
import net.thebrokenscript.registry.TBSParticleTypes;
import net.thebrokenscript.registry.TBSSounds;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\u0018\u0000 F2\u00020\u00012\u00020\u0002:\u0001FB\u001d\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00000\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0004\b\u0007\u0010\bJ\b\u0010!\u001a\u00020\"H\u0016J\b\u0010#\u001a\u00020$H\u0014J\b\u0010%\u001a\u00020$H\u0016J4\u0010&\u001a\u0004\u0018\u00010'2\u0006\u0010\u0005\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010'2\u0006\u0010.\u001a\u00020/H\u0016J\u0018\u00100\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u0002012\u0006\u00102\u001a\u00020,H\u0016J\u0010\u00103\u001a\u00020$2\u0006\u00104\u001a\u000205H\u0016J\u0010\u00106\u001a\u00020$2\u0006\u00104\u001a\u000205H\u0016J\u0010\u00107\u001a\u00020$2\u0006\u00108\u001a\u000209H\u0014J\u0010\u0010:\u001a\u00020\u00122\u0006\u0010;\u001a\u00020<H\u0016J\b\u0010=\u001a\u00020\u0012H\u0016J\u0018\u0010>\u001a\u00020\u00122\u0006\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020BH\u0016J\b\u0010C\u001a\u00020\u0012H\u0016J\b\u0010D\u001a\u00020$H\u0016J\b\u0010E\u001a\u00020\u0012H\u0016R+\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR+\u0010\u0013\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\u00128F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0011\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R+\u0010\u0019\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\u00128F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u0011\u001a\u0004\b\u001a\u0010\u0015\"\u0004\b\u001b\u0010\u0017R$\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\n8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u001f\u0010\r\"\u0004\b \u0010\u000f\u00a8\u0006G"}, d2={"Lnet/thebrokenscript/entity/FarawayEntity;", "Lnet/thebrokenscript/brokencore/api/entity/base/BaseMonster;", "Lnet/thebrokenscript/brokencore/api/entity/FinalizedSpawn;", "type", "Lnet/minecraft/world/entity/EntityType;", "level", "Lnet/minecraft/world/level/Level;", "<init>", "(Lnet/minecraft/world/entity/EntityType;Lnet/minecraft/world/level/Level;)V", "<set-?>", "", "delay", "getDelay", "()I", "setDelay", "(I)V", "delay$delegate", "Lnet/thebrokenscript/brokencore/api/dsl/EntityDataDelegate;", "", "funnyBaby", "getFunnyBaby", "()Z", "setFunnyBaby", "(Z)V", "funnyBaby$delegate", "funnyFard", "getFunnyFard", "setFunnyFard", "funnyFard$delegate", "value", "timer", "getTimer", "setTimer", "getNavigation", "Lnet/minecraft/world/entity/ai/navigation/PathNavigation;", "registerGoals", "", "tick", "onFinalizeSpawn", "Lnet/minecraft/world/entity/SpawnGroupData;", "Lnet/minecraft/world/level/ServerLevelAccessor;", "difficulty", "Lnet/minecraft/world/DifficultyInstance;", "spawnType", "Lnet/minecraft/world/entity/MobSpawnType;", "spawnData", "event", "Lnet/thebrokenscript/brokencore/api/platform/CancelProxy;", "checkSpawnRules", "Lnet/minecraft/world/level/LevelAccessor;", "reason", "addAdditionalSaveData", "compound", "Lnet/minecraft/nbt/CompoundTag;", "readAdditionalSaveData", "defineSynchedData", "builder", "Lnet/minecraft/network/syncher/SynchedEntityData$Builder;", "removeWhenFarAway", "distanceToClosestPlayer", "", "fireImmune", "hurt", "source", "Lnet/minecraft/world/damagesource/DamageSource;", "amount", "", "isBaby", "baseTick", "isPushedByFluid", "Companion", "thebrokenscript-common"})
@SourceDebugExtension(value={"SMAP\nFarawayEntity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FarawayEntity.kt\nnet/thebrokenscript/entity/FarawayEntity\n+ 2 BaseMonster.kt\nnet/thebrokenscript/brokencore/api/entity/base/BaseMonster$Companion\n*L\n1#1,195:1\n72#2:196\n*S KotlinDebug\n*F\n+ 1 FarawayEntity.kt\nnet/thebrokenscript/entity/FarawayEntity\n*L\n-1#1:196\n*E\n"})
public final class FarawayEntity
extends BaseMonster
implements FinalizedSpawn {
    @NotNull
    public static final Companion Companion;
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;
    @NotNull
    private final EntityDataDelegate delay$delegate;
    @NotNull
    private final EntityDataDelegate funnyBaby$delegate;
    @NotNull
    private final EntityDataDelegate funnyFard$delegate;
    @NotNull
    private static final EntityDataAccessor<Integer> DELAY_TIMER;
    @NotNull
    private static final EntityDataAccessor<Boolean> BABY;
    @NotNull
    private static final EntityDataAccessor<Boolean> FARD;
    @NotNull
    private static final String NATURAL_DESPAWN = "despawn_timer";
    @NotNull
    private static final String IS_BABY = "is_baby";
    @NotNull
    private static final String IS_FARD = "is_fard";

    public FarawayEntity(@NotNull EntityType<FarawayEntity> type, @NotNull Level level) {
        Intrinsics.checkNotNullParameter(type, (String)"type");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        super(type, level);
        this.delay$delegate = this.entityData(DELAY_TIMER);
        this.funnyBaby$delegate = this.entityData(BABY);
        this.funnyFard$delegate = this.entityData(FARD);
        this.xpReward = 0;
        this.setNoAi(false);
        this.setPersistenceRequired();
    }

    public final int getDelay() {
        Object object = this.delay$delegate.getValue((BaseMonster)this, $$delegatedProperties[0]);
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"getValue(...)");
        return ((Number)object).intValue();
    }

    public final void setDelay(int n) {
        this.delay$delegate.setValue((BaseMonster)this, $$delegatedProperties[0], (Object)n);
    }

    public final boolean getFunnyBaby() {
        Object object = this.funnyBaby$delegate.getValue((BaseMonster)this, $$delegatedProperties[1]);
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"getValue(...)");
        return (Boolean)object;
    }

    public final void setFunnyBaby(boolean bl) {
        this.funnyBaby$delegate.setValue((BaseMonster)this, $$delegatedProperties[1], (Object)bl);
    }

    public final boolean getFunnyFard() {
        Object object = this.funnyFard$delegate.getValue((BaseMonster)this, $$delegatedProperties[2]);
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"getValue(...)");
        return (Boolean)object;
    }

    public final void setFunnyFard(boolean bl) {
        this.funnyFard$delegate.setValue((BaseMonster)this, $$delegatedProperties[2], (Object)bl);
    }

    public final int getTimer() {
        return EntityUtil.getPersistentData((Entity)((Entity)this)).getInt(NATURAL_DESPAWN);
    }

    public final void setTimer(int value) {
        EntityUtil.getPersistentData((Entity)((Entity)this)).putInt(NATURAL_DESPAWN, value);
    }

    @NotNull
    public PathNavigation getNavigation() {
        return (PathNavigation)new GroundPathNavigation((Mob)this, this.getLevel());
    }

    protected void registerGoals() {
        super.registerGoals();
        LookAtPlayerGoal lookGoal = new LookAtPlayerGoal((Mob)this, Player.class, 400.0f, 100.0f, false);
        lookGoal.setFlags(EnumSet.of((Enum)Goal.Flag.LOOK));
        this.goalSelector.addGoal(2, (Goal)lookGoal);
        this.goalSelector.addGoal(3, (Goal)new FloatGoal((Mob)this));
    }

    public void tick() {
        super.tick();
        SideUtil.clientSide((Entity)((Entity)this), () -> FarawayEntity.tick$lambda$0(this));
    }

    @Nullable
    public SpawnGroupData onFinalizeSpawn(@NotNull ServerLevelAccessor level, @NotNull DifficultyInstance difficulty, @NotNull MobSpawnType spawnType, @Nullable SpawnGroupData spawnData, @NotNull CancelProxy event) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)difficulty, (String)"difficulty");
        Intrinsics.checkNotNullParameter((Object)spawnType, (String)"spawnType");
        Intrinsics.checkNotNullParameter((Object)event, (String)"event");
        this.setTimer(1600);
        if (TBSConfigs.INSTANCE.getServer().getDanger().getFunnySetting() && Math.random() > 0.99) {
            if (Math.random() > 0.5) {
                this.setFunnyBaby(true);
            } else {
                this.setFunnyFard(true);
            }
        }
        return null;
    }

    public boolean checkSpawnRules(@NotNull LevelAccessor level, @NotNull MobSpawnType reason) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)reason, (String)"reason");
        return true;
    }

    public void addAdditionalSaveData(@NotNull CompoundTag compound) {
        Intrinsics.checkNotNullParameter((Object)compound, (String)"compound");
        super.addAdditionalSaveData(compound);
        compound.putInt(NATURAL_DESPAWN, this.getTimer());
        compound.putBoolean(IS_BABY, this.getFunnyBaby());
        compound.putBoolean(IS_FARD, this.getFunnyFard());
    }

    public void readAdditionalSaveData(@NotNull CompoundTag compound) {
        Intrinsics.checkNotNullParameter((Object)compound, (String)"compound");
        super.readAdditionalSaveData(compound);
        this.setTimer(compound.getInt(NATURAL_DESPAWN));
        this.setFunnyBaby(compound.getBoolean(IS_BABY));
        this.setFunnyFard(compound.getBoolean(IS_FARD));
    }

    protected void defineSynchedData(@NotNull SynchedEntityData.Builder builder) {
        Intrinsics.checkNotNullParameter((Object)builder, (String)"builder");
        super.defineSynchedData(builder);
        builder.define(DELAY_TIMER, (Object)0);
        builder.define(BABY, (Object)false);
        builder.define(FARD, (Object)false);
    }

    public boolean removeWhenFarAway(double distanceToClosestPlayer) {
        return true;
    }

    public boolean fireImmune() {
        return true;
    }

    public boolean hurt(@NotNull DamageSource source, float amount) {
        Intrinsics.checkNotNullParameter((Object)source, (String)"source");
        return Intrinsics.areEqual((Object)source.type(), (Object)DamageTypes.GENERIC_KILL) || Intrinsics.areEqual((Object)source.type(), (Object)DamageTypes.FELL_OUT_OF_WORLD);
    }

    public boolean isBaby() {
        return this.getFunnyBaby();
    }

    public void baseTick() {
        int n;
        super.baseTick();
        Level level = this.getLevel();
        if (!(level instanceof ServerLevel)) {
            return;
        }
        ServerPlayer serverPlayer = EntityFinder.findClosestPlayerInRange((ServerLevel)((ServerLevel)level), (Vec3)this.getPos(), (Number)400.0);
        if (serverPlayer == null) {
            return;
        }
        ServerPlayer player = serverPlayer;
        if (this.isWithin((Entity)player, 38) && player.hasLineOfSight((Entity)this) && PlayerExt.isEntityInFovCone$default(PlayerExt.INSTANCE, (Player)player, (Entity)this, null, 2, null) || PlayerUtil.isLookingAt((Player)((Player)player), (Entity)((Entity)this))) {
            n = this.getDelay();
            this.setDelay(n + 1);
            if (this.getDelay() >= 25) {
                this.discard();
                if (this.getFunnyBaby()) {
                    PlayerUtil.sendSound$default((ServerPlayer)player, (SoundEvent)((SoundEvent)TBSSounds.BABY_DISAPPEAR.get()), (float)1.0f, (float)0.0f, null, null, (long)0L, (int)60, null);
                    PlayerUtil.trySendOverlay((Player)((Player)player), (ResourceLocation)TBSConstants.id("textures/screens/very_serious/baby.png"), (long)15L);
                } else if (this.getFunnyFard()) {
                    PlayerUtil.sendSound$default((ServerPlayer)player, (SoundEvent)((SoundEvent)TBSSounds.FARD_DISAPPEAR.get()), (float)1.0f, (float)0.0f, null, null, (long)0L, (int)60, null);
                    ParticleUtil.sendParticles((ServerLevel)((ServerLevel)level), (Supplier)((Supplier)TBSParticleTypes.FARDAWAY_PARTICLE), (Vec3)this.getPos(), (Number)50, (Vec3)Vectors.INSTANCE.all((Number)3), (Number)0);
                    PlayerUtil.trySendOverlay((Player)((Player)player), (ResourceLocation)TBSConstants.id("textures/screens/very_serious/fardaway.png"), (long)15L);
                } else {
                    PlayerUtil.sendSound$default((ServerPlayer)player, (SoundEvent)((SoundEvent)TBSSounds.PHANTOM_DISAPPEAR.get()), (float)1.0f, (float)0.0f, null, null, (long)0L, (int)56, null);
                    PlayerUtil.trySendOverlay((Player)((Player)player), (ResourceLocation)TBSConstants.id("textures/screens/snimok_ekrana_2024-11-02_090828.png"), (long)15L);
                }
                player.lookAt(EntityAnchorArgument.Anchor.EYES, new Vec3(this.getX(), this.getY() + 1.0, this.getZ()));
                ((ServerLevel)level).sendParticles((ParticleOptions)(this.random.nextBoolean() ? (SimpleParticleType)TBSParticleTypes.NULL_PARTICLE.get() : (SimpleParticleType)TBSParticleTypes.EYES.get()), this.getX(), this.getY(), this.getZ(), 555, 2.0, 2.0, 2.0, 0.0);
            }
        } else if (this.getDelay() != 0) {
            this.setDelay(0);
        }
        n = this.getTimer();
        this.setTimer(n + -1);
        if (this.getTimer() == 0) {
            this.discard();
        }
    }

    public boolean isPushedByFluid() {
        return false;
    }

    private static final Object tick$lambda$0(FarawayEntity this$0) {
        if (!ClientVariables.INSTANCE.has(64L)) {
            LocalPlayer localPlayer = ClientDSLKt.getMC().player;
            if (localPlayer == null) {
                return false;
            }
            LocalPlayer player = localPlayer;
            if (PlayerExt.INSTANCE.isEntityInFovCone((Player)player, (Entity)this$0, Double.valueOf(((Number)ClientDSLKt.getMC().options.fov().get()).intValue()))) {
                ClientVariables.INSTANCE.set(64L);
            }
        }
        return Unit.INSTANCE;
    }

    public static final /* synthetic */ AttributeSupplier.Builder access$attrs$s910975913(Function1 block) {
        return BaseMonster.attrs((Function1)block);
    }

    static {
        BaseMonster.Companion companion = new BaseMonster.Companion[]{Reflection.mutableProperty1((MutablePropertyReference1)((MutablePropertyReference1)new MutablePropertyReference1Impl(FarawayEntity.class, "delay", "getDelay()I", 0))), Reflection.mutableProperty1((MutablePropertyReference1)((MutablePropertyReference1)new MutablePropertyReference1Impl(FarawayEntity.class, "funnyBaby", "getFunnyBaby()Z", 0))), Reflection.mutableProperty1((MutablePropertyReference1)((MutablePropertyReference1)new MutablePropertyReference1Impl(FarawayEntity.class, "funnyFard", "getFunnyFard()Z", 0)))};
        $$delegatedProperties = companion;
        Companion = new Companion(null);
        companion = BaseMonster.Companion;
        BaseMonster.BMC bMC = Companion;
        EntityDataSerializer entityDataSerializer = EntityDataSerializers.INT;
        Intrinsics.checkNotNullExpressionValue((Object)entityDataSerializer, (String)"INT");
        EntityDataSerializer ser$iv = entityDataSerializer;
        boolean $i$f$data = false;
        EntityDataAccessor entityDataAccessor = SynchedEntityData.defineId(FarawayEntity.class, (EntityDataSerializer)ser$iv);
        Intrinsics.checkNotNullExpressionValue((Object)entityDataAccessor, (String)"defineId(...)");
        DELAY_TIMER = entityDataAccessor;
        BaseMonster.Companion this_$iv = BaseMonster.Companion;
        BaseMonster.BMC bMC2 = Companion;
        EntityDataSerializer entityDataSerializer2 = EntityDataSerializers.BOOLEAN;
        Intrinsics.checkNotNullExpressionValue((Object)entityDataSerializer2, (String)"BOOLEAN");
        ser$iv = entityDataSerializer2;
        $i$f$data = false;
        EntityDataAccessor entityDataAccessor2 = SynchedEntityData.defineId(FarawayEntity.class, (EntityDataSerializer)ser$iv);
        Intrinsics.checkNotNullExpressionValue((Object)entityDataAccessor2, (String)"defineId(...)");
        BABY = entityDataAccessor2;
        this_$iv = BaseMonster.Companion;
        bMC2 = Companion;
        EntityDataSerializer entityDataSerializer3 = EntityDataSerializers.BOOLEAN;
        Intrinsics.checkNotNullExpressionValue((Object)entityDataSerializer3, (String)"BOOLEAN");
        ser$iv = entityDataSerializer3;
        $i$f$data = false;
        EntityDataAccessor entityDataAccessor3 = SynchedEntityData.defineId(FarawayEntity.class, (EntityDataSerializer)ser$iv);
        Intrinsics.checkNotNullExpressionValue((Object)entityDataAccessor3, (String)"defineId(...)");
        FARD = entityDataAccessor3;
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0006R\u001f\u0010\u0007\u001a\u0010\u0012\f\u0012\n \n*\u0004\u0018\u00010\t0\t0\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001f\u0010\r\u001a\u0010\u0012\f\u0012\n \n*\u0004\u0018\u00010\u000e0\u000e0\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u001f\u0010\u0010\u001a\u0010\u0012\f\u0012\n \n*\u0004\u0018\u00010\u000e0\u000e0\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u000e\u0010\u0012\u001a\u00020\u0013X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0013X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2={"Lnet/thebrokenscript/entity/FarawayEntity$Companion;", "Lnet/thebrokenscript/brokencore/api/entity/base/BaseMonster$BMC;", "Lnet/thebrokenscript/entity/FarawayEntity;", "<init>", "()V", "attributes", "Lnet/minecraft/world/entity/ai/attributes/AttributeSupplier$Builder;", "DELAY_TIMER", "Lnet/minecraft/network/syncher/EntityDataAccessor;", "", "kotlin.jvm.PlatformType", "getDELAY_TIMER", "()Lnet/minecraft/network/syncher/EntityDataAccessor;", "BABY", "", "getBABY", "FARD", "getFARD", "NATURAL_DESPAWN", "", "IS_BABY", "IS_FARD", "thebrokenscript-common"})
    public static final class Companion
    implements BaseMonster.BMC<FarawayEntity> {
        private Companion() {
        }

        @NotNull
        public final AttributeSupplier.Builder attributes() {
            return FarawayEntity.access$attrs$s910975913(Companion::attributes$lambda$0);
        }

        @NotNull
        public final EntityDataAccessor<Integer> getDELAY_TIMER() {
            return DELAY_TIMER;
        }

        @NotNull
        public final EntityDataAccessor<Boolean> getBABY() {
            return BABY;
        }

        @NotNull
        public final EntityDataAccessor<Boolean> getFARD() {
            return FARD;
        }

        private static final Unit attributes$lambda$0(AttributeSupplier.Builder $this$attrs) {
            Intrinsics.checkNotNullParameter((Object)$this$attrs, (String)"$this$attrs");
            AttributeUtil.setMovementSpeed((AttributeSupplier.Builder)$this$attrs, (Number)0);
            AttributeUtil.setMaxHealth((AttributeSupplier.Builder)$this$attrs, (Number)510);
            AttributeUtil.setArmor((AttributeSupplier.Builder)$this$attrs, (Number)0);
            AttributeUtil.setAttackDamage((AttributeSupplier.Builder)$this$attrs, (Number)3);
            AttributeUtil.setFollowRange((AttributeSupplier.Builder)$this$attrs, (Number)616);
            return Unit.INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

