/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function3
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.core.Direction
 *  net.minecraft.world.entity.player.Player
 *  net.thebrokenscript.brokencore.api.platform.CancelProxy
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.handlers.subs;

import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.player.Player;
import net.thebrokenscript.brokencore.api.platform.CancelProxy;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u000b\u001a\u00020\f2\u001e\u0010\r\u001a\u001a\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u0006J\u001e\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\tR,\u0010\u0004\u001a \u0012\u001c\u0012\u001a\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u00060\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2={"Lnet/thebrokenscript/handlers/subs/PlayerTeleportationSubscriber;", "", "<init>", "()V", "listeners", "", "Lkotlin/Function3;", "Lnet/minecraft/world/entity/player/Player;", "Lnet/minecraft/core/Direction;", "Lnet/thebrokenscript/brokencore/api/platform/CancelProxy;", "", "add", "", "listener", "call", "player", "face", "cancelProxy", "thebrokenscript-common"})
@SourceDebugExtension(value={"SMAP\nPlayerTeleportationSubscriber.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PlayerTeleportationSubscriber.kt\nnet/thebrokenscript/handlers/subs/PlayerTeleportationSubscriber\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,14:1\n1869#2,2:15\n*S KotlinDebug\n*F\n+ 1 PlayerTeleportationSubscriber.kt\nnet/thebrokenscript/handlers/subs/PlayerTeleportationSubscriber\n*L\n13#1:15,2\n*E\n"})
public final class PlayerTeleportationSubscriber {
    @NotNull
    public static final PlayerTeleportationSubscriber INSTANCE = new PlayerTeleportationSubscriber();
    @NotNull
    private static final Set<Function3<Player, Direction, CancelProxy, Unit>> listeners = new LinkedHashSet();

    private PlayerTeleportationSubscriber() {
    }

    public final boolean add(@NotNull Function3<? super Player, ? super Direction, ? super CancelProxy, Unit> listener) {
        Intrinsics.checkNotNullParameter(listener, (String)"listener");
        return listeners.add(listener);
    }

    public final void call(@NotNull Player player, @NotNull Direction face, @NotNull CancelProxy cancelProxy) {
        Intrinsics.checkNotNullParameter((Object)player, (String)"player");
        Intrinsics.checkNotNullParameter((Object)face, (String)"face");
        Intrinsics.checkNotNullParameter((Object)cancelProxy, (String)"cancelProxy");
        Iterable $this$forEach$iv = listeners;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            Function3 it = (Function3)element$iv;
            boolean bl = false;
            if (cancelProxy.isCanceled()) continue;
            it.invoke((Object)player, (Object)face, (Object)cancelProxy);
        }
    }
}

