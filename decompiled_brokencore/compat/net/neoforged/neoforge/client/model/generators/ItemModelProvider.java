/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.core.registries.BuiltInRegistries
 *  net.minecraft.data.PackOutput
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.world.item.Item
 *  net.minecraft.world.level.block.Block
 *  org.jetbrains.annotations.NotNull
 */
package compat.net.neoforged.neoforge.client.model.generators;

import compat.net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import compat.net.neoforged.neoforge.client.model.generators.ModelFile;
import compat.net.neoforged.neoforge.client.model.generators.ModelProvider;
import compat.net.neoforged.neoforge.common.data.ExistingFileHelper;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000eJ\u0016\u0010\u000f\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0011J\u0016\u0010\u000f\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0006J\u000e\u0010\u0012\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0011J\u000e\u0010\u0014\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u0014\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0006J\u0016\u0010\u0014\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u0006J\u0016\u0010\u0014\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0006J\u000e\u0010\u0016\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u0016\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0006J\u000e\u0010\u0017\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u0017\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0006J\u000e\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u000eJ\u000e\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0006J\u000e\u0010\u001a\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\rJ\b\u0010\u001b\u001a\u00020\u0011H\u0016\u00a8\u0006\u001c"}, d2={"Lcompat/net/neoforged/neoforge/client/model/generators/ItemModelProvider;", "Lcompat/net/neoforged/neoforge/client/model/generators/ModelProvider;", "Lcompat/net/neoforged/neoforge/client/model/generators/ItemModelBuilder;", "output", "Lnet/minecraft/data/PackOutput;", "id", "Lnet/minecraft/resources/ResourceLocation;", "existingFileHelper", "Lcompat/net/neoforged/neoforge/common/data/ExistingFileHelper;", "<init>", "(Lnet/minecraft/data/PackOutput;Lnet/minecraft/resources/ResourceLocation;Lcompat/net/neoforged/neoforge/common/data/ExistingFileHelper;)V", "key", "item", "Lnet/minecraft/world/item/Item;", "Lnet/minecraft/world/level/block/Block;", "withExistingParent", "parent", "", "itemTexture", "name", "basicItem", "tex", "handheldItem", "spawnEggItem", "simpleBlockItem", "block", "musicDisc", "getName", "brokencore-common"})
public abstract class ItemModelProvider
extends ModelProvider<ItemModelBuilder> {
    public ItemModelProvider(@NotNull PackOutput output, @NotNull ResourceLocation id, @NotNull ExistingFileHelper existingFileHelper) {
        Intrinsics.checkNotNullParameter((Object)output, (String)"output");
        Intrinsics.checkNotNullParameter((Object)id, (String)"id");
        Intrinsics.checkNotNullParameter((Object)existingFileHelper, (String)"existingFileHelper");
        super(output, id, "item", 1.INSTANCE, existingFileHelper);
    }

    @NotNull
    public final ResourceLocation key(@NotNull Item item2) {
        Intrinsics.checkNotNullParameter((Object)item2, (String)"item");
        ResourceLocation resourceLocation = BuiltInRegistries.ITEM.getKey((Object)item2);
        Intrinsics.checkNotNullExpressionValue((Object)resourceLocation, (String)"getKey(...)");
        return resourceLocation;
    }

    @NotNull
    public final ResourceLocation key(@NotNull Block item2) {
        Intrinsics.checkNotNullParameter((Object)item2, (String)"item");
        ResourceLocation resourceLocation = BuiltInRegistries.BLOCK.getKey((Object)item2);
        Intrinsics.checkNotNullExpressionValue((Object)resourceLocation, (String)"getKey(...)");
        return resourceLocation;
    }

    @NotNull
    public final ItemModelBuilder withExistingParent(@NotNull Item item2, @NotNull String parent) {
        Intrinsics.checkNotNullParameter((Object)item2, (String)"item");
        Intrinsics.checkNotNullParameter((Object)parent, (String)"parent");
        String string = this.key(item2).toString();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"toString(...)");
        return (ItemModelBuilder)this.withExistingParent(string, parent);
    }

    @NotNull
    public final ItemModelBuilder withExistingParent(@NotNull Item item2, @NotNull ResourceLocation parent) {
        Intrinsics.checkNotNullParameter((Object)item2, (String)"item");
        Intrinsics.checkNotNullParameter((Object)parent, (String)"parent");
        String string = this.key(item2).toString();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"toString(...)");
        return (ItemModelBuilder)this.withExistingParent(string, parent);
    }

    @NotNull
    public final ResourceLocation itemTexture(@NotNull Item item2) {
        Intrinsics.checkNotNullParameter((Object)item2, (String)"item");
        ResourceLocation resourceLocation = ResourceLocation.fromNamespaceAndPath((String)this.key(item2).getNamespace(), (String)("item/" + this.key(item2).getPath()));
        Intrinsics.checkNotNullExpressionValue((Object)resourceLocation, (String)"fromNamespaceAndPath(...)");
        return resourceLocation;
    }

    @NotNull
    public final ResourceLocation itemTexture(@NotNull String name) {
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        ResourceLocation resourceLocation = ResourceLocation.fromNamespaceAndPath((String)this.id.getNamespace(), (String)("item/" + name));
        Intrinsics.checkNotNullExpressionValue((Object)resourceLocation, (String)"fromNamespaceAndPath(...)");
        return resourceLocation;
    }

    @NotNull
    public final ItemModelBuilder basicItem(@NotNull Item item2) {
        Intrinsics.checkNotNullParameter((Object)item2, (String)"item");
        ResourceLocation resourceLocation = Objects.requireNonNull(BuiltInRegistries.ITEM.getKey((Object)item2));
        Intrinsics.checkNotNullExpressionValue((Object)resourceLocation, (String)"requireNonNull(...)");
        return this.basicItem(resourceLocation);
    }

    @NotNull
    public final ItemModelBuilder basicItem(@NotNull ResourceLocation item2) {
        Intrinsics.checkNotNullParameter((Object)item2, (String)"item");
        String string = item2.toString();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"toString(...)");
        ItemModelBuilder itemModelBuilder = (ItemModelBuilder)((ItemModelBuilder)this.getBuilder(string)).parent(new ModelFile.UncheckedModelFile("item/generated"));
        ResourceLocation resourceLocation = ResourceLocation.fromNamespaceAndPath((String)item2.getNamespace(), (String)("item/" + item2.getPath()));
        Intrinsics.checkNotNullExpressionValue((Object)resourceLocation, (String)"fromNamespaceAndPath(...)");
        return (ItemModelBuilder)itemModelBuilder.texture("layer0", resourceLocation);
    }

    @NotNull
    public final ItemModelBuilder basicItem(@NotNull Item item2, @NotNull ResourceLocation tex) {
        Intrinsics.checkNotNullParameter((Object)item2, (String)"item");
        Intrinsics.checkNotNullParameter((Object)tex, (String)"tex");
        ResourceLocation resourceLocation = Objects.requireNonNull(BuiltInRegistries.ITEM.getKey((Object)item2));
        Intrinsics.checkNotNullExpressionValue((Object)resourceLocation, (String)"requireNonNull(...)");
        return this.basicItem(resourceLocation, tex);
    }

    @NotNull
    public final ItemModelBuilder basicItem(@NotNull ResourceLocation item2, @NotNull ResourceLocation tex) {
        Intrinsics.checkNotNullParameter((Object)item2, (String)"item");
        Intrinsics.checkNotNullParameter((Object)tex, (String)"tex");
        String string = item2.toString();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"toString(...)");
        return (ItemModelBuilder)((ItemModelBuilder)((ItemModelBuilder)this.getBuilder(string)).parent(new ModelFile.UncheckedModelFile("item/generated"))).texture("layer0", tex);
    }

    @NotNull
    public final ItemModelBuilder handheldItem(@NotNull Item item2) {
        Intrinsics.checkNotNullParameter((Object)item2, (String)"item");
        ResourceLocation resourceLocation = Objects.requireNonNull(BuiltInRegistries.ITEM.getKey((Object)item2));
        Intrinsics.checkNotNullExpressionValue((Object)resourceLocation, (String)"requireNonNull(...)");
        return this.handheldItem(resourceLocation);
    }

    @NotNull
    public final ItemModelBuilder handheldItem(@NotNull ResourceLocation item2) {
        Intrinsics.checkNotNullParameter((Object)item2, (String)"item");
        String string = item2.toString();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"toString(...)");
        ItemModelBuilder itemModelBuilder = (ItemModelBuilder)((ItemModelBuilder)this.getBuilder(string)).parent(new ModelFile.UncheckedModelFile("item/handheld"));
        ResourceLocation resourceLocation = ResourceLocation.fromNamespaceAndPath((String)item2.getNamespace(), (String)("item/" + item2.getPath()));
        Intrinsics.checkNotNullExpressionValue((Object)resourceLocation, (String)"fromNamespaceAndPath(...)");
        return (ItemModelBuilder)itemModelBuilder.texture("layer0", resourceLocation);
    }

    @NotNull
    public final ItemModelBuilder spawnEggItem(@NotNull Item item2) {
        Intrinsics.checkNotNullParameter((Object)item2, (String)"item");
        ResourceLocation resourceLocation = Objects.requireNonNull(BuiltInRegistries.ITEM.getKey((Object)item2));
        Intrinsics.checkNotNullExpressionValue((Object)resourceLocation, (String)"requireNonNull(...)");
        return this.spawnEggItem(resourceLocation);
    }

    @NotNull
    public final ItemModelBuilder spawnEggItem(@NotNull ResourceLocation item2) {
        Intrinsics.checkNotNullParameter((Object)item2, (String)"item");
        String string = item2.toString();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"toString(...)");
        return (ItemModelBuilder)((ItemModelBuilder)this.getBuilder(string)).parent(new ModelFile.UncheckedModelFile("item/template_spawn_egg"));
    }

    @NotNull
    public final ItemModelBuilder simpleBlockItem(@NotNull Block block2) {
        Intrinsics.checkNotNullParameter((Object)block2, (String)"block");
        ResourceLocation resourceLocation = Objects.requireNonNull(BuiltInRegistries.BLOCK.getKey((Object)block2));
        Intrinsics.checkNotNullExpressionValue((Object)resourceLocation, (String)"requireNonNull(...)");
        return this.simpleBlockItem(resourceLocation);
    }

    @NotNull
    public final ItemModelBuilder simpleBlockItem(@NotNull ResourceLocation block2) {
        Intrinsics.checkNotNullParameter((Object)block2, (String)"block");
        String string = block2.toString();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"toString(...)");
        ResourceLocation resourceLocation = ResourceLocation.fromNamespaceAndPath((String)block2.getNamespace(), (String)("block/" + block2.getPath()));
        Intrinsics.checkNotNullExpressionValue((Object)resourceLocation, (String)"fromNamespaceAndPath(...)");
        return (ItemModelBuilder)this.withExistingParent(string, resourceLocation);
    }

    @NotNull
    public final ItemModelBuilder musicDisc(@NotNull Item item2) {
        Intrinsics.checkNotNullParameter((Object)item2, (String)"item");
        String string = this.key(item2).toString();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"toString(...)");
        return (ItemModelBuilder)((ItemModelBuilder)this.withExistingParent(string, "item/template_music_disc")).texture("layer0", this.itemTexture(item2));
    }

    @NotNull
    public String getName() {
        return "Item Models: " + this.id;
    }
}

