/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.functions.Function3
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.renderer.blockentity.BlockEntityRenderer
 *  net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider
 *  net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider$Context
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.registries.BuiltInRegistries
 *  net.minecraft.core.registries.Registries
 *  net.minecraft.resources.ResourceKey
 *  net.minecraft.world.level.block.Block
 *  net.minecraft.world.level.block.entity.BlockEntity
 *  net.minecraft.world.level.block.entity.BlockEntityType
 *  net.minecraft.world.level.block.entity.BlockEntityType$BlockEntitySupplier
 *  net.minecraft.world.level.block.entity.BlockEntityType$Builder
 *  net.minecraft.world.level.block.state.BlockState
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.brokencore.api.registry.builders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Supplier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.thebrokenscript.brokencore.api.platform.PlatformUtil;
import net.thebrokenscript.brokencore.api.registry.BrokenReg;
import net.thebrokenscript.brokencore.api.registry.builders.AbstractBuilder;
import net.thebrokenscript.brokencore.api.registry.dsl.RegistryDslMarker;
import net.thebrokenscript.brokencore.api.registry.handlers.ClientBlockEntityHandler;
import net.thebrokenscript.brokencore.api.registry.objects.BlockEntityEntry;
import net.thebrokenscript.brokencore.api.util.Side;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@RegistryDslMarker
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0017\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u000220\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u0000\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u00050\u0003B=\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012$\u0010\n\u001a \u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00028\u00000\u000b\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u000e\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0014J \u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\u0010\u0010$\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040%H\u0016J\u0016\u0010&\u001a\u00020\u00122\f\u0010'\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0014R,\u0010\n\u001a \u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00028\u00000\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R \u0010\u0010\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001f\u0010\u0013\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00160\u00150\u0014\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018RX\u0010\u001d\u001a\u001c\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u001b\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u001c0\u0011\u0018\u00010\u001a2 \u0010\u0019\u001a\u001c\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u001b\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u001c0\u0011\u0018\u00010\u001a8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!\u00a8\u0006("}, d2={"Lnet/thebrokenscript/brokencore/api/registry/builders/BlockEntityBuilder;", "T", "Lnet/minecraft/world/level/block/entity/BlockEntity;", "Lnet/thebrokenscript/brokencore/api/registry/builders/AbstractBuilder;", "Lnet/minecraft/world/level/block/entity/BlockEntityType;", "Lnet/thebrokenscript/brokencore/api/registry/objects/BlockEntityEntry;", "parent", "Lnet/thebrokenscript/brokencore/api/registry/BrokenReg;", "name", "", "ctor", "Lkotlin/Function3;", "Lnet/minecraft/core/BlockPos;", "Lnet/minecraft/world/level/block/state/BlockState;", "<init>", "(Lnet/thebrokenscript/brokencore/api/registry/BrokenReg;Ljava/lang/String;Lkotlin/jvm/functions/Function3;)V", "clientRegisterCallback", "Lkotlin/Function1;", "", "validBlocks", "", "Ljava/util/function/Supplier;", "Lnet/minecraft/world/level/block/Block;", "getValidBlocks", "()Ljava/util/List;", "value", "Lkotlin/Function0;", "Lnet/minecraft/client/renderer/blockentity/BlockEntityRendererProvider$Context;", "Lnet/minecraft/client/renderer/blockentity/BlockEntityRenderer;", "renderer", "getRenderer", "()Lkotlin/jvm/functions/Function0;", "setRenderer", "(Lkotlin/jvm/functions/Function0;)V", "createObject", "createEntry", "key", "Lnet/minecraft/resources/ResourceKey;", "onRegistered", "entry", "brokencore-common"})
@SourceDebugExtension(value={"SMAP\nBlockEntityBuilder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BlockEntityBuilder.kt\nnet/thebrokenscript/brokencore/api/registry/builders/BlockEntityBuilder\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,76:1\n1563#2:77\n1634#2,3:78\n37#3,2:81\n*S KotlinDebug\n*F\n+ 1 BlockEntityBuilder.kt\nnet/thebrokenscript/brokencore/api/registry/builders/BlockEntityBuilder\n*L\n67#1:77\n67#1:78,3\n67#1:81,2\n*E\n"})
public class BlockEntityBuilder<T extends BlockEntity>
extends AbstractBuilder<BlockEntityBuilder<T>, BlockEntityType<?>, BlockEntityType<T>, BlockEntityEntry<T>> {
    @NotNull
    private final Function3<BlockEntityType<T>, BlockPos, BlockState, T> ctor;
    @NotNull
    private Function1<? super BlockEntityEntry<T>, Unit> clientRegisterCallback;
    @NotNull
    private final List<Supplier<? extends Block>> validBlocks;

    public BlockEntityBuilder(@NotNull BrokenReg parent, @NotNull String name, @NotNull Function3<? super BlockEntityType<T>, ? super BlockPos, ? super BlockState, ? extends T> ctor) {
        Intrinsics.checkNotNullParameter((Object)parent, (String)"parent");
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter(ctor, (String)"ctor");
        ResourceKey resourceKey = Registries.BLOCK_ENTITY_TYPE;
        Intrinsics.checkNotNullExpressionValue((Object)resourceKey, (String)"BLOCK_ENTITY_TYPE");
        super(parent, resourceKey, name);
        this.ctor = ctor;
        this.clientRegisterCallback = BlockEntityBuilder::clientRegisterCallback$lambda$0;
        this.validBlocks = new ArrayList();
    }

    @NotNull
    public final List<Supplier<? extends Block>> getValidBlocks() {
        return this.validBlocks;
    }

    @Nullable
    public final Function0<Function1<BlockEntityRendererProvider.Context, BlockEntityRenderer<T>>> getRenderer() {
        return null;
    }

    public final void setRenderer(@Nullable Function0<? extends Function1<? super BlockEntityRendererProvider.Context, ? extends BlockEntityRenderer<T>>> value) {
        PlatformUtil.Companion.runWhenOn(Side.CLIENT, (Function0<? extends Function0<Unit>>)((Function0)() -> BlockEntityBuilder._set_renderer_$lambda$0(this, value)));
    }

    /*
     * WARNING - void declaration
     */
    @Override
    @NotNull
    protected BlockEntityType<T> createObject() {
        void $this$mapTo$iv$iv;
        void $this$map$iv;
        Iterable iterable = this.validBlocks;
        BlockEntityType.BlockEntitySupplier blockEntitySupplier = (arg_0, arg_1) -> BlockEntityBuilder.createObject$lambda$0(this, arg_0, arg_1);
        boolean $i$f$map = false;
        void var4_4 = $this$map$iv;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map$iv, (int)10));
        boolean $i$f$mapTo = false;
        for (Object item$iv$iv : $this$mapTo$iv$iv) {
            void it;
            Supplier supplier = (Supplier)item$iv$iv;
            Collection collection = destination$iv$iv;
            boolean bl = false;
            Object t = it.get();
            Intrinsics.checkNotNullExpressionValue(t, (String)"get(...)");
            collection.add((Block)t);
        }
        Collection $this$toTypedArray$iv = (List)destination$iv$iv;
        boolean $i$f$toTypedArray = false;
        Collection thisCollection$iv = $this$toTypedArray$iv;
        Block[] blockArray = thisCollection$iv.toArray(new Block[0]);
        BlockEntityType blockEntityType = BlockEntityType.Builder.of((BlockEntityType.BlockEntitySupplier)blockEntitySupplier, (Block[])Arrays.copyOf(blockArray, blockArray.length)).build(null);
        Intrinsics.checkNotNullExpressionValue((Object)blockEntityType, (String)"build(...)");
        return blockEntityType;
    }

    @Override
    @NotNull
    public BlockEntityEntry<T> createEntry(@NotNull ResourceKey<BlockEntityType<?>> key) {
        Intrinsics.checkNotNullParameter(key, (String)"key");
        return new BlockEntityEntry(key);
    }

    @Override
    protected void onRegistered(@NotNull BlockEntityEntry<T> entry) {
        Intrinsics.checkNotNullParameter(entry, (String)"entry");
        PlatformUtil.Companion.runWhenOn(Side.CLIENT, (Function0<? extends Function0<Unit>>)((Function0)() -> BlockEntityBuilder.onRegistered$lambda$0(this, entry)));
    }

    private static final Unit clientRegisterCallback$lambda$0(BlockEntityEntry it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        return Unit.INSTANCE;
    }

    private static final Function0 _set_renderer_$lambda$0(BlockEntityBuilder this$0, Function0 $value) {
        return () -> BlockEntityBuilder._set_renderer_$lambda$0$0(this$0, $value);
    }

    private static final Unit _set_renderer_$lambda$0$0(BlockEntityBuilder this$0, Function0 $value) {
        Function0 function0 = $value;
        this$0.clientRegisterCallback = function0 != null ? arg_0 -> BlockEntityBuilder._set_renderer_$lambda$0$0$0(function0, arg_0) : BlockEntityBuilder::_set_renderer_$lambda$0$0$1;
        return Unit.INSTANCE;
    }

    private static final Unit _set_renderer_$lambda$0$0$0(Function0 $value, BlockEntityEntry it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        ClientBlockEntityHandler.INSTANCE.getRenderers$brokencore_common().add(new ClientBlockEntityHandler.BlockEntityRendererInfo(it, () -> BlockEntityBuilder._set_renderer_$lambda$0$0$0$0($value)));
        return Unit.INSTANCE;
    }

    private static final BlockEntityRendererProvider _set_renderer_$lambda$0$0$0$0(Function0 $value) {
        return arg_0 -> BlockEntityBuilder._set_renderer_$lambda$0$0$0$0$0($value, arg_0);
    }

    private static final BlockEntityRenderer _set_renderer_$lambda$0$0$0$0$0(Function0 $value, BlockEntityRendererProvider.Context cx) {
        Function1 function1 = (Function1)$value.invoke();
        Intrinsics.checkNotNull((Object)cx);
        return (BlockEntityRenderer)function1.invoke((Object)cx);
    }

    private static final Unit _set_renderer_$lambda$0$0$1(BlockEntityEntry it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        return Unit.INSTANCE;
    }

    private static final BlockEntity createObject$lambda$0(BlockEntityBuilder this$0, BlockPos pos, BlockState state) {
        Function3 function3 = this$0.ctor;
        Object object = BuiltInRegistries.BLOCK_ENTITY_TYPE.get(this$0.getId());
        Intrinsics.checkNotNull((Object)object, (String)"null cannot be cast to non-null type net.minecraft.world.level.block.entity.BlockEntityType<T of net.thebrokenscript.brokencore.api.registry.builders.BlockEntityBuilder>");
        BlockEntityType blockEntityType = (BlockEntityType)object;
        Intrinsics.checkNotNull((Object)pos);
        Intrinsics.checkNotNull((Object)state);
        return (BlockEntity)function3.invoke((Object)blockEntityType, (Object)pos, (Object)state);
    }

    private static final Function0 onRegistered$lambda$0(BlockEntityBuilder this$0, BlockEntityEntry $entry) {
        return () -> BlockEntityBuilder.onRegistered$lambda$0$0(this$0, $entry);
    }

    private static final Unit onRegistered$lambda$0$0(BlockEntityBuilder this$0, BlockEntityEntry $entry) {
        this$0.clientRegisterCallback.invoke((Object)$entry);
        return Unit.INSTANCE;
    }
}

