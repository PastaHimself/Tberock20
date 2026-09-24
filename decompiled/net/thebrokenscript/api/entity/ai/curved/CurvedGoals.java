/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Vec3i
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.PathfinderMob
 *  net.minecraft.world.entity.ai.attributes.Attributes
 *  net.minecraft.world.entity.ai.goal.Goal
 *  net.minecraft.world.entity.ai.goal.Goal$Flag
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.level.GameType
 *  net.minecraft.world.level.pathfinder.Path
 *  net.minecraft.world.phys.AABB
 *  net.minecraft.world.phys.Vec3
 *  net.thebrokenscript.brokencore.api.dsl.PlayerUtil
 *  net.thebrokenscript.brokencore.api.entity.base.BaseMonster
 *  net.thebrokenscript.brokencore.api.ext.BaseMonsterExtKt
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.api.entity.ai.curved;

import java.util.EnumSet;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Vec3i;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.pathfinder.Path;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.brokencore.api.dsl.PlayerUtil;
import net.thebrokenscript.brokencore.api.entity.base.BaseMonster;
import net.thebrokenscript.brokencore.api.ext.BaseMonsterExtKt;
import net.thebrokenscript.entity.players.CurvedEntity;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0007"}, d2={"Lnet/thebrokenscript/api/entity/ai/curved/CurvedGoals;", "", "<init>", "()V", "InvestigateBlockBreakGoal", "AlwaysTargetPlayerGoal", "ContinuousMeleeAttackGoal", "thebrokenscript-common"})
public final class CurvedGoals {
    @NotNull
    public static final CurvedGoals INSTANCE = new CurvedGoals();

