/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.util.Mth
 *  net.minecraft.world.entity.Mob
 *  net.minecraft.world.entity.ai.attributes.Attributes
 *  net.minecraft.world.entity.ai.control.MoveControl
 *  net.minecraft.world.entity.ai.control.MoveControl$Operation
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.api.entity.ai.circuit;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.thebrokenscript.entity.circuit.CircuitEntity;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2={"Lnet/thebrokenscript/api/entity/ai/circuit/CircuitMoveControl;", "Lnet/minecraft/world/entity/ai/control/MoveControl;", "circuitMob", "Lnet/thebrokenscript/entity/circuit/CircuitEntity;", "<init>", "(Lnet/thebrokenscript/entity/circuit/CircuitEntity;)V", "tick", "", "thebrokenscript-common"})
public final class CircuitMoveControl
extends MoveControl {
    @NotNull
    private final CircuitEntity circuitMob;

    public CircuitMoveControl(@NotNull CircuitEntity circuitMob) {
        Intrinsics.checkNotNullParameter((Object)((Object)circuitMob), (String)"circuitMob");
        super((Mob)circuitMob);
        this.circuitMob = circuitMob;
    }

    public void tick() {
        if (this.operation != MoveControl.Operation.MOVE_TO) {
            super.tick();
            return;
        }
        this.operation = MoveControl.Operation.WAIT;
        double dx = this.wantedX - this.mob.getX();
        double dz = this.wantedZ - this.mob.getZ();
        double dy = this.wantedY - this.mob.getY();
        double distSq = dx * dx + dy * dy + dz * dz;
        if (distSq < 2.5000003E-7) {
            this.mob.zza = 0.0f;
            return;
        }
        float yaw = (float)(Mth.atan2((double)dz, (double)dx) * 57.29577951308232) - 90.0f;
        this.mob.setYRot(this.rotlerp(this.mob.getYRot(), yaw, 90.0f));
        this.mob.setSpeed((float)(this.speedModifier * this.mob.getAttributeValue(Attributes.MOVEMENT_SPEED)));
        this.mob.zza = this.mob.getSpeed();
        if (this.circuitMob.getClimbing()) {
            return;
        }
        double horizontalDistSq = dx * dx + dz * dz;
        if (dy > (double)this.mob.maxUpStep() && dy <= 1.0 && horizontalDistSq < Math.max(1.0, (double)this.mob.getBbWidth())) {
            this.mob.getJumpControl().jump();
            this.operation = MoveControl.Operation.JUMPING;
        }
    }
}

