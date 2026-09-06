/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.TuplesKt
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 *  software.bernie.geckolib.animation.AnimationState
 *  software.bernie.geckolib.animation.PlayState
 */
package net.thebrokenscript.entity.fractured.attacks;

import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import net.thebrokenscript.api.entity.BaseFracturedEntity;
import net.thebrokenscript.entity.fractured.FracturedEntity;
import net.thebrokenscript.entity.fractured.attacks.JimAttackType;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.animation.PlayState;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000eH&J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\r\u001a\u00020\u000eH&J\u0010\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0016\u0010\u001f\u001a\u00020 2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u000e0\"H&R\u0012\u0010\u0004\u001a\u00020\u0005X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\tX\u0096D\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0012\u001a\u00020\u0013X\u0096D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R \u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00180\u0017X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a\u00a8\u0006#"}, d2={"Lnet/thebrokenscript/entity/fractured/attacks/JimAttack;", "", "<init>", "()V", "type", "Lnet/thebrokenscript/entity/fractured/attacks/JimAttackType;", "getType", "()Lnet/thebrokenscript/entity/fractured/attacks/JimAttackType;", "attackCooldown", "", "getAttackCooldown", "()J", "length", "entity", "Lnet/thebrokenscript/entity/fractured/FracturedEntity;", "canUse", "", "canMove", "chance", "", "getChance", "()F", "distanceRange", "Lkotlin/Pair;", "", "getDistanceRange", "()Lkotlin/Pair;", "tick", "", "setup", "finish", "animate", "Lsoftware/bernie/geckolib/animation/PlayState;", "state", "Lsoftware/bernie/geckolib/animation/AnimationState;", "thebrokenscript-common"})
public abstract class JimAttack {
    private final long attackCooldown;
    private final float chance;
    @NotNull
    private final Pair<Integer, Integer> distanceRange = TuplesKt.to((Object)Integer.MIN_VALUE, (Object)Integer.MAX_VALUE);

    public JimAttack() {
        this.chance = 1.0f;
    }

    @NotNull
    public abstract JimAttackType getType();

    public long getAttackCooldown() {
        return this.attackCooldown;
    }

    public abstract long length(@NotNull FracturedEntity var1);

    public boolean canUse(@NotNull FracturedEntity entity) {
        Intrinsics.checkNotNullParameter((Object)((Object)entity), (String)"entity");
        return true;
    }

    public boolean canMove(@NotNull FracturedEntity entity) {
        Intrinsics.checkNotNullParameter((Object)((Object)entity), (String)"entity");
        return false;
    }

    public float getChance() {
        return this.chance;
    }

    @NotNull
    public Pair<Integer, Integer> getDistanceRange() {
        return this.distanceRange;
    }

    public abstract void tick(@NotNull FracturedEntity var1);

    public void setup(@NotNull FracturedEntity entity) {
        Intrinsics.checkNotNullParameter((Object)((Object)entity), (String)"entity");
        entity.setCurrentState(BaseFracturedEntity.JimmyStates.ATTACKING);
    }

    public void finish(@NotNull FracturedEntity entity) {
        Intrinsics.checkNotNullParameter((Object)((Object)entity), (String)"entity");
        entity.setCurrentState(BaseFracturedEntity.JimmyStates.NORMAL);
    }

    @NotNull
    public abstract PlayState animate(@NotNull AnimationState<FracturedEntity> var1);
}

