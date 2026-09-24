/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.buffer.Unpooled
 *  kotlin.Metadata
 *  kotlin.jvm.functions.Function3
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.core.BlockPos
 *  net.minecraft.network.FriendlyByteBuf
 *  net.minecraft.network.chat.Component
 *  net.minecraft.network.chat.MutableComponent
 *  net.minecraft.world.MenuProvider
 *  net.minecraft.world.entity.player.Inventory
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.inventory.AbstractContainerMenu
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.events.nullent.interfaces;

import io.netty.buffer.Unpooled;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B7\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u001e\u0010\b\u001a\u001a\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00028\u00000\t\u00a2\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u000f\u001a\u00020\u0010H\u0016J \u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R&\u0010\b\u001a\u001a\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00028\u00000\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2={"Lnet/thebrokenscript/events/nullent/interfaces/NullMenuProvider;", "T", "Lnet/minecraft/world/inventory/AbstractContainerMenu;", "Lnet/minecraft/world/MenuProvider;", "displayName", "", "blockPos", "Lnet/minecraft/core/BlockPos;", "ctor", "Lkotlin/Function3;", "", "Lnet/minecraft/world/entity/player/Inventory;", "Lnet/minecraft/network/FriendlyByteBuf;", "<init>", "(Ljava/lang/String;Lnet/minecraft/core/BlockPos;Lkotlin/jvm/functions/Function3;)V", "getDisplayName", "Lnet/minecraft/network/chat/Component;", "createMenu", "id", "inventory", "player", "Lnet/minecraft/world/entity/player/Player;", "thebrokenscript-common"})
public final class NullMenuProvider<T extends AbstractContainerMenu>
implements MenuProvider {
    @NotNull
    private final String displayName;
    @NotNull
    private final BlockPos blockPos;
    @NotNull
    private final Function3<Integer, Inventory, FriendlyByteBuf, T> ctor;

    public NullMenuProvider(@NotNull String displayName, @NotNull BlockPos blockPos, @NotNull Function3<? super Integer, ? super Inventory, ? super FriendlyByteBuf, ? extends T> ctor) {
        Intrinsics.checkNotNullParameter((Object)displayName, (String)"displayName");
        Intrinsics.checkNotNullParameter((Object)blockPos, (String)"blockPos");
        Intrinsics.checkNotNullParameter(ctor, (String)"ctor");
        this.displayName = displayName;
        this.blockPos = blockPos;
        this.ctor = ctor;
    }

    @NotNull
    public Component getDisplayName() {
        MutableComponent mutableComponent = Component.literal((String)this.displayName);
        Intrinsics.checkNotNullExpressionValue((Object)mutableComponent, (String)"literal(...)");
        return (Component)mutableComponent;
    }

    @NotNull
    public AbstractContainerMenu createMenu(int id, @NotNull Inventory inventory, @NotNull Player player) {
        Intrinsics.checkNotNullParameter((Object)inventory, (String)"inventory");
        Intrinsics.checkNotNullParameter((Object)player, (String)"player");
        Integer n = id;
        FriendlyByteBuf friendlyByteBuf = new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(this.blockPos);
        Intrinsics.checkNotNullExpressionValue((Object)friendlyByteBuf, (String)"writeBlockPos(...)");
        return (AbstractContainerMenu)this.ctor.invoke((Object)n, (Object)inventory, (Object)friendlyByteBuf);
    }
}

