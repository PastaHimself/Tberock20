/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.JsonElement
 *  com.google.gson.JsonObject
 *  com.mojang.serialization.Codec
 *  com.mojang.serialization.DynamicOps
 *  com.mojang.serialization.Encoder
 *  com.mojang.serialization.JsonOps
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.TuplesKt
 *  kotlin.Unit
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.JvmOverloads
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.functions.Function3
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.advancements.critereon.StatePropertiesPredicate$Builder
 *  net.minecraft.client.color.block.BlockColor
 *  net.minecraft.core.registries.Registries
 *  net.minecraft.data.PackOutput
 *  net.minecraft.resources.RegistryOps
 *  net.minecraft.resources.ResourceKey
 *  net.minecraft.world.item.Item
 *  net.minecraft.world.level.ItemLike
 *  net.minecraft.world.level.block.Block
 *  net.minecraft.world.level.block.DoorBlock
 *  net.minecraft.world.level.block.SlabBlock
 *  net.minecraft.world.level.block.state.BlockBehaviour$Properties
 *  net.minecraft.world.level.block.state.properties.DoubleBlockHalf
 *  net.minecraft.world.level.block.state.properties.Property
 *  net.minecraft.world.level.block.state.properties.SlabType
 *  net.minecraft.world.level.storage.loot.LootPool$Builder
 *  net.minecraft.world.level.storage.loot.LootTable
 *  net.minecraft.world.level.storage.loot.LootTable$Builder
 *  net.minecraft.world.level.storage.loot.entries.LootItem
 *  net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer$Builder
 *  net.minecraft.world.level.storage.loot.entries.LootPoolSingletonContainer$Builder
 *  net.minecraft.world.level.storage.loot.functions.ApplyExplosionDecay
 *  net.minecraft.world.level.storage.loot.functions.LootItemFunction$Builder
 *  net.minecraft.world.level.storage.loot.functions.SetItemCountFunction
 *  net.minecraft.world.level.storage.loot.predicates.ExplosionCondition
 *  net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition
 *  net.minecraft.world.level.storage.loot.predicates.LootItemCondition$Builder
 *  net.minecraft.world.level.storage.loot.providers.number.ConstantValue
 *  net.minecraft.world.level.storage.loot.providers.number.NumberProvider
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.brokencore.api.registry.builders;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.mojang.serialization.Codec;
import com.mojang.serialization.DynamicOps;
import com.mojang.serialization.Encoder;
import com.mojang.serialization.JsonOps;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.client.color.block.BlockColor;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.RegistryOps;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.SlabType;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
import net.minecraft.world.level.storage.loot.entries.LootPoolSingletonContainer;
import net.minecraft.world.level.storage.loot.functions.ApplyExplosionDecay;
import net.minecraft.world.level.storage.loot.functions.LootItemFunction;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.ExplosionCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.NumberProvider;
import net.thebrokenscript.brokencore.api.datagen.providers.BCBlockItemModelProvider;
import net.thebrokenscript.brokencore.api.datagen.providers.BCBlockStateProvider;
import net.thebrokenscript.brokencore.api.ext.CodecExt;
import net.thebrokenscript.brokencore.api.ext.KFuncExt;
import net.thebrokenscript.brokencore.api.ext.MiscExt;
import net.thebrokenscript.brokencore.api.registry.BrokenReg;
import net.thebrokenscript.brokencore.api.registry.builders.AbstractBuilder;
import net.thebrokenscript.brokencore.api.registry.builders.BaseItemBuilder;
import net.thebrokenscript.brokencore.api.registry.builders.BlockItemBuilder;
import net.thebrokenscript.brokencore.api.registry.builders.BlockTagsBuilder;
import net.thebrokenscript.brokencore.api.registry.dsl.RegistryDslMarker;
import net.thebrokenscript.brokencore.api.registry.handlers.ClientBlockHandler;
import net.thebrokenscript.brokencore.api.registry.objects.BlockEntry;
import net.thebrokenscript.brokencore.api.registry.objects.ItemEntry;
import net.thebrokenscript.brokencore.api.registry.util.LootBuildersKt;
import net.thebrokenscript.brokencore.api.util.InstanceConsumer;
import net.thebrokenscript.brokencore.api.util.LangUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@RegistryDslMarker
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000z\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0017\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022&\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u0000\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u0002H\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u00040\u0003B+\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00028\u00000\n\u00a2\u0006\u0004\b\f\u0010\rJ&\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u000e\u001a\u00020\u000b2\u000e\b\u0002\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0013H\u0007J,\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000f2\u000e\b\u0002\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0013H\u0007J\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0013J \u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0012\u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00140\u0013J \u0010!\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0012\u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\"0\u0013J$\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0014\b\u0002\u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00110\u0013H\u0007J9\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002+\u0010 \u001a'\u0012\u0004\u0012\u00020\u001a\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u001b\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\u0004\u0012\u00020\u001c0\u0019\u00a2\u0006\u0002\b\u001dJ\f\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000J\f\u0010%\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000J\u001a\u0010%\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\f\u0010#\u001a\b\u0012\u0004\u0012\u00020&0\u000fJ\f\u0010'\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000J\u001a\u0010'\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\f\u0010#\u001a\b\u0012\u0004\u0012\u00020&0\u000fJ\f\u0010(\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000J\f\u0010)\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000J\f\u0010*\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000J\f\u0010+\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000J\u0016\u0010,\u001a\u00020\u001c2\f\u0010-\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0014J\r\u0010.\u001a\u00028\u0000H\u0014\u00a2\u0006\u0002\u0010/J\u001c\u00100\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\f\u00101\u001a\b\u0012\u0004\u0012\u00020\u000202H\u0016J\u000e\u00103\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00028\u00000\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0012\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0014\u0018\u00010\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R9\u0010\u0018\u001a)\u0012\u0004\u0012\u00020\u001a\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u001b\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u0019\u00a2\u0006\u0002\b\u001d8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u00064"}, d2={"Lnet/thebrokenscript/brokencore/api/registry/builders/BlockBuilder;", "T", "Lnet/minecraft/world/level/block/Block;", "Lnet/thebrokenscript/brokencore/api/registry/builders/AbstractBuilder;", "Lnet/thebrokenscript/brokencore/api/registry/objects/BlockEntry;", "parent", "Lnet/thebrokenscript/brokencore/api/registry/BrokenReg;", "name", "", "ctor", "Lkotlin/Function1;", "Lnet/minecraft/world/level/block/state/BlockBehaviour$Properties;", "<init>", "(Lnet/thebrokenscript/brokencore/api/registry/BrokenReg;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "props", "Lkotlin/Function0;", "itemBuilder", "Lnet/thebrokenscript/brokencore/api/registry/builders/BlockItemBuilder;", "tagBuilder", "Lnet/thebrokenscript/brokencore/api/util/InstanceConsumer;", "Lnet/thebrokenscript/brokencore/api/registry/builders/BlockTagsBuilder;", "colorHandler", "Lnet/minecraft/client/color/block/BlockColor;", "lang", "loot", "Lkotlin/Function3;", "Lnet/minecraft/world/level/storage/loot/LootTable$Builder;", "Lnet/thebrokenscript/brokencore/api/registry/objects/ItemEntry;", "", "Lkotlin/ExtensionFunctionType;", "block", "tags", "builder", "model", "Lnet/thebrokenscript/brokencore/api/datagen/providers/BCBlockStateProvider;", "item", "noLoot", "simpleLoot", "Lnet/minecraft/world/level/ItemLike;", "doorLoot", "slabLoot", "simpleItem", "simpleItemNoTab", "noLang", "onRegistered", "entry", "createObject", "()Lnet/minecraft/world/level/block/Block;", "createEntry", "key", "Lnet/minecraft/resources/ResourceKey;", "register", "brokencore-common"})
@SourceDebugExtension(value={"SMAP\nBlockBuilder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BlockBuilder.kt\nnet/thebrokenscript/brokencore/api/registry/builders/BlockBuilder\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,257:1\n1#2:258\n*E\n"})
public class BlockBuilder<T extends Block>
extends AbstractBuilder<BlockBuilder<T>, Block, T, BlockEntry<T>> {
    @NotNull
    private final Function1<BlockBehaviour.Properties, T> ctor;
    @NotNull
    private Function0<? extends BlockBehaviour.Properties> props;
    @Nullable
    private BlockItemBuilder<T> itemBuilder;
    @Nullable
    private InstanceConsumer<BlockTagsBuilder<T>> tagBuilder;
    @JvmField
    @Nullable
    public Function0<? extends BlockColor> colorHandler;
    @JvmField
    @Nullable
    public String lang;
    @JvmField
    @Nullable
    public Function3<? super LootTable.Builder, ? super ItemEntry<?>, ? super BlockEntry<?>, Unit> loot;

    public BlockBuilder(@NotNull BrokenReg parent, @NotNull String name, @NotNull Function1<? super BlockBehaviour.Properties, ? extends T> ctor) {
        Intrinsics.checkNotNullParameter((Object)parent, (String)"parent");
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter(ctor, (String)"ctor");
        ResourceKey resourceKey = Registries.BLOCK;
        Intrinsics.checkNotNullExpressionValue((Object)resourceKey, (String)"BLOCK");
        super(parent, resourceKey, name);
        this.ctor = ctor;
        this.props = BlockBuilder::props$lambda$0;
        this.lang = LangUtil.INSTANCE.getAutomaticName(this.getId());
    }

    @JvmOverloads
    @NotNull
    public final BlockBuilder<T> props(@NotNull BlockBehaviour.Properties props, @NotNull InstanceConsumer<BlockBehaviour.Properties> block2) {
        Intrinsics.checkNotNullParameter((Object)props, (String)"props");
        Intrinsics.checkNotNullParameter(block2, (String)"block");
        return this.props((Function0<BlockBehaviour.Properties>)((Function0)() -> BlockBuilder.props$lambda$2(props)), block2);
    }

    public static /* synthetic */ BlockBuilder props$default(BlockBuilder blockBuilder, BlockBehaviour.Properties properties, InstanceConsumer instanceConsumer, int n, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: props");
        }
        if ((n & 2) != 0) {
            instanceConsumer = BlockBuilder::props$lambda$1;
        }
        return blockBuilder.props(properties, instanceConsumer);
    }

    @JvmOverloads
    @NotNull
    public final BlockBuilder<T> props(@NotNull Function0<? extends BlockBehaviour.Properties> props, @NotNull InstanceConsumer<BlockBehaviour.Properties> block2) {
        BlockBuilder blockBuilder;
        Intrinsics.checkNotNullParameter(props, (String)"props");
        Intrinsics.checkNotNullParameter(block2, (String)"block");
        BlockBuilder $this$props_u24lambda_u244 = blockBuilder = this;
        boolean bl = false;
        $this$props_u24lambda_u244.props = KFuncExt.INSTANCE.chainApplyConsumer(props, block2);
        return blockBuilder;
    }

    public static /* synthetic */ BlockBuilder props$default(BlockBuilder blockBuilder, Function0 function0, InstanceConsumer instanceConsumer, int n, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: props");
        }
        if ((n & 2) != 0) {
            instanceConsumer = BlockBuilder::props$lambda$3;
        }
        return blockBuilder.props((Function0<BlockBehaviour.Properties>)function0, instanceConsumer);
    }

    @NotNull
    public final BlockBuilder<T> props(@NotNull InstanceConsumer<BlockBehaviour.Properties> block2) {
        BlockBuilder blockBuilder;
        Intrinsics.checkNotNullParameter(block2, (String)"block");
        BlockBuilder $this$props_u24lambda_u245 = blockBuilder = this;
        boolean bl = false;
        $this$props_u24lambda_u245.props = KFuncExt.INSTANCE.chainApplyConsumer($this$props_u24lambda_u245.props, block2);
        return blockBuilder;
    }

    @NotNull
    public final BlockBuilder<T> tags(@NotNull InstanceConsumer<BlockTagsBuilder<T>> builder) {
        BlockBuilder blockBuilder;
        Intrinsics.checkNotNullParameter(builder, (String)"builder");
        BlockBuilder $this$tags_u24lambda_u240 = blockBuilder = this;
        boolean bl = false;
        $this$tags_u24lambda_u240.tagBuilder = builder;
        return blockBuilder;
    }

    @NotNull
    public final BlockBuilder<T> model(@NotNull InstanceConsumer<BCBlockStateProvider<T>> builder) {
        BlockBuilder blockBuilder;
        Intrinsics.checkNotNullParameter(builder, (String)"builder");
        BlockBuilder $this$model_u24lambda_u240 = blockBuilder = this;
        boolean bl = false;
        $this$model_u24lambda_u240.getParent().getData().getBlockModels().register((Function1<? super PackOutput, Unit>)((Function1)arg_0 -> BlockBuilder.model$lambda$0$0($this$model_u24lambda_u240, builder, arg_0)));
        return blockBuilder;
    }

    @JvmOverloads
    @NotNull
    public final BlockBuilder<T> item(@NotNull InstanceConsumer<BlockItemBuilder<T>> builder) {
        BlockBuilder blockBuilder;
        Intrinsics.checkNotNullParameter(builder, (String)"builder");
        BlockBuilder $this$item_u24lambda_u241 = blockBuilder = this;
        boolean bl = false;
        $this$item_u24lambda_u241.itemBuilder = MiscExt.gluedApply(new BlockItemBuilder($this$item_u24lambda_u241.getParent(), $this$item_u24lambda_u241.getName()), builder);
        return blockBuilder;
    }

    public static /* synthetic */ BlockBuilder item$default(BlockBuilder blockBuilder, InstanceConsumer instanceConsumer, int n, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: item");
        }
        if ((n & 1) != 0) {
            instanceConsumer = BlockBuilder::item$lambda$0;
        }
        return blockBuilder.item(instanceConsumer);
    }

    @NotNull
    public final BlockBuilder<T> loot(@NotNull Function3<? super LootTable.Builder, ? super ItemEntry<?>, ? super BlockEntry<?>, Unit> builder) {
        BlockBuilder blockBuilder;
        Intrinsics.checkNotNullParameter(builder, (String)"builder");
        BlockBuilder $this$loot_u24lambda_u240 = blockBuilder = this;
        boolean bl = false;
        Function3 function3 = $this$loot_u24lambda_u240.loot;
        if (function3 == null) {
            function3 = BlockBuilder::loot$lambda$0$0;
        }
        $this$loot_u24lambda_u240.loot = KFuncExt.INSTANCE.chain3(function3, builder);
        return blockBuilder;
    }

    @NotNull
    public final BlockBuilder<T> noLoot() {
        return this.loot(BlockBuilder::noLoot$lambda$0);
    }

    @NotNull
    public final BlockBuilder<T> simpleLoot() {
        return this.loot(BlockBuilder::simpleLoot$lambda$0);
    }

    @NotNull
    public final BlockBuilder<T> simpleLoot(@NotNull Function0<? extends ItemLike> item2) {
        Intrinsics.checkNotNullParameter(item2, (String)"item");
        return this.loot((arg_0, arg_1, arg_2) -> BlockBuilder.simpleLoot$lambda$1(item2, arg_0, arg_1, arg_2));
    }

    @NotNull
    public final BlockBuilder<T> doorLoot() {
        return this.loot(BlockBuilder::doorLoot$lambda$0);
    }

    @NotNull
    public final BlockBuilder<T> doorLoot(@NotNull Function0<? extends ItemLike> item2) {
        Intrinsics.checkNotNullParameter(item2, (String)"item");
        return this.loot((arg_0, arg_1, arg_2) -> BlockBuilder.doorLoot$lambda$1(item2, arg_0, arg_1, arg_2));
    }

    @NotNull
    public final BlockBuilder<T> slabLoot() {
        return this.loot(BlockBuilder::slabLoot$lambda$0);
    }

    @NotNull
    public final BlockBuilder<T> simpleItem() {
        return this.item(arg_0 -> BlockBuilder.simpleItem$lambda$0(this, arg_0));
    }

    @NotNull
    public final BlockBuilder<T> simpleItemNoTab() {
        return this.item(arg_0 -> BlockBuilder.simpleItemNoTab$lambda$0(this, arg_0));
    }

    @NotNull
    public final BlockBuilder<T> noLang() {
        BlockBuilder blockBuilder;
        BlockBuilder $this$noLang_u24lambda_u240 = blockBuilder = this;
        boolean bl = false;
        $this$noLang_u24lambda_u240.lang = null;
        return blockBuilder;
    }

    @Override
    protected void onRegistered(@NotNull BlockEntry<T> entry) {
        block1: {
            Object it;
            Intrinsics.checkNotNullParameter(entry, (String)"entry");
            Function0<? extends BlockColor> function0 = this.colorHandler;
            if (function0 != null) {
                it = function0;
                boolean bl = false;
                ClientBlockHandler.INSTANCE.getColorHandlers$brokencore_common().put(entry, (Function0<BlockColor>)it);
            }
            InstanceConsumer<BlockTagsBuilder<T>> instanceConsumer = this.tagBuilder;
            if (instanceConsumer == null) break block1;
            it = instanceConsumer;
            boolean bl = false;
            ((Map)this.getParent().getVanillaBlockTags$brokencore_common()).put(entry, it);
        }
    }

    @Override
    @NotNull
    protected T createObject() {
        return (T)((Block)this.ctor.invoke(this.props.invoke()));
    }

    @Override
    @NotNull
    public BlockEntry<T> createEntry(@NotNull ResourceKey<Block> key) {
        Intrinsics.checkNotNullParameter(key, (String)"key");
        BlockItemBuilder<T> blockItemBuilder = this.itemBuilder;
        return new BlockEntry(key, (ResourceKey<Item>)(blockItemBuilder != null ? blockItemBuilder.getKey() : null));
    }

    @Override
    @NotNull
    public BlockEntry<T> register() {
        Object e;
        block2: {
            Object object;
            e = super.register();
            BlockEntry block2 = (BlockEntry)e;
            boolean bl = false;
            String string = this.lang;
            if (string != null) {
                String it = string;
                boolean bl2 = false;
                this.getParent().getData().getLang().set("block." + this.getId().getNamespace() + "." + this.getId().getPath(), it);
            }
            if ((object = this.itemBuilder) == null || (object = ((BaseItemBuilder)object).register()) == null) break block2;
            Object item2 = object;
            boolean bl3 = false;
            Function3<? super LootTable.Builder, ? super ItemEntry<?>, ? super BlockEntry<?>, Unit> function3 = this.loot;
            if (function3 != null) {
                Function3<? super LootTable.Builder, ? super ItemEntry<?>, ? super BlockEntry<?>, Unit> it = function3;
                boolean bl4 = false;
                this.getParent().getData().getLootTables().register((Function1<? super PackOutput, Unit>)((Function1)arg_0 -> BlockBuilder.register$lambda$0$1$0$0(this, it, (ItemEntry)item2, block2, arg_0)));
            }
        }
        return (BlockEntry)e;
    }

    @JvmOverloads
    @NotNull
    public final BlockBuilder<T> props(@NotNull BlockBehaviour.Properties props) {
        Intrinsics.checkNotNullParameter((Object)props, (String)"props");
        return BlockBuilder.props$default(this, props, null, 2, null);
    }

    @JvmOverloads
    @NotNull
    public final BlockBuilder<T> props(@NotNull Function0<? extends BlockBehaviour.Properties> props) {
        Intrinsics.checkNotNullParameter(props, (String)"props");
        return BlockBuilder.props$default(this, props, null, 2, null);
    }

    @JvmOverloads
    @NotNull
    public final BlockBuilder<T> item() {
        return BlockBuilder.item$default(this, null, 1, null);
    }

    private static final BlockBehaviour.Properties props$lambda$0() {
        return BlockBehaviour.Properties.of();
    }

    private static final void props$lambda$1(BlockBehaviour.Properties $this$InstanceConsumer) {
        Intrinsics.checkNotNullParameter((Object)$this$InstanceConsumer, (String)"$this$InstanceConsumer");
    }

    private static final BlockBehaviour.Properties props$lambda$2(BlockBehaviour.Properties $props) {
        return $props;
    }

    private static final void props$lambda$3(BlockBehaviour.Properties $this$InstanceConsumer) {
        Intrinsics.checkNotNullParameter((Object)$this$InstanceConsumer, (String)"$this$InstanceConsumer");
    }

    private static final Unit model$lambda$0$0(BlockBuilder $this_apply, InstanceConsumer $builder, PackOutput it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        MiscExt.gluedApply(new BCBlockStateProvider(it, $this_apply.getParent(), $this_apply.getId()), $builder).registerStatesAndModels();
        return Unit.INSTANCE;
    }

    private static final void item$lambda$0(BlockItemBuilder $this$InstanceConsumer) {
        Intrinsics.checkNotNullParameter((Object)$this$InstanceConsumer, (String)"$this$InstanceConsumer");
    }

    private static final Unit loot$lambda$0$0(LootTable.Builder builder, ItemEntry itemEntry, BlockEntry blockEntry) {
        Intrinsics.checkNotNullParameter((Object)builder, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)itemEntry, (String)"<unused var>");
        Intrinsics.checkNotNullParameter((Object)blockEntry, (String)"<unused var>");
        return Unit.INSTANCE;
    }

    private static final Unit noLoot$lambda$0(LootTable.Builder $this$loot, ItemEntry itemEntry, BlockEntry blockEntry) {
        Intrinsics.checkNotNullParameter((Object)$this$loot, (String)"$this$loot");
        Intrinsics.checkNotNullParameter((Object)itemEntry, (String)"<unused var>");
        Intrinsics.checkNotNullParameter((Object)blockEntry, (String)"<unused var>");
        return Unit.INSTANCE;
    }

    private static final Unit simpleLoot$lambda$0(LootTable.Builder $this$loot, ItemEntry item2, BlockEntry blockEntry) {
        Intrinsics.checkNotNullParameter((Object)$this$loot, (String)"$this$loot");
        Intrinsics.checkNotNullParameter((Object)item2, (String)"item");
        Intrinsics.checkNotNullParameter((Object)blockEntry, (String)"<unused var>");
        LootBuildersKt.pool($this$loot, (Function1<? super LootPool.Builder, Unit>)((Function1)arg_0 -> BlockBuilder.simpleLoot$lambda$0$0(item2, arg_0)));
        return Unit.INSTANCE;
    }

    private static final Unit simpleLoot$lambda$0$0(ItemEntry $item, LootPool.Builder $this$pool) {
        Intrinsics.checkNotNullParameter((Object)$this$pool, (String)"$this$pool");
        LootBuildersKt.setRolls($this$pool, 1.0f);
        LootItemCondition.Builder builder = ExplosionCondition.survivesExplosion();
        Intrinsics.checkNotNullExpressionValue((Object)builder, (String)"survivesExplosion(...)");
        LootBuildersKt.condition$default($this$pool, builder, null, 2, null);
        LootPoolSingletonContainer.Builder builder2 = LootItem.lootTableItem((ItemLike)((ItemLike)$item.get()));
        Intrinsics.checkNotNullExpressionValue((Object)builder2, (String)"lootTableItem(...)");
        LootBuildersKt.entry$default($this$pool, (LootPoolEntryContainer.Builder)builder2, null, 2, null);
        return Unit.INSTANCE;
    }

    private static final Unit simpleLoot$lambda$1(Function0 $item, LootTable.Builder $this$loot, ItemEntry itemEntry, BlockEntry blockEntry) {
        Intrinsics.checkNotNullParameter((Object)$this$loot, (String)"$this$loot");
        Intrinsics.checkNotNullParameter((Object)itemEntry, (String)"<unused var>");
        Intrinsics.checkNotNullParameter((Object)blockEntry, (String)"<unused var>");
        LootBuildersKt.pool($this$loot, (Function1<? super LootPool.Builder, Unit>)((Function1)arg_0 -> BlockBuilder.simpleLoot$lambda$1$0($item, arg_0)));
        return Unit.INSTANCE;
    }

    private static final Unit simpleLoot$lambda$1$0(Function0 $item, LootPool.Builder $this$pool) {
        Intrinsics.checkNotNullParameter((Object)$this$pool, (String)"$this$pool");
        LootBuildersKt.setRolls($this$pool, 1.0f);
        LootItemCondition.Builder builder = ExplosionCondition.survivesExplosion();
        Intrinsics.checkNotNullExpressionValue((Object)builder, (String)"survivesExplosion(...)");
        LootBuildersKt.condition$default($this$pool, builder, null, 2, null);
        LootPoolSingletonContainer.Builder builder2 = LootItem.lootTableItem((ItemLike)((ItemLike)$item.invoke()));
        Intrinsics.checkNotNullExpressionValue((Object)builder2, (String)"lootTableItem(...)");
        LootBuildersKt.entry$default($this$pool, (LootPoolEntryContainer.Builder)builder2, null, 2, null);
        return Unit.INSTANCE;
    }

    private static final Unit doorLoot$lambda$0(LootTable.Builder $this$loot, ItemEntry item2, BlockEntry block2) {
        Intrinsics.checkNotNullParameter((Object)$this$loot, (String)"$this$loot");
        Intrinsics.checkNotNullParameter((Object)item2, (String)"item");
        Intrinsics.checkNotNullParameter((Object)block2, (String)"block");
        LootBuildersKt.pool($this$loot, (Function1<? super LootPool.Builder, Unit>)((Function1)arg_0 -> BlockBuilder.doorLoot$lambda$0$0(item2, block2, arg_0)));
        return Unit.INSTANCE;
    }

    private static final Unit doorLoot$lambda$0$0(ItemEntry $item, BlockEntry $block, LootPool.Builder $this$pool) {
        Intrinsics.checkNotNullParameter((Object)$this$pool, (String)"$this$pool");
        LootBuildersKt.setRolls($this$pool, 1.0f);
        LootItemCondition.Builder builder = ExplosionCondition.survivesExplosion();
        Intrinsics.checkNotNullExpressionValue((Object)builder, (String)"survivesExplosion(...)");
        LootBuildersKt.condition$default($this$pool, builder, null, 2, null);
        LootPoolEntryContainer.Builder builder2 = LootItem.lootTableItem((ItemLike)((ItemLike)$item.get())).when((LootItemCondition.Builder)LootItemBlockStatePropertyCondition.hasBlockStateProperties((Block)((Block)$block.get())).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty((Property)DoorBlock.HALF, (Comparable)DoubleBlockHalf.LOWER)));
        Intrinsics.checkNotNullExpressionValue((Object)builder2, (String)"when(...)");
        LootBuildersKt.entry$default($this$pool, builder2, null, 2, null);
        return Unit.INSTANCE;
    }

    private static final Unit doorLoot$lambda$1(Function0 $item, LootTable.Builder $this$loot, ItemEntry itemEntry, BlockEntry block2) {
        Intrinsics.checkNotNullParameter((Object)$this$loot, (String)"$this$loot");
        Intrinsics.checkNotNullParameter((Object)itemEntry, (String)"<unused var>");
        Intrinsics.checkNotNullParameter((Object)block2, (String)"block");
        LootBuildersKt.pool($this$loot, (Function1<? super LootPool.Builder, Unit>)((Function1)arg_0 -> BlockBuilder.doorLoot$lambda$1$0($item, block2, arg_0)));
        return Unit.INSTANCE;
    }

    private static final Unit doorLoot$lambda$1$0(Function0 $item, BlockEntry $block, LootPool.Builder $this$pool) {
        Intrinsics.checkNotNullParameter((Object)$this$pool, (String)"$this$pool");
        LootBuildersKt.setRolls($this$pool, 1.0f);
        LootItemCondition.Builder builder = ExplosionCondition.survivesExplosion();
        Intrinsics.checkNotNullExpressionValue((Object)builder, (String)"survivesExplosion(...)");
        LootBuildersKt.condition$default($this$pool, builder, null, 2, null);
        LootPoolEntryContainer.Builder builder2 = LootItem.lootTableItem((ItemLike)((ItemLike)$item.invoke())).when((LootItemCondition.Builder)LootItemBlockStatePropertyCondition.hasBlockStateProperties((Block)((Block)$block.get())).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty((Property)DoorBlock.HALF, (Comparable)DoubleBlockHalf.LOWER)));
        Intrinsics.checkNotNullExpressionValue((Object)builder2, (String)"when(...)");
        LootBuildersKt.entry$default($this$pool, builder2, null, 2, null);
        return Unit.INSTANCE;
    }

    private static final Unit slabLoot$lambda$0(LootTable.Builder $this$loot, ItemEntry item2, BlockEntry block2) {
        Intrinsics.checkNotNullParameter((Object)$this$loot, (String)"$this$loot");
        Intrinsics.checkNotNullParameter((Object)item2, (String)"item");
        Intrinsics.checkNotNullParameter((Object)block2, (String)"block");
        LootBuildersKt.pool($this$loot, (Function1<? super LootPool.Builder, Unit>)((Function1)arg_0 -> BlockBuilder.slabLoot$lambda$0$0(item2, block2, arg_0)));
        return Unit.INSTANCE;
    }

    private static final Unit slabLoot$lambda$0$0(ItemEntry $item, BlockEntry $block, LootPool.Builder $this$pool) {
        Intrinsics.checkNotNullParameter((Object)$this$pool, (String)"$this$pool");
        LootBuildersKt.setRolls($this$pool, 1.0f);
        LootPoolSingletonContainer.Builder builder = LootItem.lootTableItem((ItemLike)((ItemLike)$item.get())).apply((LootItemFunction.Builder)SetItemCountFunction.setCount((NumberProvider)((NumberProvider)ConstantValue.exactly((float)2.0f))).when((LootItemCondition.Builder)LootItemBlockStatePropertyCondition.hasBlockStateProperties((Block)((Block)$block.get())).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty((Property)SlabBlock.TYPE, (Comparable)SlabType.DOUBLE)))).apply((LootItemFunction.Builder)ApplyExplosionDecay.explosionDecay());
        Intrinsics.checkNotNullExpressionValue((Object)builder, (String)"apply(...)");
        LootBuildersKt.entry$default($this$pool, (LootPoolEntryContainer.Builder)builder, null, 2, null);
        return Unit.INSTANCE;
    }

    private static final void simpleItem$lambda$0(BlockBuilder this$0, BlockItemBuilder $this$item) {
        Intrinsics.checkNotNullParameter((Object)$this$item, (String)"$this$item");
        $this$item.lang = this$0.lang;
        $this$item.model(BlockBuilder::simpleItem$lambda$0$0);
    }

    private static final void simpleItem$lambda$0$0(BCBlockItemModelProvider $this$model) {
        Intrinsics.checkNotNullParameter((Object)$this$model, (String)"$this$model");
        $this$model.simple();
    }

    private static final void simpleItemNoTab$lambda$0(BlockBuilder this$0, BlockItemBuilder $this$item) {
        Intrinsics.checkNotNullParameter((Object)$this$item, (String)"$this$item");
        $this$item.lang = this$0.lang;
        $this$item.noTab();
        $this$item.model(BlockBuilder::simpleItemNoTab$lambda$0$0);
    }

    private static final void simpleItemNoTab$lambda$0$0(BCBlockItemModelProvider $this$model) {
        Intrinsics.checkNotNullParameter((Object)$this$model, (String)"$this$model");
        $this$model.simple();
    }

    private static final Unit register$lambda$0$1$0$0(BlockBuilder this$0, Function3 $it, ItemEntry $item, BlockEntry $block, PackOutput it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        LootTable.Builder base = LootTable.lootTable().setRandomSequence(this$0.getId());
        Intrinsics.checkNotNull((Object)base);
        $it.invoke((Object)base, (Object)$item, (Object)$block);
        Codec codec = LootTable.DIRECT_CODEC;
        Intrinsics.checkNotNullExpressionValue((Object)codec, (String)"DIRECT_CODEC");
        Encoder encoder = (Encoder)codec;
        RegistryOps registryOps = this$0.getParent().getRegistries().createSerializationContext((DynamicOps)JsonOps.INSTANCE);
        Intrinsics.checkNotNullExpressionValue((Object)registryOps, (String)"createSerializationContext(...)");
        JsonObject json = ((JsonElement)CodecExt.INSTANCE.encodeOrThrow(encoder, (DynamicOps)registryOps, base.build())).getAsJsonObject();
        json.addProperty("type", "minecraft:block");
        Pair item2 = TuplesKt.to((Object)("data/" + this$0.getId().getNamespace() + "/loot_table/blocks/" + this$0.getId().getPath() + ".json"), (Object)json);
        Pair[] pairArray = new Pair[]{item2};
        this$0.getParent().getData().getLootTables().plusAssign(pairArray);
        return Unit.INSTANCE;
    }
}

