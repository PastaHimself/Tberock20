/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.wispforest.endec.Endec
 *  kotlin.Metadata
 *  kotlin.Result
 *  kotlin.ResultKt
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.MutablePropertyReference0Impl
 *  kotlin.jvm.internal.MutablePropertyReference1
 *  kotlin.jvm.internal.MutablePropertyReference1Impl
 *  kotlin.jvm.internal.Reflection
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.ranges.RangesKt
 *  kotlin.reflect.KProperty
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Direction
 *  net.minecraft.core.Direction$Plane
 *  net.minecraft.core.Holder
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.nbt.Tag
 *  net.minecraft.network.chat.Component
 *  net.minecraft.network.chat.MutableComponent
 *  net.minecraft.network.syncher.EntityDataAccessor
 *  net.minecraft.network.syncher.EntityDataSerializer
 *  net.minecraft.network.syncher.EntityDataSerializers
 *  net.minecraft.network.syncher.SynchedEntityData
 *  net.minecraft.network.syncher.SynchedEntityData$Builder
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.server.level.ServerPlayer
 *  net.minecraft.sounds.SoundEvent
 *  net.minecraft.sounds.SoundSource
 *  net.minecraft.util.Mth
 *  net.minecraft.util.RandomSource
 *  net.minecraft.world.DifficultyInstance
 *  net.minecraft.world.damagesource.DamageSource
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.Entity$RemovalReason
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.Mob
 *  net.minecraft.world.entity.MobSpawnType
 *  net.minecraft.world.entity.PathfinderMob
 *  net.minecraft.world.entity.SpawnGroupData
 *  net.minecraft.world.entity.ai.attributes.Attributes
 *  net.minecraft.world.entity.ai.goal.Goal
 *  net.minecraft.world.entity.ai.goal.RandomLookAroundGoal
 *  net.minecraft.world.entity.ai.goal.RandomStrollGoal
 *  net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal
 *  net.minecraft.world.entity.ai.navigation.PathNavigation
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.entity.vehicle.Boat
 *  net.minecraft.world.level.BlockGetter
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.level.ServerLevelAccessor
 *  net.minecraft.world.level.block.StairBlock
 *  net.minecraft.world.level.pathfinder.PathType
 *  net.minecraft.world.phys.AABB
 *  net.minecraft.world.phys.Vec3
 *  net.thebrokenscript.brokencore.api.dsl.ComponentUtil
 *  net.thebrokenscript.brokencore.api.dsl.EntityDataDelegate
 *  net.thebrokenscript.brokencore.api.dsl.EntityFinder
 *  net.thebrokenscript.brokencore.api.dsl.EntityUtil
 *  net.thebrokenscript.brokencore.api.dsl.GeckoUtil
 *  net.thebrokenscript.brokencore.api.dsl.PersistentDataDelegate
 *  net.thebrokenscript.brokencore.api.dsl.PlayerUtil
 *  net.thebrokenscript.brokencore.api.dsl.RandomUtil
 *  net.thebrokenscript.brokencore.api.entity.FinalizedSpawn
 *  net.thebrokenscript.brokencore.api.entity.base.BaseMonster
 *  net.thebrokenscript.brokencore.api.ext.BaseMonsterExtKt
 *  net.thebrokenscript.brokencore.api.ext.EndecExt
 *  net.thebrokenscript.brokencore.api.ext.EntityTypeExt
 *  net.thebrokenscript.brokencore.api.ext.PlayerListExt
 *  net.thebrokenscript.brokencore.api.ext.TagExt
 *  net.thebrokenscript.brokencore.api.platform.CancelProxy
 *  net.thebrokenscript.brokencore.api.world.TimeOfDay
 *  net.thebrokenscript.brokencore.impl.registry.BCSoundCategories
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  software.bernie.geckolib.animatable.GeoAnimatable
 *  software.bernie.geckolib.animation.AnimatableManager$ControllerRegistrar
 *  software.bernie.geckolib.animation.AnimationController
 *  software.bernie.geckolib.animation.AnimationState
 *  software.bernie.geckolib.animation.PlayState
 */
package net.thebrokenscript.entity.circuit;

