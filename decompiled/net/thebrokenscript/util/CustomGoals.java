/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.util.Mth
 *  net.minecraft.world.InteractionHand
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.Mob
 *  net.minecraft.world.entity.PathfinderMob
 *  net.minecraft.world.entity.ai.goal.AvoidEntityGoal
 *  net.minecraft.world.entity.ai.goal.Goal
 *  net.minecraft.world.entity.ai.goal.Goal$Flag
 *  net.minecraft.world.entity.ai.navigation.PathNavigation
 *  net.minecraft.world.entity.ai.targeting.TargetingConditions
 *  net.minecraft.world.entity.animal.IronGolem
 *  net.minecraft.world.entity.monster.Monster
 *  net.minecraft.world.entity.npc.Villager
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.level.pathfinder.Path
 *  net.minecraft.world.phys.AABB
 *  net.minecraft.world.phys.Vec3
 *  net.thebrokenscript.brokencore.api.dsl.EntityUtil
 *  net.thebrokenscript.brokencore.api.ext.EntityTypeExt
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.util;

import java.util.EnumSet;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.pathfinder.Path;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.brokencore.api.dsl.EntityUtil;
import net.thebrokenscript.brokencore.api.ext.EntityTypeExt;
import net.thebrokenscript.registry.TBSEntities;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\b"}, d2={"Lnet/thebrokenscript/util/CustomGoals;", "", "<init>", "()V", "AlwaysTargetPlayerGoal", "ContinuousMeleeAttackGoal", "ThrottledAvoidGoal", "CircuitSpawnGoal", "thebrokenscript-common"})
public final class CustomGoals {
    @NotNull
    public static final CustomGoals INSTANCE = new CustomGoals();

