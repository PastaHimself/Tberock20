/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function3
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.world.Container
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.item.ItemStack
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
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003JS\u0010\u0010\u001a\u00020\u00112K\u0010\u0012\u001aG\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\r\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f0\u0006J\u001e\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rRY\u0010\u0004\u001aM\u0012I\u0012G\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\r\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f0\u00060\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2={"Lnet/thebrokenscript/handlers/subs/ItemCraftedSubscriber;", "", "<init>", "()V", "listeners", "", "Lkotlin/Function3;", "Lnet/minecraft/world/item/ItemStack;", "Lkotlin/ParameterName;", "name", "crafting", "Lnet/minecraft/world/entity/player/Player;", "player", "Lnet/minecraft/world/Container;", "craftMatrix", "", "add", "", "listener", "call", "thebrokenscript-common"})
@SourceDebugExtension(value={"SMAP\nItemCraftedSubscriber.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ItemCraftedSubscriber.kt\nnet/thebrokenscript/handlers/subs/ItemCraftedSubscriber\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,12:1\n1869#2,2:13\n*S KotlinDebug\n*F\n+ 1 ItemCraftedSubscriber.kt\nnet/thebrokenscript/handlers/subs/ItemCraftedSubscriber\n*L\n11#1:13,2\n*E\n"})
public final class ItemCraftedSubscriber {
    @NotNull
    public static final ItemCraftedSubscriber INSTANCE = new ItemCraftedSubscriber();
    @NotNull
    private static final Set<Function3<ItemStack, Player, Container, Unit>> listeners = new LinkedHashSet();

    private ItemCraftedSubscriber() {
    }

    public final boolean add(@NotNull Function3<? super ItemStack, ? super Player, ? super Container, Unit> listener) {
        Intrinsics.checkNotNullParameter(listener, (String)"listener");
        return listeners.add(listener);
    }

    public final void call(@NotNull ItemStack crafting, @NotNull Player player, @NotNull Container craftMatrix) {
        Intrinsics.checkNotNullParameter((Object)crafting, (String)"crafting");
        Intrinsics.checkNotNullParameter((Object)player, (String)"player");
        Intrinsics.checkNotNullParameter((Object)craftMatrix, (String)"craftMatrix");
        Iterable $this$forEach$iv = listeners;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            Function3 it = (Function3)element$iv;
            boolean bl = false;
            it.invoke((Object)crafting, (Object)player, (Object)craftMatrix);
        }
    }
}

