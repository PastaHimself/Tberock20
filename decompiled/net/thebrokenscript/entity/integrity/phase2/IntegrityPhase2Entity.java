/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.player.LocalPlayer
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Direction
 *  net.minecraft.network.protocol.common.custom.CustomPacketPayload
 *  net.minecraft.network.syncher.SynchedEntityData$Builder
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.world.DifficultyInstance
 *  net.minecraft.world.InteractionHand
 *  net.minecraft.world.damagesource.DamageSource
 *  net.minecraft.world.damagesource.DamageTypes
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.Mob
 *  net.minecraft.world.entity.MobSpawnType
 *  net.minecraft.world.entity.PathfinderMob
 *  net.minecraft.world.entity.SpawnGroupData
 *  net.minecraft.world.entity.ai.attributes.AttributeInstance
 *  net.minecraft.world.entity.ai.attributes.Attributes
 *  net.minecraft.world.entity.ai.goal.Goal
 *  net.minecraft.world.entity.ai.navigation.PathNavigation
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.level.BlockGetter
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.ServerLevelAccessor
 *  net.minecraft.world.level.block.Blocks
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.material.FluidState
 *  net.minecraft.world.level.pathfinder.PathType
 *  net.minecraft.world.phys.AABB
 *  net.minecraft.world.phys.Vec3
 *  net.thebrokenscript.brokencore.api.dsl.ClientDSLKt
 *  net.thebrokenscript.brokencore.api.dsl.EntityUtil
 *  net.thebrokenscript.brokencore.api.dsl.GeckoUtil
 *  net.thebrokenscript.brokencore.api.dsl.SideUtil
 *  net.thebrokenscript.brokencore.api.entity.FinalizedSpawn
 *  net.thebrokenscript.brokencore.api.ext.BoundingBoxExt
 *  net.thebrokenscript.brokencore.api.network.PacketSender
 *  net.thebrokenscript.brokencore.api.platform.CancelProxy
 *  net.thebrokenscript.brokencore.api.util.math.Boxes
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  software.bernie.geckolib.animatable.GeoAnimatable
 *  software.bernie.geckolib.animation.AnimatableManager$ControllerRegistrar
 *  software.bernie.geckolib.animation.AnimationController
 *  software.bernie.geckolib.animation.AnimationProcessor$QueuedAnimation
 *  software.bernie.geckolib.animation.AnimationState
 *  software.bernie.geckolib.animation.PlayState
 *  software.bernie.geckolib.animation.keyframe.event.CustomInstructionKeyframeEvent
 */
package net.thebrokenscript.entity.integrity.phase2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.pathfinder.PathType;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.api.entity.ai.integrity.phase2.Phase2Goals;
import net.thebrokenscript.api.entity.ai.pathfinding.MazeNavigator;
import net.thebrokenscript.api.ext.PlayerExt;
import net.thebrokenscript.brokencore.api.dsl.ClientDSLKt;
import net.thebrokenscript.brokencore.api.dsl.EntityUtil;
import net.thebrokenscript.brokencore.api.dsl.GeckoUtil;
import net.thebrokenscript.brokencore.api.dsl.SideUtil;
import net.thebrokenscript.brokencore.api.entity.FinalizedSpawn;
import net.thebrokenscript.brokencore.api.ext.BoundingBoxExt;
import net.thebrokenscript.brokencore.api.network.PacketSender;
import net.thebrokenscript.brokencore.api.platform.CancelProxy;
import net.thebrokenscript.brokencore.api.util.math.Boxes;
import net.thebrokenscript.client.data.ClientVariables;
import net.thebrokenscript.entity.integrity.IntegrityPhaseEntity;
import net.thebrokenscript.entity.integrity.phase2.IntegrityP2AlwaysTargetPlayerGoal;
import net.thebrokenscript.misc.ForceRuntimeInit;
import net.thebrokenscript.registry.TBSPackets;
import net.thebrokenscript.util.DynamicMazeNavigationGoal;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.animation.AnimationController;
import software.bernie.geckolib.animation.AnimationProcessor;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.animation.PlayState;
import software.bernie.geckolib.animation.keyframe.event.CustomInstructionKeyframeEvent;

