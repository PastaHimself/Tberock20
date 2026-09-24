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
 *  kotlin.jvm.internal.MutablePropertyReference1
 *  kotlin.jvm.internal.MutablePropertyReference1Impl
 *  kotlin.jvm.internal.PropertyReference1
 *  kotlin.jvm.internal.PropertyReference1Impl
 *  kotlin.jvm.internal.Reflection
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.jvm.optionals.OptionalsKt
 *  kotlin.random.Random
 *  kotlin.ranges.RangesKt
 *  kotlin.reflect.KProperty
 *  net.minecraft.client.player.LocalPlayer
 *  net.minecraft.client.resources.sounds.SoundInstance
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Direction
 *  net.minecraft.core.Holder
 *  net.minecraft.core.Vec3i
 *  net.minecraft.core.particles.ParticleOptions
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.network.chat.Component
 *  net.minecraft.network.chat.MutableComponent
 *  net.minecraft.network.protocol.common.custom.CustomPacketPayload
 *  net.minecraft.network.syncher.EntityDataAccessor
 *  net.minecraft.network.syncher.EntityDataSerializer
 *  net.minecraft.network.syncher.EntityDataSerializers
 *  net.minecraft.network.syncher.SynchedEntityData
 *  net.minecraft.network.syncher.SynchedEntityData$Builder
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.server.level.ServerPlayer
 *  net.minecraft.sounds.SoundEvent
 *  net.minecraft.sounds.SoundSource
 *  net.minecraft.tags.GameEventTags
 *  net.minecraft.tags.TagKey
 *  net.minecraft.util.Mth
 *  net.minecraft.util.RandomSource
 *  net.minecraft.world.DifficultyInstance
 *  net.minecraft.world.damagesource.DamageSource
 *  net.minecraft.world.damagesource.DamageTypes
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.Entity$RemovalReason
 *  net.minecraft.world.entity.EntityDimensions
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.Mob
 *  net.minecraft.world.entity.MobSpawnType
 *  net.minecraft.world.entity.MoverType
 *  net.minecraft.world.entity.PathfinderMob
 *  net.minecraft.world.entity.Pose
 *  net.minecraft.world.entity.SpawnGroupData
 *  net.minecraft.world.entity.ai.attributes.AttributeSupplier$Builder
 *  net.minecraft.world.entity.ai.attributes.Attributes
 *  net.minecraft.world.entity.ai.control.MoveControl
 *  net.minecraft.world.entity.ai.control.MoveControl$Operation
 *  net.minecraft.world.entity.ai.goal.FloatGoal
 *  net.minecraft.world.entity.ai.goal.Goal
 *  net.minecraft.world.entity.ai.goal.RandomStrollGoal
 *  net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal
 *  net.minecraft.world.entity.ai.navigation.PathNavigation
 *  net.minecraft.world.entity.monster.Monster
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.item.Items
 *  net.minecraft.world.level.GameType
 *  net.minecraft.world.level.ItemLike
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.level.ServerLevelAccessor
 *  net.minecraft.world.level.block.Blocks
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.gameevent.DynamicGameEventListener
 *  net.minecraft.world.level.gameevent.EntityPositionSource
 *  net.minecraft.world.level.gameevent.GameEvent
 *  net.minecraft.world.level.gameevent.GameEvent$Context
 *  net.minecraft.world.level.gameevent.GameEventListener
 *  net.minecraft.world.level.gameevent.vibrations.VibrationSystem
 *  net.minecraft.world.level.gameevent.vibrations.VibrationSystem$Data
 *  net.minecraft.world.level.gameevent.vibrations.VibrationSystem$Listener
 *  net.minecraft.world.level.gameevent.vibrations.VibrationSystem$Ticker
 *  net.minecraft.world.level.gameevent.vibrations.VibrationSystem$User
 *  net.minecraft.world.level.material.FluidState
 *  net.minecraft.world.level.pathfinder.PathType
 *  net.minecraft.world.phys.Vec3
 *  net.thebrokenscript.brokencore.api.dsl.ChatUtil
 *  net.thebrokenscript.brokencore.api.dsl.ClientDSLKt
 *  net.thebrokenscript.brokencore.api.dsl.ComponentUtil
 *  net.thebrokenscript.brokencore.api.dsl.EntityDataDelegate
 *  net.thebrokenscript.brokencore.api.dsl.EntityFinder
 *  net.thebrokenscript.brokencore.api.dsl.EntityUtil
 *  net.thebrokenscript.brokencore.api.dsl.GeckoUtil
 *  net.thebrokenscript.brokencore.api.dsl.ItemUtil
 *  net.thebrokenscript.brokencore.api.dsl.LevelUtil
 *  net.thebrokenscript.brokencore.api.dsl.PlayerUtil
 *  net.thebrokenscript.brokencore.api.dsl.SideUtil
 *  net.thebrokenscript.brokencore.api.entity.FinalizedSpawn
 *  net.thebrokenscript.brokencore.api.entity.base.BaseMonster
 *  net.thebrokenscript.brokencore.api.entity.base.UwuableMonster
 *  net.thebrokenscript.brokencore.api.platform.CancelProxy
 *  net.thebrokenscript.brokencore.api.sound.FancyEntitySoundInstance
 *  net.thebrokenscript.brokencore.api.sound.FancySoundInstance
 *  net.thebrokenscript.brokencore.api.sound.fx.AudioEffect
 *  net.thebrokenscript.brokencore.api.sound.fx.ReverbPreset
 *  net.thebrokenscript.brokencore.api.sound.fx.ReverbPresets
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  software.bernie.geckolib.animatable.GeoAnimatable
 *  software.bernie.geckolib.animation.AnimatableManager$ControllerRegistrar
 *  software.bernie.geckolib.animation.AnimationController
 *  software.bernie.geckolib.animation.AnimationProcessor$QueuedAnimation
 *  software.bernie.geckolib.animation.AnimationState
 *  software.bernie.geckolib.animation.PlayState
 *  software.bernie.geckolib.animation.RawAnimation
 */
package net.thebrokenscript.entity.players;

