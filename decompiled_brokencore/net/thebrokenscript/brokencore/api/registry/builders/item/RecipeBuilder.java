/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.TuplesKt
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.core.registries.BuiltInRegistries
 *  net.minecraft.core.registries.Registries
 *  net.minecraft.data.PackOutput
 *  net.minecraft.resources.ResourceKey
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.world.item.Item
 *  net.minecraft.world.item.ItemStack
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.brokencore.api.registry.builders.item;

import compat.net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.thebrokenscript.brokencore.api.registry.builders.AbstractBuilder;
import net.thebrokenscript.brokencore.api.registry.builders.BaseItemBuilder;
import net.thebrokenscript.brokencore.api.registry.builders.item.BaseRecipeBuilder;
import net.thebrokenscript.brokencore.api.registry.builders.item.ShapedCraftingBuilder;
import net.thebrokenscript.brokencore.api.registry.builders.item.ShapelessCraftingBuilder;
import net.thebrokenscript.brokencore.api.registry.dsl.RegistryDslMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@RegistryDslMarker
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u0004*\u001a\b\u0002\u0010\u0005*\u0014\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u00050\u00062\u00020\u0007B\u000f\u0012\u0006\u0010\b\u001a\u00028\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000e\u001a\u00020\u000f2\u0017\u0010\u0010\u001a\u0013\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00120\u0011\u00a2\u0006\u0002\b\u0013J\u001f\u0010\u0014\u001a\u00020\u00152\u0017\u0010\u0010\u001a\u0013\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00120\u0011\u00a2\u0006\u0002\b\u0013J\u001b\u0010\u0016\u001a\u0002H\u0001\"\b\b\u0003\u0010\u0001*\u00020\r*\u0002H\u0001H\u0002\u00a2\u0006\u0002\u0010\u0017J\u0006\u0010\u0018\u001a\u00020\u0012R\u0010\u0010\b\u001a\u00028\u0002X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u000bR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0019"}, d2={"Lnet/thebrokenscript/brokencore/api/registry/builders/item/RecipeBuilder;", "T", "Lnet/minecraft/world/item/Item;", "M", "Lcompat/net/neoforged/neoforge/client/model/generators/ItemModelProvider;", "S", "Lnet/thebrokenscript/brokencore/api/registry/builders/BaseItemBuilder;", "", "parent", "<init>", "(Lnet/thebrokenscript/brokencore/api/registry/builders/BaseItemBuilder;)V", "Lnet/thebrokenscript/brokencore/api/registry/builders/BaseItemBuilder;", "builder", "Lnet/thebrokenscript/brokencore/api/registry/builders/item/BaseRecipeBuilder;", "shaped", "Lnet/thebrokenscript/brokencore/api/registry/builders/item/ShapedCraftingBuilder;", "block", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "shapeless", "Lnet/thebrokenscript/brokencore/api/registry/builders/item/ShapelessCraftingBuilder;", "setup", "(Lnet/thebrokenscript/brokencore/api/registry/builders/item/BaseRecipeBuilder;)Lnet/thebrokenscript/brokencore/api/registry/builders/item/BaseRecipeBuilder;", "register", "brokencore-common"})
@SourceDebugExtension(value={"SMAP\nRecipeBuilder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RecipeBuilder.kt\nnet/thebrokenscript/brokencore/api/registry/builders/item/RecipeBuilder\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,37:1\n1#2:38\n*E\n"})
public final class RecipeBuilder<T extends Item, M extends ItemModelProvider, S extends BaseItemBuilder<T, M, S>> {
    @NotNull
    private final S parent;
    @Nullable
    private BaseRecipeBuilder builder;

    public RecipeBuilder(@NotNull S parent) {
        Intrinsics.checkNotNullParameter(parent, (String)"parent");
        this.parent = parent;
    }

    @NotNull
    public final ShapedCraftingBuilder shaped(@NotNull Function1<? super ShapedCraftingBuilder, Unit> block2) {
        Intrinsics.checkNotNullParameter(block2, (String)"block");
        BaseRecipeBuilder baseRecipeBuilder = this.setup((BaseRecipeBuilder)new ShapedCraftingBuilder());
        block2.invoke((Object)baseRecipeBuilder);
        ShapedCraftingBuilder it = (ShapedCraftingBuilder)baseRecipeBuilder;
        boolean bl = false;
        this.builder = it;
        return (ShapedCraftingBuilder)baseRecipeBuilder;
    }

    @NotNull
    public final ShapelessCraftingBuilder shapeless(@NotNull Function1<? super ShapelessCraftingBuilder, Unit> block2) {
        Intrinsics.checkNotNullParameter(block2, (String)"block");
        BaseRecipeBuilder baseRecipeBuilder = this.setup((BaseRecipeBuilder)new ShapelessCraftingBuilder());
        block2.invoke((Object)baseRecipeBuilder);
        ShapelessCraftingBuilder it = (ShapelessCraftingBuilder)baseRecipeBuilder;
        boolean bl = false;
        this.builder = it;
        return (ShapelessCraftingBuilder)baseRecipeBuilder;
    }

    private final <T extends BaseRecipeBuilder> T setup(T $this$setup) {
        T t;
        T $this$setup_u24lambda_u240 = t = $this$setup;
        boolean bl = false;
        $this$setup_u24lambda_u240.result = () -> RecipeBuilder.setup$lambda$0$0(this);
        return t;
    }

    public final void register() {
        BaseRecipeBuilder baseRecipeBuilder = this.builder;
        if (baseRecipeBuilder == null) {
            return;
        }
        BaseRecipeBuilder builder = baseRecipeBuilder;
        ((AbstractBuilder)this.parent).getParent().getData().getRecipes().register((Function1<? super PackOutput, Unit>)((Function1)arg_0 -> RecipeBuilder.register$lambda$0(this, builder, arg_0)));
    }

    private static final ItemStack setup$lambda$0$0(RecipeBuilder this$0) {
        return ((Item)BuiltInRegistries.ITEM.getOrThrow(ResourceKey.create((ResourceKey)Registries.ITEM, (ResourceLocation)((AbstractBuilder)this$0.parent).getId()))).getDefaultInstance();
    }

    private static final Unit register$lambda$0(RecipeBuilder this$0, BaseRecipeBuilder $builder, PackOutput it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        Pair[] pairArray = new Pair[]{TuplesKt.to((Object)("data/" + ((AbstractBuilder)this$0.parent).getId().getNamespace() + "/recipe/" + ((AbstractBuilder)this$0.parent).getId().getPath() + ".json"), (Object)$builder.asJson())};
        ((AbstractBuilder)this$0.parent).getParent().getData().getRecipes().accept(pairArray);
        return Unit.INSTANCE;
    }
}

