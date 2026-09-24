/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Triple
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.network.protocol.common.custom.CustomPacketPayload
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.server.level.ServerPlayer
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.phys.Vec3
 *  net.thebrokenscript.brokencore.api.dsl.EntityFinder
 *  net.thebrokenscript.brokencore.api.dsl.PositionUtil
 *  net.thebrokenscript.brokencore.api.global.GlobalMathKt
 *  net.thebrokenscript.brokencore.api.network.PacketSender
 *  org.jetbrains.annotations.NotNull
 *  org.joml.Matrix4f
 *  org.joml.Vector3f
 *  org.joml.Vector3fc
 *  software.bernie.geckolib.animation.AnimationState
 *  software.bernie.geckolib.animation.PlayState
 *  software.bernie.geckolib.animation.RawAnimation
 */
package net.thebrokenscript.entity.fractured.attacks;

import java.util.List;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.brokencore.api.dsl.EntityFinder;
import net.thebrokenscript.brokencore.api.dsl.PositionUtil;
import net.thebrokenscript.brokencore.api.global.GlobalMathKt;
import net.thebrokenscript.brokencore.api.network.PacketSender;
import net.thebrokenscript.entity.fractured.FracturedEntity;
import net.thebrokenscript.entity.fractured.attacks.JimAttack;
import net.thebrokenscript.entity.fractured.attacks.JimAttackType;
import net.thebrokenscript.entity.fractured.attacks.JimShockwaveType;
import net.thebrokenscript.registry.TBSDamageTypes;
import net.thebrokenscript.registry.TBSPackets;
import org.jetbrains.annotations.NotNull;
import org.joml.Matrix4f;
import org.joml.Vector3f;
import org.joml.Vector3fc;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.animation.PlayState;
import software.bernie.geckolib.animation.RawAnimation;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0016\u0010\u0011\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\r0\u0014H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\u00a8\u0006\u0016"}, d2={"Lnet/thebrokenscript/entity/fractured/attacks/StompAttack;", "Lnet/thebrokenscript/entity/fractured/attacks/JimAttack;", "<init>", "()V", "stompTimer", "", "type", "Lnet/thebrokenscript/entity/fractured/attacks/JimAttackType;", "getType", "()Lnet/thebrokenscript/entity/fractured/attacks/JimAttackType;", "length", "", "entity", "Lnet/thebrokenscript/entity/fractured/FracturedEntity;", "setup", "", "tick", "animate", "Lsoftware/bernie/geckolib/animation/PlayState;", "state", "Lsoftware/bernie/geckolib/animation/AnimationState;", "Companion", "thebrokenscript-common"})
@SourceDebugExtension(value={"SMAP\nStompAttack.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StompAttack.kt\nnet/thebrokenscript/entity/fractured/attacks/StompAttack\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,80:1\n1869#2,2:81\n*S KotlinDebug\n*F\n+ 1 StompAttack.kt\nnet/thebrokenscript/entity/fractured/attacks/StompAttack\n*L\n48#1:81,2\n*E\n"})
public final class StompAttack
extends JimAttack {
    @NotNull
    public static final Companion Companion = new Companion(null);
    private int stompTimer;
    @NotNull
    private final JimAttackType type = JimAttackType.STOMP;
    @NotNull
    private static final Vector3f STOMP_OFFSET = new Vector3f(210.0f, 0.0f, -1313.0f);
    private static final int STOMP_OFFSET_TICKS = 13;
    private static final float ATTACK_AOE_RADIUS = 5.0f;
    private static final float ATTACK_DAMAGE = 5.0f;

    @Override
    @NotNull
    public JimAttackType getType() {
        return this.type;
    }

    @Override
    public long length(@NotNull FracturedEntity entity) {
        Intrinsics.checkNotNullParameter((Object)((Object)entity), (String)"entity");
        return 78L;
    }

    @Override
    public void setup(@NotNull FracturedEntity entity) {
        Intrinsics.checkNotNullParameter((Object)((Object)entity), (String)"entity");
        super.setup(entity);
        this.stompTimer = 0;
    }

    @Override
    public void tick(@NotNull FracturedEntity entity) {
        Intrinsics.checkNotNullParameter((Object)((Object)entity), (String)"entity");
        int n = this.stompTimer;
        this.stompTimer = n + 1;
        if (this.stompTimer == 13) {
            Vector3f add = STOMP_OFFSET.mul(0.125f);
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
            PacketSender.INSTANCE.sendToPlayersInLevel(level2, (CustomPacketPayload)TBSPackets.SHOCKWAVE_UPDATE.of(new Triple((Object)realPos, (Object)Float.valueOf(5.0f), (Object)JimShockwaveType.STOMP)), new CustomPacketPayload[0]);
            Intrinsics.checkNotNull((Object)realPos);
            List players = EntityFinder.findPlayersInRange((ServerLevel)level2, (Vec3)realPos, (Number)Float.valueOf(5.0f));
            Iterable $this$forEach$iv = players;
            boolean $i$f$forEach = false;
            for (Object element$iv : $this$forEach$iv) {
                ServerPlayer it = (ServerPlayer)element$iv;
                boolean bl = false;
                Vec3 position = it.position();
                Intrinsics.checkNotNull((Object)position);
                Vec3 diff = PositionUtil.minus((Vec3)position, (Vec3)realPos);
                it.hurt(it.damageSources().source(TBSDamageTypes.JIMMY_STOMP.getKey()), 5.0f);
                it.knockback(2.0, diff.x, diff.z);
            }
        }
    }

    @Override
    @NotNull
    public PlayState animate(@NotNull AnimationState<FracturedEntity> state) {
        PlayState playState;
        Intrinsics.checkNotNullParameter(state, (String)"state");
        int timer = this.stompTimer;
        if (timer > 0) {
            PlayState playState2 = state.setAndContinue(StompAttack.Companion.getATTACK_START());
            playState = playState2;
            Intrinsics.checkNotNullExpressionValue((Object)playState2, (String)"setAndContinue(...)");
        } else {
            PlayState playState3 = state.setAndContinue(StompAttack.Companion.getIDLE());
            playState = playState3;
            Intrinsics.checkNotNullExpressionValue((Object)playState3, (String)"setAndContinue(...)");
        }
        return playState;
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082T\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00020\f8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\f8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u000e\u00a8\u0006\u0011"}, d2={"Lnet/thebrokenscript/entity/fractured/attacks/StompAttack$Companion;", "", "<init>", "()V", "STOMP_OFFSET", "Lorg/joml/Vector3f;", "STOMP_OFFSET_TICKS", "", "ATTACK_AOE_RADIUS", "", "ATTACK_DAMAGE", "IDLE", "Lsoftware/bernie/geckolib/animation/RawAnimation;", "getIDLE", "()Lsoftware/bernie/geckolib/animation/RawAnimation;", "ATTACK_START", "getATTACK_START", "thebrokenscript-common"})
    public static final class Companion {
        private Companion() {
        }

        private final RawAnimation getIDLE() {
            RawAnimation rawAnimation = RawAnimation.begin().thenLoop("Idle");
            Intrinsics.checkNotNullExpressionValue((Object)rawAnimation, (String)"thenLoop(...)");
            return rawAnimation;
        }

        private final RawAnimation getATTACK_START() {
            RawAnimation rawAnimation = RawAnimation.begin().thenPlayAndHold("OffenseStompShockwave");
            Intrinsics.checkNotNullExpressionValue((Object)rawAnimation, (String)"thenPlayAndHold(...)");
            return rawAnimation;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