import io.wispforest.endec.Endec;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;
import kotlin.jvm.internal.MutablePropertyReference1;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KProperty;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializer;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.pathfinder.PathType;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.TheBrokenScript;
import net.thebrokenscript.api.TBSConstants;
import net.thebrokenscript.api.entity.BaseCircuitEntity;
import net.thebrokenscript.api.entity.ai.circuit.CircuitChaseGoal;
import net.thebrokenscript.api.entity.ai.circuit.CircuitMeleeGoal;
import net.thebrokenscript.api.entity.ai.circuit.CircuitMoveControl;
import net.thebrokenscript.api.entity.ai.circuit.CircuitNavigation;
import net.thebrokenscript.api.ext.PlayerExt;
import net.thebrokenscript.api.util.BlockBreakHelper;
import net.thebrokenscript.brokencore.api.dsl.ComponentUtil;
import net.thebrokenscript.brokencore.api.dsl.EntityDataDelegate;
import net.thebrokenscript.brokencore.api.dsl.EntityFinder;
import net.thebrokenscript.brokencore.api.dsl.EntityUtil;
import net.thebrokenscript.brokencore.api.dsl.GeckoUtil;
import net.thebrokenscript.brokencore.api.dsl.PersistentDataDelegate;
import net.thebrokenscript.brokencore.api.dsl.PlayerUtil;
import net.thebrokenscript.brokencore.api.dsl.RandomUtil;
import net.thebrokenscript.brokencore.api.entity.FinalizedSpawn;
import net.thebrokenscript.brokencore.api.entity.base.BaseMonster;
import net.thebrokenscript.brokencore.api.ext.BaseMonsterExtKt;
import net.thebrokenscript.brokencore.api.ext.EndecExt;
import net.thebrokenscript.brokencore.api.ext.EntityTypeExt;
import net.thebrokenscript.brokencore.api.ext.PlayerListExt;
import net.thebrokenscript.brokencore.api.ext.TagExt;
import net.thebrokenscript.brokencore.api.platform.CancelProxy;
import net.thebrokenscript.brokencore.api.world.TimeOfDay;
import net.thebrokenscript.brokencore.impl.registry.BCSoundCategories;
import net.thebrokenscript.config.TBSConfigs;
import net.thebrokenscript.data.PlayerVariables;
import net.thebrokenscript.entity.circuit.ChaseState;
import net.thebrokenscript.entity.circuit.CircuitData;
import net.thebrokenscript.entity.circuit.CircuitUtil;
import net.thebrokenscript.registry.TBSDamageTypes;
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

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u00c8\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u0084\u00012\u00020\u00012\u00020\u0002:\u0002\u0084\u0001B\u001d\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00000\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0004\b\u0007\u0010\bJ\b\u0010A\u001a\u00020BH\u0014J\u0006\u0010C\u001a\u00020BJ\u0006\u0010D\u001a\u00020\nJ\u000e\u0010E\u001a\u00020B2\u0006\u0010F\u001a\u00020GJ\u0012\u0010H\u001a\u0004\u0018\u0001082\b\b\u0002\u0010I\u001a\u00020\nJ\u0010\u0010J\u001a\u00020K2\u0006\u0010\u0005\u001a\u00020\u0006H\u0014J\u0010\u0010L\u001a\u00020B2\u0006\u0010M\u001a\u00020NH\u0014J\u0010\u0010O\u001a\u00020B2\u0006\u0010P\u001a\u00020QH\u0016J\u0010\u0010R\u001a\u00020B2\u0006\u0010P\u001a\u00020QH\u0016J\b\u0010S\u001a\u00020TH\u0016J\b\u0010U\u001a\u00020VH\u0016J\u0010\u0010W\u001a\u00020\u00162\u0006\u0010X\u001a\u00020TH\u0016J\u0010\u0010Y\u001a\u00020\u00162\u0006\u0010Z\u001a\u00020[H\u0016J \u0010\\\u001a\u00020B2\u0006\u0010]\u001a\u00020[2\u0006\u0010^\u001a\u00020\n2\u0006\u0010_\u001a\u00020`H\u0016J4\u0010e\u001a\u0004\u0018\u00010f2\u0006\u0010\u0005\u001a\u00020g2\u0006\u0010h\u001a\u00020i2\u0006\u0010j\u001a\u00020k2\b\u0010l\u001a\u0004\u0018\u00010f2\u0006\u0010m\u001a\u00020nH\u0016J\b\u0010o\u001a\u00020BH\u0016J\u0010\u0010p\u001a\u00020q2\u0006\u0010r\u001a\u00020sH\u0002J\b\u0010t\u001a\u00020\u0016H\u0016J\b\u0010u\u001a\u00020\u0016H\u0016J\b\u0010v\u001a\u0004\u0018\u00010sJ\f\u0010w\u001a\b\u0012\u0004\u0012\u00020s0xJ\b\u0010y\u001a\u00020BH\u0016J\u0010\u0010z\u001a\u00020B2\u0006\u0010\u0005\u001a\u00020{H\u0002J\u0016\u0010|\u001a\u00020B2\f\u0010}\u001a\b\u0012\u0004\u0012\u00020G0xH\u0002J\u0016\u0010~\u001a\u00020B2\f\u0010}\u001a\b\u0012\u0004\u0012\u00020G0xH\u0002J\u0012\u0010\u007f\u001a\u00020B2\b\u0010\u0080\u0001\u001a\u00030\u0081\u0001H\u0016J\t\u0010\u0082\u0001\u001a\u00020\nH\u0016J\u0011\u0010\u0083\u0001\u001a\u00020B2\u0006\u0010_\u001a\u00020`H\u0016R+\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR+\u0010\u0012\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0011\u001a\u0004\b\u0013\u0010\r\"\u0004\b\u0014\u0010\u000fR+\u0010\u0017\u001a\u00020\u00162\u0006\u0010\t\u001a\u00020\u00168F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR+\u0010\u001e\u001a\u00020\u00162\u0006\u0010\t\u001a\u00020\u00168F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b!\u0010\u001d\u001a\u0004\b\u001f\u0010\u0019\"\u0004\b \u0010\u001bR+\u0010\"\u001a\u00020\u00162\u0006\u0010\t\u001a\u00020\u00168F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b%\u0010\u001d\u001a\u0004\b#\u0010\u0019\"\u0004\b$\u0010\u001bR+\u0010&\u001a\u00020\u00162\u0006\u0010\t\u001a\u00020\u00168F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b)\u0010\u001d\u001a\u0004\b'\u0010\u0019\"\u0004\b(\u0010\u001bR+\u0010*\u001a\u00020\u00162\u0006\u0010\t\u001a\u00020\u00168F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b-\u0010\u001d\u001a\u0004\b+\u0010\u0019\"\u0004\b,\u0010\u001bR+\u0010.\u001a\u00020\u00162\u0006\u0010\t\u001a\u00020\u00168F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b1\u0010\u001d\u001a\u0004\b/\u0010\u0019\"\u0004\b0\u0010\u001bR\u001e\u00103\u001a\u00020\u00162\u0006\u00102\u001a\u00020\u0016@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b4\u0010\u0019R\u001e\u00105\u001a\u00020\n2\u0006\u00102\u001a\u00020\n@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b6\u0010\rR\u0010\u00107\u001a\u0004\u0018\u000108X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u00109\u001a\u0004\u0018\u000108X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u000208X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010;\u001a\u00020<X\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u000e\u0010a\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010b\u001a\u00020\nX\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010c\u001a\u00020TX\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010d\u001a\u00020TX\u0082D\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0085\u0001"}, d2={"Lnet/thebrokenscript/entity/circuit/CircuitEntity;", "Lnet/thebrokenscript/api/entity/BaseCircuitEntity;", "Lnet/thebrokenscript/brokencore/api/entity/FinalizedSpawn;", "type", "Lnet/minecraft/world/entity/EntityType;", "level", "Lnet/minecraft/world/level/Level;", "<init>", "(Lnet/minecraft/world/entity/EntityType;Lnet/minecraft/world/level/Level;)V", "<set-?>", "", "timer", "getTimer", "()I", "setTimer", "(I)V", "timer$delegate", "Lnet/thebrokenscript/brokencore/api/dsl/PersistentDataDelegate;", "discardTimer", "getDiscardTimer", "setDiscardTimer", "discardTimer$delegate", "", "chasing", "getChasing", "()Z", "setChasing", "(Z)V", "chasing$delegate", "Lnet/thebrokenscript/brokencore/api/dsl/EntityDataDelegate;", "despawn", "getDespawn", "setDespawn", "despawn$delegate", "spotted", "getSpotted", "setSpotted", "spotted$delegate", "crouch", "getCrouch", "setCrouch", "crouch$delegate", "climbing", "getClimbing", "setClimbing", "climbing$delegate", "spawning", "getSpawning", "setSpawning", "spawning$delegate", "value", "hasSeenPlayer", "getHasSeenPlayer", "lastSeenTick", "getLastSeenTick", "lastKnownTargetPos", "Lnet/minecraft/world/phys/Vec3;", "lastPlayerPos", "playerVelocity", "chaseState", "Lnet/thebrokenscript/entity/circuit/ChaseState;", "getChaseState$thebrokenscript_common", "()Lnet/thebrokenscript/entity/circuit/ChaseState;", "setChaseState$thebrokenscript_common", "(Lnet/thebrokenscript/entity/circuit/ChaseState;)V", "registerGoals", "", "updateLastSeenTick", "getTicksSinceLastSeen", "updatePlayerTracking", "player", "Lnet/minecraft/server/level/ServerPlayer;", "getPredictedPosition", "ticksAhead", "createNavigation", "Lnet/minecraft/world/entity/ai/navigation/PathNavigation;", "defineSynchedData", "builder", "Lnet/minecraft/network/syncher/SynchedEntityData$Builder;", "addAdditionalSaveData", "compound", "Lnet/minecraft/nbt/CompoundTag;", "readAdditionalSaveData", "getEyeY", "", "getBoundingBoxForCulling", "Lnet/minecraft/world/phys/AABB;", "shouldRenderAtSqrDistance", "dist", "doHurtTarget", "target", "Lnet/minecraft/world/entity/Entity;", "awardKillScore", "entity", "score", "damageSource", "Lnet/minecraft/world/damagesource/DamageSource;", "mountTicks", "mountDuration", "mountHorizontalSpeed", "mountVerticalSpeed", "onFinalizeSpawn", "Lnet/minecraft/world/entity/SpawnGroupData;", "Lnet/minecraft/world/level/ServerLevelAccessor;", "difficulty", "Lnet/minecraft/world/DifficultyInstance;", "spawnType", "Lnet/minecraft/world/entity/MobSpawnType;", "spawnData", "event", "Lnet/thebrokenscript/brokencore/api/platform/CancelProxy;", "tick", "directionToYaw", "", "direction", "Lnet/minecraft/core/Direction;", "canFreeze", "onClimbable", "getHorizontalCollisionDirection", "getHorizontalCollisionDirections", "", "baseTick", "checkLineOfSight", "Lnet/minecraft/server/level/ServerLevel;", "handleDespawn", "players", "handleVisualEffects", "registerControllers", "reg", "Lsoftware/bernie/geckolib/animation/AnimatableManager$ControllerRegistrar;", "getMaxFallDistance", "die", "Companion", "thebrokenscript-common"})
@SourceDebugExtension(value={"SMAP\nCircuitEntity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CircuitEntity.kt\nnet/thebrokenscript/entity/circuit/CircuitEntity\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,664:1\n1#2:665\n295#3,2:666\n1563#3:668\n1634#3,3:669\n1761#3,3:672\n774#3:675\n865#3,2:676\n774#3:678\n865#3,2:679\n1869#3,2:681\n*S KotlinDebug\n*F\n+ 1 CircuitEntity.kt\nnet/thebrokenscript/entity/circuit/CircuitEntity\n*L\n328#1:666,2\n338#1:668\n338#1:669,3\n350#1:672,3\n410#1:675\n410#1:676,2\n558#1:678\n558#1:679,2\n569#1:681,2\n*E\n"})
public final class CircuitEntity
extends BaseCircuitEntity
implements FinalizedSpawn {
    @NotNull
    public static final Companion Companion;
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;
    @NotNull
    private final PersistentDataDelegate timer$delegate;
    @NotNull
    private final PersistentDataDelegate discardTimer$delegate;
    @NotNull
    private final EntityDataDelegate chasing$delegate;
    @NotNull
    private final EntityDataDelegate despawn$delegate;
    @NotNull
    private final EntityDataDelegate spotted$delegate;
    @NotNull
    private final EntityDataDelegate crouch$delegate;
    @NotNull
    private final EntityDataDelegate climbing$delegate;
    @NotNull
    private final EntityDataDelegate spawning$delegate;
    private boolean hasSeenPlayer;
    private int lastSeenTick;
    @Nullable
    private Vec3 lastKnownTargetPos;
    @Nullable
    private Vec3 lastPlayerPos;
    @NotNull
    private Vec3 playerVelocity;
    @NotNull
    private ChaseState chaseState;
    private int mountTicks;
    private final int mountDuration;
    private final double mountHorizontalSpeed;
    private final double mountVerticalSpeed;
    @NotNull
    private static final EntityDataAccessor<Boolean> CHASING;
    @NotNull
    private static final EntityDataAccessor<Boolean> CROUCH;
    @NotNull
    private static final EntityDataAccessor<Boolean> DESPAWN;
    @NotNull
    private static final EntityDataAccessor<Boolean> SPOTTED;
    @NotNull
    private static final EntityDataAccessor<Boolean> CLIMBING;
    @NotNull
    private static final EntityDataAccessor<Boolean> SPAWNING;

    public CircuitEntity(@NotNull EntityType<CircuitEntity> type, @NotNull Level level) {
        Intrinsics.checkNotNullParameter(type, (String)"type");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        super(type, level);
        this.timer$delegate = this.persistentInt("despawn_timer");
        this.discardTimer$delegate = this.persistentInt("discard_timer");
        this.chasing$delegate = this.entityData(CHASING);
        this.despawn$delegate = this.entityData(DESPAWN);
        this.spotted$delegate = this.entityData(SPOTTED);
        this.crouch$delegate = this.entityData(CROUCH);
        this.climbing$delegate = this.entityData(CLIMBING);
        this.spawning$delegate = this.entityData(SPAWNING);
        Vec3 vec3 = Vec3.ZERO;
        Intrinsics.checkNotNullExpressionValue((Object)vec3, (String)"ZERO");
        this.playerVelocity = vec3;
        this.chaseState = ChaseState.NORMAL;
        this.setPathfindingMalus(PathType.DANGER_POWDER_SNOW, 2.0f);
        this.setPathfindingMalus(PathType.POWDER_SNOW, 4.0f);
        this.setPathfindingMalus(PathType.LAVA, 0.0f);
        this.setPathfindingMalus(PathType.FENCE, 0.0f);
        this.setPathfindingMalus(PathType.RAIL, 0.0f);
        this.setPathfindingMalus(PathType.UNPASSABLE_RAIL, 0.0f);
        this.setPathfindingMalus(PathType.WATER, 8.0f);
        this.setPathfindingMalus(PathType.WALKABLE, 0.0f);
        this.setPathfindingMalus(PathType.DAMAGE_OTHER, 0.0f);
        this.setPathfindingMalus(PathType.DANGER_OTHER, 0.0f);
        this.setPathfindingMalus(PathType.DAMAGE_FIRE, 0.0f);
        this.setPathfindingMalus(PathType.DANGER_FIRE, 0.0f);
        this.moveControl = new CircuitMoveControl(this);
        this.mountDuration = 6;
        this.mountHorizontalSpeed = 0.32;
        this.mountVerticalSpeed = 0.24;
    }

    public final int getTimer() {
        return ((Number)this.timer$delegate.getValue((BaseMonster)this, $$delegatedProperties[0])).intValue();
    }

    public final void setTimer(int n) {
        this.timer$delegate.setValue((BaseMonster)this, $$delegatedProperties[0], (Object)n);
    }

    public final int getDiscardTimer() {
        return ((Number)this.discardTimer$delegate.getValue((BaseMonster)this, $$delegatedProperties[1])).intValue();
    }

    public final void setDiscardTimer(int n) {
        this.discardTimer$delegate.setValue((BaseMonster)this, $$delegatedProperties[1], (Object)n);
    }

    public final boolean getChasing() {
        return (Boolean)this.chasing$delegate.getValue((BaseMonster)this, $$delegatedProperties[2]);
    }

    public final void setChasing(boolean bl) {
        this.chasing$delegate.setValue((BaseMonster)this, $$delegatedProperties[2], (Object)bl);
    }

    public final boolean getDespawn() {
        return (Boolean)this.despawn$delegate.getValue((BaseMonster)this, $$delegatedProperties[3]);
    }

    public final void setDespawn(boolean bl) {
        this.despawn$delegate.setValue((BaseMonster)this, $$delegatedProperties[3], (Object)bl);
    }

    public final boolean getSpotted() {
        return (Boolean)this.spotted$delegate.getValue((BaseMonster)this, $$delegatedProperties[4]);
    }

    public final void setSpotted(boolean bl) {
        this.spotted$delegate.setValue((BaseMonster)this, $$delegatedProperties[4], (Object)bl);
    }

    public final boolean getCrouch() {
        return (Boolean)this.crouch$delegate.getValue((BaseMonster)this, $$delegatedProperties[5]);
    }

    public final void setCrouch(boolean bl) {
        this.crouch$delegate.setValue((BaseMonster)this, $$delegatedProperties[5], (Object)bl);
    }

    public final boolean getClimbing() {
        return (Boolean)this.climbing$delegate.getValue((BaseMonster)this, $$delegatedProperties[6]);
    }

    public final void setClimbing(boolean bl) {
        this.climbing$delegate.setValue((BaseMonster)this, $$delegatedProperties[6], (Object)bl);
    }

    public final boolean getSpawning() {
        return (Boolean)this.spawning$delegate.getValue((BaseMonster)this, $$delegatedProperties[7]);
    }

    public final void setSpawning(boolean bl) {
        this.spawning$delegate.setValue((BaseMonster)this, $$delegatedProperties[7], (Object)bl);
    }

    public final boolean getHasSeenPlayer() {
        return this.hasSeenPlayer;
    }

    public final int getLastSeenTick() {
        return this.lastSeenTick;
    }

    @NotNull
    public final ChaseState getChaseState$thebrokenscript_common() {
        return this.chaseState;
    }

    public final void setChaseState$thebrokenscript_common(@NotNull ChaseState chaseState) {
        Intrinsics.checkNotNullParameter((Object)((Object)chaseState), (String)"<set-?>");
        this.chaseState = chaseState;
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, (Goal)new CircuitMeleeGoal(this, 1.2, true));
        this.targetSelector.addGoal(1, (Goal)new CircuitChaseGoal(this, 220, (Function0)new MutablePropertyReference0Impl((Object)this){

            public Object get() {
                return ((CircuitEntity)((Object)this.receiver)).getHasSeenPlayer();
            }

            public void set(Object value) {
                CircuitEntity.access$setHasSeenPlayer$p((CircuitEntity)((Object)this.receiver), (Boolean)value);
            }
        }, 128.0, false, 0, 48, null));
        this.targetSelector.addGoal(2, (Goal)new HurtByTargetGoal((PathfinderMob)this, new Class[0]));
        this.goalSelector.addGoal(2, (Goal)new RandomStrollGoal((PathfinderMob)this, 1.0));
        this.goalSelector.addGoal(3, (Goal)new RandomLookAroundGoal((Mob)this));
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
        if (this.getSpawning()) {
            this.setTarget((LivingEntity)player);
        }
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

    public static /* synthetic */ Vec3 getPredictedPosition$default(CircuitEntity circuitEntity, int n, int n2, Object object) {
        if ((n2 & 1) != 0) {
            n = 20;
        }
        return circuitEntity.getPredictedPosition(n);
    }

    @NotNull
    protected PathNavigation createNavigation(@NotNull Level level) {
        CircuitNavigation circuitNavigation;
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        CircuitNavigation $this$createNavigation_u24lambda_u240 = circuitNavigation = new CircuitNavigation(this, level);
        boolean bl = false;
        $this$createNavigation_u24lambda_u240.setCanOpenDoors(true);
        $this$createNavigation_u24lambda_u240.setCanPassDoors(true);
        $this$createNavigation_u24lambda_u240.setCanWalkOverFences(true);
        $this$createNavigation_u24lambda_u240.setCanFloat(true);
        return (PathNavigation)circuitNavigation;
    }

    protected void defineSynchedData(@NotNull SynchedEntityData.Builder builder) {
        Intrinsics.checkNotNullParameter((Object)builder, (String)"builder");
        super.defineSynchedData(builder);
        builder.define(CHASING, (Object)false);
        builder.define(DESPAWN, (Object)false);
        builder.define(CROUCH, (Object)false);
        builder.define(SPOTTED, (Object)false);
        builder.define(CLIMBING, (Object)false);
        builder.define(SPAWNING, (Object)true);
    }

    public void addAdditionalSaveData(@NotNull CompoundTag compound) {
        Intrinsics.checkNotNullParameter((Object)compound, (String)"compound");
        super.addAdditionalSaveData(compound);
        CircuitData data = new CircuitData(this.getTimer(), this.getDiscardTimer(), this.hasSeenPlayer, this.lastSeenTick, this.lastKnownTargetPos, this.lastPlayerPos, this.playerVelocity);
        compound.put("CircuitData", EndecExt.INSTANCE.encodeNbtOrThrow((Endec)CircuitData.Companion.getENDEC(), (Object)data));
    }

    public void readAdditionalSaveData(@NotNull CompoundTag compound) {
        Intrinsics.checkNotNullParameter((Object)compound, (String)"compound");
        super.readAdditionalSaveData(compound);
        Tag tag = compound.get("CircuitData");
        if (tag == null) {
            return;
        }
        Tag dataTag = tag;
        CircuitData circuitData = (CircuitData)EndecExt.INSTANCE.tryDecodeNbt((Endec)CircuitData.Companion.getENDEC(), dataTag);
        if (circuitData == null) {
            return;
        }
        CircuitData data = circuitData;
        this.setTimer(data.getTimer());
        this.setDiscardTimer(data.getDiscardTimer());
        this.hasSeenPlayer = data.getHasSeenPlayer();
        this.lastSeenTick = data.getLastSeenTick();
        this.lastKnownTargetPos = data.getLastKnownTargetPos();
        this.lastPlayerPos = data.getLastPlayerPos();
        this.playerVelocity = data.getPlayerVelocity();
    }

    public double getEyeY() {
        return this.getPos().y + (double)this.getEyeHeight();
    }

    @NotNull
    public AABB getBoundingBoxForCulling() {
        AABB aABB = super.getBoundingBoxForCulling().inflate(32.0);
        Intrinsics.checkNotNullExpressionValue((Object)aABB, (String)"inflate(...)");
        return aABB;
    }

    public boolean shouldRenderAtSqrDistance(double dist) {
        return dist < 65536.0;
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
        DamageSource damageSource = target.damageSources().source(TBSDamageTypes.CIRCUIT_ATTACK.getKey());
        ((ServerPlayer)target).hurt(damageSource, damage);
        if (((ServerPlayer)target).isDeadOrDying()) {
            this.remove(Entity.RemovalReason.DISCARDED);
        }
        return true;
    }

    public void awardKillScore(@NotNull Entity entity, int score, @NotNull DamageSource damageSource) {
        Intrinsics.checkNotNullParameter((Object)entity, (String)"entity");
        Intrinsics.checkNotNullParameter((Object)damageSource, (String)"damageSource");
        super.awardKillScore(entity, score, damageSource);
        if (!(this.getLevel() instanceof ServerLevel)) {
            return;
        }
        this.setDespawn(true);
        if (entity instanceof ServerPlayer) {
            PlayerUtil.stopAllSounds((Player)((Player)entity));
            PlayerExt playerExt = PlayerExt.INSTANCE;
            ServerPlayer serverPlayer = (ServerPlayer)entity;
            SoundEvent soundEvent = (SoundEvent)TBSSounds.CIRCUIT_JUMPSCARE.invoke();
            PlayerExt.tryPlaySound$default(playerExt, (Player)serverPlayer, soundEvent, false, 0.75f, 0.55f, 0.15f, 2, null);
            CircuitUtil.INSTANCE.resetNoWayOutFrame((Player)entity);
            TheBrokenScript.serverWorkQueue.add(20L, () -> CircuitEntity.awardKillScore$lambda$0(this, entity));
            this.discard();
        }
    }

    @Nullable
    public SpawnGroupData onFinalizeSpawn(@NotNull ServerLevelAccessor level, @NotNull DifficultyInstance difficulty, @NotNull MobSpawnType spawnType, @Nullable SpawnGroupData spawnData, @NotNull CancelProxy event) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)difficulty, (String)"difficulty");
        Intrinsics.checkNotNullParameter((Object)spawnType, (String)"spawnType");
        Intrinsics.checkNotNullParameter((Object)event, (String)"event");
        if (!level.getBlockState(this.getBlockPos()).getFluidState().isEmpty()) {
            Entity entity = (Entity)this;
            Vec3 vec3 = this.getPos().add(0.0, 0.5, 0.0);
            Intrinsics.checkNotNullExpressionValue((Object)vec3, (String)"add(...)");
            EntityUtil.teleport((Entity)entity, (Vec3)vec3);
        }
        for (ServerPlayer player : EntityFinder.findPlayersInRange((ServerLevelAccessor)level, (Vec3)this.getPos(), (Number)56)) {
            if (!BaseMonsterExtKt.hasLineOfSightThroughTransparent((BaseMonster)((BaseMonster)this), (Player)((Player)player))) continue;
            PlayerUtil.sendSound$default((ServerPlayer)player, (Holder)((Holder)TBSSounds.CIRCUIT_INTRO), (float)0.75f, (float)1.0f, (SoundSource)BCSoundCategories.BC_CHASE, null, (long)0L, (int)48, null);
        }
        this.setTimer(800);
        this.setDiscardTimer(-1);
        this.setNoAi(true);
        return null;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    @Override
    public void tick() {
        block29: {
            super.tick();
            if (this.level().isClientSide) break block29;
            path = this.navigation.getPath();
            if (path != null && !path.isDone()) {
                targetPos = path.getTarget();
                v0 = targetPos.getY() + 1 > this.blockPosition().getY();
            } else if (this.getTarget() != null) {
                v1 = this.getTarget();
                Intrinsics.checkNotNull((Object)v1);
                v0 = v1.getY() + (double)true > this.getY() + 1.0;
            } else {
                v0 = shouldClimb = false;
            }
            if (!this.horizontalCollision) ** GOTO lbl-1000
            $this$tick_u24lambda_u240 = this;
            $i$a$-run-CircuitEntity$tick$collidingWithWall$1 = false;
            v2 = $this$tick_u24lambda_u240.getHorizontalCollisionDirection();
            if (v2 == null) {
                v3 = false;
            } else {
                dir = v2;
                offsetPos = $this$tick_u24lambda_u240.blockPosition().relative(dir);
                foot = $this$tick_u24lambda_u240.level().getBlockState(offsetPos);
                head = $this$tick_u24lambda_u240.level().getBlockState(offsetPos.above());
                v3 = !(foot.getBlock() instanceof StairBlock) && !(head.getBlock() instanceof StairBlock);
            }
            if (v3) {
                v4 = true;
            } else lbl-1000:
            // 2 sources

            {
                v4 = false;
            }
            collidingWithWall = v4;
            facing = this.getDirection();
            frontWallPos = this.blockPosition().relative(facing);
            wallStillPresent = this.level().getBlockState(frontWallPos).isAir() == false;
            v5 = this.getTarget();
            if (v5 != null) {
                it = v5.getY();
                $i$a$-let-CircuitEntity$tick$targetDroppedBelow$1 = false;
                v6 = this.getY() - 0.5 >= it;
            } else {
                v6 = false;
            }
            targetDroppedBelow = v6;
            wasClimbing = this.getClimbing();
            this.setClimbing(targetDroppedBelow != false ? false : (wasClimbing == false && collidingWithWall != false && shouldClimb != false ? true : wasClimbing != false && wallStillPresent != false && shouldClimb != false));
            if (wasClimbing && !this.getClimbing() && !targetDroppedBelow) {
                this.mountTicks = this.mountDuration;
            }
            if (this.getClimbing()) {
                block27: {
                    this.mountTicks = 0;
                    motion = this.getDeltaMovement();
                    climbSpeed = this.chaseState == ChaseState.SEEKING_CLIMB ? 0.185 : 0.125;
                    startY = wasClimbing == false ? 0.0 : motion.y;
                    newY = Mth.lerp((double)0.3, (double)startY, (double)climbSpeed);
                    this.setDeltaMovement(motion.x * 0.1, newY, motion.z * 0.1);
                    this.fallDistance = 0.0f;
                    touchingWalls = this.getHorizontalCollisionDirections();
                    $this$firstOrNull$iv = touchingWalls;
                    $i$f$firstOrNull = false;
                    for (T element$iv : $this$firstOrNull$iv) {
                        it = (Direction)element$iv /* !! */ ;
                        $i$a$-firstOrNull-CircuitEntity$tick$wallDirection$1 = false;
                        if (!(it == facing)) continue;
                        v7 = element$iv /* !! */ ;
                        break block27;
                    }
                    v7 = null;
                }
                if ((v8 = (Direction)v7) == null && (v8 = (Direction)CollectionsKt.firstOrNull(touchingWalls)) == null) {
                    v8 = facing;
                }
                wallDirection = v8;
                Intrinsics.checkNotNull((Object)wallDirection);
                this.yBodyRot = wallYaw = this.directionToYaw(wallDirection);
                this.yBodyRotO = wallYaw;
                this.yRotO = wallYaw;
                this.setYRot(wallYaw);
                $this$map$iv = touchingWalls;
                $i$f$map = false;
                element$iv /* !! */  = $this$map$iv;
                destination$iv$iv = new ArrayList<E>(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map$iv, (int)10));
                $i$f$mapTo = false;
                for (T item$iv$iv : $this$mapTo$iv$iv) {
                    var28_36 = (Direction)item$iv$iv;
                    var33_40 = destination$iv$iv;
                    $i$a$-map-CircuitEntity$tick$protectedCols$1 = false;
                    var33_40.add(this.blockPosition().relative((Direction)it));
                }
                protectedCols = CollectionsKt.toSet((Iterable)((List)destination$iv$iv));
                leftOffset = wallDirection.getCounterClockWise();
                rightOffset = wallDirection.getClockWise();
                block2: for (i = 1; i < 5; ++i) {
                    var25_31 = new BlockPos[]{this.blockPosition().above(i), this.blockPosition().relative(leftOffset).above(i), this.blockPosition().relative(rightOffset).above(i)};
                    candidates = CollectionsKt.listOf((Object[])var25_31);
                    for (BlockPos pos : candidates) {
                        block28: {
                            $this$any$iv = protectedCols;
                            $i$f$any = false;
                            if ($this$any$iv instanceof Collection && ((Collection)$this$any$iv).isEmpty()) {
                                v9 = false;
                            } else {
                                for (T element$iv : $this$any$iv) {
                                    it = (BlockPos)element$iv;
                                    $i$a$-any-CircuitEntity$tick$1 = false;
                                    if (!(it.getX() == pos.getX() && it.getZ() == pos.getZ())) continue;
                                    v9 = true;
                                    break block28;
                                }
                                v9 = false;
                            }
                        }
                        if (v9 || this.getLevel().getBlockState(pos).isAir()) continue;
                        this.getLevel().destroyBlock(pos, false);
                        continue block2;
                    }
                }
            } else if (this.mountTicks > 0 && !this.onGround()) {
                motion = this.mountTicks;
                this.mountTicks = motion + -1;
                this.fallDistance = 0.0f;
                this.setDeltaMovement((double)facing.getStepX() * this.mountHorizontalSpeed, this.mountVerticalSpeed, (double)facing.getStepZ() * this.mountHorizontalSpeed);
                for (i = 0; i < 2; ++i) {
                    checkPos = this.blockPosition().relative(facing).above(i);
                    if (this.getLevel().getBlockState(checkPos).isAir() || TBSConfigs.INSTANCE.getServer().getDisableBlockBreaking()) continue;
                    this.getLevel().destroyBlock(checkPos, false);
                }
            } else if (wasClimbing && targetDroppedBelow) {
                this.mountTicks = 0;
                motion = this.getDeltaMovement();
                this.setDeltaMovement(motion.x + (double)facing.getStepX() * 0.25, RangesKt.coerceAtLeast((double)motion.y, (double)0.25), motion.z + (double)facing.getStepZ() * 0.25);
            } else if (this.onGround()) {
                this.mountTicks = 0;
            }
        }
        this.setCrouch(BaseMonsterExtKt.shouldCrouch$default((BaseMonster)((BaseMonster)this), null, (int)1, null));
    }

    private final float directionToYaw(Direction direction) {
        return switch (WhenMappings.$EnumSwitchMapping$0[direction.ordinal()]) {
            case 1 -> 180.0f;
            case 2 -> 0.0f;
            case 3 -> 90.0f;
            case 4 -> 270.0f;
            default -> 0.0f;
        };
    }

    public boolean canFreeze() {
        return false;
    }

    public boolean onClimbable() {
        return this.getClimbing();
    }

    @Nullable
    public final Direction getHorizontalCollisionDirection() {
        Iterator iterator = Direction.Plane.HORIZONTAL.iterator();
        Intrinsics.checkNotNullExpressionValue((Object)iterator, (String)"iterator(...)");
        Iterator iterator2 = iterator;
        while (iterator2.hasNext()) {
            Direction dir = (Direction)iterator2.next();
            BlockPos offsetPos = this.blockPosition().relative(dir);
            if (this.level().getBlockState(offsetPos).isAir()) continue;
            return dir;
        }
        return null;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public final List<Direction> getHorizontalCollisionDirections() {
        void $this$filterTo$iv$iv;
        Iterable $this$filter$iv = (Iterable)Direction.Plane.HORIZONTAL;
        boolean $i$f$filter = false;
        Iterable iterable = $this$filter$iv;
        Collection destination$iv$iv = new ArrayList();
        boolean $i$f$filterTo = false;
        for (Object element$iv$iv : $this$filterTo$iv$iv) {
            Direction dir = (Direction)element$iv$iv;
            boolean bl = false;
            if (!(!this.level().getBlockState(this.blockPosition().relative(dir)).isAir())) continue;
            destination$iv$iv.add(element$iv$iv);
        }
        return (List)destination$iv$iv;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    @Override
    public void baseTick() {
        block23: {
            super.baseTick();
            level = this.level();
            if (!(level instanceof ServerLevel)) {
                return;
            }
            if (this.getClimbing() || this.getDeltaMovement().x == 0.0 && this.getDeltaMovement().z == 0.0) break block23;
            lookVec = this.getForward();
            horizontalLen = Math.sqrt(lookVec.x * lookVec.x + lookVec.z * lookVec.z);
            if (!(horizontalLen > 0.2)) break block23;
            forwardPos = this.blockPosition().offset((int)Math.signum(lookVec.x), 0, (int)Math.signum(lookVec.z));
            forwardState /* !! */  = this.level().getBlockState(forwardPos);
            aboveForwardPos = forwardPos.above();
            aboveForwardState = this.level().getBlockState(aboveForwardPos);
            hasCollision = forwardState /* !! */ .isAir() == false && forwardState /* !! */ .getCollisionShape((BlockGetter)this.level(), forwardPos).isEmpty() == false;
            v0 /* !! */  = this.navigation.getPath();
            if (v0 /* !! */  == null) ** GOTO lbl-1000
            it = var11_15 = v0 /* !! */ ;
            $i$a$-takeIf-CircuitEntity$baseTick$nodeYDiff$1 = false;
            v0 /* !! */  = it.isDone() == false != false ? var11_15 : null;
            if (v0 /* !! */  != null) {
                path = v0 /* !! */ ;
                $i$a$-let-CircuitEntity$baseTick$nodeYDiff$2 = false;
                var15_20 /* !! */  = this;
                try {
                    $this$baseTick_u24lambda_u241_u240 = var15_20 /* !! */ ;
                    $i$a$-runCatching-CircuitEntity$baseTick$nodeYDiff$2$1 = false;
                    var18_24 = path.getNextNode().y - $this$baseTick_u24lambda_u241_u240.getBlockY();
                    var16_21 = Result.constructor-impl((Object)(1 <= var18_24 ? var18_24 < 2 : false));
                }
                catch (Throwable var17_23) {
                    var16_21 = Result.constructor-impl((Object)ResultKt.createFailure((Throwable)var17_23));
                }
                var15_20 /* !! */  = var16_21;
                var16_21 = false;
                v1 = (Boolean)(Result.isFailure-impl((Object)var15_20 /* !! */ ) != false ? var16_21 : var15_20 /* !! */ );
            } else lbl-1000:
            // 2 sources

            {
                v1 = nodeYDiff = false;
            }
            if (hasCollision && aboveForwardState.isAir() && nodeYDiff && this.onGround()) {
                this.jumpFromGround();
            }
        }
        if (this.tickCount % 15 == 0) {
            this.checkLineOfSight((ServerLevel)level);
        }
        if ((gracePeriod = EntityUtil.getPersistentData((Entity)((Entity)this)).getInt("grace")) > 0 || !EntityUtil.getPersistentData((Entity)((Entity)this)).contains("grace")) {
            if (!EntityUtil.getPersistentData((Entity)((Entity)this)).contains("grace")) {
                EntityUtil.getPersistentData((Entity)((Entity)this)).putInt("grace", 160);
            }
            currentGrace = EntityUtil.getPersistentData((Entity)((Entity)this)).getInt("grace");
            EntityUtil.getPersistentData((Entity)((Entity)this)).putInt("grace", currentGrace - 1);
            if (currentGrace - 1 <= 0) {
                for (ServerPlayer player : EntityFinder.findPlayersInRange((ServerLevel)((ServerLevel)level), (Vec3)this.getPos(), (Number)128)) {
                    if (!player.hasLineOfSight((Entity)this)) continue;
                    forwardState /* !! */  = PlayerExt.INSTANCE;
                    aboveForwardPos = (SoundEvent)TBSSounds.CIRCUIT_JUMPSCARE.invoke();
                    PlayerExt.tryPlaySound$default((PlayerExt)forwardState /* !! */ , (Player)player, (SoundEvent)aboveForwardPos, false, 0.75f, 0.75f, 0.15f, 2, null);
                }
                this.setNoAi(false);
                if (this.getSpotted()) {
                    this.setSpotted(false);
                }
                if (this.getSpawning()) {
                    this.setSpawning(false);
                }
                v2 = recentlySeen = this.hasSeenPlayer != false && this.getTicksSinceLastSeen() < 100;
                if (recentlySeen && this.getTarget() == null) {
                    v3 = this.lastKnownTargetPos;
                    if (v3 != null) {
                        it = v3;
                        $i$a$-let-CircuitEntity$baseTick$1 = false;
                        v4 = ((ServerLevel)level).getNearestPlayer((Entity)this, 128.0);
                        if (v4 != null) {
                            it = v4;
                            $i$a$-let-CircuitEntity$baseTick$1$1 = false;
                            this.setTarget((LivingEntity)it);
                        }
                    }
                }
            }
            return;
        }
        playersInRange = EntityFinder.findPlayersInRange((ServerLevel)((ServerLevel)level), (Vec3)this.getPos(), (Number)326);
        if (!this.getDespawn()) {
            this.setChasing(this.getTarget() != null);
        } else {
            this.handleDespawn(playersInRange);
        }
        if ((this.navigation.isStuck() || this.navigation.isDone()) && this.getTarget() != null && !this.getClimbing()) {
            v5 = this.getTarget();
            Intrinsics.checkNotNull((Object)v5);
            if (v5.getY() <= this.getY() + (double)2) {
                lookDistance = 2;
                facing = this.getLookAngle().normalize();
                i = 1;
                while (true) {
                    if (!(state = ((ServerLevel)level).getBlockState(frontPos = this.blockPosition().offset((int)(facing.x * (double)i), (int)(facing.y * (double)i), (int)(facing.z * (double)i)))).isAir() && !TBSConfigs.INSTANCE.getServer().getDisableBlockBreaking() && this.chaseState == ChaseState.NORMAL) {
                        v6 = (LevelAccessor)level;
                        Intrinsics.checkNotNull((Object)frontPos);
                        BlockBreakHelper.INSTANCE.tryBreakCircuit(v6, frontPos);
                        v7 = (LevelAccessor)level;
                        v8 = frontPos.above();
                        Intrinsics.checkNotNullExpressionValue((Object)v8, (String)"above(...)");
                        BlockBreakHelper.INSTANCE.tryBreakCircuit(v7, v8);
                    }
                    if (i == lookDistance) break;
                    ++i;
                }
            }
        }
        this.handleVisualEffects(playersInRange);
        EntityUtil.discardNearest(Boat.class, (Vec3)this.getPos(), (Level)level, (Number)40);
        var4_28 = this.getTimer();
        this.setTimer(var4_28 + -1);
        if (this.getTimer() == 0) {
            this.setDespawn(true);
            this.setDiscardTimer(15);
            this.setNoAi(true);
        }
        this.refreshDimensions();
    }

    private final void checkLineOfSight(ServerLevel level) {
        List playersInRange = EntityFinder.findPlayersInRange((ServerLevel)level, (Vec3)this.getPos(), (Number)326);
        for (ServerPlayer player : playersInRange) {
            if (this.hasLineOfSight((Entity)player) || BaseMonsterExtKt.hasLineOfSightThroughTransparent((BaseMonster)((BaseMonster)this), (Player)((Player)player))) {
                this.updateLastSeenTick();
                this.updatePlayerTracking(player);
                continue;
            }
            CircuitUtil.INSTANCE.resetNoWayOutFrame((Player)player);
        }
    }

    private final void handleDespawn(List<? extends ServerPlayer> players) {
        this.setTarget(null);
        int n = this.getDiscardTimer();
        this.setDiscardTimer(n + -1);
        if (this.getDiscardTimer() == 0) {
            for (ServerPlayer serverPlayer : players) {
                CircuitUtil.INSTANCE.resetNoWayOutFrame((Player)serverPlayer);
            }
            if (this.getTarget() != null && this.getTarget() instanceof ServerPlayer) {
                LivingEntity livingEntity = this.getTarget();
                Intrinsics.checkNotNull((Object)livingEntity, (String)"null cannot be cast to non-null type net.minecraft.server.level.ServerPlayer");
                RepUtilKt.applyRep((Player)((ServerPlayer)livingEntity), RepTier.GAIN_SMALL);
            }
            this.discard();
        }
    }

    private final void handleVisualEffects(List<? extends ServerPlayer> players) {
        Iterator $this$filterTo$iv$iv;
        Iterable $this$filter$iv = players;
        boolean $i$f$filter = false;
        Iterable iterable = $this$filter$iv;
        Collection destination$iv$iv = new ArrayList();
        boolean $i$f$filterTo = false;
        Iterator iterator = $this$filterTo$iv$iv.iterator();
        while (iterator.hasNext()) {
            Object element$iv$iv = iterator.next();
            ServerPlayer it = (ServerPlayer)element$iv$iv;
            boolean bl = false;
            if (!(BaseMonsterExtKt.hasLineOfSightThroughTransparent((BaseMonster)((BaseMonster)this), (Player)((Player)it)) && this.isWithin((Entity)it, 128))) continue;
            destination$iv$iv.add(element$iv$iv);
        }
        List affectedPlayers = (List)destination$iv$iv;
        if (affectedPlayers.isEmpty()) {
            return;
        }
        if (TagExt.INSTANCE.incInt(EntityUtil.getPersistentData((Entity)((Entity)this)), "waitTime") > 45) {
            EntityUtil.getPersistentData((Entity)((Entity)this)).putInt("waitTime", 0);
            CircuitUtil.INSTANCE.incNoWayOutFrame(affectedPlayers);
            if ((double)this.random.nextFloat() <= 0.23) {
                Iterable $this$forEach$iv = affectedPlayers;
                boolean $i$f$forEach = false;
                for (Object element$iv : $this$forEach$iv) {
                    ServerPlayer it = (ServerPlayer)element$iv;
                    boolean bl = false;
                    PlayerExt playerExt = PlayerExt.INSTANCE;
                    SoundEvent soundEvent = (SoundEvent)TBSSounds.CIRCUIT_JUMPSCARE.invoke();
                    RandomSource randomSource = this.random;
                    Intrinsics.checkNotNullExpressionValue((Object)randomSource, (String)"random");
                    float f = RandomUtil.nextFloat((RandomSource)randomSource, (float)0.25f, (float)1.0f);
                    PlayerExt.tryPlaySound$default(playerExt, (Player)it, soundEvent, false, 0.75f, f, 0.15f, 2, null);
                }
            }
            PlayerListExt.INSTANCE.trySendOverlay(affectedPlayers, TBSConstants.id("textures/screens/screenshot_2025-01-01_145155.png"), 2L);
            if ((double)this.random.nextFloat() < 0.7) {
                TimeOfDay.MIDNIGHT.setFake();
                PlayerListExt.INSTANCE.trySendOverlay(affectedPlayers, TBSConstants.id("textures/screens/blick.png"), 10L);
            }
            if ((double)this.random.nextFloat() < 0.7) {
                TimeOfDay.DAY.setFake();
                PlayerListExt.INSTANCE.trySendOverlay(affectedPlayers, TBSConstants.id("textures/screens/frame2.png"), 10L);
            }
            if ((double)this.random.nextFloat() < 0.7) {
                TimeOfDay.DAY.setFake();
            }
        }
        if ((double)this.random.nextFloat() < 0.01) {
            CircuitUtil.INSTANCE.incNoWayOutFrame(affectedPlayers);
        }
        for (ServerPlayer player : affectedPlayers) {
            PlayerVariables vars = PlayerExt.INSTANCE.getVars((Player)player);
            if (vars.getNoWayOutFrame() <= 6) continue;
            vars.setNoWayOutFrame(0);
            vars.syncTo((Player)player);
        }
    }

    public void registerControllers(@NotNull AnimatableManager.ControllerRegistrar reg) {
        Intrinsics.checkNotNullParameter((Object)reg, (String)"reg");
        reg.add(new AnimationController((GeoAnimatable)this, "circuit", 0, arg_0 -> CircuitEntity.registerControllers$lambda$0(this, arg_0)));
    }

    public int getMaxFallDistance() {
        return 3;
    }

    public void die(@NotNull DamageSource damageSource) {
        Intrinsics.checkNotNullParameter((Object)damageSource, (String)"damageSource");
        super.die(damageSource);
        EntityUtil.applyRandomRotation((Entity)EntityTypeExt.trySummon((EntityType)((EntityType)TBSEntities.CIRCUIT_STALK.get()), (LevelAccessor)((LevelAccessor)this.getLevel()), (Vec3)this.getPos()));
        EntityUtil.applyRandomRotation((Entity)EntityTypeExt.trySummon((EntityType)((EntityType)TBSEntities.CIRCUIT_STALK.get()), (LevelAccessor)((LevelAccessor)this.getLevel()), (Vec3)this.getPos()));
        EntityUtil.applyRandomRotation((Entity)EntityTypeExt.trySummon((EntityType)((EntityType)TBSEntities.CIRCUIT_STALK.get()), (LevelAccessor)((LevelAccessor)this.getLevel()), (Vec3)this.getPos()));
    }

    private static final Unit awardKillScore$lambda$0(CircuitEntity this$0, Entity $entity) {
        if ((double)this$0.random.nextFloat() >= 0.1) {
            String string;
            ServerPlayer serverPlayer = (ServerPlayer)$entity;
            if (this$0.random.nextBoolean()) {
                String string2 = ComponentUtil.getTranslationKey((Component)((Component)TBSLang.INSTANCE.getCIRCUIT_KICK_1()));
                string = string2;
                Intrinsics.checkNotNull((Object)string2);
            } else {
                String string3 = ComponentUtil.getTranslationKey((Component)((Component)TBSLang.INSTANCE.getCIRCUIT_KICK_2()));
                string = string3;
                Intrinsics.checkNotNull((Object)string3);
            }
            MutableComponent mutableComponent = Component.translatable((String)string);
            Intrinsics.checkNotNullExpressionValue((Object)mutableComponent, (String)"translatable(...)");
            PlayerUtil.kick((ServerPlayer)serverPlayer, (Component)((Component)mutableComponent));
        }
        return Unit.INSTANCE;
    }

    private static final PlayState registerControllers$lambda$0(CircuitEntity this$0, AnimationState event) {
        if (this$0.getDespawn()) {
            Entity entity = (Entity)this$0;
            AnimationController animationController = event.getController();
            Intrinsics.checkNotNullExpressionValue((Object)animationController, (String)"getController(...)");
            GeckoUtil.hold((Entity)entity, (AnimationController)animationController, (String)"despawn");
        } else if (this$0.getSpawning() && !this$0.getCrouch()) {
            Entity entity = (Entity)this$0;
            AnimationController animationController = event.getController();
            Intrinsics.checkNotNullExpressionValue((Object)animationController, (String)"getController(...)");
            GeckoUtil.hold((Entity)entity, (AnimationController)animationController, (String)"spotted_walk");
        } else if (this$0.getSpotted()) {
            Entity entity = (Entity)this$0;
            AnimationController animationController = event.getController();
            Intrinsics.checkNotNullExpressionValue((Object)animationController, (String)"getController(...)");
            GeckoUtil.hold((Entity)entity, (AnimationController)animationController, (String)"spottedeventchase");
        } else if (this$0.getClimbing()) {
            Entity entity = (Entity)this$0;
            AnimationController animationController = event.getController();
            Intrinsics.checkNotNullExpressionValue((Object)animationController, (String)"getController(...)");
            GeckoUtil.loop((Entity)entity, (AnimationController)animationController, (String)"climb");
        } else if (this$0.getChasing() && event.isMoving() && this$0.getCrouch()) {
            if (!this$0.getDespawn()) {
                Entity entity = (Entity)this$0;
                AnimationController animationController = event.getController();
                Intrinsics.checkNotNullExpressionValue((Object)animationController, (String)"getController(...)");
                GeckoUtil.loop((Entity)entity, (AnimationController)animationController, (String)"mineshaft_chase");
            }
        } else if (this$0.getChasing() && event.isMoving()) {
            if (!this$0.getDespawn()) {
                Entity entity = (Entity)this$0;
                AnimationController animationController = event.getController();
                Intrinsics.checkNotNullExpressionValue((Object)animationController, (String)"getController(...)");
                GeckoUtil.loop((Entity)entity, (AnimationController)animationController, (String)"normal_chase");
            }
        } else if (event.isMoving() && this$0.getCrouch()) {
            if (!this$0.getDespawn()) {
                Entity entity = (Entity)this$0;
                AnimationController animationController = event.getController();
                Intrinsics.checkNotNullExpressionValue((Object)animationController, (String)"getController(...)");
                GeckoUtil.loop((Entity)entity, (AnimationController)animationController, (String)"calm_mineshaft_walk");
            }
        } else if (event.isMoving() && ((double)event.getLimbSwingAmount() < -0.15 || (double)event.getLimbSwingAmount() > 0.15)) {
            if (!this$0.getDespawn()) {
                Entity entity = (Entity)this$0;
                AnimationController animationController = event.getController();
                Intrinsics.checkNotNullExpressionValue((Object)animationController, (String)"getController(...)");
                GeckoUtil.loop((Entity)entity, (AnimationController)animationController, (String)"calm_walk");
            }
        } else if (!this$0.getDespawn() && this$0.getCrouch()) {
            Entity entity = (Entity)this$0;
            AnimationController animationController = event.getController();
            Intrinsics.checkNotNullExpressionValue((Object)animationController, (String)"getController(...)");
            GeckoUtil.loop((Entity)entity, (AnimationController)animationController, (String)"calm_idle_mineshaft");
        } else if (!this$0.getDespawn()) {
            Entity entity = (Entity)this$0;
            AnimationController animationController = event.getController();
            Intrinsics.checkNotNullExpressionValue((Object)animationController, (String)"getController(...)");
            GeckoUtil.loop((Entity)entity, (AnimationController)animationController, (String)"idle_calm_normal");
        }
        return PlayState.CONTINUE;
    }

    public static final /* synthetic */ void access$setHasSeenPlayer$p(CircuitEntity $this, boolean bl) {
        $this.hasSeenPlayer = bl;
    }

    static {
        KProperty[] kPropertyArray = new KProperty[]{Reflection.mutableProperty1((MutablePropertyReference1)((MutablePropertyReference1)new MutablePropertyReference1Impl(CircuitEntity.class, "timer", "getTimer()I", 0))), Reflection.mutableProperty1((MutablePropertyReference1)((MutablePropertyReference1)new MutablePropertyReference1Impl(CircuitEntity.class, "discardTimer", "getDiscardTimer()I", 0))), Reflection.mutableProperty1((MutablePropertyReference1)((MutablePropertyReference1)new MutablePropertyReference1Impl(CircuitEntity.class, "chasing", "getChasing()Z", 0))), Reflection.mutableProperty1((MutablePropertyReference1)((MutablePropertyReference1)new MutablePropertyReference1Impl(CircuitEntity.class, "despawn", "getDespawn()Z", 0))), Reflection.mutableProperty1((MutablePropertyReference1)((MutablePropertyReference1)new MutablePropertyReference1Impl(CircuitEntity.class, "spotted", "getSpotted()Z", 0))), Reflection.mutableProperty1((MutablePropertyReference1)((MutablePropertyReference1)new MutablePropertyReference1Impl(CircuitEntity.class, "crouch", "getCrouch()Z", 0))), Reflection.mutableProperty1((MutablePropertyReference1)((MutablePropertyReference1)new MutablePropertyReference1Impl(CircuitEntity.class, "climbing", "getClimbing()Z", 0))), Reflection.mutableProperty1((MutablePropertyReference1)((MutablePropertyReference1)new MutablePropertyReference1Impl(CircuitEntity.class, "spawning", "getSpawning()Z", 0)))};
        $$delegatedProperties = kPropertyArray;
        Companion = new Companion(null);
        EntityDataAccessor entityDataAccessor = SynchedEntityData.defineId(CircuitEntity.class, (EntityDataSerializer)EntityDataSerializers.BOOLEAN);
        Intrinsics.checkNotNullExpressionValue((Object)entityDataAccessor, (String)"defineId(...)");
        CHASING = entityDataAccessor;
        EntityDataAccessor entityDataAccessor2 = SynchedEntityData.defineId(CircuitEntity.class, (EntityDataSerializer)EntityDataSerializers.BOOLEAN);
        Intrinsics.checkNotNullExpressionValue((Object)entityDataAccessor2, (String)"defineId(...)");
        CROUCH = entityDataAccessor2;
        EntityDataAccessor entityDataAccessor3 = SynchedEntityData.defineId(CircuitEntity.class, (EntityDataSerializer)EntityDataSerializers.BOOLEAN);
        Intrinsics.checkNotNullExpressionValue((Object)entityDataAccessor3, (String)"defineId(...)");
        DESPAWN = entityDataAccessor3;
        EntityDataAccessor entityDataAccessor4 = SynchedEntityData.defineId(CircuitEntity.class, (EntityDataSerializer)EntityDataSerializers.BOOLEAN);
        Intrinsics.checkNotNullExpressionValue((Object)entityDataAccessor4, (String)"defineId(...)");
        SPOTTED = entityDataAccessor4;
        EntityDataAccessor entityDataAccessor5 = SynchedEntityData.defineId(CircuitEntity.class, (EntityDataSerializer)EntityDataSerializers.BOOLEAN);
        Intrinsics.checkNotNullExpressionValue((Object)entityDataAccessor5, (String)"defineId(...)");
        CLIMBING = entityDataAccessor5;
        EntityDataAccessor entityDataAccessor6 = SynchedEntityData.defineId(CircuitEntity.class, (EntityDataSerializer)EntityDataSerializers.BOOLEAN);
        Intrinsics.checkNotNullExpressionValue((Object)entityDataAccessor6, (String)"defineId(...)");
        SPAWNING = entityDataAccessor6;
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\r\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\bR\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\bR\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\bR\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\b\u00a8\u0006\u0013"}, d2={"Lnet/thebrokenscript/entity/circuit/CircuitEntity$Companion;", "", "<init>", "()V", "CHASING", "Lnet/minecraft/network/syncher/EntityDataAccessor;", "", "getCHASING", "()Lnet/minecraft/network/syncher/EntityDataAccessor;", "CROUCH", "getCROUCH", "DESPAWN", "getDESPAWN", "SPOTTED", "getSPOTTED", "CLIMBING", "getCLIMBING", "SPAWNING", "getSPAWNING", "thebrokenscript-common"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final EntityDataAccessor<Boolean> getCHASING() {
            return CHASING;
        }

        @NotNull
        public final EntityDataAccessor<Boolean> getCROUCH() {
            return CROUCH;
        }

        @NotNull
        public final EntityDataAccessor<Boolean> getDESPAWN() {
            return DESPAWN;
        }

        @NotNull
        public final EntityDataAccessor<Boolean> getSPOTTED() {
            return SPOTTED;
        }

        @NotNull
        public final EntityDataAccessor<Boolean> getCLIMBING() {
            return CLIMBING;
        }

        @NotNull
        public final EntityDataAccessor<Boolean> getSPAWNING() {
            return SPAWNING;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }

    @Metadata(mv={2, 1, 0}, k=3, xi=48)
    public static final class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] nArray = new int[Direction.values().length];
            try {
                nArray[Direction.NORTH.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[Direction.SOUTH.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[Direction.WEST.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[Direction.EAST.ordinal()] = 4;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            $EnumSwitchMapping$0 = nArray;
        }
    }
}

