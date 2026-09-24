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
 *  kotlin.collections.MapsKt
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.core.Holder
 *  net.minecraft.tags.TagKey
 *  net.minecraft.world.item.Item
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.item.crafting.CraftingBookCategory
 *  net.minecraft.world.item.crafting.Ingredient
 *  net.minecraft.world.item.crafting.ShapedRecipe
 *  net.minecraft.world.item.crafting.ShapedRecipePattern
 *  net.minecraft.world.level.ItemLike
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.registry.builders.item;

import com.google.gson.JsonElement;
import com.mojang.serialization.Codec;
import com.mojang.serialization.DynamicOps;
import com.mojang.serialization.Encoder;
import com.mojang.serialization.JsonOps;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.core.Holder;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.CraftingBookCategory;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.ShapedRecipe;
import net.minecraft.world.item.crafting.ShapedRecipePattern;
import net.minecraft.world.level.ItemLike;
import net.thebrokenscript.brokencore.api.ext.CodecExt;
import net.thebrokenscript.brokencore.api.registry.builders.item.BaseRecipeBuilder;
import net.thebrokenscript.brokencore.api.registry.builders.item.IngredientProvider;
import net.thebrokenscript.brokencore.api.registry.builders.item.ItemLikeProvider;
import net.thebrokenscript.brokencore.api.registry.builders.item.ItemStackProvider;
import net.thebrokenscript.brokencore.api.registry.dsl.RegistryDslMarker;
import org.jetbrains.annotations.NotNull;

