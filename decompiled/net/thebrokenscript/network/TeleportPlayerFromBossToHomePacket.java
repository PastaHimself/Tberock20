/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.core.BlockPos
 *  net.minecraft.resources.ResourceKey
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.level.Level
 *  net.thebrokenscript.brokencore.api.dsl.EntityUtil
 *  net.thebrokenscript.brokencore.api.dsl.PlayerUtil
 *  net.thebrokenscript.brokencore.api.network.ActionPacket
 *  net.thebrokenscript.brokencore.api.network.PacketHandlerContext
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.network;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.thebrokenscript.TheBrokenScript;
import net.thebrokenscript.api.TBSConstants;
import net.thebrokenscript.api.ext.PlayerExt;
import net.thebrokenscript.brokencore.api.dsl.EntityUtil;
import net.thebrokenscript.brokencore.api.dsl.PlayerUtil;
import net.thebrokenscript.brokencore.api.network.ActionPacket;
import net.thebrokenscript.brokencore.api.network.PacketHandlerContext;
import net.thebrokenscript.data.PlayerVariables;
import net.thebrokenscript.util.InteractionTracker;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016R\u0014\u0010\b\u001a\u00020\tX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2={"Lnet/thebrokenscript/network/TeleportPlayerFromBossToHomePacket;", "Lnet/thebrokenscript/brokencore/api/network/ActionPacket;", "<init>", "()V", "handle", "", "cx", "Lnet/thebrokenscript/brokencore/api/network/PacketHandlerContext;", "id", "Lnet/minecraft/resources/ResourceLocation;", "getId", "()Lnet/minecraft/resources/ResourceLocation;", "thebrokenscript-common"})
public final class TeleportPlayerFromBossToHomePacket
extends ActionPacket<TeleportPlayerFromBossToHomePacket> {
    @NotNull
    private final ResourceLocation id = TBSConstants.id("teleport_player_from_boss");

    public void handle(@NotNull PacketHandlerContext cx) {
        Intrinsics.checkNotNullParameter((Object)cx, (String)"cx");
        if (cx.isClientbound) {
            return;
        }
        cx.getEnqueueWork().invoke(() -> TeleportPlayerFromBossToHomePacket.handle$lambda$0(cx));
    }

    @NotNull
    public ResourceLocation getId() {
        return this.id;
    }

    private static final void handle$lambda$0(PacketHandlerContext $cx) {
        Object object = $cx.getPlayer();
        if (object == null || (object = PlayerExt.INSTANCE.getInteractionTracker((Player)object)) == null || (object = ((InteractionTracker)object).getLastBedInteraction()) == null) {
            return;
        }
        Object bedPos = object;
        Player player = $cx.getPlayer();
        Intrinsics.checkNotNull((Object)player, (String)"null cannot be cast to non-null type net.minecraft.world.entity.player.Player");
        PlayerExt.INSTANCE.updateVars(player, (Function1<? super PlayerVariables, Unit>)((Function1)TeleportPlayerFromBossToHomePacket::handle$lambda$0$0));
        TheBrokenScript.serverWorkQueue.add(5L, () -> TeleportPlayerFromBossToHomePacket.handle$lambda$0$1($cx, (BlockPos)bedPos));
    }

    private static final Unit handle$lambda$0$0(PlayerVariables $this$updateVars) {
        Intrinsics.checkNotNullParameter((Object)$this$updateVars, (String)"$this$updateVars");
        $this$updateVars.setFixPos(true);
        return Unit.INSTANCE;
    }

    private static final Unit handle$lambda$0$1(PacketHandlerContext $cx, BlockPos $bedPos) {
        Player player = $cx.getPlayer();
        Intrinsics.checkNotNull((Object)player, (String)"null cannot be cast to non-null type net.minecraft.world.entity.player.Player");
        ResourceKey resourceKey = Level.OVERWORLD;
        Intrinsics.checkNotNullExpressionValue((Object)resourceKey, (String)"OVERWORLD");
        PlayerUtil.sendTo((Player)player, (ResourceKey)resourceKey);
        Player player2 = $cx.getPlayer();
        Intrinsics.checkNotNull((Object)player2, (String)"null cannot be cast to non-null type net.minecraft.world.entity.player.Player");
        EntityUtil.teleport((Entity)((Entity)player2), (BlockPos)$bedPos);
        return Unit.INSTANCE;
    }
}