@ForceRuntimeInit
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00000\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0006H\u0014J\b\u0010\u000b\u001a\u00020\fH\u0014J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0006\u0010\u0015\u001a\u00020\u000eJ\u0010\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u0018H\u0014J\u0010\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u000eH\u0016J\u0018\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0016J\b\u0010\"\u001a\u00020\fH\u0016J\b\u0010#\u001a\u00020\fH\u0016J\b\u0010$\u001a\u00020\u0014H\u0014J\b\u0010%\u001a\u00020&H\u0016J\u0010\u0010'\u001a\u00020\u000e2\u0006\u0010(\u001a\u00020\u001bH\u0016J\u0010\u0010)\u001a\u00020\f2\u0006\u0010*\u001a\u00020+H\u0016J4\u0010,\u001a\u0004\u0018\u00010-2\u0006\u0010\u0005\u001a\u00020.2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u0002022\b\u00103\u001a\u0004\u0018\u00010-2\u0006\u00104\u001a\u000205H\u0016R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u00066"}, d2={"Lnet/thebrokenscript/entity/integrity/phase2/IntegrityPhase2Entity;", "Lnet/thebrokenscript/entity/integrity/IntegrityPhaseEntity;", "Lnet/thebrokenscript/brokencore/api/entity/FinalizedSpawn;", "entityType", "Lnet/minecraft/world/entity/EntityType;", "level", "Lnet/minecraft/world/level/Level;", "<init>", "(Lnet/minecraft/world/entity/EntityType;Lnet/minecraft/world/level/Level;)V", "createNavigation", "Lnet/minecraft/world/entity/ai/navigation/PathNavigation;", "registerGoals", "", "canStandOnFluid", "", "fluidState", "Lnet/minecraft/world/level/material/FluidState;", "lastStuckCheckPos", "Lnet/minecraft/world/phys/Vec3;", "stuckTicks", "", "isStuck", "defineSynchedData", "builder", "Lnet/minecraft/network/syncher/SynchedEntityData$Builder;", "removeWhenFarAway", "distanceToClosestPlayer", "", "fireImmune", "hurt", "source", "Lnet/minecraft/world/damagesource/DamageSource;", "amount", "", "tick", "baseTick", "getCurrentSwingDuration", "getBoundingBoxForCulling", "Lnet/minecraft/world/phys/AABB;", "shouldRenderAtSqrDistance", "dist", "registerControllers", "reg", "Lsoftware/bernie/geckolib/animation/AnimatableManager$ControllerRegistrar;", "onFinalizeSpawn", "Lnet/minecraft/world/entity/SpawnGroupData;", "Lnet/minecraft/world/level/ServerLevelAccessor;", "difficulty", "Lnet/minecraft/world/DifficultyInstance;", "spawnType", "Lnet/minecraft/world/entity/MobSpawnType;", "spawnData", "event", "Lnet/thebrokenscript/brokencore/api/platform/CancelProxy;", "thebrokenscript-common"})
@SourceDebugExtension(value={"SMAP\nIntegrityPhase2Entity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 IntegrityPhase2Entity.kt\nnet/thebrokenscript/entity/integrity/phase2/IntegrityPhase2Entity\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,181:1\n774#2:182\n865#2,2:183\n*S KotlinDebug\n*F\n+ 1 IntegrityPhase2Entity.kt\nnet/thebrokenscript/entity/integrity/phase2/IntegrityPhase2Entity\n*L\n118#1:182\n118#1:183,2\n*E\n"})
public final class IntegrityPhase2Entity
extends IntegrityPhaseEntity
implements FinalizedSpawn {
    @NotNull
    private Vec3 lastStuckCheckPos;
    private int stuckTicks;

    public IntegrityPhase2Entity(@NotNull EntityType<IntegrityPhase2Entity> entityType, @NotNull Level level) {
        Intrinsics.checkNotNullParameter(entityType, (String)"entityType");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        super(entityType, level);
        this.setPathfindingMalus(PathType.DANGER_POWDER_SNOW, 0.0f);
        this.setPathfindingMalus(PathType.LAVA, 0.0f);
        this.setPathfindingMalus(PathType.FENCE, 0.0f);
        this.setPathfindingMalus(PathType.RAIL, 0.0f);
        this.setPathfindingMalus(PathType.WATER, 8.0f);
        Vec3 vec3 = Vec3.ZERO;
        Intrinsics.checkNotNullExpressionValue((Object)vec3, (String)"ZERO");
        this.lastStuckCheckPos = vec3;
    }

    @NotNull
    protected PathNavigation createNavigation(@NotNull Level level) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        return (PathNavigation)new MazeNavigator((Mob)this, level);
    }

    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(1, (Goal)new Phase2Goals.ContinuousMeleeAttackGoal((PathfinderMob)this, 3.5f, 3.5));
        this.goalSelector.addGoal(2, (Goal)new DynamicMazeNavigationGoal((Mob)this, (Function0<? extends Vec3>)((Function0)() -> IntegrityPhase2Entity.registerGoals$lambda$0(this)), 0.85, true));
        this.targetSelector.addGoal(0, (Goal)new IntegrityP2AlwaysTargetPlayerGoal((Mob)this));
    }

    public boolean canStandOnFluid(@NotNull FluidState fluidState) {
        Intrinsics.checkNotNullParameter((Object)fluidState, (String)"fluidState");
        return !fluidState.isEmpty();
    }

    public final boolean isStuck() {
        return this.stuckTicks > 30;
    }

    protected void defineSynchedData(@NotNull SynchedEntityData.Builder builder) {
        Intrinsics.checkNotNullParameter((Object)builder, (String)"builder");
        super.defineSynchedData(builder);
    }

    public boolean removeWhenFarAway(double distanceToClosestPlayer) {
        return false;
    }

    public boolean fireImmune() {
        return true;
    }

    public boolean hurt(@NotNull DamageSource source, float amount) {
        Intrinsics.checkNotNullParameter((Object)source, (String)"source");
        return Intrinsics.areEqual((Object)source.type(), (Object)DamageTypes.GENERIC_KILL) || Intrinsics.areEqual((Object)source.type(), (Object)DamageTypes.FELL_OUT_OF_WORLD);
    }

    public void tick() {
        super.tick();
        SideUtil.clientSide((Entity)((Entity)this), () -> IntegrityPhase2Entity.tick$lambda$0(this));
    }

    /*
     * WARNING - void declaration
     */
    public void baseTick() {
        super.baseTick();
        if (!(this.getLevel() instanceof ServerLevel)) {
            return;
        }
        if (this.getTarget() != null) {
            if (this.position().distanceToSqr(this.lastStuckCheckPos) < 0.002) {
                int n = this.stuckTicks;
                this.stuckTicks = n + 1;
            } else {
                this.stuckTicks = 0;
            }
            Vec3 vec3 = this.position();
            Intrinsics.checkNotNullExpressionValue((Object)vec3, (String)"position(...)");
            this.lastStuckCheckPos = vec3;
        } else {
            this.stuckTicks = 0;
        }
        if (this.getTarget() != null) {
            void $this$filterTo$iv$iv;
            Direction facing = Direction.fromYRot((double)this.getYRot());
            BlockPos pos = this.blockPosition().relative(facing);
            Intrinsics.checkNotNull((Object)pos);
            Iterable $this$filter$iv = BoundingBoxExt.INSTANCE.getPositions(Boxes.INSTANCE.bounding(pos, (Number)4));
            boolean $i$f$filter = false;
            Iterable iterable = $this$filter$iv;
            Collection destination$iv$iv = new ArrayList();
            boolean $i$f$filterTo = false;
            for (Object element$iv$iv : $this$filterTo$iv$iv) {
                BlockPos it = (BlockPos)element$iv$iv;
                boolean bl = false;
                if (!(it.getY() >= pos.getY())) continue;
                destination$iv$iv.add(element$iv$iv);
            }
            List positions = (List)destination$iv$iv;
            for (BlockPos p : positions) {
                BlockState state = this.level().getBlockState(p);
                if (state.isAir() || !(state.getDestroySpeed((BlockGetter)this.level(), p) >= 0.0f) || state.is(Blocks.MUD) || state.is(Blocks.BARRIER)) continue;
                this.level().destroyBlock(p, false);
                if (this.swinging || !state.entityCanStandOn((BlockGetter)this.getLevel(), p, (Entity)this)) continue;
                this.swing(InteractionHand.MAIN_HAND);
            }
        }
    }

    protected int getCurrentSwingDuration() {
        return 25;
    }

    @NotNull
    public AABB getBoundingBoxForCulling() {
        AABB aABB = super.getBoundingBoxForCulling().inflate(32.0);
        Intrinsics.checkNotNullExpressionValue((Object)aABB, (String)"inflate(...)");
        return aABB;
    }

    public boolean shouldRenderAtSqrDistance(double dist) {
        return true;
    }

    public void registerControllers(@NotNull AnimatableManager.ControllerRegistrar reg) {
        Intrinsics.checkNotNullParameter((Object)reg, (String)"reg");
        reg.add(new AnimationController((GeoAnimatable)this, "main", 0, arg_0 -> IntegrityPhase2Entity.registerControllers$lambda$0(this, arg_0)).setCustomInstructionKeyframeHandler(arg_0 -> IntegrityPhase2Entity.registerControllers$lambda$1(this, arg_0)));
    }

    @Nullable
    public SpawnGroupData onFinalizeSpawn(@NotNull ServerLevelAccessor level, @NotNull DifficultyInstance difficulty, @NotNull MobSpawnType spawnType, @Nullable SpawnGroupData spawnData, @NotNull CancelProxy event) {
        block0: {
            Intrinsics.checkNotNullParameter((Object)level, (String)"level");
            Intrinsics.checkNotNullParameter((Object)difficulty, (String)"difficulty");
            Intrinsics.checkNotNullParameter((Object)spawnType, (String)"spawnType");
            Intrinsics.checkNotNullParameter((Object)event, (String)"event");
            AttributeInstance attributeInstance = this.getAttribute(Attributes.SCALE);
            if (attributeInstance == null) break block0;
            attributeInstance.setBaseValue(0.8);
        }
        return spawnData;
    }

    private static final Vec3 registerGoals$lambda$0(IntegrityPhase2Entity this$0) {
        LivingEntity livingEntity = this$0.getTarget();
        return livingEntity != null ? livingEntity.position() : null;
    }

    private static final Object tick$lambda$0(IntegrityPhase2Entity this$0) {
        if (!ClientVariables.INSTANCE.has(256L)) {
            LocalPlayer localPlayer = ClientDSLKt.getMC().player;
            if (localPlayer == null) {
                return false;
            }
            LocalPlayer player = localPlayer;
            if (PlayerExt.INSTANCE.isEntityInFovCone((Player)player, (Entity)this$0, Double.valueOf(((Number)ClientDSLKt.getMC().options.fov().get()).intValue()))) {
                ClientVariables.INSTANCE.set(256L);
            }
        }
        return Unit.INSTANCE;
    }

    private static final PlayState registerControllers$lambda$0(IntegrityPhase2Entity this$0, AnimationState it) {
        AnimationProcessor.QueuedAnimation queuedAnimation;
        AnimationController ctrl = it.getController();
        AnimationProcessor.QueuedAnimation queuedAnimation2 = ctrl.getCurrentAnimation();
        if ((Intrinsics.areEqual((Object)(queuedAnimation2 != null && (queuedAnimation2 = queuedAnimation2.animation()) != null ? queuedAnimation2.name() : null), (Object)"bitch_slap") || Intrinsics.areEqual((Object)((queuedAnimation = ctrl.getCurrentAnimation()) != null && (queuedAnimation = queuedAnimation.animation()) != null ? queuedAnimation.name() : null), (Object)"bitch_slap")) && ctrl.hasAnimationFinished()) {
            ctrl.forceAnimationReset();
        }
        if (this$0.swinging && this$0.getLevel().canSeeSky(this$0.getBlockPos())) {
            Entity entity = (Entity)this$0;
            Intrinsics.checkNotNull((Object)ctrl);
            GeckoUtil.once((Entity)entity, (AnimationController)ctrl, (String)"bitch_slap");
        } else if (this$0.swinging) {
            Entity entity = (Entity)this$0;
            Intrinsics.checkNotNull((Object)ctrl);
            GeckoUtil.once((Entity)entity, (AnimationController)ctrl, (String)"crawl_slap");
        } else if (this$0.isMoving() && this$0.getLevel().canSeeSky(this$0.getBlockPos())) {
            Entity entity = (Entity)this$0;
            Intrinsics.checkNotNull((Object)ctrl);
            GeckoUtil.loop((Entity)entity, (AnimationController)ctrl, (String)"chase");
        } else if (this$0.isMoving()) {
            Entity entity = (Entity)this$0;
            Intrinsics.checkNotNull((Object)ctrl);
            GeckoUtil.loop((Entity)entity, (AnimationController)ctrl, (String)"crawl_chase");
        } else if (!this$0.isMoving() && this$0.getLevel().canSeeSky(this$0.getBlockPos())) {
            Entity entity = (Entity)this$0;
            Intrinsics.checkNotNull((Object)ctrl);
            GeckoUtil.loop((Entity)entity, (AnimationController)ctrl, (String)"idle");
        } else if (!this$0.isMoving()) {
            Entity entity = (Entity)this$0;
            Intrinsics.checkNotNull((Object)ctrl);
            GeckoUtil.loop((Entity)entity, (AnimationController)ctrl, (String)"crawl_idle");
        }
        return PlayState.CONTINUE;
    }

    private static final void registerControllers$lambda$1(IntegrityPhase2Entity this$0, CustomInstructionKeyframeEvent event) {
        if (EntityUtil.clientTarget((Entity)((Entity)this$0)) != null) {
            LivingEntity livingEntity = EntityUtil.clientTarget((Entity)((Entity)this$0));
            Intrinsics.checkNotNull((Object)livingEntity);
            boolean hasLOS = this$0.hasLineOfSight((Entity)livingEntity);
            if (Intrinsics.areEqual((Object)event.getKeyframeData().getInstructions(), (Object)"hit;") && hasLOS) {
                PacketSender.INSTANCE.sendToServer((CustomPacketPayload)TBSPackets.PHASE2_HIT.of(this$0.getId()), new CustomPacketPayload[0]);
            }
        }
    }
}

