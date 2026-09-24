/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.util.RandomSource
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.Mob
 *  net.minecraft.world.entity.ai.goal.Goal
 *  net.minecraft.world.entity.ai.goal.Goal$Flag
 *  net.minecraft.world.level.ClipContext
 *  net.minecraft.world.level.ClipContext$Block
 *  net.minecraft.world.level.ClipContext$Fluid
 *  net.minecraft.world.phys.AABB
 *  net.minecraft.world.phys.BlockHitResult
 *  net.minecraft.world.phys.HitResult$Type
 *  net.minecraft.world.phys.Vec3
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.api.entity.ai.anomaly.sa2;

import java.util.EnumSet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\fH\u0016J\b\u0010\u0012\u001a\u00020\u0010H\u0016J\b\u0010\u0013\u001a\u00020\u0010H\u0016J\n\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2={"Lnet/thebrokenscript/api/entity/ai/anomaly/sa2/RandomFlyingGoal;", "Lnet/minecraft/world/entity/ai/goal/Goal;", "mob", "Lnet/minecraft/world/entity/Mob;", "speed", "", "<init>", "(Lnet/minecraft/world/entity/Mob;D)V", "targetX", "targetY", "targetZ", "canUse", "", "giveUpTicks", "", "start", "", "canContinueToUse", "stop", "tick", "getRandomPos", "Lnet/minecraft/world/phys/Vec3;", "thebrokenscript-common"})
public final class RandomFlyingGoal
extends Goal {
    @NotNull
    private final Mob mob;
    private final double speed;
    private double targetX;
    private double targetY;
    private double targetZ;
    private int giveUpTicks;

    public RandomFlyingGoal(@NotNull Mob mob, double speed) {
        Intrinsics.checkNotNullParameter((Object)mob, (String)"mob");
        this.mob = mob;
        this.speed = speed;
        this.setFlags(EnumSet.of((Enum)Goal.Flag.MOVE, (Enum)Goal.Flag.LOOK));
    }

    public boolean canUse() {
        double dz;
        double dy;
        if (this.mob.getTarget() != null) {
            return false;
        }
        Vec3 vec3 = this.getRandomPos();
        if (vec3 == null) {
            return false;
        }
        Vec3 randomPos = vec3;
        double dx = randomPos.x - this.mob.getX();
        if (dx * dx + (dy = randomPos.y - this.mob.getY()) * dy + (dz = randomPos.z - this.mob.getZ()) * dz < 9.0) {
            return false;
        }
        BlockHitResult clip = this.mob.level().clip(new ClipContext(this.mob.position(), randomPos, ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, (Entity)this.mob));
        if (clip.getType() != HitResult.Type.MISS) {
            return false;
        }
        this.targetX = randomPos.x;
        this.targetY = randomPos.y;
        this.targetZ = randomPos.z;
        return true;
    }

    public void start() {
        this.giveUpTicks = 0;
        this.mob.getMoveControl().setWantedPosition(this.targetX, this.targetY, this.targetZ, this.speed);
    }

    public boolean canContinueToUse() {
        double dz;
        double dy;
        int n = this.giveUpTicks;
        this.giveUpTicks = n + 1;
        if (this.giveUpTicks > 200) {
            return false;
        }
        double dx = this.targetX - this.mob.getX();
        return dx * dx + (dy = this.targetY - this.mob.getY()) * dy + (dz = this.targetZ - this.mob.getZ()) * dz > 2.0;
    }

    public void stop() {
        this.mob.getNavigation().stop();
    }

    public void tick() {
        this.mob.getLookControl().setLookAt(this.targetX, this.targetY, this.targetZ);
    }

    private final Vec3 getRandomPos() {
        RandomSource randomSrc = this.mob.getRandom();
        Vec3 currentPos = this.mob.position();
        int n = 10;
        int n2 = 0;
        while (n2 < n) {
            int it = n2++;
            boolean bl = false;
            int dx = randomSrc.nextIntBetweenInclusive(-16, 16);
            int dy = randomSrc.nextIntBetweenInclusive(-4, 4);
            int dz = randomSrc.nextIntBetweenInclusive(-16, 16);
            Vec3 candidate = currentPos.add((double)dx, (double)dy, (double)dz);
            AABB aabb = this.mob.getBoundingBox().move(candidate.subtract(currentPos));
            if (!this.mob.level().noCollision((Entity)this.mob, aabb)) continue;
            return candidate;
        }
        return null;
    }
}

