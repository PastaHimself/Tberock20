/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Position
 *  net.minecraft.server.level.ServerPlayer
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.Mob
 *  net.minecraft.world.entity.ai.control.LookControl
 *  net.minecraft.world.entity.ai.goal.Goal
 *  net.minecraft.world.entity.ai.goal.Goal$Flag
 *  net.minecraft.world.entity.ai.targeting.TargetingConditions
 *  net.minecraft.world.phys.Vec3
 *  net.thebrokenscript.brokencore.api.dsl.PositionUtil
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.util;

import java.util.EnumSet;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Position;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.control.LookControl;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.brokencore.api.dsl.PositionUtil;
import net.thebrokenscript.util.MazeNavigationGoal;
import net.thebrokenscript.util.MazePathFinderKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u00a2\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0013\u001a\u00020\nH\u0016J\b\u0010\u0014\u001a\u00020\nH\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0016H\u0016J\n\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0002J\b\u0010\u001a\u001a\u00020\u0016H\u0002J\u0010\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u0019H\u0002J\b\u0010\u001d\u001a\u00020\u0016H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001e"}, d2={"Lnet/thebrokenscript/util/DynamicMazeNavigationGoal;", "Lnet/minecraft/world/entity/ai/goal/Goal;", "mob", "Lnet/minecraft/world/entity/Mob;", "targetProvider", "Lkotlin/Function0;", "Lnet/minecraft/world/phys/Vec3;", "speedModifier", "", "allowDiagonal", "", "<init>", "(Lnet/minecraft/world/entity/Mob;Lkotlin/jvm/functions/Function0;DZ)V", "innerGoal", "Lnet/thebrokenscript/util/MazeNavigationGoal;", "lastPathTarget", "Lnet/minecraft/core/BlockPos;", "tickCounter", "", "canUse", "canContinueToUse", "start", "", "tick", "findClosestValidPlayer", "Lnet/minecraft/server/level/ServerPlayer;", "recalcPath", "switchTarget", "newTarget", "stop", "thebrokenscript-common"})
@SourceDebugExtension(value={"SMAP\nMazePathFinder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MazePathFinder.kt\nnet/thebrokenscript/util/DynamicMazeNavigationGoal\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,562:1\n1#2:563\n*E\n"})
public final class DynamicMazeNavigationGoal
extends Goal {
    @NotNull
    private final Mob mob;
    @NotNull
    private final Function0<Vec3> targetProvider;
    private final double speedModifier;
    private final boolean allowDiagonal;
    @Nullable
    private MazeNavigationGoal innerGoal;
    @Nullable
    private BlockPos lastPathTarget;
    private int tickCounter;

    public DynamicMazeNavigationGoal(@NotNull Mob mob, @NotNull Function0<? extends Vec3> targetProvider, double speedModifier, boolean allowDiagonal) {
        Intrinsics.checkNotNullParameter((Object)mob, (String)"mob");
        Intrinsics.checkNotNullParameter(targetProvider, (String)"targetProvider");
        this.mob = mob;
        this.targetProvider = targetProvider;
        this.speedModifier = speedModifier;
        this.allowDiagonal = allowDiagonal;
        this.setFlags(EnumSet.of((Enum)Goal.Flag.MOVE, (Enum)Goal.Flag.LOOK));
    }

    public /* synthetic */ DynamicMazeNavigationGoal(Mob mob, Function0 function0, double d, boolean bl, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 4) != 0) {
            d = 1.0;
        }
        if ((n & 8) != 0) {
            bl = false;
        }
        this(mob, (Function0<? extends Vec3>)function0, d, bl);
    }

    public boolean canUse() {
        return this.targetProvider.invoke() != null;
    }

    public boolean canContinueToUse() {
        return this.targetProvider.invoke() != null && this.mob.getTarget() != null;
    }

    public void start() {
        this.recalcPath();
    }

    public void tick() {
        ServerPlayer closerPlayer;
        Vec3 player;
        block9: {
            BlockPos currentTargetPos;
            block8: {
                Vec3 vec3 = (Vec3)this.targetProvider.invoke();
                if (vec3 == null) {
                    return;
                }
                player = vec3;
                int n = this.tickCounter;
                this.tickCounter = n + 1;
                currentTargetPos = PositionUtil.getBlockPos((Position)((Position)player));
                if (this.lastPathTarget == null) break block8;
                BlockPos blockPos = this.lastPathTarget;
                Intrinsics.checkNotNull((Object)blockPos);
                if (!(MazePathFinderKt.distanceTo(blockPos, currentTargetPos) > 0.5)) break block9;
            }
            this.recalcPath();
            this.lastPathTarget = currentTargetPos;
        }
        if (this.tickCounter % 20 == 0 && (closerPlayer = this.findClosestValidPlayer()) != null && !Intrinsics.areEqual((Object)closerPlayer, (Object)player)) {
            double currentDist = this.mob.distanceToSqr(player);
            double closerDist = this.mob.distanceToSqr((Entity)closerPlayer);
            if (closerDist < currentDist * 0.75) {
                this.switchTarget(closerPlayer);
                return;
            }
        }
        MazeNavigationGoal mazeNavigationGoal = this.innerGoal;
        if (mazeNavigationGoal != null) {
            mazeNavigationGoal.tick();
        }
        if (this.mob.getTarget() != null) {
            LookControl lookControl = this.mob.getLookControl();
            LivingEntity livingEntity = this.mob.getTarget();
            Intrinsics.checkNotNull((Object)livingEntity);
            lookControl.setLookAt((Entity)livingEntity);
        }
    }

    private final ServerPlayer findClosestValidPlayer() {
        Object object;
        ServerPlayer serverPlayer = (ServerPlayer)this.mob.level().getNearestEntity(ServerPlayer.class, TargetingConditions.forCombat().ignoreInvisibilityTesting(), (LivingEntity)this.mob, this.mob.getX(), this.mob.getEyeY(), this.mob.getZ(), this.mob.getBoundingBox().inflate(64.0));
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

    private final void recalcPath() {
        Vec3 vec3 = (Vec3)this.targetProvider.invoke();
        if (vec3 == null || (vec3 = PositionUtil.getBlockPos((Position)((Position)vec3))) == null) {
            return;
        }
        Vec3 targetPos = vec3;
        MazeNavigationGoal existing = this.innerGoal;
        if (existing == null) {
            MazeNavigationGoal mazeNavigationGoal = this.innerGoal = new MazeNavigationGoal(this.mob, (BlockPos)targetPos, this.speedModifier, this.allowDiagonal, 0, 16, null);
            if (mazeNavigationGoal != null) {
                mazeNavigationGoal.start();
            }
        } else {
            existing.updateTarget((BlockPos)targetPos);
        }
    }

    private final void switchTarget(ServerPlayer newTarget) {
        this.mob.setTarget((LivingEntity)newTarget);
        this.mob.getNavigation().stop();
    }

    public void stop() {
        MazeNavigationGoal mazeNavigationGoal = this.innerGoal;
        if (mazeNavigationGoal != null) {
            mazeNavigationGoal.stop();
        }
        this.innerGoal = null;
        this.lastPathTarget = null;
    }
}

