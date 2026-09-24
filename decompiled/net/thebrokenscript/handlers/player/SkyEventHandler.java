/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.network.protocol.common.custom.CustomPacketPayload
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.phys.Vec3
 *  net.thebrokenscript.brokencore.api.network.PacketSender
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.handlers.player;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.api.ext.PlayerExt;
import net.thebrokenscript.api.util.CameraUtilKt;
import net.thebrokenscript.api.util.Colors;
import net.thebrokenscript.brokencore.api.network.PacketSender;
import net.thebrokenscript.data.PlayerVariables;
import net.thebrokenscript.handlers.subs.PlayerTickSubscriber;
import net.thebrokenscript.misc.ForceRuntimeInit;
import net.thebrokenscript.registry.TBSPackets;
import org.jetbrains.annotations.NotNull;

@ForceRuntimeInit
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0011"}, d2={"Lnet/thebrokenscript/handlers/player/SkyEventHandler;", "", "<init>", "()V", "skyColor", "Lnet/minecraft/world/phys/Vec3;", "getSkyColor", "()Lnet/minecraft/world/phys/Vec3;", "lookingAtSky", "", "Ljava/util/UUID;", "getLookingAtSky", "()Ljava/util/Set;", "tick", "", "player", "Lnet/minecraft/world/entity/player/Player;", "thebrokenscript-common"})
public final class SkyEventHandler {
    @NotNull
    public static final SkyEventHandler INSTANCE = new SkyEventHandler();
    @NotNull
    private static final Vec3 skyColor = Colors.INSTANCE.rgb(8037631);
    @NotNull
    private static final Set<UUID> lookingAtSky = new LinkedHashSet();

    private SkyEventHandler() {
    }

    @NotNull
    public final Vec3 getSkyColor() {
        return skyColor;
    }

    @NotNull
    public final Set<UUID> getLookingAtSky() {
        return lookingAtSky;
    }

    public final void tick(@NotNull Player player) {
        Intrinsics.checkNotNullParameter((Object)player, (String)"player");
        boolean wasLooking = lookingAtSky.contains(player.getUUID());
        boolean nowLooking = CameraUtilKt.isLookingAtSky(player);
        if (nowLooking) {
            UUID uUID = player.getUUID();
            Intrinsics.checkNotNullExpressionValue((Object)uUID, (String)"getUUID(...)");
            v1 = lookingAtSky.add(uUID);
        } else {
            v1 = lookingAtSky.remove(player.getUUID());
        }
        if (!(!PlayerExt.INSTANCE.getVars(player).getShowSkyBlue() || PlayerExt.INSTANCE.getVars(player).getEnableCustomSky() && Intrinsics.areEqual((Object)PlayerExt.INSTANCE.getVars(player).getCustomSkyColor(), (Object)skyColor))) {
            if (!player.level().isClientSide) {
                return;
            }
            PlayerExt.INSTANCE.updateVars(player, (Function1<? super PlayerVariables, Unit>)((Function1)SkyEventHandler::tick$lambda$0));
        }
        if (wasLooking && !nowLooking && player.level().isClientSide && (Intrinsics.areEqual((Object)PlayerExt.INSTANCE.getVars(player).getCustomSkyColor(), (Object)skyColor) || PlayerExt.INSTANCE.getVars(player).getShowSkyBlue())) {
            PlayerExt.INSTANCE.updateVars(player, (Function1<? super PlayerVariables, Unit>)((Function1)SkyEventHandler::tick$lambda$1));
            PacketSender.INSTANCE.sendToServer((CustomPacketPayload)TBSPackets.CLEAR_SKY_BLUE.of(0), new CustomPacketPayload[0]);
        }
    }

    private static final Unit tick$lambda$0(PlayerVariables $this$updateVars) {
        Intrinsics.checkNotNullParameter((Object)$this$updateVars, (String)"$this$updateVars");
        $this$updateVars.setEnableCustomSky(true);
        $this$updateVars.setCustomSkyColor(skyColor);
        return Unit.INSTANCE;
    }

    private static final Unit tick$lambda$1(PlayerVariables $this$updateVars) {
        Intrinsics.checkNotNullParameter((Object)$this$updateVars, (String)"$this$updateVars");
        $this$updateVars.setShowSkyBlue(false);
        $this$updateVars.setEnableCustomSky(false);
        $this$updateVars.setCustomSkyColor(Colors.INSTANCE.rgb(0));
        return Unit.INSTANCE;
    }

    static {
        PlayerTickSubscriber.INSTANCE.add((Function1<? super Player, Unit>)((Function1)new Function1<Player, Unit>((Object)INSTANCE){

            public final void invoke(Player p0) {
                Intrinsics.checkNotNullParameter((Object)p0, (String)"p0");
                ((SkyEventHandler)this.receiver).tick(p0);
            }
        }));
    }
}

