/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.world.entity.Entity
 *  net.thebrokenscript.brokencore.api.dsl.GeckoUtil
 *  org.jetbrains.annotations.NotNull
 *  software.bernie.geckolib.animation.AnimationState
 *  software.bernie.geckolib.animation.PlayState
 */
package net.thebrokenscript.entity.fractured.attacks;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.world.entity.Entity;
import net.thebrokenscript.brokencore.api.dsl.GeckoUtil;
import net.thebrokenscript.entity.fractured.FracturedEntity;
import net.thebrokenscript.entity.fractured.attacks.JimAttack;
import net.thebrokenscript.entity.fractured.attacks.JimAttackType;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.animation.PlayState;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0016\u0010\u0011\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0014H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u0015"}, d2={"Lnet/thebrokenscript/entity/fractured/attacks/NoopAttack;", "Lnet/thebrokenscript/entity/fractured/attacks/JimAttack;", "<init>", "()V", "type", "Lnet/thebrokenscript/entity/fractured/attacks/JimAttackType;", "getType", "()Lnet/thebrokenscript/entity/fractured/attacks/JimAttackType;", "length", "", "entity", "Lnet/thebrokenscript/entity/fractured/FracturedEntity;", "canUse", "", "canMove", "tick", "", "animate", "Lsoftware/bernie/geckolib/animation/PlayState;", "state", "Lsoftware/bernie/geckolib/animation/AnimationState;", "thebrokenscript-common"})
public final class NoopAttack
extends JimAttack {
    @NotNull
    private final JimAttackType type = JimAttackType.NOOP;

    @Override
    @NotNull
    public JimAttackType getType() {
        return this.type;
    }

    @Override
    public long length(@NotNull FracturedEntity entity) {
        Intrinsics.checkNotNullParameter((Object)((Object)entity), (String)"entity");
        return -1L;
    }

    @Override
    public boolean canUse(@NotNull FracturedEntity entity) {
        Intrinsics.checkNotNullParameter((Object)((Object)entity), (String)"entity");
        return false;
    }

    @Override
    public boolean canMove(@NotNull FracturedEntity entity) {
        Intrinsics.checkNotNullParameter((Object)((Object)entity), (String)"entity");
        return true;
    }

    @Override
    public void tick(@NotNull FracturedEntity entity) {
        Intrinsics.checkNotNullParameter((Object)((Object)entity), (String)"entity");
    }

    @Override
    @NotNull
    public PlayState animate(@NotNull AnimationState<FracturedEntity> state) {
        PlayState playState;
        Intrinsics.checkNotNullParameter(state, (String)"state");
        FracturedEntity ent = (FracturedEntity)state.getAnimatable();
        if (ent.isMoving()) {
            Intrinsics.checkNotNull((Object)((Object)ent));
            playState = GeckoUtil.loop(state, (Entity)((Entity)ent), (String)"Walk");
        } else {
            Intrinsics.checkNotNull((Object)((Object)ent));
            playState = GeckoUtil.loop(state, (Entity)((Entity)ent), (String)"Idle");
        }
        return playState;
    }
}

