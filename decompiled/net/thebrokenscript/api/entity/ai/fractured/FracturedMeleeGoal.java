/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.PathfinderMob
 *  net.minecraft.world.entity.ai.goal.Goal
 *  net.minecraft.world.entity.ai.goal.Goal$Flag
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.level.GameType
 *  net.minecraft.world.phys.AABB
 *  net.minecraft.world.phys.Vec3
 *  net.thebrokenscript.brokencore.api.dsl.PlayerUtil
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.api.entity.ai.fractured;

import java.util.EnumSet;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.GameType;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.brokencore.api.dsl.PlayerUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\b\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0015H\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0018H\u0016J\u0010\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u0010\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u0011H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bX\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000bX\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000bX\u0082D\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001f"}, d2={"Lnet/thebrokenscript/api/entity/ai/fractured/FracturedMeleeGoal;", "Lnet/minecraft/world/entity/ai/goal/Goal;", "mob", "Lnet/minecraft/world/entity/PathfinderMob;", "speedModifier", "", "attackRange", "", "<init>", "(Lnet/minecraft/world/entity/PathfinderMob;DF)V", "ticksUntilNextAttack", "", "ticksUntilNextPathRecalculation", "attackInterval", "pathRecalculationInterval", "pathfindingStuckTimer", "lastMobPos", "Lnet/minecraft/world/phys/Vec3;", "movementCooldown", "movementCooldownDuration", "canUse", "", "canContinueToUse", "stop", "", "tick", "checkAndDoAttack", "target", "Lnet/minecraft/world/entity/LivingEntity;", "isStuck", "currentPos", "thebrokenscript-common"})
public final class FracturedMeleeGoal
extends Goal {
    @NotNull
    private final PathfinderMob mob;
    private final double speedModifier;
    private final float attackRange;
    private int ticksUntilNextAttack;
    private int ticksUntilNextPathRecalculation;
    private final int attackInterval;
    private final int pathRecalculationInterval;
    private int pathfindingStuckTimer;
    @Nullable
    private Vec3 lastMobPos;
    private int movementCooldown;
    private final int movementCooldownDuration;

    public FracturedMeleeGoal(@NotNull PathfinderMob mob, double speedModifier, float attackRange) {
        Intrinsics.checkNotNullParameter((Object)mob, (String)"mob");
        this.mob = mob;
        this.speedModifier = speedModifier;
        this.attackRange = attackRange;
        this.setFlags(EnumSet.of((Enum)Goal.Flag.MOVE, (Enum)Goal.Flag.LOOK));
        this.attackInterval = 10;
        this.pathRecalculationInterval = 10;
        this.movementCooldownDuration = 6;
        this.setFlags(EnumSet.of((Enum)Goal.Flag.MOVE, (Enum)Goal.Flag.LOOK));
    }

    public /* synthetic */ FracturedMeleeGoal(PathfinderMob pathfinderMob, double d, float f, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 4) != 0) {
            f = 3.5f;
        }
        this(pathfinderMob, d, f);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean canUse() {
        LivingEntity target = this.mob.getTarget();
        Player player = target instanceof Player ? (Player)target : null;
        if (target == null) return false;
        if (!target.isAlive()) return false;
        Player player2 = player;
        Player player3 = player2;
        if (player2 == null) return false;
        GameType gameType = PlayerUtil.getGameMode((Player)player3);
        player3 = gameType;
        if (gameType == null) return false;
        if (!player3.isSurvival()) return false;
        return true;
    }

    public boolean canContinueToUse() {
        return this.canUse();
    }

    public void stop() {
        this.mob.getNavigation().stop();
        this.ticksUntilNextAttack = 0;
        this.ticksUntilNextPathRecalculation = 0;
        this.pathfindingStuckTimer = 0;
        this.lastMobPos = null;
        this.movementCooldown = 0;
    }

    public void tick() {
        LivingEntity livingEntity = this.mob.getTarget();
        if (livingEntity == null) {
            return;
        }
        LivingEntity target = livingEntity;
        this.mob.getLookControl().setLookAt((Entity)target, 30.0f, 30.0f);
        double distanceSqr = this.mob.distanceToSqr((Entity)target);
        if (this.movementCooldown > 0) {
            int n = this.movementCooldown;
            this.movementCooldown = n + -1;
            this.mob.getNavigation().stop();
            this.ticksUntilNextAttack = Math.max(this.ticksUntilNextAttack - 1, 0);
            this.checkAndDoAttack(target);
            return;
        }
        int n = this.ticksUntilNextPathRecalculation;
        this.ticksUntilNextPathRecalculation = n + -1;
        Vec3 mobPos = this.mob.position();
        Intrinsics.checkNotNull((Object)mobPos);
        if (this.isStuck(mobPos) && !this.mob.getNavigation().isDone()) {
            int n2 = this.pathfindingStuckTimer;
            this.pathfindingStuckTimer = n2 + 1;
            if (this.pathfindingStuckTimer > 20) {
                this.ticksUntilNextPathRecalculation = 0;
                this.pathfindingStuckTimer = 0;
            }
        } else {
            this.pathfindingStuckTimer = 0;
        }
        this.lastMobPos = mobPos;
        if (this.ticksUntilNextPathRecalculation <= 0) {
            this.ticksUntilNextPathRecalculation = this.pathRecalculationInterval;
            if (distanceSqr > (double)(this.attackRange * this.attackRange)) {
                if (!this.mob.getNavigation().isDone()) {
                    this.mob.getNavigation().stop();
                }
                this.mob.getMoveControl().setWantedPosition(target.getX(), target.getY(), target.getZ(), this.speedModifier);
            } else {
                this.mob.getNavigation().stop();
            }
            this.ticksUntilNextAttack = Math.max(this.ticksUntilNextAttack - 1, 0);
            this.checkAndDoAttack(target);
        }
    }

    private final void checkAndDoAttack(LivingEntity target) {
        AABB expandedBox = this.mob.getBoundingBox().inflate(this.mob.getBoundingBox().getXsize() * (double)this.attackRange, this.mob.getBoundingBox().getYsize() * 0.2, this.mob.getBoundingBox().getZsize() * (double)this.attackRange);
        if (expandedBox.intersects(target.getBoundingBox()) && this.ticksUntilNextAttack <= 0 && this.mob.hasLineOfSight((Entity)target)) {
            this.ticksUntilNextAttack = this.attackInterval;
            this.movementCooldown = this.movementCooldownDuration;
            this.mob.doHurtTarget((Entity)target);
        }
    }

    private final boolean isStuck(Vec3 currentPos) {
        Vec3 vec3 = this.lastMobPos;
        if (vec3 == null) {
            return false;
        }
        Vec3 lastPos = vec3;
        return currentPos.distanceToSqr(lastPos) < 0.01;
    }
}

