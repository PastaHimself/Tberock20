/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.commands.arguments.EntityAnchorArgument$Anchor
 *  net.minecraft.server.level.ServerPlayer
 *  net.minecraft.server.network.ServerGamePacketListenerImpl
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.phys.Vec3
 *  net.thebrokenscript.brokencore.api.dsl.EntityUtil
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.util;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.commands.arguments.EntityAnchorArgument;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.network.ServerGamePacketListenerImpl;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.api.ext.PlayerExt;
import net.thebrokenscript.brokencore.api.dsl.EntityUtil;
import net.thebrokenscript.data.PlayerVariables;
import net.thebrokenscript.mixinterfaces.ServerConnectionExt;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007\u00a8\u0006\t"}, d2={"Lnet/thebrokenscript/util/PlayerDesyncManager;", "", "<init>", "()V", "desync", "", "player", "Lnet/minecraft/server/level/ServerPlayer;", "resync", "thebrokenscript-common"})
public final class PlayerDesyncManager {
    @NotNull
    public static final PlayerDesyncManager INSTANCE = new PlayerDesyncManager();

    private PlayerDesyncManager() {
    }

    @JvmStatic
    public static final void desync(@NotNull ServerPlayer player) {
        Intrinsics.checkNotNullParameter((Object)player, (String)"player");
        PlayerVariables vars = PlayerExt.INSTANCE.getVars((Player)player);
        if (vars.isDesync()) {
            return;
        }
        vars.setDesync(true);
        vars.syncTo((Player)player);
    }

    @JvmStatic
    public static final void resync(@NotNull ServerPlayer player) {
        Intrinsics.checkNotNullParameter((Object)player, (String)"player");
        Vec3 look = player.position().add(player.getForward());
        PlayerVariables vars = PlayerExt.INSTANCE.getVars((Player)player);
        if (!vars.isDesync()) {
            return;
        }
        vars.setDesync(false);
        vars.syncTo((Player)player);
        Entity entity = (Entity)player;
        Vec3 vec3 = player.position();
        Intrinsics.checkNotNullExpressionValue((Object)vec3, (String)"position(...)");
        EntityUtil.teleport((Entity)entity, (Vec3)vec3);
        player.lookAt(EntityAnchorArgument.Anchor.FEET, look);
        ServerGamePacketListenerImpl serverGamePacketListenerImpl = player.connection;
        Intrinsics.checkNotNull((Object)serverGamePacketListenerImpl, (String)"null cannot be cast to non-null type net.thebrokenscript.mixinterfaces.ServerConnectionExt");
        ((ServerConnectionExt)serverGamePacketListenerImpl).tbs$sendDeferredPackets();
    }
}

