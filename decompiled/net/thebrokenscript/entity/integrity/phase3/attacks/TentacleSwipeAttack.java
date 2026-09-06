/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.server.level.ServerPlayer
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.phys.Vec3
 *  net.thebrokenscript.brokencore.api.dsl.EntityFinder
 *  net.thebrokenscript.brokencore.api.dsl.PositionUtil
 *  net.thebrokenscript.brokencore.api.global.GlobalMathKt
 *  org.jetbrains.annotations.NotNull
 *  org.joml.Matrix4f
 *  org.joml.Vector3f
 *  org.joml.Vector3fc
 *  software.bernie.geckolib.animation.AnimationState
 *  software.bernie.geckolib.animation.PlayState
 *  software.bernie.geckolib.animation.RawAnimation
 */
package net.thebrokenscript.entity.integrity.phase3.attacks;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.brokencore.api.dsl.EntityFinder;
import net.thebrokenscript.brokencore.api.dsl.PositionUtil;
import net.thebrokenscript.brokencore.api.global.GlobalMathKt;
import net.thebrokenscript.entity.integrity.phase3.IntegrityPhase3Entity;
import net.thebrokenscript.entity.integrity.phase3.attacks.Attack;
import net.thebrokenscript.entity.integrity.phase3.attacks.AttackType;
import org.jetbrains.annotations.NotNull;
import org.joml.Matrix4f;
import org.joml.Vector3f;
import org.joml.Vector3fc;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.animation.PlayState;
import software.bernie.geckolib.animation.RawAnimation;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0016\u0010\u0019\u001a\u00020\u001a2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00130\u001cH\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\tX\u0096D\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\rX\u0096D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u001e"}, d2={"Lnet/thebrokenscript/entity/integrity/phase3/attacks/TentacleSwipeAttack;", "Lnet/thebrokenscript/entity/integrity/phase3/attacks/Attack;", "<init>", "()V", "type", "Lnet/thebrokenscript/entity/integrity/phase3/attacks/AttackType;", "getType", "()Lnet/thebrokenscript/entity/integrity/phase3/attacks/AttackType;", "attackCooldown", "", "getAttackCooldown", "()J", "chance", "", "getChance", "()F", "canUse", "", "entity", "Lnet/thebrokenscript/entity/integrity/phase3/IntegrityPhase3Entity;", "length", "setup", "", "finish", "tick", "animate", "Lsoftware/bernie/geckolib/animation/PlayState;", "state", "Lsoftware/bernie/geckolib/animation/AnimationState;", "Companion", "thebrokenscript-common"})
@SourceDebugExtension(value={"SMAP\nTentacleSwipeAttack.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TentacleSwipeAttack.kt\nnet/thebrokenscript/entity/integrity/phase3/attacks/TentacleSwipeAttack\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,75:1\n1869#2,2:76\n*S KotlinDebug\n*F\n+ 1 TentacleSwipeAttack.kt\nnet/thebrokenscript/entity/integrity/phase3/attacks/TentacleSwipeAttack\n*L\n41#1:76,2\n*E\n"})
public final class TentacleSwipeAttack
extends Attack {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final AttackType type = AttackType.TENTACLE_SWIPE;
    private final long attackCooldown;
    private final float chance;
    private static final int ATTACK_OFFSET_TICKS = 9;
    private static final float ATTACK_AOE_RADIUS = 14.0f;
    private static final float ATTACK_DAMAGE = 5.0f;
    @NotNull
    private static final Vec3 ATTACK_OFFSET_POS = new Vec3(-291.5252, 400.7372, 5.4492);

    public TentacleSwipeAttack() {
        this.attackCooldown = 100L;
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
    public long length(@NotNull IntegrityPhase3Entity entity) {
        Intrinsics.checkNotNullParameter((Object)((Object)entity), (String)"entity");
        return 40L;
    }

    @Override
    public void setup(@NotNull IntegrityPhase3Entity entity) {
        Intrinsics.checkNotNullParameter((Object)((Object)entity), (String)"entity");
        entity.setSwipeAttackTimer(0);
    }

    @Override
    public void finish(@NotNull IntegrityPhase3Entity entity) {
        Intrinsics.checkNotNullParameter((Object)((Object)entity), (String)"entity");
    }

    @Override
    public void tick(@NotNull IntegrityPhase3Entity entity) {
        Intrinsics.checkNotNullParameter((Object)((Object)entity), (String)"entity");
        int n = entity.getSwipeAttackTimer();
        entity.setSwipeAttackTimer(n + 1);
        if (entity.getSwipeAttackTimer() == 9) {
            Vector3f add = ATTACK_OFFSET_POS.toVector3f().mul(0.125f);
            Matrix4f mat = new Matrix4f().rotateY(-GlobalMathKt.getToRadians((float)entity.getYRot()) + (float)Math.PI);
            Vector3f realAdd = mat.transformPosition(add);
            Vec3 vec3 = entity.getPos();
            Intrinsics.checkNotNull((Object)realAdd);
            Vec3 realPos = vec3.add(PositionUtil.toVec3((Vector3fc)((Vector3fc)realAdd)));
            Level level = entity.getLevel();
            ServerLevel serverLevel = level instanceof ServerLevel ? (ServerLevel)level : null;
            if (serverLevel == null) {
                return;
            }
            ServerLevel level2 = serverLevel;
            Intrinsics.checkNotNull((Object)realPos);
            List players = EntityFinder.findPlayersInRange((ServerLevel)level2, (Vec3)realPos, (Number)Float.valueOf(14.0f));
            Iterable $this$forEach$iv = players;
            boolean $i$f$forEach = false;
            for (Object element$iv : $this$forEach$iv) {
                ServerPlayer it = (ServerPlayer)element$iv;
                boolean bl = false;
                Vec3 position = it.position();
                Intrinsics.checkNotNull((Object)position);
                Vec3 diff = PositionUtil.minus((Vec3)position, (Vec3)realPos);
                it.hurt(it.damageSources().mobAttack((LivingEntity)entity), 5.0f);
                it.knockback(2.0, diff.x, diff.z);
            }
        }
    }

    @Override
    @NotNull
    public PlayState animate(@NotNull AnimationState<IntegrityPhase3Entity> state) {
        PlayState playState;
        Intrinsics.checkNotNullParameter(state, (String)"state");
        IntegrityPhase3Entity ent = (IntegrityPhase3Entity)state.getAnimatable();
        int timer = ent.getSwipeAttackTimer();
        if (timer == 1) {
            state.resetCurrentAnimation();
        }
        if (timer > 0) {
            PlayState playState2 = state.setAndContinue(TentacleSwipeAttack.Companion.getATTACK_START());
            playState = playState2;
            Intrinsics.checkNotNullExpressionValue((Object)playState2, (String)"setAndContinue(...)");
        } else {
            PlayState playState3 = state.setAndContinue(TentacleSwipeAttack.Companion.getIDLE());
            playState = playState3;
            Intrinsics.checkNotNullExpressionValue((Object)playState3, (String)"setAndContinue(...)");
        }
        return playState;
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00020\f8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\f8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u000e\u00a8\u0006\u0011"}, d2={"Lnet/thebrokenscript/entity/integrity/phase3/attacks/TentacleSwipeAttack$Companion;", "", "<init>", "()V", "ATTACK_OFFSET_TICKS", "", "ATTACK_AOE_RADIUS", "", "ATTACK_DAMAGE", "ATTACK_OFFSET_POS", "Lnet/minecraft/world/phys/Vec3;", "IDLE", "Lsoftware/bernie/geckolib/animation/RawAnimation;", "getIDLE", "()Lsoftware/bernie/geckolib/animation/RawAnimation;", "ATTACK_START", "getATTACK_START", "thebrokenscript-common"})
    public static final class Companion {
        private Companion() {
        }

        private final RawAnimation getIDLE() {
            RawAnimation rawAnimation = RawAnimation.begin().thenLoop("idle");
            Intrinsics.checkNotNullExpressionValue((Object)rawAnimation, (String)"thenLoop(...)");
            return rawAnimation;
        }

        private final RawAnimation getATTACK_START() {
            RawAnimation rawAnimation = RawAnimation.begin().thenPlayAndHold("backTentacleSwipeL");
            Intrinsics.checkNotNullExpressionValue((Object)rawAnimation, (String)"thenPlayAndHold(...)");
            return rawAnimation;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

