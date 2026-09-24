/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.commands.arguments.EntityAnchorArgument$Anchor
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Holder
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.network.chat.Component
 *  net.minecraft.network.protocol.Packet
 *  net.minecraft.network.protocol.game.ClientboundStopSoundPacket
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.server.level.ServerPlayer
 *  net.minecraft.world.DifficultyInstance
 *  net.minecraft.world.damagesource.DamageSource
 *  net.minecraft.world.damagesource.DamageTypes
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.Mob
 *  net.minecraft.world.entity.MobSpawnType
 *  net.minecraft.world.entity.PathfinderMob
 *  net.minecraft.world.entity.SpawnGroupData
 *  net.minecraft.world.entity.ai.goal.FloatGoal
 *  net.minecraft.world.entity.ai.goal.Goal
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.level.GameType
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.level.ServerLevelAccessor
 *  net.minecraft.world.level.pathfinder.PathType
 *  net.minecraft.world.phys.Vec3
 *  net.thebrokenscript.brokencore.api.client.overlay.OverlayQueue
 *  net.thebrokenscript.brokencore.api.dsl.EntityFinder
 *  net.thebrokenscript.brokencore.api.dsl.EntityUtil
 *  net.thebrokenscript.brokencore.api.dsl.GeckoUtil
 *  net.thebrokenscript.brokencore.api.dsl.LevelUtil
 *  net.thebrokenscript.brokencore.api.dsl.PacketUtil
 *  net.thebrokenscript.brokencore.api.dsl.PlayerUtil
 *  net.thebrokenscript.brokencore.api.dsl.SoundUtil
 *  net.thebrokenscript.brokencore.api.entity.FinalizedSpawn
 *  net.thebrokenscript.brokencore.api.platform.CancelProxy
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  software.bernie.geckolib.animatable.GeoAnimatable
 *  software.bernie.geckolib.animation.AnimatableManager$ControllerRegistrar
 *  software.bernie.geckolib.animation.AnimationController
 *  software.bernie.geckolib.animation.AnimationState
 *  software.bernie.geckolib.animation.PlayState
 */
