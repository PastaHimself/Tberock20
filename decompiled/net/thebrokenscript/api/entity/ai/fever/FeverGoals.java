/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.resources.ResourceKey
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.util.Mth
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.Mob
 *  net.minecraft.world.entity.ai.goal.Goal
 *  net.minecraft.world.entity.ai.goal.Goal$Flag
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.phys.AABB
 *  net.minecraft.world.phys.Vec3
 *  net.thebrokenscript.brokencore.api.dsl.ParticleUtil
 *  net.thebrokenscript.brokencore.api.dsl.PlayerUtil
 *  net.thebrokenscript.brokencore.api.entity.base.BaseMonster
 *  net.thebrokenscript.brokencore.api.ext.BaseMonsterExtKt
 *  net.thebrokenscript.brokencore.api.util.math.Vectors
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.api.entity.ai.fever;

import java.util.EnumSet;
import java.util.function.Supplier;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.api.TBSConstants;
import net.thebrokenscript.api.entity.BaseFeverEntity;
import net.thebrokenscript.brokencore.api.dsl.ParticleUtil;
import net.thebrokenscript.brokencore.api.dsl.PlayerUtil;
import net.thebrokenscript.brokencore.api.entity.base.BaseMonster;
import net.thebrokenscript.brokencore.api.ext.BaseMonsterExtKt;
import net.thebrokenscript.brokencore.api.util.math.Vectors;
import net.thebrokenscript.entity.fever.FeverEntity;
import net.thebrokenscript.registry.TBSParticleTypes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\b"}, d2={"Lnet/thebrokenscript/api/entity/ai/fever/FeverGoals;", "", "<init>", "()V", "FlyToPlayerGoal", "FlyToPlayerStalkGoal", "FlyToPlayerEnragedGoal", "FeverTargeting", "thebrokenscript-common"})
public final class FeverGoals {
    @NotNull
    public static final FeverGoals INSTANCE = new FeverGoals();

