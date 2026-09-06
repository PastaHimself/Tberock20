/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.phys.Vec3
 *  org.jetbrains.annotations.NotNull
 *  software.bernie.geckolib.animation.AnimationState
 *  software.bernie.geckolib.animation.PlayState
 *  software.bernie.geckolib.animation.RawAnimation
 */
package net.thebrokenscript.entity.integrity.phase3.attacks;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.entity.integrity.phase3.IntegFireballEntity;
import net.thebrokenscript.entity.integrity.phase3.IntegrityPhase3Entity;
import net.thebrokenscript.entity.integrity.phase3.attacks.Attack;
import net.thebrokenscript.entity.integrity.phase3.attacks.AttackType;
import net.thebrokenscript.registry.TBSEntities;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.animation.PlayState;
import software.bernie.geckolib.animation.RawAnimation;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0016\u0010\u001a\u001a\u00020\u001b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00130\u001dH\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\tX\u0096D\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\rX\u0096D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u001f"}, d2={"Lnet/thebrokenscript/entity/integrity/phase3/attacks/FireballAttack;", "Lnet/thebrokenscript/entity/integrity/phase3/attacks/Attack;", "<init>", "()V", "type", "Lnet/thebrokenscript/entity/integrity/phase3/attacks/AttackType;", "getType", "()Lnet/thebrokenscript/entity/integrity/phase3/attacks/AttackType;", "attackCooldown", "", "getAttackCooldown", "()J", "chance", "", "getChance", "()F", "canUse", "", "entity", "Lnet/thebrokenscript/entity/integrity/phase3/IntegrityPhase3Entity;", "canMove", "length", "setup", "", "finish", "tick", "animate", "Lsoftware/bernie/geckolib/animation/PlayState;", "state", "Lsoftware/bernie/geckolib/animation/AnimationState;", "Companion", "thebrokenscript-common"})
public final class FireballAttack
extends Attack {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final AttackType type = AttackType.FIREBALL;
    private final long attackCooldown;
    private final float chance;

    public FireballAttack() {
        this.attackCooldown = 120L;
        this.chance = 0.15f;
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
    public float getChance() {
        return this.chance;
    }

    @Override
    public boolean canUse(@NotNull IntegrityPhase3Entity entity) {
        Intrinsics.checkNotNullParameter((Object)((Object)entity), (String)"entity");
        return true;
    }

    @Override
    public boolean canMove(@NotNull IntegrityPhase3Entity entity) {
        Intrinsics.checkNotNullParameter((Object)((Object)entity), (String)"entity");
        return false;
    }

    @Override
    public long length(@NotNull IntegrityPhase3Entity entity) {
        Intrinsics.checkNotNullParameter((Object)((Object)entity), (String)"entity");
        return 144L;
    }

    @Override
    public void setup(@NotNull IntegrityPhase3Entity entity) {
        Intrinsics.checkNotNullParameter((Object)((Object)entity), (String)"entity");
    }

    @Override
    public void finish(@NotNull IntegrityPhase3Entity entity) {
        Intrinsics.checkNotNullParameter((Object)((Object)entity), (String)"entity");
        entity.setShotFireball(false);
    }

    @Override
    public void tick(@NotNull IntegrityPhase3Entity entity) {
        Intrinsics.checkNotNullParameter((Object)((Object)entity), (String)"entity");
    }

    @Override
    @NotNull
    public PlayState animate(@NotNull AnimationState<IntegrityPhase3Entity> state) {
        Intrinsics.checkNotNullParameter(state, (String)"state");
        if (state.getController().hasAnimationFinished()) {
            state.resetCurrentAnimation();
        }
        state.setAndContinue(FireballAttack.Companion.getANIM());
        return PlayState.CONTINUE;
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rR\u0014\u0010\u0004\u001a\u00020\u00058BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u000e"}, d2={"Lnet/thebrokenscript/entity/integrity/phase3/attacks/FireballAttack$Companion;", "", "<init>", "()V", "ANIM", "Lsoftware/bernie/geckolib/animation/RawAnimation;", "getANIM", "()Lsoftware/bernie/geckolib/animation/RawAnimation;", "throwFireball", "", "entity", "Lnet/thebrokenscript/entity/integrity/phase3/IntegrityPhase3Entity;", "from", "Lnet/minecraft/world/phys/Vec3;", "thebrokenscript-common"})
    public static final class Companion {
        private Companion() {
        }

        private final RawAnimation getANIM() {
            RawAnimation rawAnimation = RawAnimation.begin().thenPlay("attackProjectile").thenLoop("idle");
            Intrinsics.checkNotNullExpressionValue((Object)rawAnimation, (String)"thenLoop(...)");
            return rawAnimation;
        }

        public final void throwFireball(@NotNull IntegrityPhase3Entity entity, @NotNull Vec3 from) {
            Intrinsics.checkNotNullParameter((Object)((Object)entity), (String)"entity");
            Intrinsics.checkNotNullParameter((Object)from, (String)"from");
            if (entity.getShotFireball()) {
                return;
            }
            entity.setShotFireball(true);
            LivingEntity livingEntity = entity.getTarget();
            if (livingEntity == null) {
                return;
            }
            LivingEntity target = livingEntity;
            IntegFireballEntity fb = new IntegFireballEntity((EntityType<IntegFireballEntity>)((EntityType)TBSEntities.INTEG_FIREBALL.get()), entity.getLevel());
            fb.setPos(from.x, from.y, from.z);
            double x = target.getX() - from.x;
            double y = target.getY(0.5) - from.y;
            double z = target.getZ() - from.z;
            fb.shoot(x, y, z, 1.6f, 0.0f);
            entity.getLevel().addFreshEntity((Entity)fb);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

