/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.wispforest.endec.Endec
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.server.level.ServerPlayer
 *  net.minecraft.world.entity.player.Player
 *  net.thebrokenscript.brokencore.api.network.EndecPacket
 *  net.thebrokenscript.brokencore.api.network.PacketHandlerContext
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.network;

import io.wispforest.endec.Endec;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.thebrokenscript.api.TBSConstants;
import net.thebrokenscript.api.ext.PlayerExt;
import net.thebrokenscript.brokencore.api.network.EndecPacket;
import net.thebrokenscript.brokencore.api.network.PacketHandlerContext;
import net.thebrokenscript.data.CameraMode;
import net.thebrokenscript.data.PlayerVariables;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\rH\u0016R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\u000e"}, d2={"Lnet/thebrokenscript/network/SetCameraModePacket;", "Lnet/thebrokenscript/brokencore/api/network/EndecPacket;", "Lnet/thebrokenscript/data/CameraMode;", "<init>", "()V", "id", "Lnet/minecraft/resources/ResourceLocation;", "getId", "()Lnet/minecraft/resources/ResourceLocation;", "handle", "", "data", "cx", "Lnet/thebrokenscript/brokencore/api/network/PacketHandlerContext;", "thebrokenscript-common"})
public final class SetCameraModePacket
extends EndecPacket<SetCameraModePacket, CameraMode> {
    @NotNull
    private final ResourceLocation id;

    public SetCameraModePacket() {
        Endec endec2 = Endec.forEnum(CameraMode.class);
        Intrinsics.checkNotNullExpressionValue((Object)endec2, (String)"forEnum(...)");
        super(endec2);
        this.id = TBSConstants.id("set_camera_mode");
    }

    @NotNull
    public ResourceLocation getId() {
        return this.id;
    }

    public void handle(@NotNull CameraMode data, @NotNull PacketHandlerContext cx) {
        Intrinsics.checkNotNullParameter((Object)((Object)data), (String)"data");
        Intrinsics.checkNotNullParameter((Object)cx, (String)"cx");
        cx.getEnqueueWork().invoke(() -> SetCameraModePacket.handle$lambda$0(cx, data));
    }

    private static final void handle$lambda$0(PacketHandlerContext $cx, CameraMode $data) {
        if ($cx.isServerbound) {
            Player player = $cx.getPlayer();
            Intrinsics.checkNotNull((Object)player, (String)"null cannot be cast to non-null type net.minecraft.server.level.ServerPlayer");
            ServerPlayer player2 = (ServerPlayer)player;
            PlayerExt.INSTANCE.updateVars((Player)player2, (Function1<? super PlayerVariables, Unit>)((Function1)arg_0 -> SetCameraModePacket.handle$lambda$0$0($data, arg_0)));
        }
    }

    private static final Unit handle$lambda$0$0(CameraMode $data, PlayerVariables $this$updateVars) {
        Intrinsics.checkNotNullParameter((Object)$this$updateVars, (String)"$this$updateVars");
        $this$updateVars.setCameraMode($data);
        return Unit.INSTANCE;
    }
}

