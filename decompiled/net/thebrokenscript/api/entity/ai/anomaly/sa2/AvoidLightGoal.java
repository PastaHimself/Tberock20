/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.ranges.RangesKt
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.BlockPos$MutableBlockPos
 *  net.minecraft.core.Vec3i
 *  net.minecraft.util.RandomSource
 *  net.minecraft.world.entity.Mob
 *  net.minecraft.world.entity.ai.goal.Goal
 *  net.minecraft.world.entity.ai.goal.Goal$Flag
 *  net.minecraft.world.entity.ai.navigation.PathNavigation
 *  net.minecraft.world.phys.Vec3
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.api.entity.ai.anomaly.sa2;

import java.util.EnumSet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Vec3i;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.entity.anomaly.sa2.SubAnomaly2BaseEntity;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\r\u001a\u00020\u0007H\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0007H\u0016J\b\u0010\u0011\u001a\u00020\u000fH\u0016J\n\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0002J\b\u0010\u0014\u001a\u00020\u000fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\nR\u0012\u0010\u000b\u001a\u0004\u0018\u00010\tX\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\nR\u0012\u0010\f\u001a\u0004\u0018\u00010\tX\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\n\u00a8\u0006\u0015"}, d2={"Lnet/thebrokenscript/api/entity/ai/anomaly/sa2/AvoidLightGoal;", "Lnet/minecraft/world/entity/ai/goal/Goal;", "mob", "Lnet/minecraft/world/entity/Mob;", "<init>", "(Lnet/minecraft/world/entity/Mob;)V", "fleeDone", "", "fleeX", "", "Ljava/lang/Double;", "fleeY", "fleeZ", "canUse", "start", "", "canContinueToUse", "stop", "getHidePos", "Lnet/minecraft/world/phys/Vec3;", "tick", "thebrokenscript-common"})
public final class AvoidLightGoal
extends Goal {
    @NotNull
    private final Mob mob;
    private boolean fleeDone;
    @Nullable
    private Double fleeX;
    @Nullable
    private Double fleeY;
    @Nullable
    private Double fleeZ;

    public AvoidLightGoal(@NotNull Mob mob) {
        Intrinsics.checkNotNullParameter((Object)mob, (String)"mob");
        this.mob = mob;
        this.setFlags(EnumSet.of((Enum)Goal.Flag.MOVE, (Enum)Goal.Flag.LOOK));
    }

    public boolean canUse() {
        int lightLevel = this.mob.level().getMaxLocalRawBrightness(this.mob.blockPosition());
        if (lightLevel < ((Number)this.mob.getEntityData().get(SubAnomaly2BaseEntity.Companion.getFEAR_FACTOR())).intValue()) {
            return false;
        }
        if (((Number)this.mob.getEntityData().get(SubAnomaly2BaseEntity.Companion.getFEAR_FACTOR())).intValue() > 13) {
            return false;
        }
        Vec3 vec3 = this.getHidePos();
        if (vec3 == null) {
            return false;
        }
        Vec3 hidePos = vec3;
        this.fleeX = hidePos.x;
        this.fleeY = hidePos.y;
        this.fleeZ = hidePos.z;
        return true;
    }

    public void start() {
        Double d = this.fleeX;
        if (d == null) {
            return;
        }
        double x = d;
        Double d2 = this.fleeY;
        if (d2 == null) {
            return;
        }
        double y = d2;
        Double d3 = this.fleeZ;
        if (d3 == null) {
            return;
        }
        double z = d3;
        this.fleeDone = false;
        this.mob.getNavigation().moveTo(x, y, z, 1.5);
    }

    public boolean canContinueToUse() {
        boolean done = this.mob.getNavigation().isDone();
        if (done) {
            this.fleeDone = true;
        }
        return !done;
    }

    public void stop() {
        this.mob.getNavigation().stop();
        this.fleeX = null;
        this.fleeY = null;
        this.fleeZ = null;
        if (this.fleeDone) {
            Integer fearLvl = (Integer)this.mob.getEntityData().get(SubAnomaly2BaseEntity.Companion.getFEAR_FACTOR());
            this.mob.getEntityData().set(SubAnomaly2BaseEntity.Companion.getFEAR_FACTOR(), (Object)RangesKt.coerceAtMost((int)(fearLvl + 1), (int)13));
            this.fleeDone = false;
        }
    }

    private final Vec3 getHidePos() {
        RandomSource randomSrc = this.mob.getRandom();
        BlockPos currentPos = this.mob.blockPosition();
        BlockPos.MutableBlockPos candidatePos = new BlockPos.MutableBlockPos();
        for (int i = 0; i < 11; ++i) {
            candidatePos.set(currentPos.getX() + randomSrc.nextIntBetweenInclusive(-16, 16), currentPos.getY() + randomSrc.nextIntBetweenInclusive(-4, 4), currentPos.getZ() + randomSrc.nextIntBetweenInclusive(-16, 16));
            int candidateLight = this.mob.level().getMaxLocalRawBrightness((BlockPos)candidatePos);
            if (candidateLight > ((Number)this.mob.getEntityData().get(SubAnomaly2BaseEntity.Companion.getFEAR_FACTOR())).intValue()) continue;
            return Vec3.atBottomCenterOf((Vec3i)((Vec3i)candidatePos));
        }
        return null;
    }

    public void tick() {
        if (this.mob.getNavigation().isDone() && this.fleeX != null) {
            PathNavigation pathNavigation = this.mob.getNavigation();
            Double d = this.fleeX;
            Intrinsics.checkNotNull((Object)d);
            double d2 = d;
            Double d3 = this.fleeY;
            Intrinsics.checkNotNull((Object)d3);
            double d4 = d3;
            Double d5 = this.fleeZ;
            Intrinsics.checkNotNull((Object)d5);
            pathNavigation.moveTo(d2, d4, d5.doubleValue(), 1.5);
        }
    }
}

