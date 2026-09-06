/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.ai.goal.Goal
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.phys.Vec3
 *  net.thebrokenscript.brokencore.api.dsl.PositionUtil
 *  net.thebrokenscript.brokencore.api.entity.multipart.MultipartSubEntity
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.api.entity.ai.fractured;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.api.entity.BaseFracturedEntity;
import net.thebrokenscript.brokencore.api.dsl.PositionUtil;
import net.thebrokenscript.brokencore.api.entity.multipart.MultipartSubEntity;
import net.thebrokenscript.entity.fractured.FracturedSubEntity;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0011\u001a\u00020\rH\u0016J\b\u0010\u0012\u001a\u00020\rH\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0002J\b\u0010\u0016\u001a\u00020\rH\u0016J\b\u0010\u0017\u001a\u00020\u0014H\u0002J\b\u0010\u0018\u001a\u00020\u0014H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0019"}, d2={"Lnet/thebrokenscript/api/entity/ai/fractured/FracturedStompGoal;", "Lnet/minecraft/world/entity/ai/goal/Goal;", "fracturedEntity", "Lnet/thebrokenscript/api/entity/BaseFracturedEntity;", "<init>", "(Lnet/thebrokenscript/api/entity/BaseFracturedEntity;)V", "getFracturedEntity", "()Lnet/thebrokenscript/api/entity/BaseFracturedEntity;", "currentTarget", "Lnet/minecraft/world/entity/player/Player;", "currentLeg", "Lnet/thebrokenscript/entity/fractured/FracturedSubEntity;", "started", "", "cooldown", "", "stomping", "canUse", "requiresUpdateEveryTick", "tick", "", "reset", "canContinueToUse", "tryStart", "start", "thebrokenscript-common"})
@SourceDebugExtension(value={"SMAP\nFracturedStompGoal.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FracturedStompGoal.kt\nnet/thebrokenscript/api/entity/ai/fractured/FracturedStompGoal\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,89:1\n1869#2,2:90\n*S KotlinDebug\n*F\n+ 1 FracturedStompGoal.kt\nnet/thebrokenscript/api/entity/ai/fractured/FracturedStompGoal\n*L\n67#1:90,2\n*E\n"})
public final class FracturedStompGoal
extends Goal {
    @NotNull
    private final BaseFracturedEntity fracturedEntity;
    @Nullable
    private Player currentTarget;
    @Nullable
    private FracturedSubEntity currentLeg;
    private boolean started;
    private int cooldown;
    private boolean stomping;

    public FracturedStompGoal(@NotNull BaseFracturedEntity fracturedEntity) {
        Intrinsics.checkNotNullParameter((Object)((Object)fracturedEntity), (String)"fracturedEntity");
        this.fracturedEntity = fracturedEntity;
    }

    @NotNull
    public final BaseFracturedEntity getFracturedEntity() {
        return this.fracturedEntity;
    }

    public boolean canUse() {
        return true;
    }

    public boolean requiresUpdateEveryTick() {
        return this.started;
    }

    public void tick() {
        if (this.started) {
            if (this.cooldown > 0) {
                int n = this.cooldown;
                this.cooldown = n + -1;
                return;
            }
            if (this.currentLeg != null && this.currentTarget != null) {
                FracturedSubEntity fracturedSubEntity = this.currentLeg;
                Intrinsics.checkNotNull((Object)((Object)fracturedSubEntity));
                FracturedSubEntity leg = fracturedSubEntity;
                Player player = this.currentTarget;
                Intrinsics.checkNotNull((Object)player);
                Player player2 = player;
                this.fracturedEntity.lookAt((Entity)player2, 5.0f, 5.0f);
                leg.setDeltaMovement(FracturedStompGoal.tick$vel(this, 1.0));
                leg.hasImpulse = true;
            }
        } else {
            this.tryStart();
        }
    }

    private final void reset() {
        this.currentTarget = null;
        this.currentLeg = null;
        this.cooldown = 40;
        this.started = false;
        this.stomping = false;
    }

    public boolean canContinueToUse() {
        return this.started && this.cooldown <= 0;
    }

    private final void tryStart() {
        if (this.cooldown > 0) {
            return;
        }
        Player player = this.fracturedEntity.getLevel().getNearestPlayer((Entity)this.fracturedEntity, 200.0);
        if (player == null) {
            return;
        }
        Player player2 = player;
        FracturedStompGoal $this$tryStart_u24lambda_u240 = this;
        boolean bl = false;
        MultipartSubEntity currentClosest = null;
        Iterable $this$forEach$iv = $this$tryStart_u24lambda_u240.fracturedEntity.getSubEntities();
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            MultipartSubEntity it = (MultipartSubEntity)element$iv;
            boolean bl2 = false;
            if (!(it instanceof FracturedSubEntity)) continue;
            if (currentClosest == null) {
                currentClosest = it;
                continue;
            }
            if (!(player2.position().distanceToSqr(it.position()) < player2.position().distanceToSqr(((FracturedSubEntity)currentClosest).position()))) continue;
            currentClosest = it;
        }
        FracturedSubEntity closestLeg = (FracturedSubEntity)currentClosest;
        if (closestLeg == null) {
            return;
        }
        this.currentTarget = player2;
        this.currentLeg = closestLeg;
        this.started = true;
    }

    public void start() {
        this.tryStart();
    }

    private static final Vec3 tick$vel(FracturedStompGoal this$0, double speed) {
        FracturedSubEntity fracturedSubEntity = this$0.currentLeg;
        Intrinsics.checkNotNull((Object)((Object)fracturedSubEntity));
        Vec3 vec3 = fracturedSubEntity.position();
        Intrinsics.checkNotNullExpressionValue((Object)vec3, (String)"position(...)");
        Player player = this$0.currentTarget;
        Intrinsics.checkNotNull((Object)player);
        Vec3 vec32 = player.position().add(0.0, 5.0, 0.0);
        Intrinsics.checkNotNullExpressionValue((Object)vec32, (String)"add(...)");
        Vec3 vec33 = PositionUtil.getNorm((Vec3)PositionUtil.minus((Vec3)vec3, (Vec3)vec32)).multiply(speed, speed, speed);
        Intrinsics.checkNotNullExpressionValue((Object)vec33, (String)"multiply(...)");
        return vec33;
    }
}

