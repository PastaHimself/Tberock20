/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.core.component.DataComponentType
 *  net.minecraft.world.entity.player.Inventory
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.inventory.AbstractContainerMenu
 *  net.minecraft.world.inventory.MenuType
 *  net.minecraft.world.item.ItemStack
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.world.inventory;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.ItemStack;
import net.thebrokenscript.registry.TBSDataComponents;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B/\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0005\u00a2\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0005H\u0016R\u0011\u0010\u000b\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0016"}, d2={"Lnet/thebrokenscript/world/inventory/LibraryBookMenu;", "Lnet/minecraft/world/inventory/AbstractContainerMenu;", "type", "Lnet/minecraft/world/inventory/MenuType;", "id", "", "inv", "Lnet/minecraft/world/entity/player/Inventory;", "bookID", "<init>", "(Lnet/minecraft/world/inventory/MenuType;ILnet/minecraft/world/entity/player/Inventory;I)V", "bookId", "getBookId", "()I", "stillValid", "", "player", "Lnet/minecraft/world/entity/player/Player;", "quickMoveStack", "Lnet/minecraft/world/item/ItemStack;", "playerIn", "index", "thebrokenscript-common"})
public final class LibraryBookMenu
extends AbstractContainerMenu {
    private final int bookId;

    public LibraryBookMenu(@Nullable MenuType<LibraryBookMenu> type, int id, @NotNull Inventory inv, int bookID) {
        int n;
        Intrinsics.checkNotNullParameter((Object)inv, (String)"inv");
        super(type, id);
        if (bookID != 0) {
            n = bookID;
        } else {
            Integer n2 = (Integer)inv.player.getMainHandItem().get((DataComponentType)TBSDataComponents.INSTANCE.getLIBRARY_BOOK_NUM().invoke());
            n = n2 != null ? n2 : 1;
        }
        this.bookId = n;
    }

    public final int getBookId() {
        return this.bookId;
    }

    public boolean stillValid(@NotNull Player player) {
        Intrinsics.checkNotNullParameter((Object)player, (String)"player");
        return true;
    }

    @NotNull
    public ItemStack quickMoveStack(@NotNull Player playerIn, int index) {
        Intrinsics.checkNotNullParameter((Object)playerIn, (String)"playerIn");
        ItemStack itemStack = ItemStack.EMPTY;
        Intrinsics.checkNotNullExpressionValue((Object)itemStack, (String)"EMPTY");
        return itemStack;
    }
}

