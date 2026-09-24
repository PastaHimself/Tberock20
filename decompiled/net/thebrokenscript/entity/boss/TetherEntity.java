/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.comparisons.ComparisonsKt
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.MutablePropertyReference1
 *  kotlin.jvm.internal.MutablePropertyReference1Impl
 *  kotlin.jvm.internal.Reflection
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.math.MathKt
 *  kotlin.ranges.RangesKt
 *  kotlin.reflect.KProperty
 *  net.minecraft.core.BlockPos
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.nbt.ListTag
 *  net.minecraft.nbt.Tag
 *  net.minecraft.network.syncher.EntityDataAccessor
 *  net.minecraft.network.syncher.EntityDataSerializer
 *  net.minecraft.network.syncher.EntityDataSerializers
 *  net.minecraft.network.syncher.SynchedEntityData
 *  net.minecraft.network.syncher.SynchedEntityData$Builder
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.sounds.SoundEvent
 *  net.minecraft.sounds.SoundEvents
 *  net.minecraft.sounds.SoundSource
 *  net.minecraft.tags.BlockTags
 *  net.minecraft.tags.TagKey
 *  net.minecraft.util.RandomSource
 *  net.minecraft.world.DifficultyInstance
 *  net.minecraft.world.damagesource.DamageSource
 *  net.minecraft.world.damagesource.DamageTypes
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.Entity$RemovalReason
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.MobSpawnType
 *  net.minecraft.world.entity.SpawnGroupData
 *  net.minecraft.world.entity.ai.attributes.AttributeSupplier$Builder
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.level.BlockGetter
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.ServerLevelAccessor
 *  net.minecraft.world.level.block.Block
 *  net.minecraft.world.level.block.state.BlockState
 *  net.thebrokenscript.brokencore.api.dsl.AttributeUtil
 *  net.thebrokenscript.brokencore.api.dsl.EntityDataDelegate
 *  net.thebrokenscript.brokencore.api.entity.FinalizedSpawn
 *  net.thebrokenscript.brokencore.api.entity.anim.GeckoAnimatedMonster
 *  net.thebrokenscript.brokencore.api.entity.base.BaseMonster
 *  net.thebrokenscript.brokencore.api.entity.base.BaseMonster$BMC
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
package net.thebrokenscript.entity.boss;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KProperty;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.Tag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializer;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.thebrokenscript.brokencore.api.dsl.AttributeUtil;
import net.thebrokenscript.brokencore.api.dsl.EntityDataDelegate;
import net.thebrokenscript.brokencore.api.entity.FinalizedSpawn;
import net.thebrokenscript.brokencore.api.entity.anim.GeckoAnimatedMonster;
import net.thebrokenscript.brokencore.api.entity.base.BaseMonster;
import net.thebrokenscript.brokencore.api.platform.CancelProxy;
import net.thebrokenscript.entity.boss.TetherEntity;
import net.thebrokenscript.registry.TBSBlocks;
import net.thebrokenscript.registry.TBSEntities;
import net.thebrokenscript.util.NecrosisDeconstructTask;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.animation.AnimationController;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.animation.PlayState;
import software.bernie.geckolib.animation.RawAnimation;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u00a6\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 X2\u00020\u00012\u00020\u0002:\u0001XB\u001d\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00000\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u0012\u001a\u00020\u0013H\u0014J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0014J\n\u0010\u0018\u001a\u0004\u0018\u00010\u0015H\u0014J\u0010\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0010\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J4\u0010!\u001a\u0004\u0018\u00010\"2\u0006\u0010\u0005\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010\"2\u0006\u0010)\u001a\u00020*H\u0016J\u0010\u0010+\u001a\u00020\u00132\u0006\u0010,\u001a\u00020-H\u0014J\u0018\u0010.\u001a\u00020 2\u0006\u0010\u0005\u001a\u00020/2\u0006\u00100\u001a\u00020 H\u0002J<\u00107\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u001f2\u0006\u0010\u0005\u001a\u00020/2\u0006\u00108\u001a\u00020 2\u0006\u00109\u001a\u00020 2\b\b\u0002\u0010:\u001a\u00020\n2\b\b\u0002\u0010;\u001a\u00020<H\u0002J\u0018\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020\u00172\u0006\u0010@\u001a\u00020AH\u0016J\u0010\u0010B\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010F\u001a\u00020\u0013H\u0014J\b\u0010J\u001a\u00020\u0013H\u0016J\b\u0010K\u001a\u00020\u0013H\u0016J\u0010\u0010L\u001a\u00020>2\u0006\u0010M\u001a\u00020<H\u0016J\b\u0010N\u001a\u00020>H\u0016J\b\u0010O\u001a\u00020>H\u0016J\u0010\u0010U\u001a\u00020\u00132\u0006\u0010V\u001a\u00020WH\u0016R+\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0\u001f0\u001eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R;\u00101\u001a,\u0012(\u0012&\u0012\f\u0012\n 4*\u0004\u0018\u00010303 4*\u0012\u0012\f\u0012\n 4*\u0004\u0018\u00010303\u0018\u000102020\u001f\u00a2\u0006\b\n\u0000\u001a\u0004\b5\u00106R\u001a\u0010C\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bD\u0010\r\"\u0004\bE\u0010\u000fR\u001a\u0010G\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bH\u0010\r\"\u0004\bI\u0010\u000fR\u001a\u0010P\u001a\u00020>X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010T\u00a8\u0006Y"}, d2={"Lnet/thebrokenscript/entity/boss/TetherEntity;", "Lnet/thebrokenscript/brokencore/api/entity/anim/GeckoAnimatedMonster;", "Lnet/thebrokenscript/brokencore/api/entity/FinalizedSpawn;", "type", "Lnet/minecraft/world/entity/EntityType;", "level", "Lnet/minecraft/world/level/Level;", "<init>", "(Lnet/minecraft/world/entity/EntityType;Lnet/minecraft/world/level/Level;)V", "<set-?>", "", "floor", "getFloor", "()I", "setFloor", "(I)V", "floor$delegate", "Lnet/thebrokenscript/brokencore/api/dsl/EntityDataDelegate;", "registerGoals", "", "getHurtSound", "Lnet/minecraft/sounds/SoundEvent;", "damageSource", "Lnet/minecraft/world/damagesource/DamageSource;", "getDeathSound", "addAdditionalSaveData", "compound", "Lnet/minecraft/nbt/CompoundTag;", "readAdditionalSaveData", "spawnedPaths", "", "", "Lnet/minecraft/core/BlockPos;", "onFinalizeSpawn", "Lnet/minecraft/world/entity/SpawnGroupData;", "Lnet/minecraft/world/level/ServerLevelAccessor;", "difficulty", "Lnet/minecraft/world/DifficultyInstance;", "spawnType", "Lnet/minecraft/world/entity/MobSpawnType;", "spawnData", "event", "Lnet/thebrokenscript/brokencore/api/platform/CancelProxy;", "defineSynchedData", "builder", "Lnet/minecraft/network/syncher/SynchedEntityData$Builder;", "findGround", "Lnet/minecraft/server/level/ServerLevel;", "pos", "blockAllowList", "Lnet/minecraft/tags/TagKey;", "Lnet/minecraft/world/level/block/Block;", "kotlin.jvm.PlatformType", "getBlockAllowList", "()Ljava/util/List;", "findPathAStar", "start", "end", "maxNodes", "variance", "", "hurt", "", "source", "amount", "", "die", "deathTimer", "getDeathTimer", "setDeathTimer", "tickDeath", "soundCooldown", "getSoundCooldown", "setSoundCooldown", "tick", "baseTick", "removeWhenFarAway", "distanceToClosestPlayer", "isPushedByFluid", "isPushable", "spawnAnimPlayed", "getSpawnAnimPlayed", "()Z", "setSpawnAnimPlayed", "(Z)V", "registerControllers", "reg", "Lsoftware/bernie/geckolib/animation/AnimatableManager$ControllerRegistrar;", "Companion", "thebrokenscript-common"})
@SourceDebugExtension(value={"SMAP\nTetherEntity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TetherEntity.kt\nnet/thebrokenscript/entity/boss/TetherEntity\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,385:1\n1869#2:386\n1869#2,2:387\n1870#2:389\n1869#2,2:390\n1869#2,2:392\n1869#2,2:394\n1761#2,3:396\n*S KotlinDebug\n*F\n+ 1 TetherEntity.kt\nnet/thebrokenscript/entity/boss/TetherEntity\n*L\n66#1:386\n68#1:387,2\n66#1:389\n134#1:390,2\n145#1:392,2\n325#1:394,2\n202#1:396,3\n*E\n"})
public final class TetherEntity
extends GeckoAnimatedMonster
implements FinalizedSpawn {
    @NotNull
    public static final Companion Companion;
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;
    @NotNull
    private final EntityDataDelegate floor$delegate;
    @NotNull
    private final List<List<BlockPos>> spawnedPaths;
    @NotNull
    private final List<TagKey<Block>> blockAllowList;
    private int deathTimer;
    private int soundCooldown;
    private boolean spawnAnimPlayed;
    @NotNull
    private static final EntityDataAccessor<Integer> FLOOR;

    public TetherEntity(@NotNull EntityType<TetherEntity> type, @NotNull Level level) {
        Intrinsics.checkNotNullParameter(type, (String)"type");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        super(type, level);
        this.xpReward = 0;
        this.setNoAi(false);
        this.setPersistenceRequired();
        this.floor$delegate = this.entityData(FLOOR);
        this.spawnedPaths = new ArrayList();
        this.blockAllowList = CollectionsKt.listOf((Object)BlockTags.DOORS);
    }

    public final int getFloor() {
        return ((Number)this.floor$delegate.getValue((BaseMonster)this, $$delegatedProperties[0])).intValue();
    }

    public final void setFloor(int n) {
        this.floor$delegate.setValue((BaseMonster)this, $$delegatedProperties[0], (Object)n);
    }

    protected void registerGoals() {
        super.registerGoals();
    }

    @Nullable
    protected SoundEvent getHurtSound(@NotNull DamageSource damageSource) {
        Intrinsics.checkNotNullParameter((Object)damageSource, (String)"damageSource");
        return null;
    }

    @Nullable
    protected SoundEvent getDeathSound() {
        return null;
    }

    public void addAdditionalSaveData(@NotNull CompoundTag compound) {
        Intrinsics.checkNotNullParameter((Object)compound, (String)"compound");
        super.addAdditionalSaveData(compound);
        ListTag pathsTag = new ListTag();
        Iterable $this$forEach$iv = this.spawnedPaths;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            List path = (List)element$iv;
            boolean bl = false;
            ListTag posListTag = new ListTag();
            Iterable $this$forEach$iv2 = path;
            boolean $i$f$forEach2 = false;
            for (Object element$iv2 : $this$forEach$iv2) {
                BlockPos pos = (BlockPos)element$iv2;
                boolean bl2 = false;
                CompoundTag posTag = new CompoundTag();
                posTag.putInt("x", pos.getX());
                posTag.putInt("y", pos.getY());
                posTag.putInt("z", pos.getZ());
                posListTag.add((Object)posTag);
            }
            pathsTag.add((Object)posListTag);
        }
        compound.put("SpawnedPaths", (Tag)pathsTag);
        compound.putInt("floor", this.getFloor());
    }

    public void readAdditionalSaveData(@NotNull CompoundTag compound) {
        Intrinsics.checkNotNullParameter((Object)compound, (String)"compound");
        super.readAdditionalSaveData(compound);
        this.spawnedPaths.clear();
        ListTag pathsTag = compound.getList("SpawnedPaths", 9);
        int n = ((Collection)pathsTag).size();
        for (int i = 0; i < n; ++i) {
            ListTag posListTag = pathsTag.getList(i);
            List path = new ArrayList();
            int n2 = ((Collection)posListTag).size();
            for (int j = 0; j < n2; ++j) {
                CompoundTag posTag = posListTag.getCompound(j);
                path.add(new BlockPos(posTag.getInt("x"), posTag.getInt("y"), posTag.getInt("z")));
            }
            this.spawnedPaths.add(path);
        }
        if (compound.contains("floor")) {
            this.entityData.set(FLOOR, (Object)compound.getInt("floor"));
        }
    }

    @Nullable
    public SpawnGroupData onFinalizeSpawn(@NotNull ServerLevelAccessor level, @NotNull DifficultyInstance difficulty, @NotNull MobSpawnType spawnType, @Nullable SpawnGroupData spawnData, @NotNull CancelProxy event) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)difficulty, (String)"difficulty");
        Intrinsics.checkNotNullParameter((Object)spawnType, (String)"spawnType");
        Intrinsics.checkNotNullParameter((Object)event, (String)"event");
        ServerLevel serverLevel = level instanceof ServerLevel ? (ServerLevel)level : null;
        if (serverLevel == null) {
            return null;
        }
        ServerLevel serverLevel2 = serverLevel;
        RandomSource random = serverLevel2.random;
        BlockPos origin = this.getBlockPos();
        int rootCount = 8 + random.nextInt(5);
        double baseAngleStep = Math.PI * 2 / (double)rootCount;
        for (int i = 0; i < rootCount; ++i) {
            List it;
            double angle = (double)i * baseAngleStep + (random.nextDouble() - 0.5) * baseAngleStep * 0.5;
            int radius = 8 + random.nextInt(9);
            int targetX = origin.getX() + MathKt.roundToInt((double)(Math.cos(angle) * (double)radius));
            int targetZ = origin.getZ() + MathKt.roundToInt((double)(Math.sin(angle) * (double)radius));
            BlockPos targetPos = this.findGround(serverLevel2, new BlockPos(targetX, origin.getY() + 1, targetZ));
            BlockPos blockPos = origin.above(1);
            Intrinsics.checkNotNullExpressionValue((Object)blockPos, (String)"above(...)");
            BlockPos startPos = this.findGround(serverLevel2, blockPos).above();
            Player player = serverLevel2.getNearestPlayer((Entity)this, 512.0);
            if (player == null || (player = player.blockPosition()) == null) {
                return null;
            }
            Player nearestPlayer = player;
            BlockPos nearestPlayerButNoY = new BlockPos(nearestPlayer.getX(), this.getBlockPos().getY(), nearestPlayer.getZ());
            Intrinsics.checkNotNull((Object)startPos);
            List path = TetherEntity.findPathAStar$default(this, serverLevel2, startPos, targetPos, 0, 0.0, 24, null);
            if (path != null) {
                List it2;
                boolean bl = false;
                this.spawnedPaths.add(it2);
                Iterable $this$forEach$iv = it2;
                boolean $i$f$forEach = false;
                for (Object element$iv : $this$forEach$iv) {
                    BlockPos pos = (BlockPos)element$iv;
                    boolean bl2 = false;
                    if (!serverLevel2.getBlockState(pos).isCollisionShapeFullBlock((BlockGetter)serverLevel2, pos)) continue;
                    serverLevel2.setBlock(pos, TBSBlocks.NECROSIS.getDefaultState(), 3);
                }
            }
            BlockPos blockPos2 = this.getBlockPos().above();
            Intrinsics.checkNotNullExpressionValue((Object)blockPos2, (String)"above(...)");
            List pathToNearestPlayer = TetherEntity.findPathAStar$default(this, serverLevel2, blockPos2, nearestPlayerButNoY, 0, 0.0, 24, null);
            if (pathToNearestPlayer == null) continue;
            boolean bl = false;
            this.spawnedPaths.add(it);
            Iterable $this$forEach$iv = it;
            boolean $i$f$forEach = false;
            for (Object element$iv : $this$forEach$iv) {
                BlockPos pos = (BlockPos)element$iv;
                boolean bl3 = false;
                if (!serverLevel2.getBlockState(pos).isCollisionShapeFullBlock((BlockGetter)serverLevel2, pos)) continue;
                serverLevel2.setBlock(pos, TBSBlocks.NECROSIS.getDefaultState(), 3);
            }
        }
        return null;
    }

    protected void defineSynchedData(@NotNull SynchedEntityData.Builder builder) {
        Intrinsics.checkNotNullParameter((Object)builder, (String)"builder");
        super.defineSynchedData(builder);
        builder.define(FLOOR, (Object)-1);
    }

    private final BlockPos findGround(ServerLevel level, BlockPos pos) {
        BlockPos current = pos;
        while (current.getY() > level.getMinBuildHeight()) {
            BlockState state = level.getBlockState(current);
            if (!state.isAir() && !state.canBeReplaced()) {
                BlockPos blockPos = current.above();
                Intrinsics.checkNotNullExpressionValue((Object)blockPos, (String)"above(...)");
                return blockPos;
            }
            Intrinsics.checkNotNullExpressionValue((Object)current.below(), (String)"below(...)");
        }
        return pos;
    }

    @NotNull
    public final List<TagKey<Block>> getBlockAllowList() {
        return this.blockAllowList;
    }

    private final List<BlockPos> findPathAStar(ServerLevel level, BlockPos start, BlockPos end, int maxNodes, double variance) {
        RandomSource random = level.random;
        @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000-\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\u008a\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0000\u00a2\u0006\u0004\b\t\u0010\nJ\t\u0010\u0016\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0017\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0018\u001a\u00020\u0007H\u00c6\u0003J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0000H\u00c6\u0003\u00a2\u0006\u0002\u0010\u0012J8\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0000H\u00c6\u0001\u00a2\u0006\u0002\u0010\u001bJ\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001f\u001a\u00020\u0005H\u00d6\u0001J\t\u0010 \u001a\u00020!H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0015\u0010\b\u001a\u0004\u0018\u00010\u0000\u00a2\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0014\u001a\u00020\u00078F\u00a2\u0006\u0006\u001a\u0004\b\u0015\u0010\u0010\u00a8\u0006\""}, d2={"net/thebrokenscript/entity/boss/TetherEntity$findPathAStar$Node", "", "pos", "Lnet/minecraft/core/BlockPos;", "g", "", "h", "", "parent", "<init>", "(Lnet/minecraft/core/BlockPos;IDLnet/thebrokenscript/entity/boss/TetherEntity$findPathAStar$Node;)V", "getPos", "()Lnet/minecraft/core/BlockPos;", "getG", "()I", "getH", "()D", "getParent", "()Lnet/thebrokenscript/entity/boss/TetherEntity$findPathAStar$Node;", "Lnet/thebrokenscript/entity/boss/TetherEntity$findPathAStar$Node;", "f", "getF", "component1", "component2", "component3", "component4", "copy", "(Lnet/minecraft/core/BlockPos;IDLnet/thebrokenscript/entity/boss/TetherEntity$findPathAStar$Node;)Lnet/thebrokenscript/entity/boss/TetherEntity$findPathAStar$Node;", "equals", "", "other", "hashCode", "toString", "", "thebrokenscript-common"})
        public final class Node {
            private final BlockPos pos;
            private final int g;
            private final double h;
            private final Node parent;

            public Node(BlockPos pos, int g, double h, Node parent) {
                Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
                this.pos = pos;
                this.g = g;
                this.h = h;
                this.parent = parent;
            }

            public final BlockPos getPos() {
                return this.pos;
            }

            public final int getG() {
                return this.g;
            }

            public final double getH() {
                return this.h;
            }

            public final Node getParent() {
                return this.parent;
            }

            public final double getF() {
                return (double)this.g + this.h;
            }

            public final BlockPos component1() {
                return this.pos;
            }

            public final int component2() {
                return this.g;
            }

            public final double component3() {
                return this.h;
            }

            public final Node component4() {
                return this.parent;
            }

            public final Node copy(BlockPos pos, int g, double h, Node parent) {
                Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
                return new Node(pos, g, h, parent);
            }

            public static /* synthetic */ Node copy$default(Node node, BlockPos blockPos, int n, double d, Node node2, int n2, Object object) {
                if ((n2 & 1) != 0) {
                    blockPos = node.pos;
                }
                if ((n2 & 2) != 0) {
                    n = node.g;
                }
                if ((n2 & 4) != 0) {
                    d = node.h;
                }
                if ((n2 & 8) != 0) {
                    node2 = node.parent;
                }
                return node.copy(blockPos, n, d, node2);
            }

            public String toString() {
                return "Node(pos=" + this.pos + ", g=" + this.g + ", h=" + this.h + ", parent=" + this.parent + ")";
            }

            public int hashCode() {
                int result = this.pos.hashCode();
                result = result * 31 + Integer.hashCode(this.g);
                result = result * 31 + Double.hashCode(this.h);
                result = result * 31 + (this.parent == null ? 0 : this.parent.hashCode());
                return result;
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Node)) {
                    return false;
                }
                Node node = (Node)other;
                if (!Intrinsics.areEqual((Object)this.pos, (Object)node.pos)) {
                    return false;
                }
                if (this.g != node.g) {
                    return false;
                }
                if (Double.compare(this.h, node.h) != 0) {
                    return false;
                }
                return Intrinsics.areEqual((Object)this.parent, (Object)node.parent);
            }
        }
        Node startNode = new Node(start, 0, TetherEntity.findPathAStar$heuristic(random, variance, start, end), null);
        PriorityQueue<Node> openSet = new PriorityQueue<Node>(new Comparator(){

            public final int compare(T a, T b) {
                Node it = (Node)a;
                boolean bl = false;
                Comparable comparable = Double.valueOf(it.getF());
                it = (Node)b;
                Comparable comparable2 = comparable;
                bl = false;
                return ComparisonsKt.compareValues((Comparable)comparable2, (Comparable)Double.valueOf(it.getF()));
            }
        });
        HashSet<BlockPos> closedSet = new HashSet<BlockPos>();
        HashMap bestG = new HashMap();
        openSet.add(startNode);
        ((Map)bestG).put(start, 0.0);
        int nodesExplored = 0;
        while (!((Collection)openSet).isEmpty() && nodesExplored < maxNodes) {
            Node current = (Node)openSet.poll();
            ++nodesExplored;
            if (Intrinsics.areEqual((Object)current.getPos(), (Object)end) || TetherEntity.findPathAStar$heuristic(random, variance, current.getPos(), end) <= 1.0) {
                List path = new ArrayList();
                for (Node node = current; node != null; node = node.getParent()) {
                    BlockPos blockPos = node.getPos().below();
                    Intrinsics.checkNotNullExpressionValue((Object)blockPos, (String)"below(...)");
                    path.add(blockPos);
                }
                CollectionsKt.reverse((List)path);
                return CollectionsKt.dropLast((List)CollectionsKt.drop((Iterable)path, (int)1), (int)1);
            }
            if (closedSet.contains(current.getPos())) continue;
            closedSet.add(current.getPos());
            for (BlockPos neighbor : TetherEntity.findPathAStar$neighbors(level, this, current.getPos())) {
                if (closedSet.contains(neighbor)) continue;
                int newG = current.getG() + 1;
                Double d = (Double)bestG.get(neighbor);
                if ((double)newG >= (d != null ? d : Double.MAX_VALUE)) continue;
                ((Map)bestG).put(neighbor, Double.valueOf(newG));
                openSet.add(new Node(neighbor, newG, TetherEntity.findPathAStar$heuristic(random, variance, neighbor, end), current));
            }
        }
        return null;
    }

    static /* synthetic */ List findPathAStar$default(TetherEntity tetherEntity, ServerLevel serverLevel, BlockPos blockPos, BlockPos blockPos2, int n, double d, int n2, Object object) {
        if ((n2 & 8) != 0) {
            n = 3000;
        }
        if ((n2 & 0x10) != 0) {
            d = 0.35;
        }
        return tetherEntity.findPathAStar(serverLevel, blockPos, blockPos2, n, d);
    }

    public boolean hurt(@NotNull DamageSource source, float amount) {
        Intrinsics.checkNotNullParameter((Object)source, (String)"source");
        Entity entity = source.getEntity();
        if (Intrinsics.areEqual((Object)(entity != null ? entity.getType() : null), TBSEntities.INTEGRITY_PHASE_2)) {
            return false;
        }
        if (source.is(DamageTypes.IN_WALL)) {
            return false;
        }
        boolean result = super.hurt(source, amount);
        if (result && !this.isDeadOrDying()) {
            this.triggerAnim("hurt_controller", "tetherhurt");
        }
        return result;
    }

    public void die(@NotNull DamageSource damageSource) {
        Intrinsics.checkNotNullParameter((Object)damageSource, (String)"damageSource");
        super.die(damageSource);
        if (this.getLevel() instanceof ServerLevel) {
            Level level = this.getLevel();
            Intrinsics.checkNotNull((Object)level, (String)"null cannot be cast to non-null type net.minecraft.server.level.ServerLevel");
            NecrosisDeconstructTask.INSTANCE.start((ServerLevel)level, this.spawnedPaths);
        }
    }

    public final int getDeathTimer() {
        return this.deathTimer;
    }

    public final void setDeathTimer(int n) {
        this.deathTimer = n;
    }

    protected void tickDeath() {
        int n = this.deathTimer;
        this.deathTimer = n + 1;
        if (this.deathTimer >= 36) {
            this.remove(Entity.RemovalReason.KILLED);
        }
    }

    public final int getSoundCooldown() {
        return this.soundCooldown;
    }

    public final void setSoundCooldown(int n) {
        this.soundCooldown = n;
    }

    public void tick() {
        if (!this.isDeadOrDying()) {
            if (this.soundCooldown <= 0) {
                this.getLevel().playSound(null, this.getBlockPos(), SoundEvents.WARDEN_HEARTBEAT, SoundSource.HOSTILE, 2.0f, 1.0f);
                this.soundCooldown = 24;
            } else {
                int n = this.soundCooldown;
                this.soundCooldown = n + -1;
            }
        }
        super.tick();
    }

    public void baseTick() {
        super.baseTick();
        if (this.getLevel() instanceof ServerLevel && (this.spawnedPaths.isEmpty() || this.spawnedPaths.size() < 3)) {
            RandomSource random = this.getLevel().random;
            BlockPos origin = this.getBlockPos();
            int rootCount = 8 + random.nextInt(5);
            double baseAngleStep = Math.PI * 2 / (double)rootCount;
            for (int i = 0; i < rootCount; ++i) {
                double angle = (double)i * baseAngleStep + (random.nextDouble() - 0.5) * baseAngleStep * 0.5;
                int radius = 8 + random.nextInt(9);
                int targetX = origin.getX() + MathKt.roundToInt((double)(Math.cos(angle) * (double)radius));
                int targetZ = origin.getZ() + MathKt.roundToInt((double)(Math.sin(angle) * (double)radius));
                Level level = this.getLevel();
                Intrinsics.checkNotNull((Object)level, (String)"null cannot be cast to non-null type net.minecraft.server.level.ServerLevel");
                BlockPos targetPos = this.findGround((ServerLevel)level, new BlockPos(targetX, origin.getY() + 4, targetZ));
                Level level2 = this.getLevel();
                Intrinsics.checkNotNull((Object)level2, (String)"null cannot be cast to non-null type net.minecraft.server.level.ServerLevel");
                ServerLevel serverLevel = (ServerLevel)level2;
                BlockPos blockPos = origin.above(4);
                Intrinsics.checkNotNullExpressionValue((Object)blockPos, (String)"above(...)");
                BlockPos startPos = this.findGround(serverLevel, blockPos).above();
                Level level3 = this.getLevel();
                Intrinsics.checkNotNull((Object)level3, (String)"null cannot be cast to non-null type net.minecraft.server.level.ServerLevel");
                ServerLevel serverLevel2 = (ServerLevel)level3;
                Intrinsics.checkNotNull((Object)startPos);
                List path = TetherEntity.findPathAStar$default(this, serverLevel2, startPos, targetPos, 0, 0.0, 24, null);
                if (path != null) {
                    List it;
                    boolean bl = false;
                    this.spawnedPaths.add(it);
                    Iterable $this$forEach$iv = it;
                    boolean $i$f$forEach = false;
                    for (Object element$iv : $this$forEach$iv) {
                        BlockPos pos = (BlockPos)element$iv;
                        boolean bl2 = false;
                        if (!this.getLevel().getBlockState(pos).isCollisionShapeFullBlock((BlockGetter)this.getLevel(), pos)) continue;
                        this.getLevel().setBlock(pos, TBSBlocks.NECROSIS.getDefaultState(), 3);
                    }
                }
            }
        }
    }

    public boolean removeWhenFarAway(double distanceToClosestPlayer) {
        return false;
    }

    public boolean isPushedByFluid() {
        return false;
    }

    public boolean isPushable() {
        return false;
    }

    public final boolean getSpawnAnimPlayed() {
        return this.spawnAnimPlayed;
    }

    public final void setSpawnAnimPlayed(boolean bl) {
        this.spawnAnimPlayed = bl;
    }

    public void registerControllers(@NotNull AnimatableManager.ControllerRegistrar reg) {
        Intrinsics.checkNotNullParameter((Object)reg, (String)"reg");
        reg.add(new AnimationController((GeoAnimatable)this, "main_controller", 0, arg_0 -> TetherEntity.registerControllers$lambda$0(this, arg_0)));
        reg.add(new AnimationController((GeoAnimatable)this, "death_controller", 0, arg_0 -> TetherEntity.registerControllers$lambda$1(this, arg_0)));
        reg.add(new AnimationController((GeoAnimatable)this, "hurt_controller", 0, TetherEntity::registerControllers$lambda$2).triggerableAnim("tetherhurt", RawAnimation.begin().thenPlay("tetherhurt")));
    }

    private static final double findPathAStar$heuristic(RandomSource random, double $variance, BlockPos a, BlockPos b) {
        double base = Math.abs(a.getX() - b.getX()) + Math.abs(a.getY() - b.getY()) + Math.abs(a.getZ() - b.getZ());
        double noise = (random.nextDouble() * (double)2 - 1.0) * $variance * base;
        return RangesKt.coerceAtLeast((double)(base + noise), (double)0.0);
    }

    /*
     * Unable to fully structure code
     */
    private static final boolean findPathAStar$isWalkable(ServerLevel $level, TetherEntity this$0, BlockPos feetPos) {
        block5: {
            floor = $level.getBlockState(feetPos.below());
            feet = $level.getBlockState(feetPos);
            v0 = floorSolid = floor.isAir() == false && floor.canBeReplaced() == false;
            if (feet.isAir()) ** GOTO lbl-1000
            $this$any$iv = this$0.blockAllowList;
            $i$f$any = false;
            if ($this$any$iv instanceof Collection && ((Collection)$this$any$iv).isEmpty()) {
                v1 = false;
            } else {
                for (T element$iv : $this$any$iv) {
                    it = (TagKey)element$iv;
                    $i$a$-any-TetherEntity$findPathAStar$isWalkable$feetClear$1 = false;
                    if (!feet.is(it)) continue;
                    v1 = true;
                    break block5;
                }
                v1 = false;
            }
        }
        if (v1 || feet.canBeReplaced()) lbl-1000:
        // 2 sources

        {
            v2 = true;
        } else {
            v2 = false;
        }
        feetClear = v2;
        return floorSolid != false && feetClear != false;
    }

    private static final List<BlockPos> findPathAStar$neighbors(ServerLevel $level, TetherEntity this$0, BlockPos pos) {
        Object[] objectArray = new BlockPos[]{new BlockPos(1, 0, 0), new BlockPos(-1, 0, 0), new BlockPos(0, 0, 1), new BlockPos(0, 0, -1)};
        List dirs = CollectionsKt.listOf((Object[])objectArray);
        List result = new ArrayList();
        for (BlockPos dir : dirs) {
            BlockPos flat = pos.offset(dir.getX(), 0, dir.getZ());
            Intrinsics.checkNotNull((Object)flat);
            if (TetherEntity.findPathAStar$isWalkable($level, this$0, flat)) {
                result.add(flat);
            }
            BlockPos up = pos.offset(dir.getX(), 1, dir.getZ());
            Intrinsics.checkNotNull((Object)up);
            if (TetherEntity.findPathAStar$isWalkable($level, this$0, up)) {
                result.add(up);
            }
            BlockPos down = pos.offset(dir.getX(), -1, dir.getZ());
            Intrinsics.checkNotNull((Object)down);
            if (!TetherEntity.findPathAStar$isWalkable($level, this$0, down)) continue;
            result.add(down);
        }
        return result;
    }

    private static final PlayState registerControllers$lambda$0(TetherEntity this$0, AnimationState event) {
        if (!this$0.spawnAnimPlayed) {
            this$0.spawnAnimPlayed = true;
            event.getController().setAnimation(RawAnimation.begin().thenPlay("tetherspawn").thenLoop("tetheridle"));
        } else {
            event.getController().setAnimation(RawAnimation.begin().thenLoop("tetheridle"));
        }
        return PlayState.CONTINUE;
    }

    private static final PlayState registerControllers$lambda$1(TetherEntity this$0, AnimationState event) {
        if (this$0.isDeadOrDying()) {
            event.getController().setAnimation(RawAnimation.begin().thenPlayAndHold("tetherdeath"));
            return PlayState.CONTINUE;
        }
        return PlayState.STOP;
    }

    private static final PlayState registerControllers$lambda$2(AnimationState it) {
        return PlayState.STOP;
    }

    public static final /* synthetic */ AttributeSupplier.Builder access$attrs$s910975913(Function1 block) {
        return BaseMonster.attrs((Function1)block);
    }

    static {
        KProperty[] kPropertyArray = new KProperty[]{Reflection.mutableProperty1((MutablePropertyReference1)((MutablePropertyReference1)new MutablePropertyReference1Impl(TetherEntity.class, "floor", "getFloor()I", 0)))};
        $$delegatedProperties = kPropertyArray;
        Companion = new Companion(null);
        EntityDataAccessor entityDataAccessor = SynchedEntityData.defineId(TetherEntity.class, (EntityDataSerializer)EntityDataSerializers.INT);
        Intrinsics.checkNotNullExpressionValue((Object)entityDataAccessor, (String)"defineId(...)");
        FLOOR = entityDataAccessor;
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0006R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2={"Lnet/thebrokenscript/entity/boss/TetherEntity$Companion;", "Lnet/thebrokenscript/brokencore/api/entity/base/BaseMonster$BMC;", "Lnet/thebrokenscript/entity/boss/TetherEntity;", "<init>", "()V", "attributes", "Lnet/minecraft/world/entity/ai/attributes/AttributeSupplier$Builder;", "FLOOR", "Lnet/minecraft/network/syncher/EntityDataAccessor;", "", "getFLOOR", "()Lnet/minecraft/network/syncher/EntityDataAccessor;", "thebrokenscript-common"})
    public static final class Companion
    implements BaseMonster.BMC<TetherEntity> {
        private Companion() {
        }

        @NotNull
        public final AttributeSupplier.Builder attributes() {
            return TetherEntity.access$attrs$s910975913(Companion::attributes$lambda$0);
        }

        @NotNull
        public final EntityDataAccessor<Integer> getFLOOR() {
            return FLOOR;
        }

        private static final Unit attributes$lambda$0(AttributeSupplier.Builder $this$attrs) {
            Intrinsics.checkNotNullParameter((Object)$this$attrs, (String)"$this$attrs");
            AttributeUtil.setMaxHealth((AttributeSupplier.Builder)$this$attrs, (Number)14);
            AttributeUtil.setArmor((AttributeSupplier.Builder)$this$attrs, (Number)0);
            AttributeUtil.setKnockbackResistance((AttributeSupplier.Builder)$this$attrs, (Number)1);
            return Unit.INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

