/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.JsonElement
 *  com.mojang.serialization.Codec
 *  com.mojang.serialization.DynamicOps
 *  com.mojang.serialization.Encoder
 *  com.mojang.serialization.JsonOps
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.core.Holder
 *  net.minecraft.core.NonNullList
 *  net.minecraft.tags.TagKey
 *  net.minecraft.world.item.Item
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.item.crafting.CraftingBookCategory
 *  net.minecraft.world.item.crafting.Ingredient
 *  net.minecraft.world.item.crafting.ShapelessRecipe
 *  net.minecraft.world.level.ItemLike
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.registry.builders.item;

import com.google.gson.JsonElement;
import com.mojang.serialization.Codec;
import com.mojang.serialization.DynamicOps;
import com.mojang.serialization.Encoder;
import com.mojang.serialization.JsonOps;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.core.Holder;
import net.minecraft.core.NonNullList;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.CraftingBookCategory;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.ShapelessRecipe;
import net.minecraft.world.level.ItemLike;
import net.thebrokenscript.brokencore.api.ext.CodecExt;
import net.thebrokenscript.brokencore.api.registry.builders.item.BaseRecipeBuilder;
import net.thebrokenscript.brokencore.api.registry.builders.item.IngredientProvider;
import net.thebrokenscript.brokencore.api.registry.builders.item.ItemLikeProvider;
import net.thebrokenscript.brokencore.api.registry.builders.item.ItemStackProvider;
import net.thebrokenscript.brokencore.api.registry.dsl.RegistryDslMarker;
import org.jetbrains.annotations.NotNull;

