/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  mezz.jei.api.IModPlugin
 *  mezz.jei.api.JeiPlugin
 *  mezz.jei.api.constants.VanillaTypes
 *  mezz.jei.api.ingredients.IIngredientType
 *  mezz.jei.api.registration.IRecipeRegistration
 *  mezz.jei.api.runtime.IIngredientManager
 *  net.minecraft.core.registries.BuiltInRegistries
 *  net.minecraft.resources.ResourceKey
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.world.item.Item
 *  net.minecraft.world.item.ItemStack
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.compat.jei;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.ingredients.IIngredientType;
import mezz.jei.api.registration.IRecipeRegistration;
import mezz.jei.api.runtime.IIngredientManager;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.thebrokenscript.api.TBSConstants;
import org.jetbrains.annotations.NotNull;

@JeiPlugin
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016\u00a8\u0006\n"}, d2={"Lnet/thebrokenscript/compat/jei/TBSJeiPlugin;", "Lmezz/jei/api/IModPlugin;", "<init>", "()V", "getPluginUid", "Lnet/minecraft/resources/ResourceLocation;", "registerRecipes", "", "reg", "Lmezz/jei/api/registration/IRecipeRegistration;", "thebrokenscript-common"})
@SourceDebugExtension(value={"SMAP\nTBSJeiPlugin.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TBSJeiPlugin.kt\nnet/thebrokenscript/compat/jei/TBSJeiPlugin\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,24:1\n1617#2,9:25\n1869#2:34\n1870#2:36\n1626#2:37\n1#3:35\n*S KotlinDebug\n*F\n+ 1 TBSJeiPlugin.kt\nnet/thebrokenscript/compat/jei/TBSJeiPlugin\n*L\n16#1:25,9\n16#1:34\n16#1:36\n16#1:37\n16#1:35\n*E\n"})
public final class TBSJeiPlugin
implements IModPlugin {
    @NotNull
    public ResourceLocation getPluginUid() {
        return TBSConstants.id("jei_plugin");
    }

    /*
     * WARNING - void declaration
     */
    public void registerRecipes(@NotNull IRecipeRegistration reg) {
        void $this$mapNotNullTo$iv$iv;
        void $this$mapNotNull$iv;
        Intrinsics.checkNotNullParameter((Object)reg, (String)"reg");
        IIngredientManager iIngredientManager = reg.getIngredientManager();
        IIngredientType iIngredientType = (IIngredientType)VanillaTypes.ITEM_STACK;
        Set set = BuiltInRegistries.ITEM.entrySet();
        Intrinsics.checkNotNullExpressionValue((Object)set, (String)"entrySet(...)");
        Iterable iterable = set;
        IIngredientType iIngredientType2 = iIngredientType;
        IIngredientManager iIngredientManager2 = iIngredientManager;
        boolean $i$f$mapNotNull = false;
        void var4_6 = $this$mapNotNull$iv;
        Collection destination$iv$iv = new ArrayList();
        boolean $i$f$mapNotNullTo = false;
        void $this$forEach$iv$iv$iv = $this$mapNotNullTo$iv$iv;
        boolean $i$f$forEach = false;
        Iterator iterator = $this$forEach$iv$iv$iv.iterator();
        while (iterator.hasNext()) {
            ItemStack it$iv$iv;
            Object element$iv$iv$iv;
            Object element$iv$iv = element$iv$iv$iv = iterator.next();
            boolean bl = false;
            Map.Entry it = (Map.Entry)element$iv$iv;
            boolean bl2 = false;
            if ((Intrinsics.areEqual((Object)((ResourceKey)it.getKey()).location().getNamespace(), (Object)"thebrokenscript") ? ((Item)it.getValue()).getDefaultInstance() : null) == null) continue;
            it$iv$iv = it$iv$iv;
            boolean bl3 = false;
            destination$iv$iv.add(it$iv$iv);
        }
        List list = (List)destination$iv$iv;
        iIngredientManager2.removeIngredientsAtRuntime(iIngredientType2, (Collection)list);
    }
}

