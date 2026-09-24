/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.functions.Function3
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.core.Holder
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.world.entity.EquipmentSlotGroup
 *  net.minecraft.world.entity.ai.attributes.Attribute
 *  net.minecraft.world.entity.ai.attributes.AttributeModifier
 *  net.minecraft.world.item.ItemStack
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.handlers.subs;

import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u008a\u0001\u0010\u0014\u001a\u00020\u00152\u0081\u0001\u0010\u0016\u001a}\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012+\u0012)\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\u000b\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0010\u00121\u0012/\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u000f0\u0006\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u000f0\u0006JT\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u00072\u001e\u0010\u0010\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\u000b2$\u0010\u0013\u001a \u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u000f0\u0006R\u0090\u0001\u0010\u0004\u001a\u0083\u0001\u0012\u007f\u0012}\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012+\u0012)\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\u000b\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0010\u00121\u0012/\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u000f0\u0006\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u000f0\u00060\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2={"Lnet/thebrokenscript/handlers/subs/ItemAttributeModifierSubscriber;", "", "<init>", "()V", "listeners", "", "Lkotlin/Function3;", "Lnet/minecraft/world/item/ItemStack;", "Lkotlin/ParameterName;", "name", "itemStack", "Lkotlin/Function2;", "Lnet/minecraft/core/Holder;", "Lnet/minecraft/world/entity/ai/attributes/Attribute;", "Lnet/minecraft/resources/ResourceLocation;", "", "removeModifier", "Lnet/minecraft/world/entity/ai/attributes/AttributeModifier;", "Lnet/minecraft/world/entity/EquipmentSlotGroup;", "addModifier", "add", "", "listener", "call", "thebrokenscript-common"})
@SourceDebugExtension(value={"SMAP\nItemAttributeModifierSubscriber.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ItemAttributeModifierSubscriber.kt\nnet/thebrokenscript/handlers/subs/ItemAttributeModifierSubscriber\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,17:1\n1869#2,2:18\n*S KotlinDebug\n*F\n+ 1 ItemAttributeModifierSubscriber.kt\nnet/thebrokenscript/handlers/subs/ItemAttributeModifierSubscriber\n*L\n16#1:18,2\n*E\n"})
public final class ItemAttributeModifierSubscriber {
    @NotNull
    public static final ItemAttributeModifierSubscriber INSTANCE = new ItemAttributeModifierSubscriber();
    @NotNull
    private static final Set<Function3<ItemStack, Function2<? super Holder<Attribute>, ? super ResourceLocation, Unit>, Function3<? super Holder<Attribute>, ? super AttributeModifier, ? super EquipmentSlotGroup, Unit>, Unit>> listeners = new LinkedHashSet();

    private ItemAttributeModifierSubscriber() {
    }

    public final boolean add(@NotNull Function3<? super ItemStack, ? super Function2<? super Holder<Attribute>, ? super ResourceLocation, Unit>, ? super Function3<? super Holder<Attribute>, ? super AttributeModifier, ? super EquipmentSlotGroup, Unit>, Unit> listener) {
        Intrinsics.checkNotNullParameter(listener, (String)"listener");
        return listeners.add(listener);
    }

    public final void call(@NotNull ItemStack itemStack, @NotNull Function2<? super Holder<Attribute>, ? super ResourceLocation, Unit> removeModifier, @NotNull Function3<? super Holder<Attribute>, ? super AttributeModifier, ? super EquipmentSlotGroup, Unit> addModifier) {
        Intrinsics.checkNotNullParameter((Object)itemStack, (String)"itemStack");
        Intrinsics.checkNotNullParameter(removeModifier, (String)"removeModifier");
        Intrinsics.checkNotNullParameter(addModifier, (String)"addModifier");
        Iterable $this$forEach$iv = listeners;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            Function3 it = (Function3)element$iv;
            boolean bl = false;
            it.invoke((Object)itemStack, removeModifier, addModifier);
        }
    }
}

