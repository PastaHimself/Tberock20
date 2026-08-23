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
package net.thebrokenscript.entity.fractured.attacks;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.entity.fractured.FracturedEntity;
import net.thebrokenscript.entity.fractured.RockEntity;
import net.thebrokenscript.entity.fractured.attacks.JimAttack;
import net.thebrokenscript.entity.fractured.attacks.JimAttackType;
import net.thebrokenscript.registry.TBSEntities;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.animation.PlayState;
import software.bernie.geckolib.animation.RawAnimation;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0016\u0010\u0011\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0014H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\f\u001a\u00020\tX\u0096D\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0016"}, d2={"Lnet/thebrokenscript/entity/fractured/attacks/MoonRockTossAttack;", "Lnet/thebrokenscript/entity/fractured/attacks/JimAttack;", "<init>", "()V", "type", "Lnet/thebrokenscript/entity/fractured/attacks/JimAttackType;", "getType", "()Lnet/thebrokenscript/entity/fractured/attacks/JimAttackType;", "length", "", "entity", "Lnet/thebrokenscript/entity/fractured/FracturedEntity;", "attackCooldown", "getAttackCooldown", "()J", "tick", "", "animate", "Lsoftware/bernie/geckolib/animation/PlayState;", "state", "Lsoftware/bernie/geckolib/animation/AnimationState;", "Companion", "thebrokenscript-common"})
public final class MoonRockTossAttack
extends JimAttack {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final JimAttackType type = JimAttackType.MOON_ROCK_TOSS;
    private final long attackCooldown;

    public MoonRockTossAttack() {
        this.attackCooldown = 20L;
    }

    @Override
    @NotNull
    public JimAttackType getType() {
        return this.type;
    }

    @Override
    public long length(@NotNull FracturedEntity entity) {
        Intrinsics.checkNotNullParameter((Object)((Object)entity), (String)"entity");
        return 139L;
    }

    @Override
    public long getAttackCooldown() {
        return this.attackCooldown;
    }

    @Override
    public void tick(@NotNull FracturedEntity entity) {
        Intrinsics.checkNotNullParameter((Object)((Object)entity), (String)"entity");
    }

    @Override
    @NotNull
    public PlayState animate(@NotNull AnimationState<FracturedEntity> state) {
        Intrinsics.checkNotNullParameter(state, (String)"state");
        FracturedEntity ent = (FracturedEntity)state.getAnimatable();
        if (ent.getAttackTicks() == 0) {
            state.getController().forceAnimationReset();
        }
        PlayState playState = state.setAndContinue(MoonRockTossAttack.Companion.getROCK_THROW());
        Intrinsics.checkNotNullExpressionValue((Object)playState, (String)"setAndContinue(...)");
        return playState;
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rR\u0014\u0010\u0004\u001a\u00020\u00058BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u000e"}, d2={"Lnet/thebrokenscript/entity/fractured/attacks/MoonRockTossAttack$Companion;", "", "<init>", "()V", "ROCK_THROW", "Lsoftware/bernie/geckolib/animation/RawAnimation;", "getROCK_THROW", "()Lsoftware/bernie/geckolib/animation/RawAnimation;", "throwRock", "", "entity", "Lnet/thebrokenscript/entity/fractured/FracturedEntity;", "from", "Lnet/minecraft/world/phys/Vec3;", "thebrokenscript-common"})
    public static final class Companion {
        private Companion() {
        }

        private final RawAnimation getROCK_THROW() {
            RawAnimation rawAnimation = RawAnimation.begin().thenPlayAndHold("MoonRockToss");
            Intrinsics.checkNotNullExpressionValue((Object)rawAnimation, (String)"thenPlayAndHold(...)");
            return rawAnimation;
        }

        public final void throwRock(@NotNull FracturedEntity entity, @NotNull Vec3 from) {
            Intrinsics.checkNotNullParameter((Object)((Object)entity), (String)"entity");
            Intrinsics.checkNotNullParameter((Object)from, (String)"from");
            LivingEntity livingEntity = entity.getTarget();
            if (livingEntity == null) {
                return;
            }
            LivingEntity target = livingEntity;
            RockEntity rock = new RockEntity((EntityType<RockEntity>)((EntityType)TBSEntities.ROCK.get()), entity.getLevel());
            rock.setOwner((Entity)entity);
            rock.setPos(from.x, from.y, from.z);
            rock.setBaseDamageFromMob(15.0f);
            double x = target.getX() - from.x;
            double y = target.getY(0.5) - from.y;
            double z = target.getZ() - from.z;
            rock.shoot(x, y, z, 8.0f, 0.0f);
            entity.getLevel().addFreshEntity((Entity)rock);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

