/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
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
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Holder
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.network.chat.Component
 *  net.minecraft.network.syncher.EntityDataAccessor
 *  net.minecraft.network.syncher.EntityDataSerializer
 *  net.minecraft.network.syncher.EntityDataSerializers
 *  net.minecraft.network.syncher.SynchedEntityData
 *  net.minecraft.network.syncher.SynchedEntityData$Builder
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.sounds.SoundSource
 *  net.minecraft.world.DifficultyInstance
 *  net.minecraft.world.damagesource.DamageSource
 *  net.minecraft.world.damagesource.DamageTypes
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.Mob
 *  net.minecraft.world.entity.MobSpawnType
 *  net.minecraft.world.entity.SpawnGroupData
 *  net.minecraft.world.entity.ai.attributes.AttributeInstance
 *  net.minecraft.world.entity.ai.attributes.Attributes
 *  net.minecraft.world.entity.ai.goal.Goal
 *  net.minecraft.world.entity.ai.goal.LookAtPlayerGoal
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.level.ServerLevelAccessor
 *  net.minecraft.world.level.levelgen.Heightmap$Types
 *  net.minecraft.world.phys.Vec3
 *  net.thebrokenscript.brokencore.api.dsl.EntityDataDelegate
 *  net.thebrokenscript.brokencore.api.dsl.SoundUtil
 *  net.thebrokenscript.brokencore.api.entity.FinalizedSpawn
 *  net.thebrokenscript.brokencore.api.entity.base.BaseMonster
 *  net.thebrokenscript.brokencore.api.entity.base.UwuableMonster
 *  net.thebrokenscript.brokencore.api.ext.EntityTypeExt
 *  net.thebrokenscript.brokencore.api.platform.CancelProxy
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  software.bernie.geckolib.animatable.GeoAnimatable
 *  software.bernie.geckolib.animation.AnimatableManager$ControllerRegistrar
 *  software.bernie.geckolib.animation.AnimationController
 *  software.bernie.geckolib.animation.AnimationState
 *  software.bernie.geckolib.animation.PlayState
 *  software.bernie.geckolib.animation.RawAnimation
 */
package net.thebrokenscript.entity.tbe;

