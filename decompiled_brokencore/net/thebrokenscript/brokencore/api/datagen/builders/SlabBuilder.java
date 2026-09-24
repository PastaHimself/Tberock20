/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.JsonElement
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.data.models.blockstates.MultiVariantGenerator
 *  net.minecraft.data.models.blockstates.PropertyDispatch
 *  net.minecraft.data.models.blockstates.PropertyDispatch$C1
 *  net.minecraft.data.models.blockstates.Variant
 *  net.minecraft.data.models.blockstates.VariantProperties
 *  net.minecraft.data.models.model.ModelLocationUtils
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.world.level.block.Block
 *  net.minecraft.world.level.block.state.properties.BlockStateProperties
 *  net.minecraft.world.level.block.state.properties.Property
 *  net.minecraft.world.level.block.state.properties.SlabType
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.brokencore.api.datagen.builders;

import com.google.gson.JsonElement;
import compat.net.neoforged.neoforge.client.model.generators.BlockModelBuilder;
import compat.net.neoforged.neoforge.common.data.ExistingFileHelper;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.data.models.blockstates.PropertyDispatch;
import net.minecraft.data.models.blockstates.Variant;
import net.minecraft.data.models.blockstates.VariantProperties;
import net.minecraft.data.models.model.ModelLocationUtils;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.SlabType;
import net.thebrokenscript.brokencore.api.datagen.builders.BlockGen;
import net.thebrokenscript.brokencore.api.datagen.builders.BlockModelBuilderBase;
import net.thebrokenscript.brokencore.api.util.system.PathUtilKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0016J\u0014\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001a0\u0018H\u0016R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\rR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000b\"\u0004\b\u0013\u0010\r\u00a8\u0006\u001c"}, d2={"Lnet/thebrokenscript/brokencore/api/datagen/builders/SlabBuilder;", "Lnet/thebrokenscript/brokencore/api/datagen/builders/BlockModelBuilderBase;", "block", "Lnet/minecraft/world/level/block/Block;", "files", "Lcompat/net/neoforged/neoforge/common/data/ExistingFileHelper;", "<init>", "(Lnet/minecraft/world/level/block/Block;Lcompat/net/neoforged/neoforge/common/data/ExistingFileHelper;)V", "top", "Lcompat/net/neoforged/neoforge/client/model/generators/BlockModelBuilder;", "getTop", "()Lcompat/net/neoforged/neoforge/client/model/generators/BlockModelBuilder;", "setTop", "(Lcompat/net/neoforged/neoforge/client/model/generators/BlockModelBuilder;)V", "bottom", "getBottom", "setBottom", "double", "getDouble", "setDouble", "simple", "tex", "Lnet/minecraft/resources/ResourceLocation;", "build", "", "", "Lcom/google/gson/JsonElement;", "Companion", "brokencore-common"})
@SourceDebugExtension(value={"SMAP\nSlabBuilder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SlabBuilder.kt\nnet/thebrokenscript/brokencore/api/datagen/builders/SlabBuilder\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,72:1\n1#2:73\n*E\n"})
public final class SlabBuilder
extends BlockModelBuilderBase {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @Nullable
    private BlockModelBuilder top;
    @Nullable
    private BlockModelBuilder bottom;
    @Nullable
    private BlockModelBuilder double;

    public SlabBuilder(@NotNull Block block2, @NotNull ExistingFileHelper files) {
        Intrinsics.checkNotNullParameter((Object)block2, (String)"block");
        Intrinsics.checkNotNullParameter((Object)files, (String)"files");
        super(block2, files);
    }

    @Nullable
    public final BlockModelBuilder getTop() {
        return this.top;
    }

    public final void setTop(@Nullable BlockModelBuilder blockModelBuilder) {
        this.top = blockModelBuilder;
    }

    @Nullable
    public final BlockModelBuilder getBottom() {
        return this.bottom;
    }

    public final void setBottom(@Nullable BlockModelBuilder blockModelBuilder) {
        this.bottom = blockModelBuilder;
    }

    @Nullable
    public final BlockModelBuilder getDouble() {
        return this.double;
    }

    public final void setDouble(@Nullable BlockModelBuilder blockModelBuilder) {
        this.double = blockModelBuilder;
    }

    @NotNull
    public final SlabBuilder simple(@NotNull ResourceLocation tex) {
        SlabBuilder slabBuilder;
        Intrinsics.checkNotNullParameter((Object)tex, (String)"tex");
        SlabBuilder $this$simple_u24lambda_u240 = slabBuilder = this;
        boolean bl = false;
        $this$simple_u24lambda_u240.bottom = (BlockModelBuilder)((BlockModelBuilder)((BlockModelBuilder)((BlockModelBuilder)$this$simple_u24lambda_u240.block().parent($this$simple_u24lambda_u240.existingModel("block/slab"))).texture("bottom", tex)).texture("side", tex)).texture("top", tex);
        $this$simple_u24lambda_u240.top = (BlockModelBuilder)((BlockModelBuilder)((BlockModelBuilder)((BlockModelBuilder)$this$simple_u24lambda_u240.block().parent($this$simple_u24lambda_u240.existingModel("block/slab_top"))).texture("bottom", tex)).texture("side", tex)).texture("top", tex);
        $this$simple_u24lambda_u240.double = (BlockModelBuilder)((BlockModelBuilder)$this$simple_u24lambda_u240.block().parent($this$simple_u24lambda_u240.existingModel("block/cube_all"))).texture("all", tex);
        return slabBuilder;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    @NotNull
    public Map<String, JsonElement> build() {
        void $this$build_u24lambda_u240_u243_u240;
        PropertyDispatch.C1 c1;
        MultiVariantGenerator multiVariantGenerator;
        BlockModelBuilder it;
        Map map;
        Map $this$build_u24lambda_u240 = map = (Map)new LinkedHashMap();
        boolean bl = false;
        ResourceLocation topLoc = this.top != null ? ModelLocationUtils.getModelLocation((Block)this.getBlock(), (String)"_top") : null;
        ResourceLocation bottomLoc = this.bottom != null ? ModelLocationUtils.getModelLocation((Block)this.getBlock(), (String)"_bottom") : null;
        ResourceLocation doubleLoc = this.double != null ? ModelLocationUtils.getModelLocation((Block)this.getBlock(), (String)"_double") : null;
        ResourceLocation resourceLocation = topLoc;
        String topPath = resourceLocation != null ? PathUtilKt.modelPath(resourceLocation) : null;
        ResourceLocation resourceLocation2 = bottomLoc;
        String bottomPath = resourceLocation2 != null ? PathUtilKt.modelPath(resourceLocation2) : null;
        ResourceLocation resourceLocation3 = doubleLoc;
        String doublePath = resourceLocation3 != null ? PathUtilKt.modelPath(resourceLocation3) : null;
        ResourceLocation resourceLocation4 = bottomLoc;
        if (resourceLocation4 == null && (resourceLocation4 = topLoc) == null && (resourceLocation4 = doubleLoc) == null) {
            throw new IllegalStateException("Block has no models to generate!");
        }
        ResourceLocation fallback = resourceLocation4;
        BlockModelBuilder blockModelBuilder = this.top;
        if (blockModelBuilder != null) {
            it = blockModelBuilder;
            boolean bl2 = false;
            String string = topPath;
            Intrinsics.checkNotNull((Object)string);
            $this$build_u24lambda_u240.put(string, it.toJson());
        }
        BlockModelBuilder blockModelBuilder2 = this.bottom;
        if (blockModelBuilder2 != null) {
            it = blockModelBuilder2;
            boolean bl3 = false;
            String string = bottomPath;
            Intrinsics.checkNotNull((Object)string);
            $this$build_u24lambda_u240.put(string, it.toJson());
        }
        BlockModelBuilder blockModelBuilder3 = this.double;
        if (blockModelBuilder3 != null) {
            it = blockModelBuilder3;
            boolean bl4 = false;
            String string = doublePath;
            Intrinsics.checkNotNull((Object)string);
            $this$build_u24lambda_u240.put(string, it.toJson());
        }
        MultiVariantGenerator $this$build_u24lambda_u240_u243 = multiVariantGenerator = MultiVariantGenerator.multiVariant((Block)this.getBlock());
        boolean bl5 = false;
        PropertyDispatch.C1 c12 = c1 = PropertyDispatch.property((Property)((Property)BlockStateProperties.SLAB_TYPE));
        MultiVariantGenerator multiVariantGenerator2 = $this$build_u24lambda_u240_u243;
        boolean bl6 = false;
        Comparable comparable = (Comparable)SlabType.TOP;
        Variant variant = Variant.variant();
        ResourceLocation resourceLocation5 = topLoc;
        if (resourceLocation5 == null) {
            resourceLocation5 = fallback;
        }
        $this$build_u24lambda_u240_u243_u240.select(comparable, variant.with(VariantProperties.MODEL, (Object)resourceLocation5));
        Comparable comparable2 = (Comparable)SlabType.BOTTOM;
        Variant variant2 = Variant.variant();
        ResourceLocation resourceLocation6 = bottomLoc;
        if (resourceLocation6 == null) {
            resourceLocation6 = fallback;
        }
        $this$build_u24lambda_u240_u243_u240.select(comparable2, variant2.with(VariantProperties.MODEL, (Object)resourceLocation6));
        Comparable comparable3 = (Comparable)SlabType.DOUBLE;
        Variant variant3 = Variant.variant();
        ResourceLocation resourceLocation7 = doubleLoc;
        if (resourceLocation7 == null) {
            resourceLocation7 = fallback;
        }
        $this$build_u24lambda_u240_u243_u240.select(comparable3, variant3.with(VariantProperties.MODEL, (Object)resourceLocation7));
        multiVariantGenerator2.with((PropertyDispatch)c1);
        MultiVariantGenerator state = multiVariantGenerator;
        $this$build_u24lambda_u240.put(PathUtilKt.assetPath(BlockGen.INSTANCE.blockId(this.getBlock()), "blockstates", ".json"), state.get());
        return map;
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J;\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0017\u0010\f\u001a\u0013\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r\u00a2\u0006\u0002\b\u0010\u00a8\u0006\u0011"}, d2={"Lnet/thebrokenscript/brokencore/api/datagen/builders/SlabBuilder$Companion;", "", "<init>", "()V", "create", "", "", "Lcom/google/gson/JsonElement;", "block", "Lnet/minecraft/world/level/block/Block;", "files", "Lcompat/net/neoforged/neoforge/common/data/ExistingFileHelper;", "config", "Lkotlin/Function1;", "Lnet/thebrokenscript/brokencore/api/datagen/builders/SlabBuilder;", "", "Lkotlin/ExtensionFunctionType;", "brokencore-common"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final Map<String, JsonElement> create(@NotNull Block block2, @NotNull ExistingFileHelper files, @NotNull Function1<? super SlabBuilder, Unit> config) {
            Intrinsics.checkNotNullParameter((Object)block2, (String)"block");
            Intrinsics.checkNotNullParameter((Object)files, (String)"files");
            Intrinsics.checkNotNullParameter(config, (String)"config");
            SlabBuilder slabBuilder = new SlabBuilder(block2, files);
            config.invoke((Object)slabBuilder);
            return slabBuilder.build();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

