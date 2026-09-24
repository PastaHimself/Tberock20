/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Result
 *  kotlin.ResultKt
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.enums.EnumEntries
 *  kotlin.enums.EnumEntriesKt
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.MutablePropertyReference1
 *  kotlin.jvm.internal.MutablePropertyReference1Impl
 *  kotlin.jvm.internal.Reflection
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.reflect.KProperty
 *  net.minecraft.client.player.LocalPlayer
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Position
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.network.syncher.EntityDataAccessor
 *  net.minecraft.network.syncher.EntityDataSerializer
 *  net.minecraft.network.syncher.EntityDataSerializers
 *  net.minecraft.network.syncher.SynchedEntityData
 *  net.minecraft.network.syncher.SynchedEntityData$Builder
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.sounds.SoundEvent
 *  net.minecraft.sounds.SoundSource
 *  net.minecraft.tags.DamageTypeTags
 *  net.minecraft.util.Mth
 *  net.minecraft.world.DifficultyInstance
 *  net.minecraft.world.damagesource.DamageSource
 *  net.minecraft.world.damagesource.DamageTypes
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.Mob
 *  net.minecraft.world.entity.MobSpawnType
 *  net.minecraft.world.entity.SpawnGroupData
 *  net.minecraft.world.entity.ai.attributes.Attributes
 *  net.minecraft.world.entity.ai.control.MoveControl
 *  net.minecraft.world.entity.ai.control.MoveControl$Operation
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.item.enchantment.EnchantmentHelper
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.level.ServerLevelAccessor
 *  net.minecraft.world.phys.AABB
 *  net.minecraft.world.phys.Vec3
 *  net.neoforged.api.distmarker.Dist
 *  net.neoforged.api.distmarker.OnlyIn
 *  net.thebrokenscript.brokencore.api.dsl.ClientDSLKt
 *  net.thebrokenscript.brokencore.api.dsl.EntityDataDelegate
 *  net.thebrokenscript.brokencore.api.dsl.EntityFinder
 *  net.thebrokenscript.brokencore.api.dsl.EntityUtil
 *  net.thebrokenscript.brokencore.api.dsl.GeckoUtil
 *  net.thebrokenscript.brokencore.api.dsl.PositionUtil
 *  net.thebrokenscript.brokencore.api.dsl.SideUtil
 *  net.thebrokenscript.brokencore.api.entity.FinalizedSpawn
 *  net.thebrokenscript.brokencore.api.entity.base.BaseMonster
 *  net.thebrokenscript.brokencore.api.entity.multipart.MultipartEntity
 *  net.thebrokenscript.brokencore.api.entity.multipart.MultipartEntityPart
 *  net.thebrokenscript.brokencore.api.entity.multipart.MultipartSubEntity
 *  net.thebrokenscript.brokencore.api.platform.CancelProxy
 *  net.thebrokenscript.brokencore.api.sound.AudioEffects
 *  net.thebrokenscript.brokencore.api.sound.FancyAudio
 *  net.thebrokenscript.brokencore.api.sound.FancyEntitySoundInstance
 *  net.thebrokenscript.brokencore.api.sound.fx.ReverbEffect
 *  net.thebrokenscript.brokencore.api.sound.fx.ReverbPreset
 *  net.thebrokenscript.brokencore.api.sound.fx.ReverbPresets
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  software.bernie.geckolib.animatable.GeoAnimatable
 *  software.bernie.geckolib.animation.AnimatableManager$ControllerRegistrar
 *  software.bernie.geckolib.animation.AnimationController
 *  software.bernie.geckolib.animation.AnimationState
 *  software.bernie.geckolib.animation.PlayState
 */