    private CurvedGoals() {
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0004\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0010\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\b\u0010\u0018\u001a\u00020\u0011H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2={"Lnet/thebrokenscript/api/entity/ai/curved/CurvedGoals$AlwaysTargetPlayerGoal;", "Lnet/minecraft/world/entity/ai/goal/Goal;", "mob", "Lnet/thebrokenscript/entity/players/CurvedEntity;", "distance", "", "<init>", "(Lnet/thebrokenscript/entity/players/CurvedEntity;Ljava/lang/Number;)V", "getDistance", "()Ljava/lang/Number;", "persistTicks", "", "noticeCooldown", "lastPlayerPos", "Lnet/minecraft/world/phys/Vec3;", "blockBreakNavCooldown", "tick", "", "canUse", "", "isMovingTooMuch", "player", "Lnet/minecraft/world/entity/player/Player;", "canHearPlayer", "stop", "Companion", "thebrokenscript-common"})
    public static final class AlwaysTargetPlayerGoal
    extends Goal {
        @NotNull
        public static final Companion Companion = new Companion(null);
        @NotNull
        private final CurvedEntity mob;
        @NotNull
        private final Number distance;
        private int persistTicks;
        private int noticeCooldown;
        @Nullable
        private Vec3 lastPlayerPos;
        private int blockBreakNavCooldown;
        private static final double MOVEMENT_THRESHOLD = 0.05;
        private static final double SOUND_RANGE = 16.0;
        private static final double SPRINT_SOUND_RANGE = 24.0;

        public AlwaysTargetPlayerGoal(@NotNull CurvedEntity mob, @NotNull Number distance) {
            Intrinsics.checkNotNullParameter((Object)((Object)mob), (String)"mob");
            Intrinsics.checkNotNullParameter((Object)distance, (String)"distance");
            this.mob = mob;
            this.distance = distance;
            this.setFlags(EnumSet.of((Enum)Goal.Flag.TARGET));
        }

        @NotNull
        public final Number getDistance() {
            return this.distance;
        }

        public void tick() {
            int n;
            if (this.noticeCooldown > 0) {
                n = this.noticeCooldown;
                this.noticeCooldown = n + -1;
            }
            if (this.persistTicks > 0) {
                n = this.persistTicks;
                this.persistTicks = n + -1;
            }
            if (this.blockBreakNavCooldown > 0) {
                n = this.blockBreakNavCooldown;
                this.blockBreakNavCooldown = n + -1;
            }
        }

        public boolean canUse() {
            boolean detected;
            Player player;
            block10: {
                block9: {
                    player = this.mob.getLevel().getNearestPlayer((Entity)this.mob, this.distance.doubleValue());
                    if (player == null) {
                        if (this.persistTicks <= 0) {
                            this.mob.setTarget(null);
                        }
                        return this.persistTicks > 0 && this.mob.getTarget() != null;
                    }
                    if (!player.isAlive()) break block9;
                    GameType gameType = PlayerUtil.getGameMode((Player)player);
                    if (gameType != null ? gameType.isSurvival() : false) break block10;
                }
                return false;
            }
            boolean bl = detected = this.isMovingTooMuch(player) || this.canHearPlayer(player);
            if (detected || this.mob.getLevel().canSeeSkyFromBelowWater(this.mob.getBlockPos()) && (BaseMonsterExtKt.hasLineOfSightThroughTransparent((BaseMonster)((BaseMonster)this.mob), (Player)player) || this.mob.hasLineOfSight((Entity)player)) || player.distanceToSqr((Entity)this.mob) < 9.0) {
                this.mob.setTarget((LivingEntity)player);
                this.mob.getLookControl().setLookAt((Entity)player);
                this.persistTicks = 50;
                if (this.mob.getTransformed() && !this.mob.getLevel().canSeeSkyFromBelowWater(this.mob.getBlockPos()) && this.noticeCooldown <= 0) {
                    this.mob.noticePlayer(player);
                    this.noticeCooldown = 40;
                }
                return true;
            }
            if (this.persistTicks > 0) {
                if (this.mob.getBlockBreakAlertTicks() > 0) {
                    this.mob.setTarget(null);
                    this.persistTicks = 0;
                    return false;
                }
                return true;
            }
            return false;
        }

        private final boolean isMovingTooMuch(Player player) {
            if (player.isCrouching()) {
                return false;
            }
            Vec3 currentPos = player.position();
            Vec3 prev = this.lastPlayerPos;
            double moved = prev != null ? new Vec3(currentPos.x - prev.x, 0.0, currentPos.z - prev.z).length() : 0.0;
            this.lastPlayerPos = currentPos;
            return moved > 0.05;
        }

        private final boolean canHearPlayer(Player player) {
            double hearRangeSq;
            if (player.isCrouching()) {
                return false;
            }
            double distSq = this.mob.distanceToSqr((Entity)player);
            double d = hearRangeSq = player.isSprinting() ? 576.0 : 256.0;
            boolean isSteppingAround = player.onGround() && (!(player.getDeltaMovement().x == 0.0) || !(player.getDeltaMovement().z == 0.0));
            return distSq <= hearRangeSq && isSteppingAround;
        }

        public void stop() {
            this.mob.setTarget(null);
            this.lastPlayerPos = null;
            super.stop();
        }

        @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2={"Lnet/thebrokenscript/api/entity/ai/curved/CurvedGoals$AlwaysTargetPlayerGoal$Companion;", "", "<init>", "()V", "MOVEMENT_THRESHOLD", "", "SOUND_RANGE", "SPRINT_SOUND_RANGE", "thebrokenscript-common"})
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
                this();
            }
        }
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u00a2\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0017H\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u001aH\u0016J\u0010\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u0010\u0010\u001f\u001a\u00020\u00172\u0006\u0010 \u001a\u00020\u0013H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\rX\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\rX\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\rX\u0082D\u00a2\u0006\u0002\n\u0000\u00a8\u0006!"}, d2={"Lnet/thebrokenscript/api/entity/ai/curved/CurvedGoals$ContinuousMeleeAttackGoal;", "Lnet/minecraft/world/entity/ai/goal/Goal;", "mob", "Lnet/minecraft/world/entity/PathfinderMob;", "speedModifier", "", "slowedSpeedModifier", "attackRange", "", "slowdownRange", "<init>", "(Lnet/minecraft/world/entity/PathfinderMob;DDFF)V", "ticksUntilNextAttack", "", "ticksUntilNextPathRecalculation", "attackInterval", "pathRecalculationInterval", "pathfindingStuckTimer", "lastMobPos", "Lnet/minecraft/world/phys/Vec3;", "movementCooldown", "movementCooldownDuration", "canUse", "", "canContinueToUse", "stop", "", "tick", "checkAndDoAttack", "target", "Lnet/minecraft/world/entity/LivingEntity;", "isStuck", "currentPos", "thebrokenscript-common"})
    public static final class ContinuousMeleeAttackGoal
    extends Goal {
        @NotNull
        private final PathfinderMob mob;
        private final double speedModifier;
        private final double slowedSpeedModifier;
        private final float attackRange;
        private final float slowdownRange;
        private int ticksUntilNextAttack;
        private int ticksUntilNextPathRecalculation;
        private final int attackInterval;
        private final int pathRecalculationInterval;
        private int pathfindingStuckTimer;
        @Nullable
        private Vec3 lastMobPos;
        private int movementCooldown;
        private final int movementCooldownDuration;

        public ContinuousMeleeAttackGoal(@NotNull PathfinderMob mob, double speedModifier, double slowedSpeedModifier, float attackRange, float slowdownRange) {
            Intrinsics.checkNotNullParameter((Object)mob, (String)"mob");
            this.mob = mob;
            this.speedModifier = speedModifier;
            this.slowedSpeedModifier = slowedSpeedModifier;
            this.attackRange = attackRange;
            this.slowdownRange = slowdownRange;
            this.attackInterval = 10;
            this.pathRecalculationInterval = 10;
            this.movementCooldownDuration = 6;
            this.setFlags(EnumSet.of((Enum)Goal.Flag.MOVE, (Enum)Goal.Flag.LOOK));
        }

        public /* synthetic */ ContinuousMeleeAttackGoal(PathfinderMob pathfinderMob, double d, double d2, float f, float f2, int n, DefaultConstructorMarker defaultConstructorMarker) {
            if ((n & 4) != 0) {
                d2 = d - 0.1;
            }
            if ((n & 8) != 0) {
                f = 1.2f;
            }
            if ((n & 0x10) != 0) {
                f2 = 12.0f;
            }
            this(pathfinderMob, d, d2, f, f2);
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
            PathfinderMob pathfinderMob = this.mob;
            if (!(pathfinderMob instanceof CurvedEntity)) return false;
            CurvedEntity curvedEntity = (CurvedEntity)pathfinderMob;
            if (curvedEntity == null) return false;
            if (!curvedEntity.getTransformed()) return false;
            boolean bl = true;
            if (!bl) return false;
            Player player2 = player;
            if ((player2 != null ? PlayerUtil.getGameMode((Player)player2) : null) == GameType.CREATIVE) return false;
            Player player3 = player;
            if ((player3 != null ? PlayerUtil.getGameMode((Player)player3) : null) == GameType.SPECTATOR) return false;
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
            boolean targetMovedFar;
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
            boolean bl = targetMovedFar = this.mob.getNavigation().isDone() && distanceSqr > (double)(this.attackRange * this.attackRange);
            if (this.ticksUntilNextPathRecalculation <= 0 || targetMovedFar) {
                int n3 = this.ticksUntilNextPathRecalculation = distanceSqr > (double)(this.slowdownRange * this.slowdownRange) ? 3 : this.pathRecalculationInterval;
                if (distanceSqr > (double)(this.attackRange * this.attackRange)) {
                    double speed = distanceSqr > (double)(this.slowdownRange * this.slowdownRange) ? this.speedModifier : this.slowedSpeedModifier;
                    LivingEntity livingEntity2 = this.mob.getTarget();
                    Intrinsics.checkNotNull((Object)livingEntity2);
                    if (this.mob.hasLineOfSight((Entity)livingEntity2)) {
                        Path path = this.mob.getNavigation().createPath((Entity)target, 0);
                        boolean bl2 = path != null ? this.mob.getNavigation().moveTo(path, speed) : this.mob.getNavigation().moveTo((Entity)target, speed);
                    } else {
                        Path path = this.mob.getNavigation().createPath((Entity)target, 0);
                        if (path != null && !this.mob.getMoveControl().hasWanted()) {
                            this.mob.getNavigation().moveTo(path, speed - 0.15);
                        } else {
                            this.mob.getNavigation().stop();
                            this.mob.getMoveControl().setWantedPosition(target.getX(), target.getY(), target.getZ(), speed);
                        }
                    }
                } else {
                    this.mob.getNavigation().stop();
                }
            }
            this.ticksUntilNextAttack = Math.max(this.ticksUntilNextAttack - 1, 0);
            this.checkAndDoAttack(target);
        }

        private final void checkAndDoAttack(LivingEntity target) {
            AABB expandedBox = this.mob.getBoundingBox().inflate(this.mob.getBoundingBox().getXsize() * (double)this.attackRange, this.mob.getBoundingBox().getYsize() * 0.2, this.mob.getBoundingBox().getZsize() * (double)this.attackRange);
            if (expandedBox.intersects(target.getBoundingBox()) && this.ticksUntilNextAttack <= 0 && this.mob.hasLineOfSight((Entity)target)) {
                this.ticksUntilNextAttack = this.attackInterval;
                this.movementCooldown = this.movementCooldownDuration;
                this.mob.doHurtTarget((Entity)target);
                PathfinderMob pathfinderMob = this.mob;
                Intrinsics.checkNotNull((Object)pathfinderMob, (String)"null cannot be cast to non-null type net.thebrokenscript.entity.players.CurvedEntity");
                ((CurvedEntity)pathfinderMob).triggerAnim(null, "swing");
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

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\u0010\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0010\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0015H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2={"Lnet/thebrokenscript/api/entity/ai/curved/CurvedGoals$InvestigateBlockBreakGoal;", "Lnet/minecraft/world/entity/ai/goal/Goal;", "mob", "Lnet/thebrokenscript/entity/players/CurvedEntity;", "<init>", "(Lnet/thebrokenscript/entity/players/CurvedEntity;)V", "navCooldown", "", "noticeCooldown", "currentWanderTarget", "Lnet/minecraft/world/phys/Vec3;", "lastStage", "lastPlayerPos", "canUse", "", "canContinueToUse", "isMovingTooMuch", "player", "Lnet/minecraft/world/entity/player/Player;", "canHearPlayer", "stop", "", "tick", "Companion", "thebrokenscript-common"})
    public static final class InvestigateBlockBreakGoal
    extends Goal {
        @NotNull
        public static final Companion Companion = new Companion(null);
        @NotNull
        private final CurvedEntity mob;
        private int navCooldown;
        private int noticeCooldown;
        @Nullable
        private Vec3 currentWanderTarget;
        private int lastStage;
        @Nullable
        private Vec3 lastPlayerPos;
        private static final double MOVEMENT_THRESHOLD = 0.05;
        private static final double SOUND_RANGE = 16.0;
        private static final double SPRINT_SOUND_RANGE = 24.0;

        public InvestigateBlockBreakGoal(@NotNull CurvedEntity mob) {
            Intrinsics.checkNotNullParameter((Object)((Object)mob), (String)"mob");
            this.mob = mob;
            this.lastStage = -1;
            this.setFlags(EnumSet.of((Enum)Goal.Flag.MOVE, (Enum)Goal.Flag.LOOK));
        }

        public boolean canUse() {
            return this.mob.getBlockBreakAlertTicks() > 0 && this.mob.getBlockBreakAlertTarget() != null && !this.mob.isDead() && this.mob.getTransformed();
        }

        public boolean canContinueToUse() {
            if (this.mob.getTarget() != null) {
                return false;
            }
            if (this.mob.getBlockBreakAlertTicks() <= 0 && this.mob.getBlockBreakAlertTarget() == null) {
                return false;
            }
            if (!this.mob.getTransformed() || this.mob.isDead()) {
                return false;
            }
            Player player = this.mob.getBlockBreakAlertTarget();
            if (player == null) {
                return false;
            }
            Player player2 = player;
            if (this.isMovingTooMuch(player2) || this.canHearPlayer(player2)) {
                this.mob.setBlockBreakAlertTicks(0);
                this.mob.setBlockBreakAlertTarget(null);
                this.mob.setBlockBreakAlertStage(0);
                return false;
            }
            return true;
        }

        private final boolean isMovingTooMuch(Player player) {
            if (player.isCrouching()) {
                return false;
            }
            Vec3 currentPos = player.position();
            Vec3 prev = this.lastPlayerPos;
            double moved = prev != null ? new Vec3(currentPos.x - prev.x, 0.0, currentPos.z - prev.z).length() : 0.0;
            this.lastPlayerPos = currentPos;
            return moved > 0.05;
        }

        private final boolean canHearPlayer(Player player) {
            double hearRangeSq;
            if (player.isCrouching()) {
                return false;
            }
            double distSq = this.mob.distanceToSqr((Entity)player);
            double d = hearRangeSq = player.isSprinting() ? 576.0 : 256.0;
            return distSq <= hearRangeSq && player.onGround() && (!(player.getDeltaMovement().x == 0.0) || !(player.getDeltaMovement().z == 0.0));
        }

        public void stop() {
            this.mob.getNavigation().stop();
            this.navCooldown = 0;
            this.noticeCooldown = 0;
            this.lastPlayerPos = null;
            this.currentWanderTarget = null;
            this.lastStage = -1;
        }

        public void tick() {
            int n;
            if (this.navCooldown > 0) {
                n = this.navCooldown;
                this.navCooldown = n + -1;
            }
            if (this.noticeCooldown > 0) {
                n = this.noticeCooldown;
                this.noticeCooldown = n + -1;
            }
            Player player = this.mob.getBlockBreakAlertTarget();
            if (player == null) {
                return;
            }
            Player target = player;
            BlockPos realPos = target.blockPosition();
            if (this.currentWanderTarget == null || this.mob.getBlockBreakAlertStage() != this.lastStage) {
                Vec3 vec3;
                int radius;
                this.lastStage = this.mob.getBlockBreakAlertStage();
                int n2 = this.mob.getBlockBreakAlertStage() <= 1 ? 10 : (radius = this.mob.getBlockBreakAlertStage() == 2 ? 4 : 0);
                if (this.mob.getBlockBreakAlertStage() >= 3) {
                    this.mob.setTarget((LivingEntity)target);
                    this.mob.setBlockBreakAlertTicks(0);
                    this.mob.setBlockBreakAlertTarget(null);
                    this.mob.setBlockBreakAlertStage(0);
                    return;
                }
                if (radius > 0) {
                    double offsetX = this.mob.getRandom().nextInt(radius * 2 + 1) - radius;
                    double offsetZ = this.mob.getRandom().nextInt(radius * 2 + 1) - radius;
                    vec3 = new Vec3((double)realPos.getX() + offsetX + 0.5, (double)realPos.getY(), (double)realPos.getZ() + offsetZ + 0.5);
                } else {
                    vec3 = Vec3.atBottomCenterOf((Vec3i)((Vec3i)realPos));
                }
                this.currentWanderTarget = vec3;
            }
            Vec3 vec3 = this.currentWanderTarget;
            if (vec3 == null) {
                return;
            }
            Vec3 wanderPos = vec3;
            this.mob.getLookControl().setLookAt(wanderPos.x, wanderPos.y, wanderPos.z);
            if (this.mob.distanceToSqr(wanderPos) < 25.0) {
                this.currentWanderTarget = null;
                this.mob.setBlockBreakAlertTicks(0);
                this.mob.setBlockBreakAlertTarget(null);
                this.mob.setBlockBreakAlertStage(0);
            } else if (this.navCooldown <= 0) {
                double speed = this.mob.getAttributeValue(Attributes.MOVEMENT_SPEED) + 0.2;
                boolean moved = this.mob.getNavigation().moveTo(wanderPos.x, wanderPos.y, wanderPos.z, speed);
                if (!moved) {
                    this.mob.getNavigation().moveTo((double)realPos.getX(), (double)realPos.getY(), (double)realPos.getZ(), speed);
                }
                this.navCooldown = 20;
                if (this.mob.getTransformed() && !this.mob.getLevel().canSeeSkyFromBelowWater(this.mob.getBlockPos()) && this.noticeCooldown <= 0) {
                    this.mob.noticePlayer(target);
                    this.noticeCooldown = 40;
                }
            }
        }

        @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2={"Lnet/thebrokenscript/api/entity/ai/curved/CurvedGoals$InvestigateBlockBreakGoal$Companion;", "", "<init>", "()V", "MOVEMENT_THRESHOLD", "", "SOUND_RANGE", "SPRINT_SOUND_RANGE", "thebrokenscript-common"})
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
                this();
            }
        }
    }
}

