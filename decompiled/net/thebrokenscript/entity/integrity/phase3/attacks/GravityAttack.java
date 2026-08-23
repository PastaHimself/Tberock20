/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.core.particles.BlockParticleOption
 *  net.minecraft.core.particles.ParticleOptions
 *  net.minecraft.core.particles.ParticleTypes
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.phys.Vec3
 *  net.thebrokenscript.brokencore.api.dsl.GeckoUtil
 *  org.jetbrains.annotations.NotNull
 *  software.bernie.geckolib.animation.AnimationController
 *  software.bernie.geckolib.animation.AnimationState
 *  software.bernie.geckolib.animation.PlayState
 */
package net.thebrokenscript.entity.integrity.phase3.attacks;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.boss.integrity.BossGlobals;
import net.thebrokenscript.brokencore.api.dsl.GeckoUtil;
import net.thebrokenscript.entity.integrity.phase3.IntegrityPhase3Entity;
import net.thebrokenscript.entity.integrity.phase3.attacks.Attack;
import net.thebrokenscript.entity.integrity.phase3.attacks.AttackType;
import net.thebrokenscript.registry.TBSBlocks;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.animation.AnimationController;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.animation.PlayState;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0016\u0010\u001d\u001a\u00020\u001e2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00130 H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\tX\u0096D\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\rX\u0096D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0018\u001a\u00020\u0019X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b\u00a8\u0006!"}, d2={"Lnet/thebrokenscript/entity/integrity/phase3/attacks/GravityAttack;", "Lnet/thebrokenscript/entity/integrity/phase3/attacks/Attack;", "<init>", "()V", "type", "Lnet/thebrokenscript/entity/integrity/phase3/attacks/AttackType;", "getType", "()Lnet/thebrokenscript/entity/integrity/phase3/attacks/AttackType;", "attackCooldown", "", "getAttackCooldown", "()J", "chance", "", "getChance", "()F", "canUse", "", "entity", "Lnet/thebrokenscript/entity/integrity/phase3/IntegrityPhase3Entity;", "length", "setup", "", "finish", "particlesPerTick", "", "getParticlesPerTick", "()I", "tick", "animate", "Lsoftware/bernie/geckolib/animation/PlayState;", "state", "Lsoftware/bernie/geckolib/animation/AnimationState;", "thebrokenscript-common"})
public final class GravityAttack
extends Attack {
    @NotNull
    private final AttackType type = AttackType.GRAVITY;
    private final long attackCooldown;
    private final float chance;
    private final int particlesPerTick;

    public GravityAttack() {
        this.attackCooldown = 140L;
        this.chance = 0.15f;
        this.particlesPerTick = 20;
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
    public long length(@NotNull IntegrityPhase3Entity entity) {
        Intrinsics.checkNotNullParameter((Object)((Object)entity), (String)"entity");
        return 240L;
    }

    @Override
    public void setup(@NotNull IntegrityPhase3Entity entity) {
        Intrinsics.checkNotNullParameter((Object)((Object)entity), (String)"entity");
        BossGlobals.FLIP_GRAVITY = true;
    }

    @Override
    public void finish(@NotNull IntegrityPhase3Entity entity) {
        Intrinsics.checkNotNullParameter((Object)((Object)entity), (String)"entity");
        BossGlobals.FLIP_GRAVITY = false;
    }

    public final int getParticlesPerTick() {
        return this.particlesPerTick;
    }

    @Override
    public void tick(@NotNull IntegrityPhase3Entity entity) {
        Intrinsics.checkNotNullParameter((Object)((Object)entity), (String)"entity");
        Level level = entity.level();
        Vec3 pos = entity.position();
        int n = this.particlesPerTick;
        int n2 = 0;
        while (n2 < n) {
            int it = n2++;
            boolean bl = false;
            level.addParticle((ParticleOptions)new BlockParticleOption(ParticleTypes.BLOCK, TBSBlocks.INTENSE_PROJECTION.getDefaultState()), pos.x + (Math.random() * (double)10 - (double)5), pos.y, pos.z + (Math.random() * (double)10 - (double)5), 0.0, 2.0, 0.0);
        }
    }

    @Override
    @NotNull
    public PlayState animate(@NotNull AnimationState<IntegrityPhase3Entity> state) {
        Intrinsics.checkNotNullParameter(state, (String)"state");
        AnimationController ctrl = state.getController();
        IntegrityPhase3Entity ent = (IntegrityPhase3Entity)state.getAnimatable();
        if (ent.getAttackTicks() == 1) {
            ctrl.forceAnimationReset();
        }
        if (ent.getAttackTicks() < 61) {
            Intrinsics.checkNotNull((Object)ctrl);
            Intrinsics.checkNotNull((Object)((Object)ent));
            GeckoUtil.once((AnimationController)ctrl, (Entity)((Entity)ent), (String)"reverseGravityInitiate");
        } else if (ent.getAttackTicks() > 180) {
            Intrinsics.checkNotNull((Object)ctrl);
            Intrinsics.checkNotNull((Object)((Object)ent));
            GeckoUtil.hold((AnimationController)ctrl, (Entity)((Entity)ent), (String)"reverseGravityOff");
        } else {
            Intrinsics.checkNotNull((Object)ctrl);
            Intrinsics.checkNotNull((Object)((Object)ent));
            GeckoUtil.once((AnimationController)ctrl, (Entity)((Entity)ent), (String)"idle");
        }
        return PlayState.CONTINUE;
    }
}

