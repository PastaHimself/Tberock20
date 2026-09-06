/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.world.entity.player.Inventory
 *  net.minecraft.world.flag.FeatureFlagSet
 *  net.minecraft.world.inventory.AbstractContainerMenu
 *  net.minecraft.world.inventory.MenuType
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.registry.entries;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.thebrokenscript.brokencore.api.registry.builders.interfaces.MenuConstructor;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u001d\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u001d\u0010\n\u001a\u00028\u00002\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016\u00a2\u0006\u0002\u0010\u000fR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2={"Lnet/thebrokenscript/brokencore/api/registry/entries/CustomMenuType;", "T", "Lnet/minecraft/world/inventory/AbstractContainerMenu;", "Lnet/minecraft/world/inventory/MenuType;", "ctor", "Lnet/thebrokenscript/brokencore/api/registry/builders/interfaces/MenuConstructor;", "requiredFeatures", "Lnet/minecraft/world/flag/FeatureFlagSet;", "<init>", "(Lnet/thebrokenscript/brokencore/api/registry/builders/interfaces/MenuConstructor;Lnet/minecraft/world/flag/FeatureFlagSet;)V", "create", "containerId", "", "playerInventory", "Lnet/minecraft/world/entity/player/Inventory;", "(ILnet/minecraft/world/entity/player/Inventory;)Lnet/minecraft/world/inventory/AbstractContainerMenu;", "brokencore-common"})
public final class CustomMenuType<T extends AbstractContainerMenu>
extends MenuType<T> {
    @NotNull
    private final MenuConstructor<T> ctor;

    public CustomMenuType(@NotNull MenuConstructor<T> ctor, @NotNull FeatureFlagSet requiredFeatures) {
        Intrinsics.checkNotNullParameter(ctor, (String)"ctor");
        Intrinsics.checkNotNullParameter((Object)requiredFeatures, (String)"requiredFeatures");
        super(ctor::createNoType, requiredFeatures);
        this.ctor = ctor;
    }

    @NotNull
    public T create(int containerId, @NotNull Inventory playerInventory) {
        Intrinsics.checkNotNullParameter((Object)playerInventory, (String)"playerInventory");
        return this.ctor.create(this, containerId, playerInventory);
    }
}

