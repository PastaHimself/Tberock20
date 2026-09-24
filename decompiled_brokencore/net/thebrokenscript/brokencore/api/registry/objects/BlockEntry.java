/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.optionals.OptionalsKt
 *  net.minecraft.core.registries.BuiltInRegistries
 *  net.minecraft.resources.ResourceKey
 *  net.minecraft.world.item.Item
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.level.block.Block
 *  net.minecraft.world.level.block.state.BlockState
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.brokencore.api.registry.objects;

import java.util.Optional;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.optionals.OptionalsKt;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.thebrokenscript.brokencore.api.registry.objects.RegistryEntry;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u0000 \u0019*\b\b\u0000\u0010\u0001*\u00020\u00022\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u0002H\u00010\u0003:\u0001\u0019B%\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005\u00a2\u0006\u0004\b\b\u0010\tR\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\u000b8F\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u00078F\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u00128F\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0015\u001a\u00020\u00078F\u00a2\u0006\u0006\u001a\u0004\b\u0016\u0010\u0010R\u0011\u0010\u0017\u001a\u00020\u00128F\u00a2\u0006\u0006\u001a\u0004\b\u0018\u0010\u0014\u00a8\u0006\u001a"}, d2={"Lnet/thebrokenscript/brokencore/api/registry/objects/BlockEntry;", "T", "Lnet/minecraft/world/level/block/Block;", "Lnet/thebrokenscript/brokencore/api/registry/objects/RegistryEntry;", "key", "Lnet/minecraft/resources/ResourceKey;", "itemKey", "Lnet/minecraft/world/item/Item;", "<init>", "(Lnet/minecraft/resources/ResourceKey;Lnet/minecraft/resources/ResourceKey;)V", "defaultState", "Lnet/minecraft/world/level/block/state/BlockState;", "getDefaultState", "()Lnet/minecraft/world/level/block/state/BlockState;", "item", "getItem", "()Lnet/minecraft/world/item/Item;", "itemStack", "Lnet/minecraft/world/item/ItemStack;", "getItemStack", "()Lnet/minecraft/world/item/ItemStack;", "itemOrThrow", "getItemOrThrow", "itemStackOrThrow", "getItemStackOrThrow", "Companion", "brokencore-common"})
public class BlockEntry<T extends Block>
extends RegistryEntry<Block, T> {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @Nullable
    private final ResourceKey<Item> itemKey;

    public BlockEntry(@NotNull ResourceKey<Block> key, @Nullable ResourceKey<Item> itemKey) {
        Intrinsics.checkNotNullParameter(key, (String)"key");
        super(key);
        this.itemKey = itemKey;
    }

    @NotNull
    public final BlockState getDefaultState() {
        BlockState blockState = ((Block)this.get()).defaultBlockState();
        Intrinsics.checkNotNullExpressionValue((Object)blockState, (String)"defaultBlockState(...)");
        return blockState;
    }

    @Nullable
    public final Item getItem() {
        Optional optional = BuiltInRegistries.ITEM.getOptional(this.itemKey);
        Intrinsics.checkNotNullExpressionValue((Object)optional, (String)"getOptional(...)");
        return (Item)OptionalsKt.getOrNull((Optional)optional);
    }

    @Nullable
    public final ItemStack getItemStack() {
        Item item2 = this.getItem();
        return item2 != null ? item2.getDefaultInstance() : null;
    }

    @NotNull
    public final Item getItemOrThrow() {
        Item item2 = this.getItem();
        if (item2 == null) {
            throw new IllegalStateException("No BlockItem registered for block " + this.getKey().location() + "!");
        }
        return item2;
    }

    @NotNull
    public final ItemStack getItemStackOrThrow() {
        ItemStack itemStack = this.getItemOrThrow().getDefaultInstance();
        Intrinsics.checkNotNullExpressionValue((Object)itemStack, (String)"getDefaultInstance(...)");
        return itemStack;
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J#\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0005\"\b\b\u0001\u0010\u0006*\u00020\u00072\u0006\u0010\b\u001a\u0002H\u0006\u00a2\u0006\u0002\u0010\t\u00a8\u0006\n"}, d2={"Lnet/thebrokenscript/brokencore/api/registry/objects/BlockEntry$Companion;", "", "<init>", "()V", "of", "Lnet/thebrokenscript/brokencore/api/registry/objects/BlockEntry;", "T", "Lnet/minecraft/world/level/block/Block;", "block", "(Lnet/minecraft/world/level/block/Block;)Lnet/thebrokenscript/brokencore/api/registry/objects/BlockEntry;", "brokencore-common"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final <T extends Block> BlockEntry<T> of(@NotNull T block2) {
            Intrinsics.checkNotNullParameter(block2, (String)"block");
            Object t = BuiltInRegistries.BLOCK.getResourceKey(block2).get();
            Intrinsics.checkNotNullExpressionValue(t, (String)"get(...)");
            ResourceKey resourceKey = (ResourceKey)t;
            Optional optional = BuiltInRegistries.ITEM.getResourceKey((Object)block2.asItem());
            Intrinsics.checkNotNullExpressionValue((Object)optional, (String)"getResourceKey(...)");
            return new BlockEntry((ResourceKey<Block>)resourceKey, (ResourceKey<Item>)((ResourceKey)OptionalsKt.getOrNull((Optional)optional)));
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

