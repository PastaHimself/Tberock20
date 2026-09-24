/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.TuplesKt
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.core.BlockPos
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.level.Level
 *  net.thebrokenscript.brokencore.api.dsl.GeckoUtil
 *  org.jetbrains.annotations.NotNull
 *  software.bernie.geckolib.animation.AnimationState
 *  software.bernie.geckolib.animation.PlayState
 *  software.bernie.geckolib.animation.RawAnimation
 */
package net.thebrokenscript.entity.integrity.phase3.attacks;

import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.thebrokenscript.brokencore.api.dsl.GeckoUtil;
import net.thebrokenscript.entity.integrity.phase3.IntegrityP3GroundArmEntity;
import net.thebrokenscript.entity.integrity.phase3.IntegrityPhase3Entity;
import net.thebrokenscript.entity.integrity.phase3.attacks.Attack;
import net.thebrokenscript.entity.integrity.phase3.attacks.AttackType;
import net.thebrokenscript.registry.TBSEntities;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.animation.PlayState;
import software.bernie.geckolib.animation.RawAnimation;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 $2\u00020\u0001:\u0001$B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0010\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0010\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0010\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0010\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0010\u0010\u001f\u001a\u00020\u001d2\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0016\u0010 \u001a\u00020!2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00180#H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\tX\u0096D\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR \u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\rX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u0012X\u0096D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014\u00a8\u0006%"}, d2={"Lnet/thebrokenscript/entity/integrity/phase3/attacks/GroundAttack;", "Lnet/thebrokenscript/entity/integrity/phase3/attacks/Attack;", "<init>", "()V", "type", "Lnet/thebrokenscript/entity/integrity/phase3/attacks/AttackType;", "getType", "()Lnet/thebrokenscript/entity/integrity/phase3/attacks/AttackType;", "attackCooldown", "", "getAttackCooldown", "()J", "distanceRange", "Lkotlin/Pair;", "", "getDistanceRange", "()Lkotlin/Pair;", "chance", "", "getChance", "()F", "canMove", "", "entity", "Lnet/thebrokenscript/entity/integrity/phase3/IntegrityPhase3Entity;", "canUse", "moveTick", "length", "setup", "", "tick", "finish", "animate", "Lsoftware/bernie/geckolib/animation/PlayState;", "state", "Lsoftware/bernie/geckolib/animation/AnimationState;", "Companion", "thebrokenscript-common"})
public final class GroundAttack
extends Attack {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final AttackType type = AttackType.GROUND_ATTACK;
    private final long attackCooldown;
    @NotNull
    private final Pair<Integer, Integer> distanceRange = TuplesKt.to((Object)40, (Object)80);
    private final float chance;

    public GroundAttack() {
        this.attackCooldown = 70L;
        this.chance = 1.0f;
    }

    @Override
    @NotNull
    public AttackType getType() {
        return this.type;
    }

    @Override
    public long getAttackCooldown() {
        return this.attackCooldown;
    }

    @Override
    @NotNull
    public Pair<Integer, Integer> getDistanceRange() {
        return this.distanceRange;
    }

    @Override
    public float getChance() {
        return this.chance;
    }

    @Override
    public boolean canMove(@NotNull IntegrityPhase3Entity entity) {
        Intrinsics.checkNotNullParameter((Object)((Object)entity), (String)"entity");
        return false;
    }

    @Override
    public boolean canUse(@NotNull IntegrityPhase3Entity entity) {
        Intrinsics.checkNotNullParameter((Object)((Object)entity), (String)"entity");
        return true;
    }

    @Override
    public boolean moveTick(@NotNull IntegrityPhase3Entity entity) {
        Intrinsics.checkNotNullParameter((Object)((Object)entity), (String)"entity");
        return false;
    }

    @Override
    public long length(@NotNull IntegrityPhase3Entity entity) {
        Intrinsics.checkNotNullParameter((Object)((Object)entity), (String)"entity");
        return !entity.stuckStatus() ? 175L : 260L;
    }

    @Override
    public void setup(@NotNull IntegrityPhase3Entity entity) {
        Intrinsics.checkNotNullParameter((Object)((Object)entity), (String)"entity");
        entity.setGroundAttackTimer(0);
    }

    @Override
    public void tick(@NotNull IntegrityPhase3Entity entity) {
        IntegrityP3GroundArmEntity arm;
        Intrinsics.checkNotNullParameter((Object)((Object)entity), (String)"entity");
        Level level = entity.getLevel();
        int n = entity.getGroundAttackTimer();
        entity.setGroundAttackTimer(n + 1);
        if (entity.getGroundAttackTimer() == 33 && entity.getTarget() != null) {
            LivingEntity livingEntity = entity.getTarget();
            Intrinsics.checkNotNull((Object)livingEntity);
            entity.setGroundAttackTargetPos(livingEntity.blockPosition());
        }
        BlockPos blockPos = entity.getGroundAttackTargetPos();
        if (blockPos == null) {
            return;
        }
        BlockPos targetPos = blockPos;
        if (level instanceof ServerLevel && entity.getGroundAttackTimer() == 40 && (arm = (IntegrityP3GroundArmEntity)((EntityType)TBSEntities.INTEGRITY_ARM.get()).create(level)) != null) {
            arm.setOwnerEntity(entity);
            arm.moveTo((double)targetPos.getX() + 0.5, targetPos.getY(), (double)targetPos.getZ() + 0.5);
            ((ServerLevel)level).addFreshEntity((Entity)arm);
        }
        entity.getLookControl().setLookAt(targetPos.getCenter());
    }

    @Override
    public void finish(@NotNull IntegrityPhase3Entity entity) {
        Intrinsics.checkNotNullParameter((Object)((Object)entity), (String)"entity");
        entity.setGroundAttackTimer(0);
        entity.setGroundAttackTargetPos(null);
        entity.setStuckStatus(false);
    }

    @Override
    @NotNull
    public PlayState animate(@NotNull AnimationState<IntegrityPhase3Entity> state) {
        PlayState playState;
        Intrinsics.checkNotNullParameter(state, (String)"state");
        IntegrityPhase3Entity ent = (IntegrityPhase3Entity)state.getAnimatable();
        int timer = ent.getGroundAttackTimer();
        if (timer >= 75 && ent.stuckStatus()) {
            PlayState playState2 = state.setAndContinue(GroundAttack.Companion.getATTACK_END_STUCK());
            playState = playState2;
            Intrinsics.checkNotNullExpressionValue((Object)playState2, (String)"setAndContinue(...)");
        } else if (timer >= 75 && !ent.stuckStatus()) {
            Intrinsics.checkNotNull((Object)((Object)ent));
            playState = GeckoUtil.hold(state, (Entity)((Entity)ent), (String)"attackGroundStand");
        } else if (timer > 0) {
            PlayState playState3 = state.setAndContinue(GroundAttack.Companion.getATTACK_START());
            playState = playState3;
            Intrinsics.checkNotNullExpressionValue((Object)playState3, (String)"setAndContinue(...)");
        } else {
            PlayState playState4 = state.setAndContinue(GroundAttack.Companion.getIDLE());
            playState = playState4;
            Intrinsics.checkNotNullExpressionValue((Object)playState4, (String)"setAndContinue(...)");
        }
        return playState;
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\u00020\u00058BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00058BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u00058BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\u0007\u00a8\u0006\f"}, d2={"Lnet/thebrokenscript/entity/integrity/phase3/attacks/GroundAttack$Companion;", "", "<init>", "()V", "IDLE", "Lsoftware/bernie/geckolib/animation/RawAnimation;", "getIDLE", "()Lsoftware/bernie/geckolib/animation/RawAnimation;", "ATTACK_START", "getATTACK_START", "ATTACK_END_STUCK", "getATTACK_END_STUCK", "thebrokenscript-common"})
    public static final class Companion {
        private Companion() {
        }

        private final RawAnimation getIDLE() {
            RawAnimation rawAnimation = RawAnimation.begin().thenLoop("idle");
            Intrinsics.checkNotNullExpressionValue((Object)rawAnimation, (String)"thenLoop(...)");
            return rawAnimation;
        }

        private final RawAnimation getATTACK_START() {
            RawAnimation rawAnimation = RawAnimation.begin().thenPlayAndHold("attackGround");
            Intrinsics.checkNotNullExpressionValue((Object)rawAnimation, (String)"thenPlayAndHold(...)");
            return rawAnimation;
        }

        private final RawAnimation getATTACK_END_STUCK() {
            RawAnimation rawAnimation = RawAnimation.begin().thenPlay("attackGroundStandStuck").thenLoop("idle");
            Intrinsics.checkNotNullExpressionValue((Object)rawAnimation, (String)"thenLoop(...)");
            return rawAnimation;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

