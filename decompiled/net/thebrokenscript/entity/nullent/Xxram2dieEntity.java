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
 *  kotlin.reflect.KProperty
 *  kotlin.text.HexExtensionsKt
 *  kotlin.text.StringsKt
 *  net.minecraft.client.player.LocalPlayer
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.network.chat.Component
 *  net.minecraft.network.chat.MutableComponent
 *  net.minecraft.network.syncher.EntityDataAccessor
 *  net.minecraft.network.syncher.EntityDataSerializer
 *  net.minecraft.network.syncher.EntityDataSerializers
 *  net.minecraft.network.syncher.SynchedEntityData
 *  net.minecraft.network.syncher.SynchedEntityData$Builder
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.sounds.SoundEvent
 *  net.minecraft.sounds.SoundEvents
 *  net.minecraft.world.DifficultyInstance
 *  net.minecraft.world.damagesource.DamageSource
 *  net.minecraft.world.damagesource.DamageTypes
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.Mob
 *  net.minecraft.world.entity.MobSpawnType
 *  net.minecraft.world.entity.PathfinderMob
 *  net.minecraft.world.entity.SpawnGroupData
 *  net.minecraft.world.entity.ai.goal.FloatGoal
 *  net.minecraft.world.entity.ai.goal.Goal
 *  net.minecraft.world.entity.ai.goal.MeleeAttackGoal
 *  net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.level.ClipContext
 *  net.minecraft.world.level.ClipContext$Block
 *  net.minecraft.world.level.ClipContext$Fluid
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.level.ServerLevelAccessor
 *  net.minecraft.world.phys.BlockHitResult
 *  net.minecraft.world.phys.Vec3
 *  net.thebrokenscript.brokencore.api.dsl.ChatUtil
 *  net.thebrokenscript.brokencore.api.dsl.ClientDSLKt
 *  net.thebrokenscript.brokencore.api.dsl.ComponentUtil
 *  net.thebrokenscript.brokencore.api.dsl.EntityDataDelegate
 *  net.thebrokenscript.brokencore.api.dsl.EntityUtil
 *  net.thebrokenscript.brokencore.api.dsl.SideUtil
 *  net.thebrokenscript.brokencore.api.dsl.SoundUtil
 *  net.thebrokenscript.brokencore.api.entity.FinalizedSpawn
 *  net.thebrokenscript.brokencore.api.entity.base.BaseMonster
 *  net.thebrokenscript.brokencore.api.entity.base.UwuableMonster
 *  net.thebrokenscript.brokencore.api.ext.EntityTypeExt
 *  net.thebrokenscript.brokencore.api.ext.TagExt
 *  net.thebrokenscript.brokencore.api.platform.CancelProxy
 *  net.thebrokenscript.brokencore.api.world.TimeOfDay
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  software.bernie.geckolib.animation.AnimatableManager$ControllerRegistrar
 */
