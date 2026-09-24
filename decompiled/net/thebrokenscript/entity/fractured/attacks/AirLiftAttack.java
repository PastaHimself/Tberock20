/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.server.level.ServerPlayer
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.phys.Vec3
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  org.joml.Vector3f
 *  software.bernie.geckolib.animation.AnimationState
 *  software.bernie.geckolib.animation.PlayState
 *  software.bernie.geckolib.animation.RawAnimation
 */
package net.thebrokenscript.entity.fractured.attacks;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.entity.fractured.FracturedEntity;
import net.thebrokenscript.entity.fractured.RockEntity;
import net.thebrokenscript.entity.fractured.attacks.JimAttack;
import net.thebrokenscript.entity.fractured.attacks.JimAttackType;
import net.thebrokenscript.registry.TBSEntities;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector3f;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.animation.PlayState;
import software.bernie.geckolib.animation.RawAnimation;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0016\u0010\u0018\u001a\u00020\u00192\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00140\u001bH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u00020\u000eX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u001d"}, d2={"Lnet/thebrokenscript/entity/fractured/attacks/AirLiftAttack;", "Lnet/thebrokenscript/entity/fractured/attacks/JimAttack;", "<init>", "()V", "moonRock", "Lnet/thebrokenscript/entity/fractured/RockEntity;", "ticks", "", "capturedPlayers", "", "Lnet/minecraft/server/level/ServerPlayer;", "prevRockPos", "Lorg/joml/Vector3f;", "type", "Lnet/thebrokenscript/entity/fractured/attacks/JimAttackType;", "getType", "()Lnet/thebrokenscript/entity/fractured/attacks/JimAttackType;", "setup", "", "entity", "Lnet/thebrokenscript/entity/fractured/FracturedEntity;", "length", "", "tick", "animate", "Lsoftware/bernie/geckolib/animation/PlayState;", "state", "Lsoftware/bernie/geckolib/animation/AnimationState;", "Companion", "thebrokenscript-common"})
public final class AirLiftAttack
extends JimAttack {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @Nullable
    private RockEntity moonRock;
    private int ticks;
    @NotNull
    private List<ServerPlayer> capturedPlayers = new ArrayList();
    @Nullable
    private Vector3f prevRockPos;
    @NotNull
    private final JimAttackType type = JimAttackType.AIR_LIFT;

    @Override
    @NotNull
    public JimAttackType getType() {
        return this.type;
    }

    @Override
    public void setup(@NotNull FracturedEntity entity) {
        Intrinsics.checkNotNullParameter((Object)((Object)entity), (String)"entity");
        super.setup(entity);
        this.ticks = 0;
        this.capturedPlayers.clear();
        this.prevRockPos = null;
    }

    @Override
    public long length(@NotNull FracturedEntity entity) {
        Intrinsics.checkNotNullParameter((Object)((Object)entity), (String)"entity");
        return 60L;
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
        PlayState playState = state.setAndContinue(AirLiftAttack.Companion.getATTACK_START());
        Intrinsics.checkNotNullExpressionValue((Object)playState, (String)"setAndContinue(...)");
        return playState;
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rR\u0014\u0010\u0004\u001a\u00020\u00058BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u000e"}, d2={"Lnet/thebrokenscript/entity/fractured/attacks/AirLiftAttack$Companion;", "", "<init>", "()V", "ATTACK_START", "Lsoftware/bernie/geckolib/animation/RawAnimation;", "getATTACK_START", "()Lsoftware/bernie/geckolib/animation/RawAnimation;", "dropRock", "", "entity", "Lnet/thebrokenscript/entity/fractured/FracturedEntity;", "from", "Lnet/minecraft/world/phys/Vec3;", "thebrokenscript-common"})
    public static final class Companion {
        private Companion() {
        }

        private final RawAnimation getATTACK_START() {
            RawAnimation rawAnimation = RawAnimation.begin().thenPlayAndHold("DefenseAirLift");
            Intrinsics.checkNotNullExpressionValue((Object)rawAnimation, (String)"thenPlayAndHold(...)");
            return rawAnimation;
        }

        public final void dropRock(@NotNull FracturedEntity entity, @NotNull Vec3 from) {
            Intrinsics.checkNotNullParameter((Object)((Object)entity), (String)"entity");
            Intrinsics.checkNotNullParameter((Object)from, (String)"from");
            RockEntity rock = new RockEntity((EntityType<RockEntity>)((EntityType)TBSEntities.ROCK.get()), entity.getLevel());
            rock.setOwner((Entity)entity);
            rock.setPos(from.x, from.y, from.z);
            rock.setBaseDamageFromMob(15.0f);
            rock.shoot(entity.getX(), entity.getY(), entity.getZ(), 0.0f, 0.0f);
            entity.getLevel().addFreshEntity((Entity)rock);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

