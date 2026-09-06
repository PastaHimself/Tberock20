/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.world.entity.player.Player
 *  net.thebrokenscript.brokencore.api.network.ActionPacket
 *  net.thebrokenscript.brokencore.api.network.PacketHandlerContext
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.network;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.thebrokenscript.api.TBSConstants;
import net.thebrokenscript.api.ext.PlayerExt;
import net.thebrokenscript.brokencore.api.network.ActionPacket;
import net.thebrokenscript.brokencore.api.network.PacketHandlerContext;
import net.thebrokenscript.data.PlayerVariables;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\f"}, d2={"Lnet/thebrokenscript/network/SyncPlayerBlockPosToServerPacket;", "Lnet/thebrokenscript/brokencore/api/network/ActionPacket;", "<init>", "()V", "id", "Lnet/minecraft/resources/ResourceLocation;", "getId", "()Lnet/minecraft/resources/ResourceLocation;", "handle", "", "cx", "Lnet/thebrokenscript/brokencore/api/network/PacketHandlerContext;", "thebrokenscript-common"})
public final class SyncPlayerBlockPosToServerPacket
extends ActionPacket<SyncPlayerBlockPosToServerPacket> {
    @NotNull
    private final ResourceLocation id = TBSConstants.id("player_blockpos");

    @NotNull
    public ResourceLocation getId() {
        return this.id;
    }

    public void handle(@NotNull PacketHandlerContext cx) {
        Intrinsics.checkNotNullParameter((Object)cx, (String)"cx");
        if (cx.isClientbound) {
            return;
        }
        cx.getEnqueueWork().invoke(() -> SyncPlayerBlockPosToServerPacket.handle$lambda$0(cx));
    }

    private static final void handle$lambda$0(PacketHandlerContext $cx) {
        Player player = $cx.getPlayer();
        if (player == null) {
            return;
        }
        Player player2 = player;
        PlayerExt.INSTANCE.updateVars(player2, (Function1<? super PlayerVariables, Unit>)((Function1)arg_0 -> SyncPlayerBlockPosToServerPacket.handle$lambda$0$0(player2, arg_0)));
    }

    private static final Unit handle$lambda$0$0(Player $player, PlayerVariables $this$updateVars) {
        Intrinsics.checkNotNullParameter((Object)$this$updateVars, (String)"$this$updateVars");
        $this$updateVars.setLastX($this$updateVars.getCurrentX());
        $this$updateVars.setLastZ($this$updateVars.getCurrentZ());
        $this$updateVars.setCurrentX($player.getBlockX());
        $this$updateVars.setCurrentZ($player.getBlockZ());
        return Unit.INSTANCE;
    }
}

