/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.Mob
 *  net.minecraft.world.entity.ai.goal.Goal
 *  net.minecraft.world.entity.ai.goal.Goal$Flag
 *  net.minecraft.world.entity.player.Player
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.entity.integrity.phase2;

import java.util.EnumSet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.player.Player;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2={"Lnet/thebrokenscript/entity/integrity/phase2/IntegrityP2AlwaysTargetPlayerGoal;", "Lnet/minecraft/world/entity/ai/goal/Goal;", "mob", "Lnet/minecraft/world/entity/Mob;", "<init>", "(Lnet/minecraft/world/entity/Mob;)V", "canUse", "", "canContinueToUse", "thebrokenscript-common"})
public final class IntegrityP2AlwaysTargetPlayerGoal
extends Goal {
    @NotNull
    private final Mob mob;

    public IntegrityP2AlwaysTargetPlayerGoal(@NotNull Mob mob) {
        Intrinsics.checkNotNullParameter((Object)mob, (String)"mob");
        this.mob = mob;
        this.setFlags(EnumSet.of((Enum)Goal.Flag.TARGET));
    }

    public boolean canUse() {
        Player player = this.mob.level().getNearestPlayer((Entity)this.mob, -1.0);
        if (player != null && player.isAlive()) {
            this.mob.setTarget((LivingEntity)player);
            return true;
        }
        return false;
    }

    public boolean canContinueToUse() {
        return this.canUse();
    }
}

