/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.server.level.ServerPlayer
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.level.LevelAccessor
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
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.thebrokenscript.api.TBSConstants;
import net.thebrokenscript.api.ext.LevelExt;
import net.thebrokenscript.brokencore.api.network.ActionPacket;
import net.thebrokenscript.brokencore.api.network.PacketHandlerContext;
import net.thebrokenscript.data.MapVariables;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\f"}, d2={"Lnet/thebrokenscript/network/InventoryCorruptionProgressPacket;", "Lnet/thebrokenscript/brokencore/api/network/ActionPacket;", "<init>", "()V", "id", "Lnet/minecraft/resources/ResourceLocation;", "getId", "()Lnet/minecraft/resources/ResourceLocation;", "handle", "", "cx", "Lnet/thebrokenscript/brokencore/api/network/PacketHandlerContext;", "thebrokenscript-common"})
public final class InventoryCorruptionProgressPacket
extends ActionPacket<InventoryCorruptionProgressPacket> {
    @NotNull
    private final ResourceLocation id = TBSConstants.id("inventory_corruption");

    @NotNull
    public ResourceLocation getId() {
        return this.id;
    }

    public void handle(@NotNull PacketHandlerContext cx) {
        Intrinsics.checkNotNullParameter((Object)cx, (String)"cx");
        cx.getEnqueueWork().invoke(() -> InventoryCorruptionProgressPacket.handle$lambda$0(cx));
    }

    private static final void handle$lambda$0(PacketHandlerContext $cx) {
        Player player = $cx.getPlayer();
        if (!(player instanceof ServerPlayer)) {
            return;
        }
        ServerLevel serverLevel = ((ServerPlayer)player).serverLevel();
        Intrinsics.checkNotNullExpressionValue((Object)serverLevel, (String)"serverLevel(...)");
        LevelExt.INSTANCE.updateVars((LevelAccessor)serverLevel, (Function1<? super MapVariables, Unit>)((Function1)InventoryCorruptionProgressPacket::handle$lambda$0$0));
    }

    private static final Unit handle$lambda$0$0(MapVariables $this$updateVars) {
        Intrinsics.checkNotNullParameter((Object)((Object)$this$updateVars), (String)"$this$updateVars");
        int n = $this$updateVars.getInventoryCorruption();
        $this$updateVars.setInventoryCorruption(n + 1);
        return Unit.INSTANCE;
    }
}

