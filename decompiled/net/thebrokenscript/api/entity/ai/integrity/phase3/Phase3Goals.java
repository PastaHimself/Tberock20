/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.Mob
 *  net.minecraft.world.entity.ai.goal.Goal
 *  net.minecraft.world.entity.ai.goal.Goal$Flag
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.phys.Vec3
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.api.entity.ai.integrity.phase3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.entity.integrity.phase3.IntegrityPhase3Entity;
import net.thebrokenscript.entity.integrity.phase3.attacks.Attack;
import net.thebrokenscript.entity.integrity.phase3.attacks.AttackType;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0007"}, d2={"Lnet/thebrokenscript/api/entity/ai/integrity/phase3/Phase3Goals;", "", "<init>", "()V", "AlwaysTargetPlayerGoal", "MoveToTargetGoal", "AttackSelectorGoal", "thebrokenscript-common"})
public final class Phase3Goals {
    @NotNull
    public static final Phase3Goals INSTANCE = new Phase3Goals();

    private Phase3Goals() {
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2={"Lnet/thebrokenscript/api/entity/ai/integrity/phase3/Phase3Goals$AlwaysTargetPlayerGoal;", "Lnet/minecraft/world/entity/ai/goal/Goal;", "mob", "Lnet/minecraft/world/entity/Mob;", "<init>", "(Lnet/minecraft/world/entity/Mob;)V", "canUse", "", "thebrokenscript-common"})
    public static final class AlwaysTargetPlayerGoal
    extends Goal {
        @NotNull
        private final Mob mob;

        public AlwaysTargetPlayerGoal(@NotNull Mob mob) {
            Intrinsics.checkNotNullParameter((Object)mob, (String)"mob");
            this.mob = mob;
            this.setFlags(EnumSet.of((Enum)Goal.Flag.TARGET));
        }

        public boolean canUse() {
            Mob mob = this.mob;
            Intrinsics.checkNotNull((Object)mob, (String)"null cannot be cast to non-null type net.thebrokenscript.entity.integrity.phase3.IntegrityPhase3Entity");
            if (((IntegrityPhase3Entity)mob).getDying()) {
                return false;
            }
            Player player = this.mob.level().getNearestPlayer((Entity)this.mob, -1.0);
            if (player != null && player.isAlive()) {
                ((IntegrityPhase3Entity)this.mob).setTarget((LivingEntity)player);
                return true;
            }
            return false;
        }
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2={"Lnet/thebrokenscript/api/entity/ai/integrity/phase3/Phase3Goals$AttackSelectorGoal;", "Lnet/minecraft/world/entity/ai/goal/Goal;", "integrity", "Lnet/thebrokenscript/entity/integrity/phase3/IntegrityPhase3Entity;", "<init>", "(Lnet/thebrokenscript/entity/integrity/phase3/IntegrityPhase3Entity;)V", "canUse", "", "canContinueToUse", "start", "", "thebrokenscript-common"})
    @SourceDebugExtension(value={"SMAP\nPhase3Goals.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Phase3Goals.kt\nnet/thebrokenscript/api/entity/ai/integrity/phase3/Phase3Goals$AttackSelectorGoal\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,145:1\n774#2:146\n865#2,2:147\n1#3:149\n*S KotlinDebug\n*F\n+ 1 Phase3Goals.kt\nnet/thebrokenscript/api/entity/ai/integrity/phase3/Phase3Goals$AttackSelectorGoal\n*L\n114#1:146\n114#1:147,2\n*E\n"})
    public static final class AttackSelectorGoal
    extends Goal {
        @NotNull
        private final IntegrityPhase3Entity integrity;

        public AttackSelectorGoal(@NotNull IntegrityPhase3Entity integrity) {
            Intrinsics.checkNotNullParameter((Object)((Object)integrity), (String)"integrity");
            this.integrity = integrity;
            this.setFlags(EnumSet.noneOf(Goal.Flag.class));
        }

        public boolean canUse() {
            if (this.integrity.getDying()) {
                return false;
            }
            if (this.integrity.getTarget() == null) {
                return false;
            }
            return this.integrity.getAttackStateInternal().getType() == AttackType.NOOP && this.integrity.getAttackDelay() <= 0L && !this.integrity.stuckStatus();
        }

        public boolean canContinueToUse() {
            return false;
        }

        /*
         * WARNING - void declaration
         */
        public void start() {
            Attack attack;
            Iterable $this$filterTo$iv$iv;
            LivingEntity livingEntity = this.integrity.getTarget();
            if (livingEntity == null) {
                return;
            }
            LivingEntity target = livingEntity;
            double distSqr = this.integrity.distanceToSqr((Entity)target);
            Collection collection = IntegrityPhase3Entity.Companion.getATTACKS$thebrokenscript_common().values();
            Intrinsics.checkNotNullExpressionValue((Object)collection, (String)"<get-values>(...)");
            Iterable $this$filter$iv = collection;
            boolean $i$f$filter = false;
            Iterable iterable = $this$filter$iv;
            Collection destination$iv$iv22 = new ArrayList();
            boolean $i$f$filterTo = false;
            for (Object element$iv$iv : $this$filterTo$iv$iv) {
                boolean bl;
                attack = (Attack)element$iv$iv;
                boolean bl2 = false;
                if (!attack.canUse(this.integrity)) {
                    bl = false;
                } else if (attack.getType() == this.integrity.getPreviousAttack()) {
                    bl = false;
                } else {
                    Pair<Integer, Integer> pair = attack.getDistanceRange();
                    int min = ((Number)pair.component1()).intValue();
                    int max = ((Number)pair.component2()).intValue();
                    if (min == Integer.MIN_VALUE && max == Integer.MAX_VALUE) {
                        bl = true;
                    } else {
                        double d = (double)min * (double)min;
                        bl = distSqr <= (double)max * (double)max ? d <= distSqr : false;
                    }
                }
                if (!bl) continue;
                destination$iv$iv22.add(element$iv$iv);
            }
            List candidates = (List)destination$iv$iv22;
            if (candidates.isEmpty()) {
                return;
            }
            $this$filterTo$iv$iv = candidates;
            double destination$iv$iv22 = 0.0;
            for (Object element$iv$iv : $this$filterTo$iv$iv) {
                void it;
                attack = (Attack)element$iv$iv;
                double d = destination$iv$iv22;
                boolean bl = false;
                double d2 = it.getChance();
                destination$iv$iv22 = d + d2;
            }
            double totalWeight = destination$iv$iv22;
            Attack selected = null;
            block2: while (selected == null) {
                double roll = this.integrity.getRandom().nextDouble() * totalWeight;
                for (Attack attack2 : candidates) {
                    if (!((roll -= (double)attack2.getChance()) <= 0.0)) continue;
                    selected = attack2;
                    continue block2;
                }
            }
            this.integrity.setPreviousAttack(selected.getType());
            this.integrity.setAttackStateInternal(selected);
            this.integrity.setAttackTicks(0);
            this.integrity.setAttackDelay(0L);
            selected.setup(this.integrity);
        }
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0004\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0015H\u0016J\b\u0010\u0017\u001a\u00020\u0015H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2={"Lnet/thebrokenscript/api/entity/ai/integrity/phase3/Phase3Goals$MoveToTargetGoal;", "Lnet/minecraft/world/entity/ai/goal/Goal;", "mob", "Lnet/thebrokenscript/entity/integrity/phase3/IntegrityPhase3Entity;", "speedModifier", "", "<init>", "(Lnet/thebrokenscript/entity/integrity/phase3/IntegrityPhase3Entity;Ljava/lang/Number;)V", "attackRange", "", "speed", "", "repathCooldown", "", "lastTargetX", "lastTargetY", "lastTargetZ", "canUse", "", "canContinueToUse", "start", "", "stop", "tick", "thebrokenscript-common"})
    public static final class MoveToTargetGoal
    extends Goal {
        @NotNull
        private final IntegrityPhase3Entity mob;
        private final float attackRange;
        private final double speed;
        private int repathCooldown;
        private double lastTargetX;
        private double lastTargetY;
        private double lastTargetZ;

        public MoveToTargetGoal(@NotNull IntegrityPhase3Entity mob, @NotNull Number speedModifier) {
            Intrinsics.checkNotNullParameter((Object)((Object)mob), (String)"mob");
            Intrinsics.checkNotNullParameter((Object)speedModifier, (String)"speedModifier");
            this.mob = mob;
            this.attackRange = 1.2f;
            this.speed = speedModifier.doubleValue();
            this.setFlags(EnumSet.of((Enum)Goal.Flag.MOVE, (Enum)Goal.Flag.LOOK));
        }

        public boolean canUse() {
            if (this.mob.getDying()) {
                return false;
            }
            LivingEntity target = this.mob.getTarget();
            return target != null && target.isAlive() && this.mob.getAttackStateInternal().canMove(this.mob) && !this.mob.stuckStatus();
        }

        public boolean canContinueToUse() {
            return this.canUse();
        }

        public void start() {
            this.repathCooldown = 0;
        }

        public void stop() {
            this.mob.getMoveControl().setWantedPosition(this.mob.getX(), this.mob.getY(), this.mob.getZ(), 0.0);
        }

        public void tick() {
            if (!this.mob.getAttackStateInternal().moveTick(this.mob) || this.mob.stuckStatus()) {
                return;
            }
            LivingEntity livingEntity = this.mob.getTarget();
            if (livingEntity == null) {
                return;
            }
            LivingEntity target = livingEntity;
            this.mob.getLookControl().setLookAt((Entity)target, 30.0f, 30.0f);
            double distanceSqr = this.mob.distanceToSqr((Entity)target);
            if (distanceSqr <= (double)(this.attackRange * this.attackRange)) {
                this.mob.getMoveControl().setWantedPosition(this.mob.getX(), this.mob.getY(), this.mob.getZ(), 0.0);
                return;
            }
            int n = this.repathCooldown;
            this.repathCooldown = n + -1;
            if (n > 0) {
                return;
            }
            if (this.mob.distanceTo((Entity)target) < 15.0f) {
                this.mob.getMoveControl().setWantedPosition(this.mob.getX(), this.mob.getY(), this.mob.getZ(), 0.0);
                return;
            }
            if (this.mob.getSensing().hasLineOfSight((Entity)target) && this.mob.distanceTo((Entity)target) > 15.0f) {
                this.mob.getMoveControl().setWantedPosition(target.getX(), this.mob.getY(), target.getZ(), this.speed);
                this.mob.setDeltaMovement(Vec3.ZERO);
                this.repathCooldown = 5;
                return;
            }
            double targetMovedSqr = target.distanceToSqr(this.lastTargetX, this.lastTargetY, this.lastTargetZ);
            if (targetMovedSqr > 3.5) {
                this.mob.getMoveControl().setWantedPosition(target.getX(), this.mob.getY(), target.getZ(), this.speed);
                this.lastTargetX = target.getX();
                this.lastTargetY = target.getY();
                this.lastTargetZ = target.getZ();
            }
            this.repathCooldown = 10;
        }
    }
}

