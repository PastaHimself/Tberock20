/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.world.entity.player.Player
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.handlers.player;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.world.entity.player.Player;
import net.thebrokenscript.api.ext.PlayerExt;
import net.thebrokenscript.data.PlayerVariables;
import net.thebrokenscript.handlers.subs.PlayerRespawnSubscriber;
import net.thebrokenscript.misc.ForceRuntimeInit;
import net.thebrokenscript.registry.TBSDimensions;
import org.jetbrains.annotations.NotNull;

@ForceRuntimeInit
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2={"Lnet/thebrokenscript/handlers/player/OnRespawnHandler;", "", "<init>", "()V", "thebrokenscript-common"})
public final class OnRespawnHandler {
    @NotNull
    public static final OnRespawnHandler INSTANCE = new OnRespawnHandler();

    private OnRespawnHandler() {
    }

    private static final Unit _init_$lambda$0(Player player) {
        Intrinsics.checkNotNullParameter((Object)player, (String)"player");
        if (PlayerExt.INSTANCE.getVars(player).getPixelateEnabled() && !Intrinsics.areEqual((Object)player.level().dimension(), TBSDimensions.LUCID)) {
            PlayerExt.INSTANCE.updateVars(player, (Function1<? super PlayerVariables, Unit>)((Function1)OnRespawnHandler::lambda$0$0));
        }
        return Unit.INSTANCE;
    }

    private static final Unit lambda$0$0(PlayerVariables $this$updateVars) {
        Intrinsics.checkNotNullParameter((Object)$this$updateVars, (String)"$this$updateVars");
        $this$updateVars.setPixelateEnabled(false);
        return Unit.INSTANCE;
    }

    static {
        PlayerRespawnSubscriber.INSTANCE.add((Function1<? super Player, Unit>)((Function1)OnRespawnHandler::_init_$lambda$0));
    }
}

