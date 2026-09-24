/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.core.BlockPos
 *  net.minecraft.util.Mth
 *  net.minecraft.world.entity.Mob
 *  net.minecraft.world.entity.ai.attributes.Attributes
 *  net.minecraft.world.entity.ai.control.MoveControl
 *  net.minecraft.world.entity.ai.control.MoveControl$Operation
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.api.entity.ai.integrity.phase3;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.thebrokenscript.entity.integrity.phase3.IntegrityPhase3Entity;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016\u00a8\u0006\b"}, d2={"Lnet/thebrokenscript/api/entity/ai/integrity/phase3/IntegMoveControl;", "Lnet/minecraft/world/entity/ai/control/MoveControl;", "entity", "Lnet/thebrokenscript/entity/integrity/phase3/IntegrityPhase3Entity;", "<init>", "(Lnet/thebrokenscript/entity/integrity/phase3/IntegrityPhase3Entity;)V", "tick", "", "thebrokenscript-common"})
public final class IntegMoveControl
extends MoveControl {
    public IntegMoveControl(@NotNull IntegrityPhase3Entity entity) {
        Intrinsics.checkNotNullParameter((Object)((Object)entity), (String)"entity");
        super((Mob)entity);
    }

    public void tick() {
        double dz;
        Mob mob = this.mob;
        Intrinsics.checkNotNull((Object)mob, (String)"null cannot be cast to non-null type net.thebrokenscript.entity.integrity.phase3.IntegrityPhase3Entity");
        if (((IntegrityPhase3Entity)mob).getDying()) {
            return;
        }
        if (this.operation != MoveControl.Operation.MOVE_TO) {
            return;
        }
        this.operation = MoveControl.Operation.WAIT;
        double dx = this.wantedX - this.mob.getX();
        double distSq = dx * dx + (dz = this.wantedZ - this.mob.getZ()) * dz;
        if (distSq < 1.0E-4) {
            return;
        }
        float yaw = (float)(Mth.atan2((double)dz, (double)dx) * 180.0 / Math.PI) - 90.0f;
        this.mob.setYRot(this.rotlerp(this.mob.getYRot(), yaw, 90.0f));
        this.mob.setSpeed((float)(this.speedModifier * this.mob.getAttributeValue(Attributes.MOVEMENT_SPEED)));
        double dist = Math.sqrt(distSq);
        double nx = dx / dist;
        double nz = dz / dist;
        if (this.mob.onGround()) {
            BlockPos ahead = BlockPos.containing((double)(this.mob.getX() + nx * ((double)(this.mob.getBbWidth() / (float)2) + 0.3)), (double)(this.mob.getY() - 0.1), (double)(this.mob.getZ() + nz * ((double)(this.mob.getBbWidth() / (float)2) + 0.3)));
            if (this.mob.level().getBlockState(ahead).isAir()) {
                this.mob.setDeltaMovement(this.mob.getDeltaMovement().add(nx * 0.02, 0.0, nz * 0.02));
            }
        }
        this.operation = MoveControl.Operation.MOVE_TO;
    }
}

