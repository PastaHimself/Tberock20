/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.server.level.ServerPlayer
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.phys.Vec3
 *  net.thebrokenscript.brokencore.api.dsl.PlayerUtil
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.handlers.dimensions;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.api.ext.PlayerExt;
import net.thebrokenscript.brokencore.api.dsl.PlayerUtil;
import net.thebrokenscript.handlers.subs.PlayerTickSubscriber;
import net.thebrokenscript.misc.ForceRuntimeInit;
import net.thebrokenscript.registry.TBSDimensions;
import org.jetbrains.annotations.NotNull;

@ForceRuntimeInit
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2={"Lnet/thebrokenscript/handlers/dimensions/LucidLoopHandler;", "", "<init>", "()V", "thebrokenscript-common"})
public final class LucidLoopHandler {
    @NotNull
    public static final LucidLoopHandler INSTANCE = new LucidLoopHandler();

    private LucidLoopHandler() {
    }

    private static final Unit _init_$lambda$0(Player player) {
        Double shouldTeleport;
        Intrinsics.checkNotNullParameter((Object)player, (String)"player");
        if (!(player instanceof ServerPlayer)) {
            return Unit.INSTANCE;
        }
        if (PlayerExt.INSTANCE.getVars(player).getFixPos()) {
            return Unit.INSTANCE;
        }
        if (!Intrinsics.areEqual((Object)((ServerPlayer)player).serverLevel().dimension(), TBSDimensions.LUCID)) {
            return Unit.INSTANCE;
        }
        long lastTeleport = PlayerExt.INSTANCE.getVars(player).getLastTeleport();
        long currentTime = ((ServerPlayer)player).serverLevel().getGameTime();
        if (currentTime - lastTeleport < 5L) {
            return Unit.INSTANCE;
        }
        Double d = shouldTeleport = ((ServerPlayer)player).getY() < -100.0 ? Double.valueOf(350.0) : null;
        if (shouldTeleport != null) {
            if (((ServerPlayer)player).isPassenger()) {
                Entity entity = ((ServerPlayer)player).getVehicle();
                if (entity != null) {
                    entity.discard();
                }
                ((ServerPlayer)player).stopRiding();
            }
            ServerPlayer serverPlayer = (ServerPlayer)player;
            Vec3 vec3 = player.position().add(0.0, shouldTeleport.doubleValue(), 0.0);
            Intrinsics.checkNotNullExpressionValue((Object)vec3, (String)"add(...)");
            if (PlayerUtil.smoothTeleport((ServerPlayer)serverPlayer, (Vec3)vec3)) {
                ((ServerPlayer)player).setDeltaMovement(((ServerPlayer)player).getDeltaMovement().multiply(1.0, 1.0, 1.0));
                PlayerExt.INSTANCE.getVars(player).setLastTeleport(currentTime);
            }
        }
        return Unit.INSTANCE;
    }

    static {
        PlayerTickSubscriber.INSTANCE.add((Function1<? super Player, Unit>)((Function1)LucidLoopHandler::_init_$lambda$0));
    }
}

