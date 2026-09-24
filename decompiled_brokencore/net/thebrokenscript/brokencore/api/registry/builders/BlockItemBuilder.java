/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.core.registries.BuiltInRegistries
 *  net.minecraft.data.PackOutput
 *  net.minecraft.world.item.BlockItem
 *  net.minecraft.world.item.Item$Properties
 *  net.minecraft.world.level.block.Block
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.registry.builders;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.thebrokenscript.brokencore.api.datagen.providers.BCBlockItemModelProvider;
import net.thebrokenscript.brokencore.api.ext.MiscExt;
import net.thebrokenscript.brokencore.api.registry.BrokenReg;
import net.thebrokenscript.brokencore.api.registry.builders.BaseItemBuilder;
import net.thebrokenscript.brokencore.api.registry.dsl.RegistryDslMarker;
import net.thebrokenscript.brokencore.api.util.InstanceConsumer;
import org.jetbrains.annotations.NotNull;

@RegistryDslMarker
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\b\u0017\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022 \u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u00000\u0003B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0004\b\n\u0010\u000bJ\"\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0012\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00050\u0011H\u0016R\u0011\u0010\f\u001a\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2={"Lnet/thebrokenscript/brokencore/api/registry/builders/BlockItemBuilder;", "B", "Lnet/minecraft/world/level/block/Block;", "Lnet/thebrokenscript/brokencore/api/registry/builders/BaseItemBuilder;", "Lnet/minecraft/world/item/BlockItem;", "Lnet/thebrokenscript/brokencore/api/datagen/providers/BCBlockItemModelProvider;", "parent", "Lnet/thebrokenscript/brokencore/api/registry/BrokenReg;", "name", "", "<init>", "(Lnet/thebrokenscript/brokencore/api/registry/BrokenReg;Ljava/lang/String;)V", "block", "getBlock", "()Lnet/minecraft/world/level/block/Block;", "model", "builder", "Lnet/thebrokenscript/brokencore/api/util/InstanceConsumer;", "brokencore-common"})
public class BlockItemBuilder<B extends Block>
extends BaseItemBuilder<BlockItem, BCBlockItemModelProvider<B>, BlockItemBuilder<B>> {
    public BlockItemBuilder(@NotNull BrokenReg parent, @NotNull String name) {
        Intrinsics.checkNotNullParameter((Object)parent, (String)"parent");
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        super(parent, name, arg_0 -> BlockItemBuilder._init_$lambda$0(parent, name, arg_0));
    }

    @NotNull
    public final Block getBlock() {
        Object object = BuiltInRegistries.BLOCK.get(this.getParent().id(this.getName()));
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"get(...)");
        return (Block)object;
    }

    @Override
    @NotNull
    public BlockItemBuilder<B> model(@NotNull InstanceConsumer<BCBlockItemModelProvider<B>> builder) {
        BlockItemBuilder blockItemBuilder;
        Intrinsics.checkNotNullParameter(builder, (String)"builder");
        BlockItemBuilder $this$model_u24lambda_u240 = blockItemBuilder = this;
        boolean bl = false;
        $this$model_u24lambda_u240.getParent().getData().getItemModels().register((Function1<? super PackOutput, Unit>)((Function1)arg_0 -> BlockItemBuilder.model$lambda$0$0($this$model_u24lambda_u240, builder, arg_0)));
        return blockItemBuilder;
    }

    private static final BlockItem _init_$lambda$0(BrokenReg $parent, String $name, Item.Properties it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        return new BlockItem((Block)BuiltInRegistries.BLOCK.get($parent.id($name)), it);
    }

    private static final Unit model$lambda$0$0(BlockItemBuilder $this_apply, InstanceConsumer $builder, PackOutput it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        MiscExt.gluedApply(new BCBlockItemModelProvider(it, $this_apply.getParent(), $this_apply.getId()), $builder).registerModels();
        return Unit.INSTANCE;
    }
}