@RegistryDslMarker
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\t\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bJ\u0016\u0010\t\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u000bJ\u0016\u0010\t\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\rJ\u0016\u0010\t\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000eJ\u001c\u0010\t\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u00062\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fJ\u001c\u0010\t\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u00062\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u0012J\u0006\u0010\u0017\u001a\u00020\u0018J\u0006\u0010\u0019\u001a\u00020\u001aJ\b\u0010\u001b\u001a\u00020\u001cH\u0016R$\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u00148\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0016\u00a8\u0006\u001d"}, d2={"Lnet/thebrokenscript/brokencore/api/registry/builders/item/ShapedCraftingBuilder;", "Lnet/thebrokenscript/brokencore/api/registry/builders/item/BaseRecipeBuilder;", "<init>", "()V", "ingredients", "", "", "Lkotlin/Function0;", "Lnet/minecraft/world/item/crafting/Ingredient;", "ingredient", "key", "Lnet/thebrokenscript/brokencore/api/registry/builders/item/IngredientProvider;", "item", "Lnet/thebrokenscript/brokencore/api/registry/builders/item/ItemLikeProvider;", "Lnet/thebrokenscript/brokencore/api/registry/builders/item/ItemStackProvider;", "Lnet/minecraft/core/Holder;", "Lnet/minecraft/world/item/Item;", "tag", "Lnet/minecraft/tags/TagKey;", "pattern", "", "", "[Ljava/lang/String;", "asPattern", "Lnet/minecraft/world/item/crafting/ShapedRecipePattern;", "asRecipe", "Lnet/minecraft/world/item/crafting/ShapedRecipe;", "asJson", "Lcom/google/gson/JsonElement;", "brokencore-common"})
@SourceDebugExtension(value={"SMAP\nShapedCraftingBuilder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ShapedCraftingBuilder.kt\nnet/thebrokenscript/brokencore/api/registry/builders/item/ShapedCraftingBuilder\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,43:1\n1#2:44\n463#3:45\n413#3:46\n1252#4,4:47\n*S KotlinDebug\n*F\n+ 1 ShapedCraftingBuilder.kt\nnet/thebrokenscript/brokencore/api/registry/builders/item/ShapedCraftingBuilder\n*L\n35#1:45\n35#1:46\n35#1:47,4\n*E\n"})
public final class ShapedCraftingBuilder
extends BaseRecipeBuilder {
    @JvmField
    @NotNull
    public Map<Character, Function0<Ingredient>> ingredients = new LinkedHashMap();
    @JvmField
    @NotNull
    public String[] pattern;

    public ShapedCraftingBuilder() {
        String[] stringArray = new String[]{"   ", "   ", "   "};
        this.pattern = stringArray;
    }

    @NotNull
    public final ShapedCraftingBuilder ingredient(char key, @NotNull Ingredient ingredient2) {
        ShapedCraftingBuilder shapedCraftingBuilder;
        Intrinsics.checkNotNullParameter((Object)ingredient2, (String)"ingredient");
        ShapedCraftingBuilder $this$ingredient_u24lambda_u240 = shapedCraftingBuilder = this;
        boolean bl = false;
        $this$ingredient_u24lambda_u240.ingredients.put(Character.valueOf(key), (Function0<Ingredient>)((Function0)() -> ShapedCraftingBuilder.ingredient$lambda$0$0(ingredient2)));
        return shapedCraftingBuilder;
    }

    @NotNull
    public final ShapedCraftingBuilder ingredient(char key, @NotNull IngredientProvider ingredient2) {
        ShapedCraftingBuilder shapedCraftingBuilder;
        Intrinsics.checkNotNullParameter((Object)ingredient2, (String)"ingredient");
        ShapedCraftingBuilder $this$ingredient_u24lambda_u241 = shapedCraftingBuilder = this;
        boolean bl = false;
        $this$ingredient_u24lambda_u241.ingredients.put(Character.valueOf(key), new Function0<Ingredient>((Object)ingredient2){

            public final Ingredient invoke() {
                return ((IngredientProvider)this.receiver).provide();
            }
        });
        return shapedCraftingBuilder;
    }

    @NotNull
    public final ShapedCraftingBuilder ingredient(char key, @NotNull ItemLikeProvider item2) {
        ShapedCraftingBuilder shapedCraftingBuilder;
        Intrinsics.checkNotNullParameter((Object)item2, (String)"item");
        ShapedCraftingBuilder $this$ingredient_u24lambda_u242 = shapedCraftingBuilder = this;
        boolean bl = false;
        $this$ingredient_u24lambda_u242.ingredients.put(Character.valueOf(key), (Function0<Ingredient>)((Function0)() -> ShapedCraftingBuilder.ingredient$lambda$2$0(item2)));
        return shapedCraftingBuilder;
    }

    @NotNull
    public final ShapedCraftingBuilder ingredient(char key, @NotNull ItemStackProvider item2) {
        ShapedCraftingBuilder shapedCraftingBuilder;
        Intrinsics.checkNotNullParameter((Object)item2, (String)"item");
        ShapedCraftingBuilder $this$ingredient_u24lambda_u243 = shapedCraftingBuilder = this;
        boolean bl = false;
        $this$ingredient_u24lambda_u243.ingredients.put(Character.valueOf(key), (Function0<Ingredient>)((Function0)() -> ShapedCraftingBuilder.ingredient$lambda$3$0(item2)));
        return shapedCraftingBuilder;
    }

    @NotNull
    public final ShapedCraftingBuilder ingredient(char key, @NotNull Holder<Item> item2) {
        ShapedCraftingBuilder shapedCraftingBuilder;
        Intrinsics.checkNotNullParameter(item2, (String)"item");
        ShapedCraftingBuilder $this$ingredient_u24lambda_u244 = shapedCraftingBuilder = this;
        boolean bl = false;
        $this$ingredient_u24lambda_u244.ingredients.put(Character.valueOf(key), (Function0<Ingredient>)((Function0)() -> ShapedCraftingBuilder.ingredient$lambda$4$0(item2)));
        return shapedCraftingBuilder;
    }

    @NotNull
    public final ShapedCraftingBuilder ingredient(char key, @NotNull TagKey<Item> tag) {
        ShapedCraftingBuilder shapedCraftingBuilder;
        Intrinsics.checkNotNullParameter(tag, (String)"tag");
        ShapedCraftingBuilder $this$ingredient_u24lambda_u245 = shapedCraftingBuilder = this;
        boolean bl = false;
        $this$ingredient_u24lambda_u245.ingredients.put(Character.valueOf(key), (Function0<Ingredient>)((Function0)() -> ShapedCraftingBuilder.ingredient$lambda$5$0(tag)));
        return shapedCraftingBuilder;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public final ShapedRecipePattern asPattern() {
        void $this$associateByTo$iv$iv$iv;
        void $this$mapValuesTo$iv$iv;
        Map<Character, Function0<Ingredient>> $this$mapValues$iv = this.ingredients;
        boolean $i$f$mapValues = false;
        Map<Character, Function0<Ingredient>> map = $this$mapValues$iv;
        Map destination$iv$iv = new LinkedHashMap(MapsKt.mapCapacity((int)$this$mapValues$iv.size()));
        boolean $i$f$mapValuesTo = false;
        Iterable iterable = $this$mapValuesTo$iv$iv.entrySet();
        Map destination$iv$iv$iv = destination$iv$iv;
        boolean $i$f$associateByTo = false;
        for (Object element$iv$iv$iv : $this$associateByTo$iv$iv$iv) {
            void it;
            void it$iv$iv;
            Map.Entry entry = (Map.Entry)element$iv$iv$iv;
            Map map2 = destination$iv$iv$iv;
            boolean bl = false;
            Map.Entry entry2 = (Map.Entry)element$iv$iv$iv;
            Object k = it$iv$iv.getKey();
            Map map3 = map2;
            boolean bl2 = false;
            Ingredient ingredient2 = (Ingredient)((Function0)it.getValue()).invoke();
            map3.put(k, ingredient2);
        }
        String[] stringArray = this.pattern;
        ShapedRecipePattern shapedRecipePattern = ShapedRecipePattern.of((Map)destination$iv$iv$iv, (String[])Arrays.copyOf(stringArray, stringArray.length));
        Intrinsics.checkNotNullExpressionValue((Object)shapedRecipePattern, (String)"of(...)");
        return shapedRecipePattern;
    }

    @NotNull
    public final ShapedRecipe asRecipe() {
        CraftingBookCategory craftingBookCategory = this.category;
        ShapedRecipePattern shapedRecipePattern = this.asPattern();
        Function0 function0 = this.result;
        if (function0 == null) {
            ShapedRecipePattern shapedRecipePattern2 = shapedRecipePattern;
            CraftingBookCategory craftingBookCategory2 = craftingBookCategory;
            String string = "";
            boolean bl = false;
            String string2 = "Result must not be null!";
            String string3 = string;
            CraftingBookCategory craftingBookCategory3 = craftingBookCategory2;
            ShapedRecipePattern shapedRecipePattern3 = shapedRecipePattern2;
            String string4 = string2;
            throw new IllegalStateException(string4.toString());
        }
        ItemStack itemStack = (ItemStack)function0.invoke();
        ShapedRecipePattern shapedRecipePattern4 = shapedRecipePattern;
        CraftingBookCategory craftingBookCategory4 = craftingBookCategory;
        String string = "";
        return new ShapedRecipe(string, craftingBookCategory4, shapedRecipePattern4, itemStack);
    }

    @Override
    @NotNull
    public JsonElement asJson() {
        Codec codec = ShapedRecipe.CODEC;
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

