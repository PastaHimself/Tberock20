/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.data.PackOutput
 *  net.minecraft.world.item.Item
 *  net.minecraft.world.item.Item$Properties
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.registry.builders;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Item;
import net.thebrokenscript.brokencore.api.datagen.providers.BCItemModelProvider;
import net.thebrokenscript.brokencore.api.ext.MiscExt;
import net.thebrokenscript.brokencore.api.registry.BrokenReg;
import net.thebrokenscript.brokencore.api.registry.builders.BaseItemBuilder;
import net.thebrokenscript.brokencore.api.registry.dsl.RegistryDslMarker;
import net.thebrokenscript.brokencore.api.util.InstanceConsumer;
import org.jetbrains.annotations.NotNull;

@RegistryDslMarker
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0017\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022 \u0012\u0004\u0012\u0002H\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u00000\u0003B+\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00028\u00000\n\u00a2\u0006\u0004\b\f\u0010\rJ\"\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0012\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00040\u0010H\u0016\u00a8\u0006\u0011"}, d2={"Lnet/thebrokenscript/brokencore/api/registry/builders/ItemBuilder;", "T", "Lnet/minecraft/world/item/Item;", "Lnet/thebrokenscript/brokencore/api/registry/builders/BaseItemBuilder;", "Lnet/thebrokenscript/brokencore/api/datagen/providers/BCItemModelProvider;", "parent", "Lnet/thebrokenscript/brokencore/api/registry/BrokenReg;", "name", "", "ctor", "Lkotlin/Function1;", "Lnet/minecraft/world/item/Item$Properties;", "<init>", "(Lnet/thebrokenscript/brokencore/api/registry/BrokenReg;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "model", "builder", "Lnet/thebrokenscript/brokencore/api/util/InstanceConsumer;", "brokencore-common"})
public class ItemBuilder<T extends Item>
extends BaseItemBuilder<T, BCItemModelProvider<T>, ItemBuilder<T>> {
    public ItemBuilder(@NotNull BrokenReg parent, @NotNull String name, @NotNull Function1<? super Item.Properties, ? extends T> ctor) {
        Intrinsics.checkNotNullParameter((Object)parent, (String)"parent");
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter(ctor, (String)"ctor");
        super(parent, name, ctor);
    }

    @Override
    @NotNull
    public ItemBuilder<T> model(@NotNull InstanceConsumer<BCItemModelProvider<T>> builder) {
        ItemBuilder itemBuilder;
        Intrinsics.checkNotNullParameter(builder, (String)"builder");
        ItemBuilder $this$model_u24lambda_u240 = itemBuilder = this;
        boolean bl = false;
        $this$model_u24lambda_u240.getParent().getData().getItemModels().register((Function1<? super PackOutput, Unit>)((Function1)arg_0 -> ItemBuilder.model$lambda$0$0($this$model_u24lambda_u240, builder, arg_0)));
        return itemBuilder;
    }

    private static final Unit model$lambda$0$0(ItemBuilder $this_apply, InstanceConsumer $builder, PackOutput it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        MiscExt.gluedApply(new BCItemModelProvider(it, $this_apply.getParent(), $this_apply.getId()), $builder).registerModels();
        return Unit.INSTANCE;
    }
}