import java.lang.invoke.LambdaMetafactory;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.function.BiConsumer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.optionals.OptionalsKt;
import kotlin.random.Random;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KProperty;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.resources.sounds.SoundInstance;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.Vec3i;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializer;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.GameEventTags;
import net.minecraft.tags.TagKey;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.DynamicGameEventListener;
import net.minecraft.world.level.gameevent.EntityPositionSource;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.gameevent.GameEventListener;
import net.minecraft.world.level.gameevent.vibrations.VibrationSystem;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.pathfinder.PathType;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.api.entity.ai.curved.CurvedGoals;
import net.thebrokenscript.api.entity.ai.pathfinding.MazeNavigator;
import net.thebrokenscript.api.ext.PlayerExt;
import net.thebrokenscript.brokencore.api.dsl.ChatUtil;
import net.thebrokenscript.brokencore.api.dsl.ClientDSLKt;
import net.thebrokenscript.brokencore.api.dsl.ComponentUtil;
import net.thebrokenscript.brokencore.api.dsl.EntityDataDelegate;
import net.thebrokenscript.brokencore.api.dsl.EntityFinder;
import net.thebrokenscript.brokencore.api.dsl.EntityUtil;
import net.thebrokenscript.brokencore.api.dsl.GeckoUtil;
import net.thebrokenscript.brokencore.api.dsl.ItemUtil;
import net.thebrokenscript.brokencore.api.dsl.LevelUtil;
import net.thebrokenscript.brokencore.api.dsl.PlayerUtil;
import net.thebrokenscript.brokencore.api.dsl.SideUtil;
import net.thebrokenscript.brokencore.api.entity.FinalizedSpawn;
import net.thebrokenscript.brokencore.api.entity.base.BaseMonster;
import net.thebrokenscript.brokencore.api.entity.base.UwuableMonster;
import net.thebrokenscript.brokencore.api.platform.CancelProxy;
import net.thebrokenscript.brokencore.api.sound.FancyEntitySoundInstance;
import net.thebrokenscript.brokencore.api.sound.FancySoundInstance;
import net.thebrokenscript.brokencore.api.sound.fx.AudioEffect;
import net.thebrokenscript.brokencore.api.sound.fx.ReverbPreset;
import net.thebrokenscript.brokencore.api.sound.fx.ReverbPresets;
import net.thebrokenscript.client.data.ClientVariables;
import net.thebrokenscript.config.TBSConfigs;
import net.thebrokenscript.registry.TBSItems;
import net.thebrokenscript.registry.TBSLang;
import net.thebrokenscript.registry.TBSPackets;
import net.thebrokenscript.registry.TBSParticleTypes;
import net.thebrokenscript.registry.TBSSounds;
import net.thebrokenscript.util.RepTier;
import net.thebrokenscript.util.RepUtilKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.animation.AnimationController;
import software.bernie.geckolib.animation.AnimationProcessor;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.animation.PlayState;
import software.bernie.geckolib.animation.RawAnimation;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u00f8\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u0085\u00012\u00020\u00012\u00020\u00022\u00020\u0003:\u0006\u0083\u0001\u0084\u0001\u0085\u0001B\u001d\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00000\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0006\u001a\u00020\u0007H\u0014J\b\u0010\u0019\u001a\u00020\u0016H\u0016J\f\u0010\u001a\u001a\u00060\u0018R\u00020\u0000H\u0016J \u0010\u001b\u001a\u00020\u001c2\u0016\u0010\u001d\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0012\u0012\u0004\u0012\u00020\u001f0\u001eH\u0016J\u0010\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0014J\b\u0010$\u001a\u00020\u000bH\u0016J\u000e\u0010%\u001a\u00020\u001c2\u0006\u0010&\u001a\u00020'J\u0010\u00106\u001a\u00020\u001c2\u0006\u00107\u001a\u000208H\u0016J\u0018\u0010A\u001a\u00020\u001c2\u0006\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020EH\u0014J\b\u0010G\u001a\u00020\u001cH\u0016J\u0012\u0010H\u001a\u0004\u0018\u00010;2\u0006\u0010I\u001a\u00020JH\u0014J\n\u0010K\u001a\u0004\u0018\u00010;H\u0014J\u0010\u0010^\u001a\u00020\u001c2\u0006\u0010_\u001a\u00020`H\u0014J\u000e\u0010a\u001a\u00020\u001c2\u0006\u0010&\u001a\u00020'J\u0018\u0010b\u001a\u00020\u000b2\u0006\u0010c\u001a\u00020J2\u0006\u0010d\u001a\u00020?H\u0016J\b\u0010e\u001a\u00020\u001cH\u0014J\u0010\u0010f\u001a\u00020\u000b2\u0006\u0010g\u001a\u00020hH\u0016J\u0010\u0010i\u001a\u00020\u001c2\u0006\u0010c\u001a\u00020JH\u0016J4\u0010j\u001a\u0004\u0018\u00010k2\u0006\u0010\u0006\u001a\u00020l2\u0006\u0010m\u001a\u00020n2\u0006\u0010o\u001a\u00020\u000e2\b\u0010p\u001a\u0004\u0018\u00010k2\u0006\u0010q\u001a\u00020rH\u0016J\u0010\u0010s\u001a\u00020\u001c2\u0006\u0010t\u001a\u00020uH\u0016J\u0010\u0010v\u001a\u00020\u001c2\u0006\u0010t\u001a\u00020uH\u0016J\u0010\u0010w\u001a\u00020\u000b2\u0006\u0010x\u001a\u00020yH\u0016J \u0010z\u001a\u00020\u001c2\u0006\u0010{\u001a\u00020|2\u0006\u0010}\u001a\u00020.2\u0006\u0010I\u001a\u00020JH\u0016J\b\u0010~\u001a\u00020\u001cH\u0016J\u0012\u0010\u007f\u001a\u00020\u001c2\b\u0010\u0080\u0001\u001a\u00030\u0081\u0001H\u0016J\t\u0010\u0082\u0001\u001a\u00020\u001cH\u0014R\u001c\u0010\u0011\u001a\u0010\u0012\f\u0012\n \u0014*\u0004\u0018\u00010\u00130\u00130\u0012X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0017\u001a\u00060\u0018R\u00020\u0000X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010(\u001a\u0004\u0018\u00010'X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001a\u0010-\u001a\u00020.X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001a\u00103\u001a\u00020.X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b4\u00100\"\u0004\b5\u00102R\u0017\u00109\u001a\b\u0012\u0004\u0012\u00020;0:\u00a2\u0006\b\n\u0000\u001a\u0004\b<\u0010=R\u0017\u0010>\u001a\b\u0012\u0004\u0012\u00020?0:\u00a2\u0006\b\n\u0000\u001a\u0004\b@\u0010=R\u000e\u0010F\u001a\u00020.X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010L\u001a\u00020.8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\bN\u0010O\u001a\u0004\bM\u00100R+\u0010Q\u001a\u00020.2\u0006\u0010P\u001a\u00020.8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\bT\u0010O\u001a\u0004\bR\u00100\"\u0004\bS\u00102R+\u0010U\u001a\u00020\u000b2\u0006\u0010P\u001a\u00020\u000b8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\bZ\u0010O\u001a\u0004\bV\u0010W\"\u0004\bX\u0010YR+\u0010[\u001a\u00020\u000b2\u0006\u0010P\u001a\u00020\u000b8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b]\u0010O\u001a\u0004\b[\u0010W\"\u0004\b\\\u0010Y\u00a8\u0006\u0086\u0001"}, d2={"Lnet/thebrokenscript/entity/players/CurvedEntity;", "Lnet/thebrokenscript/brokencore/api/entity/base/UwuableMonster;", "Lnet/thebrokenscript/brokencore/api/entity/FinalizedSpawn;", "Lnet/minecraft/world/level/gameevent/vibrations/VibrationSystem;", "type", "Lnet/minecraft/world/entity/EntityType;", "level", "Lnet/minecraft/world/level/Level;", "<init>", "(Lnet/minecraft/world/entity/EntityType;Lnet/minecraft/world/level/Level;)V", "checkSpawnRules", "", "Lnet/minecraft/world/level/LevelAccessor;", "spawnReason", "Lnet/minecraft/world/entity/MobSpawnType;", "createNavigation", "Lnet/minecraft/world/entity/ai/navigation/PathNavigation;", "dynamicGameEventListener", "Lnet/minecraft/world/level/gameevent/DynamicGameEventListener;", "Lnet/minecraft/world/level/gameevent/vibrations/VibrationSystem$Listener;", "kotlin.jvm.PlatformType", "vibrationData", "Lnet/minecraft/world/level/gameevent/vibrations/VibrationSystem$Data;", "vibrationUser", "Lnet/thebrokenscript/entity/players/CurvedEntity$CurvedVibrationUser;", "getVibrationData", "getVibrationUser", "updateDynamicGameEventListener", "", "listenerConsumer", "Ljava/util/function/BiConsumer;", "Lnet/minecraft/server/level/ServerLevel;", "getDefaultDimensions", "Lnet/minecraft/world/entity/EntityDimensions;", "pose", "Lnet/minecraft/world/entity/Pose;", "isVisuallySwimming", "onHeardBlockBreak", "player", "Lnet/minecraft/world/entity/player/Player;", "blockBreakAlertTarget", "getBlockBreakAlertTarget", "()Lnet/minecraft/world/entity/player/Player;", "setBlockBreakAlertTarget", "(Lnet/minecraft/world/entity/player/Player;)V", "blockBreakAlertTicks", "", "getBlockBreakAlertTicks", "()I", "setBlockBreakAlertTicks", "(I)V", "blockBreakAlertStage", "getBlockBreakAlertStage", "setBlockBreakAlertStage", "travel", "travelVector", "Lnet/minecraft/world/phys/Vec3;", "stepSounds", "", "Lnet/minecraft/sounds/SoundEvent;", "getStepSounds", "()Ljava/util/List;", "pitches", "", "getPitches", "playStepSound", "pos", "Lnet/minecraft/core/BlockPos;", "state", "Lnet/minecraft/world/level/block/state/BlockState;", "stepCooldown", "tick", "getHurtSound", "damageSource", "Lnet/minecraft/world/damagesource/DamageSource;", "getDeathSound", "despawnTimer", "getDespawnTimer", "despawnTimer$delegate", "Lnet/thebrokenscript/brokencore/api/dsl/EntityDataDelegate;", "<set-?>", "transformTimer", "getTransformTimer", "setTransformTimer", "transformTimer$delegate", "transformed", "getTransformed", "()Z", "setTransformed", "(Z)V", "transformed$delegate", "isDead", "setDead", "isDead$delegate", "defineSynchedData", "builder", "Lnet/minecraft/network/syncher/SynchedEntityData$Builder;", "noticePlayer", "hurt", "source", "amount", "registerGoals", "removeWhenFarAway", "distanceToClosestPlayer", "", "die", "onFinalizeSpawn", "Lnet/minecraft/world/entity/SpawnGroupData;", "Lnet/minecraft/world/level/ServerLevelAccessor;", "difficulty", "Lnet/minecraft/world/DifficultyInstance;", "spawnType", "spawnData", "event", "Lnet/thebrokenscript/brokencore/api/platform/CancelProxy;", "addAdditionalSaveData", "compound", "Lnet/minecraft/nbt/CompoundTag;", "readAdditionalSaveData", "canStandOnFluid", "fluidState", "Lnet/minecraft/world/level/material/FluidState;", "awardKillScore", "entity", "Lnet/minecraft/world/entity/Entity;", "score", "baseTick", "registerControllers", "reg", "Lsoftware/bernie/geckolib/animation/AnimatableManager$ControllerRegistrar;", "tickDeath", "CurvedMoveControl", "CurvedVibrationUser", "Companion", "thebrokenscript-common"})
@SourceDebugExtension(value={"SMAP\nCurvedEntity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CurvedEntity.kt\nnet/thebrokenscript/entity/players/CurvedEntity\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,703:1\n1869#2,2:704\n1869#2,2:706\n1869#2,2:708\n1869#2,2:710\n*S KotlinDebug\n*F\n+ 1 CurvedEntity.kt\nnet/thebrokenscript/entity/players/CurvedEntity\n*L\n271#1:704,2\n369#1:706,2\n464#1:708,2\n576#1:710,2\n*E\n"})
public final class CurvedEntity
extends UwuableMonster
implements FinalizedSpawn,
VibrationSystem {
    @NotNull
    public static final Companion Companion;
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;
    @NotNull
    private final DynamicGameEventListener<VibrationSystem.Listener> dynamicGameEventListener;
    @NotNull
    private VibrationSystem.Data vibrationData;
    @NotNull
    private final CurvedVibrationUser vibrationUser;
    @Nullable
    private volatile Player blockBreakAlertTarget;
    private volatile int blockBreakAlertTicks;
    private volatile int blockBreakAlertStage;
    @NotNull
    private final List<SoundEvent> stepSounds;
    @NotNull
    private final List<Float> pitches;
    private int stepCooldown;
    @NotNull
    private final EntityDataDelegate despawnTimer$delegate;
    @NotNull
    private final EntityDataDelegate transformTimer$delegate;
    @NotNull
    private final EntityDataDelegate transformed$delegate;
    @NotNull
    private final EntityDataDelegate isDead$delegate;
    @NotNull
    private static final EntityDataAccessor<Integer> DESPAWN_TIMER;
    @NotNull
    private static final EntityDataAccessor<Integer> TRANSFORMING_TIMER;
    @NotNull
    private static final EntityDataAccessor<Boolean> TRANSFORMED;
    @NotNull
    private static final EntityDataAccessor<Boolean> IS_DEAD;

    public CurvedEntity(@NotNull EntityType<CurvedEntity> type, @NotNull Level level) {
        Intrinsics.checkNotNullParameter(type, (String)"type");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        super(type, level);
        this.xpReward = 0;
        this.setNoAi(false);
        this.setPersistenceRequired();
        this.setPathfindingMalus(PathType.DANGER_POWDER_SNOW, 2.0f);
        this.setPathfindingMalus(PathType.POWDER_SNOW, 4.0f);
        this.setPathfindingMalus(PathType.LAVA, 0.0f);
        this.setPathfindingMalus(PathType.FENCE, 0.0f);
        this.setPathfindingMalus(PathType.RAIL, 0.0f);
        this.setPathfindingMalus(PathType.UNPASSABLE_RAIL, 0.0f);
        this.setPathfindingMalus(PathType.WATER, 0.0f);
        this.setPathfindingMalus(PathType.WATER_BORDER, 0.0f);
        this.setPathfindingMalus(PathType.WALKABLE, 0.0f);
        this.setPathfindingMalus(PathType.DAMAGE_OTHER, 0.0f);
        this.setPathfindingMalus(PathType.DANGER_OTHER, 0.0f);
        this.setPathfindingMalus(PathType.DAMAGE_FIRE, 0.0f);
        this.setPathfindingMalus(PathType.DANGER_FIRE, 0.0f);
        this.moveControl = new CurvedMoveControl(this);
        this.dynamicGameEventListener = new DynamicGameEventListener((GameEventListener)new VibrationSystem.Listener((VibrationSystem)this));
        this.vibrationData = new VibrationSystem.Data();
        this.vibrationUser = new CurvedVibrationUser();
        Object[] objectArray = new SoundEvent[]{TBSSounds.CURVED_STEP1.invoke(), TBSSounds.CURVED_STEP2.invoke(), TBSSounds.CURVED_STEP3.invoke(), TBSSounds.CURVED_STEP4.invoke(), TBSSounds.CURVED_STEP5.invoke()};
        this.stepSounds = CollectionsKt.listOf((Object[])objectArray);
        objectArray = new Float[]{Float.valueOf(0.5f), Float.valueOf(0.75f), Float.valueOf(1.0f), Float.valueOf(1.25f)};
        this.pitches = CollectionsKt.listOf((Object[])objectArray);
        this.despawnTimer$delegate = this.entityData(DESPAWN_TIMER);
        this.transformTimer$delegate = this.entityData(TRANSFORMING_TIMER);
        this.transformed$delegate = this.entityData(TRANSFORMED);
        this.isDead$delegate = this.entityData(IS_DEAD);
    }

    public boolean checkSpawnRules(@NotNull LevelAccessor level, @NotNull MobSpawnType spawnReason) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)spawnReason, (String)"spawnReason");
        return true;
    }

    @NotNull
    protected PathNavigation createNavigation(@NotNull Level level) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        return (PathNavigation)new MazeNavigator((Mob)this, level);
    }

    @NotNull
    public VibrationSystem.Data getVibrationData() {
        return this.vibrationData;
    }

    @NotNull
    public CurvedVibrationUser getVibrationUser() {
        return this.vibrationUser;
    }

    public void updateDynamicGameEventListener(@NotNull BiConsumer<DynamicGameEventListener<?>, ServerLevel> listenerConsumer) {
        Intrinsics.checkNotNullParameter(listenerConsumer, (String)"listenerConsumer");
        Level level = this.level();
        if (level instanceof ServerLevel) {
            listenerConsumer.accept(this.dynamicGameEventListener, (ServerLevel)level);
        }
    }

    @NotNull
    protected EntityDimensions getDefaultDimensions(@NotNull Pose pose) {
        EntityDimensions entityDimensions;
        Intrinsics.checkNotNullParameter((Object)pose, (String)"pose");
        if (pose == Pose.SWIMMING && !this.getLevel().getBlockState(this.getBlockPos().above()).isAir()) {
            EntityDimensions entityDimensions2 = EntityDimensions.scalable((float)1.5f, (float)1.0f);
            Intrinsics.checkNotNull((Object)entityDimensions2);
            entityDimensions = entityDimensions2;
        } else {
            EntityDimensions entityDimensions3 = super.getDefaultDimensions(pose);
            Intrinsics.checkNotNull((Object)entityDimensions3);
            entityDimensions = entityDimensions3;
        }
        return entityDimensions;
    }

    public boolean isVisuallySwimming() {
        return this.getPose() == Pose.SWIMMING;
    }

    public final void onHeardBlockBreak(@NotNull Player player) {
        Intrinsics.checkNotNullParameter((Object)player, (String)"player");
        if (this.isDead() || !this.getTransformed()) {
            return;
        }
        this.blockBreakAlertTicks = 120;
        this.blockBreakAlertTarget = player;
        if (this.blockBreakAlertStage < 3) {
            int n = this.blockBreakAlertStage;
            this.blockBreakAlertStage = n + 1;
        }
    }

    @Nullable
    public final Player getBlockBreakAlertTarget() {
        return this.blockBreakAlertTarget;
    }

    public final void setBlockBreakAlertTarget(@Nullable Player player) {
        this.blockBreakAlertTarget = player;
    }

    public final int getBlockBreakAlertTicks() {
        return this.blockBreakAlertTicks;
    }

    public final void setBlockBreakAlertTicks(int n) {
        this.blockBreakAlertTicks = n;
    }

    public final int getBlockBreakAlertStage() {
        return this.blockBreakAlertStage;
    }

    public final void setBlockBreakAlertStage(int n) {
        this.blockBreakAlertStage = n;
    }

    /*
     * Enabled aggressive block sorting
     */
    public void travel(@NotNull Vec3 travelVector) {
        Intrinsics.checkNotNullParameter((Object)travelVector, (String)"travelVector");
        if (!this.isControlledByLocalInstance()) return;
        FluidState fluidstate = this.level().getFluidState(this.blockPosition());
        if (this.isInWater() && this.isAffectedByFluids()) {
            Intrinsics.checkNotNull((Object)fluidstate);
            if (!this.canStandOnFluid(fluidstate)) {
                this.moveRelative(this.getSpeed(), travelVector);
                this.move(MoverType.SELF, this.getDeltaMovement());
                this.setDeltaMovement(this.getDeltaMovement().multiply(0.6, 0.98, 0.6));
                return;
            }
        }
        super.travel(travelVector);
    }

    @NotNull
    public final List<SoundEvent> getStepSounds() {
        return this.stepSounds;
    }

    @NotNull
    public final List<Float> getPitches() {
        return this.pitches;
    }

    protected void playStepSound(@NotNull BlockPos pos, @NotNull BlockState state) {
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        Intrinsics.checkNotNullParameter((Object)state, (String)"state");
        if (!this.getTransformed()) {
            super.playStepSound(pos, state);
        }
    }

    public void tick() {
        super.tick();
        SideUtil.clientSide((Entity)((Entity)this), () -> CurvedEntity.tick$lambda$0(this));
    }

    @Nullable
    protected SoundEvent getHurtSound(@NotNull DamageSource damageSource) {
        Intrinsics.checkNotNullParameter((Object)damageSource, (String)"damageSource");
        return this.getTransformed() ? (SoundEvent)TBSSounds.CURVED_HURT.invoke() : super.getHurtSound(damageSource);
    }

    @Nullable
    protected SoundEvent getDeathSound() {
        Iterable $this$forEach$iv = EntityFinder.findPlayersInRange((LevelAccessor)((LevelAccessor)this.getLevel()), (Vec3)this.getPos(), (Number)92);
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            Player player = (Player)element$iv;
            boolean bl = false;
            PlayerUtil.trySendCustomPacket((Player)player, (CustomPacketPayload)((CustomPacketPayload)TBSPackets.CURVED_DEATH_PACKET.of(this.getId())));
        }
        return null;
    }

    public final int getDespawnTimer() {
        return ((Number)this.despawnTimer$delegate.getValue((BaseMonster)this, $$delegatedProperties[0])).intValue();
    }

    public final int getTransformTimer() {
        return ((Number)this.transformTimer$delegate.getValue((BaseMonster)this, $$delegatedProperties[1])).intValue();
    }

    public final void setTransformTimer(int n) {
        this.transformTimer$delegate.setValue((BaseMonster)this, $$delegatedProperties[1], (Object)n);
    }

    public final boolean getTransformed() {
        return (Boolean)this.transformed$delegate.getValue((BaseMonster)this, $$delegatedProperties[2]);
    }

    public final void setTransformed(boolean bl) {
        this.transformed$delegate.setValue((BaseMonster)this, $$delegatedProperties[2], (Object)bl);
    }

    public final boolean isDead() {
        return (Boolean)this.isDead$delegate.getValue((BaseMonster)this, $$delegatedProperties[3]);
    }

    public final void setDead(boolean bl) {
        this.isDead$delegate.setValue((BaseMonster)this, $$delegatedProperties[3], (Object)bl);
    }

    protected void defineSynchedData(@NotNull SynchedEntityData.Builder builder) {
        Intrinsics.checkNotNullParameter((Object)builder, (String)"builder");
        super.defineSynchedData(builder);
        builder.define(DESPAWN_TIMER, (Object)0);
        builder.define(TRANSFORMING_TIMER, (Object)100);
        builder.define(TRANSFORMED, (Object)false);
        builder.define(IS_DEAD, (Object)false);
    }

    public final void noticePlayer(@NotNull Player player) {
        Intrinsics.checkNotNullParameter((Object)player, (String)"player");
        PlayerUtil.trySendCustomPacket((Player)player, (CustomPacketPayload)((CustomPacketPayload)TBSPackets.CURVED_NOTICE_PACKET.of(this.getId())));
    }

    public boolean hurt(@NotNull DamageSource source, float amount) {
        boolean bl;
        Intrinsics.checkNotNullParameter((Object)source, (String)"source");
        boolean isPlayer = source.getDirectEntity() instanceof Player;
        if (isPlayer || Intrinsics.areEqual((Object)source.type(), (Object)DamageTypes.GENERIC_KILL) || Intrinsics.areEqual((Object)source.type(), (Object)DamageTypes.FELL_OUT_OF_WORLD)) {
            if (this.getTransformed()) {
                this.triggerAnim(null, "hit");
            }
            bl = super.hurt(source, amount);
        } else {
            bl = false;
        }
        return bl;
    }

    protected void registerGoals() {
        super.registerGoals();
        this.targetSelector.addGoal(1, (Goal)new CurvedGoals.AlwaysTargetPlayerGoal(this, 400));
        this.targetSelector.addGoal(2, (Goal)new HurtByTargetGoal((PathfinderMob)this, new Class[0]));
        this.goalSelector.addGoal(0, (Goal)new FloatGoal((Mob)this));
        this.goalSelector.addGoal(1, (Goal)new CurvedGoals.ContinuousMeleeAttackGoal((PathfinderMob)this, 1.5, 0.0, 1.5f, 0.0f, 20, null));
        this.goalSelector.addGoal(2, (Goal)new CurvedGoals.InvestigateBlockBreakGoal(this));
        this.goalSelector.addGoal(3, (Goal)new RandomStrollGoal(this){
            final /* synthetic */ CurvedEntity this$0;
            {
                this.this$0 = $receiver;
                super((PathfinderMob)$receiver, 0.85);
            }

            public boolean canUse() {
                if (this.this$0.getTarget() != null || this.mob.hasControllingPassenger()) {
                    return false;
                }
                if (!this.this$0.getTransformed()) {
                    return false;
                }
                if (!this.forceTrigger && this.mob.getRandom().nextInt(RandomStrollGoal.reducedTickDelay((int)60)) != 0) {
                    return false;
                }
                Vec3 vec3 = this.getPosition();
                if (vec3 == null) {
                    return false;
                }
                Vec3 vec32 = vec3;
                this.wantedX = vec32.x;
                this.wantedY = vec32.y;
                this.wantedZ = vec32.z;
                this.forceTrigger = false;
                return true;
            }

            public boolean canContinueToUse() {
                return super.canContinueToUse() && this.this$0.getTarget() == null;
            }
        });
    }

    public boolean removeWhenFarAway(double distanceToClosestPlayer) {
        return false;
    }

    public void die(@NotNull DamageSource source) {
        Intrinsics.checkNotNullParameter((Object)source, (String)"source");
        super.die(source);
        this.setDead(true);
        if (!(this.getLevel() instanceof ServerLevel)) {
            return;
        }
        Object[] objectArray = new ItemStack[]{new ItemStack((ItemLike)Blocks.COBBLESTONE, this.random.nextInt(1, 25)), new ItemStack((ItemLike)Items.IRON_INGOT, this.random.nextInt(1, 25)), new ItemStack((ItemLike)Items.STONE_AXE), new ItemStack((ItemLike)Items.STONE_SWORD), new ItemStack((ItemLike)TBSItems.RECORD_16.get()), new ItemStack((ItemLike)Items.DIRT), new ItemStack((ItemLike)Items.REDSTONE_TORCH), new ItemStack((ItemLike)Items.OAK_PLANKS), new ItemStack((ItemLike)Items.OAK_LOG), new ItemStack((ItemLike)Items.ROTTEN_FLESH), new ItemStack((ItemLike)Items.STRING), new ItemStack((ItemLike)Items.OAK_SAPLING), new ItemStack((ItemLike)Items.DIAMOND), new ItemStack((Holder)TBSItems.TORN_PAPER)};
        Iterable $this$forEach$iv = CollectionsKt.listOf((Object[])objectArray);
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            ItemStack it = (ItemStack)element$iv;
            boolean bl = false;
            ItemUtil.tryDropItems$default((LevelAccessor)((LevelAccessor)this.getLevel()), (Vec3)this.getPos(), (ItemStack)it, (int)0, (int)4, null);
        }
        if (source.getEntity() != null) {
            LevelAccessor levelAccessor = (LevelAccessor)this.getLevel();
            String string = ComponentUtil.getTranslationKey((Component)((Component)TBSLang.INSTANCE.getCURVED_DEATH()));
            Intrinsics.checkNotNull((Object)string);
            Object[] objectArray2 = new Object[1];
            Entity entity = source.getEntity();
            objectArray2[0] = entity != null ? entity.getDisplayName() : null;
            MutableComponent mutableComponent = Component.translatable((String)string, (Object[])objectArray2);
            Intrinsics.checkNotNullExpressionValue((Object)mutableComponent, (String)"translatable(...)");
            v4 = ChatUtil.chat$default((LevelAccessor)levelAccessor, (Component)((Component)mutableComponent), (boolean)false, (int)2, null);
        } else {
            v4 = ChatUtil.chat$default((LevelAccessor)((LevelAccessor)this.getLevel()), (Component)((Component)TBSLang.INSTANCE.getCURVED_DEATH_UNKNOWN()), (boolean)false, (int)2, null);
        }
        if (source.getEntity() instanceof ServerPlayer) {
            Entity entity = source.getEntity();
            Intrinsics.checkNotNull((Object)entity, (String)"null cannot be cast to non-null type net.minecraft.server.level.ServerPlayer");
            RepUtilKt.applyRep((Player)((ServerPlayer)entity), RepTier.GAIN_MEDIUM);
        }
        LevelUtil.getQueue((Level)this.getLevel()).add(100L, () -> CurvedEntity.die$lambda$1(this));
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
        this.setAggressive(false);
        this.setCustomName((Component)TBSLang.INSTANCE.getCURVED_NAME());
        this.setCustomNameVisible(true);
        if (!level.canSeeSkyFromBelowWater(this.getBlockPos())) {
            this.setTransformed(true);
        }
        return null;
    }

    public void addAdditionalSaveData(@NotNull CompoundTag compound) {
        Intrinsics.checkNotNullParameter((Object)compound, (String)"compound");
        super.addAdditionalSaveData(compound);
        Object object = this.entityData.get(DESPAWN_TIMER);
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"get(...)");
        compound.putInt("despawn_timer", ((Number)object).intValue());
        Object object2 = this.entityData.get(TRANSFORMING_TIMER);
        Intrinsics.checkNotNullExpressionValue((Object)object2, (String)"get(...)");
        compound.putInt("transform_timer", ((Number)object2).intValue());
        Object object3 = this.entityData.get(TRANSFORMED);
        Intrinsics.checkNotNullExpressionValue((Object)object3, (String)"get(...)");
        compound.putBoolean("transformed", ((Boolean)object3).booleanValue());
        Object object4 = this.entityData.get(IS_DEAD);
        Intrinsics.checkNotNullExpressionValue((Object)object4, (String)"get(...)");
        compound.putBoolean("is_dead", ((Boolean)object4).booleanValue());
    }

    public void readAdditionalSaveData(@NotNull CompoundTag compound) {
        Intrinsics.checkNotNullParameter((Object)compound, (String)"compound");
        super.readAdditionalSaveData(compound);
        if (compound.contains("is_dead")) {
            this.entityData.set(IS_DEAD, (Object)compound.getBoolean("is_dead"));
        }
        if (compound.contains("despawn_timer")) {
            this.entityData.set(DESPAWN_TIMER, (Object)compound.getInt("despawn_timer"));
        }
        if (compound.contains("transform_timer")) {
            this.entityData.set(TRANSFORMING_TIMER, (Object)compound.getInt("transform_timer"));
        }
        if (compound.contains("transformed")) {
            this.entityData.set(TRANSFORMED, (Object)compound.getBoolean("transformed"));
        }
    }

    public boolean canStandOnFluid(@NotNull FluidState fluidState) {
        block7: {
            block5: {
                block6: {
                    block4: {
                        Intrinsics.checkNotNullParameter((Object)fluidState, (String)"fluidState");
                        if (this.getTarget() == null || !this.getTransformed()) {
                            return !fluidState.isEmpty();
                        }
                        LivingEntity livingEntity = this.getTarget();
                        Intrinsics.checkNotNull((Object)livingEntity);
                        if (!livingEntity.isSwimming()) break block4;
                        LivingEntity livingEntity2 = this.getTarget();
                        Intrinsics.checkNotNull((Object)livingEntity2);
                        if (livingEntity2.isInWater()) break block5;
                    }
                    LivingEntity livingEntity = this.getTarget();
                    Intrinsics.checkNotNull((Object)livingEntity);
                    if (!livingEntity.isVisuallySwimming()) break block6;
                    LivingEntity livingEntity3 = this.getTarget();
                    Intrinsics.checkNotNull((Object)livingEntity3);
                    if (livingEntity3.isInWater()) break block5;
                }
                LivingEntity livingEntity = this.getTarget();
                Intrinsics.checkNotNull((Object)livingEntity);
                if (!livingEntity.isInWater()) break block7;
            }
            return false;
        }
        return !fluidState.isEmpty();
    }

    public void awardKillScore(@NotNull Entity entity, int score, @NotNull DamageSource damageSource) {
        block1: {
            Intrinsics.checkNotNullParameter((Object)entity, (String)"entity");
            Intrinsics.checkNotNullParameter((Object)damageSource, (String)"damageSource");
            super.awardKillScore(entity, score, damageSource);
            Level level = this.level();
            Intrinsics.checkNotNullExpressionValue((Object)level, (String)"level(...)");
            CurvedEntity other = (CurvedEntity)EntityFinder.findClosestEntityInRange((LevelAccessor)((LevelAccessor)level), CurvedEntity.class, (Vec3)new Vec3(this.getX(), this.getY(), this.getZ()), (Number)40.0);
            if (this.level().isClientSide) break block1;
            CurvedEntity curvedEntity = other;
            if (curvedEntity != null) {
                curvedEntity.discard();
            }
        }
    }

    /*
     * Unable to fully structure code
     */
    public void baseTick() {
        if (this.isDead() && !this.dead) {
            this.setHealth(0.0f);
            this.dead = true;
            if (this.getLevel() instanceof ServerLevel) {
                $this$forEach$iv = EntityFinder.findPlayersInRange((LevelAccessor)((LevelAccessor)this.getLevel()), (Vec3)this.getPos(), (Number)92);
                $i$f$forEach = false;
                for (T element$iv : $this$forEach$iv) {
                    player = (Player)element$iv;
                    $i$a$-forEach-CurvedEntity$baseTick$1 = false;
                    PlayerUtil.trySendCustomPacket((Player)player, (CustomPacketPayload)((CustomPacketPayload)TBSPackets.CURVED_DEATH_PACKET.of(this.getId())));
                }
            }
        }
        super.baseTick();
        if (this.isDead()) {
            return;
        }
        level = this.level();
        if (level instanceof ServerLevel) {
            VibrationSystem.Ticker.tick((Level)level, (VibrationSystem.Data)this.vibrationData, (VibrationSystem.User)this.vibrationUser);
        }
        if ((player = level.getNearestPlayer((Entity)this, 10.0)) != null) {
            v0 = PlayerUtil.getGameMode((Player)player);
            Intrinsics.checkNotNull((Object)v0);
            if (v0.isSurvival() && !this.isAggressive() && !this.getTransformed()) {
                this.navigation.stop();
                this.setInvulnerable(true);
                this.setAggressive(true);
                SideUtil.clientSide((Entity)((Entity)this), (Function0)(Function0)LambdaMetafactory.metafactory(null, null, null, ()Ljava/lang/Object;, baseTick$lambda$1(net.thebrokenscript.entity.players.CurvedEntity ), ()Lkotlin/Unit;)((CurvedEntity)this));
            }
        }
        if (level.getBlockState(this.getBlockPos()).getFluidState().isEmpty() && level.getBlockState(this.getBlockPos().above()).getFluidState().isEmpty()) ** GOTO lbl-1000
        if (level.isClientSide) ** GOTO lbl-1000
        v1 = this.getBlockStateOn().getFluidState();
        Intrinsics.checkNotNullExpressionValue((Object)v1, (String)"getFluidState(...)");
        if (!this.canStandOnFluid(v1)) lbl-1000:
        // 2 sources

        {
            v2 = true;
        } else lbl-1000:
        // 2 sources

        {
            v2 = inFluid = false;
        }
        if (inFluid && this.getTransformed()) {
            this.navigation.setCanFloat(true);
            this.setSwimming(true);
            if (this.getPose() != Pose.SWIMMING) {
                this.setPose(Pose.SWIMMING);
            }
            if (this.getTarget() != null) {
                this.navigation.stop();
                v3 = this.getTarget();
                Intrinsics.checkNotNull((Object)v3);
                if (v3.getY() > this.getPos().y) {
                    this.setDeltaMovement(this.getDeltaMovement().x, 0.1, this.getDeltaMovement().z);
                } else {
                    this.setDeltaMovement(this.getDeltaMovement().x, -0.1, this.getDeltaMovement().z);
                }
                v4 = this.getTarget();
                Intrinsics.checkNotNull((Object)v4);
                v5 = v4.getX();
                v6 = this.getTarget();
                Intrinsics.checkNotNull((Object)v6);
                v7 = v6.getY();
                v8 = this.getTarget();
                Intrinsics.checkNotNull((Object)v8);
                this.moveControl.setWantedPosition(v5, v7, v8.getZ(), 0.75);
            }
        } else {
            if (this.isUnderWater()) {
                v9 = this.getBlockStateOn().getFluidState();
                Intrinsics.checkNotNullExpressionValue((Object)v9, (String)"getFluidState(...)");
                if (this.canStandOnFluid(v9)) {
                    this.setDeltaMovement(this.getDeltaMovement().x, 0.75, this.getDeltaMovement().z);
                }
            }
            this.setSwimming(false);
            if (this.getPose() != Pose.STANDING) {
                this.setPose(Pose.STANDING);
            }
        }
        if (this.isVisuallySwimming()) {
            this.yBodyRot = Mth.rotateIfNecessary((float)this.yBodyRot, (float)this.getYRot(), (float)10.0f);
        }
        if (!(level instanceof ServerLevel)) {
            return;
        }
        if (!this.getTransformed() && !this.isAggressive()) {
            v10 = EntityFinder.findClosestPlayerInRange((ServerLevel)((ServerLevel)level), (Vec3)this.getPos(), (Number)192.0);
            if (v10 == null) {
                return;
            }
            player = v10;
            shouldApproach = PlayerExt.isEntityInFovCone$default(PlayerExt.INSTANCE, (Player)player, (Entity)this, null, 2, null) == false;
            this.lookControl.setLookAt((Entity)player);
            if (shouldApproach && player.gameMode.isSurvival()) {
                targetPos = this.navigation.getTargetPos();
                v11 = playerMoved = targetPos == null || targetPos.distSqr((Vec3i)player.blockPosition()) > 9.0;
                if ((this.navigation.isDone() || this.navigation.isStuck() || playerMoved) && this.tickCount % 10 == 0) {
                    this.navigation.moveTo((Entity)player, 0.55);
                }
            } else if (!shouldApproach && this.navigation.getTargetPos() != null) {
                v12 = this.navigation.getTargetPos();
                Intrinsics.checkNotNull((Object)v12);
                v13 = movingTowardPlayer = v12.distSqr((Vec3i)player.blockPosition()) < 10.0;
                if (movingTowardPlayer) {
                    this.navigation.stop();
                }
            }
        }
        if (this.getTarget() != null) {
            v14 = this.getTarget();
            Intrinsics.checkNotNull((Object)v14);
            targetEntity = v14;
            v15 = targetEntity.mainSupportingBlockPos;
            Intrinsics.checkNotNullExpressionValue((Object)v15, (String)"mainSupportingBlockPos");
            v16 = (BlockPos)OptionalsKt.getOrNull((Optional)v15);
            if (v16 == null) {
                v16 = targetEntity.blockPosition();
            }
            v17 = targetReachableByBreaking = (heightDiff = (supportingPos = v16).getY() - this.blockPosition().getY()) <= 2;
            if ((this.navigation.isDone() || this.navigation.isStuck()) && !TBSConfigs.INSTANCE.getServer().getDisableBlockBreaking() && this.getTransformed() && targetReachableByBreaking) {
                facing = this.getDirection();
                $this$baseTick_u24lambda_u242 = var10_17 = CollectionsKt.createListBuilder();
                $i$a$-buildList-CurvedEntity$baseTick$candidates$1 = false;
                for (dy = 0; dy < 3; ++dy) {
                    for (side = -1; side < 2; ++side) {
                        v18 = facing;
                        switch (v18 == null ? -1 : WhenMappings.$EnumSwitchMapping$0[v18.ordinal()]) {
                            case 1: 
                            case 2: {
                                v19 = new BlockPos(side, dy, 0);
                                break;
                            }
                            case 3: 
                            case 4: {
                                v19 = new BlockPos(0, dy, side);
                                break;
                            }
                            default: {
                                v19 = new BlockPos(side, dy, 0);
                            }
                        }
                        sideOffset = v19;
                        $this$baseTick_u24lambda_u242.add(this.blockPosition().relative(facing, 1).offset((Vec3i)sideOffset));
                    }
                }
                candidates = CollectionsKt.build((List)var10_17);
                $this$forEach$iv = candidates;
                $i$f$forEach = false;
                for (T element$iv : $this$forEach$iv) {
                    pos = (BlockPos)element$iv;
                    $i$a$-forEach-CurvedEntity$baseTick$3 = false;
                    state = ((ServerLevel)level).getBlockState(pos);
                    if (state.isAir() || !state.getFluidState().isEmpty()) continue;
                    ((ServerLevel)level).destroyBlock(pos, true, (Entity)this);
                }
            }
        }
        if (this.blockBreakAlertTicks > 0) {
            var4_7 = this.blockBreakAlertTicks;
            this.blockBreakAlertTicks = var4_7 + -1;
        } else if (this.blockBreakAlertStage > 0) {
            this.blockBreakAlertStage = 0;
            this.blockBreakAlertTarget = null;
        }
        this.entityData.set(CurvedEntity.DESPAWN_TIMER, (Object)(this.getDespawnTimer() + 1));
        if (this.getDespawnTimer() + 1 > 6200) {
            this.discard();
            ((ServerLevel)level).sendParticles((ParticleOptions)TBSParticleTypes.PARTICLE_OF_CURVED.get(), this.getX(), this.getY(), this.getZ(), 55, 3.0, 3.0, 3.0, 0.0);
        }
        if (this.isAggressive()) {
            if (this.getTransformTimer() > 0) {
                var4_8 = this.getTransformTimer();
                this.setTransformTimer(var4_8 + -1);
            } else {
                this.setInvulnerable(false);
                this.setTransformed(true);
            }
        }
    }

    public void registerControllers(@NotNull AnimatableManager.ControllerRegistrar reg) {
        Intrinsics.checkNotNullParameter((Object)reg, (String)"reg");
        reg.add(new AnimationController((GeoAnimatable)this, "curved", 0, arg_0 -> CurvedEntity.registerControllers$lambda$0(this, arg_0)));
        reg.add(new AnimationController((GeoAnimatable)this, "curved_death", 0, arg_0 -> CurvedEntity.registerControllers$lambda$1(this, arg_0)));
        reg.add(new AnimationController((GeoAnimatable)this, "curved_swing", 0, CurvedEntity::registerControllers$lambda$2).triggerableAnim("swing", RawAnimation.begin().thenPlay("swing")));
        reg.add(new AnimationController((GeoAnimatable)this, "curved_hit", 0, CurvedEntity::registerControllers$lambda$3).triggerableAnim("hit", RawAnimation.begin().thenPlay("hurt")));
    }

    protected void tickDeath() {
        int n = this.deathTime;
        this.deathTime = n + 1;
        if (this.deathTime >= 122) {
            this.getLevel().broadcastEntityEvent((Entity)this, (byte)60);
            this.remove(Entity.RemovalReason.KILLED);
        }
    }

    private static final Object tick$lambda$0(CurvedEntity this$0) {
        if (!ClientVariables.INSTANCE.has(32L)) {
            LocalPlayer localPlayer = ClientDSLKt.getMC().player;
            if (localPlayer == null) {
                return false;
            }
            LocalPlayer player = localPlayer;
            if (PlayerExt.INSTANCE.isEntityInFovCone((Player)player, (Entity)this$0, Double.valueOf(((Number)ClientDSLKt.getMC().options.fov().get()).intValue()))) {
                ClientVariables.INSTANCE.set(32L);
            }
        }
        if (this$0.stepCooldown > 0) {
            int player = this$0.stepCooldown;
            this$0.stepCooldown = player + -1;
        }
        if (this$0.onGround() && this$0.getDeltaMovement().horizontalDistanceSqr() > 0.01 && this$0.stepCooldown <= 0 && this$0.getTransformed()) {
            FancySoundInstance fancySoundInstance;
            this$0.stepCooldown = 5;
            SoundEvent soundtype = (SoundEvent)CollectionsKt.random((Collection)this$0.stepSounds, (Random)((Random)Random.Default));
            float f = ((Number)CollectionsKt.random((Collection)this$0.pitches, (Random)((Random)Random.Default))).floatValue();
            RandomSource randomSource = this$0.level().random;
            Intrinsics.checkNotNullExpressionValue((Object)randomSource, (String)"random");
            FancySoundInstance $this$tick_u24lambda_u240_u240 = fancySoundInstance = new FancySoundInstance(soundtype, SoundSource.HOSTILE, 1.75f, f, false, randomSource, this$0.getX(), this$0.getY(), this$0.getZ());
            boolean bl = false;
            $this$tick_u24lambda_u240_u240.addEffect((AudioEffect)ReverbPreset.create$default((ReverbPreset)ReverbPresets.EFX_REVERB_PRESET_CAVE, null, (int)1, null));
            FancySoundInstance instance = fancySoundInstance;
            ClientDSLKt.getMC().getSoundManager().play((SoundInstance)instance);
        }
        return Unit.INSTANCE;
    }

    private static final Unit die$lambda$1(CurvedEntity this$0) {
        ChatUtil.chat$default((LevelAccessor)((LevelAccessor)this$0.getLevel()), (Component)((Component)TBSLang.INSTANCE.getCURVED_LEAVE()), (boolean)false, (int)2, null);
        return Unit.INSTANCE;
    }

    private static final Unit baseTick$lambda$1(CurvedEntity this$0) {
        FancyEntitySoundInstance fancyEntitySoundInstance;
        SoundEvent soundEvent = (SoundEvent)TBSSounds.CURVED_TRANSFORM.invoke();
        Entity entity = (Entity)this$0;
        RandomSource randomSource = this$0.level().random;
        Intrinsics.checkNotNullExpressionValue((Object)randomSource, (String)"random");
        FancyEntitySoundInstance $this$baseTick_u24lambda_u241_u240 = fancyEntitySoundInstance = new FancyEntitySoundInstance(soundEvent, SoundSource.HOSTILE, 0.6f, 1.0f, entity, false, randomSource);
        boolean bl = false;
        $this$baseTick_u24lambda_u241_u240.addEffect((AudioEffect)ReverbPreset.create$default((ReverbPreset)ReverbPresets.EFX_REVERB_PRESET_CAVE, null, (int)1, null));
        FancyEntitySoundInstance instance = fancyEntitySoundInstance;
        ClientDSLKt.getMC().getSoundManager().play((SoundInstance)instance);
        return Unit.INSTANCE;
    }

    private static final PlayState registerControllers$lambda$0(CurvedEntity this$0, AnimationState it) {
        AnimationController ctrl = it.getController();
        if (this$0.isDeadOrDying()) {
            return PlayState.STOP;
        }
        boolean moving = this$0.getDeltaMovement().horizontalDistanceSqr() > 1.0E-6;
        if (!this$0.getTransformed() && this$0.getTransformTimer() < 100) {
            Entity entity = (Entity)this$0;
            Intrinsics.checkNotNull((Object)ctrl);
            GeckoUtil.hold((Entity)entity, (AnimationController)ctrl, (String)"transform");
        } else if (this$0.getTransformed()) {
            AnimationProcessor.QueuedAnimation queuedAnimation = ctrl.getCurrentAnimation();
            if (Intrinsics.areEqual((Object)(queuedAnimation != null && (queuedAnimation = queuedAnimation.animation()) != null ? queuedAnimation.name() : null), (Object)"transform")) {
                ctrl.forceAnimationReset();
            }
            if (moving) {
                if (this$0.isVisuallySwimming() && !this$0.getLevel().getBlockState(this$0.getBlockPos().above()).isAir()) {
                    Entity entity = (Entity)this$0;
                    Intrinsics.checkNotNull((Object)ctrl);
                    GeckoUtil.loop((Entity)entity, (AnimationController)ctrl, (String)"swimmy swammy");
                } else {
                    Entity entity = (Entity)this$0;
                    Intrinsics.checkNotNull((Object)ctrl);
                    GeckoUtil.loop((Entity)entity, (AnimationController)ctrl, (String)"chase");
                }
            } else {
                Entity entity = (Entity)this$0;
                Intrinsics.checkNotNull((Object)ctrl);
                GeckoUtil.loop((Entity)entity, (AnimationController)ctrl, (String)"curved_idle");
            }
        } else if (moving) {
            Entity entity = (Entity)this$0;
            Intrinsics.checkNotNull((Object)ctrl);
            GeckoUtil.loop((Entity)entity, (AnimationController)ctrl, (String)"normal_walk");
        } else {
            Entity entity = (Entity)this$0;
            Intrinsics.checkNotNull((Object)ctrl);
            GeckoUtil.loop((Entity)entity, (AnimationController)ctrl, (String)"normal_idle");
        }
        return PlayState.CONTINUE;
    }

    private static final PlayState registerControllers$lambda$1(CurvedEntity this$0, AnimationState it) {
        AnimationController ctrl = it.getController();
        if (!this$0.isDeadOrDying()) {
            return PlayState.STOP;
        }
        Entity entity = (Entity)this$0;
        Intrinsics.checkNotNull((Object)ctrl);
        GeckoUtil.hold((Entity)entity, (AnimationController)ctrl, (String)"death");
        return PlayState.CONTINUE;
    }

    private static final PlayState registerControllers$lambda$2(AnimationState it) {
        return PlayState.CONTINUE;
    }

    private static final PlayState registerControllers$lambda$3(AnimationState it) {
        return PlayState.CONTINUE;
    }

    static {
        KProperty[] kPropertyArray = new KProperty[]{Reflection.property1((PropertyReference1)((PropertyReference1)new PropertyReference1Impl(CurvedEntity.class, "despawnTimer", "getDespawnTimer()I", 0))), Reflection.mutableProperty1((MutablePropertyReference1)((MutablePropertyReference1)new MutablePropertyReference1Impl(CurvedEntity.class, "transformTimer", "getTransformTimer()I", 0))), Reflection.mutableProperty1((MutablePropertyReference1)((MutablePropertyReference1)new MutablePropertyReference1Impl(CurvedEntity.class, "transformed", "getTransformed()Z", 0))), Reflection.mutableProperty1((MutablePropertyReference1)((MutablePropertyReference1)new MutablePropertyReference1Impl(CurvedEntity.class, "isDead", "isDead()Z", 0)))};
        $$delegatedProperties = kPropertyArray;
        Companion = new Companion(null);
        EntityDataAccessor entityDataAccessor = SynchedEntityData.defineId(CurvedEntity.class, (EntityDataSerializer)EntityDataSerializers.INT);
        Intrinsics.checkNotNullExpressionValue((Object)entityDataAccessor, (String)"defineId(...)");
        DESPAWN_TIMER = entityDataAccessor;
        EntityDataAccessor entityDataAccessor2 = SynchedEntityData.defineId(CurvedEntity.class, (EntityDataSerializer)EntityDataSerializers.INT);
        Intrinsics.checkNotNullExpressionValue((Object)entityDataAccessor2, (String)"defineId(...)");
        TRANSFORMING_TIMER = entityDataAccessor2;
        EntityDataAccessor entityDataAccessor3 = SynchedEntityData.defineId(CurvedEntity.class, (EntityDataSerializer)EntityDataSerializers.BOOLEAN);
        Intrinsics.checkNotNullExpressionValue((Object)entityDataAccessor3, (String)"defineId(...)");
        TRANSFORMED = entityDataAccessor3;
        EntityDataAccessor entityDataAccessor4 = SynchedEntityData.defineId(CurvedEntity.class, (EntityDataSerializer)EntityDataSerializers.BOOLEAN);
        Intrinsics.checkNotNullExpressionValue((Object)entityDataAccessor4, (String)"defineId(...)");
        IS_DEAD = entityDataAccessor4;
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0010\u001a\u00020\u0011R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\bR\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\f0\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\b\u00a8\u0006\u0012"}, d2={"Lnet/thebrokenscript/entity/players/CurvedEntity$Companion;", "", "<init>", "()V", "DESPAWN_TIMER", "Lnet/minecraft/network/syncher/EntityDataAccessor;", "", "getDESPAWN_TIMER", "()Lnet/minecraft/network/syncher/EntityDataAccessor;", "TRANSFORMING_TIMER", "getTRANSFORMING_TIMER", "TRANSFORMED", "", "getTRANSFORMED", "IS_DEAD", "getIS_DEAD", "createAttributes", "Lnet/minecraft/world/entity/ai/attributes/AttributeSupplier$Builder;", "thebrokenscript-common"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final EntityDataAccessor<Integer> getDESPAWN_TIMER() {
            return DESPAWN_TIMER;
        }

        @NotNull
        public final EntityDataAccessor<Integer> getTRANSFORMING_TIMER() {
            return TRANSFORMING_TIMER;
        }

        @NotNull
        public final EntityDataAccessor<Boolean> getTRANSFORMED() {
            return TRANSFORMED;
        }

        @NotNull
        public final EntityDataAccessor<Boolean> getIS_DEAD() {
            return IS_DEAD;
        }

        @NotNull
        public final AttributeSupplier.Builder createAttributes() {
            AttributeSupplier.Builder builder = Monster.createMobAttributes().add(Attributes.MOVEMENT_SPEED, 0.35).add(Attributes.MAX_HEALTH, 125.0).add(Attributes.ARMOR, 5.0).add(Attributes.ATTACK_DAMAGE, 7.0).add(Attributes.FOLLOW_RANGE, 916.0).add(Attributes.KNOCKBACK_RESISTANCE, 5.0).add(Attributes.ATTACK_KNOCKBACK, 1.0).add(Attributes.STEP_HEIGHT, 2.6);
            Intrinsics.checkNotNullExpressionValue((Object)builder, (String)"add(...)");
            return builder;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2={"Lnet/thebrokenscript/entity/players/CurvedEntity$CurvedMoveControl;", "Lnet/minecraft/world/entity/ai/control/MoveControl;", "curvedEntity", "Lnet/thebrokenscript/entity/players/CurvedEntity;", "<init>", "(Lnet/thebrokenscript/entity/players/CurvedEntity;)V", "tick", "", "thebrokenscript-common"})
    private static final class CurvedMoveControl
    extends MoveControl {
        @NotNull
        private final CurvedEntity curvedEntity;

        public CurvedMoveControl(@NotNull CurvedEntity curvedEntity) {
            Intrinsics.checkNotNullParameter((Object)((Object)curvedEntity), (String)"curvedEntity");
            super((Mob)curvedEntity);
            this.curvedEntity = curvedEntity;
        }

        public void tick() {
            if (this.curvedEntity.isVisuallySwimming()) {
                this.curvedEntity.navigation.stop();
                this.operation = MoveControl.Operation.WAIT;
                double d0 = this.wantedX - this.curvedEntity.getX();
                double d1 = this.wantedZ - this.curvedEntity.getZ();
                double d2 = this.wantedY - this.curvedEntity.getY();
                double dist = d0 * d0 + d2 * d2 + d1 * d1;
                if (dist < 2.5000003E-7) {
                    this.curvedEntity.zza = 0.0f;
                    return;
                }
                float f = (float)(Mth.atan2((double)d1, (double)d0) * 57.29577951308232) - 90.0f;
                this.curvedEntity.setYRot(this.rotlerp(this.curvedEntity.getYRot(), f, 5.0f));
                this.curvedEntity.yBodyRot = this.curvedEntity.getYRot();
                float angleDiff = Mth.abs((float)Mth.wrapDegrees((float)(this.curvedEntity.getYRot() - f)));
                float alignmentFactor = RangesKt.coerceIn((float)(1.0f - angleDiff / 90.0f), (float)0.0f, (float)1.0f);
                this.curvedEntity.setSpeed((float)(this.speedModifier * this.curvedEntity.getAttributeValue(Attributes.MOVEMENT_SPEED)));
                this.curvedEntity.zza = alignmentFactor;
            } else {
                super.tick();
            }
        }
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016J\u001e\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J.\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016JB\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000f2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0010\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u001dH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001f"}, d2={"Lnet/thebrokenscript/entity/players/CurvedEntity$CurvedVibrationUser;", "Lnet/minecraft/world/level/gameevent/vibrations/VibrationSystem$User;", "<init>", "(Lnet/thebrokenscript/entity/players/CurvedEntity;)V", "positionSource", "Lnet/minecraft/world/level/gameevent/EntityPositionSource;", "getListenerRadius", "", "getPositionSource", "getListenableEvents", "Lnet/minecraft/tags/TagKey;", "Lnet/minecraft/world/level/gameevent/GameEvent;", "isValidVibration", "", "gameEvent", "Lnet/minecraft/core/Holder;", "context", "Lnet/minecraft/world/level/gameevent/GameEvent$Context;", "canReceiveVibration", "level", "Lnet/minecraft/server/level/ServerLevel;", "pos", "Lnet/minecraft/core/BlockPos;", "onReceiveVibration", "", "sourceEntity", "Lnet/minecraft/world/entity/Entity;", "projectileOwner", "distance", "", "calculateTravelTimeInTicks", "thebrokenscript-common"})
    public final class CurvedVibrationUser
    implements VibrationSystem.User {
        @NotNull
        private final EntityPositionSource positionSource;

        public CurvedVibrationUser() {
            this.positionSource = new EntityPositionSource((Entity)CurvedEntity.this, CurvedEntity.this.getEyeHeight());
        }

        public int getListenerRadius() {
            return 42;
        }

        @NotNull
        public EntityPositionSource getPositionSource() {
            return this.positionSource;
        }

        @NotNull
        public TagKey<GameEvent> getListenableEvents() {
            TagKey tagKey = GameEventTags.VIBRATIONS;
            Intrinsics.checkNotNullExpressionValue((Object)tagKey, (String)"VIBRATIONS");
            return tagKey;
        }

        public boolean isValidVibration(@NotNull Holder<GameEvent> gameEvent, @NotNull GameEvent.Context context) {
            Entity entity;
            block6: {
                block5: {
                    Intrinsics.checkNotNullParameter(gameEvent, (String)"gameEvent");
                    Intrinsics.checkNotNullParameter((Object)context, (String)"context");
                    boolean isBlockDestroy = Intrinsics.areEqual(gameEvent.unwrapKey().orElse(null), (Object)GameEvent.BLOCK_DESTROY.key());
                    if (!isBlockDestroy) {
                        return false;
                    }
                    if (CurvedEntity.this.isDead() || !CurvedEntity.this.getTransformed()) {
                        return false;
                    }
                    entity = context.sourceEntity();
                    if (!(entity instanceof Player)) break block5;
                    GameType gameType = PlayerUtil.getGameMode((Player)((Player)entity));
                    Intrinsics.checkNotNull((Object)gameType);
                    if (gameType.isSurvival()) break block6;
                }
                return false;
            }
            CurvedEntity.this.onHeardBlockBreak((Player)entity);
            return false;
        }

        public boolean canReceiveVibration(@NotNull ServerLevel level, @NotNull BlockPos pos, @NotNull Holder<GameEvent> gameEvent, @NotNull GameEvent.Context context) {
            Intrinsics.checkNotNullParameter((Object)level, (String)"level");
            Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
            Intrinsics.checkNotNullParameter(gameEvent, (String)"gameEvent");
            Intrinsics.checkNotNullParameter((Object)context, (String)"context");
            return false;
        }

        public void onReceiveVibration(@NotNull ServerLevel level, @NotNull BlockPos pos, @NotNull Holder<GameEvent> gameEvent, @Nullable Entity sourceEntity, @Nullable Entity projectileOwner, float distance) {
            Intrinsics.checkNotNullParameter((Object)level, (String)"level");
            Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
            Intrinsics.checkNotNullParameter(gameEvent, (String)"gameEvent");
        }

        public int calculateTravelTimeInTicks(float distance) {
            return 0;
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
                nArray[Direction.EAST.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[Direction.WEST.ordinal()] = 4;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            $EnumSwitchMapping$0 = nArray;
        }
    }
}