package net.thebrokenscript.entity.niw;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.commands.arguments.EntityAnchorArgument;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientboundStopSoundPacket;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.pathfinder.PathType;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.api.TBSConstants;
import net.thebrokenscript.api.util.BlockBreakHelper;
import net.thebrokenscript.brokencore.api.client.overlay.OverlayQueue;
import net.thebrokenscript.brokencore.api.dsl.EntityFinder;
import net.thebrokenscript.brokencore.api.dsl.EntityUtil;
import net.thebrokenscript.brokencore.api.dsl.GeckoUtil;
import net.thebrokenscript.brokencore.api.dsl.LevelUtil;
import net.thebrokenscript.brokencore.api.dsl.PacketUtil;
import net.thebrokenscript.brokencore.api.dsl.PlayerUtil;
import net.thebrokenscript.brokencore.api.dsl.SoundUtil;
import net.thebrokenscript.brokencore.api.entity.FinalizedSpawn;
import net.thebrokenscript.brokencore.api.platform.CancelProxy;
import net.thebrokenscript.config.TBSConfigs;
import net.thebrokenscript.entity.niw.NothingIsWatchingEntity;
import net.thebrokenscript.registry.TBSLang;
import net.thebrokenscript.registry.TBSSounds;
import net.thebrokenscript.util.CustomGoals;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.animation.AnimationController;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.animation.PlayState;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 -2\u00020\u00012\u00020\u0002:\u0001-B\u001d\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00000\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0004\b\u0007\u0010\bJ\b\u0010\t\u001a\u00020\nH\u0014J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0018\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0010\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J4\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010\u0005\u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010 2\u0006\u0010'\u001a\u00020(H\u0016J\b\u0010)\u001a\u00020\nH\u0016J\u0010\u0010*\u001a\u00020\n2\u0006\u0010+\u001a\u00020,H\u0016R$\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u00158F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a\u00a8\u0006."}, d2={"Lnet/thebrokenscript/entity/niw/NothingIsWatchingChaseEntity;", "Lnet/thebrokenscript/entity/niw/NothingIsWatchingEntity;", "Lnet/thebrokenscript/brokencore/api/entity/FinalizedSpawn;", "type", "Lnet/minecraft/world/entity/EntityType;", "level", "Lnet/minecraft/world/level/Level;", "<init>", "(Lnet/minecraft/world/entity/EntityType;Lnet/minecraft/world/level/Level;)V", "registerGoals", "", "removeWhenFarAway", "", "distanceToClosestPlayer", "", "hurt", "source", "Lnet/minecraft/world/damagesource/DamageSource;", "amount", "", "value", "", "despawnTimer", "getDespawnTimer", "()I", "setDespawnTimer", "(I)V", "addAdditionalSaveData", "compound", "Lnet/minecraft/nbt/CompoundTag;", "readAdditionalSaveData", "onFinalizeSpawn", "Lnet/minecraft/world/entity/SpawnGroupData;", "Lnet/minecraft/world/level/ServerLevelAccessor;", "difficulty", "Lnet/minecraft/world/DifficultyInstance;", "spawnType", "Lnet/minecraft/world/entity/MobSpawnType;", "spawnData", "event", "Lnet/thebrokenscript/brokencore/api/platform/CancelProxy;", "baseTick", "registerControllers", "reg", "Lsoftware/bernie/geckolib/animation/AnimatableManager$ControllerRegistrar;", "Companion", "thebrokenscript-common"})
@SourceDebugExtension(value={"SMAP\nNothingIsWatchingChaseEntity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NothingIsWatchingChaseEntity.kt\nnet/thebrokenscript/entity/niw/NothingIsWatchingChaseEntity\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,179:1\n774#2:180\n865#2,2:181\n*S KotlinDebug\n*F\n+ 1 NothingIsWatchingChaseEntity.kt\nnet/thebrokenscript/entity/niw/NothingIsWatchingChaseEntity\n*L\n91#1:180\n91#1:181,2\n*E\n"})
public final class NothingIsWatchingChaseEntity
extends NothingIsWatchingEntity
implements FinalizedSpawn {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private static final String NATURAL_DESPAWN = "despawn_timer";

    public NothingIsWatchingChaseEntity(@NotNull EntityType<NothingIsWatchingChaseEntity> type, @NotNull Level level) {
        Intrinsics.checkNotNullParameter(type, (String)"type");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        super(type, level);
        this.xpReward = 0;
        this.setNoAi(false);
        this.setPersistenceRequired();
        this.setPathfindingMalus(PathType.LAVA, 0.0f);
        this.setPathfindingMalus(PathType.FENCE, 0.0f);
        this.setPathfindingMalus(PathType.RAIL, 0.0f);
        this.setPathfindingMalus(PathType.WATER, 0.0f);
        this.setPathfindingMalus(PathType.WATER_BORDER, 0.0f);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(1, (Goal)new CustomGoals.ContinuousMeleeAttackGoal((PathfinderMob)this, 1.45, 0.0f, 0.0, 12, null));
        this.goalSelector.addGoal(2, (Goal)new FloatGoal((Mob)this));
        this.targetSelector.addGoal(1, (Goal)new CustomGoals.AlwaysTargetPlayerGoal((Mob)this, 800));
    }

    public boolean removeWhenFarAway(double distanceToClosestPlayer) {
        return false;
    }

    @Override
    public boolean hurt(@NotNull DamageSource source, float amount) {
        Intrinsics.checkNotNullParameter((Object)source, (String)"source");
        return Intrinsics.areEqual((Object)source.type(), (Object)DamageTypes.GENERIC_KILL) || Intrinsics.areEqual((Object)source.type(), (Object)DamageTypes.FELL_OUT_OF_WORLD);
    }

    public final int getDespawnTimer() {
        return EntityUtil.getPersistentData((Entity)((Entity)this)).getInt(NATURAL_DESPAWN);
    }

    public final void setDespawnTimer(int value) {
        EntityUtil.getPersistentData((Entity)((Entity)this)).putInt(NATURAL_DESPAWN, value);
    }

    @Override
    public void addAdditionalSaveData(@NotNull CompoundTag compound) {
        Intrinsics.checkNotNullParameter((Object)compound, (String)"compound");
        super.addAdditionalSaveData(compound);
        compound.putInt(NATURAL_DESPAWN, this.getDespawnTimer());
    }

    @Override
    public void readAdditionalSaveData(@NotNull CompoundTag compound) {
        Intrinsics.checkNotNullParameter((Object)compound, (String)"compound");
        super.readAdditionalSaveData(compound);
        compound.getInt(NATURAL_DESPAWN);
    }

    @Override
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
        SoundUtil.tryBroadcastSoundInRange$default((LevelAccessor)((LevelAccessor)level), (Vec3)this.getPos(), (Number)100, (Holder)((Holder)TBSSounds.SILUET_CHASE), (float)10.0f, (float)0.0f, null, (int)48, null);
        this.setDespawnTimer(800);
        return null;
    }

    @Override
    public void baseTick() {
        this.onServerTick(arg_0 -> NothingIsWatchingChaseEntity.baseTick$lambda$0(this, arg_0));
    }

    @Override
    public void registerControllers(@NotNull AnimatableManager.ControllerRegistrar reg) {
        Intrinsics.checkNotNullParameter((Object)reg, (String)"reg");
        reg.add(new AnimationController((GeoAnimatable)this, "niw_chase", 0, arg_0 -> NothingIsWatchingChaseEntity.registerControllers$lambda$0(this, arg_0)));
    }

    /*
     * WARNING - void declaration
     */
    private static final Unit baseTick$lambda$0(NothingIsWatchingChaseEntity this$0, ServerLevel level) {
        LivingEntity target;
        LivingEntity currentTarget;
        void $this$filterTo$iv$iv;
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Iterable $this$filter$iv = EntityFinder.findPlayersInRange((ServerLevel)level, (Vec3)this$0.getPos(), (Number)500);
        boolean $i$f$filter = false;
        Iterable iterable = $this$filter$iv;
        Collection destination$iv$iv = new ArrayList();
        boolean $i$f$filterTo = false;
        for (Object element$iv$iv : $this$filterTo$iv$iv) {
            ServerPlayer it = (ServerPlayer)element$iv$iv;
            boolean bl = false;
            if (!it.hasLineOfSight((Entity)this$0)) continue;
            destination$iv$iv.add(element$iv$iv);
        }
        List players = (List)destination$iv$iv;
        ServerPlayer player = (ServerPlayer)EntityUtil.closest((List)players, (Vec3)this$0.getPos());
        if (player != null && player.gameMode.getGameModeForPlayer() != GameType.SURVIVAL) {
            player.setGameMode(GameType.SURVIVAL);
        }
        if (player != null && PlayerUtil.isLookingAt((Player)((Player)player), (Entity)((Entity)this$0)) && (currentTarget = this$0.getTarget()) != null && this$0.isCloserThan((Entity)player, (Entity)currentTarget)) {
            this$0.setTarget((LivingEntity)player);
        }
        if ((target = this$0.getTarget()) instanceof ServerPlayer) {
            ((ServerPlayer)target).lookAt(EntityAnchorArgument.Anchor.EYES, this$0.getPos().add(0.0, (double)this$0.getEyeHeight(), 0.0));
            if (this$0.isWithin((Entity)target, 5)) {
                ((ServerPlayer)target).kill();
                this$0.discard();
                PlayerUtil.stopAllSounds((Player)((Player)target));
                PlayerUtil.sendSound$default((ServerPlayer)((ServerPlayer)target), (Holder)((Holder)TBSSounds.SILUET_CHASE), (float)10.0f, (float)0.0f, null, null, (long)0L, (int)60, null);
                LevelUtil.getQueue((Level)((Level)level)).add(5L, () -> NothingIsWatchingChaseEntity.baseTick$lambda$0$1(target));
            }
            if (this$0.random.nextDouble() < 1.0E-4 && this$0.isWithin((Entity)target, 500)) {
                Vec3 newPos = ((ServerPlayer)target).position().add((double)this$0.random.nextInt(2, 3), 5.0, 0.0);
                this$0.teleportTo(newPos.x, newPos.y, newPos.z);
            }
            if ((double)this$0.random.nextFloat() < 0.1 && this$0.isWithin((Entity)target, 100)) {
                OverlayQueue queue = new OverlayQueue();
                queue.add(1L, TBSConstants.id("textures/screens/blick.png"), 10L);
                queue.add(5L, TBSConstants.id("textures/screens/frame2.png"), 10L);
                queue.add(5L, TBSConstants.id("textures/screens/frame3.png"), 10L);
                queue.add(5L, TBSConstants.id("textures/screens/frame4.png"), 10L);
                queue.add(5L, TBSConstants.id("textures/screens/frame5.png"), 10L);
                ServerPlayer[] serverPlayerArray = new ServerPlayer[]{target};
                queue.send(serverPlayerArray);
                LevelUtil.getQueue((Level)((Level)level)).add(queue.getTotalTime() + 1L, () -> NothingIsWatchingChaseEntity.baseTick$lambda$0$2(this$0, queue, target));
            }
        }
        int yo = this$0.random.nextInt(1, 5);
        if (!TBSConfigs.INSTANCE.getServer().getDisableBlockBreaking()) {
            LevelAccessor levelAccessor = (LevelAccessor)level;
            BlockPos blockPos = this$0.getBlockPos().offset(1, yo, 0);
            Intrinsics.checkNotNullExpressionValue((Object)blockPos, (String)"offset(...)");
            BlockBreakHelper.INSTANCE.tryBreakNIW(levelAccessor, blockPos);
            LevelAccessor levelAccessor2 = (LevelAccessor)level;
            BlockPos blockPos2 = this$0.getBlockPos().offset(-1, yo, 0);
            Intrinsics.checkNotNullExpressionValue((Object)blockPos2, (String)"offset(...)");
            BlockBreakHelper.INSTANCE.tryBreakNIW(levelAccessor2, blockPos2);
            LevelAccessor levelAccessor3 = (LevelAccessor)level;
            BlockPos blockPos3 = this$0.getBlockPos().offset(0, yo, -1);
            Intrinsics.checkNotNullExpressionValue((Object)blockPos3, (String)"offset(...)");
            BlockBreakHelper.INSTANCE.tryBreakNIW(levelAccessor3, blockPos3);
            LevelAccessor levelAccessor4 = (LevelAccessor)level;
            BlockPos blockPos4 = this$0.getBlockPos().offset(0, yo, 1);
            Intrinsics.checkNotNullExpressionValue((Object)blockPos4, (String)"offset(...)");
            BlockBreakHelper.INSTANCE.tryBreakNIW(levelAccessor4, blockPos4);
            LevelAccessor levelAccessor5 = (LevelAccessor)level;
            BlockPos blockPos5 = this$0.getBlockPos().offset(0, yo - 1, 0);
            Intrinsics.checkNotNullExpressionValue((Object)blockPos5, (String)"offset(...)");
            BlockBreakHelper.INSTANCE.tryBreakNIW(levelAccessor5, blockPos5);
        }
        this$0.refreshDimensions();
        int n = this$0.getDespawnTimer();
        this$0.setDespawnTimer(n + -1);
        if (this$0.getDespawnTimer() <= 0) {
            PacketUtil.tryBroadcastPacket((LevelAccessor)((LevelAccessor)level), (Packet)((Packet)new ClientboundStopSoundPacket(null, null)));
            this$0.discard();
        }
        return Unit.INSTANCE;
    }

    private static final Unit baseTick$lambda$0$1(LivingEntity $target) {
        PlayerUtil.kick((ServerPlayer)((ServerPlayer)$target), (Component)((Component)TBSLang.INSTANCE.getNIW_KICK()));
        return Unit.INSTANCE;
    }

    private static final Unit baseTick$lambda$0$2(NothingIsWatchingChaseEntity this$0, OverlayQueue $queue, LivingEntity $target) {
        if (this$0.isAlive() && this$0.isAggressive()) {
            ServerPlayer[] serverPlayerArray = new ServerPlayer[]{$target};
            $queue.send(serverPlayerArray);
        }
        return Unit.INSTANCE;
    }

    private static final PlayState registerControllers$lambda$0(NothingIsWatchingChaseEntity this$0, AnimationState it) {
        Entity entity = (Entity)this$0;
        AnimationController animationController = it.getController();
        Intrinsics.checkNotNullExpressionValue((Object)animationController, (String)"getController(...)");
        GeckoUtil.loop((Entity)entity, (AnimationController)animationController, (String)"new");
        return PlayState.CONTINUE;
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2={"Lnet/thebrokenscript/entity/niw/NothingIsWatchingChaseEntity$Companion;", "", "<init>", "()V", "NATURAL_DESPAWN", "", "thebrokenscript-common"})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

