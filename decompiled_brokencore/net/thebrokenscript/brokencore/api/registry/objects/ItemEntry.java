/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.resources.ResourceKey
 *  net.minecraft.world.item.Item
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.level.ItemLike
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.registry.objects;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.thebrokenscript.brokencore.api.registry.objects.RegistryEntry;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u0002H\u00010\u0003B\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\t8F\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2={"Lnet/thebrokenscript/brokencore/api/registry/objects/ItemEntry;", "T", "Lnet/minecraft/world/item/Item;", "Lnet/thebrokenscript/brokencore/api/registry/objects/RegistryEntry;", "key", "Lnet/minecraft/resources/ResourceKey;", "<init>", "(Lnet/minecraft/resources/ResourceKey;)V", "stack", "Lnet/minecraft/world/item/ItemStack;", "getStack", "()Lnet/minecraft/world/item/ItemStack;", "brokencore-common"})
public class ItemEntry<T extends Item>
extends RegistryEntry<Item, T> {
    public ItemEntry(@NotNull ResourceKey<Item> key) {
        Intrinsics.checkNotNullParameter(key, (String)"key");
        super(key);
    }

    @NotNull
    public final ItemStack getStack() {
        return new ItemStack((ItemLike)this.get());
    }
}