    private FeverGoals() {
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u00a2\u0006\u0004\b\b\u0010\tJ\b\u0010\n\u001a\u00020\u0007H\u0016J\b\u0010\u000b\u001a\u00020\u0007H\u0016J\b\u0010\f\u001a\u00020\rH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0004\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2={"Lnet/thebrokenscript/api/entity/ai/fever/FeverGoals$FeverTargeting;", "Lnet/minecraft/world/entity/ai/goal/Goal;", "mob", "Lnet/minecraft/world/entity/Mob;", "predicate", "Lkotlin/Function1;", "Lnet/minecraft/world/entity/LivingEntity;", "", "<init>", "(Lnet/minecraft/world/entity/Mob;Lkotlin/jvm/functions/Function1;)V", "canUse", "canContinueToUse", "stop", "", "thebrokenscript-common"})
    public static final class FeverTargeting
    extends Goal {
        @NotNull
        private final Mob mob;
        @NotNull
        private final Function1<LivingEntity, Boolean> predicate;

        public FeverTargeting(@NotNull Mob mob, @NotNull Function1<? super LivingEntity, Boolean> predicate) {
            Intrinsics.checkNotNullParameter((Object)mob, (String)"mob");
            Intrinsics.checkNotNullParameter(predicate, (String)"predicate");
            this.mob = mob;
            this.predicate = predicate;
            this.setFlags(EnumSet.of((Enum)Goal.Flag.TARGET));
        }

        public /* synthetic */ FeverTargeting(Mob mob, Function1 function1, int n, DefaultConstructorMarker defaultConstructorMarker) {
            if ((n & 2) != 0) {
                function1 = FeverTargeting::_init_$lambda$0;
            }
            this(mob, (Function1<? super LivingEntity, Boolean>)function1);
        }

        public boolean canUse() {
            Player player = this.mob.level().getNearestPlayer((Entity)this.mob, -1.0);
            if (player == null) {
                return false;
            }
            Player targetPlayer = player;
            if (targetPlayer.isSpectator()) {
                return false;
            }
            if (targetPlayer.isDeadOrDying()) {
                return false;
            }
            if (!targetPlayer.level().dimension().equals((Object)this.mob.level().dimension())) {
                return false;
            }
            if (!((Boolean)this.predicate.invoke((Object)targetPlayer)).booleanValue()) {
                return false;
            }
            this.mob.setTarget((LivingEntity)targetPlayer);
            return true;
        }

        /*
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        public boolean canContinueToUse() {
            if (this.mob.getTarget() == null) return false;
            LivingEntity livingEntity = this.mob.getTarget();
            if (livingEntity == null) return false;
            if (!livingEntity.isAlive()) return false;
            boolean bl = true;
            if (!bl) return false;
            if ((Boolean)this.predicate.invoke((Object)this.mob.getTarget()) == false) return false;
            LivingEntity livingEntity2 = this.mob.getTarget();
            if (livingEntity2 == null) return false;
            if (livingEntity2.isSpectator()) return false;
            boolean bl2 = true;
            if (!bl2) return false;
            LivingEntity livingEntity3 = this.mob.getTarget();
            LivingEntity livingEntity4 = livingEntity3;
            if (livingEntity3 == null) return false;
            Level level = livingEntity4.level();
            livingEntity4 = level;
            if (level == null) return false;
            ResourceKey resourceKey = livingEntity4.dimension();
            livingEntity4 = resourceKey;
            if (resourceKey == null) return false;
            if (!livingEntity4.equals((Object)this.mob.level().dimension())) return false;
            return true;
        }

        public void stop() {
            super.stop();
            this.mob.setTarget(null);
        }

        private static final boolean _init_$lambda$0(LivingEntity it) {
            return true;
        }
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0012\u001a\u00020\tH\u0016J\b\u0010\u0013\u001a\u00020\tH\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0015H\u0016J\b\u0010\u0017\u001a\u00020\u0015H\u0016J\u0010\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u001aH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082D\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001b"}, d2={"Lnet/thebrokenscript/api/entity/ai/fever/FeverGoals$FlyToPlayerEnragedGoal;", "Lnet/minecraft/world/entity/ai/goal/Goal;", "mob", "Lnet/thebrokenscript/api/entity/BaseFeverEntity;", "speed", "", "targetPredicate", "Lkotlin/Function1;", "Lnet/minecraft/world/entity/player/Player;", "", "<init>", "(Lnet/thebrokenscript/api/entity/BaseFeverEntity;DLkotlin/jvm/functions/Function1;)V", "targetPlayer", "ticksUntilNextAttack", "", "attackInterval", "attackRange", "", "canUse", "canContinueToUse", "start", "", "stop", "tick", "checkAndDoAttack", "target", "Lnet/minecraft/world/entity/LivingEntity;", "thebrokenscript-common"})
    public static final class FlyToPlayerEnragedGoal
    extends Goal {
        @NotNull
        private final BaseFeverEntity mob;
        private final double speed;
        @NotNull
        private final Function1<Player, Boolean> targetPredicate;
        @Nullable
        private Player targetPlayer;
        private int ticksUntilNextAttack;
        private final int attackInterval;
        private final float attackRange;

        public FlyToPlayerEnragedGoal(@NotNull BaseFeverEntity mob, double speed, @NotNull Function1<? super Player, Boolean> targetPredicate) {
            Intrinsics.checkNotNullParameter((Object)((Object)mob), (String)"mob");
            Intrinsics.checkNotNullParameter(targetPredicate, (String)"targetPredicate");
            this.mob = mob;
            this.speed = speed;
            this.targetPredicate = targetPredicate;
            this.attackInterval = 10;
            this.attackRange = 1.2f;
            this.setFlags(EnumSet.of((Enum)Goal.Flag.MOVE, (Enum)Goal.Flag.LOOK, (Enum)Goal.Flag.TARGET));
        }

        public /* synthetic */ FlyToPlayerEnragedGoal(BaseFeverEntity baseFeverEntity, double d, Function1 function1, int n, DefaultConstructorMarker defaultConstructorMarker) {
            if ((n & 4) != 0) {
                function1 = FlyToPlayerEnragedGoal::_init_$lambda$0;
            }
            this(baseFeverEntity, d, (Function1<? super Player, Boolean>)function1);
        }

        /*
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        public boolean canUse() {
            if (!(this.mob.getTarget() instanceof Player)) return false;
            LivingEntity livingEntity = this.mob.getTarget();
            if (livingEntity == null) return false;
            if (!livingEntity.isAlive()) return false;
            boolean bl = true;
            if (!bl) return false;
            LivingEntity livingEntity2 = this.mob.getTarget();
            if (livingEntity2 == null) return false;
            if (livingEntity2.isSpectator()) return false;
            boolean bl2 = true;
            if (!bl2) return false;
            LivingEntity livingEntity3 = this.mob.getTarget();
            Intrinsics.checkNotNull((Object)livingEntity3, (String)"null cannot be cast to non-null type net.minecraft.world.entity.player.Player");
            if ((Boolean)this.targetPredicate.invoke((Object)((Player)livingEntity3)) == false) return false;
            return true;
        }

        /*
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        public boolean canContinueToUse() {
            if (!(this.mob.getTarget() instanceof Player)) return false;
            LivingEntity livingEntity = this.mob.getTarget();
            if (livingEntity == null) return false;
            if (!livingEntity.isAlive()) return false;
            boolean bl = true;
            if (!bl) return false;
            LivingEntity livingEntity2 = this.mob.getTarget();
            if (livingEntity2 == null) return false;
            if (livingEntity2.isSpectator()) return false;
            boolean bl2 = true;
            if (!bl2) return false;
            LivingEntity livingEntity3 = this.mob.getTarget();
            Intrinsics.checkNotNull((Object)livingEntity3, (String)"null cannot be cast to non-null type net.minecraft.world.entity.player.Player");
            if ((Boolean)this.targetPredicate.invoke((Object)((Player)livingEntity3)) == false) return false;
            return true;
        }

        public void start() {
            LivingEntity livingEntity = this.mob.getTarget();
            this.targetPlayer = livingEntity instanceof Player ? (Player)livingEntity : null;
            this.ticksUntilNextAttack = this.attackInterval;
        }

        public void stop() {
            this.targetPlayer = null;
            this.ticksUntilNextAttack = 0;
        }

        public void tick() {
            Player player = this.targetPlayer;
            if (player == null) {
                return;
            }
            Player player2 = player;
            if (this.mob instanceof FeverEntity && !this.mob.canMove()) {
                return;
            }
            Vec3 toTarget = player2.position().subtract(this.mob.position());
            if (toTarget.lengthSqr() < 1.0E-4) {
                return;
            }
            Vec3 desired = toTarget.normalize().scale(this.speed);
            this.mob.setDeltaMovement(this.mob.getDeltaMovement().lerp(desired, 0.3));
            double horizDist = Math.sqrt(toTarget.x * toTarget.x + toTarget.z * toTarget.z);
            double targetYaw = Mth.atan2((double)toTarget.z, (double)toTarget.x) * 57.29577951308232 - 90.0;
            double targetPitch = -(Mth.atan2((double)toTarget.y, (double)horizDist) * 57.29577951308232);
            this.mob.setYRot(Mth.approachDegrees((float)this.mob.getYRot(), (float)((float)targetYaw), (float)20.0f));
            this.mob.yBodyRot = this.mob.getYRot();
            this.mob.setXRot(Mth.approachDegrees((float)this.mob.getXRot(), (float)((float)targetPitch), (float)20.0f));
            this.mob.getLookControl().setLookAt((Entity)player2);
            this.ticksUntilNextAttack = Math.max(this.ticksUntilNextAttack - 1, 0);
            this.checkAndDoAttack((LivingEntity)player2);
        }

        private final void checkAndDoAttack(LivingEntity target) {
            AABB expandedBox = this.mob.getBoundingBox().inflate(this.mob.getBoundingBox().getXsize() * (double)this.attackRange, this.mob.getBoundingBox().getYsize() * 0.2, this.mob.getBoundingBox().getZsize() * (double)this.attackRange);
            boolean intersects = expandedBox.intersects(target.getBoundingBox());
            boolean canHit = this.ticksUntilNextAttack <= 0;
            BaseMonster baseMonster = (BaseMonster)this.mob;
            Intrinsics.checkNotNull((Object)target, (String)"null cannot be cast to non-null type net.minecraft.world.entity.player.Player");
            boolean hasLoS = BaseMonsterExtKt.hasLineOfSightThroughTransparent((BaseMonster)baseMonster, (Player)((Player)target));
            if (intersects && canHit && hasLoS) {
                this.ticksUntilNextAttack = this.attackInterval;
                this.mob.doHurtTarget((Entity)target);
                if (((Player)target).isDeadOrDying()) {
                    this.mob.discard();
                }
            }
        }

        private static final boolean _init_$lambda$0(Player it) {
            Intrinsics.checkNotNullParameter((Object)it, (String)"it");
            return true;
        }
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\b\u0010\u0015\u001a\u00020\u0013H\u0016J\u0010\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0018H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082D\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0019"}, d2={"Lnet/thebrokenscript/api/entity/ai/fever/FeverGoals$FlyToPlayerGoal;", "Lnet/minecraft/world/entity/ai/goal/Goal;", "mob", "Lnet/thebrokenscript/api/entity/BaseFeverEntity;", "speed", "", "<init>", "(Lnet/thebrokenscript/api/entity/BaseFeverEntity;D)V", "targetPlayer", "Lnet/minecraft/world/entity/player/Player;", "ticksUntilNextAttack", "", "attackInterval", "attackRange", "", "canUse", "", "canContinueToUse", "start", "", "stop", "tick", "checkAndDoAttack", "target", "Lnet/minecraft/world/entity/LivingEntity;", "thebrokenscript-common"})
    public static final class FlyToPlayerGoal
    extends Goal {
        @NotNull
        private final BaseFeverEntity mob;
        private final double speed;
        @Nullable
        private Player targetPlayer;
        private int ticksUntilNextAttack;
        private final int attackInterval;
        private final float attackRange;

        public FlyToPlayerGoal(@NotNull BaseFeverEntity mob, double speed) {
            Intrinsics.checkNotNullParameter((Object)((Object)mob), (String)"mob");
            this.mob = mob;
            this.speed = speed;
            this.attackInterval = 10;
            this.attackRange = 1.2f;
            this.setFlags(EnumSet.of((Enum)Goal.Flag.MOVE, (Enum)Goal.Flag.LOOK, (Enum)Goal.Flag.TARGET));
        }

        /*
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        public boolean canUse() {
            if (!(this.mob.getTarget() instanceof Player)) return false;
            LivingEntity livingEntity = this.mob.getTarget();
            if (livingEntity == null) return false;
            if (!livingEntity.isAlive()) return false;
            boolean bl = true;
            if (!bl) return false;
            LivingEntity livingEntity2 = this.mob.getTarget();
            if (livingEntity2 == null) return false;
            if (livingEntity2.isSpectator()) return false;
            return true;
        }

        /*
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        public boolean canContinueToUse() {
            if (!(this.mob.getTarget() instanceof Player)) return false;
            LivingEntity livingEntity = this.mob.getTarget();
            if (livingEntity == null) return false;
            if (!livingEntity.isAlive()) return false;
            boolean bl = true;
            if (!bl) return false;
            LivingEntity livingEntity2 = this.mob.getTarget();
            if (livingEntity2 == null) return false;
            if (livingEntity2.isSpectator()) return false;
            return true;
        }

        public void start() {
            LivingEntity livingEntity = this.mob.getTarget();
            this.targetPlayer = livingEntity instanceof Player ? (Player)livingEntity : null;
            this.ticksUntilNextAttack = this.attackInterval;
        }

        public void stop() {
            this.targetPlayer = null;
            this.ticksUntilNextAttack = 0;
        }

        public void tick() {
            Player player = this.targetPlayer;
            if (player == null) {
                return;
            }
            Player player2 = player;
            if (this.mob instanceof FeverEntity && !this.mob.canMove()) {
                return;
            }
            Vec3 toTarget = player2.position().subtract(this.mob.position());
            if (toTarget.lengthSqr() < 1.0E-4) {
                return;
            }
            Vec3 desired = toTarget.normalize().scale(this.speed);
            this.mob.setDeltaMovement(this.mob.getDeltaMovement().lerp(desired, 0.3));
            double horizDist = Math.sqrt(toTarget.x * toTarget.x + toTarget.z * toTarget.z);
            double targetYaw = Mth.atan2((double)toTarget.z, (double)toTarget.x) * 57.29577951308232 - 90.0;
            double targetPitch = -(Mth.atan2((double)toTarget.y, (double)horizDist) * 57.29577951308232);
            this.mob.setYRot(Mth.approachDegrees((float)this.mob.getYRot(), (float)((float)targetYaw), (float)20.0f));
            this.mob.yBodyRot = this.mob.getYRot();
            this.mob.setXRot(Mth.approachDegrees((float)this.mob.getXRot(), (float)((float)targetPitch), (float)20.0f));
            this.mob.getLookControl().setLookAt((Entity)player2);
            this.ticksUntilNextAttack = Math.max(this.ticksUntilNextAttack - 1, 0);
            this.checkAndDoAttack((LivingEntity)player2);
        }

        private final void checkAndDoAttack(LivingEntity target) {
            AABB expandedBox = this.mob.getBoundingBox().inflate(this.mob.getBoundingBox().getXsize() * (double)this.attackRange, this.mob.getBoundingBox().getYsize() * 0.2, this.mob.getBoundingBox().getZsize() * (double)this.attackRange);
            boolean intersects = expandedBox.intersects(target.getBoundingBox());
            boolean canHit = this.ticksUntilNextAttack <= 0;
            BaseMonster baseMonster = (BaseMonster)this.mob;
            Intrinsics.checkNotNull((Object)target, (String)"null cannot be cast to non-null type net.minecraft.world.entity.player.Player");
            boolean hasLoS = BaseMonsterExtKt.hasLineOfSightThroughTransparent((BaseMonster)baseMonster, (Player)((Player)target));
            if (intersects && canHit && hasLoS) {
                this.ticksUntilNextAttack = this.attackInterval;
                this.mob.doHurtTarget((Entity)target);
            }
        }
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u000f\u001a\u00020\tH\u0016J\b\u0010\u0010\u001a\u00020\tH\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\b\u0010\u0014\u001a\u00020\u0012H\u0016J\u0010\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0017H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082D\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2={"Lnet/thebrokenscript/api/entity/ai/fever/FeverGoals$FlyToPlayerStalkGoal;", "Lnet/minecraft/world/entity/ai/goal/Goal;", "mob", "Lnet/thebrokenscript/api/entity/BaseFeverEntity;", "speed", "", "targetPredicate", "Lkotlin/Function1;", "Lnet/minecraft/world/entity/player/Player;", "", "<init>", "(Lnet/thebrokenscript/api/entity/BaseFeverEntity;DLkotlin/jvm/functions/Function1;)V", "targetPlayer", "discardRange", "", "canUse", "canContinueToUse", "start", "", "stop", "tick", "checkAndDiscard", "target", "Lnet/minecraft/world/entity/LivingEntity;", "thebrokenscript-common"})
    public static final class FlyToPlayerStalkGoal
    extends Goal {
        @NotNull
        private final BaseFeverEntity mob;
        private final double speed;
        @NotNull
        private final Function1<Player, Boolean> targetPredicate;
        @Nullable
        private Player targetPlayer;
        private final float discardRange;

        public FlyToPlayerStalkGoal(@NotNull BaseFeverEntity mob, double speed, @NotNull Function1<? super Player, Boolean> targetPredicate) {
            Intrinsics.checkNotNullParameter((Object)((Object)mob), (String)"mob");
            Intrinsics.checkNotNullParameter(targetPredicate, (String)"targetPredicate");
            this.mob = mob;
            this.speed = speed;
            this.targetPredicate = targetPredicate;
            this.discardRange = 1.2f;
            this.setFlags(EnumSet.of((Enum)Goal.Flag.MOVE, (Enum)Goal.Flag.LOOK, (Enum)Goal.Flag.TARGET));
        }

        public /* synthetic */ FlyToPlayerStalkGoal(BaseFeverEntity baseFeverEntity, double d, Function1 function1, int n, DefaultConstructorMarker defaultConstructorMarker) {
            if ((n & 4) != 0) {
                function1 = FlyToPlayerStalkGoal::_init_$lambda$0;
            }
            this(baseFeverEntity, d, (Function1<? super Player, Boolean>)function1);
        }

        /*
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        public boolean canUse() {
            if (!(this.mob.getTarget() instanceof Player)) return false;
            LivingEntity livingEntity = this.mob.getTarget();
            if (livingEntity == null) return false;
            if (!livingEntity.isAlive()) return false;
            boolean bl = true;
            if (!bl) return false;
            LivingEntity livingEntity2 = this.mob.getTarget();
            if (livingEntity2 == null) return false;
            if (livingEntity2.isSpectator()) return false;
            boolean bl2 = true;
            if (!bl2) return false;
            LivingEntity livingEntity3 = this.mob.getTarget();
            Intrinsics.checkNotNull((Object)livingEntity3, (String)"null cannot be cast to non-null type net.minecraft.world.entity.player.Player");
            if ((Boolean)this.targetPredicate.invoke((Object)((Player)livingEntity3)) == false) return false;
            return true;
        }

        /*
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        public boolean canContinueToUse() {
            if (!(this.mob.getTarget() instanceof Player)) return false;
            LivingEntity livingEntity = this.mob.getTarget();
            if (livingEntity == null) return false;
            if (!livingEntity.isAlive()) return false;
            boolean bl = true;
            if (!bl) return false;
            LivingEntity livingEntity2 = this.mob.getTarget();
            if (livingEntity2 == null) return false;
            if (livingEntity2.isSpectator()) return false;
            boolean bl2 = true;
            if (!bl2) return false;
            LivingEntity livingEntity3 = this.mob.getTarget();
            Intrinsics.checkNotNull((Object)livingEntity3, (String)"null cannot be cast to non-null type net.minecraft.world.entity.player.Player");
            if ((Boolean)this.targetPredicate.invoke((Object)((Player)livingEntity3)) == false) return false;
            return true;
        }

        public void start() {
            LivingEntity livingEntity = this.mob.getTarget();
            this.targetPlayer = livingEntity instanceof Player ? (Player)livingEntity : null;
        }

        public void stop() {
            this.targetPlayer = null;
        }

        public void tick() {
            Player player = this.targetPlayer;
            if (player == null) {
                return;
            }
            Player player2 = player;
            if (this.mob instanceof FeverEntity && !this.mob.canMove()) {
                return;
            }
            Vec3 toTarget = player2.position().subtract(this.mob.position());
            if (toTarget.lengthSqr() < 1.0E-4) {
                return;
            }
            Vec3 desired = toTarget.normalize().scale(this.speed);
            this.mob.setDeltaMovement(this.mob.getDeltaMovement().lerp(desired, 0.3));
            double horizDist = Math.sqrt(toTarget.x * toTarget.x + toTarget.z * toTarget.z);
            double targetYaw = Mth.atan2((double)toTarget.z, (double)toTarget.x) * 57.29577951308232 - 90.0;
            double targetPitch = -(Mth.atan2((double)toTarget.y, (double)horizDist) * 57.29577951308232);
            this.mob.setYRot(Mth.approachDegrees((float)this.mob.getYRot(), (float)((float)targetYaw), (float)20.0f));
            this.mob.yBodyRot = this.mob.getYRot();
            this.mob.setXRot(Mth.approachDegrees((float)this.mob.getXRot(), (float)((float)targetPitch), (float)20.0f));
            this.mob.getLookControl().setLookAt((Entity)player2);
            this.checkAndDiscard((LivingEntity)player2);
        }

        private final void checkAndDiscard(LivingEntity target) {
            Level level = this.mob.getLevel();
            Intrinsics.checkNotNull((Object)level, (String)"null cannot be cast to non-null type net.minecraft.server.level.ServerLevel");
            ServerLevel serverLevel = (ServerLevel)level;
            AABB expandedBox = this.mob.getBoundingBox().inflate(this.mob.getBoundingBox().getXsize() * (double)this.discardRange, this.mob.getBoundingBox().getYsize() * 0.2, this.mob.getBoundingBox().getZsize() * (double)this.discardRange);
            boolean intersects = expandedBox.intersects(target.getBoundingBox());
            BaseMonster baseMonster = (BaseMonster)this.mob;
            Intrinsics.checkNotNull((Object)target, (String)"null cannot be cast to non-null type net.minecraft.world.entity.player.Player");
            boolean hasLoS = BaseMonsterExtKt.hasLineOfSightThroughTransparent((BaseMonster)baseMonster, (Player)((Player)target));
            if (intersects && hasLoS) {
                PlayerUtil.trySendOverlay((Player)((Player)target), (ResourceLocation)TBSConstants.id("textures/screens/be_not_afraid.png"), (long)6L);
                ParticleUtil.sendParticles((ServerLevel)serverLevel, (Supplier)((Supplier)TBSParticleTypes.EYES), (Vec3)this.mob.getPos(), (Number)50, (Vec3)Vectors.INSTANCE.all((Number)3), (Number)0);
                this.mob.discard();
            }
        }

        private static final boolean _init_$lambda$0(Player it) {
            Intrinsics.checkNotNullParameter((Object)it, (String)"it");
            return true;
        }
    }
}