package net.thebrokenscript.api.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KProperty;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Position;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializer;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.util.Mth;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.thebrokenscript.TheBrokenScript;
import net.thebrokenscript.api.ext.PlayerExt;
import net.thebrokenscript.boss.jimmy.JimArena;
import net.thebrokenscript.brokencore.api.dsl.ClientDSLKt;
import net.thebrokenscript.brokencore.api.dsl.EntityDataDelegate;
import net.thebrokenscript.brokencore.api.dsl.EntityFinder;
import net.thebrokenscript.brokencore.api.dsl.EntityUtil;
import net.thebrokenscript.brokencore.api.dsl.GeckoUtil;
import net.thebrokenscript.brokencore.api.dsl.PositionUtil;
import net.thebrokenscript.brokencore.api.dsl.SideUtil;
import net.thebrokenscript.brokencore.api.entity.FinalizedSpawn;
import net.thebrokenscript.brokencore.api.entity.base.BaseMonster;
import net.thebrokenscript.brokencore.api.entity.multipart.MultipartEntity;
import net.thebrokenscript.brokencore.api.entity.multipart.MultipartEntityPart;
import net.thebrokenscript.brokencore.api.entity.multipart.MultipartSubEntity;
import net.thebrokenscript.brokencore.api.platform.CancelProxy;
import net.thebrokenscript.brokencore.api.sound.AudioEffects;
import net.thebrokenscript.brokencore.api.sound.FancyAudio;
import net.thebrokenscript.brokencore.api.sound.FancyEntitySoundInstance;
import net.thebrokenscript.brokencore.api.sound.fx.ReverbEffect;
import net.thebrokenscript.brokencore.api.sound.fx.ReverbPreset;
import net.thebrokenscript.brokencore.api.sound.fx.ReverbPresets;
import net.thebrokenscript.client.TBSClient;
import net.thebrokenscript.client.data.ClientVariables;
import net.thebrokenscript.entity.fractured.FracturedPartEntity;
import net.thebrokenscript.entity.fractured.FracturedSubEntity;
import net.thebrokenscript.entity.fractured.Leg;
import net.thebrokenscript.registry.TBSBlocks;
import net.thebrokenscript.registry.TBSDamageTypes;
import net.thebrokenscript.registry.TBSSounds;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.animation.AnimationController;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.animation.PlayState;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u00e2\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0004\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u0000 \u009f\u00012\u00020\u00012\u00020\u0002:\u0006\u009d\u0001\u009e\u0001\u009f\u0001B\u001f\u0012\u000e\u0010\u0003\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00000\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0004\b\u0007\u0010\bJ\b\u0010\t\u001a\u00020\nH\u0016J\u001e\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u00020K2\u0006\u0010L\u001a\u00020\u001f2\u0006\u0010M\u001a\u00020NJ&\u0010O\u001a\u00020\n2\u0006\u0010P\u001a\u00020Q2\u0006\u0010J\u001a\u00020K2\u0006\u0010L\u001a\u00020\u001f2\u0006\u0010M\u001a\u00020NJ\u0006\u0010R\u001a\u00020IJ(\u0010S\u001a\u00020)2\u0006\u0010T\u001a\u00020U2\u0006\u0010V\u001a\u00020W2\u0006\u0010X\u001a\u00020W2\u0006\u0010Y\u001a\u00020ZH\u0016J\u001e\u0010[\u001a\u00020\\2\u0006\u0010T\u001a\u00020U2\u0006\u0010V\u001a\u00020W2\u0006\u0010X\u001a\u00020WJ\b\u0010]\u001a\u00020^H\u0016J\u0010\u0010_\u001a\u00020\n2\u0006\u0010`\u001a\u00020\u001fH\u0016J\u0010\u0010a\u001a\u00020\n2\u0006\u0010b\u001a\u00020\u001fH\u0016J\u0018\u0010c\u001a\u00020\n2\u0006\u0010d\u001a\u00020N2\u0006\u0010e\u001a\u00020KH\u0016J\b\u0010i\u001a\u00020IH\u0016J\u001e\u0010j\u001a\u0004\u0018\u00010Z2\b\b\u0002\u0010k\u001a\u00020h2\b\b\u0002\u0010l\u001a\u00020hH\u0002J\t\u0010\u0084\u0001\u001a\u00020IH\u0016J\u0007\u0010\u0085\u0001\u001a\u00020IJ\u0013\u0010\u0086\u0001\u001a\u00020I2\b\u0010\u0087\u0001\u001a\u00030\u0088\u0001H\u0016J?\u0010\u0089\u0001\u001a\u0005\u0018\u00010\u008a\u00012\u0007\u0010\u0005\u001a\u00030\u008b\u00012\b\u0010\u008c\u0001\u001a\u00030\u008d\u00012\b\u0010\u008e\u0001\u001a\u00030\u008f\u00012\n\u0010\u0090\u0001\u001a\u0005\u0018\u00010\u008a\u00012\b\u0010\u0091\u0001\u001a\u00030\u0092\u0001H\u0016J\u0013\u0010\u0093\u0001\u001a\u00020I2\b\u0010\u0094\u0001\u001a\u00030\u0095\u0001H\u0016J\u0013\u0010\u0096\u0001\u001a\u00020I2\b\u0010\u0094\u0001\u001a\u00030\u0095\u0001H\u0016J\u0013\u0010\u0097\u0001\u001a\u00020I2\b\u0010\u0098\u0001\u001a\u00030\u0099\u0001H\u0014J\t\u0010\u009c\u0001\u001a\u00020IH\u0003R$\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R+\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\n8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0017\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00000\u001b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001e\u001a\u00020\u001fX\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0014\u0010\"\u001a\u00020\u001fX\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010!R\u001d\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00000\u001b\u00a2\u0006\u000e\n\u0000\u0012\u0004\b%\u0010&\u001a\u0004\b'\u0010\u001dR\u0011\u0010(\u001a\u00020)\u00a2\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0011\u0010,\u001a\u00020)\u00a2\u0006\b\n\u0000\u001a\u0004\b-\u0010+R\u0011\u0010.\u001a\u00020)\u00a2\u0006\b\n\u0000\u001a\u0004\b/\u0010+R\u0011\u00100\u001a\u00020)\u00a2\u0006\b\n\u0000\u001a\u0004\b1\u0010+R\u0011\u00102\u001a\u000203\u00a2\u0006\b\n\u0000\u001a\u0004\b4\u00105R\u0011\u00106\u001a\u000203\u00a2\u0006\b\n\u0000\u001a\u0004\b7\u00105R\u0011\u00108\u001a\u000203\u00a2\u0006\b\n\u0000\u001a\u0004\b9\u00105R\u0011\u0010:\u001a\u000203\u00a2\u0006\b\n\u0000\u001a\u0004\b;\u00105R\u0019\u0010<\u001a\b\u0012\u0004\u0012\u0002030=\u00a2\u0006\n\n\u0002\u0010@\u001a\u0004\b>\u0010?R \u0010A\u001a\b\u0012\u0004\u0012\u00020C0BX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR\u0010\u0010f\u001a\u0004\u0018\u00010ZX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010g\u001a\u00020hX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010m\u001a\u00020hX\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\bn\u0010oR\u0014\u0010p\u001a\u00020hX\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\bq\u0010oR\u0014\u0010r\u001a\u00020hX\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\bs\u0010oR\u001a\u0010t\u001a\u00020hX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bu\u0010o\"\u0004\bv\u0010wR\u001a\u0010x\u001a\u00020hX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\by\u0010o\"\u0004\bz\u0010wR\u001a\u0010{\u001a\u00020hX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b|\u0010o\"\u0004\b}\u0010wR\u001b\u0010~\u001a\u00020hX\u0086\u000e\u00a2\u0006\u000f\n\u0000\u001a\u0004\b\u007f\u0010o\"\u0005\b\u0080\u0001\u0010wR\u001d\u0010\u0081\u0001\u001a\u00020hX\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u0082\u0001\u0010o\"\u0005\b\u0083\u0001\u0010wR\u0016\u0010\u009a\u0001\u001a\u0005\u0018\u00010\u009b\u00018\u0002@\u0002X\u0083\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u00a0\u0001"}, d2={"Lnet/thebrokenscript/api/entity/BaseFracturedEntity;", "Lnet/thebrokenscript/brokencore/api/entity/multipart/MultipartEntity;", "Lnet/thebrokenscript/brokencore/api/entity/FinalizedSpawn;", "type", "Lnet/minecraft/world/entity/EntityType;", "level", "Lnet/minecraft/world/level/Level;", "<init>", "(Lnet/minecraft/world/entity/EntityType;Lnet/minecraft/world/level/Level;)V", "isPickable", "", "thingy", "Lnet/thebrokenscript/api/entity/BaseFracturedEntity$JimmyStates;", "currentState", "getCurrentState", "()Lnet/thebrokenscript/api/entity/BaseFracturedEntity$JimmyStates;", "setCurrentState", "(Lnet/thebrokenscript/api/entity/BaseFracturedEntity$JimmyStates;)V", "<set-?>", "gaveBlock", "getGaveBlock", "()Z", "setGaveBlock", "(Z)V", "gaveBlock$delegate", "Lnet/thebrokenscript/brokencore/api/dsl/EntityDataDelegate;", "head", "Lnet/thebrokenscript/brokencore/api/entity/multipart/MultipartEntityPart;", "getHead", "()Lnet/thebrokenscript/brokencore/api/entity/multipart/MultipartEntityPart;", "legHeight", "", "getLegHeight", "()D", "legWidth", "getLegWidth", "chest", "getChest$annotations", "()V", "getChest", "frontLeftEnt", "Lnet/thebrokenscript/entity/fractured/FracturedSubEntity;", "getFrontLeftEnt", "()Lnet/thebrokenscript/entity/fractured/FracturedSubEntity;", "frontRightEnt", "getFrontRightEnt", "backLeftEnt", "getBackLeftEnt", "backRightEnt", "getBackRightEnt", "frontLeft", "Lnet/thebrokenscript/entity/fractured/Leg;", "getFrontLeft", "()Lnet/thebrokenscript/entity/fractured/Leg;", "frontRight", "getFrontRight", "backLeft", "getBackLeft", "backRight", "getBackRight", "legs", "", "getLegs", "()[Lnet/thebrokenscript/entity/fractured/Leg;", "[Lnet/thebrokenscript/entity/fractured/Leg;", "entityList", "", "Lnet/minecraft/world/entity/LivingEntity;", "getEntityList", "()Ljava/util/List;", "setEntityList", "(Ljava/util/List;)V", "hurtMultipleTargets", "", "damage", "", "knockbackStrength", "damageSource", "Lnet/minecraft/world/damagesource/DamageSource;", "doHurtTargetTheSecond", "entity", "Lnet/minecraft/world/entity/Entity;", "swap", "subEntity", "name", "", "width", "", "height", "defaultOffset", "Lnet/minecraft/world/phys/Vec3;", "subPart", "Lnet/thebrokenscript/entity/fractured/FracturedPartEntity;", "getBoundingBoxForCulling", "Lnet/minecraft/world/phys/AABB;", "shouldRenderAtSqrDistance", "dist", "removeWhenFarAway", "distanceToClosestPlayer", "hurt", "source", "amount", "lastSafeGroundPos", "airborneTicks", "", "baseTick", "findSurfaceAhead", "maxDist", "step", "riseAnimDuration", "getRiseAnimDuration", "()I", "digAnimDuration", "getDigAnimDuration", "defeatedAnimDuration", "getDefeatedAnimDuration", "riseTick", "getRiseTick", "setRiseTick", "(I)V", "digTick", "getDigTick", "setDigTick", "despawnTick", "getDespawnTick", "setDespawnTick", "defeatedTick", "getDefeatedTick", "setDefeatedTick", "switchingTick", "getSwitchingTick", "setSwitchingTick", "tick", "tickLegs", "registerControllers", "reg", "Lsoftware/bernie/geckolib/animation/AnimatableManager$ControllerRegistrar;", "onFinalizeSpawn", "Lnet/minecraft/world/entity/SpawnGroupData;", "Lnet/minecraft/world/level/ServerLevelAccessor;", "difficulty", "Lnet/minecraft/world/DifficultyInstance;", "spawnType", "Lnet/minecraft/world/entity/MobSpawnType;", "spawnData", "event", "Lnet/thebrokenscript/brokencore/api/platform/CancelProxy;", "addAdditionalSaveData", "compound", "Lnet/minecraft/nbt/CompoundTag;", "readAdditionalSaveData", "defineSynchedData", "builder", "Lnet/minecraft/network/syncher/SynchedEntityData$Builder;", "sfx", "Lnet/thebrokenscript/brokencore/api/sound/FancyEntitySoundInstance;", "playSpawnSounds", "RoamMoveControl", "JimmyStates", "Companion", "thebrokenscript-common"})
@SourceDebugExtension(value={"SMAP\nBaseFracturedEntity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BaseFracturedEntity.kt\nnet/thebrokenscript/api/entity/BaseFracturedEntity\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,483:1\n1#2:484\n1869#3,2:485\n774#3:489\n865#3,2:490\n13805#4,2:487\n*S KotlinDebug\n*F\n+ 1 BaseFracturedEntity.kt\nnet/thebrokenscript/api/entity/BaseFracturedEntity\n*L\n117#1:485,2\n275#1:489\n275#1:490,2\n356#1:487,2\n*E\n"})
public abstract class BaseFracturedEntity
extends MultipartEntity
implements FinalizedSpawn {
    @NotNull
    public static final Companion Companion;
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;
    @NotNull
    private final EntityDataDelegate gaveBlock$delegate;
    @NotNull
    private final MultipartEntityPart<BaseFracturedEntity> head;
    private final double legHeight;
    private final double legWidth;
    @NotNull
    private final MultipartEntityPart<BaseFracturedEntity> chest;
    @NotNull
    private final FracturedSubEntity frontLeftEnt;
    @NotNull
    private final FracturedSubEntity frontRightEnt;
    @NotNull
    private final FracturedSubEntity backLeftEnt;
    @NotNull
    private final FracturedSubEntity backRightEnt;
    @NotNull
    private final Leg frontLeft;
    @NotNull
    private final Leg frontRight;
    @NotNull
    private final Leg backLeft;
    @NotNull
    private final Leg backRight;
    @NotNull
    private final Leg[] legs;
    @NotNull
    private volatile List<LivingEntity> entityList;
    @Nullable
    private Vec3 lastSafeGroundPos;
    private int airborneTicks;
    private final int riseAnimDuration;
    private final int digAnimDuration;
    private final int defeatedAnimDuration;
    private int riseTick;
    private int digTick;
    private int despawnTick;
    private int defeatedTick;
    private int switchingTick;
    @OnlyIn(value=Dist.CLIENT)
    @Nullable
    private FancyEntitySoundInstance sfx;
    public static final double LEG_DIST = 45.0;
    private static final EntityDataAccessor<String> STATE;
    private static final EntityDataAccessor<Boolean> GAVE_BLOCK;

    public BaseFracturedEntity(@NotNull EntityType<? extends BaseFracturedEntity> type, @NotNull Level level) {
        Intrinsics.checkNotNullParameter(type, (String)"type");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        super(type, level);
        this.setPersistenceRequired();
        EntityDataAccessor<Boolean> entityDataAccessor = GAVE_BLOCK;
        Intrinsics.checkNotNullExpressionValue(entityDataAccessor, (String)"GAVE_BLOCK");
        this.gaveBlock$delegate = this.entityData(entityDataAccessor);
        this.head = this.subPart("head", Float.valueOf(14.0f), Float.valueOf(14.0f)).moved(1.0, 88.0, 10.0);
        this.legHeight = 15.0;
        this.legWidth = 15.0;
        this.chest = this.subPart("chest", Float.valueOf(18.0f), Float.valueOf(18.0f)).moved(1.0, 68.0, 10.0);
        this.frontLeftEnt = this.subEntity("frontleft", this.legWidth, this.legHeight, new Vec3(40.0, 0.0, 50.0));
        this.frontRightEnt = this.subEntity("frontright", this.legWidth, this.legHeight, new Vec3(-40.0, 0.0, 50.0));
        this.backLeftEnt = this.subEntity("backleft", this.legWidth, this.legHeight, new Vec3(40.0, 0.0, -49.0));
        this.backRightEnt = this.subEntity("backright", this.legWidth, this.legHeight, new Vec3(-40.0, 0.0, -49.0));
        this.frontLeft = new Leg(this.frontLeftEnt, new Vec3(45.0, 0.0, 45.0), null, 4, null);
        this.frontRight = new Leg(this.frontRightEnt, new Vec3(-45.0, 0.0, 45.0), null, 4, null);
        this.backLeft = new Leg(this.backLeftEnt, new Vec3(45.0, 0.0, -45.0), null, 4, null);
        this.backRight = new Leg(this.backRightEnt, new Vec3(-45.0, 0.0, -45.0), null, 4, null);
        Leg[] legArray = new Leg[]{this.frontLeft, this.frontRight, this.backLeft, this.backRight};
        this.legs = legArray;
        this.entityList = new ArrayList();
        this.riseAnimDuration = 149;
        this.digAnimDuration = 103;
        this.defeatedAnimDuration = 552;
        this.riseTick = this.riseAnimDuration;
        this.digTick = this.digAnimDuration;
        this.despawnTick = this.digAnimDuration;
        this.defeatedTick = this.defeatedAnimDuration;
        this.switchingTick = this.digAnimDuration;
    }

    public boolean isPickable() {
        return false;
    }

    @NotNull
    public final JimmyStates getCurrentState() {
        Object object;
        Object object2 = this;
        try {
            BaseFracturedEntity $this$_get_currentState__u24lambda_u240 = object2;
            boolean bl = false;
            Object object3 = $this$_get_currentState__u24lambda_u240.entityData.get(STATE);
            Intrinsics.checkNotNullExpressionValue((Object)object3, (String)"get(...)");
            object = Result.constructor-impl((Object)((Object)JimmyStates.valueOf((String)object3)));
        }
        catch (Throwable throwable) {
            object = Result.constructor-impl((Object)ResultKt.createFailure((Throwable)throwable));
        }
        object2 = object;
        object = JimmyStates.NORMAL;
        return (JimmyStates)((Object)(Result.isFailure-impl((Object)object2) ? object : object2));
    }

    public final void setCurrentState(@NotNull JimmyStates thingy) {
        Intrinsics.checkNotNullParameter((Object)((Object)thingy), (String)"thingy");
        this.entityData.set(STATE, (Object)thingy.name());
    }

    public final boolean getGaveBlock() {
        Object object = this.gaveBlock$delegate.getValue((BaseMonster)this, $$delegatedProperties[0]);
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"getValue(...)");
        return (Boolean)object;
    }

    public final void setGaveBlock(boolean bl) {
        this.gaveBlock$delegate.setValue((BaseMonster)this, $$delegatedProperties[0], (Object)bl);
    }

    @NotNull
    public final MultipartEntityPart<BaseFracturedEntity> getHead() {
        return this.head;
    }

    public final double getLegHeight() {
        return this.legHeight;
    }

    public final double getLegWidth() {
        return this.legWidth;
    }

    @NotNull
    public final MultipartEntityPart<BaseFracturedEntity> getChest() {
        return this.chest;
    }

    public static /* synthetic */ void getChest$annotations() {
    }

    @NotNull
    public final FracturedSubEntity getFrontLeftEnt() {
        return this.frontLeftEnt;
    }

    @NotNull
    public final FracturedSubEntity getFrontRightEnt() {
        return this.frontRightEnt;
    }

    @NotNull
    public final FracturedSubEntity getBackLeftEnt() {
        return this.backLeftEnt;
    }

    @NotNull
    public final FracturedSubEntity getBackRightEnt() {
        return this.backRightEnt;
    }

    @NotNull
    public final Leg getFrontLeft() {
        return this.frontLeft;
    }

    @NotNull
    public final Leg getFrontRight() {
        return this.frontRight;
    }

    @NotNull
    public final Leg getBackLeft() {
        return this.backLeft;
    }

    @NotNull
    public final Leg getBackRight() {
        return this.backRight;
    }

    @NotNull
    public final Leg[] getLegs() {
        return this.legs;
    }

    @NotNull
    public final List<LivingEntity> getEntityList() {
        return this.entityList;
    }

    public final void setEntityList(@NotNull List<LivingEntity> list) {
        Intrinsics.checkNotNullParameter(list, (String)"<set-?>");
        this.entityList = list;
    }

    public final void hurtMultipleTargets(float damage, double knockbackStrength, @NotNull DamageSource damageSource) {
        Intrinsics.checkNotNullParameter((Object)damageSource, (String)"damageSource");
        long i = 0L;
        i = 1L;
        Iterable $this$forEach$iv = this.entityList;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            LivingEntity entity = (LivingEntity)element$iv;
            boolean bl = false;
            EntityUtil.getQueue((Entity)((Entity)this)).add(i, () -> BaseFracturedEntity.hurtMultipleTargets$lambda$0$0(this, entity, damage, knockbackStrength, damageSource));
            ++i;
        }
    }

    public final boolean doHurtTargetTheSecond(@NotNull Entity entity, float damage, double knockbackStrength, @NotNull DamageSource damageSource) {
        boolean flag;
        Intrinsics.checkNotNullParameter((Object)entity, (String)"entity");
        Intrinsics.checkNotNullParameter((Object)damageSource, (String)"damageSource");
        float f = damage;
        Level var5 = this.level();
        if (var5 instanceof ServerLevel) {
            f = EnchantmentHelper.modifyDamage((ServerLevel)((ServerLevel)var5), (ItemStack)this.getWeaponItem(), (Entity)entity, (DamageSource)damageSource, (float)f);
        }
        if (flag = entity.hurt(damageSource, f)) {
            Level var7;
            if (entity instanceof LivingEntity) {
                Vec3 vec3 = ((LivingEntity)entity).getLookAngle().normalize();
                Intrinsics.checkNotNullExpressionValue((Object)vec3, (String)"normalize(...)");
                Vec3 lookDirection = vec3;
                Vec3 knockbackVector = new Vec3(-lookDirection.x * knockbackStrength, knockbackStrength, -lookDirection.z * knockbackStrength);
                ((LivingEntity)entity).setDeltaMovement(((LivingEntity)entity).getDeltaMovement().add(knockbackVector));
            }
            if ((var7 = this.level()) instanceof ServerLevel) {
                EnchantmentHelper.doPostAttackEffects((ServerLevel)((ServerLevel)var7), (Entity)entity, (DamageSource)damageSource);
            }
            this.setLastHurtMob(entity);
        }
        return flag;
    }

    public final void swap() {
        if (this.getCurrentState() == JimmyStates.NORMAL) {
            this.setCurrentState(JimmyStates.SWITCHING);
        }
    }

    @NotNull
    public FracturedSubEntity subEntity(@NotNull String name, @NotNull Number width, @NotNull Number height, @NotNull Vec3 defaultOffset) {
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter((Object)width, (String)"width");
        Intrinsics.checkNotNullParameter((Object)height, (String)"height");
        Intrinsics.checkNotNullParameter((Object)defaultOffset, (String)"defaultOffset");
        FracturedSubEntity fracturedSubEntity = new FracturedSubEntity(this, name, width.floatValue(), height.floatValue(), defaultOffset);
        List list = this.getSubEntities();
        MultipartSubEntity p0 = fracturedSubEntity;
        boolean bl = false;
        list.add(p0);
        return fracturedSubEntity;
    }

    @NotNull
    public final FracturedPartEntity subPart(@NotNull String name, @NotNull Number width, @NotNull Number height) {
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter((Object)width, (String)"width");
        Intrinsics.checkNotNullParameter((Object)height, (String)"height");
        FracturedPartEntity fracturedPartEntity = new FracturedPartEntity(this, name, width.floatValue(), height.floatValue());
        List list = this.getParts();
        MultipartEntityPart p0 = fracturedPartEntity;
        boolean bl = false;
        list.add(p0);
        return fracturedPartEntity;
    }

    @NotNull
    public AABB getBoundingBoxForCulling() {
        AABB aABB = super.getBoundingBoxForCulling().inflate(128.0);
        Intrinsics.checkNotNullExpressionValue((Object)aABB, (String)"inflate(...)");
        return aABB;
    }

    public boolean shouldRenderAtSqrDistance(double dist) {
        return dist < 262144.0;
    }

    public boolean removeWhenFarAway(double distanceToClosestPlayer) {
        return false;
    }

    public boolean hurt(@NotNull DamageSource source, float amount) {
        Intrinsics.checkNotNullParameter((Object)source, (String)"source");
        if (this.getArrowCount() > 0) {
            this.setArrowCount(this.getArrowCount() - 1);
        }
        if (source.is(DamageTypeTags.IS_FALL)) {
            return false;
        }
        if (source.is(DamageTypes.IN_WALL)) {
            return false;
        }
        boolean result = super.hurt(source, amount);
        if (!source.isCreativePlayer() && source.getEntity() != null) {
            this.setTarget((LivingEntity)source.getEntity());
        }
        return result;
    }

    public void baseTick() {
        super.baseTick();
        this.tickLegs();
        SideUtil.serverSide((Entity)((Entity)this), () -> BaseFracturedEntity.baseTick$lambda$0(this));
    }

    private final Vec3 findSurfaceAhead(int maxDist, int step) {
        Level lvl = this.level();
        double yaw = Math.toRadians((double)this.getYRot() + 90.0);
        double dirX = -Math.sin(yaw);
        double dirZ = Math.cos(yaw);
        for (int dist = step; dist <= maxDist; dist += step) {
            int checkY;
            int checkX = (int)(this.getX() + dirX * (double)dist);
            int checkZ = (int)(this.getZ() + dirZ * (double)dist);
            for (int dy = 0; dy < 41 && (checkY = (int)this.getY() + 60 - dy) >= lvl.getMinBuildHeight(); ++dy) {
                BlockPos pos = new BlockPos(checkX, checkY, checkZ);
                if (lvl.getBlockState(pos).isAir() || !lvl.getBlockState(pos.above()).isAir() || !lvl.getBlockState(pos.above(2)).isAir()) continue;
                return new Vec3((double)checkX + 0.5, (double)(checkY + 1), (double)checkZ + 0.5);
            }
        }
        return null;
    }

    static /* synthetic */ Vec3 findSurfaceAhead$default(BaseFracturedEntity baseFracturedEntity, int n, int n2, int n3, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: findSurfaceAhead");
        }
        if ((n3 & 1) != 0) {
            n = 64;
        }
        if ((n3 & 2) != 0) {
            n2 = 3;
        }
        return baseFracturedEntity.findSurfaceAhead(n, n2);
    }

    public final int getRiseAnimDuration() {
        return this.riseAnimDuration;
    }

    public final int getDigAnimDuration() {
        return this.digAnimDuration;
    }

    public final int getDefeatedAnimDuration() {
        return this.defeatedAnimDuration;
    }

    public final int getRiseTick() {
        return this.riseTick;
    }

    public final void setRiseTick(int n) {
        this.riseTick = n;
    }

    public final int getDigTick() {
        return this.digTick;
    }

    public final void setDigTick(int n) {
        this.digTick = n;
    }

    public final int getDespawnTick() {
        return this.despawnTick;
    }

    public final void setDespawnTick(int n) {
        this.despawnTick = n;
    }

    public final int getDefeatedTick() {
        return this.defeatedTick;
    }

    public final void setDefeatedTick(int n) {
        this.defeatedTick = n;
    }

    public final int getSwitchingTick() {
        return this.switchingTick;
    }

    public final void setSwitchingTick(int n) {
        this.switchingTick = n;
    }

    public void tick() {
        int n;
        super.tick();
        if (this.getCurrentState() == JimmyStates.RISING) {
            if (this.riseTick > 0) {
                n = this.riseTick;
                this.riseTick = n + -1;
                SideUtil.serverSide((Entity)((Entity)this), () -> BaseFracturedEntity.tick$lambda$0(this));
            } else {
                this.setCurrentState(JimmyStates.NORMAL);
            }
        } else {
            this.riseTick = this.riseAnimDuration;
        }
        if (this.getCurrentState() == JimmyStates.DIGGING) {
            if (this.digTick > 0) {
                n = this.digTick;
                this.digTick = n + -1;
            } else {
                this.setCurrentState(JimmyStates.UNDERGROUND);
            }
        } else {
            this.digTick = this.digAnimDuration;
        }
        if (this.getCurrentState() == JimmyStates.DESPAWNING) {
            if (this.despawnTick > 0) {
                n = this.despawnTick;
                this.despawnTick = n + -1;
            } else {
                this.discard();
            }
        } else {
            this.despawnTick = this.digAnimDuration;
        }
        if (this.getCurrentState() == JimmyStates.DEFEATED) {
            if (this.defeatedTick > 0) {
                n = this.defeatedTick;
                this.defeatedTick = n + -1;
            } else {
                JimArena arena = JimArena.instance;
                if (arena != null) {
                    if (!this.getGaveBlock()) {
                        this.getLevel().setBlock(PositionUtil.getBlockPos((Position)((Position)this.getPos())), TBSBlocks.CORRUPTED_COMMAND_BLOCK_GIVER.getDefaultState(), 3);
                        this.setGaveBlock(true);
                    }
                    TheBrokenScript.serverWorkQueue.add(2L, () -> BaseFracturedEntity.tick$lambda$1(arena));
                } else {
                    this.discard();
                }
            }
        } else {
            this.defeatedTick = this.defeatedAnimDuration;
        }
        if (this.getCurrentState() == JimmyStates.SWITCHING) {
            if (this.switchingTick > 0) {
                int arena = this.switchingTick;
                this.switchingTick = arena + -1;
            } else {
                JimArena arena = JimArena.instance;
                if (arena == null) {
                    BlockPos blockPos = PositionUtil.getBlockPos((Position)((Position)this.getPos()));
                    Level level = this.getLevel();
                    Intrinsics.checkNotNull((Object)level, (String)"null cannot be cast to non-null type net.minecraft.server.level.ServerLevel");
                    JimArena.Companion.start(blockPos, (ServerLevel)level);
                }
                this.discard();
            }
        } else {
            this.switchingTick = this.digAnimDuration;
        }
        SideUtil.clientSide((Entity)((Entity)this), () -> BaseFracturedEntity.tick$lambda$2(this));
    }

    public final void tickLegs() {
        Leg[] $this$forEach$iv = this.legs;
        boolean $i$f$forEach = false;
        int n = $this$forEach$iv.length;
        for (int i = 0; i < n; ++i) {
            Leg element$iv;
            Leg it = element$iv = $this$forEach$iv[i];
            boolean bl = false;
            it.tick(this);
        }
    }

    public void registerControllers(@NotNull AnimatableManager.ControllerRegistrar reg) {
        Intrinsics.checkNotNullParameter((Object)reg, (String)"reg");
        reg.add(new AnimationController((GeoAnimatable)this, "spawn_controller", 0, arg_0 -> BaseFracturedEntity.registerControllers$lambda$0(this, arg_0)));
        reg.add(new AnimationController((GeoAnimatable)this, "main_controller", 0, arg_0 -> BaseFracturedEntity.registerControllers$lambda$1(this, arg_0)));
        reg.add(new AnimationController((GeoAnimatable)this, "dig_controller", 0, arg_0 -> BaseFracturedEntity.registerControllers$lambda$2(this, arg_0)));
        reg.add(new AnimationController((GeoAnimatable)this, "underground_controller", 0, arg_0 -> BaseFracturedEntity.registerControllers$lambda$3(this, arg_0)));
    }

    @Nullable
    public SpawnGroupData onFinalizeSpawn(@NotNull ServerLevelAccessor level, @NotNull DifficultyInstance difficulty, @NotNull MobSpawnType spawnType, @Nullable SpawnGroupData spawnData, @NotNull CancelProxy event) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)difficulty, (String)"difficulty");
        Intrinsics.checkNotNullParameter((Object)spawnType, (String)"spawnType");
        Intrinsics.checkNotNullParameter((Object)event, (String)"event");
        return null;
    }

    public void addAdditionalSaveData(@NotNull CompoundTag compound) {
        Intrinsics.checkNotNullParameter((Object)compound, (String)"compound");
        super.addAdditionalSaveData(compound);
        compound.putString("state", this.getCurrentState().name());
        compound.putBoolean("gave_block", this.getGaveBlock());
    }

    public void readAdditionalSaveData(@NotNull CompoundTag compound) {
        Intrinsics.checkNotNullParameter((Object)compound, (String)"compound");
        super.readAdditionalSaveData(compound);
        if (compound.contains("state")) {
            Object object;
            Object object2 = this;
            BaseFracturedEntity baseFracturedEntity = this;
            try {
                BaseFracturedEntity $this$readAdditionalSaveData_u24lambda_u240 = object2;
                boolean bl = false;
                String string = compound.getString("state");
                Intrinsics.checkNotNullExpressionValue((Object)string, (String)"getString(...)");
                object = Result.constructor-impl((Object)((Object)JimmyStates.valueOf(string)));
            }
            catch (Throwable throwable) {
                object = Result.constructor-impl((Object)ResultKt.createFailure((Throwable)throwable));
            }
            object2 = object;
            object = this.getCurrentState();
            baseFracturedEntity.setCurrentState((JimmyStates)((Object)(Result.isFailure-impl((Object)object2) ? object : object2)));
        }
        if (compound.contains("gave_block")) {
            this.setGaveBlock(compound.getBoolean("gave_block"));
        }
    }

    protected void defineSynchedData(@NotNull SynchedEntityData.Builder builder) {
        Intrinsics.checkNotNullParameter((Object)builder, (String)"builder");
        super.defineSynchedData(builder);
        builder.define(STATE, (Object)"NORMAL");
        builder.define(GAVE_BLOCK, (Object)false);
    }

    @OnlyIn(value=Dist.CLIENT)
    private final void playSpawnSounds() {
        FancyEntitySoundInstance fancyEntitySoundInstance = this.sfx;
        boolean bl = fancyEntitySoundInstance != null ? !fancyEntitySoundInstance.isStopped() : false;
        if (bl) {
            return;
        }
        FancyEntitySoundInstance fancyEntitySoundInstance2 = this.sfx = FancyAudio.play$default((FancyAudio)FancyAudio.INSTANCE, (SoundEvent)((SoundEvent)TBSSounds.JIMMY_SPAWN.get()), (SoundSource)SoundSource.HOSTILE, (float)0.0f, (float)0.0f, (boolean)false, null, (Entity)((Entity)this), (int)60, null);
        if (fancyEntitySoundInstance2 != null) {
            fancyEntitySoundInstance2.setAttenuation(1.0f, 500.0f, 0.0f);
        }
        FancyEntitySoundInstance fancyEntitySoundInstance3 = this.sfx;
        if (fancyEntitySoundInstance3 != null) {
            fancyEntitySoundInstance3.setGain(2.0f);
        }
        FancyEntitySoundInstance fancyEntitySoundInstance4 = this.sfx;
        if (fancyEntitySoundInstance4 != null) {
            fancyEntitySoundInstance4.addEffect(AudioEffects.REVERB.create((Function1)new Function1<ReverbEffect, Unit>((Object)ReverbPresets.EFX_REVERB_PRESET_MOUNTAINS){

                public final void invoke(ReverbEffect p0) {
                    Intrinsics.checkNotNullParameter((Object)p0, (String)"p0");
                    ((ReverbPreset)this.receiver).apply(p0);
                }
            }));
        }
        TBSClient.INSTANCE.getQueue().add(340L, () -> BaseFracturedEntity.playSpawnSounds$lambda$0(this));
    }

    private static final Unit hurtMultipleTargets$lambda$0$0(BaseFracturedEntity this$0, LivingEntity $entity, float $damage, double $knockbackStrength, DamageSource $damageSource) {
        this$0.doHurtTargetTheSecond((Entity)$entity, $damage, $knockbackStrength, $damageSource);
        return Unit.INSTANCE;
    }

    private static final Unit baseTick$lambda$0(BaseFracturedEntity this$0) {
        if (this$0.onGround()) {
            this$0.lastSafeGroundPos = this$0.position();
            this$0.airborneTicks = 0;
        } else {
            boolean airborneTooLong;
            int n = this$0.airborneTicks;
            this$0.airborneTicks = n + 1;
            Vec3 safe = this$0.lastSafeGroundPos;
            boolean fellTooFar = safe != null && safe.y - this$0.getY() > 20.0;
            boolean bl = airborneTooLong = this$0.airborneTicks > 40;
            if (safe != null && (fellTooFar || airborneTooLong)) {
                Vec3 vec3 = BaseFracturedEntity.findSurfaceAhead$default(this$0, 0, 0, 3, null);
                if (vec3 == null) {
                    vec3 = safe;
                }
                Vec3 destination = vec3;
                this$0.setDeltaMovement(Vec3.ZERO);
                this$0.fallDistance = 0.0f;
                this$0.teleportTo(destination.x, destination.y, destination.z);
                this$0.lastSafeGroundPos = destination;
                this$0.airborneTicks = 0;
                this$0.moveControl.setWantedPosition(this$0.getX(), this$0.getY(), this$0.getZ(), 0.0);
            }
        }
        return Unit.INSTANCE;
    }

    /*
     * WARNING - void declaration
     */
    private static final Unit tick$lambda$0(BaseFracturedEntity this$0) {
        int n = this$0.riseTick;
        boolean bl = 55 <= n ? n < 104 : false;
        if (bl) {
            void $this$filterTo$iv$iv;
            void $this$filter$iv;
            List playersInRange = EntityFinder.findPlayersInRange((LevelAccessor)((LevelAccessor)this$0.getLevel()), (Vec3)this$0.getPos(), (Number)30);
            Iterable iterable = playersInRange;
            BaseFracturedEntity baseFracturedEntity = this$0;
            boolean $i$f$filter = false;
            void var4_6 = $this$filter$iv;
            Collection destination$iv$iv = new ArrayList();
            boolean $i$f$filterTo = false;
            for (Object element$iv$iv : $this$filterTo$iv$iv) {
                Player it = (Player)element$iv$iv;
                boolean bl2 = false;
                if (!it.onGround()) continue;
                destination$iv$iv.add(element$iv$iv);
            }
            baseFracturedEntity.entityList = CollectionsKt.toMutableList((Collection)((List)destination$iv$iv));
            DamageSource damageSource = this$0.damageSources().source(TBSDamageTypes.JIMMY_RISE.getKey());
            Intrinsics.checkNotNullExpressionValue((Object)damageSource, (String)"source(...)");
            this$0.hurtMultipleTargets(19.0f, 30.0, damageSource);
        }
        return Unit.INSTANCE;
    }

    private static final Unit tick$lambda$1(JimArena $arena) {
        $arena.reset();
        return Unit.INSTANCE;
    }

    private static final Object tick$lambda$2(BaseFracturedEntity this$0) {
        if (!ClientVariables.INSTANCE.has(4L)) {
            LocalPlayer localPlayer = ClientDSLKt.getMC().player;
            if (localPlayer == null) {
                return false;
            }
            LocalPlayer player = localPlayer;
            if (PlayerExt.INSTANCE.isEntityInFovCone((Player)player, (Entity)this$0, Double.valueOf(((Number)ClientDSLKt.getMC().options.fov().get()).intValue()))) {
                ClientVariables.INSTANCE.set(4L);
            }
        }
        return Unit.INSTANCE;
    }

    private static final PlayState registerControllers$lambda$0(BaseFracturedEntity this$0, AnimationState event) {
        if (this$0.getCurrentState() == JimmyStates.RISING) {
            Entity entity = (Entity)this$0;
            AnimationController animationController = event.getController();
            Intrinsics.checkNotNullExpressionValue((Object)animationController, (String)"getController(...)");
            GeckoUtil.once((Entity)entity, (AnimationController)animationController, (String)"Spawn");
            this$0.playSpawnSounds();
            return PlayState.CONTINUE;
        }
        return PlayState.STOP;
    }

    private static final PlayState registerControllers$lambda$1(BaseFracturedEntity this$0, AnimationState event) {
        if (this$0.getCurrentState() == JimmyStates.NORMAL) {
            if (!event.isMoving()) {
                Entity entity = (Entity)this$0;
                AnimationController animationController = event.getController();
                Intrinsics.checkNotNullExpressionValue((Object)animationController, (String)"getController(...)");
                GeckoUtil.loop((Entity)entity, (AnimationController)animationController, (String)"Idle");
            } else if (event.isMoving()) {
                Entity entity = (Entity)this$0;
                AnimationController animationController = event.getController();
                Intrinsics.checkNotNullExpressionValue((Object)animationController, (String)"getController(...)");
                GeckoUtil.loop((Entity)entity, (AnimationController)animationController, (String)"Walk");
            }
            return PlayState.CONTINUE;
        }
        return PlayState.STOP;
    }

    private static final PlayState registerControllers$lambda$2(BaseFracturedEntity this$0, AnimationState event) {
        if (this$0.getCurrentState() == JimmyStates.DIGGING || this$0.getCurrentState() == JimmyStates.DESPAWNING || this$0.getCurrentState() == JimmyStates.SWITCHING) {
            Entity entity = (Entity)this$0;
            AnimationController animationController = event.getController();
            Intrinsics.checkNotNullExpressionValue((Object)animationController, (String)"getController(...)");
            GeckoUtil.once((Entity)entity, (AnimationController)animationController, (String)"Flee");
            return PlayState.CONTINUE;
        }
        return PlayState.STOP;
    }

    private static final PlayState registerControllers$lambda$3(BaseFracturedEntity this$0, AnimationState event) {
        if (this$0.getCurrentState() == JimmyStates.UNDERGROUND) {
            Entity entity = (Entity)this$0;
            AnimationController animationController = event.getController();
            Intrinsics.checkNotNullExpressionValue((Object)animationController, (String)"getController(...)");
            GeckoUtil.loop((Entity)entity, (AnimationController)animationController, (String)"Underground");
            return PlayState.CONTINUE;
        }
        return PlayState.STOP;
    }

    private static final Unit playSpawnSounds$lambda$0(BaseFracturedEntity this$0) {
        block4: {
            Object object;
            FancyEntitySoundInstance fancyEntitySoundInstance = this$0.sfx;
            if (fancyEntitySoundInstance != null) {
                fancyEntitySoundInstance.stopSFX();
            }
            FancyEntitySoundInstance fancyEntitySoundInstance2 = this$0.sfx = FancyAudio.play$default((FancyAudio)FancyAudio.INSTANCE, (SoundEvent)((SoundEvent)TBSSounds.JIMMY_ROAR.get()), (SoundSource)SoundSource.HOSTILE, (float)0.0f, (float)0.0f, (boolean)false, null, (Entity)((Entity)this$0), (int)60, null);
            if (fancyEntitySoundInstance2 != null) {
                fancyEntitySoundInstance2.setAttenuation(1.0f, 500.0f, 0.0f);
            }
            FancyEntitySoundInstance fancyEntitySoundInstance3 = this$0.sfx;
            if (fancyEntitySoundInstance3 != null) {
                fancyEntitySoundInstance3.setGain(2.0f);
            }
            FancyEntitySoundInstance fancyEntitySoundInstance4 = this$0.sfx;
            if (fancyEntitySoundInstance4 != null) {
                fancyEntitySoundInstance4.addEffect(AudioEffects.REVERB.create((Function1)new Function1<ReverbEffect, Unit>((Object)ReverbPresets.EFX_REVERB_PRESET_MOUNTAINS){

                    public final void invoke(ReverbEffect p0) {
                        Intrinsics.checkNotNullParameter((Object)p0, (String)"p0");
                        ((ReverbPreset)this.receiver).apply(p0);
                    }
                }));
            }
            if ((object = this$0.sfx) == null || (object = object.getOnEnded()) == null) break block4;
            object.add(arg_0 -> BaseFracturedEntity.playSpawnSounds$lambda$0$0(this$0, arg_0));
        }
        return Unit.INSTANCE;
    }

    private static final Unit playSpawnSounds$lambda$0$0(BaseFracturedEntity this$0, FancyEntitySoundInstance it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        this$0.sfx = null;
        return Unit.INSTANCE;
    }

    static {
        KProperty[] kPropertyArray = new KProperty[]{Reflection.mutableProperty1((MutablePropertyReference1)((MutablePropertyReference1)new MutablePropertyReference1Impl(BaseFracturedEntity.class, "gaveBlock", "getGaveBlock()Z", 0)))};
        $$delegatedProperties = kPropertyArray;
        Companion = new Companion(null);
        STATE = SynchedEntityData.defineId(BaseFracturedEntity.class, (EntityDataSerializer)EntityDataSerializers.STRING);
        GAVE_BLOCK = SynchedEntityData.defineId(BaseFracturedEntity.class, (EntityDataSerializer)EntityDataSerializers.BOOLEAN);
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R2\u0010\u0006\u001a&\u0012\f\u0012\n \t*\u0004\u0018\u00010\b0\b \t*\u0012\u0012\f\u0012\n \t*\u0004\u0018\u00010\b0\b\u0018\u00010\u00070\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R2\u0010\n\u001a&\u0012\f\u0012\n \t*\u0004\u0018\u00010\u000b0\u000b \t*\u0012\u0012\f\u0012\n \t*\u0004\u0018\u00010\u000b0\u000b\u0018\u00010\u00070\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2={"Lnet/thebrokenscript/api/entity/BaseFracturedEntity$Companion;", "", "<init>", "()V", "LEG_DIST", "", "STATE", "Lnet/minecraft/network/syncher/EntityDataAccessor;", "", "kotlin.jvm.PlatformType", "GAVE_BLOCK", "", "thebrokenscript-common"})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b\u00a8\u0006\f"}, d2={"Lnet/thebrokenscript/api/entity/BaseFracturedEntity$JimmyStates;", "", "<init>", "(Ljava/lang/String;I)V", "RISING", "NORMAL", "DIGGING", "UNDERGROUND", "ATTACKING", "DEFEATED", "DESPAWNING", "SWITCHING", "thebrokenscript-common"})
    public static final class JimmyStates
    extends Enum<JimmyStates> {
        public static final /* enum */ JimmyStates RISING = new JimmyStates();
        public static final /* enum */ JimmyStates NORMAL = new JimmyStates();
        public static final /* enum */ JimmyStates DIGGING = new JimmyStates();
        public static final /* enum */ JimmyStates UNDERGROUND = new JimmyStates();
        public static final /* enum */ JimmyStates ATTACKING = new JimmyStates();
        public static final /* enum */ JimmyStates DEFEATED = new JimmyStates();
        public static final /* enum */ JimmyStates DESPAWNING = new JimmyStates();
        public static final /* enum */ JimmyStates SWITCHING = new JimmyStates();
        private static final /* synthetic */ JimmyStates[] $VALUES;
        private static final /* synthetic */ EnumEntries $ENTRIES;

        public static JimmyStates[] values() {
            return (JimmyStates[])$VALUES.clone();
        }

        public static JimmyStates valueOf(String value) {
            return Enum.valueOf(JimmyStates.class, value);
        }

        @NotNull
        public static EnumEntries<JimmyStates> getEntries() {
            return $ENTRIES;
        }

        static {
            $VALUES = jimmyStatesArray = new JimmyStates[]{JimmyStates.RISING, JimmyStates.NORMAL, JimmyStates.DIGGING, JimmyStates.UNDERGROUND, JimmyStates.ATTACKING, JimmyStates.DEFEATED, JimmyStates.DESPAWNING, JimmyStates.SWITCHING};
            $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
        }
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\b\u0010\n\u001a\u00020\u0007H\u0016\u00a8\u0006\u000b"}, d2={"Lnet/thebrokenscript/api/entity/BaseFracturedEntity$RoamMoveControl;", "Lnet/minecraft/world/entity/ai/control/MoveControl;", "entity", "Lnet/thebrokenscript/api/entity/BaseFracturedEntity;", "<init>", "(Lnet/thebrokenscript/api/entity/BaseFracturedEntity;)V", "changeOperation", "", "op", "Lnet/minecraft/world/entity/ai/control/MoveControl$Operation;", "tick", "thebrokenscript-common"})
    protected static final class RoamMoveControl
    extends MoveControl {
        public RoamMoveControl(@NotNull BaseFracturedEntity entity) {
            Intrinsics.checkNotNullParameter((Object)((Object)entity), (String)"entity");
            super((Mob)entity);
        }

        public final void changeOperation(@NotNull MoveControl.Operation op) {
            Intrinsics.checkNotNullParameter((Object)op, (String)"op");
            this.operation = op;
        }

        public void tick() {
            double dz;
            if (this.operation != MoveControl.Operation.MOVE_TO) {
                return;
            }
            this.operation = MoveControl.Operation.WAIT;
            double dx = this.wantedX - this.mob.getX();
            double horizDistSq = dx * dx + (dz = this.wantedZ - this.mob.getZ()) * dz;
            if (horizDistSq < 0.125) {
                this.mob.zza = 0.0f;
                return;
            }
            float targetYaw = (float)(Mth.atan2((double)dz, (double)dx) * 180.0 / Math.PI) - 90.0f;
            this.mob.setYRot(this.rotlerp(this.mob.getYRot(), targetYaw, 90.0f));
            this.mob.setSpeed((float)(this.speedModifier * this.mob.getAttributeValue(Attributes.MOVEMENT_SPEED)));
            this.mob.zza = 1.0f;
            this.operation = MoveControl.Operation.MOVE_TO;
        }
    }
}

