/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.world.entity.player.Player
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.brokencore.api.network;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.world.entity.player.Player;
import net.thebrokenscript.brokencore.api.network.PacketDirection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B-\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007\u00a2\u0006\u0004\b\n\u0010\u000bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0010\u0010\u0012\u001a\u00020\u00138\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u00020\u00138\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2={"Lnet/thebrokenscript/brokencore/api/network/PacketHandlerContext;", "", "player", "Lnet/minecraft/world/entity/player/Player;", "direction", "Lnet/thebrokenscript/brokencore/api/network/PacketDirection;", "enqueueWork", "Lkotlin/Function1;", "Ljava/lang/Runnable;", "", "<init>", "(Lnet/minecraft/world/entity/player/Player;Lnet/thebrokenscript/brokencore/api/network/PacketDirection;Lkotlin/jvm/functions/Function1;)V", "getPlayer", "()Lnet/minecraft/world/entity/player/Player;", "getDirection", "()Lnet/thebrokenscript/brokencore/api/network/PacketDirection;", "getEnqueueWork", "()Lkotlin/jvm/functions/Function1;", "isClientbound", "", "isServerbound", "brokencore-common"})
public final class PacketHandlerContext {
    @Nullable
    private final Player player;
    @NotNull
    private final PacketDirection direction;
    @NotNull
    private final Function1<Runnable, Unit> enqueueWork;
    @JvmField
    public final boolean isClientbound;
    @JvmField
    public final boolean isServerbound;

    public PacketHandlerContext(@Nullable Player player, @NotNull PacketDirection direction, @NotNull Function1<? super Runnable, Unit> enqueueWork) {
        Intrinsics.checkNotNullParameter((Object)((Object)direction), (String)"direction");
        Intrinsics.checkNotNullParameter(enqueueWork, (String)"enqueueWork");
        this.player = player;
        this.direction = direction;
        this.enqueueWork = enqueueWork;
        this.isClientbound = this.direction == PacketDirection.CLIENTBOUND;
        this.isServerbound = this.direction == PacketDirection.SERVERBOUND;
    }

    @Nullable
    public final Player getPlayer() {
        return this.player;
    }

    @NotNull
    public final PacketDirection getDirection() {
        return this.direction;
    }

    @NotNull
    public final Function1<Runnable, Unit> getEnqueueWork() {
        return this.enqueueWork;
    }
}

