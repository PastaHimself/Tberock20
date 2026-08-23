/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.util.RandomSource
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.MoverType
 *  net.minecraft.world.entity.ai.goal.Goal
 *  net.minecraft.world.entity.ai.goal.Goal$Flag
 *  net.minecraft.world.phys.AABB
 *  net.minecraft.world.phys.Vec3
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.api.entity.ai.integrity.phas1;

import java.util.EnumSet;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.entity.integrity.phase1.IntegrityPhase1Entity;
import net.thebrokenscript.misc.ForceRuntimeInit;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@ForceRuntimeInit
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u00c7\u0002\u0018\u00002\u00020\u0001:\u0001\u0004B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0005"}, d2={"Lnet/thebrokenscript/api/entity/ai/integrity/phas1/Phase1Goals;", "", "<init>", "()V", "RandomFloatGoal", "thebrokenscript-common"})
public final class Phase1Goals {
    @NotNull
    public static final Phase1Goals INSTANCE = new Phase1Goals();

    private Phase1Goals() {
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\n\u0010\u0015\u001a\u0004\u0018\u00010\fH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2={"Lnet/thebrokenscript/api/entity/ai/integrity/phas1/Phase1Goals$RandomFloatGoal;", "Lnet/minecraft/world/entity/ai/goal/Goal;", "integrity", "Lnet/thebrokenscript/entity/integrity/phase1/IntegrityPhase1Entity;", "aabb", "Lnet/minecraft/world/phys/AABB;", "minDelay", "", "maxDelay", "<init>", "(Lnet/thebrokenscript/entity/integrity/phase1/IntegrityPhase1Entity;Lnet/minecraft/world/phys/AABB;II)V", "targetPos", "Lnet/minecraft/world/phys/Vec3;", "cooldown", "giveUpTicks", "canUse", "", "canContinueToUse", "start", "", "tick", "getRandomPos", "thebrokenscript-common"})
    public static final class RandomFloatGoal
    extends Goal {
        @NotNull
        private final IntegrityPhase1Entity integrity;
        @NotNull
        private final AABB aabb;
        private final int minDelay;
        private final int maxDelay;
        @Nullable
        private Vec3 targetPos;
        private int cooldown;
        private int giveUpTicks;

        public RandomFloatGoal(@NotNull IntegrityPhase1Entity integrity, @NotNull AABB aabb, int minDelay, int maxDelay) {
            Intrinsics.checkNotNullParameter((Object)((Object)integrity), (String)"integrity");
            Intrinsics.checkNotNullParameter((Object)aabb, (String)"aabb");
            this.integrity = integrity;
            this.aabb = aabb;
            this.minDelay = minDelay;
            this.maxDelay = maxDelay;
            this.setFlags(EnumSet.of((Enum)Goal.Flag.MOVE));
        }

        public /* synthetic */ RandomFloatGoal(IntegrityPhase1Entity integrityPhase1Entity, AABB aABB, int n, int n2, int n3, DefaultConstructorMarker defaultConstructorMarker) {
            if ((n3 & 4) != 0) {
                n = 40;
            }
            if ((n3 & 8) != 0) {
                n2 = 100;
            }
            this(integrityPhase1Entity, aABB, n, n2);
        }

        public boolean canUse() {
            return true;
        }

        public boolean canContinueToUse() {
            if (this.targetPos != null) {
                double dz;
                double dy;
                Vec3 vec3 = this.targetPos;
                Intrinsics.checkNotNull((Object)vec3);
                Vec3 pos = vec3;
                int n = this.giveUpTicks;
                this.giveUpTicks = n + 1;
                if (this.giveUpTicks > 200) {
                    return false;
                }
                double dx = pos.x - this.integrity.getX();
                return dx * dx + (dy = pos.y - this.integrity.getX()) * dy + (dz = pos.z - this.integrity.getX()) * dz > 2.0;
            }
            return false;
        }

        public void start() {
            System.out.println((Object)"he do be using it doe");
            this.targetPos = this.getRandomPos();
        }

        public void tick() {
            Vec3 target;
            block5: {
                block4: {
                    Vec3 vec3 = this.targetPos;
                    if (vec3 == null) {
                        return;
                    }
                    target = vec3;
                    double distance = this.integrity.getPos().distanceToSqr(target);
                    if (distance < 1.0) break block4;
                    int n = this.cooldown;
                    this.cooldown = n + -1;
                    if (n > 0) break block5;
                }
                this.targetPos = this.getRandomPos();
                return;
            }
            Vec3 delta = target.subtract(this.integrity.getPos());
            Vec3 motion = delta.normalize().scale(0.15);
            this.integrity.setDeltaMovement(this.integrity.getDeltaMovement().lerp(motion, 0.05));
            this.integrity.move(MoverType.SELF, this.integrity.getDeltaMovement());
        }

        private final Vec3 getRandomPos() {
            RandomSource randomSrc = this.integrity.getRandom();
            Vec3 currentPos = this.integrity.position();
            int n = 10;
            int n2 = 0;
            while (n2 < n) {
                int it = n2++;
                boolean bl = false;
                int dx = randomSrc.nextIntBetweenInclusive(-16, 16);
                int dy = randomSrc.nextIntBetweenInclusive(-4, 4);
                int dz = randomSrc.nextIntBetweenInclusive(-16, 16);
                Vec3 candidate = currentPos.add((double)dx, (double)dy, (double)dz);
                AABB aabb = this.integrity.getBoundingBox().move(candidate.subtract(currentPos));
                if (!this.integrity.level().noCollision((Entity)this.integrity, aabb)) continue;
                return candidate;
            }
            return null;
        }
    }
}

