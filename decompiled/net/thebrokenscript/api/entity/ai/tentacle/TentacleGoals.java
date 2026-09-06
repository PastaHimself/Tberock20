/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.Mob
 *  net.minecraft.world.entity.ai.attributes.Attributes
 *  net.minecraft.world.entity.ai.goal.Goal
 *  net.minecraft.world.entity.ai.goal.Goal$Flag
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.phys.Vec3
 *  net.thebrokenscript.brokencore.api.dsl.EntityFinder
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.api.entity.ai.tentacle;

import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.brokencore.api.dsl.EntityFinder;
import net.thebrokenscript.entity.boss.VoidTentacleEntity;
import net.thebrokenscript.entity.integrity.phase3.IntegrityP3GroundArmEntity;
import net.thebrokenscript.entity.integrity.phase3.IntegrityPhase3Entity;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0006"}, d2={"Lnet/thebrokenscript/api/entity/ai/tentacle/TentacleGoals;", "", "<init>", "()V", "AlwaysTargetPlayerGoal", "MeleeGoal", "thebrokenscript-common"})
public final class TentacleGoals {
    @NotNull
    public static final TentacleGoals INSTANCE = new TentacleGoals();

    private TentacleGoals() {
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0004\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\n\u001a\u00020\u000bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\u00a8\u0006\f"}, d2={"Lnet/thebrokenscript/api/entity/ai/tentacle/TentacleGoals$AlwaysTargetPlayerGoal;", "Lnet/minecraft/world/entity/ai/goal/Goal;", "mob", "Lnet/minecraft/world/entity/Mob;", "distance", "", "<init>", "(Lnet/minecraft/world/entity/Mob;Ljava/lang/Number;)V", "getDistance", "()Ljava/lang/Number;", "canUse", "", "thebrokenscript-common"})
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
                return true;
            }
            return false;
        }
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u000f\u001a\u00020\rH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2={"Lnet/thebrokenscript/api/entity/ai/tentacle/TentacleGoals$MeleeGoal;", "Lnet/minecraft/world/entity/ai/goal/Goal;", "tentacleEntity", "Lnet/thebrokenscript/entity/boss/VoidTentacleEntity;", "<init>", "(Lnet/thebrokenscript/entity/boss/VoidTentacleEntity;)V", "attackInterval", "", "ticksUntilNextAttack", "canUse", "", "canContinueToUse", "tick", "", "start", "stop", "thebrokenscript-common"})
    @SourceDebugExtension(value={"SMAP\nTentacleGoals.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TentacleGoals.kt\nnet/thebrokenscript/api/entity/ai/tentacle/TentacleGoals$MeleeGoal\n+ 2 EntityFinderDSL.kt\nnet/thebrokenscript/brokencore/api/dsl/EntityFinder\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,79:1\n64#2:80\n774#3:81\n865#3,2:82\n774#3:84\n865#3,2:85\n*S KotlinDebug\n*F\n+ 1 TentacleGoals.kt\nnet/thebrokenscript/api/entity/ai/tentacle/TentacleGoals$MeleeGoal\n*L\n46#1:80\n47#1:81\n47#1:82,2\n56#1:84\n56#1:85,2\n*E\n"})
    public static final class MeleeGoal
    extends Goal {
        @NotNull
        private final VoidTentacleEntity tentacleEntity;
        private final int attackInterval;
        private int ticksUntilNextAttack;

        public MeleeGoal(@NotNull VoidTentacleEntity tentacleEntity) {
            Intrinsics.checkNotNullParameter((Object)((Object)tentacleEntity), (String)"tentacleEntity");
            this.tentacleEntity = tentacleEntity;
            this.attackInterval = 25;
            this.setFlags(EnumSet.of((Enum)Goal.Flag.MOVE, (Enum)Goal.Flag.LOOK));
        }

        public boolean canUse() {
            LivingEntity livingEntity = this.tentacleEntity.getTarget();
            return livingEntity != null ? livingEntity.isAlive() : false;
        }

        public boolean canContinueToUse() {
            return this.canUse();
        }

        /*
         * WARNING - void declaration
         */
        public void tick() {
            boolean sweep;
            void $this$filterTo$iv$iv;
            void $this$filterTo$iv$iv2;
            void base$iv;
            void $this$findEntitiesInRange$iv;
            super.tick();
            int n = this.ticksUntilNextAttack;
            this.ticksUntilNextAttack = n + -1;
            if (this.ticksUntilNextAttack > 0) {
                return;
            }
            LevelAccessor levelAccessor = (LevelAccessor)this.tentacleEntity.getLevel();
            Vec3 vec3 = this.tentacleEntity.getPos();
            Object radius$iv = (double)8 * (this.tentacleEntity.getAttributes().getBaseValue(Attributes.SCALE) * 0.7);
            boolean $i$f$findEntitiesInRange = false;
            Iterable $this$filter$iv = EntityFinder.findEntitiesInRange((LevelAccessor)$this$findEntitiesInRange$iv, LivingEntity.class, (Vec3)base$iv, (Number)radius$iv);
            boolean $i$f$filter = false;
            radius$iv = $this$filter$iv;
            Iterable destination$iv$iv = new ArrayList();
            boolean $i$f$filterTo = false;
            for (Object element$iv$iv : $this$filterTo$iv$iv2) {
                LivingEntity it = (LivingEntity)element$iv$iv;
                boolean bl = false;
                if (!((double)it.distanceTo((Entity)this.tentacleEntity) < (double)7 * (this.tentacleEntity.getAttributes().getBaseValue(Attributes.SCALE) * 0.7) && (it instanceof Player || it instanceof IntegrityP3GroundArmEntity || it instanceof IntegrityPhase3Entity && !((IntegrityPhase3Entity)it).stuckStatus()))) continue;
                destination$iv$iv.add(element$iv$iv);
            }
            List sweepCandidates = (List)destination$iv$iv;
            if (sweepCandidates.isEmpty()) {
                return;
            }
            this.ticksUntilNextAttack = this.attackInterval;
            this.tentacleEntity.getLookControl().setLookAt((Entity)CollectionsKt.first((List)sweepCandidates));
            Iterable $this$filter$iv2 = sweepCandidates;
            boolean $i$f$filter2 = false;
            destination$iv$iv = $this$filter$iv2;
            Collection destination$iv$iv2 = new ArrayList();
            boolean $i$f$filterTo2 = false;
            for (Object element$iv$iv : $this$filterTo$iv$iv) {
                LivingEntity it = (LivingEntity)element$iv$iv;
                boolean bl = false;
                if (!((double)it.distanceTo((Entity)this.tentacleEntity) < 2.75 * (this.tentacleEntity.getAttributes().getBaseValue(Attributes.SCALE) * 0.7))) continue;
                destination$iv$iv2.add(element$iv$iv);
            }
            List tooClose = (List)destination$iv$iv2;
            boolean bl = sweep = sweepCandidates.size() > 1 || tooClose.isEmpty() && this.tentacleEntity.getLevel().random.nextFloat() <= 0.35f;
            if (sweep) {
                this.tentacleEntity.triggerAnim(null, "360_Sweep");
            } else {
                LivingEntity target = (LivingEntity)CollectionsKt.firstOrNull((List)tooClose);
                if (target != null) {
                    this.tentacleEntity.doHurtTarget((Entity)target, 5.0f);
                }
            }
        }

        public void start() {
            super.start();
            this.ticksUntilNextAttack = 0;
        }

        public void stop() {
            super.stop();
            this.ticksUntilNextAttack = 0;
        }
    }
}