    private CustomGoals() {
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0004\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\n\u001a\u00020\u000bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\u00a8\u0006\f"}, d2={"Lnet/thebrokenscript/util/CustomGoals$AlwaysTargetPlayerGoal;", "Lnet/minecraft/world/entity/ai/goal/Goal;", "mob", "Lnet/minecraft/world/entity/Mob;", "distance", "", "<init>", "(Lnet/minecraft/world/entity/Mob;Ljava/lang/Number;)V", "getDistance", "()Ljava/lang/Number;", "canUse", "", "thebrokenscript-common"})
    public static final class AlwaysTargetPlayerGoal
    extends Goal {
        @NotNull
        private final Mob mob;
        @NotNull
        private final Number distance;

        public AlwaysTargetPlayerGoal(@NotNull Mob mob, @NotNull Number distance) {
            Intrinsics.checkNotNullParameter((Object)mob, (String)"mob");
            Intrinsics.checkNotNullParameter((Object)distance, (String)"distance");
            this.mob = mob;
            this.distance = distance;
            this.setFlags(EnumSet.of((Enum)Goal.Flag.TARGET));
        }

        @NotNull
        public final Number getDistance() {
            return this.distance;
        }

        public boolean canUse() {
            Player player = this.mob.level().getNearestPlayer((Entity)this.mob, this.distance.doubleValue());
            if (player != null && player.isAlive()) {
                this.mob.setTarget((LivingEntity)player);
                PathNavigation pathNavigation = this.mob.getNavigation();
                LivingEntity livingEntity = this.mob.getTarget();
                Intrinsics.checkNotNull((Object)livingEntity);
                pathNavigation.moveTo((Entity)livingEntity, 1.45);
                return true;
            }
            return false;
        }
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2={"Lnet/thebrokenscript/util/CustomGoals$CircuitSpawnGoal;", "Lnet/minecraft/world/entity/ai/goal/Goal;", "mob", "Lnet/minecraft/world/entity/Mob;", "<init>", "(Lnet/minecraft/world/entity/Mob;)V", "canUse", "", "canContinueToUse", "tick", "", "thebrokenscript-common"})
    public static final class CircuitSpawnGoal
    extends Goal {
        @NotNull
        private final Mob mob;

        public CircuitSpawnGoal(@NotNull Mob mob) {
            Intrinsics.checkNotNullParameter((Object)mob, (String)"mob");
            this.mob = mob;
            this.setFlags(this.mob instanceof Monster ? EnumSet.noneOf(Goal.Flag.class) : EnumSet.of((Enum)Goal.Flag.LOOK, (Enum)Goal.Flag.MOVE, (Enum)Goal.Flag.TARGET));
        }

        public boolean canUse() {
            Level level = this.mob.level();
            if (!(level instanceof ServerLevel)) {
                return false;
            }
            if (((ServerLevel)level).isDay() && this.mob.getRandom().nextDouble() < 1.0E-4) {
                this.mob.discard();
                return false;
            }
            Player player = ((ServerLevel)level).getNearestPlayer((Entity)this.mob, 1000.0);
            if (player != null) {
                double distSqr = player.position().distanceToSqr(this.mob.getX(), this.mob.getY(), this.mob.getZ());
                return distSqr > Mth.square((double)20.0);
            }
            return true;
        }

        public boolean canContinueToUse() {
            return this.canUse();
        }

        public void tick() {
            Level level = this.mob.level();
            if (!(level instanceof ServerLevel)) {
                return;
            }
            Player player = ((ServerLevel)level).getNearestPlayer((Entity)this.mob, 1000.0);
            if (player != null) {
                IronGolem ironGolem;
                double distSqr = player.position().distanceToSqr(this.mob.getX(), this.mob.getY(), this.mob.getZ());
                if (distSqr <= Mth.square((double)20.0)) {
                    if (this.mob.getRandom().nextDouble() < 1.0E-4) {
                        this.mob.discard();
                        EntityType entityType = (EntityType)TBSEntities.CIRCUIT.get();
                        LevelAccessor levelAccessor = (LevelAccessor)level;
                        Vec3 vec3 = this.mob.position();
                        Intrinsics.checkNotNullExpressionValue((Object)vec3, (String)"position(...)");
                        Entity entity = EntityTypeExt.trySummon((EntityType)entityType, (LevelAccessor)levelAccessor, (Vec3)vec3);
                        if (entity != null) {
                            EntityUtil.applyRandomRotation((Entity)entity);
                        }
                    } else if (!(this.mob instanceof Monster)) {
                        this.mob.setTarget(null);
                        this.mob.getNavigation().stop();
                    }
                } else {
                    this.mob.getLookControl().setLookAt((Entity)player, 30.0f, 30.0f);
                    boolean bl = this.mob instanceof Villager ? ((Villager)this.mob).getNavigation().moveTo((Entity)player, 0.6) : this.mob.getNavigation().moveTo((Entity)player, 1.05);
                    if (!(this.mob instanceof Monster)) {
                        this.mob.setTarget((LivingEntity)player);
                    }
                }
                if (this.mob instanceof Villager && (ironGolem = (IronGolem)((ServerLevel)level).getNearestEntity(IronGolem.class, TargetingConditions.DEFAULT.ignoreLineOfSight().ignoreInvisibilityTesting(), (LivingEntity)this.mob, ((Villager)this.mob).getX(), ((Villager)this.mob).getY(), ((Villager)this.mob).getZ(), ((Villager)this.mob).getBoundingBox().inflate(50.0))) != null) {
                    ironGolem.setTarget((LivingEntity)player);
                }
            }
            if (((ServerLevel)level).isDay() && this.mob.getRandom().nextDouble() < 1.0E-4) {
                this.mob.discard();
            }
        }
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u00a2\u0006\u0004\b\t\u0010\nJ\b\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0017H\u0016J\b\u0010\u001a\u001a\u00020\u0014H\u0002J\b\u0010\u001b\u001a\u00020\u0017H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\fX\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\fX\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001c"}, d2={"Lnet/thebrokenscript/util/CustomGoals$ContinuousMeleeAttackGoal;", "Lnet/minecraft/world/entity/ai/goal/Goal;", "mob", "Lnet/minecraft/world/entity/PathfinderMob;", "speedModifier", "", "attackRange", "", "range", "<init>", "(Lnet/minecraft/world/entity/PathfinderMob;DFD)V", "ticksUntilNextAttack", "", "ticksUntilNextPathRecalculation", "attackInterval", "pathRecalculationInterval", "pathfindingStuckTimer", "lastTargetPos", "Lnet/minecraft/world/phys/Vec3;", "canUse", "", "canContinueToUse", "start", "", "stop", "lastMobPos", "isStuck", "tick", "thebrokenscript-common"})
    public static final class ContinuousMeleeAttackGoal
    extends Goal {
        @NotNull
        private final PathfinderMob mob;
        private final double speedModifier;
        private final float attackRange;
        private final double range;
        private int ticksUntilNextAttack;
        private int ticksUntilNextPathRecalculation;
        private final int attackInterval;
        private final int pathRecalculationInterval;
        private int pathfindingStuckTimer;
        @Nullable
        private Vec3 lastTargetPos;
        @Nullable
        private Vec3 lastMobPos;

        public ContinuousMeleeAttackGoal(@NotNull PathfinderMob mob, double speedModifier, float attackRange, double range) {
            Intrinsics.checkNotNullParameter((Object)mob, (String)"mob");
            this.mob = mob;
            this.speedModifier = speedModifier;
            this.attackRange = attackRange;
            this.range = range;
            this.attackInterval = 10;
            this.pathRecalculationInterval = 10;
            this.setFlags(EnumSet.of((Enum)Goal.Flag.MOVE, (Enum)Goal.Flag.LOOK));
        }

        public /* synthetic */ ContinuousMeleeAttackGoal(PathfinderMob pathfinderMob, double d, float f, double d2, int n, DefaultConstructorMarker defaultConstructorMarker) {
            if ((n & 4) != 0) {
                f = 1.2f;
            }
            if ((n & 8) != 0) {
                d2 = 400.0;
            }
            this(pathfinderMob, d, f, d2);
        }

        public boolean canUse() {
            LivingEntity target = this.mob.getTarget();
            return target != null && target.isAlive() && this.mob.distanceToSqr((Entity)target) < this.range * this.range;
        }

        public boolean canContinueToUse() {
            return this.canUse();
        }

        public void start() {
            this.ticksUntilNextPathRecalculation = 0;
            this.pathfindingStuckTimer = 0;
            this.lastTargetPos = null;
            this.lastMobPos = null;
        }

        public void stop() {
            this.mob.getNavigation().stop();
            this.ticksUntilNextAttack = 0;
            this.ticksUntilNextPathRecalculation = 0;
            this.pathfindingStuckTimer = 0;
            this.lastTargetPos = null;
            this.lastMobPos = null;
        }

        private final boolean isStuck() {
            Vec3 currentMobPos = this.mob.position();
            Vec3 vec3 = this.lastMobPos;
            if (vec3 == null) {
                ContinuousMeleeAttackGoal $this$isStuck_u24lambda_u240 = this;
                boolean bl = false;
                $this$isStuck_u24lambda_u240.lastMobPos = currentMobPos;
                return false;
            }
            Vec3 lastPos = vec3;
            boolean stuck = currentMobPos.distanceToSqr(lastPos) < 0.01 && !this.mob.getNavigation().isDone();
            this.lastMobPos = currentMobPos;
            return stuck;
        }

        public void tick() {
            LivingEntity livingEntity = this.mob.getTarget();
            if (livingEntity == null) {
                return;
            }
            LivingEntity target = livingEntity;
            this.mob.getLookControl().setLookAt((Entity)target, 30.0f, 30.0f);
            double distanceSqr = this.mob.distanceToSqr((Entity)target);
            Vec3 targetPos = target.position();
            int n = this.ticksUntilNextPathRecalculation;
            this.ticksUntilNextPathRecalculation = n + -1;
            if (this.isStuck()) {
                n = this.pathfindingStuckTimer;
                this.pathfindingStuckTimer = n + 1;
                if (this.pathfindingStuckTimer > 20) {
                    this.ticksUntilNextPathRecalculation = 0;
                    this.pathfindingStuckTimer = 0;
                }
            } else {
                this.pathfindingStuckTimer = 0;
            }
            if (this.ticksUntilNextPathRecalculation <= 0) {
                this.ticksUntilNextPathRecalculation = this.pathRecalculationInterval;
                if (distanceSqr > (double)(this.attackRange * this.attackRange)) {
                    Path path = this.mob.getNavigation().createPath((Entity)target, 0);
                    if (path != null) {
                        this.mob.getNavigation().moveTo(path, this.speedModifier);
                    } else {
                        this.mob.getMoveControl().setWantedPosition(target.getX(), target.getY(), target.getZ(), this.speedModifier);
                    }
                } else {
                    this.mob.getNavigation().stop();
                }
            }
            this.lastTargetPos = targetPos;
            this.ticksUntilNextAttack = Math.max(this.ticksUntilNextAttack - 1, 0);
            AABB expandedBox = this.mob.getBoundingBox().inflate(this.mob.getBoundingBox().getXsize() * (double)this.attackRange, this.mob.getBoundingBox().getYsize() * 0.2, this.mob.getBoundingBox().getZsize() * (double)this.attackRange);
            if (expandedBox.intersects(target.getBoundingBox()) && this.ticksUntilNextAttack <= 0) {
                this.ticksUntilNextAttack = this.attackInterval;
                this.mob.swing(InteractionHand.MAIN_HAND);
                this.mob.doHurtTarget((Entity)target);
            }
        }
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B'\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u00a2\u0006\u0004\b\n\u0010\u000bJ\b\u0010\f\u001a\u00020\rH\u0016\u00a8\u0006\u000e"}, d2={"Lnet/thebrokenscript/util/CustomGoals$ThrottledAvoidGoal;", "Lnet/minecraft/world/entity/ai/goal/AvoidEntityGoal;", "Lnet/minecraft/world/entity/player/Player;", "entity", "Lnet/minecraft/world/entity/PathfinderMob;", "distance", "", "walkSpeed", "", "sprintSpeed", "<init>", "(Lnet/minecraft/world/entity/PathfinderMob;FDD)V", "tick", "", "thebrokenscript-common"})
    public static final class ThrottledAvoidGoal
    extends AvoidEntityGoal<Player> {
        public ThrottledAvoidGoal(@NotNull PathfinderMob entity, float distance, double walkSpeed, double sprintSpeed) {
            Intrinsics.checkNotNullParameter((Object)entity, (String)"entity");
            super(entity, Player.class, distance, walkSpeed, sprintSpeed);
        }

        public void tick() {
            if (this.mob.tickCount % 10 == 0) {
                super.tick();
            }
        }
    }
}

