/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.world.InteractionHand
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.PathfinderMob
 *  net.minecraft.world.entity.ai.goal.Goal
 *  net.minecraft.world.entity.ai.goal.Goal$Flag
 *  net.minecraft.world.phys.AABB
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.api.entity.ai.null_maze;

import java.util.EnumSet;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.phys.AABB;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u0004B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0005"}, d2={"Lnet/thebrokenscript/api/entity/ai/null_maze/MazeHitGoal;", "", "<init>", "()V", "ContinuousMeleeAttackGoal", "thebrokenscript-common"})
public final class MazeHitGoal {
    @NotNull
    public static final MazeHitGoal INSTANCE = new MazeHitGoal();

    private MazeHitGoal() {
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082D\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2={"Lnet/thebrokenscript/api/entity/ai/null_maze/MazeHitGoal$ContinuousMeleeAttackGoal;", "Lnet/minecraft/world/entity/ai/goal/Goal;", "mob", "Lnet/minecraft/world/entity/PathfinderMob;", "attackRange", "", "range", "", "<init>", "(Lnet/minecraft/world/entity/PathfinderMob;FD)V", "ticksUntilNextAttack", "", "attackInterval", "canUse", "", "canContinueToUse", "stop", "", "tick", "thebrokenscript-common"})
    public static final class ContinuousMeleeAttackGoal
    extends Goal {
        @NotNull
        private final PathfinderMob mob;
        private final float attackRange;
        private final double range;
        private int ticksUntilNextAttack;
        private final int attackInterval;

        public ContinuousMeleeAttackGoal(@NotNull PathfinderMob mob, float attackRange, double range) {
            Intrinsics.checkNotNullParameter((Object)mob, (String)"mob");
            this.mob = mob;
            this.attackRange = attackRange;
            this.range = range;
            this.attackInterval = 10;
            this.setFlags(EnumSet.noneOf(Goal.Flag.class));
        }

        public /* synthetic */ ContinuousMeleeAttackGoal(PathfinderMob pathfinderMob, float f, double d, int n, DefaultConstructorMarker defaultConstructorMarker) {
            if ((n & 2) != 0) {
                f = 1.2f;
            }
            if ((n & 4) != 0) {
                d = 2.0;
            }
            this(pathfinderMob, f, d);
        }

        public boolean canUse() {
            LivingEntity target = this.mob.getTarget();
            return target != null && target.isAlive() && this.mob.distanceToSqr((Entity)target) < this.range * this.range;
        }

        public boolean canContinueToUse() {
            return this.canUse();
        }

        public void stop() {
            this.ticksUntilNextAttack = 0;
        }

        public void tick() {
            LivingEntity livingEntity = this.mob.getTarget();
            if (livingEntity == null) {
                return;
            }
            LivingEntity target = livingEntity;
            this.ticksUntilNextAttack = Math.max(this.ticksUntilNextAttack - 1, 0);
            AABB expandedBox = this.mob.getBoundingBox().inflate(this.mob.getBoundingBox().getXsize() * (double)this.attackRange, this.mob.getBoundingBox().getYsize() * 0.2, this.mob.getBoundingBox().getZsize() * (double)this.attackRange);
            if (expandedBox.intersects(target.getBoundingBox()) && this.ticksUntilNextAttack <= 0) {
                this.ticksUntilNextAttack = this.attackInterval;
                this.mob.swing(InteractionHand.MAIN_HAND);
                this.mob.doHurtTarget((Entity)target);
            }
        }
    }
}