@RegistryDslMarker
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\b\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\b\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\b\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\b\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\fJ\u0014\u0010\b\u001a\u00020\u00002\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000e0\rJ\u0014\u0010\b\u001a\u00020\u00002\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0010J\u0006\u0010\u0011\u001a\u00020\u0012J\b\u0010\u0013\u001a\u00020\u0014H\u0016R\u001e\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2={"Lnet/thebrokenscript/brokencore/api/registry/builders/item/ShapelessCraftingBuilder;", "Lnet/thebrokenscript/brokencore/api/registry/builders/item/BaseRecipeBuilder;", "<init>", "()V", "ingredients", "", "Lkotlin/Function0;", "Lnet/minecraft/world/item/crafting/Ingredient;", "ingredient", "Lnet/thebrokenscript/brokencore/api/registry/builders/item/IngredientProvider;", "item", "Lnet/thebrokenscript/brokencore/api/registry/builders/item/ItemLikeProvider;", "Lnet/thebrokenscript/brokencore/api/registry/builders/item/ItemStackProvider;", "Lnet/minecraft/core/Holder;", "Lnet/minecraft/world/item/Item;", "tag", "Lnet/minecraft/tags/TagKey;", "asRecipe", "Lnet/minecraft/world/item/crafting/ShapelessRecipe;", "asJson", "Lcom/google/gson/JsonElement;", "brokencore-common"})
@SourceDebugExtension(value={"SMAP\nShapelessCraftingBuilder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ShapelessCraftingBuilder.kt\nnet/thebrokenscript/brokencore/api/registry/builders/item/ShapelessCraftingBuilder\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,38:1\n1#2:39\n1563#3:40\n1634#3,3:41\n37#4,2:44\n*S KotlinDebug\n*F\n+ 1 ShapelessCraftingBuilder.kt\nnet/thebrokenscript/brokencore/api/registry/builders/item/ShapelessCraftingBuilder\n*L\n34#1:40\n34#1:41,3\n34#1:44,2\n*E\n"})
public final class ShapelessCraftingBuilder
extends BaseRecipeBuilder {
    @JvmField
    @NotNull
    public List<Function0<Ingredient>> ingredients = new ArrayList();

    @NotNull
    public final ShapelessCraftingBuilder ingredient(@NotNull Ingredient ingredient2) {
        ShapelessCraftingBuilder shapelessCraftingBuilder;
        Intrinsics.checkNotNullParameter((Object)ingredient2, (String)"ingredient");
        ShapelessCraftingBuilder $this$ingredient_u24lambda_u240 = shapelessCraftingBuilder = this;
        boolean bl = false;
        $this$ingredient_u24lambda_u240.ingredients.add((Function0<Ingredient>)((Function0)() -> ShapelessCraftingBuilder.ingredient$lambda$0$0(ingredient2)));
        return shapelessCraftingBuilder;
    }

    @NotNull
    public final ShapelessCraftingBuilder ingredient(@NotNull IngredientProvider ingredient2) {
        ShapelessCraftingBuilder shapelessCraftingBuilder;
        Intrinsics.checkNotNullParameter((Object)ingredient2, (String)"ingredient");
        ShapelessCraftingBuilder $this$ingredient_u24lambda_u241 = shapelessCraftingBuilder = this;
        boolean bl = false;
        $this$ingredient_u24lambda_u241.ingredients.add(new Function0<Ingredient>((Object)ingredient2){

            public final Ingredient invoke() {
                return ((IngredientProvider)this.receiver).provide();
            }
        });
        return shapelessCraftingBuilder;
    }

    @NotNull
    public final ShapelessCraftingBuilder ingredient(@NotNull ItemLikeProvider item2) {
        ShapelessCraftingBuilder shapelessCraftingBuilder;
        Intrinsics.checkNotNullParameter((Object)item2, (String)"item");
        ShapelessCraftingBuilder $this$ingredient_u24lambda_u242 = shapelessCraftingBuilder = this;
        boolean bl = false;
        $this$ingredient_u24lambda_u242.ingredients.add((Function0<Ingredient>)((Function0)() -> ShapelessCraftingBuilder.ingredient$lambda$2$0(item2)));
        return shapelessCraftingBuilder;
    }

    @NotNull
    public final ShapelessCraftingBuilder ingredient(@NotNull ItemStackProvider item2) {
        ShapelessCraftingBuilder shapelessCraftingBuilder;
        Intrinsics.checkNotNullParameter((Object)item2, (String)"item");
        ShapelessCraftingBuilder $this$ingredient_u24lambda_u243 = shapelessCraftingBuilder = this;
        boolean bl = false;
        $this$ingredient_u24lambda_u243.ingredients.add((Function0<Ingredient>)((Function0)() -> ShapelessCraftingBuilder.ingredient$lambda$3$0(item2)));
        return shapelessCraftingBuilder;
    }

    @NotNull
    public final ShapelessCraftingBuilder ingredient(@NotNull Holder<Item> item2) {
        ShapelessCraftingBuilder shapelessCraftingBuilder;
        Intrinsics.checkNotNullParameter(item2, (String)"item");
        ShapelessCraftingBuilder $this$ingredient_u24lambda_u244 = shapelessCraftingBuilder = this;
        boolean bl = false;
        $this$ingredient_u24lambda_u244.ingredients.add((Function0<Ingredient>)((Function0)() -> ShapelessCraftingBuilder.ingredient$lambda$4$0(item2)));
        return shapelessCraftingBuilder;
    }

    @NotNull
    public final ShapelessCraftingBuilder ingredient(@NotNull TagKey<Item> tag) {
        ShapelessCraftingBuilder shapelessCraftingBuilder;
        Intrinsics.checkNotNullParameter(tag, (String)"tag");
        ShapelessCraftingBuilder $this$ingredient_u24lambda_u245 = shapelessCraftingBuilder = this;
        boolean bl = false;
        $this$ingredient_u24lambda_u245.ingredients.add((Function0<Ingredient>)((Function0)() -> ShapelessCraftingBuilder.ingredient$lambda$5$0(tag)));
        return shapelessCraftingBuilder;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public final ShapelessRecipe asRecipe() {
        Collection<Ingredient> collection;
        void $this$mapTo$iv$iv;
        void $this$map$iv;
        CraftingBookCategory craftingBookCategory = this.category;
        Function0 function0 = this.result;
        if (function0 == null) {
            CraftingBookCategory craftingBookCategory2 = craftingBookCategory;
            String string = "";
            boolean $i$a$-checkNotNull-ShapelessCraftingBuilder$asRecipe$22 = false;
            String string2 = "Result must not be null!";
            String string3 = string;
            CraftingBookCategory craftingBookCategory3 = craftingBookCategory2;
            String $i$a$-checkNotNull-ShapelessCraftingBuilder$asRecipe$22 = string2;
            throw new IllegalStateException($i$a$-checkNotNull-ShapelessCraftingBuilder$asRecipe$22.toString());
        }
        Iterable $i$a$-checkNotNull-ShapelessCraftingBuilder$asRecipe$22 = this.ingredients;
        Object var14_10 = null;
        ItemStack itemStack = (ItemStack)function0.invoke();
        CraftingBookCategory craftingBookCategory4 = craftingBookCategory;
        String string = "";
        boolean $i$f$map = false;
        void var4_12 = $this$map$iv;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map$iv, (int)10));
        boolean $i$f$mapTo = false;
        for (Object item$iv$iv : $this$mapTo$iv$iv) {
            void it;
            Function0 function02 = (Function0)item$iv$iv;
            collection = destination$iv$iv;
            boolean bl = false;
            collection.add((Ingredient)it.invoke());
        }
        collection = (List)destination$iv$iv;
        Collection $this$toTypedArray$iv = collection;
        boolean $i$f$toTypedArray = false;
        Collection thisCollection$iv = $this$toTypedArray$iv;
        Ingredient[] ingredientArray = thisCollection$iv.toArray(new Ingredient[0]);
        NonNullList nonNullList = NonNullList.of(var14_10, (Object[])Arrays.copyOf(ingredientArray, ingredientArray.length));
        ItemStack itemStack2 = itemStack;
        CraftingBookCategory craftingBookCategory5 = craftingBookCategory4;
        String string4 = string;
        return new ShapelessRecipe(string4, craftingBookCategory5, itemStack2, nonNullList);
    }

    @Override
    @NotNull
    public JsonElement asJson() {
        Codec codec = ShapelessRecipe.CODEC;
        Intrinsics.checkNotNullExpressionValue((Object)codec, (String)"CODEC");
        Encoder encoder = (Encoder)codec;
        JsonOps jsonOps = JsonOps.INSTANCE;
        Intrinsics.checkNotNullExpressionValue((Object)jsonOps, (String)"INSTANCE");
        Object t = CodecExt.INSTANCE.encodeOrThrow(encoder, (DynamicOps)jsonOps, this.asRecipe());
        Intrinsics.checkNotNullExpressionValue(t, (String)"encodeOrThrow(...)");
        return (JsonElement)t;
    }

    private static final Ingredient ingredient$lambda$0$0(Ingredient $ingredient) {
        return $ingredient;
    }

    private static final Ingredient ingredient$lambda$2$0(ItemLikeProvider $item) {
        ItemLike[] itemLikeArray = new ItemLike[]{$item.provide()};
        Ingredient ingredient2 = Ingredient.of((ItemLike[])itemLikeArray);
        Intrinsics.checkNotNullExpressionValue((Object)ingredient2, (String)"of(...)");
        return ingredient2;
    }

    private static final Ingredient ingredient$lambda$3$0(ItemStackProvider $item) {
        ItemStack[] itemStackArray = new ItemStack[]{$item.provide()};
        Ingredient ingredient2 = Ingredient.of((ItemStack[])itemStackArray);
        Intrinsics.checkNotNullExpressionValue((Object)ingredient2, (String)"of(...)");
        return ingredient2;
    }

    private static final Ingredient ingredient$lambda$4$0(Holder $item) {
        ItemLike[] itemLikeArray = new ItemLike[]{$item.value()};
        Ingredient ingredient2 = Ingredient.of((ItemLike[])itemLikeArray);
        Intrinsics.checkNotNullExpressionValue((Object)ingredient2, (String)"of(...)");
        return ingredient2;
    }

    private static final Ingredient ingredient$lambda$5$0(TagKey $tag) {
        Ingredient ingredient2 = Ingredient.of((TagKey)$tag);
        Intrinsics.checkNotNullExpressionValue((Object)ingredient2, (String)"of(...)");
        return ingredient2;
    }
}

