/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.network.chat.Component
 *  net.minecraft.resources.ResourceKey
 *  net.minecraft.server.level.ServerPlayer
 *  net.minecraft.world.MenuProvider
 *  net.minecraft.world.SimpleMenuProvider
 *  net.minecraft.world.entity.player.Inventory
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.inventory.AbstractContainerMenu
 *  net.minecraft.world.inventory.MenuConstructor
 *  net.minecraft.world.inventory.MenuType
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.registry.objects;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuConstructor;
import net.minecraft.world.inventory.MenuType;
import net.thebrokenscript.brokencore.api.registry.entries.CustomMenuType;
import net.thebrokenscript.brokencore.api.registry.objects.RegistryEntry;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000H\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u0018\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u00050\u0003B\u0019\u0012\u0010\u0010\u0006\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u001b\u0010\n\u001a\u00028\u00002\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e\u00a2\u0006\u0002\u0010\u000fJ\u0006\u0010\u0010\u001a\u00020\u0011J\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017J\u001e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0011\u00a8\u0006\u0019"}, d2={"Lnet/thebrokenscript/brokencore/api/registry/objects/MenuEntry;", "T", "Lnet/minecraft/world/inventory/AbstractContainerMenu;", "Lnet/thebrokenscript/brokencore/api/registry/objects/RegistryEntry;", "Lnet/minecraft/world/inventory/MenuType;", "Lnet/thebrokenscript/brokencore/api/registry/entries/CustomMenuType;", "key", "Lnet/minecraft/resources/ResourceKey;", "<init>", "(Lnet/minecraft/resources/ResourceKey;)V", "create", "id", "", "inv", "Lnet/minecraft/world/entity/player/Inventory;", "(ILnet/minecraft/world/entity/player/Inventory;)Lnet/minecraft/world/inventory/AbstractContainerMenu;", "asProvider", "Lnet/minecraft/world/inventory/MenuConstructor;", "open", "", "player", "Lnet/minecraft/server/level/ServerPlayer;", "displayName", "Lnet/minecraft/network/chat/Component;", "provider", "brokencore-common"})
@SourceDebugExtension(value={"SMAP\nMenuEntry.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MenuEntry.kt\nnet/thebrokenscript/brokencore/api/registry/objects/MenuEntry\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,40:1\n1#2:41\n*E\n"})
public final class MenuEntry<T extends AbstractContainerMenu>
extends RegistryEntry<MenuType<?>, CustomMenuType<T>> {
    public MenuEntry(@NotNull ResourceKey<MenuType<?>> key) {
        Intrinsics.checkNotNullParameter(key, (String)"key");
        super(key);
    }

    @NotNull
    public final T create(int id, @NotNull Inventory inv) {
        Intrinsics.checkNotNullParameter((Object)inv, (String)"inv");
        return ((CustomMenuType)((Object)this.get())).create(id, inv);
    }

    @NotNull
    public final MenuConstructor asProvider() {
        return (arg_0, arg_1, arg_2) -> MenuEntry.asProvider$lambda$0(this, arg_0, arg_1, arg_2);
    }

    public final void open(@NotNull ServerPlayer player, @NotNull Component displayName) {
        Intrinsics.checkNotNullParameter((Object)player, (String)"player");
        Intrinsics.checkNotNullParameter((Object)displayName, (String)"displayName");
        MenuEntry $this$open_u24lambda_u240 = this;
        boolean bl = false;
        $this$open_u24lambda_u240.open(player, displayName, $this$open_u24lambda_u240.asProvider());
    }

    public final void open(@NotNull ServerPlayer player, @NotNull Component displayName, @NotNull MenuConstructor provider) {
        Intrinsics.checkNotNullParameter((Object)player, (String)"player");
        Intrinsics.checkNotNullParameter((Object)displayName, (String)"displayName");
        Intrinsics.checkNotNullParameter((Object)provider, (String)"provider");
        MenuEntry $this$open_u24lambda_u241 = this;
        boolean bl = false;
        player.openMenu((MenuProvider)new SimpleMenuProvider(provider, displayName));
    }

    private static final AbstractContainerMenu asProvider$lambda$0(MenuEntry this$0, int id, Inventory inv, Player player) {
        Intrinsics.checkNotNull((Object)inv);
        return this$0.create(id, inv);
    }
}

