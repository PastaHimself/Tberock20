/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  net.minecraft.client.gui.screens.Screen
 *  net.minecraft.network.chat.Component
 *  net.minecraft.world.entity.player.Inventory
 *  net.minecraft.world.inventory.AbstractContainerMenu
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.registry.builders.interfaces;

import kotlin.Metadata;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.thebrokenscript.brokencore.api.util.Side;
import net.thebrokenscript.brokencore.api.util.SideOnly;
import org.jetbrains.annotations.NotNull;

@SideOnly(side=Side.CLIENT)
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00e7\u0080\u0001\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\u0012\b\u0001\u0010\u0003*\u00020\u0004*\b\u0012\u0004\u0012\u0002H\u00010\u00052\u00020\u0006J%\u0010\u0007\u001a\u00028\u00012\u0006\u0010\b\u001a\u00028\u00002\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH&\u00a2\u0006\u0002\u0010\r\u00a8\u0006\u000e"}, d2={"Lnet/thebrokenscript/brokencore/api/registry/builders/interfaces/ScreenFactory;", "M", "Lnet/minecraft/world/inventory/AbstractContainerMenu;", "S", "Lnet/minecraft/client/gui/screens/Screen;", "Lnet/minecraft/client/gui/screens/inventory/MenuAccess;", "", "create", "menu", "inventory", "Lnet/minecraft/world/entity/player/Inventory;", "displayName", "Lnet/minecraft/network/chat/Component;", "(Lnet/minecraft/world/inventory/AbstractContainerMenu;Lnet/minecraft/world/entity/player/Inventory;Lnet/minecraft/network/chat/Component;)Lnet/minecraft/client/gui/screens/Screen;", "brokencore-common"})
public interface ScreenFactory<M extends AbstractContainerMenu, S extends Screen> {
    @NotNull
    public S create(@NotNull M var1, @NotNull Inventory var2, @NotNull Component var3);
}

