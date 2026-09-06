/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.server.level.ServerPlayer
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.PathfinderMob
 *  net.minecraft.world.entity.ai.goal.MeleeAttackGoal
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.phys.AABB
 *  net.thebrokenscript.brokencore.api.entity.base.BaseMonster
 *  net.thebrokenscript.brokencore.api.ext.BaseMonsterExtKt
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.api.entity.ai.circuit;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.AABB;
import net.thebrokenscript.brokencore.api.entity.base.BaseMonster;
import net.thebrokenscript.brokencore.api.ext.BaseMonsterExtKt;
import net.thebrokenscript.entity.circuit.CircuitEntity;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\b\u0010\f\u001a\u00020\u0007H\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2={"Lnet/thebrokenscript/api/entity/ai/circuit/CircuitMeleeGoal;", "Lnet/minecraft/world/entity/ai/goal/MeleeAttackGoal;", "circuitMob", "Lnet/thebrokenscript/entity/circuit/CircuitEntity;", "speed", "", "follow", "", "<init>", "(Lnet/thebrokenscript/entity/circuit/CircuitEntity;DZ)V", "ticksUntilNextAttack", "", "canUse", "tick", "", "stop", "thebrokenscript-common"})
public final class CircuitMeleeGoal
extends MeleeAttackGoal {
    @NotNull
    private final CircuitEntity circuitMob;
    private int ticksUntilNextAttack;

    public CircuitMeleeGoal(@NotNull CircuitEntity circuitMob, double speed, boolean follow) {
        Intrinsics.checkNotNullParameter((Object)((Object)circuitMob), (String)"circuitMob");
        super((PathfinderMob)circuitMob, speed, follow);
        this.circuitMob = circuitMob;
    }

    public boolean canUse() {
        LivingEntity livingEntity = this.mob.getTarget();
        if (livingEntity == null) {
            return false;
        }
        LivingEntity target = livingEntity;
        if (target.isRemoved() || !target.isAlive()) {
            this.mob.setTarget(null);
            return false;
        }
        return !(target instanceof ServerPlayer) || !((ServerPlayer)target).isSpectator();
    }

    public void tick() {
        LivingEntity target = this.mob.getTarget();
        if (this.mob.isNoAi()) {
            return;
        }
        if (target != null && (target.isRemoved() || !target.isAlive())) {
            this.mob.setTarget(null);
            return;
        }
        if (target instanceof ServerPlayer && ((ServerPlayer)target).isSpectator()) {
            this.mob.setTarget(null);
            return;
        }
        if (target == null) {
            return;
        }
        this.mob.getLookControl().setLookAt((Entity)target, 30.0f, 30.0f);
        if (target instanceof ServerPlayer) {
            PathfinderMob pathfinderMob = this.mob;
            Intrinsics.checkNotNull((Object)pathfinderMob, (String)"null cannot be cast to non-null type net.thebrokenscript.brokencore.api.entity.base.BaseMonster");
            if (BaseMonsterExtKt.hasLineOfSightThroughTransparent((BaseMonster)((BaseMonster)pathfinderMob), (Player)((Player)target))) {
                this.circuitMob.updateLastSeenTick();
                this.circuitMob.updatePlayerTracking((ServerPlayer)target);
            }
        }
        this.ticksUntilNextAttack = Math.max(this.ticksUntilNextAttack - 1, 0);
        AABB mobBB = this.mob.getBoundingBox();
        AABB targetBB = target.getBoundingBox();
        double horizontalReach = (double)this.mob.getBbWidth() * 1.5 + (double)target.getBbWidth();
        AABB expandedBB = mobBB.inflate(horizontalReach, 0.5, horizontalReach);
        if (expandedBB.intersects(targetBB) && this.ticksUntilNextAttack <= 0 && this.mob.hasLineOfSight((Entity)target)) {
            this.mob.doHurtTarget((Entity)target);
            this.ticksUntilNextAttack = 20;
        }
    }

    public void stop() {
        this.mob.setAggressive(false);
        this.ticksUntilNextAttack = 0;
    }
}

