/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.world.entity.player.Player
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.handlers.subs;

import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.world.entity.player.Player;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J>\u0010\r\u001a\u00020\u000e26\u0010\u000f\u001a2\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0006J\u0016\u0010\u0010\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0007RD\u0010\u0004\u001a8\u00124\u00122\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u00060\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2={"Lnet/thebrokenscript/handlers/subs/PlayerCloneSubscriber;", "", "<init>", "()V", "listeners", "", "Lkotlin/Function2;", "Lnet/minecraft/world/entity/player/Player;", "Lkotlin/ParameterName;", "name", "orig", "new", "", "add", "", "listener", "call", "thebrokenscript-common"})
@SourceDebugExtension(value={"SMAP\nPlayerCloneSubscriber.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PlayerCloneSubscriber.kt\nnet/thebrokenscript/handlers/subs/PlayerCloneSubscriber\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,11:1\n1869#2,2:12\n*S KotlinDebug\n*F\n+ 1 PlayerCloneSubscriber.kt\nnet/thebrokenscript/handlers/subs/PlayerCloneSubscriber\n*L\n9#1:12,2\n*E\n"})
public final class PlayerCloneSubscriber {
    @NotNull
    public static final PlayerCloneSubscriber INSTANCE = new PlayerCloneSubscriber();
    @NotNull
    private static final Set<Function2<Player, Player, Unit>> listeners = new LinkedHashSet();

    private PlayerCloneSubscriber() {
    }

    public final boolean add(@NotNull Function2<? super Player, ? super Player, Unit> listener) {
        Intrinsics.checkNotNullParameter(listener, (String)"listener");
        return listeners.add(listener);
    }

    public final void call(@NotNull Player orig, @NotNull Player player) {
        Intrinsics.checkNotNullParameter((Object)orig, (String)"orig");
        Intrinsics.checkNotNullParameter((Object)player, (String)"new");
        Iterable $this$forEach$iv = listeners;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            Function2 it = (Function2)element$iv;
            boolean bl = false;
            it.invoke((Object)orig, (Object)player);
        }
    }
}

