/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.PathfinderMob
 *  net.minecraft.world.entity.ai.goal.Goal
 *  net.minecraft.world.entity.ai.goal.Goal$Flag
 *  net.minecraft.world.entity.ai.util.DefaultRandomPos
 *  net.minecraft.world.phys.Vec3
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.api.entity.ai.fractured;

import java.util.EnumSet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.util.DefaultRandomPos;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.api.entity.BaseFracturedEntity;
import net.thebrokenscript.entity.fractured.FracturedRoamEntity;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\b\u0010\u0015\u001a\u00020\u0013H\u0016J\b\u0010\u0016\u001a\u00020\u0010H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000b\u00a8\u0006\u0017"}, d2={"Lnet/thebrokenscript/api/entity/ai/fractured/FracturedRoamGoUnDerGroundGoal;", "Lnet/minecraft/world/entity/ai/goal/Goal;", "jimmy", "Lnet/thebrokenscript/entity/fractured/FracturedRoamEntity;", "<init>", "(Lnet/thebrokenscript/entity/fractured/FracturedRoamEntity;)V", "undergroundTimer", "", "getUndergroundTimer", "()I", "setUndergroundTimer", "(I)V", "navCooldown", "getNavCooldown", "setNavCooldown", "start", "", "stop", "canUse", "", "canContinueToUse", "requiresUpdateEveryTick", "tick", "thebrokenscript-common"})
public class FracturedRoamGoUnDerGroundGoal
extends Goal {
    @NotNull
    private final FracturedRoamEntity jimmy;
    private int undergroundTimer;
    private int navCooldown;

    public FracturedRoamGoUnDerGroundGoal(@NotNull FracturedRoamEntity jimmy) {
        Intrinsics.checkNotNullParameter((Object)((Object)jimmy), (String)"jimmy");
        this.jimmy = jimmy;
        this.setFlags(EnumSet.of((Enum)Goal.Flag.MOVE, (Enum)Goal.Flag.LOOK));
    }

    public final int getUndergroundTimer() {
        return this.undergroundTimer;
    }

    public final void setUndergroundTimer(int n) {
        this.undergroundTimer = n;
    }

    public final int getNavCooldown() {
        return this.navCooldown;
    }

    public final void setNavCooldown(int n) {
        this.navCooldown = n;
    }

    public void start() {
        super.start();
        this.jimmy.setCurrentState(BaseFracturedEntity.JimmyStates.DIGGING);
        this.undergroundTimer = this.jimmy.getRandom().nextInt(300, 400);
    }

    public void stop() {
        super.stop();
        this.jimmy.setCurrentState(BaseFracturedEntity.JimmyStates.RISING);
        this.jimmy.setDigCooldown(this.jimmy.getRandom().nextInt(400, 800));
        this.jimmy.getMoveControl().setWantedPosition(this.jimmy.getX(), this.jimmy.getY(), this.jimmy.getZ(), 0.4);
    }

    public boolean canUse() {
        return this.jimmy.getRandom().nextInt(0, 1000) == 1 && this.jimmy.getCurrentState() == BaseFracturedEntity.JimmyStates.NORMAL && this.jimmy.getDigCooldown() <= 0;
    }

    public boolean canContinueToUse() {
        return this.undergroundTimer > 0;
    }

    public boolean requiresUpdateEveryTick() {
        return true;
    }

    public void tick() {
        Vec3 pos;
        int n = this.undergroundTimer;
        this.undergroundTimer = n + -1;
        LivingEntity target = this.jimmy.getTarget();
        if (target != null) {
            if (this.jimmy.distanceTo((Entity)target) >= 5.0f) {
                if (this.navCooldown <= 0) {
                    this.jimmy.getMoveControl().setWantedPosition(target.getX(), target.getY(), target.getZ(), 0.4);
                    this.navCooldown = this.jimmy.getRandom().nextInt(60, 120);
                } else {
                    int n2 = this.navCooldown;
                    this.navCooldown = n2 + -1;
                }
            }
        } else if (!this.jimmy.isMoving() && (pos = DefaultRandomPos.getPos((PathfinderMob)((PathfinderMob)this.jimmy), (int)30, (int)7)) != null) {
            if (this.navCooldown <= 0) {
                this.jimmy.getMoveControl().setWantedPosition(pos.x, pos.y, pos.z, 0.4);
                this.navCooldown = this.jimmy.getRandom().nextInt(60, 120);
            } else {
                int n3 = this.navCooldown;
                this.navCooldown = n3 + -1;
            }
        }
    }
}