package net.thebrokenscript.entity.nullent;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.text.HexExtensionsKt;
import kotlin.text.StringsKt;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializer;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.api.ext.LevelExt;
import net.thebrokenscript.api.ext.PlayerExt;
import net.thebrokenscript.brokencore.api.dsl.ChatUtil;
import net.thebrokenscript.brokencore.api.dsl.ClientDSLKt;
import net.thebrokenscript.brokencore.api.dsl.ComponentUtil;
import net.thebrokenscript.brokencore.api.dsl.EntityDataDelegate;
import net.thebrokenscript.brokencore.api.dsl.EntityUtil;
import net.thebrokenscript.brokencore.api.dsl.SideUtil;
import net.thebrokenscript.brokencore.api.dsl.SoundUtil;
import net.thebrokenscript.brokencore.api.entity.FinalizedSpawn;
import net.thebrokenscript.brokencore.api.entity.base.BaseMonster;
import net.thebrokenscript.brokencore.api.entity.base.UwuableMonster;
import net.thebrokenscript.brokencore.api.ext.EntityTypeExt;
import net.thebrokenscript.brokencore.api.ext.TagExt;
import net.thebrokenscript.brokencore.api.platform.CancelProxy;
import net.thebrokenscript.brokencore.api.world.TimeOfDay;
import net.thebrokenscript.client.data.ClientVariables;
import net.thebrokenscript.config.TBSConfigs;
import net.thebrokenscript.data.MapVariables;
import net.thebrokenscript.registry.TBSEntities;
import net.thebrokenscript.registry.TBSLang;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animation.AnimatableManager;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 62\u00020\u00012\u00020\u0002:\u00016B\u001d\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00000\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u0015\u001a\u00020\u0016H\u0014J\u0010\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0019H\u0014J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0018\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0016J\u0010\u0010#\u001a\u00020\u00162\u0006\u0010$\u001a\u00020%H\u0016J\u0010\u0010&\u001a\u00020\u00162\u0006\u0010$\u001a\u00020%H\u0016J\b\u0010'\u001a\u00020\u0016H\u0016J\u0010\u0010(\u001a\u00020\u00162\u0006\u0010)\u001a\u00020*H\u0016J\b\u0010+\u001a\u00020\u0016H\u0016J4\u0010,\u001a\u0004\u0018\u00010-2\u0006\u0010\u0005\u001a\u00020.2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u0002022\b\u00103\u001a\u0004\u0018\u00010-2\u0006\u00104\u001a\u000205H\u0016R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR+\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\n8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000e\u00a8\u00067"}, d2={"Lnet/thebrokenscript/entity/nullent/Xxram2dieEntity;", "Lnet/thebrokenscript/brokencore/api/entity/base/UwuableMonster;", "Lnet/thebrokenscript/brokencore/api/entity/FinalizedSpawn;", "type", "Lnet/minecraft/world/entity/EntityType;", "level", "Lnet/minecraft/world/level/Level;", "<init>", "(Lnet/minecraft/world/entity/EntityType;Lnet/minecraft/world/level/Level;)V", "ramTimer", "", "getRamTimer", "()I", "setRamTimer", "(I)V", "<set-?>", "invisTimer", "getInvisTimer", "setInvisTimer", "invisTimer$delegate", "Lnet/thebrokenscript/brokencore/api/dsl/EntityDataDelegate;", "registerGoals", "", "defineSynchedData", "builder", "Lnet/minecraft/network/syncher/SynchedEntityData$Builder;", "removeWhenFarAway", "", "distanceToClosestPlayer", "", "hurt", "source", "Lnet/minecraft/world/damagesource/DamageSource;", "amount", "", "addAdditionalSaveData", "compound", "Lnet/minecraft/nbt/CompoundTag;", "load", "baseTick", "registerControllers", "reg", "Lsoftware/bernie/geckolib/animation/AnimatableManager$ControllerRegistrar;", "tick", "onFinalizeSpawn", "Lnet/minecraft/world/entity/SpawnGroupData;", "Lnet/minecraft/world/level/ServerLevelAccessor;", "difficulty", "Lnet/minecraft/world/DifficultyInstance;", "spawnType", "Lnet/minecraft/world/entity/MobSpawnType;", "spawnData", "event", "Lnet/thebrokenscript/brokencore/api/platform/CancelProxy;", "Companion", "thebrokenscript-common"})
public final class Xxram2dieEntity
extends UwuableMonster
implements FinalizedSpawn {
    @NotNull
    public static final Companion Companion;
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;
    private int ramTimer;
    @NotNull
    private final EntityDataDelegate invisTimer$delegate;
    @NotNull
    private static final EntityDataAccessor<Integer> INVIS_TIMER;

    public Xxram2dieEntity(@NotNull EntityType<Xxram2dieEntity> type, @NotNull Level level) {
        Intrinsics.checkNotNullParameter(type, (String)"type");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        super(type, level);
        this.xpReward = 0;
        this.setNoAi(false);
        this.setCustomName((Component)TBSLang.INSTANCE.getRAM2DIE_NAME());
        this.setCustomNameVisible(true);
        this.setPersistenceRequired();
        this.invisTimer$delegate = this.entityData(INVIS_TIMER);
    }

    public final int getRamTimer() {
        return this.ramTimer;
    }

    public final void setRamTimer(int n) {
        this.ramTimer = n;
    }

    public final int getInvisTimer() {
        return ((Number)this.invisTimer$delegate.getValue((BaseMonster)this, $$delegatedProperties[0])).intValue();
    }

    public final void setInvisTimer(int n) {
        this.invisTimer$delegate.setValue((BaseMonster)this, $$delegatedProperties[0], (Object)n);
    }

    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(1, (Goal)new MeleeAttackGoal((PathfinderMob)this, 1.2, false));
        this.targetSelector.addGoal(3, (Goal)new HurtByTargetGoal((PathfinderMob)this, new Class[0]));
        this.goalSelector.addGoal(5, (Goal)new FloatGoal((Mob)this));
    }

    protected void defineSynchedData(@NotNull SynchedEntityData.Builder builder) {
        Intrinsics.checkNotNullParameter((Object)builder, (String)"builder");
        super.defineSynchedData(builder);
        builder.define(INVIS_TIMER, (Object)0);
    }

    public boolean removeWhenFarAway(double distanceToClosestPlayer) {
        return false;
    }

    public boolean hurt(@NotNull DamageSource source, float amount) {
        Intrinsics.checkNotNullParameter((Object)source, (String)"source");
        return Intrinsics.areEqual((Object)source.type(), (Object)DamageTypes.GENERIC_KILL) || Intrinsics.areEqual((Object)source.type(), (Object)DamageTypes.FELL_OUT_OF_WORLD);
    }

    public void addAdditionalSaveData(@NotNull CompoundTag compound) {
        Intrinsics.checkNotNullParameter((Object)compound, (String)"compound");
        super.addAdditionalSaveData(compound);
        compound.putInt("timer", this.ramTimer);
    }

    public void load(@NotNull CompoundTag compound) {
        Intrinsics.checkNotNullParameter((Object)compound, (String)"compound");
        super.load(compound);
        this.ramTimer = compound.getInt("timer");
    }

    public void baseTick() {
        Player player;
        super.baseTick();
        switch (TagExt.INSTANCE.incInt(EntityUtil.getPersistentData((Entity)((Entity)this)), "timer")) {
            case 1: {
                ChatUtil.chat$default((LevelAccessor)((LevelAccessor)this.getLevel()), (Component)((Component)TBSLang.INSTANCE.getRAM2DIE_HOSTED()), (boolean)false, (int)2, null);
                break;
            }
            case 500: {
                ChatUtil.chat$default((LevelAccessor)((LevelAccessor)this.getLevel()), (Component)((Component)TBSLang.INSTANCE.getRAM2DIE_JOIN()), (boolean)false, (int)2, null);
                this.setInvisible(false);
                TimeOfDay.MIDNIGHT.setFake();
                LevelAccessor levelAccessor = (LevelAccessor)this.getLevel();
                Vec3 vec3 = this.position();
                Intrinsics.checkNotNullExpressionValue((Object)vec3, (String)"position(...)");
                Object object = SoundEvents.AMBIENT_CAVE.value();
                Intrinsics.checkNotNullExpressionValue((Object)object, (String)"value(...)");
                SoundUtil.playSound$default((LevelAccessor)levelAccessor, (Vec3)vec3, (SoundEvent)((SoundEvent)object), (float)10.0f, (float)0.0f, null, (int)16, null);
                break;
            }
            case 1500: {
                LevelAccessor levelAccessor = (LevelAccessor)this.getLevel();
                String string = ComponentUtil.getTranslationKey((Component)((Component)TBSLang.INSTANCE.getRAM2DIE_CHAT_MSG()));
                Intrinsics.checkNotNull((Object)string);
                Object[] objectArray = new Object[]{HexExtensionsKt.toHexString$default((byte[])StringsKt.encodeToByteArray((String)"Hello?"), null, (int)1, null)};
                MutableComponent mutableComponent = Component.translatable((String)string, (Object[])objectArray);
                Intrinsics.checkNotNullExpressionValue((Object)mutableComponent, (String)"translatable(...)");
                ChatUtil.chat$default((LevelAccessor)levelAccessor, (Component)((Component)mutableComponent), (boolean)false, (int)2, null);
                TimeOfDay.MIDNIGHT.setFake();
                LevelAccessor levelAccessor2 = (LevelAccessor)this.getLevel();
                Vec3 vec3 = this.position();
                Intrinsics.checkNotNullExpressionValue((Object)vec3, (String)"position(...)");
                Object object = SoundEvents.AMBIENT_CAVE.value();
                Intrinsics.checkNotNullExpressionValue((Object)object, (String)"value(...)");
                SoundUtil.playSound$default((LevelAccessor)levelAccessor2, (Vec3)vec3, (SoundEvent)((SoundEvent)object), (float)10.0f, (float)0.0f, null, (int)16, null);
                break;
            }
            case 2000: {
                LevelAccessor levelAccessor = (LevelAccessor)this.getLevel();
                String string = ComponentUtil.getTranslationKey((Component)((Component)TBSLang.INSTANCE.getRAM2DIE_CHAT_MSG()));
                Intrinsics.checkNotNull((Object)string);
                Object[] objectArray = new Object[]{HexExtensionsKt.toHexString$default((byte[])StringsKt.encodeToByteArray((String)"How did you find this server?"), null, (int)1, null)};
                MutableComponent mutableComponent = Component.translatable((String)string, (Object[])objectArray);
                Intrinsics.checkNotNullExpressionValue((Object)mutableComponent, (String)"translatable(...)");
                ChatUtil.chat$default((LevelAccessor)levelAccessor, (Component)((Component)mutableComponent), (boolean)false, (int)2, null);
                TimeOfDay.MIDNIGHT.setFake();
                LevelAccessor levelAccessor3 = (LevelAccessor)this.getLevel();
                Vec3 vec3 = this.position();
                Intrinsics.checkNotNullExpressionValue((Object)vec3, (String)"position(...)");
                Object object = SoundEvents.AMBIENT_CAVE.value();
                Intrinsics.checkNotNullExpressionValue((Object)object, (String)"value(...)");
                SoundUtil.playSound$default((LevelAccessor)levelAccessor3, (Vec3)vec3, (SoundEvent)((SoundEvent)object), (float)10.0f, (float)0.0f, null, (int)16, null);
                break;
            }
            case 2500: {
                LevelAccessor levelAccessor = (LevelAccessor)this.getLevel();
                String string = ComponentUtil.getTranslationKey((Component)((Component)TBSLang.INSTANCE.getRAM2DIE_CHAT_MSG()));
                Intrinsics.checkNotNull((Object)string);
                Object[] objectArray = new Object[]{HexExtensionsKt.toHexString$default((byte[])StringsKt.encodeToByteArray((String)"Do you want to be friends?"), null, (int)1, null)};
                MutableComponent mutableComponent = Component.translatable((String)string, (Object[])objectArray);
                Intrinsics.checkNotNullExpressionValue((Object)mutableComponent, (String)"translatable(...)");
                ChatUtil.chat$default((LevelAccessor)levelAccessor, (Component)((Component)mutableComponent), (boolean)false, (int)2, null);
                TimeOfDay.DAY.setFake();
                LevelAccessor levelAccessor4 = (LevelAccessor)this.getLevel();
                Vec3 vec3 = this.position();
                Intrinsics.checkNotNullExpressionValue((Object)vec3, (String)"position(...)");
                Object object = SoundEvents.AMBIENT_CAVE.value();
                Intrinsics.checkNotNullExpressionValue((Object)object, (String)"value(...)");
                SoundUtil.playSound$default((LevelAccessor)levelAccessor4, (Vec3)vec3, (SoundEvent)((SoundEvent)object), (float)10.0f, (float)0.0f, null, (int)16, null);
                break;
            }
            case 3000: {
                LevelAccessor levelAccessor = (LevelAccessor)this.getLevel();
                String string = ComponentUtil.getTranslationKey((Component)((Component)TBSLang.INSTANCE.getRAM2DIE_CHAT_MSG()));
                Intrinsics.checkNotNull((Object)string);
                Object[] objectArray = new Object[]{HexExtensionsKt.toHexString$default((byte[])StringsKt.encodeToByteArray((String)"Leave."), null, (int)1, null)};
                MutableComponent mutableComponent = Component.translatable((String)string, (Object[])objectArray);
                Intrinsics.checkNotNullExpressionValue((Object)mutableComponent, (String)"translatable(...)");
                ChatUtil.chat$default((LevelAccessor)levelAccessor, (Component)((Component)mutableComponent), (boolean)false, (int)2, null);
                TimeOfDay.NIGHT.setFake();
                LevelAccessor levelAccessor5 = (LevelAccessor)this.getLevel();
                Vec3 vec3 = this.position();
                Intrinsics.checkNotNullExpressionValue((Object)vec3, (String)"position(...)");
                Object object = SoundEvents.AMBIENT_CAVE.value();
                Intrinsics.checkNotNullExpressionValue((Object)object, (String)"value(...)");
                SoundUtil.playSound$default((LevelAccessor)levelAccessor5, (Vec3)vec3, (SoundEvent)((SoundEvent)object), (float)10.0f, (float)0.0f, null, (int)16, null);
                break;
            }
            case 3500: {
                ChatUtil.chat$default((LevelAccessor)((LevelAccessor)this.getLevel()), (Component)((Component)TBSLang.INSTANCE.getRAM2DIE_LEAVE()), (boolean)false, (int)2, null);
                this.discard();
            }
        }
        if (this.getInvisTimer() > 0) {
            int n = this.getInvisTimer();
            this.setInvisTimer(n + -1);
            if (this.getInvisTimer() <= 0) {
                this.setInvisible(false);
            }
        }
        if (this.isInvisible()) {
            return;
        }
        Level level = this.level();
        Vec3 pos = this.position();
        if (!(level instanceof ServerLevel)) {
            return;
        }
        if (((ServerLevel)level).getBlockState(this.blockPosition()).canOcclude()) {
            Entity entity = (Entity)this;
            Vec3 vec3 = pos.add(0.0, 1.0, 0.0);
            Intrinsics.checkNotNullExpressionValue((Object)vec3, (String)"add(...)");
            EntityUtil.teleport((Entity)entity, (Vec3)vec3);
        }
        if ((player = ((ServerLevel)level).getNearestPlayer((Entity)this, 520.0)) != null) {
            this.lookControl.setLookAt(player.getEyePosition());
            Entity entity = (Entity)player;
            Intrinsics.checkNotNull((Object)pos);
            if (EntityUtil.isWithin((Entity)entity, (Vec3)pos, (Number)25.0)) {
                Vec3 directionToPlayer = player.position().subtract(this.position()).normalize();
                BlockHitResult raycast = ((ServerLevel)level).clip(new ClipContext(this.getEyePosition(), player.getEyePosition().add(directionToPlayer.scale(42.0)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, (Entity)player));
                this.setInvisTimer(10);
                this.setInvisible(true);
                this.setPos(raycast.getBlockPos().getCenter());
                if (TagExt.INSTANCE.incInt(EntityUtil.getPersistentData((Entity)((Entity)this)), "Anger") == 10) {
                    this.discard();
                    if ((double)this.random.nextFloat() < 0.7) {
                        EntityUtil.applyRandomRotation((Entity)EntityTypeExt.trySummon((EntityType)((EntityType)TBSEntities.NULL_CHASE.get()), (LevelAccessor)((LevelAccessor)level), (Vec3)this.getPos()));
                    } else if (!TBSConfigs.INSTANCE.getServer().getDisableBanning()) {
                        EntityUtil.applyRandomRotation((Entity)EntityTypeExt.trySummon((EntityType)((EntityType)TBSEntities.BAN.get()), (LevelAccessor)((LevelAccessor)level), (Vec3)this.getPos()));
                    }
                }
            }
        }
        this.refreshDimensions();
    }

    public void registerControllers(@NotNull AnimatableManager.ControllerRegistrar reg) {
        Intrinsics.checkNotNullParameter((Object)reg, (String)"reg");
    }

    public void tick() {
        super.tick();
        SideUtil.clientSide((Entity)((Entity)this), () -> Xxram2dieEntity.tick$lambda$0(this));
    }

    @Nullable
    public SpawnGroupData onFinalizeSpawn(@NotNull ServerLevelAccessor level, @NotNull DifficultyInstance difficulty, @NotNull MobSpawnType spawnType, @Nullable SpawnGroupData spawnData, @NotNull CancelProxy event) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)difficulty, (String)"difficulty");
        Intrinsics.checkNotNullParameter((Object)spawnType, (String)"spawnType");
        Intrinsics.checkNotNullParameter((Object)event, (String)"event");
        if (!LevelExt.INSTANCE.getVars((LevelAccessor)level).getHasRam2DieJoined()) {
            LevelExt.INSTANCE.updateVars((LevelAccessor)level, (Function1<? super MapVariables, Unit>)((Function1)Xxram2dieEntity::onFinalizeSpawn$lambda$0));
        }
        EntityUtil.getPersistentData((Entity)((Entity)this)).putInt("Anger", 0);
        this.setInvisible(true);
        return null;
    }

    private static final Object tick$lambda$0(Xxram2dieEntity this$0) {
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

    private static final Unit onFinalizeSpawn$lambda$0(MapVariables $this$updateVars) {
        Intrinsics.checkNotNullParameter((Object)((Object)$this$updateVars), (String)"$this$updateVars");
        $this$updateVars.setHasRam2DieJoined(true);
        return Unit.INSTANCE;
    }

    static {
        KProperty[] kPropertyArray = new KProperty[]{Reflection.mutableProperty1((MutablePropertyReference1)((MutablePropertyReference1)new MutablePropertyReference1Impl(Xxram2dieEntity.class, "invisTimer", "getInvisTimer()I", 0)))};
        $$delegatedProperties = kPropertyArray;
        Companion = new Companion(null);
        EntityDataAccessor entityDataAccessor = SynchedEntityData.defineId(Xxram2dieEntity.class, (EntityDataSerializer)EntityDataSerializers.INT);
        Intrinsics.checkNotNullExpressionValue((Object)entityDataAccessor, (String)"defineId(...)");
        INVIS_TIMER = entityDataAccessor;
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\t"}, d2={"Lnet/thebrokenscript/entity/nullent/Xxram2dieEntity$Companion;", "", "<init>", "()V", "INVIS_TIMER", "Lnet/minecraft/network/syncher/EntityDataAccessor;", "", "getINVIS_TIMER", "()Lnet/minecraft/network/syncher/EntityDataAccessor;", "thebrokenscript-common"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final EntityDataAccessor<Integer> getINVIS_TIMER() {
            return INVIS_TIMER;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