import java.util.Collection;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
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
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializer;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.brokencore.api.dsl.EntityDataDelegate;
import net.thebrokenscript.brokencore.api.dsl.SoundUtil;
import net.thebrokenscript.brokencore.api.entity.FinalizedSpawn;
import net.thebrokenscript.brokencore.api.entity.base.BaseMonster;
import net.thebrokenscript.brokencore.api.entity.base.UwuableMonster;
import net.thebrokenscript.brokencore.api.ext.EntityTypeExt;
import net.thebrokenscript.brokencore.api.platform.CancelProxy;
import net.thebrokenscript.registry.TBSEntities;
import net.thebrokenscript.registry.TBSSounds;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.animation.AnimationController;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.animation.PlayState;
import software.bernie.geckolib.animation.RawAnimation;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 ?2\u00020\u00012\u00020\u0002:\u0001?B\u001d\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00000\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u001d\u001a\u00020\u001eH\u0014J\u0010\u0010\u001f\u001a\u00020\r2\u0006\u0010 \u001a\u00020!H\u0016J\u0018\u0010\"\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0016J\b\u0010&\u001a\u00020\u001eH\u0016J\u0018\u0010'\u001a\u00020\r2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+H\u0016J\u0010\u0010,\u001a\u00020\u001e2\u0006\u0010-\u001a\u00020.H\u0016J4\u0010/\u001a\u0004\u0018\u0001002\u0006\u0010\u0005\u001a\u0002012\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u00020%2\b\u00105\u001a\u0004\u0018\u0001002\u0006\u00106\u001a\u000207H\u0016J\u0010\u00108\u001a\u00020\u001e2\u0006\u00109\u001a\u00020:H\u0014J\u0010\u0010;\u001a\u00020\u001e2\u0006\u0010<\u001a\u00020=H\u0016J\u0010\u0010>\u001a\u00020\u001e2\u0006\u0010<\u001a\u00020=H\u0016R\u000e\u0010\t\u001a\u00020\nX\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R$\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R+\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\n8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a\u00a8\u0006@"}, d2={"Lnet/thebrokenscript/entity/tbe/TheBrokenEndAmbushEntity;", "Lnet/thebrokenscript/brokencore/api/entity/base/UwuableMonster;", "Lnet/thebrokenscript/brokencore/api/entity/FinalizedSpawn;", "type", "Lnet/minecraft/world/entity/EntityType;", "level", "Lnet/minecraft/world/level/Level;", "<init>", "(Lnet/minecraft/world/entity/EntityType;Lnet/minecraft/world/level/Level;)V", "despawnTicks", "", "despawnTimer", "value", "", "isDespawning", "()Z", "setDespawning", "(Z)V", "lifetime", "aliveTicks", "spawnTBE", "<set-?>", "variant", "getVariant", "()I", "setVariant", "(I)V", "variant$delegate", "Lnet/thebrokenscript/brokencore/api/dsl/EntityDataDelegate;", "registerGoals", "", "removeWhenFarAway", "distanceToClosestPlayer", "", "checkSpawnRules", "Lnet/minecraft/world/level/LevelAccessor;", "reason", "Lnet/minecraft/world/entity/MobSpawnType;", "baseTick", "hurt", "source", "Lnet/minecraft/world/damagesource/DamageSource;", "amount", "", "registerControllers", "reg", "Lsoftware/bernie/geckolib/animation/AnimatableManager$ControllerRegistrar;", "onFinalizeSpawn", "Lnet/minecraft/world/entity/SpawnGroupData;", "Lnet/minecraft/world/level/ServerLevelAccessor;", "difficulty", "Lnet/minecraft/world/DifficultyInstance;", "spawnType", "spawnData", "event", "Lnet/thebrokenscript/brokencore/api/platform/CancelProxy;", "defineSynchedData", "builder", "Lnet/minecraft/network/syncher/SynchedEntityData$Builder;", "addAdditionalSaveData", "compound", "Lnet/minecraft/nbt/CompoundTag;", "readAdditionalSaveData", "Companion", "thebrokenscript-common"})
@SourceDebugExtension(value={"SMAP\nTheBrokenEndAmbushEntity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TheBrokenEndAmbushEntity.kt\nnet/thebrokenscript/entity/tbe/TheBrokenEndAmbushEntity\n+ 2 ComponentDSL.kt\nnet/thebrokenscript/brokencore/api/dsl/ComponentUtil\n*L\n1#1,181:1\n15#2:182\n15#2:183\n15#2:184\n15#2:185\n*S KotlinDebug\n*F\n+ 1 TheBrokenEndAmbushEntity.kt\nnet/thebrokenscript/entity/tbe/TheBrokenEndAmbushEntity\n*L\n138#1:182\n139#1:183\n140#1:184\n141#1:185\n*E\n"})
public final class TheBrokenEndAmbushEntity
extends UwuableMonster
implements FinalizedSpawn {
    @NotNull
    public static final Companion Companion;
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;
    private final int despawnTicks;
    private int despawnTimer;
    private int lifetime;
    private int aliveTicks;
    private boolean spawnTBE;
    @NotNull
    private final EntityDataDelegate variant$delegate;
    @NotNull
    private static final EntityDataAccessor<Boolean> DESPAWNING;
    @NotNull
    private static final EntityDataAccessor<Integer> VARIANT;

    public TheBrokenEndAmbushEntity(@NotNull EntityType<TheBrokenEndAmbushEntity> type, @NotNull Level level) {
        Intrinsics.checkNotNullParameter(type, (String)"type");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        super(type, level);
        AttributeInstance attributeInstance = this.getAttribute(Attributes.STEP_HEIGHT);
        Intrinsics.checkNotNull((Object)attributeInstance);
        attributeInstance.setBaseValue(0.6);
        this.xpReward = 0;
        this.setNoAi(false);
        this.setPersistenceRequired();
        this.despawnTicks = 26;
        this.lifetime = RangesKt.random((IntRange)new IntRange(18000, 24000), (Random)((Random)Random.Default));
        this.spawnTBE = true;
        this.variant$delegate = this.entityData(VARIANT);
    }

    public final boolean isDespawning() {
        Object object = this.entityData.get(DESPAWNING);
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"get(...)");
        return (Boolean)object;
    }

    public final void setDespawning(boolean value) {
        this.entityData.set(DESPAWNING, (Object)value);
    }

    public final int getVariant() {
        return ((Number)this.variant$delegate.getValue((BaseMonster)this, $$delegatedProperties[0])).intValue();
    }

    public final void setVariant(int n) {
        this.variant$delegate.setValue((BaseMonster)this, $$delegatedProperties[0], (Object)n);
    }

    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(1, (Goal)new LookAtPlayerGoal((Mob)this, Player.class, 400.0f, 1.0f));
    }

    public boolean removeWhenFarAway(double distanceToClosestPlayer) {
        return false;
    }

    public boolean checkSpawnRules(@NotNull LevelAccessor level, @NotNull MobSpawnType reason) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)reason, (String)"reason");
        return true;
    }

    public void baseTick() {
        super.baseTick();
        if (this.getLevel().isClientSide) {
            return;
        }
        if (this.isDespawning()) {
            ++this.despawnTimer;
            if (this.despawnTimer >= this.despawnTicks) {
                if (this.spawnTBE) {
                    Player player = this.getLevel().getNearestPlayer((Entity)this, 512.0);
                    if (player != null) {
                        Player player2 = player;
                        boolean bl = false;
                        double distance = (double)15 + this.getLevel().random.nextDouble() * (double)15;
                        double targetX = player2.position().x - player2.getLookAngle().x * distance;
                        double targetZ = player2.position().z - player2.getLookAngle().z * distance;
                        Level level = this.getLevel();
                        Intrinsics.checkNotNull((Object)level, (String)"null cannot be cast to non-null type net.minecraft.server.level.ServerLevel");
                        BlockPos surfacePos = ((ServerLevel)level).getHeightmapPos(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, new BlockPos((int)targetX, 0, (int)targetZ));
                        EntityTypeExt.trySummon((EntityType)((EntityType)TBSEntities.THE_BROKEN_END.get()), (LevelAccessor)((LevelAccessor)this.getLevel()), (Vec3)new Vec3(targetX, (double)surfacePos.getY(), targetZ));
                    }
                }
                this.discard();
            }
            return;
        }
        ++this.aliveTicks;
        if (this.aliveTicks >= this.lifetime) {
            this.spawnTBE = false;
            this.setDespawning(true);
            return;
        }
        if (this.getLevel().getNearestPlayer((Entity)this, 15.0) == null) {
            return;
        }
        this.setDespawning(true);
        SoundUtil.playSound((LevelAccessor)((LevelAccessor)this.getLevel()), (Vec3)this.getPos(), (Holder)((Holder)TBSSounds.REEL), (float)1.0f, (float)1.0f, (SoundSource)SoundSource.HOSTILE);
    }

    public boolean hurt(@NotNull DamageSource source, float amount) {
        Intrinsics.checkNotNullParameter((Object)source, (String)"source");
        return Intrinsics.areEqual((Object)source.type(), (Object)DamageTypes.GENERIC_KILL) || Intrinsics.areEqual((Object)source.type(), (Object)DamageTypes.FELL_OUT_OF_WORLD);
    }

    public void registerControllers(@NotNull AnimatableManager.ControllerRegistrar reg) {
        Intrinsics.checkNotNullParameter((Object)reg, (String)"reg");
        reg.add(new AnimationController((GeoAnimatable)this, "main", 0, arg_0 -> TheBrokenEndAmbushEntity.registerControllers$lambda$0(this, arg_0)));
    }

    @Nullable
    public SpawnGroupData onFinalizeSpawn(@NotNull ServerLevelAccessor level, @NotNull DifficultyInstance difficulty, @NotNull MobSpawnType spawnType, @Nullable SpawnGroupData spawnData, @NotNull CancelProxy event) {
        Component component;
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)difficulty, (String)"difficulty");
        Intrinsics.checkNotNullParameter((Object)spawnType, (String)"spawnType");
        Intrinsics.checkNotNullParameter((Object)event, (String)"event");
        if (!(level instanceof ServerLevel)) {
            return null;
        }
        Object[] objectArray = new Integer[]{1, 1, 2, 3};
        this.setVariant(((Number)CollectionsKt.random((Collection)CollectionsKt.listOf((Object[])objectArray), (Random)((Random)Random.Default))).intValue());
        switch (this.getVariant()) {
            case 1: {
                String $this$c$iv = "Not_It_Cal";
                boolean $i$f$getC = false;
                Component component2 = Component.nullToEmpty((String)$this$c$iv);
                component = component2;
                Intrinsics.checkNotNullExpressionValue((Object)component2, (String)"nullToEmpty(...)");
                break;
            }
            case 2: {
                String $this$c$iv = "uImmortal_";
                boolean $i$f$getC = false;
                Component component3 = Component.nullToEmpty((String)$this$c$iv);
                component = component3;
                Intrinsics.checkNotNullExpressionValue((Object)component3, (String)"nullToEmpty(...)");
                break;
            }
            case 3: {
                String $this$c$iv = "99_thatOneteChFella_99";
                boolean $i$f$getC = false;
                Component component4 = Component.nullToEmpty((String)$this$c$iv);
                component = component4;
                Intrinsics.checkNotNullExpressionValue((Object)component4, (String)"nullToEmpty(...)");
                break;
            }
            default: {
                String $this$c$iv = "???";
                boolean $i$f$getC = false;
                Component component5 = Component.nullToEmpty((String)$this$c$iv);
                component = component5;
                Intrinsics.checkNotNullExpressionValue((Object)component5, (String)"nullToEmpty(...)");
            }
        }
        this.setCustomName(component);
        this.setCustomNameVisible(true);
        return null;
    }

    protected void defineSynchedData(@NotNull SynchedEntityData.Builder builder) {
        Intrinsics.checkNotNullParameter((Object)builder, (String)"builder");
        super.defineSynchedData(builder);
        builder.define(DESPAWNING, (Object)false);
        builder.define(VARIANT, (Object)1);
    }

    public void addAdditionalSaveData(@NotNull CompoundTag compound) {
        Intrinsics.checkNotNullParameter((Object)compound, (String)"compound");
        super.addAdditionalSaveData(compound);
        compound.putInt("AliveTicks", this.aliveTicks);
        compound.putInt("Lifetime", this.lifetime);
        compound.putInt("variant", this.getVariant());
    }

    public void readAdditionalSaveData(@NotNull CompoundTag compound) {
        Intrinsics.checkNotNullParameter((Object)compound, (String)"compound");
        super.readAdditionalSaveData(compound);
        if (compound.contains("AliveTicks")) {
            this.aliveTicks = compound.getInt("AliveTicks");
        }
        if (compound.contains("Lifetime")) {
            this.lifetime = compound.getInt("Lifetime");
        }
        if (compound.contains("variant")) {
            this.entityData.set(VARIANT, (Object)compound.getInt("variant"));
        }
    }

    private static final PlayState registerControllers$lambda$0(TheBrokenEndAmbushEntity this$0, AnimationState state) {
        if (this$0.isDespawning()) {
            state.getController().setAnimation(RawAnimation.begin().thenPlayAndHold("despawn"));
        } else {
            state.getController().setAnimation(RawAnimation.begin().thenPlay("spawn").thenLoop("idle"));
        }
        return PlayState.CONTINUE;
    }

    static {
        KProperty[] kPropertyArray = new KProperty[]{Reflection.mutableProperty1((MutablePropertyReference1)((MutablePropertyReference1)new MutablePropertyReference1Impl(TheBrokenEndAmbushEntity.class, "variant", "getVariant()I", 0)))};
        $$delegatedProperties = kPropertyArray;
        Companion = new Companion(null);
        EntityDataAccessor entityDataAccessor = SynchedEntityData.defineId(TheBrokenEndAmbushEntity.class, (EntityDataSerializer)EntityDataSerializers.BOOLEAN);
        Intrinsics.checkNotNullExpressionValue((Object)entityDataAccessor, (String)"defineId(...)");
        DESPAWNING = entityDataAccessor;
        EntityDataAccessor entityDataAccessor2 = SynchedEntityData.defineId(TheBrokenEndAmbushEntity.class, (EntityDataSerializer)EntityDataSerializers.INT);
        Intrinsics.checkNotNullExpressionValue((Object)entityDataAccessor2, (String)"defineId(...)");
        VARIANT = entityDataAccessor2;
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u000b"}, d2={"Lnet/thebrokenscript/entity/tbe/TheBrokenEndAmbushEntity$Companion;", "", "<init>", "()V", "DESPAWNING", "Lnet/minecraft/network/syncher/EntityDataAccessor;", "", "VARIANT", "", "getVARIANT", "()Lnet/minecraft/network/syncher/EntityDataAccessor;", "thebrokenscript-common"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final EntityDataAccessor<Integer> getVARIANT() {
            return VARIANT;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

