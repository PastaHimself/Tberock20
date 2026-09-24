/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.NoWhenBranchMatchedException
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.ranges.RangesKt
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Direction
 *  net.minecraft.core.Direction$Plane
 *  net.minecraft.core.Position
 *  net.minecraft.core.Vec3i
 *  net.minecraft.server.level.ServerPlayer
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.Mob
 *  net.minecraft.world.entity.ai.goal.target.TargetGoal
 *  net.minecraft.world.entity.ai.targeting.TargetingConditions
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.level.BlockGetter
 *  net.minecraft.world.level.ClipContext
 *  net.minecraft.world.level.ClipContext$Block
 *  net.minecraft.world.level.ClipContext$Fluid
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.level.pathfinder.Path
 *  net.minecraft.world.phys.BlockHitResult
 *  net.minecraft.world.phys.HitResult$Type
 *  net.minecraft.world.phys.Vec3
 *  net.thebrokenscript.brokencore.api.entity.base.BaseMonster
 *  net.thebrokenscript.brokencore.api.ext.BaseMonsterExtKt
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.api.entity.ai.circuit;

import java.util.Collection;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Position;
import net.minecraft.core.Vec3i;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.target.TargetGoal;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.pathfinder.Path;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.brokencore.api.entity.base.BaseMonster;
import net.thebrokenscript.brokencore.api.ext.BaseMonsterExtKt;
import net.thebrokenscript.entity.circuit.ChaseState;
import net.thebrokenscript.entity.circuit.CircuitEntity;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\b\u0012\b\b\u0002\u0010\f\u001a\u00020\u0005\u00a2\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0019\u001a\u00020\bH\u0016J\b\u0010\u001c\u001a\u00020\bH\u0016J\b\u0010\u001d\u001a\u00020\u001eH\u0016J\b\u0010\u001f\u001a\u00020\bH\u0016J\b\u0010 \u001a\u00020\u001eH\u0016J\u0010\u0010!\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\u0010H\u0002J\u0010\u0010#\u001a\u00020\u001e2\u0006\u0010$\u001a\u00020\u0012H\u0002J\b\u0010%\u001a\u00020\bH\u0002J\u0010\u0010(\u001a\u00020\u001e2\u0006\u0010$\u001a\u00020\u0012H\u0002J$\u0010)\u001a\u0004\u0018\u00010'2\u0006\u0010*\u001a\u00020\u00032\u0006\u0010$\u001a\u00020\u00122\b\b\u0002\u0010+\u001a\u00020\u0005H\u0002J\u001a\u0010,\u001a\u0004\u0018\u00010'2\u0006\u0010*\u001a\u00020\u00032\u0006\u0010-\u001a\u00020'H\u0002J\u0018\u0010.\u001a\u00020\b2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020'H\u0002J*\u00102\u001a\u0004\u0018\u00010'2\u0006\u0010/\u001a\u0002002\u0006\u0010-\u001a\u00020'2\u0006\u0010$\u001a\u00020\u00122\u0006\u0010+\u001a\u00020\u0005H\u0002J \u00103\u001a\u00020\u00052\u0006\u0010/\u001a\u0002002\u0006\u00104\u001a\u00020'2\u0006\u00105\u001a\u00020\u0005H\u0002J\b\u00106\u001a\u00020\u001eH\u0016J\b\u00107\u001a\u00020\u001eH\u0002J\n\u00108\u001a\u0004\u0018\u00010\u0010H\u0002J\u0010\u00109\u001a\u00020\u001e2\u0006\u0010:\u001a\u00020\u0010H\u0002J\u0010\u0010;\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\u0010H\u0002J\u0010\u0010<\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020\u0010H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0005X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0005X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006="}, d2={"Lnet/thebrokenscript/api/entity/ai/circuit/CircuitChaseGoal;", "Lnet/minecraft/world/entity/ai/goal/target/TargetGoal;", "circuitMob", "Lnet/thebrokenscript/entity/circuit/CircuitEntity;", "chasePersistenceTicks", "", "hasSeenPlayerProvider", "Lkotlin/Function0;", "", "detectionRange", "", "allowTargetSwitching", "maxTicksWithoutLOS", "<init>", "(Lnet/thebrokenscript/entity/circuit/CircuitEntity;ILkotlin/jvm/functions/Function0;DZI)V", "targetPlayer", "Lnet/minecraft/server/level/ServerPlayer;", "lastKnownPos", "Lnet/minecraft/world/phys/Vec3;", "ticksSinceLostLOS", "lastPathUpdate", "lastTargetCheck", "isCommittedToClimb", "pathCooldownTicks", "targetCheckCooldownTicks", "requiresUpdateEveryTick", "targetingConditions", "Lnet/minecraft/world/entity/ai/targeting/TargetingConditions;", "canUse", "start", "", "canContinueToUse", "tick", "tryDirectChase", "player", "maybeUpdatePath", "targetPos", "hasLOS", "cachedWallPos", "Lnet/minecraft/core/BlockPos;", "seekClimb", "findClimbableWall", "mob", "searchRadius", "raytraceForWall", "searchPoint", "isClimbableWallAt", "level", "Lnet/minecraft/world/level/LevelAccessor;", "pos", "searchAroundPoint", "findWallTopY", "basePos", "maxScan", "stop", "resetState", "findClosestValidPlayer", "switchTarget", "newTarget", "shouldFallTowardsPlayer", "fallTowardsPlayer", "thebrokenscript-common"})
@SourceDebugExtension(value={"SMAP\nCircuitChaseGoal.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CircuitChaseGoal.kt\nnet/thebrokenscript/api/entity/ai/circuit/CircuitChaseGoal\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,439:1\n1761#2,3:440\n1#3:443\n*S KotlinDebug\n*F\n+ 1 CircuitChaseGoal.kt\nnet/thebrokenscript/api/entity/ai/circuit/CircuitChaseGoal\n*L\n288#1:440,3\n*E\n"})
public final class CircuitChaseGoal
extends TargetGoal {
    @NotNull
    private final CircuitEntity circuitMob;
    private final int chasePersistenceTicks;
    @NotNull
    private final Function0<Boolean> hasSeenPlayerProvider;
    private final double detectionRange;
    private final boolean allowTargetSwitching;
    private final int maxTicksWithoutLOS;
    @Nullable
    private ServerPlayer targetPlayer;
    @Nullable
    private Vec3 lastKnownPos;
    private int ticksSinceLostLOS;
    private int lastPathUpdate;
    private int lastTargetCheck;
    private boolean isCommittedToClimb;
    private final int pathCooldownTicks;
    private final int targetCheckCooldownTicks;
    @NotNull
    private final TargetingConditions targetingConditions;
    @Nullable
    private BlockPos cachedWallPos;

    public CircuitChaseGoal(@NotNull CircuitEntity circuitMob, int chasePersistenceTicks, @NotNull Function0<Boolean> hasSeenPlayerProvider, double detectionRange, boolean allowTargetSwitching, int maxTicksWithoutLOS) {
        Intrinsics.checkNotNullParameter((Object)((Object)circuitMob), (String)"circuitMob");
        Intrinsics.checkNotNullParameter(hasSeenPlayerProvider, (String)"hasSeenPlayerProvider");
        super((Mob)circuitMob, false);
        this.circuitMob = circuitMob;
        this.chasePersistenceTicks = chasePersistenceTicks;
        this.hasSeenPlayerProvider = hasSeenPlayerProvider;
        this.detectionRange = detectionRange;
        this.allowTargetSwitching = allowTargetSwitching;
        this.maxTicksWithoutLOS = maxTicksWithoutLOS;
        this.pathCooldownTicks = 6;
        this.targetCheckCooldownTicks = 40;
        TargetingConditions targetingConditions = TargetingConditions.forNonCombat().ignoreInvisibilityTesting().ignoreLineOfSight();
        Intrinsics.checkNotNullExpressionValue((Object)targetingConditions, (String)"ignoreLineOfSight(...)");
        this.targetingConditions = targetingConditions;
    }

    public /* synthetic */ CircuitChaseGoal(CircuitEntity circuitEntity, int n, Function0 function0, double d, boolean bl, int n2, int n3, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n3 & 8) != 0) {
            d = 64.0;
        }
        if ((n3 & 0x10) != 0) {
            bl = true;
        }
        if ((n3 & 0x20) != 0) {
            n2 = 120;
        }
        this(circuitEntity, n, (Function0<Boolean>)function0, d, bl, n2);
    }

    public boolean requiresUpdateEveryTick() {
        return true;
    }

    public boolean canUse() {
        ServerPlayer nearby;
        if (this.targetPlayer != null && this.circuitMob.getTicksSinceLastSeen() < this.chasePersistenceTicks) {
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
            Mob mob = this.mob;
            Intrinsics.checkNotNull((Object)mob, (String)"null cannot be cast to non-null type net.thebrokenscript.brokencore.api.entity.base.BaseMonster");
            if (BaseMonsterExtKt.hasLineOfSightThroughTransparent((BaseMonster)((BaseMonster)mob), (Player)((Player)it))) {
                this.circuitMob.updateLastSeenTick();
                this.circuitMob.updatePlayerTracking(it);
                this.lastKnownPos = it.position();
            }
        }
        this.ticksSinceLostLOS = 0;
        this.lastPathUpdate = 0;
        this.lastTargetCheck = 0;
        this.isCommittedToClimb = false;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
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
        Mob mob = this.mob;
        Intrinsics.checkNotNull((Object)mob, (String)"null cannot be cast to non-null type net.thebrokenscript.entity.circuit.CircuitEntity");
        boolean isClimbing = ((CircuitEntity)mob).getClimbing();
        if (isClimbing && this.isCommittedToClimb && player.getY() < this.mob.getY()) {
            this.resetState();
            return false;
        }
        int ticksSinceSeen = this.circuitMob.getTicksSinceLastSeen();
        if (this.ticksSinceLostLOS > this.maxTicksWithoutLOS && ticksSinceSeen >= this.chasePersistenceTicks) {
            if (!this.isCommittedToClimb) return false;
        }
        Mob mob2 = this.mob;
        Intrinsics.checkNotNull((Object)mob2, (String)"null cannot be cast to non-null type net.thebrokenscript.brokencore.api.entity.base.BaseMonster");
        if (BaseMonsterExtKt.hasLineOfSightThroughTransparent((BaseMonster)((BaseMonster)mob2), (Player)((Player)player))) return true;
        if (ticksSinceSeen < this.chasePersistenceTicks) return true;
        if (!this.isCommittedToClimb) return false;
        return true;
    }

    /*
     * Unable to fully structure code
     */
    public void tick() {
        v0 = this.targetPlayer;
        if (v0 == null) {
            return;
        }
        player = v0;
        if (this.mob.isNoAi()) {
            return;
        }
        if (player.isRemoved() || !player.isAlive() || player.isSpectator()) {
            this.resetState();
            return;
        }
        v1 = this.mob;
        Intrinsics.checkNotNull((Object)v1, (String)"null cannot be cast to non-null type net.thebrokenscript.entity.circuit.CircuitEntity");
        circuitMob = (CircuitEntity)v1;
        isClimbing = circuitMob.getClimbing();
        v2 = isSeekingClimb = circuitMob.getChaseState$thebrokenscript_common() == ChaseState.SEEKING_CLIMB;
        if (isClimbing && !this.isCommittedToClimb) {
            this.isCommittedToClimb = true;
        }
        if (!isClimbing && this.isCommittedToClimb && player.getY() <= this.mob.getY() + (double)true) {
            this.isCommittedToClimb = false;
        }
        if (this.allowTargetSwitching && this.mob.tickCount - this.lastTargetCheck >= this.targetCheckCooldownTicks && !isClimbing && !this.isCommittedToClimb && !isSeekingClimb) {
            this.lastTargetCheck = this.mob.tickCount;
            closerPlayer = this.findClosestValidPlayer();
            if (closerPlayer != null && !Intrinsics.areEqual((Object)closerPlayer, (Object)player)) {
                currentDist = this.mob.distanceToSqr((Entity)player);
                closerDist = this.mob.distanceToSqr((Entity)closerPlayer);
                if (closerDist < currentDist * 0.75) {
                    this.switchTarget(closerPlayer);
                    return;
                }
            }
        }
        if (this.mob.hasLineOfSight((Entity)player)) ** GOTO lbl-1000
        v3 = this.mob;
        Intrinsics.checkNotNull((Object)v3, (String)"null cannot be cast to non-null type net.thebrokenscript.brokencore.api.entity.base.BaseMonster");
        if (BaseMonsterExtKt.hasLineOfSightThroughTransparent((BaseMonster)((BaseMonster)v3), (Player)((Player)player))) lbl-1000:
        // 2 sources

        {
            v4 = true;
        } else {
            v4 = hasLOS = false;
        }
        if (hasLOS) {
            this.circuitMob.updateLastSeenTick();
            this.circuitMob.updatePlayerTracking(player);
            this.lastKnownPos = player.position();
            this.ticksSinceLostLOS = 0;
            if (this.shouldFallTowardsPlayer(player)) {
                this.fallTowardsPlayer(player);
                return;
            }
            if (!isSeekingClimb) {
                v5 = this.mob;
                Intrinsics.checkNotNull((Object)v5, (String)"null cannot be cast to non-null type net.thebrokenscript.entity.circuit.CircuitEntity");
                if (!((CircuitEntity)v5).getClimbing() && this.tryDirectChase(player)) {
                    return;
                }
            }
            v6 = player.position();
            Intrinsics.checkNotNullExpressionValue((Object)v6, (String)"position(...)");
            this.maybeUpdatePath(v6);
            return;
        }
        if (!(isClimbing || this.isCommittedToClimb || isSeekingClimb)) {
            currentDist = this.ticksSinceLostLOS;
            this.ticksSinceLostLOS = currentDist + 1;
        }
        if ((ticksSinceSeen = this.circuitMob.getTicksSinceLastSeen()) < this.chasePersistenceTicks || this.isCommittedToClimb || isSeekingClimb) {
            v7 = this.circuitMob.getPredictedPosition(ticksSinceSeen);
            if (v7 == null && (v7 = this.lastKnownPos) == null) {
                v7 = player.position();
            }
            predicted = v7;
            Intrinsics.checkNotNull((Object)predicted);
            this.maybeUpdatePath(predicted);
        } else {
            this.resetState();
        }
    }

    private final boolean tryDirectChase(ServerPlayer player) {
        if (!this.mob.getBoundingBox().inflate(10.0, 4.0, 10.0).intersects(player.getBoundingBox())) {
            return false;
        }
        if (!this.mob.hasLineOfSight((Entity)player)) {
            return false;
        }
        if (this.mob.getNavigation().getPath() != null) {
            this.mob.getNavigation().stop();
        }
        this.mob.getMoveControl().setWantedPosition(player.getX(), player.getY(), player.getZ(), 1.25);
        return true;
    }

    /*
     * Unable to fully structure code
     */
    private final void maybeUpdatePath(Vec3 targetPos) {
        v0 = this.mob;
        Intrinsics.checkNotNull((Object)v0, (String)"null cannot be cast to non-null type net.thebrokenscript.entity.circuit.CircuitEntity");
        mob = (CircuitEntity)v0;
        if (mob.getChaseState$thebrokenscript_common() != ChaseState.SEEKING_CLIMB || this.cachedWallPos == null) ** GOTO lbl-1000
        $this$maybeUpdatePath_u24lambda_u240 = this;
        $i$a$-run-CircuitChaseGoal$maybeUpdatePath$isFinalPush$1 = false;
        v1 = mob.getX();
        v2 = $this$maybeUpdatePath_u24lambda_u240.cachedWallPos;
        Intrinsics.checkNotNull((Object)v2);
        dx = v1 - ((double)v2.getX() + 0.5);
        v3 = mob.getZ();
        v4 = $this$maybeUpdatePath_u24lambda_u240.cachedWallPos;
        Intrinsics.checkNotNull((Object)v4);
        dz = v3 - ((double)v4.getZ() + 0.5);
        v5 = dx * dx + dz * dz <= 2.25;
        if (v5) {
            v6 = true;
        } else lbl-1000:
        // 2 sources

        {
            v6 = isFinalPush = false;
        }
        if (!(isFinalPush || mob.getClimbing() || mob.getNavigation().isDone() || mob.getNavigation().isStuck() || mob.tickCount - this.lastPathUpdate >= this.pathCooldownTicks)) {
            return;
        }
        this.lastPathUpdate = mob.tickCount;
        entityBox = mob.getBoundingBox().inflate(2.0, 0.0, 2.0).inflate(0.0, -mob.position().y, 0.0);
        playerInside = entityBox.contains(targetPos);
        v7 = playerInWater = mob.level().getFluidState(BlockPos.containing((Position)((Position)targetPos))).isEmpty() == false;
        if (playerInside && playerInWater) {
            return;
        }
        if (this.targetPlayer != null) {
            path = this.hasLOS() != false ? mob.getNavigation().createPath((Entity)this.targetPlayer, 1) : mob.getNavigation().createPath(BlockPos.containing((Position)((Position)targetPos)), 1);
            heightDiff = targetPos.y - mob.getY();
            wantsClimb = this.isCommittedToClimb || mob.getClimbing() ? heightDiff > -1.0 : heightDiff > 3.0 && (path == null || path.canReach() == false);
            mob.setChaseState$thebrokenscript_common(wantsClimb != false ? ChaseState.SEEKING_CLIMB : ChaseState.NORMAL);
            if (!wantsClimb) {
                this.cachedWallPos = null;
            }
            switch (WhenMappings.$EnumSwitchMapping$0[mob.getChaseState$thebrokenscript_common().ordinal()]) {
                case 1: {
                    this.seekClimb(targetPos);
                    break;
                }
                case 2: {
                    mob.getNavigation().moveTo(path, 1.2);
                    break;
                }
                default: {
                    throw new NoWhenBranchMatchedException();
                }
            }
        }
    }

    private final boolean hasLOS() {
        ServerPlayer serverPlayer = this.targetPlayer;
        if (serverPlayer == null) {
            return false;
        }
        ServerPlayer player = serverPlayer;
        Mob mob = this.mob;
        Intrinsics.checkNotNull((Object)mob, (String)"null cannot be cast to non-null type net.thebrokenscript.brokencore.api.entity.base.BaseMonster");
        return BaseMonsterExtKt.hasLineOfSightThroughTransparent((BaseMonster)((BaseMonster)mob), (Player)((Player)player));
    }

    private final void seekClimb(Vec3 targetPos) {
        BlockPos blockPos;
        boolean stillValid;
        Mob mob = this.mob;
        Intrinsics.checkNotNull((Object)mob, (String)"null cannot be cast to non-null type net.thebrokenscript.entity.circuit.CircuitEntity");
        CircuitEntity mob2 = (CircuitEntity)mob;
        BlockPos blockPos2 = this.cachedWallPos;
        if (blockPos2 != null) {
            double dz;
            BlockPos pos = blockPos2;
            boolean bl = false;
            double dx = mob2.getX() - ((double)pos.getX() + 0.5);
            v2 = dx * dx + (dz = mob2.getZ() - ((double)pos.getZ() + 0.5)) * dz <= 100.0;
        } else {
            v2 = stillValid = false;
        }
        if (stillValid) {
            BlockPos blockPos3 = this.cachedWallPos;
            blockPos = blockPos3;
            Intrinsics.checkNotNull((Object)blockPos3);
        } else {
            BlockPos found;
            this.cachedWallPos = found = CircuitChaseGoal.findClimbableWall$default(this, mob2, targetPos, 0, 4, null);
            blockPos = found;
        }
        if (blockPos == null) {
            CircuitChaseGoal $this$seekClimb_u24lambda_u241 = this;
            boolean bl = false;
            mob2.getNavigation().stop();
            mob2.getMoveControl().setWantedPosition(targetPos.x, targetPos.y, targetPos.z, 1.25);
            return;
        }
        BlockPos wallPos = blockPos;
        Path wallPath = mob2.getNavigation().createPath(wallPos, 0);
        if (wallPath != null) {
            mob2.getNavigation().moveTo(wallPath, 1.25);
        } else {
            mob2.getNavigation().stop();
            mob2.getMoveControl().setWantedPosition((double)wallPos.getX() + 0.5, targetPos.y, (double)wallPos.getZ() + 0.5, 1.25);
        }
    }

    private final BlockPos findClimbableWall(CircuitEntity mob, Vec3 targetPos, int searchRadius) {
        Level level = mob.level();
        BlockPos origin = mob.blockPosition();
        BlockPos searchPoint = new BlockPos((int)targetPos.x, origin.getY(), (int)targetPos.z);
        BlockPos rayHit = this.raytraceForWall(mob, searchPoint);
        if (rayHit != null) {
            return rayHit;
        }
        Intrinsics.checkNotNull((Object)level);
        return this.searchAroundPoint((LevelAccessor)level, searchPoint, targetPos, searchRadius);
    }

    static /* synthetic */ BlockPos findClimbableWall$default(CircuitChaseGoal circuitChaseGoal, CircuitEntity circuitEntity, Vec3 vec3, int n, int n2, Object object) {
        if ((n2 & 4) != 0) {
            n = 8;
        }
        return circuitChaseGoal.findClimbableWall(circuitEntity, vec3, n);
    }

    private final BlockPos raytraceForWall(CircuitEntity mob, BlockPos searchPoint) {
        Vec3 end;
        Vec3 start;
        ClipContext clipContext;
        Level level = mob.level();
        BlockHitResult hitResult = level.clip(clipContext = new ClipContext(start = new Vec3(mob.getX(), mob.getY() + (double)mob.getEyeHeight(), mob.getZ()), end = new Vec3((double)searchPoint.getX() + 0.5, mob.getY() + (double)mob.getEyeHeight(), (double)searchPoint.getZ() + 0.5), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, (Entity)mob));
        if (hitResult.getType() != HitResult.Type.BLOCK) {
            return null;
        }
        BlockPos hitBlockPos = hitResult.getBlockPos();
        BlockPos wallPos = new BlockPos(hitBlockPos.getX(), mob.blockPosition().getY(), hitBlockPos.getZ());
        Intrinsics.checkNotNull((Object)level);
        if (!this.isClimbableWallAt((LevelAccessor)level, wallPos)) {
            return null;
        }
        return wallPos;
    }

    private final boolean isClimbableWallAt(LevelAccessor level, BlockPos pos) {
        boolean bl;
        block6: {
            if (level.getBlockState(pos).isAir()) {
                return false;
            }
            if (level.getBlockState(pos.above()).isAir()) {
                return false;
            }
            if (level.getBlockState(pos.above(2)).isAir()) {
                return false;
            }
            Iterable $this$any$iv = (Iterable)Direction.Plane.HORIZONTAL;
            boolean $i$f$any = false;
            if ($this$any$iv instanceof Collection && ((Collection)$this$any$iv).isEmpty()) {
                bl = false;
            } else {
                for (Object element$iv : $this$any$iv) {
                    Direction dir = (Direction)element$iv;
                    boolean bl2 = false;
                    BlockPos neighbor = pos.relative(dir);
                    if (!(level.getBlockState(neighbor).isAir() && level.getBlockState(neighbor.above()).isAir())) continue;
                    bl = true;
                    break block6;
                }
                bl = false;
            }
        }
        return bl;
    }

    private final BlockPos searchAroundPoint(LevelAccessor level, BlockPos searchPoint, Vec3 targetPos, int searchRadius) {
        BlockPos targetBlockPos = BlockPos.containing((Position)((Position)targetPos));
        BlockPos best = null;
        double bestScore = Double.MAX_VALUE;
        int x = -searchRadius;
        if (x <= searchRadius) {
            while (true) {
                int z;
                if ((z = -searchRadius) <= searchRadius) {
                    while (true) {
                        double heightScore;
                        double distToTargetSq;
                        double distToPointSq;
                        double score;
                        int maxScan;
                        int wallTopY;
                        BlockPos pos = searchPoint.offset(x, 0, z);
                        Intrinsics.checkNotNull((Object)pos);
                        if (this.isClimbableWallAt(level, pos) && (wallTopY = this.findWallTopY(level, pos, maxScan = RangesKt.coerceAtLeast((int)(targetBlockPos.getY() - pos.getY() + 4), (int)1))) > searchPoint.getY() && (score = (distToPointSq = pos.distSqr((Vec3i)searchPoint)) * 1.0 + (distToTargetSq = pos.distSqr((Vec3i)targetBlockPos)) * 1.0 + (heightScore = (double)Math.abs(targetBlockPos.getY() - wallTopY) * 3.0)) < bestScore) {
                            bestScore = score;
                            best = pos;
                        }
                        if (z == searchRadius) break;
                        ++z;
                    }
                }
                if (x == searchRadius) break;
                ++x;
            }
        }
        return best;
    }

    private final int findWallTopY(LevelAccessor level, BlockPos basePos, int maxScan) {
        BlockPos checkPos;
        int top = basePos.getY();
        for (int i = 0; i < maxScan && !level.getBlockState(checkPos = basePos.above(i)).isAir(); ++i) {
            top = checkPos.getY();
        }
        return top;
    }

    public void stop() {
        super.stop();
        this.resetState();
    }

    private final void resetState() {
        this.targetPlayer = null;
        this.lastKnownPos = null;
        this.ticksSinceLostLOS = 0;
        this.lastPathUpdate = 0;
        this.lastTargetCheck = 0;
        this.isCommittedToClimb = false;
        this.cachedWallPos = null;
        this.mob.setTarget(null);
        this.mob.getNavigation().stop();
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
        Mob mob = this.mob;
        Intrinsics.checkNotNull((Object)mob, (String)"null cannot be cast to non-null type net.thebrokenscript.brokencore.api.entity.base.BaseMonster");
        if (BaseMonsterExtKt.hasLineOfSightThroughTransparent((BaseMonster)((BaseMonster)mob), (Player)((Player)newTarget))) {
            this.circuitMob.updateLastSeenTick();
            this.circuitMob.updatePlayerTracking(newTarget);
            this.lastKnownPos = newTarget.position();
            this.ticksSinceLostLOS = 0;
        }
        this.lastPathUpdate = this.mob.tickCount - this.pathCooldownTicks;
        this.mob.getNavigation().stop();
    }

    private final boolean shouldFallTowardsPlayer(ServerPlayer player) {
        BlockPos groundPos;
        Mob mob = this.mob;
        Intrinsics.checkNotNull((Object)mob, (String)"null cannot be cast to non-null type net.thebrokenscript.entity.circuit.CircuitEntity");
        if (((CircuitEntity)mob).getClimbing() || !this.mob.onGround()) {
            return false;
        }
        double heightDiff = this.mob.getY() - player.getY();
        if (heightDiff < 2.0) {
            return false;
        }
        double horizontalDist = Math.sqrt((this.mob.getX() - player.getX()) * (this.mob.getX() - player.getX()) + (this.mob.getZ() - player.getZ()) * (this.mob.getZ() - player.getZ()));
        double dirX = (player.getX() - this.mob.getX()) / horizontalDist;
        double dirZ = (player.getZ() - this.mob.getZ()) / horizontalDist;
        BlockPos checkPos = new BlockPos((int)(this.mob.getX() + dirX * 1.1), this.mob.getBlockY(), (int)(this.mob.getZ() + dirZ * 1.1));
        Level level = this.mob.level();
        if (!level.getBlockState(groundPos = this.mob.blockPosition().below()).isSolidRender((BlockGetter)level, groundPos)) {
            return false;
        }
        BlockPos belowCheck = checkPos.below();
        BlockPos twoBelow = checkPos.below(2);
        return level.getBlockState(belowCheck).isAir() || level.getBlockState(twoBelow).isAir();
    }

    private final void fallTowardsPlayer(ServerPlayer player) {
        this.mob.getNavigation().stop();
        double dirX = player.getX() - this.mob.getX();
        double dirZ = player.getZ() - this.mob.getZ();
        double horizontalDist = Math.sqrt(dirX * dirX + dirZ * dirZ);
        if (horizontalDist > 0.1) {
            double speed = 1.25;
            this.mob.setDeltaMovement(this.mob.getDeltaMovement().add(dirX / horizontalDist * speed, 0.0, dirZ / horizontalDist * speed));
        }
    }

    @Metadata(mv={2, 1, 0}, k=3, xi=48)
    public static final class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] nArray = new int[ChaseState.values().length];
            try {
                nArray[ChaseState.SEEKING_CLIMB.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[ChaseState.NORMAL.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            $EnumSwitchMapping$0 = nArray;
        }
    }
}

