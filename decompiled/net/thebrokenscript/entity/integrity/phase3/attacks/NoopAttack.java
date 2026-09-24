/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.phys.Vec3
 *  net.thebrokenscript.brokencore.api.dsl.EntityFinder
 *  net.thebrokenscript.brokencore.api.dsl.GeckoUtil
 *  org.jetbrains.annotations.NotNull
 *  software.bernie.geckolib.animation.AnimationState
 *  software.bernie.geckolib.animation.PlayState
 */
package net.thebrokenscript.entity.integrity.phase3.attacks;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.brokencore.api.dsl.EntityFinder;
import net.thebrokenscript.brokencore.api.dsl.GeckoUtil;
import net.thebrokenscript.entity.integrity.phase3.IntegrityPhase3Entity;
import net.thebrokenscript.entity.integrity.phase3.attacks.Attack;
import net.thebrokenscript.entity.integrity.phase3.attacks.AttackType;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.animation.PlayState;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\u0011\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0016\u0010\u0012\u001a\u00020\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0015H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u0016"}, d2={"Lnet/thebrokenscript/entity/integrity/phase3/attacks/NoopAttack;", "Lnet/thebrokenscript/entity/integrity/phase3/attacks/Attack;", "<init>", "()V", "type", "Lnet/thebrokenscript/entity/integrity/phase3/attacks/AttackType;", "getType", "()Lnet/thebrokenscript/entity/integrity/phase3/attacks/AttackType;", "length", "", "entity", "Lnet/thebrokenscript/entity/integrity/phase3/IntegrityPhase3Entity;", "canUse", "", "canMove", "tick", "", "moveTick", "animate", "Lsoftware/bernie/geckolib/animation/PlayState;", "state", "Lsoftware/bernie/geckolib/animation/AnimationState;", "thebrokenscript-common"})
@SourceDebugExtension(value={"SMAP\nNoopAttack.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NoopAttack.kt\nnet/thebrokenscript/entity/integrity/phase3/attacks/NoopAttack\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,40:1\n1869#2,2:41\n*S KotlinDebug\n*F\n+ 1 NoopAttack.kt\nnet/thebrokenscript/entity/integrity/phase3/attacks/NoopAttack\n*L\n23#1:41,2\n*E\n"})
public final class NoopAttack
extends Attack {
    @NotNull
    private final AttackType type = AttackType.NOOP;

    @Override
    @NotNull
    public AttackType getType() {
        return this.type;
    }

    @Override
    public long length(@NotNull IntegrityPhase3Entity entity) {
        Intrinsics.checkNotNullParameter((Object)((Object)entity), (String)"entity");
        return -1L;
    }

    @Override
    public boolean canUse(@NotNull IntegrityPhase3Entity entity) {
        Intrinsics.checkNotNullParameter((Object)((Object)entity), (String)"entity");
        return false;
    }

    @Override
    public boolean canMove(@NotNull IntegrityPhase3Entity entity) {
        Intrinsics.checkNotNullParameter((Object)((Object)entity), (String)"entity");
        return !entity.stuckStatus();
    }

    @Override
    public void tick(@NotNull IntegrityPhase3Entity entity) {
        Intrinsics.checkNotNullParameter((Object)((Object)entity), (String)"entity");
        if (entity.tickCount % 5 == 0 && !entity.stuckStatus()) {
            List players = EntityFinder.findPlayersInRange((LevelAccessor)((LevelAccessor)entity.getLevel()), (Vec3)entity.getPos(), (Number)5);
            Iterable $this$forEach$iv = players;
            boolean $i$f$forEach = false;
            for (Object element$iv : $this$forEach$iv) {
                Player player = (Player)element$iv;
                boolean bl = false;
                player.hurt(entity.damageSources().mobAttack((LivingEntity)entity), 4.0f);
            }
        }
    }

    @Override
    public boolean moveTick(@NotNull IntegrityPhase3Entity entity) {
        Intrinsics.checkNotNullParameter((Object)((Object)entity), (String)"entity");
        return true;
    }

    @Override
    @NotNull
    public PlayState animate(@NotNull AnimationState<IntegrityPhase3Entity> state) {
        PlayState playState;
        Intrinsics.checkNotNullParameter(state, (String)"state");
        IntegrityPhase3Entity ent = (IntegrityPhase3Entity)state.getAnimatable();
        if (ent.stuckStatus()) {
            Intrinsics.checkNotNull((Object)((Object)ent));
            playState = GeckoUtil.loop(state, (Entity)((Entity)ent), (String)"stuckFootL");
        } else if (ent.isMoving()) {
            Intrinsics.checkNotNull((Object)((Object)ent));
            playState = GeckoUtil.loop(state, (Entity)((Entity)ent), (String)"walk");
        } else {
            Intrinsics.checkNotNull((Object)((Object)ent));
            playState = GeckoUtil.loop(state, (Entity)((Entity)ent), (String)"idle");
        }
        return playState;
    }
}

