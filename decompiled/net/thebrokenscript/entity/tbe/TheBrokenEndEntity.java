/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.ranges.RangesKt
 *  net.minecraft.client.player.LocalPlayer
 *  net.minecraft.client.resources.sounds.SoundInstance
 *  net.minecraft.core.BlockPos
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.network.chat.Component
 *  net.minecraft.network.syncher.EntityDataAccessor
 *  net.minecraft.network.syncher.EntityDataSerializer
 *  net.minecraft.network.syncher.EntityDataSerializers
 *  net.minecraft.network.syncher.SynchedEntityData
 *  net.minecraft.network.syncher.SynchedEntityData$Builder
 *  net.minecraft.resources.ResourceKey
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.server.level.ServerPlayer
 *  net.minecraft.sounds.SoundEvent
 *  net.minecraft.sounds.SoundSource
 *  net.minecraft.util.RandomSource
 *  net.minecraft.world.DifficultyInstance
 *  net.minecraft.world.InteractionHand
 *  net.minecraft.world.damagesource.DamageSource
 *  net.minecraft.world.damagesource.DamageSources
 *  net.minecraft.world.damagesource.DamageTypes
 *  net.minecraft.world.effect.MobEffectInstance
 *  net.minecraft.world.effect.MobEffects
 *  net.minecraft.world.entity.AreaEffectCloud
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.Mob
 *  net.minecraft.world.entity.MobSpawnType
 *  net.minecraft.world.entity.PathfinderMob
 *  net.minecraft.world.entity.SpawnGroupData
 *  net.minecraft.world.entity.ai.attributes.AttributeInstance
 *  net.minecraft.world.entity.ai.attributes.Attributes
 *  net.minecraft.world.entity.ai.goal.FloatGoal
 *  net.minecraft.world.entity.ai.goal.Goal
 *  net.minecraft.world.entity.ai.goal.MeleeAttackGoal
 *  net.minecraft.world.entity.ai.goal.RandomLookAroundGoal
 *  net.minecraft.world.entity.ai.goal.RandomStrollGoal
 *  net.minecraft.world.entity.ai.goal.target.TargetGoal
 *  net.minecraft.world.entity.ai.navigation.GroundPathNavigation
 *  net.minecraft.world.entity.ai.navigation.PathNavigation
 *  net.minecraft.world.entity.ai.targeting.TargetingConditions
 *  net.minecraft.world.entity.animal.IronGolem
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.entity.projectile.AbstractArrow
 *  net.minecraft.world.entity.projectile.ThrownPotion
 *  net.minecraft.world.entity.vehicle.Boat
 *  net.minecraft.world.level.BlockGetter
 *  net.minecraft.world.level.GameType
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.level.ServerLevelAccessor
 *  net.minecraft.world.level.block.Block
 *  net.minecraft.world.level.block.Blocks
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.material.FluidState
 *  net.minecraft.world.level.pathfinder.PathType
 *  net.minecraft.world.phys.AABB
 *  net.minecraft.world.phys.Vec3
 *  net.thebrokenscript.brokencore.api.dsl.ClientDSLKt
 *  net.thebrokenscript.brokencore.api.dsl.EntityFinder
 *  net.thebrokenscript.brokencore.api.dsl.EntityUtil
 *  net.thebrokenscript.brokencore.api.dsl.LevelUtil
 *  net.thebrokenscript.brokencore.api.dsl.PlayerUtil
 *  net.thebrokenscript.brokencore.api.dsl.SideUtil
 *  net.thebrokenscript.brokencore.api.entity.FinalizedSpawn
 *  net.thebrokenscript.brokencore.api.entity.base.BaseMonster
 *  net.thebrokenscript.brokencore.api.entity.base.UwuableMonster
 *  net.thebrokenscript.brokencore.api.ext.BaseMonsterExtKt
 *  net.thebrokenscript.brokencore.api.ext.DamageSourcesExt
 *  net.thebrokenscript.brokencore.api.ext.EntityTypeExt
 *  net.thebrokenscript.brokencore.api.ext.TagExt
 *  net.thebrokenscript.brokencore.api.platform.CancelProxy
 *  net.thebrokenscript.brokencore.api.platform.PlatformUtil
 *  net.thebrokenscript.brokencore.api.sound.FancyEntitySoundInstance
 *  net.thebrokenscript.brokencore.api.sound.fx.AudioEffect
 *  net.thebrokenscript.brokencore.api.sound.fx.ReverbPreset
 *  net.thebrokenscript.brokencore.api.sound.fx.ReverbPresets
 *  net.thebrokenscript.brokencore.api.world.TimeOfDay
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

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.resources.sounds.SoundInstance;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializer;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageSources;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.AreaEffectCloud;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.TargetGoal;
import net.minecraft.world.entity.ai.navigation.GroundPathNavigation;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.ThrownPotion;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.pathfinder.PathType;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.api.TBSConstants;
import net.thebrokenscript.api.ext.PlayerExt;
import net.thebrokenscript.brokencore.api.dsl.ClientDSLKt;
import net.thebrokenscript.brokencore.api.dsl.EntityFinder;
import net.thebrokenscript.brokencore.api.dsl.EntityUtil;
import net.thebrokenscript.brokencore.api.dsl.LevelUtil;
import net.thebrokenscript.brokencore.api.dsl.PlayerUtil;
import net.thebrokenscript.brokencore.api.dsl.SideUtil;
import net.thebrokenscript.brokencore.api.entity.FinalizedSpawn;
import net.thebrokenscript.brokencore.api.entity.base.BaseMonster;
import net.thebrokenscript.brokencore.api.entity.base.UwuableMonster;
import net.thebrokenscript.brokencore.api.ext.BaseMonsterExtKt;
import net.thebrokenscript.brokencore.api.ext.DamageSourcesExt;
import net.thebrokenscript.brokencore.api.ext.EntityTypeExt;
import net.thebrokenscript.brokencore.api.ext.TagExt;
import net.thebrokenscript.brokencore.api.platform.CancelProxy;
import net.thebrokenscript.brokencore.api.platform.PlatformUtil;
import net.thebrokenscript.brokencore.api.sound.FancyEntitySoundInstance;
import net.thebrokenscript.brokencore.api.sound.fx.AudioEffect;
import net.thebrokenscript.brokencore.api.sound.fx.ReverbPreset;
import net.thebrokenscript.brokencore.api.sound.fx.ReverbPresets;
import net.thebrokenscript.brokencore.api.world.TimeOfDay;
import net.thebrokenscript.client.data.ClientVariables;
import net.thebrokenscript.config.TBSConfigs;
import net.thebrokenscript.registry.TBSEntities;
import net.thebrokenscript.registry.TBSLang;
import net.thebrokenscript.registry.TBSSounds;
import net.thebrokenscript.util.RepTier;
import net.thebrokenscript.util.RepUtilKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.animation.AnimationController;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.animation.PlayState;
import software.bernie.geckolib.animation.RawAnimation;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u00ae\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 W2\u00020\u00012\u00020\u0002:\u0003UVWB\u001d\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00000\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u0016\u001a\u00020\u0017H\u0014J\b\u0010\u0018\u001a\u00020\u000eH\u0016J\b\u0010\u0019\u001a\u00020\u000eH\u0016J\u0006\u0010\u001a\u001a\u00020\u0017J\u0006\u0010\u001b\u001a\u00020\u000eJ\u000e\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u001eJ\u0012\u0010\u001f\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010 \u001a\u00020\u000eJ\u0010\u0010!\u001a\u00020\n2\u0006\u0010\"\u001a\u00020#H\u0016J\u0010\u0010$\u001a\u00020\u00172\u0006\u0010\u0005\u001a\u00020%H\u0002J\b\u0010&\u001a\u00020#H\u0016J\u0018\u0010'\u001a\u00020\n2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+H\u0016J\u0010\u00100\u001a\u00020\u00172\u0006\u00101\u001a\u000202H\u0014J\u0010\u00103\u001a\u00020\u00172\u0006\u00104\u001a\u000205H\u0016J\u0010\u00106\u001a\u00020\u00172\u0006\u00104\u001a\u000205H\u0016J\b\u00107\u001a\u00020\u0017H\u0016J\b\u00108\u001a\u00020\u0017H\u0016J\u0010\u00109\u001a\u00020\n2\u0006\u0010:\u001a\u00020;H\u0016J4\u0010<\u001a\u0004\u0018\u00010=2\u0006\u0010\u0005\u001a\u00020>2\u0006\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020B2\b\u0010C\u001a\u0004\u0018\u00010=2\u0006\u0010D\u001a\u00020EH\u0016J \u0010F\u001a\u00020\u00172\u0006\u0010G\u001a\u00020;2\u0006\u0010H\u001a\u00020\u000e2\u0006\u0010I\u001a\u00020)H\u0016J\b\u0010J\u001a\u00020\u0017H\u0016J\u0010\u0010K\u001a\u00020\n2\u0006\u0010L\u001a\u00020#H\u0016J\b\u0010M\u001a\u00020NH\u0016J\u0010\u0010O\u001a\u00020\u00172\u0006\u0010P\u001a\u00020QH\u0016J\u0010\u0010R\u001a\u00020\n2\u0006\u0010S\u001a\u00020TH\u0016R\u001e\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001e\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\u000e@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R$\u0010,\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\u000e8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b-\u0010\u0011\"\u0004\b.\u0010/\u00a8\u0006X"}, d2={"Lnet/thebrokenscript/entity/tbe/TheBrokenEndEntity;", "Lnet/thebrokenscript/brokencore/api/entity/base/UwuableMonster;", "Lnet/thebrokenscript/brokencore/api/entity/FinalizedSpawn;", "type", "Lnet/minecraft/world/entity/EntityType;", "level", "Lnet/minecraft/world/level/Level;", "<init>", "(Lnet/minecraft/world/entity/EntityType;Lnet/minecraft/world/level/Level;)V", "value", "", "hasSeenPlayer", "getHasSeenPlayer", "()Z", "", "lastSeenTick", "getLastSeenTick", "()I", "lastKnownTargetPos", "Lnet/minecraft/world/phys/Vec3;", "lastPlayerPos", "playerVelocity", "registerGoals", "", "getMaxHeadXRot", "getMaxHeadYRot", "updateLastSeenTick", "getTicksSinceLastSeen", "updatePlayerTracking", "player", "Lnet/minecraft/server/level/ServerPlayer;", "getPredictedPosition", "ticksAhead", "removeWhenFarAway", "distanceToClosestPlayer", "", "checkLineOfSight", "Lnet/minecraft/server/level/ServerLevel;", "getEyeY", "hurt", "source", "Lnet/minecraft/world/damagesource/DamageSource;", "amount", "", "timer", "getTimer", "setTimer", "(I)V", "defineSynchedData", "builder", "Lnet/minecraft/network/syncher/SynchedEntityData$Builder;", "addAdditionalSaveData", "compound", "Lnet/minecraft/nbt/CompoundTag;", "readAdditionalSaveData", "checkDespawn", "tick", "doHurtTarget", "target", "Lnet/minecraft/world/entity/Entity;", "onFinalizeSpawn", "Lnet/minecraft/world/entity/SpawnGroupData;", "Lnet/minecraft/world/level/ServerLevelAccessor;", "difficulty", "Lnet/minecraft/world/DifficultyInstance;", "spawnType", "Lnet/minecraft/world/entity/MobSpawnType;", "spawnData", "event", "Lnet/thebrokenscript/brokencore/api/platform/CancelProxy;", "awardKillScore", "entity", "score", "damageSource", "baseTick", "shouldRenderAtSqrDistance", "dist", "getBoundingBoxForCulling", "Lnet/minecraft/world/phys/AABB;", "registerControllers", "reg", "Lsoftware/bernie/geckolib/animation/AnimatableManager$ControllerRegistrar;", "canBeAffected", "effectInstance", "Lnet/minecraft/world/effect/MobEffectInstance;", "CustomMeleeGoal", "ChaseGoal", "Companion", "thebrokenscript-common"})
@SourceDebugExtension(value={"SMAP\nTheBrokenEndEntity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TheBrokenEndEntity.kt\nnet/thebrokenscript/entity/tbe/TheBrokenEndEntity\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,801:1\n1761#2,3:802\n*S KotlinDebug\n*F\n+ 1 TheBrokenEndEntity.kt\nnet/thebrokenscript/entity/tbe/TheBrokenEndEntity\n*L\n397#1:802,3\n*E\n"})
public final class TheBrokenEndEntity
extends UwuableMonster
implements FinalizedSpawn {
    @NotNull
    public static final Companion Companion = new Companion(null);
    private boolean hasSeenPlayer;
    private int lastSeenTick;
    @Nullable
    private Vec3 lastKnownTargetPos;
    @Nullable
    private Vec3 lastPlayerPos;
    @NotNull
    private Vec3 playerVelocity;
    @NotNull
    private static final String NATURAL_DESPAWN = "despawn_timer";
    private static final EntityDataAccessor<Integer> GRACE_PERIOD = SynchedEntityData.defineId(TheBrokenEndEntity.class, (EntityDataSerializer)EntityDataSerializers.INT);

    public TheBrokenEndEntity(@NotNull EntityType<TheBrokenEndEntity> type, @NotNull Level level) {
        Intrinsics.checkNotNullParameter(type, (String)"type");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        super(type, level);
        this.xpReward = 5440;
        this.setNoAi(false);
        this.setPersistenceRequired();
        PathNavigation pathNavigation = this.navigation;
        Intrinsics.checkNotNull((Object)pathNavigation, (String)"null cannot be cast to non-null type net.minecraft.world.entity.ai.navigation.GroundPathNavigation");
        ((GroundPathNavigation)pathNavigation).setCanWalkOverFences(true);
        this.setPathfindingMalus(PathType.DANGER_POWDER_SNOW, 2.0f);
        this.setPathfindingMalus(PathType.POWDER_SNOW, 4.0f);
        this.setPathfindingMalus(PathType.LAVA, 0.0f);
        this.setPathfindingMalus(PathType.FENCE, 0.0f);
        this.setPathfindingMalus(PathType.RAIL, 0.0f);
        this.setPathfindingMalus(PathType.UNPASSABLE_RAIL, 0.0f);
        this.setPathfindingMalus(PathType.WATER, 4.0f);
        this.setPathfindingMalus(PathType.WATER_BORDER, 1.0f);
        this.setPathfindingMalus(PathType.WALKABLE, 0.0f);
        this.setPathfindingMalus(PathType.DAMAGE_OTHER, 0.0f);
        this.setPathfindingMalus(PathType.DANGER_OTHER, 0.0f);
        this.setPathfindingMalus(PathType.DAMAGE_FIRE, 0.0f);
        this.setPathfindingMalus(PathType.DANGER_FIRE, 0.0f);
        Vec3 vec3 = Vec3.ZERO;
        Intrinsics.checkNotNullExpressionValue((Object)vec3, (String)"ZERO");
        this.playerVelocity = vec3;
    }

    public final boolean getHasSeenPlayer() {
        return this.hasSeenPlayer;
    }

    public final int getLastSeenTick() {
        return this.lastSeenTick;
    }

    protected void registerGoals() {
        this.targetSelector.addGoal(1, (Goal)new ChaseGoal(this, 100, () -> TheBrokenEndEntity.registerGoals$lambda$0(this), 128.0, false, 16, null));
        this.goalSelector.addGoal(2, (Goal)new FloatGoal((Mob)this));
        this.goalSelector.addGoal(3, (Goal)new CustomMeleeGoal(this, 1.25, false));
        this.goalSelector.addGoal(4, (Goal)new RandomStrollGoal((PathfinderMob)this, 1.0));
        this.goalSelector.addGoal(5, (Goal)new RandomLookAroundGoal((Mob)this));
    }

    public int getMaxHeadXRot() {
        return 0;
    }

    public int getMaxHeadYRot() {
        return 180;
    }

    public final void updateLastSeenTick() {
        this.lastSeenTick = this.tickCount;
        this.hasSeenPlayer = true;
    }

    public final int getTicksSinceLastSeen() {
        return this.tickCount - this.lastSeenTick;
    }

    public final void updatePlayerTracking(@NotNull ServerPlayer player) {
        Intrinsics.checkNotNullParameter((Object)player, (String)"player");
        Vec3 currentPos = player.position();
        Vec3 vec3 = this.lastPlayerPos;
        if (vec3 != null) {
            Vec3 oldPos = vec3;
            boolean bl = false;
            Vec3 vec32 = currentPos.subtract(oldPos);
            Intrinsics.checkNotNullExpressionValue((Object)vec32, (String)"subtract(...)");
            this.playerVelocity = vec32;
        }
        this.lastPlayerPos = currentPos;
        this.lastKnownTargetPos = currentPos;
    }

    @Nullable
    public final Vec3 getPredictedPosition(int ticksAhead) {
        Vec3 vec3 = this.lastKnownTargetPos;
        if (vec3 == null) {
            return null;
        }
        Vec3 lastPos = vec3;
        if (this.playerVelocity.length() > 0.01) {
            return lastPos.add(this.playerVelocity.scale((double)ticksAhead));
        }
        return lastPos;
    }

    public static /* synthetic */ Vec3 getPredictedPosition$default(TheBrokenEndEntity theBrokenEndEntity, int n, int n2, Object object) {
        if ((n2 & 1) != 0) {
            n = 20;
        }
        return theBrokenEndEntity.getPredictedPosition(n);
    }

    public boolean removeWhenFarAway(double distanceToClosestPlayer) {
        return false;
    }

    private final void checkLineOfSight(ServerLevel level) {
        List playersInRange = EntityFinder.findPlayersInRange((ServerLevel)level, (Vec3)this.getPos(), (Number)1000);
        for (ServerPlayer player : playersInRange) {
            if (!BaseMonsterExtKt.hasLineOfSightThroughTransparent((BaseMonster)((BaseMonster)this), (Player)((Player)player))) continue;
            this.updateLastSeenTick();
        }
    }

    public double getEyeY() {
        double y = this.getEyeHeight();
        int randomY = this.random.nextInt(1, 5);
        switch (randomY) {
            case 1: {
                y = this.getEyeHeight();
                break;
            }
            case 2: {
                y = (double)this.getEyeHeight() / (double)randomY;
                break;
            }
            case 3: {
                y = (double)this.getEyeHeight() / (double)randomY;
                break;
            }
            case 4: {
                y = (double)this.getEyeHeight() / (double)randomY;
            }
        }
        return this.getPos().y + y;
    }

    public boolean hurt(@NotNull DamageSource source, float amount) {
        boolean bl;
        block6: {
            Intrinsics.checkNotNullParameter((Object)source, (String)"source");
            Entity entity = source.getEntity();
            if (entity != null) {
                DamageSources damageSources = this.level().damageSources();
                Intrinsics.checkNotNullExpressionValue((Object)damageSources, (String)"damageSources(...)");
                entity.hurt(DamageSourcesExt.INSTANCE.player(damageSources), 10.0f);
            }
            Object[] objectArray = new ResourceKey[]{DamageTypes.IN_FIRE, DamageTypes.FALL, DamageTypes.CACTUS, DamageTypes.DROWN, DamageTypes.LIGHTNING_BOLT, DamageTypes.EXPLOSION, DamageTypes.TRIDENT, DamageTypes.FALLING_ANVIL, DamageTypes.DRAGON_BREATH, DamageTypes.WITHER, DamageTypes.WITHER_SKULL};
            List blacklistedDamageTypes = CollectionsKt.listOf((Object[])objectArray);
            Iterable $this$any$iv = blacklistedDamageTypes;
            boolean $i$f$any = false;
            if ($this$any$iv instanceof Collection && ((Collection)$this$any$iv).isEmpty()) {
                bl = false;
            } else {
                for (Object element$iv : $this$any$iv) {
                    ResourceKey it = (ResourceKey)element$iv;
                    boolean bl2 = false;
                    if (!source.is(it)) continue;
                    bl = true;
                    break block6;
                }
                bl = false;
            }
        }
        if (bl) {
            return false;
        }
        if (source.getDirectEntity() instanceof AbstractArrow || source.getDirectEntity() instanceof Player || source.getDirectEntity() instanceof ThrownPotion || source.getDirectEntity() instanceof AreaEffectCloud) {
            return false;
        }
        return super.hurt(source, amount);
    }

    public final int getTimer() {
        return EntityUtil.getPersistentData((Entity)((Entity)this)).getInt(NATURAL_DESPAWN);
    }

    public final void setTimer(int value) {
        EntityUtil.getPersistentData((Entity)((Entity)this)).putInt(NATURAL_DESPAWN, value);
    }

    protected void defineSynchedData(@NotNull SynchedEntityData.Builder builder) {
        Intrinsics.checkNotNullParameter((Object)builder, (String)"builder");
        super.defineSynchedData(builder);
        builder.define(GRACE_PERIOD, (Object)150);
    }

    public void addAdditionalSaveData(@NotNull CompoundTag compound) {
        Vec3 it;
        Intrinsics.checkNotNullParameter((Object)compound, (String)"compound");
        super.addAdditionalSaveData(compound);
        compound.putInt(NATURAL_DESPAWN, this.getTimer());
        compound.putBoolean("HasSeenPlayer", this.hasSeenPlayer);
        compound.putInt("LastSeenTick", this.lastSeenTick);
        Object object = this.entityData.get(GRACE_PERIOD);
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"get(...)");
        compound.putInt("grace", ((Number)object).intValue());
        Vec3 vec3 = this.lastKnownTargetPos;
        if (vec3 != null) {
            it = vec3;
            boolean bl = false;
            compound.putDouble("LastKnownX", it.x);
            compound.putDouble("LastKnownY", it.y);
            compound.putDouble("LastKnownZ", it.z);
        }
        Vec3 vec32 = this.lastPlayerPos;
        if (vec32 != null) {
            it = vec32;
            boolean bl = false;
            compound.putDouble("LastPlayerX", it.x);
            compound.putDouble("LastPlayerY", it.y);
            compound.putDouble("LastPlayerZ", it.z);
        }
        compound.putDouble("VelocityX", this.playerVelocity.x);
        compound.putDouble("VelocityY", this.playerVelocity.y);
        compound.putDouble("VelocityZ", this.playerVelocity.z);
    }

    public void readAdditionalSaveData(@NotNull CompoundTag compound) {
        Intrinsics.checkNotNullParameter((Object)compound, (String)"compound");
        super.readAdditionalSaveData(compound);
        this.setTimer(compound.getInt(NATURAL_DESPAWN));
        this.hasSeenPlayer = compound.getBoolean("HasSeenPlayer");
        this.lastSeenTick = compound.getInt("LastSeenTick");
        if (compound.contains("grace")) {
            this.entityData.set(GRACE_PERIOD, (Object)compound.getInt("grace"));
        }
        if (compound.contains("LastKnownX")) {
            this.lastKnownTargetPos = new Vec3(compound.getDouble("LastKnownX"), compound.getDouble("LastKnownY"), compound.getDouble("LastKnownZ"));
        }
        if (compound.contains("LastPlayerX")) {
            this.lastPlayerPos = new Vec3(compound.getDouble("LastPlayerX"), compound.getDouble("LastPlayerY"), compound.getDouble("LastPlayerZ"));
        }
        this.playerVelocity = new Vec3(compound.getDouble("VelocityX"), compound.getDouble("VelocityY"), compound.getDouble("VelocityZ"));
    }

    public void checkDespawn() {
        super.checkDespawn();
        if (this.horizontalCollision && this.verticalCollision) {
            int stuckTime = EntityUtil.getPersistentData((Entity)((Entity)this)).getInt("StuckTicks");
            EntityUtil.getPersistentData((Entity)((Entity)this)).putInt("StuckTicks", stuckTime + 1);
            if (stuckTime > 40) {
                if (this.getTarget() != null) {
                    double d = this.getX();
                    LivingEntity livingEntity = this.getTarget();
                    Intrinsics.checkNotNull((Object)livingEntity);
                    this.teleportTo(d, livingEntity.getY(), this.getZ());
                }
                EntityUtil.getPersistentData((Entity)((Entity)this)).putInt("StuckTicks", 0);
            }
        } else {
            EntityUtil.getPersistentData((Entity)((Entity)this)).putInt("StuckTicks", 0);
        }
    }

    public void tick() {
        super.tick();
        SideUtil.clientSide((Entity)((Entity)this), () -> TheBrokenEndEntity.tick$lambda$0(this));
        SideUtil.serverSide((Entity)((Entity)this), () -> TheBrokenEndEntity.tick$lambda$1(this));
    }

    public boolean doHurtTarget(@NotNull Entity target) {
        Intrinsics.checkNotNullParameter((Object)target, (String)"target");
        if (!(target instanceof ServerPlayer) || ((ServerPlayer)target).isSpectator()) {
            return false;
        }
        float damage = (float)this.getAttributes().getValue(Attributes.ATTACK_DAMAGE);
        Level level = target.level();
        if (!(level instanceof ServerLevel)) {
            return false;
        }
        if (((ServerPlayer)target).isCreative()) {
            ((ServerPlayer)target).kill();
            DamageSource damageSource = target.damageSources().genericKill();
            Intrinsics.checkNotNullExpressionValue((Object)damageSource, (String)"genericKill(...)");
            this.awardKillScore(target, 0, damageSource);
            return true;
        }
        DamageSource damageSource = target.damageSources().mobAttack((LivingEntity)this);
        ((ServerPlayer)target).hurt(damageSource, damage);
        return true;
    }

    @Nullable
    public SpawnGroupData onFinalizeSpawn(@NotNull ServerLevelAccessor level, @NotNull DifficultyInstance difficulty, @NotNull MobSpawnType spawnType, @Nullable SpawnGroupData spawnData, @NotNull CancelProxy event) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)difficulty, (String)"difficulty");
        Intrinsics.checkNotNullParameter((Object)spawnType, (String)"spawnType");
        Intrinsics.checkNotNullParameter((Object)event, (String)"event");
        if (!(level instanceof ServerLevel)) {
            return null;
        }
        if (!((ServerLevel)level).getBlockState(this.getBlockPos()).getFluidState().isEmpty()) {
            Entity entity = (Entity)this;
            Vec3 vec3 = this.getPos().add(0.0, 1.0, 0.0);
            Intrinsics.checkNotNullExpressionValue((Object)vec3, (String)"add(...)");
            EntityUtil.teleport((Entity)entity, (Vec3)vec3);
        }
        List players = EntityFinder.findPlayersInRange((ServerLevel)((ServerLevel)level), (Vec3)this.getPos(), (Number)150);
        for (ServerPlayer player : players) {
            if (!PlayerUtil.hasLineOfSightThroughTransparent((Player)((Player)player), (BaseMonster)((BaseMonster)this))) continue;
            PlayerExt.tryPlayChase$default(PlayerExt.INSTANCE, (Player)player, (SoundEvent)TBSSounds.TBE_INTRO.invoke(), false, 0.0f, 0.0f, 0.0f, 30, null);
        }
        TimeOfDay.MIDNIGHT.setFake();
        EntityUtil.discardNearest(Boat.class, (Vec3)new Vec3(this.getX(), this.getY(), this.getZ()), (Level)((Level)level), (Number)1000.0);
        this.teleportTo(this.getX(), this.getY(), this.getZ());
        this.setTimer(1000);
        this.setNoAi(true);
        return null;
    }

    public void awardKillScore(@NotNull Entity entity, int score, @NotNull DamageSource damageSource) {
        Intrinsics.checkNotNullParameter((Object)entity, (String)"entity");
        Intrinsics.checkNotNullParameter((Object)damageSource, (String)"damageSource");
        super.awardKillScore(entity, score, damageSource);
        Level level = this.level();
        if (!(level instanceof ServerLevel)) {
            return;
        }
        if (entity instanceof ServerPlayer) {
            PlayerUtil.sendSound$default((ServerPlayer)((ServerPlayer)entity), (SoundEvent)((SoundEvent)TBSSounds.THE_END_IS_NEAR.invoke()), (float)2.0f, (float)0.2f, null, null, (long)0L, (int)56, null);
        }
        this.discard();
        LevelUtil.getQueue((Level)level).add(15L, () -> TheBrokenEndEntity.awardKillScore$lambda$0(entity));
        if (!TBSConfigs.INSTANCE.getServer().getDisableBanning() && this.random.nextBoolean()) {
            EntityUtil.applyRandomRotation((Entity)EntityTypeExt.trySummon((EntityType)((EntityType)TBSEntities.BAN.get()), (LevelAccessor)((LevelAccessor)level), (BlockPos)this.getBlockPos()));
        }
    }

    public void baseTick() {
        LivingEntity livingEntity;
        super.baseTick();
        Level level = this.level();
        Integer grace = (Integer)this.entityData.get(GRACE_PERIOD);
        if (grace > 0) {
            this.entityData.set(GRACE_PERIOD, (Object)(grace - 1));
            Integer n = grace;
            int n2 = 30;
            if (n != null && n == n2) {
                SideUtil.clientSide((Entity)((Entity)this), () -> TheBrokenEndEntity.baseTick$lambda$0(this));
            }
            if (grace - 1 <= 0) {
                this.setNoAi(false);
            }
            return;
        }
        double a = TagExt.INSTANCE.addDouble(EntityUtil.getPersistentData((Entity)((Entity)this)), "a", (Number)1.0);
        if (a > 150.0) {
            EntityUtil.getPersistentData((Entity)((Entity)this)).putDouble("a", 0.0);
            if (this.random.nextBoolean()) {
                SideUtil.clientSide((Entity)((Entity)this), () -> TheBrokenEndEntity.baseTick$lambda$1(this));
            }
            SideUtil.serverSide((Entity)((Entity)this), () -> TheBrokenEndEntity.baseTick$lambda$2(this));
        }
        if (!(level instanceof ServerLevel)) {
            return;
        }
        if (this.tickCount % 10 == 0) {
            this.checkLineOfSight((ServerLevel)level);
        }
        ServerPlayer serverPlayer = (livingEntity = this.getTarget()) instanceof ServerPlayer ? (ServerPlayer)livingEntity : null;
        if (serverPlayer == null) {
            return;
        }
        ServerPlayer player = serverPlayer;
        if (PlatformUtil.Companion.isProduction()) {
            player.setGameMode(GameType.SURVIVAL);
        }
        IronGolem ironGolem = (IronGolem)EntityFinder.findClosestEntityInRange((LevelAccessor)((LevelAccessor)level), IronGolem.class, (Vec3)this.getPos(), (Number)20);
        if (ironGolem != null) {
            DamageSources damageSources = ((ServerLevel)level).damageSources();
            Intrinsics.checkNotNullExpressionValue((Object)damageSources, (String)"damageSources(...)");
            ironGolem.hurt(DamageSourcesExt.INSTANCE.player(damageSources), 30.0f);
        }
        Boat boat = (Boat)EntityFinder.findClosestEntityInRange((LevelAccessor)((LevelAccessor)level), Boat.class, (Vec3)this.getPos(), (Number)20);
        if (boat != null) {
            DamageSources damageSources = ((ServerLevel)level).damageSources();
            Intrinsics.checkNotNullExpressionValue((Object)damageSources, (String)"damageSources(...)");
            boat.hurt(DamageSourcesExt.INSTANCE.player(damageSources), 30.0f);
        }
        double interferences = TagExt.INSTANCE.incDouble(EntityUtil.getPersistentData((Entity)((Entity)this)), "interferences");
        if (PlatformUtil.Companion.isProduction()) {
            double d = interferences;
            if (d == 3.0) {
                PlayerUtil.trySendOverlay((Player)((Player)player), (ResourceLocation)TBSConstants.id("textures/screens/tbescreenframe_1.png"), (long)5L);
            } else if (d == 6.0) {
                PlayerUtil.trySendOverlay((Player)((Player)player), (ResourceLocation)TBSConstants.id("textures/screens/tbescreenframe_2.png"), (long)5L);
            } else if (d == 9.0) {
                PlayerUtil.trySendOverlay((Player)((Player)player), (ResourceLocation)TBSConstants.id("textures/screens/tbescreenframe_3.png"), (long)5L);
            } else if (d == 12.0) {
                PlayerUtil.trySendOverlay((Player)((Player)player), (ResourceLocation)TBSConstants.id("textures/screens/tbescreenframe_4.png"), (long)5L);
                EntityUtil.getPersistentData((Entity)((Entity)this)).putDouble("interferences", 0.0);
            }
        }
        player.addEffect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 10, 1, false, false));
        int n = this.getTimer();
        this.setTimer(n + -1);
        if (this.getTimer() == 0) {
            if (this.getTarget() != null && this.getTarget() instanceof ServerPlayer) {
                LivingEntity livingEntity2 = this.getTarget();
                Intrinsics.checkNotNull((Object)livingEntity2, (String)"null cannot be cast to non-null type net.minecraft.server.level.ServerPlayer");
                RepUtilKt.applyRep((Player)((ServerPlayer)livingEntity2), RepTier.GAIN_MEDIUM);
            }
            this.discard();
        }
        this.refreshDimensions();
    }

    public boolean shouldRenderAtSqrDistance(double dist) {
        return dist < 65536.0;
    }

    @NotNull
    public AABB getBoundingBoxForCulling() {
        AABB aABB = super.getBoundingBoxForCulling().inflate(96.0);
        Intrinsics.checkNotNullExpressionValue((Object)aABB, (String)"inflate(...)");
        return aABB;
    }

    public void registerControllers(@NotNull AnimatableManager.ControllerRegistrar reg) {
        Intrinsics.checkNotNullParameter((Object)reg, (String)"reg");
        reg.add(new AnimationController((GeoAnimatable)this, "main_controller", 5, arg_0 -> TheBrokenEndEntity.registerControllers$lambda$0(this, arg_0)));
    }

    public boolean canBeAffected(@NotNull MobEffectInstance effectInstance) {
        Intrinsics.checkNotNullParameter((Object)effectInstance, (String)"effectInstance");
        return false;
    }

    private static final boolean registerGoals$lambda$0(TheBrokenEndEntity this$0) {
        return this$0.hasSeenPlayer;
    }

    private static final Object tick$lambda$0(TheBrokenEndEntity this$0) {
        if (!ClientVariables.INSTANCE.has(4096L)) {
            LocalPlayer localPlayer = ClientDSLKt.getMC().player;
            if (localPlayer == null) {
                return false;
            }
            LocalPlayer player = localPlayer;
            if (PlayerExt.INSTANCE.isEntityInFovCone((Player)player, (Entity)this$0, Double.valueOf(((Number)ClientDSLKt.getMC().options.fov().get()).intValue()))) {
                ClientVariables.INSTANCE.set(4096L);
            }
        }
        return Unit.INSTANCE;
    }

    private static final Unit tick$lambda$1(TheBrokenEndEntity this$0) {
        LivingEntity livingEntity = this$0.getTarget();
        if (livingEntity == null) {
            return Unit.INSTANCE;
        }
        LivingEntity currentTarget = livingEntity;
        AttributeInstance attributeInstance = this$0.getAttribute(Attributes.STEP_HEIGHT);
        if (attributeInstance != null) {
            attributeInstance.setBaseValue(currentTarget.getY() > this$0.getY() + (double)2 ? 50.0 : 1.0);
        }
        if (TBSConfigs.INSTANCE.getServer().getDisableBlockBreaking()) {
            return Unit.INSTANCE;
        }
        Level level = this$0.getLevel();
        ServerLevel serverLevel = level instanceof ServerLevel ? (ServerLevel)level : null;
        if (serverLevel == null) {
            return Unit.INSTANCE;
        }
        ServerLevel serverLevel2 = serverLevel;
        BlockPos currentPos = this$0.blockPosition();
        BlockPos targetPos = currentTarget.blockPosition();
        double startY = ((Number)(targetPos.getY() > currentPos.getY() ? (Number)RangesKt.coerceAtMost((int)targetPos.getY(), (int)(currentPos.getY() + 5)) : (Number)this$0.getY())).doubleValue();
        double checkHeight = (double)currentPos.getY() + (double)this$0.getBbHeight() + 1.0;
        AABB baseBox = new AABB(this$0.getX() - (double)this$0.getBbWidth() / 2.0, startY, this$0.getZ() - (double)this$0.getBbWidth() / 2.0, this$0.getX() + (double)this$0.getBbWidth() / 2.0, checkHeight, this$0.getZ() + (double)this$0.getBbWidth() / 2.0);
        Vec3 lookVector = this$0.getLookAngle();
        double scanDistance = 2.0;
        AABB projectedBox = baseBox.move(lookVector.x * scanDistance, 0.0, lookVector.z * scanDistance);
        double extraWidth = 0.65;
        double perpX = -lookVector.z * extraWidth;
        double perpZ = lookVector.x * extraWidth;
        AABB leftBox = projectedBox.move(perpX, 0.0, perpZ);
        AABB rightBox = projectedBox.move(-perpX, 0.0, -perpZ);
        projectedBox = leftBox.minmax(rightBox);
        List blocksToBreak = new ArrayList();
        boolean isBlockedBySolid = false;
        int minX = (int)Math.floor(projectedBox.minX);
        int maxX = (int)Math.ceil(projectedBox.maxX) - 1;
        int minY = (int)Math.floor(projectedBox.minY);
        int maxY = (int)Math.ceil(projectedBox.maxY) - 1;
        int minZ = (int)Math.floor(projectedBox.minZ);
        int maxZ = (int)Math.ceil(projectedBox.maxZ) - 1;
        int bx = minX;
        if (bx <= maxX) {
            while (true) {
                int by;
                if ((by = minY) <= maxY) {
                    while (true) {
                        int bz;
                        if ((bz = minZ) <= maxZ) {
                            while (true) {
                                BlockPos pos;
                                BlockState state;
                                if (!((state = serverLevel2.getBlockState(pos = new BlockPos(bx, by, bz))).isAir() || state.getDestroySpeed((BlockGetter)serverLevel2, pos) < 0.0f || state.getCollisionShape((BlockGetter)serverLevel2, pos).isEmpty())) {
                                    blocksToBreak.add(pos);
                                    isBlockedBySolid = true;
                                }
                                if (bz == maxZ) break;
                                ++bz;
                            }
                        }
                        if (by == maxY) break;
                        ++by;
                    }
                }
                if (bx == maxX) break;
                ++bx;
            }
        }
        if (!isBlockedBySolid) {
            return Unit.INSTANCE;
        }
        for (BlockPos pos : blocksToBreak) {
            BlockState state = serverLevel2.getBlockState(pos);
            FluidState fluidState = state.getFluidState();
            BlockState replacementState = !fluidState.isEmpty() ? fluidState.createLegacyBlock() : Blocks.AIR.defaultBlockState();
            serverLevel2.setBlock(pos, replacementState, 3);
            serverLevel2.levelEvent(2001, pos, Block.getId((BlockState)state));
        }
        return Unit.INSTANCE;
    }

    private static final Unit awardKillScore$lambda$0(Entity $entity) {
        if ($entity instanceof ServerPlayer) {
            PlayerUtil.kick((ServerPlayer)((ServerPlayer)$entity), (Component)((Component)TBSLang.INSTANCE.getTBE_KICK()));
        }
        return Unit.INSTANCE;
    }

    private static final Unit baseTick$lambda$0(TheBrokenEndEntity this$0) {
        LocalPlayer localPlayer = ClientDSLKt.getMC().player;
        if (localPlayer == null) {
            return Unit.INSTANCE;
        }
        LocalPlayer localPlayer2 = localPlayer;
        if (localPlayer2.hasLineOfSight((Entity)this$0) || PlayerUtil.hasLineOfSightThroughTransparent((Player)((Player)localPlayer2), (BaseMonster)((BaseMonster)this$0))) {
            FancyEntitySoundInstance fancyEntitySoundInstance;
            SoundEvent soundEvent = (SoundEvent)TBSSounds.THE_END_IS_NEAR.invoke();
            Entity entity = (Entity)this$0;
            RandomSource randomSource = this$0.level().random;
            Intrinsics.checkNotNullExpressionValue((Object)randomSource, (String)"random");
            FancyEntitySoundInstance $this$baseTick_u24lambda_u240_u240 = fancyEntitySoundInstance = new FancyEntitySoundInstance(soundEvent, SoundSource.HOSTILE, 4.0f, 1.0f, entity, false, randomSource);
            boolean bl = false;
            $this$baseTick_u24lambda_u240_u240.addEffect((AudioEffect)ReverbPreset.create$default((ReverbPreset)ReverbPresets.EFX_REVERB_PRESET_MOOD_HELL, null, (int)1, null));
            FancyEntitySoundInstance instance = fancyEntitySoundInstance;
            ClientDSLKt.getMC().getSoundManager().play((SoundInstance)instance);
        }
        return Unit.INSTANCE;
    }

    private static final Unit baseTick$lambda$1(TheBrokenEndEntity this$0) {
        LocalPlayer localPlayer = ClientDSLKt.getMC().player;
        if (localPlayer == null) {
            return Unit.INSTANCE;
        }
        LocalPlayer localPlayer2 = localPlayer;
        if (localPlayer2.distanceTo((Entity)this$0) <= 150.0f && (localPlayer2.hasLineOfSight((Entity)this$0) || PlayerUtil.hasLineOfSightThroughTransparent((Player)((Player)localPlayer2), (BaseMonster)((BaseMonster)this$0)))) {
            FancyEntitySoundInstance fancyEntitySoundInstance;
            SoundEvent soundEvent = (SoundEvent)TBSSounds.THE_END_IS_NEAR.invoke();
            Entity entity = (Entity)this$0;
            RandomSource randomSource = this$0.level().random;
            Intrinsics.checkNotNullExpressionValue((Object)randomSource, (String)"random");
            FancyEntitySoundInstance $this$baseTick_u24lambda_u241_u240 = fancyEntitySoundInstance = new FancyEntitySoundInstance(soundEvent, SoundSource.HOSTILE, 4.0f, 0.4f, entity, false, randomSource);
            boolean bl = false;
            $this$baseTick_u24lambda_u241_u240.addEffect((AudioEffect)ReverbPreset.create$default((ReverbPreset)ReverbPresets.EFX_REVERB_PRESET_MOOD_HELL, null, (int)1, null));
            FancyEntitySoundInstance instance = fancyEntitySoundInstance;
            ClientDSLKt.getMC().getSoundManager().play((SoundInstance)instance);
        }
        return Unit.INSTANCE;
    }

    private static final Unit baseTick$lambda$2(TheBrokenEndEntity this$0) {
        LivingEntity livingEntity = this$0.getTarget();
        ServerPlayer serverPlayer = livingEntity instanceof ServerPlayer ? (ServerPlayer)livingEntity : null;
        if (serverPlayer == null) {
            return Unit.INSTANCE;
        }
        ServerPlayer player = serverPlayer;
        if ((double)this$0.random.nextFloat() < 0.7) {
            ServerPlayer[] serverPlayerArray = new ServerPlayer[]{player};
            TimeOfDay.MIDNIGHT.setFake(serverPlayerArray);
            PlayerUtil.trySendOverlay((Player)((Player)player), (ResourceLocation)TBSConstants.id("textures/screens/frame1.png"), (long)10L);
        } else if ((double)this$0.random.nextFloat() < 0.7) {
            ServerPlayer[] serverPlayerArray = new ServerPlayer[]{player};
            TimeOfDay.DAY.setFake(serverPlayerArray);
            PlayerUtil.trySendOverlay((Player)((Player)player), (ResourceLocation)TBSConstants.id("textures/screens/frame2.png"), (long)10L);
        } else if ((double)this$0.random.nextFloat() < 0.7) {
            ServerPlayer[] serverPlayerArray = new ServerPlayer[]{player};
            TimeOfDay.NOON.setFake(serverPlayerArray);
            PlayerUtil.trySendOverlay((Player)((Player)player), (ResourceLocation)TBSConstants.id("textures/screens/wecanhearyou.png"), (long)10L);
        }
        return Unit.INSTANCE;
    }

    private static final PlayState registerControllers$lambda$0(TheBrokenEndEntity this$0, AnimationState event) {
        if (((Number)this$0.entityData.get(GRACE_PERIOD)).intValue() > 0) {
            event.getController().setAnimation(RawAnimation.begin().thenPlayAndHold("animation.tbe.spottedeventchase"));
        } else if (event.isMoving()) {
            event.getController().setAnimation(RawAnimation.begin().thenLoop("animation.tbe.chase"));
        } else {
            event.getController().setAnimation(RawAnimation.begin().thenLoop("animation.tbe.idle_redeyes"));
        }
        return PlayState.CONTINUE;
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\b\u00a2\u0006\u0004\b\f\u0010\rJ\b\u0010\u0017\u001a\u00020\bH\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\bH\u0016J\b\u0010\u001b\u001a\u00020\u0019H\u0016J\b\u0010\u001c\u001a\u00020\u0019H\u0016J\b\u0010\u001d\u001a\u00020\u0019H\u0002J\n\u0010\u001e\u001a\u0004\u0018\u00010\u000fH\u0002J\u0010\u0010\u001f\u001a\u00020\u00192\u0006\u0010 \u001a\u00020\u000fH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006!"}, d2={"Lnet/thebrokenscript/entity/tbe/TheBrokenEndEntity$ChaseGoal;", "Lnet/minecraft/world/entity/ai/goal/target/TargetGoal;", "tbeMob", "Lnet/thebrokenscript/entity/tbe/TheBrokenEndEntity;", "chasePersistenceTicks", "", "hasSeenPlayerProvider", "Lkotlin/Function0;", "", "detectionRange", "", "allowTargetSwitching", "<init>", "(Lnet/thebrokenscript/entity/tbe/TheBrokenEndEntity;ILkotlin/jvm/functions/Function0;DZ)V", "targetPlayer", "Lnet/minecraft/server/level/ServerPlayer;", "lastTargetCheck", "targetCheckCooldownTicks", "lastLOSCheck", "cachedLOS", "losCooldownTicks", "targetingConditions", "Lnet/minecraft/world/entity/ai/targeting/TargetingConditions;", "canUse", "start", "", "canContinueToUse", "tick", "stop", "resetState", "findClosestValidPlayer", "switchTarget", "newTarget", "thebrokenscript-common"})
    @SourceDebugExtension(value={"SMAP\nTheBrokenEndEntity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TheBrokenEndEntity.kt\nnet/thebrokenscript/entity/tbe/TheBrokenEndEntity$ChaseGoal\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,801:1\n1#2:802\n*E\n"})
    public static final class ChaseGoal
    extends TargetGoal {
        @NotNull
        private final TheBrokenEndEntity tbeMob;
        private final int chasePersistenceTicks;
        @NotNull
        private final Function0<Boolean> hasSeenPlayerProvider;
        private final double detectionRange;
        private final boolean allowTargetSwitching;
        @Nullable
        private ServerPlayer targetPlayer;
        private int lastTargetCheck;
        private final int targetCheckCooldownTicks;
        private int lastLOSCheck;
        private boolean cachedLOS;
        private final int losCooldownTicks;
        @NotNull
        private final TargetingConditions targetingConditions;

        public ChaseGoal(@NotNull TheBrokenEndEntity tbeMob, int chasePersistenceTicks, @NotNull Function0<Boolean> hasSeenPlayerProvider, double detectionRange, boolean allowTargetSwitching) {
            Intrinsics.checkNotNullParameter((Object)((Object)tbeMob), (String)"tbeMob");
            Intrinsics.checkNotNullParameter(hasSeenPlayerProvider, (String)"hasSeenPlayerProvider");
            super((Mob)tbeMob, false);
            this.tbeMob = tbeMob;
            this.chasePersistenceTicks = chasePersistenceTicks;
            this.hasSeenPlayerProvider = hasSeenPlayerProvider;
            this.detectionRange = detectionRange;
            this.allowTargetSwitching = allowTargetSwitching;
            this.targetCheckCooldownTicks = 40;
            this.losCooldownTicks = 5;
            TargetingConditions targetingConditions = TargetingConditions.forNonCombat().ignoreInvisibilityTesting().ignoreLineOfSight();
            Intrinsics.checkNotNullExpressionValue((Object)targetingConditions, (String)"ignoreLineOfSight(...)");
            this.targetingConditions = targetingConditions;
        }

        public /* synthetic */ ChaseGoal(TheBrokenEndEntity theBrokenEndEntity, int n, Function0 function0, double d, boolean bl, int n2, DefaultConstructorMarker defaultConstructorMarker) {
            if ((n2 & 8) != 0) {
                d = 64.0;
            }
            if ((n2 & 0x10) != 0) {
                bl = true;
            }
            this(theBrokenEndEntity, n, (Function0<Boolean>)function0, d, bl);
        }

        public boolean canUse() {
            ServerPlayer nearby;
            if (this.targetPlayer != null && this.tbeMob.getTicksSinceLastSeen() < this.chasePersistenceTicks) {
                return true;
            }
            if (!((Boolean)this.hasSeenPlayerProvider.invoke()).booleanValue()) {
                return false;
            }
            ServerPlayer serverPlayer = this.findClosestValidPlayer();
            if (serverPlayer == null) {
                return false;
            }
            this.targetPlayer = nearby = serverPlayer;
            return true;
        }

        public void start() {
            ServerPlayer serverPlayer = this.targetPlayer;
            if (serverPlayer != null) {
                ServerPlayer it = serverPlayer;
                boolean bl = false;
                this.mob.setTarget((LivingEntity)it);
                if (this.mob.getSensing().hasLineOfSight((Entity)it)) {
                    this.tbeMob.updateLastSeenTick();
                    this.tbeMob.updatePlayerTracking(it);
                }
            }
            this.lastTargetCheck = this.mob.tickCount;
            this.lastLOSCheck = this.mob.tickCount;
        }

        public boolean canContinueToUse() {
            ServerPlayer serverPlayer = this.targetPlayer;
            if (serverPlayer == null) {
                return false;
            }
            ServerPlayer player = serverPlayer;
            if (player.isSpectator() || player.isRemoved() || !player.isAlive()) {
                this.resetState();
                return false;
            }
            return this.cachedLOS || this.tbeMob.getTicksSinceLastSeen() < this.chasePersistenceTicks;
        }

        public void tick() {
            ServerPlayer serverPlayer = this.targetPlayer;
            if (serverPlayer == null) {
                return;
            }
            ServerPlayer player = serverPlayer;
            if (player.isRemoved() || !player.isAlive() || player.isSpectator()) {
                this.resetState();
                return;
            }
            if (this.allowTargetSwitching && this.mob.tickCount - this.lastTargetCheck >= this.targetCheckCooldownTicks) {
                this.lastTargetCheck = this.mob.tickCount;
                ServerPlayer closerPlayer = this.findClosestValidPlayer();
                if (closerPlayer != null && !Intrinsics.areEqual((Object)closerPlayer, (Object)player)) {
                    double currentDist = this.mob.distanceToSqr((Entity)player);
                    double closerDist = this.mob.distanceToSqr((Entity)closerPlayer);
                    if (closerDist < currentDist * 0.75) {
                        this.switchTarget(closerPlayer);
                        return;
                    }
                }
            }
            if (this.mob.tickCount - this.lastLOSCheck >= this.losCooldownTicks) {
                this.lastLOSCheck = this.mob.tickCount;
                Mob mob = this.mob;
                Intrinsics.checkNotNull((Object)mob, (String)"null cannot be cast to non-null type net.thebrokenscript.brokencore.api.entity.base.BaseMonster");
                this.cachedLOS = BaseMonsterExtKt.hasLineOfSightThroughTransparent((BaseMonster)((BaseMonster)mob), (Player)((Player)player));
            }
            if (this.cachedLOS) {
                this.tbeMob.updateLastSeenTick();
                this.tbeMob.updatePlayerTracking(player);
            }
        }

        public void stop() {
            super.stop();
            this.resetState();
        }

        private final void resetState() {
            this.targetPlayer = null;
            this.cachedLOS = false;
            this.mob.setTarget(null);
        }

        private final ServerPlayer findClosestValidPlayer() {
            Object object;
            ServerPlayer serverPlayer = (ServerPlayer)this.mob.level().getNearestEntity(ServerPlayer.class, this.targetingConditions, (LivingEntity)this.mob, this.mob.getX(), this.mob.getEyeY(), this.mob.getZ(), this.mob.getBoundingBox().inflate(this.detectionRange));
            if (serverPlayer != null) {
                ServerPlayer serverPlayer2;
                ServerPlayer it = serverPlayer2 = serverPlayer;
                boolean bl = false;
                object = !it.isSpectator() ? serverPlayer2 : null;
            } else {
                object = null;
            }
            return object;
        }

        private final void switchTarget(ServerPlayer newTarget) {
            this.targetPlayer = newTarget;
            this.mob.setTarget((LivingEntity)newTarget);
            if (this.mob.getSensing().hasLineOfSight((Entity)newTarget)) {
                this.tbeMob.updateLastSeenTick();
                this.tbeMob.updatePlayerTracking(newTarget);
            }
            this.lastTargetCheck = this.mob.tickCount;
        }
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T\u00a2\u0006\u0002\n\u0000R2\u0010\u0006\u001a&\u0012\f\u0012\n \t*\u0004\u0018\u00010\b0\b \t*\u0012\u0012\f\u0012\n \t*\u0004\u0018\u00010\b0\b\u0018\u00010\u00070\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2={"Lnet/thebrokenscript/entity/tbe/TheBrokenEndEntity$Companion;", "", "<init>", "()V", "NATURAL_DESPAWN", "", "GRACE_PERIOD", "Lnet/minecraft/network/syncher/EntityDataAccessor;", "", "kotlin.jvm.PlatformType", "thebrokenscript-common"})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\b\u0010\u0010\u001a\u00020\u0007H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0015H\u0014J\b\u0010\u0016\u001a\u00020\u0012H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2={"Lnet/thebrokenscript/entity/tbe/TheBrokenEndEntity$CustomMeleeGoal;", "Lnet/minecraft/world/entity/ai/goal/MeleeAttackGoal;", "tbeMob", "Lnet/thebrokenscript/entity/tbe/TheBrokenEndEntity;", "speed", "", "follow", "", "<init>", "(Lnet/thebrokenscript/entity/tbe/TheBrokenEndEntity;DZ)V", "pathCooldown", "", "attackCooldownTicks", "targetPathX", "targetPathY", "targetPathZ", "canUse", "tick", "", "checkAndPerformAttack", "target", "Lnet/minecraft/world/entity/LivingEntity;", "stop", "thebrokenscript-common"})
    public static final class CustomMeleeGoal
    extends MeleeAttackGoal {
        @NotNull
        private final TheBrokenEndEntity tbeMob;
        private int pathCooldown;
        private int attackCooldownTicks;
        private double targetPathX;
        private double targetPathY;
        private double targetPathZ;

        public CustomMeleeGoal(@NotNull TheBrokenEndEntity tbeMob, double speed, boolean follow) {
            Intrinsics.checkNotNullParameter((Object)((Object)tbeMob), (String)"tbeMob");
            super((PathfinderMob)tbeMob, speed, follow);
            this.tbeMob = tbeMob;
        }

        public boolean canUse() {
            LivingEntity livingEntity = this.mob.getTarget();
            if (livingEntity == null) {
                return false;
            }
            LivingEntity target = livingEntity;
            if (target.isRemoved() || !target.isAlive()) {
                this.mob.setTarget(null);
                return false;
            }
            return !(target instanceof ServerPlayer) || !((ServerPlayer)target).isSpectator();
        }

        /*
         * Unable to fully structure code
         */
        public void tick() {
            var3_1 = this.mob.getTarget();
            v0 = var3_1 instanceof Player != false ? (Player)var3_1 : null;
            if (v0 == null) {
                return;
            }
            target = v0;
            if (target.isRemoved() || !target.isAlive()) {
                this.mob.setTarget(null);
                return;
            }
            this.mob.getLookControl().setLookAt((Entity)target, 30.0f, 30.0f);
            if (this.attackCooldownTicks > 0) {
                var2_3 = this.attackCooldownTicks;
                this.attackCooldownTicks = var2_3 + -1;
            }
            if (this.mob.getSensing().hasLineOfSight((Entity)target)) ** GOTO lbl-1000
            v1 = this.mob;
            Intrinsics.checkNotNull((Object)v1, (String)"null cannot be cast to non-null type net.thebrokenscript.brokencore.api.entity.base.BaseMonster");
            if (BaseMonsterExtKt.hasLineOfSightThroughTransparent((BaseMonster)((BaseMonster)v1), (Player)target)) lbl-1000:
            // 2 sources

            {
                v2 = true;
            } else {
                v2 = false;
            }
            hasLos = v2;
            expandedBox = this.mob.getBoundingBox().inflate((double)this.mob.getBbWidth() * 1.5, (double)this.mob.getBbHeight() * 1.5, (double)this.mob.getBbWidth() * 1.5);
            if (target instanceof ServerPlayer && (hasLos || expandedBox.intersects(((ServerPlayer)target).getBoundingBox()))) {
                this.tbeMob.updateLastSeenTick();
            }
            this.pathCooldown += -1;
            if (this.pathCooldown <= 0) {
                distSqr = this.mob.distanceToSqr((Entity)target);
                this.pathCooldown = distSqr > 1024.0 ? 20 : 10;
                entityBox = this.mob.getBoundingBox().inflate(2.0, 0.0, 2.0).inflate(0.0, -this.mob.position().y, 0.0);
                playerInside = target.getBoundingBox().intersects(entityBox);
                if (!(playerInside && target.isInWater() || !this.mob.getNavigation().isDone() && !(target.distanceToSqr(this.targetPathX, this.targetPathY, this.targetPathZ) >= 1.0))) {
                    this.targetPathX = target.getX();
                    this.targetPathY = target.getY();
                    this.targetPathZ = target.getZ();
                    pathSuccess = false;
                    if (hasLos) {
                        if (TBSConfigs.INSTANCE.getServer().getDisableBlockBreaking() || !this.mob.level().getBlockState(this.mob.blockPosition()).getFluidState().isEmpty()) {
                            this.mob.getMoveControl().setWantedPosition(this.targetPathX, this.targetPathY, this.targetPathZ, 1.25);
                            pathSuccess = true;
                        } else {
                            pathSuccess = this.mob.getNavigation().moveTo((Entity)target, 1.25);
                        }
                    } else {
                        ticksSinceSeen = this.tbeMob.getTicksSinceLastSeen();
                        if (ticksSinceSeen < 100) {
                            predicted = this.tbeMob.getPredictedPosition(ticksSinceSeen);
                            if (predicted != null) {
                                pathSuccess = this.mob.getNavigation().moveTo(predicted.x, predicted.y, predicted.z, 1.375);
                            }
                        } else {
                            this.mob.getNavigation().stop();
                            pathSuccess = true;
                        }
                    }
                    if (!pathSuccess) {
                        this.pathCooldown += 30;
                    }
                }
            }
            this.checkAndPerformAttack((LivingEntity)target);
        }

        protected void checkAndPerformAttack(@NotNull LivingEntity target) {
            Intrinsics.checkNotNullParameter((Object)target, (String)"target");
            AABB expandedBox = this.mob.getBoundingBox().inflate((double)this.mob.getBbWidth() * 2.0, (double)this.mob.getBbHeight() * 0.25, (double)this.mob.getBbWidth() * 2.0);
            if (expandedBox.intersects(target.getBoundingBox()) && this.mob.getSensing().hasLineOfSight((Entity)target) && this.attackCooldownTicks <= 0) {
                this.attackCooldownTicks = 20;
                this.mob.swing(InteractionHand.MAIN_HAND);
                this.mob.doHurtTarget((Entity)target);
            }
        }

        public void stop() {
            this.mob.setAggressive(false);
            this.mob.getNavigation().stop();
            this.pathCooldown = 0;
            this.attackCooldownTicks = 0;
        }
    }
}

