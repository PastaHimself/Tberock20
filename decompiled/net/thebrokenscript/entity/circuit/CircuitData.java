/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.wispforest.endec.Endec
 *  io.wispforest.endec.StructEndec
 *  io.wispforest.endec.impl.StructEndecBuilder
 *  io.wispforest.endec.impl.StructField
 *  io.wispforest.owo.serialization.endec.MinecraftEndecs
 *  kotlin.Metadata
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.reflect.KProperty1
 *  net.minecraft.world.phys.Vec3
 *  net.thebrokenscript.brokencore.api.dsl.EndecUtil
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.entity.circuit;

import io.wispforest.endec.Endec;
import io.wispforest.endec.StructEndec;
import io.wispforest.endec.impl.StructEndecBuilder;
import io.wispforest.endec.impl.StructField;
import io.wispforest.owo.serialization.endec.MinecraftEndecs;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty1;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.brokencore.api.dsl.EndecUtil;
import net.thebrokenscript.entity.circuit.CircuitData;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018BC\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\u000b\u001a\u00020\t\u00a2\u0006\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0013\u0010\b\u001a\u0004\u0018\u00010\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\n\u001a\u0004\u0018\u00010\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0011\u0010\u000b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015\u00a8\u0006\u0019"}, d2={"Lnet/thebrokenscript/entity/circuit/CircuitData;", "", "timer", "", "discardTimer", "hasSeenPlayer", "", "lastSeenTick", "lastKnownTargetPos", "Lnet/minecraft/world/phys/Vec3;", "lastPlayerPos", "playerVelocity", "<init>", "(IIZILnet/minecraft/world/phys/Vec3;Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/world/phys/Vec3;)V", "getTimer", "()I", "getDiscardTimer", "getHasSeenPlayer", "()Z", "getLastSeenTick", "getLastKnownTargetPos", "()Lnet/minecraft/world/phys/Vec3;", "getLastPlayerPos", "getPlayerVelocity", "Companion", "thebrokenscript-common"})
public final class CircuitData {
    @NotNull
    public static final Companion Companion = new Companion(null);
    private final int timer;
    private final int discardTimer;
    private final boolean hasSeenPlayer;
    private final int lastSeenTick;
    @Nullable
    private final Vec3 lastKnownTargetPos;
    @Nullable
    private final Vec3 lastPlayerPos;
    @NotNull
    private final Vec3 playerVelocity;
    @NotNull
    private static final StructEndec<CircuitData> ENDEC;

    public CircuitData(int timer, int discardTimer, boolean hasSeenPlayer, int lastSeenTick, @Nullable Vec3 lastKnownTargetPos, @Nullable Vec3 lastPlayerPos, @NotNull Vec3 playerVelocity) {
        Intrinsics.checkNotNullParameter((Object)playerVelocity, (String)"playerVelocity");
        this.timer = timer;
        this.discardTimer = discardTimer;
        this.hasSeenPlayer = hasSeenPlayer;
        this.lastSeenTick = lastSeenTick;
        this.lastKnownTargetPos = lastKnownTargetPos;
        this.lastPlayerPos = lastPlayerPos;
        this.playerVelocity = playerVelocity;
    }

    public final int getTimer() {
        return this.timer;
    }

    public final int getDiscardTimer() {
        return this.discardTimer;
    }

    public final boolean getHasSeenPlayer() {
        return this.hasSeenPlayer;
    }

    public final int getLastSeenTick() {
        return this.lastSeenTick;
    }

    @Nullable
    public final Vec3 getLastKnownTargetPos() {
        return this.lastKnownTargetPos;
    }

    @Nullable
    public final Vec3 getLastPlayerPos() {
        return this.lastPlayerPos;
    }

    @NotNull
    public final Vec3 getPlayerVelocity() {
        return this.playerVelocity;
    }

    private static final Integer ENDEC$lambda$0(KProperty1 $tmp0, CircuitData p0) {
        return (Integer)((Function1)$tmp0).invoke((Object)p0);
    }

    private static final Integer ENDEC$lambda$1(KProperty1 $tmp0, CircuitData p0) {
        return (Integer)((Function1)$tmp0).invoke((Object)p0);
    }

    private static final Boolean ENDEC$lambda$2(KProperty1 $tmp0, CircuitData p0) {
        return (Boolean)((Function1)$tmp0).invoke((Object)p0);
    }

    private static final Integer ENDEC$lambda$3(KProperty1 $tmp0, CircuitData p0) {
        return (Integer)((Function1)$tmp0).invoke((Object)p0);
    }

    private static final Vec3 ENDEC$lambda$4(KProperty1 $tmp0, CircuitData p0) {
        return (Vec3)((Function1)$tmp0).invoke((Object)p0);
    }

    static {
        StructField structField = Endec.INT.fieldOf("despawn_timer", arg_0 -> CircuitData.ENDEC$lambda$0((KProperty1)Companion.ENDEC.1.INSTANCE, arg_0));
        StructField structField2 = Endec.INT.fieldOf("discard_timer", arg_0 -> CircuitData.ENDEC$lambda$1((KProperty1)Companion.ENDEC.2.INSTANCE, arg_0));
        StructField structField3 = Endec.BOOLEAN.fieldOf("has_seen_player", arg_0 -> CircuitData.ENDEC$lambda$2((KProperty1)Companion.ENDEC.3.INSTANCE, arg_0));
        StructField structField4 = Endec.INT.fieldOf("last_seen_tick", arg_0 -> CircuitData.ENDEC$lambda$3((KProperty1)Companion.ENDEC.4.INSTANCE, arg_0));
        Endec endec2 = MinecraftEndecs.VEC3D;
        Intrinsics.checkNotNullExpressionValue((Object)endec2, (String)"VEC3D");
        StructField structField5 = EndecUtil.nullableFieldOf((Endec)endec2, (String)"last_known_target_pos", (Function1)((Function1)Companion.ENDEC.5.INSTANCE));
        Endec endec3 = MinecraftEndecs.VEC3D;
        Intrinsics.checkNotNullExpressionValue((Object)endec3, (String)"VEC3D");
        StructEndec structEndec = StructEndecBuilder.of((StructField)structField, (StructField)structField2, (StructField)structField3, (StructField)structField4, (StructField)structField5, (StructField)EndecUtil.nullableFieldOf((Endec)endec3, (String)"last_player_pos", (Function1)((Function1)Companion.ENDEC.6.INSTANCE)), (StructField)MinecraftEndecs.VEC3D.fieldOf("player_velocity", arg_0 -> CircuitData.ENDEC$lambda$4((KProperty1)Companion.ENDEC.7.INSTANCE, arg_0)), CircuitData::new);
        Intrinsics.checkNotNullExpressionValue((Object)structEndec, (String)"of(...)");
        ENDEC = structEndec;
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\t"}, d2={"Lnet/thebrokenscript/entity/circuit/CircuitData$Companion;", "", "<init>", "()V", "ENDEC", "Lio/wispforest/endec/StructEndec;", "Lnet/thebrokenscript/entity/circuit/CircuitData;", "getENDEC", "()Lio/wispforest/endec/StructEndec;", "thebrokenscript-common"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final StructEndec<CircuitData> getENDEC() {
            return ENDEC;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

